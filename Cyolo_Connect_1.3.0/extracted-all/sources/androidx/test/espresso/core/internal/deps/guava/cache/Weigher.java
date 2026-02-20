package androidx.test.espresso.core.internal.deps.guava.cache;

/* JADX INFO: loaded from: classes.dex */
public interface Weigher<K, V> {
    int weigh(K key, V value);
}
