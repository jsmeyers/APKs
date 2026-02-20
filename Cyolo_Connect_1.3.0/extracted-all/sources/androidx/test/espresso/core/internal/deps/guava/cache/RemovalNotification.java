package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.AbstractMap;

/* JADX INFO: loaded from: classes.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public static <K, V> RemovalNotification<K, V> create(K key, V value, RemovalCause cause) {
        return new RemovalNotification<>(key, value, cause);
    }

    private RemovalNotification(K key, V value, RemovalCause cause) {
        super(key, value);
        this.cause = (RemovalCause) Preconditions.checkNotNull(cause);
    }
}
