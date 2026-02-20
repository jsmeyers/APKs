package androidx.test.espresso.util;

import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.Stage;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityLifecycles {
    private ActivityLifecycles() {
    }

    public static boolean hasForegroundActivities(ActivityLifecycleMonitor monitor) {
        return !monitor.getActivitiesInStage(Stage.RESUMED).isEmpty();
    }

    public static boolean hasVisibleActivities(ActivityLifecycleMonitor monitor) {
        return hasForegroundActivities(monitor) || hasTransitioningActivities(monitor);
    }

    public static boolean hasTransitioningActivities(ActivityLifecycleMonitor monitor) {
        return (monitor.getActivitiesInStage(Stage.RESTARTED).isEmpty() && monitor.getActivitiesInStage(Stage.STARTED).isEmpty() && monitor.getActivitiesInStage(Stage.PAUSED).isEmpty()) ? false : true;
    }
}
