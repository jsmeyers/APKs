package io.cyolo.android.model;

import io.cyolo.android.MainActivityKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lio/cyolo/android/model/Status;", "", "(Ljava/lang/String;I)V", "LOGGED_IN", "LOGGED_OUT", "ERROR", "Companion", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Status {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Status[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final Status LOGGED_IN = new Status("LOGGED_IN", 0);
    public static final Status LOGGED_OUT = new Status("LOGGED_OUT", 1);
    public static final Status ERROR = new Status("ERROR", 2);

    private static final /* synthetic */ Status[] $values() {
        return new Status[]{LOGGED_IN, LOGGED_OUT, ERROR};
    }

    public static EnumEntries<Status> getEntries() {
        return $ENTRIES;
    }

    public static Status valueOf(String str) {
        return (Status) Enum.valueOf(Status.class, str);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    private Status(String str, int i) {
    }

    static {
        Status[] statusArr$values = $values();
        $VALUES = statusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: Status.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lio/cyolo/android/model/Status$Companion;", "", "()V", "byNameIgnoreCaseOrNull", "Lio/cyolo/android/model/Status;", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Status byNameIgnoreCaseOrNull(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            for (Status status : Status.values()) {
                if (StringsKt.equals(status.name(), value, true)) {
                    return status;
                }
            }
            return null;
        }
    }
}
