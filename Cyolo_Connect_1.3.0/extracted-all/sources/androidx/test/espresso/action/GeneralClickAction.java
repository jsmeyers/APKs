package androidx.test.espresso.action;

import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.Tapper;
import androidx.test.espresso.core.internal.deps.guava.base.Optional;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import java.util.Locale;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* JADX INFO: loaded from: classes.dex */
public final class GeneralClickAction implements ViewAction {
    private static final String TAG = "GeneralClickAction";
    private final int buttonState;
    final CoordinatesProvider coordinatesProvider;
    private final int inputDevice;
    final PrecisionDescriber precisionDescriber;
    private final Optional<ViewAction> rollbackAction;
    final Tapper tapper;

    @Deprecated
    public GeneralClickAction(Tapper tapper, CoordinatesProvider coordinatesProvider, PrecisionDescriber precisionDescriber) {
        this(tapper, coordinatesProvider, precisionDescriber, 0, 0, null);
    }

    public GeneralClickAction(Tapper tapper, CoordinatesProvider coordinatesProvider, PrecisionDescriber precisionDescriber, int inputDevice, int buttonState) {
        this(tapper, coordinatesProvider, precisionDescriber, inputDevice, buttonState, null);
    }

    @Deprecated
    public GeneralClickAction(Tapper tapper, CoordinatesProvider coordinatesProvider, PrecisionDescriber precisionDescriber, ViewAction rollbackAction) {
        this(tapper, coordinatesProvider, precisionDescriber, 0, 0, rollbackAction);
    }

    public GeneralClickAction(Tapper tapper, CoordinatesProvider coordinatesProvider, PrecisionDescriber precisionDescriber, int inputDevice, int buttonState, ViewAction rollbackAction) {
        this.coordinatesProvider = coordinatesProvider;
        this.tapper = tapper;
        this.precisionDescriber = precisionDescriber;
        this.inputDevice = inputDevice;
        this.buttonState = buttonState;
        this.rollbackAction = Optional.fromNullable(rollbackAction);
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        Matcher<View> matcherIsDisplayingAtLeast = ViewMatchers.isDisplayingAtLeast(90);
        return this.rollbackAction.isPresent() ? Matchers.allOf(matcherIsDisplayingAtLeast, this.rollbackAction.get().getConstraints()) : matcherIsDisplayingAtLeast;
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        char c;
        float[] fArrCalculateCoordinates = this.coordinatesProvider.calculateCoordinates(view);
        float[] fArrDescribePrecision = this.precisionDescriber.describePrecision();
        Tapper.Status statusSendTap = Tapper.Status.FAILURE;
        int i = 0;
        while (true) {
            if (statusSendTap == Tapper.Status.SUCCESS || i >= 3) {
                c = 3;
                break;
            }
            try {
                c = 3;
            } catch (RuntimeException e) {
                e = e;
                c = 3;
            }
            try {
                statusSendTap = this.tapper.sendTap(uiController, fArrCalculateCoordinates, fArrDescribePrecision, this.inputDevice, this.buttonState);
                if (Log.isLoggable(TAG, 3)) {
                    String strValueOf = String.valueOf(String.format(Locale.ROOT, "%s - At Coordinates: %d, %d and precision: %d, %d", getDescription(), Integer.valueOf((int) fArrCalculateCoordinates[0]), Integer.valueOf((int) fArrCalculateCoordinates[1]), Integer.valueOf((int) fArrDescribePrecision[0]), Integer.valueOf((int) fArrDescribePrecision[1])));
                    Log.d(TAG, strValueOf.length() != 0 ? "perform: ".concat(strValueOf) : new String("perform: "));
                }
                int pressedStateDuration = ViewConfiguration.getPressedStateDuration();
                if (pressedStateDuration > 0) {
                    uiController.loopMainThreadForAtLeast(pressedStateDuration);
                }
                if (statusSendTap == Tapper.Status.WARNING) {
                    if (!this.rollbackAction.isPresent()) {
                        break;
                    } else {
                        this.rollbackAction.get().perform(uiController, view);
                    }
                }
                i++;
            } catch (RuntimeException e2) {
                e = e2;
                PerformException.Builder builder = new PerformException.Builder();
                Locale locale = Locale.ROOT;
                Object[] objArr = new Object[5];
                objArr[0] = getDescription();
                objArr[1] = Integer.valueOf((int) fArrCalculateCoordinates[0]);
                objArr[2] = Integer.valueOf((int) fArrCalculateCoordinates[1]);
                objArr[c] = Integer.valueOf((int) fArrDescribePrecision[0]);
                objArr[4] = Integer.valueOf((int) fArrDescribePrecision[1]);
                throw builder.withActionDescription(String.format(locale, "%s - At Coordinates: %d, %d and precision: %d, %d", objArr)).withViewDescription(HumanReadables.describe(view)).withCause(e).build();
            }
        }
        if (statusSendTap == Tapper.Status.FAILURE) {
            PerformException.Builder builderWithViewDescription = new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view));
            Locale locale2 = Locale.ROOT;
            Object[] objArr2 = new Object[9];
            objArr2[0] = Float.valueOf(fArrCalculateCoordinates[0]);
            objArr2[1] = Float.valueOf(fArrCalculateCoordinates[1]);
            objArr2[2] = Float.valueOf(fArrDescribePrecision[0]);
            objArr2[c] = Float.valueOf(fArrDescribePrecision[1]);
            objArr2[4] = this.tapper;
            objArr2[5] = this.coordinatesProvider;
            objArr2[6] = this.precisionDescriber;
            objArr2[7] = Integer.valueOf(i);
            objArr2[8] = Boolean.valueOf(this.rollbackAction.isPresent());
            throw builderWithViewDescription.withCause(new RuntimeException(String.format(locale2, "Couldn't click at: %s,%s precision: %s, %s . Tapper: %s coordinate provider: %s precision describer: %s. Tried %s times. With Rollback? %s", objArr2))).build();
        }
        if (this.tapper == Tap.SINGLE && (view instanceof WebView)) {
            uiController.loopMainThreadForAtLeast(ViewConfiguration.getDoubleTapTimeout());
        }
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return String.valueOf(this.tapper.toString().toLowerCase()).concat(" click");
    }
}
