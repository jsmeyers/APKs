package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.MoreExecutors;
import androidx.test.espresso.remote.NoRemoteEspressoInstanceException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
final class InteractionResultsHandler {
    private static final int LOCAL_OR_REMOTE_ERROR_PRIORITY = Integer.MAX_VALUE;
    private static final String TAG = "InteractionResultsHandl";

    private InteractionResultsHandler() {
    }

    static <T> T gatherAnyResult(List<ListenableFuture<T>> list) {
        return (T) gatherAnyResult(list, MoreExecutors.directExecutor());
    }

    static <T> T gatherAnyResult(List<ListenableFuture<T>> list, Executor executor) {
        Preconditions.checkNotNull(list);
        Preconditions.checkState(!list.isEmpty());
        int size = list.size();
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(size);
        for (final ListenableFuture<T> listenableFuture : list) {
            listenableFuture.addListener(new Runnable() { // from class: androidx.test.espresso.InteractionResultsHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (listenableFuture.isCancelled()) {
                        return;
                    }
                    linkedBlockingQueue.offer(InteractionResultsHandler.adaptResult(listenableFuture));
                }
            }, executor);
        }
        ExecutionResult executionResultPickResult = null;
        while (size != 0) {
            if (executionResultPickResult != null) {
                try {
                    try {
                        if (executionResultPickResult.isPriority()) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Interrupted while interacting", e);
                    }
                } catch (Throwable th) {
                    Iterator<ListenableFuture<T>> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().cancel(true);
                    }
                    throw th;
                }
            }
            size--;
            executionResultPickResult = pickResult(executionResultPickResult, (ExecutionResult) linkedBlockingQueue.take());
        }
        T t = (T) finalResult(executionResultPickResult);
        Iterator<ListenableFuture<T>> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().cancel(true);
        }
        return t;
    }

    private static <T> T finalResult(ExecutionResult<T> result) {
        if (result.isSuccess()) {
            return result.getResult();
        }
        Throwable failure = result.getFailure();
        if (failure instanceof ExecutionException) {
            Throwable cause = failure.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unknown error during interactions", result.getFailure());
        }
        if (failure instanceof InterruptedException) {
            throw new IllegalStateException("Interrupted while interacting remotely", failure);
        }
        throw new RuntimeException("Error interacting remotely", failure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ExecutionResult<T> adaptResult(Future<T> task) {
        try {
            Preconditions.checkState(task.isDone());
            return ExecutionResult.success(task.get());
        } catch (Error e) {
            return ExecutionResult.error(e);
        } catch (InterruptedException e2) {
            return ExecutionResult.error(e2);
        } catch (RuntimeException e3) {
            return ExecutionResult.error(e3);
        } catch (ExecutionException e4) {
            return ExecutionResult.error(e4, Integer.MAX_VALUE == getPriority(e4));
        }
    }

    private static <T> ExecutionResult<T> pickResult(ExecutionResult<T> one, ExecutionResult<T> two) {
        return two == null ? one : one == null ? two : one.isSuccess() ? one : (!two.isSuccess() && getPriority(one.getFailure()) > getPriority(two.getFailure())) ? one : two;
    }

    private static int getPriority(Throwable t) {
        if (t == null) {
            return Integer.MIN_VALUE;
        }
        if (!(t instanceof ExecutionException)) {
            return -2147483647;
        }
        if (t.getCause() instanceof NoRemoteEspressoInstanceException) {
            return 0;
        }
        return t.getCause() instanceof NoActivityResumedException ? 1 : Integer.MAX_VALUE;
    }

    private static class ExecutionResult<T> {
        private final Throwable failure;
        private final boolean priority;
        private final T result;
        private final boolean success;

        private ExecutionResult(T result, boolean success, Throwable failure, boolean priority) {
            this.result = result;
            this.success = success;
            this.failure = failure;
            this.priority = priority;
        }

        public T getResult() {
            Preconditions.checkState(this.success);
            return this.result;
        }

        public boolean isPriority() {
            return this.priority;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public Throwable getFailure() {
            Preconditions.checkState(!this.success);
            return this.failure;
        }

        public static <T> ExecutionResult<T> success(T result) {
            return new ExecutionResult<>(result, true, null, true);
        }

        public static <T> ExecutionResult<T> error(Throwable error) {
            return error(error, false);
        }

        public static <T> ExecutionResult<T> error(Throwable error, boolean priorityFailure) {
            return new ExecutionResult<>(null, false, error, priorityFailure);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).omitNullValues().add("priority", this.priority).add("success", this.success).add("result", this.result).add("failure", this.failure).toString();
        }
    }
}
