package com.bugsnag.android;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bugsnag/android/ErrorType;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc$bugsnag_android_core_release", "()Ljava/lang/String;", "UNKNOWN", "ANDROID", "REACTNATIVEJS", "C", "DART", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum ErrorType {
    UNKNOWN(""),
    ANDROID("android"),
    REACTNATIVEJS("reactnativejs"),
    C("c"),
    DART("dart");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String desc;

    @JvmStatic
    public static final ErrorType fromDescriptor(String str) {
        return INSTANCE.fromDescriptor(str);
    }

    ErrorType(String str) {
        this.desc = str;
    }

    /* JADX INFO: renamed from: getDesc$bugsnag_android_core_release, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: compiled from: ErrorType.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/bugsnag/android/ErrorType$Companion;", "", "()V", "fromDescriptor", "Lcom/bugsnag/android/ErrorType;", "desc", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ErrorType fromDescriptor(String desc) {
            ErrorType[] errorTypeArrValues = ErrorType.values();
            int length = errorTypeArrValues.length;
            int i = 0;
            while (i < length) {
                ErrorType errorType = errorTypeArrValues[i];
                i++;
                if (kotlin.jvm.internal.Intrinsics.areEqual(errorType.getDesc(), desc)) {
                    return errorType;
                }
            }
            return null;
        }
    }
}
