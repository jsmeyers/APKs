package androidx.test.espresso;

import android.view.View;
import androidx.core.os.EnvironmentCompat;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.HumanReadables;
import java.util.List;
import java.util.Locale;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class NoMatchingViewException extends RuntimeException implements EspressoException {
    private EspressoOptional<String> adapterViewWarning;
    private List<View> adapterViews;
    private boolean includeViewHierarchy;
    private View rootView;
    private Matcher<? super View> viewMatcher;

    private NoMatchingViewException(String description) {
        super(description);
        this.adapterViews = Lists.newArrayList();
        this.includeViewHierarchy = true;
        this.adapterViewWarning = EspressoOptional.absent();
    }

    private NoMatchingViewException(Builder builder) {
        super(getErrorMessage(builder), builder.cause);
        this.adapterViews = Lists.newArrayList();
        this.includeViewHierarchy = true;
        this.adapterViewWarning = EspressoOptional.absent();
        this.viewMatcher = builder.viewMatcher;
        this.rootView = builder.rootView;
        this.adapterViews = builder.adapterViews;
        this.adapterViewWarning = builder.adapterViewWarning;
        this.includeViewHierarchy = builder.includeViewHierarchy;
    }

    public String getViewMatcherDescription() {
        Matcher<? super View> matcher = this.viewMatcher;
        return matcher != null ? matcher.toString() : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    private static String getErrorMessage(Builder builder) {
        if (!builder.includeViewHierarchy) {
            return String.format(Locale.ROOT, "Could not find a view that matches %s", builder.viewMatcher);
        }
        String strConcat = String.format(Locale.ROOT, "No views in hierarchy found matching: %s", builder.viewMatcher);
        if (builder.adapterViewWarning.isPresent()) {
            String strValueOf = String.valueOf(strConcat);
            String strValueOf2 = String.valueOf((String) builder.adapterViewWarning.get());
            strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
        }
        return HumanReadables.getViewHierarchyErrorMessage(builder.rootView, null, strConcat, null);
    }

    public static class Builder {
        private Throwable cause;
        private View rootView;
        private Matcher<? super View> viewMatcher;
        private List<View> adapterViews = Lists.newArrayList();
        private boolean includeViewHierarchy = true;
        private EspressoOptional<String> adapterViewWarning = EspressoOptional.absent();

        public Builder from(NoMatchingViewException exception) {
            this.viewMatcher = exception.viewMatcher;
            this.rootView = exception.rootView;
            this.adapterViews = exception.adapterViews;
            this.adapterViewWarning = exception.adapterViewWarning;
            this.includeViewHierarchy = exception.includeViewHierarchy;
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

        public Builder withAdapterViews(List<View> adapterViews) {
            this.adapterViews = adapterViews;
            return this;
        }

        public Builder includeViewHierarchy(boolean includeViewHierarchy) {
            this.includeViewHierarchy = includeViewHierarchy;
            return this;
        }

        public Builder withAdapterViewWarning(EspressoOptional<String> adapterViewWarning) {
            this.adapterViewWarning = adapterViewWarning;
            return this;
        }

        public Builder withCause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        public NoMatchingViewException build() {
            Preconditions.checkNotNull(this.viewMatcher);
            Preconditions.checkNotNull(this.rootView);
            Preconditions.checkNotNull(this.adapterViews);
            Preconditions.checkNotNull(this.adapterViewWarning);
            return new NoMatchingViewException(this);
        }
    }
}
