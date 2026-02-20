package com.bugsnag.android;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ManifestConfigLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J0\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tJ!\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0002\b\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0018"}, d2 = {"Lcom/bugsnag/android/ManifestConfigLoader;", "", "()V", "getPatternSet", "", "Ljava/util/regex/Pattern;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/os/Bundle;", "key", "", "default", "getStrArray", "load", "Lcom/bugsnag/android/Configuration;", "ctx", "Landroid/content/Context;", "userSuppliedApiKey", "load$bugsnag_android_core_release", "loadAppConfig", "", "config", "loadDetectionConfig", "loadEndpointsConfig", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ManifestConfigLoader {
    private static final String API_KEY = "com.bugsnag.android.API_KEY";
    private static final String APP_TYPE = "com.bugsnag.android.APP_TYPE";
    private static final String APP_VERSION = "com.bugsnag.android.APP_VERSION";
    private static final String ATTEMPT_DELIVERY_ON_CRASH = "com.bugsnag.android.ATTEMPT_DELIVERY_ON_CRASH";
    private static final String AUTO_DETECT_ERRORS = "com.bugsnag.android.AUTO_DETECT_ERRORS";
    private static final String AUTO_TRACK_SESSIONS = "com.bugsnag.android.AUTO_TRACK_SESSIONS";
    private static final String BUGSNAG_NS = "com.bugsnag.android";
    public static final String BUILD_UUID = "com.bugsnag.android.BUILD_UUID";
    private static final String DISCARD_CLASSES = "com.bugsnag.android.DISCARD_CLASSES";
    private static final String ENABLED_RELEASE_STAGES = "com.bugsnag.android.ENABLED_RELEASE_STAGES";
    private static final String ENDPOINT_NOTIFY = "com.bugsnag.android.ENDPOINT_NOTIFY";
    private static final String ENDPOINT_SESSIONS = "com.bugsnag.android.ENDPOINT_SESSIONS";
    private static final String GENERATE_ANONYMOUS_ID = "com.bugsnag.android.GENERATE_ANONYMOUS_ID";
    private static final String LAUNCH_CRASH_THRESHOLD_MS = "com.bugsnag.android.LAUNCH_CRASH_THRESHOLD_MS";
    private static final String LAUNCH_DURATION_MILLIS = "com.bugsnag.android.LAUNCH_DURATION_MILLIS";
    private static final String MAX_BREADCRUMBS = "com.bugsnag.android.MAX_BREADCRUMBS";
    private static final String MAX_PERSISTED_EVENTS = "com.bugsnag.android.MAX_PERSISTED_EVENTS";
    private static final String MAX_PERSISTED_SESSIONS = "com.bugsnag.android.MAX_PERSISTED_SESSIONS";
    private static final String MAX_REPORTED_THREADS = "com.bugsnag.android.MAX_REPORTED_THREADS";
    private static final String PERSIST_USER = "com.bugsnag.android.PERSIST_USER";
    private static final String PROJECT_PACKAGES = "com.bugsnag.android.PROJECT_PACKAGES";
    private static final String REDACTED_KEYS = "com.bugsnag.android.REDACTED_KEYS";
    private static final String RELEASE_STAGE = "com.bugsnag.android.RELEASE_STAGE";
    private static final String SEND_LAUNCH_CRASHES_SYNCHRONOUSLY = "com.bugsnag.android.SEND_LAUNCH_CRASHES_SYNCHRONOUSLY";
    private static final String SEND_THREADS = "com.bugsnag.android.SEND_THREADS";
    private static final String THREAD_COLLECTION_TIME_LIMIT_MS = "com.bugsnag.android.THREAD_COLLECTION_TIME_LIMIT_MS";
    private static final String VERSION_CODE = "com.bugsnag.android.VERSION_CODE";

    public final Configuration load(Context ctx, String userSuppliedApiKey) {
        try {
            return load$bugsnag_android_core_release(ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), 128).metaData, userSuppliedApiKey);
        } catch (Exception e) {
            throw new IllegalStateException("Bugsnag is unable to read config from manifest.", e);
        }
    }

    public final Configuration load$bugsnag_android_core_release(Bundle data, String userSuppliedApiKey) {
        if (userSuppliedApiKey == null) {
            userSuppliedApiKey = data == null ? null : data.getString(API_KEY);
        }
        if (userSuppliedApiKey == null) {
            throw new IllegalArgumentException("No Bugsnag API key set");
        }
        Configuration configuration = new Configuration(userSuppliedApiKey);
        if (data != null) {
            loadDetectionConfig(configuration, data);
            loadEndpointsConfig(configuration, data);
            loadAppConfig(configuration, data);
            configuration.setMaxBreadcrumbs(data.getInt(MAX_BREADCRUMBS, configuration.getMaxBreadcrumbs()));
            configuration.setMaxPersistedEvents(data.getInt(MAX_PERSISTED_EVENTS, configuration.getMaxPersistedEvents()));
            configuration.setMaxPersistedSessions(data.getInt(MAX_PERSISTED_SESSIONS, configuration.getMaxPersistedSessions()));
            configuration.setMaxReportedThreads(data.getInt(MAX_REPORTED_THREADS, configuration.getMaxReportedThreads()));
            configuration.setThreadCollectionTimeLimitMillis(data.getLong(THREAD_COLLECTION_TIME_LIMIT_MS, configuration.getThreadCollectionTimeLimitMillis()));
            configuration.setLaunchDurationMillis(data.getInt(LAUNCH_DURATION_MILLIS, (int) configuration.getLaunchDurationMillis()));
            configuration.setSendLaunchCrashesSynchronously(data.getBoolean(SEND_LAUNCH_CRASHES_SYNCHRONOUSLY, configuration.getSendLaunchCrashesSynchronously()));
            configuration.setAttemptDeliveryOnCrash(data.getBoolean(ATTEMPT_DELIVERY_ON_CRASH, configuration.isAttemptDeliveryOnCrash()));
        }
        return configuration;
    }

    private final void loadDetectionConfig(Configuration config, Bundle data) {
        config.setAutoTrackSessions(data.getBoolean(AUTO_TRACK_SESSIONS, config.getAutoTrackSessions()));
        config.setAutoDetectErrors(data.getBoolean(AUTO_DETECT_ERRORS, config.getAutoDetectErrors()));
        config.setPersistUser(data.getBoolean(PERSIST_USER, config.getPersistUser()));
        config.setGenerateAnonymousId(data.getBoolean(GENERATE_ANONYMOUS_ID, config.getGenerateAnonymousId()));
        String string = data.getString(SEND_THREADS);
        if (string != null) {
            config.setSendThreads(ThreadSendPolicy.INSTANCE.fromString(string));
        }
    }

    private final void loadEndpointsConfig(Configuration config, Bundle data) {
        if (data.containsKey(ENDPOINT_NOTIFY)) {
            config.setEndpoints(new EndpointConfiguration(data.getString(ENDPOINT_NOTIFY, config.getEndpoints().getNotify()), data.getString(ENDPOINT_SESSIONS, config.getEndpoints().getSessions())));
        }
    }

    private final void loadAppConfig(Configuration config, Bundle data) {
        config.setReleaseStage(data.getString(RELEASE_STAGE, config.getReleaseStage()));
        config.setAppVersion(data.getString(APP_VERSION, config.getAppVersion()));
        config.setAppType(data.getString(APP_TYPE, config.getAppType()));
        if (data.containsKey(VERSION_CODE)) {
            config.setVersionCode(Integer.valueOf(data.getInt(VERSION_CODE)));
        }
        if (data.containsKey(ENABLED_RELEASE_STAGES)) {
            config.setEnabledReleaseStages(getStrArray(data, ENABLED_RELEASE_STAGES, config.getEnabledReleaseStages()));
        }
        Set<Pattern> patternSet = getPatternSet(data, DISCARD_CLASSES, config.getDiscardClasses());
        if (patternSet == null) {
            patternSet = SetsKt.emptySet();
        }
        config.setDiscardClasses(patternSet);
        Set<String> strArray = getStrArray(data, PROJECT_PACKAGES, SetsKt.emptySet());
        if (strArray == null) {
            strArray = SetsKt.emptySet();
        }
        config.setProjectPackages(strArray);
        Set<Pattern> patternSet2 = getPatternSet(data, REDACTED_KEYS, config.getRedactedKeys());
        if (patternSet2 == null) {
            patternSet2 = SetsKt.emptySet();
        }
        config.setRedactedKeys(patternSet2);
    }

    private final Set<String> getStrArray(Bundle data, String key, Set<String> set) {
        String string = data.getString(key);
        List listSplit$default = string == null ? null : StringsKt.split$default((CharSequence) string, new String[]{","}, false, 0, 6, (Object) null);
        return listSplit$default == null ? set : CollectionsKt.toSet(listSplit$default);
    }

    private final Set<Pattern> getPatternSet(Bundle data, String key, Set<Pattern> set) {
        String string = data.getString(key);
        return string == null ? set : SequencesKt.toSet(SequencesKt.map(StringsKt.splitToSequence$default((CharSequence) string, new char[]{','}, false, 0, 6, (Object) null), new Function1<String, Pattern>() { // from class: com.bugsnag.android.ManifestConfigLoader.getPatternSet.1
            @Override // kotlin.jvm.functions.Function1
            public final Pattern invoke(String str) {
                return Pattern.compile(str);
            }
        }));
    }
}
