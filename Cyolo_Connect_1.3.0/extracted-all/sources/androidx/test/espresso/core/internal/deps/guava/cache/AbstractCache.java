package androidx.test.espresso.core.internal.deps.guava.cache;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    public interface StatsCounter {
        void recordEviction();

        void recordHits(int count);

        void recordLoadException(long loadTime);

        void recordLoadSuccess(long loadTime);

        void recordMisses(int count);
    }

    public static final class SimpleStatsCounter implements StatsCounter {
        private final LongAddable hitCount = LongAddables.create();
        private final LongAddable missCount = LongAddables.create();
        private final LongAddable loadSuccessCount = LongAddables.create();
        private final LongAddable loadExceptionCount = LongAddables.create();
        private final LongAddable totalLoadTime = LongAddables.create();
        private final LongAddable evictionCount = LongAddables.create();

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.AbstractCache.StatsCounter
        public void recordHits(int count) {
            this.hitCount.add(count);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.AbstractCache.StatsCounter
        public void recordMisses(int count) {
            this.missCount.add(count);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long loadTime) {
            this.loadSuccessCount.increment();
            this.totalLoadTime.add(loadTime);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.AbstractCache.StatsCounter
        public void recordLoadException(long loadTime) {
            this.loadExceptionCount.increment();
            this.totalLoadTime.add(loadTime);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.AbstractCache.StatsCounter
        public void recordEviction() {
            this.evictionCount.increment();
        }
    }
}
