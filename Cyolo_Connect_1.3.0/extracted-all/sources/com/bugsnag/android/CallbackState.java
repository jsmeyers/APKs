package com.bugsnag.android;

import androidx.core.app.NotificationCompat;
import com.bugsnag.android.internal.InternalMetrics;
import com.bugsnag.android.internal.InternalMetricsNoop;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallbackState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u0000 B2\u00020\u0001:\u0001BBE\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000bJ\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000bJ\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u0006\u0010#\u001a\u00020\u0000JI\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)H\u0002J\t\u0010,\u001a\u00020+HÖ\u0001J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u000e\u0010/\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000bJ\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0016\u00101\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u00020%2\u0006\u00107\u001a\u0002082\u0006\u00104\u001a\u000205J\u001c\u00109\u001a\u00020%2\f\u0010:\u001a\b\u0012\u0004\u0012\u0002080;2\u0006\u00104\u001a\u000205J\u0016\u00109\u001a\u00020%2\u0006\u00107\u001a\u0002082\u0006\u00104\u001a\u000205J\u0016\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020>2\u0006\u00104\u001a\u000205J\u000e\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u000eJ\t\u0010A\u001a\u00020*HÖ\u0001R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006C"}, d2 = {"Lcom/bugsnag/android/CallbackState;", "Lcom/bugsnag/android/CallbackAware;", "onErrorTasks", "", "Lcom/bugsnag/android/OnErrorCallback;", "onBreadcrumbTasks", "Lcom/bugsnag/android/OnBreadcrumbCallback;", "onSessionTasks", "Lcom/bugsnag/android/OnSessionCallback;", "onSendTasks", "", "Lcom/bugsnag/android/OnSendCallback;", "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/List;)V", "internalMetrics", "Lcom/bugsnag/android/internal/InternalMetrics;", "getOnBreadcrumbTasks", "()Ljava/util/Collection;", "getOnErrorTasks", "getOnSendTasks", "()Ljava/util/List;", "getOnSessionTasks", "addOnBreadcrumb", "", CallbackState.onBreadcrumbName, "addOnError", CallbackState.onErrorName, "addOnSend", "onSend", "addOnSession", CallbackState.onSessionName, "addPreOnSend", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getCallbackCounts", "", "", "", "hashCode", "removeOnBreadcrumb", "removeOnError", "removeOnSend", "removeOnSession", "runOnBreadcrumbTasks", "breadcrumb", "Lcom/bugsnag/android/Breadcrumb;", "logger", "Lcom/bugsnag/android/Logger;", "runOnErrorTasks", NotificationCompat.CATEGORY_EVENT, "Lcom/bugsnag/android/Event;", "runOnSendTasks", "eventSource", "Lkotlin/Function0;", "runOnSessionTasks", "session", "Lcom/bugsnag/android/Session;", "setInternalMetrics", "metrics", "toString", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class CallbackState implements CallbackAware {
    private static final String onBreadcrumbName = "onBreadcrumb";
    private static final String onErrorName = "onError";
    private static final String onSendName = "onSendError";
    private static final String onSessionName = "onSession";
    private InternalMetrics internalMetrics;
    private final Collection<OnBreadcrumbCallback> onBreadcrumbTasks;
    private final Collection<OnErrorCallback> onErrorTasks;
    private final List<OnSendCallback> onSendTasks;
    private final Collection<OnSessionCallback> onSessionTasks;

    public CallbackState() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallbackState copy$default(CallbackState callbackState, Collection collection, Collection collection2, Collection collection3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = callbackState.onErrorTasks;
        }
        if ((i & 2) != 0) {
            collection2 = callbackState.onBreadcrumbTasks;
        }
        if ((i & 4) != 0) {
            collection3 = callbackState.onSessionTasks;
        }
        if ((i & 8) != 0) {
            list = callbackState.onSendTasks;
        }
        return callbackState.copy(collection, collection2, collection3, list);
    }

    public final Collection<OnErrorCallback> component1() {
        return this.onErrorTasks;
    }

    public final Collection<OnBreadcrumbCallback> component2() {
        return this.onBreadcrumbTasks;
    }

    public final Collection<OnSessionCallback> component3() {
        return this.onSessionTasks;
    }

    public final List<OnSendCallback> component4() {
        return this.onSendTasks;
    }

    public final CallbackState copy(Collection<OnErrorCallback> onErrorTasks, Collection<OnBreadcrumbCallback> onBreadcrumbTasks, Collection<OnSessionCallback> onSessionTasks, List<OnSendCallback> onSendTasks) {
        return new CallbackState(onErrorTasks, onBreadcrumbTasks, onSessionTasks, onSendTasks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallbackState)) {
            return false;
        }
        CallbackState callbackState = (CallbackState) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.onErrorTasks, callbackState.onErrorTasks) && kotlin.jvm.internal.Intrinsics.areEqual(this.onBreadcrumbTasks, callbackState.onBreadcrumbTasks) && kotlin.jvm.internal.Intrinsics.areEqual(this.onSessionTasks, callbackState.onSessionTasks) && kotlin.jvm.internal.Intrinsics.areEqual(this.onSendTasks, callbackState.onSendTasks);
    }

    public int hashCode() {
        return (((((this.onErrorTasks.hashCode() * 31) + this.onBreadcrumbTasks.hashCode()) * 31) + this.onSessionTasks.hashCode()) * 31) + this.onSendTasks.hashCode();
    }

    public String toString() {
        return "CallbackState(onErrorTasks=" + this.onErrorTasks + ", onBreadcrumbTasks=" + this.onBreadcrumbTasks + ", onSessionTasks=" + this.onSessionTasks + ", onSendTasks=" + this.onSendTasks + ')';
    }

    public CallbackState(Collection<OnErrorCallback> collection, Collection<OnBreadcrumbCallback> collection2, Collection<OnSessionCallback> collection3, List<OnSendCallback> list) {
        this.onErrorTasks = collection;
        this.onBreadcrumbTasks = collection2;
        this.onSessionTasks = collection3;
        this.onSendTasks = list;
        this.internalMetrics = new InternalMetricsNoop();
    }

    public /* synthetic */ CallbackState(CopyOnWriteArrayList copyOnWriteArrayList, CopyOnWriteArrayList copyOnWriteArrayList2, CopyOnWriteArrayList copyOnWriteArrayList3, CopyOnWriteArrayList copyOnWriteArrayList4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CopyOnWriteArrayList() : copyOnWriteArrayList, (i & 2) != 0 ? new CopyOnWriteArrayList() : copyOnWriteArrayList2, (i & 4) != 0 ? new CopyOnWriteArrayList() : copyOnWriteArrayList3, (i & 8) != 0 ? new CopyOnWriteArrayList() : copyOnWriteArrayList4);
    }

    public final Collection<OnErrorCallback> getOnErrorTasks() {
        return this.onErrorTasks;
    }

    public final Collection<OnBreadcrumbCallback> getOnBreadcrumbTasks() {
        return this.onBreadcrumbTasks;
    }

    public final Collection<OnSessionCallback> getOnSessionTasks() {
        return this.onSessionTasks;
    }

    public final List<OnSendCallback> getOnSendTasks() {
        return this.onSendTasks;
    }

    public final void setInternalMetrics(InternalMetrics metrics) {
        this.internalMetrics = metrics;
        metrics.setCallbackCounts(getCallbackCounts());
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnError(OnErrorCallback onError) {
        if (this.onErrorTasks.add(onError)) {
            this.internalMetrics.notifyAddCallback(onErrorName);
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnError(OnErrorCallback onError) {
        if (this.onErrorTasks.remove(onError)) {
            this.internalMetrics.notifyRemoveCallback(onErrorName);
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnBreadcrumb(OnBreadcrumbCallback onBreadcrumb) {
        if (this.onBreadcrumbTasks.add(onBreadcrumb)) {
            this.internalMetrics.notifyAddCallback(onBreadcrumbName);
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnBreadcrumb(OnBreadcrumbCallback onBreadcrumb) {
        if (this.onBreadcrumbTasks.remove(onBreadcrumb)) {
            this.internalMetrics.notifyRemoveCallback(onBreadcrumbName);
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnSession(OnSessionCallback onSession) {
        if (this.onSessionTasks.add(onSession)) {
            this.internalMetrics.notifyAddCallback(onSessionName);
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnSession(OnSessionCallback onSession) {
        if (this.onSessionTasks.remove(onSession)) {
            this.internalMetrics.notifyRemoveCallback(onSessionName);
        }
    }

    public final void addOnSend(OnSendCallback onSend) {
        if (this.onSendTasks.add(onSend)) {
            this.internalMetrics.notifyAddCallback(onSendName);
        }
    }

    public final void addPreOnSend(OnSendCallback onSend) {
        this.onSendTasks.add(0, onSend);
        this.internalMetrics.notifyAddCallback(onSendName);
    }

    public final void removeOnSend(OnSendCallback onSend) {
        if (this.onSendTasks.remove(onSend)) {
            this.internalMetrics.notifyRemoveCallback(onSendName);
        }
    }

    public final boolean runOnErrorTasks(Event event, Logger logger) {
        if (this.onErrorTasks.isEmpty()) {
            return true;
        }
        Iterator<T> it = this.onErrorTasks.iterator();
        while (it.hasNext()) {
            try {
            } catch (Throwable th) {
                logger.w("OnBreadcrumbCallback threw an Exception", th);
            }
            if (!((OnErrorCallback) it.next()).onError(event)) {
                return false;
            }
        }
        return true;
    }

    public final boolean runOnBreadcrumbTasks(Breadcrumb breadcrumb, Logger logger) {
        if (this.onBreadcrumbTasks.isEmpty()) {
            return true;
        }
        Iterator<T> it = this.onBreadcrumbTasks.iterator();
        while (it.hasNext()) {
            try {
            } catch (Throwable th) {
                logger.w("OnBreadcrumbCallback threw an Exception", th);
            }
            if (!((OnBreadcrumbCallback) it.next()).onBreadcrumb(breadcrumb)) {
                return false;
            }
        }
        return true;
    }

    public final boolean runOnSessionTasks(Session session, Logger logger) {
        if (this.onSessionTasks.isEmpty()) {
            return true;
        }
        Iterator<T> it = this.onSessionTasks.iterator();
        while (it.hasNext()) {
            try {
            } catch (Throwable th) {
                logger.w("OnSessionCallback threw an Exception", th);
            }
            if (!((OnSessionCallback) it.next()).onSession(session)) {
                return false;
            }
        }
        return true;
    }

    public final boolean runOnSendTasks(Event event, Logger logger) {
        Iterator<T> it = this.onSendTasks.iterator();
        while (it.hasNext()) {
            try {
            } catch (Throwable th) {
                logger.w("OnSendCallback threw an Exception", th);
            }
            if (!((OnSendCallback) it.next()).onSend(event)) {
                return false;
            }
        }
        return true;
    }

    public final boolean runOnSendTasks(Function0<? extends Event> eventSource, Logger logger) {
        if (this.onSendTasks.isEmpty()) {
            return true;
        }
        return runOnSendTasks(eventSource.invoke(), logger);
    }

    public final CallbackState copy() {
        return copy(this.onErrorTasks, this.onBreadcrumbTasks, this.onSessionTasks, this.onSendTasks);
    }

    private final Map<String, Integer> getCallbackCounts() {
        HashMap map = new HashMap();
        if (getOnBreadcrumbTasks().size() > 0) {
            map.put(onBreadcrumbName, Integer.valueOf(getOnBreadcrumbTasks().size()));
        }
        if (getOnErrorTasks().size() > 0) {
            map.put(onErrorName, Integer.valueOf(getOnErrorTasks().size()));
        }
        if (getOnSendTasks().size() > 0) {
            map.put(onSendName, Integer.valueOf(getOnSendTasks().size()));
        }
        if (getOnSessionTasks().size() > 0) {
            map.put(onSessionName, Integer.valueOf(getOnSessionTasks().size()));
        }
        return map;
    }
}
