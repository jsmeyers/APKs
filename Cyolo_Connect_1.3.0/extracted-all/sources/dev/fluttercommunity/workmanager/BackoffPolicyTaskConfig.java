package dev.fluttercommunity.workmanager;

import androidx.work.BackoffPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ldev/fluttercommunity/workmanager/BackoffPolicyTaskConfig;", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "requestedBackoffDelay", "", "minBackoffInMillis", "backoffDelay", "(Landroidx/work/BackoffPolicy;JJJ)V", "getBackoffDelay", "()J", "getBackoffPolicy", "()Landroidx/work/BackoffPolicy;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "workmanager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class BackoffPolicyTaskConfig {
    private final long backoffDelay;
    private final BackoffPolicy backoffPolicy;
    private final long minBackoffInMillis;
    private final long requestedBackoffDelay;

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final long getRequestedBackoffDelay() {
        return this.requestedBackoffDelay;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final long getMinBackoffInMillis() {
        return this.minBackoffInMillis;
    }

    public static /* synthetic */ BackoffPolicyTaskConfig copy$default(BackoffPolicyTaskConfig backoffPolicyTaskConfig, BackoffPolicy backoffPolicy, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            backoffPolicy = backoffPolicyTaskConfig.backoffPolicy;
        }
        if ((i & 2) != 0) {
            j = backoffPolicyTaskConfig.requestedBackoffDelay;
        }
        long j4 = j;
        if ((i & 4) != 0) {
            j2 = backoffPolicyTaskConfig.minBackoffInMillis;
        }
        long j5 = j2;
        if ((i & 8) != 0) {
            j3 = backoffPolicyTaskConfig.backoffDelay;
        }
        return backoffPolicyTaskConfig.copy(backoffPolicy, j4, j5, j3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BackoffPolicy getBackoffPolicy() {
        return this.backoffPolicy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getBackoffDelay() {
        return this.backoffDelay;
    }

    public final BackoffPolicyTaskConfig copy(BackoffPolicy backoffPolicy, long requestedBackoffDelay, long minBackoffInMillis, long backoffDelay) {
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        return new BackoffPolicyTaskConfig(backoffPolicy, requestedBackoffDelay, minBackoffInMillis, backoffDelay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackoffPolicyTaskConfig)) {
            return false;
        }
        BackoffPolicyTaskConfig backoffPolicyTaskConfig = (BackoffPolicyTaskConfig) other;
        return this.backoffPolicy == backoffPolicyTaskConfig.backoffPolicy && this.requestedBackoffDelay == backoffPolicyTaskConfig.requestedBackoffDelay && this.minBackoffInMillis == backoffPolicyTaskConfig.minBackoffInMillis && this.backoffDelay == backoffPolicyTaskConfig.backoffDelay;
    }

    public int hashCode() {
        return (((((this.backoffPolicy.hashCode() * 31) + BackoffPolicyTaskConfig$$ExternalSyntheticBackport0.m(this.requestedBackoffDelay)) * 31) + BackoffPolicyTaskConfig$$ExternalSyntheticBackport0.m(this.minBackoffInMillis)) * 31) + BackoffPolicyTaskConfig$$ExternalSyntheticBackport0.m(this.backoffDelay);
    }

    public String toString() {
        return "BackoffPolicyTaskConfig(backoffPolicy=" + this.backoffPolicy + ", requestedBackoffDelay=" + this.requestedBackoffDelay + ", minBackoffInMillis=" + this.minBackoffInMillis + ", backoffDelay=" + this.backoffDelay + ')';
    }

    public BackoffPolicyTaskConfig(BackoffPolicy backoffPolicy, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        this.backoffPolicy = backoffPolicy;
        this.requestedBackoffDelay = j;
        this.minBackoffInMillis = j2;
        this.backoffDelay = j3;
    }

    public final BackoffPolicy getBackoffPolicy() {
        return this.backoffPolicy;
    }

    public /* synthetic */ BackoffPolicyTaskConfig(BackoffPolicy backoffPolicy, long j, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backoffPolicy, j, j2, (i & 8) != 0 ? Math.max(j2, j) : j3);
    }

    public final long getBackoffDelay() {
        return this.backoffDelay;
    }
}
