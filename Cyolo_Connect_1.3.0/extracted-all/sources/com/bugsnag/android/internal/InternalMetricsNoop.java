package com.bugsnag.android.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: InternalMetricsNoop.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u000eH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bugsnag/android/internal/InternalMetricsNoop;", "Lcom/bugsnag/android/internal/InternalMetrics;", "()V", "notifyAddCallback", "", "callback", "", "notifyRemoveCallback", "setBreadcrumbTrimMetrics", "breadcrumbsRemoved", "", "bytesRemoved", "setCallbackCounts", "newCallbackCounts", "", "setConfigDifferences", "differences", "", "setMetadataTrimMetrics", "stringsTrimmed", "charsRemoved", "toJsonableMap", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InternalMetricsNoop implements InternalMetrics {
    @Override // com.bugsnag.android.internal.InternalMetrics
    public void notifyAddCallback(String callback) {
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void notifyRemoveCallback(String callback) {
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void setBreadcrumbTrimMetrics(int breadcrumbsRemoved, int bytesRemoved) {
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void setCallbackCounts(Map<String, Integer> newCallbackCounts) {
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void setConfigDifferences(Map<String, ? extends Object> differences) {
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void setMetadataTrimMetrics(int stringsTrimmed, int charsRemoved) {
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public Map<String, Object> toJsonableMap() {
        return MapsKt.emptyMap();
    }
}
