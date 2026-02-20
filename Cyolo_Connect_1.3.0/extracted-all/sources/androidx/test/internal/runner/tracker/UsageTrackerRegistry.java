package androidx.test.internal.runner.tracker;

import androidx.test.internal.runner.tracker.UsageTracker;
import androidx.test.internal.util.Checks;

/* JADX INFO: loaded from: classes.dex */
public final class UsageTrackerRegistry {
    private static volatile UsageTracker instance = new UsageTracker.NoOpUsageTracker();

    public interface AxtVersions {
        public static final String ESPRESSO_VERSION = "3.2.0";
        public static final String RUNNER_VERSION = "1.2.0";
    }

    public static void registerInstance(UsageTracker tracker) {
        instance = (UsageTracker) Checks.checkNotNull(tracker);
    }

    public static UsageTracker getInstance() {
        return instance;
    }

    private UsageTrackerRegistry() {
    }
}
