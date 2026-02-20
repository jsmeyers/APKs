package com.bugsnag.android;

import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.util.UUID;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SessionFilenameInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0003J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/bugsnag/android/SessionFilenameInfo;", "", DynamicLink.Builder.KEY_API_KEY, "", "timestamp", "", "uuid", "(Ljava/lang/String;JLjava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "getTimestamp", "()J", "getUuid", "component1", "component2", "component3", "copy", "encode", "equals", "", "other", "hashCode", "", "toString", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class SessionFilenameInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int uuidLength = 36;
    private String apiKey;
    private final long timestamp;
    private final String uuid;

    public static /* synthetic */ SessionFilenameInfo copy$default(SessionFilenameInfo sessionFilenameInfo, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionFilenameInfo.apiKey;
        }
        if ((i & 2) != 0) {
            j = sessionFilenameInfo.timestamp;
        }
        if ((i & 4) != 0) {
            str2 = sessionFilenameInfo.uuid;
        }
        return sessionFilenameInfo.copy(str, j, str2);
    }

    @JvmStatic
    public static final SessionFilenameInfo defaultFilename(Object obj, String str) {
        return INSTANCE.defaultFilename(obj, str);
    }

    @JvmStatic
    public static final String findApiKeyInFilename(File file, String str) {
        return INSTANCE.findApiKeyInFilename(file, str);
    }

    @JvmStatic
    public static final long findTimestampInFilename(File file) {
        return INSTANCE.findTimestampInFilename(file);
    }

    @JvmStatic
    public static final String findUuidInFilename(File file) {
        return INSTANCE.findUuidInFilename(file);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    public final SessionFilenameInfo copy(String apiKey, long timestamp, String uuid) {
        return new SessionFilenameInfo(apiKey, timestamp, uuid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionFilenameInfo)) {
            return false;
        }
        SessionFilenameInfo sessionFilenameInfo = (SessionFilenameInfo) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.apiKey, sessionFilenameInfo.apiKey) && this.timestamp == sessionFilenameInfo.timestamp && kotlin.jvm.internal.Intrinsics.areEqual(this.uuid, sessionFilenameInfo.uuid);
    }

    public int hashCode() {
        return (((this.apiKey.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestamp)) * 31) + this.uuid.hashCode();
    }

    public String toString() {
        return "SessionFilenameInfo(apiKey=" + this.apiKey + ", timestamp=" + this.timestamp + ", uuid=" + this.uuid + ')';
    }

    public SessionFilenameInfo(String str, long j, String str2) {
        this.apiKey = str;
        this.timestamp = j;
        this.uuid = str2;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final void setApiKey(String str) {
        this.apiKey = str;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String encode() {
        return INSTANCE.toFilename(this.apiKey, this.timestamp, this.uuid);
    }

    /* JADX INFO: compiled from: SessionFilenameInfo.kt */
    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0014J\u001e\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bugsnag/android/SessionFilenameInfo$Companion;", "", "()V", "uuidLength", "", "defaultFilename", "Lcom/bugsnag/android/SessionFilenameInfo;", "obj", DynamicLink.Builder.KEY_API_KEY, "", "findApiKeyInFilename", "file", "Ljava/io/File;", "defaultApiKey", "findTimestampInFilename", "", "findUuidInFilename", "fromFile", "isFileV3", "", "isFileV3$bugsnag_android_core_release", "toFilename", "timestamp", "uuid", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toFilename(String apiKey, long timestamp, String uuid) {
            return apiKey + '_' + uuid + timestamp + "_v3.json";
        }

        @JvmStatic
        public final SessionFilenameInfo defaultFilename(Object obj, String apiKey) {
            if (obj instanceof Session) {
                apiKey = ((Session) obj).getApiKey();
            }
            return new SessionFilenameInfo(apiKey, System.currentTimeMillis(), UUID.randomUUID().toString());
        }

        public final SessionFilenameInfo fromFile(File file, String defaultApiKey) {
            return new SessionFilenameInfo(findApiKeyInFilename(file, defaultApiKey), findTimestampInFilename(file), findUuidInFilename(file));
        }

        @JvmStatic
        public final String findUuidInFilename(File file) {
            String strTake;
            String name = file.getName();
            if (isFileV3$bugsnag_android_core_release(file)) {
                name = StringsKt.substringAfter$default(file.getName(), '_', (String) null, 2, (Object) null);
            }
            String str = name.length() >= 36 ? name : null;
            return (str == null || (strTake = StringsKt.take(str, 36)) == null) ? "" : strTake;
        }

        @JvmStatic
        public final long findTimestampInFilename(File file) {
            String name = file.getName();
            if (isFileV3$bugsnag_android_core_release(file)) {
                name = StringsKt.substringAfter$default(file.getName(), '_', (String) null, 2, (Object) null);
            }
            Long longOrNull = StringsKt.toLongOrNull(StringsKt.substringBefore$default(StringsKt.drop(name, findUuidInFilename(file).length()), '_', (String) null, 2, (Object) null));
            if (longOrNull == null) {
                return -1L;
            }
            return longOrNull.longValue();
        }

        @JvmStatic
        public final String findApiKeyInFilename(File file, String defaultApiKey) {
            if (file == null || !isFileV3$bugsnag_android_core_release(file)) {
                return defaultApiKey;
            }
            String strSubstringBefore$default = StringsKt.substringBefore$default(file.getName(), '_', (String) null, 2, (Object) null);
            String str = strSubstringBefore$default.length() == 0 ? null : strSubstringBefore$default;
            return str == null ? defaultApiKey : str;
        }

        public final boolean isFileV3$bugsnag_android_core_release(File file) {
            return StringsKt.endsWith$default(file.getName(), "_v3.json", false, 2, (Object) null);
        }
    }
}
