package com.bugsnag.android;

import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.StateObserver;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FeatureFlagState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\r\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u0006\u0010\u0013\u001a\u00020\u0000J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\tJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cJ\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bugsnag/android/FeatureFlagState;", "Lcom/bugsnag/android/BaseObservable;", "Lcom/bugsnag/android/FeatureFlagAware;", "featureFlags", "Lcom/bugsnag/android/FeatureFlags;", "(Lcom/bugsnag/android/FeatureFlags;)V", "getFeatureFlags", "()Lcom/bugsnag/android/FeatureFlags;", "addFeatureFlag", "", "name", "", "variant", "addFeatureFlags", "", "Lcom/bugsnag/android/FeatureFlag;", "clearFeatureFlag", "clearFeatureFlags", "component1", "copy", "emitObservableEvent", "equals", "", "other", "", "hashCode", "", "toList", "", "toString", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class FeatureFlagState extends BaseObservable implements FeatureFlagAware {
    private final FeatureFlags featureFlags;

    /* JADX WARN: Multi-variable type inference failed */
    public FeatureFlagState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FeatureFlagState copy$default(FeatureFlagState featureFlagState, FeatureFlags featureFlags, int i, Object obj) {
        if ((i & 1) != 0) {
            featureFlags = featureFlagState.featureFlags;
        }
        return featureFlagState.copy(featureFlags);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FeatureFlags getFeatureFlags() {
        return this.featureFlags;
    }

    public final FeatureFlagState copy(FeatureFlags featureFlags) {
        return new FeatureFlagState(featureFlags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FeatureFlagState) && kotlin.jvm.internal.Intrinsics.areEqual(this.featureFlags, ((FeatureFlagState) other).featureFlags);
    }

    public int hashCode() {
        return this.featureFlags.hashCode();
    }

    public String toString() {
        return "FeatureFlagState(featureFlags=" + this.featureFlags + ')';
    }

    public /* synthetic */ FeatureFlagState(FeatureFlags featureFlags, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new FeatureFlags() : featureFlags);
    }

    public final FeatureFlags getFeatureFlags() {
        return this.featureFlags;
    }

    public FeatureFlagState(FeatureFlags featureFlags) {
        this.featureFlags = featureFlags;
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String name) {
        this.featureFlags.addFeatureFlag(name);
        FeatureFlagState featureFlagState = this;
        if (featureFlagState.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.AddFeatureFlag addFeatureFlag = new StateEvent.AddFeatureFlag(name, null, 2, null);
        Iterator<T> it = featureFlagState.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(addFeatureFlag);
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String name, String variant) {
        this.featureFlags.addFeatureFlag(name, variant);
        FeatureFlagState featureFlagState = this;
        if (featureFlagState.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.AddFeatureFlag addFeatureFlag = new StateEvent.AddFeatureFlag(name, variant);
        Iterator<T> it = featureFlagState.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(addFeatureFlag);
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlag(String name) {
        this.featureFlags.clearFeatureFlag(name);
        FeatureFlagState featureFlagState = this;
        if (featureFlagState.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.ClearFeatureFlag clearFeatureFlag = new StateEvent.ClearFeatureFlag(name);
        Iterator<T> it = featureFlagState.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(clearFeatureFlag);
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlags() {
        this.featureFlags.clearFeatureFlags();
        FeatureFlagState featureFlagState = this;
        if (featureFlagState.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.ClearFeatureFlags clearFeatureFlags = StateEvent.ClearFeatureFlags.INSTANCE;
        Iterator<T> it = featureFlagState.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(clearFeatureFlags);
        }
    }

    public final void emitObservableEvent() {
        for (FeatureFlag featureFlag : toList()) {
            String key = featureFlag.getKey();
            String value = featureFlag.getValue();
            FeatureFlagState featureFlagState = this;
            if (!featureFlagState.getObservers$bugsnag_android_core_release().isEmpty()) {
                StateEvent.AddFeatureFlag addFeatureFlag = new StateEvent.AddFeatureFlag(key, value);
                Iterator<T> it = featureFlagState.getObservers$bugsnag_android_core_release().iterator();
                while (it.hasNext()) {
                    ((StateObserver) it.next()).onStateChange(addFeatureFlag);
                }
            }
        }
    }

    public final List<FeatureFlag> toList() {
        return this.featureFlags.toList();
    }

    public final FeatureFlagState copy() {
        return new FeatureFlagState(this.featureFlags.copy());
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlags(Iterable<FeatureFlag> featureFlags) {
        for (FeatureFlag featureFlag : featureFlags) {
            addFeatureFlag(featureFlag.getKey(), featureFlag.getValue());
        }
    }
}
