package com.bugsnag.android;

import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: OnErrorCallback.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bugsnag/android/OnErrorCallback;", "", "onError", "", NotificationCompat.CATEGORY_EVENT, "Lcom/bugsnag/android/Event;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface OnErrorCallback {
    boolean onError(Event event);
}
