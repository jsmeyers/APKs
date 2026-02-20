package androidx.test.espresso.base;

import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.base.BaseLayerModule;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideFailureHandlerFactory implements Factory<FailureHandler> {
    private final Provider<BaseLayerModule.FailureHandlerHolder> holderProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideFailureHandlerFactory(BaseLayerModule module, Provider<BaseLayerModule.FailureHandlerHolder> holderProvider) {
        this.module = module;
        this.holderProvider = holderProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public FailureHandler get2() {
        return provideFailureHandler(this.module, this.holderProvider.get2());
    }

    public static BaseLayerModule_ProvideFailureHandlerFactory create(BaseLayerModule module, Provider<BaseLayerModule.FailureHandlerHolder> holderProvider) {
        return new BaseLayerModule_ProvideFailureHandlerFactory(module, holderProvider);
    }

    public static FailureHandler provideFailureHandler(BaseLayerModule instance, BaseLayerModule.FailureHandlerHolder holder) {
        return (FailureHandler) Preconditions.checkNotNull(instance.provideFailureHandler(holder), "Cannot return null from a non-@Nullable @Provides method");
    }
}
