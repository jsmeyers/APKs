package com.bugsnag.android;

import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.StateObserver;
import java.util.Iterator;

/* JADX INFO: compiled from: ContextState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bugsnag/android/ContextState;", "Lcom/bugsnag/android/BaseObservable;", "()V", "automaticContext", "", "manualContext", "emitObservableEvent", "", "getContext", "setAutomaticContext", "context", "setManualContext", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ContextState extends BaseObservable {
    private static final String MANUAL = "__BUGSNAG_MANUAL_CONTEXT__";
    private String automaticContext;
    private String manualContext;

    public final void setManualContext(String context) {
        this.manualContext = context;
        this.automaticContext = MANUAL;
        emitObservableEvent();
    }

    public final void setAutomaticContext(String context) {
        if (this.automaticContext != MANUAL) {
            this.automaticContext = context;
            emitObservableEvent();
        }
    }

    public final String getContext() {
        String str = this.automaticContext;
        if (!(str != MANUAL)) {
            str = null;
        }
        return str == null ? this.manualContext : str;
    }

    public final void emitObservableEvent() {
        ContextState contextState = this;
        if (contextState.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.UpdateContext updateContext = new StateEvent.UpdateContext(getContext());
        Iterator<T> it = contextState.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(updateContext);
        }
    }
}
