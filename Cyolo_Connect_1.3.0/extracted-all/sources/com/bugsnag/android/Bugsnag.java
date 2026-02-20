package com.bugsnag.android;

import android.content.Context;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Bugsnag {
    static Client client;
    private static final Object lock = new Object();

    private Bugsnag() {
    }

    public static Client start(Context context) {
        return start(context, Configuration.load(context));
    }

    public static Client start(Context context, String str) {
        return start(context, Configuration.load(context, str));
    }

    public static Client start(Context context, Configuration configuration) {
        synchronized (lock) {
            if (client == null) {
                client = new Client(context, configuration);
            } else {
                logClientInitWarning();
            }
        }
        return client;
    }

    public static boolean isStarted() {
        return client != null;
    }

    private static void logClientInitWarning() {
        getClient().logger.w("Multiple Bugsnag.start calls detected. Ignoring.");
    }

    public static String getContext() {
        return getClient().getContext();
    }

    public static void setContext(String str) {
        getClient().setContext(str);
    }

    public static void setUser(String str, String str2, String str3) {
        getClient().setUser(str, str2, str3);
    }

    public static User getUser() {
        return getClient().getUser();
    }

    public static void addOnError(OnErrorCallback onErrorCallback) {
        getClient().addOnError(onErrorCallback);
    }

    public static void removeOnError(OnErrorCallback onErrorCallback) {
        getClient().removeOnError(onErrorCallback);
    }

    public static void addOnBreadcrumb(OnBreadcrumbCallback onBreadcrumbCallback) {
        getClient().addOnBreadcrumb(onBreadcrumbCallback);
    }

    public static void removeOnBreadcrumb(OnBreadcrumbCallback onBreadcrumbCallback) {
        getClient().removeOnBreadcrumb(onBreadcrumbCallback);
    }

    public static void addOnSession(OnSessionCallback onSessionCallback) {
        getClient().addOnSession(onSessionCallback);
    }

    public static void removeOnSession(OnSessionCallback onSessionCallback) {
        getClient().removeOnSession(onSessionCallback);
    }

    public static void notify(Throwable th) {
        getClient().notify(th);
    }

    public static void notify(Throwable th, OnErrorCallback onErrorCallback) {
        getClient().notify(th, onErrorCallback);
    }

    public static void addMetadata(String str, Map<String, ?> map) {
        getClient().addMetadata(str, map);
    }

    public static void addMetadata(String str, String str2, Object obj) {
        getClient().addMetadata(str, str2, obj);
    }

    public static void clearMetadata(String str) {
        getClient().clearMetadata(str);
    }

    public static void clearMetadata(String str, String str2) {
        getClient().clearMetadata(str, str2);
    }

    public static Map<String, Object> getMetadata(String str) {
        return getClient().getMetadata(str);
    }

    public static Object getMetadata(String str, String str2) {
        return getClient().getMetadata(str, str2);
    }

    public static void leaveBreadcrumb(String str) {
        getClient().leaveBreadcrumb(str);
    }

    public static void leaveBreadcrumb(String str, Map<String, Object> map, BreadcrumbType breadcrumbType) {
        getClient().leaveBreadcrumb(str, map, breadcrumbType);
    }

    public static void startSession() {
        getClient().startSession();
    }

    public static boolean resumeSession() {
        return getClient().resumeSession();
    }

    public static void pauseSession() {
        getClient().pauseSession();
    }

    public static List<Breadcrumb> getBreadcrumbs() {
        return getClient().getBreadcrumbs();
    }

    public static LastRunInfo getLastRunInfo() {
        return getClient().getLastRunInfo();
    }

    public static void markLaunchCompleted() {
        getClient().markLaunchCompleted();
    }

    public static void addFeatureFlag(String str) {
        getClient().addFeatureFlag(str);
    }

    public static void addFeatureFlag(String str, String str2) {
        getClient().addFeatureFlag(str, str2);
    }

    public static void addFeatureFlags(Iterable<FeatureFlag> iterable) {
        getClient().addFeatureFlags(iterable);
    }

    public static void clearFeatureFlag(String str) {
        getClient().clearFeatureFlag(str);
    }

    public static void clearFeatureFlags() {
        getClient().clearFeatureFlags();
    }

    public static Client getClient() {
        if (client == null) {
            synchronized (lock) {
                if (client == null) {
                    throw new IllegalStateException("You must call Bugsnag.start before any other Bugsnag methods");
                }
            }
        }
        return client;
    }
}
