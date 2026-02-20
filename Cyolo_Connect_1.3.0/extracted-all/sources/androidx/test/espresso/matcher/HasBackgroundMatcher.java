package androidx.test.espresso.matcher;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.util.Arrays;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/* JADX INFO: loaded from: classes.dex */
public final class HasBackgroundMatcher extends TypeSafeMatcher<View> {
    private static final String TAG = "HasBackgroundMatcher";
    private final int drawableId;

    public HasBackgroundMatcher(int drawableId) {
        this.drawableId = drawableId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(View view) {
        return assertDrawable(view.getBackground(), this.drawableId, view);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        int i = this.drawableId;
        StringBuilder sb = new StringBuilder(44);
        sb.append("has background with drawable ID: ");
        sb.append(i);
        description.appendText(sb.toString());
    }

    static boolean compareBitmaps(Bitmap img1, Bitmap img2) {
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            return false;
        }
        int[] iArr = new int[img1.getWidth() * img1.getHeight()];
        int[] iArr2 = new int[img2.getWidth() * img2.getHeight()];
        img1.getPixels(iArr, 0, img1.getWidth(), 0, 0, img1.getWidth(), img1.getHeight());
        img2.getPixels(iArr2, 0, img2.getWidth(), 0, 0, img2.getWidth(), img2.getHeight());
        return Arrays.equals(iArr, iArr2);
    }

    private static boolean assertDrawable(Drawable actual, int expectedId, View v) {
        if (actual == null || !(actual instanceof BitmapDrawable)) {
            return false;
        }
        Bitmap bitmapDecodeResource = null;
        try {
            bitmapDecodeResource = BitmapFactory.decodeResource(v.getContext().getResources(), expectedId);
            return ((BitmapDrawable) actual).getBitmap().sameAs(bitmapDecodeResource);
        } catch (OutOfMemoryError e) {
            Log.e(TAG, e.getMessage(), e.getCause());
            return false;
        } finally {
            if (bitmapDecodeResource != null) {
                bitmapDecodeResource.recycle();
            }
        }
    }
}
