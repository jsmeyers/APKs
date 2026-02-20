package androidx.test.espresso;

import android.view.View;
import androidx.test.espresso.base.RootViewPicker;
import androidx.test.espresso.base.ViewFinderImpl;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.remote.RemoteInteraction;
import androidx.test.espresso.remote.RemoteInteractionRegistry;
import java.util.concurrent.atomic.AtomicReference;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
class ViewInteractionModule {
    private final Matcher<View> viewMatcher;
    private final AtomicReference<Matcher<Root>> rootMatcher = new AtomicReference<>(RootMatchers.DEFAULT);
    private final AtomicReference<Boolean> needsActivity = new AtomicReference<>(true);

    ViewFinder provideViewFinder(ViewFinderImpl impl) {
        return impl;
    }

    ViewInteractionModule(Matcher<View> viewMatcher) {
        this.viewMatcher = (Matcher) Preconditions.checkNotNull(viewMatcher);
    }

    RemoteInteraction provideRemoteInteraction() {
        return RemoteInteractionRegistry.getInstance();
    }

    AtomicReference<Boolean> provideNeedsActivity() {
        return this.needsActivity;
    }

    AtomicReference<Matcher<Root>> provideRootMatcher() {
        return this.rootMatcher;
    }

    Matcher<View> provideViewMatcher() {
        return this.viewMatcher;
    }

    public View provideRootView(RootViewPicker rootViewPicker) {
        return rootViewPicker.get2();
    }
}
