package androidx.test.espresso.core.internal.deps.dagger.internal;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class DoubleCheck<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.instance;
                if (t == obj) {
                    t = this.provider.get();
                    this.instance = reentrantCheck(this.instance, t);
                    this.provider = null;
                }
            }
        }
        return t;
    }

    public static Object reentrantCheck(Object currentInstance, Object newInstance) {
        if (!((currentInstance == UNINITIALIZED || (currentInstance instanceof MemoizedSentinel)) ? false : true) || currentInstance == newInstance) {
            return newInstance;
        }
        String strValueOf = String.valueOf(currentInstance);
        String strValueOf2 = String.valueOf(newInstance);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 118 + String.valueOf(strValueOf2).length());
        sb.append("Scoped provider was invoked recursively returning different results: ");
        sb.append(strValueOf);
        sb.append(" & ");
        sb.append(strValueOf2);
        sb.append(". This is likely due to a circular dependency.");
        throw new IllegalStateException(sb.toString());
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P delegate) {
        Preconditions.checkNotNull(delegate);
        return delegate instanceof DoubleCheck ? delegate : new DoubleCheck(delegate);
    }
}
