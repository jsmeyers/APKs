package com.bugsnag.android;

import com.bugsnag.android.internal.ImmutableConfig;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventFilenameInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0003J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0006\u0010 \u001a\u00020\u001cJ\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006#"}, d2 = {"Lcom/bugsnag/android/EventFilenameInfo;", "", DynamicLink.Builder.KEY_API_KEY, "", "uuid", "timestamp", "", DynamicLink.Builder.KEY_SUFFIX, "errorTypes", "", "Lcom/bugsnag/android/ErrorType;", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/Set;)V", "getApiKey", "()Ljava/lang/String;", "getErrorTypes", "()Ljava/util/Set;", "getSuffix", "getTimestamp", "()J", "getUuid", "component1", "component2", "component3", "component4", "component5", "copy", "encode", "equals", "", "other", "hashCode", "", "isLaunchCrashReport", "toString", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class EventFilenameInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NON_JVM_CRASH = "not-jvm";
    private static final String STARTUP_CRASH = "startupcrash";
    private final String apiKey;
    private final Set<ErrorType> errorTypes;
    private final String suffix;
    private final long timestamp;
    private final String uuid;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventFilenameInfo copy$default(EventFilenameInfo eventFilenameInfo, String str, String str2, long j, String str3, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventFilenameInfo.apiKey;
        }
        if ((i & 2) != 0) {
            str2 = eventFilenameInfo.uuid;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            j = eventFilenameInfo.timestamp;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str3 = eventFilenameInfo.suffix;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            set = eventFilenameInfo.errorTypes;
        }
        return eventFilenameInfo.copy(str, str4, j2, str5, set);
    }

    @JvmStatic
    public static final long findTimestampInFilename(File file) {
        return INSTANCE.findTimestampInFilename(file);
    }

    @JvmStatic
    public static final EventFilenameInfo fromEvent(Object obj, String str, ImmutableConfig immutableConfig) {
        return INSTANCE.fromEvent(obj, str, immutableConfig);
    }

    @JvmStatic
    public static final EventFilenameInfo fromEvent(Object obj, String str, String str2, long j, ImmutableConfig immutableConfig) {
        return INSTANCE.fromEvent(obj, str, str2, j, immutableConfig);
    }

    @JvmStatic
    public static final EventFilenameInfo fromEvent(Object obj, String str, String str2, long j, ImmutableConfig immutableConfig, Boolean bool) {
        return INSTANCE.fromEvent(obj, str, str2, j, immutableConfig, bool);
    }

    @JvmStatic
    public static final EventFilenameInfo fromEvent(Object obj, String str, String str2, ImmutableConfig immutableConfig) {
        return INSTANCE.fromEvent(obj, str, str2, immutableConfig);
    }

    @JvmStatic
    public static final EventFilenameInfo fromFile(File file, ImmutableConfig immutableConfig) {
        return INSTANCE.fromFile(file, immutableConfig);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSuffix() {
        return this.suffix;
    }

    public final Set<ErrorType> component5() {
        return this.errorTypes;
    }

    public final EventFilenameInfo copy(String apiKey, String uuid, long timestamp, String suffix, Set<? extends ErrorType> errorTypes) {
        return new EventFilenameInfo(apiKey, uuid, timestamp, suffix, errorTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventFilenameInfo)) {
            return false;
        }
        EventFilenameInfo eventFilenameInfo = (EventFilenameInfo) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.apiKey, eventFilenameInfo.apiKey) && kotlin.jvm.internal.Intrinsics.areEqual(this.uuid, eventFilenameInfo.uuid) && this.timestamp == eventFilenameInfo.timestamp && kotlin.jvm.internal.Intrinsics.areEqual(this.suffix, eventFilenameInfo.suffix) && kotlin.jvm.internal.Intrinsics.areEqual(this.errorTypes, eventFilenameInfo.errorTypes);
    }

    public int hashCode() {
        return (((((((this.apiKey.hashCode() * 31) + this.uuid.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestamp)) * 31) + this.suffix.hashCode()) * 31) + this.errorTypes.hashCode();
    }

    public String toString() {
        return "EventFilenameInfo(apiKey=" + this.apiKey + ", uuid=" + this.uuid + ", timestamp=" + this.timestamp + ", suffix=" + this.suffix + ", errorTypes=" + this.errorTypes + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventFilenameInfo(String str, String str2, long j, String str3, Set<? extends ErrorType> set) {
        this.apiKey = str;
        this.uuid = str2;
        this.timestamp = j;
        this.suffix = str3;
        this.errorTypes = set;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final Set<ErrorType> getErrorTypes() {
        return this.errorTypes;
    }

    public final String encode() {
        return INSTANCE.toFilename(this.apiKey, this.uuid, this.timestamp, this.suffix, this.errorTypes);
    }

    public final boolean isLaunchCrashReport() {
        return kotlin.jvm.internal.Intrinsics.areEqual(this.suffix, STARTUP_CRASH);
    }

    /* JADX INFO: compiled from: EventFilenameInfo.kt */
    @kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\u0010J\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0013J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\bH\u0007JG\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010!\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J4\u0010%\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bugsnag/android/EventFilenameInfo$Companion;", "", "()V", "NON_JVM_CRASH", "", "STARTUP_CRASH", "findApiKeyInFilename", "file", "Ljava/io/File;", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "findApiKeyInFilename$bugsnag_android_core_release", "findErrorTypesForEvent", "", "Lcom/bugsnag/android/ErrorType;", "obj", "findErrorTypesForEvent$bugsnag_android_core_release", "findErrorTypesInFilename", "eventFile", "findErrorTypesInFilename$bugsnag_android_core_release", "findSuffixForEvent", "launching", "", "findSuffixForEvent$bugsnag_android_core_release", "(Ljava/lang/Object;Ljava/lang/Boolean;)Ljava/lang/String;", "findSuffixInFilename", "findSuffixInFilename$bugsnag_android_core_release", "findTimestampInFilename", "", "fromEvent", "Lcom/bugsnag/android/EventFilenameInfo;", "uuid", DynamicLink.Builder.KEY_API_KEY, "timestamp", "isLaunching", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;JLcom/bugsnag/android/internal/ImmutableConfig;Ljava/lang/Boolean;)Lcom/bugsnag/android/EventFilenameInfo;", "fromFile", "toFilename", DynamicLink.Builder.KEY_SUFFIX, "errorTypes", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventFilenameInfo fromEvent(Object obj, String str, ImmutableConfig immutableConfig) {
            return fromEvent$default(this, obj, null, str, 0L, immutableConfig, null, 42, null);
        }

        @JvmStatic
        public final EventFilenameInfo fromEvent(Object obj, String str, String str2, long j, ImmutableConfig immutableConfig) {
            return fromEvent$default(this, obj, str, str2, j, immutableConfig, null, 32, null);
        }

        @JvmStatic
        public final EventFilenameInfo fromEvent(Object obj, String str, String str2, ImmutableConfig immutableConfig) {
            return fromEvent$default(this, obj, str, str2, 0L, immutableConfig, null, 40, null);
        }

        private Companion() {
        }

        public final String toFilename(String apiKey, String uuid, long timestamp, String suffix, Set<? extends ErrorType> errorTypes) {
            return timestamp + '_' + apiKey + '_' + DeliveryHeadersKt.serializeErrorTypeHeader(errorTypes) + '_' + uuid + '_' + suffix + ".json";
        }

        public static /* synthetic */ EventFilenameInfo fromEvent$default(Companion companion, Object obj, String str, String str2, long j, ImmutableConfig immutableConfig, Boolean bool, int i, Object obj2) {
            return companion.fromEvent(obj, (i & 2) != 0 ? UUID.randomUUID().toString() : str, str2, (i & 8) != 0 ? System.currentTimeMillis() : j, immutableConfig, (i & 32) != 0 ? null : bool);
        }

        @JvmStatic
        public final EventFilenameInfo fromEvent(Object obj, String uuid, String apiKey, long timestamp, ImmutableConfig config, Boolean isLaunching) {
            if (obj instanceof Event) {
                apiKey = ((Event) obj).getApiKey();
            } else {
                String str = apiKey;
                if (str == null || str.length() == 0) {
                    apiKey = config.getApiKey();
                }
            }
            return new EventFilenameInfo(apiKey, uuid, timestamp, findSuffixForEvent$bugsnag_android_core_release(obj, isLaunching), findErrorTypesForEvent$bugsnag_android_core_release(obj));
        }

        @JvmStatic
        public final EventFilenameInfo fromFile(File file, ImmutableConfig config) {
            return new EventFilenameInfo(findApiKeyInFilename$bugsnag_android_core_release(file, config), "", findTimestampInFilename(file), findSuffixInFilename$bugsnag_android_core_release(file), findErrorTypesInFilename$bugsnag_android_core_release(file));
        }

        public final String findApiKeyInFilename$bugsnag_android_core_release(File file, ImmutableConfig config) {
            String strSubstring;
            String strRemoveSuffix = StringsKt.removeSuffix(file.getName(), (CharSequence) "_startupcrash.json");
            String str = strRemoveSuffix;
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, "_", 0, false, 6, (Object) null) + 1;
            int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, "_", iIndexOf$default, false, 4, (Object) null);
            if (iIndexOf$default == 0 || iIndexOf$default2 == -1 || iIndexOf$default2 <= iIndexOf$default) {
                strSubstring = null;
            } else {
                strSubstring = strRemoveSuffix.substring(iIndexOf$default, iIndexOf$default2);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            return strSubstring == null ? config.getApiKey() : strSubstring;
        }

        public final Set<ErrorType> findErrorTypesInFilename$bugsnag_android_core_release(File eventFile) {
            String name = eventFile.getName();
            String str = name;
            int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, "_", StringsKt.lastIndexOf$default((CharSequence) str, "_", 0, false, 6, (Object) null) - 1, false, 4, (Object) null);
            int iLastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) str, "_", iLastIndexOf$default - 1, false, 4, (Object) null) + 1;
            if (iLastIndexOf$default2 < iLastIndexOf$default) {
                String strSubstring = name.substring(iLastIndexOf$default2, iLastIndexOf$default);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                int i = 0;
                List listSplit$default = StringsKt.split$default((CharSequence) strSubstring, new String[]{","}, false, 0, 6, (Object) null);
                ErrorType[] errorTypeArrValues = ErrorType.values();
                ArrayList arrayList = new ArrayList();
                int length = errorTypeArrValues.length;
                while (i < length) {
                    ErrorType errorType = errorTypeArrValues[i];
                    i++;
                    if (listSplit$default.contains(errorType.getDesc())) {
                        arrayList.add(errorType);
                    }
                }
                return CollectionsKt.toSet(arrayList);
            }
            return SetsKt.emptySet();
        }

        public final String findSuffixInFilename$bugsnag_android_core_release(File eventFile) {
            String nameWithoutExtension = FilesKt.getNameWithoutExtension(eventFile);
            String strSubstring = nameWithoutExtension.substring(StringsKt.lastIndexOf$default((CharSequence) nameWithoutExtension, "_", 0, false, 6, (Object) null) + 1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            return kotlin.jvm.internal.Intrinsics.areEqual(strSubstring, EventFilenameInfo.STARTUP_CRASH) ? true : kotlin.jvm.internal.Intrinsics.areEqual(strSubstring, EventFilenameInfo.NON_JVM_CRASH) ? strSubstring : "";
        }

        @JvmStatic
        public final long findTimestampInFilename(File eventFile) {
            Long longOrNull = StringsKt.toLongOrNull(StringsKt.substringBefore(FilesKt.getNameWithoutExtension(eventFile), "_", "-1"));
            if (longOrNull == null) {
                return -1L;
            }
            return longOrNull.longValue();
        }

        public final Set<ErrorType> findErrorTypesForEvent$bugsnag_android_core_release(Object obj) {
            return obj instanceof Event ? ((Event) obj).getImpl().getErrorTypesFromStackframes$bugsnag_android_core_release() : SetsKt.setOf(ErrorType.C);
        }

        public final String findSuffixForEvent$bugsnag_android_core_release(Object obj, Boolean launching) {
            return (((obj instanceof Event) && kotlin.jvm.internal.Intrinsics.areEqual((Object) ((Event) obj).getApp().getIsLaunching(), (Object) true)) || kotlin.jvm.internal.Intrinsics.areEqual((Object) launching, (Object) true)) ? EventFilenameInfo.STARTUP_CRASH : "";
        }
    }
}
