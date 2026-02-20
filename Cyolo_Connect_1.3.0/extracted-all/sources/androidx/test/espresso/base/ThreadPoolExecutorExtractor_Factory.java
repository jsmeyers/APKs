package androidx.test.espresso.base;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadPoolExecutorExtractor_Factory implements Factory<ThreadPoolExecutorExtractor> {
    private final Provider<Looper> looperProvider;

    public ThreadPoolExecutorExtractor_Factory(Provider<Looper> looperProvider) {
        this.looperProvider = looperProvider;
    }

    @Override // javax.inject.Provider
    public ThreadPoolExecutorExtractor get() {
        return new ThreadPoolExecutorExtractor(this.looperProvider.get());
    }

    public static ThreadPoolExecutorExtractor_Factory create(Provider<Looper> looperProvider) {
        return new ThreadPoolExecutorExtractor_Factory(looperProvider);
    }

    public static ThreadPoolExecutorExtractor newInstance(Looper looper) {
        return new ThreadPoolExecutorExtractor(looper);
    }
}
