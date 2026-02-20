package com.bugsnag.android.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: compiled from: ForegroundDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001MB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020/H\u0016J\u001d\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020709H\u0082\bJ\u001a\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010@\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010A\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010B\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010C\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u0018\u0010D\u001a\u0002072\u0006\u0010;\u001a\u00020<2\u0006\u0010E\u001a\u00020>H\u0016J\u0010\u0010F\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010G\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0016J\u001a\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020$2\b\b\u0002\u0010J\u001a\u00020\rH\u0007J\u0010\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020)H\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\t8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R,\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8\u0006@AX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0016\u0010\u0012R$\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR*\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#`%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u000e\u0010-\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010.\u001a\u00020\u0005*\u00020/2\u0006\u0010.\u001a\u00020\u00058B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006N"}, d2 = {"Lcom/bugsnag/android/internal/ForegroundDetector;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/os/Handler$Callback;", "()V", "BACKGROUND_TIMEOUT_MS", "", "getBACKGROUND_TIMEOUT_MS$bugsnag_android_core_release$annotations", "INT_MASK", "MSG_SEND_BACKGROUND", "", "getMSG_SEND_BACKGROUND$bugsnag_android_core_release$annotations", "activityInstanceCount", "backgroundSent", "", "getBackgroundSent$bugsnag_android_core_release$annotations", "getBackgroundSent$bugsnag_android_core_release", "()Z", "setBackgroundSent$bugsnag_android_core_release", "(Z)V", "<set-?>", "isInForeground", "isInForeground$annotations", "setInForeground$bugsnag_android_core_release", "lastEnteredForegroundMs", "getLastEnteredForegroundMs$annotations", "getLastEnteredForegroundMs", "()J", "setLastEnteredForegroundMs", "(J)V", "lastExitedForegroundMs", "getLastExitedForegroundMs$annotations", "getLastExitedForegroundMs", "setLastExitedForegroundMs", "listeners", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/bugsnag/android/internal/ForegroundDetector$OnActivityCallback;", "Lkotlin/collections/ArrayList;", "mainThreadHandler", "Landroid/os/Handler;", "observedApplication", "Landroid/app/Application;", "startedActivityCount", "startupTime", "getStartupTime$bugsnag_android_core_release", "waitingForActivityRestart", "timestamp", "Landroid/os/Message;", "getTimestamp", "(Landroid/os/Message;)J", "setTimestamp", "(Landroid/os/Message;J)V", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "notifyListeners", "", "sendCallback", "Lkotlin/Function1;", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPostStarted", "onActivityPostStopped", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "registerActivityCallbacks", "callbacks", "notifyCurrentState", "registerOn", "application", "OnActivityCallback", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ForegroundDetector implements Application.ActivityLifecycleCallbacks, Handler.Callback {
    public static final long BACKGROUND_TIMEOUT_MS = 700;
    public static final ForegroundDetector INSTANCE;
    private static final long INT_MASK = 4294967295L;
    public static final int MSG_SEND_BACKGROUND = 1;
    private static int activityInstanceCount;
    private static boolean backgroundSent;
    private static boolean isInForeground;
    private static volatile long lastEnteredForegroundMs;
    private static volatile long lastExitedForegroundMs;
    private static final ArrayList<WeakReference<OnActivityCallback>> listeners;
    private static final Handler mainThreadHandler;
    private static Application observedApplication;
    private static int startedActivityCount;
    private static final long startupTime;
    private static boolean waitingForActivityRestart;

    /* JADX INFO: compiled from: ForegroundDetector.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bugsnag/android/internal/ForegroundDetector$OnActivityCallback;", "", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "onActivityStopped", "onForegroundStatus", "foreground", "", "timestamp", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnActivityCallback {
        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);

        void onForegroundStatus(boolean foreground, long timestamp);
    }

    public static /* synthetic */ void getBACKGROUND_TIMEOUT_MS$bugsnag_android_core_release$annotations() {
    }

    public static /* synthetic */ void getBackgroundSent$bugsnag_android_core_release$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLastEnteredForegroundMs$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLastExitedForegroundMs$annotations() {
    }

    public static /* synthetic */ void getMSG_SEND_BACKGROUND$bugsnag_android_core_release$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isInForeground$annotations() {
    }

    @JvmStatic
    public static final void registerActivityCallbacks(OnActivityCallback onActivityCallback) {
        registerActivityCallbacks$default(onActivityCallback, false, 2, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    private ForegroundDetector() {
    }

    static {
        ForegroundDetector foregroundDetector = new ForegroundDetector();
        INSTANCE = foregroundDetector;
        listeners = new ArrayList<>();
        mainThreadHandler = new Handler(Looper.getMainLooper(), foregroundDetector);
        startupTime = SystemClock.elapsedRealtime();
        backgroundSent = true;
    }

    public final long getStartupTime$bugsnag_android_core_release() {
        return startupTime;
    }

    public final boolean getBackgroundSent$bugsnag_android_core_release() {
        return backgroundSent;
    }

    public final void setBackgroundSent$bugsnag_android_core_release(boolean z) {
        backgroundSent = z;
    }

    public static final boolean isInForeground() {
        return isInForeground;
    }

    public static final long getLastExitedForegroundMs() {
        return lastExitedForegroundMs;
    }

    public static final void setLastExitedForegroundMs(long j) {
        lastExitedForegroundMs = j;
    }

    public static final long getLastEnteredForegroundMs() {
        return lastEnteredForegroundMs;
    }

    public static final void setLastEnteredForegroundMs(long j) {
        lastEnteredForegroundMs = j;
    }

    @JvmStatic
    public static final void registerOn(Application application) {
        Application application2 = observedApplication;
        if (application == application2) {
            return;
        }
        if (application2 != null) {
            application2.unregisterActivityLifecycleCallbacks(INSTANCE);
        }
        ForegroundDetector foregroundDetector = INSTANCE;
        observedApplication = application;
        application.registerActivityLifecycleCallbacks(foregroundDetector);
    }

    public static /* synthetic */ void registerActivityCallbacks$default(OnActivityCallback onActivityCallback, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        registerActivityCallbacks(onActivityCallback, z);
    }

    @JvmStatic
    public static final void registerActivityCallbacks(OnActivityCallback callbacks, boolean notifyCurrentState) {
        ArrayList<WeakReference<OnActivityCallback>> arrayList = listeners;
        synchronized (arrayList) {
            arrayList.add(new WeakReference<>(callbacks));
        }
        if (notifyCurrentState) {
            boolean z = isInForeground;
            callbacks.onForegroundStatus(z, z ? lastEnteredForegroundMs : lastExitedForegroundMs);
        }
    }

    private final void notifyListeners(Function1<? super OnActivityCallback, Unit> sendCallback) {
        ArrayList<WeakReference<OnActivityCallback>> arrayList = listeners;
        synchronized (arrayList) {
            int i = 1;
            try {
                if (arrayList.isEmpty()) {
                    InlineMarker.finallyStart(2);
                    return;
                }
                try {
                    Iterator<WeakReference<OnActivityCallback>> it = arrayList.iterator();
                    while (it.hasNext()) {
                        OnActivityCallback onActivityCallback = it.next().get();
                        if (onActivityCallback == null) {
                            it.remove();
                        } else {
                            sendCallback.invoke(onActivityCallback);
                        }
                    }
                } catch (Exception unused) {
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(i);
            } finally {
                InlineMarker.finallyStart(i);
                InlineMarker.finallyEnd(i);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        activityInstanceCount++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (startedActivityCount == 0 && !waitingForActivityRestart) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList<WeakReference<OnActivityCallback>> arrayList = listeners;
            synchronized (arrayList) {
                if (!arrayList.isEmpty()) {
                    try {
                        Iterator<WeakReference<OnActivityCallback>> it = arrayList.iterator();
                        while (it.hasNext()) {
                            OnActivityCallback onActivityCallback = it.next().get();
                            if (onActivityCallback != null) {
                                onActivityCallback.onForegroundStatus(true, jElapsedRealtime);
                            } else {
                                it.remove();
                            }
                        }
                    } catch (Exception unused) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            lastEnteredForegroundMs = jElapsedRealtime;
        }
        startedActivityCount++;
        mainThreadHandler.removeMessages(1);
        isInForeground = true;
        waitingForActivityRestart = false;
        if (Build.VERSION.SDK_INT < 29) {
            ArrayList<WeakReference<OnActivityCallback>> arrayList2 = listeners;
            synchronized (arrayList2) {
                if (arrayList2.isEmpty()) {
                    return;
                }
                try {
                    Iterator<WeakReference<OnActivityCallback>> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        OnActivityCallback onActivityCallback2 = it2.next().get();
                        if (onActivityCallback2 != null) {
                            onActivityCallback2.onActivityStarted(activity);
                        } else {
                            it2.remove();
                        }
                    }
                } catch (Exception unused2) {
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int iMax = Math.max(0, startedActivityCount - 1);
        startedActivityCount = iMax;
        if (iMax == 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (activity.isChangingConfigurations()) {
                waitingForActivityRestart = true;
                Handler handler = mainThreadHandler;
                Message messageObtainMessage = handler.obtainMessage(1);
                setTimestamp(messageObtainMessage, jElapsedRealtime);
                handler.sendMessageDelayed(messageObtainMessage, 700L);
            } else {
                ArrayList<WeakReference<OnActivityCallback>> arrayList = listeners;
                synchronized (arrayList) {
                    if (!arrayList.isEmpty()) {
                        try {
                            Iterator<WeakReference<OnActivityCallback>> it = arrayList.iterator();
                            while (it.hasNext()) {
                                OnActivityCallback onActivityCallback = it.next().get();
                                if (onActivityCallback != null) {
                                    onActivityCallback.onForegroundStatus(false, jElapsedRealtime);
                                } else {
                                    it.remove();
                                }
                            }
                        } catch (Exception unused) {
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                isInForeground = false;
                lastExitedForegroundMs = jElapsedRealtime;
            }
        }
        if (Build.VERSION.SDK_INT < 29) {
            ArrayList<WeakReference<OnActivityCallback>> arrayList2 = listeners;
            synchronized (arrayList2) {
                if (arrayList2.isEmpty()) {
                    return;
                }
                try {
                    Iterator<WeakReference<OnActivityCallback>> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        OnActivityCallback onActivityCallback2 = it2.next().get();
                        if (onActivityCallback2 != null) {
                            onActivityCallback2.onActivityStopped(activity);
                        } else {
                            it2.remove();
                        }
                    }
                } catch (Exception unused2) {
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        activityInstanceCount = Math.max(0, activityInstanceCount - 1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        if (msg.what != 1) {
            return false;
        }
        waitingForActivityRestart = false;
        if (!backgroundSent) {
            isInForeground = false;
            backgroundSent = true;
            long timestamp = getTimestamp(msg);
            ArrayList<WeakReference<OnActivityCallback>> arrayList = listeners;
            synchronized (arrayList) {
                if (!arrayList.isEmpty()) {
                    try {
                        Iterator<WeakReference<OnActivityCallback>> it = arrayList.iterator();
                        while (it.hasNext()) {
                            OnActivityCallback onActivityCallback = it.next().get();
                            if (onActivityCallback != null) {
                                onActivityCallback.onForegroundStatus(false, timestamp);
                            } else {
                                it.remove();
                            }
                        }
                    } catch (Exception unused) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            lastExitedForegroundMs = timestamp;
        }
        return true;
    }

    private final long getTimestamp(Message message) {
        return (((long) message.arg1) << 32) | ((long) message.arg2);
    }

    private final void setTimestamp(Message message, long j) {
        message.arg1 = (int) ((j >>> 32) & 4294967295L);
        message.arg2 = (int) (j & 4294967295L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        ArrayList<WeakReference<OnActivityCallback>> arrayList = listeners;
        synchronized (arrayList) {
            if (arrayList.isEmpty()) {
                return;
            }
            try {
                Iterator<WeakReference<OnActivityCallback>> it = arrayList.iterator();
                while (it.hasNext()) {
                    OnActivityCallback onActivityCallback = it.next().get();
                    if (onActivityCallback != null) {
                        onActivityCallback.onActivityStarted(activity);
                    } else {
                        it.remove();
                    }
                }
            } catch (Exception unused) {
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(Activity activity) {
        ArrayList<WeakReference<OnActivityCallback>> arrayList = listeners;
        synchronized (arrayList) {
            if (arrayList.isEmpty()) {
                return;
            }
            try {
                Iterator<WeakReference<OnActivityCallback>> it = arrayList.iterator();
                while (it.hasNext()) {
                    OnActivityCallback onActivityCallback = it.next().get();
                    if (onActivityCallback != null) {
                        onActivityCallback.onActivityStopped(activity);
                    } else {
                        it.remove();
                    }
                }
            } catch (Exception unused) {
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
