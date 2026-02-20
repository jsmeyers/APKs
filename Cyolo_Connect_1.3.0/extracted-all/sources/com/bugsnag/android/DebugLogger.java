package com.bugsnag.android;

import android.util.Log;
import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: DebugLogger.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bugsnag/android/DebugLogger;", "Lcom/bugsnag/android/Logger;", "()V", "TAG", "", "d", "", NotificationCompat.CATEGORY_MESSAGE, "throwable", "", "e", "i", "w", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DebugLogger implements Logger {
    public static final DebugLogger INSTANCE = new DebugLogger();
    private static final String TAG = "Bugsnag";

    private DebugLogger() {
    }

    @Override // com.bugsnag.android.Logger
    public void e(String msg) {
        Log.e(TAG, msg);
    }

    @Override // com.bugsnag.android.Logger
    public void e(String msg, Throwable throwable) {
        Log.e(TAG, msg, throwable);
    }

    @Override // com.bugsnag.android.Logger
    public void w(String msg) {
        Log.w(TAG, msg);
    }

    @Override // com.bugsnag.android.Logger
    public void w(String msg, Throwable throwable) {
        Log.w(TAG, msg, throwable);
    }

    @Override // com.bugsnag.android.Logger
    public void i(String msg) {
        Log.i(TAG, msg);
    }

    @Override // com.bugsnag.android.Logger
    public void i(String msg, Throwable throwable) {
        Log.i(TAG, msg, throwable);
    }

    @Override // com.bugsnag.android.Logger
    public void d(String msg) {
        Log.d(TAG, msg);
    }

    @Override // com.bugsnag.android.Logger
    public void d(String msg, Throwable throwable) {
        Log.d(TAG, msg, throwable);
    }
}
