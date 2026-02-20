package com.bugsnag.android;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import com.bugsnag.android.DeviceIdStore;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.BackgroundDependencyModule;
import com.bugsnag.android.internal.dag.ConfigModule;
import com.bugsnag.android.internal.dag.ContextModule;
import com.bugsnag.android.internal.dag.Provider;
import com.bugsnag.android.internal.dag.RunnableProvider;
import com.bugsnag.android.internal.dag.SystemServiceModule;
import java.io.File;

/* JADX INFO: compiled from: DataCollectionModule.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0015¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bugsnag/android/DataCollectionModule;", "Lcom/bugsnag/android/internal/dag/BackgroundDependencyModule;", "contextModule", "Lcom/bugsnag/android/internal/dag/ContextModule;", "configModule", "Lcom/bugsnag/android/internal/dag/ConfigModule;", "systemServiceModule", "Lcom/bugsnag/android/internal/dag/SystemServiceModule;", "trackerModule", "Lcom/bugsnag/android/TrackerModule;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "connectivity", "Lcom/bugsnag/android/Connectivity;", "deviceIdStore", "Lcom/bugsnag/android/internal/dag/Provider;", "Lcom/bugsnag/android/DeviceIdStore;", "memoryTrimState", "Lcom/bugsnag/android/MemoryTrimState;", "(Lcom/bugsnag/android/internal/dag/ContextModule;Lcom/bugsnag/android/internal/dag/ConfigModule;Lcom/bugsnag/android/internal/dag/SystemServiceModule;Lcom/bugsnag/android/TrackerModule;Lcom/bugsnag/android/internal/BackgroundTaskService;Lcom/bugsnag/android/Connectivity;Lcom/bugsnag/android/internal/dag/Provider;Lcom/bugsnag/android/MemoryTrimState;)V", "appDataCollector", "Lcom/bugsnag/android/internal/dag/RunnableProvider;", "Lcom/bugsnag/android/AppDataCollector;", "getAppDataCollector", "()Lcom/bugsnag/android/internal/dag/RunnableProvider;", "cfg", "Lcom/bugsnag/android/internal/ImmutableConfig;", "ctx", "Landroid/content/Context;", "dataDir", "Ljava/io/File;", "kotlin.jvm.PlatformType", "deviceBuildInfo", "Lcom/bugsnag/android/DeviceBuildInfo;", "deviceDataCollector", "Lcom/bugsnag/android/DeviceDataCollector;", "getDeviceDataCollector", "logger", "Lcom/bugsnag/android/Logger;", "rootDetection", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DataCollectionModule extends BackgroundDependencyModule {
    private final RunnableProvider<AppDataCollector> appDataCollector;
    private final ImmutableConfig cfg;
    private final Context ctx;
    private final File dataDir;
    private final DeviceBuildInfo deviceBuildInfo;
    private final RunnableProvider<DeviceDataCollector> deviceDataCollector;
    private final Logger logger;
    private final RunnableProvider<Boolean> rootDetection;

    public DataCollectionModule(ContextModule contextModule, ConfigModule configModule, final SystemServiceModule systemServiceModule, final TrackerModule trackerModule, final BackgroundTaskService backgroundTaskService, final Connectivity connectivity, final Provider<DeviceIdStore> provider, final MemoryTrimState memoryTrimState) {
        super(backgroundTaskService, null, 2, null);
        this.ctx = contextModule.getCtx();
        ImmutableConfig config = configModule.getConfig();
        this.cfg = config;
        this.logger = config.getLogger();
        this.deviceBuildInfo = DeviceBuildInfo.INSTANCE.defaultInfo();
        this.dataDir = Environment.getDataDirectory();
        DataCollectionModule dataCollectionModule = this;
        BackgroundTaskService backgroundTaskService2 = dataCollectionModule.bgTaskService;
        TaskType taskType = dataCollectionModule.taskType;
        RunnableProvider<AppDataCollector> runnableProvider = new RunnableProvider<AppDataCollector>() { // from class: com.bugsnag.android.DataCollectionModule$special$$inlined$provider$1
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public AppDataCollector invoke() {
                return new AppDataCollector(this.this$0.ctx, this.this$0.ctx.getPackageManager(), this.this$0.cfg, trackerModule.getSessionTracker(), systemServiceModule.getActivityManager(), trackerModule.getLaunchCrashTracker(), memoryTrimState);
            }
        };
        backgroundTaskService2.execute(taskType, runnableProvider);
        this.appDataCollector = runnableProvider;
        BackgroundTaskService backgroundTaskService3 = dataCollectionModule.bgTaskService;
        TaskType taskType2 = dataCollectionModule.taskType;
        RunnableProvider<Boolean> runnableProvider2 = new RunnableProvider<Boolean>() { // from class: com.bugsnag.android.DataCollectionModule$special$$inlined$provider$2
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public Boolean invoke() {
                return Boolean.valueOf(new RootDetector(this.this$0.deviceBuildInfo, null, null, this.this$0.logger, 6, null).isRooted());
            }
        };
        backgroundTaskService3.execute(taskType2, runnableProvider2);
        this.rootDetection = runnableProvider2;
        BackgroundTaskService backgroundTaskService4 = dataCollectionModule.bgTaskService;
        TaskType taskType3 = dataCollectionModule.taskType;
        RunnableProvider<DeviceDataCollector> runnableProvider3 = new RunnableProvider<DeviceDataCollector>() { // from class: com.bugsnag.android.DataCollectionModule$special$$inlined$provider$3
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public DeviceDataCollector invoke() {
                Connectivity connectivity2 = connectivity;
                Context context = this.ctx;
                Resources resources = this.ctx.getResources();
                DataCollectionModule dataCollectionModule2 = this;
                final Provider provider2 = provider;
                RunnableProvider<DeviceIdStore.DeviceIds> runnableProvider4 = new RunnableProvider<DeviceIdStore.DeviceIds>() { // from class: com.bugsnag.android.DataCollectionModule$deviceDataCollector$lambda-3$$inlined$map$bugsnag_android_core_release$1
                    @Override // com.bugsnag.android.internal.dag.RunnableProvider
                    public DeviceIdStore.DeviceIds invoke() {
                        return ((DeviceIdStore) provider2.get()).load();
                    }
                };
                dataCollectionModule2.bgTaskService.execute(dataCollectionModule2.taskType, runnableProvider4);
                return new DeviceDataCollector(connectivity2, context, resources, runnableProvider4, this.deviceBuildInfo, this.dataDir, this.rootDetection, backgroundTaskService, this.logger);
            }
        };
        backgroundTaskService4.execute(taskType3, runnableProvider3);
        this.deviceDataCollector = runnableProvider3;
    }

    public final RunnableProvider<AppDataCollector> getAppDataCollector() {
        return this.appDataCollector;
    }

    public final RunnableProvider<DeviceDataCollector> getDeviceDataCollector() {
        return this.deviceDataCollector;
    }
}
