package androidx.test.espresso.assertion;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.test.espresso.AmbiguousViewMatcherException;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterators;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.Iterator;
import java.util.Locale;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;

/* JADX INFO: loaded from: classes.dex */
public final class PositionAssertions {
    private static final String TAG = "PositionAssertions";

    private PositionAssertions() {
    }

    public static ViewAssertion isCompletelyLeftOf(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.COMPLETELY_LEFT_OF);
    }

    public static ViewAssertion isCompletelyRightOf(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.COMPLETELY_RIGHT_OF);
    }

    @Deprecated
    public static ViewAssertion isLeftOf(Matcher<View> matcher) {
        return isCompletelyLeftOf(matcher);
    }

    @Deprecated
    public static ViewAssertion isRightOf(Matcher<View> matcher) {
        return isCompletelyRightOf(matcher);
    }

    public static ViewAssertion isPartiallyLeftOf(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.PARTIALLY_LEFT_OF);
    }

    public static ViewAssertion isPartiallyRightOf(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.PARTIALLY_RIGHT_OF);
    }

    public static ViewAssertion isLeftAlignedWith(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.LEFT_ALIGNED);
    }

    public static ViewAssertion isRightAlignedWith(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.RIGHT_ALIGNED);
    }

    public static ViewAssertion isCompletelyAbove(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.COMPLETELY_ABOVE);
    }

    public static ViewAssertion isCompletelyBelow(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.COMPLETELY_BELOW);
    }

    public static ViewAssertion isPartiallyAbove(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.PARTIALLY_ABOVE);
    }

    public static ViewAssertion isPartiallyBelow(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.PARTIALLY_BELOW);
    }

    @Deprecated
    public static ViewAssertion isAbove(Matcher<View> matcher) {
        return isCompletelyAbove(matcher);
    }

    @Deprecated
    public static ViewAssertion isBelow(Matcher<View> matcher) {
        return isCompletelyBelow(matcher);
    }

    public static ViewAssertion isBottomAlignedWith(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.BOTTOM_ALIGNED);
    }

    public static ViewAssertion isTopAlignedWith(Matcher<View> matcher) {
        return relativePositionOf(matcher, Position.TOP_ALIGNED);
    }

    static ViewAssertion relativePositionOf(final Matcher<View> viewMatcher, final Position position) {
        Preconditions.checkNotNull(viewMatcher);
        return new ViewAssertion() { // from class: androidx.test.espresso.assertion.PositionAssertions.1
            @Override // androidx.test.espresso.ViewAssertion
            public void check(final View foundView, NoMatchingViewException noViewException) {
                StringDescription stringDescription = new StringDescription();
                if (noViewException != null) {
                    stringDescription.appendText(String.format(Locale.ROOT, "' check could not be performed because view '%s' was not found.\n", noViewException.getViewMatcherDescription()));
                    Log.e(PositionAssertions.TAG, stringDescription.toString());
                    throw noViewException;
                }
                stringDescription.appendText("View:").appendText(HumanReadables.describe(foundView)).appendText(" is not ").appendText(position.toString()).appendText(" view ").appendText(viewMatcher.toString());
                ViewMatchers.assertThat(stringDescription.toString(), Boolean.valueOf(PositionAssertions.isRelativePosition(foundView, PositionAssertions.findView(viewMatcher, PositionAssertions.getTopViewGroup(foundView)), position)), Matchers.is(true));
            }
        };
    }

    static View findView(final Matcher<View> toView, View root) {
        Preconditions.checkNotNull(toView);
        Preconditions.checkNotNull(root);
        Iterator it = Iterables.filter(TreeIterables.breadthFirstViewTraversal(root), new Predicate<View>() { // from class: androidx.test.espresso.assertion.PositionAssertions.2
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
            public boolean apply(View input) {
                return toView.matches(input);
            }
        }).iterator();
        View view = null;
        while (it.hasNext()) {
            if (view != null) {
                throw new AmbiguousViewMatcherException.Builder().withRootView(root).withViewMatcher(toView).withView1(view).withView2((View) it.next()).withOtherAmbiguousViews((View[]) Iterators.toArray(it, View.class)).build();
            }
            view = (View) it.next();
        }
        if (view != null) {
            return view;
        }
        throw new NoMatchingViewException.Builder().withViewMatcher(toView).withRootView(root).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup getTopViewGroup(View view) {
        ViewGroup viewGroup = null;
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
        }
        return viewGroup;
    }

    static boolean isRelativePosition(View view1, View view2, Position position) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view1.getLocationOnScreen(iArr);
        view2.getLocationOnScreen(iArr2);
        switch (AnonymousClass3.$SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[position.ordinal()]) {
            case 1:
                return iArr[0] + view1.getWidth() <= iArr2[0];
            case 2:
                return iArr2[0] + view2.getWidth() <= iArr[0];
            case 3:
                return iArr[1] + view1.getHeight() <= iArr2[1];
            case 4:
                return iArr2[1] + view2.getHeight() <= iArr[1];
            case 5:
                int i = iArr[0];
                int i2 = iArr2[0];
                return i < i2 && i2 < i + view1.getWidth();
            case 6:
                int i3 = iArr2[0];
                int i4 = iArr[0];
                return i3 < i4 && i4 < i3 + view2.getWidth();
            case 7:
                int i5 = iArr[1];
                int i6 = iArr2[1];
                return i5 < i6 && i6 < i5 + view1.getHeight();
            case 8:
                int i7 = iArr2[1];
                int i8 = iArr[1];
                return i7 < i8 && i8 < i7 + view2.getHeight();
            case 9:
                return iArr[0] == iArr2[0];
            case 10:
                return iArr[0] + view1.getWidth() == iArr2[0] + view2.getWidth();
            case 11:
                return iArr[1] == iArr2[1];
            case 12:
                return iArr[1] + view1.getHeight() == iArr2[1] + view2.getHeight();
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: androidx.test.espresso.assertion.PositionAssertions$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position;

        static {
            int[] iArr = new int[Position.values().length];
            $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position = iArr;
            try {
                iArr[Position.COMPLETELY_LEFT_OF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.COMPLETELY_RIGHT_OF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.COMPLETELY_ABOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.COMPLETELY_BELOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.PARTIALLY_LEFT_OF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.PARTIALLY_RIGHT_OF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.PARTIALLY_ABOVE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.PARTIALLY_BELOW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.LEFT_ALIGNED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.RIGHT_ALIGNED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.TOP_ALIGNED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$test$espresso$assertion$PositionAssertions$Position[Position.BOTTOM_ALIGNED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    enum Position {
        COMPLETELY_LEFT_OF("completely left of"),
        COMPLETELY_RIGHT_OF("completely right of"),
        COMPLETELY_ABOVE("completely above"),
        COMPLETELY_BELOW("completely below"),
        PARTIALLY_LEFT_OF("partially left of"),
        PARTIALLY_RIGHT_OF("partially right of"),
        PARTIALLY_ABOVE("partially above"),
        PARTIALLY_BELOW("partially below"),
        LEFT_ALIGNED("aligned left with"),
        RIGHT_ALIGNED("aligned right with"),
        TOP_ALIGNED("aligned top with"),
        BOTTOM_ALIGNED("aligned bottom with");

        private final String positionValue;

        Position(String value) {
            this.positionValue = value;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.positionValue;
        }
    }
}
