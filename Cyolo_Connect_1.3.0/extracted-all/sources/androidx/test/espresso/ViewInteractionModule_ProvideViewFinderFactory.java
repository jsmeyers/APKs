package androidx.test.espresso;

import androidx.test.espresso.base.ViewFinderImpl;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteractionModule_ProvideViewFinderFactory implements Factory<ViewFinder> {
    private final Provider<ViewFinderImpl> implProvider;
    private final ViewInteractionModule module;

    public ViewInteractionModule_ProvideViewFinderFactory(ViewInteractionModule module, Provider<ViewFinderImpl> implProvider) {
        this.module = module;
        this.implProvider = implProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public ViewFinder get2() {
        return provideViewFinder(this.module, this.implProvider.get2());
    }

    public static ViewInteractionModule_ProvideViewFinderFactory create(ViewInteractionModule module, Provider<ViewFinderImpl> implProvider) {
        return new ViewInteractionModule_ProvideViewFinderFactory(module, implProvider);
    }

    public static ViewFinder provideViewFinder(ViewInteractionModule instance, ViewFinderImpl impl) {
        return (ViewFinder) Preconditions.checkNotNull(instance.provideViewFinder(impl), "Cannot return null from a non-@Nullable @Provides method");
    }
}
