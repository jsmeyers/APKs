package androidx.test.espresso.base;

import androidx.test.espresso.Root;
import androidx.test.espresso.base.RootViewPicker;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;
import org.hamcrest.Matcher;

/* JADX INFO: loaded from: classes.dex */
public final class RootViewPicker_RootResultFetcher_Factory implements Factory<RootViewPicker.RootResultFetcher> {
    private final Provider<ActiveRootLister> activeRootListerProvider;
    private final Provider<AtomicReference<Matcher<Root>>> rootMatcherRefProvider;

    public RootViewPicker_RootResultFetcher_Factory(Provider<ActiveRootLister> activeRootListerProvider, Provider<AtomicReference<Matcher<Root>>> rootMatcherRefProvider) {
        this.activeRootListerProvider = activeRootListerProvider;
        this.rootMatcherRefProvider = rootMatcherRefProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public RootViewPicker.RootResultFetcher get2() {
        return new RootViewPicker.RootResultFetcher(this.activeRootListerProvider.get2(), this.rootMatcherRefProvider.get2());
    }

    public static RootViewPicker_RootResultFetcher_Factory create(Provider<ActiveRootLister> activeRootListerProvider, Provider<AtomicReference<Matcher<Root>>> rootMatcherRefProvider) {
        return new RootViewPicker_RootResultFetcher_Factory(activeRootListerProvider, rootMatcherRefProvider);
    }

    public static RootViewPicker.RootResultFetcher newInstance(ActiveRootLister activeRootLister, AtomicReference<Matcher<Root>> rootMatcherRef) {
        return new RootViewPicker.RootResultFetcher(activeRootLister, rootMatcherRef);
    }
}
