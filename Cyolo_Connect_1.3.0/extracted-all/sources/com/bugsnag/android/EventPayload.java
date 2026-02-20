package com.bugsnag.android;

import androidx.core.app.NotificationCompat;
import com.bugsnag.android.Deliverable;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.Thread;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.JsonHelper;
import com.bugsnag.android.internal.TrimMetrics;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EventPayload.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B9\b\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010!\u001a\u00020\u0006H\u0002J\u0013\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020\u0013H\u0001¢\u0006\u0002\b'J\b\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020\u00002\b\b\u0002\u0010.\u001a\u00020/H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/bugsnag/android/EventPayload;", "Lcom/bugsnag/android/JsonStream$Streamable;", "Lcom/bugsnag/android/Deliverable;", DynamicLink.Builder.KEY_API_KEY, "", NotificationCompat.CATEGORY_EVENT, "Lcom/bugsnag/android/Event;", "eventFile", "Ljava/io/File;", "notifier", "Lcom/bugsnag/android/Notifier;", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "(Ljava/lang/String;Lcom/bugsnag/android/Event;Ljava/io/File;Lcom/bugsnag/android/Notifier;Lcom/bugsnag/android/internal/ImmutableConfig;)V", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "cachedBytes", "", "<set-?>", "getEvent", "()Lcom/bugsnag/android/Event;", "setEvent$bugsnag_android_core_release", "(Lcom/bugsnag/android/Event;)V", "getEventFile$bugsnag_android_core_release", "()Ljava/io/File;", "logger", "Lcom/bugsnag/android/Logger;", "getLogger", "()Lcom/bugsnag/android/Logger;", "getNotifier$bugsnag_android_core_release", "()Lcom/bugsnag/android/Notifier;", "decodedEvent", "getErrorTypes", "", "Lcom/bugsnag/android/ErrorType;", "getErrorTypes$bugsnag_android_core_release", "rebuildPayloadCache", "rebuildPayloadCache$bugsnag_android_core_release", "toByteArray", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "trimToSize", "maxSizeBytes", "", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventPayload implements JsonStream.Streamable, Deliverable {
    public static final int DEFAULT_MAX_PAYLOAD_SIZE = 999700;
    private String apiKey;
    private byte[] cachedBytes;
    private final ImmutableConfig config;
    private Event event;
    private File eventFile;
    private final Notifier notifier;

    public EventPayload(String str, Event event, Notifier notifier, ImmutableConfig immutableConfig) {
        this(str, event, null, notifier, immutableConfig, 4, null);
    }

    public EventPayload(String str, Notifier notifier, ImmutableConfig immutableConfig) {
        this(str, null, null, notifier, immutableConfig, 6, null);
    }

    public final EventPayload trimToSize() {
        return trimToSize$default(this, 0, 1, null);
    }

    public EventPayload(String str, Event event, File file, Notifier notifier, ImmutableConfig immutableConfig) {
        this.apiKey = str;
        this.config = immutableConfig;
        this.event = event;
        this.eventFile = file;
        Notifier notifier2 = new Notifier(notifier.getName(), notifier.getVersion(), notifier.getUrl());
        notifier2.setDependencies(CollectionsKt.toMutableList((Collection) notifier.getDependencies()));
        this.notifier = notifier2;
    }

    public /* synthetic */ EventPayload(String str, Event event, File file, Notifier notifier, ImmutableConfig immutableConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : event, (i & 4) != 0 ? null : file, notifier, immutableConfig);
    }

    @Override // com.bugsnag.android.Deliverable
    public String getIntegrityToken() {
        return Deliverable.DefaultImpls.getIntegrityToken(this);
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final void setApiKey(String str) {
        this.apiKey = str;
    }

    public final Event getEvent() {
        return this.event;
    }

    public final void setEvent$bugsnag_android_core_release(Event event) {
        this.event = event;
    }

    /* JADX INFO: renamed from: getEventFile$bugsnag_android_core_release, reason: from getter */
    public final File getEventFile() {
        return this.eventFile;
    }

    private final Logger getLogger() {
        return this.config.getLogger();
    }

    /* JADX INFO: renamed from: getNotifier$bugsnag_android_core_release, reason: from getter */
    public final Notifier getNotifier() {
        return this.notifier;
    }

    public final Set<ErrorType> getErrorTypes$bugsnag_android_core_release() {
        EventInternal impl;
        Event event = this.event;
        Set<ErrorType> errorTypesFromStackframes$bugsnag_android_core_release = (event == null || (impl = event.getImpl()) == null) ? null : impl.getErrorTypesFromStackframes$bugsnag_android_core_release();
        if (errorTypesFromStackframes$bugsnag_android_core_release != null) {
            return errorTypesFromStackframes$bugsnag_android_core_release;
        }
        File file = this.eventFile;
        Set<ErrorType> errorTypes = file != null ? EventFilenameInfo.INSTANCE.fromFile(file, this.config).getErrorTypes() : null;
        return errorTypes == null ? SetsKt.emptySet() : errorTypes;
    }

    private final Event decodedEvent() {
        Event event = this.event;
        if (event != null) {
            return event;
        }
        File file = this.eventFile;
        kotlin.jvm.internal.Intrinsics.checkNotNull(file);
        String apiKey = this.apiKey;
        if (apiKey == null) {
            apiKey = this.config.getApiKey();
        }
        Event eventInvoke = new MarshalledEventSource(file, apiKey, getLogger()).invoke();
        this.event = eventInvoke;
        return eventInvoke;
    }

    public static /* synthetic */ EventPayload trimToSize$default(EventPayload eventPayload, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = DEFAULT_MAX_PAYLOAD_SIZE;
        }
        return eventPayload.trimToSize(i);
    }

    public final EventPayload trimToSize(int maxSizeBytes) {
        if (toByteArray().length <= maxSizeBytes) {
            return this;
        }
        Event eventDecodedEvent = decodedEvent();
        TrimMetrics trimMetricsTrimMetadataStringsTo = eventDecodedEvent.getImpl().trimMetadataStringsTo(this.config.getMaxStringValueLength());
        eventDecodedEvent.getImpl().getInternalMetrics().setMetadataTrimMetrics(trimMetricsTrimMetadataStringsTo.getItemsTrimmed(), trimMetricsTrimMetadataStringsTo.getDataTrimmed());
        int size = eventDecodedEvent.getThreads().size();
        int maxReportedThreads = this.config.getMaxReportedThreads();
        if (size > maxReportedThreads) {
            eventDecodedEvent.getThreads().subList(maxReportedThreads, size).clear();
            eventDecodedEvent.getThreads().add(new Thread("", "[" + (size - maxReportedThreads) + " threads omitted as the maxReportedThreads limit (" + maxReportedThreads + ") was exceeded]", ErrorType.UNKNOWN, false, Thread.State.UNKNOWN, new Stacktrace(new StackTraceElement[]{new StackTraceElement("", "", "-", 0)}, this.config.getProjectPackages(), getLogger()), getLogger()));
        }
        byte[] bArrRebuildPayloadCache$bugsnag_android_core_release = rebuildPayloadCache$bugsnag_android_core_release();
        if (bArrRebuildPayloadCache$bugsnag_android_core_release.length <= maxSizeBytes) {
            return this;
        }
        TrimMetrics trimMetricsTrimBreadcrumbsBy = eventDecodedEvent.getImpl().trimBreadcrumbsBy(bArrRebuildPayloadCache$bugsnag_android_core_release.length - maxSizeBytes);
        eventDecodedEvent.getImpl().getInternalMetrics().setBreadcrumbTrimMetrics(trimMetricsTrimBreadcrumbsBy.getItemsTrimmed(), trimMetricsTrimBreadcrumbsBy.getDataTrimmed());
        rebuildPayloadCache$bugsnag_android_core_release();
        return this;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws Throwable {
        writer.beginObject();
        writer.name(DynamicLink.Builder.KEY_API_KEY).value(this.apiKey);
        writer.name("payloadVersion").value("4.0");
        writer.name("notifier").value(this.notifier);
        writer.name("events").beginArray();
        Event event = this.event;
        if (event != null) {
            writer.value(event);
        } else {
            File file = this.eventFile;
            if (file != null) {
                writer.value((Object) file);
            }
        }
        writer.endArray();
        writer.endObject();
    }

    @Override // com.bugsnag.android.Deliverable
    public byte[] toByteArray() throws IOException {
        byte[] bArr = this.cachedBytes;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArrSerialize = JsonHelper.INSTANCE.serialize((JsonStream.Streamable) this);
        this.cachedBytes = bArrSerialize;
        return bArrSerialize;
    }

    public final byte[] rebuildPayloadCache$bugsnag_android_core_release() {
        this.cachedBytes = null;
        return toByteArray();
    }
}
