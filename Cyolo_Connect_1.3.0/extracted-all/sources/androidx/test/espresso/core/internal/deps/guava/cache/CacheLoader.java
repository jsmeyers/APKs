package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.Futures;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public abstract class CacheLoader<K, V> {
    public abstract V load(K key) throws Exception;

    public ListenableFuture<V> reload(K key, V oldValue) throws Exception {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(oldValue);
        return Futures.immediateFuture(load(key));
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String message) {
            super(message);
        }
    }
}
