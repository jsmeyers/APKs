package androidx.test.espresso.action;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.NoActivityResumedException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.ActivityLifecycles;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import java.util.Locale;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
class KeyEventActionBase implements ViewAction {
    public static final int BACK_ACTIVITY_TRANSITION_MILLIS_DELAY = 150;
    public static final int CLEAR_TRANSITIONING_ACTIVITIES_ATTEMPTS = 4;
    public static final int CLEAR_TRANSITIONING_ACTIVITIES_MILLIS_DELAY = 150;
    private static final String TAG = "KeyEventActionBase";
    final EspressoKey espressoKey;

    KeyEventActionBase(EspressoKey espressoKey) {
        this.espressoKey = (EspressoKey) Preconditions.checkNotNull(espressoKey);
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        return ViewMatchers.isDisplayed();
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return String.format(Locale.ROOT, "send %s key event", this.espressoKey);
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        try {
            if (sendKeyEvent(uiController)) {
                return;
            }
            String strValueOf = String.valueOf(this.espressoKey);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 36);
            sb.append("Failed to inject espressoKey event: ");
            sb.append(strValueOf);
            Log.e(TAG, sb.toString());
            PerformException.Builder builderWithViewDescription = new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view));
            String strValueOf2 = String.valueOf(this.espressoKey);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 35);
            sb2.append("Failed to inject espressoKey event ");
            sb2.append(strValueOf2);
            throw builderWithViewDescription.withCause(new RuntimeException(sb2.toString())).build();
        } catch (InjectEventSecurityException e) {
            String strValueOf3 = String.valueOf(this.espressoKey);
            StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf3).length() + 36);
            sb3.append("Failed to inject espressoKey event: ");
            sb3.append(strValueOf3);
            Log.e(TAG, sb3.toString());
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(e).build();
        }
    }

    private boolean sendKeyEvent(UiController controller) throws InjectEventSecurityException {
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean zInjectKeyEvent = false;
        boolean zInjectKeyEvent2 = false;
        for (int i = 0; !zInjectKeyEvent2 && i < 4; i++) {
            zInjectKeyEvent2 = controller.injectKeyEvent(new KeyEvent(jUptimeMillis, jUptimeMillis, 0, this.espressoKey.getKeyCode(), 0, this.espressoKey.getMetaState()));
        }
        if (!zInjectKeyEvent2) {
            return false;
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        for (int i2 = 0; !zInjectKeyEvent && i2 < 4; i2++) {
            zInjectKeyEvent = controller.injectKeyEvent(new KeyEvent(jUptimeMillis2, jUptimeMillis2, 1, this.espressoKey.getKeyCode(), 0));
        }
        return zInjectKeyEvent;
    }

    static Activity getCurrentActivity() {
        return (Activity) Iterables.getOnlyElement(ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED));
    }

    static void waitForStageChangeInitialActivity(UiController controller, Activity initialActivity) {
        if (isActivityResumed(initialActivity)) {
            controller.loopMainThreadForAtLeast(150L);
            if (isActivityResumed(initialActivity)) {
                Log.e(TAG, "Back was pressed but there was no Activity stage transition in 150ms, possibly due to a delay calling super.onBackPressed() from your Activity.");
            }
        }
    }

    private static boolean isActivityResumed(Activity activity) {
        return ActivityLifecycleMonitorRegistry.getInstance().getLifecycleStageOf(activity) == Stage.RESUMED;
    }

    static void waitForPendingForegroundActivities(UiController controller, boolean conditional) {
        ActivityLifecycleMonitor activityLifecycleMonitorRegistry = ActivityLifecycleMonitorRegistry.getInstance();
        boolean zHasTransitioningActivities = false;
        for (int i = 0; i < 4; i++) {
            controller.loopMainThreadUntilIdle();
            zHasTransitioningActivities = ActivityLifecycles.hasTransitioningActivities(activityLifecycleMonitorRegistry);
            if (!zHasTransitioningActivities) {
                break;
            }
            controller.loopMainThreadForAtLeast(150L);
        }
        if (!ActivityLifecycles.hasForegroundActivities(activityLifecycleMonitorRegistry)) {
            if (conditional) {
                throw new NoActivityResumedException("Pressed back and killed the app");
            }
            Log.w(TAG, "Pressed back and hopped to a different process or potentially killed the app");
        }
        if (zHasTransitioningActivities) {
            Log.e(TAG, "Back was pressed and left the application in an inconsistent state even after 600ms.");
        }
    }
}
