package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;
import j$.util.function.Supplier;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
class StreamSpliterators$DelegatingSpliterator implements Spliterator {
    private Spliterator s;
    private final Supplier supplier;

    static final class OfDouble extends OfPrimitive implements Spliterator.OfDouble {
        OfDouble(Supplier supplier) {
            super(supplier);
        }

        @Override // j$.util.Spliterator.OfDouble
        public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
            super.forEachRemaining((Object) doubleConsumer);
        }

        @Override // j$.util.Spliterator.OfDouble
        public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
            return super.tryAdvance((Object) doubleConsumer);
        }

        @Override // j$.util.stream.StreamSpliterators$DelegatingSpliterator.OfPrimitive, j$.util.stream.StreamSpliterators$DelegatingSpliterator, j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
            return (Spliterator.OfDouble) super.trySplit();
        }
    }

    static final class OfInt extends OfPrimitive implements Spliterator.OfInt {
        OfInt(Supplier supplier) {
            super(supplier);
        }

        @Override // j$.util.Spliterator.OfInt
        public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
            super.forEachRemaining((Object) intConsumer);
        }

        @Override // j$.util.Spliterator.OfInt
        public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
            return super.tryAdvance((Object) intConsumer);
        }

        @Override // j$.util.stream.StreamSpliterators$DelegatingSpliterator.OfPrimitive, j$.util.stream.StreamSpliterators$DelegatingSpliterator, j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
            return (Spliterator.OfInt) super.trySplit();
        }
    }

    static final class OfLong extends OfPrimitive implements Spliterator.OfLong {
        OfLong(Supplier supplier) {
            super(supplier);
        }

        @Override // j$.util.Spliterator.OfLong
        public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
            super.forEachRemaining((Object) longConsumer);
        }

        @Override // j$.util.Spliterator.OfLong
        public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
            return super.tryAdvance((Object) longConsumer);
        }

        @Override // j$.util.stream.StreamSpliterators$DelegatingSpliterator.OfPrimitive, j$.util.stream.StreamSpliterators$DelegatingSpliterator, j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
            return (Spliterator.OfLong) super.trySplit();
        }
    }

    static class OfPrimitive extends StreamSpliterators$DelegatingSpliterator implements Spliterator.OfPrimitive {
        OfPrimitive(Supplier supplier) {
            super(supplier);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(Object obj) {
            ((Spliterator.OfPrimitive) get()).forEachRemaining(obj);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(Object obj) {
            return ((Spliterator.OfPrimitive) get()).tryAdvance(obj);
        }

        @Override // j$.util.stream.StreamSpliterators$DelegatingSpliterator, j$.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
            return (Spliterator.OfPrimitive) super.trySplit();
        }
    }

    StreamSpliterators$DelegatingSpliterator(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override // j$.util.Spliterator
    public int characteristics() {
        return get().characteristics();
    }

    @Override // j$.util.Spliterator
    public long estimateSize() {
        return get().estimateSize();
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(Consumer consumer) {
        get().forEachRemaining(consumer);
    }

    Spliterator get() {
        if (this.s == null) {
            this.s = (Spliterator) this.supplier.get();
        }
        return this.s;
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        return get().getComparator();
    }

    @Override // j$.util.Spliterator
    public long getExactSizeIfKnown() {
        return get().getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public /* synthetic */ boolean hasCharacteristics(int i) {
        return Spliterator.CC.$default$hasCharacteristics(this, i);
    }

    public String toString() {
        return getClass().getName() + "[" + get() + "]";
    }

    @Override // j$.util.Spliterator
    public boolean tryAdvance(Consumer consumer) {
        return get().tryAdvance(consumer);
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        return get().trySplit();
    }
}
