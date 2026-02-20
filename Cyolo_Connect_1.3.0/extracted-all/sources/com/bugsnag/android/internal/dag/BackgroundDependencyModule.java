package com.bugsnag.android.internal.dag;

import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.BackgroundTaskService$provider$task$1;
import com.bugsnag.android.internal.TaskType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DependencyModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\nH\u0086\bJ@\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\f0\r2\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\t0\u000fH\u0080\b¢\u0006\u0002\b\u0010R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bugsnag/android/internal/dag/BackgroundDependencyModule;", "Lcom/bugsnag/android/internal/dag/DependencyModule;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "taskType", "Lcom/bugsnag/android/internal/TaskType;", "(Lcom/bugsnag/android/internal/BackgroundTaskService;Lcom/bugsnag/android/internal/TaskType;)V", "provider", "Lcom/bugsnag/android/internal/dag/RunnableProvider;", "R", "Lkotlin/Function0;", "map", "E", "Lcom/bugsnag/android/internal/dag/Provider;", "mapping", "Lkotlin/Function1;", "map$bugsnag_android_core_release", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class BackgroundDependencyModule implements DependencyModule {
    public final BackgroundTaskService bgTaskService;
    public final TaskType taskType;

    public BackgroundDependencyModule(BackgroundTaskService backgroundTaskService, TaskType taskType) {
        this.bgTaskService = backgroundTaskService;
        this.taskType = taskType;
    }

    public /* synthetic */ BackgroundDependencyModule(BackgroundTaskService backgroundTaskService, TaskType taskType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backgroundTaskService, (i & 2) != 0 ? TaskType.DEFAULT : taskType);
    }

    public final <R> RunnableProvider<R> provider(Function0<? extends R> provider) {
        BackgroundTaskService backgroundTaskService = this.bgTaskService;
        TaskType taskType = this.taskType;
        BackgroundTaskService$provider$task$1 backgroundTaskService$provider$task$1 = new BackgroundTaskService$provider$task$1(provider);
        backgroundTaskService.execute(taskType, backgroundTaskService$provider$task$1);
        return backgroundTaskService$provider$task$1;
    }

    public final <E, R> RunnableProvider<R> map$bugsnag_android_core_release(final Provider<E> provider, final Function1<? super E, ? extends R> function1) {
        RunnableProvider<R> runnableProvider = new RunnableProvider<R>() { // from class: com.bugsnag.android.internal.dag.BackgroundDependencyModule$map$task$1
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public R invoke() {
                return function1.invoke((E) provider.get());
            }
        };
        this.bgTaskService.execute(this.taskType, runnableProvider);
        return runnableProvider;
    }
}
