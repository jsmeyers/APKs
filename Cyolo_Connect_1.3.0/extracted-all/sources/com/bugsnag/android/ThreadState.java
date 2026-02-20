package com.bugsnag.android;

import android.os.SystemClock;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.Thread;
import com.bugsnag.android.internal.ImmutableConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ThreadState.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B!\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\u0010\u0018J\\\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/bugsnag/android/ThreadState;", "Lcom/bugsnag/android/JsonStream$Streamable;", "exc", "", "isUnhandled", "", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "(Ljava/lang/Throwable;ZLcom/bugsnag/android/internal/ImmutableConfig;)V", "maxThreads", "", "threadCollectionTimeLimitMillis", "", "sendThreads", "Lcom/bugsnag/android/ThreadSendPolicy;", "projectPackages", "", "", "logger", "Lcom/bugsnag/android/Logger;", "currentThread", "Ljava/lang/Thread;", "allThreads", "", "(Ljava/lang/Throwable;ZIJLcom/bugsnag/android/ThreadSendPolicy;Ljava/util/Collection;Lcom/bugsnag/android/Logger;Ljava/lang/Thread;Ljava/util/List;)V", "threads", "", "Lcom/bugsnag/android/Thread;", "getThreads", "()Ljava/util/List;", "captureThreadTrace", "maxThreadCount", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ThreadState implements JsonStream.Streamable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Thread> threads;

    public ThreadState(Throwable th, boolean z, int i, long j, ThreadSendPolicy threadSendPolicy, Collection<String> collection, Logger logger, java.lang.Thread thread, List<? extends java.lang.Thread> list) {
        ArrayList arrayList;
        if (threadSendPolicy == ThreadSendPolicy.ALWAYS || (threadSendPolicy == ThreadSendPolicy.UNHANDLED_ONLY && z)) {
            arrayList = captureThreadTrace(list, thread, th, z, i, j, collection, logger);
        } else {
            arrayList = new ArrayList();
        }
        this.threads = arrayList;
    }

    public /* synthetic */ ThreadState(Throwable th, boolean z, int i, long j, ThreadSendPolicy threadSendPolicy, Collection collection, Logger logger, java.lang.Thread thread, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, z, i, j, threadSendPolicy, collection, logger, (i2 & 128) != 0 ? java.lang.Thread.currentThread() : thread, (i2 & 256) != 0 ? INSTANCE.allThreads$bugsnag_android_core_release() : list);
    }

    public ThreadState(Throwable th, boolean z, ImmutableConfig immutableConfig) {
        this(th, z, immutableConfig.getMaxReportedThreads(), immutableConfig.getThreadCollectionTimeLimitMillis(), immutableConfig.getSendThreads(), immutableConfig.getProjectPackages(), immutableConfig.getLogger(), null, null, 384, null);
    }

    public final List<Thread> getThreads() {
        return this.threads;
    }

    /* JADX INFO: compiled from: ThreadState.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0002\b\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lcom/bugsnag/android/ThreadState$Companion;", "", "()V", "allThreads", "", "Ljava/lang/Thread;", "allThreads$bugsnag_android_core_release", "rootThreadGroup", "Ljava/lang/ThreadGroup;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final ThreadGroup rootThreadGroup() {
            ThreadGroup threadGroup = java.lang.Thread.currentThread().getThreadGroup();
            kotlin.jvm.internal.Intrinsics.checkNotNull(threadGroup);
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            return threadGroup;
        }

        public final List<java.lang.Thread> allThreads$bugsnag_android_core_release() {
            ThreadGroup threadGroupRootThreadGroup = rootThreadGroup();
            java.lang.Thread[] threadArr = new java.lang.Thread[threadGroupRootThreadGroup.activeCount()];
            threadGroupRootThreadGroup.enumerate(threadArr);
            return ArraysKt.filterNotNull(threadArr);
        }
    }

    private static final Thread captureThreadTrace$toBugsnagThread(java.lang.Thread thread, Throwable th, boolean z, Collection<String> collection, Logger logger, java.lang.Thread thread2) {
        StackTraceElement[] stackTrace;
        boolean z2 = thread2.getId() == thread.getId();
        if (!z2) {
            stackTrace = thread2.getStackTrace();
        } else if (th != null && z) {
            stackTrace = th.getStackTrace();
        } else {
            stackTrace = thread.getStackTrace();
        }
        return new Thread(String.valueOf(thread2.getId()), thread2.getName(), ErrorType.ANDROID, z2, Thread.State.forThread(thread2), new Stacktrace(stackTrace, collection, logger), logger);
    }

    private final List<Thread> captureThreadTrace(List<? extends java.lang.Thread> allThreads, final java.lang.Thread currentThread, Throwable exc, boolean isUnhandled, int maxThreadCount, long threadCollectionTimeLimitMillis, Collection<String> projectPackages, Logger logger) {
        List listSortedWith = CollectionsKt.sortedWith(allThreads, new Comparator() { // from class: com.bugsnag.android.ThreadState$captureThreadTrace$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((java.lang.Thread) t).getId()), Long.valueOf(((java.lang.Thread) t2).getId()));
            }
        });
        int iBinarySearch = CollectionsKt.binarySearch(listSortedWith, 0, Math.min(maxThreadCount, listSortedWith.size()), new Function1<java.lang.Thread, Integer>() { // from class: com.bugsnag.android.ThreadState$captureThreadTrace$currentThreadIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(java.lang.Thread thread) {
                return Integer.valueOf(kotlin.jvm.internal.Intrinsics.compare(thread.getId(), currentThread.getId()));
            }
        });
        List<java.lang.Thread> listTake = CollectionsKt.take(listSortedWith, iBinarySearch >= 0 ? maxThreadCount : Math.max(maxThreadCount - 1, 0));
        ArrayList arrayList = new ArrayList(maxThreadCount);
        long jElapsedRealtime = SystemClock.elapsedRealtime() + threadCollectionTimeLimitMillis;
        for (java.lang.Thread thread : listTake) {
            if (SystemClock.elapsedRealtime() >= jElapsedRealtime) {
                break;
            }
            arrayList.add(captureThreadTrace$toBugsnagThread(currentThread, exc, isUnhandled, projectPackages, logger, thread));
        }
        if (iBinarySearch < 0) {
            int i = (-iBinarySearch) - 1;
            if (i >= arrayList.size()) {
                arrayList.add(captureThreadTrace$toBugsnagThread(currentThread, exc, isUnhandled, projectPackages, logger, currentThread));
            } else {
                arrayList.add(i, captureThreadTrace$toBugsnagThread(currentThread, exc, isUnhandled, projectPackages, logger, currentThread));
            }
        } else if (iBinarySearch >= arrayList.size()) {
            arrayList.add(captureThreadTrace$toBugsnagThread(currentThread, exc, isUnhandled, projectPackages, logger, currentThread));
        }
        if (allThreads.size() > maxThreadCount) {
            arrayList.add(new Thread("", "[" + (allThreads.size() - maxThreadCount) + " threads omitted as the maxReportedThreads limit (" + maxThreadCount + ") was exceeded]", ErrorType.UNKNOWN, false, Thread.State.UNKNOWN, new Stacktrace(new StackTraceElement[]{new StackTraceElement("", "", "-", 0)}, projectPackages, logger), logger));
        }
        return arrayList;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws Throwable {
        writer.beginArray();
        Iterator<Thread> it = this.threads.iterator();
        while (it.hasNext()) {
            writer.value(it.next());
        }
        writer.endArray();
    }
}
