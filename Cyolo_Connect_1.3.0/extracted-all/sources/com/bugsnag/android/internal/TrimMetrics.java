package com.bugsnag.android.internal;

import kotlin.Metadata;

/* JADX INFO: compiled from: InternalMetrics.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bugsnag/android/internal/TrimMetrics;", "", "itemsTrimmed", "", "dataTrimmed", "(II)V", "getDataTrimmed", "()I", "getItemsTrimmed", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class TrimMetrics {
    private final int dataTrimmed;
    private final int itemsTrimmed;

    public static /* synthetic */ TrimMetrics copy$default(TrimMetrics trimMetrics, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = trimMetrics.itemsTrimmed;
        }
        if ((i3 & 2) != 0) {
            i2 = trimMetrics.dataTrimmed;
        }
        return trimMetrics.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getItemsTrimmed() {
        return this.itemsTrimmed;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDataTrimmed() {
        return this.dataTrimmed;
    }

    public final TrimMetrics copy(int itemsTrimmed, int dataTrimmed) {
        return new TrimMetrics(itemsTrimmed, dataTrimmed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrimMetrics)) {
            return false;
        }
        TrimMetrics trimMetrics = (TrimMetrics) other;
        return this.itemsTrimmed == trimMetrics.itemsTrimmed && this.dataTrimmed == trimMetrics.dataTrimmed;
    }

    public int hashCode() {
        return (this.itemsTrimmed * 31) + this.dataTrimmed;
    }

    public String toString() {
        return "TrimMetrics(itemsTrimmed=" + this.itemsTrimmed + ", dataTrimmed=" + this.dataTrimmed + ')';
    }

    public TrimMetrics(int i, int i2) {
        this.itemsTrimmed = i;
        this.dataTrimmed = i2;
    }

    public final int getItemsTrimmed() {
        return this.itemsTrimmed;
    }

    public final int getDataTrimmed() {
        return this.dataTrimmed;
    }
}
