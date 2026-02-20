package com.bugsnag.android;

import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.StateObserver;
import io.cyolo.android.MainActivityKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MetadataState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\tJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u001a\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J&\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000fH\u0002J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/bugsnag/android/MetadataState;", "Lcom/bugsnag/android/BaseObservable;", "Lcom/bugsnag/android/MetadataAware;", "metadata", "Lcom/bugsnag/android/Metadata;", "(Lcom/bugsnag/android/Metadata;)V", "getMetadata", "()Lcom/bugsnag/android/Metadata;", "addMetadata", "", "section", "", "key", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "", "", "clearMetadata", "component1", "copy", "emitObservableEvent", "equals", "", "other", "hashCode", "", "notifyClear", "notifyMetadataAdded", "toString", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class MetadataState extends BaseObservable implements MetadataAware {
    private final Metadata metadata;

    /* JADX WARN: Multi-variable type inference failed */
    public MetadataState() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MetadataState copy$default(MetadataState metadataState, Metadata metadata, int i, Object obj) {
        if ((i & 1) != 0) {
            metadata = metadataState.metadata;
        }
        return metadataState.copy(metadata);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Metadata getMetadata() {
        return this.metadata;
    }

    public final MetadataState copy(Metadata metadata) {
        return new MetadataState(metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MetadataState) && kotlin.jvm.internal.Intrinsics.areEqual(this.metadata, ((MetadataState) other).metadata);
    }

    public int hashCode() {
        return this.metadata.hashCode();
    }

    public String toString() {
        return "MetadataState(metadata=" + this.metadata + ')';
    }

    public /* synthetic */ MetadataState(Metadata metadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Metadata(null, 1, null) : metadata);
    }

    public final Metadata getMetadata() {
        return this.metadata;
    }

    public MetadataState(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String section, Map<String, ? extends Object> value) {
        this.metadata.addMetadata(section, value);
        notifyMetadataAdded(section, value);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String section, String key, Object value) {
        this.metadata.addMetadata(section, key, value);
        notifyMetadataAdded(section, key, value);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String section) {
        this.metadata.clearMetadata(section);
        notifyClear(section, null);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String section, String key) {
        this.metadata.clearMetadata(section, key);
        notifyClear(section, key);
    }

    private final void notifyClear(String section, String key) {
        if (key == null) {
            MetadataState metadataState = this;
            if (metadataState.getObservers$bugsnag_android_core_release().isEmpty()) {
                return;
            }
            StateEvent.ClearMetadataSection clearMetadataSection = new StateEvent.ClearMetadataSection(section);
            Iterator<T> it = metadataState.getObservers$bugsnag_android_core_release().iterator();
            while (it.hasNext()) {
                ((StateObserver) it.next()).onStateChange(clearMetadataSection);
            }
            return;
        }
        MetadataState metadataState2 = this;
        if (metadataState2.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.ClearMetadataValue clearMetadataValue = new StateEvent.ClearMetadataValue(section, key);
        Iterator<T> it2 = metadataState2.getObservers$bugsnag_android_core_release().iterator();
        while (it2.hasNext()) {
            ((StateObserver) it2.next()).onStateChange(clearMetadataValue);
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public Map<String, Object> getMetadata(String section) {
        return this.metadata.getMetadata(section);
    }

    @Override // com.bugsnag.android.MetadataAware
    public Object getMetadata(String section, String key) {
        return this.metadata.getMetadata(section, key);
    }

    public final void emitObservableEvent() {
        Set<Map.Entry<String, Object>> setEntrySet;
        for (String str : this.metadata.getStore$bugsnag_android_core_release().keySet()) {
            Map<String, Object> metadata = this.metadata.getMetadata(str);
            if (metadata != null && (setEntrySet = metadata.entrySet()) != null) {
                Iterator<T> it = setEntrySet.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    notifyMetadataAdded(str, (String) entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private final void notifyMetadataAdded(String section, String key, Object value) {
        if (value == null) {
            notifyClear(section, key);
            return;
        }
        MetadataState metadataState = this;
        if (metadataState.getObservers$bugsnag_android_core_release().isEmpty()) {
            return;
        }
        StateEvent.AddMetadata addMetadata = new StateEvent.AddMetadata(section, key, getMetadata().getMetadata(section, key));
        Iterator<T> it = metadataState.getObservers$bugsnag_android_core_release().iterator();
        while (it.hasNext()) {
            ((StateObserver) it.next()).onStateChange(addMetadata);
        }
    }

    private final void notifyMetadataAdded(String section, Map<String, ? extends Object> value) {
        Iterator<T> it = value.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            MetadataState metadataState = this;
            if (!metadataState.getObservers$bugsnag_android_core_release().isEmpty()) {
                StateEvent.AddMetadata addMetadata = new StateEvent.AddMetadata(section, (String) entry.getKey(), getMetadata().getMetadata(section, (String) entry.getKey()));
                Iterator<T> it2 = metadataState.getObservers$bugsnag_android_core_release().iterator();
                while (it2.hasNext()) {
                    ((StateObserver) it2.next()).onStateChange(addMetadata);
                }
            }
        }
    }
}
