package j$.util.stream;

import j$.util.IntSummaryStatisticsConversions;
import j$.util.OptionalConversions;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.IntBinaryOperator;
import j$.util.function.IntConsumer;
import j$.util.function.IntFunction;
import j$.util.function.IntPredicate;
import j$.util.function.IntToDoubleFunction;
import j$.util.function.IntToLongFunction;
import j$.util.function.IntUnaryOperator;
import j$.util.function.ObjIntConsumer;
import j$.util.function.Supplier;
import j$.util.stream.BaseStream;
import j$.util.stream.DoubleStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public interface IntStream extends BaseStream<Integer, IntStream> {

    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.IntStream convert(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream.new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return IntStream.this.allMatch(IntPredicate.VivifiedWrapper.convert(intPredicate));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ boolean anyMatch(java.util.function.IntPredicate intPredicate) {
            return IntStream.this.anyMatch(IntPredicate.VivifiedWrapper.convert(intPredicate));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.DoubleStream asDoubleStream() {
            return DoubleStream.Wrapper.convert(IntStream.this.asDoubleStream());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.LongStream asLongStream() {
            return LongStream.Wrapper.convert(IntStream.this.asLongStream());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ OptionalDouble average() {
            return OptionalConversions.convert(IntStream.this.average());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.convert(IntStream.this.boxed());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            IntStream.this.close();
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return IntStream.this.collect(Supplier.VivifiedWrapper.convert(supplier), ObjIntConsumer.VivifiedWrapper.convert(objIntConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ long count() {
            return IntStream.this.count();
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream distinct() {
            return convert(IntStream.this.distinct());
        }

        public /* synthetic */ boolean equals(Object obj) {
            IntStream intStream = IntStream.this;
            if (obj instanceof Wrapper) {
                obj = IntStream.this;
            }
            return intStream.equals(obj);
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream filter(java.util.function.IntPredicate intPredicate) {
            return convert(IntStream.this.filter(IntPredicate.VivifiedWrapper.convert(intPredicate)));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ OptionalInt findAny() {
            return OptionalConversions.convert(IntStream.this.findAny());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ OptionalInt findFirst() {
            return OptionalConversions.convert(IntStream.this.findFirst());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream flatMap(IntFunction intFunction) {
            return convert(IntStream.this.flatMap(IntFunction.VivifiedWrapper.convert(intFunction)));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ void forEach(IntConsumer intConsumer) {
            IntStream.this.forEach(IntConsumer.VivifiedWrapper.convert(intConsumer));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ void forEachOrdered(java.util.function.IntConsumer intConsumer) {
            IntStream.this.forEachOrdered(IntConsumer.VivifiedWrapper.convert(intConsumer));
        }

        public /* synthetic */ int hashCode() {
            return IntStream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return IntStream.this.isParallel();
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ Iterator<Integer> iterator() {
            return IntStream.this.iterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.PrimitiveIterator$OfInt] */
        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
        public /* synthetic */ Iterator<Integer> iterator2() {
            return PrimitiveIterator.OfInt.Wrapper.convert(IntStream.this.iterator());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream limit(long j) {
            return convert(IntStream.this.limit(j));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(IntStream.this.map(IntUnaryOperator.VivifiedWrapper.convert(intUnaryOperator)));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return DoubleStream.Wrapper.convert(IntStream.this.mapToDouble(IntToDoubleFunction.VivifiedWrapper.convert(intToDoubleFunction)));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return LongStream.Wrapper.convert(IntStream.this.mapToLong(IntToLongFunction.VivifiedWrapper.convert(intToLongFunction)));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.Stream mapToObj(java.util.function.IntFunction intFunction) {
            return Stream.Wrapper.convert(IntStream.this.mapToObj(IntFunction.VivifiedWrapper.convert(intFunction)));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ OptionalInt max() {
            return OptionalConversions.convert(IntStream.this.max());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ OptionalInt min() {
            return OptionalConversions.convert(IntStream.this.min());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ boolean noneMatch(java.util.function.IntPredicate intPredicate) {
            return IntStream.this.noneMatch(IntPredicate.VivifiedWrapper.convert(intPredicate));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.convert(IntStream.this.onClose(runnable));
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream parallel() {
            return BaseStream.Wrapper.convert(IntStream.this.parallel());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.IntStream parallel() {
            return convert(IntStream.this.parallel());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream peek(java.util.function.IntConsumer intConsumer) {
            return convert(IntStream.this.peek(IntConsumer.VivifiedWrapper.convert(intConsumer)));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
            return IntStream.this.reduce(i, IntBinaryOperator.VivifiedWrapper.convert(intBinaryOperator));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ OptionalInt reduce(java.util.function.IntBinaryOperator intBinaryOperator) {
            return OptionalConversions.convert(IntStream.this.reduce(IntBinaryOperator.VivifiedWrapper.convert(intBinaryOperator)));
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream sequential() {
            return BaseStream.Wrapper.convert(IntStream.this.sequential());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.IntStream sequential() {
            return convert(IntStream.this.sequential());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream skip(long j) {
            return convert(IntStream.this.skip(j));
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ java.util.stream.IntStream sorted() {
            return convert(IntStream.this.sorted());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        public /* synthetic */ Spliterator<Integer> spliterator() {
            return Spliterator.OfInt.Wrapper.convert(IntStream.this.spliterator());
        }

        @Override // java.util.stream.IntStream, java.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator, reason: avoid collision after fix types in other method */
        public /* synthetic */ java.util.Spliterator<Integer> spliterator2() {
            return Spliterator.Wrapper.convert(IntStream.this.spliterator());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ int sum() {
            return IntStream.this.sum();
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ IntSummaryStatistics summaryStatistics() {
            return IntSummaryStatisticsConversions.convert(IntStream.this.summaryStatistics());
        }

        @Override // java.util.stream.IntStream
        public /* synthetic */ int[] toArray() {
            return IntStream.this.toArray();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream unordered() {
            return BaseStream.Wrapper.convert(IntStream.this.unordered());
        }
    }

    boolean allMatch(j$.util.function.IntPredicate intPredicate);

    boolean anyMatch(j$.util.function.IntPredicate intPredicate);

    DoubleStream asDoubleStream();

    LongStream asLongStream();

    j$.util.OptionalDouble average();

    Stream boxed();

    Object collect(j$.util.function.Supplier supplier, j$.util.function.ObjIntConsumer objIntConsumer, j$.util.function.BiConsumer biConsumer);

    long count();

    IntStream distinct();

    IntStream filter(j$.util.function.IntPredicate intPredicate);

    j$.util.OptionalInt findAny();

    j$.util.OptionalInt findFirst();

    IntStream flatMap(j$.util.function.IntFunction intFunction);

    void forEach(j$.util.function.IntConsumer intConsumer);

    void forEachOrdered(j$.util.function.IntConsumer intConsumer);

    @Override // j$.util.stream.BaseStream, j$.util.stream.DoubleStream
    Iterator<Integer> iterator();

    IntStream limit(long j);

    IntStream map(j$.util.function.IntUnaryOperator intUnaryOperator);

    DoubleStream mapToDouble(j$.util.function.IntToDoubleFunction intToDoubleFunction);

    LongStream mapToLong(j$.util.function.IntToLongFunction intToLongFunction);

    Stream mapToObj(j$.util.function.IntFunction intFunction);

    j$.util.OptionalInt max();

    j$.util.OptionalInt min();

    boolean noneMatch(j$.util.function.IntPredicate intPredicate);

    @Override // j$.util.stream.BaseStream
    IntStream parallel();

    IntStream peek(j$.util.function.IntConsumer intConsumer);

    int reduce(int i, j$.util.function.IntBinaryOperator intBinaryOperator);

    j$.util.OptionalInt reduce(j$.util.function.IntBinaryOperator intBinaryOperator);

    @Override // j$.util.stream.BaseStream
    IntStream sequential();

    IntStream skip(long j);

    IntStream sorted();

    @Override // j$.util.stream.BaseStream
    Spliterator.OfInt spliterator();

    int sum();

    j$.util.IntSummaryStatistics summaryStatistics();

    int[] toArray();
}
