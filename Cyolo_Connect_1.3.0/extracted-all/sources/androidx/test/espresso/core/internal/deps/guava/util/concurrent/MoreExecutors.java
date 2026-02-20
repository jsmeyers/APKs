package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Throwables;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class MoreExecutors {
    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    public static ListeningExecutorService listeningDecorator(ExecutorService delegate) {
        ListeningExecutorService listeningDecorator;
        if (delegate instanceof ListeningExecutorService) {
            return (ListeningExecutorService) delegate;
        }
        if (delegate instanceof ScheduledExecutorService) {
            listeningDecorator = new ScheduledListeningDecorator((ScheduledExecutorService) delegate);
        } else {
            listeningDecorator = new ListeningDecorator(delegate);
        }
        return listeningDecorator;
    }

    private static class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService delegate;

        ListeningDecorator(ExecutorService delegate) {
            this.delegate = (ExecutorService) Preconditions.checkNotNull(delegate);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return this.delegate.awaitTermination(timeout, unit);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.delegate.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable command) {
            this.delegate.execute(command);
        }
    }

    private static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        final ScheduledExecutorService delegate;

        ScheduledListeningDecorator(ScheduledExecutorService delegate) {
            super(delegate);
            this.delegate = (ScheduledExecutorService) Preconditions.checkNotNull(delegate);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(command, null);
            return new ListenableScheduledTask(trustedListenableFutureTaskCreate, this.delegate.schedule(trustedListenableFutureTaskCreate, delay, unit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(callable);
            return new ListenableScheduledTask(trustedListenableFutureTaskCreate, this.delegate.schedule(trustedListenableFutureTaskCreate, delay, unit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(command);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, initialDelay, period, unit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(command);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, initialDelay, delay, unit));
        }

        private static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> scheduledDelegate;

            public ListenableScheduledTask(ListenableFuture<V> listenableDelegate, ScheduledFuture<?> scheduledDelegate) {
                super(listenableDelegate);
                this.scheduledDelegate = scheduledDelegate;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean mayInterruptIfRunning) {
                boolean zCancel = super.cancel(mayInterruptIfRunning);
                if (zCancel) {
                    this.scheduledDelegate.cancel(mayInterruptIfRunning);
                }
                return zCancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit unit) {
                return this.scheduledDelegate.getDelay(unit);
            }

            @Override // java.lang.Comparable
            public int compareTo(Delayed other) {
                return this.scheduledDelegate.compareTo(other);
            }
        }

        private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable delegate) {
                this.delegate = (Runnable) Preconditions.checkNotNull(delegate);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.delegate.run();
                } catch (Throwable th) {
                    setException(th);
                    throw Throwables.propagate(th);
                }
            }
        }
    }

    static Executor rejectionPropagatingExecutor(final Executor delegate, final AbstractFuture<?> future) {
        Preconditions.checkNotNull(delegate);
        Preconditions.checkNotNull(future);
        return delegate == directExecutor() ? delegate : new AnonymousClass5(delegate, future);
    }

    /* JADX INFO: renamed from: androidx.test.espresso.core.internal.deps.guava.util.concurrent.MoreExecutors$5, reason: invalid class name */
    class AnonymousClass5 implements Executor {
        boolean thrownFromDelegate = true;
        final /* synthetic */ Executor val$delegate;
        final /* synthetic */ AbstractFuture val$future;

        AnonymousClass5(final Executor val$delegate, final AbstractFuture val$future) {
            this.val$delegate = val$delegate;
            this.val$future = val$future;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable command) {
            try {
                this.val$delegate.execute(new Runnable() { // from class: androidx.test.espresso.core.internal.deps.guava.util.concurrent.MoreExecutors.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5.this.thrownFromDelegate = false;
                        command.run();
                    }
                });
            } catch (RejectedExecutionException e) {
                if (this.thrownFromDelegate) {
                    this.val$future.setException(e);
                }
            }
        }
    }
}
