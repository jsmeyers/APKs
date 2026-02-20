package com.bugsnag.android;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DeliveryStatus.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/bugsnag/android/DeliveryStatus;", "", "(Ljava/lang/String;I)V", "DELIVERED", "UNDELIVERED", "FAILURE", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum DeliveryStatus {
    DELIVERED,
    UNDELIVERED,
    FAILURE;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final DeliveryStatus forHttpResponseCode(int i) {
        return INSTANCE.forHttpResponseCode(i);
    }

    /* JADX INFO: compiled from: DeliveryStatus.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bugsnag/android/DeliveryStatus$Companion;", "", "()V", "forHttpResponseCode", "Lcom/bugsnag/android/DeliveryStatus;", "responseCode", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DeliveryStatus forHttpResponseCode(int responseCode) {
            if (200 <= responseCode && responseCode < 300) {
                return DeliveryStatus.DELIVERED;
            }
            if ((400 <= responseCode && responseCode < 500) && responseCode != 408 && responseCode != 429) {
                return DeliveryStatus.FAILURE;
            }
            return DeliveryStatus.UNDELIVERED;
        }
    }
}
