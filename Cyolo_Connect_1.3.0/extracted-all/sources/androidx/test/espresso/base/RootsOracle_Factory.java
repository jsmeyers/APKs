package androidx.test.espresso.base;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class RootsOracle_Factory implements Factory<RootsOracle> {
    private final Provider<Looper> mainLooperProvider;

    public RootsOracle_Factory(Provider<Looper> mainLooperProvider) {
        this.mainLooperProvider = mainLooperProvider;
    }

    @Override // javax.inject.Provider
    public RootsOracle get() {
        return new RootsOracle(this.mainLooperProvider.get());
    }

    public static RootsOracle_Factory create(Provider<Looper> mainLooperProvider) {
        return new RootsOracle_Factory(mainLooperProvider);
    }

    public static RootsOracle newInstance(Looper mainLooper) {
        return new RootsOracle(mainLooper);
    }
}
