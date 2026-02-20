package io.cyolo.android.model;

import io.cyolo.android.MainActivityKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ServiceStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lio/cyolo/android/model/ServiceStatus;", "", "(Ljava/lang/String;I)V", "CONNECTING", "CONNECTED", "DISCONNECTED", "Companion", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ServiceStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ServiceStatus[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ServiceStatus CONNECTING = new ServiceStatus("CONNECTING", 0);
    public static final ServiceStatus CONNECTED = new ServiceStatus("CONNECTED", 1);
    public static final ServiceStatus DISCONNECTED = new ServiceStatus("DISCONNECTED", 2);

    private static final /* synthetic */ ServiceStatus[] $values() {
        return new ServiceStatus[]{CONNECTING, CONNECTED, DISCONNECTED};
    }

    public static EnumEntries<ServiceStatus> getEntries() {
        return $ENTRIES;
    }

    public static ServiceStatus valueOf(String str) {
        return (ServiceStatus) Enum.valueOf(ServiceStatus.class, str);
    }

    public static ServiceStatus[] values() {
        return (ServiceStatus[]) $VALUES.clone();
    }

    private ServiceStatus(String str, int i) {
    }

    static {
        ServiceStatus[] serviceStatusArr$values = $values();
        $VALUES = serviceStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(serviceStatusArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: ServiceStatus.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lio/cyolo/android/model/ServiceStatus$Companion;", "", "()V", "byNameIgnoreCaseOrNull", "Lio/cyolo/android/model/ServiceStatus;", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ServiceStatus byNameIgnoreCaseOrNull(String value) {
            for (ServiceStatus serviceStatus : ServiceStatus.values()) {
                if (StringsKt.equals(serviceStatus.name(), value, true)) {
                    return serviceStatus;
                }
            }
            return null;
        }
    }
}
