package androidx.test.espresso.action;

import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.test.espresso.UiController;
import androidx.test.espresso.action.MotionEvents;
import androidx.test.espresso.action.Tapper;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.lang.reflect.InvocationTargetException;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SINGLE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public abstract class Tap implements Tapper {
    private static final /* synthetic */ Tap[] $VALUES;
    public static final Tap DOUBLE;
    private static final int DOUBLE_TAP_MIN_TIMEOUT;
    public static final Tap LONG;
    public static final Tap SINGLE;
    private static final String TAG;

    private Tap(String $enum$name, int $enum$ordinal) {
    }

    public static Tap valueOf(String name) {
        return (Tap) Enum.valueOf(Tap.class, name);
    }

    public static Tap[] values() {
        return (Tap[]) $VALUES.clone();
    }

    static {
        int iIntValue = 0;
        Tap tap = new Tap("SINGLE", iIntValue) { // from class: androidx.test.espresso.action.Tap.1
            @Override // androidx.test.espresso.action.Tapper
            public Tapper.Status sendTap(UiController uiController, float[] coordinates, float[] precision) {
                return sendTap(uiController, coordinates, precision, 0, 0);
            }

            @Override // androidx.test.espresso.action.Tapper
            public Tapper.Status sendTap(UiController uiController, float[] coordinates, float[] precision, int inputDevice, int buttonState) {
                Tapper.Status statusSendSingleTap = Tap.sendSingleTap(uiController, coordinates, precision, inputDevice, buttonState);
                if (Tapper.Status.SUCCESS == statusSendSingleTap) {
                    uiController.loopMainThreadForAtLeast((long) (ViewConfiguration.getTapTimeout() * 1.5f));
                }
                return statusSendSingleTap;
            }
        };
        SINGLE = tap;
        Tap tap2 = new Tap("LONG", 1) { // from class: androidx.test.espresso.action.Tap.2
            @Override // androidx.test.espresso.action.Tapper
            public Tapper.Status sendTap(UiController uiController, float[] coordinates, float[] precision) {
                return sendTap(uiController, coordinates, precision, 0, 0);
            }

            @Override // androidx.test.espresso.action.Tapper
            public Tapper.Status sendTap(UiController uiController, float[] coordinates, float[] precision, int inputDevice, int buttonState) {
                Preconditions.checkNotNull(uiController);
                Preconditions.checkNotNull(coordinates);
                Preconditions.checkNotNull(precision);
                MotionEvent motionEvent = MotionEvents.sendDown(uiController, coordinates, precision, inputDevice, buttonState).down;
                try {
                    uiController.loopMainThreadForAtLeast((long) (ViewConfiguration.getLongPressTimeout() * 1.5f));
                    if (!MotionEvents.sendUp(uiController, motionEvent)) {
                        MotionEvents.sendCancel(uiController, motionEvent);
                        return Tapper.Status.FAILURE;
                    }
                    return Tapper.Status.SUCCESS;
                } finally {
                    motionEvent.recycle();
                }
            }
        };
        LONG = tap2;
        Tap tap3 = new Tap("DOUBLE", 2) { // from class: androidx.test.espresso.action.Tap.3
            @Override // androidx.test.espresso.action.Tapper
            public Tapper.Status sendTap(UiController uiController, float[] coordinates, float[] precision) {
                return sendTap(uiController, coordinates, precision, 0, 0);
            }

            @Override // androidx.test.espresso.action.Tapper
            public Tapper.Status sendTap(UiController uiController, float[] coordinates, float[] precision, int inputDevice, int buttonState) {
                Preconditions.checkNotNull(uiController);
                Preconditions.checkNotNull(coordinates);
                Preconditions.checkNotNull(precision);
                Tapper.Status statusSendSingleTap = Tap.sendSingleTap(uiController, coordinates, precision, inputDevice, buttonState);
                if (statusSendSingleTap != Tapper.Status.FAILURE) {
                    if (Tap.DOUBLE_TAP_MIN_TIMEOUT > 0) {
                        uiController.loopMainThreadForAtLeast(Tap.DOUBLE_TAP_MIN_TIMEOUT);
                    }
                    Tapper.Status statusSendSingleTap2 = Tap.sendSingleTap(uiController, coordinates, precision, inputDevice, buttonState);
                    if (statusSendSingleTap2 == Tapper.Status.FAILURE) {
                        return Tapper.Status.FAILURE;
                    }
                    if (statusSendSingleTap2 == Tapper.Status.WARNING || statusSendSingleTap == Tapper.Status.WARNING) {
                        return Tapper.Status.WARNING;
                    }
                    return Tapper.Status.SUCCESS;
                }
                return Tapper.Status.FAILURE;
            }
        };
        DOUBLE = tap3;
        $VALUES = new Tap[]{tap, tap2, tap3};
        TAG = "Tap";
        try {
            iIntValue = ((Integer) ViewConfiguration.class.getDeclaredMethod("getDoubleTapMinTime", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.w(TAG, "Unable to query double tap min time!", e);
        } catch (NoSuchMethodException e2) {
            Log.w(TAG, "Expected to find getDoubleTapMinTime", e2);
        } catch (InvocationTargetException e3) {
            Log.w(TAG, "Unable to query double tap min time!", e3);
        }
        DOUBLE_TAP_MIN_TIMEOUT = iIntValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Tapper.Status sendSingleTap(UiController uiController, float[] coordinates, float[] precision, int inputDevice, int buttonState) {
        Preconditions.checkNotNull(uiController);
        Preconditions.checkNotNull(coordinates);
        Preconditions.checkNotNull(precision);
        MotionEvents.DownResultHolder downResultHolderSendDown = MotionEvents.sendDown(uiController, coordinates, precision, inputDevice, buttonState);
        try {
            if (MotionEvents.sendUp(uiController, downResultHolderSendDown.down)) {
                downResultHolderSendDown.down.recycle();
                return downResultHolderSendDown.longPress ? Tapper.Status.WARNING : Tapper.Status.SUCCESS;
            }
            Log.d(TAG, "Injection of up event as part of the click failed. Send cancel event.");
            MotionEvents.sendCancel(uiController, downResultHolderSendDown.down);
            Tapper.Status status = Tapper.Status.FAILURE;
            downResultHolderSendDown.down.recycle();
            return status;
        } catch (Throwable th) {
            downResultHolderSendDown.down.recycle();
            throw th;
        }
    }
}
