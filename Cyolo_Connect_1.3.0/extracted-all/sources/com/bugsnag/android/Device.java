package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import io.cyolo.android.MainActivityKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: Device.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b)\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B]\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J,\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u0015\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0010¢\u0006\u0002\b<J\u0010\u0010=\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001c\u0010'\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001c\u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R@\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/bugsnag/android/Device;", "Lcom/bugsnag/android/JsonStream$Streamable;", "buildInfo", "Lcom/bugsnag/android/DeviceBuildInfo;", "cpuAbi", "", "", "jailbroken", "", "id", "locale", "totalMemory", "", "runtimeVersions", "", "", "(Lcom/bugsnag/android/DeviceBuildInfo;[Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "getCpuAbi", "()[Ljava/lang/String;", "setCpuAbi", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getJailbroken", "()Ljava/lang/Boolean;", "setJailbroken", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLocale", "setLocale", "manufacturer", "getManufacturer", "setManufacturer", "model", "getModel", "setModel", "osName", "getOsName", "setOsName", "osVersion", "getOsVersion", "setOsVersion", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "getRuntimeVersions", "()Ljava/util/Map;", "setRuntimeVersions", "(Ljava/util/Map;)V", "getTotalMemory", "()Ljava/lang/Long;", "setTotalMemory", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "sanitizeRuntimeVersions", "serializeFields", "", "writer", "Lcom/bugsnag/android/JsonStream;", "serializeFields$bugsnag_android_core_release", "toStream", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class Device implements JsonStream.Streamable {
    private String[] cpuAbi;
    private String id;
    private Boolean jailbroken;
    private String locale;
    private String manufacturer;
    private String model;
    private String osName = "android";
    private String osVersion;
    private Map<String, Object> runtimeVersions;
    private Long totalMemory;

    public Device(DeviceBuildInfo deviceBuildInfo, String[] strArr, Boolean bool, String str, String str2, Long l, Map<String, Object> map) {
        this.cpuAbi = strArr;
        this.jailbroken = bool;
        this.id = str;
        this.locale = str2;
        this.totalMemory = l;
        this.manufacturer = deviceBuildInfo.getManufacturer();
        this.model = deviceBuildInfo.getModel();
        this.osVersion = deviceBuildInfo.getOsVersion();
        this.runtimeVersions = sanitizeRuntimeVersions(map);
    }

    public final String[] getCpuAbi() {
        return this.cpuAbi;
    }

    public final void setCpuAbi(String[] strArr) {
        this.cpuAbi = strArr;
    }

    public final Boolean getJailbroken() {
        return this.jailbroken;
    }

    public final void setJailbroken(Boolean bool) {
        this.jailbroken = bool;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final void setLocale(String str) {
        this.locale = str;
    }

    public final Long getTotalMemory() {
        return this.totalMemory;
    }

    public final void setTotalMemory(Long l) {
        this.totalMemory = l;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public final String getModel() {
        return this.model;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final String getOsName() {
        return this.osName;
    }

    public final void setOsName(String str) {
        this.osName = str;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final void setOsVersion(String str) {
        this.osVersion = str;
    }

    public final Map<String, Object> getRuntimeVersions() {
        return this.runtimeVersions;
    }

    public final void setRuntimeVersions(Map<String, Object> map) {
        this.runtimeVersions = sanitizeRuntimeVersions(map);
    }

    public void serializeFields$bugsnag_android_core_release(JsonStream writer) throws Throwable {
        writer.name("cpuAbi").value(this.cpuAbi);
        writer.name("jailbroken").value(this.jailbroken);
        writer.name("id").value(this.id);
        writer.name("locale").value(this.locale);
        writer.name("manufacturer").value(this.manufacturer);
        writer.name("model").value(this.model);
        writer.name("osName").value(this.osName);
        writer.name("osVersion").value(this.osVersion);
        writer.name("runtimeVersions").value(this.runtimeVersions);
        writer.name("totalMemory").value((Number) this.totalMemory);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws Throwable {
        writer.beginObject();
        serializeFields$bugsnag_android_core_release(writer);
        writer.endObject();
    }

    private final Map<String, Object> sanitizeRuntimeVersions(Map<String, Object> value) {
        if (value == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = value.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return linkedHashMap;
    }
}
