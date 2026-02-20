package com.bugsnag.android;

import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.BackgroundDependencyModule;
import com.bugsnag.android.internal.dag.ConfigModule;
import com.bugsnag.android.internal.dag.RunnableProvider;

/* JADX INFO: compiled from: TrackerModule.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bugsnag/android/TrackerModule;", "Lcom/bugsnag/android/internal/dag/BackgroundDependencyModule;", "configModule", "Lcom/bugsnag/android/internal/dag/ConfigModule;", "storageModule", "Lcom/bugsnag/android/StorageModule;", "client", "Lcom/bugsnag/android/Client;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "callbackState", "Lcom/bugsnag/android/CallbackState;", "(Lcom/bugsnag/android/internal/dag/ConfigModule;Lcom/bugsnag/android/StorageModule;Lcom/bugsnag/android/Client;Lcom/bugsnag/android/internal/BackgroundTaskService;Lcom/bugsnag/android/CallbackState;)V", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "launchCrashTracker", "Lcom/bugsnag/android/LaunchCrashTracker;", "getLaunchCrashTracker", "()Lcom/bugsnag/android/LaunchCrashTracker;", "sessionTracker", "Lcom/bugsnag/android/internal/dag/RunnableProvider;", "Lcom/bugsnag/android/SessionTracker;", "getSessionTracker", "()Lcom/bugsnag/android/internal/dag/RunnableProvider;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrackerModule extends BackgroundDependencyModule {
    private final ImmutableConfig config;
    private final LaunchCrashTracker launchCrashTracker;
    private final RunnableProvider<SessionTracker> sessionTracker;

    public TrackerModule(ConfigModule configModule, final StorageModule storageModule, final Client client, final BackgroundTaskService backgroundTaskService, final CallbackState callbackState) {
        super(backgroundTaskService, null, 2, null);
        ImmutableConfig config = configModule.getConfig();
        this.config = config;
        this.launchCrashTracker = new LaunchCrashTracker(config, null, 2, null);
        TrackerModule trackerModule = this;
        BackgroundTaskService backgroundTaskService2 = trackerModule.bgTaskService;
        TaskType taskType = trackerModule.taskType;
        RunnableProvider<SessionTracker> runnableProvider = new RunnableProvider<SessionTracker>() { // from class: com.bugsnag.android.TrackerModule$special$$inlined$provider$1
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public SessionTracker invoke() {
                client.getConfig();
                return new SessionTracker(this.config, callbackState, client, storageModule.getSessionStore(), this.config.getLogger(), backgroundTaskService);
            }
        };
        backgroundTaskService2.execute(taskType, runnableProvider);
        this.sessionTracker = runnableProvider;
    }

    public final LaunchCrashTracker getLaunchCrashTracker() {
        return this.launchCrashTracker;
    }

    public final RunnableProvider<SessionTracker> getSessionTracker() {
        return this.sessionTracker;
    }
}
