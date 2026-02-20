package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.dag.Provider;
import io.cyolo.android.MainActivityKt;
import java.io.IOException;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001BA\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nB_\b\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0010¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/bugsnag/android/App;", "Lcom/bugsnag/android/JsonStream$Streamable;", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "binaryArch", "", "id", "releaseStage", "version", "codeBundleId", "(Lcom/bugsnag/android/internal/ImmutableConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "buildUuid", "Lcom/bugsnag/android/internal/dag/Provider;", "type", "versionCode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bugsnag/android/internal/dag/Provider;Ljava/lang/String;Ljava/lang/Number;)V", "getBinaryArch", "()Ljava/lang/String;", "setBinaryArch", "(Ljava/lang/String;)V", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "getBuildUuid", "setBuildUuid", "buildUuidProvider", "getCodeBundleId", "setCodeBundleId", "getId", "setId", "getReleaseStage", "setReleaseStage", "getType", "setType", "getVersion", "setVersion", "getVersionCode", "()Ljava/lang/Number;", "setVersionCode", "(Ljava/lang/Number;)V", "serialiseFields", "", "writer", "Lcom/bugsnag/android/JsonStream;", "serialiseFields$bugsnag_android_core_release", "toStream", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class App implements JsonStream.Streamable {
    private String binaryArch;
    private String buildUuid;
    private Provider<String> buildUuidProvider;
    private String codeBundleId;
    private String id;
    private String releaseStage;
    private String type;
    private String version;
    private Number versionCode;

    public App(String str, String str2, String str3, String str4, String str5, Provider<String> provider, String str6, Number number) {
        this.binaryArch = str;
        this.id = str2;
        this.releaseStage = str3;
        this.version = str4;
        this.codeBundleId = str5;
        this.type = str6;
        this.versionCode = number;
        this.buildUuidProvider = provider;
    }

    public final String getBinaryArch() {
        return this.binaryArch;
    }

    public final void setBinaryArch(String str) {
        this.binaryArch = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getReleaseStage() {
        return this.releaseStage;
    }

    public final void setReleaseStage(String str) {
        this.releaseStage = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getCodeBundleId() {
        return this.codeBundleId;
    }

    public final void setCodeBundleId(String str) {
        this.codeBundleId = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final Number getVersionCode() {
        return this.versionCode;
    }

    public final void setVersionCode(Number number) {
        this.versionCode = number;
    }

    public final String getBuildUuid() {
        String str = this.buildUuid;
        if (str != null) {
            return str;
        }
        Provider<String> provider = this.buildUuidProvider;
        if (provider == null) {
            return null;
        }
        return provider.getOrNull();
    }

    public final void setBuildUuid(String str) {
        this.buildUuid = str;
        this.buildUuidProvider = null;
    }

    public App(ImmutableConfig immutableConfig, String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, immutableConfig.getBuildUuid(), immutableConfig.getAppType(), immutableConfig.getVersionCode());
    }

    public void serialiseFields$bugsnag_android_core_release(JsonStream writer) {
        writer.name("binaryArch").value(this.binaryArch);
        writer.name("buildUUID").value(getBuildUuid());
        writer.name("codeBundleId").value(this.codeBundleId);
        writer.name("id").value(this.id);
        writer.name("releaseStage").value(this.releaseStage);
        writer.name("type").value(this.type);
        writer.name("version").value(this.version);
        writer.name("versionCode").value(this.versionCode);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws IOException {
        writer.beginObject();
        serialiseFields$bugsnag_android_core_release(writer);
        writer.endObject();
    }
}
