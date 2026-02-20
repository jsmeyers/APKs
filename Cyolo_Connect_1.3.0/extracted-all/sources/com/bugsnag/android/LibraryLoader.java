package com.bugsnag.android;

import com.bugsnag.android.internal.TaskType;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class LibraryLoader {
    private final AtomicBoolean attemptedLoad = new AtomicBoolean();
    private boolean loaded = false;

    LibraryLoader() {
    }

    boolean loadLibrary(final String str, final Client client, final OnErrorCallback onErrorCallback) {
        try {
            client.bgTaskService.submitTask(TaskType.IO, new Runnable() { // from class: com.bugsnag.android.LibraryLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    LibraryLoader.this.loadLibInternal(str, client, onErrorCallback);
                }
            }).get();
            return this.loaded;
        } catch (Throwable unused) {
            return false;
        }
    }

    void loadLibInternal(String str, Client client, OnErrorCallback onErrorCallback) {
        if (this.attemptedLoad.getAndSet(true)) {
            return;
        }
        try {
            try {
                System.loadLibrary(str);
                this.loaded = true;
            } catch (UnsatisfiedLinkError unused) {
                System.loadLibrary(str);
                this.loaded = true;
            }
        } catch (UnsatisfiedLinkError e) {
            client.notify(e, onErrorCallback);
        }
    }

    boolean isLoaded() {
        return this.loaded;
    }
}
