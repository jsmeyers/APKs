package com.bugsnag.android;

import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: StrictModeOnErrorCallback.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bugsnag/android/StrictModeOnErrorCallback;", "Lcom/bugsnag/android/OnErrorCallback;", "errMsg", "", "(Ljava/lang/String;)V", "onError", "", NotificationCompat.CATEGORY_EVENT, "Lcom/bugsnag/android/Event;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StrictModeOnErrorCallback implements OnErrorCallback {
    private final String errMsg;

    public StrictModeOnErrorCallback(String str) {
        this.errMsg = str;
    }

    @Override // com.bugsnag.android.OnErrorCallback
    public boolean onError(Event event) {
        event.updateSeverityInternal(Severity.INFO);
        event.updateSeverityReason("strictMode");
        Error error = (Error) CollectionsKt.firstOrNull((List) event.getErrors());
        if (error == null) {
            return true;
        }
        error.setErrorMessage(this.errMsg);
        return true;
    }
}
