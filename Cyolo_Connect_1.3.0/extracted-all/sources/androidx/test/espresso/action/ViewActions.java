package androidx.test.espresso.action;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.EspressoKey;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* JADX INFO: loaded from: classes.dex */
public final class ViewActions {
    private static final float EDGE_FUZZ_FACTOR = 0.083f;
    private static Set<Pair<String, ViewAssertion>> globalAssertions = new CopyOnWriteArraySet();

    private ViewActions() {
    }

    public static void addGlobalAssertion(String name, ViewAssertion viewAssertion) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(viewAssertion);
        Pair<String, ViewAssertion> pair = new Pair<>(name, viewAssertion);
        Preconditions.checkArgument(!globalAssertions.contains(pair), "ViewAssertion with name %s is already in the global assertions!", name);
        globalAssertions.add(pair);
    }

    public static void removeGlobalAssertion(ViewAssertion viewAssertion) {
        Iterator<Pair<String, ViewAssertion>> it = globalAssertions.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (it.hasNext()) {
                    Pair<String, ViewAssertion> next = it.next();
                    if (viewAssertion != null && viewAssertion.equals(next.second)) {
                        if (z || globalAssertions.remove(next)) {
                            z = true;
                        }
                    }
                } else {
                    Preconditions.checkArgument(z, "ViewAssertion was not in global assertions!");
                    return;
                }
            }
        }
    }

    public static void clearGlobalAssertions() {
        globalAssertions.clear();
    }

    public static ViewAction actionWithAssertions(final ViewAction viewAction) {
        return globalAssertions.isEmpty() ? viewAction : new ViewAction() { // from class: androidx.test.espresso.action.ViewActions.1
            @Override // androidx.test.espresso.ViewAction
            public String getDescription() {
                StringBuilder sb = new StringBuilder("Running view assertions[");
                Iterator it = ViewActions.globalAssertions.iterator();
                while (it.hasNext()) {
                    sb.append((String) ((Pair) it.next()).first);
                    sb.append(", ");
                }
                sb.append("] and then running: ");
                sb.append(viewAction.getDescription());
                return sb.toString();
            }

            @Override // androidx.test.espresso.ViewAction
            public Matcher<View> getConstraints() {
                return viewAction.getConstraints();
            }

            @Override // androidx.test.espresso.ViewAction
            public void perform(UiController uic, View view) {
                for (Pair pair : ViewActions.globalAssertions) {
                    String strValueOf = String.valueOf((String) pair.first);
                    Log.i("ViewAssertion", strValueOf.length() != 0 ? "Asserting ".concat(strValueOf) : new String("Asserting "));
                    ((ViewAssertion) pair.second).check(view, null);
                }
                viewAction.perform(uic, view);
            }
        };
    }

    public static ViewAction clearText() {
        return actionWithAssertions(new ReplaceTextAction(""));
    }

    public static ViewAction click(int inputDevice, int buttonState) {
        return actionWithAssertions(new GeneralClickAction(Tap.SINGLE, GeneralLocation.VISIBLE_CENTER, Press.FINGER, inputDevice, buttonState));
    }

    public static ViewAction click() {
        return actionWithAssertions(new GeneralClickAction(Tap.SINGLE, GeneralLocation.VISIBLE_CENTER, Press.FINGER, 0, 1));
    }

    public static ViewAction click(ViewAction rollbackAction) {
        Preconditions.checkNotNull(rollbackAction);
        return actionWithAssertions(new GeneralClickAction(Tap.SINGLE, GeneralLocation.CENTER, Press.FINGER, 0, 1, rollbackAction));
    }

    public static ViewAction swipeLeft() {
        return actionWithAssertions(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.translate(GeneralLocation.CENTER_RIGHT, -0.083f, 0.0f), GeneralLocation.CENTER_LEFT, Press.FINGER));
    }

    public static ViewAction swipeRight() {
        return actionWithAssertions(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.translate(GeneralLocation.CENTER_LEFT, EDGE_FUZZ_FACTOR, 0.0f), GeneralLocation.CENTER_RIGHT, Press.FINGER));
    }

    public static ViewAction swipeDown() {
        return actionWithAssertions(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.translate(GeneralLocation.TOP_CENTER, 0.0f, EDGE_FUZZ_FACTOR), GeneralLocation.BOTTOM_CENTER, Press.FINGER));
    }

    public static ViewAction swipeUp() {
        return actionWithAssertions(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.translate(GeneralLocation.BOTTOM_CENTER, 0.0f, -0.083f), GeneralLocation.TOP_CENTER, Press.FINGER));
    }

    public static ViewAction closeSoftKeyboard() {
        return actionWithAssertions(new CloseKeyboardAction());
    }

    public static ViewAction pressImeActionButton() {
        return actionWithAssertions(new EditorAction());
    }

    public static ViewAction pressBack() {
        return actionWithAssertions(new PressBackAction(true));
    }

    public static ViewAction pressBackUnconditionally() {
        return actionWithAssertions(new PressBackAction(false));
    }

    public static ViewAction pressMenuKey() {
        return pressKey(82);
    }

    public static ViewAction pressKey(int keyCode) {
        return actionWithAssertions(new KeyEventAction(new EspressoKey.Builder().withKeyCode(keyCode).build()));
    }

    public static ViewAction pressKey(EspressoKey key) {
        return actionWithAssertions(new KeyEventAction(key));
    }

    public static ViewAction doubleClick() {
        return actionWithAssertions(new GeneralClickAction(Tap.DOUBLE, GeneralLocation.CENTER, Press.FINGER, 0, 1));
    }

    public static ViewAction longClick() {
        return actionWithAssertions(new GeneralClickAction(Tap.LONG, GeneralLocation.CENTER, Press.FINGER, 0, 1));
    }

    public static ViewAction scrollTo() {
        return actionWithAssertions(new ScrollToAction());
    }

    public static ViewAction typeTextIntoFocusedView(String stringToBeTyped) {
        return actionWithAssertions(new TypeTextAction(stringToBeTyped, false));
    }

    public static ViewAction typeText(String stringToBeTyped) {
        return actionWithAssertions(new TypeTextAction(stringToBeTyped));
    }

    public static ViewAction replaceText(String stringToBeSet) {
        return actionWithAssertions(new ReplaceTextAction(stringToBeSet));
    }

    public static ViewAction openLinkWithText(String linkText) {
        return openLinkWithText((Matcher<String>) Matchers.is(linkText));
    }

    public static ViewAction openLinkWithText(Matcher<String> linkTextMatcher) {
        return openLink(linkTextMatcher, Matchers.any(Uri.class));
    }

    public static ViewAction openLinkWithUri(String uri) {
        return openLinkWithUri((Matcher<Uri>) Matchers.is(Uri.parse(uri)));
    }

    public static ViewAction openLinkWithUri(Matcher<Uri> uriMatcher) {
        return openLink(Matchers.any(String.class), uriMatcher);
    }

    public static ViewAction openLink(Matcher<String> linkTextMatcher, Matcher<Uri> uriMatcher) {
        Preconditions.checkNotNull(linkTextMatcher);
        Preconditions.checkNotNull(uriMatcher);
        return actionWithAssertions(new OpenLinkAction(linkTextMatcher, uriMatcher));
    }

    public static ViewAction repeatedlyUntil(final ViewAction action, final Matcher<View> desiredStateMatcher, final int maxAttempts) {
        Preconditions.checkNotNull(action);
        Preconditions.checkNotNull(desiredStateMatcher);
        return actionWithAssertions(new RepeatActionUntilViewState(action, desiredStateMatcher, maxAttempts));
    }
}
