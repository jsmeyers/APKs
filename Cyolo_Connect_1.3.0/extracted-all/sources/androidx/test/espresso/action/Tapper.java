package androidx.test.espresso.action;

import androidx.test.espresso.UiController;

/* JADX INFO: loaded from: classes.dex */
public interface Tapper {

    public enum Status {
        SUCCESS,
        WARNING,
        FAILURE
    }

    @Deprecated
    Status sendTap(UiController uiController, float[] coordinates, float[] precision);

    Status sendTap(UiController uiController, float[] coordinates, float[] precision, int inputDevice, int buttonState);
}
