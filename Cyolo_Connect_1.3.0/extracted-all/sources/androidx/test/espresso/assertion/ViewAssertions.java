package androidx.test.espresso.assertion;

import android.util.Log;
import android.view.View;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.remote.annotation.RemoteMsgField;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.ArrayList;
import java.util.Locale;
import junit.framework.AssertionFailedError;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;

/* JADX INFO: loaded from: classes.dex */
public final class ViewAssertions {
    private static final String TAG = "ViewAssertions";

    private ViewAssertions() {
    }

    public static ViewAssertion doesNotExist() {
        return new DoesNotExistViewAssertion();
    }

    public static ViewAssertion matches(final Matcher<? super View> viewMatcher) {
        return new MatchesViewAssertion((Matcher) Preconditions.checkNotNull(viewMatcher));
    }

    public static ViewAssertion selectedDescendantsMatch(final Matcher<View> selector, final Matcher<View> matcher) {
        return new SelectedDescendantsMatchViewAssertion(selector, matcher);
    }

    static class MatchesViewAssertion implements ViewAssertion {

        @RemoteMsgField(order = 0)
        final Matcher<? super View> viewMatcher;

        @RemoteMsgConstructor
        private MatchesViewAssertion(final Matcher<? super View> viewMatcher) {
            this.viewMatcher = viewMatcher;
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noViewException) {
            StringDescription stringDescription = new StringDescription();
            stringDescription.appendText("'");
            this.viewMatcher.describeTo(stringDescription);
            if (noViewException != null) {
                stringDescription.appendText(String.format(Locale.ROOT, "' check could not be performed because view '%s' was not found.\n", noViewException.getViewMatcherDescription()));
                Log.e(ViewAssertions.TAG, stringDescription.toString());
                throw noViewException;
            }
            stringDescription.appendText("' doesn't match the selected view.");
            ViewMatchers.assertThat(stringDescription.toString(), view, this.viewMatcher);
        }

        public String toString() {
            return String.format(Locale.ROOT, "MatchesViewAssertion{viewMatcher=%s}", this.viewMatcher);
        }
    }

    static class DoesNotExistViewAssertion implements ViewAssertion {
        @RemoteMsgConstructor
        private DoesNotExistViewAssertion() {
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noView) {
            if (view != null) {
                String strValueOf = String.valueOf(HumanReadables.describe(view));
                ViewMatchers.assertThat(strValueOf.length() != 0 ? "View is present in the hierarchy: ".concat(strValueOf) : new String("View is present in the hierarchy: "), true, Matchers.is(false));
            }
        }
    }

    static class SelectedDescendantsMatchViewAssertion implements ViewAssertion {

        @RemoteMsgField(order = 1)
        private final Matcher<View> matcher;

        @RemoteMsgField(order = 0)
        private final Matcher<View> selector;

        @RemoteMsgConstructor
        private SelectedDescendantsMatchViewAssertion(final Matcher<View> selector, final Matcher<View> matcher) {
            this.selector = selector;
            this.matcher = matcher;
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noViewException) {
            Preconditions.checkNotNull(view);
            ArrayList arrayList = new ArrayList();
            for (View view2 : Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), new Predicate<View>() { // from class: androidx.test.espresso.assertion.ViewAssertions.SelectedDescendantsMatchViewAssertion.1
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
                public boolean apply(View input) {
                    return SelectedDescendantsMatchViewAssertion.this.selector.matches(input);
                }
            })) {
                if (!this.matcher.matches(view2)) {
                    arrayList.add(view2);
                }
            }
            if (arrayList.size() > 0) {
                throw new AssertionFailedError(HumanReadables.getViewHierarchyErrorMessage(view, arrayList, String.format(Locale.ROOT, "At least one view did not match the required matcher: %s", this.matcher), "****DOES NOT MATCH****"));
            }
        }

        public String toString() {
            return String.format(Locale.ROOT, "SelectedDescendantsMatchViewAssertion{selector=%s, matcher=%s}", this.selector, this.matcher);
        }
    }
}
