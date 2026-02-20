package com.bugsnag.android;

/* JADX INFO: compiled from: Delivery.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/bugsnag/android/Delivery;", "", "deliver", "Lcom/bugsnag/android/DeliveryStatus;", "payload", "Lcom/bugsnag/android/EventPayload;", "deliveryParams", "Lcom/bugsnag/android/DeliveryParams;", "Lcom/bugsnag/android/Session;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Delivery {
    DeliveryStatus deliver(EventPayload payload, DeliveryParams deliveryParams);

    DeliveryStatus deliver(Session payload, DeliveryParams deliveryParams);
}
