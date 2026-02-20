package org.xbill.DNS;

import j$.time.Duration;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okio.NioSystemFileSystem$$ExternalSyntheticApiModelOutline0;
import org.xbill.DNS.Resolver;

/* JADX INFO: loaded from: classes2.dex */
public interface Resolver {
    Duration getTimeout();

    Message send(Message message) throws IOException;

    @Deprecated
    Object sendAsync(Message message, ResolverListener resolverListener);

    CompletionStage<Message> sendAsync(Message message);

    CompletionStage<Message> sendAsync(Message message, Executor executor);

    void setEDNS(int i);

    void setEDNS(int i, int i2, int i3, List<EDNSOption> list);

    void setEDNS(int i, int i2, int i3, EDNSOption... eDNSOptionArr);

    void setIgnoreTruncation(boolean z);

    void setPort(int i);

    void setTCP(boolean z);

    void setTSIGKey(TSIG tsig);

    @Deprecated
    void setTimeout(int i);

    @Deprecated
    void setTimeout(int i, int i2);

    void setTimeout(Duration duration);

    /* JADX INFO: renamed from: org.xbill.DNS.Resolver$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Message $default$send(Resolver _this, Message message) throws IOException {
            try {
                return (Message) _this.sendAsync(message).toCompletableFuture().get(_this.getTimeout().toMillis(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException(e);
            } catch (ExecutionException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw new IOException(e2.getCause());
            } catch (TimeoutException unused) {
                throw new IOException("Timed out while trying to resolve " + message.getQuestion().getName() + "/" + Type.string(message.getQuestion().type) + ", id=" + message.getHeader().getID());
            }
        }

        public static CompletionStage $default$sendAsync(final Resolver _this, Message message, Executor executor) {
            final CompletableFuture completableFutureM2226m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2226m();
            _this.sendAsync(message, new ResolverListener() { // from class: org.xbill.DNS.Resolver.1
                @Override // org.xbill.DNS.ResolverListener
                public void receiveMessage(Object obj, Message message2) {
                    completableFutureM2226m.complete(message2);
                }

                @Override // org.xbill.DNS.ResolverListener
                public void handleException(Object obj, Exception exc) {
                    completableFutureM2226m.completeExceptionally(exc);
                }
            });
            return completableFutureM2226m;
        }

        @Deprecated
        public static Object $default$sendAsync(Resolver _this, Message message, final ResolverListener resolverListener) {
            final Object obj = new Object();
            _this.sendAsync(message).handleAsync(BiFunction.Wrapper.convert(new BiFunction() { // from class: org.xbill.DNS.Resolver$$ExternalSyntheticLambda2
                @Override // j$.util.function.BiFunction
                public /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj2, Object obj3) {
                    return Resolver.CC.lambda$sendAsync$0(resolverListener, obj, (Message) obj2, (Throwable) obj3);
                }
            }));
            return obj;
        }

        public static /* synthetic */ Object lambda$sendAsync$0(ResolverListener resolverListener, Object obj, Message message, Throwable th) {
            if (th != null) {
                resolverListener.handleException(obj, th instanceof Exception ? (Exception) th : new Exception(th));
                return null;
            }
            resolverListener.receiveMessage(obj, message);
            return null;
        }
    }
}
