package androidx.test.espresso.action;

import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.AdapterViewFlipper;
import androidx.test.espresso.action.AdapterViewProtocol;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.collect.Range;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.EspressoOptional;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AdapterViewProtocols {
    private static final int FULLY_RENDERED_PERCENTAGE_CUTOFF = 90;
    private static final AdapterViewProtocol STANDARD_PROTOCOL = new StandardAdapterViewProtocol();

    private AdapterViewProtocols() {
    }

    public static AdapterViewProtocol standardProtocol() {
        return STANDARD_PROTOCOL;
    }

    private static final class StandardAdapterViewProtocol implements AdapterViewProtocol {
        private static final String TAG = "StdAdapterViewProtocol";

        private static final class StandardDataFunction implements AdapterViewProtocol.DataFunction {
            private final Object dataAtPosition;
            private final int position;

            private StandardDataFunction(Object dataAtPosition, int position) {
                Preconditions.checkArgument(position >= 0, "position must be >= 0");
                this.dataAtPosition = dataAtPosition;
                this.position = position;
            }

            @Override // androidx.test.espresso.action.AdapterViewProtocol.DataFunction
            public Object getData() {
                Object obj = this.dataAtPosition;
                if ((obj instanceof Cursor) && !((Cursor) obj).moveToPosition(this.position)) {
                    int i = this.position;
                    StringBuilder sb = new StringBuilder(43);
                    sb.append("Cannot move cursor to position: ");
                    sb.append(i);
                    Log.e(StandardAdapterViewProtocol.TAG, sb.toString());
                }
                return this.dataAtPosition;
            }
        }

        @Override // androidx.test.espresso.action.AdapterViewProtocol
        public Iterable<AdapterViewProtocol.AdaptedData> getDataInAdapterView(AdapterView<? extends Adapter> adapterView) {
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            for (int i = 0; i < adapterView.getCount(); i++) {
                arrayListNewArrayList.add(new AdapterViewProtocol.AdaptedData.Builder().withDataFunction(new StandardDataFunction(adapterView.getItemAtPosition(i), i)).withOpaqueToken(Integer.valueOf(i)).build());
            }
            return arrayListNewArrayList;
        }

        @Override // androidx.test.espresso.action.AdapterViewProtocol
        public EspressoOptional<AdapterViewProtocol.AdaptedData> getDataRenderedByView(AdapterView<? extends Adapter> adapterView, View descendantView) {
            int positionForView;
            if (adapterView == descendantView.getParent() && (positionForView = adapterView.getPositionForView(descendantView)) != -1) {
                return EspressoOptional.of(new AdapterViewProtocol.AdaptedData.Builder().withDataFunction(new StandardDataFunction(adapterView.getItemAtPosition(positionForView), positionForView)).withOpaqueToken(Integer.valueOf(positionForView)).build());
            }
            return EspressoOptional.absent();
        }

        @Override // androidx.test.espresso.action.AdapterViewProtocol
        public void makeDataRenderedWithinAdapterView(AdapterView<? extends Adapter> adapterView, AdapterViewProtocol.AdaptedData data) {
            Preconditions.checkArgument(data.opaqueToken instanceof Integer, "Not my data: %s", data);
            int iIntValue = ((Integer) data.opaqueToken).intValue();
            boolean z = true;
            boolean z2 = false;
            if (adapterView instanceof AbsListView) {
                ((AbsListView) adapterView).smoothScrollToPositionFromTop(iIntValue, adapterView.getPaddingTop(), 0);
                z2 = true;
            }
            if (adapterView instanceof AdapterViewAnimator) {
                if (adapterView instanceof AdapterViewFlipper) {
                    ((AdapterViewFlipper) adapterView).stopFlipping();
                }
                ((AdapterViewAnimator) adapterView).setDisplayedChild(iIntValue);
            } else {
                z = z2;
            }
            if (z) {
                return;
            }
            adapterView.setSelection(iIntValue);
        }

        @Override // androidx.test.espresso.action.AdapterViewProtocol
        public boolean isDataRenderedWithinAdapterView(AdapterView<? extends Adapter> adapterView, AdapterViewProtocol.AdaptedData adaptedData) {
            boolean zIsElementFullyRendered;
            Preconditions.checkArgument(adaptedData.opaqueToken instanceof Integer, "Not my data: %s", adaptedData);
            int iIntValue = ((Integer) adaptedData.opaqueToken).intValue();
            if (Range.closed(Integer.valueOf(adapterView.getFirstVisiblePosition()), Integer.valueOf(adapterView.getLastVisiblePosition())).contains(Integer.valueOf(iIntValue))) {
                zIsElementFullyRendered = adapterView.getFirstVisiblePosition() == adapterView.getLastVisiblePosition() ? true : isElementFullyRendered(adapterView, iIntValue - adapterView.getFirstVisiblePosition());
            } else {
                zIsElementFullyRendered = false;
            }
            if (zIsElementFullyRendered) {
                adapterView.setSelection(iIntValue);
            }
            return zIsElementFullyRendered;
        }

        private boolean isElementFullyRendered(AdapterView<? extends Adapter> adapterView, int childAt) {
            return ViewMatchers.isDisplayingAtLeast(90).matches(adapterView.getChildAt(childAt));
        }
    }
}
