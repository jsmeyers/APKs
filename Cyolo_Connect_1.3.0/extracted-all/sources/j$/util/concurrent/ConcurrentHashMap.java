package j$.util.concurrent;

import com.google.common.primitives.Ints;
import io.cyolo.android.MainActivityKt;
import j$.com.android.tools.r8.DesugarVarHandle$$ExternalSyntheticBackportWithForwarding0;
import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.io.FileUtils;
import org.xbill.DNS.TTL;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes4.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements java.util.concurrent.ConcurrentMap<K, V>, Serializable, ConcurrentMap<K, V> {
    private static final long ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static int RESIZE_STAMP_BITS = 16;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    private static final Unsafe U;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView entrySet;
    private transient KeySetView keySet;
    private volatile transient Node[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node[] table;
    private volatile transient int transferIndex;
    private transient ValuesView values;
    private static final int MAX_RESIZERS = (1 << (32 - 16)) - 1;
    private static final int RESIZE_STAMP_SHIFT = 32 - 16;
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    static class BaseIterator extends Traverser {
        Node lastReturned;
        final ConcurrentHashMap map;

        BaseIterator(Node[] nodeArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMap;
            advance();
        }

        public final boolean hasMoreElements() {
            return this.next != null;
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        public final void remove() {
            Node node = this.lastReturned;
            if (node == null) {
                throw new IllegalStateException();
            }
            this.lastReturned = null;
            this.map.replaceNode(node.key, null, null);
        }
    }

    static abstract class CollectionView implements Collection, Serializable {
        final ConcurrentHashMap map;

        CollectionView(ConcurrentHashMap concurrentHashMap) {
            this.map = concurrentHashMap;
        }

        @Override // java.util.Collection
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.Collection
        public abstract boolean contains(Object obj);

        @Override // java.util.Collection
        public final boolean containsAll(Collection collection) {
            if (collection == this) {
                return true;
            }
            for (Object obj : collection) {
                if (obj == null || !contains(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public abstract Iterator iterator();

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            collection.getClass();
            Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            collection.getClass();
            Iterator it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            long jMappingCount = this.map.mappingCount();
            if (jMappingCount > 2147483639) {
                throw new OutOfMemoryError("Required array size too large");
            }
            int i = (int) jMappingCount;
            Object[] objArrCopyOf = new Object[i];
            int i2 = 0;
            for (Object obj : this) {
                if (i2 == i) {
                    if (i >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i3 = i < 1073741819 ? (i >>> 1) + 1 + i : 2147483639;
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    i = i3;
                }
                objArrCopyOf[i2] = obj;
                i2++;
            }
            return i2 == i ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i2);
        }

        @Override // java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            long jMappingCount = this.map.mappingCount();
            if (jMappingCount > 2147483639) {
                throw new OutOfMemoryError("Required array size too large");
            }
            int i = (int) jMappingCount;
            Object[] objArrCopyOf = objArr.length >= i ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            int length = objArrCopyOf.length;
            int i2 = 0;
            for (Object obj : this) {
                if (i2 == length) {
                    if (length >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i3 = length < 1073741819 ? (length >>> 1) + 1 + length : 2147483639;
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    length = i3;
                }
                objArrCopyOf[i2] = obj;
                i2++;
            }
            if (objArr != objArrCopyOf || i2 >= length) {
                return i2 == length ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i2);
            }
            objArrCopyOf[i2] = null;
            return objArrCopyOf;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',');
                    sb.append(' ');
                }
            }
            sb.append(']');
            return sb.toString();
        }
    }

    static final class CounterCell {
        volatile long value;

        CounterCell(long j) {
            this.value = j;
        }
    }

    static final class EntryIterator extends BaseIterator implements Iterator {
        EntryIterator(Node[] nodeArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        @Override // java.util.Iterator
        public final Map.Entry next() {
            Node node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            Object obj = node.key;
            Object obj2 = node.val;
            this.lastReturned = node;
            advance();
            return new MapEntry(obj, obj2, this.map);
        }
    }

    static final class EntrySetView extends CollectionView implements Set, j$.util.Collection {
        EntrySetView(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(Map.Entry entry) {
            return this.map.putVal(entry.getKey(), entry.getValue(), false) == null;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection collection) {
            Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (add((Map.Entry) it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            Object value;
            return (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = this.map.get(key)) == null || (value = entry.getValue()) == null || (value != obj2 && !value.equals(obj2))) ? false : true;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            Node[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    consumer.accept(new MapEntry(nodeAdvance.key, nodeAdvance.val, this.map));
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            Node[] nodeArr = this.map.table;
            int iHashCode = 0;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node nodeAdvance = traverser.advance();
                    if (nodeAdvance == null) {
                        break;
                    }
                    iHashCode += nodeAdvance.hashCode();
                }
            }
            return iHashCode;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntryIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return StreamSupport.stream(Collection.EL.spliterator(this), true);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.convert(parallelStream());
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.map.remove(key, value);
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.Collection
        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return removeIf(Predicate.VivifiedWrapper.convert(predicate));
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Collection
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long jSumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new EntrySpliterator(nodeArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L, concurrentHashMap);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.convert(stream());
        }

        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return toArray((Object[]) intFunction.apply(0));
        }

        @Override // java.util.Collection
        public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
        }
    }

    static final class EntrySpliterator extends Traverser implements Spliterator {
        long est;
        final ConcurrentHashMap map;

        EntrySpliterator(Node[] nodeArr, int i, int i2, int i3, long j, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3);
            this.map = concurrentHashMap;
            this.est = j;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4353;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                Node nodeAdvance = advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    consumer.accept(new MapEntry(nodeAdvance.key, nodeAdvance.val, this.map));
                }
            }
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer consumer) {
            consumer.getClass();
            Node nodeAdvance = advance();
            if (nodeAdvance == null) {
                return false;
            }
            consumer.accept(new MapEntry(nodeAdvance.key, nodeAdvance.val, this.map));
            return true;
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new EntrySpliterator(nodeArr, i4, i3, i2, j, this.map);
        }
    }

    static final class ForwardingNode extends Node {
        final Node[] nextTable;

        ForwardingNode(Node[] nodeArr) {
            super(-1, null, null, null);
            this.nextTable = nodeArr;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        Node find(int i, Object obj) {
            int length;
            Node nodeTabAt;
            Object obj2;
            Node[] nodeArr = this.nextTable;
            loop0: while (obj != null && nodeArr != null && (length = nodeArr.length) != 0 && (nodeTabAt = ConcurrentHashMap.tabAt(nodeArr, (length - 1) & i)) != null) {
                do {
                    int i2 = nodeTabAt.hash;
                    if (i2 == i && ((obj2 = nodeTabAt.key) == obj || (obj2 != null && obj.equals(obj2)))) {
                        return nodeTabAt;
                    }
                    if (i2 >= 0) {
                        nodeTabAt = nodeTabAt.next;
                    } else {
                        if (!(nodeTabAt instanceof ForwardingNode)) {
                            return nodeTabAt.find(i, obj);
                        }
                        nodeArr = ((ForwardingNode) nodeTabAt).nextTable;
                    }
                } while (nodeTabAt != null);
            }
            return null;
        }
    }

    static final class KeyIterator extends BaseIterator implements Iterator, Enumeration {
        KeyIterator(Node[] nodeArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        @Override // java.util.Iterator
        public final Object next() {
            Node node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            Object obj = node.key;
            this.lastReturned = node;
            advance();
            return obj;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return next();
        }
    }

    public static class KeySetView extends CollectionView implements Set, j$.util.Collection {
        private final Object value;

        KeySetView(ConcurrentHashMap concurrentHashMap, Object obj) {
            super(concurrentHashMap);
            this.value = obj;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            Object obj2 = this.value;
            if (obj2 != null) {
                return this.map.putVal(obj, obj2, true) == null;
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(java.util.Collection collection) {
            Object obj = this.value;
            if (obj == null) {
                throw new UnsupportedOperationException();
            }
            Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (this.map.putVal(it.next(), obj, true) == null) {
                    z = true;
                }
            }
            return z;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            Node[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    consumer.accept(nodeAdvance.key);
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Iterator it = iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += it.next().hashCode();
            }
            return iHashCode;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeyIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return StreamSupport.stream(Collection.EL.spliterator(this), true);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.convert(parallelStream());
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.map.remove(obj) != null;
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.Collection
        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return removeIf(Predicate.VivifiedWrapper.convert(predicate));
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set, j$.util.Collection
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long jSumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new KeySpliterator(nodeArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.convert(stream());
        }

        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return toArray((Object[]) intFunction.apply(0));
        }

        @Override // java.util.Collection
        public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
        }
    }

    static final class KeySpliterator extends Traverser implements Spliterator {
        long est;

        KeySpliterator(Node[] nodeArr, int i, int i2, int i3, long j) {
            super(nodeArr, i, i2, i3);
            this.est = j;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4353;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                Node nodeAdvance = advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    consumer.accept(nodeAdvance.key);
                }
            }
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer consumer) {
            consumer.getClass();
            Node nodeAdvance = advance();
            if (nodeAdvance == null) {
                return false;
            }
            consumer.accept(nodeAdvance.key);
            return true;
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new KeySpliterator(nodeArr, i4, i3, i2, j);
        }
    }

    static final class MapEntry implements Map.Entry {
        final Object key;
        final ConcurrentHashMap map;
        Object val;

        MapEntry(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
            this.key = obj;
            this.val = obj2;
            this.map = concurrentHashMap;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.key) || key.equals(obj2)) && (value == (obj3 = this.val) || value.equals(obj3));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            obj.getClass();
            Object obj2 = this.val;
            this.val = obj;
            this.map.put(this.key, obj);
            return obj2;
        }

        public String toString() {
            return this.key + "=" + this.val;
        }
    }

    static class Node implements Map.Entry {
        final int hash;
        final Object key;
        volatile Node next;
        volatile Object val;

        Node(int i, Object obj, Object obj2, Node node) {
            this.hash = i;
            this.key = obj;
            this.val = obj2;
            this.next = node;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            Object obj2;
            Object obj3;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == (obj2 = this.key) || key.equals(obj2)) && (value == (obj3 = this.val) || value.equals(obj3));
        }

        Node find(int i, Object obj) {
            Object obj2;
            if (obj == null) {
                return null;
            }
            Node node = this;
            do {
                if (node.hash == i && ((obj2 = node.key) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return node;
                }
                node = node.next;
            } while (node != null);
            return null;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final String toString() {
            return this.key + "=" + this.val;
        }
    }

    static final class ReservationNode extends Node {
        ReservationNode() {
            super(-3, null, null, null);
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        Node find(int i, Object obj) {
            return null;
        }
    }

    static class Segment extends ReentrantLock implements Serializable {
        final float loadFactor;

        Segment(float f) {
            this.loadFactor = f;
        }
    }

    static final class TableStack {
        int index;
        int length;
        TableStack next;
        Node[] tab;

        TableStack() {
        }
    }

    static class Traverser {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int index;
        Node next = null;
        TableStack spare;
        TableStack stack;
        Node[] tab;

        Traverser(Node[] nodeArr, int i, int i2, int i3) {
            this.tab = nodeArr;
            this.baseSize = i;
            this.index = i2;
            this.baseIndex = i2;
            this.baseLimit = i3;
        }

        private void pushState(Node[] nodeArr, int i, int i2) {
            TableStack tableStack = this.spare;
            if (tableStack != null) {
                this.spare = tableStack.next;
            } else {
                tableStack = new TableStack();
            }
            tableStack.tab = nodeArr;
            tableStack.length = i2;
            tableStack.index = i;
            tableStack.next = this.stack;
            this.stack = tableStack;
        }

        private void recoverState(int i) {
            TableStack tableStack;
            while (true) {
                tableStack = this.stack;
                if (tableStack == null) {
                    break;
                }
                int i2 = this.index;
                int i3 = tableStack.length;
                int i4 = i2 + i3;
                this.index = i4;
                if (i4 < i) {
                    break;
                }
                this.index = tableStack.index;
                this.tab = tableStack.tab;
                tableStack.tab = null;
                TableStack tableStack2 = tableStack.next;
                tableStack.next = this.spare;
                this.stack = tableStack2;
                this.spare = tableStack;
                i = i3;
            }
            if (tableStack == null) {
                int i5 = this.index + this.baseSize;
                this.index = i5;
                if (i5 >= i) {
                    int i6 = this.baseIndex + 1;
                    this.baseIndex = i6;
                    this.index = i6;
                }
            }
        }

        /* JADX WARN: Found duplicated region for block: B:45:0x004b A[SYNTHETIC] */
        /* JADX WARN: Found duplicated region for block: B:46:0x0047 A[SYNTHETIC] */
        /* JADX WARN: Found duplicated region for block: B:47:0x0052 A[SYNTHETIC] */
        /* JADX WARN: Found duplicated region for block: B:49:0x0006 A[SYNTHETIC] */
        final Node advance() {
            Node[] nodeArr;
            int length;
            int i;
            int i2;
            Node node = this.next;
            if (node != null) {
                node = node.next;
            }
            while (node == null) {
                if (this.baseIndex >= this.baseLimit || (nodeArr = this.tab) == null || (length = nodeArr.length) <= (i = this.index) || i < 0) {
                    this.next = null;
                    return null;
                }
                Node nodeTabAt = ConcurrentHashMap.tabAt(nodeArr, i);
                if (nodeTabAt == null || nodeTabAt.hash >= 0) {
                    node = nodeTabAt;
                    if (this.stack != null) {
                        recoverState(length);
                    } else {
                        i2 = i + this.baseSize;
                        this.index = i2;
                        if (i2 >= length) {
                            int i3 = this.baseIndex + 1;
                            this.baseIndex = i3;
                            this.index = i3;
                        }
                    }
                } else if (nodeTabAt instanceof ForwardingNode) {
                    this.tab = ((ForwardingNode) nodeTabAt).nextTable;
                    pushState(nodeArr, i, length);
                    node = null;
                } else {
                    node = nodeTabAt instanceof TreeBin ? ((TreeBin) nodeTabAt).first : null;
                    if (this.stack != null) {
                        recoverState(length);
                    } else {
                        i2 = i + this.baseSize;
                        this.index = i2;
                        if (i2 >= length) {
                            int i32 = this.baseIndex + 1;
                            this.baseIndex = i32;
                            this.index = i32;
                        }
                    }
                }
            }
            this.next = node;
            return node;
        }
    }

    static final class TreeBin extends Node {
        private static final long LOCKSTATE;
        private static final Unsafe U;
        volatile TreeNode first;
        volatile int lockState;
        TreeNode root;
        volatile Thread waiter;

        static {
            try {
                Unsafe unsafe = DesugarUnsafe.getUnsafe();
                U = unsafe;
                LOCKSTATE = unsafe.objectFieldOffset(TreeBin.class.getDeclaredField("lockState"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        TreeBin(TreeNode treeNode) {
            int iCompareComparables;
            int iTieBreakOrder;
            super(-2, null, null, null);
            this.first = treeNode;
            TreeNode treeNode2 = null;
            while (treeNode != null) {
                TreeNode treeNode3 = (TreeNode) treeNode.next;
                treeNode.right = null;
                treeNode.left = null;
                if (treeNode2 == null) {
                    treeNode.parent = null;
                    treeNode.red = false;
                } else {
                    Object obj = treeNode.key;
                    int i = treeNode.hash;
                    TreeNode treeNode4 = treeNode2;
                    Class clsComparableClassFor = null;
                    while (true) {
                        Object obj2 = treeNode4.key;
                        int i2 = treeNode4.hash;
                        iTieBreakOrder = i2 > i ? -1 : i2 < i ? 1 : ((clsComparableClassFor == null && (clsComparableClassFor = ConcurrentHashMap.comparableClassFor(obj)) == null) || (iCompareComparables = ConcurrentHashMap.compareComparables(clsComparableClassFor, obj, obj2)) == 0) ? tieBreakOrder(obj, obj2) : iCompareComparables;
                        TreeNode treeNode5 = iTieBreakOrder <= 0 ? treeNode4.left : treeNode4.right;
                        if (treeNode5 == null) {
                            break;
                        } else {
                            treeNode4 = treeNode5;
                        }
                    }
                    treeNode.parent = treeNode4;
                    if (iTieBreakOrder <= 0) {
                        treeNode4.left = treeNode;
                    } else {
                        treeNode4.right = treeNode;
                    }
                    treeNode = balanceInsertion(treeNode2, treeNode);
                }
                treeNode2 = treeNode;
                treeNode = treeNode3;
            }
            this.root = treeNode2;
        }

        static TreeNode balanceDeletion(TreeNode treeNode, TreeNode treeNode2) {
            while (treeNode2 != null && treeNode2 != treeNode) {
                TreeNode treeNode3 = treeNode2.parent;
                if (treeNode3 == null) {
                    treeNode2.red = false;
                    return treeNode2;
                }
                if (treeNode2.red) {
                    treeNode2.red = false;
                    return treeNode;
                }
                TreeNode treeNode4 = treeNode3.left;
                if (treeNode4 == treeNode2) {
                    treeNode4 = treeNode3.right;
                    if (treeNode4 != null && treeNode4.red) {
                        treeNode4.red = false;
                        treeNode3.red = true;
                        treeNode = rotateLeft(treeNode, treeNode3);
                        treeNode3 = treeNode2.parent;
                        treeNode4 = treeNode3 == null ? null : treeNode3.right;
                    }
                    if (treeNode4 != null) {
                        TreeNode treeNode5 = treeNode4.left;
                        TreeNode treeNode6 = treeNode4.right;
                        if ((treeNode6 == null || !treeNode6.red) && (treeNode5 == null || !treeNode5.red)) {
                            treeNode4.red = true;
                        } else {
                            if (treeNode6 == null || !treeNode6.red) {
                                if (treeNode5 != null) {
                                    treeNode5.red = false;
                                }
                                treeNode4.red = true;
                                treeNode = rotateRight(treeNode, treeNode4);
                                treeNode3 = treeNode2.parent;
                                treeNode4 = treeNode3 != null ? treeNode3.right : null;
                            }
                            if (treeNode4 != null) {
                                treeNode4.red = treeNode3 == null ? false : treeNode3.red;
                                TreeNode treeNode7 = treeNode4.right;
                                if (treeNode7 != null) {
                                    treeNode7.red = false;
                                }
                            }
                            if (treeNode3 != null) {
                                treeNode3.red = false;
                                treeNode = rotateLeft(treeNode, treeNode3);
                            }
                            treeNode2 = treeNode;
                        }
                    }
                    treeNode2 = treeNode3;
                } else {
                    if (treeNode4 != null && treeNode4.red) {
                        treeNode4.red = false;
                        treeNode3.red = true;
                        treeNode = rotateRight(treeNode, treeNode3);
                        treeNode3 = treeNode2.parent;
                        treeNode4 = treeNode3 == null ? null : treeNode3.left;
                    }
                    if (treeNode4 != null) {
                        TreeNode treeNode8 = treeNode4.left;
                        TreeNode treeNode9 = treeNode4.right;
                        if ((treeNode8 == null || !treeNode8.red) && (treeNode9 == null || !treeNode9.red)) {
                            treeNode4.red = true;
                        } else {
                            if (treeNode8 == null || !treeNode8.red) {
                                if (treeNode9 != null) {
                                    treeNode9.red = false;
                                }
                                treeNode4.red = true;
                                treeNode = rotateLeft(treeNode, treeNode4);
                                treeNode3 = treeNode2.parent;
                                treeNode4 = treeNode3 != null ? treeNode3.left : null;
                            }
                            if (treeNode4 != null) {
                                treeNode4.red = treeNode3 == null ? false : treeNode3.red;
                                TreeNode treeNode10 = treeNode4.left;
                                if (treeNode10 != null) {
                                    treeNode10.red = false;
                                }
                            }
                            if (treeNode3 != null) {
                                treeNode3.red = false;
                                treeNode = rotateRight(treeNode, treeNode3);
                            }
                            treeNode2 = treeNode;
                        }
                    }
                    treeNode2 = treeNode3;
                }
            }
            return treeNode;
        }

        static TreeNode balanceInsertion(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3;
            treeNode2.red = true;
            while (true) {
                TreeNode treeNode4 = treeNode2.parent;
                if (treeNode4 == null) {
                    treeNode2.red = false;
                    return treeNode2;
                }
                if (!treeNode4.red || (treeNode3 = treeNode4.parent) == null) {
                    return treeNode;
                }
                TreeNode treeNode5 = treeNode3.left;
                if (treeNode4 == treeNode5) {
                    treeNode5 = treeNode3.right;
                    if (treeNode5 == null || !treeNode5.red) {
                        if (treeNode2 == treeNode4.right) {
                            treeNode = rotateLeft(treeNode, treeNode4);
                            TreeNode treeNode6 = treeNode4.parent;
                            treeNode3 = treeNode6 == null ? null : treeNode6.parent;
                            treeNode4 = treeNode6;
                            treeNode2 = treeNode4;
                        }
                        if (treeNode4 != null) {
                            treeNode4.red = false;
                            if (treeNode3 != null) {
                                treeNode3.red = true;
                                treeNode = rotateRight(treeNode, treeNode3);
                            }
                        }
                    } else {
                        treeNode5.red = false;
                        treeNode4.red = false;
                        treeNode3.red = true;
                        treeNode2 = treeNode3;
                    }
                } else if (treeNode5 == null || !treeNode5.red) {
                    if (treeNode2 == treeNode4.left) {
                        treeNode = rotateRight(treeNode, treeNode4);
                        TreeNode treeNode7 = treeNode4.parent;
                        treeNode3 = treeNode7 == null ? null : treeNode7.parent;
                        treeNode4 = treeNode7;
                        treeNode2 = treeNode4;
                    }
                    if (treeNode4 != null) {
                        treeNode4.red = false;
                        if (treeNode3 != null) {
                            treeNode3.red = true;
                            treeNode = rotateLeft(treeNode, treeNode3);
                        }
                    }
                } else {
                    treeNode5.red = false;
                    treeNode4.red = false;
                    treeNode3.red = true;
                    treeNode2 = treeNode3;
                }
            }
        }

        private final void contendedLock() {
            boolean z = false;
            while (true) {
                int i = this.lockState;
                if ((i & (-3)) == 0) {
                    if (U.compareAndSwapInt(this, LOCKSTATE, i, 1)) {
                        break;
                    }
                } else if ((i & 2) == 0) {
                    if (U.compareAndSwapInt(this, LOCKSTATE, i, i | 2)) {
                        this.waiter = Thread.currentThread();
                        z = true;
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.waiter = null;
            }
        }

        private final void lockRoot() {
            if (U.compareAndSwapInt(this, LOCKSTATE, 0, 1)) {
                return;
            }
            contendedLock();
        }

        static TreeNode rotateLeft(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3;
            if (treeNode2 != null && (treeNode3 = treeNode2.right) != null) {
                TreeNode treeNode4 = treeNode3.left;
                treeNode2.right = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.red = false;
                    treeNode = treeNode3;
                } else if (treeNode5.left == treeNode2) {
                    treeNode5.left = treeNode3;
                } else {
                    treeNode5.right = treeNode3;
                }
                treeNode3.left = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        static TreeNode rotateRight(TreeNode treeNode, TreeNode treeNode2) {
            TreeNode treeNode3;
            if (treeNode2 != null && (treeNode3 = treeNode2.left) != null) {
                TreeNode treeNode4 = treeNode3.right;
                treeNode2.left = treeNode4;
                if (treeNode4 != null) {
                    treeNode4.parent = treeNode2;
                }
                TreeNode treeNode5 = treeNode2.parent;
                treeNode3.parent = treeNode5;
                if (treeNode5 == null) {
                    treeNode3.red = false;
                    treeNode = treeNode3;
                } else if (treeNode5.right == treeNode2) {
                    treeNode5.right = treeNode3;
                } else {
                    treeNode5.left = treeNode3;
                }
                treeNode3.right = treeNode2;
                treeNode2.parent = treeNode3;
            }
            return treeNode;
        }

        static int tieBreakOrder(Object obj, Object obj2) {
            int iCompareTo;
            return (obj == null || obj2 == null || (iCompareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) ? System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1 : iCompareTo;
        }

        private final void unlockRoot() {
            this.lockState = 0;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        final Node find(int i, Object obj) {
            Object obj2;
            Thread thread;
            TreeNode treeNodeFindTreeNode = null;
            if (obj != null) {
                Node node = this.first;
                while (node != null) {
                    int i2 = this.lockState;
                    if ((i2 & 3) != 0) {
                        if (node.hash == i && ((obj2 = node.key) == obj || (obj2 != null && obj.equals(obj2)))) {
                            return node;
                        }
                        node = node.next;
                    } else if (U.compareAndSwapInt(this, LOCKSTATE, i2, i2 + 4)) {
                        try {
                            TreeNode treeNode = this.root;
                            if (treeNode != null) {
                                treeNodeFindTreeNode = treeNode.findTreeNode(i, obj, null);
                            }
                            return treeNodeFindTreeNode;
                        } finally {
                            if (DesugarUnsafe.getAndAddInt(U, this, LOCKSTATE, -4) == 6 && (thread = this.waiter) != null) {
                                LockSupport.unpark(thread);
                            }
                        }
                    }
                }
            }
            return null;
        }

        final TreeNode putTreeVal(int i, Object obj, Object obj2) {
            int iCompareComparables;
            int iTieBreakOrder;
            TreeNode treeNode;
            TreeNode treeNodeFindTreeNode;
            TreeNode treeNode2 = this.root;
            boolean z = false;
            Class clsComparableClassFor = null;
            while (treeNode2 != null) {
                int i2 = treeNode2.hash;
                if (i2 > i) {
                    iTieBreakOrder = -1;
                } else if (i2 < i) {
                    iTieBreakOrder = 1;
                } else {
                    Object obj3 = treeNode2.key;
                    if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                        return treeNode2;
                    }
                    if ((clsComparableClassFor == null && (clsComparableClassFor = ConcurrentHashMap.comparableClassFor(obj)) == null) || (iCompareComparables = ConcurrentHashMap.compareComparables(clsComparableClassFor, obj, obj3)) == 0) {
                        if (!z) {
                            TreeNode treeNode3 = treeNode2.left;
                            if ((treeNode3 != null && (treeNodeFindTreeNode = treeNode3.findTreeNode(i, obj, clsComparableClassFor)) != null) || ((treeNode = treeNode2.right) != null && (treeNodeFindTreeNode = treeNode.findTreeNode(i, obj, clsComparableClassFor)) != null)) {
                                return treeNodeFindTreeNode;
                            }
                            z = true;
                        }
                        iTieBreakOrder = tieBreakOrder(obj, obj3);
                    } else {
                        iTieBreakOrder = iCompareComparables;
                    }
                }
                TreeNode treeNode4 = iTieBreakOrder <= 0 ? treeNode2.left : treeNode2.right;
                if (treeNode4 == null) {
                    TreeNode treeNode5 = this.first;
                    TreeNode treeNode6 = new TreeNode(i, obj, obj2, treeNode5, treeNode2);
                    this.first = treeNode6;
                    if (treeNode5 != null) {
                        treeNode5.prev = treeNode6;
                    }
                    if (iTieBreakOrder <= 0) {
                        treeNode2.left = treeNode6;
                    } else {
                        treeNode2.right = treeNode6;
                    }
                    if (treeNode2.red) {
                        lockRoot();
                        try {
                            this.root = balanceInsertion(this.root, treeNode6);
                        } finally {
                            unlockRoot();
                        }
                    } else {
                        treeNode6.red = true;
                    }
                    return null;
                }
                treeNode2 = treeNode4;
            }
            TreeNode treeNode7 = new TreeNode(i, obj, obj2, null, null);
            this.root = treeNode7;
            this.first = treeNode7;
            return null;
        }

        /* JADX WARN: Found duplicated region for block: B:55:0x008a A[PHI: r0
          0x008a: PHI (r0v4 j$.util.concurrent.ConcurrentHashMap$TreeNode) = (r0v3 j$.util.concurrent.ConcurrentHashMap$TreeNode), (r0v12 j$.util.concurrent.ConcurrentHashMap$TreeNode) binds: [B:53:0x0086, B:49:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
        final boolean removeTreeNode(TreeNode treeNode) {
            TreeNode treeNode2;
            TreeNode treeNode3;
            TreeNode treeNode4 = (TreeNode) treeNode.next;
            TreeNode treeNode5 = treeNode.prev;
            if (treeNode5 == null) {
                this.first = treeNode4;
            } else {
                treeNode5.next = treeNode4;
            }
            if (treeNode4 != null) {
                treeNode4.prev = treeNode5;
            }
            if (this.first == null) {
                this.root = null;
                return true;
            }
            TreeNode treeNodeBalanceDeletion = this.root;
            if (treeNodeBalanceDeletion == null || treeNodeBalanceDeletion.right == null || (treeNode2 = treeNodeBalanceDeletion.left) == null || treeNode2.left == null) {
                return true;
            }
            lockRoot();
            try {
                TreeNode treeNode6 = treeNode.left;
                TreeNode treeNode7 = treeNode.right;
                if (treeNode6 != null && treeNode7 != null) {
                    TreeNode treeNode8 = treeNode7;
                    while (true) {
                        TreeNode treeNode9 = treeNode8.left;
                        if (treeNode9 == null) {
                            break;
                        }
                        treeNode8 = treeNode9;
                    }
                    boolean z = treeNode8.red;
                    treeNode8.red = treeNode.red;
                    treeNode.red = z;
                    TreeNode treeNode10 = treeNode8.right;
                    TreeNode treeNode11 = treeNode.parent;
                    if (treeNode8 == treeNode7) {
                        treeNode.parent = treeNode8;
                        treeNode8.right = treeNode;
                    } else {
                        TreeNode treeNode12 = treeNode8.parent;
                        treeNode.parent = treeNode12;
                        if (treeNode12 != null) {
                            if (treeNode8 == treeNode12.left) {
                                treeNode12.left = treeNode;
                            } else {
                                treeNode12.right = treeNode;
                            }
                        }
                        treeNode8.right = treeNode7;
                        treeNode7.parent = treeNode8;
                    }
                    treeNode.left = null;
                    treeNode.right = treeNode10;
                    if (treeNode10 != null) {
                        treeNode10.parent = treeNode;
                    }
                    treeNode8.left = treeNode6;
                    treeNode6.parent = treeNode8;
                    treeNode8.parent = treeNode11;
                    if (treeNode11 == null) {
                        treeNodeBalanceDeletion = treeNode8;
                    } else if (treeNode == treeNode11.left) {
                        treeNode11.left = treeNode8;
                    } else {
                        treeNode11.right = treeNode8;
                    }
                    if (treeNode10 != null) {
                        treeNode6 = treeNode10;
                    }
                } else if (treeNode6 == null) {
                    treeNode6 = treeNode7 != null ? treeNode7 : treeNode;
                }
                if (treeNode6 != treeNode) {
                    TreeNode treeNode13 = treeNode.parent;
                    treeNode6.parent = treeNode13;
                    if (treeNode13 == null) {
                        treeNodeBalanceDeletion = treeNode6;
                    } else if (treeNode == treeNode13.left) {
                        treeNode13.left = treeNode6;
                    } else {
                        treeNode13.right = treeNode6;
                    }
                    treeNode.parent = null;
                    treeNode.right = null;
                    treeNode.left = null;
                }
                if (!treeNode.red) {
                    treeNodeBalanceDeletion = balanceDeletion(treeNodeBalanceDeletion, treeNode6);
                }
                this.root = treeNodeBalanceDeletion;
                if (treeNode == treeNode6 && (treeNode3 = treeNode.parent) != null) {
                    if (treeNode == treeNode3.left) {
                        treeNode3.left = null;
                    } else if (treeNode == treeNode3.right) {
                        treeNode3.right = null;
                    }
                    treeNode.parent = null;
                }
                return false;
            } finally {
                unlockRoot();
            }
        }
    }

    static final class TreeNode extends Node {
        TreeNode left;
        TreeNode parent;
        TreeNode prev;
        boolean red;
        TreeNode right;

        TreeNode(int i, Object obj, Object obj2, Node node, TreeNode treeNode) {
            super(i, obj, obj2, node);
            this.parent = treeNode;
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.Node
        Node find(int i, Object obj) {
            return findTreeNode(i, obj, null);
        }

        final TreeNode findTreeNode(int i, Object obj, Class cls) {
            int iCompareComparables;
            if (obj == null) {
                return null;
            }
            TreeNode treeNode = this;
            do {
                TreeNode treeNode2 = treeNode.left;
                TreeNode treeNode3 = treeNode.right;
                int i2 = treeNode.hash;
                if (i2 <= i) {
                    if (i2 >= i) {
                        Object obj2 = treeNode.key;
                        if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                            return treeNode;
                        }
                        if (treeNode2 != null) {
                            if (treeNode3 != null) {
                                if ((cls == null && (cls = ConcurrentHashMap.comparableClassFor(obj)) == null) || (iCompareComparables = ConcurrentHashMap.compareComparables(cls, obj, obj2)) == 0) {
                                    TreeNode treeNodeFindTreeNode = treeNode3.findTreeNode(i, obj, cls);
                                    if (treeNodeFindTreeNode != null) {
                                        return treeNodeFindTreeNode;
                                    }
                                } else if (iCompareComparables >= 0) {
                                    treeNode2 = treeNode3;
                                }
                            }
                            treeNode = treeNode2;
                        }
                    }
                    treeNode = treeNode3;
                } else {
                    treeNode = treeNode2;
                }
            } while (treeNode != null);
            return null;
        }
    }

    static final class ValueIterator extends BaseIterator implements Iterator, Enumeration {
        ValueIterator(Node[] nodeArr, int i, int i2, int i3, ConcurrentHashMap concurrentHashMap) {
            super(nodeArr, i, i2, i3, concurrentHashMap);
        }

        @Override // java.util.Iterator
        public final Object next() {
            Node node = this.next;
            if (node == null) {
                throw new NoSuchElementException();
            }
            Object obj = node.val;
            this.lastReturned = node;
            advance();
            return obj;
        }

        @Override // java.util.Enumeration
        public final Object nextElement() {
            return next();
        }
    }

    static final class ValueSpliterator extends Traverser implements Spliterator {
        long est;

        ValueSpliterator(Node[] nodeArr, int i, int i2, int i3, long j) {
            super(nodeArr, i, i2, i3);
            this.est = j;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 4352;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // j$.util.Spliterator
        public void forEachRemaining(Consumer consumer) {
            consumer.getClass();
            while (true) {
                Node nodeAdvance = advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    consumer.accept(nodeAdvance.val);
                }
            }
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator
        public boolean tryAdvance(Consumer consumer) {
            consumer.getClass();
            Node nodeAdvance = advance();
            if (nodeAdvance == null) {
                return false;
            }
            consumer.accept(nodeAdvance.val);
            return true;
        }

        @Override // j$.util.Spliterator
        public Spliterator trySplit() {
            int i = this.baseIndex;
            int i2 = this.baseLimit;
            int i3 = (i + i2) >>> 1;
            if (i3 <= i) {
                return null;
            }
            Node[] nodeArr = this.tab;
            int i4 = this.baseSize;
            this.baseLimit = i3;
            long j = this.est >>> 1;
            this.est = j;
            return new ValueSpliterator(nodeArr, i4, i3, i2, j);
        }
    }

    static final class ValuesView extends CollectionView implements j$.util.Collection {
        ValuesView(ConcurrentHashMap concurrentHashMap) {
            super(concurrentHashMap);
        }

        @Override // java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(java.util.Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection
        public final boolean contains(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public void forEach(Consumer consumer) {
            consumer.getClass();
            Node[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return;
            }
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    return;
                } else {
                    consumer.accept(nodeAdvance.val);
                }
            }
        }

        @Override // java.lang.Iterable
        public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
            forEach(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // j$.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new ValueIterator(nodeArr, length, 0, length, concurrentHashMap);
        }

        @Override // java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return StreamSupport.stream(Collection.EL.spliterator(this), true);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream parallelStream() {
            return Stream.Wrapper.convert(parallelStream());
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            if (obj == null) {
                return false;
            }
            Iterator it = iterator();
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // java.util.Collection
        public /* synthetic */ boolean removeIf(java.util.function.Predicate predicate) {
            return removeIf(Predicate.VivifiedWrapper.convert(predicate));
        }

        @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection
        public Spliterator spliterator() {
            ConcurrentHashMap concurrentHashMap = this.map;
            long jSumCount = concurrentHashMap.sumCount();
            Node[] nodeArr = concurrentHashMap.table;
            int length = nodeArr == null ? 0 : nodeArr.length;
            return new ValueSpliterator(nodeArr, length, 0, length, jSumCount >= 0 ? jSumCount : 0L);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(spliterator());
        }

        @Override // java.util.Collection, j$.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }

        @Override // java.util.Collection
        public /* synthetic */ java.util.stream.Stream stream() {
            return Stream.Wrapper.convert(stream());
        }

        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return toArray((Object[]) intFunction.apply(0));
        }

        @Override // java.util.Collection
        public /* synthetic */ Object[] toArray(java.util.function.IntFunction intFunction) {
            return toArray(IntFunction.VivifiedWrapper.convert(intFunction));
        }
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", Segment[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        try {
            Unsafe unsafe = DesugarUnsafe.getUnsafe();
            U = unsafe;
            SIZECTL = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("sizeCtl"));
            TRANSFERINDEX = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("transferIndex"));
            BASECOUNT = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("baseCount"));
            CELLSBUSY = unsafe.objectFieldOffset(ConcurrentHashMap.class.getDeclaredField("cellsBusy"));
            CELLVALUE = unsafe.objectFieldOffset(CounterCell.class.getDeclaredField(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE));
            ABASE = unsafe.arrayBaseOffset(Node[].class);
            int iArrayIndexScale = unsafe.arrayIndexScale(Node[].class);
            if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            ASHIFT = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.sizeCtl = i >= 536870912 ? Ints.MAX_POWER_OF_TWO : tableSizeFor(i + (i >>> 1) + 1);
    }

    public ConcurrentHashMap(int i, float f, int i2) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        long j = (long) (((double) ((i < i2 ? i2 : i) / f)) + 1.0d);
        this.sizeCtl = j >= FileUtils.ONE_GB ? Ints.MAX_POWER_OF_TWO : tableSizeFor((int) j);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    /* JADX WARN: Found duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Found duplicated region for block: B:15:0x0034 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:16:0x0036 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Found duplicated region for block: B:6:0x0014  */
    private final void addCount(long j, int i) {
        boolean z;
        int length;
        CounterCell counterCell;
        boolean zCompareAndSwapLong;
        long jSumCount;
        Node[] nodeArr;
        int length2;
        Node[] nodeArr2;
        CounterCell[] counterCellArr = this.counterCells;
        if (counterCellArr != null) {
            z = true;
            if (counterCellArr != null) {
                Unsafe unsafe = U;
                long j2 = CELLVALUE;
                long j3 = counterCell.value;
                zCompareAndSwapLong = unsafe.compareAndSwapLong(counterCell, j2, j3, j3 + j);
                if (!zCompareAndSwapLong) {
                    z = zCompareAndSwapLong;
                } else if (i <= 1) {
                    return;
                } else {
                    jSumCount = sumCount();
                }
            }
            fullAddCount(j, z);
            return;
        }
        Unsafe unsafe2 = U;
        long j4 = BASECOUNT;
        long j5 = this.baseCount;
        jSumCount = j5 + j;
        if (!unsafe2.compareAndSwapLong(this, j4, j5, jSumCount)) {
            z = true;
            if (counterCellArr != null && (length = counterCellArr.length - 1) >= 0 && (counterCell = counterCellArr[length & ThreadLocalRandom.getProbe()]) != null) {
                Unsafe unsafe3 = U;
                long j22 = CELLVALUE;
                long j32 = counterCell.value;
                zCompareAndSwapLong = unsafe3.compareAndSwapLong(counterCell, j22, j32, j32 + j);
                if (!zCompareAndSwapLong) {
                    z = zCompareAndSwapLong;
                } else if (i <= 1) {
                    return;
                } else {
                    jSumCount = sumCount();
                }
            }
            fullAddCount(j, z);
            return;
        }
        if (i < 0) {
            return;
        }
        while (true) {
            int i2 = this.sizeCtl;
            if (jSumCount < i2 || (nodeArr = this.table) == null || (length2 = nodeArr.length) >= 1073741824) {
                return;
            }
            int iResizeStamp = resizeStamp(length2);
            if (i2 < 0) {
                if ((i2 >>> RESIZE_STAMP_SHIFT) != iResizeStamp || i2 == iResizeStamp + 1 || i2 == iResizeStamp + MAX_RESIZERS || (nodeArr2 = this.nextTable) == null || this.transferIndex <= 0) {
                    return;
                }
                if (U.compareAndSwapInt(this, SIZECTL, i2, i2 + 1)) {
                    transfer(nodeArr, nodeArr2);
                }
            } else if (U.compareAndSwapInt(this, SIZECTL, i2, (iResizeStamp << RESIZE_STAMP_SHIFT) + 2)) {
                transfer(nodeArr, null);
            }
            jSumCount = sumCount();
        }
    }

    static final boolean casTabAt(Node[] nodeArr, int i, Node node, Node node2) {
        return DesugarVarHandle$$ExternalSyntheticBackportWithForwarding0.m(U, nodeArr, (((long) i) << ASHIFT) + ABASE, node, node2);
    }

    static Class comparableClassFor(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return cls;
        }
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    return cls;
                }
            }
        }
        return null;
    }

    static int compareComparables(Class cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    /* JADX WARN: Found duplicated region for block: B:28:0x0056  */
    private final void fullAddCount(long j, boolean z) {
        int probe;
        boolean z2;
        CounterCell[] counterCellArr;
        boolean z3;
        int length;
        boolean z4;
        int length2;
        int probe2 = ThreadLocalRandom.getProbe();
        if (probe2 == 0) {
            ThreadLocalRandom.localInit();
            probe = ThreadLocalRandom.getProbe();
            z2 = true;
        } else {
            probe = probe2;
            z2 = z;
        }
        int iAdvanceProbe = probe;
        while (true) {
            boolean z5 = false;
            while (true) {
                counterCellArr = this.counterCells;
                if (counterCellArr != null && (length = counterCellArr.length) > 0) {
                    CounterCell counterCell = counterCellArr[(length - 1) & iAdvanceProbe];
                    if (counterCell != null) {
                        if (z2) {
                            Unsafe unsafe = U;
                            long j2 = CELLVALUE;
                            long j3 = counterCell.value;
                            if (unsafe.compareAndSwapLong(counterCell, j2, j3, j3 + j)) {
                                return;
                            }
                            if (this.counterCells == counterCellArr && length < NCPU) {
                                if (z5) {
                                    if (this.cellsBusy == 0 && unsafe.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                                        break;
                                    }
                                } else {
                                    z5 = true;
                                }
                            }
                        } else {
                            z2 = true;
                        }
                        iAdvanceProbe = ThreadLocalRandom.advanceProbe(iAdvanceProbe);
                    } else if (this.cellsBusy == 0) {
                        CounterCell counterCell2 = new CounterCell(j);
                        if (this.cellsBusy == 0 && U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                            try {
                                CounterCell[] counterCellArr2 = this.counterCells;
                                if (counterCellArr2 == null || (length2 = counterCellArr2.length) <= 0) {
                                    z4 = false;
                                } else {
                                    int i = (length2 - 1) & iAdvanceProbe;
                                    if (counterCellArr2[i] == null) {
                                        counterCellArr2[i] = counterCell2;
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                }
                                this.cellsBusy = 0;
                                if (z4) {
                                    return;
                                }
                            } catch (Throwable th) {
                                this.cellsBusy = 0;
                                throw th;
                            }
                        }
                    }
                    z5 = false;
                    iAdvanceProbe = ThreadLocalRandom.advanceProbe(iAdvanceProbe);
                } else if (this.cellsBusy == 0 && this.counterCells == counterCellArr && U.compareAndSwapInt(this, CELLSBUSY, 0, 1)) {
                    try {
                        if (this.counterCells == counterCellArr) {
                            CounterCell[] counterCellArr3 = new CounterCell[2];
                            counterCellArr3[iAdvanceProbe & 1] = new CounterCell(j);
                            this.counterCells = counterCellArr3;
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.cellsBusy = 0;
                        if (z3) {
                            return;
                        }
                    } catch (Throwable th2) {
                        this.cellsBusy = 0;
                        throw th2;
                    }
                } else {
                    Unsafe unsafe2 = U;
                    long j4 = BASECOUNT;
                    long j5 = this.baseCount;
                    if (unsafe2.compareAndSwapLong(this, j4, j5, j5 + j)) {
                        return;
                    }
                }
            }
            try {
                if (this.counterCells == counterCellArr) {
                    CounterCell[] counterCellArr4 = new CounterCell[length << 1];
                    for (int i2 = 0; i2 < length; i2++) {
                        counterCellArr4[i2] = counterCellArr[i2];
                    }
                    this.counterCells = counterCellArr4;
                }
                this.cellsBusy = 0;
            } catch (Throwable th3) {
                this.cellsBusy = 0;
                throw th3;
            }
        }
    }

    private final Node[] initTable() {
        while (true) {
            Node[] nodeArr = this.table;
            if (nodeArr != null && nodeArr.length != 0) {
                return nodeArr;
            }
            int i = this.sizeCtl;
            if (i < 0) {
                Thread.yield();
            } else if (U.compareAndSwapInt(this, SIZECTL, i, -1)) {
                try {
                    Node[] nodeArr2 = this.table;
                    if (nodeArr2 == null || nodeArr2.length == 0) {
                        int i2 = i > 0 ? i : 16;
                        Node[] nodeArr3 = new Node[i2];
                        this.table = nodeArr3;
                        i = i2 - (i2 >>> 2);
                        nodeArr2 = nodeArr3;
                    }
                    return nodeArr2;
                } finally {
                    this.sizeCtl = i;
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        long j;
        int iTableSizeFor;
        boolean z;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j2 = 0;
        long j3 = 0;
        Node node = null;
        while (true) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            j = 1;
            if (object == null || object2 == null) {
                break;
            }
            j3++;
            node = new Node(spread(object.hashCode()), object, object2, node);
        }
        if (j3 == 0) {
            this.sizeCtl = 0;
            return;
        }
        if (j3 >= 536870912) {
            iTableSizeFor = Ints.MAX_POWER_OF_TWO;
        } else {
            int i = (int) j3;
            iTableSizeFor = tableSizeFor(i + (i >>> 1) + 1);
        }
        Node[] nodeArr = new Node[iTableSizeFor];
        int i2 = iTableSizeFor - 1;
        while (node != null) {
            Node node2 = node.next;
            int i3 = node.hash;
            int i4 = i3 & i2;
            Node nodeTabAt = tabAt(nodeArr, i4);
            if (nodeTabAt == null) {
                z = true;
            } else {
                Object obj2 = node.key;
                if (nodeTabAt.hash >= 0) {
                    Node node3 = nodeTabAt;
                    int i5 = 0;
                    while (true) {
                        if (node3 == null) {
                            z = true;
                            break;
                        }
                        if (node3.hash == i3 && ((obj = node3.key) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z = false;
                            break;
                        } else {
                            i5++;
                            node3 = node3.next;
                        }
                    }
                    if (z && i5 >= 8) {
                        long j4 = j2 + 1;
                        node.next = nodeTabAt;
                        Node node4 = node;
                        TreeNode treeNode = null;
                        TreeNode treeNode2 = null;
                        while (node4 != null) {
                            long j5 = j4;
                            TreeNode treeNode3 = new TreeNode(node4.hash, node4.key, node4.val, null, null);
                            treeNode3.prev = treeNode2;
                            if (treeNode2 == null) {
                                treeNode = treeNode3;
                            } else {
                                treeNode2.next = treeNode3;
                            }
                            node4 = node4.next;
                            treeNode2 = treeNode3;
                            j4 = j5;
                        }
                        setTabAt(nodeArr, i4, new TreeBin(treeNode));
                        j2 = j4;
                    }
                } else if (((TreeBin) nodeTabAt).putTreeVal(i3, obj2, node.val) == null) {
                    j2 += j;
                }
                z = false;
            }
            if (z) {
                j2++;
                node.next = nodeTabAt;
                setTabAt(nodeArr, i4, node);
            }
            j = 1;
            node = node2;
        }
        this.table = nodeArr;
        this.sizeCtl = iTableSizeFor - (iTableSizeFor >>> 2);
        this.baseCount = j2;
    }

    static final int resizeStamp(int i) {
        return Integer.numberOfLeadingZeros(i) | (1 << (RESIZE_STAMP_BITS - 1));
    }

    static final void setTabAt(Node[] nodeArr, int i, Node node) {
        U.putObjectVolatile(nodeArr, (((long) i) << ASHIFT) + ABASE, node);
    }

    static final int spread(int i) {
        return (i ^ (i >>> 16)) & Integer.MAX_VALUE;
    }

    static final Node tabAt(Node[] nodeArr, int i) {
        return (Node) U.getObjectVolatile(nodeArr, (((long) i) << ASHIFT) + ABASE);
    }

    private static final int tableSizeFor(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        if (i7 < 0) {
            return 1;
        }
        return i7 >= 1073741824 ? Ints.MAX_POWER_OF_TWO : 1 + i7;
    }

    private final void transfer(Node[] nodeArr, Node[] nodeArr2) {
        Node[] nodeArr3;
        int i;
        int i2;
        ForwardingNode forwardingNode;
        ConcurrentHashMap<K, V> concurrentHashMap;
        int i3;
        Node node;
        int i4;
        ConcurrentHashMap<K, V> concurrentHashMap2 = this;
        Node[] nodeArr4 = nodeArr;
        int length = nodeArr4.length;
        int i5 = NCPU;
        int i6 = i5 > 1 ? (length >>> 3) / i5 : length;
        int i7 = i6 < 16 ? 16 : i6;
        if (nodeArr2 == null) {
            try {
                Node[] nodeArr5 = new Node[length << 1];
                concurrentHashMap2.nextTable = nodeArr5;
                concurrentHashMap2.transferIndex = length;
                nodeArr3 = nodeArr5;
            } catch (Throwable unused) {
                concurrentHashMap2.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            nodeArr3 = nodeArr2;
        }
        int length2 = nodeArr3.length;
        ForwardingNode forwardingNode2 = new ForwardingNode(nodeArr3);
        int i8 = 0;
        int i9 = 0;
        boolean zCasTabAt = true;
        boolean z = false;
        while (true) {
            if (zCasTabAt) {
                int i10 = i9 - 1;
                if (i10 >= i8 || z) {
                    i8 = i8;
                    i9 = i10;
                    zCasTabAt = false;
                } else {
                    int i11 = concurrentHashMap2.transferIndex;
                    if (i11 <= 0) {
                        i9 = -1;
                    } else {
                        Unsafe unsafe = U;
                        long j = TRANSFERINDEX;
                        int i12 = i11 > i7 ? i11 - i7 : 0;
                        int i13 = i8;
                        if (unsafe.compareAndSwapInt(this, j, i11, i12)) {
                            i9 = i11 - 1;
                            i8 = i12;
                        } else {
                            i8 = i13;
                            i9 = i10;
                        }
                    }
                    zCasTabAt = false;
                }
            } else {
                int i14 = i8;
                TreeNode treeNode = null;
                Node node2 = null;
                if (i9 < 0 || i9 >= length || (i3 = i9 + length) >= length2) {
                    i = i7;
                    i2 = length2;
                    forwardingNode = forwardingNode2;
                    concurrentHashMap = this;
                    if (z) {
                        concurrentHashMap.nextTable = null;
                        concurrentHashMap.table = nodeArr3;
                        concurrentHashMap.sizeCtl = (length << 1) - (length >>> 1);
                        return;
                    }
                    Unsafe unsafe2 = U;
                    long j2 = SIZECTL;
                    int i15 = concurrentHashMap.sizeCtl;
                    int i16 = i9;
                    if (!unsafe2.compareAndSwapInt(this, j2, i15, i15 - 1)) {
                        i9 = i16;
                    } else {
                        if (i15 - 2 != (resizeStamp(length) << RESIZE_STAMP_SHIFT)) {
                            return;
                        }
                        i9 = length;
                        zCasTabAt = true;
                        z = true;
                    }
                } else {
                    Node nodeTabAt = tabAt(nodeArr4, i9);
                    if (nodeTabAt == null) {
                        zCasTabAt = casTabAt(nodeArr4, i9, null, forwardingNode2);
                        concurrentHashMap = concurrentHashMap2;
                        i = i7;
                        i2 = length2;
                        forwardingNode = forwardingNode2;
                    } else {
                        int i17 = nodeTabAt.hash;
                        if (i17 == -1) {
                            concurrentHashMap = concurrentHashMap2;
                            i = i7;
                            i2 = length2;
                            forwardingNode = forwardingNode2;
                            zCasTabAt = true;
                        } else {
                            synchronized (nodeTabAt) {
                                if (tabAt(nodeArr4, i9) == nodeTabAt) {
                                    if (i17 >= 0) {
                                        int i18 = i17 & length;
                                        Node node3 = nodeTabAt;
                                        for (Node node4 = nodeTabAt.next; node4 != null; node4 = node4.next) {
                                            int i19 = node4.hash & length;
                                            if (i19 != i18) {
                                                node3 = node4;
                                                i18 = i19;
                                            }
                                        }
                                        if (i18 == 0) {
                                            node = null;
                                            node2 = node3;
                                        } else {
                                            node = node3;
                                        }
                                        Node node5 = nodeTabAt;
                                        while (node5 != node3) {
                                            int i20 = node5.hash;
                                            Object obj = node5.key;
                                            int i21 = i7;
                                            Object obj2 = node5.val;
                                            if ((i20 & length) == 0) {
                                                i4 = length2;
                                                node2 = new Node(i20, obj, obj2, node2);
                                            } else {
                                                i4 = length2;
                                                node = new Node(i20, obj, obj2, node);
                                            }
                                            node5 = node5.next;
                                            i7 = i21;
                                            length2 = i4;
                                        }
                                        i = i7;
                                        i2 = length2;
                                        setTabAt(nodeArr3, i9, node2);
                                        setTabAt(nodeArr3, i3, node);
                                        setTabAt(nodeArr4, i9, forwardingNode2);
                                        forwardingNode = forwardingNode2;
                                    } else {
                                        i = i7;
                                        i2 = length2;
                                        if (nodeTabAt instanceof TreeBin) {
                                            TreeBin treeBin = (TreeBin) nodeTabAt;
                                            TreeNode treeNode2 = null;
                                            TreeNode treeNode3 = null;
                                            Node node6 = treeBin.first;
                                            int i22 = 0;
                                            int i23 = 0;
                                            TreeNode treeNode4 = null;
                                            while (node6 != null) {
                                                TreeBin treeBin2 = treeBin;
                                                int i24 = node6.hash;
                                                ForwardingNode forwardingNode3 = forwardingNode2;
                                                TreeNode treeNode5 = new TreeNode(i24, node6.key, node6.val, null, null);
                                                if ((i24 & length) == 0) {
                                                    treeNode5.prev = treeNode3;
                                                    if (treeNode3 == null) {
                                                        treeNode = treeNode5;
                                                    } else {
                                                        treeNode3.next = treeNode5;
                                                    }
                                                    i22++;
                                                    treeNode3 = treeNode5;
                                                } else {
                                                    treeNode5.prev = treeNode2;
                                                    if (treeNode2 == null) {
                                                        treeNode4 = treeNode5;
                                                    } else {
                                                        treeNode2.next = treeNode5;
                                                    }
                                                    i23++;
                                                    treeNode2 = treeNode5;
                                                }
                                                node6 = node6.next;
                                                treeBin = treeBin2;
                                                forwardingNode2 = forwardingNode3;
                                            }
                                            TreeBin treeBin3 = treeBin;
                                            ForwardingNode forwardingNode4 = forwardingNode2;
                                            Node nodeUntreeify = i22 <= 6 ? untreeify(treeNode) : i23 != 0 ? new TreeBin(treeNode) : treeBin3;
                                            Node nodeUntreeify2 = i23 <= 6 ? untreeify(treeNode4) : i22 != 0 ? new TreeBin(treeNode4) : treeBin3;
                                            setTabAt(nodeArr3, i9, nodeUntreeify);
                                            setTabAt(nodeArr3, i3, nodeUntreeify2);
                                            nodeArr4 = nodeArr;
                                            forwardingNode = forwardingNode4;
                                            setTabAt(nodeArr4, i9, forwardingNode);
                                        }
                                    }
                                    zCasTabAt = true;
                                } else {
                                    i = i7;
                                    i2 = length2;
                                }
                                forwardingNode = forwardingNode2;
                            }
                            concurrentHashMap = this;
                        }
                    }
                }
                forwardingNode2 = forwardingNode;
                concurrentHashMap2 = concurrentHashMap;
                i8 = i14;
                i7 = i;
                length2 = i2;
            }
        }
    }

    private final void treeifyBin(Node[] nodeArr, int i) {
        if (nodeArr != null) {
            int length = nodeArr.length;
            if (length < 64) {
                tryPresize(length << 1);
                return;
            }
            Node nodeTabAt = tabAt(nodeArr, i);
            if (nodeTabAt == null || nodeTabAt.hash < 0) {
                return;
            }
            synchronized (nodeTabAt) {
                if (tabAt(nodeArr, i) == nodeTabAt) {
                    TreeNode treeNode = null;
                    Node node = nodeTabAt;
                    TreeNode treeNode2 = null;
                    while (node != null) {
                        TreeNode treeNode3 = new TreeNode(node.hash, node.key, node.val, null, null);
                        treeNode3.prev = treeNode2;
                        if (treeNode2 == null) {
                            treeNode = treeNode3;
                        } else {
                            treeNode2.next = treeNode3;
                        }
                        node = node.next;
                        treeNode2 = treeNode3;
                    }
                    setTabAt(nodeArr, i, new TreeBin(treeNode));
                }
            }
        }
    }

    private final void tryPresize(int i) {
        int length;
        Node[] nodeArr;
        int iTableSizeFor = i >= 536870912 ? Ints.MAX_POWER_OF_TWO : tableSizeFor(i + (i >>> 1) + 1);
        while (true) {
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                return;
            }
            Node[] nodeArr2 = this.table;
            if (nodeArr2 == null || (length = nodeArr2.length) == 0) {
                int i3 = i2 > iTableSizeFor ? i2 : iTableSizeFor;
                if (U.compareAndSwapInt(this, SIZECTL, i2, -1)) {
                    try {
                        if (this.table == nodeArr2) {
                            this.table = new Node[i3];
                            i2 = i3 - (i3 >>> 2);
                        }
                        this.sizeCtl = i2;
                    } catch (Throwable th) {
                        this.sizeCtl = i2;
                        throw th;
                    }
                } else {
                    continue;
                }
            } else {
                if (iTableSizeFor <= i2 || length >= 1073741824) {
                    return;
                }
                if (nodeArr2 == this.table) {
                    int iResizeStamp = resizeStamp(length);
                    if (i2 < 0) {
                        if ((i2 >>> RESIZE_STAMP_SHIFT) != iResizeStamp || i2 == iResizeStamp + 1 || i2 == iResizeStamp + MAX_RESIZERS || (nodeArr = this.nextTable) == null || this.transferIndex <= 0) {
                            return;
                        }
                        if (U.compareAndSwapInt(this, SIZECTL, i2, i2 + 1)) {
                            transfer(nodeArr2, nodeArr);
                        }
                    } else if (U.compareAndSwapInt(this, SIZECTL, i2, (iResizeStamp << RESIZE_STAMP_SHIFT) + 2)) {
                        transfer(nodeArr2, null);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    static Node untreeify(Node node) {
        Node node2 = null;
        Node node3 = null;
        while (node != null) {
            Node node4 = new Node(node.hash, node.key, node.val, null);
            if (node3 == null) {
                node2 = node4;
            } else {
                node3.next = node4;
            }
            node = node.next;
            node3 = node4;
        }
        return node2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i = 1;
        int i2 = 0;
        while (i < 16) {
            i2++;
            i <<= 1;
        }
        int i3 = 32 - i2;
        int i4 = i - 1;
        Segment[] segmentArr = new Segment[16];
        for (int i5 = 0; i5 < 16; i5++) {
            segmentArr[i5] = new Segment(0.75f);
        }
        objectOutputStream.putFields().put("segments", segmentArr);
        objectOutputStream.putFields().put("segmentShift", i3);
        objectOutputStream.putFields().put("segmentMask", i4);
        objectOutputStream.writeFields();
        Node[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    break;
                }
                objectOutputStream.writeObject(nodeAdvance.key);
                objectOutputStream.writeObject(nodeAdvance.val);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Node nodeTabAt;
        Node[] nodeArrHelpTransfer = this.table;
        long j = 0;
        loop0: while (true) {
            int i = 0;
            while (true) {
                if (nodeArrHelpTransfer == null || i >= nodeArrHelpTransfer.length) {
                    break loop0;
                }
                nodeTabAt = tabAt(nodeArrHelpTransfer, i);
                if (nodeTabAt == null) {
                    i++;
                } else {
                    int i2 = nodeTabAt.hash;
                    if (i2 == -1) {
                        break;
                    }
                    synchronized (nodeTabAt) {
                        if (tabAt(nodeArrHelpTransfer, i) == nodeTabAt) {
                            for (Node node = i2 >= 0 ? nodeTabAt : nodeTabAt instanceof TreeBin ? ((TreeBin) nodeTabAt).first : null; node != null; node = node.next) {
                                j--;
                            }
                            setTabAt(nodeArrHelpTransfer, i, null);
                            i++;
                        }
                    }
                }
            }
            nodeArrHelpTransfer = helpTransfer(nodeArrHelpTransfer, nodeTabAt);
        }
        if (j != 0) {
            addCount(j, -1);
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "start" is null
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1223)
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1217)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.cutHandlerBlocks(MarkFinallyVisitor.java:249)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:123)
     */
    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object compute(Object obj, BiFunction biFunction) {
        int i;
        Node node;
        Object objApply;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        Node[] nodeArrInitTable = this.table;
        int i2 = 0;
        Object obj3 = null;
        int i3 = 0;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i4 = (length - 1) & iSpread;
                    Node nodeTabAt = tabAt(nodeArrInitTable, i4);
                    if (nodeTabAt == null) {
                        ReservationNode reservationNode = new ReservationNode();
                        synchronized (reservationNode) {
                            try {
                                if (casTabAt(nodeArrInitTable, i4, null, reservationNode)) {
                                    try {
                                        Object objApply2 = biFunction.apply(obj, null);
                                        if (objApply2 != null) {
                                            node = new Node(iSpread, obj, objApply2, null);
                                            i = 1;
                                        } else {
                                            i = i3;
                                            node = null;
                                        }
                                        setTabAt(nodeArrInitTable, i4, node);
                                        i3 = i;
                                        obj3 = objApply2;
                                        i2 = 1;
                                    } catch (Throwable th) {
                                        setTabAt(nodeArrInitTable, i4, null);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    } else {
                        int i5 = nodeTabAt.hash;
                        if (i5 == -1) {
                            nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                        } else {
                            synchronized (nodeTabAt) {
                                try {
                                    if (tabAt(nodeArrInitTable, i4) == nodeTabAt) {
                                        if (i5 >= 0) {
                                            Node node2 = null;
                                            Node node3 = nodeTabAt;
                                            i2 = 1;
                                            while (true) {
                                                if (node3.hash == iSpread && ((obj2 = node3.key) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                    objApply = biFunction.apply(obj, node3.val);
                                                    if (objApply == null) {
                                                        Node node4 = node3.next;
                                                        if (node2 != null) {
                                                            node2.next = node4;
                                                        } else {
                                                            setTabAt(nodeArrInitTable, i4, node4);
                                                        }
                                                        i3 = -1;
                                                        break;
                                                    }
                                                    node3.val = objApply;
                                                    break;
                                                }
                                                Node node5 = node3.next;
                                                if (node5 == null) {
                                                    Object objApply3 = biFunction.apply(obj, null);
                                                    if (objApply3 == null) {
                                                        objApply = objApply3;
                                                        break;
                                                    }
                                                    node3.next = new Node(iSpread, obj, objApply3, null);
                                                    objApply = objApply3;
                                                    i3 = 1;
                                                    break;
                                                }
                                                i2++;
                                                node2 = node3;
                                                node3 = node5;
                                            }
                                            obj3 = objApply;
                                        } else if (nodeTabAt instanceof TreeBin) {
                                            TreeBin treeBin = (TreeBin) nodeTabAt;
                                            TreeNode treeNode = treeBin.root;
                                            TreeNode treeNodeFindTreeNode = treeNode != null ? treeNode.findTreeNode(iSpread, obj, null) : null;
                                            Object objApply4 = biFunction.apply(obj, treeNodeFindTreeNode == null ? null : treeNodeFindTreeNode.val);
                                            if (objApply4 != null) {
                                                if (treeNodeFindTreeNode != null) {
                                                    treeNodeFindTreeNode.val = objApply4;
                                                    obj3 = objApply4;
                                                    i2 = 1;
                                                } else {
                                                    treeBin.putTreeVal(iSpread, obj, objApply4);
                                                    obj3 = objApply4;
                                                    i2 = 1;
                                                    i3 = 1;
                                                }
                                            } else if (treeNodeFindTreeNode != null) {
                                                if (treeBin.removeTreeNode(treeNodeFindTreeNode)) {
                                                    setTabAt(nodeArrInitTable, i4, untreeify(treeBin.first));
                                                }
                                                obj3 = objApply4;
                                                i2 = 1;
                                                i3 = -1;
                                            } else {
                                                obj3 = objApply4;
                                                i2 = 1;
                                            }
                                        }
                                    }
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                            if (i2 != 0) {
                                if (i2 < 8) {
                                    break;
                                }
                                treeifyBin(nodeArrInitTable, i4);
                                break;
                            }
                        }
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        if (i3 != 0) {
            addCount(i3, i2);
        }
        return obj3;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    /* JADX WARN: Found duplicated region for block: B:174:0x00b6 A[PHI: r4 r5
      0x00b6: PHI (r4v7 int) = (r4v1 int), (r4v1 int), (r4v12 int) binds: [B:143:0x005e, B:164:0x0096, B:173:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x00b6: PHI (r5v9 java.lang.Object) = (r5v1 java.lang.Object), (r5v1 java.lang.Object), (r5v13 java.lang.Object) binds: [B:143:0x005e, B:164:0x0096, B:173:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "start" is null
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1223)
    	at jadx.core.utils.BlockUtils.followEmptyUpPathWithinSet(BlockUtils.java:1217)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.cutHandlerBlocks(MarkFinallyVisitor.java:249)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:123)
     */
    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object computeIfAbsent(Object obj, Function function) {
        TreeNode treeNodeFindTreeNode;
        Object obj2;
        Object obj3;
        if (obj == null || function == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        Node[] nodeArrInitTable = this.table;
        Object objApply = null;
        int i = 0;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i2 = (length - 1) & iSpread;
                    Node nodeTabAt = tabAt(nodeArrInitTable, i2);
                    boolean z = true;
                    if (nodeTabAt == null) {
                        ReservationNode reservationNode = new ReservationNode();
                        synchronized (reservationNode) {
                            try {
                                if (casTabAt(nodeArrInitTable, i2, null, reservationNode)) {
                                    try {
                                        Object objApply2 = function.apply(obj);
                                        setTabAt(nodeArrInitTable, i2, objApply2 != null ? new Node(iSpread, obj, objApply2, null) : null);
                                        objApply = objApply2;
                                        i = 1;
                                    } catch (Throwable th) {
                                        setTabAt(nodeArrInitTable, i2, null);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        if (i != 0) {
                            break;
                        }
                    } else {
                        int i3 = nodeTabAt.hash;
                        if (i3 == -1) {
                            nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                        } else {
                            synchronized (nodeTabAt) {
                                try {
                                    if (tabAt(nodeArrInitTable, i2) != nodeTabAt) {
                                        z = false;
                                    } else if (i3 >= 0) {
                                        Node node = nodeTabAt;
                                        int i4 = 1;
                                        while (true) {
                                            if (node.hash == iSpread && ((obj3 = node.key) == obj || (obj3 != null && obj.equals(obj3)))) {
                                                obj2 = node.val;
                                                z = false;
                                                break;
                                            }
                                            Node node2 = node.next;
                                            if (node2 == null) {
                                                Object objApply3 = function.apply(obj);
                                                if (objApply3 == null) {
                                                    obj2 = objApply3;
                                                    z = false;
                                                    break;
                                                }
                                                node.next = new Node(iSpread, obj, objApply3, null);
                                                obj2 = objApply3;
                                                break;
                                            }
                                            i4++;
                                            node = node2;
                                        }
                                        int i5 = i4;
                                        objApply = obj2;
                                        i = i5;
                                    } else if (nodeTabAt instanceof TreeBin) {
                                        TreeBin treeBin = (TreeBin) nodeTabAt;
                                        TreeNode treeNode = treeBin.root;
                                        if (treeNode == null || (treeNodeFindTreeNode = treeNode.findTreeNode(iSpread, obj, null)) == null) {
                                            objApply = function.apply(obj);
                                            if (objApply != null) {
                                                treeBin.putTreeVal(iSpread, obj, objApply);
                                                i = 2;
                                            }
                                        } else {
                                            objApply = treeNodeFindTreeNode.val;
                                        }
                                        i = 2;
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                            if (i != 0) {
                                if (i >= 8) {
                                    treeifyBin(nodeArrInitTable, i2);
                                }
                                if (z) {
                                    break;
                                }
                                return objApply;
                            }
                        }
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        if (objApply != null) {
            addCount(1L, i);
        }
        return objApply;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object computeIfPresent(Object obj, BiFunction biFunction) {
        TreeNode treeNodeFindTreeNode;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        Node[] nodeArrInitTable = this.table;
        int i = 0;
        Object objApply = null;
        int i2 = 0;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i3 = (length - 1) & iSpread;
                    Node nodeTabAt = tabAt(nodeArrInitTable, i3);
                    if (nodeTabAt == null) {
                        break;
                    }
                    int i4 = nodeTabAt.hash;
                    if (i4 == -1) {
                        nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                    } else {
                        synchronized (nodeTabAt) {
                            if (tabAt(nodeArrInitTable, i3) == nodeTabAt) {
                                if (i4 >= 0) {
                                    i2 = 1;
                                    Node node = null;
                                    Node node2 = nodeTabAt;
                                    while (true) {
                                        if (node2.hash == iSpread && ((obj2 = node2.key) == obj || (obj2 != null && obj.equals(obj2)))) {
                                            objApply = biFunction.apply(obj, node2.val);
                                            if (objApply == null) {
                                                Node node3 = node2.next;
                                                if (node != null) {
                                                    node.next = node3;
                                                } else {
                                                    setTabAt(nodeArrInitTable, i3, node3);
                                                }
                                                i = -1;
                                                break;
                                            }
                                            node2.val = objApply;
                                            break;
                                        }
                                        Node node4 = node2.next;
                                        if (node4 == null) {
                                            break;
                                        }
                                        i2++;
                                        node = node2;
                                        node2 = node4;
                                    }
                                } else if (nodeTabAt instanceof TreeBin) {
                                    TreeBin treeBin = (TreeBin) nodeTabAt;
                                    TreeNode treeNode = treeBin.root;
                                    if (treeNode != null && (treeNodeFindTreeNode = treeNode.findTreeNode(iSpread, obj, null)) != null) {
                                        objApply = biFunction.apply(obj, treeNodeFindTreeNode.val);
                                        if (objApply != null) {
                                            treeNodeFindTreeNode.val = objApply;
                                        } else {
                                            if (treeBin.removeTreeNode(treeNodeFindTreeNode)) {
                                                setTabAt(nodeArrInitTable, i3, untreeify(treeBin.first));
                                            }
                                            i = -1;
                                        }
                                    }
                                    i2 = 2;
                                }
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        if (i != 0) {
            addCount(i, i2);
        }
        return objApply;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        obj.getClass();
        Node[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    break;
                }
                Object obj2 = nodeAdvance.val;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView entrySetView = this.entrySet;
        if (entrySetView != null) {
            return entrySetView;
        }
        EntrySetView entrySetView2 = new EntrySetView(this);
        this.entrySet = entrySetView2;
        return entrySetView2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        V value;
        V v;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        Node[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        while (true) {
            Node nodeAdvance = traverser.advance();
            if (nodeAdvance == null) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null || (value != v && !value.equals(v))) {
                        return false;
                    }
                }
                return true;
            }
            Object obj2 = nodeAdvance.val;
            Object obj3 = map.get(nodeAdvance.key);
            if (obj3 == null || (obj3 != obj2 && !obj3.equals(obj2))) {
                break;
            }
        }
        return false;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        Node[] nodeArr = this.table;
        if (nodeArr == null) {
            return;
        }
        Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
        while (true) {
            Node nodeAdvance = traverser.advance();
            if (nodeAdvance == null) {
                return;
            } else {
                biConsumer.accept(nodeAdvance.key, nodeAdvance.val);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int length;
        Node nodeTabAt;
        Object obj2;
        int iSpread = spread(obj.hashCode());
        Node[] nodeArr = this.table;
        if (nodeArr != null && (length = nodeArr.length) > 0 && (nodeTabAt = tabAt(nodeArr, (length - 1) & iSpread)) != null) {
            int i = nodeTabAt.hash;
            if (i == iSpread) {
                Object obj3 = nodeTabAt.key;
                if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                    return (V) nodeTabAt.val;
                }
            } else if (i < 0) {
                Node nodeFind = nodeTabAt.find(iSpread, obj);
                if (nodeFind != null) {
                    return (V) nodeFind.val;
                }
                return null;
            }
            while (true) {
                nodeTabAt = nodeTabAt.next;
                if (nodeTabAt == null) {
                    break;
                }
                if (nodeTabAt.hash == iSpread && ((obj2 = nodeTabAt.key) == obj || (obj2 != null && obj.equals(obj2)))) {
                    return (V) nodeTabAt.val;
                }
            }
        }
        return null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object getOrDefault(Object obj, Object obj2) {
        V v = get(obj);
        return v == null ? obj2 : v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        Node[] nodeArr = this.table;
        int iHashCode = 0;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    break;
                }
                iHashCode += nodeAdvance.val.hashCode() ^ nodeAdvance.key.hashCode();
            }
        }
        return iHashCode;
    }

    final Node[] helpTransfer(Node[] nodeArr, Node node) {
        Node[] nodeArr2;
        int i;
        if (nodeArr == null || !(node instanceof ForwardingNode) || (nodeArr2 = ((ForwardingNode) node).nextTable) == null) {
            return this.table;
        }
        int iResizeStamp = resizeStamp(nodeArr.length);
        while (nodeArr2 == this.nextTable && this.table == nodeArr && (i = this.sizeCtl) < 0 && (i >>> RESIZE_STAMP_SHIFT) == iResizeStamp && i != iResizeStamp + 1 && i != MAX_RESIZERS + iResizeStamp && this.transferIndex > 0) {
            if (U.compareAndSwapInt(this, SIZECTL, i, i + 1)) {
                transfer(nodeArr, nodeArr2);
                break;
            }
        }
        return nodeArr2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        KeySetView keySetView = this.keySet;
        if (keySetView != null) {
            return keySetView;
        }
        KeySetView keySetView2 = new KeySetView(this, null);
        this.keySet = keySetView2;
        return keySetView2;
    }

    public long mappingCount() {
        long jSumCount = sumCount();
        if (jSumCount < 0) {
            return 0L;
        }
        return jSumCount;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i;
        Object objApply;
        Object obj3;
        Object obj4 = obj2;
        if (obj == null || obj4 == null || biFunction == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        Node[] nodeArrInitTable = this.table;
        int i2 = 0;
        Object obj5 = null;
        int i3 = 0;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i4 = (length - 1) & iSpread;
                    Node nodeTabAt = tabAt(nodeArrInitTable, i4);
                    i = 1;
                    if (nodeTabAt != null) {
                        int i5 = nodeTabAt.hash;
                        if (i5 == -1) {
                            nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                        } else {
                            synchronized (nodeTabAt) {
                                if (tabAt(nodeArrInitTable, i4) == nodeTabAt) {
                                    if (i5 >= 0) {
                                        Node node = null;
                                        Node node2 = nodeTabAt;
                                        int i6 = 1;
                                        while (true) {
                                            if (node2.hash == iSpread && ((obj3 = node2.key) == obj || (obj3 != null && obj.equals(obj3)))) {
                                                objApply = biFunction.apply(node2.val, obj4);
                                                if (objApply == null) {
                                                    Node node3 = node2.next;
                                                    if (node != null) {
                                                        node.next = node3;
                                                    } else {
                                                        setTabAt(nodeArrInitTable, i4, node3);
                                                    }
                                                    i3 = -1;
                                                    break;
                                                }
                                                node2.val = objApply;
                                                break;
                                            }
                                            Node node4 = node2.next;
                                            if (node4 == null) {
                                                node2.next = new Node(iSpread, obj, obj4, null);
                                                objApply = obj4;
                                                i3 = 1;
                                                break;
                                            }
                                            i6++;
                                            node = node2;
                                            node2 = node4;
                                        }
                                        i2 = i6;
                                        obj5 = objApply;
                                    } else if (nodeTabAt instanceof TreeBin) {
                                        TreeBin treeBin = (TreeBin) nodeTabAt;
                                        TreeNode treeNode = treeBin.root;
                                        TreeNode treeNodeFindTreeNode = treeNode == null ? null : treeNode.findTreeNode(iSpread, obj, null);
                                        Object objApply2 = treeNodeFindTreeNode == null ? obj4 : biFunction.apply(treeNodeFindTreeNode.val, obj4);
                                        if (objApply2 != null) {
                                            if (treeNodeFindTreeNode != null) {
                                                treeNodeFindTreeNode.val = objApply2;
                                                obj5 = objApply2;
                                                i2 = 2;
                                            } else {
                                                treeBin.putTreeVal(iSpread, obj, objApply2);
                                                obj5 = objApply2;
                                                i2 = 2;
                                                i3 = 1;
                                            }
                                        } else if (treeNodeFindTreeNode != null) {
                                            if (treeBin.removeTreeNode(treeNodeFindTreeNode)) {
                                                setTabAt(nodeArrInitTable, i4, untreeify(treeBin.first));
                                            }
                                            obj5 = objApply2;
                                            i2 = 2;
                                            i3 = -1;
                                        } else {
                                            obj5 = objApply2;
                                            i2 = 2;
                                        }
                                    }
                                }
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    treeifyBin(nodeArrInitTable, i4);
                                }
                                i = i3;
                                obj4 = obj5;
                                break;
                            }
                        }
                    } else if (casTabAt(nodeArrInitTable, i4, null, new Node(iSpread, obj, obj4, null))) {
                        break;
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        if (i != 0) {
            addCount(i, i2);
        }
        return obj4;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return (V) putVal(k, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        tryPresize(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            putVal(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K k, V v) {
        return (V) putVal(k, v, true);
    }

    /* JADX WARN: Found duplicated region for block: B:46:0x0081 A[PHI: r3
      0x0081: PHI (r3v4 int) = (r3v1 int), (r3v1 int), (r3v11 int) binds: [B:20:0x003c, B:38:0x006b, B:35:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    final Object putVal(Object obj, Object obj2, boolean z) {
        Object obj3;
        Object obj4;
        if (obj == null || obj2 == null) {
            throw null;
        }
        int iSpread = spread(obj.hashCode());
        Node[] nodeArrInitTable = this.table;
        int i = 0;
        while (true) {
            if (nodeArrInitTable != null) {
                int length = nodeArrInitTable.length;
                if (length != 0) {
                    int i2 = (length - 1) & iSpread;
                    Node nodeTabAt = tabAt(nodeArrInitTable, i2);
                    if (nodeTabAt != null) {
                        int i3 = nodeTabAt.hash;
                        if (i3 == -1) {
                            nodeArrInitTable = helpTransfer(nodeArrInitTable, nodeTabAt);
                        } else {
                            synchronized (nodeTabAt) {
                                if (tabAt(nodeArrInitTable, i2) != nodeTabAt) {
                                    obj3 = null;
                                } else if (i3 >= 0) {
                                    i = 1;
                                    Node node = nodeTabAt;
                                    while (true) {
                                        if (node.hash != iSpread || ((obj4 = node.key) != obj && (obj4 == null || !obj.equals(obj4)))) {
                                            Node node2 = node.next;
                                            if (node2 == null) {
                                                node.next = new Node(iSpread, obj, obj2, null);
                                                obj3 = null;
                                            } else {
                                                i++;
                                                node = node2;
                                            }
                                        } else {
                                            obj3 = node.val;
                                            if (!z) {
                                                node.val = obj2;
                                            }
                                        }
                                    }
                                } else if (nodeTabAt instanceof TreeBin) {
                                    TreeNode treeNodePutTreeVal = ((TreeBin) nodeTabAt).putTreeVal(iSpread, obj, obj2);
                                    if (treeNodePutTreeVal != null) {
                                        obj3 = treeNodePutTreeVal.val;
                                        if (!z) {
                                            treeNodePutTreeVal.val = obj2;
                                        }
                                    } else {
                                        obj3 = null;
                                    }
                                    i = 2;
                                } else {
                                    obj3 = null;
                                }
                            }
                            if (i != 0) {
                                if (i >= 8) {
                                    treeifyBin(nodeArrInitTable, i2);
                                }
                                if (obj3 == null) {
                                    break;
                                }
                                return obj3;
                            }
                        }
                    } else if (casTabAt(nodeArrInitTable, i2, null, new Node(iSpread, obj, obj2, null))) {
                        break;
                    }
                }
            }
            nodeArrInitTable = initTable();
        }
        addCount(1L, i);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) replaceNode(obj, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || replaceNode(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public Object replace(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw null;
        }
        return replaceNode(obj, obj2, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean replace(K k, V v, V v2) {
        if (k == null || v == null || v2 == null) {
            throw null;
        }
        return replaceNode(k, v2, v) != null;
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        Node[] nodeArr = this.table;
        if (nodeArr == null) {
            return;
        }
        Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
        while (true) {
            Node nodeAdvance = traverser.advance();
            if (nodeAdvance == null) {
                return;
            }
            Object obj = nodeAdvance.val;
            Object obj2 = nodeAdvance.key;
            do {
                Object objApply = biFunction.apply(obj2, obj);
                objApply.getClass();
                if (replaceNode(obj2, objApply, obj) != null) {
                    break;
                } else {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    /* JADX WARN: Found duplicated region for block: B:59:0x009b  */
    final Object replaceNode(Object obj, Object obj2, Object obj3) {
        int length;
        int i;
        Node nodeTabAt;
        boolean z;
        Object obj4;
        TreeNode treeNodeFindTreeNode;
        Node nodeUntreeify;
        Object obj5;
        int iSpread = spread(obj.hashCode());
        Node[] nodeArrHelpTransfer = this.table;
        while (nodeArrHelpTransfer != null && (length = nodeArrHelpTransfer.length) != 0 && (nodeTabAt = tabAt(nodeArrHelpTransfer, (i = (length - 1) & iSpread))) != null) {
            int i2 = nodeTabAt.hash;
            if (i2 == -1) {
                nodeArrHelpTransfer = helpTransfer(nodeArrHelpTransfer, nodeTabAt);
            } else {
                synchronized (nodeTabAt) {
                    if (tabAt(nodeArrHelpTransfer, i) == nodeTabAt) {
                        z = true;
                        if (i2 >= 0) {
                            Node node = null;
                            Node node2 = nodeTabAt;
                            while (true) {
                                if (node2.hash != iSpread || ((obj5 = node2.key) != obj && (obj5 == null || !obj.equals(obj5)))) {
                                    Node node3 = node2.next;
                                    if (node3 != null) {
                                        node = node2;
                                        node2 = node3;
                                    }
                                } else {
                                    obj4 = node2.val;
                                    if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                        if (obj2 != null) {
                                            node2.val = obj2;
                                        } else if (node != null) {
                                            node.next = node2.next;
                                        } else {
                                            nodeUntreeify = node2.next;
                                            setTabAt(nodeArrHelpTransfer, i, nodeUntreeify);
                                        }
                                    }
                                }
                                obj4 = null;
                            }
                        } else {
                            if (nodeTabAt instanceof TreeBin) {
                                TreeBin treeBin = (TreeBin) nodeTabAt;
                                TreeNode treeNode = treeBin.root;
                                if (treeNode != null && (treeNodeFindTreeNode = treeNode.findTreeNode(iSpread, obj, null)) != null) {
                                    obj4 = treeNodeFindTreeNode.val;
                                    if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                        if (obj2 != null) {
                                            treeNodeFindTreeNode.val = obj2;
                                        } else if (treeBin.removeTreeNode(treeNodeFindTreeNode)) {
                                            nodeUntreeify = untreeify(treeBin.first);
                                            setTabAt(nodeArrHelpTransfer, i, nodeUntreeify);
                                        }
                                    }
                                }
                            } else {
                                z = false;
                            }
                            obj4 = null;
                        }
                    } else {
                        z = false;
                        obj4 = null;
                    }
                }
                if (z) {
                    if (obj4 == null) {
                        break;
                    }
                    if (obj2 == null) {
                        addCount(-1L, -1);
                    }
                    return obj4;
                }
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long jSumCount = sumCount();
        if (jSumCount < 0) {
            return 0;
        }
        if (jSumCount > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) jSumCount;
    }

    final long sumCount() {
        CounterCell[] counterCellArr = this.counterCells;
        long j = this.baseCount;
        if (counterCellArr != null) {
            for (CounterCell counterCell : counterCellArr) {
                if (counterCell != null) {
                    j += counterCell.value;
                }
            }
        }
        return j;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        Node[] nodeArr = this.table;
        int length = nodeArr == null ? 0 : nodeArr.length;
        Traverser traverser = new Traverser(nodeArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node nodeAdvance = traverser.advance();
        if (nodeAdvance != null) {
            while (true) {
                Object obj = nodeAdvance.key;
                Object obj2 = nodeAdvance.val;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                nodeAdvance = traverser.advance();
                if (nodeAdvance == null) {
                    break;
                }
                sb.append(',');
                sb.append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Collection<V> values() {
        ValuesView valuesView = this.values;
        if (valuesView != null) {
            return valuesView;
        }
        ValuesView valuesView2 = new ValuesView(this);
        this.values = valuesView2;
        return valuesView2;
    }
}
