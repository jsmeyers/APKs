package com.bugsnag.android.internal;

import androidx.core.app.NotificationCompat;
import com.bugsnag.android.BugsnagEventMapper;
import com.bugsnag.android.Error;
import com.bugsnag.android.Event;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.Logger;
import com.google.firebase.messaging.Constants;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: BugsnagMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nJ&\u0010\f\u001a\u00020\r2\u0016\u0010\t\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000bJ\u001e\u0010\u000f\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u0010\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u0006\u0010\u0011\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bugsnag/android/internal/BugsnagMapper;", "", "logger", "Lcom/bugsnag/android/Logger;", "(Lcom/bugsnag/android/Logger;)V", "eventMapper", "Lcom/bugsnag/android/BugsnagEventMapper;", "convertToError", "Lcom/bugsnag/android/Error;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "", "convertToEvent", "Lcom/bugsnag/android/Event;", "fallbackApiKey", "convertToMap", "error", NotificationCompat.CATEGORY_EVENT, "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BugsnagMapper {
    private final BugsnagEventMapper eventMapper;

    public BugsnagMapper(Logger logger) {
        this.eventMapper = new BugsnagEventMapper(logger);
    }

    public final Event convertToEvent(Map<? super String, ? extends Object> data, String fallbackApiKey) {
        return this.eventMapper.convertToEvent$bugsnag_android_core_release(data, fallbackApiKey);
    }

    public final Error convertToError(Map<? super String, ? extends Object> data) {
        return this.eventMapper.convertError$bugsnag_android_core_release(data);
    }

    public final Map<? super String, Object> convertToMap(Event event) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, Charsets.UTF_8);
        try {
            new JsonStream(outputStreamWriter).value(event);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamWriter, null);
            return JsonHelper.INSTANCE.deserialize(byteArrayOutputStream.toByteArray());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(outputStreamWriter, th);
                throw th2;
            }
        }
    }

    public final Map<? super String, Object> convertToMap(Error error) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, Charsets.UTF_8);
        try {
            new JsonStream(outputStreamWriter).value(error);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStreamWriter, null);
            return JsonHelper.INSTANCE.deserialize(byteArrayOutputStream.toByteArray());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(outputStreamWriter, th);
                throw th2;
            }
        }
    }
}
