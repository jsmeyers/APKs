package androidx.test.espresso.base;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.view.View;
import androidx.test.espresso.EspressoException;
import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Throwables;
import androidx.test.espresso.internal.inject.TargetContext;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.AssertionFailedError;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultFailureHandler implements FailureHandler {
    private static final AtomicInteger failureCount = new AtomicInteger(0);
    private final Context appContext;

    private static boolean isJellyBeanMR1OrHigher() {
        return true;
    }

    public DefaultFailureHandler(@TargetContext Context appContext) {
        this.appContext = (Context) Preconditions.checkNotNull(appContext);
    }

    @Override // androidx.test.espresso.FailureHandler
    public void handle(Throwable error, Matcher<View> viewMatcher) {
        int iIncrementAndGet = failureCount.incrementAndGet();
        StringBuilder sb = new StringBuilder(29);
        sb.append("view-op-error-");
        sb.append(iIncrementAndGet);
        sb.append(".png");
        TestOutputEmitter.takeScreenshot(sb.toString());
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("explore-window-hierarchy-");
        sb2.append(iIncrementAndGet);
        sb2.append(".xml");
        TestOutputEmitter.captureWindowHierarchy(sb2.toString());
        if ((error instanceof EspressoException) || (error instanceof AssertionFailedError) || (error instanceof AssertionError)) {
            Throwables.throwIfUnchecked(getUserFriendlyError(error, viewMatcher));
            throw new RuntimeException(getUserFriendlyError(error, viewMatcher));
        }
        Throwables.throwIfUnchecked(error);
        throw new RuntimeException(error);
    }

    private Throwable getUserFriendlyError(Throwable error, Matcher<View> viewMatcher) {
        if (error instanceof PerformException) {
            StringBuilder sb = new StringBuilder();
            if (!isAnimationAndTransitionDisabled(this.appContext)) {
                sb.append("Animations or transitions are enabled on the target device.\nFor more info check: https://developer.android.com/training/testing/espresso/setup#set-up-environment\n\n");
            }
            sb.append(viewMatcher.toString());
            throw new PerformException.Builder().from((PerformException) error).withViewDescription(sb.toString()).build();
        }
        if (error instanceof AssertionError) {
            error = new AssertionFailedWithCauseError(error.getMessage(), error);
        }
        error.setStackTrace(Thread.currentThread().getStackTrace());
        return error;
    }

    private static final class AssertionFailedWithCauseError extends AssertionFailedError {
        public AssertionFailedWithCauseError(String message, Throwable cause) {
            super(message);
            initCause(cause);
        }
    }

    private static boolean isAnimationAndTransitionDisabled(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return isEqualToZero(getTransitionAnimationScale(contentResolver)) && isEqualToZero(getWindowAnimationScale(contentResolver)) && isEqualToZero(getAnimatorDurationScale(contentResolver));
    }

    private static boolean isEqualToZero(float value) {
        return Float.compare(Math.abs(value), 0.0f) == 0;
    }

    private static float getTransitionAnimationScale(ContentResolver resolver) {
        return getSetting(resolver, "transition_animation_scale", "transition_animation_scale");
    }

    private static float getWindowAnimationScale(ContentResolver resolver) {
        return getSetting(resolver, "window_animation_scale", "window_animation_scale");
    }

    private static float getAnimatorDurationScale(ContentResolver resolver) {
        if (isJellyBeanMR1OrHigher()) {
            return getSetting(resolver, "animator_duration_scale", "animator_duration_scale");
        }
        return 0.0f;
    }

    private static float getSetting(ContentResolver resolver, String current, String deprecated) {
        if (isJellyBeanMR1OrHigher()) {
            return getGlobalSetting(resolver, current);
        }
        return getSystemSetting(resolver, deprecated);
    }

    private static float getGlobalSetting(ContentResolver resolver, String setting) {
        try {
            return Settings.Global.getFloat(resolver, setting);
        } catch (Settings.SettingNotFoundException unused) {
            return 0.0f;
        }
    }

    private static float getSystemSetting(ContentResolver resolver, String setting) {
        try {
            return Settings.System.getFloat(resolver, setting);
        } catch (Settings.SettingNotFoundException unused) {
            return 0.0f;
        }
    }
}
