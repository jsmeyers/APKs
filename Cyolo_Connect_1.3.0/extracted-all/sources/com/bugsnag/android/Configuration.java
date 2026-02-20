package com.bugsnag.android;

import android.content.Context;
import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class Configuration implements CallbackAware, MetadataAware, UserAware, FeatureFlagAware {
    private static final int MAX_BREADCRUMBS = 500;
    private static final int MIN_BREADCRUMBS = 0;
    private static final long MIN_LAUNCH_CRASH_THRESHOLD_MS = 0;
    final ConfigInternal impl;

    public Configuration(String str) {
        this.impl = new ConfigInternal(str);
    }

    public static Configuration load(Context context) {
        return ConfigInternal.load(context);
    }

    static Configuration load(Context context, String str) {
        return ConfigInternal.load(context, str);
    }

    private void logNull(String str) {
        getLogger().e("Invalid null value supplied to config." + str + ", ignoring");
    }

    public String getApiKey() {
        return this.impl.getApiKey();
    }

    public void setApiKey(String str) {
        this.impl.setApiKey(str);
    }

    public String getAppVersion() {
        return this.impl.getAppVersion();
    }

    public void setAppVersion(String str) {
        this.impl.setAppVersion(str);
    }

    public Integer getVersionCode() {
        return this.impl.getVersionCode();
    }

    public void setVersionCode(Integer num) {
        this.impl.setVersionCode(num);
    }

    public String getReleaseStage() {
        return this.impl.getReleaseStage();
    }

    public void setReleaseStage(String str) {
        this.impl.setReleaseStage(str);
    }

    public ThreadSendPolicy getSendThreads() {
        return this.impl.getSendThreads();
    }

    public void setSendThreads(ThreadSendPolicy threadSendPolicy) {
        if (threadSendPolicy != null) {
            this.impl.setSendThreads(threadSendPolicy);
        } else {
            logNull("sendThreads");
        }
    }

    public boolean getPersistUser() {
        return this.impl.getPersistUser();
    }

    public void setPersistUser(boolean z) {
        this.impl.setPersistUser(z);
    }

    public boolean getGenerateAnonymousId() {
        return this.impl.getGenerateAnonymousId();
    }

    public void setGenerateAnonymousId(boolean z) {
        this.impl.setGenerateAnonymousId(z);
    }

    public File getPersistenceDirectory() {
        return this.impl.getPersistenceDirectory();
    }

    public void setPersistenceDirectory(File file) {
        this.impl.setPersistenceDirectory(file);
    }

    public boolean getSendLaunchCrashesSynchronously() {
        return this.impl.getSendLaunchCrashesSynchronously();
    }

    public void setSendLaunchCrashesSynchronously(boolean z) {
        this.impl.setSendLaunchCrashesSynchronously(z);
    }

    public long getLaunchDurationMillis() {
        return this.impl.getLaunchDurationMillis();
    }

    public void setLaunchDurationMillis(long j) {
        if (j >= 0) {
            this.impl.setLaunchDurationMillis(j);
            return;
        }
        getLogger().e("Invalid configuration value detected. Option launchDurationMillis should be a positive long value.Supplied value is " + j);
    }

    public boolean getAutoTrackSessions() {
        return this.impl.getAutoTrackSessions();
    }

    public void setAutoTrackSessions(boolean z) {
        this.impl.setAutoTrackSessions(z);
    }

    public ErrorTypes getEnabledErrorTypes() {
        return this.impl.getEnabledErrorTypes();
    }

    public void setEnabledErrorTypes(ErrorTypes errorTypes) {
        if (errorTypes != null) {
            this.impl.setEnabledErrorTypes(errorTypes);
        } else {
            logNull("enabledErrorTypes");
        }
    }

    public boolean getAutoDetectErrors() {
        return this.impl.getAutoDetectErrors();
    }

    public void setAutoDetectErrors(boolean z) {
        this.impl.setAutoDetectErrors(z);
    }

    public String getAppType() {
        return this.impl.getAppType();
    }

    public void setAppType(String str) {
        this.impl.setAppType(str);
    }

    public Logger getLogger() {
        return this.impl.getLogger();
    }

    public void setLogger(Logger logger) {
        this.impl.setLogger(logger);
    }

    public Delivery getDelivery() {
        return this.impl.getDelivery();
    }

    public void setDelivery(Delivery delivery) {
        if (delivery != null) {
            this.impl.setDelivery(delivery);
        } else {
            logNull("delivery");
        }
    }

    public EndpointConfiguration getEndpoints() {
        return this.impl.getEndpoints();
    }

    public void setEndpoints(EndpointConfiguration endpointConfiguration) {
        if (endpointConfiguration != null) {
            this.impl.setEndpoints(endpointConfiguration);
        } else {
            logNull("endpoints");
        }
    }

    public int getMaxBreadcrumbs() {
        return this.impl.getMaxBreadcrumbs();
    }

    public void setMaxBreadcrumbs(int i) {
        if (i >= 0 && i <= 500) {
            this.impl.setMaxBreadcrumbs(i);
            return;
        }
        getLogger().e("Invalid configuration value detected. Option maxBreadcrumbs should be an integer between 0-500. Supplied value is " + i);
    }

    public int getMaxPersistedEvents() {
        return this.impl.getMaxPersistedEvents();
    }

    public void setMaxPersistedEvents(int i) {
        if (i >= 0) {
            this.impl.setMaxPersistedEvents(i);
            return;
        }
        getLogger().e("Invalid configuration value detected. Option maxPersistedEvents should be a positive integer.Supplied value is " + i);
    }

    public int getMaxReportedThreads() {
        return this.impl.getMaxReportedThreads();
    }

    public void setMaxReportedThreads(int i) {
        if (i >= 0) {
            this.impl.setMaxReportedThreads(i);
            return;
        }
        getLogger().e("Invalid configuration value detected. Option maxReportedThreads should be a positive integer.Supplied value is " + i);
    }

    public long getThreadCollectionTimeLimitMillis() {
        return this.impl.getThreadCollectionTimeLimitMillis();
    }

    public void setThreadCollectionTimeLimitMillis(long j) {
        if (j >= 0) {
            this.impl.setThreadCollectionTimeLimitMillis(j);
            return;
        }
        getLogger().e("Invalid configuration value detected. Option threadCollectionTimeLimitMillis should be a positive integer.Supplied value is " + j);
    }

    public int getMaxPersistedSessions() {
        return this.impl.getMaxPersistedSessions();
    }

    public void setMaxPersistedSessions(int i) {
        if (i >= 0) {
            this.impl.setMaxPersistedSessions(i);
            return;
        }
        getLogger().e("Invalid configuration value detected. Option maxPersistedSessions should be a positive integer.Supplied value is " + i);
    }

    public int getMaxStringValueLength() {
        return this.impl.getMaxStringValueLength();
    }

    public void setMaxStringValueLength(int i) {
        if (i >= 0) {
            this.impl.setMaxStringValueLength(i);
            return;
        }
        getLogger().e("Invalid configuration value detected. Option maxStringValueLength should be a positive integer.Supplied value is " + i);
    }

    public String getContext() {
        return this.impl.getContext();
    }

    public void setContext(String str) {
        this.impl.setContext(str);
    }

    public Set<Pattern> getRedactedKeys() {
        return this.impl.getRedactedKeys();
    }

    public void setRedactedKeys(Set<Pattern> set) {
        if (CollectionUtils.containsNullElements(set)) {
            logNull("redactedKeys");
        } else {
            this.impl.setRedactedKeys(set);
        }
    }

    public Set<Pattern> getDiscardClasses() {
        return this.impl.getDiscardClasses();
    }

    public void setDiscardClasses(Set<Pattern> set) {
        if (CollectionUtils.containsNullElements(set)) {
            logNull("discardClasses");
        } else {
            this.impl.setDiscardClasses(set);
        }
    }

    public Set<String> getEnabledReleaseStages() {
        return this.impl.getEnabledReleaseStages();
    }

    public void setEnabledReleaseStages(Set<String> set) {
        this.impl.setEnabledReleaseStages(set);
    }

    public Set<BreadcrumbType> getEnabledBreadcrumbTypes() {
        return this.impl.getEnabledBreadcrumbTypes();
    }

    public void setEnabledBreadcrumbTypes(Set<BreadcrumbType> set) {
        this.impl.setEnabledBreadcrumbTypes(set);
    }

    public Set<Telemetry> getTelemetry() {
        return this.impl.getTelemetry();
    }

    public void setTelemetry(Set<Telemetry> set) {
        if (set != null) {
            this.impl.setTelemetry(set);
        } else {
            logNull("telemetry");
        }
    }

    public Set<String> getProjectPackages() {
        return this.impl.getProjectPackages();
    }

    public void setProjectPackages(Set<String> set) {
        if (CollectionUtils.containsNullElements(set)) {
            logNull("projectPackages");
        } else {
            this.impl.setProjectPackages(set);
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnError(OnErrorCallback onErrorCallback) {
        if (onErrorCallback != null) {
            this.impl.addOnError(onErrorCallback);
        } else {
            logNull("addOnError");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnError(OnErrorCallback onErrorCallback) {
        if (onErrorCallback != null) {
            this.impl.removeOnError(onErrorCallback);
        } else {
            logNull("removeOnError");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnBreadcrumb(OnBreadcrumbCallback onBreadcrumbCallback) {
        if (onBreadcrumbCallback != null) {
            this.impl.addOnBreadcrumb(onBreadcrumbCallback);
        } else {
            logNull("addOnBreadcrumb");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnBreadcrumb(OnBreadcrumbCallback onBreadcrumbCallback) {
        if (onBreadcrumbCallback != null) {
            this.impl.removeOnBreadcrumb(onBreadcrumbCallback);
        } else {
            logNull("removeOnBreadcrumb");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnSession(OnSessionCallback onSessionCallback) {
        if (onSessionCallback != null) {
            this.impl.addOnSession(onSessionCallback);
        } else {
            logNull("addOnSession");
        }
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnSession(OnSessionCallback onSessionCallback) {
        if (onSessionCallback != null) {
            this.impl.removeOnSession(onSessionCallback);
        } else {
            logNull("removeOnSession");
        }
    }

    public void addOnSend(OnSendCallback onSendCallback) {
        if (onSendCallback != null) {
            this.impl.addOnSend(onSendCallback);
        } else {
            logNull("addOnSend");
        }
    }

    public void removeOnSend(OnSendCallback onSendCallback) {
        if (onSendCallback != null) {
            this.impl.removeOnSend(onSendCallback);
        } else {
            logNull("removeOnSend");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String str, Map<String, ?> map) {
        if (str != null && map != null) {
            this.impl.addMetadata(str, map);
        } else {
            logNull("addMetadata");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String str, String str2, Object obj) {
        if (str != null && str2 != null) {
            this.impl.addMetadata(str, str2, obj);
        } else {
            logNull("addMetadata");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String str) {
        if (str != null) {
            this.impl.clearMetadata(str);
        } else {
            logNull("clearMetadata");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String str, String str2) {
        if (str != null && str2 != null) {
            this.impl.clearMetadata(str, str2);
        } else {
            logNull("clearMetadata");
        }
    }

    @Override // com.bugsnag.android.MetadataAware
    public Map<String, Object> getMetadata(String str) {
        if (str != null) {
            return this.impl.getMetadata(str);
        }
        logNull("getMetadata");
        return null;
    }

    @Override // com.bugsnag.android.MetadataAware
    public Object getMetadata(String str, String str2) {
        if (str != null && str2 != null) {
            return this.impl.getMetadata(str, str2);
        }
        logNull("getMetadata");
        return null;
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String str) {
        if (str != null) {
            this.impl.addFeatureFlag(str);
        } else {
            logNull("addFeatureFlag");
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String str, String str2) {
        if (str != null) {
            this.impl.addFeatureFlag(str, str2);
        } else {
            logNull("addFeatureFlag");
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlags(Iterable<FeatureFlag> iterable) {
        if (iterable != null) {
            this.impl.addFeatureFlags(iterable);
        } else {
            logNull("addFeatureFlags");
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlag(String str) {
        if (str != null) {
            this.impl.clearFeatureFlag(str);
        } else {
            logNull("clearFeatureFlag");
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlags() {
        this.impl.clearFeatureFlags();
    }

    @Override // com.bugsnag.android.UserAware
    public User getUser() {
        return this.impl.getUser();
    }

    @Override // com.bugsnag.android.UserAware
    public void setUser(String str, String str2, String str3) {
        this.impl.setUser(str, str2, str3);
    }

    public void addPlugin(Plugin plugin) {
        if (plugin != null) {
            this.impl.addPlugin(plugin);
        } else {
            logNull("addPlugin");
        }
    }

    public void setAttemptDeliveryOnCrash(boolean z) {
        this.impl.setAttemptDeliveryOnCrash(z);
    }

    public boolean isAttemptDeliveryOnCrash() {
        return this.impl.getAttemptDeliveryOnCrash();
    }

    Set<Plugin> getPlugins() {
        return this.impl.getPlugins();
    }

    Notifier getNotifier() {
        return this.impl.getNotifier();
    }
}
