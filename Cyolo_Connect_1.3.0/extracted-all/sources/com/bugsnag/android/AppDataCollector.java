package com.bugsnag.android;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.dag.Provider;
import io.flutter.plugins.firebase.dynamiclinks.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppDataCollector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 82\u00020\u0001:\u00018BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u001d\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0004\b%\u0010&J\n\u0010'\u001a\u0004\u0018\u00010\u0013H\u0003J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010.J\n\u0010/\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u00100\u001a\u0004\u0018\u00010\u0013J\n\u00101\u001a\u0004\u0018\u00010\u0013H\u0003J\u000f\u00102\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u00103J\u001e\u00104\u001a\u0002052\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010.H\u0002J\u000e\u00107\u001a\u0002052\u0006\u0010\u0017\u001a\u00020\u0013R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bugsnag/android/AppDataCollector;", "", "appContext", "Landroid/content/Context;", "packageManager", "Landroid/content/pm/PackageManager;", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "sessionTracker", "Lcom/bugsnag/android/internal/dag/Provider;", "Lcom/bugsnag/android/SessionTracker;", "activityManager", "Landroid/app/ActivityManager;", "launchCrashTracker", "Lcom/bugsnag/android/LaunchCrashTracker;", "memoryTrimState", "Lcom/bugsnag/android/MemoryTrimState;", "(Landroid/content/Context;Landroid/content/pm/PackageManager;Lcom/bugsnag/android/internal/ImmutableConfig;Lcom/bugsnag/android/internal/dag/Provider;Landroid/app/ActivityManager;Lcom/bugsnag/android/LaunchCrashTracker;Lcom/bugsnag/android/MemoryTrimState;)V", Constants.APP_NAME, "", "bgWorkRestricted", "", "Ljava/lang/Boolean;", "binaryArch", "codeBundleId", "getCodeBundleId", "()Ljava/lang/String;", "setCodeBundleId", "(Ljava/lang/String;)V", "installerPackage", "packageName", "processName", "releaseStage", "versionName", "calculateDurationInForeground", "", "inForeground", "calculateDurationInForeground$bugsnag_android_core_release", "(Ljava/lang/Boolean;)Ljava/lang/Long;", "findProcessName", "generateApp", "Lcom/bugsnag/android/App;", "generateAppWithState", "Lcom/bugsnag/android/AppWithState;", "generateHistoricAppWithState", "getAppDataMetadata", "", "getAppName", "getInstallerPackageName", "getProcessImportance", "isBackgroundWorkRestricted", "()Ljava/lang/Boolean;", "populateRuntimeMemoryMetadata", "", "map", "setBinaryArch", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppDataCollector {
    private static final int IMPORTANCE_CANT_SAVE_STATE_PRE_26 = 170;
    private final ActivityManager activityManager;
    private String binaryArch;
    private String codeBundleId;
    private final ImmutableConfig config;
    private final String installerPackage;
    private final LaunchCrashTracker launchCrashTracker;
    private final MemoryTrimState memoryTrimState;
    private final PackageManager packageManager;
    private final String packageName;
    private final String releaseStage;
    private final Provider<SessionTracker> sessionTracker;
    private final String versionName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long startTimeMs = SystemClock.elapsedRealtime();
    private final Boolean bgWorkRestricted = isBackgroundWorkRestricted();
    private final String appName = getAppName();
    private final String processName = findProcessName();

    public AppDataCollector(Context context, PackageManager packageManager, ImmutableConfig immutableConfig, Provider<SessionTracker> provider, ActivityManager activityManager, LaunchCrashTracker launchCrashTracker, MemoryTrimState memoryTrimState) {
        this.packageManager = packageManager;
        this.config = immutableConfig;
        this.sessionTracker = provider;
        this.activityManager = activityManager;
        this.launchCrashTracker = launchCrashTracker;
        this.memoryTrimState = memoryTrimState;
        this.packageName = context.getPackageName();
        this.releaseStage = immutableConfig.getReleaseStage();
        String appVersion = immutableConfig.getAppVersion();
        if (appVersion == null) {
            PackageInfo packageInfo = immutableConfig.getPackageInfo();
            appVersion = packageInfo == null ? null : packageInfo.versionName;
        }
        this.versionName = appVersion;
        this.installerPackage = getInstallerPackageName();
    }

    public final String getCodeBundleId() {
        return this.codeBundleId;
    }

    public final void setCodeBundleId(String str) {
        this.codeBundleId = str;
    }

    public final App generateApp() {
        return new App(this.config, this.binaryArch, this.packageName, this.releaseStage, this.versionName, this.codeBundleId);
    }

    public final AppWithState generateAppWithState() {
        boolean zIsInForeground = this.sessionTracker.get().isInForeground();
        return new AppWithState(this.config, this.binaryArch, this.packageName, this.releaseStage, this.versionName, this.codeBundleId, Long.valueOf(INSTANCE.getDurationMs()), calculateDurationInForeground$bugsnag_android_core_release(Boolean.valueOf(zIsInForeground)), Boolean.valueOf(zIsInForeground), Boolean.valueOf(this.launchCrashTracker.isLaunching()));
    }

    public final AppWithState generateHistoricAppWithState() {
        return new AppWithState(this.config, this.binaryArch, this.packageName, this.releaseStage, this.versionName, this.codeBundleId, null, null, null, null);
    }

    private final String getProcessImportance() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.pid == 0) {
                return null;
            }
            int i = runningAppProcessInfo.importance;
            if (i == 1) {
                return "provider in use";
            }
            if (i == 2) {
                return "service in use";
            }
            switch (i) {
                case 100:
                    return "foreground";
                case 125:
                    return "foreground service";
                case 130:
                case 230:
                    return "perceptible";
                case 150:
                case 325:
                    return "top sleeping";
                case IMPORTANCE_CANT_SAVE_STATE_PRE_26 /* 170 */:
                case 350:
                    return "can't save state";
                case 200:
                    return "visible";
                case 300:
                    return NotificationCompat.CATEGORY_SERVICE;
                case 400:
                    return "cached/background";
                case 500:
                    return "empty";
                case 1000:
                    return "gone";
                default:
                    return "unknown importance (" + runningAppProcessInfo.importance + ')';
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final Map<String, Object> getAppDataMetadata() {
        HashMap map = new HashMap();
        map.put("name", this.appName);
        map.put("activeScreen", this.sessionTracker.get().getContextActivity());
        map.put("processImportance", getProcessImportance());
        if (this.memoryTrimState.getMemoryTrimLevel() != null) {
            map.put("lowMemory", Boolean.valueOf(this.memoryTrimState.getIsLowMemory()));
            map.put("memoryTrimLevel", this.memoryTrimState.getTrimLevelDescription());
        }
        populateRuntimeMemoryMetadata(map);
        Boolean bool = this.bgWorkRestricted;
        if (bool != null) {
            bool.booleanValue();
            map.put("backgroundWorkRestricted", this.bgWorkRestricted);
        }
        String str = this.processName;
        if (str != null) {
            map.put("processName", str);
        }
        return map;
    }

    private final void populateRuntimeMemoryMetadata(Map<String, Object> map) {
        Runtime runtime = Runtime.getRuntime();
        long j = runtime.totalMemory();
        long jFreeMemory = runtime.freeMemory();
        map.put("memoryUsage", Long.valueOf(j - jFreeMemory));
        map.put("totalMemory", Long.valueOf(j));
        map.put("freeMemory", Long.valueOf(jFreeMemory));
        map.put("memoryLimit", Long.valueOf(runtime.maxMemory()));
        map.put("installerPackage", this.installerPackage);
    }

    private final Boolean isBackgroundWorkRestricted() {
        if (this.activityManager == null || Build.VERSION.SDK_INT < 28) {
            return null;
        }
        if (this.activityManager.isBackgroundRestricted()) {
            return true;
        }
        return null;
    }

    public final void setBinaryArch(String binaryArch) {
        this.binaryArch = binaryArch;
    }

    public static /* synthetic */ Long calculateDurationInForeground$bugsnag_android_core_release$default(AppDataCollector appDataCollector, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.valueOf(appDataCollector.sessionTracker.get().isInForeground());
        }
        return appDataCollector.calculateDurationInForeground$bugsnag_android_core_release(bool);
    }

    public final Long calculateDurationInForeground$bugsnag_android_core_release(Boolean inForeground) {
        if (inForeground == null) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long lastEnteredForegroundMs = this.sessionTracker.get().getLastEnteredForegroundMs();
        long j = (!inForeground.booleanValue() || lastEnteredForegroundMs == 0) ? 0L : jElapsedRealtime - lastEnteredForegroundMs;
        if (j > 0) {
            return Long.valueOf(j);
        }
        return 0L;
    }

    private final String getAppName() {
        ApplicationInfo appInfo = this.config.getAppInfo();
        PackageManager packageManager = this.packageManager;
        if (packageManager == null || appInfo == null) {
            return null;
        }
        return packageManager.getApplicationLabel(appInfo).toString();
    }

    public final String getInstallerPackageName() {
        InstallSourceInfo installSourceInfo;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                PackageManager packageManager = this.packageManager;
                if (packageManager != null && (installSourceInfo = packageManager.getInstallSourceInfo(this.packageName)) != null) {
                    return installSourceInfo.getInstallingPackageName();
                }
                return null;
            }
            PackageManager packageManager2 = this.packageManager;
            if (packageManager2 == null) {
                return null;
            }
            return packageManager2.getInstallerPackageName(this.packageName);
        } catch (Exception unused) {
            return null;
        }
    }

    private final String findProcessName() {
        Object objM442constructorimpl;
        String processName;
        try {
            Result.Companion companion = Result.INSTANCE;
            AppDataCollector appDataCollector = this;
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
            } else {
                Object objInvoke = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                processName = (String) objInvoke;
            }
            objM442constructorimpl = Result.m442constructorimpl(processName);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m448isFailureimpl(objM442constructorimpl) ? null : objM442constructorimpl);
    }

    /* JADX INFO: compiled from: AppDataCollector.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bugsnag/android/AppDataCollector$Companion;", "", "()V", "IMPORTANCE_CANT_SAVE_STATE_PRE_26", "", "startTimeMs", "", "getStartTimeMs$bugsnag_android_core_release", "()J", "getDurationMs", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getStartTimeMs$bugsnag_android_core_release() {
            return AppDataCollector.startTimeMs;
        }

        public final long getDurationMs() {
            return SystemClock.elapsedRealtime() - getStartTimeMs$bugsnag_android_core_release();
        }
    }
}
