package com.bugsnag.android;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Telemetry.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/bugsnag/android/Telemetry;", "", "(Ljava/lang/String;I)V", "INTERNAL_ERRORS", "USAGE", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum Telemetry {
    INTERNAL_ERRORS,
    USAGE;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: Telemetry.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bugsnag/android/Telemetry$Companion;", "", "()V", "fromString", "Lcom/bugsnag/android/Telemetry;", "str", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Found duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Found duplicated region for block: B:9:0x001a  */
        public final Telemetry fromString(String str) {
            Telemetry telemetry;
            Telemetry[] telemetryArrValues = Telemetry.values();
            int length = telemetryArrValues.length;
            int i = 0;
            while (i < length) {
                telemetry = telemetryArrValues[i];
                i++;
                if (kotlin.jvm.internal.Intrinsics.areEqual(telemetry.name(), str)) {
                    return telemetry == null ? Telemetry.INTERNAL_ERRORS : telemetry;
                }
            }
            telemetry = null;
            if (telemetry == null) {
            }
        }
    }
}
