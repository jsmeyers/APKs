package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Equivalence;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Stopwatch;
import androidx.test.espresso.core.internal.deps.guava.base.Ticker;
import androidx.test.espresso.core.internal.deps.guava.cache.AbstractCache;
import androidx.test.espresso.core.internal.deps.guava.cache.CacheBuilder;
import androidx.test.espresso.core.internal.deps.guava.cache.CacheLoader;
import androidx.test.espresso.core.internal.deps.guava.collect.AbstractSequentialIterator;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterators;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.Futures;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.MoreExecutors;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.SettableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.Uninterruptibles;
import com.google.common.primitives.Ints;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, j$.util.concurrent.ConcurrentMap {
    final int concurrencyLevel;
    final CacheLoader<? super K, V> defaultLoader;
    final EntryFactory entryFactory;
    Set<Map.Entry<K, V>> entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final AbstractCache.StatsCounter globalStatsCounter;
    final Equivalence<Object> keyEquivalence;
    Set<K> keySet;
    final Strength keyStrength;
    final long maxWeight;
    final long refreshNanos;
    final RemovalListener<K, V> removalListener;
    final Queue<RemovalNotification<K, V>> removalNotificationQueue;
    final int segmentMask;
    final int segmentShift;
    final Segment<K, V>[] segments;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    Collection<V> values;
    final Weigher<K, V> weigher;
    static final Logger logger = Logger.getLogger(LocalCache.class.getName());
    static final ValueReference<Object, Object> UNSET = new ValueReference<Object, Object>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.1
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference<Object, Object> copyFor(ReferenceQueue<Object> queue, Object value, ReferenceEntry<Object, Object> entry) {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 0;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(Object newValue) {
        }
    };
    static final Queue<?> DISCARDING_QUEUE = new AbstractQueue<Object>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.2
        @Override // java.util.Queue
        public boolean offer(Object o) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }
    };

    private enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return 0L;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return 0L;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long time) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<Object, Object> next) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<Object, Object> next) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> previous) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> previous) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long time) {
        }
    }

    enum Strength {
        STRONG { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength.1
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> entry, V value, int weight) {
                if (weight == 1) {
                    return new StrongValueReference(value);
                }
                return new WeightedStrongValueReference(value, weight);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        SOFT { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength.2
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> entry, V value, int weight) {
                if (weight == 1) {
                    return new SoftValueReference(segment.valueReferenceQueue, value, entry);
                }
                return new WeightedSoftValueReference(segment.valueReferenceQueue, value, entry, weight);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        },
        WEAK { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength.3
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> entry, V value, int weight) {
                if (weight == 1) {
                    return new WeakValueReference(segment.valueReferenceQueue, value, entry);
                }
                return new WeightedWeakValueReference(segment.valueReferenceQueue, value, entry, weight);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        abstract Equivalence<Object> defaultEquivalence();

        abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> entry, V value, int weight);
    }

    interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, ReferenceEntry<K, V> entry);

        V get();

        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(V newValue);
    }

    static int rehash(int h) {
        int i = h + ((h << 15) ^ (-12931));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = i4 + (i4 << 2) + (i4 << 14);
        return i5 ^ (i5 >>> 16);
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
        return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return ConcurrentMap.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
        return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
        return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        ConcurrentMap.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
        forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return ConcurrentMap.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
        return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
    }

    @Override // j$.util.concurrent.ConcurrentMap, j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        ConcurrentMap.CC.$default$replaceAll(this, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
        replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        Queue<RemovalNotification<K, V>> concurrentLinkedQueue;
        this.concurrencyLevel = Math.min(cacheBuilder.getConcurrencyLevel(), 65536);
        Strength keyStrength = cacheBuilder.getKeyStrength();
        this.keyStrength = keyStrength;
        this.valueStrength = cacheBuilder.getValueStrength();
        this.keyEquivalence = cacheBuilder.getKeyEquivalence();
        this.valueEquivalence = cacheBuilder.getValueEquivalence();
        long maximumWeight = cacheBuilder.getMaximumWeight();
        this.maxWeight = maximumWeight;
        this.weigher = (Weigher<K, V>) cacheBuilder.getWeigher();
        this.expireAfterAccessNanos = cacheBuilder.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = cacheBuilder.getExpireAfterWriteNanos();
        this.refreshNanos = cacheBuilder.getRefreshNanos();
        CacheBuilder.NullListener nullListener = (RemovalListener<K, V>) cacheBuilder.getRemovalListener();
        this.removalListener = nullListener;
        if (nullListener == CacheBuilder.NullListener.INSTANCE) {
            concurrentLinkedQueue = discardingQueue();
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        }
        this.removalNotificationQueue = concurrentLinkedQueue;
        this.ticker = cacheBuilder.getTicker(recordsTime());
        this.entryFactory = EntryFactory.getFactory(keyStrength, usesAccessEntries(), usesWriteEntries());
        this.globalStatsCounter = cacheBuilder.getStatsCounterSupplier().get();
        this.defaultLoader = cacheLoader;
        int iMin = Math.min(cacheBuilder.getInitialCapacity(), Ints.MAX_POWER_OF_TWO);
        if (evictsBySize() && !customWeigher()) {
            iMin = (int) Math.min(iMin, maximumWeight);
        }
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.concurrencyLevel && (!evictsBySize() || i3 * 20 <= this.maxWeight)) {
            i4++;
            i3 <<= 1;
        }
        this.segmentShift = 32 - i4;
        this.segmentMask = i3 - 1;
        this.segments = newSegmentArray(i3);
        int i5 = iMin / i3;
        while (i2 < (i5 * i3 < iMin ? i5 + 1 : i5)) {
            i2 <<= 1;
        }
        if (evictsBySize()) {
            long j = this.maxWeight;
            long j2 = i3;
            long j3 = (j / j2) + 1;
            long j4 = j % j2;
            while (true) {
                Segment<K, V>[] segmentArr = this.segments;
                if (i >= segmentArr.length) {
                    return;
                }
                if (i == j4) {
                    j3--;
                }
                segmentArr[i] = createSegment(i2, j3, cacheBuilder.getStatsCounterSupplier().get());
                i++;
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.segments;
                if (i >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i] = createSegment(i2, -1L, cacheBuilder.getStatsCounterSupplier().get());
                i++;
            }
        }
    }

    boolean evictsBySize() {
        return this.maxWeight >= 0;
    }

    boolean customWeigher() {
        return this.weigher != CacheBuilder.OneWeigher.INSTANCE;
    }

    boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
    }

    boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    boolean refreshes() {
        return this.refreshNanos > 0;
    }

    boolean usesAccessQueue() {
        return expiresAfterAccess() || evictsBySize();
    }

    boolean usesWriteQueue() {
        return expiresAfterWrite();
    }

    boolean recordsWrite() {
        return expiresAfterWrite() || refreshes();
    }

    boolean recordsAccess() {
        return expiresAfterAccess();
    }

    boolean recordsTime() {
        return recordsWrite() || recordsAccess();
    }

    boolean usesWriteEntries() {
        return usesWriteQueue() || recordsWrite();
    }

    boolean usesAccessEntries() {
        return usesAccessQueue() || recordsAccess();
    }

    boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    enum EntryFactory {
        STRONG { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.1
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next) {
                return new StrongEntry(key, hash, next);
            }
        },
        STRONG_ACCESS { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.2
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next) {
                return new StrongAccessEntry(key, hash, next);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, original, newNext);
                copyAccessEntry(original, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        STRONG_WRITE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.3
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next) {
                return new StrongWriteEntry(key, hash, next);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, original, newNext);
                copyWriteEntry(original, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        STRONG_ACCESS_WRITE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.4
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next) {
                return new StrongAccessWriteEntry(key, hash, next);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, original, newNext);
                copyAccessEntry(original, referenceEntryCopyEntry);
                copyWriteEntry(original, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        WEAK { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.5
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next) {
                return new WeakEntry(segment.keyReferenceQueue, key, hash, next);
            }
        },
        WEAK_ACCESS { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.6
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next) {
                return new WeakAccessEntry(segment.keyReferenceQueue, key, hash, next);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, original, newNext);
                copyAccessEntry(original, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        WEAK_WRITE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.7
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next) {
                return new WeakWriteEntry(segment.keyReferenceQueue, key, hash, next);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, original, newNext);
                copyWriteEntry(original, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        WEAK_ACCESS_WRITE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.8
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, key, hash, next);
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = super.copyEntry(segment, original, newNext);
                copyAccessEntry(original, referenceEntryCopyEntry);
                copyWriteEntry(original, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        };

        static final EntryFactory[] factories = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K key, int hash, ReferenceEntry<K, V> next);

        /* JADX WARN: Multi-variable type inference failed */
        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[(strength == Strength.WEAK ? (char) 4 : (char) 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext) {
            return newEntry(segment, original.getKey(), original.getHash(), newNext);
        }

        <K, V> void copyAccessEntry(ReferenceEntry<K, V> original, ReferenceEntry<K, V> newEntry) {
            newEntry.setAccessTime(original.getAccessTime());
            LocalCache.connectAccessOrder(original.getPreviousInAccessQueue(), newEntry);
            LocalCache.connectAccessOrder(newEntry, original.getNextInAccessQueue());
            LocalCache.nullifyAccessOrder(original);
        }

        <K, V> void copyWriteEntry(ReferenceEntry<K, V> original, ReferenceEntry<K, V> newEntry) {
            newEntry.setWriteTime(original.getWriteTime());
            LocalCache.connectWriteOrder(original.getPreviousInWriteQueue(), newEntry);
            LocalCache.connectWriteOrder(newEntry, original.getNextInWriteQueue());
            LocalCache.nullifyWriteOrder(original);
        }
    }

    static <K, V> ValueReference<K, V> unset() {
        return (ValueReference<K, V>) UNSET;
    }

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long time) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> next) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> previous) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long time) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> next) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> previous) {
            throw new UnsupportedOperationException();
        }
    }

    static <K, V> ReferenceEntry<K, V> nullEntry() {
        return NullEntry.INSTANCE;
    }

    static <E> Queue<E> discardingQueue() {
        return (Queue<E>) DISCARDING_QUEUE;
    }

    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final int hash;
        final K key;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference = LocalCache.unset();

        StrongEntry(K key, int hash, ReferenceEntry<K, V> next) {
            this.key = key;
            this.hash = hash;
            this.next = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public K getKey() {
            return this.key;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.valueReference = valueReference;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> previousAccess;

        StrongAccessEntry(K key, int hash, ReferenceEntry<K, V> next) {
            super(key, hash, next);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long time) {
            this.accessTime = time;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> next) {
            this.nextAccess = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> previous) {
            this.previousAccess = previous;
        }
    }

    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        StrongWriteEntry(K key, int hash, ReferenceEntry<K, V> next) {
            super(key, hash, next);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long time) {
            this.writeTime = time;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> next) {
            this.nextWrite = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> previous) {
            this.previousWrite = previous;
        }
    }

    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousAccess;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        StrongAccessWriteEntry(K key, int hash, ReferenceEntry<K, V> next) {
            super(key, hash, next);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long time) {
            this.accessTime = time;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> next) {
            this.nextAccess = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> previous) {
            this.previousAccess = previous;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long time) {
            this.writeTime = time;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> next) {
            this.nextWrite = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> previous) {
            this.previousWrite = previous;
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry<K, V> next;
        volatile ValueReference<K, V> valueReference;

        WeakEntry(ReferenceQueue<K> queue, K key, int hash, ReferenceEntry<K, V> next) {
            super(key, queue);
            this.valueReference = LocalCache.unset();
            this.hash = hash;
            this.next = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public K getKey() {
            return (K) get();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long time) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> next) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> previous) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long time) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> next) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> previous) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference<K, V> valueReference) {
            this.valueReference = valueReference;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> previousAccess;

        WeakAccessEntry(ReferenceQueue<K> queue, K key, int hash, ReferenceEntry<K, V> next) {
            super(queue, key, hash, next);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long time) {
            this.accessTime = time;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> next) {
            this.nextAccess = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> previous) {
            this.previousAccess = previous;
        }
    }

    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        WeakWriteEntry(ReferenceQueue<K> queue, K key, int hash, ReferenceEntry<K, V> next) {
            super(queue, key, hash, next);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long time) {
            this.writeTime = time;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> next) {
            this.nextWrite = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> previous) {
            this.previousWrite = previous;
        }
    }

    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry<K, V> nextAccess;
        ReferenceEntry<K, V> nextWrite;
        ReferenceEntry<K, V> previousAccess;
        ReferenceEntry<K, V> previousWrite;
        volatile long writeTime;

        WeakAccessWriteEntry(ReferenceQueue<K> queue, K key, int hash, ReferenceEntry<K, V> next) {
            super(queue, key, hash, next);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long time) {
            this.accessTime = time;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry<K, V> next) {
            this.nextAccess = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry<K, V> previous) {
            this.previousAccess = previous;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long time) {
            this.writeTime = time;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry<K, V> next) {
            this.nextWrite = next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry<K, V> previous) {
            this.previousWrite = previous;
        }
    }

    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(V newValue) {
        }

        WeakValueReference(ReferenceQueue<V> queue, V referent, ReferenceEntry<K, V> entry) {
            super(referent, queue);
            this.entry = entry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, ReferenceEntry<K, V> entry) {
            return new WeakValueReference(queue, value, entry);
        }
    }

    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(V newValue) {
        }

        SoftValueReference(ReferenceQueue<V> queue, V referent, ReferenceEntry<K, V> entry) {
            super(referent, queue);
            this.entry = entry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return this.entry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, ReferenceEntry<K, V> entry) {
            return new SoftValueReference(queue, value, entry);
        }
    }

    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, ReferenceEntry<K, V> entry) {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(V newValue) {
        }

        StrongValueReference(V referent) {
            this.referent = referent;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public V get() {
            return this.referent;
        }
    }

    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int weight;

        WeightedWeakValueReference(ReferenceQueue<V> queue, V referent, ReferenceEntry<K, V> entry, int weight) {
            super(queue, referent, entry);
            this.weight = weight;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, ReferenceEntry<K, V> entry) {
            return new WeightedWeakValueReference(queue, value, entry, this.weight);
        }
    }

    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int weight;

        WeightedSoftValueReference(ReferenceQueue<V> queue, V referent, ReferenceEntry<K, V> entry, int weight) {
            super(queue, referent, entry);
            this.weight = weight;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.SoftValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.SoftValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, ReferenceEntry<K, V> entry) {
            return new WeightedSoftValueReference(queue, value, entry, this.weight);
        }
    }

    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int weight;

        WeightedStrongValueReference(V referent, int weight) {
            super(referent);
            this.weight = weight;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.StrongValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    int hash(Object key) {
        return rehash(this.keyEquivalence.hash(key));
    }

    void reclaimValue(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    void reclaimKey(ReferenceEntry<K, V> entry) {
        int hash = entry.getHash();
        segmentFor(hash).reclaimKey(entry, hash);
    }

    Segment<K, V> segmentFor(int hash) {
        return this.segments[(hash >>> this.segmentShift) & this.segmentMask];
    }

    Segment<K, V> createSegment(int initialCapacity, long maxSegmentWeight, AbstractCache.StatsCounter statsCounter) {
        return new Segment<>(this, initialCapacity, maxSegmentWeight, statsCounter);
    }

    V getLiveValue(ReferenceEntry<K, V> entry, long now) {
        V v;
        if (entry.getKey() == null || (v = entry.getValueReference().get()) == null || isExpired(entry, now)) {
            return null;
        }
        return v;
    }

    boolean isExpired(ReferenceEntry<K, V> entry, long now) {
        Preconditions.checkNotNull(entry);
        if (!expiresAfterAccess() || now - entry.getAccessTime() < this.expireAfterAccessNanos) {
            return expiresAfterWrite() && now - entry.getWriteTime() >= this.expireAfterWriteNanos;
        }
        return true;
    }

    static <K, V> void connectAccessOrder(ReferenceEntry<K, V> previous, ReferenceEntry<K, V> next) {
        previous.setNextInAccessQueue(next);
        next.setPreviousInAccessQueue(previous);
    }

    static <K, V> void nullifyAccessOrder(ReferenceEntry<K, V> nulled) {
        ReferenceEntry<K, V> referenceEntryNullEntry = nullEntry();
        nulled.setNextInAccessQueue(referenceEntryNullEntry);
        nulled.setPreviousInAccessQueue(referenceEntryNullEntry);
    }

    static <K, V> void connectWriteOrder(ReferenceEntry<K, V> previous, ReferenceEntry<K, V> next) {
        previous.setNextInWriteQueue(next);
        next.setPreviousInWriteQueue(previous);
    }

    static <K, V> void nullifyWriteOrder(ReferenceEntry<K, V> nulled) {
        ReferenceEntry<K, V> referenceEntryNullEntry = nullEntry();
        nulled.setNextInWriteQueue(referenceEntryNullEntry);
        nulled.setPreviousInWriteQueue(referenceEntryNullEntry);
    }

    void processPendingNotifications() {
        while (true) {
            RemovalNotification<K, V> removalNotificationPoll = this.removalNotificationQueue.poll();
            if (removalNotificationPoll == null) {
                return;
            }
            try {
                this.removalListener.onRemoval(removalNotificationPoll);
            } catch (Throwable th) {
                logger.logp(Level.WARNING, "androidx.test.espresso.core.internal.deps.guava.cache.LocalCache", "processPendingNotifications", "Exception thrown by removal listener", th);
            }
        }
    }

    final Segment<K, V>[] newSegmentArray(int ssize) {
        return new Segment[ssize];
    }

    static class Segment<K, V> extends ReentrantLock {
        final Queue<ReferenceEntry<K, V>> accessQueue;
        volatile int count;
        final ReferenceQueue<K> keyReferenceQueue;
        final LocalCache<K, V> map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue<ReferenceEntry<K, V>> recencyQueue;
        final AbstractCache.StatsCounter statsCounter;
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        int threshold;
        long totalWeight;
        final ReferenceQueue<V> valueReferenceQueue;
        final Queue<ReferenceEntry<K, V>> writeQueue;

        Segment(LocalCache<K, V> map, int initialCapacity, long maxSegmentWeight, AbstractCache.StatsCounter statsCounter) {
            Queue<ReferenceEntry<K, V>> queueDiscardingQueue;
            Queue<ReferenceEntry<K, V>> queueDiscardingQueue2;
            Queue<ReferenceEntry<K, V>> queueDiscardingQueue3;
            this.map = map;
            this.maxSegmentWeight = maxSegmentWeight;
            this.statsCounter = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter);
            initTable(newEntryArray(initialCapacity));
            this.keyReferenceQueue = map.usesKeyReferences() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = map.usesValueReferences() ? new ReferenceQueue<>() : null;
            if (map.usesAccessQueue()) {
                queueDiscardingQueue = new ConcurrentLinkedQueue<>();
            } else {
                queueDiscardingQueue = LocalCache.discardingQueue();
            }
            this.recencyQueue = queueDiscardingQueue;
            if (map.usesWriteQueue()) {
                queueDiscardingQueue2 = new WriteQueue<>();
            } else {
                queueDiscardingQueue2 = LocalCache.discardingQueue();
            }
            this.writeQueue = queueDiscardingQueue2;
            if (map.usesAccessQueue()) {
                queueDiscardingQueue3 = new AccessQueue<>();
            } else {
                queueDiscardingQueue3 = LocalCache.discardingQueue();
            }
            this.accessQueue = queueDiscardingQueue3;
        }

        AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int size) {
            return new AtomicReferenceArray<>(size);
        }

        void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> newTable) {
            this.threshold = (newTable.length() * 3) / 4;
            if (!this.map.customWeigher()) {
                int i = this.threshold;
                if (i == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = newTable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        ReferenceEntry<K, V> newEntry(K key, int hash, ReferenceEntry<K, V> next) {
            return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(key), hash, next);
        }

        ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext) {
            if (original.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = original.getValueReference();
            V v = valueReference.get();
            if (v == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> referenceEntryCopyEntry = this.map.entryFactory.copyEntry(this, original, newNext);
            referenceEntryCopyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, v, referenceEntryCopyEntry));
            return referenceEntryCopyEntry;
        }

        void setValue(ReferenceEntry<K, V> entry, K key, V value, long now) {
            ValueReference<K, V> valueReference = entry.getValueReference();
            int iWeigh = this.map.weigher.weigh(key, value);
            Preconditions.checkState(iWeigh >= 0, "Weights must be non-negative");
            entry.setValueReference(this.map.valueStrength.referenceValue(this, entry, value, iWeigh));
            recordWrite(entry, iWeigh, now);
            valueReference.notifyNewValue(value);
        }

        V get(Object key, int hash) {
            try {
                if (this.count != 0) {
                    long j = this.map.ticker.read();
                    ReferenceEntry<K, V> liveEntry = getLiveEntry(key, hash, j);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v = liveEntry.getValueReference().get();
                    if (v != null) {
                        recordRead(liveEntry, j);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), hash, v, j, this.map.defaultLoader);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        ListenableFuture<V> loadAsync(final K key, final int hash, final LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> loader) {
            final ListenableFuture<V> listenableFutureLoadFuture = loadingValueReference.loadFuture(key, loader);
            listenableFutureLoadFuture.addListener(new Runnable() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(key, hash, loadingValueReference, listenableFutureLoadFuture);
                    } catch (Throwable th) {
                        LocalCache.logger.logp(Level.WARNING, "androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$Segment$1", "run", "Exception thrown during refresh", th);
                        loadingValueReference.setException(th);
                    }
                }
            }, MoreExecutors.directExecutor());
            return listenableFutureLoadFuture;
        }

        /* JADX WARN: Undo finally extract visitor
        java.lang.NullPointerException
         */
        V getAndRecordStats(K k, int i, LoadingValueReference<K, V> loadingValueReference, ListenableFuture<V> listenableFuture) throws Throwable {
            V v;
            try {
                v = (V) Uninterruptibles.getUninterruptibly(listenableFuture);
                try {
                    if (v == null) {
                        String strValueOf = String.valueOf(k);
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 35);
                        sb.append("CacheLoader returned null for key ");
                        sb.append(strValueOf);
                        sb.append(".");
                        throw new CacheLoader.InvalidCacheLoadException(sb.toString());
                    }
                    this.statsCounter.recordLoadSuccess(loadingValueReference.elapsedNanos());
                    storeLoadedValue(k, i, loadingValueReference, v);
                    if (v == null) {
                        this.statsCounter.recordLoadException(loadingValueReference.elapsedNanos());
                        removeLoadingValue(k, i, loadingValueReference);
                    }
                    return v;
                } catch (Throwable th) {
                    th = th;
                    if (v == null) {
                        this.statsCounter.recordLoadException(loadingValueReference.elapsedNanos());
                        removeLoadingValue(k, i, loadingValueReference);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                v = null;
            }
        }

        V scheduleRefresh(ReferenceEntry<K, V> entry, K key, int hash, V oldValue, long now, CacheLoader<? super K, V> loader) {
            V vRefresh;
            return (!this.map.refreshes() || now - entry.getWriteTime() <= this.map.refreshNanos || entry.getValueReference().isLoading() || (vRefresh = refresh(key, hash, loader, true)) == null) ? oldValue : vRefresh;
        }

        V refresh(K k, int i, CacheLoader<? super K, V> cacheLoader, boolean z) {
            LoadingValueReference<K, V> loadingValueReferenceInsertLoadingValueReference = insertLoadingValueReference(k, i, z);
            if (loadingValueReferenceInsertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> listenableFutureLoadAsync = loadAsync(k, i, loadingValueReferenceInsertLoadingValueReference, cacheLoader);
            if (listenableFutureLoadAsync.isDone()) {
                try {
                    return (V) Uninterruptibles.getUninterruptibly(listenableFutureLoadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        LoadingValueReference<K, V> insertLoadingValueReference(K k, int i, boolean z) {
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry<K, V> referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(k, key)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        if (!valueReference.isLoading() && (!z || j - next.getWriteTime() >= this.map.refreshNanos)) {
                            this.modCount++;
                            LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference<>(valueReference);
                            next.setValueReference(loadingValueReference);
                            return loadingValueReference;
                        }
                        return null;
                    }
                }
                this.modCount++;
                LoadingValueReference<K, V> loadingValueReference2 = new LoadingValueReference<>();
                ReferenceEntry<K, V> referenceEntryNewEntry = newEntry(k, i, referenceEntry);
                referenceEntryNewEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                return loadingValueReference2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends K> referencePoll = this.keyReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimKey((ReferenceEntry) referencePoll);
                i++;
            } while (i != 16);
        }

        void drainValueReferenceQueue() {
            int i = 0;
            do {
                Reference<? extends V> referencePoll = this.valueReferenceQueue.poll();
                if (referencePoll == null) {
                    return;
                }
                this.map.reclaimValue((ValueReference) referencePoll);
                i++;
            } while (i != 16);
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        void recordRead(ReferenceEntry<K, V> entry, long now) {
            if (this.map.recordsAccess()) {
                entry.setAccessTime(now);
            }
            this.recencyQueue.add(entry);
        }

        void recordLockedRead(ReferenceEntry<K, V> entry, long now) {
            if (this.map.recordsAccess()) {
                entry.setAccessTime(now);
            }
            this.accessQueue.add(entry);
        }

        void recordWrite(ReferenceEntry<K, V> entry, int weight, long now) {
            drainRecencyQueue();
            this.totalWeight += (long) weight;
            if (this.map.recordsAccess()) {
                entry.setAccessTime(now);
            }
            if (this.map.recordsWrite()) {
                entry.setWriteTime(now);
            }
            this.accessQueue.add(entry);
            this.writeQueue.add(entry);
        }

        void drainRecencyQueue() {
            while (true) {
                ReferenceEntry<K, V> referenceEntryPoll = this.recencyQueue.poll();
                if (referenceEntryPoll == null) {
                    return;
                }
                if (this.accessQueue.contains(referenceEntryPoll)) {
                    this.accessQueue.add(referenceEntryPoll);
                }
            }
        }

        void tryExpireEntries(long now) {
            if (tryLock()) {
                try {
                    expireEntries(now);
                } finally {
                    unlock();
                }
            }
        }

        void expireEntries(long now) {
            ReferenceEntry<K, V> referenceEntryPeek;
            ReferenceEntry<K, V> referenceEntryPeek2;
            drainRecencyQueue();
            do {
                referenceEntryPeek = this.writeQueue.peek();
                if (referenceEntryPeek == null || !this.map.isExpired(referenceEntryPeek, now)) {
                    do {
                        referenceEntryPeek2 = this.accessQueue.peek();
                        if (referenceEntryPeek2 == null || !this.map.isExpired(referenceEntryPeek2, now)) {
                            return;
                        }
                    } while (removeEntry(referenceEntryPeek2, referenceEntryPeek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(referenceEntryPeek, referenceEntryPeek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        void enqueueNotification(K key, int hash, V value, int weight, RemovalCause cause) {
            this.totalWeight -= (long) weight;
            if (cause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE) {
                this.map.removalNotificationQueue.offer(RemovalNotification.create(key, value, cause));
            }
        }

        void evictEntries(ReferenceEntry<K, V> newest) {
            if (this.map.evictsBySize()) {
                drainRecencyQueue();
                if (newest.getValueReference().getWeight() > this.maxSegmentWeight && !removeEntry(newest, newest.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    ReferenceEntry<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        ReferenceEntry<K, V> getNextEvictable() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        ReferenceEntry<K, V> getFirst(int hash) {
            return this.table.get(hash & (r0.length() - 1));
        }

        ReferenceEntry<K, V> getEntry(Object key, int hash) {
            for (ReferenceEntry<K, V> first = getFirst(hash); first != null; first = first.getNext()) {
                if (first.getHash() == hash) {
                    K key2 = first.getKey();
                    if (key2 == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(key, key2)) {
                        return first;
                    }
                }
            }
            return null;
        }

        ReferenceEntry<K, V> getLiveEntry(Object key, int hash, long now) {
            ReferenceEntry<K, V> entry = getEntry(key, hash);
            if (entry == null) {
                return null;
            }
            if (!this.map.isExpired(entry, now)) {
                return entry;
            }
            tryExpireEntries(now);
            return null;
        }

        V getLiveValue(ReferenceEntry<K, V> entry, long now) {
            if (entry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v = entry.getValueReference().get();
            if (v == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.isExpired(entry, now)) {
                return v;
            }
            tryExpireEntries(now);
            return null;
        }

        boolean containsKey(Object key, int hash) {
            try {
                if (this.count == 0) {
                    return false;
                }
                ReferenceEntry<K, V> liveEntry = getLiveEntry(key, hash, this.map.ticker.read());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        V put(K key, int hash, V value, boolean onlyIfAbsent) {
            int i;
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.keyEquivalence.equivalent(key, key2)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            if (onlyIfAbsent) {
                                recordLockedRead(next, j);
                            } else {
                                this.modCount++;
                                enqueueNotification(key, hash, v, valueReference.getWeight(), RemovalCause.REPLACED);
                                setValue(next, key, value, j);
                                evictEntries(next);
                            }
                            return v;
                        }
                        this.modCount++;
                        if (valueReference.isActive()) {
                            enqueueNotification(key, hash, v, valueReference.getWeight(), RemovalCause.COLLECTED);
                            setValue(next, key, value, j);
                            i = this.count;
                        } else {
                            setValue(next, key, value, j);
                            i = this.count + 1;
                        }
                        this.count = i;
                        evictEntries(next);
                        return null;
                    }
                }
                this.modCount++;
                ReferenceEntry<K, V> referenceEntryNewEntry = newEntry(key, hash, referenceEntry);
                setValue(referenceEntryNewEntry, key, value, j);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                this.count++;
                evictEntries(referenceEntryNewEntry);
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                ReferenceEntry<K, V> next = atomicReferenceArray.get(i2);
                if (next != null) {
                    ReferenceEntry<K, V> next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, next);
                    } else {
                        ReferenceEntry<K, V> referenceEntry = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                referenceEntry = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, referenceEntry);
                        while (next != referenceEntry) {
                            int hash3 = next.getHash() & length2;
                            ReferenceEntry<K, V> referenceEntryCopyEntry = copyEntry(next, atomicReferenceArrayNewEntryArray.get(hash3));
                            if (referenceEntryCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, referenceEntryCopyEntry);
                            } else {
                                removeCollectedEntry(next);
                                i--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArrayNewEntryArray;
            this.count = i;
        }

        boolean replace(K key, int hash, V oldValue, V newValue) {
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null) {
                        if (this.map.keyEquivalence.equivalent(key, key2)) {
                            ValueReference<K, V> valueReference = next.getValueReference();
                            V v = valueReference.get();
                            if (v == null) {
                                if (!valueReference.isActive()) {
                                    break;
                                }
                                this.modCount++;
                                ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key2, hash, v, valueReference, RemovalCause.COLLECTED);
                                int i = this.count - 1;
                                atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                                this.count = i;
                                break;
                            }
                            if (this.map.valueEquivalence.equivalent(oldValue, v)) {
                                this.modCount++;
                                enqueueNotification(key, hash, v, valueReference.getWeight(), RemovalCause.REPLACED);
                                setValue(next, key, newValue, j);
                                evictEntries(next);
                                return true;
                            }
                            recordLockedRead(next, j);
                            break;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        V replace(K key, int hash, V newValue) {
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null) {
                        if (this.map.keyEquivalence.equivalent(key, key2)) {
                            ValueReference<K, V> valueReference = next.getValueReference();
                            V v = valueReference.get();
                            if (v == null) {
                                if (!valueReference.isActive()) {
                                    break;
                                }
                                this.modCount++;
                                ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key2, hash, v, valueReference, RemovalCause.COLLECTED);
                                int i = this.count - 1;
                                atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                                this.count = i;
                                break;
                            }
                            this.modCount++;
                            enqueueNotification(key, hash, v, valueReference.getWeight(), RemovalCause.REPLACED);
                            setValue(next, key, newValue, j);
                            evictEntries(next);
                            return v;
                        }
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        V remove(Object key, int hash) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.ticker.read());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.keyEquivalence.equivalent(key, key2)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        V v = valueReference.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else {
                            if (!valueReference.isActive()) {
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.modCount++;
                        ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key2, hash, v, valueReference, removalCause2);
                        int i = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean remove(Object key, int hash, Object value) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.ticker.read());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.keyEquivalence.equivalent(key, key2)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        V v = valueReference.get();
                        if (this.map.valueEquivalence.equivalent(value, v)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else {
                            if (v != null || !valueReference.isActive()) {
                                break;
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key2, hash, v, valueReference, removalCause);
                        int i = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i;
                        return removalCause == RemovalCause.EXPLICIT;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean storeLoadedValue(K key, int hash, LoadingValueReference<K, V> oldValueReference, V newValue) {
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                int i = this.count + 1;
                if (i > this.threshold) {
                    expand();
                    i = this.count + 1;
                }
                int i2 = i;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = hash & (atomicReferenceArray.length() - 1);
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.keyEquivalence.equivalent(key, key2)) {
                        ValueReference<K, V> valueReference = next.getValueReference();
                        V v = valueReference.get();
                        if (oldValueReference != valueReference && (v != null || valueReference == LocalCache.UNSET)) {
                            enqueueNotification(key, hash, newValue, 0, RemovalCause.REPLACED);
                            return false;
                        }
                        this.modCount++;
                        if (oldValueReference.isActive()) {
                            enqueueNotification(key, hash, v, oldValueReference.getWeight(), v == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i2--;
                        }
                        setValue(next, key, newValue, j);
                        this.count = i2;
                        evictEntries(next);
                        return true;
                    }
                }
                this.modCount++;
                ReferenceEntry<K, V> referenceEntryNewEntry = newEntry(key, hash, referenceEntry);
                setValue(referenceEntryNewEntry, key, newValue, j);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                this.count = i2;
                evictEntries(referenceEntryNewEntry);
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.ticker.read());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry<K, V> next = atomicReferenceArray.get(i); next != null; next = next.getNext()) {
                            if (next.getValueReference().isActive()) {
                                K key = next.getKey();
                                V v = next.getValueReference().get();
                                enqueueNotification(key, next.getHash(), v, next.getValueReference().getWeight(), (key == null || v == null) ? RemovalCause.COLLECTED : RemovalCause.EXPLICIT);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> first, ReferenceEntry<K, V> entry, K key, int hash, V value, ValueReference<K, V> valueReference, RemovalCause cause) {
            enqueueNotification(key, hash, value, valueReference.getWeight(), cause);
            this.writeQueue.remove(entry);
            this.accessQueue.remove(entry);
            if (valueReference.isLoading()) {
                valueReference.notifyNewValue(null);
                return first;
            }
            return removeEntryFromChain(first, entry);
        }

        ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> first, ReferenceEntry<K, V> entry) {
            int i = this.count;
            ReferenceEntry<K, V> next = entry.getNext();
            while (first != entry) {
                ReferenceEntry<K, V> referenceEntryCopyEntry = copyEntry(first, next);
                if (referenceEntryCopyEntry != null) {
                    next = referenceEntryCopyEntry;
                } else {
                    removeCollectedEntry(first);
                    i--;
                }
                first = first.getNext();
            }
            this.count = i;
            return next;
        }

        void removeCollectedEntry(ReferenceEntry<K, V> entry) {
            enqueueNotification(entry.getKey(), entry.getHash(), entry.getValueReference().get(), entry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(entry);
            this.accessQueue.remove(entry);
        }

        boolean reclaimKey(ReferenceEntry<K, V> entry, int hash) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    if (next == entry) {
                        this.modCount++;
                        ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, next.getKey(), hash, next.getValueReference().get(), next.getValueReference(), RemovalCause.COLLECTED);
                        int i = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean reclaimValue(K key, int hash, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.keyEquivalence.equivalent(key, key2)) {
                        if (next.getValueReference() != valueReference) {
                            return false;
                        }
                        this.modCount++;
                        ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key2, hash, valueReference.get(), valueReference, RemovalCause.COLLECTED);
                        int i = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        boolean removeLoadingValue(K key, int hash, LoadingValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & hash;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                    K key2 = next.getKey();
                    if (next.getHash() == hash && key2 != null && this.map.keyEquivalence.equivalent(key, key2)) {
                        if (next.getValueReference() != valueReference) {
                            break;
                        }
                        if (valueReference.isActive()) {
                            next.setValueReference(valueReference.getOldValue());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, next));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean removeEntry(ReferenceEntry<K, V> entry, int hash, RemovalCause cause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & hash;
            ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> next = referenceEntry; next != null; next = next.getNext()) {
                if (next == entry) {
                    this.modCount++;
                    ReferenceEntry<K, V> referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, next.getKey(), hash, next.getValueReference().get(), next.getValueReference(), cause);
                    int i = this.count - 1;
                    atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                    this.count = i;
                    return true;
                }
            }
            return false;
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        void preWriteCleanup(long now) {
            runLockedCleanup(now);
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void cleanUp() {
            runLockedCleanup(this.map.ticker.read());
            runUnlockedCleanup();
        }

        void runLockedCleanup(long now) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(now);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.processPendingNotifications();
        }
    }

    static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        final SettableFuture<V> futureValue;
        volatile ValueReference<K, V> oldValue;
        final Stopwatch stopwatch;

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, ReferenceEntry<K, V> entry) {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        public LoadingValueReference() {
            this(LocalCache.unset());
        }

        public LoadingValueReference(ValueReference<K, V> oldValue) {
            this.futureValue = SettableFuture.create();
            this.stopwatch = Stopwatch.createUnstarted();
            this.oldValue = oldValue;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.oldValue.isActive();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.oldValue.getWeight();
        }

        public boolean set(V newValue) {
            return this.futureValue.set(newValue);
        }

        public boolean setException(Throwable t) {
            return this.futureValue.setException(t);
        }

        private ListenableFuture<V> fullyFailedFuture(Throwable t) {
            return Futures.immediateFailedFuture(t);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(V newValue) {
            if (newValue != null) {
                set(newValue);
            } else {
                this.oldValue = LocalCache.unset();
            }
        }

        public ListenableFuture<V> loadFuture(K key, CacheLoader<? super K, V> loader) {
            try {
                this.stopwatch.start();
                V v = this.oldValue.get();
                if (v == null) {
                    V vLoad = loader.load(key);
                    return set(vLoad) ? this.futureValue : Futures.immediateFuture(vLoad);
                }
                ListenableFuture<V> listenableFutureReload = loader.reload(key, v);
                if (listenableFutureReload == null) {
                    return Futures.immediateFuture(null);
                }
                return Futures.transform(listenableFutureReload, new androidx.test.espresso.core.internal.deps.guava.base.Function<V, V>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.LoadingValueReference.1
                    @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
                    public V apply(V newValue) {
                        LoadingValueReference.this.set(newValue);
                        return newValue;
                    }
                }, MoreExecutors.directExecutor());
            } catch (Throwable th) {
                ListenableFuture<V> listenableFutureFullyFailedFuture = setException(th) ? this.futureValue : fullyFailedFuture(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return listenableFutureFullyFailedFuture;
            }
        }

        public long elapsedNanos() {
            return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public V get() {
            return this.oldValue.get();
        }

        public ValueReference<K, V> getOldValue() {
            return this.oldValue;
        }
    }

    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>(this) { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WriteQueue.1
            ReferenceEntry<K, V> nextWrite = this;
            ReferenceEntry<K, V> previousWrite = this;

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setWriteTime(long time) {
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.nextWrite;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setNextInWriteQueue(ReferenceEntry<K, V> next) {
                this.nextWrite = next;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.previousWrite;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setPreviousInWriteQueue(ReferenceEntry<K, V> previous) {
                this.previousWrite = previous;
            }
        };

        WriteQueue() {
        }

        @Override // java.util.Queue
        public boolean offer(ReferenceEntry<K, V> entry) {
            LocalCache.connectWriteOrder(entry.getPreviousInWriteQueue(), entry.getNextInWriteQueue());
            LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), entry);
            LocalCache.connectWriteOrder(entry, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object o) {
            ReferenceEntry referenceEntry = (ReferenceEntry) o;
            ReferenceEntry<K, V> previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.connectWriteOrder(previousInWriteQueue, nextInWriteQueue);
            LocalCache.nullifyWriteOrder(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o) {
            return ((ReferenceEntry) o).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.head.getNextInWriteQueue() == this.head;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue(); nextInWriteQueue != this.head; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.head.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.head;
                if (nextInWriteQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.nullifyWriteOrder(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WriteQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // androidx.test.espresso.core.internal.deps.guava.collect.AbstractSequentialIterator
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> previous) {
                    ReferenceEntry<K, V> nextInWriteQueue = previous.getNextInWriteQueue();
                    if (nextInWriteQueue == WriteQueue.this.head) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
            };
        }
    }

    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> head = new AbstractReferenceEntry<K, V>(this) { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AccessQueue.1
            ReferenceEntry<K, V> nextAccess = this;
            ReferenceEntry<K, V> previousAccess = this;

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setAccessTime(long time) {
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.nextAccess;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setNextInAccessQueue(ReferenceEntry<K, V> next) {
                this.nextAccess = next;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.previousAccess;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setPreviousInAccessQueue(ReferenceEntry<K, V> previous) {
                this.previousAccess = previous;
            }
        };

        AccessQueue() {
        }

        @Override // java.util.Queue
        public boolean offer(ReferenceEntry<K, V> entry) {
            LocalCache.connectAccessOrder(entry.getPreviousInAccessQueue(), entry.getNextInAccessQueue());
            LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), entry);
            LocalCache.connectAccessOrder(entry, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object o) {
            ReferenceEntry referenceEntry = (ReferenceEntry) o;
            ReferenceEntry<K, V> previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.connectAccessOrder(previousInAccessQueue, nextInAccessQueue);
            LocalCache.nullifyAccessOrder(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o) {
            return ((ReferenceEntry) o).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.head.getNextInAccessQueue() == this.head;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue(); nextInAccessQueue != this.head; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.head.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.head;
                if (nextInAccessQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.nullifyAccessOrder(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AccessQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // androidx.test.espresso.core.internal.deps.guava.collect.AbstractSequentialIterator
                public ReferenceEntry<K, V> computeNext(ReferenceEntry<K, V> previous) {
                    ReferenceEntry<K, V> nextInAccessQueue = previous.getNextInAccessQueue();
                    if (nextInAccessQueue == AccessQueue.this.head) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
            };
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += (long) segmentArr[i].modCount;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j -= (long) segmentArr[i2].modCount;
        }
        return j == 0;
    }

    long longSize() {
        long jMax = 0;
        for (Segment<K, V> segment : this.segments) {
            jMax += (long) Math.max(0, segment.count);
        }
        return jMax;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return androidx.test.espresso.core.internal.deps.guava.primitives.Ints.saturatedCast(longSize());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        if (key == null) {
            return null;
        }
        int iHash = hash(key);
        return segmentFor(iHash).get(key, iHash);
    }

    public V getIfPresent(Object key) {
        int iHash = hash(Preconditions.checkNotNull(key));
        V v = segmentFor(iHash).get(key, iHash);
        if (v == null) {
            this.globalStatsCounter.recordMisses(1);
        } else {
            this.globalStatsCounter.recordHits(1);
        }
        return v;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public V getOrDefault(Object key, V defaultValue) {
        V v = get(key);
        return v != null ? v : defaultValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        int iHash = hash(key);
        return segmentFor(iHash).containsKey(key, iHash);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }
        long j = this.ticker.read();
        Segment<K, V>[] segmentArr = this.segments;
        long j2 = -1;
        int i = 0;
        while (i < 3) {
            int length = segmentArr.length;
            long j3 = 0;
            int i2 = 0;
            while (i2 < length) {
                Segment<K, V> segment = segmentArr[i2];
                int i3 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    ReferenceEntry<K, V> next = atomicReferenceArray.get(i4);
                    while (next != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(next, j);
                        long j4 = j;
                        if (liveValue != null && this.valueEquivalence.equivalent(value, liveValue)) {
                            return true;
                        }
                        next = next.getNext();
                        segmentArr = segmentArr2;
                        j = j4;
                    }
                }
                j3 += (long) segment.modCount;
                i2++;
                j = j;
            }
            long j5 = j;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j3 == j2) {
                return false;
            }
            i++;
            j2 = j3;
            segmentArr = segmentArr3;
            j = j5;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(value);
        int iHash = hash(key);
        return segmentFor(iHash).put(key, iHash, value, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K key, V value) {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(value);
        int iHash = hash(key);
        return segmentFor(iHash).put(key, iHash, value, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        if (key == null) {
            return null;
        }
        int iHash = hash(key);
        return segmentFor(iHash).remove(key, iHash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object key, Object value) {
        if (key == null || value == null) {
            return false;
        }
        int iHash = hash(key);
        return segmentFor(iHash).remove(key, iHash, value);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean replace(K key, V oldValue, V newValue) {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(newValue);
        if (oldValue == null) {
            return false;
        }
        int iHash = hash(key);
        return segmentFor(iHash).replace(key, iHash, oldValue, newValue);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V replace(K key, V value) {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(value);
        int iHash = hash(key);
        return segmentFor(iHash).replace(key, iHash, value);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet(this);
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values(this);
        this.values = values;
        return values;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet(this);
        this.entrySet = entrySet;
        return entrySet;
    }

    abstract class HashIterator<T> implements Iterator<T> {
        Segment<K, V> currentSegment;
        AtomicReferenceArray<ReferenceEntry<K, V>> currentTable;
        LocalCache<K, V>.WriteThroughEntry lastReturned;
        ReferenceEntry<K, V> nextEntry;
        LocalCache<K, V>.WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex = -1;

        HashIterator() {
            this.nextSegmentIndex = LocalCache.this.segments.length - 1;
            advance();
        }

        final void advance() {
            this.nextExternal = null;
            if (nextInChain() || nextInTable()) {
                return;
            }
            while (this.nextSegmentIndex >= 0) {
                Segment<K, V>[] segmentArr = LocalCache.this.segments;
                int i = this.nextSegmentIndex;
                this.nextSegmentIndex = i - 1;
                Segment<K, V> segment = segmentArr[i];
                this.currentSegment = segment;
                if (segment.count != 0) {
                    this.currentTable = this.currentSegment.table;
                    this.nextTableIndex = r0.length() - 1;
                    if (nextInTable()) {
                        return;
                    }
                }
            }
        }

        boolean nextInChain() {
            ReferenceEntry<K, V> referenceEntry = this.nextEntry;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.nextEntry = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.nextEntry;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (advanceTo(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.nextEntry;
            }
        }

        boolean nextInTable() {
            while (true) {
                int i = this.nextTableIndex;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.currentTable;
                this.nextTableIndex = i - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i);
                this.nextEntry = referenceEntry;
                if (referenceEntry != null && (advanceTo(referenceEntry) || nextInChain())) {
                    return true;
                }
            }
        }

        boolean advanceTo(ReferenceEntry<K, V> entry) {
            Segment<K, V> segment;
            try {
                long j = LocalCache.this.ticker.read();
                K key = entry.getKey();
                Object liveValue = LocalCache.this.getLiveValue(entry, j);
                if (liveValue == null) {
                    return false;
                }
                this.nextExternal = new WriteThroughEntry(key, liveValue);
                return true;
            } finally {
                this.currentSegment.postReadCleanup();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextExternal != null;
        }

        LocalCache<K, V>.WriteThroughEntry nextEntry() {
            LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.nextExternal;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = writeThroughEntry;
            advance();
            return this.lastReturned;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.lastReturned != null);
            LocalCache.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }
    }

    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator(final LocalCache this$0) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator(final LocalCache this$0) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    final class WriteThroughEntry implements Map.Entry<K, V> {
        final K key;
        V value;

        WriteThroughEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) object;
            return this.key.equals(entry.getKey()) && this.value.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.value.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) LocalCache.this.put(this.key, v);
            this.value = v;
            return v2;
        }

        public String toString() {
            String strValueOf = String.valueOf(getKey());
            String strValueOf2 = String.valueOf(getValue());
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length());
            sb.append(strValueOf);
            sb.append("=");
            sb.append(strValueOf2);
            return sb.toString();
        }
    }

    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(final LocalCache this$0) {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        final java.util.concurrent.ConcurrentMap<?, ?> map;

        AbstractCacheSet(final LocalCache this$0, java.util.concurrent.ConcurrentMap<?, ?> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> c) {
        ArrayList<E> arrayList = new ArrayList<>(c.size());
        Iterators.addAll(arrayList, c.iterator());
        return arrayList;
    }

    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet(java.util.concurrent.ConcurrentMap<?, ?> map) {
            super(LocalCache.this, map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return this.map.containsKey(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return this.map.remove(o) != null;
        }
    }

    final class Values extends AbstractCollection<V> {
        private final java.util.concurrent.ConcurrentMap<?, ?> map;

        Values(java.util.concurrent.ConcurrentMap<?, ?> map) {
            this.map = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.map.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o) {
            return this.map.containsValue(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.toArrayList(this).toArray(eArr);
        }
    }

    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet(java.util.concurrent.ConcurrentMap<?, ?> map) {
            super(LocalCache.this, map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            Map.Entry entry;
            Object key;
            Object obj;
            return (o instanceof Map.Entry) && (key = (entry = (Map.Entry) o).getKey()) != null && (obj = LocalCache.this.get(key)) != null && LocalCache.this.valueEquivalence.equivalent(entry.getValue(), obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            Map.Entry entry;
            Object key;
            return (o instanceof Map.Entry) && (key = (entry = (Map.Entry) o).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        transient Cache<K, V> delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence<Object> keyEquivalence;
        final Strength keyStrength;
        final CacheLoader<? super K, V> loader;
        final long maxWeight;
        final RemovalListener<? super K, ? super V> removalListener;
        final Ticker ticker;
        final Equivalence<Object> valueEquivalence;
        final Strength valueStrength;
        final Weigher<K, V> weigher;

        ManualSerializationProxy(LocalCache<K, V> cache) {
            this(cache.keyStrength, cache.valueStrength, cache.keyEquivalence, cache.valueEquivalence, cache.expireAfterWriteNanos, cache.expireAfterAccessNanos, cache.maxWeight, cache.weigher, cache.concurrencyLevel, cache.removalListener, cache.ticker, cache.defaultLoader);
        }

        private ManualSerializationProxy(Strength keyStrength, Strength valueStrength, Equivalence<Object> keyEquivalence, Equivalence<Object> valueEquivalence, long expireAfterWriteNanos, long expireAfterAccessNanos, long maxWeight, Weigher<K, V> weigher, int concurrencyLevel, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> loader) {
            this.keyStrength = keyStrength;
            this.valueStrength = valueStrength;
            this.keyEquivalence = keyEquivalence;
            this.valueEquivalence = valueEquivalence;
            this.expireAfterWriteNanos = expireAfterWriteNanos;
            this.expireAfterAccessNanos = expireAfterAccessNanos;
            this.maxWeight = maxWeight;
            this.weigher = weigher;
            this.concurrencyLevel = concurrencyLevel;
            this.removalListener = removalListener;
            this.ticker = (ticker == Ticker.systemTicker() || ticker == CacheBuilder.NULL_TICKER) ? null : ticker;
            this.loader = loader;
        }

        CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
            cacheBuilder.strictParsing = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                cacheBuilder.expireAfterWrite(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                cacheBuilder.expireAfterAccess(j2, TimeUnit.NANOSECONDS);
            }
            if (this.weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.weigher(this.weigher);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    cacheBuilder.maximumWeight(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    cacheBuilder.maximumSize(j4);
                }
            }
            Ticker ticker = this.ticker;
            if (ticker != null) {
                cacheBuilder.ticker(ticker);
            }
            return cacheBuilder;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = (Cache<K, V>) recreateCacheBuilder().build();
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ForwardingCache, androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache<K, V> localCache;

        LocalManualCache(CacheBuilder<? super K, ? super V> builder) {
            this(new LocalCache(builder, null));
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
        public V getIfPresent(Object key) {
            return this.localCache.getIfPresent(key);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
        public void put(K key, V value) {
            this.localCache.put(key, value);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }
    }
}
