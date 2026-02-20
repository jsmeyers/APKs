package io.cyolo.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Site.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jo\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020(HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(HÖ\u0001R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u00063"}, d2 = {"Lio/cyolo/android/model/Site;", "Landroid/os/Parcelable;", "id", "", "name", "system", "", "ctime", "Ljava/util/Date;", "mtime", "enabled", "cidrs", "", "dnsSuffixes", "external", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;ZLjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getCidrs", "()Ljava/util/List;", "getCtime", "()Ljava/util/Date;", "getDnsSuffixes", "getEnabled", "()Z", "getExternal", "()Ljava/lang/String;", "getId", "getMtime", "getName", "getSystem", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Site implements Parcelable {
    public static final Parcelable.Creator<Site> CREATOR = new Creator();

    @SerializedName("cidr_list")
    private final List<String> cidrs;

    @SerializedName("ctime")
    private final Date ctime;

    @SerializedName("dns_suffixes")
    private final List<String> dnsSuffixes;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("external")
    private final String external;

    @SerializedName("id")
    private final String id;

    @SerializedName("mtime")
    private final Date mtime;

    @SerializedName("name")
    private final String name;

    @SerializedName("system")
    private final boolean system;

    /* JADX INFO: compiled from: Site.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Site> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Site createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Site(parcel.readString(), parcel.readString(), parcel.readInt() != 0, (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), parcel.readInt() != 0, parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Site[] newArray(int i) {
            return new Site[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSystem() {
        return this.system;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCtime() {
        return this.ctime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getMtime() {
        return this.mtime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> component7() {
        return this.cidrs;
    }

    public final List<String> component8() {
        return this.dnsSuffixes;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getExternal() {
        return this.external;
    }

    public final Site copy(String id, String name, boolean system, Date ctime, Date mtime, boolean enabled, List<String> cidrs, List<String> dnsSuffixes, String external) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ctime, "ctime");
        Intrinsics.checkNotNullParameter(mtime, "mtime");
        Intrinsics.checkNotNullParameter(cidrs, "cidrs");
        Intrinsics.checkNotNullParameter(dnsSuffixes, "dnsSuffixes");
        Intrinsics.checkNotNullParameter(external, "external");
        return new Site(id, name, system, ctime, mtime, enabled, cidrs, dnsSuffixes, external);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Site)) {
            return false;
        }
        Site site = (Site) other;
        return Intrinsics.areEqual(this.id, site.id) && Intrinsics.areEqual(this.name, site.name) && this.system == site.system && Intrinsics.areEqual(this.ctime, site.ctime) && Intrinsics.areEqual(this.mtime, site.mtime) && this.enabled == site.enabled && Intrinsics.areEqual(this.cidrs, site.cidrs) && Intrinsics.areEqual(this.dnsSuffixes, site.dnsSuffixes) && Intrinsics.areEqual(this.external, site.external);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        boolean z = this.system;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((iHashCode + r1) * 31) + this.ctime.hashCode()) * 31) + this.mtime.hashCode()) * 31;
        boolean z2 = this.enabled;
        return ((((((iHashCode2 + (z2 ? 1 : z2)) * 31) + this.cidrs.hashCode()) * 31) + this.dnsSuffixes.hashCode()) * 31) + this.external.hashCode();
    }

    public String toString() {
        return "Site(id=" + this.id + ", name=" + this.name + ", system=" + this.system + ", ctime=" + this.ctime + ", mtime=" + this.mtime + ", enabled=" + this.enabled + ", cidrs=" + this.cidrs + ", dnsSuffixes=" + this.dnsSuffixes + ", external=" + this.external + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.system ? 1 : 0);
        parcel.writeSerializable(this.ctime);
        parcel.writeSerializable(this.mtime);
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeStringList(this.cidrs);
        parcel.writeStringList(this.dnsSuffixes);
        parcel.writeString(this.external);
    }

    public Site(String id, String name, boolean z, Date ctime, Date mtime, boolean z2, List<String> cidrs, List<String> dnsSuffixes, String external) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ctime, "ctime");
        Intrinsics.checkNotNullParameter(mtime, "mtime");
        Intrinsics.checkNotNullParameter(cidrs, "cidrs");
        Intrinsics.checkNotNullParameter(dnsSuffixes, "dnsSuffixes");
        Intrinsics.checkNotNullParameter(external, "external");
        this.id = id;
        this.name = name;
        this.system = z;
        this.ctime = ctime;
        this.mtime = mtime;
        this.enabled = z2;
        this.cidrs = cidrs;
        this.dnsSuffixes = dnsSuffixes;
        this.external = external;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSystem() {
        return this.system;
    }

    public final Date getCtime() {
        return this.ctime;
    }

    public final Date getMtime() {
        return this.mtime;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getCidrs() {
        return this.cidrs;
    }

    public final List<String> getDnsSuffixes() {
        return this.dnsSuffixes;
    }

    public final String getExternal() {
        return this.external;
    }
}
