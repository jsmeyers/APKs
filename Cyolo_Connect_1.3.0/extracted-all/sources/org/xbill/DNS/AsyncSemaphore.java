package org.xbill.DNS;

import j$.time.Duration;
import j$.util.function.BiConsumer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.AsyncSemaphore;

/* JADX INFO: loaded from: classes2.dex */
final class AsyncSemaphore {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) AsyncSemaphore.class);
    private volatile int permits;
    private final Queue<CompletableFuture<Permit>> queue = new ArrayDeque();
    private final Permit singletonPermit = new Permit();

    static /* synthetic */ int access$108(AsyncSemaphore asyncSemaphore) {
        int i = asyncSemaphore.permits;
        asyncSemaphore.permits = i + 1;
        return i;
    }

    final class Permit {
        Permit() {
        }

        public void release() {
            synchronized (AsyncSemaphore.this.queue) {
                CompletableFuture completableFutureM = Resolver$$ExternalSyntheticApiModelOutline1.m(AsyncSemaphore.this.queue.poll());
                if (completableFutureM == null) {
                    AsyncSemaphore.access$108(AsyncSemaphore.this);
                } else {
                    completableFutureM.complete(this);
                }
            }
        }
    }

    AsyncSemaphore(int i) {
        this.permits = i;
    }

    CompletionStage<Permit> acquire(Duration duration) {
        synchronized (this.queue) {
            if (this.permits > 0) {
                this.permits--;
                return CompletableFuture.completedFuture(this.singletonPermit);
            }
            final TimeoutCompletableFuture timeoutCompletableFuture = new TimeoutCompletableFuture();
            timeoutCompletableFuture.compatTimeout(duration.toNanos(), TimeUnit.NANOSECONDS).whenComplete(BiConsumer.Wrapper.convert(new BiConsumer() { // from class: org.xbill.DNS.AsyncSemaphore$$ExternalSyntheticLambda2
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f$0.m2245lambda$acquire$0$orgxbillDNSAsyncSemaphore(timeoutCompletableFuture, (AsyncSemaphore.Permit) obj, (Throwable) obj2);
                }

                @Override // j$.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                    return BiConsumer.CC.$default$andThen(this, biConsumer);
                }
            }));
            this.queue.add(timeoutCompletableFuture);
            return timeoutCompletableFuture;
        }
    }

    /* JADX INFO: renamed from: lambda$acquire$0$org-xbill-DNS-AsyncSemaphore, reason: not valid java name */
    /* synthetic */ void m2245lambda$acquire$0$orgxbillDNSAsyncSemaphore(TimeoutCompletableFuture timeoutCompletableFuture, Permit permit, Throwable th) {
        this.queue.remove(timeoutCompletableFuture);
    }
}
