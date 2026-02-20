package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.bugsnag.android.DeviceIdStore;
import com.bugsnag.android.internal.BackgroundTaskService;
import com.bugsnag.android.internal.TaskType;
import com.bugsnag.android.internal.dag.Provider;
import io.cyolo.android.MainActivityKt;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceDataCollector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u0018J\b\u00101\u001a\u00020,H\u0007J\r\u00102\u001a\u0004\u0018\u00010,¢\u0006\u0002\u00103J\u000f\u00104\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0002\u00103J\b\u00105\u001a\u00020\u0010H\u0002J\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020,J\u000e\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020,J\u000e\u0010=\u001a\u0002092\u0006\u0010:\u001a\u00020,J\u0011\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\u0010?J\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010AJ\n\u0010B\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010C\u001a\u00020\u0018H\u0002J\u000f\u0010D\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\bEJ\u000f\u0010F\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0002\u0010GJ\u000f\u0010H\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010IJ\n\u0010J\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010K\u001a\u00020\u0010H\u0002J\b\u0010L\u001a\u00020\u0010H\u0002J\u001e\u0010M\u001a\u00020.2\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010%H\u0002J\u0012\u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010+H\u0002J\u0015\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u001eH\u0000¢\u0006\u0002\bRR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/bugsnag/android/DeviceDataCollector;", "", "connectivity", "Lcom/bugsnag/android/Connectivity;", "appContext", "Landroid/content/Context;", "resources", "Landroid/content/res/Resources;", "deviceIdStore", "Lcom/bugsnag/android/internal/dag/Provider;", "Lcom/bugsnag/android/DeviceIdStore$DeviceIds;", "buildInfo", "Lcom/bugsnag/android/DeviceBuildInfo;", "dataDirectory", "Ljava/io/File;", "rootedFuture", "", "bgTaskService", "Lcom/bugsnag/android/internal/BackgroundTaskService;", "logger", "Lcom/bugsnag/android/Logger;", "(Lcom/bugsnag/android/Connectivity;Landroid/content/Context;Landroid/content/res/Resources;Lcom/bugsnag/android/internal/dag/Provider;Lcom/bugsnag/android/DeviceBuildInfo;Ljava/io/File;Lcom/bugsnag/android/internal/dag/Provider;Lcom/bugsnag/android/internal/BackgroundTaskService;Lcom/bugsnag/android/Logger;)V", "cpuAbi", "", "", "[Ljava/lang/String;", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "dpi", "", "Ljava/lang/Integer;", "emulator", "locale", "orientation", "Ljava/util/concurrent/atomic/AtomicInteger;", "runtimeVersions", "", "screenDensity", "", "Ljava/lang/Float;", "screenResolution", "totalMemoryFuture", "Ljava/util/concurrent/Future;", "", "addRuntimeVersionInfo", "", "key", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "calculateFreeDisk", "calculateFreeMemory", "()Ljava/lang/Long;", "calculateTotalMemory", "checkIsRooted", "generateDevice", "Lcom/bugsnag/android/Device;", "generateDeviceWithState", "Lcom/bugsnag/android/DeviceWithState;", "now", "generateHistoricDeviceWithState", "timeStamp", "generateInternalDeviceWithState", "getCpuAbi", "()[Ljava/lang/String;", "getDeviceMetadata", "", "getLocationStatus", "getNetworkAccess", "getOrientationAsString", "getOrientationAsString$bugsnag_android_core_release", "getScreenDensity", "()Ljava/lang/Float;", "getScreenDensityDpi", "()Ljava/lang/Integer;", "getScreenResolution", "isEmulator", "isLocationEnabled", "populateBatteryInfo", "into", "retrieveTotalDeviceMemory", "updateOrientation", "newOrientation", "updateOrientation$bugsnag_android_core_release", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceDataCollector {
    private final Context appContext;
    private final BackgroundTaskService bgTaskService;
    private final DeviceBuildInfo buildInfo;
    private final Connectivity connectivity;
    private final File dataDirectory;
    private final Provider<DeviceIdStore.DeviceIds> deviceIdStore;
    private final DisplayMetrics displayMetrics;
    private final Logger logger;
    private AtomicInteger orientation;
    private final Provider<Boolean> rootedFuture;
    private Map<String, Object> runtimeVersions;
    private final boolean emulator = isEmulator();
    private final Float screenDensity = getScreenDensity();
    private final Integer dpi = getScreenDensityDpi();
    private final String screenResolution = getScreenResolution();
    private final String locale = Locale.getDefault().toString();
    private final String[] cpuAbi = getCpuAbi();
    private final Future<Long> totalMemoryFuture = retrieveTotalDeviceMemory();

    public DeviceDataCollector(Connectivity connectivity, Context context, Resources resources, Provider<DeviceIdStore.DeviceIds> provider, DeviceBuildInfo deviceBuildInfo, File file, Provider<Boolean> provider2, BackgroundTaskService backgroundTaskService, Logger logger) {
        this.connectivity = connectivity;
        this.appContext = context;
        this.deviceIdStore = provider;
        this.buildInfo = deviceBuildInfo;
        this.dataDirectory = file;
        this.rootedFuture = provider2;
        this.bgTaskService = backgroundTaskService;
        this.logger = logger;
        this.displayMetrics = resources.getDisplayMetrics();
        this.orientation = new AtomicInteger(resources.getConfiguration().orientation);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer apiLevel = deviceBuildInfo.getApiLevel();
        if (apiLevel != null) {
            linkedHashMap.put("androidApiLevel", Integer.valueOf(apiLevel.intValue()));
        }
        String osBuild = deviceBuildInfo.getOsBuild();
        if (osBuild != null) {
            linkedHashMap.put("osBuild", osBuild);
        }
        this.runtimeVersions = linkedHashMap;
    }

    public final Device generateDevice() {
        Object objM442constructorimpl;
        DeviceBuildInfo deviceBuildInfo = this.buildInfo;
        String[] strArr = this.cpuAbi;
        Boolean boolValueOf = Boolean.valueOf(checkIsRooted());
        DeviceIdStore.DeviceIds deviceIds = this.deviceIdStore.get();
        String deviceId = deviceIds == null ? null : deviceIds.getDeviceId();
        String str = this.locale;
        Future<Long> future = this.totalMemoryFuture;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(future == null ? null : future.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        return new Device(deviceBuildInfo, strArr, boolValueOf, deviceId, str, (Long) (Result.m448isFailureimpl(objM442constructorimpl) ? null : objM442constructorimpl), MapsKt.toMutableMap(this.runtimeVersions));
    }

    public final DeviceWithState generateDeviceWithState(long now) {
        Object objM442constructorimpl;
        DeviceBuildInfo deviceBuildInfo = this.buildInfo;
        Boolean boolValueOf = Boolean.valueOf(checkIsRooted());
        DeviceIdStore.DeviceIds deviceIds = this.deviceIdStore.get();
        String deviceId = deviceIds == null ? null : deviceIds.getDeviceId();
        String str = this.locale;
        Future<Long> future = this.totalMemoryFuture;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(future == null ? null : future.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        return new DeviceWithState(deviceBuildInfo, boolValueOf, deviceId, str, (Long) (Result.m448isFailureimpl(objM442constructorimpl) ? null : objM442constructorimpl), MapsKt.toMutableMap(this.runtimeVersions), Long.valueOf(calculateFreeDisk()), calculateFreeMemory(), getOrientationAsString$bugsnag_android_core_release(), new Date(now));
    }

    public final DeviceWithState generateInternalDeviceWithState(long now) {
        Object objM442constructorimpl;
        DeviceBuildInfo deviceBuildInfo = this.buildInfo;
        Boolean boolValueOf = Boolean.valueOf(checkIsRooted());
        DeviceIdStore.DeviceIds deviceIds = this.deviceIdStore.get();
        String internalDeviceId = deviceIds == null ? null : deviceIds.getInternalDeviceId();
        String str = this.locale;
        Future<Long> future = this.totalMemoryFuture;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(future == null ? null : future.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        return new DeviceWithState(deviceBuildInfo, boolValueOf, internalDeviceId, str, (Long) (Result.m448isFailureimpl(objM442constructorimpl) ? null : objM442constructorimpl), MapsKt.toMutableMap(this.runtimeVersions), Long.valueOf(calculateFreeDisk()), calculateFreeMemory(), getOrientationAsString$bugsnag_android_core_release(), new Date(now));
    }

    public final DeviceWithState generateHistoricDeviceWithState(long timeStamp) {
        DeviceBuildInfo deviceBuildInfo = this.buildInfo;
        Boolean boolValueOf = Boolean.valueOf(checkIsRooted());
        DeviceIdStore.DeviceIds deviceIds = this.deviceIdStore.get();
        return new DeviceWithState(deviceBuildInfo, boolValueOf, deviceIds == null ? null : deviceIds.getDeviceId(), this.locale, null, MapsKt.toMutableMap(this.runtimeVersions), null, null, getOrientationAsString$bugsnag_android_core_release(), new Date(timeStamp));
    }

    public final Map<String, Object> getDeviceMetadata() {
        HashMap map = new HashMap();
        populateBatteryInfo(map);
        map.put("locationStatus", getLocationStatus());
        map.put("networkAccess", getNetworkAccess());
        map.put("brand", this.buildInfo.getBrand());
        map.put("screenDensity", this.screenDensity);
        map.put("dpi", this.dpi);
        map.put("emulator", Boolean.valueOf(this.emulator));
        map.put("screenResolution", this.screenResolution);
        return map;
    }

    private final boolean checkIsRooted() {
        try {
            Provider<Boolean> provider = this.rootedFuture;
            return provider != null && provider.get().booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean isEmulator() {
        String fingerprint = this.buildInfo.getFingerprint();
        if (fingerprint == null) {
            return false;
        }
        if (!StringsKt.startsWith$default(fingerprint, EnvironmentCompat.MEDIA_UNKNOWN, false, 2, (Object) null)) {
            String str = fingerprint;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "generic", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "vbox", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    private final Integer getScreenDensityDpi() {
        DisplayMetrics displayMetrics = this.displayMetrics;
        if (displayMetrics == null) {
            return null;
        }
        return Integer.valueOf(displayMetrics.densityDpi);
    }

    private final void populateBatteryInfo(Map<String, Object> into) {
        try {
            Intent intentRegisterReceiverSafe = ContextExtensionsKt.registerReceiverSafe(this.appContext, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), this.logger);
            if (intentRegisterReceiverSafe != null) {
                int intExtra = intentRegisterReceiverSafe.getIntExtra("level", -1);
                int intExtra2 = intentRegisterReceiverSafe.getIntExtra("scale", -1);
                if (intExtra != -1 || intExtra2 != -1) {
                    into.put("batteryLevel", Float.valueOf(intExtra / intExtra2));
                }
                int intExtra3 = intentRegisterReceiverSafe.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                into.put("charging", Boolean.valueOf(intExtra3 == 2 || intExtra3 == 5));
            }
        } catch (Exception unused) {
            this.logger.w("Could not get battery status");
        }
    }

    private final String getLocationStatus() {
        try {
            return isLocationEnabled() ? "allowed" : "disallowed";
        } catch (Exception unused) {
            this.logger.w("Could not get locationStatus");
            return null;
        }
    }

    private final boolean isLocationEnabled() {
        if (Build.VERSION.SDK_INT >= 31) {
            LocationManager locationManager = ContextExtensionsKt.getLocationManager(this.appContext);
            if (locationManager != null && locationManager.isLocationEnabled()) {
                return true;
            }
        } else {
            String string = Settings.Secure.getString(this.appContext.getContentResolver(), "location_providers_allowed");
            if (string != null) {
                if (string.length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String getNetworkAccess() {
        return this.connectivity.retrieveNetworkAccessState();
    }

    private final Float getScreenDensity() {
        DisplayMetrics displayMetrics = this.displayMetrics;
        if (displayMetrics == null) {
            return null;
        }
        return Float.valueOf(displayMetrics.density);
    }

    private final String getScreenResolution() {
        DisplayMetrics displayMetrics = this.displayMetrics;
        if (displayMetrics != null) {
            int iMax = Math.max(displayMetrics.widthPixels, this.displayMetrics.heightPixels);
            int iMin = Math.min(this.displayMetrics.widthPixels, this.displayMetrics.heightPixels);
            StringBuilder sb = new StringBuilder();
            sb.append(iMax);
            sb.append('x');
            sb.append(iMin);
            return sb.toString();
        }
        return null;
    }

    public final String[] getCpuAbi() {
        String[] cpuAbis = this.buildInfo.getCpuAbis();
        return cpuAbis == null ? new String[0] : cpuAbis;
    }

    public final long calculateFreeDisk() {
        Object objM442constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            DeviceDataCollector deviceDataCollector = this;
            objM442constructorimpl = Result.m442constructorimpl((Long) this.bgTaskService.submitTask(TaskType.IO, new Callable() { // from class: com.bugsnag.android.DeviceDataCollector$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return DeviceDataCollector.m227calculateFreeDisk$lambda6$lambda5(this.f$0);
                }
            }).get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m448isFailureimpl(objM442constructorimpl)) {
            objM442constructorimpl = 0L;
        }
        return ((Number) objM442constructorimpl).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateFreeDisk$lambda-6$lambda-5, reason: not valid java name */
    public static final Long m227calculateFreeDisk$lambda6$lambda5(DeviceDataCollector deviceDataCollector) {
        return Long.valueOf(deviceDataCollector.dataDirectory.getUsableSpace());
    }

    public final Long calculateFreeMemory() {
        Long lValueOf;
        try {
            ActivityManager activityManagerFrom = ContextExtensionsKt.getActivityManagerFrom(this.appContext);
            if (activityManagerFrom == null) {
                lValueOf = null;
            } else {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManagerFrom.getMemoryInfo(memoryInfo);
                lValueOf = Long.valueOf(memoryInfo.availMem);
            }
            if (lValueOf != null) {
                return lValueOf;
            }
            try {
                return (Long) Process.class.getDeclaredMethod("getFreeMemory", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private final Future<Long> retrieveTotalDeviceMemory() {
        try {
            return this.bgTaskService.submitTask(TaskType.DEFAULT, new Callable() { // from class: com.bugsnag.android.DeviceDataCollector$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.calculateTotalMemory();
                }
            });
        } catch (RejectedExecutionException e) {
            this.logger.w("Failed to lookup available device memory", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long calculateTotalMemory() {
        Long lValueOf;
        Object objM442constructorimpl;
        ActivityManager activityManagerFrom = ContextExtensionsKt.getActivityManagerFrom(this.appContext);
        if (activityManagerFrom == null) {
            lValueOf = null;
        } else {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManagerFrom.getMemoryInfo(memoryInfo);
            lValueOf = Long.valueOf(memoryInfo.totalMem);
        }
        if (lValueOf != null) {
            return lValueOf;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DeviceDataCollector deviceDataCollector = this;
            objM442constructorimpl = Result.m442constructorimpl((Long) Process.class.getDeclaredMethod("getTotalMemory", new Class[0]).invoke(null, new Object[0]));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM442constructorimpl = Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        return (Long) (Result.m448isFailureimpl(objM442constructorimpl) ? null : objM442constructorimpl);
    }

    public final String getOrientationAsString$bugsnag_android_core_release() {
        int i = this.orientation.get();
        if (i == 1) {
            return "portrait";
        }
        if (i != 2) {
            return null;
        }
        return "landscape";
    }

    public final boolean updateOrientation$bugsnag_android_core_release(int newOrientation) {
        return this.orientation.getAndSet(newOrientation) != newOrientation;
    }

    public final void addRuntimeVersionInfo(String key, String value) {
        Map<String, Object> mutableMap = MapsKt.toMutableMap(this.runtimeVersions);
        mutableMap.put(key, value);
        this.runtimeVersions = mutableMap;
    }
}
