package androidx.test.espresso.base;

import android.content.Context;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideDefaultFailureHanderFactory implements Factory<DefaultFailureHandler> {
    private final Provider<Context> contextProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideDefaultFailureHanderFactory(BaseLayerModule module, Provider<Context> contextProvider) {
        this.module = module;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public DefaultFailureHandler get2() {
        return provideDefaultFailureHander(this.module, this.contextProvider.get2());
    }

    public static BaseLayerModule_ProvideDefaultFailureHanderFactory create(BaseLayerModule module, Provider<Context> contextProvider) {
        return new BaseLayerModule_ProvideDefaultFailureHanderFactory(module, contextProvider);
    }

    public static DefaultFailureHandler provideDefaultFailureHander(BaseLayerModule instance, Context context) {
        return (DefaultFailureHandler) Preconditions.checkNotNull(instance.provideDefaultFailureHander(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
