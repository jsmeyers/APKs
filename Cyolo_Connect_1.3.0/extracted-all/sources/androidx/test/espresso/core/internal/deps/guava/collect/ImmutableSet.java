package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private transient ImmutableList<E> asList;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int actualUnique, int expectedUnique) {
        return actualUnique < (expectedUnique >> 1) + (expectedUnique >> 2);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract UnmodifiableIterator<E> iterator();

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    public static <E> ImmutableSet<E> of(E element) {
        return new SingletonImmutableSet(element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int n, Object... elements) {
        if (n == 0) {
            return of();
        }
        if (n == 1) {
            return of(elements[0]);
        }
        int iChooseTableSize = chooseTableSize(n);
        Object[] objArr = new Object[iChooseTableSize];
        int i = iChooseTableSize - 1;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < n; i4++) {
            Object objCheckElementNotNull = ObjectArrays.checkElementNotNull(elements[i4], i4);
            int iHashCode = objCheckElementNotNull.hashCode();
            int iSmear = Hashing.smear(iHashCode);
            while (true) {
                int i5 = iSmear & i;
                Object obj = objArr[i5];
                if (obj == null) {
                    elements[i3] = objCheckElementNotNull;
                    objArr[i5] = objCheckElementNotNull;
                    i2 += iHashCode;
                    i3++;
                    break;
                }
                if (obj.equals(objCheckElementNotNull)) {
                    break;
                }
                iSmear++;
            }
        }
        Arrays.fill(elements, i3, n, (Object) null);
        if (i3 == 1) {
            return new SingletonImmutableSet(elements[0], i2);
        }
        if (chooseTableSize(i3) < iChooseTableSize / 2) {
            return construct(i3, elements);
        }
        if (shouldTrim(i3, elements.length)) {
            elements = Arrays.copyOf(elements, i3);
        }
        return new RegularImmutableSet(elements, i2, objArr, i, i3);
    }

    static int chooseTableSize(int setSize) {
        int iMax = Math.max(setSize, 2);
        if (iMax < 751619276) {
            int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
            while (((double) iHighestOneBit) * 0.7d < iMax) {
                iHighestOneBit <<= 1;
            }
            return iHighestOneBit;
        }
        Preconditions.checkArgument(iMax < 1073741824, "collection too large");
        return Ints.MAX_POWER_OF_TWO;
    }

    public static <E> ImmutableSet<E> copyOf(E[] elements) {
        int length = elements.length;
        if (length == 0) {
            return of();
        }
        if (length == 1) {
            return of((Object) elements[0]);
        }
        return construct(elements.length, (Object[]) elements.clone());
    }

    ImmutableSet() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if ((object instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) object).isHashCodeFast() && hashCode() != object.hashCode()) {
            return false;
        }
        return Sets.equalsImpl(this, object);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListCreateAsList = createAsList();
        this.asList = immutableListCreateAsList;
        return immutableListCreateAsList;
    }

    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] elements) {
            this.elements = elements;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        private int hashCode;
        Object[] hashTable;

        public Builder() {
            super(4);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection.ArrayBasedBuilder, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection.Builder
        public Builder<E> add(E element) {
            Preconditions.checkNotNull(element);
            if (this.hashTable != null && ImmutableSet.chooseTableSize(this.size) <= this.hashTable.length) {
                addDeduping(element);
                return this;
            }
            this.hashTable = null;
            super.add((Object) element);
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection.ArrayBasedBuilder, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection.Builder
        public Builder<E> add(E... elements) {
            if (this.hashTable != null) {
                for (E e : elements) {
                    add((Object) e);
                }
            } else {
                super.add((Object[]) elements);
            }
            return this;
        }

        private void addDeduping(E element) {
            int length = this.hashTable.length - 1;
            int iHashCode = element.hashCode();
            int iSmear = Hashing.smear(iHashCode);
            while (true) {
                int i = iSmear & length;
                Object[] objArr = this.hashTable;
                Object obj = objArr[i];
                if (obj == null) {
                    objArr[i] = element;
                    this.hashCode += iHashCode;
                    super.add((Object) element);
                    return;
                } else if (obj.equals(element)) {
                    return;
                } else {
                    iSmear = i + 1;
                }
            }
        }

        public ImmutableSet<E> build() {
            ImmutableSet<E> immutableSetConstruct;
            int i = this.size;
            if (i == 0) {
                return ImmutableSet.of();
            }
            if (i == 1) {
                return ImmutableSet.of(this.contents[0]);
            }
            if (this.hashTable == null || ImmutableSet.chooseTableSize(this.size) != this.hashTable.length) {
                immutableSetConstruct = ImmutableSet.construct(this.size, this.contents);
                this.size = immutableSetConstruct.size();
            } else {
                Object[] objArrCopyOf = ImmutableSet.shouldTrim(this.size, this.contents.length) ? Arrays.copyOf(this.contents, this.size) : this.contents;
                immutableSetConstruct = new RegularImmutableSet<>(objArrCopyOf, this.hashCode, this.hashTable, r5.length - 1, this.size);
            }
            this.forceCopy = true;
            this.hashTable = null;
            return immutableSetConstruct;
        }
    }
}
