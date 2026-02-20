package androidx.test.espresso.action;

import android.view.MotionEvent;
import androidx.test.espresso.UiController;
import androidx.test.espresso.action.Swiper;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public enum Swipe implements Swiper {
    FAST { // from class: androidx.test.espresso.action.Swipe.1
        @Override // androidx.test.espresso.action.Swiper
        public Swiper.Status sendSwipe(UiController uiController, float[] startCoordinates, float[] endCoordinates, float[] precision) {
            return Swipe.sendLinearSwipe(uiController, startCoordinates, endCoordinates, precision, 150);
        }
    },
    SLOW { // from class: androidx.test.espresso.action.Swipe.2
        @Override // androidx.test.espresso.action.Swiper
        public Swiper.Status sendSwipe(UiController uiController, float[] startCoordinates, float[] endCoordinates, float[] precision) {
            return Swipe.sendLinearSwipe(uiController, startCoordinates, endCoordinates, precision, 1500);
        }
    };

    private static final int SWIPE_EVENT_COUNT = 10;
    private static final int SWIPE_FAST_DURATION_MS = 150;
    private static final int SWIPE_SLOW_DURATION_MS = 1500;
    private static final String TAG = "Swipe";

    private static float[][] interpolate(float[] start, float[] end, int steps) {
        Preconditions.checkElementIndex(1, start.length);
        Preconditions.checkElementIndex(1, end.length);
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, steps, 2);
        for (int i = 1; i < steps + 1; i++) {
            float[] fArr2 = fArr[i - 1];
            float f = start[0];
            float f2 = i;
            float f3 = steps + 2.0f;
            fArr2[0] = f + (((end[0] - f) * f2) / f3);
            float f4 = start[1];
            fArr2[1] = f4 + (((end[1] - f4) * f2) / f3);
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Swiper.Status sendLinearSwipe(UiController uiController, float[] startCoordinates, float[] endCoordinates, float[] precision, int duration) {
        Preconditions.checkNotNull(uiController);
        Preconditions.checkNotNull(startCoordinates);
        Preconditions.checkNotNull(endCoordinates);
        Preconditions.checkNotNull(precision);
        float[][] fArrInterpolate = interpolate(startCoordinates, endCoordinates, 10);
        ArrayList arrayList = new ArrayList();
        MotionEvent motionEventObtainDownEvent = MotionEvents.obtainDownEvent(startCoordinates, precision);
        arrayList.add(motionEventObtainDownEvent);
        try {
            long length = duration / fArrInterpolate.length;
            long downTime = motionEventObtainDownEvent.getDownTime();
            for (float[] fArr : fArrInterpolate) {
                downTime += length;
                arrayList.add(MotionEvents.obtainMovement(motionEventObtainDownEvent.getDownTime(), downTime, fArr));
            }
            arrayList.add(MotionEvent.obtain(motionEventObtainDownEvent.getDownTime(), length + downTime, 1, endCoordinates[0], endCoordinates[1], 0));
            uiController.injectMotionEventSequence(arrayList);
            return Swiper.Status.SUCCESS;
        } catch (Exception unused) {
            return Swiper.Status.FAILURE;
        } finally {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
        }
    }
}
