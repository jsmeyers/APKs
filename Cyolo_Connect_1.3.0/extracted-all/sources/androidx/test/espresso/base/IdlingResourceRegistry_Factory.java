package androidx.test.espresso.base;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class IdlingResourceRegistry_Factory implements Factory<IdlingResourceRegistry> {
    private final Provider<Looper> looperProvider;

    public IdlingResourceRegistry_Factory(Provider<Looper> looperProvider) {
        this.looperProvider = looperProvider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: get */
    public IdlingResourceRegistry get2() {
        return new IdlingResourceRegistry(this.looperProvider.get2());
    }

    public static IdlingResourceRegistry_Factory create(Provider<Looper> looperProvider) {
        return new IdlingResourceRegistry_Factory(looperProvider);
    }

    public static IdlingResourceRegistry newInstance(Looper looper) {
        return new IdlingResourceRegistry(looper);
    }
}
