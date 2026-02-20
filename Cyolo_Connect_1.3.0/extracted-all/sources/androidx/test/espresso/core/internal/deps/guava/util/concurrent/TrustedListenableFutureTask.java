package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes.dex */
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    static <V> TrustedListenableFutureTask<V> create(Runnable runnable, V result) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, result));
    }

    TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture
    protected void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture
    protected String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            String strValueOf = String.valueOf(interruptibleTask);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 7);
            sb.append("task=[");
            sb.append(strValueOf);
            sb.append("]");
            return sb.toString();
        }
        return super.pendingToString();
    }

    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.callable = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.InterruptibleTask
        final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.InterruptibleTask
        V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.InterruptibleTask
        void afterRanInterruptibly(V result, Throwable error) {
            if (error == null) {
                TrustedListenableFutureTask.this.set(result);
            } else {
                TrustedListenableFutureTask.this.setException(error);
            }
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.InterruptibleTask
        String toPendingString() {
            return this.callable.toString();
        }
    }
}
