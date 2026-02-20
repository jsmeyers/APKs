package androidx.test.espresso.base;

import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideFailureHanderFactory implements Factory<FailureHandler> {
    private final Provider<DefaultFailureHandler> implProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideFailureHanderFactory(BaseLayerModule module, Provider<DefaultFailureHandler> implProvider) {
        this.module = module;
        this.implProvider = implProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public FailureHandler get2() {
        return provideFailureHander(this.module, this.implProvider.get2());
    }

    public static BaseLayerModule_ProvideFailureHanderFactory create(BaseLayerModule module, Provider<DefaultFailureHandler> implProvider) {
        return new BaseLayerModule_ProvideFailureHanderFactory(module, implProvider);
    }

    public static FailureHandler provideFailureHander(BaseLayerModule instance, DefaultFailureHandler impl) {
        return (FailureHandler) Preconditions.checkNotNull(instance.provideFailureHander(impl), "Cannot return null from a non-@Nullable @Provides method");
    }
}
