package com.bugsnag.android.internal;

import com.bugsnag.android.internal.dag.RunnableProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BackgroundTaskService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001!B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u000e\b\u0004\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0018H\u0086\bJ\u0006\u0010\u0019\u001a\u00020\u0010J\u001a\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0014J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001b\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001fJ\f\u0010 \u001a\u00020\u0010*\u00020\u0003H\u0002R\u0016\u0010\u0007\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\""}, d2 = {"Lcom/bugsnag/android/internal/BackgroundTaskService;", "", "errorExecutor", "Ljava/util/concurrent/ExecutorService;", "sessionExecutor", "ioExecutor", "internalReportExecutor", "defaultExecutor", "(Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;)V", "getDefaultExecutor$bugsnag_android_core_release", "()Ljava/util/concurrent/ExecutorService;", "getErrorExecutor$bugsnag_android_core_release", "getInternalReportExecutor$bugsnag_android_core_release", "getIoExecutor$bugsnag_android_core_release", "getSessionExecutor$bugsnag_android_core_release", "execute", "", "taskType", "Lcom/bugsnag/android/internal/TaskType;", "task", "Ljava/lang/Runnable;", "provider", "Lcom/bugsnag/android/internal/dag/RunnableProvider;", "R", "Lkotlin/Function0;", "shutdown", "submitTask", "Ljava/util/concurrent/Future;", "runnable", "T", "callable", "Ljava/util/concurrent/Callable;", "awaitTerminationSafe", "SafeFuture", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BackgroundTaskService {
    private final ExecutorService defaultExecutor;
    private final ExecutorService errorExecutor;
    private final ExecutorService internalReportExecutor;
    private final ExecutorService ioExecutor;
    private final ExecutorService sessionExecutor;

    /* JADX INFO: compiled from: BackgroundTaskService.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskType.values().length];
            iArr[TaskType.ERROR_REQUEST.ordinal()] = 1;
            iArr[TaskType.SESSION_REQUEST.ordinal()] = 2;
            iArr[TaskType.IO.ordinal()] = 3;
            iArr[TaskType.INTERNAL_REPORT.ordinal()] = 4;
            iArr[TaskType.DEFAULT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BackgroundTaskService() {
        this(null, null, null, null, null, 31, null);
    }

    public BackgroundTaskService(ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3, ExecutorService executorService4, ExecutorService executorService5) {
        this.errorExecutor = executorService;
        this.sessionExecutor = executorService2;
        this.ioExecutor = executorService3;
        this.internalReportExecutor = executorService4;
        this.defaultExecutor = executorService5;
    }

    /* JADX INFO: renamed from: getErrorExecutor$bugsnag_android_core_release, reason: from getter */
    public final ExecutorService getErrorExecutor() {
        return this.errorExecutor;
    }

    public /* synthetic */ BackgroundTaskService(ExecutorService executorService, ExecutorService executorService2, ExecutorService executorService3, ExecutorService executorService4, ExecutorService executorService5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BackgroundTaskServiceKt.createExecutor("Bugsnag Error thread", TaskType.ERROR_REQUEST, true) : executorService, (i & 2) != 0 ? BackgroundTaskServiceKt.createExecutor("Bugsnag Session thread", TaskType.SESSION_REQUEST, true) : executorService2, (i & 4) != 0 ? BackgroundTaskServiceKt.createExecutor("Bugsnag IO thread", TaskType.IO, true) : executorService3, (i & 8) != 0 ? BackgroundTaskServiceKt.createExecutor("Bugsnag Internal Report thread", TaskType.INTERNAL_REPORT, false) : executorService4, (i & 16) != 0 ? BackgroundTaskServiceKt.createExecutor("Bugsnag Default thread", TaskType.DEFAULT, false) : executorService5);
    }

    /* JADX INFO: renamed from: getSessionExecutor$bugsnag_android_core_release, reason: from getter */
    public final ExecutorService getSessionExecutor() {
        return this.sessionExecutor;
    }

    /* JADX INFO: renamed from: getIoExecutor$bugsnag_android_core_release, reason: from getter */
    public final ExecutorService getIoExecutor() {
        return this.ioExecutor;
    }

    /* JADX INFO: renamed from: getInternalReportExecutor$bugsnag_android_core_release, reason: from getter */
    public final ExecutorService getInternalReportExecutor() {
        return this.internalReportExecutor;
    }

    /* JADX INFO: renamed from: getDefaultExecutor$bugsnag_android_core_release, reason: from getter */
    public final ExecutorService getDefaultExecutor() {
        return this.defaultExecutor;
    }

    public final Future<?> submitTask(TaskType taskType, Runnable runnable) throws RejectedExecutionException {
        return submitTask(taskType, Executors.callable(runnable));
    }

    public final <T> Future<T> submitTask(TaskType taskType, Callable<T> callable) throws RejectedExecutionException {
        FutureTask futureTask = new FutureTask(callable);
        execute(taskType, futureTask);
        return new SafeFuture(futureTask, taskType);
    }

    public final void execute(TaskType taskType, Runnable task) {
        int i = WhenMappings.$EnumSwitchMapping$0[taskType.ordinal()];
        if (i == 1) {
            this.errorExecutor.execute(task);
            return;
        }
        if (i == 2) {
            this.sessionExecutor.execute(task);
            return;
        }
        if (i == 3) {
            this.ioExecutor.execute(task);
        } else if (i == 4) {
            this.internalReportExecutor.execute(task);
        } else {
            if (i != 5) {
                return;
            }
            this.defaultExecutor.execute(task);
        }
    }

    public final void shutdown() {
        this.internalReportExecutor.shutdownNow();
        this.defaultExecutor.shutdownNow();
        this.errorExecutor.shutdown();
        this.sessionExecutor.shutdown();
        this.ioExecutor.shutdown();
        awaitTerminationSafe(this.errorExecutor);
        awaitTerminationSafe(this.sessionExecutor);
        awaitTerminationSafe(this.ioExecutor);
    }

    public final <R> RunnableProvider<R> provider(TaskType taskType, Function0<? extends R> provider) {
        BackgroundTaskService$provider$task$1 backgroundTaskService$provider$task$1 = new BackgroundTaskService$provider$task$1(provider);
        execute(taskType, backgroundTaskService$provider$task$1);
        return backgroundTaskService$provider$task$1;
    }

    private final void awaitTerminationSafe(ExecutorService executorService) {
        try {
            executorService.awaitTermination(1500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: compiled from: BackgroundTaskService.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\r\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ \u0010\r\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\tH\u0096\u0001J\t\u0010\u0015\u001a\u00020\tH\u0096\u0001R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bugsnag/android/internal/BackgroundTaskService$SafeFuture;", "V", "Ljava/util/concurrent/Future;", "delegate", "Ljava/util/concurrent/FutureTask;", "taskType", "Lcom/bugsnag/android/internal/TaskType;", "(Ljava/util/concurrent/FutureTask;Lcom/bugsnag/android/internal/TaskType;)V", "cancel", "", "p0", "ensureTaskGetSafe", "", "get", "()Ljava/lang/Object;", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "isDone", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class SafeFuture<V> implements Future<V> {
        private final FutureTask<V> delegate;
        private final TaskType taskType;

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean p0) {
            return this.delegate.cancel(p0);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.delegate.isDone();
        }

        public SafeFuture(FutureTask<V> futureTask, TaskType taskType) {
            this.delegate = futureTask;
            this.taskType = taskType;
        }

        @Override // java.util.concurrent.Future
        public V get() {
            ensureTaskGetSafe();
            return this.delegate.get();
        }

        @Override // java.util.concurrent.Future
        public V get(long timeout, TimeUnit unit) {
            ensureTaskGetSafe();
            return this.delegate.get(timeout, unit);
        }

        private final void ensureTaskGetSafe() {
            if (this.delegate.isDone() || BackgroundTaskServiceKt.getTaskType(Thread.currentThread()) != this.taskType) {
                return;
            }
            this.delegate.run();
        }
    }
}
