package com.bugsnag.android;

import com.bugsnag.android.ErrorType;
import com.bugsnag.android.internal.DateUtils;
import com.bugsnag.android.internal.InternalMetricsImpl;
import com.bugsnag.android.internal.dag.ValueProvider;
import com.google.firebase.dynamiclinks.DynamicLink;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BugsnagEventMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0000¢\u0006\u0002\b\rJ#\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0000¢\u0006\u0002\b\u0011J#\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0000¢\u0006\u0002\b\u0015J%\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0000¢\u0006\u0002\b\u0019J%\u0010\u001a\u001a\u00020\u001b2\u0016\u0010\u0018\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0000¢\u0006\u0002\b\u001cJ)\u0010\u001d\u001a\u00020\u001e2\u001a\u0010\u001f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0 H\u0000¢\u0006\u0002\b!J#\u0010\"\u001a\u00020#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0000¢\u0006\u0002\b%J-\u0010&\u001a\u00020'2\u0016\u0010(\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0006\u0010)\u001a\u00020\fH\u0000¢\u0006\u0002\b*J-\u0010+\u001a\u00020,2\u0016\u0010(\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0006\u0010)\u001a\u00020\fH\u0000¢\u0006\u0002\b-J#\u0010.\u001a\u00020/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bH\u0000¢\u0006\u0002\b1J7\u00102\u001a\u0002032\u0016\u0010(\u001a\u0012\u0012\u0006\b\u0000\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0000¢\u0006\u0002\b8J\u0014\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\fH\u0002J\u0013\u0010<\u001a\u0004\u0018\u00010=*\u00020\fH\u0002¢\u0006\u0002\u0010>J*\u0010?\u001a\u0002H@\"\u0006\b\u0000\u0010@\u0018\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b2\u0006\u0010A\u001a\u00020\fH\u0082\b¢\u0006\u0002\u0010BJ\f\u0010C\u001a\u00020D*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006E"}, d2 = {"Lcom/bugsnag/android/BugsnagEventMapper;", "", "logger", "Lcom/bugsnag/android/Logger;", "(Lcom/bugsnag/android/Logger;)V", "ndkDateFormatHolder", "com/bugsnag/android/BugsnagEventMapper$ndkDateFormatHolder$1", "Lcom/bugsnag/android/BugsnagEventMapper$ndkDateFormatHolder$1;", "convertAppWithState", "Lcom/bugsnag/android/AppWithState;", "app", "", "", "convertAppWithState$bugsnag_android_core_release", "convertBreadcrumbInternal", "Lcom/bugsnag/android/BreadcrumbInternal;", "breadcrumb", "convertBreadcrumbInternal$bugsnag_android_core_release", "convertDeviceWithState", "Lcom/bugsnag/android/DeviceWithState;", "device", "convertDeviceWithState$bugsnag_android_core_release", "convertError", "Lcom/bugsnag/android/Error;", "error", "convertError$bugsnag_android_core_release", "convertErrorInternal", "Lcom/bugsnag/android/ErrorInternal;", "convertErrorInternal$bugsnag_android_core_release", "convertStacktrace", "Lcom/bugsnag/android/Stacktrace;", "trace", "", "convertStacktrace$bugsnag_android_core_release", "convertThread", "Lcom/bugsnag/android/ThreadInternal;", "thread", "convertThread$bugsnag_android_core_release", "convertToEvent", "Lcom/bugsnag/android/Event;", "map", DynamicLink.Builder.KEY_API_KEY, "convertToEvent$bugsnag_android_core_release", "convertToEventImpl", "Lcom/bugsnag/android/EventInternal;", "convertToEventImpl$bugsnag_android_core_release", "convertUser", "Lcom/bugsnag/android/User;", "user", "convertUser$bugsnag_android_core_release", "deserializeSeverityReason", "Lcom/bugsnag/android/SeverityReason;", "unhandled", "", "severity", "Lcom/bugsnag/android/Severity;", "deserializeSeverityReason$bugsnag_android_core_release", "parseTraceId", "Ljava/util/UUID;", "traceId", "parseUnsignedLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "readEntry", "T", "key", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "toDate", "Ljava/util/Date;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BugsnagEventMapper {
    private final Logger logger;
    private final BugsnagEventMapper$ndkDateFormatHolder$1 ndkDateFormatHolder = new ThreadLocal<DateFormat>() { // from class: com.bugsnag.android.BugsnagEventMapper$ndkDateFormatHolder$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bugsnag.android.BugsnagEventMapper$ndkDateFormatHolder$1] */
    public BugsnagEventMapper(Logger logger) {
        this.logger = logger;
    }

    public final Event convertToEvent$bugsnag_android_core_release(Map<? super String, ? extends Object> map, String apiKey) {
        return new Event(convertToEventImpl$bugsnag_android_core_release(map, apiKey), this.logger);
    }

    public final EventInternal convertToEventImpl$bugsnag_android_core_release(Map<? super String, ? extends Object> map, String apiKey) {
        EventInternal eventInternal = new EventInternal(apiKey, this.logger, null, null, null, null, null, null, null, null, null, null, null, 8188, null);
        Object obj = map.get("exceptions");
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            List<Error> errors = eventInternal.getErrors();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                errors.add(new Error(convertErrorInternal$bugsnag_android_core_release((Map) it.next()), this.logger));
            }
        }
        Object obj2 = map.get("user");
        if (!(obj2 instanceof Map)) {
            if (obj2 == null) {
                throw new IllegalStateException("cannot find json property 'user'");
            }
            throw new IllegalArgumentException("json property 'user' not of expected type, found " + ((Object) obj2.getClass().getName()));
        }
        eventInternal.setUserImpl$bugsnag_android_core_release(convertUser$bugsnag_android_core_release((Map) obj2));
        Object obj3 = map.get("metaData");
        Map mapEmptyMap = obj3 instanceof Map ? (Map) obj3 : null;
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        for (Map.Entry entry : mapEmptyMap.entrySet()) {
            eventInternal.addMetadata((String) entry.getKey(), (Map) entry.getValue());
        }
        Object obj4 = map.get("featureFlags");
        List<Map> listEmptyList = obj4 instanceof List ? (List) obj4 : null;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        for (Map map2 : listEmptyList) {
            Object obj5 = map2.get("featureFlag");
            if (!(obj5 instanceof String)) {
                if (obj5 == null) {
                    throw new IllegalStateException("cannot find json property 'featureFlag'");
                }
                throw new IllegalArgumentException("json property 'featureFlag' not of expected type, found " + ((Object) obj5.getClass().getName()));
            }
            String str = (String) obj5;
            Object obj6 = map2.get("variant");
            eventInternal.addFeatureFlag(str, obj6 instanceof String ? (String) obj6 : null);
        }
        Object obj7 = map.get("breadcrumbs");
        List listEmptyList2 = obj7 instanceof List ? (List) obj7 : null;
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        List<Breadcrumb> breadcrumbs = eventInternal.getBreadcrumbs();
        Iterator it2 = listEmptyList2.iterator();
        while (it2.hasNext()) {
            breadcrumbs.add(new Breadcrumb(convertBreadcrumbInternal$bugsnag_android_core_release((Map) it2.next()), this.logger));
        }
        Object obj8 = map.get("context");
        eventInternal.setContext(obj8 instanceof String ? (String) obj8 : null);
        Object obj9 = map.get("groupingHash");
        eventInternal.setGroupingHash(obj9 instanceof String ? (String) obj9 : null);
        Object obj10 = map.get("app");
        if (!(obj10 instanceof Map)) {
            if (obj10 == null) {
                throw new IllegalStateException("cannot find json property 'app'");
            }
            throw new IllegalArgumentException("json property 'app' not of expected type, found " + ((Object) obj10.getClass().getName()));
        }
        eventInternal.setApp(convertAppWithState$bugsnag_android_core_release((Map) obj10));
        Object obj11 = map.get("device");
        if (!(obj11 instanceof Map)) {
            if (obj11 == null) {
                throw new IllegalStateException("cannot find json property 'device'");
            }
            throw new IllegalArgumentException("json property 'device' not of expected type, found " + ((Object) obj11.getClass().getName()));
        }
        eventInternal.setDevice(convertDeviceWithState$bugsnag_android_core_release((Map) obj11));
        Object obj12 = map.get("session");
        Map map3 = obj12 instanceof Map ? (Map) obj12 : null;
        if (map3 != null) {
            eventInternal.session = new Session(map3, this.logger, apiKey);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        Object obj13 = map.get("threads");
        List list2 = obj13 instanceof List ? (List) obj13 : null;
        if (list2 != null) {
            List<Thread> threads = eventInternal.getThreads();
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                threads.add(new Thread(convertThread$bugsnag_android_core_release((Map) it3.next()), this.logger));
            }
        }
        Object obj14 = map.get("projectPackages");
        List list3 = obj14 instanceof List ? (List) obj14 : null;
        if (list3 != null) {
            eventInternal.setProjectPackages$bugsnag_android_core_release(list3);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Object obj15 = map.get("severity");
        if (!(obj15 instanceof String)) {
            if (obj15 == null) {
                throw new IllegalStateException("cannot find json property 'severity'");
            }
            throw new IllegalArgumentException("json property 'severity' not of expected type, found " + ((Object) obj15.getClass().getName()));
        }
        Severity severityFromDescriptor$bugsnag_android_core_release = Severity.INSTANCE.fromDescriptor$bugsnag_android_core_release((String) obj15);
        Object obj16 = map.get("unhandled");
        if (!(obj16 instanceof Boolean)) {
            if (obj16 == null) {
                throw new IllegalStateException("cannot find json property 'unhandled'");
            }
            throw new IllegalArgumentException("json property 'unhandled' not of expected type, found " + ((Object) obj16.getClass().getName()));
        }
        eventInternal.updateSeverityReasonInternal$bugsnag_android_core_release(deserializeSeverityReason$bugsnag_android_core_release(map, ((Boolean) obj16).booleanValue(), severityFromDescriptor$bugsnag_android_core_release));
        eventInternal.normalizeStackframeErrorTypes$bugsnag_android_core_release();
        eventInternal.setInternalMetrics(new InternalMetricsImpl(TypeIntrinsics.asMutableMap(map.get("usage"))));
        Object obj17 = map.get("correlation");
        Map map4 = obj17 instanceof Map ? (Map) obj17 : null;
        if (map4 != null) {
            UUID traceId = parseTraceId((String) map4.get("traceId"));
            String str2 = (String) map4.get("spanId");
            Long unsignedLong = str2 != null ? parseUnsignedLong(str2) : null;
            if (traceId != null && unsignedLong != null) {
                eventInternal.setTraceCorrelation(new TraceCorrelation(traceId, unsignedLong.longValue()));
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        return eventInternal;
    }

    public final Error convertError$bugsnag_android_core_release(Map<? super String, ? extends Object> error) {
        return new Error(convertErrorInternal$bugsnag_android_core_release(error), this.logger);
    }

    public final User convertUser$bugsnag_android_core_release(Map<String, ? extends Object> user) {
        Object obj = user.get("id");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = user.get("email");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = user.get("name");
        return new User(str, str2, obj3 instanceof String ? (String) obj3 : null);
    }

    public final AppWithState convertAppWithState$bugsnag_android_core_release(Map<String, ? extends Object> app) {
        Object obj = app.get("binaryArch");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = app.get("id");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = app.get("releaseStage");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = app.get("version");
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = app.get("codeBundleId");
        String str5 = obj5 instanceof String ? (String) obj5 : null;
        Object obj6 = app.get("buildUUID");
        String str6 = obj6 instanceof String ? (String) obj6 : null;
        ValueProvider valueProvider = str6 == null ? null : new ValueProvider(str6);
        Object obj7 = app.get("type");
        String str7 = obj7 instanceof String ? (String) obj7 : null;
        Object obj8 = app.get("versionCode");
        Number number = obj8 instanceof Number ? (Number) obj8 : null;
        Integer numValueOf = number == null ? null : Integer.valueOf(number.intValue());
        Object obj9 = app.get("duration");
        Number number2 = obj9 instanceof Number ? (Number) obj9 : null;
        Long lValueOf = number2 == null ? null : Long.valueOf(number2.longValue());
        Object obj10 = app.get("durationInForeground");
        Number number3 = obj10 instanceof Number ? (Number) obj10 : null;
        Long lValueOf2 = number3 == null ? null : Long.valueOf(number3.longValue());
        Object obj11 = app.get("inForeground");
        Boolean bool = obj11 instanceof Boolean ? (Boolean) obj11 : null;
        Object obj12 = app.get("isLaunching");
        return new AppWithState(str, str2, str3, str4, str5, valueProvider, str7, numValueOf, lValueOf, lValueOf2, bool, obj12 instanceof Boolean ? (Boolean) obj12 : null);
    }

    public final DeviceWithState convertDeviceWithState$bugsnag_android_core_release(Map<String, ? extends Object> device) {
        String[] strArr;
        Object obj = device.get("manufacturer");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = device.get("model");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = device.get("osVersion");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = device.get("cpuAbi");
        List list = obj4 instanceof List ? (List) obj4 : null;
        if (list == null) {
            strArr = null;
        } else {
            Object[] array = list.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            strArr = (String[]) array;
        }
        DeviceBuildInfo deviceBuildInfo = new DeviceBuildInfo(str, str2, str3, null, null, null, null, null, strArr);
        Object obj5 = device.get("jailbroken");
        Boolean bool = obj5 instanceof Boolean ? (Boolean) obj5 : null;
        Object obj6 = device.get("id");
        String str4 = obj6 instanceof String ? (String) obj6 : null;
        Object obj7 = device.get("locale");
        String str5 = obj7 instanceof String ? (String) obj7 : null;
        Object obj8 = device.get("totalMemory");
        Number number = obj8 instanceof Number ? (Number) obj8 : null;
        Long lValueOf = number == null ? null : Long.valueOf(number.longValue());
        Object obj9 = device.get("runtimeVersions");
        Map map = obj9 instanceof Map ? (Map) obj9 : null;
        LinkedHashMap mutableMap = map == null ? null : MapsKt.toMutableMap(map);
        if (mutableMap == null) {
            mutableMap = new LinkedHashMap();
        }
        Map map2 = mutableMap;
        Object obj10 = device.get("freeDisk");
        Number number2 = obj10 instanceof Number ? (Number) obj10 : null;
        Long lValueOf2 = number2 == null ? null : Long.valueOf(number2.longValue());
        Object obj11 = device.get("freeMemory");
        Number number3 = obj11 instanceof Number ? (Number) obj11 : null;
        Long lValueOf3 = number3 == null ? null : Long.valueOf(number3.longValue());
        Object obj12 = device.get("orientation");
        String str6 = obj12 instanceof String ? (String) obj12 : null;
        Object obj13 = device.get("time");
        String str7 = obj13 instanceof String ? (String) obj13 : null;
        return new DeviceWithState(deviceBuildInfo, bool, str4, str5, lValueOf, map2, lValueOf2, lValueOf3, str6, str7 == null ? null : toDate(str7));
    }

    public final ThreadInternal convertThread$bugsnag_android_core_release(Map<String, ? extends Object> thread) {
        String strValueOf = String.valueOf(thread.get("id"));
        Object obj = thread.get("name");
        if (!(obj instanceof String)) {
            if (obj == null) {
                throw new IllegalStateException("cannot find json property 'name'");
            }
            throw new IllegalArgumentException("json property 'name' not of expected type, found " + ((Object) obj.getClass().getName()));
        }
        String str = (String) obj;
        ErrorType.Companion companion = ErrorType.INSTANCE;
        Object obj2 = thread.get("type");
        if (!(obj2 instanceof String)) {
            if (obj2 == null) {
                throw new IllegalStateException("cannot find json property 'type'");
            }
            throw new IllegalArgumentException("json property 'type' not of expected type, found " + ((Object) obj2.getClass().getName()));
        }
        ErrorType errorTypeFromDescriptor = companion.fromDescriptor((String) obj2);
        if (errorTypeFromDescriptor == null) {
            errorTypeFromDescriptor = ErrorType.ANDROID;
        }
        ErrorType errorType = errorTypeFromDescriptor;
        boolean zAreEqual = kotlin.jvm.internal.Intrinsics.areEqual(thread.get("errorReportingThread"), (Object) true);
        Object obj3 = thread.get("state");
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        if (str2 == null) {
            str2 = "";
        }
        Object obj4 = thread.get("stacktrace");
        List<? extends Map<String, ? extends Object>> list = obj4 instanceof List ? (List) obj4 : null;
        Stacktrace stacktraceConvertStacktrace$bugsnag_android_core_release = list != null ? convertStacktrace$bugsnag_android_core_release(list) : null;
        return new ThreadInternal(strValueOf, str, errorType, zAreEqual, str2, stacktraceConvertStacktrace$bugsnag_android_core_release == null ? new Stacktrace(new ArrayList()) : stacktraceConvertStacktrace$bugsnag_android_core_release);
    }

    public final Stacktrace convertStacktrace$bugsnag_android_core_release(List<? extends Map<String, ? extends Object>> trace) {
        ArrayList arrayList = new ArrayList(trace.size());
        Iterator<T> it = trace.iterator();
        while (it.hasNext()) {
            arrayList.add(new Stackframe((Map<String, ? extends Object>) it.next()));
        }
        return new Stacktrace(arrayList);
    }

    private final /* synthetic */ <T> T readEntry(Map<?, ?> map, String str) {
        T t = (T) map.get(str);
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(3, "T");
        if (t instanceof Object) {
            return t;
        }
        if (t == null) {
            throw new IllegalStateException("cannot find json property '" + str + '\'');
        }
        throw new IllegalArgumentException("json property '" + str + "' not of expected type, found " + ((Object) t.getClass().getName()));
    }

    private final Date toDate(String str) throws ParseException {
        if ((str.length() > 0) && str.charAt(0) == 't') {
            String strSubstring = str.substring(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            Long longOrNull = StringsKt.toLongOrNull(strSubstring);
            if (longOrNull != null) {
                return new Date(longOrNull.longValue());
            }
        }
        try {
            return DateUtils.fromIso8601(str);
        } catch (IllegalArgumentException unused) {
            DateFormat dateFormat = get();
            kotlin.jvm.internal.Intrinsics.checkNotNull(dateFormat);
            Date date = dateFormat.parse(str);
            if (date != null) {
                return date;
            }
            throw new IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("cannot parse date ", str));
        }
    }

    private final UUID parseTraceId(String traceId) {
        if (!(traceId != null && traceId.length() == 32)) {
            return null;
        }
        String strSubstring = traceId.substring(0, 16);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        Long unsignedLong = parseUnsignedLong(strSubstring);
        if (unsignedLong == null) {
            return null;
        }
        long jLongValue = unsignedLong.longValue();
        String strSubstring2 = traceId.substring(16);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        Long unsignedLong2 = parseUnsignedLong(strSubstring2);
        if (unsignedLong2 == null) {
            return null;
        }
        return new UUID(jLongValue, unsignedLong2.longValue());
    }

    private final Long parseUnsignedLong(String str) {
        if (str.length() != 16) {
            return null;
        }
        try {
            String strSubstring = str.substring(0, 2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            long j = Long.parseLong(strSubstring, CharsKt.checkRadix(16)) << 56;
            String strSubstring2 = str.substring(2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            return Long.valueOf(Long.parseLong(strSubstring2, CharsKt.checkRadix(16)) | j);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final ErrorInternal convertErrorInternal$bugsnag_android_core_release(Map<? super String, ? extends Object> error) {
        Object obj = error.get("errorClass");
        if (!(obj instanceof String)) {
            if (obj == null) {
                throw new IllegalStateException("cannot find json property 'errorClass'");
            }
            throw new IllegalArgumentException("json property 'errorClass' not of expected type, found " + ((Object) obj.getClass().getName()));
        }
        String str = (String) obj;
        Object obj2 = error.get("message");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = error.get("type");
        if (!(obj3 instanceof String)) {
            if (obj3 == null) {
                throw new IllegalStateException("cannot find json property 'type'");
            }
            throw new IllegalArgumentException("json property 'type' not of expected type, found " + ((Object) obj3.getClass().getName()));
        }
        String str3 = (String) obj3;
        ErrorType errorTypeFromDescriptor = ErrorType.INSTANCE.fromDescriptor(str3);
        if (errorTypeFromDescriptor == null) {
            throw new IllegalArgumentException("unknown ErrorType: '" + str3 + '\'');
        }
        Object obj4 = error.get("stacktrace");
        if (obj4 instanceof List) {
            return new ErrorInternal(str, str2, convertStacktrace$bugsnag_android_core_release((List) obj4), errorTypeFromDescriptor);
        }
        if (obj4 == null) {
            throw new IllegalStateException("cannot find json property 'stacktrace'");
        }
        throw new IllegalArgumentException("json property 'stacktrace' not of expected type, found " + ((Object) obj4.getClass().getName()));
    }

    public final BreadcrumbInternal convertBreadcrumbInternal$bugsnag_android_core_release(Map<String, ? extends Object> breadcrumb) {
        Object obj = breadcrumb.get("name");
        if (!(obj instanceof String)) {
            if (obj == null) {
                throw new IllegalStateException("cannot find json property 'name'");
            }
            throw new IllegalArgumentException("json property 'name' not of expected type, found " + ((Object) obj.getClass().getName()));
        }
        String str = (String) obj;
        Object obj2 = breadcrumb.get("type");
        if (!(obj2 instanceof String)) {
            if (obj2 == null) {
                throw new IllegalStateException("cannot find json property 'type'");
            }
            throw new IllegalArgumentException("json property 'type' not of expected type, found " + ((Object) obj2.getClass().getName()));
        }
        BreadcrumbType breadcrumbTypeFromDescriptor$bugsnag_android_core_release = BreadcrumbType.INSTANCE.fromDescriptor$bugsnag_android_core_release((String) obj2);
        if (breadcrumbTypeFromDescriptor$bugsnag_android_core_release == null) {
            breadcrumbTypeFromDescriptor$bugsnag_android_core_release = BreadcrumbType.MANUAL;
        }
        Object obj3 = breadcrumb.get("metaData");
        Map map = TypeIntrinsics.isMutableMap(obj3) ? (Map) obj3 : null;
        Object obj4 = breadcrumb.get("timestamp");
        if (obj4 instanceof String) {
            return new BreadcrumbInternal(str, breadcrumbTypeFromDescriptor$bugsnag_android_core_release, map, toDate((String) obj4));
        }
        if (obj4 == null) {
            throw new IllegalStateException("cannot find json property 'timestamp'");
        }
        throw new IllegalArgumentException("json property 'timestamp' not of expected type, found " + ((Object) obj4.getClass().getName()));
    }

    public final SeverityReason deserializeSeverityReason$bugsnag_android_core_release(Map<? super String, ? extends Object> map, boolean unhandled, Severity severity) {
        Set setEntrySet;
        Object obj = map.get("severityReason");
        if (!(obj instanceof Map)) {
            if (obj == null) {
                throw new IllegalStateException("cannot find json property 'severityReason'");
            }
            throw new IllegalArgumentException("json property 'severityReason' not of expected type, found " + ((Object) obj.getClass().getName()));
        }
        Map map2 = (Map) obj;
        Object obj2 = map2.get("unhandledOverridden");
        if (!(obj2 instanceof Boolean)) {
            if (obj2 == null) {
                throw new IllegalStateException("cannot find json property 'unhandledOverridden'");
            }
            throw new IllegalArgumentException("json property 'unhandledOverridden' not of expected type, found " + ((Object) obj2.getClass().getName()));
        }
        boolean zBooleanValue = ((Boolean) obj2).booleanValue();
        Object obj3 = map2.get("type");
        if (!(obj3 instanceof String)) {
            if (obj3 == null) {
                throw new IllegalStateException("cannot find json property 'type'");
            }
            throw new IllegalArgumentException("json property 'type' not of expected type, found " + ((Object) obj3.getClass().getName()));
        }
        String str = (String) obj3;
        boolean z = zBooleanValue ? !unhandled : unhandled;
        Object obj4 = map2.get("attributes");
        if (obj4 != null ? obj4 instanceof Map : true) {
            Map map3 = (Map) obj4;
            Map.Entry entry = (map3 == null || (setEntrySet = map3.entrySet()) == null) ? null : (Map.Entry) CollectionsKt.singleOrNull(setEntrySet);
            return new SeverityReason(str, severity, unhandled, z, entry == null ? null : (String) entry.getValue(), entry == null ? null : (String) entry.getKey());
        }
        if (obj4 == null) {
            throw new IllegalStateException("cannot find json property 'attributes'");
        }
        throw new IllegalArgumentException("json property 'attributes' not of expected type, found " + ((Object) obj4.getClass().getName()));
    }
}
