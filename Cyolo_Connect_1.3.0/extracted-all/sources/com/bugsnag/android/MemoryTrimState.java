package com.bugsnag.android;

import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.StateObserver;
import java.util.Iterator;

/* JADX INFO: compiled from: MemoryTrimState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0013\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0015\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bugsnag/android/MemoryTrimState;", "Lcom/bugsnag/android/BaseObservable;", "()V", "isLowMemory", "", "()Z", "setLowMemory", "(Z)V", "memoryTrimLevel", "", "getMemoryTrimLevel", "()Ljava/lang/Integer;", "setMemoryTrimLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "trimLevelDescription", "", "getTrimLevelDescription", "()Ljava/lang/String;", "descriptionFor", "(Ljava/lang/Integer;)Ljava/lang/String;", "emitObservableEvent", "", "updateMemoryTrimLevel", "newTrimLevel", "(Ljava/lang/Integer;)Z", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MemoryTrimState extends BaseObservable {
    private boolean isLowMemory;
    private Integer memoryTrimLevel;

    /* JADX INFO: renamed from: isLowMemory, reason: from getter */
    public final boolean getIsLowMemory() {
        return this.isLowMemory;
    }

    public final void setLowMemory(boolean z) {
        this.isLowMemory = z;
    }

    public final Integer getMemoryTrimLevel() {
        return this.memoryTrimLevel;
    }

    public final void setMemoryTrimLevel(Integer num) {
        this.memoryTrimLevel = num;
    }

    public final String getTrimLevelDescription() {
        return descriptionFor(this.memoryTrimLevel);
    }

    public final boolean updateMemoryTrimLevel(Integer newTrimLevel) {
        if (kotlin.jvm.internal.Intrinsics.areEqual(this.memoryTrimLevel, newTrimLevel)) {
            return false;
        }
        this.memoryTrimLevel = newTrimLevel;
        return true;
    }

    public final void emitObservableEvent() {
        MemoryTrimState memoryTrimState = this;
        if (memoryTrimState.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.UpdateMemoryTrimEvent updateMemoryTrimEvent = new StateEvent.UpdateMemoryTrimEvent(getIsLowMemory(), getMemoryTrimLevel(), getTrimLevelDescription());
        Iterator<T> it = memoryTrimState.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(updateMemoryTrimEvent);
        }
    }

    private final String descriptionFor(Integer memoryTrimLevel) {
        if (memoryTrimLevel == null) {
            return "None";
        }
        if (memoryTrimLevel.intValue() == 80) {
            return "Complete";
        }
        if (memoryTrimLevel.intValue() == 60) {
            return "Moderate";
        }
        if (memoryTrimLevel.intValue() == 40) {
            return "Background";
        }
        if (memoryTrimLevel.intValue() == 20) {
            return "UI hidden";
        }
        if (memoryTrimLevel.intValue() == 15) {
            return "Running critical";
        }
        if (memoryTrimLevel.intValue() == 10) {
            return "Running low";
        }
        if (memoryTrimLevel.intValue() == 5) {
            return "Running moderate";
        }
        return "Unknown (" + memoryTrimLevel + ')';
    }
}
