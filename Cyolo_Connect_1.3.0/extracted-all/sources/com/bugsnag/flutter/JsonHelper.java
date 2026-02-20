package com.bugsnag.flutter;

import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.FeatureFlag;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.MetadataAware;
import io.flutter.plugin.common.JSONUtil;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonHelper {
    private JsonHelper() {
    }

    public static JSONObject toJson(JsonStream.Streamable streamable) {
        StringWriter stringWriter = new StringWriter();
        try {
            streamable.toStream(new JsonStream(stringWriter));
            return new JSONObject(stringWriter.toString());
        } catch (IOException | JSONException unused) {
            return null;
        }
    }

    public static Map<String, Object> unwrap(JSONObject jSONObject) {
        return (Map) JSONUtil.unwrap(jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E, C extends Collection<E>> C unwrap(JSONArray jSONArray, C c) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                c.add(JSONUtil.unwrap(jSONArray.opt(i)));
            }
        }
        return c;
    }

    public static JSONObject wrap(Map<? super String, Object> map) {
        return (JSONObject) JSONUtil.wrap(map);
    }

    public static void unpackMetadata(JSONObject jSONObject, MetadataAware metadataAware) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null) {
                metadataAware.addMetadata(next, unwrap(jSONObjectOptJSONObject));
            }
        }
    }

    public static List<FeatureFlag> unpackFeatureFlags(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            arrayList.add(new FeatureFlag(jSONObjectOptJSONObject.optString("featureFlag"), (String) jSONObjectOptJSONObject.opt("variant")));
        }
        return arrayList;
    }

    public static BreadcrumbType unpackBreadcrumbType(String str) {
        str.hashCode();
        switch (str) {
            case "process":
                return BreadcrumbType.PROCESS;
            case "log":
                return BreadcrumbType.LOG;
            case "user":
                return BreadcrumbType.USER;
            case "error":
                return BreadcrumbType.ERROR;
            case "state":
                return BreadcrumbType.STATE;
            case "request":
                return BreadcrumbType.REQUEST;
            case "navigation":
                return BreadcrumbType.NAVIGATION;
            default:
                return BreadcrumbType.MANUAL;
        }
    }
}
