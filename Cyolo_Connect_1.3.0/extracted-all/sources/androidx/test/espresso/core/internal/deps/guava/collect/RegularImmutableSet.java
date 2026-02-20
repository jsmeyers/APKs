package androidx.test.espresso.core.internal.deps.guava.collect;

/* JADX INFO: loaded from: classes.dex */
final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet<>(new Object[0], 0, null, 0, 0);
    final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;
    final transient Object[] table;

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    int internalArrayStart() {
        return 0;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    RegularImmutableSet(Object[] elements, int hashCode, Object[] table, int mask, int size) {
        this.elements = elements;
        this.table = table;
        this.mask = mask;
        this.hashCode = hashCode;
        this.size = size;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object target) {
        Object[] objArr = this.table;
        if (target == null || objArr == null) {
            return false;
        }
        int iSmearedHash = Hashing.smearedHash(target);
        while (true) {
            int i = iSmearedHash & this.mask;
            Object obj = objArr[i];
            if (obj == null) {
                return false;
            }
            if (obj.equals(target)) {
                return true;
            }
            iSmearedHash = i + 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    Object[] internalArray() {
        return this.elements;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.size;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    int copyIntoArray(Object[] dst, int offset) {
        System.arraycopy(this.elements, 0, dst, offset, this.size);
        return offset + this.size;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.elements, this.size);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.hashCode;
    }
}
