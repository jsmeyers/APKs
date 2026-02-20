package io.cyolo.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProxyPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lio/cyolo/android/model/ProxyPolicySettings;", "Landroid/os/Parcelable;", "httpProxy", "", "httpsProxy", "noProxy", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getHttpProxy", "()Ljava/lang/String;", "getHttpsProxy", "getNoProxy", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ProxyPolicySettings implements Parcelable {
    public static final Parcelable.Creator<ProxyPolicySettings> CREATOR = new Creator();

    @SerializedName("http_proxy")
    private final String httpProxy;

    @SerializedName("https_proxy")
    private final String httpsProxy;

    @SerializedName("no_proxy")
    private final List<String> noProxy;

    /* JADX INFO: compiled from: ProxyPolicy.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProxyPolicySettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyPolicySettings createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProxyPolicySettings(parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyPolicySettings[] newArray(int i) {
            return new ProxyPolicySettings[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProxyPolicySettings copy$default(ProxyPolicySettings proxyPolicySettings, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = proxyPolicySettings.httpProxy;
        }
        if ((i & 2) != 0) {
            str2 = proxyPolicySettings.httpsProxy;
        }
        if ((i & 4) != 0) {
            list = proxyPolicySettings.noProxy;
        }
        return proxyPolicySettings.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHttpProxy() {
        return this.httpProxy;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHttpsProxy() {
        return this.httpsProxy;
    }

    public final List<String> component3() {
        return this.noProxy;
    }

    public final ProxyPolicySettings copy(String httpProxy, String httpsProxy, List<String> noProxy) {
        Intrinsics.checkNotNullParameter(httpProxy, "httpProxy");
        Intrinsics.checkNotNullParameter(httpsProxy, "httpsProxy");
        Intrinsics.checkNotNullParameter(noProxy, "noProxy");
        return new ProxyPolicySettings(httpProxy, httpsProxy, noProxy);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProxyPolicySettings)) {
            return false;
        }
        ProxyPolicySettings proxyPolicySettings = (ProxyPolicySettings) other;
        return Intrinsics.areEqual(this.httpProxy, proxyPolicySettings.httpProxy) && Intrinsics.areEqual(this.httpsProxy, proxyPolicySettings.httpsProxy) && Intrinsics.areEqual(this.noProxy, proxyPolicySettings.noProxy);
    }

    public int hashCode() {
        return (((this.httpProxy.hashCode() * 31) + this.httpsProxy.hashCode()) * 31) + this.noProxy.hashCode();
    }

    public String toString() {
        return "ProxyPolicySettings(httpProxy=" + this.httpProxy + ", httpsProxy=" + this.httpsProxy + ", noProxy=" + this.noProxy + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.httpProxy);
        parcel.writeString(this.httpsProxy);
        parcel.writeStringList(this.noProxy);
    }

    public ProxyPolicySettings(String httpProxy, String httpsProxy, List<String> noProxy) {
        Intrinsics.checkNotNullParameter(httpProxy, "httpProxy");
        Intrinsics.checkNotNullParameter(httpsProxy, "httpsProxy");
        Intrinsics.checkNotNullParameter(noProxy, "noProxy");
        this.httpProxy = httpProxy;
        this.httpsProxy = httpsProxy;
        this.noProxy = noProxy;
    }

    public final String getHttpProxy() {
        return this.httpProxy;
    }

    public final String getHttpsProxy() {
        return this.httpsProxy;
    }

    public final List<String> getNoProxy() {
        return this.noProxy;
    }
}
