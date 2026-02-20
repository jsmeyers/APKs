package com.bugsnag.android;

import androidx.core.app.NotificationCompat;
import com.bugsnag.android.internal.JsonHelper;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MarshalledEventSource.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bugsnag/android/MarshalledEventSource;", "Lkotlin/Function0;", "Lcom/bugsnag/android/Event;", "eventFile", "Ljava/io/File;", DynamicLink.Builder.KEY_API_KEY, "", "logger", "Lcom/bugsnag/android/Logger;", "(Ljava/io/File;Ljava/lang/String;Lcom/bugsnag/android/Logger;)V", "<set-?>", NotificationCompat.CATEGORY_EVENT, "getEvent", "()Lcom/bugsnag/android/Event;", "clear", "", "invoke", "unmarshall", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MarshalledEventSource implements Function0<Event> {
    private final String apiKey;
    private Event event;
    private final File eventFile;
    private final Logger logger;

    public MarshalledEventSource(File file, String str, Logger logger) {
        this.eventFile = file;
        this.apiKey = str;
        this.logger = logger;
    }

    public final Event getEvent() {
        return this.event;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public Event invoke() {
        Event event = this.event;
        if (event != null) {
            return event;
        }
        Event eventUnmarshall = unmarshall();
        this.event = eventUnmarshall;
        return eventUnmarshall;
    }

    public final void clear() {
        this.event = null;
    }

    private final Event unmarshall() {
        return new Event(new BugsnagEventMapper(this.logger).convertToEventImpl$bugsnag_android_core_release(JsonHelper.INSTANCE.deserialize(this.eventFile), this.apiKey), this.logger);
    }
}
