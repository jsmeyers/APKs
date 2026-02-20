package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
    public abstract Future<? extends V> delegate();

    protected ForwardingFuture() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return delegate().cancel(mayInterruptIfRunning);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return delegate().isDone();
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return delegate().get();
    }

    @Override // java.util.concurrent.Future
    public V get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        return delegate().get(timeout, unit);
    }
}
