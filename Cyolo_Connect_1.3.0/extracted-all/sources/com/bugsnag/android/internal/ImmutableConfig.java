package com.bugsnag.android.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.Delivery;
import com.bugsnag.android.DeliveryHeadersKt;
import com.bugsnag.android.DeliveryParams;
import com.bugsnag.android.EndpointConfiguration;
import com.bugsnag.android.ErrorTypes;
import com.bugsnag.android.EventPayload;
import com.bugsnag.android.Logger;
import com.bugsnag.android.Session;
import com.bugsnag.android.Telemetry;
import com.bugsnag.android.ThreadSendPolicy;
import com.bugsnag.android.ThrowableUtils;
import com.bugsnag.android.internal.dag.Provider;
import com.google.common.primitives.Ints;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImmutableConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bZ\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BÑ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020\u001a\u0012\u0006\u0010&\u001a\u00020\u001a\u0012\u0006\u0010'\u001a\u00020\u001a\u0012\u0006\u0010(\u001a\u00020\u001a\u0012\u0006\u0010)\u001a\u00020\u001a\u0012\u0006\u0010*\u001a\u00020\"\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020\u0005\u0012\b\u00101\u001a\u0004\u0018\u000102\u0012\b\u00103\u001a\u0004\u0018\u000104\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u00106J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u000f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010l\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0017HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010gJ\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u001dHÆ\u0003J\t\u0010q\u001a\u00020\u001fHÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\"HÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\t\u0010u\u001a\u00020$HÆ\u0003J\t\u0010v\u001a\u00020\u001aHÆ\u0003J\t\u0010w\u001a\u00020\u001aHÆ\u0003J\t\u0010x\u001a\u00020\u001aHÆ\u0003J\t\u0010y\u001a\u00020\u001aHÆ\u0003J\t\u0010z\u001a\u00020\u001aHÆ\u0003J\t\u0010{\u001a\u00020\"HÆ\u0003J\u000f\u0010|\u001a\b\u0012\u0004\u0012\u00020-0,HÆ\u0003J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\u0010\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\nHÆ\u0003J\u0010\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u0012\u0010\u0087\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0010\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u0012\u0010\u0089\u0001\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u009e\u0003\u0010\u008a\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u001a2\b\b\u0002\u0010&\u001a\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010(\u001a\u00020\u001a2\b\b\u0002\u0010)\u001a\u00020\u001a2\b\b\u0002\u0010*\u001a\u00020\"2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0003\u0010\u008b\u0001J\u0015\u0010\u008c\u0001\u001a\u00020\u00052\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0014\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0001J\u0014\u0010\u0092\u0001\u001a\u00030\u008f\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0001J\n\u0010\u0095\u0001\u001a\u00020\u001aHÖ\u0001J\u0010\u0010\u0096\u0001\u001a\u00020\u00052\u0007\u0010\u0097\u0001\u001a\u00020\u0012J\u001a\u0010\u0098\u0001\u001a\u00020\u00052\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0003\b\u009a\u0001J\u0019\u0010\u0098\u0001\u001a\u00020\u00052\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0001¢\u0006\u0003\b\u009a\u0001J\u0007\u0010\u009d\u0001\u001a\u00020\u0005J\u0012\u0010\u009e\u0001\u001a\u00020\u00052\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003J\u0011\u0010\u009e\u0001\u001a\u00020\u00052\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001J\u0010\u0010\u009f\u0001\u001a\u00020\u00052\u0007\u0010 \u0001\u001a\u00020\u0005J\n\u0010¡\u0001\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00108R\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u001b\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\bK\u0010FR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u00100\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bN\u0010>R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0011\u0010%\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010&\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bU\u0010TR\u0011\u0010'\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bV\u0010TR\u0011\u0010(\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bW\u0010TR\u0011\u0010)\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bX\u0010TR\u0013\u00101\u001a\u0004\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010>R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b^\u0010FR\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b_\u0010FR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u00108R\u0011\u0010.\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\ba\u0010>R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\b\n\u0000\u001a\u0004\bd\u0010HR\u0011\u0010*\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\be\u0010PR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010g¨\u0006¢\u0001"}, d2 = {"Lcom/bugsnag/android/internal/ImmutableConfig;", "", DynamicLink.Builder.KEY_API_KEY, "", "autoDetectErrors", "", "enabledErrorTypes", "Lcom/bugsnag/android/ErrorTypes;", "autoTrackSessions", "sendThreads", "Lcom/bugsnag/android/ThreadSendPolicy;", "discardClasses", "", "Ljava/util/regex/Pattern;", "enabledReleaseStages", "projectPackages", "enabledBreadcrumbTypes", "", "Lcom/bugsnag/android/BreadcrumbType;", "telemetry", "Lcom/bugsnag/android/Telemetry;", "releaseStage", "buildUuid", "Lcom/bugsnag/android/internal/dag/Provider;", "appVersion", "versionCode", "", "appType", "delivery", "Lcom/bugsnag/android/Delivery;", "endpoints", "Lcom/bugsnag/android/EndpointConfiguration;", "persistUser", "launchDurationMillis", "", "logger", "Lcom/bugsnag/android/Logger;", "maxBreadcrumbs", "maxPersistedEvents", "maxPersistedSessions", "maxReportedThreads", "maxStringValueLength", "threadCollectionTimeLimitMillis", "persistenceDirectory", "Lkotlin/Lazy;", "Ljava/io/File;", "sendLaunchCrashesSynchronously", "attemptDeliveryOnCrash", "generateAnonymousId", "packageInfo", "Landroid/content/pm/PackageInfo;", "appInfo", "Landroid/content/pm/ApplicationInfo;", "redactedKeys", "(Ljava/lang/String;ZLcom/bugsnag/android/ErrorTypes;ZLcom/bugsnag/android/ThreadSendPolicy;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;Lcom/bugsnag/android/internal/dag/Provider;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bugsnag/android/Delivery;Lcom/bugsnag/android/EndpointConfiguration;ZJLcom/bugsnag/android/Logger;IIIIIJLkotlin/Lazy;ZZZLandroid/content/pm/PackageInfo;Landroid/content/pm/ApplicationInfo;Ljava/util/Collection;)V", "getApiKey", "()Ljava/lang/String;", "getAppInfo", "()Landroid/content/pm/ApplicationInfo;", "getAppType", "getAppVersion", "getAttemptDeliveryOnCrash", "()Z", "getAutoDetectErrors", "getAutoTrackSessions", "getBuildUuid", "()Lcom/bugsnag/android/internal/dag/Provider;", "getDelivery", "()Lcom/bugsnag/android/Delivery;", "getDiscardClasses", "()Ljava/util/Collection;", "getEnabledBreadcrumbTypes", "()Ljava/util/Set;", "getEnabledErrorTypes", "()Lcom/bugsnag/android/ErrorTypes;", "getEnabledReleaseStages", "getEndpoints", "()Lcom/bugsnag/android/EndpointConfiguration;", "getGenerateAnonymousId", "getLaunchDurationMillis", "()J", "getLogger", "()Lcom/bugsnag/android/Logger;", "getMaxBreadcrumbs", "()I", "getMaxPersistedEvents", "getMaxPersistedSessions", "getMaxReportedThreads", "getMaxStringValueLength", "getPackageInfo", "()Landroid/content/pm/PackageInfo;", "getPersistUser", "getPersistenceDirectory", "()Lkotlin/Lazy;", "getProjectPackages", "getRedactedKeys", "getReleaseStage", "getSendLaunchCrashesSynchronously", "getSendThreads", "()Lcom/bugsnag/android/ThreadSendPolicy;", "getTelemetry", "getThreadCollectionTimeLimitMillis", "getVersionCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ZLcom/bugsnag/android/ErrorTypes;ZLcom/bugsnag/android/ThreadSendPolicy;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;Lcom/bugsnag/android/internal/dag/Provider;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bugsnag/android/Delivery;Lcom/bugsnag/android/EndpointConfiguration;ZJLcom/bugsnag/android/Logger;IIIIIJLkotlin/Lazy;ZZZLandroid/content/pm/PackageInfo;Landroid/content/pm/ApplicationInfo;Ljava/util/Collection;)Lcom/bugsnag/android/internal/ImmutableConfig;", "equals", "other", "getErrorApiDeliveryParams", "Lcom/bugsnag/android/DeliveryParams;", "payload", "Lcom/bugsnag/android/EventPayload;", "getSessionApiDeliveryParams", "session", "Lcom/bugsnag/android/Session;", "hashCode", "shouldDiscardBreadcrumb", "type", "shouldDiscardByErrorClass", "errorClass", "shouldDiscardByErrorClass$bugsnag_android_core_release", "exc", "", "shouldDiscardByReleaseStage", "shouldDiscardError", "shouldDiscardSession", "autoCaptured", "toString", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class ImmutableConfig {
    private final String apiKey;
    private final ApplicationInfo appInfo;
    private final String appType;
    private final String appVersion;
    private final boolean attemptDeliveryOnCrash;
    private final boolean autoDetectErrors;
    private final boolean autoTrackSessions;
    private final Provider<String> buildUuid;
    private final Delivery delivery;
    private final Collection<Pattern> discardClasses;
    private final Set<BreadcrumbType> enabledBreadcrumbTypes;
    private final ErrorTypes enabledErrorTypes;
    private final Collection<String> enabledReleaseStages;
    private final EndpointConfiguration endpoints;
    private final boolean generateAnonymousId;
    private final long launchDurationMillis;
    private final Logger logger;
    private final int maxBreadcrumbs;
    private final int maxPersistedEvents;
    private final int maxPersistedSessions;
    private final int maxReportedThreads;
    private final int maxStringValueLength;
    private final PackageInfo packageInfo;
    private final boolean persistUser;
    private final Lazy<File> persistenceDirectory;
    private final Collection<String> projectPackages;
    private final Collection<Pattern> redactedKeys;
    private final String releaseStage;
    private final boolean sendLaunchCrashesSynchronously;
    private final ThreadSendPolicy sendThreads;
    private final Set<Telemetry> telemetry;
    private final long threadCollectionTimeLimitMillis;
    private final Integer versionCode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImmutableConfig copy$default(ImmutableConfig immutableConfig, String str, boolean z, ErrorTypes errorTypes, boolean z2, ThreadSendPolicy threadSendPolicy, Collection collection, Collection collection2, Collection collection3, Set set, Set set2, String str2, Provider provider, String str3, Integer num, String str4, Delivery delivery, EndpointConfiguration endpointConfiguration, boolean z3, long j, Logger logger, int i, int i2, int i3, int i4, int i5, long j2, Lazy lazy, boolean z4, boolean z5, boolean z6, PackageInfo packageInfo, ApplicationInfo applicationInfo, Collection collection4, int i6, int i7, Object obj) {
        String str5 = (i6 & 1) != 0 ? immutableConfig.apiKey : str;
        boolean z7 = (i6 & 2) != 0 ? immutableConfig.autoDetectErrors : z;
        ErrorTypes errorTypes2 = (i6 & 4) != 0 ? immutableConfig.enabledErrorTypes : errorTypes;
        boolean z8 = (i6 & 8) != 0 ? immutableConfig.autoTrackSessions : z2;
        ThreadSendPolicy threadSendPolicy2 = (i6 & 16) != 0 ? immutableConfig.sendThreads : threadSendPolicy;
        Collection collection5 = (i6 & 32) != 0 ? immutableConfig.discardClasses : collection;
        Collection collection6 = (i6 & 64) != 0 ? immutableConfig.enabledReleaseStages : collection2;
        Collection collection7 = (i6 & 128) != 0 ? immutableConfig.projectPackages : collection3;
        Set set3 = (i6 & 256) != 0 ? immutableConfig.enabledBreadcrumbTypes : set;
        Set set4 = (i6 & 512) != 0 ? immutableConfig.telemetry : set2;
        String str6 = (i6 & 1024) != 0 ? immutableConfig.releaseStage : str2;
        Provider provider2 = (i6 & 2048) != 0 ? immutableConfig.buildUuid : provider;
        String str7 = (i6 & 4096) != 0 ? immutableConfig.appVersion : str3;
        return immutableConfig.copy(str5, z7, errorTypes2, z8, threadSendPolicy2, collection5, collection6, collection7, set3, set4, str6, provider2, str7, (i6 & 8192) != 0 ? immutableConfig.versionCode : num, (i6 & 16384) != 0 ? immutableConfig.appType : str4, (i6 & 32768) != 0 ? immutableConfig.delivery : delivery, (i6 & 65536) != 0 ? immutableConfig.endpoints : endpointConfiguration, (i6 & 131072) != 0 ? immutableConfig.persistUser : z3, (i6 & 262144) != 0 ? immutableConfig.launchDurationMillis : j, (i6 & 524288) != 0 ? immutableConfig.logger : logger, (1048576 & i6) != 0 ? immutableConfig.maxBreadcrumbs : i, (i6 & 2097152) != 0 ? immutableConfig.maxPersistedEvents : i2, (i6 & 4194304) != 0 ? immutableConfig.maxPersistedSessions : i3, (i6 & 8388608) != 0 ? immutableConfig.maxReportedThreads : i4, (i6 & 16777216) != 0 ? immutableConfig.maxStringValueLength : i5, (i6 & 33554432) != 0 ? immutableConfig.threadCollectionTimeLimitMillis : j2, (i6 & 67108864) != 0 ? immutableConfig.persistenceDirectory : lazy, (134217728 & i6) != 0 ? immutableConfig.sendLaunchCrashesSynchronously : z4, (i6 & 268435456) != 0 ? immutableConfig.attemptDeliveryOnCrash : z5, (i6 & 536870912) != 0 ? immutableConfig.generateAnonymousId : z6, (i6 & Ints.MAX_POWER_OF_TWO) != 0 ? immutableConfig.packageInfo : packageInfo, (i6 & Integer.MIN_VALUE) != 0 ? immutableConfig.appInfo : applicationInfo, (i7 & 1) != 0 ? immutableConfig.redactedKeys : collection4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    public final Set<Telemetry> component10() {
        return this.telemetry;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getReleaseStage() {
        return this.releaseStage;
    }

    public final Provider<String> component12() {
        return this.buildUuid;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAppType() {
        return this.appType;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Delivery getDelivery() {
        return this.delivery;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final EndpointConfiguration getEndpoints() {
        return this.endpoints;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getPersistUser() {
        return this.persistUser;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final long getLaunchDurationMillis() {
        return this.launchDurationMillis;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAutoDetectErrors() {
        return this.autoDetectErrors;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Logger getLogger() {
        return this.logger;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getMaxPersistedEvents() {
        return this.maxPersistedEvents;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getMaxPersistedSessions() {
        return this.maxPersistedSessions;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final int getMaxReportedThreads() {
        return this.maxReportedThreads;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final int getMaxStringValueLength() {
        return this.maxStringValueLength;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final long getThreadCollectionTimeLimitMillis() {
        return this.threadCollectionTimeLimitMillis;
    }

    public final Lazy<File> component27() {
        return this.persistenceDirectory;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final boolean getSendLaunchCrashesSynchronously() {
        return this.sendLaunchCrashesSynchronously;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final boolean getAttemptDeliveryOnCrash() {
        return this.attemptDeliveryOnCrash;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ErrorTypes getEnabledErrorTypes() {
        return this.enabledErrorTypes;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final boolean getGenerateAnonymousId() {
        return this.generateAnonymousId;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final PackageInfo getPackageInfo() {
        return this.packageInfo;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final ApplicationInfo getAppInfo() {
        return this.appInfo;
    }

    public final Collection<Pattern> component33() {
        return this.redactedKeys;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAutoTrackSessions() {
        return this.autoTrackSessions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ThreadSendPolicy getSendThreads() {
        return this.sendThreads;
    }

    public final Collection<Pattern> component6() {
        return this.discardClasses;
    }

    public final Collection<String> component7() {
        return this.enabledReleaseStages;
    }

    public final Collection<String> component8() {
        return this.projectPackages;
    }

    public final Set<BreadcrumbType> component9() {
        return this.enabledBreadcrumbTypes;
    }

    public final ImmutableConfig copy(String apiKey, boolean autoDetectErrors, ErrorTypes enabledErrorTypes, boolean autoTrackSessions, ThreadSendPolicy sendThreads, Collection<Pattern> discardClasses, Collection<String> enabledReleaseStages, Collection<String> projectPackages, Set<? extends BreadcrumbType> enabledBreadcrumbTypes, Set<? extends Telemetry> telemetry, String releaseStage, Provider<String> buildUuid, String appVersion, Integer versionCode, String appType, Delivery delivery, EndpointConfiguration endpoints, boolean persistUser, long launchDurationMillis, Logger logger, int maxBreadcrumbs, int maxPersistedEvents, int maxPersistedSessions, int maxReportedThreads, int maxStringValueLength, long threadCollectionTimeLimitMillis, Lazy<? extends File> persistenceDirectory, boolean sendLaunchCrashesSynchronously, boolean attemptDeliveryOnCrash, boolean generateAnonymousId, PackageInfo packageInfo, ApplicationInfo appInfo, Collection<Pattern> redactedKeys) {
        return new ImmutableConfig(apiKey, autoDetectErrors, enabledErrorTypes, autoTrackSessions, sendThreads, discardClasses, enabledReleaseStages, projectPackages, enabledBreadcrumbTypes, telemetry, releaseStage, buildUuid, appVersion, versionCode, appType, delivery, endpoints, persistUser, launchDurationMillis, logger, maxBreadcrumbs, maxPersistedEvents, maxPersistedSessions, maxReportedThreads, maxStringValueLength, threadCollectionTimeLimitMillis, persistenceDirectory, sendLaunchCrashesSynchronously, attemptDeliveryOnCrash, generateAnonymousId, packageInfo, appInfo, redactedKeys);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImmutableConfig)) {
            return false;
        }
        ImmutableConfig immutableConfig = (ImmutableConfig) other;
        return Intrinsics.areEqual(this.apiKey, immutableConfig.apiKey) && this.autoDetectErrors == immutableConfig.autoDetectErrors && Intrinsics.areEqual(this.enabledErrorTypes, immutableConfig.enabledErrorTypes) && this.autoTrackSessions == immutableConfig.autoTrackSessions && this.sendThreads == immutableConfig.sendThreads && Intrinsics.areEqual(this.discardClasses, immutableConfig.discardClasses) && Intrinsics.areEqual(this.enabledReleaseStages, immutableConfig.enabledReleaseStages) && Intrinsics.areEqual(this.projectPackages, immutableConfig.projectPackages) && Intrinsics.areEqual(this.enabledBreadcrumbTypes, immutableConfig.enabledBreadcrumbTypes) && Intrinsics.areEqual(this.telemetry, immutableConfig.telemetry) && Intrinsics.areEqual(this.releaseStage, immutableConfig.releaseStage) && Intrinsics.areEqual(this.buildUuid, immutableConfig.buildUuid) && Intrinsics.areEqual(this.appVersion, immutableConfig.appVersion) && Intrinsics.areEqual(this.versionCode, immutableConfig.versionCode) && Intrinsics.areEqual(this.appType, immutableConfig.appType) && Intrinsics.areEqual(this.delivery, immutableConfig.delivery) && Intrinsics.areEqual(this.endpoints, immutableConfig.endpoints) && this.persistUser == immutableConfig.persistUser && this.launchDurationMillis == immutableConfig.launchDurationMillis && Intrinsics.areEqual(this.logger, immutableConfig.logger) && this.maxBreadcrumbs == immutableConfig.maxBreadcrumbs && this.maxPersistedEvents == immutableConfig.maxPersistedEvents && this.maxPersistedSessions == immutableConfig.maxPersistedSessions && this.maxReportedThreads == immutableConfig.maxReportedThreads && this.maxStringValueLength == immutableConfig.maxStringValueLength && this.threadCollectionTimeLimitMillis == immutableConfig.threadCollectionTimeLimitMillis && Intrinsics.areEqual(this.persistenceDirectory, immutableConfig.persistenceDirectory) && this.sendLaunchCrashesSynchronously == immutableConfig.sendLaunchCrashesSynchronously && this.attemptDeliveryOnCrash == immutableConfig.attemptDeliveryOnCrash && this.generateAnonymousId == immutableConfig.generateAnonymousId && Intrinsics.areEqual(this.packageInfo, immutableConfig.packageInfo) && Intrinsics.areEqual(this.appInfo, immutableConfig.appInfo) && Intrinsics.areEqual(this.redactedKeys, immutableConfig.redactedKeys);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v40, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v53, types: [int] */
    /* JADX WARN: Type inference failed for: r1v55, types: [int] */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v65 */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v79 */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.apiKey.hashCode() * 31;
        boolean z = this.autoDetectErrors;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.enabledErrorTypes.hashCode()) * 31;
        boolean z2 = this.autoTrackSessions;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int iHashCode3 = (((((iHashCode2 + r12) * 31) + this.sendThreads.hashCode()) * 31) + this.discardClasses.hashCode()) * 31;
        Collection<String> collection = this.enabledReleaseStages;
        int iHashCode4 = (((iHashCode3 + (collection == null ? 0 : collection.hashCode())) * 31) + this.projectPackages.hashCode()) * 31;
        Set<BreadcrumbType> set = this.enabledBreadcrumbTypes;
        int iHashCode5 = (((iHashCode4 + (set == null ? 0 : set.hashCode())) * 31) + this.telemetry.hashCode()) * 31;
        String str = this.releaseStage;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Provider<String> provider = this.buildUuid;
        int iHashCode7 = (iHashCode6 + (provider == null ? 0 : provider.hashCode())) * 31;
        String str2 = this.appVersion;
        int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.versionCode;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.appType;
        int iHashCode10 = (((((iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.delivery.hashCode()) * 31) + this.endpoints.hashCode()) * 31;
        boolean z3 = this.persistUser;
        ?? r13 = z3;
        if (z3) {
            r13 = 1;
        }
        int iM = (((((((((((((((((((iHashCode10 + r13) * 31) + UByte$$ExternalSyntheticBackport0.m(this.launchDurationMillis)) * 31) + this.logger.hashCode()) * 31) + this.maxBreadcrumbs) * 31) + this.maxPersistedEvents) * 31) + this.maxPersistedSessions) * 31) + this.maxReportedThreads) * 31) + this.maxStringValueLength) * 31) + UByte$$ExternalSyntheticBackport0.m(this.threadCollectionTimeLimitMillis)) * 31) + this.persistenceDirectory.hashCode()) * 31;
        boolean z4 = this.sendLaunchCrashesSynchronously;
        ?? r14 = z4;
        if (z4) {
            r14 = 1;
        }
        int i = (iM + r14) * 31;
        boolean z5 = this.attemptDeliveryOnCrash;
        ?? r15 = z5;
        if (z5) {
            r15 = 1;
        }
        int i2 = (i + r15) * 31;
        boolean z6 = this.generateAnonymousId;
        int i3 = (i2 + (z6 ? 1 : z6)) * 31;
        PackageInfo packageInfo = this.packageInfo;
        int iHashCode11 = (i3 + (packageInfo == null ? 0 : packageInfo.hashCode())) * 31;
        ApplicationInfo applicationInfo = this.appInfo;
        return ((iHashCode11 + (applicationInfo != null ? applicationInfo.hashCode() : 0)) * 31) + this.redactedKeys.hashCode();
    }

    public String toString() {
        return "ImmutableConfig(apiKey=" + this.apiKey + ", autoDetectErrors=" + this.autoDetectErrors + ", enabledErrorTypes=" + this.enabledErrorTypes + ", autoTrackSessions=" + this.autoTrackSessions + ", sendThreads=" + this.sendThreads + ", discardClasses=" + this.discardClasses + ", enabledReleaseStages=" + this.enabledReleaseStages + ", projectPackages=" + this.projectPackages + ", enabledBreadcrumbTypes=" + this.enabledBreadcrumbTypes + ", telemetry=" + this.telemetry + ", releaseStage=" + ((Object) this.releaseStage) + ", buildUuid=" + this.buildUuid + ", appVersion=" + ((Object) this.appVersion) + ", versionCode=" + this.versionCode + ", appType=" + ((Object) this.appType) + ", delivery=" + this.delivery + ", endpoints=" + this.endpoints + ", persistUser=" + this.persistUser + ", launchDurationMillis=" + this.launchDurationMillis + ", logger=" + this.logger + ", maxBreadcrumbs=" + this.maxBreadcrumbs + ", maxPersistedEvents=" + this.maxPersistedEvents + ", maxPersistedSessions=" + this.maxPersistedSessions + ", maxReportedThreads=" + this.maxReportedThreads + ", maxStringValueLength=" + this.maxStringValueLength + ", threadCollectionTimeLimitMillis=" + this.threadCollectionTimeLimitMillis + ", persistenceDirectory=" + this.persistenceDirectory + ", sendLaunchCrashesSynchronously=" + this.sendLaunchCrashesSynchronously + ", attemptDeliveryOnCrash=" + this.attemptDeliveryOnCrash + ", generateAnonymousId=" + this.generateAnonymousId + ", packageInfo=" + this.packageInfo + ", appInfo=" + this.appInfo + ", redactedKeys=" + this.redactedKeys + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableConfig(String str, boolean z, ErrorTypes errorTypes, boolean z2, ThreadSendPolicy threadSendPolicy, Collection<Pattern> collection, Collection<String> collection2, Collection<String> collection3, Set<? extends BreadcrumbType> set, Set<? extends Telemetry> set2, String str2, Provider<String> provider, String str3, Integer num, String str4, Delivery delivery, EndpointConfiguration endpointConfiguration, boolean z3, long j, Logger logger, int i, int i2, int i3, int i4, int i5, long j2, Lazy<? extends File> lazy, boolean z4, boolean z5, boolean z6, PackageInfo packageInfo, ApplicationInfo applicationInfo, Collection<Pattern> collection4) {
        this.apiKey = str;
        this.autoDetectErrors = z;
        this.enabledErrorTypes = errorTypes;
        this.autoTrackSessions = z2;
        this.sendThreads = threadSendPolicy;
        this.discardClasses = collection;
        this.enabledReleaseStages = collection2;
        this.projectPackages = collection3;
        this.enabledBreadcrumbTypes = set;
        this.telemetry = set2;
        this.releaseStage = str2;
        this.buildUuid = provider;
        this.appVersion = str3;
        this.versionCode = num;
        this.appType = str4;
        this.delivery = delivery;
        this.endpoints = endpointConfiguration;
        this.persistUser = z3;
        this.launchDurationMillis = j;
        this.logger = logger;
        this.maxBreadcrumbs = i;
        this.maxPersistedEvents = i2;
        this.maxPersistedSessions = i3;
        this.maxReportedThreads = i4;
        this.maxStringValueLength = i5;
        this.threadCollectionTimeLimitMillis = j2;
        this.persistenceDirectory = lazy;
        this.sendLaunchCrashesSynchronously = z4;
        this.attemptDeliveryOnCrash = z5;
        this.generateAnonymousId = z6;
        this.packageInfo = packageInfo;
        this.appInfo = applicationInfo;
        this.redactedKeys = collection4;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final boolean getAutoDetectErrors() {
        return this.autoDetectErrors;
    }

    public final ErrorTypes getEnabledErrorTypes() {
        return this.enabledErrorTypes;
    }

    public final boolean getAutoTrackSessions() {
        return this.autoTrackSessions;
    }

    public final ThreadSendPolicy getSendThreads() {
        return this.sendThreads;
    }

    public final Collection<Pattern> getDiscardClasses() {
        return this.discardClasses;
    }

    public final Collection<String> getEnabledReleaseStages() {
        return this.enabledReleaseStages;
    }

    public final Collection<String> getProjectPackages() {
        return this.projectPackages;
    }

    public final Set<BreadcrumbType> getEnabledBreadcrumbTypes() {
        return this.enabledBreadcrumbTypes;
    }

    public final Set<Telemetry> getTelemetry() {
        return this.telemetry;
    }

    public final String getReleaseStage() {
        return this.releaseStage;
    }

    public final Provider<String> getBuildUuid() {
        return this.buildUuid;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final Integer getVersionCode() {
        return this.versionCode;
    }

    public final String getAppType() {
        return this.appType;
    }

    public final Delivery getDelivery() {
        return this.delivery;
    }

    public final EndpointConfiguration getEndpoints() {
        return this.endpoints;
    }

    public final boolean getPersistUser() {
        return this.persistUser;
    }

    public final long getLaunchDurationMillis() {
        return this.launchDurationMillis;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public final int getMaxPersistedEvents() {
        return this.maxPersistedEvents;
    }

    public final int getMaxPersistedSessions() {
        return this.maxPersistedSessions;
    }

    public final int getMaxReportedThreads() {
        return this.maxReportedThreads;
    }

    public final int getMaxStringValueLength() {
        return this.maxStringValueLength;
    }

    public final long getThreadCollectionTimeLimitMillis() {
        return this.threadCollectionTimeLimitMillis;
    }

    public final Lazy<File> getPersistenceDirectory() {
        return this.persistenceDirectory;
    }

    public final boolean getSendLaunchCrashesSynchronously() {
        return this.sendLaunchCrashesSynchronously;
    }

    public final boolean getAttemptDeliveryOnCrash() {
        return this.attemptDeliveryOnCrash;
    }

    public final boolean getGenerateAnonymousId() {
        return this.generateAnonymousId;
    }

    public final PackageInfo getPackageInfo() {
        return this.packageInfo;
    }

    public final ApplicationInfo getAppInfo() {
        return this.appInfo;
    }

    public final Collection<Pattern> getRedactedKeys() {
        return this.redactedKeys;
    }

    public final DeliveryParams getErrorApiDeliveryParams(EventPayload payload) {
        return new DeliveryParams(this.endpoints.getNotify(), DeliveryHeadersKt.errorApiHeaders(payload));
    }

    public final DeliveryParams getSessionApiDeliveryParams(Session session) {
        return new DeliveryParams(this.endpoints.getSessions(), DeliveryHeadersKt.sessionApiHeaders(session.getApiKey()));
    }

    public final boolean shouldDiscardError(Throwable exc) {
        return shouldDiscardByReleaseStage() || shouldDiscardByErrorClass$bugsnag_android_core_release(exc);
    }

    public final boolean shouldDiscardError(String errorClass) {
        return shouldDiscardByReleaseStage() || shouldDiscardByErrorClass$bugsnag_android_core_release(errorClass);
    }

    public final boolean shouldDiscardSession(boolean autoCaptured) {
        return shouldDiscardByReleaseStage() || (autoCaptured && !this.autoTrackSessions);
    }

    public final boolean shouldDiscardBreadcrumb(BreadcrumbType type) {
        Set<BreadcrumbType> set = this.enabledBreadcrumbTypes;
        return (set == null || set.contains(type)) ? false : true;
    }

    public final boolean shouldDiscardByReleaseStage() {
        Collection<String> collection = this.enabledReleaseStages;
        return (collection == null || CollectionsKt.contains(collection, this.releaseStage)) ? false : true;
    }

    public final boolean shouldDiscardByErrorClass$bugsnag_android_core_release(String errorClass) {
        String str = errorClass;
        if (!(str == null || str.length() == 0)) {
            Collection<Pattern> collection = this.discardClasses;
            if (!(collection instanceof Collection) || !collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((Pattern) it.next()).matcher(errorClass.toString()).matches()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean shouldDiscardByErrorClass$bugsnag_android_core_release(Throwable exc) {
        List<Throwable> listSafeUnrollCauses = ThrowableUtils.safeUnrollCauses(exc);
        if ((listSafeUnrollCauses instanceof Collection) && listSafeUnrollCauses.isEmpty()) {
            return false;
        }
        Iterator<T> it = listSafeUnrollCauses.iterator();
        while (it.hasNext()) {
            if (shouldDiscardByErrorClass$bugsnag_android_core_release(((Throwable) it.next()).getClass().getName())) {
                return true;
            }
        }
        return false;
    }
}
