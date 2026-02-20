package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class IdlingResourceTimeoutException extends RuntimeException implements EspressoException {
    public IdlingResourceTimeoutException(List<String> resourceNames) {
        super(String.format(Locale.ROOT, "Wait for %s to become idle timed out", Preconditions.checkNotNull(resourceNames)));
        TestOutputEmitter.dumpThreadStates("ThreadState-IdlingResTimeoutExcep.txt");
    }
}
