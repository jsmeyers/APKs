package com.bugsnag.android;

import android.content.Context;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.dag.Provider;
import io.cyolo.android.MethodNames;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DeviceIdStore.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001eBa\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bugsnag/android/DeviceIdStore;", "", "context", "Landroid/content/Context;", "deviceIdFile", "Ljava/io/File;", "deviceIdGenerator", "Lkotlin/Function0;", "Ljava/util/UUID;", "internalDeviceIdFile", "internalDeviceIdGenerator", "sharedPrefMigrator", "Lcom/bugsnag/android/internal/dag/Provider;", "Lcom/bugsnag/android/SharedPrefMigrator;", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "logger", "Lcom/bugsnag/android/Logger;", "(Landroid/content/Context;Ljava/io/File;Lkotlin/jvm/functions/Function0;Ljava/io/File;Lkotlin/jvm/functions/Function0;Lcom/bugsnag/android/internal/dag/Provider;Lcom/bugsnag/android/internal/ImmutableConfig;Lcom/bugsnag/android/Logger;)V", "deviceIds", "Lcom/bugsnag/android/DeviceIdStore$DeviceIds;", "generateId", "", "internalPersistence", "Lcom/bugsnag/android/DeviceIdPersistence;", "persistence", "load", "loadDeviceId", "", "loadInternalDeviceId", "DeviceIds", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceIdStore {
    private final File deviceIdFile;
    private final Function0<UUID> deviceIdGenerator;
    private DeviceIds deviceIds;
    private final boolean generateId;
    private final File internalDeviceIdFile;
    private final Function0<UUID> internalDeviceIdGenerator;
    private DeviceIdPersistence internalPersistence;
    private final Logger logger;
    private DeviceIdPersistence persistence;
    private final Provider<SharedPrefMigrator> sharedPrefMigrator;

    public DeviceIdStore(Context context, Provider<SharedPrefMigrator> provider, ImmutableConfig immutableConfig, Logger logger) {
        this(context, null, null, null, null, provider, immutableConfig, logger, 30, null);
    }

    public DeviceIdStore(Context context, File file, Provider<SharedPrefMigrator> provider, ImmutableConfig immutableConfig, Logger logger) {
        this(context, file, null, null, null, provider, immutableConfig, logger, 28, null);
    }

    public DeviceIdStore(Context context, File file, Function0<UUID> function0, Provider<SharedPrefMigrator> provider, ImmutableConfig immutableConfig, Logger logger) {
        this(context, file, function0, null, null, provider, immutableConfig, logger, 24, null);
    }

    public DeviceIdStore(Context context, File file, Function0<UUID> function0, File file2, Provider<SharedPrefMigrator> provider, ImmutableConfig immutableConfig, Logger logger) {
        this(context, file, function0, file2, null, provider, immutableConfig, logger, 16, null);
    }

    public DeviceIdStore(Context context, File file, Function0<UUID> function0, File file2, Function0<UUID> function02, Provider<SharedPrefMigrator> provider, ImmutableConfig immutableConfig, Logger logger) {
        this.deviceIdFile = file;
        this.deviceIdGenerator = function0;
        this.internalDeviceIdFile = file2;
        this.internalDeviceIdGenerator = function02;
        this.sharedPrefMigrator = provider;
        this.logger = logger;
        this.generateId = immutableConfig.getGenerateAnonymousId();
    }

    public /* synthetic */ DeviceIdStore(Context context, File file, Function0 function0, File file2, Function0 function02, Provider provider, ImmutableConfig immutableConfig, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new File(context.getFilesDir(), "device-id") : file, (i & 4) != 0 ? new Function0<UUID>() { // from class: com.bugsnag.android.DeviceIdStore.1
            @Override // kotlin.jvm.functions.Function0
            public final UUID invoke() {
                return UUID.randomUUID();
            }
        } : function0, (i & 8) != 0 ? new File(context.getFilesDir(), "internal-device-id") : file2, (i & 16) != 0 ? new Function0<UUID>() { // from class: com.bugsnag.android.DeviceIdStore.2
            @Override // kotlin.jvm.functions.Function0
            public final UUID invoke() {
                return UUID.randomUUID();
            }
        } : function02, provider, immutableConfig, logger);
    }

    private final String loadDeviceId() {
        DeviceIdPersistence deviceIdPersistence = null;
        if (!this.generateId) {
            return null;
        }
        DeviceIdPersistence deviceIdPersistence2 = this.persistence;
        if (deviceIdPersistence2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("persistence");
            deviceIdPersistence2 = null;
        }
        String strLoadDeviceId = deviceIdPersistence2.loadDeviceId(false);
        if (strLoadDeviceId != null) {
            return strLoadDeviceId;
        }
        String strLoadDeviceId2 = this.sharedPrefMigrator.get().loadDeviceId(false);
        if (strLoadDeviceId2 != null) {
            return strLoadDeviceId2;
        }
        DeviceIdPersistence deviceIdPersistence3 = this.persistence;
        if (deviceIdPersistence3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("persistence");
        } else {
            deviceIdPersistence = deviceIdPersistence3;
        }
        return deviceIdPersistence.loadDeviceId(true);
    }

    private final String loadInternalDeviceId() {
        DeviceIdPersistence deviceIdPersistence = null;
        if (!this.generateId) {
            return null;
        }
        DeviceIdPersistence deviceIdPersistence2 = this.internalPersistence;
        if (deviceIdPersistence2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("internalPersistence");
        } else {
            deviceIdPersistence = deviceIdPersistence2;
        }
        return deviceIdPersistence.loadDeviceId(true);
    }

    public final DeviceIds load() {
        DeviceIds deviceIds = this.deviceIds;
        if (deviceIds != null) {
            return deviceIds;
        }
        this.persistence = new DeviceIdFilePersistence(this.deviceIdFile, this.deviceIdGenerator, this.logger);
        this.internalPersistence = new DeviceIdFilePersistence(this.internalDeviceIdFile, this.internalDeviceIdGenerator, this.logger);
        String strLoadDeviceId = loadDeviceId();
        String strLoadInternalDeviceId = loadInternalDeviceId();
        if (strLoadDeviceId != null || strLoadInternalDeviceId != null) {
            this.deviceIds = new DeviceIds(strLoadDeviceId, strLoadInternalDeviceId);
        }
        return this.deviceIds;
    }

    /* JADX INFO: compiled from: DeviceIdStore.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bugsnag/android/DeviceIdStore$DeviceIds;", "", "deviceId", "", "internalDeviceId", "(Ljava/lang/String;Ljava/lang/String;)V", MethodNames.getDeviceId, "()Ljava/lang/String;", "getInternalDeviceId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class DeviceIds {
        private final String deviceId;
        private final String internalDeviceId;

        public static /* synthetic */ DeviceIds copy$default(DeviceIds deviceIds, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deviceIds.deviceId;
            }
            if ((i & 2) != 0) {
                str2 = deviceIds.internalDeviceId;
            }
            return deviceIds.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getInternalDeviceId() {
            return this.internalDeviceId;
        }

        public final DeviceIds copy(String deviceId, String internalDeviceId) {
            return new DeviceIds(deviceId, internalDeviceId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeviceIds)) {
                return false;
            }
            DeviceIds deviceIds = (DeviceIds) other;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.deviceId, deviceIds.deviceId) && kotlin.jvm.internal.Intrinsics.areEqual(this.internalDeviceId, deviceIds.internalDeviceId);
        }

        public int hashCode() {
            String str = this.deviceId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.internalDeviceId;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "DeviceIds(deviceId=" + ((Object) this.deviceId) + ", internalDeviceId=" + ((Object) this.internalDeviceId) + ')';
        }

        public DeviceIds(String str, String str2) {
            this.deviceId = str;
            this.internalDeviceId = str2;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getInternalDeviceId() {
            return this.internalDeviceId;
        }
    }
}
