package androidx.test.internal.runner.lifecycle;

import android.app.Application;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitor;
import androidx.test.runner.lifecycle.ApplicationStage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationLifecycleMonitorImpl implements ApplicationLifecycleMonitor {
    private static final String TAG = "ApplicationLifecycleMonitorImpl";
    private final List<WeakReference<ApplicationLifecycleCallback>> callbacks = new ArrayList();

    @Override // androidx.test.runner.lifecycle.ApplicationLifecycleMonitor
    public void addLifecycleCallback(ApplicationLifecycleCallback callback) {
        Checks.checkNotNull(callback);
        synchronized (this.callbacks) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
            boolean z = true;
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = it.next().get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else if (applicationLifecycleCallback == callback) {
                    z = false;
                }
            }
            if (z) {
                this.callbacks.add(new WeakReference<>(callback));
            }
        }
    }

    @Override // androidx.test.runner.lifecycle.ApplicationLifecycleMonitor
    public void removeLifecycleCallback(ApplicationLifecycleCallback callback) {
        Checks.checkNotNull(callback);
        synchronized (this.callbacks) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = it.next().get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else if (applicationLifecycleCallback == callback) {
                    it.remove();
                }
            }
        }
    }

    public void signalLifecycleChange(Application app, ApplicationStage stage) {
        synchronized (this.callbacks) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = it.next().get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else {
                    try {
                        String strValueOf = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 18);
                        sb.append("running callback: ");
                        sb.append(strValueOf);
                        Log.d(TAG, sb.toString());
                        applicationLifecycleCallback.onApplicationLifecycleChanged(app, stage);
                        String strValueOf2 = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 20);
                        sb2.append("callback completes: ");
                        sb2.append(strValueOf2);
                        Log.d(TAG, sb2.toString());
                    } catch (RuntimeException e) {
                        Log.e(TAG, String.format("Callback threw exception! (callback: %s stage: %s)", applicationLifecycleCallback, stage), e);
                    }
                }
            }
        }
    }
}
