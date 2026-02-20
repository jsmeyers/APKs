package com.bugsnag.android;

import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.JsonHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class NativeInterface {
    private static Charset UTF8Charset = Charset.defaultCharset();
    private static Client client;

    private static Client getClient() {
        Client client2 = client;
        return client2 != null ? client2 : Bugsnag.getClient();
    }

    public static Event createEmptyEvent() {
        Client client2 = getClient();
        return new Event(new EventInternal(null, client2.getConfig(), SeverityReason.newInstance("handledException"), client2.getMetadataState().getMetadata().copy()), client2.getLogger());
    }

    public static void setClient(Client client2) {
        client = client2;
    }

    public static String getContext() {
        return getClient().getContext();
    }

    public static File getNativeReportPath() {
        return getNativeReportPath(getPersistenceDirectory());
    }

    private static File getNativeReportPath(File file) {
        return new File(file, "bugsnag/native");
    }

    private static File getPersistenceDirectory() {
        return getClient().getConfig().getPersistenceDirectory().getValue();
    }

    public static Map<String, String> getUser() {
        HashMap map = new HashMap();
        User userImpl = getClient().getUserImpl();
        map.put("id", userImpl.getId());
        map.put("name", userImpl.getName());
        map.put("email", userImpl.getEmail());
        return map;
    }

    public static Map<String, Object> getApp() {
        HashMap map = new HashMap();
        AppDataCollector appDataCollector = getClient().getAppDataCollector();
        AppWithState appWithStateGenerateAppWithState = appDataCollector.generateAppWithState();
        map.put("version", appWithStateGenerateAppWithState.getVersion());
        map.put("releaseStage", appWithStateGenerateAppWithState.getReleaseStage());
        map.put("id", appWithStateGenerateAppWithState.getId());
        map.put("type", appWithStateGenerateAppWithState.getType());
        map.put("buildUUID", appWithStateGenerateAppWithState.getBuildUuid());
        map.put("duration", appWithStateGenerateAppWithState.getDuration());
        map.put("durationInForeground", appWithStateGenerateAppWithState.getDurationInForeground());
        map.put("versionCode", appWithStateGenerateAppWithState.getVersionCode());
        map.put("inForeground", appWithStateGenerateAppWithState.getInForeground());
        map.put("isLaunching", appWithStateGenerateAppWithState.getIsLaunching());
        map.put("binaryArch", appWithStateGenerateAppWithState.getBinaryArch());
        map.putAll(appDataCollector.getAppDataMetadata());
        return map;
    }

    public static Map<String, Object> getDevice() {
        DeviceDataCollector deviceDataCollector = getClient().getDeviceDataCollector();
        HashMap map = new HashMap(deviceDataCollector.getDeviceMetadata());
        DeviceWithState deviceWithStateGenerateDeviceWithState = deviceDataCollector.generateDeviceWithState(new Date().getTime());
        map.put("freeDisk", deviceWithStateGenerateDeviceWithState.getFreeDisk());
        map.put("freeMemory", deviceWithStateGenerateDeviceWithState.getFreeMemory());
        map.put("orientation", deviceWithStateGenerateDeviceWithState.getOrientation());
        map.put("time", deviceWithStateGenerateDeviceWithState.getTime());
        map.put("cpuAbi", deviceWithStateGenerateDeviceWithState.getCpuAbi());
        map.put("jailbroken", deviceWithStateGenerateDeviceWithState.getJailbroken());
        map.put("id", deviceWithStateGenerateDeviceWithState.getId());
        map.put("locale", deviceWithStateGenerateDeviceWithState.getLocale());
        map.put("manufacturer", deviceWithStateGenerateDeviceWithState.getManufacturer());
        map.put("model", deviceWithStateGenerateDeviceWithState.getModel());
        map.put("osName", deviceWithStateGenerateDeviceWithState.getOsName());
        map.put("osVersion", deviceWithStateGenerateDeviceWithState.getOsVersion());
        map.put("runtimeVersions", deviceWithStateGenerateDeviceWithState.getRuntimeVersions());
        map.put("totalMemory", deviceWithStateGenerateDeviceWithState.getTotalMemory());
        return map;
    }

    public static String[] getCpuAbi() {
        return getClient().getDeviceDataCollector().getCpuAbi();
    }

    public static Map<String, Object> getMetadata() {
        return getClient().getMetadata();
    }

    public static List<Breadcrumb> getBreadcrumbs() {
        return getClient().getBreadcrumbs();
    }

    public static void setUser(String str, String str2, String str3) {
        getClient().setUser(str, str2, str3);
    }

    public static void setUser(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        setUser(bArr == null ? null : new String(bArr, UTF8Charset), bArr2 == null ? null : new String(bArr2, UTF8Charset), bArr3 != null ? new String(bArr3, UTF8Charset) : null);
    }

    public static void leaveBreadcrumb(String str, BreadcrumbType breadcrumbType) {
        if (str == null) {
            return;
        }
        getClient().leaveBreadcrumb(str, new HashMap(), breadcrumbType);
    }

    public static void leaveBreadcrumb(byte[] bArr, BreadcrumbType breadcrumbType) {
        if (bArr == null) {
            return;
        }
        getClient().leaveBreadcrumb(new String(bArr, UTF8Charset), new HashMap(), breadcrumbType);
    }

    public static void leaveBreadcrumb(String str, String str2, Map<String, Object> map) {
        getClient().leaveBreadcrumb(str, map, BreadcrumbType.valueOf(str2.toUpperCase(Locale.US)));
    }

    public static void clearMetadata(String str, String str2) {
        if (str2 == null) {
            getClient().clearMetadata(str);
        } else {
            getClient().clearMetadata(str, str2);
        }
    }

    public static void addMetadata(String str, String str2, Object obj) {
        getClient().addMetadata(str, str2, obj);
    }

    public static void addMetadata(String str, Map<String, ?> map) {
        getClient().addMetadata(str, map);
    }

    public static String getReleaseStage() {
        return getClient().getConfig().getReleaseStage();
    }

    public static String getSessionEndpoint() {
        return getClient().getConfig().getEndpoints().getSessions();
    }

    public static String getEndpoint() {
        return getClient().getConfig().getEndpoints().getNotify();
    }

    public static void setContext(String str) {
        getClient().setContext(str);
    }

    public static void setBinaryArch(String str) {
        getClient().setBinaryArch(str);
    }

    public static String getAppVersion() {
        return getClient().getConfig().getAppVersion();
    }

    public static Collection<String> getEnabledReleaseStages() {
        return getClient().getConfig().getEnabledReleaseStages();
    }

    public static void registerSession(long j, String str, int i, int i2) {
        Client client2 = getClient();
        client2.getSessionTracker().registerExistingSession(j > 0 ? new Date(j) : null, str, client2.getUserImpl(), i, i2);
    }

    public static boolean isDiscardErrorClass(String str) {
        Collection<Pattern> discardClasses = getClient().getConfig().getDiscardClasses();
        if (discardClasses.isEmpty()) {
            return false;
        }
        Iterator<Pattern> it = discardClasses.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private static void deepMerge(Map<String, Object> map, Map<String, Object> map2) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Object obj = map2.get(key);
            if ((value instanceof Map) && (obj instanceof Map)) {
                deepMerge((Map) value, (Map) obj);
            } else if ((value instanceof Collection) && (obj instanceof Collection)) {
                ((Collection) obj).addAll((Collection) value);
            } else {
                map2.put(key, value);
            }
        }
    }

    public static void deliverReport(byte[] bArr, byte[] bArr2, byte[] bArr3, String str, boolean z) throws IOException {
        if (bArr3 != null) {
            Map<? super String, ? extends Object> mapDeserialize = JsonHelper.INSTANCE.deserialize(new ByteArrayInputStream(bArr2));
            deepMerge(JsonHelper.INSTANCE.deserialize(new ByteArrayInputStream(bArr3)), mapDeserialize);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            JsonHelper.INSTANCE.serialize(mapDeserialize, byteArrayOutputStream);
            bArr2 = byteArrayOutputStream.toByteArray();
        }
        String str2 = new String(bArr2, UTF8Charset);
        String str3 = bArr == null ? null : new String(bArr, UTF8Charset);
        Client client2 = getClient();
        ImmutableConfig config = client2.getConfig();
        if (str3 == null || str3.length() == 0 || !config.shouldDiscardByReleaseStage()) {
            EventStore eventStore = client2.getEventStore();
            String ndkFilename = eventStore.getNdkFilename(str2, str);
            if (z) {
                ndkFilename = ndkFilename.replace(".json", "startupcrash.json");
            }
            eventStore.enqueueContentForDelivery(str2, ndkFilename);
        }
    }

    public static void deliverReport(File file) {
        EventStore eventStore = getClient().getEventStore();
        if (file.renameTo(new File(eventStore.getStorageDir(), file.getName()))) {
            eventStore.flushAsync();
        } else {
            file.delete();
        }
    }

    public static void notify(byte[] bArr, byte[] bArr2, Severity severity, StackTraceElement[] stackTraceElementArr) {
        if (bArr == null || bArr2 == null || stackTraceElementArr == null) {
            return;
        }
        notify(new String(bArr, UTF8Charset), new String(bArr2, UTF8Charset), severity, stackTraceElementArr);
    }

    public static void notify(final String str, final String str2, final Severity severity, StackTraceElement[] stackTraceElementArr) {
        if (getClient().getConfig().shouldDiscardError(str)) {
            return;
        }
        RuntimeException runtimeException = new RuntimeException();
        runtimeException.setStackTrace(stackTraceElementArr);
        getClient().notify(runtimeException, new OnErrorCallback() { // from class: com.bugsnag.android.NativeInterface.1
            @Override // com.bugsnag.android.OnErrorCallback
            public boolean onError(Event event) {
                event.updateSeverityInternal(severity);
                List<Error> errors = event.getErrors();
                Error error = event.getErrors().get(0);
                if (errors.isEmpty()) {
                    return true;
                }
                error.setErrorClass(str);
                error.setErrorMessage(str2);
                Iterator<Error> it = errors.iterator();
                while (it.hasNext()) {
                    it.next().setType(ErrorType.C);
                }
                return true;
            }
        });
    }

    public static void notify(byte[] bArr, byte[] bArr2, Severity severity, NativeStackframe[] nativeStackframeArr) {
        if (bArr == null || bArr2 == null || nativeStackframeArr == null) {
            return;
        }
        notify(new String(bArr, UTF8Charset), new String(bArr2, UTF8Charset), severity, nativeStackframeArr);
    }

    public static void notify(String str, String str2, Severity severity, NativeStackframe[] nativeStackframeArr) {
        Client client2 = getClient();
        if (client2.getConfig().shouldDiscardError(str)) {
            return;
        }
        Event eventCreateEmptyEvent = createEmptyEvent();
        eventCreateEmptyEvent.updateSeverityInternal(severity);
        ArrayList arrayList = new ArrayList(nativeStackframeArr.length);
        for (NativeStackframe nativeStackframe : nativeStackframeArr) {
            arrayList.add(new Stackframe(nativeStackframe));
        }
        eventCreateEmptyEvent.getErrors().add(new Error(new ErrorInternal(str, str2, new Stacktrace(arrayList), ErrorType.C), client2.getLogger()));
        getClient().populateAndNotifyAndroidEvent(eventCreateEmptyEvent, null);
    }

    public static Event createEvent(Throwable th, Client client2, SeverityReason severityReason) {
        return new Event(th, client2.getConfig(), severityReason, client2.getMetadataState().getMetadata(), client2.getFeatureFlagState().getFeatureFlags(), client2.logger);
    }

    public static Logger getLogger() {
        return getClient().getConfig().getLogger();
    }

    public static void setAutoNotify(boolean z) {
        getClient().setAutoNotify(z);
    }

    public static void setAutoDetectAnrs(boolean z) {
        getClient().setAutoDetectAnrs(z);
    }

    public static void startSession() {
        getClient().startSession();
    }

    public static void pauseSession() {
        getClient().pauseSession();
    }

    public static boolean resumeSession() {
        return getClient().resumeSession();
    }

    public static Session getCurrentSession() {
        return getClient().sessionTracker.getCurrentSession();
    }

    public static void markLaunchCompleted() {
        getClient().markLaunchCompleted();
    }

    public static LastRunInfo getLastRunInfo() {
        return getClient().getLastRunInfo();
    }
}
