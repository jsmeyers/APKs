package androidx.test.espresso;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface ViewFinder {
    View getView() throws NoMatchingViewException, AmbiguousViewMatcherException;
}
