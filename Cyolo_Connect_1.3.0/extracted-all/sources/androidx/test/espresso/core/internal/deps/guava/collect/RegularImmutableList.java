package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);
    final transient Object[] array;
    private final transient int size;

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    int internalArrayStart() {
        return 0;
    }

    RegularImmutableList(Object[] array, int size) {
        this.array = array;
        this.size = size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    Object[] internalArray() {
        return this.array;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.size;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableList, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    int copyIntoArray(Object[] dst, int dstOff) {
        System.arraycopy(this.array, 0, dst, dstOff, this.size);
        return dstOff + this.size;
    }

    @Override // java.util.List
    public E get(int i) {
        Preconditions.checkElementIndex(i, this.size);
        return (E) this.array[i];
    }
}
