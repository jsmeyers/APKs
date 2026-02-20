package com.bugsnag.android.internal.dag;

import android.content.Context;
import com.bugsnag.android.internal.BackgroundTaskService;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContextModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bugsnag/android/internal/dag/ContextModule;", "Lcom/bugsnag/android/internal/dag/BackgroundDependencyModule;", "appContext", "Landroid/content/Context;", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "(Landroid/content/Context;Lcom/bugsnag/android/internal/BackgroundTaskService;)V", "ctx", "getCtx", "()Landroid/content/Context;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ContextModule extends BackgroundDependencyModule {
    private final Context ctx;

    public ContextModule(Context context, BackgroundTaskService backgroundTaskService) {
        super(backgroundTaskService, null, 2, null);
        this.ctx = context.getApplicationContext() != null ? context.getApplicationContext() : context;
    }

    public final Context getCtx() {
        return this.ctx;
    }
}
