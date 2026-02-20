package com.bugsnag.android;

import android.content.Context;
import android.os.Build;
import android.os.storage.StorageManager;
import com.bugsnag.android.FileStore;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.Provider;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
class InternalReportDelegate implements FileStore.Delegate {
    static final String INTERNAL_DIAGNOSTICS_TAB = "BugsnagDiagnostics";
    final Context appContext;
    final Provider<AppDataCollector> appDataCollector;
    final BackgroundTaskService backgroundTaskService;
    final ImmutableConfig config;
    final Provider<DeviceDataCollector> deviceDataCollector;
    final Logger logger;
    final Notifier notifier;
    final Provider<SessionTracker> sessionTracker;
    final StorageManager storageManager;

    InternalReportDelegate(Context context, Logger logger, ImmutableConfig immutableConfig, StorageManager storageManager, Provider<AppDataCollector> provider, Provider<DeviceDataCollector> provider2, Provider<SessionTracker> provider3, Notifier notifier, BackgroundTaskService backgroundTaskService) {
        this.logger = logger;
        this.config = immutableConfig;
        this.storageManager = storageManager;
        this.appDataCollector = provider;
        this.deviceDataCollector = provider2;
        this.appContext = context;
        this.sessionTracker = provider3;
        this.notifier = notifier;
        this.backgroundTaskService = backgroundTaskService;
    }

    @Override // com.bugsnag.android.FileStore.Delegate
    public void onErrorIOFailure(Exception exc, File file, String str) {
        Event event = new Event(exc, this.config, SeverityReason.newInstance("unhandledException"), this.logger);
        event.setContext(str);
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "canRead", Boolean.valueOf(file.canRead()));
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "canWrite", Boolean.valueOf(file.canWrite()));
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "exists", Boolean.valueOf(file.exists()));
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "usableSpace", Long.valueOf(this.appContext.getCacheDir().getUsableSpace()));
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "filename", file.getName());
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "fileLength", Long.valueOf(file.length()));
        recordStorageCacheBehavior(event);
        reportInternalBugsnagError(event);
    }

    void recordStorageCacheBehavior(Event event) {
        if (this.storageManager == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        File file = new File(this.appContext.getCacheDir(), "bugsnag/errors");
        try {
            boolean zIsCacheBehaviorTombstone = this.storageManager.isCacheBehaviorTombstone(file);
            boolean zIsCacheBehaviorGroup = this.storageManager.isCacheBehaviorGroup(file);
            event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "cacheTombstone", Boolean.valueOf(zIsCacheBehaviorTombstone));
            event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "cacheGroup", Boolean.valueOf(zIsCacheBehaviorGroup));
        } catch (IOException e) {
            this.logger.w("Failed to record cache behaviour, skipping diagnostics", e);
        }
    }

    void reportInternalBugsnagError(Event event) {
        event.setApp(this.appDataCollector.get().generateAppWithState());
        event.setDevice(this.deviceDataCollector.get().generateDeviceWithState(new Date().getTime()));
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "notifierName", this.notifier.getName());
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, "notifierVersion", this.notifier.getVersion());
        event.addMetadata(INTERNAL_DIAGNOSTICS_TAB, DynamicLink.Builder.KEY_API_KEY, this.config.getApiKey());
        final EventPayload eventPayload = new EventPayload(null, event, this.notifier, this.config);
        try {
            this.backgroundTaskService.submitTask(TaskType.INTERNAL_REPORT, new Runnable() { // from class: com.bugsnag.android.InternalReportDelegate.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InternalReportDelegate.this.logger.d("InternalReportDelegate - sending internal event");
                        Delivery delivery = InternalReportDelegate.this.config.getDelivery();
                        DeliveryParams errorApiDeliveryParams = InternalReportDelegate.this.config.getErrorApiDeliveryParams(eventPayload);
                        if (delivery instanceof DefaultDelivery) {
                            Map<String, String> headers = errorApiDeliveryParams.getHeaders();
                            headers.put(DeliveryHeadersKt.HEADER_INTERNAL_ERROR, "bugsnag-android");
                            headers.remove(DeliveryHeadersKt.HEADER_API_KEY);
                            ((DefaultDelivery) delivery).deliver(errorApiDeliveryParams.getEndpoint(), eventPayload.toByteArray(), eventPayload.getIntegrityToken(), headers);
                        }
                    } catch (Exception e) {
                        InternalReportDelegate.this.logger.w("Failed to report internal event to Bugsnag", e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }
}
