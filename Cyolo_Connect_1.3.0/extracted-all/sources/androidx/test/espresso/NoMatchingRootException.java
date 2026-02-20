package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.List;
import java.util.Locale;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class NoMatchingRootException extends RuntimeException implements EspressoException {
    private NoMatchingRootException(String description) {
        super(description);
        TestOutputEmitter.dumpThreadStates("ThreadState-NoMatchingRootException.txt");
    }

    public static NoMatchingRootException create(Matcher<Root> rootMatcher, List<Root> roots) {
        Preconditions.checkNotNull(rootMatcher);
        Preconditions.checkNotNull(roots);
        return new NoMatchingRootException(String.format(Locale.ROOT, "Matcher '%s' did not match any of the following roots: %s", rootMatcher, roots));
    }
}
