package com.bugsnag.android;

import androidx.core.app.NotificationCompat;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.InternalMetrics;
import com.bugsnag.android.internal.InternalMetricsNoop;
import com.bugsnag.android.internal.JsonHelper;
import com.bugsnag.android.internal.TrimMetrics;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.messaging.Constants;
import io.cyolo.android.MainActivityKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EventInternal.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\b\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u00ad\u0001\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001e\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0015\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0002\u0010$J$\u0010x\u001a\u00020\u001b2\b\u0010y\u001a\u0004\u0018\u00010\u00112\b\u0010z\u001a\u0004\u0018\u00010\u00112\b\u0010{\u001a\u0004\u0018\u00010|J\u0010\u0010x\u001a\u00020\u001b2\b\u0010}\u001a\u0004\u0018\u00010\u0006J\u0011\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u0011H\u0016J\u001c\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u00112\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0011H\u0016J\u0019\u0010\u0082\u0001\u001a\u00020\u007f2\u000e\u0010\r\u001a\n\u0012\u0005\u0012\u00030\u0084\u00010\u0083\u0001H\u0016J&\u0010\u0085\u0001\u001a\u00020\u007f2\u0007\u0010\u0086\u0001\u001a\u00020\u00112\u0007\u0010\u0087\u0001\u001a\u00020\u00112\t\u0010U\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J*\u0010\u0085\u0001\u001a\u00020\u007f2\u0007\u0010\u0086\u0001\u001a\u00020\u00112\u0016\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u0088\u00010\u0089\u0001H\u0016J7\u0010\u008a\u0001\u001a\u00020 2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010{\u001a\u00020|2\u0007\u0010\u008c\u0001\u001a\u00020m2\u0007\u0010\u008d\u0001\u001a\u00020\u0011J\u0012\u0010\u008e\u0001\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u008f\u0001\u001a\u00020\u007fH\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\u007f2\u0007\u0010\u0086\u0001\u001a\u00020\u0011H\u0016J\u001b\u0010\u0090\u0001\u001a\u00020\u007f2\u0007\u0010\u0086\u0001\u001a\u00020\u00112\u0007\u0010\u0087\u0001\u001a\u00020\u0011H\u0016J\u0015\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020|0\u0018H\u0000¢\u0006\u0003\b\u0092\u0001J!\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010\u0089\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u0011H\u0016J\u001d\u0010M\u001a\u0005\u0018\u00010\u0088\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u00112\u0007\u0010\u0087\u0001\u001a\u00020\u0011H\u0016J\u0007\u0010\u0093\u0001\u001a\u00020mJ\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0007\u0010\u0095\u0001\u001a\u00020mJ\t\u0010\u0096\u0001\u001a\u00020\"H\u0016J\u0013\u0010\u0097\u0001\u001a\u00020m2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0004J8\u0010\u009a\u0001\u001a\u00020\u00162\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00112\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u0088\u0001\u0018\u00010\u009e\u0001J\u000f\u0010\u009f\u0001\u001a\u00020\u007fH\u0000¢\u0006\u0003\b \u0001J*\u0010¡\u0001\u001a\u00020\u007f2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u00112\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010£\u0001\u001a\u00020mH\u0004J\u0013\u0010¤\u0001\u001a\u00020\u007f2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0012\u0010§\u0001\u001a\u00030¨\u00012\b\u0010©\u0001\u001a\u00030ª\u0001J\u0012\u0010«\u0001\u001a\u00030¨\u00012\b\u0010¬\u0001\u001a\u00030ª\u0001J\u0011\u0010\u00ad\u0001\u001a\u00020\u007f2\u0006\u0010\\\u001a\u00020[H\u0004J\u0012\u0010®\u0001\u001a\u00020\u007f2\u0007\u0010¯\u0001\u001a\u00020\u0011H\u0004J\u0017\u0010°\u0001\u001a\u00020\u007f2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0003\b±\u0001R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\u001a\u00106\u001a\u000207X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00100\"\u0004\b=\u00102R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010&\"\u0004\bB\u0010(R\u001a\u0010C\u001a\u00020DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010\u001c\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR0\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010R\"\u0004\bX\u0010TR\u0014\u0010Y\u001a\u0004\u0018\u00010Z8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R$\u0010\\\u001a\u00020[2\u0006\u0010U\u001a\u00020[8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00100\"\u0004\bf\u00102R\u001c\u0010g\u001a\u0004\u0018\u00010hX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010n\u001a\u00020m2\u0006\u0010U\u001a\u00020m8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001a\u0010s\u001a\u00020\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w¨\u0006²\u0001"}, d2 = {"Lcom/bugsnag/android/EventInternal;", "Lcom/bugsnag/android/FeatureFlagAware;", "Lcom/bugsnag/android/JsonStream$Streamable;", "Lcom/bugsnag/android/MetadataAware;", "Lcom/bugsnag/android/UserAware;", "originalError", "", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "severityReason", "Lcom/bugsnag/android/SeverityReason;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/bugsnag/android/Metadata;", "featureFlags", "Lcom/bugsnag/android/FeatureFlags;", "(Ljava/lang/Throwable;Lcom/bugsnag/android/internal/ImmutableConfig;Lcom/bugsnag/android/SeverityReason;Lcom/bugsnag/android/Metadata;Lcom/bugsnag/android/FeatureFlags;)V", DynamicLink.Builder.KEY_API_KEY, "", "logger", "Lcom/bugsnag/android/Logger;", "breadcrumbs", "", "Lcom/bugsnag/android/Breadcrumb;", "discardClasses", "", "Ljava/util/regex/Pattern;", "errors", "Lcom/bugsnag/android/Error;", "metadata", "projectPackages", "", "threads", "Lcom/bugsnag/android/Thread;", "user", "Lcom/bugsnag/android/User;", "redactionKeys", "(Ljava/lang/String;Lcom/bugsnag/android/Logger;Ljava/util/List;Ljava/util/Set;Ljava/util/List;Lcom/bugsnag/android/Metadata;Lcom/bugsnag/android/FeatureFlags;Ljava/lang/Throwable;Ljava/util/Collection;Lcom/bugsnag/android/SeverityReason;Ljava/util/List;Lcom/bugsnag/android/User;Ljava/util/Set;)V", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "app", "Lcom/bugsnag/android/AppWithState;", "getApp", "()Lcom/bugsnag/android/AppWithState;", "setApp", "(Lcom/bugsnag/android/AppWithState;)V", "getBreadcrumbs", "()Ljava/util/List;", "setBreadcrumbs", "(Ljava/util/List;)V", "context", "getContext", "setContext", "device", "Lcom/bugsnag/android/DeviceWithState;", "getDevice", "()Lcom/bugsnag/android/DeviceWithState;", "setDevice", "(Lcom/bugsnag/android/DeviceWithState;)V", "getErrors", "setErrors", "getFeatureFlags", "()Lcom/bugsnag/android/FeatureFlags;", "groupingHash", "getGroupingHash", "setGroupingHash", "internalMetrics", "Lcom/bugsnag/android/internal/InternalMetrics;", "getInternalMetrics", "()Lcom/bugsnag/android/internal/InternalMetrics;", "setInternalMetrics", "(Lcom/bugsnag/android/internal/InternalMetrics;)V", "jsonStreamer", "Lcom/bugsnag/android/ObjectJsonStreamer;", "getLogger", "()Lcom/bugsnag/android/Logger;", "getMetadata", "()Lcom/bugsnag/android/Metadata;", "getOriginalError", "()Ljava/lang/Throwable;", "getProjectPackages$bugsnag_android_core_release", "()Ljava/util/Collection;", "setProjectPackages$bugsnag_android_core_release", "(Ljava/util/Collection;)V", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "redactedKeys", "getRedactedKeys", "setRedactedKeys", "session", "Lcom/bugsnag/android/Session;", "Lcom/bugsnag/android/Severity;", "severity", "getSeverity", "()Lcom/bugsnag/android/Severity;", "setSeverity", "(Lcom/bugsnag/android/Severity;)V", "getSeverityReason$bugsnag_android_core_release", "()Lcom/bugsnag/android/SeverityReason;", "setSeverityReason$bugsnag_android_core_release", "(Lcom/bugsnag/android/SeverityReason;)V", "getThreads", "setThreads", "traceCorrelation", "Lcom/bugsnag/android/TraceCorrelation;", "getTraceCorrelation", "()Lcom/bugsnag/android/TraceCorrelation;", "setTraceCorrelation", "(Lcom/bugsnag/android/TraceCorrelation;)V", "", "unhandled", "getUnhandled", "()Z", "setUnhandled", "(Z)V", "userImpl", "getUserImpl$bugsnag_android_core_release", "()Lcom/bugsnag/android/User;", "setUserImpl$bugsnag_android_core_release", "(Lcom/bugsnag/android/User;)V", "addError", "errorClass", "errorMessage", "errorType", "Lcom/bugsnag/android/ErrorType;", "thrownError", "addFeatureFlag", "", "name", "variant", "addFeatureFlags", "", "Lcom/bugsnag/android/FeatureFlag;", "addMetadata", "section", "key", "", "", "addThread", "id", "isErrorReportingThread", "state", "clearFeatureFlag", "clearFeatureFlags", "clearMetadata", "getErrorTypesFromStackframes", "getErrorTypesFromStackframes$bugsnag_android_core_release", "getOriginalUnhandled", "getSeverityReasonType", "getUnhandledOverridden", "getUser", "isAnr", NotificationCompat.CATEGORY_EVENT, "Lcom/bugsnag/android/Event;", "leaveBreadcrumb", "message", "type", "Lcom/bugsnag/android/BreadcrumbType;", "", "normalizeStackframeErrorTypes", "normalizeStackframeErrorTypes$bugsnag_android_core_release", "setUser", "email", "shouldDiscardClass", "toStream", "parentWriter", "Lcom/bugsnag/android/JsonStream;", "trimBreadcrumbsBy", "Lcom/bugsnag/android/internal/TrimMetrics;", "byteCount", "", "trimMetadataStringsTo", "maxLength", "updateSeverityInternal", "updateSeverityReason", "reason", "updateSeverityReasonInternal", "updateSeverityReasonInternal$bugsnag_android_core_release", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EventInternal implements FeatureFlagAware, JsonStream.Streamable, MetadataAware, UserAware {
    private String apiKey;
    public AppWithState app;
    private List<Breadcrumb> breadcrumbs;
    private String context;
    public DeviceWithState device;
    private final Set<Pattern> discardClasses;
    private List<Error> errors;
    private final FeatureFlags featureFlags;
    private String groupingHash;
    private InternalMetrics internalMetrics;
    private final ObjectJsonStreamer jsonStreamer;
    private final Logger logger;
    private final Metadata metadata;
    private final Throwable originalError;
    private Collection<String> projectPackages;
    public Session session;
    private SeverityReason severityReason;
    private List<Thread> threads;
    private TraceCorrelation traceCorrelation;
    private User userImpl;

    public EventInternal(ImmutableConfig immutableConfig, SeverityReason severityReason) {
        this(null, immutableConfig, severityReason, null, null, 25, null);
    }

    public EventInternal(Throwable th, ImmutableConfig immutableConfig, SeverityReason severityReason) {
        this(th, immutableConfig, severityReason, null, null, 24, null);
    }

    public EventInternal(Throwable th, ImmutableConfig immutableConfig, SeverityReason severityReason, Metadata metadata) {
        this(th, immutableConfig, severityReason, metadata, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ EventInternal(Throwable th, ImmutableConfig immutableConfig, SeverityReason severityReason, Metadata metadata, FeatureFlags featureFlags, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th, immutableConfig, severityReason, (i & 8) != 0 ? new Metadata(null, 1, 0 == true ? 1 : 0) : metadata, (i & 16) != 0 ? new FeatureFlags() : featureFlags);
    }

    public EventInternal(Throwable th, ImmutableConfig immutableConfig, SeverityReason severityReason, Metadata metadata, FeatureFlags featureFlags) {
        ArrayList arrayListCreateError;
        String apiKey = immutableConfig.getApiKey();
        Logger logger = immutableConfig.getLogger();
        ArrayList arrayList = new ArrayList();
        Set set = CollectionsKt.toSet(immutableConfig.getDiscardClasses());
        if (th == null) {
            arrayListCreateError = new ArrayList();
        } else {
            arrayListCreateError = Error.createError(th, immutableConfig.getProjectPackages(), immutableConfig.getLogger());
        }
        this(apiKey, logger, arrayList, set, arrayListCreateError, metadata.copy(), featureFlags.copy(), th, immutableConfig.getProjectPackages(), severityReason, new ThreadState(th, severityReason.getUnhandled(), immutableConfig).getThreads(), new User(null, null, null, 7, null), CollectionsKt.toSet(immutableConfig.getRedactedKeys()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ EventInternal(String str, Logger logger, List list, Set set, List list2, Metadata metadata, FeatureFlags featureFlags, Throwable th, Collection collection, SeverityReason severityReason, List list3, User user, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Metadata metadata2;
        List arrayList = (i & 4) != 0 ? new ArrayList() : list;
        Set setEmptySet = (i & 8) != 0 ? SetsKt.emptySet() : set;
        List arrayList2 = (i & 16) != 0 ? new ArrayList() : list2;
        Map map = null;
        Object[] objArr = 0;
        if ((i & 32) != 0) {
            metadata2 = new Metadata(map, 1, objArr == true ? 1 : 0);
        } else {
            metadata2 = metadata;
        }
        this(str, logger, arrayList, setEmptySet, arrayList2, metadata2, (i & 64) != 0 ? new FeatureFlags() : featureFlags, (i & 128) != 0 ? null : th, (i & 256) != 0 ? SetsKt.emptySet() : collection, (i & 512) != 0 ? SeverityReason.newInstance("handledException") : severityReason, (i & 1024) != 0 ? new ArrayList() : list3, (i & 2048) != 0 ? new User(null, null, null, 7, null) : user, (i & 4096) != 0 ? null : set2);
    }

    public EventInternal(String str, Logger logger, List<Breadcrumb> list, Set<Pattern> set, List<Error> list2, Metadata metadata, FeatureFlags featureFlags, Throwable th, Collection<String> collection, SeverityReason severityReason, List<Thread> list3, User user, Set<Pattern> set2) {
        ObjectJsonStreamer objectJsonStreamer = new ObjectJsonStreamer();
        objectJsonStreamer.setRedactedKeys(CollectionsKt.toSet(objectJsonStreamer.getRedactedKeys()));
        this.jsonStreamer = objectJsonStreamer;
        this.internalMetrics = new InternalMetricsNoop();
        this.logger = logger;
        this.apiKey = str;
        this.breadcrumbs = list;
        this.discardClasses = set;
        this.errors = list2;
        this.metadata = metadata;
        this.featureFlags = featureFlags;
        this.originalError = th;
        this.projectPackages = collection;
        this.severityReason = severityReason;
        this.threads = list3;
        this.userImpl = user;
        if (set2 == null) {
            return;
        }
        setRedactedKeys(set2);
    }

    public final Throwable getOriginalError() {
        return this.originalError;
    }

    /* JADX INFO: renamed from: getSeverityReason$bugsnag_android_core_release, reason: from getter */
    public final SeverityReason getSeverityReason() {
        return this.severityReason;
    }

    public final void setSeverityReason$bugsnag_android_core_release(SeverityReason severityReason) {
        this.severityReason = severityReason;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final Metadata getMetadata() {
        return this.metadata;
    }

    public final FeatureFlags getFeatureFlags() {
        return this.featureFlags;
    }

    public final Collection<String> getProjectPackages$bugsnag_android_core_release() {
        return this.projectPackages;
    }

    public final void setProjectPackages$bugsnag_android_core_release(Collection<String> collection) {
        this.projectPackages = collection;
    }

    public final Severity getSeverity() {
        return this.severityReason.getCurrentSeverity();
    }

    public final void setSeverity(Severity severity) {
        this.severityReason.setCurrentSeverity(severity);
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final void setApiKey(String str) {
        this.apiKey = str;
    }

    public final AppWithState getApp() {
        AppWithState appWithState = this.app;
        if (appWithState != null) {
            return appWithState;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("app");
        return null;
    }

    public final void setApp(AppWithState appWithState) {
        this.app = appWithState;
    }

    public final DeviceWithState getDevice() {
        DeviceWithState deviceWithState = this.device;
        if (deviceWithState != null) {
            return deviceWithState;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(DeviceWithState deviceWithState) {
        this.device = deviceWithState;
    }

    public final boolean getUnhandled() {
        return this.severityReason.getUnhandled();
    }

    public final void setUnhandled(boolean z) {
        this.severityReason.setUnhandled(z);
    }

    public final List<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    public final void setBreadcrumbs(List<Breadcrumb> list) {
        this.breadcrumbs = list;
    }

    public final List<Error> getErrors() {
        return this.errors;
    }

    public final void setErrors(List<Error> list) {
        this.errors = list;
    }

    public final List<Thread> getThreads() {
        return this.threads;
    }

    public final void setThreads(List<Thread> list) {
        this.threads = list;
    }

    public final String getGroupingHash() {
        return this.groupingHash;
    }

    public final void setGroupingHash(String str) {
        this.groupingHash = str;
    }

    public final String getContext() {
        return this.context;
    }

    public final void setContext(String str) {
        this.context = str;
    }

    public final Collection<Pattern> getRedactedKeys() {
        return this.jsonStreamer.getRedactedKeys();
    }

    public final void setRedactedKeys(Collection<Pattern> collection) {
        Collection<Pattern> collection2 = collection;
        this.jsonStreamer.setRedactedKeys(CollectionsKt.toSet(collection2));
        this.metadata.setRedactedKeys(CollectionsKt.toSet(collection2));
    }

    public final InternalMetrics getInternalMetrics() {
        return this.internalMetrics;
    }

    public final void setInternalMetrics(InternalMetrics internalMetrics) {
        this.internalMetrics = internalMetrics;
    }

    public final User getUserImpl$bugsnag_android_core_release() {
        return this.userImpl;
    }

    public final void setUserImpl$bugsnag_android_core_release(User user) {
        this.userImpl = user;
    }

    public final TraceCorrelation getTraceCorrelation() {
        return this.traceCorrelation;
    }

    public final void setTraceCorrelation(TraceCorrelation traceCorrelation) {
        this.traceCorrelation = traceCorrelation;
    }

    public final boolean getUnhandledOverridden() {
        return this.severityReason.getUnhandledOverridden();
    }

    public final boolean getOriginalUnhandled() {
        return this.severityReason.originalUnhandled;
    }

    protected final boolean shouldDiscardClass() {
        boolean z;
        if (this.errors.isEmpty()) {
            return true;
        }
        List<Error> list = this.errors;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Error error : list) {
                Set<Pattern> set = this.discardClasses;
                if (!(set instanceof Collection) || !set.isEmpty()) {
                    Iterator<T> it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        if (((Pattern) it.next()).matcher(error.getErrorClass()).matches()) {
                            z = true;
                            break;
                        }
                    }
                } else {
                    z = false;
                    break;
                    break;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean isAnr(Event event) {
        List<Error> errors = event.getErrors();
        return kotlin.jvm.internal.Intrinsics.areEqual("ANR", errors.isEmpty() ^ true ? errors.get(0).getErrorClass() : null);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream parentWriter) throws IOException {
        JsonStream jsonStream = new JsonStream(parentWriter, this.jsonStreamer);
        jsonStream.beginObject();
        jsonStream.name("context").value(this.context);
        jsonStream.name("metaData").value(this.metadata);
        jsonStream.name("severity").value(getSeverity());
        jsonStream.name("severityReason").value(this.severityReason);
        jsonStream.name("unhandled").value(this.severityReason.getUnhandled());
        jsonStream.name("exceptions");
        jsonStream.beginArray();
        Iterator<T> it = this.errors.iterator();
        while (it.hasNext()) {
            jsonStream.value((Error) it.next());
        }
        jsonStream.endArray();
        jsonStream.name("projectPackages");
        jsonStream.beginArray();
        Iterator<T> it2 = this.projectPackages.iterator();
        while (it2.hasNext()) {
            jsonStream.value((String) it2.next());
        }
        jsonStream.endArray();
        jsonStream.name("user").value(this.userImpl);
        jsonStream.name("app").value(getApp());
        jsonStream.name("device").value(getDevice());
        jsonStream.name("breadcrumbs").value(this.breadcrumbs);
        jsonStream.name("groupingHash").value(this.groupingHash);
        Map<String, Object> jsonableMap = this.internalMetrics.toJsonableMap();
        if (!jsonableMap.isEmpty()) {
            jsonStream.name("usage");
            jsonStream.beginObject();
            for (Map.Entry<String, Object> entry : jsonableMap.entrySet()) {
                jsonStream.name(entry.getKey()).value(entry.getValue());
            }
            jsonStream.endObject();
        }
        jsonStream.name("threads");
        jsonStream.beginArray();
        Iterator<T> it3 = this.threads.iterator();
        while (it3.hasNext()) {
            jsonStream.value((Thread) it3.next());
        }
        jsonStream.endArray();
        jsonStream.name("featureFlags").value(this.featureFlags);
        TraceCorrelation traceCorrelation = this.traceCorrelation;
        if (traceCorrelation != null) {
            jsonStream.name("correlation").value(traceCorrelation);
        }
        Session session = this.session;
        if (session != null) {
            Session sessionCopySession = Session.copySession(session);
            jsonStream.name("session").beginObject();
            jsonStream.name("id").value(sessionCopySession.getId());
            jsonStream.name("startedAt").value(sessionCopySession.getStartedAt());
            jsonStream.name("events").beginObject();
            jsonStream.name("handled").value(sessionCopySession.getHandledCount());
            jsonStream.name("unhandled").value(sessionCopySession.getUnhandledCount());
            jsonStream.endObject();
            jsonStream.endObject();
        }
        jsonStream.endObject();
    }

    public final Set<ErrorType> getErrorTypesFromStackframes$bugsnag_android_core_release() {
        List<Error> list = this.errors;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ErrorType type = ((Error) it.next()).getType();
            if (type != null) {
                arrayList.add(type);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        List<Error> list2 = this.errors;
        ArrayList<List> arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Error) it2.next()).getStacktrace());
        }
        ArrayList arrayList3 = new ArrayList();
        for (List list3 : arrayList2) {
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = list3.iterator();
            while (it3.hasNext()) {
                ErrorType type2 = ((Stackframe) it3.next()).getType();
                if (type2 != null) {
                    arrayList4.add(type2);
                }
            }
            CollectionsKt.addAll(arrayList3, arrayList4);
        }
        return SetsKt.plus(set, (Iterable) arrayList3);
    }

    public final void normalizeStackframeErrorTypes$bugsnag_android_core_release() {
        if (getErrorTypesFromStackframes$bugsnag_android_core_release().size() == 1) {
            List<Error> list = this.errors;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((Error) it.next()).getStacktrace());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Stackframe) it2.next()).setType(null);
            }
        }
    }

    public final void updateSeverityReasonInternal$bugsnag_android_core_release(SeverityReason severityReason) {
        this.severityReason = severityReason;
    }

    protected final void updateSeverityInternal(Severity severity) {
        this.severityReason = new SeverityReason(this.severityReason.getSeverityReasonType(), severity, this.severityReason.getUnhandled(), this.severityReason.getUnhandledOverridden(), this.severityReason.getAttributeValue(), this.severityReason.getAttributeKey());
    }

    protected final void updateSeverityReason(String reason) {
        this.severityReason = new SeverityReason(reason, this.severityReason.getCurrentSeverity(), this.severityReason.getUnhandled(), this.severityReason.getUnhandledOverridden(), this.severityReason.getAttributeValue(), this.severityReason.getAttributeKey());
    }

    public final String getSeverityReasonType() {
        return this.severityReason.getSeverityReasonType();
    }

    public final TrimMetrics trimMetadataStringsTo(int maxLength) {
        TrimMetrics trimMetricsTrimMetadataStringsTo = this.metadata.trimMetadataStringsTo(maxLength);
        int itemsTrimmed = trimMetricsTrimMetadataStringsTo.getItemsTrimmed() + 0;
        int dataTrimmed = trimMetricsTrimMetadataStringsTo.getDataTrimmed() + 0;
        Iterator<Breadcrumb> it = this.breadcrumbs.iterator();
        while (it.hasNext()) {
            TrimMetrics trimMetricsTrimMetadataStringsTo$bugsnag_android_core_release = it.next().impl.trimMetadataStringsTo$bugsnag_android_core_release(maxLength);
            itemsTrimmed += trimMetricsTrimMetadataStringsTo$bugsnag_android_core_release.getItemsTrimmed();
            dataTrimmed += trimMetricsTrimMetadataStringsTo$bugsnag_android_core_release.getDataTrimmed();
        }
        return new TrimMetrics(itemsTrimmed, dataTrimmed);
    }

    public final TrimMetrics trimBreadcrumbsBy(int byteCount) {
        int length = 0;
        int i = 0;
        while (length < byteCount && (!this.breadcrumbs.isEmpty())) {
            length += JsonHelper.INSTANCE.serialize((JsonStream.Streamable) this.breadcrumbs.remove(0)).length;
            i++;
        }
        if (i == 1) {
            this.breadcrumbs.add(new Breadcrumb("Removed to reduce payload size", this.logger));
        } else {
            List<Breadcrumb> list = this.breadcrumbs;
            StringBuilder sb = new StringBuilder("Removed, along with ");
            sb.append(i - 1);
            sb.append(" older breadcrumbs, to reduce payload size");
            list.add(new Breadcrumb(sb.toString(), this.logger));
        }
        return new TrimMetrics(i, length);
    }

    @Override // com.bugsnag.android.UserAware
    public void setUser(String id, String email, String name) {
        this.userImpl = new User(id, email, name);
    }

    @Override // com.bugsnag.android.UserAware
    public User getUser() {
        return this.userImpl;
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String section, Map<String, ? extends Object> value) {
        this.metadata.addMetadata(section, value);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String section, String key, Object value) {
        this.metadata.addMetadata(section, key, value);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String section) {
        this.metadata.clearMetadata(section);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String section, String key) {
        this.metadata.clearMetadata(section, key);
    }

    @Override // com.bugsnag.android.MetadataAware
    public Map<String, Object> getMetadata(String section) {
        return this.metadata.getMetadata(section);
    }

    @Override // com.bugsnag.android.MetadataAware
    public Object getMetadata(String section, String key) {
        return this.metadata.getMetadata(section, key);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String name) {
        this.featureFlags.addFeatureFlag(name);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String name, String variant) {
        this.featureFlags.addFeatureFlag(name, variant);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlags(Iterable<FeatureFlag> featureFlags) {
        this.featureFlags.addFeatureFlags(featureFlags);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlag(String name) {
        this.featureFlags.clearFeatureFlag(name);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlags() {
        this.featureFlags.clearFeatureFlags();
    }

    public final Error addError(Throwable thrownError) {
        if (thrownError == null) {
            Error error = new Error(new ErrorInternal("null", null, new Stacktrace(new ArrayList()), null, 8, null), this.logger);
            this.errors.add(error);
            return error;
        }
        List<Error> listCreateError = Error.createError(thrownError, this.projectPackages, this.logger);
        this.errors.addAll(listCreateError);
        return (Error) CollectionsKt.first((List) listCreateError);
    }

    public final Error addError(String errorClass, String errorMessage, ErrorType errorType) {
        String strValueOf = String.valueOf(errorClass);
        Stacktrace stacktrace = new Stacktrace(new ArrayList());
        if (errorType == null) {
            errorType = ErrorType.ANDROID;
        }
        Error error = new Error(new ErrorInternal(strValueOf, errorMessage, stacktrace, errorType), this.logger);
        this.errors.add(error);
        return error;
    }

    public final Thread addThread(String id, String name, ErrorType errorType, boolean isErrorReportingThread, String state) {
        Thread thread = new Thread(new ThreadInternal(String.valueOf(id), String.valueOf(name), errorType, isErrorReportingThread, state, new Stacktrace(new ArrayList())), this.logger);
        this.threads.add(thread);
        return thread;
    }

    public final Breadcrumb leaveBreadcrumb(String message, BreadcrumbType type, Map<String, Object> metadata) {
        String strValueOf = String.valueOf(message);
        if (type == null) {
            type = BreadcrumbType.MANUAL;
        }
        Breadcrumb breadcrumb = new Breadcrumb(strValueOf, type, metadata, new Date(), this.logger);
        this.breadcrumbs.add(breadcrumb);
        return breadcrumb;
    }
}
