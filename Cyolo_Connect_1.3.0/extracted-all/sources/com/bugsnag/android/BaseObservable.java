package com.bugsnag.android;

import androidx.core.app.NotificationCompat;
import com.bugsnag.android.internal.StateObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: BaseObservable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u001c\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0080\b¢\u0006\u0002\b\u0010J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bugsnag/android/BaseObservable;", "", "()V", "observers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bugsnag/android/internal/StateObserver;", "getObservers$bugsnag_android_core_release", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "addObserver", "", "observer", "removeObserver", "updateState", "provider", "Lkotlin/Function0;", "Lcom/bugsnag/android/StateEvent;", "updateState$bugsnag_android_core_release", NotificationCompat.CATEGORY_EVENT, "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class BaseObservable {
    private final CopyOnWriteArrayList<StateObserver> observers = new CopyOnWriteArrayList<>();

    public final CopyOnWriteArrayList<StateObserver> getObservers$bugsnag_android_core_release() {
        return this.observers;
    }

    public final void addObserver(StateObserver observer) {
        this.observers.addIfAbsent(observer);
    }

    public final void removeObserver(StateObserver observer) {
        this.observers.remove(observer);
    }

    public final void updateState$bugsnag_android_core_release(Function0<? extends StateEvent> provider) {
        if (getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent stateEventInvoke = provider.invoke();
        Iterator<T> it = getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(stateEventInvoke);
        }
    }

    public final void updateState(StateEvent event) {
        if (getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        Iterator<T> it = getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(event);
        }
    }
}
