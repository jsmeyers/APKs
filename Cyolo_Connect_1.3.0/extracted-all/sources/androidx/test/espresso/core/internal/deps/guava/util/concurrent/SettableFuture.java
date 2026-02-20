package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture;

/* JADX INFO: loaded from: classes.dex */
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    public static <V> SettableFuture<V> create() {
        return new SettableFuture<>();
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture
    public boolean set(V value) {
        return super.set(value);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture
    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.AbstractFuture
    public boolean setFuture(ListenableFuture<? extends V> future) {
        return super.setFuture(future);
    }

    private SettableFuture() {
    }
}
