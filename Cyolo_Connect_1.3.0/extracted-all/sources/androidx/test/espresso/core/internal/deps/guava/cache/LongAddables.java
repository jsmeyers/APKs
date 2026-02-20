package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LongAddables.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Supplier
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LongAddables.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Supplier
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }

    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LongAddable
        public void add(long x) {
            getAndAdd(x);
        }
    }
}
