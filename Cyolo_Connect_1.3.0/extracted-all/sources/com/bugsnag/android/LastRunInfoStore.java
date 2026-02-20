package com.bugsnag.android;

import com.bugsnag.android.internal.ImmutableConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LastRunInfoStore.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bugsnag/android/LastRunInfoStore;", "", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "(Lcom/bugsnag/android/internal/ImmutableConfig;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "logger", "Lcom/bugsnag/android/Logger;", "load", "Lcom/bugsnag/android/LastRunInfo;", "loadImpl", "persist", "", "lastRunInfo", "persistImpl", "asBooleanValue", "", "", "key", "asIntValue", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LastRunInfoStore {
    private final File file;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Logger logger;

    public LastRunInfoStore(ImmutableConfig immutableConfig) {
        this.file = new File(immutableConfig.getPersistenceDirectory().getValue(), "bugsnag/last-run-info");
        this.logger = immutableConfig.getLogger();
    }

    public final File getFile() {
        return this.file;
    }

    public final void persist(LastRunInfo lastRunInfo) {
        ReentrantReadWriteLock.WriteLock writeLock = this.lock.writeLock();
        writeLock.lock();
        try {
            try {
                persistImpl(lastRunInfo);
            } catch (Throwable th) {
                this.logger.w("Unexpectedly failed to persist LastRunInfo.", th);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            writeLock.unlock();
        }
    }

    private final void persistImpl(LastRunInfo lastRunInfo) {
        KeyValueWriter keyValueWriter = new KeyValueWriter();
        keyValueWriter.add("consecutiveLaunchCrashes", Integer.valueOf(lastRunInfo.getConsecutiveLaunchCrashes()));
        keyValueWriter.add("crashed", Boolean.valueOf(lastRunInfo.getCrashed()));
        keyValueWriter.add("crashedDuringLaunch", Boolean.valueOf(lastRunInfo.getCrashedDuringLaunch()));
        String string = keyValueWriter.toString();
        File parentFile = this.file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FilesKt.writeText$default(this.file, string, null, 2, null);
        this.logger.d(kotlin.jvm.internal.Intrinsics.stringPlus("Persisted: ", string));
    }

    public final LastRunInfo load() {
        LastRunInfo lastRunInfoLoadImpl;
        ReentrantReadWriteLock.ReadLock lock = this.lock.readLock();
        lock.lock();
        try {
            lastRunInfoLoadImpl = loadImpl();
        } catch (Throwable th) {
            try {
                this.logger.w("Unexpectedly failed to load LastRunInfo.", th);
                lastRunInfoLoadImpl = null;
            } finally {
                lock.unlock();
            }
        }
        return lastRunInfoLoadImpl;
    }

    private final LastRunInfo loadImpl() {
        if (!this.file.exists()) {
            return null;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) FilesKt.readText$default(this.file, null, 1, null), new String[]{org.apache.commons.io.IOUtils.LINE_SEPARATOR_UNIX}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() != 3) {
            this.logger.w(kotlin.jvm.internal.Intrinsics.stringPlus("Unexpected number of lines when loading LastRunInfo. Skipping load. ", arrayList2));
            return null;
        }
        try {
            LastRunInfo lastRunInfo = new LastRunInfo(asIntValue((String) arrayList2.get(0), "consecutiveLaunchCrashes"), asBooleanValue((String) arrayList2.get(1), "crashed"), asBooleanValue((String) arrayList2.get(2), "crashedDuringLaunch"));
            this.logger.d(kotlin.jvm.internal.Intrinsics.stringPlus("Loaded: ", lastRunInfo));
            return lastRunInfo;
        } catch (NumberFormatException e) {
            this.logger.w("Failed to read consecutiveLaunchCrashes from saved lastRunInfo", e);
            return null;
        }
    }

    private final int asIntValue(String str, String str2) {
        return Integer.parseInt(StringsKt.substringAfter$default(str, kotlin.jvm.internal.Intrinsics.stringPlus(str2, "="), (String) null, 2, (Object) null));
    }

    private final boolean asBooleanValue(String str, String str2) {
        return Boolean.parseBoolean(StringsKt.substringAfter$default(str, kotlin.jvm.internal.Intrinsics.stringPlus(str2, "="), (String) null, 2, (Object) null));
    }
}
