package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public interface ListenableFuture<V> extends Future<V> {
    void addListener(Runnable listener, Executor executor);
}
