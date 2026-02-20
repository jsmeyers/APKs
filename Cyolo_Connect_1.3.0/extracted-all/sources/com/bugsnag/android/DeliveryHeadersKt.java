package com.bugsnag.android;

import com.bugsnag.android.internal.DateUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: DeliveryHeaders.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0016\u0010\f\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0000\u001a\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"HEADER_API_KEY", "", "HEADER_API_PAYLOAD_VERSION", "HEADER_BUGSNAG_INTEGRITY", "HEADER_BUGSNAG_SENT_AT", "HEADER_BUGSNAG_STACKTRACE_TYPES", "HEADER_CONTENT_TYPE", "HEADER_INTERNAL_ERROR", "errorApiHeaders", "", "payload", "Lcom/bugsnag/android/EventPayload;", "serializeErrorTypeHeader", "errorTypes", "", "Lcom/bugsnag/android/ErrorType;", "sessionApiHeaders", DynamicLink.Builder.KEY_API_KEY, "bugsnag-android-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DeliveryHeadersKt {
    public static final String HEADER_API_KEY = "Bugsnag-Api-Key";
    private static final String HEADER_API_PAYLOAD_VERSION = "Bugsnag-Payload-Version";
    public static final String HEADER_BUGSNAG_INTEGRITY = "Bugsnag-Integrity";
    private static final String HEADER_BUGSNAG_SENT_AT = "Bugsnag-Sent-At";
    private static final String HEADER_BUGSNAG_STACKTRACE_TYPES = "Bugsnag-Stacktrace-Types";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_INTERNAL_ERROR = "Bugsnag-Internal-Error";

    public static final Map<String, String> errorApiHeaders(EventPayload eventPayload) {
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(HEADER_API_PAYLOAD_VERSION, "4.0");
        String apiKey = eventPayload.getApiKey();
        if (apiKey == null) {
            apiKey = "";
        }
        pairArr[1] = TuplesKt.to(HEADER_API_KEY, apiKey);
        pairArr[2] = TuplesKt.to(HEADER_BUGSNAG_SENT_AT, DateUtils.toIso8601(new Date()));
        pairArr[3] = TuplesKt.to("Content-Type", "application/json");
        Map mapMutableMapOf = MapsKt.mutableMapOf(pairArr);
        Set<ErrorType> errorTypes$bugsnag_android_core_release = eventPayload.getErrorTypes$bugsnag_android_core_release();
        if (!errorTypes$bugsnag_android_core_release.isEmpty()) {
            mapMutableMapOf.put(HEADER_BUGSNAG_STACKTRACE_TYPES, serializeErrorTypeHeader(errorTypes$bugsnag_android_core_release));
        }
        return MapsKt.toMap(mapMutableMapOf);
    }

    public static final String serializeErrorTypeHeader(Set<? extends ErrorType> set) {
        if (set.isEmpty()) {
            return "";
        }
        Set<? extends ErrorType> set2 = set;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(((ErrorType) it.next()).getDesc());
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            next = ((String) next) + ',' + ((String) it2.next());
        }
        return (String) next;
    }

    public static final Map<String, String> sessionApiHeaders(String str) {
        return MapsKt.mapOf(TuplesKt.to(HEADER_API_PAYLOAD_VERSION, "1.0"), TuplesKt.to(HEADER_API_KEY, str), TuplesKt.to("Content-Type", "application/json"), TuplesKt.to(HEADER_BUGSNAG_SENT_AT, DateUtils.toIso8601(new Date())));
    }
}
