package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList executionList;

    public static <V> ListenableFutureTask<V> create(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    public static <V> ListenableFutureTask<V> create(Runnable runnable, V result) {
        return new ListenableFutureTask<>(runnable, result);
    }

    ListenableFutureTask(Callable<V> callable) {
        super(callable);
        this.executionList = new ExecutionList();
    }

    ListenableFutureTask(Runnable runnable, V result) {
        super(runnable, result);
        this.executionList = new ExecutionList();
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture
    public void addListener(Runnable listener, Executor exec) {
        this.executionList.add(listener, exec);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.executionList.execute();
    }
}
