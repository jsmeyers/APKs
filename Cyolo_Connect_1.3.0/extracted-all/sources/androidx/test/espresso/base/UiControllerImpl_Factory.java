package androidx.test.espresso.base;

import android.os.Looper;
import androidx.test.espresso.base.IdlingResourceRegistry;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class UiControllerImpl_Factory implements Factory<UiControllerImpl> {
    private final Provider<IdleNotifier<Runnable>> asyncIdleProvider;
    private final Provider<IdleNotifier<Runnable>> compatIdleProvider;
    private final Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> dynamicIdleProvider;
    private final Provider<EventInjector> eventInjectorProvider;
    private final Provider<IdlingResourceRegistry> idlingResourceRegistryProvider;
    private final Provider<Looper> mainLooperProvider;

    public UiControllerImpl_Factory(Provider<EventInjector> eventInjectorProvider, Provider<IdleNotifier<Runnable>> asyncIdleProvider, Provider<IdleNotifier<Runnable>> compatIdleProvider, Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> dynamicIdleProvider, Provider<Looper> mainLooperProvider, Provider<IdlingResourceRegistry> idlingResourceRegistryProvider) {
        this.eventInjectorProvider = eventInjectorProvider;
        this.asyncIdleProvider = asyncIdleProvider;
        this.compatIdleProvider = compatIdleProvider;
        this.dynamicIdleProvider = dynamicIdleProvider;
        this.mainLooperProvider = mainLooperProvider;
        this.idlingResourceRegistryProvider = idlingResourceRegistryProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public UiControllerImpl get2() {
        return new UiControllerImpl(this.eventInjectorProvider.get2(), this.asyncIdleProvider.get2(), this.compatIdleProvider.get2(), this.dynamicIdleProvider, this.mainLooperProvider.get2(), this.idlingResourceRegistryProvider.get2());
    }

    public static UiControllerImpl_Factory create(Provider<EventInjector> eventInjectorProvider, Provider<IdleNotifier<Runnable>> asyncIdleProvider, Provider<IdleNotifier<Runnable>> compatIdleProvider, Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> dynamicIdleProvider, Provider<Looper> mainLooperProvider, Provider<IdlingResourceRegistry> idlingResourceRegistryProvider) {
        return new UiControllerImpl_Factory(eventInjectorProvider, asyncIdleProvider, compatIdleProvider, dynamicIdleProvider, mainLooperProvider, idlingResourceRegistryProvider);
    }

    public static UiControllerImpl newInstance(Object eventInjector, Object asyncIdle, Object compatIdle, Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> dynamicIdle, Looper mainLooper, IdlingResourceRegistry idlingResourceRegistry) {
        return new UiControllerImpl((EventInjector) eventInjector, (IdleNotifier) asyncIdle, (IdleNotifier) compatIdle, dynamicIdle, mainLooper, idlingResourceRegistry);
    }
}
