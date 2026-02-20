package com.bugsnag.android;

import android.util.JsonReader;
import com.bugsnag.android.DeviceId;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.UUID;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: DeviceIdFilePersistence.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bugsnag/android/DeviceIdFilePersistence;", "Lcom/bugsnag/android/DeviceIdPersistence;", "file", "Ljava/io/File;", "deviceIdGenerator", "Lkotlin/Function0;", "Ljava/util/UUID;", "logger", "Lcom/bugsnag/android/Logger;", "(Ljava/io/File;Lkotlin/jvm/functions/Function0;Lcom/bugsnag/android/Logger;)V", "synchronizedStreamableStore", "Lcom/bugsnag/android/SynchronizedStreamableStore;", "Lcom/bugsnag/android/DeviceId;", "loadDeviceId", "", "requestCreateIfDoesNotExist", "", "loadDeviceIdInternal", "persistNewDeviceIdWithLock", "channel", "Ljava/nio/channels/FileChannel;", "uuid", "persistNewDeviceUuid", "waitForFileLock", "Ljava/nio/channels/FileLock;", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceIdFilePersistence implements DeviceIdPersistence {
    private static final long FILE_LOCK_WAIT_MS = 25;
    private static final int MAX_FILE_LOCK_ATTEMPTS = 20;
    private final Function0<UUID> deviceIdGenerator;
    private final File file;
    private final Logger logger;
    private final SynchronizedStreamableStore<DeviceId> synchronizedStreamableStore;

    public DeviceIdFilePersistence(File file, Function0<UUID> function0, Logger logger) {
        this.file = file;
        this.deviceIdGenerator = function0;
        this.logger = logger;
        try {
            file.createNewFile();
        } catch (Throwable th) {
            this.logger.w("Failed to created device ID file", th);
        }
        this.synchronizedStreamableStore = new SynchronizedStreamableStore<>(this.file);
    }

    @Override // com.bugsnag.android.DeviceIdPersistence
    public String loadDeviceId(boolean requestCreateIfDoesNotExist) {
        try {
            DeviceId deviceIdLoadDeviceIdInternal = loadDeviceIdInternal();
            if ((deviceIdLoadDeviceIdInternal == null ? null : deviceIdLoadDeviceIdInternal.getId()) != null) {
                return deviceIdLoadDeviceIdInternal.getId();
            }
            if (requestCreateIfDoesNotExist) {
                return persistNewDeviceUuid(this.deviceIdGenerator.invoke());
            }
            return null;
        } catch (Throwable th) {
            this.logger.w("Failed to load device ID", th);
            return null;
        }
    }

    private final DeviceId loadDeviceIdInternal() {
        if (this.file.length() <= 0) {
            return null;
        }
        try {
            return (DeviceId) this.synchronizedStreamableStore.load(new AnonymousClass1(DeviceId.INSTANCE));
        } catch (Throwable th) {
            this.logger.w("Failed to load device ID", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bugsnag.android.DeviceIdFilePersistence$loadDeviceIdInternal$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeviceIdFilePersistence.kt */
    @kotlin.Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<JsonReader, DeviceId> {
        AnonymousClass1(Object obj) {
            super(1, obj, DeviceId.Companion.class, "fromReader", "fromReader(Landroid/util/JsonReader;)Lcom/bugsnag/android/DeviceId;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DeviceId invoke(JsonReader jsonReader) {
            return ((DeviceId.Companion) this.receiver).fromReader(jsonReader);
        }
    }

    private final String persistNewDeviceUuid(UUID uuid) {
        try {
            FileChannel channel = new FileOutputStream(this.file).getChannel();
            try {
                String strPersistNewDeviceIdWithLock = persistNewDeviceIdWithLock(channel, uuid);
                CloseableKt.closeFinally(channel, null);
                return strPersistNewDeviceIdWithLock;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(channel, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            this.logger.w("Failed to persist device ID", e);
            return null;
        }
    }

    private final String persistNewDeviceIdWithLock(FileChannel channel, UUID uuid) throws InterruptedException, IOException {
        String id;
        FileLock fileLockWaitForFileLock = waitForFileLock(channel);
        String id2 = null;
        if (fileLockWaitForFileLock == null) {
            return null;
        }
        try {
            DeviceId deviceIdLoadDeviceIdInternal = loadDeviceIdInternal();
            if (deviceIdLoadDeviceIdInternal != null) {
                id2 = deviceIdLoadDeviceIdInternal.getId();
            }
            if (id2 != null) {
                id = deviceIdLoadDeviceIdInternal.getId();
            } else {
                DeviceId deviceId = new DeviceId(uuid.toString());
                this.synchronizedStreamableStore.persist(deviceId);
                id = deviceId.getId();
            }
            return id;
        } finally {
            fileLockWaitForFileLock.release();
        }
    }

    private final FileLock waitForFileLock(FileChannel channel) throws InterruptedException {
        int i = 0;
        while (i < 20) {
            i++;
            try {
                return channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                java.lang.Thread.sleep(FILE_LOCK_WAIT_MS);
            }
        }
        return null;
    }
}
