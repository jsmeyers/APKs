package com.bugsnag.android;

import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.BackgroundDependencyModule;
import com.bugsnag.android.internal.dag.ConfigModule;
import com.bugsnag.android.internal.dag.ContextModule;
import com.bugsnag.android.internal.dag.RunnableProvider;
import com.bugsnag.android.internal.dag.SystemServiceModule;

/* JADX INFO: compiled from: EventStorageModule.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bugsnag/android/EventStorageModule;", "Lcom/bugsnag/android/internal/dag/BackgroundDependencyModule;", "contextModule", "Lcom/bugsnag/android/internal/dag/ContextModule;", "configModule", "Lcom/bugsnag/android/internal/dag/ConfigModule;", "dataCollectionModule", "Lcom/bugsnag/android/DataCollectionModule;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "trackerModule", "Lcom/bugsnag/android/TrackerModule;", "systemServiceModule", "Lcom/bugsnag/android/internal/dag/SystemServiceModule;", "notifier", "Lcom/bugsnag/android/Notifier;", "callbackState", "Lcom/bugsnag/android/CallbackState;", "(Lcom/bugsnag/android/internal/dag/ContextModule;Lcom/bugsnag/android/internal/dag/ConfigModule;Lcom/bugsnag/android/DataCollectionModule;Lcom/bugsnag/android/internal/BackgroundTaskService;Lcom/bugsnag/android/TrackerModule;Lcom/bugsnag/android/internal/dag/SystemServiceModule;Lcom/bugsnag/android/Notifier;Lcom/bugsnag/android/CallbackState;)V", "cfg", "Lcom/bugsnag/android/internal/ImmutableConfig;", "delegate", "Lcom/bugsnag/android/internal/dag/RunnableProvider;", "Lcom/bugsnag/android/InternalReportDelegate;", "eventStore", "Lcom/bugsnag/android/EventStore;", "getEventStore", "()Lcom/bugsnag/android/internal/dag/RunnableProvider;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventStorageModule extends BackgroundDependencyModule {
    private final ImmutableConfig cfg;
    private final RunnableProvider<InternalReportDelegate> delegate;
    private final RunnableProvider<EventStore> eventStore;

    public EventStorageModule(final ContextModule contextModule, ConfigModule configModule, final DataCollectionModule dataCollectionModule, final BackgroundTaskService backgroundTaskService, final TrackerModule trackerModule, final SystemServiceModule systemServiceModule, final Notifier notifier, final CallbackState callbackState) {
        super(backgroundTaskService, null, 2, null);
        this.cfg = configModule.getConfig();
        EventStorageModule eventStorageModule = this;
        BackgroundTaskService backgroundTaskService2 = eventStorageModule.bgTaskService;
        TaskType taskType = eventStorageModule.taskType;
        RunnableProvider<InternalReportDelegate> runnableProvider = new RunnableProvider<InternalReportDelegate>() { // from class: com.bugsnag.android.EventStorageModule$special$$inlined$provider$1
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public InternalReportDelegate invoke() {
                if (this.this$0.cfg.getTelemetry().contains(Telemetry.INTERNAL_ERRORS)) {
                    return new InternalReportDelegate(contextModule.getCtx(), this.this$0.cfg.getLogger(), this.this$0.cfg, systemServiceModule.getStorageManager(), dataCollectionModule.getAppDataCollector(), dataCollectionModule.getDeviceDataCollector(), trackerModule.getSessionTracker(), notifier, backgroundTaskService);
                }
                return null;
            }
        };
        backgroundTaskService2.execute(taskType, runnableProvider);
        this.delegate = runnableProvider;
        BackgroundTaskService backgroundTaskService3 = eventStorageModule.bgTaskService;
        TaskType taskType2 = eventStorageModule.taskType;
        RunnableProvider<EventStore> runnableProvider2 = new RunnableProvider<EventStore>() { // from class: com.bugsnag.android.EventStorageModule$special$$inlined$provider$2
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public EventStore invoke() {
                return new EventStore(this.this$0.cfg, this.this$0.cfg.getLogger(), notifier, backgroundTaskService, this.this$0.delegate, callbackState);
            }
        };
        backgroundTaskService3.execute(taskType2, runnableProvider2);
        this.eventStore = runnableProvider2;
    }

    public final RunnableProvider<EventStore> getEventStore() {
        return this.eventStore;
    }
}
