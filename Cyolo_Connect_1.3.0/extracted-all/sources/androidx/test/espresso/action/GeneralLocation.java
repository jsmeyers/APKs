package androidx.test.espresso.action;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public enum GeneralLocation implements CoordinatesProvider {
    TOP_LEFT { // from class: androidx.test.espresso.action.GeneralLocation.1
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.BEGIN, Position.BEGIN);
        }
    },
    TOP_CENTER { // from class: androidx.test.espresso.action.GeneralLocation.2
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.BEGIN, Position.MIDDLE);
        }
    },
    TOP_RIGHT { // from class: androidx.test.espresso.action.GeneralLocation.3
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.BEGIN, Position.END);
        }
    },
    CENTER_LEFT { // from class: androidx.test.espresso.action.GeneralLocation.4
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.MIDDLE, Position.BEGIN);
        }
    },
    CENTER { // from class: androidx.test.espresso.action.GeneralLocation.5
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.MIDDLE, Position.MIDDLE);
        }
    },
    CENTER_RIGHT { // from class: androidx.test.espresso.action.GeneralLocation.6
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.MIDDLE, Position.END);
        }
    },
    BOTTOM_LEFT { // from class: androidx.test.espresso.action.GeneralLocation.7
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.END, Position.BEGIN);
        }
    },
    BOTTOM_CENTER { // from class: androidx.test.espresso.action.GeneralLocation.8
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.END, Position.MIDDLE);
        }
    },
    BOTTOM_RIGHT { // from class: androidx.test.espresso.action.GeneralLocation.9
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinates(view, Position.END, Position.END);
        }
    },
    VISIBLE_CENTER { // from class: androidx.test.espresso.action.GeneralLocation.10
        @Override // androidx.test.espresso.action.CoordinatesProvider
        public float[] calculateCoordinates(View view) {
            return GeneralLocation.getCoordinatesOfVisiblePart(view, Position.MIDDLE, Position.MIDDLE);
        }
    };

    private enum Position {
        BEGIN { // from class: androidx.test.espresso.action.GeneralLocation.Position.1
            @Override // androidx.test.espresso.action.GeneralLocation.Position
            public float getPosition(int viewPos, int viewLength) {
                return viewPos;
            }
        },
        MIDDLE { // from class: androidx.test.espresso.action.GeneralLocation.Position.2
            @Override // androidx.test.espresso.action.GeneralLocation.Position
            public float getPosition(int viewPos, int viewLength) {
                return viewPos + ((viewLength - 1) / 2.0f);
            }
        },
        END { // from class: androidx.test.espresso.action.GeneralLocation.Position.3
            @Override // androidx.test.espresso.action.GeneralLocation.Position
            public float getPosition(int viewPos, int viewLength) {
                return (viewPos + viewLength) - 1;
            }
        };

        abstract float getPosition(int widgetPos, int widgetLength);
    }

    static CoordinatesProvider translate(final CoordinatesProvider coords, final float dx, final float dy) {
        return new TranslatedCoordinatesProvider(coords, dx, dy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[] getCoordinates(View view, Position vertical, Position horizontal) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new float[]{horizontal.getPosition(iArr[0], view.getWidth()), vertical.getPosition(iArr[1], view.getHeight())};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[] getCoordinatesOfVisiblePart(View view, Position vertical, Position horizontal) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return new float[]{horizontal.getPosition(iArr[0], rect.width()), vertical.getPosition(iArr[1], rect.height())};
    }
}
