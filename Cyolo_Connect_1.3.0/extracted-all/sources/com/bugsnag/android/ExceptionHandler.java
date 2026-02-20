package com.bugsnag.android;

import android.os.StrictMode;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String STRICT_MODE_KEY = "Violation";
    private static final String STRICT_MODE_TAB = "StrictMode";
    private final Client client;
    private final Logger logger;
    private final StrictModeHandler strictModeHandler = new StrictModeHandler();
    private final Thread.UncaughtExceptionHandler originalHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();

    ExceptionHandler(Client client, Logger logger) {
        this.client = client;
        this.logger = logger;
    }

    void install() {
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
    }

    void uninstall() {
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this.originalHandler);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, Throwable th) {
        String str;
        if (!this.client.getConfig().shouldDiscardError(th)) {
            boolean zIsStrictModeThrowable = this.strictModeHandler.isStrictModeThrowable(th);
            Metadata metadata = new Metadata();
            if (zIsStrictModeThrowable) {
                String violationDescription = this.strictModeHandler.getViolationDescription(th.getMessage());
                Metadata metadata2 = new Metadata();
                metadata2.addMetadata(STRICT_MODE_TAB, STRICT_MODE_KEY, violationDescription);
                str = violationDescription;
                metadata = metadata2;
            } else {
                str = null;
            }
            String str2 = zIsStrictModeThrowable ? "strictMode" : "unhandledException";
            if (zIsStrictModeThrowable) {
                StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
                this.client.notifyUnhandledException(th, metadata, str2, str);
                StrictMode.setThreadPolicy(threadPolicy);
            } else {
                this.client.notifyUnhandledException(th, metadata, str2, null);
            }
            forwardToOriginalHandler(thread, th);
            return;
        }
        forwardToOriginalHandler(thread, th);
    }

    private void forwardToOriginalHandler(java.lang.Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.originalHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            System.err.printf("Exception in thread \"%s\" ", thread.getName());
            this.logger.w("Exception", th);
        }
    }
}
