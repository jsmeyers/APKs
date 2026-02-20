package org.xbill.DNS;

import j$.util.function.BiConsumer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.TimeoutCompletableFuture;

/* JADX INFO: loaded from: classes2.dex */
class TimeoutCompletableFuture<T> extends CompletableFuture<T> {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) TimeoutCompletableFuture.class);
    private static final Method orTimeoutMethod;

    static {
        Method method = null;
        if (!System.getProperty("java.version").startsWith("1.")) {
            try {
                method = Resolver$$ExternalSyntheticApiModelOutline1.m().getMethod("orTimeout", Long.TYPE, TimeUnit.class);
            } catch (NoSuchMethodException e) {
                log.warn("CompletableFuture.orTimeout method not found in Java 9+, using custom implementation", (Throwable) e);
            }
        }
        orTimeoutMethod = method;
    }

    TimeoutCompletableFuture() {
    }

    public CompletableFuture<T> compatTimeout(long j, TimeUnit timeUnit) {
        return compatTimeout(this, j, timeUnit);
    }

    public static <T> CompletableFuture<T> compatTimeout(CompletableFuture<T> completableFuture, long j, TimeUnit timeUnit) {
        Method method = orTimeoutMethod;
        if (method == null) {
            return orTimeout(completableFuture, j, timeUnit);
        }
        try {
            return Resolver$$ExternalSyntheticApiModelOutline1.m(method.invoke(completableFuture, Long.valueOf(j), timeUnit));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return orTimeout(completableFuture, j, timeUnit);
        }
    }

    private static <T> CompletableFuture<T> orTimeout(final CompletableFuture<T> completableFuture, long j, TimeUnit timeUnit) {
        final ScheduledFuture<?> scheduledFutureSchedule = TimeoutScheduler.executor.schedule(new Runnable() { // from class: org.xbill.DNS.TimeoutCompletableFuture$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TimeoutCompletableFuture.lambda$orTimeout$0(completableFuture);
            }
        }, j, timeUnit);
        completableFuture.whenComplete(BiConsumer.Wrapper.convert(new BiConsumer() { // from class: org.xbill.DNS.TimeoutCompletableFuture$$ExternalSyntheticLambda2
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                TimeoutCompletableFuture.lambda$orTimeout$1(scheduledFutureSchedule, obj, (Throwable) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }));
        return completableFuture;
    }

    static /* synthetic */ void lambda$orTimeout$0(CompletableFuture completableFuture) {
        if (completableFuture.isDone()) {
            return;
        }
        completableFuture.completeExceptionally(new TimeoutException());
    }

    static /* synthetic */ void lambda$orTimeout$1(ScheduledFuture scheduledFuture, Object obj, Throwable th) {
        if (th != null || scheduledFuture.isDone()) {
            return;
        }
        scheduledFuture.cancel(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class TimeoutScheduler {
        private static final ScheduledThreadPoolExecutor executor;

        private TimeoutScheduler() {
        }

        static {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: org.xbill.DNS.TimeoutCompletableFuture$TimeoutScheduler$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return TimeoutCompletableFuture.TimeoutScheduler.lambda$static$0(runnable);
                }
            });
            executor = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        }

        static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName("dnsjava AsyncSemaphoreTimeoutScheduler");
            return thread;
        }
    }
}
