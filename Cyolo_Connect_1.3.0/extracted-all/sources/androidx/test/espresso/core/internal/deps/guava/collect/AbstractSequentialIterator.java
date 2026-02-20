package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    private T nextOrNull;

    protected abstract T computeNext(T previous);

    protected AbstractSequentialIterator(T firstOrNull) {
        this.nextOrNull = firstOrNull;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return this.nextOrNull;
        } finally {
            this.nextOrNull = computeNext(this.nextOrNull);
        }
    }
}
