package androidx.test.espresso;

import androidx.test.espresso.IdlingPolicy;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class IdlingPolicies {
    private static volatile IdlingPolicy masterIdlingPolicy = new IdlingPolicy.Builder().withIdlingTimeout(60).withIdlingTimeoutUnit(TimeUnit.SECONDS).throwAppNotIdleException().build();
    private static volatile IdlingPolicy dynamicIdlingResourceErrorPolicy = new IdlingPolicy.Builder().withIdlingTimeout(26).withIdlingTimeoutUnit(TimeUnit.SECONDS).throwIdlingResourceTimeoutException().build();
    private static volatile IdlingPolicy dynamicIdlingResourceWarningPolicy = new IdlingPolicy.Builder().withIdlingTimeout(5).withIdlingTimeoutUnit(TimeUnit.SECONDS).logWarning().build();

    private IdlingPolicies() {
    }

    public static void setMasterPolicyTimeout(long timeout, TimeUnit unit) {
        Preconditions.checkArgument(timeout > 0);
        Preconditions.checkNotNull(unit);
        masterIdlingPolicy = masterIdlingPolicy.toBuilder().withIdlingTimeout(timeout).withIdlingTimeoutUnit(unit).build();
    }

    public static void setIdlingResourceTimeout(long timeout, TimeUnit unit) {
        Preconditions.checkArgument(timeout > 0);
        Preconditions.checkNotNull(unit);
        dynamicIdlingResourceErrorPolicy = dynamicIdlingResourceErrorPolicy.toBuilder().withIdlingTimeout(timeout).withIdlingTimeoutUnit(unit).build();
    }

    public static void setMasterPolicyTimeoutWhenDebuggerAttached(boolean timeoutWhenDebuggerAttached) {
        masterIdlingPolicy = masterIdlingPolicy.toBuilder().build();
    }

    public static IdlingPolicy getMasterIdlingPolicy() {
        return masterIdlingPolicy;
    }

    public static IdlingPolicy getDynamicIdlingResourceWarningPolicy() {
        return dynamicIdlingResourceWarningPolicy;
    }

    public static IdlingPolicy getDynamicIdlingResourceErrorPolicy() {
        return dynamicIdlingResourceErrorPolicy;
    }
}
