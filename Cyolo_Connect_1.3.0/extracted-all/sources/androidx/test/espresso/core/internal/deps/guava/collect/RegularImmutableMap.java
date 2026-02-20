package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    private final transient Object hashTable;
    private final transient int size;

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    static <K, V> RegularImmutableMap<K, V> create(int n, Object[] alternatingKeysAndValues) {
        if (n == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (n == 1) {
            CollectPreconditions.checkEntryNotNull(alternatingKeysAndValues[0], alternatingKeysAndValues[1]);
            return new RegularImmutableMap<>(null, alternatingKeysAndValues, 1);
        }
        Preconditions.checkPositionIndex(n, alternatingKeysAndValues.length >> 1);
        return new RegularImmutableMap<>(createHashTable(alternatingKeysAndValues, n, ImmutableSet.chooseTableSize(n), 0), alternatingKeysAndValues, n);
    }

    static Object createHashTable(Object[] alternatingKeysAndValues, int n, int tableSize, int keyOffset) {
        int i;
        int i2;
        int i3;
        if (n == 1) {
            CollectPreconditions.checkEntryNotNull(alternatingKeysAndValues[keyOffset], alternatingKeysAndValues[keyOffset ^ 1]);
            return null;
        }
        int i4 = tableSize - 1;
        int i5 = 0;
        if (tableSize <= 128) {
            byte[] bArr = new byte[tableSize];
            Arrays.fill(bArr, (byte) -1);
            while (i5 < n) {
                int i6 = (i5 * 2) + keyOffset;
                Object obj = alternatingKeysAndValues[i6];
                Object obj2 = alternatingKeysAndValues[i6 ^ 1];
                CollectPreconditions.checkEntryNotNull(obj, obj2);
                int iSmear = Hashing.smear(obj.hashCode());
                while (true) {
                    i3 = iSmear & i4;
                    int i7 = bArr[i3] & 255;
                    if (i7 == 255) {
                        break;
                    }
                    if (alternatingKeysAndValues[i7].equals(obj)) {
                        throw duplicateKeyException(obj, obj2, alternatingKeysAndValues, i7);
                    }
                    iSmear = i3 + 1;
                }
                bArr[i3] = (byte) i6;
                i5++;
            }
            return bArr;
        }
        if (tableSize <= 32768) {
            short[] sArr = new short[tableSize];
            Arrays.fill(sArr, (short) -1);
            while (i5 < n) {
                int i8 = (i5 * 2) + keyOffset;
                Object obj3 = alternatingKeysAndValues[i8];
                Object obj4 = alternatingKeysAndValues[i8 ^ 1];
                CollectPreconditions.checkEntryNotNull(obj3, obj4);
                int iSmear2 = Hashing.smear(obj3.hashCode());
                while (true) {
                    i2 = iSmear2 & i4;
                    int i9 = sArr[i2] & UShort.MAX_VALUE;
                    if (i9 == 65535) {
                        break;
                    }
                    if (alternatingKeysAndValues[i9].equals(obj3)) {
                        throw duplicateKeyException(obj3, obj4, alternatingKeysAndValues, i9);
                    }
                    iSmear2 = i2 + 1;
                }
                sArr[i2] = (short) i8;
                i5++;
            }
            return sArr;
        }
        int[] iArr = new int[tableSize];
        Arrays.fill(iArr, -1);
        while (i5 < n) {
            int i10 = (i5 * 2) + keyOffset;
            Object obj5 = alternatingKeysAndValues[i10];
            Object obj6 = alternatingKeysAndValues[i10 ^ 1];
            CollectPreconditions.checkEntryNotNull(obj5, obj6);
            int iSmear3 = Hashing.smear(obj5.hashCode());
            while (true) {
                i = iSmear3 & i4;
                int i11 = iArr[i];
                if (i11 == -1) {
                    break;
                }
                if (alternatingKeysAndValues[i11].equals(obj5)) {
                    throw duplicateKeyException(obj5, obj6, alternatingKeysAndValues, i11);
                }
                iSmear3 = i + 1;
            }
            iArr[i] = i10;
            i5++;
        }
        return iArr;
    }

    private static IllegalArgumentException duplicateKeyException(Object key, Object value, Object[] alternatingKeysAndValues, int previousKeyIndex) {
        String strValueOf = String.valueOf(key);
        String strValueOf2 = String.valueOf(value);
        String strValueOf3 = String.valueOf(alternatingKeysAndValues[previousKeyIndex]);
        String strValueOf4 = String.valueOf(alternatingKeysAndValues[previousKeyIndex ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 39 + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length() + String.valueOf(strValueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append("=");
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private RegularImmutableMap(Object hashTable, Object[] alternatingKeysAndValues, int size) {
        this.hashTable = hashTable;
        this.alternatingKeysAndValues = alternatingKeysAndValues;
        this.size = size;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
    }

    static Object get(Object hashTableObject, Object[] alternatingKeysAndValues, int size, int keyOffset, Object key) {
        if (key == null) {
            return null;
        }
        if (size == 1) {
            if (alternatingKeysAndValues[keyOffset].equals(key)) {
                return alternatingKeysAndValues[keyOffset ^ 1];
            }
            return null;
        }
        if (hashTableObject == null) {
            return null;
        }
        if (hashTableObject instanceof byte[]) {
            byte[] bArr = (byte[]) hashTableObject;
            int length = bArr.length - 1;
            int iSmear = Hashing.smear(key.hashCode());
            while (true) {
                int i = iSmear & length;
                int i2 = bArr[i] & 255;
                if (i2 == 255) {
                    return null;
                }
                if (alternatingKeysAndValues[i2].equals(key)) {
                    return alternatingKeysAndValues[i2 ^ 1];
                }
                iSmear = i + 1;
            }
        } else if (hashTableObject instanceof short[]) {
            short[] sArr = (short[]) hashTableObject;
            int length2 = sArr.length - 1;
            int iSmear2 = Hashing.smear(key.hashCode());
            while (true) {
                int i3 = iSmear2 & length2;
                int i4 = sArr[i3] & UShort.MAX_VALUE;
                if (i4 == 65535) {
                    return null;
                }
                if (alternatingKeysAndValues[i4].equals(key)) {
                    return alternatingKeysAndValues[i4 ^ 1];
                }
                iSmear2 = i3 + 1;
            }
        } else {
            int[] iArr = (int[]) hashTableObject;
            int length3 = iArr.length - 1;
            int iSmear3 = Hashing.smear(key.hashCode());
            while (true) {
                int i5 = iSmear3 & length3;
                int i6 = iArr[i5];
                if (i6 == -1) {
                    return null;
                }
                if (alternatingKeysAndValues[i6].equals(key)) {
                    return alternatingKeysAndValues[i6 ^ 1];
                }
                iSmear3 = i5 + 1;
            }
        }
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        private final transient int size;

        EntrySet(ImmutableMap<K, V> map, Object[] alternatingKeysAndValues, int keyOffset, int size) {
            this.map = map;
            this.alternatingKeysAndValues = alternatingKeysAndValues;
            this.keyOffset = keyOffset;
            this.size = size;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
        int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: androidx.test.espresso.core.internal.deps.guava.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.List
                public Map.Entry<K, V> get(int index) {
                    Preconditions.checkElementIndex(index, EntrySet.this.size);
                    int i = index * 2;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i], EntrySet.this.alternatingKeysAndValues[i + (EntrySet.this.keyOffset ^ 1)]);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.size;
                }
            };
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) object;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.map.get(key));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        KeysOrValuesAsList(Object[] alternatingKeysAndValues, int offset, int size) {
            this.alternatingKeysAndValues = alternatingKeysAndValues;
            this.offset = offset;
            this.size = size;
        }

        @Override // java.util.List
        public Object get(int index) {
            Preconditions.checkElementIndex(index, this.size);
            return this.alternatingKeysAndValues[(index * 2) + this.offset];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        KeySet(ImmutableMap<K, ?> map, ImmutableList<K> list) {
            this.map = map;
            this.list = list;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
        int copyIntoArray(Object[] dst, int offset) {
            return asList().copyIntoArray(dst, offset);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.list;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object object) {
            return this.map.get(object) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }
}
