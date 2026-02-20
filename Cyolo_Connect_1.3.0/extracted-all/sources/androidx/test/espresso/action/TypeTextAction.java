package androidx.test.espresso.action;

import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.remote.annotation.RemoteMsgField;
import androidx.test.espresso.util.HumanReadables;
import java.util.Locale;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* JADX INFO: loaded from: classes.dex */
public final class TypeTextAction implements ViewAction {
    private static final String TAG = "TypeTextAction";

    @RemoteMsgField(order = 0)
    final String stringToBeTyped;

    @RemoteMsgField(order = 1)
    final boolean tapToFocus;

    public TypeTextAction(String stringToBeTyped) {
        this(stringToBeTyped, true);
    }

    @RemoteMsgConstructor
    public TypeTextAction(String stringToBeTyped, boolean tapToFocus) {
        Preconditions.checkNotNull(stringToBeTyped);
        this.stringToBeTyped = stringToBeTyped;
        this.tapToFocus = tapToFocus;
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        Matcher matcherAllOf = Matchers.allOf(ViewMatchers.isDisplayed());
        if (!this.tapToFocus) {
            matcherAllOf = Matchers.allOf(matcherAllOf, ViewMatchers.hasFocus());
        }
        return Matchers.allOf(matcherAllOf, Matchers.anyOf(ViewMatchers.supportsInputMethods(), ViewMatchers.isAssignableFrom(SearchView.class)));
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        if (this.stringToBeTyped.length() == 0) {
            Log.w(TAG, "Supplied string is empty resulting in no-op (nothing is typed).");
            return;
        }
        if (this.tapToFocus) {
            new GeneralClickAction(Tap.SINGLE, GeneralLocation.CENTER, Press.FINGER).perform(uiController, view);
            uiController.loopMainThreadUntilIdle();
        }
        try {
            if (uiController.injectString(this.stringToBeTyped)) {
                return;
            }
            String str = TAG;
            String strValueOf = String.valueOf(this.stringToBeTyped);
            Log.e(str, strValueOf.length() != 0 ? "Failed to type text: ".concat(strValueOf) : new String("Failed to type text: "));
            PerformException.Builder builderWithViewDescription = new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view));
            String strValueOf2 = String.valueOf(this.stringToBeTyped);
            throw builderWithViewDescription.withCause(new RuntimeException(strValueOf2.length() != 0 ? "Failed to type text: ".concat(strValueOf2) : new String("Failed to type text: "))).build();
        } catch (InjectEventSecurityException e) {
            String str2 = TAG;
            String strValueOf3 = String.valueOf(this.stringToBeTyped);
            Log.e(str2, strValueOf3.length() != 0 ? "Failed to type text: ".concat(strValueOf3) : new String("Failed to type text: "));
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(e).build();
        }
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return String.format(Locale.ROOT, "type text(%s)", this.stringToBeTyped);
    }
}
