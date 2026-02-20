package androidx.test.espresso;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.guava.base.Joiner;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class AppNotIdleException extends RuntimeException implements EspressoException {
    private AppNotIdleException(String description) {
        super(description);
        TestOutputEmitter.dumpThreadStates("ThreadState-AppNotIdleException.txt");
    }

    @Deprecated
    public static AppNotIdleException create(List<String> idleConditions, int loopCount, int seconds) {
        Preconditions.checkState(Looper.myLooper() == Looper.getMainLooper());
        return new AppNotIdleException(String.format(Locale.ROOT, "App not idle within timeout of %s seconds evenafter trying for %s iterations. The following Idle Conditions failed %s", Integer.valueOf(seconds), Integer.valueOf(loopCount), Joiner.on(",").join(idleConditions)));
    }

    public static AppNotIdleException create(List<String> idleConditions, String message) {
        return new AppNotIdleException(String.format(Locale.ROOT, "%s The following Idle Conditions failed %s.", message, Joiner.on(",").join(idleConditions)));
    }
}
