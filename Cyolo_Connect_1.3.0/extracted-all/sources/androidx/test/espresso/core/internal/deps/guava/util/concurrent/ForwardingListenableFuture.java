package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingFuture, androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
    public abstract ListenableFuture<? extends V> delegate();

    protected ForwardingListenableFuture() {
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture
    public void addListener(Runnable listener, Executor exec) {
        delegate().addListener(listener, exec);
    }

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        private final ListenableFuture<V> delegate;

        protected SimpleForwardingListenableFuture(ListenableFuture<V> delegate) {
            this.delegate = (ListenableFuture) Preconditions.checkNotNull(delegate);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingListenableFuture, androidx.test.espresso.core.internal.deps.guava.util.concurrent.ForwardingFuture, androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
        public final ListenableFuture<V> delegate() {
            return this.delegate;
        }
    }
}
