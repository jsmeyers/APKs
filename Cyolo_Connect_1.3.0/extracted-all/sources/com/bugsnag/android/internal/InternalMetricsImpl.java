package com.bugsnag.android.internal;

import com.bugsnag.android.NdkPluginCaller;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: InternalMetricsImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u001c\u0010\u0019\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003H\u0016J\u001c\u0010\u001b\u001a\u00020\u00112\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bugsnag/android/internal/InternalMetricsImpl;", "Lcom/bugsnag/android/internal/InternalMetrics;", "source", "", "", "", "(Ljava/util/Map;)V", "breadcrumbBytesRemovedCount", "", "breadcrumbsRemovedCount", "callbackCounts", "", "configDifferences", "metadataCharsTruncatedCount", "metadataStringsTrimmedCount", "allCallbacks", "modifyCallback", "", "callback", "delta", "notifyAddCallback", "notifyRemoveCallback", "setBreadcrumbTrimMetrics", "breadcrumbsRemoved", "bytesRemoved", "setCallbackCounts", "newCallbackCounts", "setConfigDifferences", "differences", "setMetadataTrimMetrics", "stringsTrimmed", "charsRemoved", "toJsonableMap", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InternalMetricsImpl implements InternalMetrics {
    private int breadcrumbBytesRemovedCount;
    private int breadcrumbsRemovedCount;
    private final Map<String, Integer> callbackCounts;
    private final Map<String, Object> configDifferences;
    private int metadataCharsTruncatedCount;
    private int metadataStringsTrimmedCount;

    /* JADX WARN: Multi-variable type inference failed */
    public InternalMetricsImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public InternalMetricsImpl(Map<String, ? extends Object> map) {
        if (map != null) {
            HashMap mapAsMutableMap = TypeIntrinsics.asMutableMap(map.get("config"));
            this.configDifferences = mapAsMutableMap == null ? new HashMap() : mapAsMutableMap;
            HashMap mapAsMutableMap2 = TypeIntrinsics.asMutableMap(map.get("callbacks"));
            this.callbackCounts = mapAsMutableMap2 == null ? new HashMap() : mapAsMutableMap2;
            Map mapAsMutableMap3 = TypeIntrinsics.asMutableMap(map.get("system"));
            if (mapAsMutableMap3 != null) {
                Number number = (Number) mapAsMutableMap3.get("stringsTruncated");
                this.metadataStringsTrimmedCount = number == null ? 0 : number.intValue();
                Number number2 = (Number) mapAsMutableMap3.get("stringCharsTruncated");
                this.metadataCharsTruncatedCount = number2 == null ? 0 : number2.intValue();
                Number number3 = (Number) mapAsMutableMap3.get("breadcrumbsRemovedCount");
                this.breadcrumbsRemovedCount = number3 == null ? 0 : number3.intValue();
                Number number4 = (Number) mapAsMutableMap3.get("breadcrumbBytesRemoved");
                this.breadcrumbBytesRemovedCount = number4 != null ? number4.intValue() : 0;
                return;
            }
            return;
        }
        this.configDifferences = new HashMap();
        this.callbackCounts = new HashMap();
    }

    public /* synthetic */ InternalMetricsImpl(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public Map<String, Object> toJsonableMap() throws IllegalAccessException, InvocationTargetException {
        Map<String, Object> mapAllCallbacks = allCallbacks();
        Pair[] pairArr = new Pair[4];
        int i = this.metadataStringsTrimmedCount;
        pairArr[0] = i > 0 ? TuplesKt.to("stringsTruncated", Integer.valueOf(i)) : null;
        int i2 = this.metadataCharsTruncatedCount;
        pairArr[1] = i2 > 0 ? TuplesKt.to("stringCharsTruncated", Integer.valueOf(i2)) : null;
        int i3 = this.breadcrumbsRemovedCount;
        pairArr[2] = i3 > 0 ? TuplesKt.to("breadcrumbsRemoved", Integer.valueOf(i3)) : null;
        int i4 = this.breadcrumbBytesRemovedCount;
        pairArr[3] = i4 > 0 ? TuplesKt.to("breadcrumbBytesRemoved", Integer.valueOf(i4)) : null;
        Map map = MapsKt.toMap(CollectionsKt.listOfNotNull((Object[]) pairArr));
        Pair[] pairArr2 = new Pair[3];
        pairArr2[0] = this.configDifferences.isEmpty() ^ true ? TuplesKt.to("config", this.configDifferences) : null;
        pairArr2[1] = mapAllCallbacks.isEmpty() ^ true ? TuplesKt.to("callbacks", mapAllCallbacks) : null;
        pairArr2[2] = map.isEmpty() ^ true ? TuplesKt.to("system", map) : null;
        return MapsKt.toMap(CollectionsKt.listOfNotNull((Object[]) pairArr2));
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void setConfigDifferences(Map<String, ? extends Object> differences) throws IllegalAccessException, InvocationTargetException {
        this.configDifferences.clear();
        this.configDifferences.putAll(differences);
        NdkPluginCaller.INSTANCE.setStaticData(MapsKt.mapOf(TuplesKt.to("config", this.configDifferences)));
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void setCallbackCounts(Map<String, Integer> newCallbackCounts) throws IllegalAccessException, InvocationTargetException {
        this.callbackCounts.clear();
        this.callbackCounts.putAll(newCallbackCounts);
        NdkPluginCaller.INSTANCE.initCallbackCounts(newCallbackCounts);
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void notifyAddCallback(String callback) throws IllegalAccessException, InvocationTargetException {
        modifyCallback(callback, 1);
        NdkPluginCaller.INSTANCE.notifyAddCallback(callback);
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void notifyRemoveCallback(String callback) throws IllegalAccessException, InvocationTargetException {
        modifyCallback(callback, -1);
        NdkPluginCaller.INSTANCE.notifyRemoveCallback(callback);
    }

    private final void modifyCallback(String callback, int delta) {
        Integer num = this.callbackCounts.get(callback);
        this.callbackCounts.put(callback, Integer.valueOf(RangesKt.coerceAtLeast((num == null ? 0 : num.intValue()) + delta, 0)));
    }

    private final Map<String, Object> allCallbacks() throws IllegalAccessException, InvocationTargetException {
        Integer num;
        HashMap map = new HashMap();
        map.putAll(this.callbackCounts);
        Map<String, Integer> currentCallbackSetCounts = NdkPluginCaller.INSTANCE.getCurrentCallbackSetCounts();
        if (currentCallbackSetCounts != null && (num = currentCallbackSetCounts.get("ndkOnError")) != null) {
            map.put("ndkOnError", num);
        }
        Map<String, Boolean> currentNativeApiCallUsage = NdkPluginCaller.INSTANCE.getCurrentNativeApiCallUsage();
        if (currentNativeApiCallUsage != null) {
            map.putAll(currentNativeApiCallUsage);
        }
        return map;
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void setMetadataTrimMetrics(int stringsTrimmed, int charsRemoved) {
        this.metadataStringsTrimmedCount = stringsTrimmed;
        this.metadataCharsTruncatedCount = charsRemoved;
    }

    @Override // com.bugsnag.android.internal.InternalMetrics
    public void setBreadcrumbTrimMetrics(int breadcrumbsRemoved, int bytesRemoved) {
        this.breadcrumbsRemovedCount = breadcrumbsRemoved;
        this.breadcrumbBytesRemovedCount = bytesRemoved;
    }
}
