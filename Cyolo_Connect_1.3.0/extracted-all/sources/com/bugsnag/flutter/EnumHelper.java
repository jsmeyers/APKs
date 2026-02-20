package com.bugsnag.flutter;

import androidx.core.app.NotificationCompat;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.Telemetry;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
class EnumHelper {
    private static final Map<String, BreadcrumbType> dartBreadcrumbTypes;
    private static final Map<String, Telemetry> dartTelemetry;

    static {
        HashMap map = new HashMap();
        dartBreadcrumbTypes = map;
        HashMap map2 = new HashMap();
        dartTelemetry = map2;
        map.put(NotificationCompat.CATEGORY_NAVIGATION, BreadcrumbType.NAVIGATION);
        map.put("request", BreadcrumbType.REQUEST);
        map.put("process", BreadcrumbType.PROCESS);
        map.put("log", BreadcrumbType.LOG);
        map.put("user", BreadcrumbType.USER);
        map.put("state", BreadcrumbType.STATE);
        map.put("error", BreadcrumbType.ERROR);
        map.put("manual", BreadcrumbType.MANUAL);
        map2.put("internalErrors", Telemetry.INTERNAL_ERRORS);
        map2.put("usage", Telemetry.USAGE);
    }

    private EnumHelper() {
    }

    static Set<BreadcrumbType> unwrapBreadcrumbTypes(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptySet();
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(BreadcrumbType.class);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            enumSetNoneOf.add(dartBreadcrumbTypes.get(jSONArray.optString(i)));
        }
        return enumSetNoneOf;
    }

    static Set<Telemetry> unwrapTelemetry(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptySet();
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(Telemetry.class);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            enumSetNoneOf.add(dartTelemetry.get(jSONArray.optString(i)));
        }
        return enumSetNoneOf;
    }
}
