package androidx.test.espresso.core.internal.deps.guava.cache;

/* JADX INFO: loaded from: classes.dex */
public interface Cache<K, V> {
    V getIfPresent(Object key);

    void invalidateAll();

    void put(K key, V value);
}
