package com.bugsnag.android;

import com.bugsnag.android.StateEvent;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.android.internal.StateObserver;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LaunchCrashTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bugsnag/android/LaunchCrashTracker;", "Lcom/bugsnag/android/BaseObservable;", "config", "Lcom/bugsnag/android/internal/ImmutableConfig;", "executor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "(Lcom/bugsnag/android/internal/ImmutableConfig;Ljava/util/concurrent/ScheduledThreadPoolExecutor;)V", "launching", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logger", "Lcom/bugsnag/android/Logger;", "isLaunching", "", "markLaunchCompleted", "", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LaunchCrashTracker extends BaseObservable {
    private final ScheduledThreadPoolExecutor executor;
    private final AtomicBoolean launching;
    private final Logger logger;

    /* JADX WARN: Multi-variable type inference failed */
    public LaunchCrashTracker(ImmutableConfig immutableConfig) {
        this(immutableConfig, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ LaunchCrashTracker(ImmutableConfig immutableConfig, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(immutableConfig, (i & 2) != 0 ? new ScheduledThreadPoolExecutor(1) : scheduledThreadPoolExecutor);
    }

    public LaunchCrashTracker(ImmutableConfig immutableConfig, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.executor = scheduledThreadPoolExecutor;
        this.launching = new AtomicBoolean(true);
        this.logger = immutableConfig.getLogger();
        long launchDurationMillis = immutableConfig.getLaunchDurationMillis();
        if (launchDurationMillis > 0) {
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            try {
                scheduledThreadPoolExecutor.schedule(new Runnable() { // from class: com.bugsnag.android.LaunchCrashTracker$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.markLaunchCompleted();
                    }
                }, launchDurationMillis, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                this.logger.w("Failed to schedule timer for LaunchCrashTracker", e);
            }
        }
    }

    public final void markLaunchCompleted() {
        this.executor.shutdown();
        this.launching.set(false);
        LaunchCrashTracker launchCrashTracker = this;
        if (!launchCrashTracker.getObservers$bugsnag_android_core_release().isEmpty()) {
            StateEvent.UpdateIsLaunching updateIsLaunching = new StateEvent.UpdateIsLaunching(false);
            Iterator<T> it = launchCrashTracker.getObservers$bugsnag_android_core_release().iterator();
            while (it.hasNext()) {
                ((StateObserver) it.next()).onStateChange(updateIsLaunching);
            }
        }
        this.logger.d("App launch period marked as complete");
    }

    public final boolean isLaunching() {
        return this.launching.get();
    }
}
