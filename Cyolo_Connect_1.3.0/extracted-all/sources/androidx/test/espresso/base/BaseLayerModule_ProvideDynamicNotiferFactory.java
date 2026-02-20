package androidx.test.espresso.base;

import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideDynamicNotiferFactory implements Factory<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> {
    private final Provider<IdlingResourceRegistry> dynamicRegistryProvider;
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideDynamicNotiferFactory(BaseLayerModule module, Provider<IdlingResourceRegistry> dynamicRegistryProvider) {
        this.module = module;
        this.dynamicRegistryProvider = dynamicRegistryProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> get2() {
        return provideDynamicNotifer(this.module, this.dynamicRegistryProvider.get2());
    }

    public static BaseLayerModule_ProvideDynamicNotiferFactory create(BaseLayerModule module, Provider<IdlingResourceRegistry> dynamicRegistryProvider) {
        return new BaseLayerModule_ProvideDynamicNotiferFactory(module, dynamicRegistryProvider);
    }

    public static IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> provideDynamicNotifer(BaseLayerModule instance, IdlingResourceRegistry dynamicRegistry) {
        return (IdleNotifier) Preconditions.checkNotNull(instance.provideDynamicNotifer(dynamicRegistry), "Cannot return null from a non-@Nullable @Provides method");
    }
}
