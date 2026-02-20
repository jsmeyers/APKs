package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.StringUtils;
import com.bugsnag.android.internal.TrimMetrics;
import com.google.firebase.messaging.Constants;
import io.cyolo.android.MainActivityKt;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: Metadata.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B)\b\u0007\u0012 \b\u0002\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004¢\u0006\u0002\u0010\u0007J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J&\u0010\u001c\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004HÀ\u0003¢\u0006\u0002\b\u001dJ\u0006\u0010\u001e\u001a\u00020\u0000J+\u0010\u001e\u001a\u00020\u00002 \b\u0002\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J,\u0010%\u001a\u00020\u00172\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0006H\u0002J\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0016J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R,\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00061"}, d2 = {"Lcom/bugsnag/android/Metadata;", "Lcom/bugsnag/android/JsonStream$Streamable;", "Lcom/bugsnag/android/MetadataAware;", "store", "", "", "", "(Ljava/util/Map;)V", "jsonStreamer", "Lcom/bugsnag/android/ObjectJsonStreamer;", "getJsonStreamer", "()Lcom/bugsnag/android/ObjectJsonStreamer;", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "", "Ljava/util/regex/Pattern;", "redactedKeys", "getRedactedKeys", "()Ljava/util/Set;", "setRedactedKeys", "(Ljava/util/Set;)V", "getStore$bugsnag_android_core_release", "()Ljava/util/Map;", "addMetadata", "", "section", "key", "", "clearMetadata", "component1", "component1$bugsnag_android_core_release", "copy", "equals", "", "other", "getMetadata", "hashCode", "", "insertValue", "map", "newValue", "toMap", "toStream", "writer", "Lcom/bugsnag/android/JsonStream;", "toString", "trimMetadataStringsTo", "Lcom/bugsnag/android/internal/TrimMetrics;", "maxStringLength", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class Metadata implements JsonStream.Streamable, MetadataAware {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ObjectJsonStreamer jsonStreamer;
    private final Map<String, Map<String, Object>> store;

    /* JADX WARN: Multi-variable type inference failed */
    public Metadata() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Metadata copy$default(Metadata metadata, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = metadata.store;
        }
        return metadata.copy(map);
    }

    public final Map<String, Map<String, Object>> component1$bugsnag_android_core_release() {
        return this.store;
    }

    public final Metadata copy(Map<String, Map<String, Object>> store) {
        return new Metadata(store);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Metadata) && kotlin.jvm.internal.Intrinsics.areEqual(this.store, ((Metadata) other).store);
    }

    public int hashCode() {
        return this.store.hashCode();
    }

    public String toString() {
        return "Metadata(store=" + this.store + ')';
    }

    public Metadata(Map<String, Map<String, Object>> map) {
        this.store = map;
        this.jsonStreamer = new ObjectJsonStreamer();
    }

    public /* synthetic */ Metadata(ConcurrentHashMap concurrentHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ConcurrentHashMap() : concurrentHashMap);
    }

    public final Map<String, Map<String, Object>> getStore$bugsnag_android_core_release() {
        return this.store;
    }

    public final ObjectJsonStreamer getJsonStreamer() {
        return this.jsonStreamer;
    }

    public final Set<Pattern> getRedactedKeys() {
        return this.jsonStreamer.getRedactedKeys();
    }

    public final void setRedactedKeys(Set<Pattern> set) {
        this.jsonStreamer.setRedactedKeys(set);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws IOException {
        this.jsonStreamer.objectToStream(this.store, writer, true);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String section, Map<String, ? extends Object> value) {
        Iterator<T> it = value.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            addMetadata(section, (String) entry.getKey(), entry.getValue());
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String section, String key, Object value) {
        if (value == null) {
            clearMetadata(section, key);
            return;
        }
        ConcurrentHashMap concurrentHashMap = this.store.get(section);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap();
        }
        this.store.put(section, concurrentHashMap);
        insertValue(concurrentHashMap, key, value);
    }

    private final void insertValue(Map<String, Object> map, String key, Object newValue) {
        Object obj = map.get(key);
        if (obj != null && (newValue instanceof Map)) {
            newValue = INSTANCE.mergeMaps$bugsnag_android_core_release(CollectionsKt.listOf((Object[]) new Map[]{(Map) obj, (Map) newValue}));
        }
        map.put(key, newValue);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String section) {
        this.store.remove(section);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String section, String key) {
        Map<String, Object> map = this.store.get(section);
        if (map != null) {
            map.remove(key);
        }
        if (map == null || map.isEmpty()) {
            this.store.remove(section);
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public Map<String, Object> getMetadata(String section) {
        return this.store.get(section);
    }

    @Override // com.bugsnag.android.MetadataAware
    public Object getMetadata(String section, String key) {
        Map<String, Object> metadata = getMetadata(section);
        if (metadata == null) {
            return null;
        }
        return metadata.get(key);
    }

    public final Map<String, Map<String, Object>> toMap() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(this.store);
        Iterator<T> it = this.store.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            concurrentHashMap.put(entry.getKey(), new ConcurrentHashMap((Map) entry.getValue()));
        }
        return concurrentHashMap;
    }

    /* JADX INFO: compiled from: Metadata.kt */
    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\nH\u0002J\u001f\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000e\"\u00020\f¢\u0006\u0002\u0010\u000fJ3\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\n0\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bugsnag/android/Metadata$Companion;", "", "()V", "getMergeValue", "", "result", "", "", "key", "map", "", "merge", "Lcom/bugsnag/android/Metadata;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "([Lcom/bugsnag/android/Metadata;)Lcom/bugsnag/android/Metadata;", "mergeMaps", "", "mergeMaps$bugsnag_android_core_release", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Object> mergeMaps$bugsnag_android_core_release(List<? extends Map<String, ? extends Object>> data) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((Map) it.next()).keySet());
            }
            Set set = CollectionsKt.toSet(arrayList);
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (Map<String, ? extends Object> map : data) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    getMergeValue(concurrentHashMap, (String) it2.next(), map);
                }
            }
            return concurrentHashMap;
        }

        private final void getMergeValue(Map<String, Object> result, String key, Map<String, ? extends Object> map) {
            Object obj = result.get(key);
            Object obj2 = map.get(key);
            if (obj2 == null) {
                if (obj != null) {
                    result.put(key, obj);
                }
            } else if ((obj instanceof Map) && (obj2 instanceof Map)) {
                result.put(key, mergeMaps$bugsnag_android_core_release(CollectionsKt.listOf((Object[]) new Map[]{(Map) obj, (Map) obj2})));
            } else {
                result.put(key, obj2);
            }
        }

        public final Metadata merge(Metadata... data) {
            ArrayList arrayList = new ArrayList(data.length);
            int length = data.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                Metadata metadata = data[i2];
                i2++;
                arrayList.add(metadata.toMap());
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            int length2 = data.length;
            while (i < length2) {
                Metadata metadata2 = data[i];
                i++;
                CollectionsKt.addAll(arrayList3, metadata2.getJsonStreamer().getRedactedKeys());
            }
            Metadata metadata3 = new Metadata(TypeIntrinsics.asMutableMap(mergeMaps$bugsnag_android_core_release(arrayList2)));
            metadata3.setRedactedKeys(CollectionsKt.toSet(arrayList3));
            return metadata3;
        }
    }

    public final Metadata copy() {
        Metadata metadataCopy = copy(toMap());
        metadataCopy.setRedactedKeys(CollectionsKt.toSet(getRedactedKeys()));
        return metadataCopy;
    }

    public final TrimMetrics trimMetadataStringsTo(int maxStringLength) {
        Iterator<Map.Entry<String, Map<String, Object>>> it = this.store.entrySet().iterator();
        int itemsTrimmed = 0;
        int dataTrimmed = 0;
        while (it.hasNext()) {
            TrimMetrics trimMetricsTrimStringValuesTo = StringUtils.INSTANCE.trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableMap(it.next().getValue()));
            itemsTrimmed += trimMetricsTrimStringValuesTo.getItemsTrimmed();
            dataTrimmed += trimMetricsTrimStringValuesTo.getDataTrimmed();
        }
        return new TrimMetrics(itemsTrimmed, dataTrimmed);
    }
}
