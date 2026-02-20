package androidx.test.espresso.base;

import android.content.Context;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideTargetContextFactory implements Factory<Context> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideTargetContextFactory(BaseLayerModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public Context get2() {
        return provideTargetContext(this.module);
    }

    public static BaseLayerModule_ProvideTargetContextFactory create(BaseLayerModule module) {
        return new BaseLayerModule_ProvideTargetContextFactory(module);
    }

    public static Context provideTargetContext(BaseLayerModule instance) {
        return (Context) Preconditions.checkNotNull(instance.provideTargetContext(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
