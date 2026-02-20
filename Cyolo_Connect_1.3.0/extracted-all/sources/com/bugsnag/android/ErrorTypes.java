package com.bugsnag.android;

import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ErrorTypes.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\r\u0010\u0013\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0004R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/bugsnag/android/ErrorTypes;", "", "detectErrors", "", "(Z)V", "anrs", "ndkCrashes", "unhandledExceptions", "unhandledRejections", "(ZZZZ)V", "getAnrs", "()Z", "setAnrs", "getNdkCrashes", "setNdkCrashes", "getUnhandledExceptions", "setUnhandledExceptions", "getUnhandledRejections", "setUnhandledRejections", "copy", "copy$bugsnag_android_core_release", "equals", "other", "hashCode", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorTypes {
    private boolean anrs;
    private boolean ndkCrashes;
    private boolean unhandledExceptions;
    private boolean unhandledRejections;

    public ErrorTypes() {
        this(false, false, false, false, 15, null);
    }

    public ErrorTypes(boolean z, boolean z2, boolean z3, boolean z4) {
        this.anrs = z;
        this.ndkCrashes = z2;
        this.unhandledExceptions = z3;
        this.unhandledRejections = z4;
    }

    public /* synthetic */ ErrorTypes(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
    }

    public final boolean getAnrs() {
        return this.anrs;
    }

    public final void setAnrs(boolean z) {
        this.anrs = z;
    }

    public final boolean getNdkCrashes() {
        return this.ndkCrashes;
    }

    public final void setNdkCrashes(boolean z) {
        this.ndkCrashes = z;
    }

    public final boolean getUnhandledExceptions() {
        return this.unhandledExceptions;
    }

    public final void setUnhandledExceptions(boolean z) {
        this.unhandledExceptions = z;
    }

    public final boolean getUnhandledRejections() {
        return this.unhandledRejections;
    }

    public final void setUnhandledRejections(boolean z) {
        this.unhandledRejections = z;
    }

    public ErrorTypes(boolean z) {
        this(z, z, z, z);
    }

    public final ErrorTypes copy$bugsnag_android_core_release() {
        return new ErrorTypes(this.anrs, this.ndkCrashes, this.unhandledExceptions, this.unhandledRejections);
    }

    public boolean equals(Object other) {
        if (other instanceof ErrorTypes) {
            ErrorTypes errorTypes = (ErrorTypes) other;
            if (this.anrs == errorTypes.anrs && this.ndkCrashes == errorTypes.ndkCrashes && this.unhandledExceptions == errorTypes.unhandledExceptions && this.unhandledRejections == errorTypes.unhandledRejections) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((UByte$$ExternalSyntheticBackport0.m(this.anrs) * 31) + UByte$$ExternalSyntheticBackport0.m(this.ndkCrashes)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.unhandledExceptions)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.unhandledRejections);
    }
}
