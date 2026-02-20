package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
    public abstract Cache<K, V> delegate();

    protected ForwardingCache() {
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
    public V getIfPresent(Object key) {
        return delegate().getIfPresent(key);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
    public void put(K key, V value) {
        delegate().put(key, value);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
    public void invalidateAll() {
        delegate().invalidateAll();
    }
}
