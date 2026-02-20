package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.cache.LocalCache;

/* JADX INFO: loaded from: classes.dex */
interface ReferenceEntry<K, V> {
    long getAccessTime();

    int getHash();

    K getKey();

    ReferenceEntry<K, V> getNext();

    ReferenceEntry<K, V> getNextInAccessQueue();

    ReferenceEntry<K, V> getNextInWriteQueue();

    ReferenceEntry<K, V> getPreviousInAccessQueue();

    ReferenceEntry<K, V> getPreviousInWriteQueue();

    LocalCache.ValueReference<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long time);

    void setNextInAccessQueue(ReferenceEntry<K, V> next);

    void setNextInWriteQueue(ReferenceEntry<K, V> next);

    void setPreviousInAccessQueue(ReferenceEntry<K, V> previous);

    void setPreviousInWriteQueue(ReferenceEntry<K, V> previous);

    void setValueReference(LocalCache.ValueReference<K, V> valueReference);

    void setWriteTime(long time);
}
