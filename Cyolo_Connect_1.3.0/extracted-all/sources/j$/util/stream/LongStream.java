package j$.util.stream;

import j$.util.LongSummaryStatisticsConversions;
import j$.util.OptionalConversions;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.LongBinaryOperator;
import j$.util.function.LongConsumer;
import j$.util.function.LongFunction;
import j$.util.function.LongPredicate;
import j$.util.function.LongToDoubleFunction;
import j$.util.function.LongToIntFunction;
import j$.util.function.LongUnaryOperator;
import j$.util.function.ObjLongConsumer;
import j$.util.function.Supplier;
import j$.util.stream.BaseStream;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public interface LongStream extends BaseStream<Long, LongStream> {

    public final /* synthetic */ class Wrapper implements java.util.stream.LongStream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.LongStream convert(LongStream longStream) {
            if (longStream == null) {
                return null;
            }
            return longStream.new Wrapper();
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ boolean allMatch(LongPredicate longPredicate) {
            return LongStream.this.allMatch(LongPredicate.VivifiedWrapper.convert(longPredicate));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ boolean anyMatch(java.util.function.LongPredicate longPredicate) {
            return LongStream.this.anyMatch(LongPredicate.VivifiedWrapper.convert(longPredicate));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.DoubleStream asDoubleStream() {
            return DoubleStream.Wrapper.convert(LongStream.this.asDoubleStream());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ OptionalDouble average() {
            return OptionalConversions.convert(LongStream.this.average());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.convert(LongStream.this.boxed());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            LongStream.this.close();
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
            return LongStream.this.collect(Supplier.VivifiedWrapper.convert(supplier), ObjLongConsumer.VivifiedWrapper.convert(objLongConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ long count() {
            return LongStream.this.count();
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.LongStream distinct() {
            return convert(LongStream.this.distinct());
        }

        public /* synthetic */ boolean equals(Object obj) {
            LongStream longStream = LongStream.this;
            if (obj instanceof Wrapper) {
                obj = LongStream.this;
            }
            return longStream.equals(obj);
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.LongStream filter(java.util.function.LongPredicate longPredicate) {
            return convert(LongStream.this.filter(LongPredicate.VivifiedWrapper.convert(longPredicate)));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ OptionalLong findAny() {
            return OptionalConversions.convert(LongStream.this.findAny());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ OptionalLong findFirst() {
            return OptionalConversions.convert(LongStream.this.findFirst());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.LongStream flatMap(LongFunction longFunction) {
            return convert(LongStream.this.flatMap(LongFunction.VivifiedWrapper.convert(longFunction)));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ void forEach(LongConsumer longConsumer) {
            LongStream.this.forEach(LongConsumer.VivifiedWrapper.convert(longConsumer));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ void forEachOrdered(java.util.function.LongConsumer longConsumer) {
            LongStream.this.forEachOrdered(LongConsumer.VivifiedWrapper.convert(longConsumer));
        }

        public /* synthetic */ int hashCode() {
            return LongStream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return LongStream.this.isParallel();
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public /* synthetic */ Iterator<Long> iterator() {
            return LongStream.this.iterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.PrimitiveIterator$OfLong] */
        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
        public /* synthetic */ Iterator<Long> iterator2() {
            return PrimitiveIterator.OfLong.Wrapper.convert(LongStream.this.iterator());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.LongStream limit(long j) {
            return convert(LongStream.this.limit(j));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.LongStream map(LongUnaryOperator longUnaryOperator) {
            return convert(LongStream.this.map(LongUnaryOperator.VivifiedWrapper.convert(longUnaryOperator)));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
            return DoubleStream.Wrapper.convert(LongStream.this.mapToDouble(LongToDoubleFunction.VivifiedWrapper.convert(longToDoubleFunction)));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.IntStream mapToInt(LongToIntFunction longToIntFunction) {
            return IntStream.Wrapper.convert(LongStream.this.mapToInt(LongToIntFunction.VivifiedWrapper.convert(longToIntFunction)));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.Stream mapToObj(java.util.function.LongFunction longFunction) {
            return Stream.Wrapper.convert(LongStream.this.mapToObj(LongFunction.VivifiedWrapper.convert(longFunction)));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ OptionalLong max() {
            return OptionalConversions.convert(LongStream.this.max());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ OptionalLong min() {
            return OptionalConversions.convert(LongStream.this.min());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ boolean noneMatch(java.util.function.LongPredicate longPredicate) {
            return LongStream.this.noneMatch(LongPredicate.VivifiedWrapper.convert(longPredicate));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.convert(LongStream.this.onClose(runnable));
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream parallel() {
            return BaseStream.Wrapper.convert(LongStream.this.parallel());
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.LongStream parallel() {
            return convert(LongStream.this.parallel());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.LongStream peek(java.util.function.LongConsumer longConsumer) {
            return convert(LongStream.this.peek(LongConsumer.VivifiedWrapper.convert(longConsumer)));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ long reduce(long j, LongBinaryOperator longBinaryOperator) {
            return LongStream.this.reduce(j, LongBinaryOperator.VivifiedWrapper.convert(longBinaryOperator));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ OptionalLong reduce(java.util.function.LongBinaryOperator longBinaryOperator) {
            return OptionalConversions.convert(LongStream.this.reduce(LongBinaryOperator.VivifiedWrapper.convert(longBinaryOperator)));
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream sequential() {
            return BaseStream.Wrapper.convert(LongStream.this.sequential());
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.LongStream sequential() {
            return convert(LongStream.this.sequential());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.LongStream skip(long j) {
            return convert(LongStream.this.skip(j));
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ java.util.stream.LongStream sorted() {
            return convert(LongStream.this.sorted());
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        public /* synthetic */ Spliterator<Long> spliterator() {
            return Spliterator.OfLong.Wrapper.convert(LongStream.this.spliterator());
        }

        @Override // java.util.stream.LongStream, java.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator, reason: avoid collision after fix types in other method */
        public /* synthetic */ java.util.Spliterator<Long> spliterator2() {
            return Spliterator.Wrapper.convert(LongStream.this.spliterator());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ long sum() {
            return LongStream.this.sum();
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ LongSummaryStatistics summaryStatistics() {
            return LongSummaryStatisticsConversions.convert(LongStream.this.summaryStatistics());
        }

        @Override // java.util.stream.LongStream
        public /* synthetic */ long[] toArray() {
            return LongStream.this.toArray();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream unordered() {
            return BaseStream.Wrapper.convert(LongStream.this.unordered());
        }
    }

    boolean allMatch(j$.util.function.LongPredicate longPredicate);

    boolean anyMatch(j$.util.function.LongPredicate longPredicate);

    DoubleStream asDoubleStream();

    j$.util.OptionalDouble average();

    Stream boxed();

    Object collect(j$.util.function.Supplier supplier, j$.util.function.ObjLongConsumer objLongConsumer, j$.util.function.BiConsumer biConsumer);

    long count();

    LongStream distinct();

    LongStream filter(j$.util.function.LongPredicate longPredicate);

    j$.util.OptionalLong findAny();

    j$.util.OptionalLong findFirst();

    LongStream flatMap(j$.util.function.LongFunction longFunction);

    void forEach(j$.util.function.LongConsumer longConsumer);

    void forEachOrdered(j$.util.function.LongConsumer longConsumer);

    @Override // j$.util.stream.BaseStream, j$.util.stream.DoubleStream
    Iterator<Long> iterator();

    LongStream limit(long j);

    LongStream map(j$.util.function.LongUnaryOperator longUnaryOperator);

    DoubleStream mapToDouble(j$.util.function.LongToDoubleFunction longToDoubleFunction);

    IntStream mapToInt(j$.util.function.LongToIntFunction longToIntFunction);

    Stream mapToObj(j$.util.function.LongFunction longFunction);

    j$.util.OptionalLong max();

    j$.util.OptionalLong min();

    boolean noneMatch(j$.util.function.LongPredicate longPredicate);

    @Override // j$.util.stream.BaseStream
    LongStream parallel();

    LongStream peek(j$.util.function.LongConsumer longConsumer);

    long reduce(long j, j$.util.function.LongBinaryOperator longBinaryOperator);

    j$.util.OptionalLong reduce(j$.util.function.LongBinaryOperator longBinaryOperator);

    @Override // j$.util.stream.BaseStream
    LongStream sequential();

    LongStream skip(long j);

    LongStream sorted();

    @Override // j$.util.stream.BaseStream
    Spliterator.OfLong spliterator();

    long sum();

    j$.util.LongSummaryStatistics summaryStatistics();

    long[] toArray();
}
