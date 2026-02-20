package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        TrustedFuture() {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture, androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture
        public final void addListener(Runnable listener, Executor executor) {
            super.addListener(listener, executor);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean mayInterruptIfRunning) {
            return super.cancel(mayInterruptIfRunning);
        }
    }

    FluentFuture() {
    }
}
