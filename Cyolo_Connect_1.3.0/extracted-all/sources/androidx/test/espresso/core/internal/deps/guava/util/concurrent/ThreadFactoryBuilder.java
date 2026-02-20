package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadFactoryBuilder {
    private String nameFormat = null;
    private Boolean daemon = null;
    private Integer priority = null;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
    private ThreadFactory backingThreadFactory = null;

    public ThreadFactoryBuilder setNameFormat(String nameFormat) {
        format(nameFormat, 0);
        this.nameFormat = nameFormat;
        return this;
    }

    public ThreadFactory build() {
        return doBuild(this);
    }

    private static ThreadFactory doBuild(ThreadFactoryBuilder builder) {
        final String str = builder.nameFormat;
        final Boolean bool = builder.daemon;
        final Integer num = builder.priority;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = builder.uncaughtExceptionHandler;
        ThreadFactory threadFactoryDefaultThreadFactory = builder.backingThreadFactory;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        final ThreadFactory threadFactory = threadFactoryDefaultThreadFactory;
        final AtomicLong atomicLong = str != null ? new AtomicLong(0L) : null;
        return new ThreadFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.util.concurrent.ThreadFactoryBuilder.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = threadFactory.newThread(runnable);
                String str2 = str;
                if (str2 != null) {
                    threadNewThread.setName(ThreadFactoryBuilder.format(str2, Long.valueOf(atomicLong.getAndIncrement())));
                }
                Boolean bool2 = bool;
                if (bool2 != null) {
                    threadNewThread.setDaemon(bool2.booleanValue());
                }
                Integer num2 = num;
                if (num2 != null) {
                    threadNewThread.setPriority(num2.intValue());
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandler;
                if (uncaughtExceptionHandler2 != null) {
                    threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler2);
                }
                return threadNewThread;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String format(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }
}
