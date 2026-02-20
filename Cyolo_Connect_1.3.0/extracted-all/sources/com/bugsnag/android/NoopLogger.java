package com.bugsnag.android;

import com.bugsnag.android.Logger;

/* JADX INFO: compiled from: NoopLogger.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bugsnag/android/NoopLogger;", "Lcom/bugsnag/android/Logger;", "()V", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NoopLogger implements Logger {
    public static final NoopLogger INSTANCE = new NoopLogger();

    private NoopLogger() {
    }

    @Override // com.bugsnag.android.Logger
    public void d(String str) {
        Logger.DefaultImpls.d(this, str);
    }

    @Override // com.bugsnag.android.Logger
    public void d(String str, Throwable th) {
        Logger.DefaultImpls.d(this, str, th);
    }

    @Override // com.bugsnag.android.Logger
    public void e(String str) {
        Logger.DefaultImpls.e(this, str);
    }

    @Override // com.bugsnag.android.Logger
    public void e(String str, Throwable th) {
        Logger.DefaultImpls.e(this, str, th);
    }

    @Override // com.bugsnag.android.Logger
    public void i(String str) {
        Logger.DefaultImpls.i(this, str);
    }

    @Override // com.bugsnag.android.Logger
    public void i(String str, Throwable th) {
        Logger.DefaultImpls.i(this, str, th);
    }

    @Override // com.bugsnag.android.Logger
    public void w(String str) {
        Logger.DefaultImpls.w(this, str);
    }

    @Override // com.bugsnag.android.Logger
    public void w(String str, Throwable th) {
        Logger.DefaultImpls.w(this, str, th);
    }
}
