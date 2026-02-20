package com.bugsnag.android;

import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.StateObserver;
import com.bugsnag.android.internal.dag.Provider;
import java.util.Iterator;

/* JADX INFO: compiled from: ClientObservable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\t¨\u0006\u000e"}, d2 = {"Lcom/bugsnag/android/ClientObservable;", "Lcom/bugsnag/android/BaseObservable;", "()V", "postNdkDeliverPending", "", "postNdkInstall", "conf", "Lcom/bugsnag/android/internal/ImmutableConfig;", "lastRunInfoPath", "", "consecutiveLaunchCrashes", "", "postOrientationChange", "orientation", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ClientObservable extends BaseObservable {
    public final void postOrientationChange(String orientation) {
        ClientObservable clientObservable = this;
        if (clientObservable.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.UpdateOrientation updateOrientation = new StateEvent.UpdateOrientation(orientation);
        Iterator<T> it = clientObservable.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(updateOrientation);
        }
    }

    public final void postNdkInstall(ImmutableConfig conf, String lastRunInfoPath, int consecutiveLaunchCrashes) {
        ClientObservable clientObservable = this;
        if (clientObservable.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        String apiKey = conf.getApiKey();
        boolean ndkCrashes = conf.getEnabledErrorTypes().getNdkCrashes();
        String appVersion = conf.getAppVersion();
        Provider<String> buildUuid = conf.getBuildUuid();
        StateEvent.Install install = new StateEvent.Install(apiKey, ndkCrashes, appVersion, buildUuid == null ? null : buildUuid.getOrNull(), conf.getReleaseStage(), lastRunInfoPath, consecutiveLaunchCrashes, conf.getSendThreads(), conf.getMaxBreadcrumbs());
        Iterator<T> it = clientObservable.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(install);
        }
    }

    public final void postNdkDeliverPending() {
        ClientObservable clientObservable = this;
        if (clientObservable.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.DeliverPending deliverPending = StateEvent.DeliverPending.INSTANCE;
        Iterator<T> it = clientObservable.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(deliverPending);
        }
    }
}
