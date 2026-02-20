package com.bugsnag.android.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.Configuration;
import com.bugsnag.android.Connectivity;
import com.bugsnag.android.DebugLogger;
import com.bugsnag.android.DefaultDelivery;
import com.bugsnag.android.Delivery;
import com.bugsnag.android.EndpointConfiguration;
import com.bugsnag.android.ErrorTypes;
import com.bugsnag.android.Logger;
import com.bugsnag.android.ManifestConfigLoader;
import com.bugsnag.android.NoopLogger;
import com.bugsnag.android.ThreadSendPolicy;
import com.bugsnag.android.internal.dag.Provider;
import com.bugsnag.android.internal.dag.RunnableProvider;
import com.bugsnag.android.internal.dag.ValueProvider;
import com.google.firebase.dynamiclinks.DynamicLink;
import io.cyolo.android.MainActivityKt;
import java.io.File;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImmutableConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a$\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001aL\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0001\u001a\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0007\u001a(\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"RELEASE_STAGE_DEVELOPMENT", "", "RELEASE_STAGE_PRODUCTION", "VALID_API_KEY_LEN", "", "collectBuildUuid", "Lcom/bugsnag/android/internal/dag/Provider;", "appInfo", "Landroid/content/pm/ApplicationInfo;", "backgroundTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "convertToImmutableConfig", "Lcom/bugsnag/android/internal/ImmutableConfig;", "config", "Lcom/bugsnag/android/Configuration;", "buildUuid", "packageInfo", "Landroid/content/pm/PackageInfo;", "persistenceDir", "Lkotlin/Lazy;", "Ljava/io/File;", "isInvalidApiKey", "", DynamicLink.Builder.KEY_API_KEY, "sanitiseConfiguration", "appContext", "Landroid/content/Context;", "configuration", "connectivity", "Lcom/bugsnag/android/Connectivity;", "validateApiKey", "", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "bugsnag-android-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ImmutableConfigKt {
    public static final String RELEASE_STAGE_DEVELOPMENT = "development";
    public static final String RELEASE_STAGE_PRODUCTION = "production";
    public static final int VALID_API_KEY_LEN = 32;

    public static final ImmutableConfig convertToImmutableConfig(Configuration configuration) {
        return convertToImmutableConfig$default(configuration, null, null, null, null, 30, null);
    }

    public static final ImmutableConfig convertToImmutableConfig(Configuration configuration, Provider<String> provider) {
        return convertToImmutableConfig$default(configuration, provider, null, null, null, 28, null);
    }

    public static final ImmutableConfig convertToImmutableConfig(Configuration configuration, Provider<String> provider, PackageInfo packageInfo) {
        return convertToImmutableConfig$default(configuration, provider, packageInfo, null, null, 24, null);
    }

    public static final ImmutableConfig convertToImmutableConfig(Configuration configuration, Provider<String> provider, PackageInfo packageInfo, ApplicationInfo applicationInfo) {
        return convertToImmutableConfig$default(configuration, provider, packageInfo, applicationInfo, null, 16, null);
    }

    public static /* synthetic */ ImmutableConfig convertToImmutableConfig$default(final Configuration configuration, Provider provider, PackageInfo packageInfo, ApplicationInfo applicationInfo, Lazy lazy, int i, Object obj) {
        if ((i & 2) != 0) {
            provider = null;
        }
        if ((i & 4) != 0) {
            packageInfo = null;
        }
        if ((i & 8) != 0) {
            applicationInfo = null;
        }
        if ((i & 16) != 0) {
            lazy = LazyKt.lazy(new Function0<File>() { // from class: com.bugsnag.android.internal.ImmutableConfigKt.convertToImmutableConfig.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final File invoke() {
                    File persistenceDirectory = configuration.getPersistenceDirectory();
                    if (persistenceDirectory != null) {
                        return persistenceDirectory;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            });
        }
        return convertToImmutableConfig(configuration, provider, packageInfo, applicationInfo, lazy);
    }

    public static final ImmutableConfig convertToImmutableConfig(Configuration configuration, Provider<String> provider, PackageInfo packageInfo, ApplicationInfo applicationInfo, Lazy<? extends File> lazy) {
        ErrorTypes errorTypesCopy$bugsnag_android_core_release = configuration.getAutoDetectErrors() ? configuration.getEnabledErrorTypes().copy$bugsnag_android_core_release() : new ErrorTypes(false);
        String apiKey = configuration.getApiKey();
        boolean autoDetectErrors = configuration.getAutoDetectErrors();
        boolean autoTrackSessions = configuration.getAutoTrackSessions();
        ThreadSendPolicy sendThreads = configuration.getSendThreads();
        Set set = CollectionsKt.toSet(configuration.getDiscardClasses());
        Set<String> enabledReleaseStages = configuration.getEnabledReleaseStages();
        Set set2 = enabledReleaseStages == null ? null : CollectionsKt.toSet(enabledReleaseStages);
        Set set3 = CollectionsKt.toSet(configuration.getProjectPackages());
        String releaseStage = configuration.getReleaseStage();
        String appVersion = configuration.getAppVersion();
        Integer versionCode = configuration.getVersionCode();
        String appType = configuration.getAppType();
        Delivery delivery = configuration.getDelivery();
        EndpointConfiguration endpoints = configuration.getEndpoints();
        boolean persistUser = configuration.getPersistUser();
        boolean generateAnonymousId = configuration.getGenerateAnonymousId();
        long launchDurationMillis = configuration.getLaunchDurationMillis();
        Logger logger = configuration.getLogger();
        Intrinsics.checkNotNull(logger);
        int maxBreadcrumbs = configuration.getMaxBreadcrumbs();
        int maxPersistedEvents = configuration.getMaxPersistedEvents();
        int maxPersistedSessions = configuration.getMaxPersistedSessions();
        int maxReportedThreads = configuration.getMaxReportedThreads();
        int maxStringValueLength = configuration.getMaxStringValueLength();
        long threadCollectionTimeLimitMillis = configuration.getThreadCollectionTimeLimitMillis();
        Set<BreadcrumbType> enabledBreadcrumbTypes = configuration.getEnabledBreadcrumbTypes();
        return new ImmutableConfig(apiKey, autoDetectErrors, errorTypesCopy$bugsnag_android_core_release, autoTrackSessions, sendThreads, set, set2, set3, enabledBreadcrumbTypes != null ? CollectionsKt.toSet(enabledBreadcrumbTypes) : null, CollectionsKt.toSet(configuration.getTelemetry()), releaseStage, provider, appVersion, versionCode, appType, delivery, endpoints, persistUser, launchDurationMillis, logger, maxBreadcrumbs, maxPersistedEvents, maxPersistedSessions, maxReportedThreads, maxStringValueLength, threadCollectionTimeLimitMillis, lazy, configuration.getSendLaunchCrashesSynchronously(), configuration.isAttemptDeliveryOnCrash(), generateAnonymousId, packageInfo, applicationInfo, CollectionsKt.toSet(configuration.getRedactedKeys()));
    }

    private static final void validateApiKey(String str) {
        if (isInvalidApiKey(str)) {
            DebugLogger.INSTANCE.w(Intrinsics.stringPlus("Invalid configuration. apiKey should be a 32-character hexademical string, got ", str));
        }
    }

    /* JADX WARN: Found duplicated region for block: B:27:0x003f  */
    public static final boolean isInvalidApiKey(String str) {
        boolean z;
        String str2 = str;
        boolean z2 = false;
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("No Bugsnag API Key set");
        }
        if (str.length() != 32) {
            return true;
        }
        int i = 0;
        while (i < str2.length()) {
            char cCharAt = str2.charAt(i);
            i++;
            if (!Character.isDigit(cCharAt)) {
                z = 'a' <= cCharAt && cCharAt < 'g';
            }
            if (!z) {
                return !z2;
            }
        }
        z2 = true;
        return !z2;
    }

    public static final ImmutableConfig sanitiseConfiguration(final Context context, final Configuration configuration, Connectivity connectivity, BackgroundTaskService backgroundTaskService) {
        Object objM442constructorimpl;
        Object objM442constructorimpl2;
        Integer versionCode;
        validateApiKey(configuration.getApiKey());
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        try {
            Result.Companion companion = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(packageManager.getPackageInfo(packageName, 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m448isFailureimpl(objM442constructorimpl)) {
            objM442constructorimpl = null;
        }
        PackageInfo packageInfo = (PackageInfo) objM442constructorimpl;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            objM442constructorimpl2 = Result.m442constructorimpl(packageManager.getApplicationInfo(packageName, 128));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM442constructorimpl2 = Result.m442constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m448isFailureimpl(objM442constructorimpl2)) {
            objM442constructorimpl2 = null;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) objM442constructorimpl2;
        if (configuration.getReleaseStage() == null) {
            configuration.setReleaseStage((applicationInfo == null || (applicationInfo.flags & 2) == 0) ? RELEASE_STAGE_PRODUCTION : RELEASE_STAGE_DEVELOPMENT);
        }
        if (configuration.getLogger() == null || Intrinsics.areEqual(configuration.getLogger(), DebugLogger.INSTANCE)) {
            if (!Intrinsics.areEqual(RELEASE_STAGE_PRODUCTION, configuration.getReleaseStage())) {
                configuration.setLogger(DebugLogger.INSTANCE);
            } else {
                configuration.setLogger(NoopLogger.INSTANCE);
            }
        }
        if (configuration.getVersionCode() == null || ((versionCode = configuration.getVersionCode()) != null && versionCode.intValue() == 0)) {
            configuration.setVersionCode(packageInfo != null ? Integer.valueOf(packageInfo.versionCode) : null);
        }
        if (configuration.getProjectPackages().isEmpty()) {
            configuration.setProjectPackages(SetsKt.setOf(packageName));
        }
        Provider<String> providerCollectBuildUuid = collectBuildUuid(applicationInfo, backgroundTaskService);
        if (configuration.getDelivery() == null) {
            Logger logger = configuration.getLogger();
            Intrinsics.checkNotNull(logger);
            configuration.setDelivery(new DefaultDelivery(connectivity, logger));
        }
        return convertToImmutableConfig(configuration, providerCollectBuildUuid, packageInfo, applicationInfo, LazyKt.lazy(new Function0<File>() { // from class: com.bugsnag.android.internal.ImmutableConfigKt.sanitiseConfiguration.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File persistenceDirectory = configuration.getPersistenceDirectory();
                return persistenceDirectory == null ? context.getCacheDir() : persistenceDirectory;
            }
        }));
    }

    private static final Provider<String> collectBuildUuid(final ApplicationInfo applicationInfo, BackgroundTaskService backgroundTaskService) {
        Bundle bundle = applicationInfo == null ? null : applicationInfo.metaData;
        if (bundle != null && bundle.containsKey(ManifestConfigLoader.BUILD_UUID)) {
            String string = bundle.getString(ManifestConfigLoader.BUILD_UUID);
            if (string == null) {
                string = String.valueOf(bundle.getInt(ManifestConfigLoader.BUILD_UUID));
            }
            return new ValueProvider(string.length() > 0 ? string : null);
        }
        if (applicationInfo == null) {
            return null;
        }
        TaskType taskType = TaskType.IO;
        RunnableProvider<String> runnableProvider = new RunnableProvider<String>() { // from class: com.bugsnag.android.internal.ImmutableConfigKt$collectBuildUuid$$inlined$provider$1
            @Override // com.bugsnag.android.internal.dag.RunnableProvider
            public String invoke() {
                return DexBuildIdGenerator.INSTANCE.generateBuildId(applicationInfo);
            }
        };
        backgroundTaskService.execute(taskType, runnableProvider);
        return runnableProvider;
    }
}
