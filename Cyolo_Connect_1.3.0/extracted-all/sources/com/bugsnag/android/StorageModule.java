package com.bugsnag.android;

import android.content.Context;
import com.bugsnag.android.DeviceIdStore;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.BugsnagStoreMigrator;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.BackgroundDependencyModule;
import com.bugsnag.android.internal.dag.Provider;
import com.bugsnag.android.internal.dag.RunnableProvider;
import java.io.File;

/* JADX INFO: compiled from: StorageModule.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\r¨\u0006%"}, d2 = {"Lcom/bugsnag/android/StorageModule;", "Lcom/bugsnag/android/internal/dag/BackgroundDependencyModule;", "appContext", "Landroid/content/Context;", "immutableConfig", "Lcom/bugsnag/android/internal/ImmutableConfig;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "(Landroid/content/Context;Lcom/bugsnag/android/internal/ImmutableConfig;Lcom/bugsnag/android/internal/BackgroundTaskService;)V", "bugsnagDir", "Lcom/bugsnag/android/internal/dag/RunnableProvider;", "Ljava/io/File;", "getBugsnagDir", "()Lcom/bugsnag/android/internal/dag/RunnableProvider;", "deviceIdStore", "Lcom/bugsnag/android/DeviceIdStore;", "getDeviceIdStore", "lastRunInfo", "Lcom/bugsnag/android/LastRunInfo;", "getLastRunInfo", "lastRunInfoStore", "Lcom/bugsnag/android/LastRunInfoStore;", "getLastRunInfoStore", "sessionStore", "Lcom/bugsnag/android/SessionStore;", "getSessionStore", "sharedPrefMigrator", "Lcom/bugsnag/android/SharedPrefMigrator;", "getSharedPrefMigrator", "userStore", "Lcom/bugsnag/android/UserStore;", "getUserStore", "loadUser", "Lcom/bugsnag/android/internal/dag/Provider;", "Lcom/bugsnag/android/UserState;", "initialUser", "Lcom/bugsnag/android/User;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StorageModule extends BackgroundDependencyModule {
    private final RunnableProvider<File> bugsnagDir;
    private final RunnableProvider<DeviceIdStore> deviceIdStore;
    private final ImmutableConfig immutableConfig;
    private final RunnableProvider<LastRunInfo> lastRunInfo;
    private final RunnableProvider<LastRunInfoStore> lastRunInfoStore;
    private final RunnableProvider<SessionStore> sessionStore;
    private final RunnableProvider<SharedPrefMigrator> sharedPrefMigrator;
    private final RunnableProvider<UserStore> userStore;

    public StorageModule(final Context context, ImmutableConfig immutableConfig, BackgroundTaskService backgroundTaskService) {
        super(backgroundTaskService, TaskType.IO);
        this.immutableConfig = immutableConfig;
        StorageModule storageModule = this;
        BackgroundTaskService backgroundTaskService2 = storageModule.bgTaskService;
        TaskType taskType = storageModule.taskType;
        RunnableProvider<File> runnableProvider = new RunnableProvider<File>() { // from class: com.bugsnag.android.StorageModule$special$$inlined$provider$1
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public File invoke() {
                return BugsnagStoreMigrator.migrateLegacyFiles(this.this$0.immutableConfig.getPersistenceDirectory());
            }
        };
        backgroundTaskService2.execute(taskType, runnableProvider);
        this.bugsnagDir = runnableProvider;
        BackgroundTaskService backgroundTaskService3 = storageModule.bgTaskService;
        TaskType taskType2 = storageModule.taskType;
        RunnableProvider<SharedPrefMigrator> runnableProvider2 = new RunnableProvider<SharedPrefMigrator>() { // from class: com.bugsnag.android.StorageModule$special$$inlined$provider$2
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public SharedPrefMigrator invoke() {
                return new SharedPrefMigrator(context);
            }
        };
        backgroundTaskService3.execute(taskType2, runnableProvider2);
        this.sharedPrefMigrator = runnableProvider2;
        BackgroundTaskService backgroundTaskService4 = storageModule.bgTaskService;
        TaskType taskType3 = storageModule.taskType;
        RunnableProvider<DeviceIdStore> runnableProvider3 = new RunnableProvider<DeviceIdStore>() { // from class: com.bugsnag.android.StorageModule$special$$inlined$provider$3
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public DeviceIdStore invoke() {
                RunnableProvider<SharedPrefMigrator> sharedPrefMigrator = this.this$0.getSharedPrefMigrator();
                Logger logger = this.this$0.immutableConfig.getLogger();
                return new DeviceIdStore(context, null, null, null, null, sharedPrefMigrator, this.this$0.immutableConfig, logger, 30, null);
            }
        };
        backgroundTaskService4.execute(taskType3, runnableProvider3);
        this.deviceIdStore = runnableProvider3;
        BackgroundTaskService backgroundTaskService5 = storageModule.bgTaskService;
        TaskType taskType4 = storageModule.taskType;
        RunnableProvider<UserStore> runnableProvider4 = new RunnableProvider<UserStore>() { // from class: com.bugsnag.android.StorageModule$special$$inlined$provider$4
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public UserStore invoke() {
                boolean persistUser = this.this$0.immutableConfig.getPersistUser();
                RunnableProvider<File> bugsnagDir = this.this$0.getBugsnagDir();
                StorageModule storageModule2 = this.this$0;
                StorageModule storageModule3 = storageModule2;
                final RunnableProvider<DeviceIdStore> deviceIdStore = storageModule2.getDeviceIdStore();
                RunnableProvider<DeviceIdStore.DeviceIds> runnableProvider5 = new RunnableProvider<DeviceIdStore.DeviceIds>() { // from class: com.bugsnag.android.StorageModule$userStore$lambda-4$$inlined$map$bugsnag_android_core_release$1
                    @Override // com.bugsnag.android.internal.dag.RunnableProvider
                    public DeviceIdStore.DeviceIds invoke() {
                        return ((DeviceIdStore) deviceIdStore.get()).load();
                    }
                };
                storageModule3.bgTaskService.execute(storageModule3.taskType, runnableProvider5);
                return new UserStore(persistUser, bugsnagDir, runnableProvider5, null, this.this$0.getSharedPrefMigrator(), this.this$0.immutableConfig.getLogger(), 8, null);
            }
        };
        backgroundTaskService5.execute(taskType4, runnableProvider4);
        this.userStore = runnableProvider4;
        BackgroundTaskService backgroundTaskService6 = storageModule.bgTaskService;
        TaskType taskType5 = storageModule.taskType;
        RunnableProvider<LastRunInfoStore> runnableProvider5 = new RunnableProvider<LastRunInfoStore>() { // from class: com.bugsnag.android.StorageModule$special$$inlined$provider$5
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public LastRunInfoStore invoke() {
                return new LastRunInfoStore(this.this$0.immutableConfig);
            }
        };
        backgroundTaskService6.execute(taskType5, runnableProvider5);
        RunnableProvider<LastRunInfoStore> runnableProvider6 = runnableProvider5;
        this.lastRunInfoStore = runnableProvider6;
        BackgroundTaskService backgroundTaskService7 = storageModule.bgTaskService;
        TaskType taskType6 = storageModule.taskType;
        RunnableProvider<SessionStore> runnableProvider7 = new RunnableProvider<SessionStore>() { // from class: com.bugsnag.android.StorageModule$special$$inlined$provider$6
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public SessionStore invoke() {
                return new SessionStore(this.this$0.getBugsnagDir().get(), this.this$0.immutableConfig.getMaxPersistedSessions(), this.this$0.immutableConfig.getApiKey(), this.this$0.immutableConfig.getLogger(), null);
            }
        };
        backgroundTaskService7.execute(taskType6, runnableProvider7);
        this.sessionStore = runnableProvider7;
        final RunnableProvider<LastRunInfoStore> runnableProvider8 = runnableProvider6;
        RunnableProvider<LastRunInfo> runnableProvider9 = new RunnableProvider<LastRunInfo>() { // from class: com.bugsnag.android.StorageModule$special$$inlined$map$bugsnag_android_core_release$1
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public LastRunInfo invoke() {
                LastRunInfoStore lastRunInfoStore = (LastRunInfoStore) runnableProvider8.get();
                LastRunInfo lastRunInfoLoad = lastRunInfoStore.load();
                lastRunInfoStore.persist(new LastRunInfo(0, false, false));
                return lastRunInfoLoad;
            }
        };
        storageModule.bgTaskService.execute(storageModule.taskType, runnableProvider9);
        this.lastRunInfo = runnableProvider9;
    }

    public final RunnableProvider<File> getBugsnagDir() {
        return this.bugsnagDir;
    }

    public final RunnableProvider<SharedPrefMigrator> getSharedPrefMigrator() {
        return this.sharedPrefMigrator;
    }

    public final RunnableProvider<DeviceIdStore> getDeviceIdStore() {
        return this.deviceIdStore;
    }

    public final RunnableProvider<UserStore> getUserStore() {
        return this.userStore;
    }

    public final RunnableProvider<LastRunInfoStore> getLastRunInfoStore() {
        return this.lastRunInfoStore;
    }

    public final RunnableProvider<SessionStore> getSessionStore() {
        return this.sessionStore;
    }

    public final RunnableProvider<LastRunInfo> getLastRunInfo() {
        return this.lastRunInfo;
    }

    public final Provider<UserState> loadUser(final User initialUser) {
        StorageModule storageModule = this;
        BackgroundTaskService backgroundTaskService = storageModule.bgTaskService;
        TaskType taskType = storageModule.taskType;
        RunnableProvider<UserState> runnableProvider = new RunnableProvider<UserState>() { // from class: com.bugsnag.android.StorageModule$loadUser$$inlined$provider$1
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public UserState invoke() {
                UserState userStateLoad = this.this$0.getUserStore().get().load(initialUser);
                SharedPrefMigrator orNull = this.this$0.getSharedPrefMigrator().getOrNull();
                if (orNull != null) {
                    orNull.deleteLegacyPrefs();
                }
                return userStateLoad;
            }
        };
        backgroundTaskService.execute(taskType, runnableProvider);
        return runnableProvider;
    }
}
