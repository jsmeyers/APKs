package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AnrDetailsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ!\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bugsnag/android/AnrDetailsCollector;", "", "()V", "handlerThread", "Landroid/os/HandlerThread;", "addErrorStateInfo", "", NotificationCompat.CATEGORY_EVENT, "Lcom/bugsnag/android/Event;", "anrState", "Landroid/app/ActivityManager$ProcessErrorStateInfo;", "addErrorStateInfo$bugsnag_plugin_android_anr_release", "captureProcessErrorState", "am", "Landroid/app/ActivityManager;", "pid", "", "captureProcessErrorState$bugsnag_plugin_android_anr_release", "collectAnrDetails", "ctx", "Landroid/content/Context;", "collectAnrDetails$bugsnag_plugin_android_anr_release", "collectAnrErrorDetails", "client", "Lcom/bugsnag/android/Client;", "collectAnrErrorDetails$bugsnag_plugin_android_anr_release", "Companion", "bugsnag-plugin-android-anr_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AnrDetailsCollector {
    private static final long INFO_POLL_THRESHOLD_MS = 100;
    private static final int MAX_ATTEMPTS = 300;
    private final HandlerThread handlerThread;

    public AnrDetailsCollector() {
        HandlerThread handlerThread = new HandlerThread("bugsnag-anr-collector");
        this.handlerThread = handlerThread;
        handlerThread.start();
    }

    public final ActivityManager.ProcessErrorStateInfo collectAnrDetails$bugsnag_plugin_android_anr_release(Context ctx) {
        Object objM442constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AnrDetailsCollector anrDetailsCollector = this;
            Object systemService = ctx.getSystemService("activity");
            objM442constructorimpl = Result.m442constructorimpl(systemService instanceof ActivityManager ? (ActivityManager) systemService : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        return captureProcessErrorState$bugsnag_plugin_android_anr_release((ActivityManager) (Result.m448isFailureimpl(objM442constructorimpl) ? null : objM442constructorimpl), Process.myPid());
    }

    public final ActivityManager.ProcessErrorStateInfo captureProcessErrorState$bugsnag_plugin_android_anr_release(ActivityManager am, int pid) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        Object next;
        if (am == null) {
            processesInErrorState = null;
        } else {
            try {
                processesInErrorState = am.getProcessesInErrorState();
            } catch (RuntimeException unused) {
                return null;
            }
        }
        if (processesInErrorState == null) {
            processesInErrorState = CollectionsKt.emptyList();
        }
        Iterator<T> it = processesInErrorState.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((ActivityManager.ProcessErrorStateInfo) next).pid == pid) {
                return (ActivityManager.ProcessErrorStateInfo) next;
            }
        }
        next = null;
        return (ActivityManager.ProcessErrorStateInfo) next;
    }

    public final void addErrorStateInfo$bugsnag_plugin_android_anr_release(Event event, ActivityManager.ProcessErrorStateInfo anrState) {
        String strReplaceFirst$default = anrState.shortMsg;
        if (!event.getErrors().isEmpty()) {
            Error error = event.getErrors().get(0);
            if (StringsKt.startsWith$default(strReplaceFirst$default, "ANR", false, 2, (Object) null)) {
                strReplaceFirst$default = StringsKt.replaceFirst$default(strReplaceFirst$default, "ANR", "", false, 4, (Object) null);
            }
            error.setErrorMessage(strReplaceFirst$default);
        }
    }

    public final void collectAnrErrorDetails$bugsnag_plugin_android_anr_release(final Client client, final Event event) {
        final Handler handler = new Handler(this.handlerThread.getLooper());
        final AtomicInteger atomicInteger = new AtomicInteger();
        handler.post(new Runnable() { // from class: com.bugsnag.android.AnrDetailsCollector$collectAnrErrorDetails$1
            @Override // java.lang.Runnable
            public void run() {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfoCollectAnrDetails$bugsnag_plugin_android_anr_release = this.this$0.collectAnrDetails$bugsnag_plugin_android_anr_release(client.appContext);
                if (processErrorStateInfoCollectAnrDetails$bugsnag_plugin_android_anr_release == null) {
                    if (atomicInteger.getAndIncrement() < 300) {
                        handler.postDelayed(this, 100L);
                    }
                } else {
                    this.this$0.addErrorStateInfo$bugsnag_plugin_android_anr_release(event, processErrorStateInfoCollectAnrDetails$bugsnag_plugin_android_anr_release);
                    client.populateAndNotifyAndroidEvent(event, null);
                }
            }
        });
    }
}
