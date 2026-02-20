package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    ComparatorOrdering(Comparator<T> comparator) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.Ordering, java.util.Comparator
    public int compare(T a, T b) {
        return this.comparator.compare(a, b);
    }

    @Override // java.util.Comparator
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ComparatorOrdering) {
            return this.comparator.equals(((ComparatorOrdering) object).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
