package com.bugsnag.android;

import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.dag.Provider;
import com.bugsnag.android.internal.dag.ValueProvider;
import java.io.IOException;

/* JADX INFO: compiled from: AppWithState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u007f\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011Bi\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0014B\u0087\u0001\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0015\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0016J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0010¢\u0006\u0002\b'R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u0010\u0010\u001e\"\u0004\b\"\u0010 ¨\u0006("}, d2 = {"Lcom/bugsnag/android/AppWithState;", "Lcom/bugsnag/android/App;", "binaryArch", "", "id", "releaseStage", "version", "codeBundleId", "buildUuid", "type", "versionCode", "", "duration", "durationInForeground", "inForeground", "", "isLaunching", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "(Lcom/bugsnag/android/internal/ImmutableConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "Lcom/bugsnag/android/internal/dag/Provider;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bugsnag/android/internal/dag/Provider;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getDuration", "()Ljava/lang/Number;", "setDuration", "(Ljava/lang/Number;)V", "getDurationInForeground", "setDurationInForeground", "getInForeground", "()Ljava/lang/Boolean;", "setInForeground", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setLaunching", "serialiseFields", "", "writer", "Lcom/bugsnag/android/JsonStream;", "serialiseFields$bugsnag_android_core_release", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppWithState extends App {
    private Number duration;
    private Number durationInForeground;
    private Boolean inForeground;
    private Boolean isLaunching;

    public final Number getDuration() {
        return this.duration;
    }

    public final void setDuration(Number number) {
        this.duration = number;
    }

    public final Number getDurationInForeground() {
        return this.durationInForeground;
    }

    public final void setDurationInForeground(Number number) {
        this.durationInForeground = number;
    }

    public final Boolean getInForeground() {
        return this.inForeground;
    }

    public final void setInForeground(Boolean bool) {
        this.inForeground = bool;
    }

    /* JADX INFO: renamed from: isLaunching, reason: from getter */
    public final Boolean getIsLaunching() {
        return this.isLaunching;
    }

    public final void setLaunching(Boolean bool) {
        this.isLaunching = bool;
    }

    public AppWithState(String str, String str2, String str3, String str4, String str5, Provider<String> provider, String str6, Number number, Number number2, Number number3, Boolean bool, Boolean bool2) {
        super(str, str2, str3, str4, str5, provider, str6, number);
        this.duration = number2;
        this.durationInForeground = number3;
        this.inForeground = bool;
        this.isLaunching = bool2;
    }

    public AppWithState(String str, String str2, String str3, String str4, String str5, String str6, String str7, Number number, Number number2, Number number3, Boolean bool, Boolean bool2) {
        this(str, str2, str3, str4, str5, str6 == null ? null : new ValueProvider(str6), str7, number, number2, number3, bool, bool2);
    }

    public AppWithState(ImmutableConfig immutableConfig, String str, String str2, String str3, String str4, String str5, Number number, Number number2, Boolean bool, Boolean bool2) {
        this(str, str2, str3, str4, str5, immutableConfig.getBuildUuid(), immutableConfig.getAppType(), immutableConfig.getVersionCode(), number, number2, bool, bool2);
    }

    @Override // com.bugsnag.android.App
    public void serialiseFields$bugsnag_android_core_release(JsonStream writer) throws IOException {
        super.serialiseFields$bugsnag_android_core_release(writer);
        writer.name("duration").value(this.duration);
        writer.name("durationInForeground").value(this.durationInForeground);
        writer.name("inForeground").value(this.inForeground);
        writer.name("isLaunching").value(this.isLaunching);
    }
}
