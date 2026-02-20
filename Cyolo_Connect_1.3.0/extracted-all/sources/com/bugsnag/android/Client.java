package com.bugsnag.android;

import android.app.Application;
import android.content.Context;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.ForegroundDetector;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.InternalMetrics;
import com.bugsnag.android.internal.InternalMetricsImpl;
import com.bugsnag.android.internal.InternalMetricsNoop;
import com.bugsnag.android.internal.StateObserver;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.ConfigModule;
import com.bugsnag.android.internal.dag.ContextModule;
import com.bugsnag.android.internal.dag.Provider;
import com.bugsnag.android.internal.dag.RunnableProvider;
import com.bugsnag.android.internal.dag.SystemServiceModule;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public class Client implements MetadataAware, CallbackAware, UserAware, FeatureFlagAware {
    final Context appContext;
    final AppDataCollector appDataCollector;
    final BackgroundTaskService bgTaskService;
    final BreadcrumbState breadcrumbState;
    private final CallbackState callbackState;
    final ClientObservable clientObservable;
    private final Map<String, Object> configDifferences;
    final Connectivity connectivity;
    private final ContextState contextState;
    final DeliveryDelegate deliveryDelegate;
    final DeviceDataCollector deviceDataCollector;
    private final Provider<EventStore> eventStore;
    private final ExceptionHandler exceptionHandler;
    final FeatureFlagState featureFlagState;
    final ImmutableConfig immutableConfig;
    private final InternalMetrics internalMetrics;
    final LastRunInfo lastRunInfo;
    final LastRunInfoStore lastRunInfoStore;
    final LaunchCrashTracker launchCrashTracker;
    final Logger logger;
    final MemoryTrimState memoryTrimState;
    final MetadataState metadataState;
    final Notifier notifier;
    PluginClient pluginClient;
    final SessionTracker sessionTracker;
    final SystemBroadcastReceiver systemBroadcastReceiver;
    private final Provider<UserState> userState;

    public Client(Context context) {
        this(context, Configuration.load(context));
    }

    public Client(Context context, String str) {
        this(context, Configuration.load(context, str));
    }

    public Client(Context context, Configuration configuration) {
        MemoryTrimState memoryTrimState = new MemoryTrimState();
        this.memoryTrimState = memoryTrimState;
        BackgroundTaskService backgroundTaskService = new BackgroundTaskService();
        this.bgTaskService = backgroundTaskService;
        ContextModule contextModule = new ContextModule(context, backgroundTaskService);
        Context ctx = contextModule.getCtx();
        this.appContext = ctx;
        Notifier notifier = configuration.getNotifier();
        this.notifier = notifier;
        ConnectivityCompat connectivityCompat = new ConnectivityCompat(ctx, new Function2<Boolean, String, Unit>() { // from class: com.bugsnag.android.Client.1
            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Boolean bool, String str) {
                HashMap map = new HashMap();
                map.put("hasConnection", bool);
                map.put("networkState", str);
                Client.this.leaveAutoBreadcrumb("Connectivity changed", BreadcrumbType.STATE, map);
                if (!bool.booleanValue()) {
                    return null;
                }
                Client.this.getEventStore().flushAsync();
                Client.this.sessionTracker.flushAsync();
                return null;
            }
        });
        this.connectivity = connectivityCompat;
        ConfigModule configModule = new ConfigModule(contextModule, configuration, connectivityCompat, backgroundTaskService);
        ImmutableConfig config = configModule.getConfig();
        this.immutableConfig = config;
        Logger logger = config.getLogger();
        this.logger = logger;
        if (!(context instanceof Application)) {
            logger.w("You should initialize Bugsnag from the onCreate() callback of your Application subclass, as this guarantees errors are captured as early as possible. If a custom Application subclass is not possible in your app then you should suppress this warning by passing the Application context instead: Bugsnag.start(context.getApplicationContext()). For further info see: https://docs.bugsnag.com/platforms/android/#basic-configuration");
        }
        StorageModule storageModule = new StorageModule(ctx, config, backgroundTaskService);
        BugsnagStateModule bugsnagStateModule = new BugsnagStateModule(config, configuration);
        this.clientObservable = bugsnagStateModule.getClientObservable();
        CallbackState callbackState = bugsnagStateModule.getCallbackState();
        this.callbackState = callbackState;
        this.breadcrumbState = bugsnagStateModule.getBreadcrumbState();
        this.contextState = bugsnagStateModule.getContextState();
        this.metadataState = bugsnagStateModule.getMetadataState();
        this.featureFlagState = bugsnagStateModule.getFeatureFlagState();
        SystemServiceModule systemServiceModule = new SystemServiceModule(contextModule, backgroundTaskService);
        TrackerModule trackerModule = new TrackerModule(configModule, storageModule, this, backgroundTaskService, callbackState);
        DataCollectionModule dataCollectionModule = new DataCollectionModule(contextModule, configModule, systemServiceModule, trackerModule, backgroundTaskService, connectivityCompat, storageModule.getDeviceIdStore(), memoryTrimState);
        this.userState = storageModule.loadUser(configuration.getUser());
        RunnableProvider<EventStore> eventStore = new EventStorageModule(contextModule, configModule, dataCollectionModule, backgroundTaskService, trackerModule, systemServiceModule, notifier, callbackState).getEventStore();
        this.eventStore = eventStore;
        this.deliveryDelegate = new DeliveryDelegate(logger, eventStore, config, callbackState, notifier, backgroundTaskService);
        this.exceptionHandler = new ExceptionHandler(this, logger);
        this.lastRunInfoStore = storageModule.getLastRunInfoStore().getOrNull();
        this.lastRunInfo = storageModule.getLastRunInfo().getOrNull();
        this.launchCrashTracker = trackerModule.getLaunchCrashTracker();
        this.sessionTracker = trackerModule.getSessionTracker().get();
        this.appDataCollector = dataCollectionModule.getAppDataCollector().get();
        this.deviceDataCollector = dataCollectionModule.getDeviceDataCollector().get();
        this.pluginClient = new PluginClient(configuration.getPlugins(), config, logger);
        if (configuration.getTelemetry().contains(Telemetry.USAGE)) {
            this.internalMetrics = new InternalMetricsImpl();
        } else {
            this.internalMetrics = new InternalMetricsNoop();
        }
        this.configDifferences = configuration.impl.getConfigDifferences();
        this.systemBroadcastReceiver = new SystemBroadcastReceiver(this, logger);
        start();
    }

    Client(ImmutableConfig immutableConfig, MetadataState metadataState, ContextState contextState, CallbackState callbackState, Provider<UserState> provider, FeatureFlagState featureFlagState, ClientObservable clientObservable, Context context, DeviceDataCollector deviceDataCollector, AppDataCollector appDataCollector, BreadcrumbState breadcrumbState, Provider<EventStore> provider2, SystemBroadcastReceiver systemBroadcastReceiver, SessionTracker sessionTracker, Connectivity connectivity, Logger logger, DeliveryDelegate deliveryDelegate, LastRunInfoStore lastRunInfoStore, LaunchCrashTracker launchCrashTracker, ExceptionHandler exceptionHandler, Notifier notifier) {
        this.memoryTrimState = new MemoryTrimState();
        this.bgTaskService = new BackgroundTaskService();
        this.immutableConfig = immutableConfig;
        this.metadataState = metadataState;
        this.contextState = contextState;
        this.callbackState = callbackState;
        this.userState = provider;
        this.featureFlagState = featureFlagState;
        this.clientObservable = clientObservable;
        this.appContext = context;
        this.deviceDataCollector = deviceDataCollector;
        this.appDataCollector = appDataCollector;
        this.breadcrumbState = breadcrumbState;
        this.eventStore = provider2;
        this.systemBroadcastReceiver = systemBroadcastReceiver;
        this.sessionTracker = sessionTracker;
        this.connectivity = connectivity;
        this.logger = logger;
        this.deliveryDelegate = deliveryDelegate;
        this.lastRunInfoStore = lastRunInfoStore;
        this.launchCrashTracker = launchCrashTracker;
        this.lastRunInfo = null;
        this.exceptionHandler = exceptionHandler;
        this.notifier = notifier;
        this.internalMetrics = new InternalMetricsNoop();
        this.configDifferences = new HashMap();
    }

    private void start() {
        if (this.immutableConfig.getEnabledErrorTypes().getUnhandledExceptions()) {
            this.exceptionHandler.install();
        }
        NativeInterface.setClient(this);
        this.pluginClient.loadPlugins(this);
        NdkPluginCaller.INSTANCE.setNdkPlugin(this.pluginClient.getNdkPlugin());
        if (this.immutableConfig.getTelemetry().contains(Telemetry.USAGE)) {
            NdkPluginCaller.INSTANCE.setInternalMetricsEnabled(true);
        }
        this.eventStore.get().flushOnLaunch();
        this.eventStore.get().flushAsync();
        this.sessionTracker.flushAsync();
        this.internalMetrics.setConfigDifferences(this.configDifferences);
        this.callbackState.setInternalMetrics(this.internalMetrics);
        registerLifecycleCallbacks();
        registerComponentCallbacks();
        registerListenersInBackground();
        leaveAutoBreadcrumb("Bugsnag loaded", BreadcrumbType.STATE, new HashMap());
        this.logger.d("Bugsnag loaded");
    }

    void registerLifecycleCallbacks() {
        Context context = this.appContext;
        if (context instanceof Application) {
            Application application = (Application) context;
            ForegroundDetector.registerOn(application);
            ForegroundDetector.registerActivityCallbacks(this.sessionTracker);
            if (this.immutableConfig.shouldDiscardBreadcrumb(BreadcrumbType.STATE)) {
                return;
            }
            application.registerActivityLifecycleCallbacks(new ActivityBreadcrumbCollector(new Function2<String, Map<String, ? extends Object>, Unit>() { // from class: com.bugsnag.android.Client.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, Map<String, ? extends Object> map) {
                    return invoke2(str, (Map<String, ?>) map);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public Unit invoke2(String str, Map<String, ?> map) {
                    Client.this.leaveBreadcrumb(str, map, BreadcrumbType.STATE);
                    return null;
                }
            }));
        }
    }

    void registerListenersInBackground() {
        try {
            this.bgTaskService.submitTask(TaskType.DEFAULT, new Runnable() { // from class: com.bugsnag.android.Client.3
                @Override // java.lang.Runnable
                public void run() {
                    Client.this.connectivity.registerForNetworkChanges();
                    SystemBroadcastReceiver.register(Client.this.appContext, Client.this.systemBroadcastReceiver, Client.this.logger);
                }
            });
        } catch (RejectedExecutionException e) {
            this.logger.w("Failed to register for system events", e);
        }
    }

    private void persistRunInfo(final LastRunInfo lastRunInfo) {
        try {
            this.bgTaskService.submitTask(TaskType.IO, new Runnable() { // from class: com.bugsnag.android.Client.4
                @Override // java.lang.Runnable
                public void run() {
                    Client.this.lastRunInfoStore.persist(lastRunInfo);
                }
            });
        } catch (RejectedExecutionException e) {
            this.logger.w("Failed to persist last run info", e);
        }
    }

    private void logNull(String str) {
        this.logger.e("Invalid null value supplied to client." + str + ", ignoring");
    }

    private void registerComponentCallbacks() {
        this.appContext.registerComponentCallbacks(new ClientComponentCallbacks(this.deviceDataCollector, new Function2<String, String, Unit>() { // from class: com.bugsnag.android.Client.5
            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(String str, String str2) {
                HashMap map = new HashMap();
                map.put(Constants.MessagePayloadKeys.FROM, str);
                map.put("to", str2);
                Client.this.leaveAutoBreadcrumb("Orientation changed", BreadcrumbType.STATE, map);
                Client.this.clientObservable.postOrientationChange(str2);
                return null;
            }
        }, new Function2<Boolean, Integer, Unit>() { // from class: com.bugsnag.android.Client.6
            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Boolean bool, Integer num) {
                Client.this.memoryTrimState.setLowMemory(Boolean.TRUE.equals(bool));
                if (Client.this.memoryTrimState.updateMemoryTrimLevel(num)) {
                    Client.this.leaveAutoBreadcrumb("Trim Memory", BreadcrumbType.STATE, Collections.singletonMap("trimLevel", Client.this.memoryTrimState.getTrimLevelDescription()));
                }
                Client.this.memoryTrimState.emitObservableEvent();
                return null;
            }
        }));
    }

    void setupNdkPlugin() {
        if (!setupNdkDirectory()) {
            this.logger.w("Failed to setup NDK directory.");
            return;
        }
        String absolutePath = this.lastRunInfoStore.getFile().getAbsolutePath();
        LastRunInfo lastRunInfo = this.lastRunInfo;
        this.clientObservable.postNdkInstall(this.immutableConfig, absolutePath, lastRunInfo != null ? lastRunInfo.getConsecutiveLaunchCrashes() : 0);
        syncInitialState();
        this.clientObservable.postNdkDeliverPending();
    }

    private boolean setupNdkDirectory() {
        try {
            return ((Boolean) this.bgTaskService.submitTask(TaskType.IO, new Callable<Boolean>() { // from class: com.bugsnag.android.Client.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() {
                    File nativeReportPath = NativeInterface.getNativeReportPath();
                    return Boolean.valueOf(nativeReportPath.exists() || nativeReportPath.mkdirs());
                }
            }).get()).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    void addObserver(StateObserver stateObserver) {
        this.metadataState.addObserver(stateObserver);
        this.breadcrumbState.addObserver(stateObserver);
        this.sessionTracker.addObserver(stateObserver);
        this.clientObservable.addObserver(stateObserver);
        this.userState.get().addObserver(stateObserver);
        this.contextState.addObserver(stateObserver);
        this.deliveryDelegate.addObserver(stateObserver);
        this.launchCrashTracker.addObserver(stateObserver);
        this.memoryTrimState.addObserver(stateObserver);
        this.featureFlagState.addObserver(stateObserver);
    }

    void removeObserver(StateObserver stateObserver) {
        this.metadataState.removeObserver(stateObserver);
        this.breadcrumbState.removeObserver(stateObserver);
        this.sessionTracker.removeObserver(stateObserver);
        this.clientObservable.removeObserver(stateObserver);
        this.userState.get().removeObserver(stateObserver);
        this.contextState.removeObserver(stateObserver);
        this.deliveryDelegate.removeObserver(stateObserver);
        this.launchCrashTracker.removeObserver(stateObserver);
        this.memoryTrimState.removeObserver(stateObserver);
        this.featureFlagState.removeObserver(stateObserver);
    }

    void syncInitialState() {
        this.metadataState.emitObservableEvent();
        this.contextState.emitObservableEvent();
        this.userState.get().emitObservableEvent();
        this.memoryTrimState.emitObservableEvent();
        this.featureFlagState.emitObservableEvent();
    }

    public void startSession() {
        this.sessionTracker.startSession(false);
    }

    public void pauseSession() {
        this.sessionTracker.pauseSession();
    }

    public boolean resumeSession() {
        return this.sessionTracker.resumeSession();
    }

    public String getContext() {
        return this.contextState.getContext();
    }

    public void setContext(String str) {
        this.contextState.setManualContext(str);
    }

    @Override // com.bugsnag.android.UserAware
    public void setUser(String str, String str2, String str3) {
        this.userState.get().setUser(new User(str, str2, str3));
    }

    @Override // com.bugsnag.android.UserAware
    public User getUser() {
        return this.userState.get().getUser();
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnError(OnErrorCallback onErrorCallback) {
        if (onErrorCallback != null) {
            this.callbackState.addOnError(onErrorCallback);
        } else {
            logNull("addOnError");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnError(OnErrorCallback onErrorCallback) {
        if (onErrorCallback != null) {
            this.callbackState.removeOnError(onErrorCallback);
        } else {
            logNull("removeOnError");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnBreadcrumb(OnBreadcrumbCallback onBreadcrumbCallback) {
        if (onBreadcrumbCallback != null) {
            this.callbackState.addOnBreadcrumb(onBreadcrumbCallback);
        } else {
            logNull("addOnBreadcrumb");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnBreadcrumb(OnBreadcrumbCallback onBreadcrumbCallback) {
        if (onBreadcrumbCallback != null) {
            this.callbackState.removeOnBreadcrumb(onBreadcrumbCallback);
        } else {
            logNull("removeOnBreadcrumb");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnSession(OnSessionCallback onSessionCallback) {
        if (onSessionCallback != null) {
            this.callbackState.addOnSession(onSessionCallback);
        } else {
            logNull("addOnSession");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnSession(OnSessionCallback onSessionCallback) {
        if (onSessionCallback != null) {
            this.callbackState.removeOnSession(onSessionCallback);
        } else {
            logNull("removeOnSession");
        }
    }

    public void notify(Throwable th) {
        notify(th, null);
    }

    public void notify(Throwable th, OnErrorCallback onErrorCallback) {
        if (th != null) {
            if (this.immutableConfig.shouldDiscardError(th)) {
                return;
            }
            populateAndNotifyAndroidEvent(new Event(th, this.immutableConfig, SeverityReason.newInstance("handledException"), this.metadataState.getMetadata(), this.featureFlagState.getFeatureFlags(), this.logger), onErrorCallback);
            return;
        }
        logNull("notify");
    }

    void notifyUnhandledException(Throwable th, Metadata metadata, String str, String str2) {
        populateAndNotifyAndroidEvent(new Event(th, this.immutableConfig, SeverityReason.newInstance(str, Severity.ERROR, str2), Metadata.INSTANCE.merge(this.metadataState.getMetadata(), metadata), this.featureFlagState.getFeatureFlags(), this.logger), null);
        LastRunInfo lastRunInfo = this.lastRunInfo;
        int consecutiveLaunchCrashes = lastRunInfo != null ? lastRunInfo.getConsecutiveLaunchCrashes() : 0;
        boolean zIsLaunching = this.launchCrashTracker.isLaunching();
        if (zIsLaunching) {
            consecutiveLaunchCrashes++;
        }
        persistRunInfo(new LastRunInfo(consecutiveLaunchCrashes, true, zIsLaunching));
        this.bgTaskService.shutdown();
    }

    void populateAndNotifyAndroidEvent(Event event, OnErrorCallback onErrorCallback) {
        event.setDevice(this.deviceDataCollector.generateDeviceWithState(new Date().getTime()));
        event.addMetadata("device", this.deviceDataCollector.getDeviceMetadata());
        event.setApp(this.appDataCollector.generateAppWithState());
        event.addMetadata("app", this.appDataCollector.getAppDataMetadata());
        event.setBreadcrumbs(this.breadcrumbState.copy());
        User user = this.userState.get().getUser();
        event.setUser(user.getId(), user.getEmail(), user.getName());
        event.setContext(this.contextState.getContext());
        event.setInternalMetrics(this.internalMetrics);
        notifyInternal(event, onErrorCallback);
    }

    void notifyInternal(Event event, OnErrorCallback onErrorCallback) {
        event.setRedactedKeys(this.metadataState.getMetadata().getRedactedKeys());
        Session currentSession = this.sessionTracker.getCurrentSession();
        if (currentSession != null && (this.immutableConfig.getAutoTrackSessions() || !currentSession.isAutoCaptured())) {
            event.setSession(currentSession);
        }
        if (!this.callbackState.runOnErrorTasks(event, this.logger) || (onErrorCallback != null && !onErrorCallback.onError(event))) {
            this.logger.d("Skipping notification - onError task returned false");
        } else {
            leaveErrorBreadcrumb(event);
            this.deliveryDelegate.deliver(event);
        }
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbState.copy();
    }

    AppDataCollector getAppDataCollector() {
        return this.appDataCollector;
    }

    DeviceDataCollector getDeviceDataCollector() {
        return this.deviceDataCollector;
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String str, Map<String, ?> map) {
        if (str != null && map != null) {
            this.metadataState.addMetadata(str, map);
        } else {
            logNull("addMetadata");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String str, String str2, Object obj) {
        if (str != null && str2 != null) {
            this.metadataState.addMetadata(str, str2, obj);
        } else {
            logNull("addMetadata");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String str) {
        if (str != null) {
            this.metadataState.clearMetadata(str);
        } else {
            logNull("clearMetadata");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String str, String str2) {
        if (str != null && str2 != null) {
            this.metadataState.clearMetadata(str, str2);
        } else {
            logNull("clearMetadata");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public Map<String, Object> getMetadata(String str) {
        if (str != null) {
            return this.metadataState.getMetadata(str);
        }
        logNull("getMetadata");
        return null;
    }

    @Override // com.bugsnag.android.MetadataAware
    public Object getMetadata(String str, String str2) {
        if (str != null && str2 != null) {
            return this.metadataState.getMetadata(str, str2);
        }
        logNull("getMetadata");
        return null;
    }

    Map<String, Object> getMetadata() {
        return this.metadataState.getMetadata().toMap();
    }

    public void leaveBreadcrumb(String str) {
        if (str != null) {
            this.breadcrumbState.add(new Breadcrumb(str, this.logger));
        } else {
            logNull("leaveBreadcrumb");
        }
    }

    public void leaveBreadcrumb(String str, Map<String, Object> map, BreadcrumbType breadcrumbType) {
        if (str != null && breadcrumbType != null) {
            this.breadcrumbState.add(new Breadcrumb(str, breadcrumbType, map, new Date(), this.logger));
        } else {
            logNull("leaveBreadcrumb");
        }
    }

    void leaveAutoBreadcrumb(String str, BreadcrumbType breadcrumbType, Map<String, Object> map) {
        if (this.immutableConfig.shouldDiscardBreadcrumb(breadcrumbType)) {
            return;
        }
        this.breadcrumbState.add(new Breadcrumb(str, breadcrumbType, map, new Date(), this.logger));
    }

    private void leaveErrorBreadcrumb(Event event) {
        List<Error> errors = event.getErrors();
        if (errors.size() > 0) {
            String errorClass = errors.get(0).getErrorClass();
            String errorMessage = errors.get(0).getErrorMessage();
            HashMap map = new HashMap();
            map.put("errorClass", errorClass);
            map.put("message", errorMessage);
            map.put("unhandled", String.valueOf(event.isUnhandled()));
            map.put("severity", event.getSeverity().toString());
            this.breadcrumbState.add(new Breadcrumb(errorClass, BreadcrumbType.ERROR, map, new Date(), this.logger));
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String str) {
        if (str != null) {
            this.featureFlagState.addFeatureFlag(str);
        } else {
            logNull("addFeatureFlag");
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String str, String str2) {
        if (str != null) {
            this.featureFlagState.addFeatureFlag(str, str2);
        } else {
            logNull("addFeatureFlag");
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlags(Iterable<FeatureFlag> iterable) {
        if (iterable != null) {
            this.featureFlagState.addFeatureFlags(iterable);
        } else {
            logNull("addFeatureFlags");
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlag(String str) {
        if (str != null) {
            this.featureFlagState.clearFeatureFlag(str);
        } else {
            logNull("clearFeatureFlag");
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlags() {
        this.featureFlagState.clearFeatureFlags();
    }

    public LastRunInfo getLastRunInfo() {
        return this.lastRunInfo;
    }

    public void markLaunchCompleted() {
        this.launchCrashTracker.markLaunchCompleted();
    }

    SessionTracker getSessionTracker() {
        return this.sessionTracker;
    }

    EventStore getEventStore() {
        return this.eventStore.get();
    }

    protected void finalize() throws Throwable {
        SystemBroadcastReceiver systemBroadcastReceiver = this.systemBroadcastReceiver;
        if (systemBroadcastReceiver != null) {
            try {
                ContextExtensionsKt.unregisterReceiverSafe(this.appContext, systemBroadcastReceiver, this.logger);
            } catch (IllegalArgumentException unused) {
                this.logger.w("Receiver not registered");
            }
        }
        super.finalize();
    }

    ImmutableConfig getConfig() {
        return this.immutableConfig;
    }

    void setBinaryArch(String str) {
        getAppDataCollector().setBinaryArch(str);
    }

    Context getAppContext() {
        return this.appContext;
    }

    String getCodeBundleId() {
        return this.appDataCollector.getCodeBundleId();
    }

    void setCodeBundleId(String str) {
        this.appDataCollector.setCodeBundleId(str);
    }

    void addRuntimeVersionInfo(String str, String str2) {
        this.deviceDataCollector.addRuntimeVersionInfo(str, str2);
    }

    void close() {
        this.connectivity.unregisterForNetworkChanges();
        this.bgTaskService.shutdown();
    }

    Logger getLogger() {
        return this.logger;
    }

    Plugin getPlugin(Class cls) {
        return this.pluginClient.findPlugin(cls);
    }

    Notifier getNotifier() {
        return this.notifier;
    }

    MetadataState getMetadataState() {
        return this.metadataState;
    }

    FeatureFlagState getFeatureFlagState() {
        return this.featureFlagState;
    }

    ContextState getContextState() {
        return this.contextState;
    }

    void setAutoNotify(boolean z) {
        this.pluginClient.setAutoNotify(this, z);
        if (z) {
            this.exceptionHandler.install();
        } else {
            this.exceptionHandler.uninstall();
        }
    }

    void setAutoDetectAnrs(boolean z) {
        this.pluginClient.setAutoDetectAnrs(this, z);
    }

    void addOnSend(OnSendCallback onSendCallback) {
        this.callbackState.addPreOnSend(onSendCallback);
    }
}
