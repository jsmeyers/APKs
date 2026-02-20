package com.bugsnag.android;

import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bugsnag/android/Logger;", "", "d", "", NotificationCompat.CATEGORY_MESSAGE, "", "throwable", "", "e", "i", "w", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Logger {

    /* JADX INFO: compiled from: Logger.kt */
    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void d(Logger logger, String str) {
        }

        public static void d(Logger logger, String str, Throwable th) {
        }

        public static void e(Logger logger, String str) {
        }

        public static void e(Logger logger, String str, Throwable th) {
        }

        public static void i(Logger logger, String str) {
        }

        public static void i(Logger logger, String str, Throwable th) {
        }

        public static void w(Logger logger, String str) {
        }

        public static void w(Logger logger, String str, Throwable th) {
        }
    }

    void d(String msg);

    void d(String msg, Throwable throwable);

    void e(String msg);

    void e(String msg, Throwable throwable);

    void i(String msg);

    void i(String msg, Throwable throwable);

    void w(String msg);

    void w(String msg, Throwable throwable);
}
