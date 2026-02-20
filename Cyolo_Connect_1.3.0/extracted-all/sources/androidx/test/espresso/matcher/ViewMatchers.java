package androidx.test.espresso.matcher;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.remote.annotation.RemoteMsgField;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.Locale;
import junit.framework.AssertionFailedError;
import org.apache.commons.io.IOUtils;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;
import org.hamcrest.TypeSafeMatcher;

/* JADX INFO: loaded from: classes.dex */
public final class ViewMatchers {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isViewIdGenerated(int id) {
        return ((-16777216) & id) == 0 && (id & ViewCompat.MEASURED_SIZE_MASK) != 0;
    }

    private ViewMatchers() {
    }

    public static Matcher<View> isAssignableFrom(Class<? extends View> clazz) {
        return new IsAssignableFromMatcher(clazz);
    }

    public static Matcher<View> withClassName(final Matcher<String> classNameMatcher) {
        return new WithClassNameMatcher((Matcher) Preconditions.checkNotNull(classNameMatcher));
    }

    public static Matcher<View> isDisplayed() {
        return new IsDisplayedMatcher();
    }

    public static Matcher<View> isCompletelyDisplayed() {
        return isDisplayingAtLeast(100);
    }

    public static Matcher<View> isDisplayingAtLeast(final int areaPercentage) {
        Preconditions.checkState(areaPercentage <= 100, "Cannot have over 100 percent: %s", areaPercentage);
        Preconditions.checkState(areaPercentage > 0, "Must have a positive, non-zero value: %s", areaPercentage);
        return new IsDisplayingAtLeastMatcher(areaPercentage);
    }

    public static Matcher<View> isEnabled() {
        return new IsEnabledMatcher();
    }

    public static Matcher<View> isFocusable() {
        return new IsFocusableMatcher();
    }

    public static Matcher<View> hasFocus() {
        return new HasFocusMatcher();
    }

    public static Matcher<View> isSelected() {
        return new IsSelectedMatcher();
    }

    public static Matcher<View> hasSibling(final Matcher<View> siblingMatcher) {
        return new HasSiblingMatcher((Matcher) Preconditions.checkNotNull(siblingMatcher));
    }

    public static Matcher<View> withContentDescription(final int resourceId) {
        return new WithContentDescriptionFromIdMatcher(resourceId);
    }

    public static Matcher<View> withContentDescription(String text) {
        return new WithContentDescriptionTextMatcher(Matchers.is(text));
    }

    public static Matcher<View> withContentDescription(final Matcher<? extends CharSequence> charSequenceMatcher) {
        return new WithContentDescriptionMatcher((Matcher) Preconditions.checkNotNull(charSequenceMatcher));
    }

    public static Matcher<View> withId(final int id) {
        return withId((Matcher<Integer>) Matchers.is(Integer.valueOf(id)));
    }

    public static Matcher<View> withId(final Matcher<Integer> integerMatcher) {
        return new WithIdMatcher((Matcher) Preconditions.checkNotNull(integerMatcher));
    }

    public static Matcher<View> withResourceName(String name) {
        return withResourceName((Matcher<String>) Matchers.is(name));
    }

    public static Matcher<View> withResourceName(final Matcher<String> stringMatcher) {
        return new WithResourceNameMatcher((Matcher) Preconditions.checkNotNull(stringMatcher));
    }

    public static Matcher<View> withTagKey(final int key) {
        return withTagKey(key, Matchers.notNullValue());
    }

    public static Matcher<View> withTagKey(final int key, final Matcher<?> objectMatcher) {
        return new WithTagKeyMatcher(key, (Matcher) Preconditions.checkNotNull(objectMatcher));
    }

    public static Matcher<View> withTagValue(final Matcher<Object> tagValueMatcher) {
        return new WithTagValueMatcher((Matcher) Preconditions.checkNotNull(tagValueMatcher));
    }

    public static Matcher<View> withText(String text) {
        return withText((Matcher<String>) Matchers.is(text));
    }

    public static Matcher<View> withText(final Matcher<String> stringMatcher) {
        return new WithTextMatcher((Matcher) Preconditions.checkNotNull(stringMatcher));
    }

    public static Matcher<View> withText(final int resourceId) {
        return new WithCharSequenceMatcher(resourceId, WithCharSequenceMatcher.TextViewMethod.GET_TEXT);
    }

    public static Matcher<View> withSubstring(String substring) {
        return withText(Matchers.containsString(substring));
    }

    public static Matcher<View> withHint(String hintText) {
        return withHint((Matcher<String>) Matchers.is((String) Preconditions.checkNotNull(hintText)));
    }

    public static Matcher<View> withHint(final Matcher<String> stringMatcher) {
        return new WithHintMatcher((Matcher) Preconditions.checkNotNull(stringMatcher));
    }

    public static Matcher<View> withHint(final int resourceId) {
        return new WithCharSequenceMatcher(resourceId, WithCharSequenceMatcher.TextViewMethod.GET_HINT);
    }

    public static Matcher<View> isChecked() {
        return withCheckBoxState(Matchers.is(true));
    }

    public static Matcher<View> isNotChecked() {
        return withCheckBoxState(Matchers.is(false));
    }

    private static <E extends View & Checkable> Matcher<View> withCheckBoxState(final Matcher<Boolean> checkStateMatcher) {
        return new WithCheckBoxStateMatcher(checkStateMatcher);
    }

    public static Matcher<View> hasContentDescription() {
        return new HasContentDescriptionMatcher();
    }

    public static Matcher<View> hasDescendant(final Matcher<View> descendantMatcher) {
        return new HasDescendantMatcher((Matcher) Preconditions.checkNotNull(descendantMatcher));
    }

    public static Matcher<View> isClickable() {
        return new IsClickableMatcher();
    }

    public static Matcher<View> isDescendantOfA(final Matcher<View> ancestorMatcher) {
        return new IsDescendantOfAMatcher((Matcher) Preconditions.checkNotNull(ancestorMatcher));
    }

    public static Matcher<View> withEffectiveVisibility(final Visibility visibility) {
        return new WithEffectiveVisibilityMatcher(visibility);
    }

    public enum Visibility {
        VISIBLE(0),
        INVISIBLE(4),
        GONE(8);

        private final int value;

        Visibility(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Matcher<View> withAlpha(final float alpha) {
        return new WithAlphaMatcher(alpha);
    }

    public static Matcher<View> withParent(final Matcher<View> parentMatcher) {
        return new WithParentMatcher((Matcher) Preconditions.checkNotNull(parentMatcher));
    }

    public static Matcher<View> withChild(final Matcher<View> childMatcher) {
        return new WithChildMatcher((Matcher) Preconditions.checkNotNull(childMatcher));
    }

    public static Matcher<View> hasChildCount(final int childCount) {
        return new HasChildCountMatcher(childCount);
    }

    public static Matcher<View> hasMinimumChildCount(final int minChildCount) {
        return new HasMinimumChildCountMatcher(minChildCount);
    }

    public static Matcher<View> isRoot() {
        return new IsRootMatcher();
    }

    public static Matcher<View> supportsInputMethods() {
        return new SupportsInputMethodsMatcher();
    }

    public static Matcher<View> hasImeAction(int imeAction) {
        return hasImeAction((Matcher<Integer>) Matchers.is(Integer.valueOf(imeAction)));
    }

    public static Matcher<View> hasImeAction(final Matcher<Integer> imeActionMatcher) {
        return new HasImeActionMatcher(imeActionMatcher);
    }

    public static Matcher<View> hasLinks() {
        return new HasLinksMatcher();
    }

    public static <T> void assertThat(T actual, Matcher<T> matcher) {
        assertThat("", actual, matcher);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void assertThat(String message, T actual, Matcher<T> matcher) {
        if (matcher.matches(actual)) {
            return;
        }
        StringDescription stringDescription = new StringDescription();
        stringDescription.appendText(message).appendText("\nExpected: ").appendDescriptionOf(matcher).appendText("\n     Got: ");
        if (actual instanceof View) {
            stringDescription.appendValue(HumanReadables.describe((View) actual));
        } else {
            stringDescription.appendValue(actual);
        }
        stringDescription.appendText(IOUtils.LINE_SEPARATOR_UNIX);
        throw new AssertionFailedError(stringDescription.toString());
    }

    public static Matcher<View> withSpinnerText(final int resourceId) {
        return new WithSpinnerTextIdMatcher(resourceId);
    }

    public static Matcher<View> withSpinnerText(final Matcher<String> stringMatcher) {
        return new WithSpinnerTextMatcher((Matcher) Preconditions.checkNotNull(stringMatcher));
    }

    public static Matcher<View> withSpinnerText(String text) {
        return withSpinnerText((Matcher<String>) Matchers.is(text));
    }

    public static Matcher<View> isJavascriptEnabled() {
        return new IsJavascriptEnabledMatcher();
    }

    public static Matcher<View> hasErrorText(final Matcher<String> stringMatcher) {
        return new HasErrorTextMatcher((Matcher) Preconditions.checkNotNull(stringMatcher));
    }

    public static Matcher<View> hasErrorText(final String expectedError) {
        return hasErrorText((Matcher<String>) Matchers.is(expectedError));
    }

    public static Matcher<View> withInputType(final int inputType) {
        return new WithInputTypeMatcher(inputType);
    }

    public static Matcher<View> withParentIndex(final int index) {
        Preconditions.checkArgument(index >= 0, "Index %s must be >= 0", index);
        return new WithParentIndexMatcher(index);
    }

    static final class WithIdMatcher extends TypeSafeMatcher<View> {
        private Resources resources;

        @RemoteMsgField(order = 0)
        Matcher<Integer> viewIdMatcher;

        @RemoteMsgConstructor
        private WithIdMatcher(Matcher<Integer> integerMatcher) {
            this.viewIdMatcher = integerMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            String strReplaceAll = this.viewIdMatcher.toString().replaceAll("\\D+", "");
            int i = Integer.parseInt(strReplaceAll);
            Resources resources = this.resources;
            if (resources != null) {
                try {
                    strReplaceAll = resources.getResourceName(i);
                } catch (Resources.NotFoundException unused) {
                    strReplaceAll = String.format(Locale.ROOT, "%s (resource name not found)", strReplaceAll);
                }
            }
            String strValueOf = String.valueOf(strReplaceAll);
            description.appendText(strValueOf.length() != 0 ? "with id: ".concat(strValueOf) : new String("with id: "));
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            this.resources = view.getResources();
            return this.viewIdMatcher.matches(Integer.valueOf(view.getId()));
        }
    }

    static final class WithTextMatcher extends BoundedMatcher<View, TextView> {

        @RemoteMsgField(order = 0)
        private final Matcher<String> stringMatcher;

        @RemoteMsgConstructor
        private WithTextMatcher(Matcher<String> stringMatcher) {
            super(TextView.class);
            this.stringMatcher = stringMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with text: ");
            this.stringMatcher.describeTo(description);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(TextView textView) {
            CharSequence transformation;
            String string = textView.getText().toString();
            if (this.stringMatcher.matches(string)) {
                return true;
            }
            if (textView.getTransformationMethod() == null || (transformation = textView.getTransformationMethod().getTransformation(string, textView)) == null) {
                return false;
            }
            return this.stringMatcher.matches(transformation.toString());
        }
    }

    static final class WithResourceNameMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<String> stringMatcher;

        @RemoteMsgConstructor
        private WithResourceNameMatcher(Matcher<String> stringMatcher) {
            this.stringMatcher = stringMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with res-name that ");
            this.stringMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            if (view.getId() != -1 && view.getResources() != null && !ViewMatchers.isViewIdGenerated(view.getId())) {
                try {
                    return this.stringMatcher.matches(view.getResources().getResourceEntryName(view.getId()));
                } catch (Resources.NotFoundException unused) {
                }
            }
            return false;
        }
    }

    static final class WithTagKeyMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final int key;

        @RemoteMsgField(order = 1)
        private final Matcher<?> objectMatcher;

        @RemoteMsgConstructor
        private WithTagKeyMatcher(int key, Matcher<?> objectMatcher) {
            this.key = key;
            this.objectMatcher = objectMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            int i = this.key;
            StringBuilder sb = new StringBuilder(21);
            sb.append("with key: ");
            sb.append(i);
            description.appendText(sb.toString());
            this.objectMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return this.objectMatcher.matches(view.getTag(this.key));
        }
    }

    static final class IsAssignableFromMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Class<?> clazz;

        @RemoteMsgConstructor
        private IsAssignableFromMatcher(Class<?> clazz) {
            this.clazz = (Class) Preconditions.checkNotNull(clazz);
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            String strValueOf = String.valueOf(this.clazz);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 26);
            sb.append("is assignable from class: ");
            sb.append(strValueOf);
            description.appendText(sb.toString());
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return this.clazz.isAssignableFrom(view.getClass());
        }
    }

    static final class WithClassNameMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        final Matcher<String> classNameMatcher;

        @RemoteMsgConstructor
        private WithClassNameMatcher(Matcher<String> classNameMatcher) {
            this.classNameMatcher = classNameMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with class name: ");
            this.classNameMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return this.classNameMatcher.matches(view.getClass().getName());
        }
    }

    static final class IsDisplayedMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private IsDisplayedMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is displayed on the screen to the user");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.getGlobalVisibleRect(new Rect()) && ViewMatchers.withEffectiveVisibility(Visibility.VISIBLE).matches(view);
        }
    }

    static final class IsDisplayingAtLeastMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        final int areaPercentage;

        @RemoteMsgConstructor
        private IsDisplayingAtLeastMatcher(int areaPercentage) {
            this.areaPercentage = areaPercentage;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText(String.format(Locale.ROOT, "at least %s percent of the view's area is displayed to the user.", Integer.valueOf(this.areaPercentage)));
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return false;
            }
            Rect screenWithoutStatusBarActionBar = getScreenWithoutStatusBarActionBar(view);
            if (view.getHeight() > screenWithoutStatusBarActionBar.height()) {
                screenWithoutStatusBarActionBar.height();
            } else {
                view.getHeight();
            }
            if (view.getWidth() > screenWithoutStatusBarActionBar.width()) {
                screenWithoutStatusBarActionBar.width();
            } else {
                view.getWidth();
            }
            return ((int) ((((double) (rect.height() * rect.width())) / ((double) (Math.min(((float) view.getHeight()) * view.getScaleY(), (float) screenWithoutStatusBarActionBar.height()) * Math.min(((float) view.getWidth()) * view.getScaleX(), (float) screenWithoutStatusBarActionBar.width())))) * 100.0d)) >= this.areaPercentage && ViewMatchers.withEffectiveVisibility(Visibility.VISIBLE).matches(view);
        }

        private Rect getScreenWithoutStatusBarActionBar(View view) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int identifier = view.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? view.getContext().getResources().getDimensionPixelSize(identifier) : 0;
            TypedValue typedValue = new TypedValue();
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels - (dimensionPixelSize + (view.getContext().getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, view.getContext().getResources().getDisplayMetrics()) : 0)));
        }
    }

    static final class IsEnabledMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private IsEnabledMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is enabled");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.isEnabled();
        }
    }

    static final class IsFocusableMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private IsFocusableMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is focusable");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.isFocusable();
        }
    }

    static final class HasFocusMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private HasFocusMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has focus on the screen to the user");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.hasFocus();
        }
    }

    static final class IsSelectedMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private IsSelectedMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is selected");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.isSelected();
        }
    }

    static final class HasSiblingMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<View> siblingMatcher;

        @RemoteMsgConstructor
        private HasSiblingMatcher(final Matcher<View> siblingMatcher) {
            this.siblingMatcher = siblingMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has sibling: ");
            this.siblingMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (this.siblingMatcher.matches(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    static final class WithContentDescriptionFromIdMatcher extends TypeSafeMatcher<View> {
        private String expectedText;

        @RemoteMsgField(order = 0)
        private final int resourceId;
        private String resourceName;

        @RemoteMsgConstructor
        private WithContentDescriptionFromIdMatcher(final int resourceId) {
            this.resourceName = null;
            this.expectedText = null;
            this.resourceId = resourceId;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with content description from resource id: ");
            description.appendValue(Integer.valueOf(this.resourceId));
            if (this.resourceName != null) {
                description.appendText("[");
                description.appendText(this.resourceName);
                description.appendText("]");
            }
            if (this.expectedText != null) {
                description.appendText(" value: ");
                description.appendText(this.expectedText);
            }
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            if (this.expectedText == null) {
                try {
                    this.expectedText = view.getResources().getString(this.resourceId);
                    this.resourceName = view.getResources().getResourceEntryName(this.resourceId);
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (this.expectedText == null || view.getContentDescription() == null) {
                return false;
            }
            return this.expectedText.equals(view.getContentDescription().toString());
        }
    }

    static final class WithContentDescriptionMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<? extends CharSequence> charSequenceMatcher;

        @RemoteMsgConstructor
        private WithContentDescriptionMatcher(Matcher<? extends CharSequence> charSequenceMatcher) {
            this.charSequenceMatcher = charSequenceMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with content description: ");
            this.charSequenceMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return this.charSequenceMatcher.matches(view.getContentDescription());
        }
    }

    static final class WithContentDescriptionTextMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<String> textMatcher;

        @RemoteMsgConstructor
        private WithContentDescriptionTextMatcher(Matcher<String> textMatcher) {
            this.textMatcher = textMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with content description text: ");
            this.textMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return this.textMatcher.matches(view.getContentDescription() != null ? view.getContentDescription().toString() : null);
        }
    }

    static final class WithTagValueMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<Object> tagValueMatcher;

        @RemoteMsgConstructor
        private WithTagValueMatcher(Matcher<Object> tagValueMatcher) {
            this.tagValueMatcher = tagValueMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with tag value: ");
            this.tagValueMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return this.tagValueMatcher.matches(view.getTag());
        }
    }

    static final class WithCharSequenceMatcher extends BoundedMatcher<View, TextView> {
        private String expectedText;

        @RemoteMsgField(order = 1)
        private final TextViewMethod method;

        @RemoteMsgField(order = 0)
        private final int resourceId;
        private String resourceName;

        private enum TextViewMethod {
            GET_TEXT,
            GET_HINT
        }

        @RemoteMsgConstructor
        private WithCharSequenceMatcher(int resourceId, TextViewMethod method) {
            super(TextView.class);
            this.resourceId = resourceId;
            this.method = method;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with string from resource id: ").appendValue(Integer.valueOf(this.resourceId));
            if (this.resourceName != null) {
                description.appendText("[").appendText(this.resourceName).appendText("]");
            }
            if (this.expectedText != null) {
                description.appendText(" value: ").appendText(this.expectedText);
            }
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(TextView textView) {
            CharSequence text;
            if (this.expectedText == null) {
                try {
                    this.expectedText = textView.getResources().getString(this.resourceId);
                    this.resourceName = textView.getResources().getResourceEntryName(this.resourceId);
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i = AnonymousClass2.$SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod[this.method.ordinal()];
            if (i == 1) {
                text = textView.getText();
            } else if (i == 2) {
                text = textView.getHint();
            } else {
                String strValueOf = String.valueOf(this.method.toString());
                throw new IllegalStateException(strValueOf.length() != 0 ? "Unexpected TextView method: ".concat(strValueOf) : new String("Unexpected TextView method: "));
            }
            String str = this.expectedText;
            return (str == null || text == null || !str.equals(text.toString())) ? false : true;
        }
    }

    /* JADX INFO: renamed from: androidx.test.espresso.matcher.ViewMatchers$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod;

        static {
            int[] iArr = new int[WithCharSequenceMatcher.TextViewMethod.values().length];
            $SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod = iArr;
            try {
                iArr[WithCharSequenceMatcher.TextViewMethod.GET_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$espresso$matcher$ViewMatchers$WithCharSequenceMatcher$TextViewMethod[WithCharSequenceMatcher.TextViewMethod.GET_HINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static final class WithHintMatcher extends BoundedMatcher<View, TextView> {

        @RemoteMsgField(order = 0)
        private final Matcher<String> stringMatcher;

        @RemoteMsgConstructor
        private WithHintMatcher(Matcher<String> stringMatcher) {
            super(TextView.class);
            this.stringMatcher = stringMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with hint: ");
            this.stringMatcher.describeTo(description);
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(TextView textView) {
            return this.stringMatcher.matches(textView.getHint());
        }
    }

    static final class WithCheckBoxStateMatcher<E extends View & Checkable> extends BoundedMatcher<View, E> {

        @RemoteMsgField(order = 0)
        private final Matcher<Boolean> checkStateMatcher;

        @RemoteMsgConstructor
        private WithCheckBoxStateMatcher(Matcher<Boolean> checkStateMatcher) {
            super(View.class, Checkable.class, new Class[0]);
            this.checkStateMatcher = checkStateMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with checkbox state: ");
            this.checkStateMatcher.describeTo(description);
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(E checkable) {
            return this.checkStateMatcher.matches(Boolean.valueOf(checkable.isChecked()));
        }
    }

    static final class HasContentDescriptionMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private HasContentDescriptionMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has content description");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.getContentDescription() != null;
        }
    }

    static final class HasDescendantMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<View> descendantMatcher;

        @RemoteMsgConstructor
        private HasDescendantMatcher(Matcher<View> descendantMatcher) {
            this.descendantMatcher = descendantMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has descendant: ");
            this.descendantMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(final View view) {
            return Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), new Predicate<View>() { // from class: androidx.test.espresso.matcher.ViewMatchers.HasDescendantMatcher.1
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
                public boolean apply(View input) {
                    return input != view && HasDescendantMatcher.this.descendantMatcher.matches(input);
                }
            }).iterator().hasNext();
        }
    }

    static final class IsClickableMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private IsClickableMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is clickable");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.isClickable();
        }
    }

    static final class IsDescendantOfAMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<View> ancestorMatcher;

        @RemoteMsgConstructor
        private IsDescendantOfAMatcher(Matcher<View> ancestorMatcher) {
            this.ancestorMatcher = ancestorMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is descendant of a: ");
            this.ancestorMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return checkAncestors(view.getParent(), this.ancestorMatcher);
        }

        private boolean checkAncestors(ViewParent viewParent, Matcher<View> ancestorMatcher) {
            if (!(viewParent instanceof View)) {
                return false;
            }
            if (ancestorMatcher.matches(viewParent)) {
                return true;
            }
            return checkAncestors(viewParent.getParent(), ancestorMatcher);
        }
    }

    static final class WithEffectiveVisibilityMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Visibility visibility;

        @RemoteMsgConstructor
        private WithEffectiveVisibilityMatcher(Visibility visibility) {
            this.visibility = visibility;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText(String.format(Locale.ROOT, "view has effective visibility=%s", this.visibility));
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            if (this.visibility.getValue() == 0) {
                if (view.getVisibility() != this.visibility.getValue()) {
                    return false;
                }
                while (view.getParent() != null && (view.getParent() instanceof View)) {
                    view = (View) view.getParent();
                    if (view.getVisibility() != this.visibility.getValue()) {
                        return false;
                    }
                }
                return true;
            }
            if (view.getVisibility() == this.visibility.getValue()) {
                return true;
            }
            while (view.getParent() != null && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
                if (view.getVisibility() == this.visibility.getValue()) {
                    return true;
                }
            }
            return false;
        }
    }

    public static Matcher<View> hasBackground(final int drawableId) {
        return new HasBackgroundMatcher(drawableId);
    }

    public static Matcher<View> hasTextColor(final int colorResId) {
        return new BoundedMatcher<View, TextView>(TextView.class) { // from class: androidx.test.espresso.matcher.ViewMatchers.1
            private Context context;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.test.espresso.matcher.BoundedMatcher
            public boolean matchesSafely(TextView textView) {
                int color;
                this.context = textView.getContext();
                int currentTextColor = textView.getCurrentTextColor();
                if (Build.VERSION.SDK_INT <= 22) {
                    color = this.context.getResources().getColor(colorResId);
                } else {
                    color = this.context.getColor(colorResId);
                }
                return currentTextColor == color;
            }

            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                String strValueOf = String.valueOf(colorResId);
                Context context = this.context;
                if (context != null) {
                    strValueOf = context.getResources().getResourceName(colorResId);
                }
                String strValueOf2 = String.valueOf(strValueOf);
                description.appendText(strValueOf2.length() != 0 ? "has color with ID ".concat(strValueOf2) : new String("has color with ID "));
            }
        };
    }

    static final class WithAlphaMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final float alpha;

        @RemoteMsgConstructor
        private WithAlphaMatcher(final float alpha) {
            this.alpha = alpha;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has alpha: ").appendValue(Float.valueOf(this.alpha));
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.getAlpha() == this.alpha;
        }
    }

    static final class WithParentMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<View> parentMatcher;

        @RemoteMsgConstructor
        private WithParentMatcher(Matcher<View> parentMatcher) {
            this.parentMatcher = parentMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has parent matching: ");
            this.parentMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return this.parentMatcher.matches(view.getParent());
        }
    }

    static final class WithChildMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<View> childMatcher;

        @RemoteMsgConstructor
        private WithChildMatcher(Matcher<View> childMatcher) {
            this.childMatcher = childMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has child: ");
            this.childMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            if (!(view instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (this.childMatcher.matches(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    static final class HasChildCountMatcher extends BoundedMatcher<View, ViewGroup> {

        @RemoteMsgField(order = 0)
        private final int childCount;

        @RemoteMsgConstructor
        private HasChildCountMatcher(int childCount) {
            super(ViewGroup.class);
            this.childCount = childCount;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has child count: ").appendValue(Integer.valueOf(this.childCount));
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(ViewGroup viewGroup) {
            return viewGroup.getChildCount() == this.childCount;
        }
    }

    static final class HasMinimumChildCountMatcher extends BoundedMatcher<View, ViewGroup> {

        @RemoteMsgField(order = 0)
        private final int minChildCount;

        @RemoteMsgConstructor
        private HasMinimumChildCountMatcher(int minChildCount) {
            super(ViewGroup.class);
            this.minChildCount = minChildCount;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has minimum child count: ").appendValue(Integer.valueOf(this.minChildCount));
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(ViewGroup viewGroup) {
            return viewGroup.getChildCount() >= this.minChildCount;
        }
    }

    static final class IsRootMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private IsRootMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is a root view.");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.getRootView().equals(view);
        }
    }

    static final class SupportsInputMethodsMatcher extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        private SupportsInputMethodsMatcher() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("supports input methods");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.onCreateInputConnection(new EditorInfo()) != null;
        }
    }

    static final class HasImeActionMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final Matcher<Integer> imeActionMatcher;

        @RemoteMsgConstructor
        private HasImeActionMatcher(final Matcher<Integer> imeActionMatcher) {
            this.imeActionMatcher = imeActionMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has ime action: ");
            this.imeActionMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            int i;
            EditorInfo editorInfo = new EditorInfo();
            if (view.onCreateInputConnection(editorInfo) == null) {
                return false;
            }
            if (editorInfo.actionId != 0) {
                i = editorInfo.actionId;
            } else {
                i = editorInfo.imeOptions & 255;
            }
            return this.imeActionMatcher.matches(Integer.valueOf(i));
        }
    }

    static final class HasLinksMatcher extends BoundedMatcher<View, TextView> {
        @RemoteMsgConstructor
        private HasLinksMatcher() {
            super(TextView.class);
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has links");
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(TextView textView) {
            return textView.getUrls().length > 0;
        }
    }

    static final class WithSpinnerTextIdMatcher extends BoundedMatcher<View, Spinner> {
        private String expectedText;

        @RemoteMsgField(order = 0)
        private int resourceId;
        private String resourceName;

        @RemoteMsgConstructor
        private WithSpinnerTextIdMatcher(int resourceId) {
            super(Spinner.class);
            this.resourceName = null;
            this.expectedText = null;
            this.resourceId = resourceId;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with string from resource id: ");
            description.appendValue(Integer.valueOf(this.resourceId));
            if (this.resourceName != null) {
                description.appendText("[");
                description.appendText(this.resourceName);
                description.appendText("]");
            }
            if (this.expectedText != null) {
                description.appendText(" value: ");
                description.appendText(this.expectedText);
            }
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(Spinner spinner) {
            if (this.expectedText == null) {
                try {
                    this.expectedText = spinner.getResources().getString(this.resourceId);
                    this.resourceName = spinner.getResources().getResourceEntryName(this.resourceId);
                } catch (Resources.NotFoundException unused) {
                }
            }
            String str = this.expectedText;
            if (str != null) {
                return str.equals(spinner.getSelectedItem().toString());
            }
            return false;
        }
    }

    static final class WithSpinnerTextMatcher extends BoundedMatcher<View, Spinner> {

        @RemoteMsgField(order = 0)
        private Matcher<String> stringMatcher;

        @RemoteMsgConstructor
        private WithSpinnerTextMatcher(Matcher<String> stringMatcher) {
            super(Spinner.class);
            this.stringMatcher = stringMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with text: ");
            this.stringMatcher.describeTo(description);
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(Spinner spinner) {
            return this.stringMatcher.matches(spinner.getSelectedItem().toString());
        }
    }

    static final class IsJavascriptEnabledMatcher extends BoundedMatcher<View, WebView> {
        @RemoteMsgConstructor
        private IsJavascriptEnabledMatcher() {
            super(WebView.class);
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("WebView with JS enabled");
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(WebView webView) {
            return webView.getSettings().getJavaScriptEnabled();
        }
    }

    static final class HasErrorTextMatcher extends BoundedMatcher<View, EditText> {

        @RemoteMsgField(order = 0)
        private Matcher<String> stringMatcher;

        @RemoteMsgConstructor
        private HasErrorTextMatcher(Matcher<String> stringMatcher) {
            super(EditText.class);
            this.stringMatcher = stringMatcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with error: ");
            this.stringMatcher.describeTo(description);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(EditText view) {
            return this.stringMatcher.matches(view.getError());
        }
    }

    static final class WithInputTypeMatcher extends BoundedMatcher<View, EditText> {

        @RemoteMsgField(order = 0)
        private int inputType;

        @RemoteMsgConstructor
        private WithInputTypeMatcher(int inputType) {
            super(EditText.class);
            this.inputType = inputType;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is view input type equal to: ");
            description.appendText(Integer.toString(this.inputType));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(EditText view) {
            return view.getInputType() == this.inputType;
        }
    }

    static final class WithParentIndexMatcher extends TypeSafeMatcher<View> {

        @RemoteMsgField(order = 0)
        private final int index;

        @RemoteMsgConstructor
        private WithParentIndexMatcher(int index) {
            this.index = index;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            int i = this.index;
            StringBuilder sb = new StringBuilder(30);
            sb.append("with parent index: ");
            sb.append(i);
            description.appendText(sb.toString());
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                int childCount = viewGroup.getChildCount();
                int i = this.index;
                if (childCount > i && viewGroup.getChildAt(i) == view) {
                    return true;
                }
            }
            return false;
        }
    }
}
