package androidx.test.espresso.action;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.os.EnvironmentCompat;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class MotionEvents {
    static final int MAX_CLICK_ATTEMPTS = 3;
    private static final String TAG = "MotionEvents";

    private MotionEvents() {
    }

    public static DownResultHolder sendDown(UiController uiController, float[] coordinates, float[] precision) {
        return sendDown(uiController, coordinates, precision, 0, 1);
    }

    public static MotionEvent obtainDownEvent(float[] coordinates, float[] precision, int inputDevice, int buttonState) {
        Preconditions.checkNotNull(coordinates);
        Preconditions.checkNotNull(precision);
        return downPressICS(SystemClock.uptimeMillis(), coordinates, precision, inputDevice, buttonState);
    }

    public static MotionEvent obtainDownEvent(float[] coordinates, float[] precision) {
        return obtainDownEvent(coordinates, precision, 0, 1);
    }

    public static DownResultHolder sendDown(UiController uiController, float[] coordinates, float[] precision, int inputDevice, int buttonState) {
        Preconditions.checkNotNull(uiController);
        Preconditions.checkNotNull(coordinates);
        Preconditions.checkNotNull(precision);
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < 3) {
                try {
                    MotionEvent motionEventObtainDownEvent = obtainDownEvent(coordinates, precision, inputDevice, buttonState);
                    long downTime = motionEventObtainDownEvent.getDownTime();
                    long tapTimeout = ((long) (ViewConfiguration.getTapTimeout() / 2)) + downTime;
                    boolean zInjectMotionEvent = uiController.injectMotionEvent(motionEventObtainDownEvent);
                    while (true) {
                        long jUptimeMillis = tapTimeout - SystemClock.uptimeMillis();
                        if (jUptimeMillis <= 10) {
                            break;
                        }
                        uiController.loopMainThreadForAtLeast(jUptimeMillis / 4);
                    }
                    if (SystemClock.uptimeMillis() > downTime + ((long) ViewConfiguration.getLongPressTimeout())) {
                        Log.w(TAG, "Overslept and turned a tap into a long press");
                    } else {
                        z = false;
                    }
                    if (!zInjectMotionEvent) {
                        motionEventObtainDownEvent.recycle();
                        i++;
                    } else {
                        return new DownResultHolder(motionEventObtainDownEvent, z);
                    }
                } catch (InjectEventSecurityException e) {
                    throw new PerformException.Builder().withActionDescription("Send down motion event").withViewDescription(EnvironmentCompat.MEDIA_UNKNOWN).withCause(e).build();
                }
            } else {
                throw new PerformException.Builder().withActionDescription(String.format(Locale.ROOT, "click (after %s attempts)", 3)).withViewDescription(EnvironmentCompat.MEDIA_UNKNOWN).build();
            }
        }
    }

    public static boolean sendUp(UiController uiController, MotionEvent downEvent) {
        return sendUp(uiController, downEvent, new float[]{downEvent.getX(), downEvent.getY()});
    }

    public static MotionEvent obtainUpEvent(MotionEvent downEvent, float[] coordinates) {
        Preconditions.checkNotNull(downEvent);
        Preconditions.checkNotNull(coordinates);
        return upPressICS(downEvent, coordinates);
    }

    public static boolean sendUp(UiController uiController, MotionEvent downEvent, float[] coordinates) {
        Preconditions.checkNotNull(uiController);
        Preconditions.checkNotNull(downEvent);
        Preconditions.checkNotNull(coordinates);
        MotionEvent motionEventObtainUpEvent = null;
        try {
            try {
                motionEventObtainUpEvent = obtainUpEvent(downEvent, coordinates);
                if (uiController.injectMotionEvent(motionEventObtainUpEvent)) {
                    if (motionEventObtainUpEvent != null) {
                        motionEventObtainUpEvent.recycle();
                    }
                    return true;
                }
                Log.e(TAG, String.format(Locale.ROOT, "Injection of up event failed (corresponding down event: %s)", downEvent));
                if (motionEventObtainUpEvent != null) {
                    motionEventObtainUpEvent.recycle();
                }
                return false;
            } catch (InjectEventSecurityException e) {
                throw new PerformException.Builder().withActionDescription(String.format(Locale.ROOT, "inject up event (corresponding down event: %s)", downEvent)).withViewDescription(EnvironmentCompat.MEDIA_UNKNOWN).withCause(e).build();
            }
        } catch (Throwable th) {
            if (motionEventObtainUpEvent != null) {
                motionEventObtainUpEvent.recycle();
            }
            throw th;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:43:0x006b  */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "start" is null
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1223)
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1217)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.cutHandlerBlocks(MarkFinallyVisitor.java:249)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:123)
     */
    public static void sendCancel(UiController uiController, MotionEvent downEvent) {
        Preconditions.checkNotNull(uiController);
        Preconditions.checkNotNull(downEvent);
        MotionEvent motionEventObtain = null;
        try {
            try {
                motionEventObtain = MotionEvent.obtain(downEvent.getDownTime(), SystemClock.uptimeMillis(), 3, downEvent.getX(), downEvent.getY(), 0);
                if (uiController.injectMotionEvent(motionEventObtain)) {
                    if (motionEventObtain != null) {
                        motionEventObtain.recycle();
                        return;
                    }
                    return;
                } else {
                    Log.e(TAG, String.format(Locale.ROOT, "Injection of cancel event failed (corresponding down event: %s)", downEvent));
                    if (motionEventObtain != null) {
                        motionEventObtain.recycle();
                        return;
                    }
                    return;
                }
            } catch (InjectEventSecurityException e) {
                throw new PerformException.Builder().withActionDescription(String.format(Locale.ROOT, "inject cancel event (corresponding down event: %s)", downEvent)).withViewDescription(EnvironmentCompat.MEDIA_UNKNOWN).withCause(e).build();
            }
        } catch (Throwable th) {
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            throw th;
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        throw th;
    }

    public static MotionEvent obtainMovement(long downTime, float[] coordinates) {
        return MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), 2, coordinates[0], coordinates[1], 0);
    }

    public static MotionEvent obtainMovement(long downTime, long eventTime, float[] coordinates) {
        return MotionEvent.obtain(downTime, eventTime, 2, coordinates[0], coordinates[1], 0);
    }

    public static boolean sendMovement(UiController uiController, MotionEvent downEvent, float[] coordinates) {
        Preconditions.checkNotNull(uiController);
        Preconditions.checkNotNull(downEvent);
        Preconditions.checkNotNull(coordinates);
        MotionEvent motionEventObtainMovement = null;
        try {
            try {
                motionEventObtainMovement = obtainMovement(downEvent.getDownTime(), coordinates);
                if (uiController.injectMotionEvent(motionEventObtainMovement)) {
                    if (motionEventObtainMovement != null) {
                        motionEventObtainMovement.recycle();
                    }
                    return true;
                }
                Log.e(TAG, String.format(Locale.ROOT, "Injection of motion event failed (corresponding down event: %s)", downEvent));
                if (motionEventObtainMovement != null) {
                    motionEventObtainMovement.recycle();
                }
                return false;
            } catch (InjectEventSecurityException e) {
                throw new PerformException.Builder().withActionDescription(String.format(Locale.ROOT, "inject motion event (corresponding down event: %s)", downEvent)).withViewDescription(EnvironmentCompat.MEDIA_UNKNOWN).withCause(e).build();
            }
        } catch (Throwable th) {
            if (motionEventObtainMovement != null) {
                motionEventObtainMovement.recycle();
            }
            throw th;
        }
    }

    private static MotionEvent downPressGingerBread(long downTime, float[] coordinates, float[] precision) {
        return MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), 0, coordinates[0], coordinates[1], 0.0f, 1.0f, 0, precision[0], precision[1], 0, 0);
    }

    private static MotionEvent downPressICS(long downTime, float[] coordinates, float[] precision, int inputDevice, int buttonState) {
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        MotionEvent.PointerProperties[] pointerProperties = getPointerProperties(inputDevice);
        pointerCoordsArr[0].clear();
        pointerCoordsArr[0].x = coordinates[0];
        pointerCoordsArr[0].y = coordinates[1];
        pointerCoordsArr[0].pressure = 0.0f;
        pointerCoordsArr[0].size = 1.0f;
        return MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), 0, 1, pointerProperties, pointerCoordsArr, 0, buttonState, precision[0], precision[1], 0, 0, inputDevice, 0);
    }

    private static MotionEvent upPressGingerBread(MotionEvent downEvent, float[] coordinates) {
        return MotionEvent.obtain(downEvent.getDownTime(), SystemClock.uptimeMillis(), 1, coordinates[0], coordinates[1], 0);
    }

    private static MotionEvent upPressICS(MotionEvent downEvent, float[] coordinates) {
        MotionEvent.PointerCoords[] pointerCoordsArr = {new MotionEvent.PointerCoords()};
        MotionEvent.PointerProperties[] pointerProperties = getPointerProperties(downEvent.getSource());
        pointerCoordsArr[0].clear();
        pointerCoordsArr[0].x = coordinates[0];
        pointerCoordsArr[0].y = coordinates[1];
        pointerCoordsArr[0].pressure = 0.0f;
        pointerCoordsArr[0].size = 1.0f;
        return MotionEvent.obtain(downEvent.getDownTime(), SystemClock.uptimeMillis(), 1, 1, pointerProperties, pointerCoordsArr, 0, downEvent.getButtonState(), downEvent.getXPrecision(), downEvent.getYPrecision(), 0, 0, downEvent.getSource(), 0);
    }

    private static MotionEvent.PointerProperties[] getPointerProperties(int inputDevice) {
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        MotionEvent.PointerProperties[] pointerPropertiesArr = {pointerProperties};
        pointerProperties.clear();
        pointerPropertiesArr[0].id = 0;
        if (inputDevice == 4098) {
            pointerPropertiesArr[0].toolType = 1;
        } else if (inputDevice == 8194) {
            pointerPropertiesArr[0].toolType = 3;
        } else if (inputDevice == 16386) {
            pointerPropertiesArr[0].toolType = 2;
        } else {
            pointerPropertiesArr[0].toolType = 0;
        }
        return pointerPropertiesArr;
    }

    public static class DownResultHolder {
        public final MotionEvent down;
        public final boolean longPress;

        DownResultHolder(MotionEvent down, boolean longPress) {
            this.down = down;
            this.longPress = longPress;
        }
    }
}
