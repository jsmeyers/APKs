package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideEventInjectorFactory implements Factory<EventInjector> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideEventInjectorFactory(BaseLayerModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public EventInjector get2() {
        return provideEventInjector(this.module);
    }

    public static BaseLayerModule_ProvideEventInjectorFactory create(BaseLayerModule module) {
        return new BaseLayerModule_ProvideEventInjectorFactory(module);
    }

    public static EventInjector provideEventInjector(BaseLayerModule instance) {
        return (EventInjector) Preconditions.checkNotNull(instance.provideEventInjector(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
