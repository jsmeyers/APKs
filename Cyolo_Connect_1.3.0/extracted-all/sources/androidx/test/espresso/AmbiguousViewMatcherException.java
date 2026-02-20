package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.Locale;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class AmbiguousViewMatcherException extends RuntimeException implements EspressoException {
    private View[] others;
    private View rootView;
    private View view1;
    private View view2;
    private Matcher<? super View> viewMatcher;

    private AmbiguousViewMatcherException(String description) {
        super(description);
        TestOutputEmitter.dumpThreadStates("ThreadState-AmbiguousViewMatcherException.txt");
    }

    private AmbiguousViewMatcherException(Builder builder) {
        super(getErrorMessage(builder));
        this.viewMatcher = builder.viewMatcher;
        this.rootView = builder.rootView;
        this.view1 = builder.view1;
        this.view2 = builder.view2;
        this.others = builder.others;
    }

    private static String getErrorMessage(Builder builder) {
        if (builder.includeViewHierarchy) {
            return HumanReadables.getViewHierarchyErrorMessage(builder.rootView, Lists.newArrayList(ImmutableSet.builder().add((Object[]) new View[]{builder.view1, builder.view2}).add((Object[]) builder.others).build()), String.format(Locale.ROOT, "'%s' matches multiple views in the hierarchy.", builder.viewMatcher), "****MATCHES****");
        }
        return String.format(Locale.ROOT, "Multiple Ambiguous Views found for matcher %s", builder.viewMatcher);
    }

    public static class Builder {
        private boolean includeViewHierarchy = true;
        private View[] others;
        private View rootView;
        private View view1;
        private View view2;
        private Matcher<? super View> viewMatcher;

        public Builder from(AmbiguousViewMatcherException exception) {
            this.viewMatcher = exception.viewMatcher;
            this.rootView = exception.rootView;
            this.view1 = exception.view1;
            this.view2 = exception.view2;
            this.others = exception.others;
            return this;
        }

        public Builder withViewMatcher(Matcher<? super View> viewMatcher) {
            this.viewMatcher = viewMatcher;
            return this;
        }

        public Builder withRootView(View rootView) {
            this.rootView = rootView;
            return this;
        }

        public Builder withView1(View view1) {
            this.view1 = view1;
            return this;
        }

        public Builder withView2(View view2) {
            this.view2 = view2;
            return this;
        }

        public Builder withOtherAmbiguousViews(View... others) {
            this.others = others;
            return this;
        }

        public Builder includeViewHierarchy(boolean includeViewHierarchy) {
            this.includeViewHierarchy = includeViewHierarchy;
            return this;
        }

        public AmbiguousViewMatcherException build() {
            Preconditions.checkNotNull(this.viewMatcher);
            Preconditions.checkNotNull(this.rootView);
            Preconditions.checkNotNull(this.view1);
            Preconditions.checkNotNull(this.view2);
            Preconditions.checkNotNull(this.others);
            return new AmbiguousViewMatcherException(this);
        }
    }
}
