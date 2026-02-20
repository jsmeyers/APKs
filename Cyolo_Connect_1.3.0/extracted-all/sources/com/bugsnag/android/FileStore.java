package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.dag.Provider;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: FileStore.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001:\u0002+,B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0019J\u0006\u0010\u001c\u001a\u00020\u0017J\u0018\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"J\u0012\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010\u0001H&J\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u0004\u0018\u00010\u001f2\u0006\u0010)\u001a\u00020*R \u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Lcom/bugsnag/android/FileStore;", "", "storageDir", "Ljava/io/File;", "maxStoreCount", "", "logger", "Lcom/bugsnag/android/Logger;", "delegate", "Lcom/bugsnag/android/internal/dag/Provider;", "Lcom/bugsnag/android/FileStore$Delegate;", "(Ljava/io/File;ILcom/bugsnag/android/Logger;Lcom/bugsnag/android/internal/dag/Provider;)V", "getDelegate", "()Lcom/bugsnag/android/internal/dag/Provider;", "lock", "Ljava/util/concurrent/locks/Lock;", "getLogger", "()Lcom/bugsnag/android/Logger;", "queuedFiles", "", "getStorageDir", "()Ljava/io/File;", "cancelQueuedFiles", "", "files", "", "deleteStoredFiles", "storedFiles", "discardOldestFileIfNeeded", "enqueueContentForDelivery", "content", "", "filename", "findStoredFiles", "", "getFilename", "obj", "isEmpty", "", "isStorageDirValid", "write", "streamable", "Lcom/bugsnag/android/JsonStream$Streamable;", "Delegate", "FileWithTimestamp", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class FileStore {
    private final Provider<? extends Delegate> delegate;
    private final Logger logger;
    private final int maxStoreCount;
    private final File storageDir;
    private final Lock lock = new ReentrantLock();
    private final Collection<File> queuedFiles = new ConcurrentSkipListSet();

    /* JADX INFO: compiled from: FileStore.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/bugsnag/android/FileStore$Delegate;", "", "onErrorIOFailure", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorFile", "Ljava/io/File;", "context", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Delegate {
        void onErrorIOFailure(Exception exception, File errorFile, String context);
    }

    public abstract String getFilename(Object obj);

    public FileStore(File file, int i, Logger logger, Provider<? extends Delegate> provider) {
        this.storageDir = file;
        this.maxStoreCount = i;
        this.logger = logger;
        this.delegate = provider;
    }

    public final File getStorageDir() {
        return this.storageDir;
    }

    protected Logger getLogger() {
        return this.logger;
    }

    protected final Provider<? extends Delegate> getDelegate() {
        return this.delegate;
    }

    private final boolean isStorageDirValid(File storageDir) {
        try {
            storageDir.mkdirs();
            return true;
        } catch (Exception e) {
            getLogger().e("Could not prepare file storage directory", e);
            return false;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:13:0x001d  */
    public final boolean isEmpty() {
        boolean z;
        if (!this.queuedFiles.isEmpty()) {
            return false;
        }
        String[] list = this.storageDir.list();
        if (list != null) {
            z = list.length == 0;
        }
        return z;
    }

    public final void enqueueContentForDelivery(String content, String filename) throws Throwable {
        Delegate orNull;
        BufferedWriter bufferedWriter;
        if (!isStorageDirValid(this.storageDir)) {
            return;
        }
        discardOldestFileIfNeeded();
        this.lock.lock();
        String absolutePath = new File(this.storageDir, filename).getAbsolutePath();
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(absolutePath), "UTF-8"));
            } catch (Exception e) {
                e = e;
            }
            this.lock.unlock();
            return;
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(content);
            try {
                bufferedWriter.close();
            } catch (Exception e2) {
                e = e2;
                getLogger().w(kotlin.jvm.internal.Intrinsics.stringPlus("Failed to close unsent payload writer: ", filename), e);
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            File file = new File(absolutePath);
            Provider<? extends Delegate> provider = this.delegate;
            if (provider != null && (orNull = provider.getOrNull()) != null) {
                orNull.onErrorIOFailure(e, file, "NDK Crash report copy");
            }
            IOUtils.deleteFile(file, getLogger());
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e4) {
                    e = e4;
                    getLogger().w(kotlin.jvm.internal.Intrinsics.stringPlus("Failed to close unsent payload writer: ", filename), e);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (Exception e5) {
                    getLogger().w(kotlin.jvm.internal.Intrinsics.stringPlus("Failed to close unsent payload writer: ", filename), e5);
                }
            }
            this.lock.unlock();
            throw th;
        }
    }

    public final String write(JsonStream.Streamable streamable) throws Throwable {
        JsonStream jsonStream;
        Delegate orNull;
        Lock lock = null;
        if (!isStorageDirValid(this.storageDir) || this.maxStoreCount == 0) {
            return null;
        }
        discardOldestFileIfNeeded();
        String absolutePath = new File(this.storageDir, getFilename(streamable)).getAbsolutePath();
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            try {
                jsonStream = new JsonStream(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(absolutePath), "UTF-8")));
                try {
                    jsonStream.value(streamable);
                    getLogger().i("Saved unsent payload to disk: '" + ((Object) absolutePath) + '\'');
                    IOUtils.closeQuietly(jsonStream);
                    this.lock.unlock();
                    return absolutePath;
                } catch (FileNotFoundException e) {
                    e = e;
                    getLogger().w("Ignoring FileNotFoundException - unable to create file", e);
                    IOUtils.closeQuietly(jsonStream);
                    this.lock.unlock();
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    File file = new File(absolutePath);
                    Provider<? extends Delegate> provider = this.delegate;
                    if (provider != null && (orNull = provider.getOrNull()) != null) {
                        orNull.onErrorIOFailure(e, file, "Crash report serialization");
                    }
                    IOUtils.deleteFile(file, getLogger());
                    IOUtils.closeQuietly(jsonStream);
                    this.lock.unlock();
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                lock = lock2;
                IOUtils.closeQuietly((Closeable) lock);
                this.lock.unlock();
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            jsonStream = null;
        } catch (Exception e4) {
            e = e4;
            jsonStream = null;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((Closeable) lock);
            this.lock.unlock();
            throw th;
        }
    }

    public final void discardOldestFileIfNeeded() {
        File[] fileArrListFiles;
        if (isStorageDirValid(this.storageDir) && (fileArrListFiles = this.storageDir.listFiles()) != null && fileArrListFiles.length >= this.maxStoreCount) {
            ArrayList arrayList = new ArrayList(fileArrListFiles.length);
            int length = fileArrListFiles.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                File file = fileArrListFiles[i2];
                i2++;
                arrayList.add(new FileWithTimestamp(file, file.lastModified()));
            }
            ArrayList arrayList2 = arrayList;
            CollectionsKt.sort(arrayList2);
            int length2 = (fileArrListFiles.length - this.maxStoreCount) + 1;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                File file2 = ((FileWithTimestamp) it.next()).getFile();
                if (i == length2) {
                    return;
                }
                if (!this.queuedFiles.contains(file2)) {
                    getLogger().w("Discarding oldest error as stored error limit reached: '" + ((Object) file2.getPath()) + '\'');
                    deleteStoredFiles(SetsKt.setOf(file2));
                    i++;
                }
            }
        }
    }

    public final List<File> findStoredFiles() {
        File[] fileArrListFiles;
        this.lock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            if (isStorageDirValid(this.storageDir) && (fileArrListFiles = this.storageDir.listFiles()) != null) {
                int length = fileArrListFiles.length;
                int i = 0;
                while (i < length) {
                    File file = fileArrListFiles[i];
                    i++;
                    if (file.length() == 0) {
                        if (!file.delete()) {
                            file.deleteOnExit();
                        }
                    } else if (file.isFile() && !this.queuedFiles.contains(file)) {
                        arrayList.add(file);
                    }
                }
            }
            this.queuedFiles.addAll(arrayList);
            return arrayList;
        } finally {
            this.lock.unlock();
        }
    }

    public final void cancelQueuedFiles(Collection<? extends File> files) {
        this.lock.lock();
        if (files != null) {
            try {
                this.queuedFiles.removeAll(files);
            } finally {
                this.lock.unlock();
            }
        }
    }

    public final void deleteStoredFiles(Collection<? extends File> storedFiles) {
        this.lock.lock();
        if (storedFiles != null) {
            try {
                this.queuedFiles.removeAll(storedFiles);
                for (File file : storedFiles) {
                    if (!file.delete()) {
                        file.deleteOnExit();
                    }
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
    }

    /* JADX INFO: compiled from: FileStore.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bugsnag/android/FileStore$FileWithTimestamp;", "", "file", "Ljava/io/File;", "timestamp", "", "(Ljava/io/File;J)V", "getFile", "()Ljava/io/File;", "getTimestamp", "()J", "compareTo", "", "other", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final /* data */ class FileWithTimestamp implements Comparable<FileWithTimestamp> {
        private final File file;
        private final long timestamp;

        public static /* synthetic */ FileWithTimestamp copy$default(FileWithTimestamp fileWithTimestamp, File file, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                file = fileWithTimestamp.file;
            }
            if ((i & 2) != 0) {
                j = fileWithTimestamp.timestamp;
            }
            return fileWithTimestamp.copy(file, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final File getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final FileWithTimestamp copy(File file, long timestamp) {
            return new FileWithTimestamp(file, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileWithTimestamp)) {
                return false;
            }
            FileWithTimestamp fileWithTimestamp = (FileWithTimestamp) other;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.file, fileWithTimestamp.file) && this.timestamp == fileWithTimestamp.timestamp;
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestamp);
        }

        public String toString() {
            return "FileWithTimestamp(file=" + this.file + ", timestamp=" + this.timestamp + ')';
        }

        public FileWithTimestamp(File file, long j) {
            this.file = file;
            this.timestamp = j;
        }

        public final File getFile() {
            return this.file;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // java.lang.Comparable
        public int compareTo(FileWithTimestamp other) {
            return kotlin.jvm.internal.Intrinsics.compare(this.timestamp, other.timestamp);
        }
    }
}
