package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.Thread;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.InternalMetrics;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class Event implements JsonStream.Streamable, MetadataAware, UserAware, FeatureFlagAware {
    private final EventInternal impl;
    private final Logger logger;

    Event(Throwable th, ImmutableConfig immutableConfig, SeverityReason severityReason, Logger logger) {
        this(th, immutableConfig, severityReason, new Metadata(), new FeatureFlags(), logger);
    }

    Event(Throwable th, ImmutableConfig immutableConfig, SeverityReason severityReason, Metadata metadata, FeatureFlags featureFlags, Logger logger) {
        this(new EventInternal(th, immutableConfig, severityReason, metadata, featureFlags), logger);
    }

    Event(EventInternal eventInternal, Logger logger) {
        this.impl = eventInternal;
        this.logger = logger;
    }

    private void logNull(String str) {
        this.logger.e("Invalid null value supplied to config." + str + ", ignoring");
    }

    public Throwable getOriginalError() {
        return this.impl.getOriginalError();
    }

    public List<Error> getErrors() {
        return this.impl.getErrors();
    }

    public Error addError(Throwable th) {
        return this.impl.addError(th);
    }

    public Error addError(String str, String str2) {
        return this.impl.addError(str, str2, ErrorType.ANDROID);
    }

    public Error addError(String str, String str2, ErrorType errorType) {
        return this.impl.addError(str, str2, errorType);
    }

    public List<Thread> getThreads() {
        return this.impl.getThreads();
    }

    public Thread addThread(String str, String str2) {
        return this.impl.addThread(str, str2, ErrorType.ANDROID, false, Thread.State.RUNNABLE.getDescriptor());
    }

    public Thread addThread(long j, String str) {
        return this.impl.addThread(Long.toString(j), str, ErrorType.ANDROID, false, Thread.State.RUNNABLE.getDescriptor());
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return this.impl.getBreadcrumbs();
    }

    public Breadcrumb leaveBreadcrumb(String str, BreadcrumbType breadcrumbType, Map<String, Object> map) {
        return this.impl.leaveBreadcrumb(str, breadcrumbType, map);
    }

    public Breadcrumb leaveBreadcrumb(String str) {
        return this.impl.leaveBreadcrumb(str, BreadcrumbType.MANUAL, null);
    }

    public List<FeatureFlag> getFeatureFlags() {
        return this.impl.getFeatureFlags().toList();
    }

    public AppWithState getApp() {
        return this.impl.getApp();
    }

    public DeviceWithState getDevice() {
        return this.impl.getDevice();
    }

    public void setApiKey(String str) {
        if (str != null) {
            this.impl.setApiKey(str);
        } else {
            logNull(DynamicLink.Builder.KEY_API_KEY);
        }
    }

    public String getApiKey() {
        return this.impl.getApiKey();
    }

    public void setSeverity(Severity severity) {
        if (severity != null) {
            this.impl.setSeverity(severity);
        } else {
            logNull("severity");
        }
    }

    public Severity getSeverity() {
        return this.impl.getSeverity();
    }

    public void setGroupingHash(String str) {
        this.impl.setGroupingHash(str);
    }

    public String getGroupingHash() {
        return this.impl.getGroupingHash();
    }

    public void setContext(String str) {
        this.impl.setContext(str);
    }

    public String getContext() {
        return this.impl.getContext();
    }

    @Override // com.bugsnag.android.UserAware
    public void setUser(String str, String str2, String str3) {
        this.impl.setUser(str, str2, str3);
    }

    @Override // com.bugsnag.android.UserAware
    /* JADX INFO: renamed from: getUser */
    public User getUserImpl() {
        return this.impl.getUserImpl();
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

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        this.impl.toStream(jsonStream);
    }

    public boolean isUnhandled() {
        return this.impl.getUnhandled();
    }

    public void setUnhandled(boolean z) {
        this.impl.setUnhandled(z);
    }

    public void setTraceCorrelation(UUID uuid, long j) {
        if (uuid != null) {
            this.impl.setTraceCorrelation(new TraceCorrelation(uuid, j));
        } else {
            logNull("traceId");
        }
    }

    protected boolean shouldDiscardClass() {
        return this.impl.shouldDiscardClass();
    }

    protected void updateSeverityInternal(Severity severity) {
        this.impl.updateSeverityInternal(severity);
    }

    protected void updateSeverityReason(String str) {
        this.impl.updateSeverityReason(str);
    }

    void setApp(AppWithState appWithState) {
        this.impl.setApp(appWithState);
    }

    void setDevice(DeviceWithState deviceWithState) {
        this.impl.setDevice(deviceWithState);
    }

    void setBreadcrumbs(List<Breadcrumb> list) {
        this.impl.setBreadcrumbs(list);
    }

    Session getSession() {
        return this.impl.session;
    }

    void setSession(Session session) {
        this.impl.session = session;
    }

    EventInternal getImpl() {
        return this.impl;
    }

    void setRedactedKeys(Collection<Pattern> collection) {
        this.impl.setRedactedKeys(collection);
    }

    void setInternalMetrics(InternalMetrics internalMetrics) {
        this.impl.setInternalMetrics(internalMetrics);
    }
}
