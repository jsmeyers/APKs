package androidx.test.espresso.base;

import android.view.View;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class ViewFinderImpl_Factory implements Factory<ViewFinderImpl> {
    private final Provider<View> rootViewProvider;
    private final Provider<Matcher<View>> viewMatcherProvider;

    public ViewFinderImpl_Factory(Provider<Matcher<View>> viewMatcherProvider, Provider<View> rootViewProvider) {
        this.viewMatcherProvider = viewMatcherProvider;
        this.rootViewProvider = rootViewProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public ViewFinderImpl get2() {
        return new ViewFinderImpl(this.viewMatcherProvider.get2(), this.rootViewProvider);
    }

    public static ViewFinderImpl_Factory create(Provider<Matcher<View>> viewMatcherProvider, Provider<View> rootViewProvider) {
        return new ViewFinderImpl_Factory(viewMatcherProvider, rootViewProvider);
    }

    public static ViewFinderImpl newInstance(Matcher<View> viewMatcher, Provider<View> rootViewProvider) {
        return new ViewFinderImpl(viewMatcher, rootViewProvider);
    }
}
