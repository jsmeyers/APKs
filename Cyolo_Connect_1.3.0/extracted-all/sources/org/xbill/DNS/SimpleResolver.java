package org.xbill.DNS;

import j$.time.Duration;
import j$.util.function.Function;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import okio.NioSystemFileSystem$$ExternalSyntheticApiModelOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.Resolver;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleResolver implements Resolver {
    public static final int DEFAULT_EDNS_PAYLOADSIZE = 1280;
    public static final int DEFAULT_PORT = 53;
    private static final short DEFAULT_UDPSIZE = 512;
    private InetSocketAddress address;
    private boolean ignoreTruncation;
    private InetSocketAddress localAddress;
    private OPTRecord queryOPT;
    private Duration timeoutValue;
    private TSIG tsig;
    private boolean useTCP;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) SimpleResolver.class);
    private static InetSocketAddress defaultResolver = new InetSocketAddress(InetAddress.getLoopbackAddress(), 53);

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ Message send(Message message) {
        return Resolver.CC.$default$send(this, message);
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ Object sendAsync(Message message, ResolverListener resolverListener) {
        return Resolver.CC.$default$sendAsync(this, message, resolverListener);
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setEDNS(int i) {
        setEDNS(i, 0, 0, Collections.emptyList());
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setEDNS(int i, int i2, int i3, EDNSOption... eDNSOptionArr) {
        setEDNS(i, i2, i3, eDNSOptionArr == null ? Collections.emptyList() : Arrays.asList(eDNSOptionArr));
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setTimeout(int i) {
        setTimeout(Duration.ofSeconds(i));
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setTimeout(int i, int i2) {
        setTimeout(Duration.ofMillis((((long) i) * 1000) + ((long) i2)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleResolver() throws UnknownHostException {
        this((String) null);
    }

    public SimpleResolver(String str) throws UnknownHostException {
        InetAddress byName;
        this.queryOPT = new OPTRecord(1280, 0, 0, 0);
        this.timeoutValue = Duration.ofSeconds(10L);
        if (str == null) {
            InetSocketAddress inetSocketAddressServer = ResolverConfig.getCurrentConfig().server();
            this.address = inetSocketAddressServer;
            if (inetSocketAddressServer == null) {
                this.address = defaultResolver;
                return;
            }
            return;
        }
        if ("0".equals(str)) {
            byName = InetAddress.getLoopbackAddress();
        } else {
            byName = InetAddress.getByName(str);
        }
        this.address = new InetSocketAddress(byName, 53);
    }

    public SimpleResolver(InetSocketAddress inetSocketAddress) {
        this.queryOPT = new OPTRecord(1280, 0, 0, 0);
        this.timeoutValue = Duration.ofSeconds(10L);
        this.address = (InetSocketAddress) Objects.requireNonNull(inetSocketAddress, "host must not be null");
    }

    public SimpleResolver(InetAddress inetAddress) {
        this.queryOPT = new OPTRecord(1280, 0, 0, 0);
        this.timeoutValue = Duration.ofSeconds(10L);
        Objects.requireNonNull(inetAddress, "host must not be null");
        this.address = new InetSocketAddress(inetAddress, 53);
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    public static void setDefaultResolver(InetSocketAddress inetSocketAddress) {
        defaultResolver = inetSocketAddress;
    }

    public static void setDefaultResolver(String str) {
        defaultResolver = new InetSocketAddress(str, 53);
    }

    public int getPort() {
        return this.address.getPort();
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i) {
        this.address = new InetSocketAddress(this.address.getAddress(), i);
    }

    public void setAddress(InetSocketAddress inetSocketAddress) {
        this.address = inetSocketAddress;
    }

    public void setAddress(InetAddress inetAddress) {
        this.address = new InetSocketAddress(inetAddress, this.address.getPort());
    }

    public void setLocalAddress(InetSocketAddress inetSocketAddress) {
        this.localAddress = inetSocketAddress;
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.localAddress = new InetSocketAddress(inetAddress, 0);
    }

    public boolean getTCP() {
        return this.useTCP;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
        this.useTCP = z;
    }

    public boolean getIgnoreTruncation() {
        return this.ignoreTruncation;
    }

    @Override // org.xbill.DNS.Resolver
    public void setIgnoreTruncation(boolean z) {
        this.ignoreTruncation = z;
    }

    public OPTRecord getEDNS() {
        return this.queryOPT;
    }

    public void setEDNS(OPTRecord oPTRecord) {
        this.queryOPT = oPTRecord;
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i, int i2, int i3, List<EDNSOption> list) {
        if (i == -1) {
            this.queryOPT = null;
        } else {
            if (i == 0) {
                this.queryOPT = new OPTRecord(i2 == 0 ? 1280 : i2, 0, i, i3, list);
                return;
            }
            throw new IllegalArgumentException("invalid EDNS version - must be 0 or -1 to disable");
        }
    }

    public TSIG getTSIGKey() {
        return this.tsig;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        this.tsig = tsig;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.timeoutValue = duration;
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.timeoutValue;
    }

    private Message parseMessage(byte[] bArr) throws WireParseException {
        try {
            return new Message(bArr);
        } catch (IOException e) {
            if (!(e instanceof WireParseException)) {
                throw new WireParseException("Error parsing message", e);
            }
            throw ((WireParseException) e);
        }
    }

    private void verifyTSIG(Message message, Message message2, byte[] bArr, TSIG tsig) {
        if (tsig == null) {
            return;
        }
        log.debug("TSIG verify: {}", Rcode.TSIGstring(tsig.verify(message2, bArr, message.getTSIG())));
    }

    private void applyEDNS(Message message) {
        if (this.queryOPT == null || message.getOPT() != null) {
            return;
        }
        message.addRecord(this.queryOPT, 3);
    }

    private int maxUDPSize(Message message) {
        OPTRecord opt = message.getOPT();
        if (opt == null) {
            return 512;
        }
        return opt.getPayloadSize();
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, ForkJoinPool.commonPool());
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(final Message message, Executor executor) {
        Record question;
        if (message.getHeader().getOpcode() == 0 && (question = message.getQuestion()) != null && question.getType() == 252) {
            final CompletableFuture completableFutureM2226m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2226m();
            CompletableFuture.runAsync(new Runnable() { // from class: org.xbill.DNS.SimpleResolver$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m2263lambda$sendAsync$0$orgxbillDNSSimpleResolver(completableFutureM2226m, message);
                }
            }, executor);
            return completableFutureM2226m;
        }
        Message messageClone = message.clone();
        applyEDNS(messageClone);
        TSIG tsig = this.tsig;
        if (tsig != null) {
            messageClone.setTSIG(tsig, 0, null);
        }
        return sendAsync(messageClone, this.useTCP, executor);
    }

    /* JADX INFO: renamed from: lambda$sendAsync$0$org-xbill-DNS-SimpleResolver, reason: not valid java name */
    /* synthetic */ void m2263lambda$sendAsync$0$orgxbillDNSSimpleResolver(CompletableFuture completableFuture, Message message) {
        try {
            completableFuture.complete(sendAXFR(message));
        } catch (IOException e) {
            completableFuture.completeExceptionally(e);
        }
    }

    CompletableFuture<Message> sendAsync(final Message message, boolean z, final Executor executor) {
        CompletableFuture<byte[]> completableFutureSendrecv;
        final int id = message.getHeader().getID();
        byte[] wire = message.toWire(65535);
        int iMaxUDPSize = maxUDPSize(message);
        boolean z2 = z || wire.length > iMaxUDPSize;
        Logger logger = log;
        if (logger.isTraceEnabled()) {
            Object[] objArr = new Object[7];
            objArr[0] = message.getQuestion().getName();
            objArr[1] = Type.string(message.getQuestion().getType());
            objArr[2] = Integer.valueOf(id);
            objArr[3] = z2 ? "tcp" : "udp";
            objArr[4] = this.address.getAddress().getHostAddress();
            objArr[5] = Integer.valueOf(this.address.getPort());
            objArr[6] = message;
            logger.trace("Sending {}/{}, id={} to {}/{}:{}, query:\n{}", objArr);
        } else if (logger.isDebugEnabled()) {
            Object[] objArr2 = new Object[6];
            objArr2[0] = message.getQuestion().getName();
            objArr2[1] = Type.string(message.getQuestion().getType());
            objArr2[2] = Integer.valueOf(id);
            objArr2[3] = z2 ? "tcp" : "udp";
            objArr2[4] = this.address.getAddress().getHostAddress();
            objArr2[5] = Integer.valueOf(this.address.getPort());
            logger.debug("Sending {}/{}, id={} to {}/{}:{}", objArr2);
        }
        if (z2) {
            completableFutureSendrecv = NioTcpClient.sendrecv(this.localAddress, this.address, message, wire, this.timeoutValue);
        } else {
            completableFutureSendrecv = NioUdpClient.sendrecv(this.localAddress, this.address, wire, iMaxUDPSize, this.timeoutValue);
        }
        final boolean z3 = z2;
        return completableFutureSendrecv.thenComposeAsync((Function<? super byte[], ? extends CompletionStage<U>>) Function.Wrapper.convert(new j$.util.function.Function() { // from class: org.xbill.DNS.SimpleResolver$$ExternalSyntheticLambda3
            @Override // j$.util.function.Function
            public /* synthetic */ j$.util.function.Function andThen(j$.util.function.Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m2264lambda$sendAsync$1$orgxbillDNSSimpleResolver(id, message, z3, executor, (byte[]) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ j$.util.function.Function compose(j$.util.function.Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }), executor);
    }

    /* JADX INFO: renamed from: lambda$sendAsync$1$org-xbill-DNS-SimpleResolver, reason: not valid java name */
    /* synthetic */ CompletionStage m2264lambda$sendAsync$1$orgxbillDNSSimpleResolver(int i, Message message, boolean z, Executor executor, byte[] bArr) {
        CompletableFuture completableFutureM2226m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2226m();
        if (bArr.length < 12) {
            completableFutureM2226m.completeExceptionally(new WireParseException("invalid DNS header - too short"));
            return completableFutureM2226m;
        }
        int i2 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
        if (i2 != i) {
            completableFutureM2226m.completeExceptionally(new WireParseException("invalid message id: expected " + i + "; got id " + i2));
            return completableFutureM2226m;
        }
        try {
            Message message2 = parseMessage(bArr);
            if (!message.getQuestion().getName().equals(message2.getQuestion().getName())) {
                completableFutureM2226m.completeExceptionally(new WireParseException("invalid name in message: expected " + message.getQuestion().getName() + "; got " + message2.getQuestion().getName()));
                return completableFutureM2226m;
            }
            if (message.getQuestion().getDClass() != message2.getQuestion().getDClass()) {
                completableFutureM2226m.completeExceptionally(new WireParseException("invalid class in message: expected " + DClass.string(message.getQuestion().getDClass()) + "; got " + DClass.string(message2.getQuestion().getDClass())));
                return completableFutureM2226m;
            }
            if (message.getQuestion().getType() != message2.getQuestion().getType()) {
                completableFutureM2226m.completeExceptionally(new WireParseException("invalid type in message: expected " + Type.string(message.getQuestion().getType()) + "; got " + Type.string(message2.getQuestion().getType())));
                return completableFutureM2226m;
            }
            verifyTSIG(message, message2, bArr, this.tsig);
            if (!z && !this.ignoreTruncation && message2.getHeader().getFlag(6)) {
                Logger logger = log;
                if (logger.isTraceEnabled()) {
                    logger.trace("Got truncated response for id {}, retrying via TCP, response:\n{}", Integer.valueOf(i), message2);
                } else {
                    logger.debug("Got truncated response for id {}, retrying via TCP", Integer.valueOf(i));
                }
                return sendAsync(message, true, executor);
            }
            message2.setResolver(this);
            completableFutureM2226m.complete(message2);
            return completableFutureM2226m;
        } catch (WireParseException e) {
            completableFutureM2226m.completeExceptionally(e);
            return completableFutureM2226m;
        }
    }

    private Message sendAXFR(Message message) throws IOException {
        ZoneTransferIn zoneTransferInNewAXFR = ZoneTransferIn.newAXFR(message.getQuestion().getName(), this.address, this.tsig);
        zoneTransferInNewAXFR.setTimeout(this.timeoutValue);
        zoneTransferInNewAXFR.setLocalAddress(this.localAddress);
        try {
            zoneTransferInNewAXFR.run();
            List<Record> axfr = zoneTransferInNewAXFR.getAXFR();
            Message message2 = new Message(message.getHeader().getID());
            message2.getHeader().setFlag(5);
            message2.getHeader().setFlag(0);
            message2.addRecord(message.getQuestion(), 0);
            Iterator<Record> it = axfr.iterator();
            while (it.hasNext()) {
                message2.addRecord(it.next(), 1);
            }
            return message2;
        } catch (ZoneTransferException e) {
            throw new WireParseException(e.getMessage());
        }
    }

    public String toString() {
        return "SimpleResolver [" + this.address + "]";
    }
}
