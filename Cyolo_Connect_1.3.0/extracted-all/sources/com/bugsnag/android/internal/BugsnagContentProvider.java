package com.bugsnag.android.internal;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: compiled from: BugsnagContentProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bugsnag/android/internal/BugsnagContentProvider;", "Lcom/bugsnag/android/internal/AbstractStartupProvider;", "()V", "onCreate", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BugsnagContentProvider extends AbstractStartupProvider {
    @Override // com.bugsnag.android.internal.AbstractStartupProvider, android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            return true;
        }
        ForegroundDetector.registerOn(application);
        return true;
    }
}
