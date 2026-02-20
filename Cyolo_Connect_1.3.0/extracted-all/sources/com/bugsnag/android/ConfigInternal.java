package com.bugsnag.android;

import android.content.Context;
import com.google.firebase.dynamiclinks.DynamicLink;
import io.cyolo.android.MainActivityKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ConfigInternal.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0000\u0018\u0000 É\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002É\u0001B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0006H\u0016J\u001e\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u00062\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u001b\u0010¡\u0001\u001a\u00030\u009e\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010£\u0001H\u0016J'\u0010¥\u0001\u001a\u00030\u009e\u00012\u0007\u0010¦\u0001\u001a\u00020\u00062\u0007\u0010§\u0001\u001a\u00020\u00062\t\u0010>\u001a\u0005\u0018\u00010¨\u0001H\u0016J+\u0010¥\u0001\u001a\u00030\u009e\u00012\u0007\u0010¦\u0001\u001a\u00020\u00062\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0007\u0012\u0005\u0018\u00010¨\u00010©\u0001H\u0016J\u0014\u0010ª\u0001\u001a\u00030\u009e\u00012\b\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\u0014\u0010\u00ad\u0001\u001a\u00030\u009e\u00012\b\u0010®\u0001\u001a\u00030¯\u0001H\u0016J\u0012\u0010°\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001J\u0014\u0010³\u0001\u001a\u00030\u009e\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H\u0016J\u0011\u0010¶\u0001\u001a\u00030\u009e\u00012\u0007\u0010·\u0001\u001a\u00020xJ\u0013\u0010¸\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0006H\u0016J\n\u0010¹\u0001\u001a\u00030\u009e\u0001H\u0016J\u0013\u0010º\u0001\u001a\u00030\u009e\u00012\u0007\u0010¦\u0001\u001a\u00020\u0006H\u0016J\u001c\u0010º\u0001\u001a\u00030\u009e\u00012\u0007\u0010¦\u0001\u001a\u00020\u00062\u0007\u0010§\u0001\u001a\u00020\u0006H\u0016J\u0015\u0010»\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030¨\u00010©\u0001J\"\u0010¼\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030¨\u0001\u0018\u00010©\u00012\u0007\u0010¦\u0001\u001a\u00020\u0006H\u0016J\u001e\u0010¼\u0001\u001a\u0005\u0018\u00010¨\u00012\u0007\u0010¦\u0001\u001a\u00020\u00062\u0007\u0010§\u0001\u001a\u00020\u0006H\u0016J\n\u0010½\u0001\u001a\u00030\u0096\u0001H\u0016J\t\u0010¾\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010¿\u0001\u001a\u00030\u009e\u00012\b\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\u0014\u0010À\u0001\u001a\u00030\u009e\u00012\b\u0010®\u0001\u001a\u00030¯\u0001H\u0016J\u0012\u0010Á\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001J\u0014\u0010Â\u0001\u001a\u00030\u009e\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H\u0016J+\u0010Ã\u0001\u001a\u00030\u009e\u00012\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010Å\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010Æ\u0001\u001a\u00020\u00062\u0011\u0010Ç\u0001\u001a\f\u0012\u0005\u0012\u00030¨\u0001\u0018\u00010È\u0001H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u0010\u0010\u001f\u001a\u00020 8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\u0007R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010.\"\u0004\b=\u00100R$\u0010?\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0010\u0010D\u001a\u00020E8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u0018R\u001a\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR(\u0010P\u001a\u0004\u0018\u00010O2\b\u0010>\u001a\u0004\u0018\u00010O@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR\u001a\u0010^\u001a\u00020VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010X\"\u0004\b`\u0010ZR\u001a\u0010a\u001a\u00020VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010X\"\u0004\bc\u0010ZR\u001a\u0010d\u001a\u00020VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010X\"\u0004\bf\u0010ZR\u0010\u0010g\u001a\u00020h8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0011\u0010i\u001a\u00020j¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u001a\u0010m\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0016\"\u0004\bo\u0010\u0018R\u001c\u0010p\u001a\u0004\u0018\u00010qX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010v\u001a\u0012\u0012\u0004\u0012\u00020x0wj\b\u0012\u0004\u0012\u00020x`yX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R \u0010|\u001a\b\u0012\u0004\u0012\u00020\u00060+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010.\"\u0004\b~\u00100R2\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020,0+8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010.\"\u0005\b\u0081\u0001\u00100R\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u000b\"\u0005\b\u0084\u0001\u0010\u0007R\u001d\u0010\u0085\u0001\u001a\u00020\u0014X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0016\"\u0005\b\u0087\u0001\u0010\u0018R \u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R$\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010+X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010.\"\u0005\b\u0091\u0001\u00100R\u001d\u0010\u0092\u0001\u001a\u00020JX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010L\"\u0005\b\u0094\u0001\u0010NR\u0010\u0010\u0095\u0001\u001a\u00030\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0097\u0001\u001a\u0004\u0018\u00010VX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009c\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001¨\u0006Ê\u0001"}, d2 = {"Lcom/bugsnag/android/ConfigInternal;", "Lcom/bugsnag/android/CallbackAware;", "Lcom/bugsnag/android/MetadataAware;", "Lcom/bugsnag/android/UserAware;", "Lcom/bugsnag/android/FeatureFlagAware;", DynamicLink.Builder.KEY_API_KEY, "", "(Ljava/lang/String;)V", "_endpoints", "Lcom/bugsnag/android/EndpointConfiguration;", "getApiKey", "()Ljava/lang/String;", "setApiKey", "appType", "getAppType", "setAppType", "appVersion", "getAppVersion", "setAppVersion", "attemptDeliveryOnCrash", "", "getAttemptDeliveryOnCrash", "()Z", "setAttemptDeliveryOnCrash", "(Z)V", "autoDetectErrors", "getAutoDetectErrors", "setAutoDetectErrors", "autoTrackSessions", "getAutoTrackSessions", "setAutoTrackSessions", "callbackState", "Lcom/bugsnag/android/CallbackState;", "context", "getContext", "setContext", "delivery", "Lcom/bugsnag/android/Delivery;", "getDelivery", "()Lcom/bugsnag/android/Delivery;", "setDelivery", "(Lcom/bugsnag/android/Delivery;)V", "discardClasses", "", "Ljava/util/regex/Pattern;", "getDiscardClasses", "()Ljava/util/Set;", "setDiscardClasses", "(Ljava/util/Set;)V", "enabledBreadcrumbTypes", "Lcom/bugsnag/android/BreadcrumbType;", "getEnabledBreadcrumbTypes", "setEnabledBreadcrumbTypes", "enabledErrorTypes", "Lcom/bugsnag/android/ErrorTypes;", "getEnabledErrorTypes", "()Lcom/bugsnag/android/ErrorTypes;", "setEnabledErrorTypes", "(Lcom/bugsnag/android/ErrorTypes;)V", "enabledReleaseStages", "getEnabledReleaseStages", "setEnabledReleaseStages", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "endpoints", "getEndpoints", "()Lcom/bugsnag/android/EndpointConfiguration;", "setEndpoints", "(Lcom/bugsnag/android/EndpointConfiguration;)V", "featureFlagState", "Lcom/bugsnag/android/FeatureFlagState;", "generateAnonymousId", "getGenerateAnonymousId", "setGenerateAnonymousId", "launchDurationMillis", "", "getLaunchDurationMillis", "()J", "setLaunchDurationMillis", "(J)V", "Lcom/bugsnag/android/Logger;", "logger", "getLogger", "()Lcom/bugsnag/android/Logger;", "setLogger", "(Lcom/bugsnag/android/Logger;)V", "maxBreadcrumbs", "", "getMaxBreadcrumbs", "()I", "setMaxBreadcrumbs", "(I)V", "maxPersistedEvents", "getMaxPersistedEvents", "setMaxPersistedEvents", "maxPersistedSessions", "getMaxPersistedSessions", "setMaxPersistedSessions", "maxReportedThreads", "getMaxReportedThreads", "setMaxReportedThreads", "maxStringValueLength", "getMaxStringValueLength", "setMaxStringValueLength", "metadataState", "Lcom/bugsnag/android/MetadataState;", "notifier", "Lcom/bugsnag/android/Notifier;", "getNotifier", "()Lcom/bugsnag/android/Notifier;", "persistUser", "getPersistUser", "setPersistUser", "persistenceDirectory", "Ljava/io/File;", "getPersistenceDirectory", "()Ljava/io/File;", "setPersistenceDirectory", "(Ljava/io/File;)V", "plugins", "Ljava/util/HashSet;", "Lcom/bugsnag/android/Plugin;", "Lkotlin/collections/HashSet;", "getPlugins", "()Ljava/util/HashSet;", "projectPackages", "getProjectPackages", "setProjectPackages", "redactedKeys", "getRedactedKeys", "setRedactedKeys", "releaseStage", "getReleaseStage", "setReleaseStage", "sendLaunchCrashesSynchronously", "getSendLaunchCrashesSynchronously", "setSendLaunchCrashesSynchronously", "sendThreads", "Lcom/bugsnag/android/ThreadSendPolicy;", "getSendThreads", "()Lcom/bugsnag/android/ThreadSendPolicy;", "setSendThreads", "(Lcom/bugsnag/android/ThreadSendPolicy;)V", "telemetry", "Lcom/bugsnag/android/Telemetry;", "getTelemetry", "setTelemetry", "threadCollectionTimeLimitMillis", "getThreadCollectionTimeLimitMillis", "setThreadCollectionTimeLimitMillis", "user", "Lcom/bugsnag/android/User;", "versionCode", "getVersionCode", "()Ljava/lang/Integer;", "setVersionCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "addFeatureFlag", "", "name", "variant", "addFeatureFlags", "featureFlags", "", "Lcom/bugsnag/android/FeatureFlag;", "addMetadata", "section", "key", "", "", "addOnBreadcrumb", "onBreadcrumb", "Lcom/bugsnag/android/OnBreadcrumbCallback;", "addOnError", "onError", "Lcom/bugsnag/android/OnErrorCallback;", "addOnSend", "onSend", "Lcom/bugsnag/android/OnSendCallback;", "addOnSession", "onSession", "Lcom/bugsnag/android/OnSessionCallback;", "addPlugin", "plugin", "clearFeatureFlag", "clearFeatureFlags", "clearMetadata", "getConfigDifferences", "getMetadata", "getUser", "isHubApiKey", "removeOnBreadcrumb", "removeOnError", "removeOnSend", "removeOnSession", "setUser", "id", "email", "toCommaSeparated", "coll", "", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConfigInternal implements CallbackAware, MetadataAware, UserAware, FeatureFlagAware {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEFAULT_LAUNCH_CRASH_THRESHOLD_MS = 5000;
    private static final int DEFAULT_MAX_BREADCRUMBS = 100;
    private static final int DEFAULT_MAX_PERSISTED_EVENTS = 32;
    private static final int DEFAULT_MAX_PERSISTED_SESSIONS = 128;
    private static final int DEFAULT_MAX_REPORTED_THREADS = 200;
    private static final int DEFAULT_MAX_STRING_VALUE_LENGTH = 10000;
    private static final String DEFAULT_NOTIFY = "https://notify.bugsnag.com";
    private static final String DEFAULT_SESSION = "https://sessions.bugsnag.com";
    private static final long DEFAULT_THREAD_COLLECTION_TIME_LIMIT_MS = 5000;
    private static final String HUB_NOTIFY = "https://notify.insighthub.smartbear.com";
    private static final String HUB_PREFIX = "00000";
    private static final String HUB_SESSION = "https://sessions.insighthub.smartbear.com";
    private EndpointConfiguration _endpoints;
    private String apiKey;
    private String appVersion;
    private boolean attemptDeliveryOnCrash;
    private String context;
    private Delivery delivery;
    private Set<? extends BreadcrumbType> enabledBreadcrumbTypes;
    private Set<String> enabledReleaseStages;
    private File persistenceDirectory;
    private String releaseStage;
    private User user = new User(null, null, null, 7, null);
    public final CallbackState callbackState = new CallbackState(null, null, null, null, 15, null);
    public final MetadataState metadataState = new MetadataState(null, 1, null);
    public final FeatureFlagState featureFlagState = new FeatureFlagState(null, 1, null);
    private Integer versionCode = 0;
    private ThreadSendPolicy sendThreads = ThreadSendPolicy.ALWAYS;
    private boolean persistUser = true;
    private boolean generateAnonymousId = true;
    private long launchDurationMillis = 5000;
    private boolean autoTrackSessions = true;
    private boolean sendLaunchCrashesSynchronously = true;
    private ErrorTypes enabledErrorTypes = new ErrorTypes(false, false, false, false, 15, null);
    private boolean autoDetectErrors = true;
    private String appType = "android";
    private Logger logger = DebugLogger.INSTANCE;
    private int maxBreadcrumbs = 100;
    private int maxPersistedEvents = 32;
    private int maxPersistedSessions = 128;
    private int maxReportedThreads = 200;
    private long threadCollectionTimeLimitMillis = 5000;
    private int maxStringValueLength = DEFAULT_MAX_STRING_VALUE_LENGTH;
    private Set<Pattern> discardClasses = SetsKt.emptySet();
    private Set<? extends Telemetry> telemetry = EnumSet.of(Telemetry.INTERNAL_ERRORS, Telemetry.USAGE);
    private Set<String> projectPackages = SetsKt.emptySet();
    private final Notifier notifier = new Notifier(null, null, null, 7, null);
    private final HashSet<Plugin> plugins = new HashSet<>();

    @JvmStatic
    public static final Configuration load(Context context) {
        return INSTANCE.load(context);
    }

    @JvmStatic
    protected static final Configuration load(Context context, String str) {
        return INSTANCE.load(context, str);
    }

    public ConfigInternal(String str) {
        this.apiKey = str;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final void setApiKey(String str) {
        this.apiKey = str;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        this.appVersion = str;
    }

    public final Integer getVersionCode() {
        return this.versionCode;
    }

    public final void setVersionCode(Integer num) {
        this.versionCode = num;
    }

    public final String getReleaseStage() {
        return this.releaseStage;
    }

    public final void setReleaseStage(String str) {
        this.releaseStage = str;
    }

    public final ThreadSendPolicy getSendThreads() {
        return this.sendThreads;
    }

    public final void setSendThreads(ThreadSendPolicy threadSendPolicy) {
        this.sendThreads = threadSendPolicy;
    }

    public final boolean getPersistUser() {
        return this.persistUser;
    }

    public final void setPersistUser(boolean z) {
        this.persistUser = z;
    }

    public final boolean getGenerateAnonymousId() {
        return this.generateAnonymousId;
    }

    public final void setGenerateAnonymousId(boolean z) {
        this.generateAnonymousId = z;
    }

    public final long getLaunchDurationMillis() {
        return this.launchDurationMillis;
    }

    public final void setLaunchDurationMillis(long j) {
        this.launchDurationMillis = j;
    }

    public final boolean getAutoTrackSessions() {
        return this.autoTrackSessions;
    }

    public final void setAutoTrackSessions(boolean z) {
        this.autoTrackSessions = z;
    }

    public final boolean getSendLaunchCrashesSynchronously() {
        return this.sendLaunchCrashesSynchronously;
    }

    public final void setSendLaunchCrashesSynchronously(boolean z) {
        this.sendLaunchCrashesSynchronously = z;
    }

    public final ErrorTypes getEnabledErrorTypes() {
        return this.enabledErrorTypes;
    }

    public final void setEnabledErrorTypes(ErrorTypes errorTypes) {
        this.enabledErrorTypes = errorTypes;
    }

    public final boolean getAutoDetectErrors() {
        return this.autoDetectErrors;
    }

    public final void setAutoDetectErrors(boolean z) {
        this.autoDetectErrors = z;
    }

    public final String getAppType() {
        return this.appType;
    }

    public final void setAppType(String str) {
        this.appType = str;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final void setLogger(Logger logger) {
        if (logger == null) {
            logger = NoopLogger.INSTANCE;
        }
        this.logger = logger;
    }

    public final Delivery getDelivery() {
        return this.delivery;
    }

    public final void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    private final boolean isHubApiKey() {
        String str = this.apiKey;
        return str != null && StringsKt.startsWith$default(str, HUB_PREFIX, false, 2, (Object) null);
    }

    public final EndpointConfiguration getEndpoints() {
        EndpointConfiguration endpointConfiguration = this._endpoints;
        return endpointConfiguration == null ? isHubApiKey() ? new EndpointConfiguration(HUB_NOTIFY, HUB_SESSION) : new EndpointConfiguration(DEFAULT_NOTIFY, DEFAULT_SESSION) : endpointConfiguration;
    }

    public final void setEndpoints(EndpointConfiguration endpointConfiguration) {
        this._endpoints = endpointConfiguration;
    }

    public final int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public final void setMaxBreadcrumbs(int i) {
        this.maxBreadcrumbs = i;
    }

    public final int getMaxPersistedEvents() {
        return this.maxPersistedEvents;
    }

    public final void setMaxPersistedEvents(int i) {
        this.maxPersistedEvents = i;
    }

    public final int getMaxPersistedSessions() {
        return this.maxPersistedSessions;
    }

    public final void setMaxPersistedSessions(int i) {
        this.maxPersistedSessions = i;
    }

    public final int getMaxReportedThreads() {
        return this.maxReportedThreads;
    }

    public final void setMaxReportedThreads(int i) {
        this.maxReportedThreads = i;
    }

    public final long getThreadCollectionTimeLimitMillis() {
        return this.threadCollectionTimeLimitMillis;
    }

    public final void setThreadCollectionTimeLimitMillis(long j) {
        this.threadCollectionTimeLimitMillis = j;
    }

    public final int getMaxStringValueLength() {
        return this.maxStringValueLength;
    }

    public final void setMaxStringValueLength(int i) {
        this.maxStringValueLength = i;
    }

    public final String getContext() {
        return this.context;
    }

    public final void setContext(String str) {
        this.context = str;
    }

    public final Set<Pattern> getRedactedKeys() {
        return this.metadataState.getMetadata().getRedactedKeys();
    }

    public final void setRedactedKeys(Set<Pattern> set) {
        this.metadataState.getMetadata().setRedactedKeys(set);
    }

    public final Set<Pattern> getDiscardClasses() {
        return this.discardClasses;
    }

    public final void setDiscardClasses(Set<Pattern> set) {
        this.discardClasses = set;
    }

    public final Set<String> getEnabledReleaseStages() {
        return this.enabledReleaseStages;
    }

    public final void setEnabledReleaseStages(Set<String> set) {
        this.enabledReleaseStages = set;
    }

    public final Set<BreadcrumbType> getEnabledBreadcrumbTypes() {
        return this.enabledBreadcrumbTypes;
    }

    public final void setEnabledBreadcrumbTypes(Set<? extends BreadcrumbType> set) {
        this.enabledBreadcrumbTypes = set;
    }

    public final Set<Telemetry> getTelemetry() {
        return this.telemetry;
    }

    public final void setTelemetry(Set<? extends Telemetry> set) {
        this.telemetry = set;
    }

    public final Set<String> getProjectPackages() {
        return this.projectPackages;
    }

    public final void setProjectPackages(Set<String> set) {
        this.projectPackages = set;
    }

    public final File getPersistenceDirectory() {
        return this.persistenceDirectory;
    }

    public final void setPersistenceDirectory(File file) {
        this.persistenceDirectory = file;
    }

    public final boolean getAttemptDeliveryOnCrash() {
        return this.attemptDeliveryOnCrash;
    }

    public final void setAttemptDeliveryOnCrash(boolean z) {
        this.attemptDeliveryOnCrash = z;
    }

    public final Notifier getNotifier() {
        return this.notifier;
    }

    protected final HashSet<Plugin> getPlugins() {
        return this.plugins;
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnError(OnErrorCallback onError) {
        this.callbackState.addOnError(onError);
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnError(OnErrorCallback onError) {
        this.callbackState.removeOnError(onError);
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnBreadcrumb(OnBreadcrumbCallback onBreadcrumb) {
        this.callbackState.addOnBreadcrumb(onBreadcrumb);
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnBreadcrumb(OnBreadcrumbCallback onBreadcrumb) {
        this.callbackState.removeOnBreadcrumb(onBreadcrumb);
    }

    @Override // com.bugsnag.android.CallbackAware
    public void addOnSession(OnSessionCallback onSession) {
        this.callbackState.addOnSession(onSession);
    }

    @Override // com.bugsnag.android.CallbackAware
    public void removeOnSession(OnSessionCallback onSession) {
        this.callbackState.removeOnSession(onSession);
    }

    public final void addOnSend(OnSendCallback onSend) {
        this.callbackState.addOnSend(onSend);
    }

    public final void removeOnSend(OnSendCallback onSend) {
        this.callbackState.removeOnSend(onSend);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String section, Map<String, ? extends Object> value) {
        this.metadataState.addMetadata(section, value);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void addMetadata(String section, String key, Object value) {
        this.metadataState.addMetadata(section, key, value);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String section) {
        this.metadataState.clearMetadata(section);
    }

    @Override // com.bugsnag.android.MetadataAware
    public void clearMetadata(String section, String key) {
        this.metadataState.clearMetadata(section, key);
    }

    @Override // com.bugsnag.android.MetadataAware
    public Map<String, Object> getMetadata(String section) {
        return this.metadataState.getMetadata(section);
    }

    @Override // com.bugsnag.android.MetadataAware
    public Object getMetadata(String section, String key) {
        return this.metadataState.getMetadata(section, key);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String name) {
        this.featureFlagState.addFeatureFlag(name);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String name, String variant) {
        this.featureFlagState.addFeatureFlag(name, variant);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlags(Iterable<FeatureFlag> featureFlags) {
        this.featureFlagState.addFeatureFlags(featureFlags);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlag(String name) {
        this.featureFlagState.clearFeatureFlag(name);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlags() {
        this.featureFlagState.clearFeatureFlags();
    }

    @Override // com.bugsnag.android.UserAware
    /* JADX INFO: renamed from: getUser, reason: from getter */
    public User getUserImpl() {
        return this.user;
    }

    @Override // com.bugsnag.android.UserAware
    public void setUser(String id, String email, String name) {
        this.user = new User(id, email, name);
    }

    public final void addPlugin(Plugin plugin) {
        this.plugins.add(plugin);
    }

    private final String toCommaSeparated(Collection<? extends Object> coll) {
        String strJoinToString$default;
        if (coll == null) {
            return "";
        }
        Collection<? extends Object> collection = coll;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        List listSorted = CollectionsKt.sorted(arrayList);
        return (listSorted == null || (strJoinToString$default = CollectionsKt.joinToString$default(listSorted, ",", null, null, 0, null, null, 62, null)) == null) ? "" : strJoinToString$default;
    }

    public final Map<String, Object> getConfigDifferences() {
        Pair pair;
        ConfigInternal configInternal = new ConfigInternal("");
        Pair[] pairArr = new Pair[16];
        pairArr[0] = this.plugins.size() > 0 ? TuplesKt.to("pluginCount", Integer.valueOf(this.plugins.size())) : null;
        boolean z = this.autoDetectErrors;
        pairArr[1] = z != configInternal.autoDetectErrors ? TuplesKt.to("autoDetectErrors", Boolean.valueOf(z)) : null;
        boolean z2 = this.autoTrackSessions;
        pairArr[2] = z2 != configInternal.autoTrackSessions ? TuplesKt.to("autoTrackSessions", Boolean.valueOf(z2)) : null;
        pairArr[3] = this.discardClasses.size() > 0 ? TuplesKt.to("discardClassesCount", Integer.valueOf(this.discardClasses.size())) : null;
        pairArr[4] = !kotlin.jvm.internal.Intrinsics.areEqual(this.enabledBreadcrumbTypes, configInternal.enabledBreadcrumbTypes) ? TuplesKt.to("enabledBreadcrumbTypes", toCommaSeparated(this.enabledBreadcrumbTypes)) : null;
        if (kotlin.jvm.internal.Intrinsics.areEqual(this.enabledErrorTypes, configInternal.enabledErrorTypes)) {
            pair = null;
        } else {
            String[] strArr = new String[4];
            strArr[0] = this.enabledErrorTypes.getAnrs() ? "anrs" : null;
            strArr[1] = this.enabledErrorTypes.getNdkCrashes() ? "ndkCrashes" : null;
            strArr[2] = this.enabledErrorTypes.getUnhandledExceptions() ? "unhandledExceptions" : null;
            strArr[3] = this.enabledErrorTypes.getUnhandledRejections() ? "unhandledRejections" : null;
            pair = TuplesKt.to("enabledErrorTypes", toCommaSeparated(CollectionsKt.listOfNotNull((Object[]) strArr)));
        }
        pairArr[5] = pair;
        long j = this.launchDurationMillis;
        pairArr[6] = j != 0 ? TuplesKt.to("launchDurationMillis", Long.valueOf(j)) : null;
        pairArr[7] = !kotlin.jvm.internal.Intrinsics.areEqual(this.logger, NoopLogger.INSTANCE) ? TuplesKt.to("logger", true) : null;
        int i = this.maxBreadcrumbs;
        pairArr[8] = i != configInternal.maxBreadcrumbs ? TuplesKt.to("maxBreadcrumbs", Integer.valueOf(i)) : null;
        int i2 = this.maxPersistedEvents;
        pairArr[9] = i2 != configInternal.maxPersistedEvents ? TuplesKt.to("maxPersistedEvents", Integer.valueOf(i2)) : null;
        int i3 = this.maxPersistedSessions;
        pairArr[10] = i3 != configInternal.maxPersistedSessions ? TuplesKt.to("maxPersistedSessions", Integer.valueOf(i3)) : null;
        int i4 = this.maxReportedThreads;
        pairArr[11] = i4 != configInternal.maxReportedThreads ? TuplesKt.to("maxReportedThreads", Integer.valueOf(i4)) : null;
        long j2 = this.threadCollectionTimeLimitMillis;
        pairArr[12] = j2 != configInternal.threadCollectionTimeLimitMillis ? TuplesKt.to("threadCollectionTimeLimitMillis", Long.valueOf(j2)) : null;
        pairArr[13] = this.persistenceDirectory != null ? TuplesKt.to("persistenceDirectorySet", true) : null;
        ThreadSendPolicy threadSendPolicy = this.sendThreads;
        pairArr[14] = threadSendPolicy != configInternal.sendThreads ? TuplesKt.to("sendThreads", threadSendPolicy) : null;
        boolean z3 = this.attemptDeliveryOnCrash;
        pairArr[15] = z3 != configInternal.attemptDeliveryOnCrash ? TuplesKt.to("attemptDeliveryOnCrash", Boolean.valueOf(z3)) : null;
        return MapsKt.toMap(CollectionsKt.listOfNotNull((Object[]) pairArr));
    }

    /* JADX INFO: compiled from: ConfigInternal.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bugsnag/android/ConfigInternal$Companion;", "", "()V", "DEFAULT_LAUNCH_CRASH_THRESHOLD_MS", "", "DEFAULT_MAX_BREADCRUMBS", "", "DEFAULT_MAX_PERSISTED_EVENTS", "DEFAULT_MAX_PERSISTED_SESSIONS", "DEFAULT_MAX_REPORTED_THREADS", "DEFAULT_MAX_STRING_VALUE_LENGTH", "DEFAULT_NOTIFY", "", "DEFAULT_SESSION", "DEFAULT_THREAD_COLLECTION_TIME_LIMIT_MS", "HUB_NOTIFY", "HUB_PREFIX", "HUB_SESSION", "load", "Lcom/bugsnag/android/Configuration;", "context", "Landroid/content/Context;", DynamicLink.Builder.KEY_API_KEY, "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Configuration load(Context context) {
            return ConfigInternal.load(context, null);
        }

        @JvmStatic
        protected final Configuration load(Context context, String apiKey) {
            return new ManifestConfigLoader().load(context, apiKey);
        }
    }
}
