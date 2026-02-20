package androidx.test.espresso.action;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class TranslatedCoordinatesProvider implements CoordinatesProvider {
    final CoordinatesProvider coordinatesProvider;
    final float dx;
    final float dy;

    public TranslatedCoordinatesProvider(CoordinatesProvider coordinatesProvider, float dx, float dy) {
        this.coordinatesProvider = coordinatesProvider;
        this.dx = dx;
        this.dy = dy;
    }

    @Override // androidx.test.espresso.action.CoordinatesProvider
    public float[] calculateCoordinates(View view) {
        float[] fArrCalculateCoordinates = this.coordinatesProvider.calculateCoordinates(view);
        fArrCalculateCoordinates[0] = fArrCalculateCoordinates[0] + (this.dx * view.getWidth());
        fArrCalculateCoordinates[1] = fArrCalculateCoordinates[1] + (this.dy * view.getHeight());
        return fArrCalculateCoordinates;
    }
}
