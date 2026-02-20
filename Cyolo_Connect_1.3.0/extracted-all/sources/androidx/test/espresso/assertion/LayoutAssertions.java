package androidx.test.espresso.assertion;

import android.graphics.Rect;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.matcher.LayoutMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.remote.annotation.RemoteMsgField;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.AssertionFailedError;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutAssertions {
    private LayoutAssertions() {
    }

    public static ViewAssertion noEllipsizedText() {
        return ViewAssertions.selectedDescendantsMatch(ViewMatchers.isAssignableFrom(TextView.class), Matchers.not((Matcher) LayoutMatchers.hasEllipsizedText()));
    }

    public static ViewAssertion noMultilineButtons() {
        return ViewAssertions.selectedDescendantsMatch(ViewMatchers.isAssignableFrom(Button.class), Matchers.not((Matcher) LayoutMatchers.hasMultilineText()));
    }

    public static ViewAssertion noOverlaps(final Matcher<View> selector) {
        return new NoOverlapsViewAssertion((Matcher) Preconditions.checkNotNull(selector));
    }

    public static ViewAssertion noOverlaps() {
        return noOverlaps(Matchers.allOf(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE), Matchers.anyOf(ViewMatchers.isAssignableFrom(TextView.class), ViewMatchers.isAssignableFrom(ImageView.class))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rect getRect(View view) {
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], (view.getWidth() + i) - 1, (iArr[1] + view.getHeight()) - 1);
    }

    static class NoOverlapsViewAssertion implements ViewAssertion {

        @RemoteMsgField(order = 0)
        private final Matcher<View> selector;

        @RemoteMsgConstructor
        private NoOverlapsViewAssertion(Matcher<View> selector) {
            this.selector = selector;
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noViewException) {
            Predicate<View> predicate = new Predicate<View>() { // from class: androidx.test.espresso.assertion.LayoutAssertions.NoOverlapsViewAssertion.1
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
                public boolean apply(View input) {
                    return NoOverlapsViewAssertion.this.selector.matches(input);
                }
            };
            if (noViewException != null) {
                throw noViewException;
            }
            LinkedList<View> linkedList = new LinkedList();
            StringBuilder sb = new StringBuilder();
            for (View view2 : Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), predicate)) {
                Rect rect = LayoutAssertions.getRect(view2);
                if (!rect.isEmpty() && (!(view2 instanceof TextView) || ((TextView) view2).getText().length() != 0)) {
                    for (View view3 : linkedList) {
                        if (!(view2 instanceof ImageView) || !(view3 instanceof ImageView)) {
                            if (Rect.intersects(rect, LayoutAssertions.getRect(view3))) {
                                if (sb.length() > 0) {
                                    sb.append(",\n\n");
                                }
                                sb.append(String.format(Locale.ROOT, "%s overlaps\n%s", HumanReadables.describe(view2), HumanReadables.describe(view3)));
                                break;
                            }
                        }
                    }
                    linkedList.add(view2);
                }
            }
            if (sb.length() > 0) {
                throw new AssertionFailedError(sb.toString());
            }
        }

        public String toString() {
            return String.format(Locale.ROOT, "NoOverlapsViewAssertion{selector=%s}", this.selector);
        }
    }
}
