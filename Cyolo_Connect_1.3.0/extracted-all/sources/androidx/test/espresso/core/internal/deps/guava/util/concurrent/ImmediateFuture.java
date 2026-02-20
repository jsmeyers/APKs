package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
abstract class ImmediateFuture<V> implements ListenableFuture<V> {
    private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    ImmediateFuture() {
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture
    public void addListener(Runnable listener, Executor executor) {
        Preconditions.checkNotNull(listener, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(listener);
        } catch (RuntimeException e) {
            Logger logger = log;
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(listener);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 57 + String.valueOf(strValueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            logger.logp(level, "androidx.test.espresso.core.internal.deps.guava.util.concurrent.ImmediateFuture", "addListener", sb.toString(), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long timeout, TimeUnit unit) throws ExecutionException {
        Preconditions.checkNotNull(unit);
        return get();
    }

    static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateSuccessfulFuture<Object> NULL = new ImmediateSuccessfulFuture<>(null);
        private final V value;

        ImmediateSuccessfulFuture(V value) {
            this.value = value;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ImmediateFuture, java.util.concurrent.Future
        public V get() {
            return this.value;
        }

        public String toString() {
            String string = super.toString();
            String strValueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 27 + String.valueOf(strValueOf).length());
            sb.append(string);
            sb.append("[status=SUCCESS, result=[");
            sb.append(strValueOf);
            sb.append("]]");
            return sb.toString();
        }
    }

    static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateFailedFuture(Throwable thrown) {
            setException(thrown);
        }
    }
}
