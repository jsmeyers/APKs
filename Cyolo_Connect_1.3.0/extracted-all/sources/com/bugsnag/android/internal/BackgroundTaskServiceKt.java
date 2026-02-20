package com.bugsnag.android.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: BackgroundTaskService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"KEEP_ALIVE_SECS", "", "SHUTDOWN_WAIT_MS", "TASK_QUEUE_SIZE", "", "THREAD_POOL_SIZE", "taskType", "Lcom/bugsnag/android/internal/TaskType;", "Ljava/lang/Thread;", "getTaskType", "(Ljava/lang/Thread;)Lcom/bugsnag/android/internal/TaskType;", "createExecutor", "Ljava/util/concurrent/ExecutorService;", "name", "", "type", "keepAlive", "", "bugsnag-android-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BackgroundTaskServiceKt {
    private static final long KEEP_ALIVE_SECS = 30;
    private static final long SHUTDOWN_WAIT_MS = 1500;
    private static final int TASK_QUEUE_SIZE = 128;
    private static final int THREAD_POOL_SIZE = 1;

    public static final TaskType getTaskType(Thread thread) {
        TaskTypeThread taskTypeThread = thread instanceof TaskTypeThread ? (TaskTypeThread) thread : null;
        if (taskTypeThread == null) {
            return null;
        }
        return taskTypeThread.getTaskType();
    }

    public static final ExecutorService createExecutor(final String str, final TaskType taskType, boolean z) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.bugsnag.android.internal.BackgroundTaskServiceKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return BackgroundTaskServiceKt.m257createExecutor$lambda0(str, taskType, runnable);
            }
        };
        return new ThreadPoolExecutor(z ? 1 : 0, 1, KEEP_ALIVE_SECS, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createExecutor$lambda-0, reason: not valid java name */
    public static final Thread m257createExecutor$lambda0(String str, TaskType taskType, Runnable runnable) {
        return new TaskTypeThread(runnable, str, taskType);
    }
}
