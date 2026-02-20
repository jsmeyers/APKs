package io.cyolo.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProxyPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lio/cyolo/android/model/ProxyPolicy;", "Landroid/os/Parcelable;", "settings", "Lio/cyolo/android/model/ProxyPolicySettings;", "(Lio/cyolo/android/model/ProxyPolicySettings;)V", "getSettings", "()Lio/cyolo/android/model/ProxyPolicySettings;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ProxyPolicy implements Parcelable {
    public static final Parcelable.Creator<ProxyPolicy> CREATOR = new Creator();

    @SerializedName("proxy_settings")
    private final ProxyPolicySettings settings;

    /* JADX INFO: compiled from: ProxyPolicy.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProxyPolicy> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyPolicy createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProxyPolicy(ProxyPolicySettings.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyPolicy[] newArray(int i) {
            return new ProxyPolicy[i];
        }
    }

    public static /* synthetic */ ProxyPolicy copy$default(ProxyPolicy proxyPolicy, ProxyPolicySettings proxyPolicySettings, int i, Object obj) {
        if ((i & 1) != 0) {
            proxyPolicySettings = proxyPolicy.settings;
        }
        return proxyPolicy.copy(proxyPolicySettings);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ProxyPolicySettings getSettings() {
        return this.settings;
    }

    public final ProxyPolicy copy(ProxyPolicySettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new ProxyPolicy(settings);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ProxyPolicy) && Intrinsics.areEqual(this.settings, ((ProxyPolicy) other).settings);
    }

    public int hashCode() {
        return this.settings.hashCode();
    }

    public String toString() {
        return "ProxyPolicy(settings=" + this.settings + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.settings.writeToParcel(parcel, flags);
    }

    public ProxyPolicy(ProxyPolicySettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settings = settings;
    }

    public final ProxyPolicySettings getSettings() {
        return this.settings;
    }
}
