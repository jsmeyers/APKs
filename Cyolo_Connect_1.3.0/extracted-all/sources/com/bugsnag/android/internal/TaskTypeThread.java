package com.bugsnag.android.internal;

import kotlin.Metadata;

/* JADX INFO: compiled from: BackgroundTaskService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bugsnag/android/internal/TaskTypeThread;", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "name", "", "taskType", "Lcom/bugsnag/android/internal/TaskType;", "(Ljava/lang/Runnable;Ljava/lang/String;Lcom/bugsnag/android/internal/TaskType;)V", "getTaskType", "()Lcom/bugsnag/android/internal/TaskType;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class TaskTypeThread extends Thread {
    private final TaskType taskType;

    public final TaskType getTaskType() {
        return this.taskType;
    }

    public TaskTypeThread(Runnable runnable, String str, TaskType taskType) {
        super(runnable, str);
        this.taskType = taskType;
    }
}
