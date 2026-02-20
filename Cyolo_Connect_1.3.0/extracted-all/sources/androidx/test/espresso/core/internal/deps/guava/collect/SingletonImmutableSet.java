package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    private transient int cachedHashCode;
    final transient E element;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    SingletonImmutableSet(E e) {
        this.element = (E) Preconditions.checkNotNull(e);
    }

    SingletonImmutableSet(E element, int hashCode) {
        this.element = element;
        this.cachedHashCode = hashCode;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object target) {
        return this.element.equals(target);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return ImmutableList.of((Object) this.element);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    int copyIntoArray(Object[] dst, int offset) {
        dst[offset] = this.element;
        return offset + 1;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.cachedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.element.hashCode();
        this.cachedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet
    boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String string = this.element.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }
}
