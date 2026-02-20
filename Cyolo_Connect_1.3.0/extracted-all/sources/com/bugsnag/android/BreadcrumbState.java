package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.DateUtils;
import com.bugsnag.android.internal.StateObserver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: BreadcrumbState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bugsnag/android/BreadcrumbState;", "Lcom/bugsnag/android/BaseObservable;", "Lcom/bugsnag/android/JsonStream$Streamable;", "maxBreadcrumbs", "", "callbackState", "Lcom/bugsnag/android/CallbackState;", "logger", "Lcom/bugsnag/android/Logger;", "(ILcom/bugsnag/android/CallbackState;Lcom/bugsnag/android/Logger;)V", "index", "Ljava/util/concurrent/atomic/AtomicInteger;", "store", "", "Lcom/bugsnag/android/Breadcrumb;", "[Lcom/bugsnag/android/Breadcrumb;", "validIndexMask", "add", "", "breadcrumb", "copy", "", "getBreadcrumbIndex", "toStream", "writer", "Lcom/bugsnag/android/JsonStream;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BreadcrumbState extends BaseObservable implements JsonStream.Streamable {
    private final CallbackState callbackState;
    private final Logger logger;
    private final int maxBreadcrumbs;
    private final Breadcrumb[] store;
    private final int validIndexMask = Integer.MAX_VALUE;
    private final AtomicInteger index = new AtomicInteger(0);

    public BreadcrumbState(int i, CallbackState callbackState, Logger logger) {
        this.maxBreadcrumbs = i;
        this.callbackState = callbackState;
        this.logger = logger;
        this.store = new Breadcrumb[i];
    }

    public final void add(Breadcrumb breadcrumb) {
        if (this.maxBreadcrumbs == 0 || !this.callbackState.runOnBreadcrumbTasks(breadcrumb, this.logger)) {
            return;
        }
        this.store[getBreadcrumbIndex()] = breadcrumb;
        BreadcrumbState breadcrumbState = this;
        if (breadcrumbState.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        String str = breadcrumb.impl.message;
        BreadcrumbType breadcrumbType = breadcrumb.impl.type;
        String iso8601 = DateUtils.toIso8601(breadcrumb.impl.timestamp);
        LinkedHashMap linkedHashMap = breadcrumb.impl.metadata;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
        }
        StateEvent.AddBreadcrumb addBreadcrumb = new StateEvent.AddBreadcrumb(str, breadcrumbType, iso8601, linkedHashMap);
        Iterator<T> it = breadcrumbState.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(addBreadcrumb);
        }
    }

    private final int getBreadcrumbIndex() {
        int i;
        do {
            i = this.index.get() & this.validIndexMask;
        } while (!this.index.compareAndSet(i, (i + 1) % this.maxBreadcrumbs));
        return i;
    }

    public final List<Breadcrumb> copy() {
        if (this.maxBreadcrumbs == 0) {
            return CollectionsKt.emptyList();
        }
        int andSet = -1;
        while (andSet == -1) {
            andSet = this.index.getAndSet(-1);
        }
        try {
            int i = this.maxBreadcrumbs;
            Breadcrumb[] breadcrumbArr = new Breadcrumb[i];
            ArraysKt.copyInto(this.store, breadcrumbArr, 0, andSet, i);
            ArraysKt.copyInto(this.store, breadcrumbArr, this.maxBreadcrumbs - andSet, 0, andSet);
            return ArraysKt.filterNotNull(breadcrumbArr);
        } finally {
            this.index.set(andSet);
        }
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws Throwable {
        List<Breadcrumb> listCopy = copy();
        writer.beginArray();
        Iterator<T> it = listCopy.iterator();
        while (it.hasNext()) {
            ((Breadcrumb) it.next()).toStream(writer);
        }
        writer.endArray();
    }
}
