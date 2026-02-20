package org.xbill.DNS;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import j$.time.Duration;
import j$.time.temporal.ChronoUnit;
import j$.util.DesugarCollections;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import okio.NioSystemFileSystem$$ExternalSyntheticApiModelOutline0;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.AsyncSemaphore;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.utils.base64;

/* JADX INFO: loaded from: classes2.dex */
public final class DohResolver implements Resolver {
    private static final String APPLICATION_DNS_MESSAGE = "application/dns-message";
    private static final boolean USE_HTTP_CLIENT;
    private static Method byteArrayBodyPublisherMethod;
    private static Object defaultHttpRequestBuilder;
    private static Method httpClientBuilderBuildMethod;
    private static Method httpClientBuilderExecutorMethod;
    private static Method httpClientBuilderTimeoutMethod;
    private static Method httpClientNewBuilderMethod;
    private static Method httpClientSendAsyncMethod;
    private static Method httpResponseBodyMethod;
    private static Method httpResponseStatusCodeMethod;
    private static Method publisherOfByteArrayMethod;
    private static Method requestBuilderBuildMethod;
    private static Method requestBuilderCopyMethod;
    private static Method requestBuilderPostMethod;
    private static Method requestBuilderTimeoutMethod;
    private static Method requestBuilderUriMethod;
    private Executor defaultExecutor;
    private final Duration idleConnectionTimeout;
    private final AsyncSemaphore initialRequestLock;
    private final AtomicLong lastRequest;
    private final AsyncSemaphore maxConcurrentRequests;
    private OPTRecord queryOPT;
    private final SSLSocketFactory sslSocketFactory;
    private Duration timeout;
    private TSIG tsig;
    private String uriTemplate;
    private boolean usePost;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) DohResolver.class);
    private static final Map<Executor, Object> httpClients = DesugarCollections.synchronizedMap(new WeakHashMap());

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
    public void setIgnoreTruncation(boolean z) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setPort(int i) {
    }

    @Override // org.xbill.DNS.Resolver
    public void setTCP(boolean z) {
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setTimeout(int i) {
        setTimeout(Duration.ofSeconds(i));
    }

    @Override // org.xbill.DNS.Resolver
    public /* synthetic */ void setTimeout(int i, int i2) {
        setTimeout(Duration.ofMillis((((long) i) * 1000) + ((long) i2)));
    }

    static {
        Method declaredMethod;
        Object obj;
        Object[] objArr;
        boolean z;
        if (!System.getProperty("java.version").startsWith("1.")) {
            try {
                Class<?> cls = Class.forName("java.net.http.HttpClient$Builder");
                Class<?> cls2 = Class.forName("java.net.http.HttpClient");
                Class<?> cls3 = Class.forName("java.net.http.HttpClient$Version");
                Class<?> cls4 = Class.forName("java.net.http.HttpRequest$Builder");
                Class<?> cls5 = Class.forName("java.net.http.HttpRequest");
                Class<?> cls6 = Class.forName("java.net.http.HttpRequest$BodyPublishers");
                Class<?> cls7 = Class.forName("java.net.http.HttpRequest$BodyPublisher");
                Class<?> cls8 = Class.forName("java.net.http.HttpResponse");
                Class<?> cls9 = Class.forName("java.net.http.HttpResponse$BodyHandlers");
                Class<?> cls10 = Class.forName("java.net.http.HttpResponse$BodyHandler");
                httpClientBuilderTimeoutMethod = cls.getDeclaredMethod("connectTimeout", Duration.class);
                httpClientBuilderExecutorMethod = cls.getDeclaredMethod("executor", Executor.class);
                httpClientBuilderBuildMethod = cls.getDeclaredMethod("build", new Class[0]);
                httpClientNewBuilderMethod = cls2.getDeclaredMethod("newBuilder", new Class[0]);
                httpClientSendAsyncMethod = cls2.getDeclaredMethod("sendAsync", cls5, cls10);
                declaredMethod = cls4.getDeclaredMethod("header", String.class, String.class);
                Method declaredMethod2 = cls4.getDeclaredMethod("version", cls3);
                requestBuilderTimeoutMethod = cls4.getDeclaredMethod("timeout", Duration.class);
                requestBuilderUriMethod = cls4.getDeclaredMethod("uri", URI.class);
                requestBuilderCopyMethod = cls4.getDeclaredMethod("copy", new Class[0]);
                requestBuilderBuildMethod = cls4.getDeclaredMethod("build", new Class[0]);
                requestBuilderPostMethod = cls4.getDeclaredMethod(ShareTarget.METHOD_POST, cls7);
                Method declaredMethod3 = cls5.getDeclaredMethod("newBuilder", new Class[0]);
                publisherOfByteArrayMethod = cls6.getDeclaredMethod("ofByteArray", byte[].class);
                byteArrayBodyPublisherMethod = cls9.getDeclaredMethod("ofByteArray", new Class[0]);
                httpResponseBodyMethod = cls8.getDeclaredMethod("body", new Class[0]);
                httpResponseStatusCodeMethod = cls8.getDeclaredMethod("statusCode", new Class[0]);
                defaultHttpRequestBuilder = declaredMethod3.invoke(null, new Object[0]);
                declaredMethod2.invoke(defaultHttpRequestBuilder, Enum.valueOf(cls3, "HTTP_2"));
                declaredMethod.invoke(defaultHttpRequestBuilder, HttpHeaders.CONTENT_TYPE, APPLICATION_DNS_MESSAGE);
                obj = defaultHttpRequestBuilder;
                objArr = new Object[2];
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            try {
                objArr[0] = HttpHeaders.ACCEPT;
                objArr[1] = APPLICATION_DNS_MESSAGE;
                declaredMethod.invoke(obj, objArr);
                z = true;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                log.warn("Java >= 11 detected, but HttpRequest not available");
                z = false;
            }
            USE_HTTP_CLIENT = z;
        }
        z = false;
        USE_HTTP_CLIENT = z;
    }

    public DohResolver(String str) {
        this(str, 100, Duration.ofMinutes(2L));
    }

    public DohResolver(String str, int i, Duration duration) {
        this.usePost = false;
        this.timeout = Duration.ofSeconds(5L);
        this.queryOPT = new OPTRecord(0, 0, 0);
        this.defaultExecutor = ForkJoinPool.commonPool();
        this.lastRequest = new AtomicLong(0L);
        this.initialRequestLock = new AsyncSemaphore(1);
        this.uriTemplate = str;
        this.idleConnectionTimeout = duration;
        if (i <= 0) {
            throw new IllegalArgumentException("maxConcurrentRequests must be > 0");
        }
        if (!USE_HTTP_CLIENT) {
            try {
                int i2 = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
                if (i > i2) {
                    i = i2;
                }
            } catch (NumberFormatException unused) {
            }
        }
        this.maxConcurrentRequests = new AsyncSemaphore(i);
        try {
            this.sslSocketFactory = SSLContext.getDefault().getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private Object getHttpClient(Executor executor) {
        return Map.EL.computeIfAbsent(httpClients, executor, new Function() { // from class: org.xbill.DNS.DohResolver$$ExternalSyntheticLambda7
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m2246lambda$getHttpClient$0$orgxbillDNSDohResolver((Executor) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getHttpClient$0$org-xbill-DNS-DohResolver, reason: not valid java name */
    /* synthetic */ Object m2246lambda$getHttpClient$0$orgxbillDNSDohResolver(Executor executor) {
        try {
            Object objInvoke = httpClientNewBuilderMethod.invoke(null, new Object[0]);
            httpClientBuilderTimeoutMethod.invoke(objInvoke, this.timeout);
            httpClientBuilderExecutorMethod.invoke(objInvoke, executor);
            return httpClientBuilderBuildMethod.invoke(objInvoke, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.warn("Could not create a HttpClient with for Executor {}", executor, e);
            return null;
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setEDNS(int i, int i2, int i3, List<EDNSOption> list) {
        if (i == -1) {
            this.queryOPT = null;
        } else {
            if (i == 0) {
                this.queryOPT = new OPTRecord(0, 0, i, i3, list);
                return;
            }
            throw new IllegalArgumentException("invalid EDNS version - must be 0 or -1 to disable");
        }
    }

    @Override // org.xbill.DNS.Resolver
    public void setTSIGKey(TSIG tsig) {
        this.tsig = tsig;
    }

    @Override // org.xbill.DNS.Resolver
    public void setTimeout(Duration duration) {
        this.timeout = duration;
        httpClients.clear();
    }

    @Override // org.xbill.DNS.Resolver
    public Duration getTimeout() {
        return this.timeout;
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message) {
        return sendAsync(message, this.defaultExecutor);
    }

    @Override // org.xbill.DNS.Resolver
    public CompletionStage<Message> sendAsync(Message message, Executor executor) {
        if (USE_HTTP_CLIENT) {
            return sendAsync11(message, executor);
        }
        return sendAsync8(message, executor);
    }

    private CompletionStage<Message> sendAsync8(final Message message, Executor executor) {
        final byte[] wire = prepareQuery(message).toWire();
        final String url = getUrl(wire);
        final long jNanoTime = System.nanoTime();
        return this.maxConcurrentRequests.acquire(this.timeout).handleAsync(BiFunction.Wrapper.convert(new BiFunction() { // from class: org.xbill.DNS.DohResolver$$ExternalSyntheticLambda8
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m2251lambda$sendAsync8$1$orgxbillDNSDohResolver(message, url, wire, jNanoTime, (AsyncSemaphore.Permit) obj, (Throwable) obj2);
            }
        }), executor).thenCompose(Function.Wrapper.convert(Function.CC.identity()));
    }

    /* JADX INFO: renamed from: lambda$sendAsync8$1$org-xbill-DNS-DohResolver, reason: not valid java name */
    /* synthetic */ CompletableFuture m2251lambda$sendAsync8$1$orgxbillDNSDohResolver(Message message, String str, byte[] bArr, long j, AsyncSemaphore.Permit permit, Throwable th) {
        Message message2;
        try {
            if (th != null) {
                return timeoutFailedFuture(message, th);
            }
            SendAndGetMessageBytesResponse sendAndGetMessageBytesResponseSendAndGetMessageBytes = sendAndGetMessageBytes(str, bArr, j);
            if (sendAndGetMessageBytesResponseSendAndGetMessageBytes.rc == 0) {
                message2 = new Message(sendAndGetMessageBytesResponseSendAndGetMessageBytes.responseBytes);
                verifyTSIG(message, message2, sendAndGetMessageBytesResponseSendAndGetMessageBytes.responseBytes, this.tsig);
            } else {
                message2 = new Message(0);
                message2.getHeader().setRcode(sendAndGetMessageBytesResponseSendAndGetMessageBytes.rc);
            }
            message2.setResolver(this);
            return CompletableFuture.completedFuture(message2);
        } catch (IOException e) {
            return failedFuture(e);
        } catch (SocketTimeoutException e2) {
            return timeoutFailedFuture(message, e2);
        } finally {
            permit.release();
        }
    }

    private static final class SendAndGetMessageBytesResponse {
        private final int rc;
        private final byte[] responseBytes;

        public SendAndGetMessageBytesResponse(int i, byte[] bArr) {
            this.rc = i;
            this.responseBytes = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SendAndGetMessageBytesResponse)) {
                return false;
            }
            SendAndGetMessageBytesResponse sendAndGetMessageBytesResponse = (SendAndGetMessageBytesResponse) obj;
            return getRc() == sendAndGetMessageBytesResponse.getRc() && Arrays.equals(getResponseBytes(), sendAndGetMessageBytesResponse.getResponseBytes());
        }

        public int hashCode() {
            return ((getRc() + 59) * 59) + Arrays.hashCode(getResponseBytes());
        }

        public String toString() {
            return "DohResolver.SendAndGetMessageBytesResponse(rc=" + getRc() + ", responseBytes=" + Arrays.toString(getResponseBytes()) + ")";
        }

        public int getRc() {
            return this.rc;
        }

        public byte[] getResponseBytes() {
            return this.responseBytes;
        }
    }

    private SendAndGetMessageBytesResponse sendAndGetMessageBytes(String str, byte[] bArr, long j) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.sslSocketFactory);
        }
        Duration durationMinus = this.timeout.minus(System.nanoTime() - j, ChronoUnit.NANOS);
        httpURLConnection.setConnectTimeout((int) durationMinus.toMillis());
        httpURLConnection.setReadTimeout((int) durationMinus.toMillis());
        httpURLConnection.setRequestMethod(this.usePost ? ShareTarget.METHOD_POST : ShareTarget.METHOD_GET);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, APPLICATION_DNS_MESSAGE);
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, APPLICATION_DNS_MESSAGE);
        if (this.usePost) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(bArr);
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 300) {
            discardStream(httpURLConnection.getInputStream());
            discardStream(httpURLConnection.getErrorStream());
            return new SendAndGetMessageBytesResponse(2, null);
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                if (httpURLConnection.getContentLength() > -1) {
                    int contentLength = httpURLConnection.getContentLength();
                    byte[] bArr2 = new byte[contentLength];
                    int i = 0;
                    do {
                        int i2 = inputStream.read(bArr2, i, contentLength - i);
                        if (i2 <= 0) {
                            if (i < contentLength) {
                                throw new EOFException("Could not read expected content length");
                            }
                            SendAndGetMessageBytesResponse sendAndGetMessageBytesResponse = new SendAndGetMessageBytesResponse(0, bArr2);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return sendAndGetMessageBytesResponse;
                        }
                        i += i2;
                    } while (!this.timeout.minus(System.nanoTime() - j, ChronoUnit.NANOS).isNegative());
                    throw new SocketTimeoutException();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr3 = new byte[4096];
                    while (true) {
                        int i3 = inputStream.read(bArr3, 0, 4096);
                        if (i3 > 0) {
                            if (this.timeout.minus(System.nanoTime() - j, ChronoUnit.NANOS).isNegative()) {
                                throw new SocketTimeoutException();
                            }
                            byteArrayOutputStream.write(bArr3, 0, i3);
                        } else {
                            SendAndGetMessageBytesResponse sendAndGetMessageBytesResponse2 = new SendAndGetMessageBytesResponse(0, byteArrayOutputStream.toByteArray());
                            byteArrayOutputStream.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return sendAndGetMessageBytesResponse2;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (IOException e) {
            discardStream(httpURLConnection.getErrorStream());
            throw e;
        }
        discardStream(httpURLConnection.getErrorStream());
        throw e;
    }

    private void discardStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                try {
                    do {
                    } while (inputStream.read(new byte[4096]) > 0);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    private CompletionStage<Message> sendAsync11(final Message message, final Executor executor) {
        final long jNanoTime = System.nanoTime();
        byte[] wire = prepareQuery(message).toWire();
        String url = getUrl(wire);
        try {
            final Object objInvoke = requestBuilderCopyMethod.invoke(defaultHttpRequestBuilder, new Object[0]);
            requestBuilderUriMethod.invoke(objInvoke, URI.create(url));
            if (this.usePost) {
                requestBuilderPostMethod.invoke(objInvoke, publisherOfByteArrayMethod.invoke(null, wire));
            }
            return this.initialRequestLock.acquire(this.timeout.minus(System.nanoTime() - jNanoTime, ChronoUnit.NANOS)).handle(BiFunction.Wrapper.convert(new BiFunction() { // from class: org.xbill.DNS.DohResolver$$ExternalSyntheticLambda9
                @Override // j$.util.function.BiFunction
                public /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return this.f$0.m2247lambda$sendAsync11$2$orgxbillDNSDohResolver(message, executor, jNanoTime, objInvoke, (AsyncSemaphore.Permit) obj, (Throwable) obj2);
                }
            })).thenCompose(Function.Wrapper.convert(Function.CC.identity()));
        } catch (IllegalAccessException | InvocationTargetException e) {
            return failedFuture(e);
        }
    }

    /* JADX INFO: renamed from: lambda$sendAsync11$2$org-xbill-DNS-DohResolver, reason: not valid java name */
    /* synthetic */ CompletionStage m2247lambda$sendAsync11$2$orgxbillDNSDohResolver(Message message, Executor executor, long j, Object obj, AsyncSemaphore.Permit permit, Throwable th) {
        return th != null ? timeoutFailedFuture(message, th) : sendAsync11WithInitialRequestPermit(message, executor, j, obj, permit);
    }

    private CompletionStage<Message> sendAsync11WithInitialRequestPermit(final Message message, final Executor executor, final long j, final Object obj, final AsyncSemaphore.Permit permit) {
        final boolean z = this.lastRequest.get() < System.nanoTime() - this.idleConnectionTimeout.toNanos();
        if (!z) {
            permit.release();
        }
        Duration durationMinus = this.timeout.minus(System.nanoTime() - j, ChronoUnit.NANOS);
        if (durationMinus.isNegative()) {
            if (z) {
                permit.release();
            }
            return timeoutFailedFuture(message, null);
        }
        return this.maxConcurrentRequests.acquire(durationMinus).handle(BiFunction.Wrapper.convert(new BiFunction() { // from class: org.xbill.DNS.DohResolver$$ExternalSyntheticLambda10
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj2, Object obj3) {
                return this.f$0.m2250x55540af6(z, permit, message, executor, j, obj, (AsyncSemaphore.Permit) obj2, (Throwable) obj3);
            }
        })).thenCompose(Function.Wrapper.convert(Function.CC.identity()));
    }

    /* JADX INFO: renamed from: lambda$sendAsync11WithInitialRequestPermit$3$org-xbill-DNS-DohResolver, reason: not valid java name */
    /* synthetic */ CompletionStage m2250x55540af6(boolean z, AsyncSemaphore.Permit permit, Message message, Executor executor, long j, Object obj, AsyncSemaphore.Permit permit2, Throwable th) {
        if (th == null) {
            return sendAsync11WithConcurrentRequestPermit(message, executor, j, obj, permit, z, permit2);
        }
        if (z) {
            permit.release();
        }
        return timeoutFailedFuture(message, th);
    }

    private CompletionStage<Message> sendAsync11WithConcurrentRequestPermit(final Message message, Executor executor, final long j, Object obj, final AsyncSemaphore.Permit permit, final boolean z, final AsyncSemaphore.Permit permit2) {
        Duration durationMinus = this.timeout.minus(System.nanoTime() - j, ChronoUnit.NANOS);
        if (durationMinus.isNegative()) {
            if (z) {
                permit.release();
            }
            permit2.release();
            return timeoutFailedFuture(message, null);
        }
        try {
            Object httpClient = getHttpClient(executor);
            requestBuilderTimeoutMethod.invoke(obj, durationMinus);
            return TimeoutCompletableFuture.compatTimeout(Resolver$$ExternalSyntheticApiModelOutline1.m(httpClientSendAsyncMethod.invoke(httpClient, requestBuilderBuildMethod.invoke(obj, new Object[0]), byteArrayBodyPublisherMethod.invoke(null, new Object[0]))).whenComplete(BiConsumer.Wrapper.convert(new BiConsumer() { // from class: org.xbill.DNS.DohResolver$$ExternalSyntheticLambda5
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj2, Object obj3) {
                    this.f$0.m2248x2d48134a(j, permit2, z, permit, obj2, (Throwable) obj3);
                }

                @Override // j$.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer.CC.$default$andThen(this, biConsumer);
                }
            })).handleAsync(BiFunction.Wrapper.convert(new BiFunction() { // from class: org.xbill.DNS.DohResolver$$ExternalSyntheticLambda6
                @Override // j$.util.function.BiFunction
                public /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj2, Object obj3) {
                    return this.f$0.m2249x6699240b(message, obj2, (Throwable) obj3);
                }
            }), executor).thenCompose(Function.Wrapper.convert(Function.CC.identity())), durationMinus.toMillis(), TimeUnit.MILLISECONDS);
        } catch (IllegalAccessException | InvocationTargetException e) {
            return failedFuture(e);
        }
    }

    /* JADX INFO: renamed from: lambda$sendAsync11WithConcurrentRequestPermit$4$org-xbill-DNS-DohResolver, reason: not valid java name */
    /* synthetic */ void m2248x2d48134a(long j, AsyncSemaphore.Permit permit, boolean z, AsyncSemaphore.Permit permit2, Object obj, Throwable th) {
        if (th == null) {
            this.lastRequest.set(j);
        }
        permit.release();
        if (z) {
            permit2.release();
        }
    }

    /* JADX INFO: renamed from: lambda$sendAsync11WithConcurrentRequestPermit$5$org-xbill-DNS-DohResolver, reason: not valid java name */
    /* synthetic */ CompletableFuture m2249x6699240b(Message message, Object obj, Throwable th) {
        Message message2;
        if (th != null) {
            return th.getCause().getClass().getSimpleName().equals("HttpTimeoutException") ? timeoutFailedFuture(message, th.getCause()) : failedFuture(th);
        }
        try {
            int iIntValue = ((Integer) httpResponseStatusCodeMethod.invoke(obj, new Object[0])).intValue();
            if (iIntValue < 200 || iIntValue >= 300) {
                message2 = new Message();
                message2.getHeader().setRcode(2);
            } else {
                byte[] bArr = (byte[]) httpResponseBodyMethod.invoke(obj, new Object[0]);
                message2 = new Message(bArr);
                verifyTSIG(message, message2, bArr, this.tsig);
            }
            message2.setResolver(this);
            return CompletableFuture.completedFuture(message2);
        } catch (IOException | IllegalAccessException | InvocationTargetException e) {
            return failedFuture(e);
        }
    }

    private <T> CompletableFuture<T> failedFuture(Throwable th) {
        CompletableFuture<T> completableFutureM2226m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2226m();
        completableFutureM2226m.completeExceptionally(th);
        return completableFutureM2226m;
    }

    private <T> CompletableFuture<T> timeoutFailedFuture(Message message, Throwable th) {
        return failedFuture(new IOException("Query " + message.getHeader().getID() + " for " + message.getQuestion().getName() + "/" + Type.string(message.getQuestion().getType()) + " timed out", th));
    }

    private String getUrl(byte[] bArr) {
        String str = this.uriTemplate;
        if (this.usePost) {
            return str;
        }
        return str + "?dns=" + base64.toString(bArr, true);
    }

    private Message prepareQuery(Message message) {
        Message messageClone = message.clone();
        messageClone.getHeader().setID(0);
        if (this.queryOPT != null && messageClone.getOPT() == null) {
            messageClone.addRecord(this.queryOPT, 3);
        }
        TSIG tsig = this.tsig;
        if (tsig != null) {
            tsig.apply(messageClone, null);
        }
        return messageClone;
    }

    private void verifyTSIG(Message message, Message message2, byte[] bArr, TSIG tsig) {
        if (tsig == null) {
            return;
        }
        log.debug("TSIG verify for query {}, {}/{}: {}", Integer.valueOf(message.getHeader().getID()), message.getQuestion().getName(), Type.string(message.getQuestion().getType()), Rcode.TSIGstring(tsig.verify(message2, bArr, message.getTSIG())));
    }

    public boolean isUsePost() {
        return this.usePost;
    }

    public void setUsePost(boolean z) {
        this.usePost = z;
    }

    public String getUriTemplate() {
        return this.uriTemplate;
    }

    public void setUriTemplate(String str) {
        this.uriTemplate = str;
    }

    @Deprecated
    public Executor getExecutor() {
        return this.defaultExecutor;
    }

    @Deprecated
    public void setExecutor(Executor executor) {
        if (executor == null) {
            executor = ForkJoinPool.commonPool();
        }
        this.defaultExecutor = executor;
        httpClients.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DohResolver {");
        sb.append(this.usePost ? "POST " : "GET ");
        sb.append(this.uriTemplate);
        sb.append("}");
        return sb.toString();
    }
}
