package org.xbill.DNS;

import j$.lang.Iterable;
import j$.time.Duration;
import j$.util.function.Consumer;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import okio.NioSystemFileSystem$$ExternalSyntheticApiModelOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.NioClient;
import org.xbill.DNS.NioUdpClient;

/* JADX INFO: loaded from: classes2.dex */
final class NioUdpClient extends NioClient {
    private static final int EPHEMERAL_RANGE;
    private static final int EPHEMERAL_START;
    private static final SecureRandom prng;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) NioUdpClient.class);
    private static final Queue<Transaction> registrationQueue = new ConcurrentLinkedQueue();
    private static final Queue<Transaction> pendingTransactions = new ConcurrentLinkedQueue();

    static {
        int i;
        int i2;
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            i = 32768;
            i2 = 60999;
        } else {
            i = 49152;
            i2 = 65535;
        }
        int iIntValue = Integer.getInteger("dnsjava.udp.ephemeral.start", i).intValue();
        EPHEMERAL_START = iIntValue;
        EPHEMERAL_RANGE = Integer.getInteger("dnsjava.udp.ephemeral.end", i2).intValue() - iIntValue;
        if (Boolean.getBoolean("dnsjava.udp.ephemeral.use_ephemeral_port")) {
            prng = null;
        } else {
            prng = new SecureRandom();
        }
        addSelectorTimeoutTask(new Runnable() { // from class: org.xbill.DNS.NioUdpClient$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                NioUdpClient.processPendingRegistrations();
            }
        });
        addSelectorTimeoutTask(new Runnable() { // from class: org.xbill.DNS.NioUdpClient$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                NioUdpClient.checkTransactionTimeouts();
            }
        });
        addCloseTask(new Runnable() { // from class: org.xbill.DNS.NioUdpClient$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                NioUdpClient.closeUdp();
            }
        });
    }

    private NioUdpClient() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processPendingRegistrations() {
        while (true) {
            Queue<Transaction> queue = registrationQueue;
            if (queue.isEmpty()) {
                return;
            }
            Transaction transactionRemove = queue.remove();
            try {
                transactionRemove.channel.register(selector(), 1, transactionRemove);
                transactionRemove.send();
            } catch (IOException e) {
                transactionRemove.f.completeExceptionally(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkTransactionTimeouts() {
        Iterator<Transaction> it = pendingTransactions.iterator();
        while (it.hasNext()) {
            Transaction next = it.next();
            if (next.endTime - System.nanoTime() < 0) {
                next.silentCloseChannel();
                next.f.completeExceptionally(new SocketTimeoutException("Query timed out"));
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Transaction implements NioClient.KeyProcessor {
        private final DatagramChannel channel;
        private final byte[] data;
        private final long endTime;
        private final CompletableFuture<byte[]> f;
        private final int max;

        public Transaction(byte[] bArr, int i, long j, DatagramChannel datagramChannel, CompletableFuture<byte[]> completableFuture) {
            this.data = bArr;
            this.max = i;
            this.endTime = j;
            this.channel = datagramChannel;
            this.f = completableFuture;
        }

        void send() throws IOException {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.data);
            NioClient.verboseLog("UDP write", this.channel.socket().getLocalSocketAddress(), this.channel.socket().getRemoteSocketAddress(), this.data);
            DatagramChannel datagramChannel = this.channel;
            if (datagramChannel.send(byteBufferWrap, datagramChannel.socket().getRemoteSocketAddress()) <= 0) {
                throw new EOFException();
            }
        }

        @Override // org.xbill.DNS.NioClient.KeyProcessor
        public void processReadyKey(SelectionKey selectionKey) {
            if (!selectionKey.isReadable()) {
                silentCloseChannel();
                this.f.completeExceptionally(new EOFException("channel not readable"));
                NioUdpClient.pendingTransactions.remove(this);
                return;
            }
            DatagramChannel datagramChannel = (DatagramChannel) selectionKey.channel();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.max);
            try {
                int i = datagramChannel.read(byteBufferAllocate);
                if (i <= 0) {
                    throw new EOFException();
                }
                byteBufferAllocate.flip();
                byte[] bArr = new byte[i];
                System.arraycopy(byteBufferAllocate.array(), 0, bArr, 0, i);
                NioClient.verboseLog("UDP read", datagramChannel.socket().getLocalSocketAddress(), datagramChannel.socket().getRemoteSocketAddress(), bArr);
                silentCloseChannel();
                this.f.complete(bArr);
                NioUdpClient.pendingTransactions.remove(this);
            } catch (IOException e) {
                silentCloseChannel();
                this.f.completeExceptionally(e);
                NioUdpClient.pendingTransactions.remove(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void silentCloseChannel() {
            try {
                this.channel.disconnect();
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    this.channel.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                this.channel.close();
            } catch (IOException unused3) {
            }
        }
    }

    static CompletableFuture<byte[]> sendrecv(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, byte[] bArr, int i, Duration duration) {
        InetSocketAddress inetSocketAddress3;
        SecureRandom secureRandom;
        CompletableFuture<byte[]> completableFutureM2226m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2226m();
        try {
            Selector selector = selector();
            DatagramChannel datagramChannelOpen = DatagramChannel.open();
            boolean z = false;
            datagramChannelOpen.configureBlocking(false);
            if (inetSocketAddress == null || inetSocketAddress.getPort() == 0) {
                for (int i2 = 0; i2 < 1024; i2++) {
                    try {
                        if (inetSocketAddress == null) {
                            SecureRandom secureRandom2 = prng;
                            inetSocketAddress3 = secureRandom2 != null ? new InetSocketAddress(secureRandom2.nextInt(EPHEMERAL_RANGE) + EPHEMERAL_START) : null;
                        } else {
                            int port = inetSocketAddress.getPort();
                            if (port == 0 && (secureRandom = prng) != null) {
                                port = secureRandom.nextInt(EPHEMERAL_RANGE) + EPHEMERAL_START;
                            }
                            inetSocketAddress3 = new InetSocketAddress(inetSocketAddress.getAddress(), port);
                        }
                        datagramChannelOpen.bind((SocketAddress) inetSocketAddress3);
                        z = true;
                        break;
                    } catch (SocketException unused) {
                    }
                }
                if (!z) {
                    datagramChannelOpen.close();
                    completableFutureM2226m.completeExceptionally(new IOException("No available source port found"));
                    return completableFutureM2226m;
                }
            }
            datagramChannelOpen.connect(inetSocketAddress2);
            Transaction transaction = new Transaction(bArr, i, System.nanoTime() + duration.toNanos(), datagramChannelOpen, completableFutureM2226m);
            pendingTransactions.add(transaction);
            registrationQueue.add(transaction);
            selector.wakeup();
        } catch (IOException e) {
            completableFutureM2226m.completeExceptionally(e);
        }
        return completableFutureM2226m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeUdp() {
        registrationQueue.clear();
        final EOFException eOFException = new EOFException("Client is closing");
        Queue<Transaction> queue = pendingTransactions;
        Iterable.EL.forEach(queue, new Consumer() { // from class: org.xbill.DNS.NioUdpClient$$ExternalSyntheticLambda1
            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                ((NioUdpClient.Transaction) obj).f.completeExceptionally(eOFException);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }
        });
        queue.clear();
    }
}
