package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideActiveRootListerFactory implements Factory<ActiveRootLister> {
    private final BaseLayerModule module;
    private final Provider<RootsOracle> rootsOracleProvider;

    public BaseLayerModule_ProvideActiveRootListerFactory(BaseLayerModule module, Provider<RootsOracle> rootsOracleProvider) {
        this.module = module;
        this.rootsOracleProvider = rootsOracleProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public ActiveRootLister get2() {
        return provideActiveRootLister(this.module, this.rootsOracleProvider.get2());
    }

    public static BaseLayerModule_ProvideActiveRootListerFactory create(BaseLayerModule module, Provider<RootsOracle> rootsOracleProvider) {
        return new BaseLayerModule_ProvideActiveRootListerFactory(module, rootsOracleProvider);
    }

    public static ActiveRootLister provideActiveRootLister(BaseLayerModule instance, Object rootsOracle) {
        return (ActiveRootLister) Preconditions.checkNotNull(instance.provideActiveRootLister((RootsOracle) rootsOracle), "Cannot return null from a non-@Nullable @Provides method");
    }
}
