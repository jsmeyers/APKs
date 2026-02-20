package androidx.test.espresso.base;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class BaseLayerModule_ProvideMainLooperFactory implements Factory<Looper> {
    private final BaseLayerModule module;

    public BaseLayerModule_ProvideMainLooperFactory(BaseLayerModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public Looper get2() {
        return provideMainLooper(this.module);
    }

    public static BaseLayerModule_ProvideMainLooperFactory create(BaseLayerModule module) {
        return new BaseLayerModule_ProvideMainLooperFactory(module);
    }

    public static Looper provideMainLooper(BaseLayerModule instance) {
        return (Looper) Preconditions.checkNotNull(instance.provideMainLooper(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
