package com.bugsnag.android.internal.dag;

import android.app.ActivityManager;
import android.os.storage.StorageManager;
import com.bugsnag.android.ContextExtensionsKt;
import com.bugsnag.android.internal.BackgroundTaskService;
import kotlin.Metadata;

/* JADX INFO: compiled from: SystemServiceModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bugsnag/android/internal/dag/SystemServiceModule;", "Lcom/bugsnag/android/internal/dag/BackgroundDependencyModule;", "contextModule", "Lcom/bugsnag/android/internal/dag/ContextModule;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "(Lcom/bugsnag/android/internal/dag/ContextModule;Lcom/bugsnag/android/internal/BackgroundTaskService;)V", "activityManager", "Landroid/app/ActivityManager;", "getActivityManager", "()Landroid/app/ActivityManager;", "storageManager", "Landroid/os/storage/StorageManager;", "getStorageManager", "()Landroid/os/storage/StorageManager;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SystemServiceModule extends BackgroundDependencyModule {
    private final ActivityManager activityManager;
    private final StorageManager storageManager;

    public SystemServiceModule(ContextModule contextModule, BackgroundTaskService backgroundTaskService) {
        super(backgroundTaskService, null, 2, null);
        this.storageManager = ContextExtensionsKt.getStorageManagerFrom(contextModule.getCtx());
        this.activityManager = ContextExtensionsKt.getActivityManagerFrom(contextModule.getCtx());
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final ActivityManager getActivityManager() {
        return this.activityManager;
    }
}
