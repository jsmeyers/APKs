package androidx.test.espresso.action;

import androidx.test.espresso.UiController;

/* JADX INFO: loaded from: classes.dex */
public interface Swiper {

    public enum Status {
        SUCCESS,
        FAILURE
    }

    Status sendSwipe(UiController uiController, float[] startCoordinates, float[] endCoordinates, float[] precision);
}
