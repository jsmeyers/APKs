package androidx.test.internal.runner.filters;

import java.util.regex.Pattern;
import org.junit.runner.Description;

/* JADX INFO: loaded from: classes.dex */
public final class TestsRegExFilter extends ParentFilter {
    private Pattern pattern = null;

    @Override // org.junit.runner.manipulation.Filter
    public String describe() {
        return "tests filter";
    }

    public void setPattern(String patternString) {
        this.pattern = Pattern.compile(patternString);
    }

    @Override // androidx.test.internal.runner.filters.ParentFilter
    protected boolean evaluateTest(Description description) {
        if (this.pattern == null) {
            return true;
        }
        return this.pattern.matcher(String.format("%s#%s", description.getClassName(), description.getMethodName())).find();
    }
}
