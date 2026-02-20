package com.bugsnag.flutter;

import android.content.Context;
import android.util.Log;
import com.bugsnag.android.Breadcrumb;
import com.bugsnag.android.Bugsnag;
import com.bugsnag.android.Client;
import com.bugsnag.android.Configuration;
import com.bugsnag.android.EndpointConfiguration;
import com.bugsnag.android.ErrorTypes;
import com.bugsnag.android.Event;
import com.bugsnag.android.InternalHooks;
import com.bugsnag.android.LastRunInfo;
import com.bugsnag.android.Notifier;
import com.bugsnag.android.ThreadSendPolicy;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class BugsnagFlutter {
    private static boolean isAnyStarted = false;
    private static boolean isAttached = false;
    private InternalHooks client;
    Context context;
    private boolean isStarted = false;

    BugsnagFlutter() {
    }

    JSONObject attach(JSONObject jSONObject) throws Exception {
        JSONObject jSONObjectPut = new JSONObject().put("config", new JSONObject().put("enabledErrorTypes", new JSONObject().put("dartErrors", BugsnagFlutterConfiguration.enabledErrorTypes.dartErrors)));
        if (isAttached) {
            Log.i("BugsnagFlutter", "bugsnag.attach() has already been called. Ignoring.");
            return jSONObjectPut;
        }
        Client client = InternalHooks.getClient();
        if (client == null) {
            throw new IllegalStateException("bugsnag.attach() can only be called once the native layer has already been started, have you called Bugsnag.start() from your Android code?");
        }
        this.client = new InternalHooks(client);
        if (jSONObject != null && jSONObject.has("notifier")) {
            Notifier notifier = this.client.getNotifier();
            JSONObject jSONObject2 = jSONObject.getJSONObject("notifier");
            notifier.setName(jSONObject2.getString("name"));
            notifier.setVersion(jSONObject2.getString("version"));
            notifier.setUrl(jSONObject2.getString(ImagesContract.URL));
            notifier.setDependencies(Collections.singletonList(new Notifier()));
        }
        isAttached = true;
        return jSONObjectPut;
    }

    Void start(JSONObject jSONObject) throws Exception {
        Configuration configurationLoad;
        if (this.isStarted) {
            Log.w("BugsnagFlutter", "bugsnag.start() was called more than once. Ignoring.");
            return null;
        }
        if (isAnyStarted) {
            Log.i("BugsnagFlutter", "bugsnag.start() was called from a previous Flutter context. Ignoring.");
            return null;
        }
        if (InternalHooks.getClient() != null) {
            throw new IllegalStateException("bugsnag.start() may not be called after starting Bugsnag natively");
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.has(DynamicLink.Builder.KEY_API_KEY)) {
            configurationLoad = new Configuration(jSONObject.getString(DynamicLink.Builder.KEY_API_KEY));
        } else {
            configurationLoad = Configuration.load(this.context);
        }
        configurationLoad.setAppType(getString(jSONObject, "appType", configurationLoad.getAppType()));
        configurationLoad.setAppVersion(getString(jSONObject, "appVersion", configurationLoad.getAppVersion()));
        configurationLoad.setAutoTrackSessions(jSONObject.optBoolean("autoTrackSessions", configurationLoad.getAutoTrackSessions()));
        configurationLoad.setAutoDetectErrors(jSONObject.optBoolean("autoDetectErrors", configurationLoad.getAutoDetectErrors()));
        configurationLoad.setContext(getString(jSONObject, "context", configurationLoad.getContext()));
        configurationLoad.setLaunchDurationMillis(jSONObject.optLong("launchDurationMillis", configurationLoad.getLaunchDurationMillis()));
        configurationLoad.setSendLaunchCrashesSynchronously(jSONObject.optBoolean("sendLaunchCrashesSynchronously", configurationLoad.getSendLaunchCrashesSynchronously()));
        configurationLoad.setMaxBreadcrumbs(jSONObject.optInt("maxBreadcrumbs", configurationLoad.getMaxBreadcrumbs()));
        configurationLoad.setMaxPersistedEvents(jSONObject.optInt("maxPersistedEvents", configurationLoad.getMaxPersistedEvents()));
        configurationLoad.setMaxPersistedSessions(jSONObject.optInt("maxPersistedSessions", configurationLoad.getMaxPersistedSessions()));
        configurationLoad.setMaxStringValueLength(jSONObject.optInt("maxStringValueLength", configurationLoad.getMaxStringValueLength()));
        configurationLoad.setReleaseStage(getString(jSONObject, "releaseStage", configurationLoad.getReleaseStage()));
        configurationLoad.setPersistUser(jSONObject.optBoolean("persistUser", configurationLoad.getPersistUser()));
        if (jSONObject.has("redactedKeys")) {
            configurationLoad.setRedactedKeys((Set) JsonHelper.unwrap(jSONObject.optJSONArray("redactedKeys"), new HashSet()));
        }
        if (jSONObject.has("discardClasses")) {
            configurationLoad.setDiscardClasses((Set) JsonHelper.unwrap(jSONObject.optJSONArray("discardClasses"), new HashSet()));
        }
        if (jSONObject.has("enabledReleaseStages")) {
            configurationLoad.setEnabledReleaseStages((Set) JsonHelper.unwrap(jSONObject.optJSONArray("enabledReleaseStages"), new HashSet()));
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("user");
        if (jSONObjectOptJSONObject != null) {
            configurationLoad.setUser(getString(jSONObjectOptJSONObject, "id"), getString(jSONObjectOptJSONObject, "email"), getString(jSONObjectOptJSONObject, "name"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("endpoints");
        if (jSONObjectOptJSONObject2 != null) {
            configurationLoad.setEndpoints(new EndpointConfiguration(jSONObjectOptJSONObject2.getString("notify"), jSONObjectOptJSONObject2.getString("sessions")));
        }
        String strOptString = jSONObject.optString("sendThreads");
        if (strOptString.equals("always")) {
            configurationLoad.setSendThreads(ThreadSendPolicy.ALWAYS);
        } else if (strOptString.equals("unhandledOnly")) {
            configurationLoad.setSendThreads(ThreadSendPolicy.UNHANDLED_ONLY);
        } else if (strOptString.equals("never")) {
            configurationLoad.setSendThreads(ThreadSendPolicy.NEVER);
        }
        configurationLoad.setEnabledBreadcrumbTypes(EnumHelper.unwrapBreadcrumbTypes(jSONObject.optJSONArray("enabledBreadcrumbTypes")));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("enabledErrorTypes");
        if (jSONObjectOptJSONObject3 != null) {
            ErrorTypes errorTypes = new ErrorTypes();
            errorTypes.setUnhandledExceptions(jSONObjectOptJSONObject3.optBoolean("unhandledExceptions"));
            errorTypes.setNdkCrashes(jSONObjectOptJSONObject3.optBoolean("crashes"));
            errorTypes.setAnrs(jSONObjectOptJSONObject3.optBoolean("anrs"));
            configurationLoad.setEnabledErrorTypes(errorTypes);
        }
        JsonHelper.unpackMetadata(jSONObject.optJSONObject("metadata"), configurationLoad);
        configurationLoad.addFeatureFlags(JsonHelper.unpackFeatureFlags(jSONObject.optJSONArray("featureFlags")));
        Notifier notifier = InternalHooks.getNotifier(configurationLoad);
        if (jSONObject.has("notifier")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("notifier");
            notifier.setName(jSONObject2.getString("name"));
            notifier.setVersion(jSONObject2.getString("version"));
            notifier.setUrl(jSONObject2.getString(ImagesContract.URL));
            notifier.setDependencies(Collections.singletonList(new Notifier()));
        }
        if (jSONObject.has("persistenceDirectory")) {
            configurationLoad.setPersistenceDirectory(new File(jSONObject.getString("persistenceDirectory")));
        }
        if (jSONObject.has("projectPackages")) {
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("projectPackages");
            JSONArray jSONArray = jSONObjectOptJSONObject4.getJSONArray("packageNames");
            int length = jSONArray.length();
            LinkedHashSet linkedHashSet = new LinkedHashSet(length);
            for (int i = 0; i < length; i++) {
                linkedHashSet.add(jSONArray.getString(i));
            }
            if (jSONObjectOptJSONObject4.optBoolean("includeDefaults")) {
                linkedHashSet.add(this.context.getPackageName());
            }
            configurationLoad.setProjectPackages(linkedHashSet);
        }
        if (jSONObject.has("telemetry")) {
            configurationLoad.setTelemetry(EnumHelper.unwrapTelemetry(jSONObject.optJSONArray("telemetry")));
        }
        if (jSONObject.has("versionCode")) {
            configurationLoad.setVersionCode(Integer.valueOf(jSONObject.getInt("versionCode")));
        }
        this.client = new InternalHooks(Bugsnag.start(this.context, configurationLoad));
        isAnyStarted = true;
        this.isStarted = true;
        return null;
    }

    JSONObject getUser(JSONObject jSONObject) {
        return JsonHelper.toJson(Bugsnag.getUser());
    }

    Void setUser(JSONObject jSONObject) {
        if (jSONObject != null) {
            Bugsnag.setUser(getString(jSONObject, "id"), getString(jSONObject, "email"), getString(jSONObject, "name"));
        } else {
            Bugsnag.setUser(null, null, null);
        }
        return null;
    }

    Void setContext(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Bugsnag.setContext(getString(jSONObject, "context"));
        return null;
    }

    String getContext(JSONObject jSONObject) {
        return Bugsnag.getContext();
    }

    Void leaveBreadcrumb(JSONObject jSONObject) throws Exception {
        if (jSONObject == null || !hasString(jSONObject, "name") || !jSONObject.has("metaData") || !hasString(jSONObject, "type")) {
            return null;
        }
        Bugsnag.leaveBreadcrumb(jSONObject.getString("name"), JsonHelper.unwrap(jSONObject.getJSONObject("metaData")), JsonHelper.unpackBreadcrumbType(jSONObject.getString("type")));
        return null;
    }

    JSONArray getBreadcrumbs(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Breadcrumb> it = Bugsnag.getBreadcrumbs().iterator();
        while (it.hasNext()) {
            jSONArray.put(JsonHelper.toJson(it.next()));
        }
        return jSONArray;
    }

    Void addFeatureFlags(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        Bugsnag.addFeatureFlags(JsonHelper.unpackFeatureFlags(jSONArray));
        return null;
    }

    Void clearFeatureFlag(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !hasString(jSONObject, "name")) {
            return null;
        }
        Bugsnag.clearFeatureFlag(jSONObject.getString("name"));
        return null;
    }

    Void clearFeatureFlags(JSONObject jSONObject) {
        Bugsnag.clearFeatureFlags();
        return null;
    }

    Void addMetadata(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && hasString(jSONObject, "section") && jSONObject.has("metadata")) {
            Bugsnag.addMetadata(jSONObject.getString("section"), JsonHelper.unwrap(jSONObject.getJSONObject("metadata")));
        }
        return null;
    }

    Void clearMetadata(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && hasString(jSONObject, "section")) {
            if (hasString(jSONObject, "key")) {
                Bugsnag.clearMetadata(jSONObject.getString("section"), jSONObject.getString("key"));
            } else {
                Bugsnag.clearMetadata(jSONObject.getString("section"));
            }
        }
        return null;
    }

    JSONObject getMetadata(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !hasString(jSONObject, "section")) {
            return null;
        }
        return JsonHelper.wrap(Bugsnag.getMetadata(jSONObject.getString("section")));
    }

    Void startSession(Void r1) {
        Bugsnag.startSession();
        return null;
    }

    Void pauseSession(Void r1) {
        Bugsnag.pauseSession();
        return null;
    }

    Boolean resumeSession(Void r1) {
        return Boolean.valueOf(Bugsnag.resumeSession());
    }

    Void markLaunchCompleted(Void r1) {
        Bugsnag.markLaunchCompleted();
        return null;
    }

    JSONObject getLastRunInfo(Void r4) throws JSONException {
        LastRunInfo lastRunInfo = Bugsnag.getLastRunInfo();
        if (lastRunInfo == null) {
            return null;
        }
        return new JSONObject().put("consecutiveLaunchCrashes", lastRunInfo.getConsecutiveLaunchCrashes()).put("crashed", lastRunInfo.getCrashed()).put("crashedDuringLaunch", lastRunInfo.getCrashedDuringLaunch());
    }

    JSONObject createEvent(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("error")) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("error");
        boolean zOptBoolean = jSONObject.optBoolean("deliver");
        if (zOptBoolean && this.client.shouldDiscardError(jSONObject2)) {
            return null;
        }
        boolean zOptBoolean2 = jSONObject.optBoolean("unhandled");
        InternalHooks internalHooks = this.client;
        Event eventCreateEvent = internalHooks.createEvent(internalHooks.createSeverityReason(zOptBoolean2 ? "unhandledException" : "handledException"));
        eventCreateEvent.getErrors().add(this.client.unmapError(JsonHelper.unwrap(jSONObject2)));
        Map<String, ?> mapUnwrap = JsonHelper.unwrap(jSONObject.optJSONObject("flutterMetadata"));
        if (mapUnwrap instanceof Map) {
            eventCreateEvent.addMetadata("flutter", mapUnwrap);
        }
        if (zOptBoolean) {
            this.client.deliverEvent(eventCreateEvent);
            return null;
        }
        return this.client.mapEvent(eventCreateEvent);
    }

    JSONObject deliverEvent(JSONObject jSONObject) {
        if (jSONObject == null || this.client.shouldDiscardEvent(jSONObject)) {
            return null;
        }
        this.client.deliverEvent(this.client.unmapEvent(JsonHelper.unwrap(jSONObject)));
        return null;
    }

    String getString(JSONObject jSONObject, String str) {
        Object objOpt = jSONObject.opt(str);
        if (objOpt instanceof String) {
            return (String) objOpt;
        }
        return null;
    }

    String getString(JSONObject jSONObject, String str, String str2) {
        String string = getString(jSONObject, str);
        return string != null ? string : str2;
    }

    boolean hasString(JSONObject jSONObject, String str) {
        return getString(jSONObject, str) != null;
    }
}
