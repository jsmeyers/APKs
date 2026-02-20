package androidx.test.espresso.base;

import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;
import androidx.test.internal.platform.os.ControlledLooper;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideControlledLooperFactory implements Factory<ControlledLooper> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideControlledLooperFactory(BaseLayerModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public ControlledLooper get2() {
        return provideControlledLooper(this.module);
    }

    public static BaseLayerModule_ProvideControlledLooperFactory create(BaseLayerModule module) {
        return new BaseLayerModule_ProvideControlledLooperFactory(module);
    }

    public static ControlledLooper provideControlledLooper(BaseLayerModule instance) {
        return (ControlledLooper) Preconditions.checkNotNull(instance.provideControlledLooper(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
