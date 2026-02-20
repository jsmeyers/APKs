package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.DateUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ObjectJsonStreamer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u001c\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\"\u0010\u0019\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u0013R(\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bugsnag/android/ObjectJsonStreamer;", "", "()V", "redactedKeys", "", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getRedactedKeys", "()Ljava/util/Set;", "setRedactedKeys", "(Ljava/util/Set;)V", "arrayToStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "obj", "collectionToStream", "", "isRedactedKey", "", "key", "", "mapToStream", "", "shouldRedactKeys", "objectToStream", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ObjectJsonStreamer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Pattern> DEFAULT_REDACTED_KEYS = SetsKt.setOf(Pattern.compile(".*password.*", 2));
    public static final String OBJECT_PLACEHOLDER = "[OBJECT]";
    public static final String REDACTED_PLACEHOLDER = "[REDACTED]";
    private Set<Pattern> redactedKeys = DEFAULT_REDACTED_KEYS;

    /* JADX INFO: compiled from: ObjectJsonStreamer.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bugsnag/android/ObjectJsonStreamer$Companion;", "", "()V", "DEFAULT_REDACTED_KEYS", "", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getDEFAULT_REDACTED_KEYS$bugsnag_android_core_release", "()Ljava/util/Set;", "OBJECT_PLACEHOLDER", "", "REDACTED_PLACEHOLDER", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<Pattern> getDEFAULT_REDACTED_KEYS$bugsnag_android_core_release() {
            return ObjectJsonStreamer.DEFAULT_REDACTED_KEYS;
        }
    }

    public final Set<Pattern> getRedactedKeys() {
        return this.redactedKeys;
    }

    public final void setRedactedKeys(Set<Pattern> set) {
        this.redactedKeys = set;
    }

    public static /* synthetic */ void objectToStream$default(ObjectJsonStreamer objectJsonStreamer, Object obj, JsonStream jsonStream, boolean z, int i, Object obj2) throws IOException {
        if ((i & 4) != 0) {
            z = false;
        }
        objectJsonStreamer.objectToStream(obj, jsonStream, z);
    }

    public final void objectToStream(Object obj, JsonStream writer, boolean shouldRedactKeys) throws IOException {
        if (obj == null) {
            writer.nullValue();
            return;
        }
        if (obj instanceof String) {
            writer.value((String) obj);
            return;
        }
        if (obj instanceof Number) {
            writer.value((Number) obj);
            return;
        }
        if (obj instanceof Boolean) {
            writer.value(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof JsonStream.Streamable) {
            ((JsonStream.Streamable) obj).toStream(writer);
            return;
        }
        if (obj instanceof Date) {
            writer.value(DateUtils.toIso8601((Date) obj));
            return;
        }
        if (obj instanceof Map) {
            mapToStream(writer, (Map) obj, shouldRedactKeys);
            return;
        }
        if (obj instanceof Collection) {
            collectionToStream(writer, (Collection) obj);
        } else if (obj.getClass().isArray()) {
            arrayToStream(writer, obj);
        } else {
            writer.value(OBJECT_PLACEHOLDER);
        }
    }

    private final void mapToStream(JsonStream writer, Map<?, ?> obj, boolean shouldRedactKeys) throws IOException {
        writer.beginObject();
        Iterator<T> it = obj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            if (key instanceof String) {
                String str = (String) key;
                writer.name(str);
                if (shouldRedactKeys && isRedactedKey(str)) {
                    writer.value(REDACTED_PLACEHOLDER);
                } else {
                    objectToStream(entry.getValue(), writer, shouldRedactKeys);
                }
            }
        }
        writer.endObject();
    }

    private final void collectionToStream(JsonStream writer, Collection<?> obj) throws IOException {
        writer.beginArray();
        Iterator<T> it = obj.iterator();
        while (it.hasNext()) {
            objectToStream$default(this, it.next(), writer, false, 4, null);
        }
        writer.endArray();
    }

    private final void arrayToStream(JsonStream writer, Object obj) throws IOException {
        writer.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            objectToStream$default(this, Array.get(obj, i), writer, false, 4, null);
        }
        writer.endArray();
    }

    private final boolean isRedactedKey(String key) {
        Set<Pattern> set = this.redactedKeys;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (((Pattern) it.next()).matcher(key).matches()) {
                return true;
            }
        }
        return false;
    }
}
