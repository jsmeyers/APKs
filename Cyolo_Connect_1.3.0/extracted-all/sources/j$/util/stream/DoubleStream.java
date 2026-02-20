package j$.util.stream;

import j$.util.DoubleSummaryStatisticsConversions;
import j$.util.OptionalConversions;
import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.DoubleBinaryOperator;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleFunction;
import j$.util.function.DoublePredicate;
import j$.util.function.DoubleToIntFunction;
import j$.util.function.DoubleToLongFunction;
import j$.util.function.DoubleUnaryOperator;
import j$.util.function.ObjDoubleConsumer;
import j$.util.function.Supplier;
import j$.util.stream.BaseStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleStream extends BaseStream<Double, DoubleStream> {

    public final /* synthetic */ class Wrapper implements java.util.stream.DoubleStream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.DoubleStream convert(DoubleStream doubleStream) {
            if (doubleStream == null) {
                return null;
            }
            return doubleStream.new Wrapper();
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
            return DoubleStream.this.allMatch(DoublePredicate.VivifiedWrapper.convert(doublePredicate));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ boolean anyMatch(java.util.function.DoublePredicate doublePredicate) {
            return DoubleStream.this.anyMatch(DoublePredicate.VivifiedWrapper.convert(doublePredicate));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble average() {
            return OptionalConversions.convert(DoubleStream.this.average());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.convert(DoubleStream.this.boxed());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            DoubleStream.this.close();
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
            return DoubleStream.this.collect(Supplier.VivifiedWrapper.convert(supplier), ObjDoubleConsumer.VivifiedWrapper.convert(objDoubleConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ long count() {
            return DoubleStream.this.count();
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream distinct() {
            return convert(DoubleStream.this.distinct());
        }

        public /* synthetic */ boolean equals(Object obj) {
            DoubleStream doubleStream = DoubleStream.this;
            if (obj instanceof Wrapper) {
                obj = DoubleStream.this;
            }
            return doubleStream.equals(obj);
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream filter(java.util.function.DoublePredicate doublePredicate) {
            return convert(DoubleStream.this.filter(DoublePredicate.VivifiedWrapper.convert(doublePredicate)));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble findAny() {
            return OptionalConversions.convert(DoubleStream.this.findAny());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble findFirst() {
            return OptionalConversions.convert(DoubleStream.this.findFirst());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream flatMap(DoubleFunction doubleFunction) {
            return convert(DoubleStream.this.flatMap(DoubleFunction.VivifiedWrapper.convert(doubleFunction)));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
            DoubleStream.this.forEach(DoubleConsumer.VivifiedWrapper.convert(doubleConsumer));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ void forEachOrdered(java.util.function.DoubleConsumer doubleConsumer) {
            DoubleStream.this.forEachOrdered(DoubleConsumer.VivifiedWrapper.convert(doubleConsumer));
        }

        public /* synthetic */ int hashCode() {
            return DoubleStream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return DoubleStream.this.isParallel();
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ Iterator<Double> iterator() {
            return DoubleStream.this.iterator();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [j$.util.PrimitiveIterator$OfDouble] */
        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
        public /* synthetic */ Iterator<Double> iterator2() {
            return PrimitiveIterator.OfDouble.Wrapper.convert(DoubleStream.this.iterator());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream limit(long j) {
            return convert(DoubleStream.this.limit(j));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
            return convert(DoubleStream.this.map(DoubleUnaryOperator.VivifiedWrapper.convert(doubleUnaryOperator)));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
            return IntStream.Wrapper.convert(DoubleStream.this.mapToInt(DoubleToIntFunction.VivifiedWrapper.convert(doubleToIntFunction)));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
            return LongStream.Wrapper.convert(DoubleStream.this.mapToLong(DoubleToLongFunction.VivifiedWrapper.convert(doubleToLongFunction)));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.Stream mapToObj(java.util.function.DoubleFunction doubleFunction) {
            return Stream.Wrapper.convert(DoubleStream.this.mapToObj(DoubleFunction.VivifiedWrapper.convert(doubleFunction)));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble max() {
            return OptionalConversions.convert(DoubleStream.this.max());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble min() {
            return OptionalConversions.convert(DoubleStream.this.min());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ boolean noneMatch(java.util.function.DoublePredicate doublePredicate) {
            return DoubleStream.this.noneMatch(DoublePredicate.VivifiedWrapper.convert(doublePredicate));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.convert(DoubleStream.this.onClose(runnable));
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream parallel() {
            return BaseStream.Wrapper.convert(DoubleStream.this.parallel());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.DoubleStream parallel() {
            return convert(DoubleStream.this.parallel());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream peek(java.util.function.DoubleConsumer doubleConsumer) {
            return convert(DoubleStream.this.peek(DoubleConsumer.VivifiedWrapper.convert(doubleConsumer)));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
            return DoubleStream.this.reduce(d, DoubleBinaryOperator.VivifiedWrapper.convert(doubleBinaryOperator));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ OptionalDouble reduce(java.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            return OptionalConversions.convert(DoubleStream.this.reduce(DoubleBinaryOperator.VivifiedWrapper.convert(doubleBinaryOperator)));
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream sequential() {
            return BaseStream.Wrapper.convert(DoubleStream.this.sequential());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.DoubleStream sequential() {
            return convert(DoubleStream.this.sequential());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream skip(long j) {
            return convert(DoubleStream.this.skip(j));
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ java.util.stream.DoubleStream sorted() {
            return convert(DoubleStream.this.sorted());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        public /* synthetic */ Spliterator<Double> spliterator() {
            return Spliterator.OfDouble.Wrapper.convert(DoubleStream.this.spliterator());
        }

        @Override // java.util.stream.DoubleStream, java.util.stream.BaseStream
        /* JADX INFO: renamed from: spliterator, reason: avoid collision after fix types in other method */
        public /* synthetic */ java.util.Spliterator<Double> spliterator2() {
            return Spliterator.Wrapper.convert(DoubleStream.this.spliterator());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ double sum() {
            return DoubleStream.this.sum();
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ DoubleSummaryStatistics summaryStatistics() {
            return DoubleSummaryStatisticsConversions.convert(DoubleStream.this.summaryStatistics());
        }

        @Override // java.util.stream.DoubleStream
        public /* synthetic */ double[] toArray() {
            return DoubleStream.this.toArray();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream unordered() {
            return BaseStream.Wrapper.convert(DoubleStream.this.unordered());
        }
    }

    boolean allMatch(j$.util.function.DoublePredicate doublePredicate);

    boolean anyMatch(j$.util.function.DoublePredicate doublePredicate);

    j$.util.OptionalDouble average();

    Stream boxed();

    Object collect(j$.util.function.Supplier supplier, j$.util.function.ObjDoubleConsumer objDoubleConsumer, j$.util.function.BiConsumer biConsumer);

    long count();

    DoubleStream distinct();

    DoubleStream filter(j$.util.function.DoublePredicate doublePredicate);

    j$.util.OptionalDouble findAny();

    j$.util.OptionalDouble findFirst();

    DoubleStream flatMap(j$.util.function.DoubleFunction doubleFunction);

    void forEach(j$.util.function.DoubleConsumer doubleConsumer);

    void forEachOrdered(j$.util.function.DoubleConsumer doubleConsumer);

    @Override // 
    Iterator<Double> iterator();

    DoubleStream limit(long j);

    DoubleStream map(j$.util.function.DoubleUnaryOperator doubleUnaryOperator);

    IntStream mapToInt(j$.util.function.DoubleToIntFunction doubleToIntFunction);

    LongStream mapToLong(j$.util.function.DoubleToLongFunction doubleToLongFunction);

    Stream mapToObj(j$.util.function.DoubleFunction doubleFunction);

    j$.util.OptionalDouble max();

    j$.util.OptionalDouble min();

    boolean noneMatch(j$.util.function.DoublePredicate doublePredicate);

    @Override // j$.util.stream.BaseStream
    DoubleStream parallel();

    DoubleStream peek(j$.util.function.DoubleConsumer doubleConsumer);

    double reduce(double d, j$.util.function.DoubleBinaryOperator doubleBinaryOperator);

    j$.util.OptionalDouble reduce(j$.util.function.DoubleBinaryOperator doubleBinaryOperator);

    @Override // j$.util.stream.BaseStream
    DoubleStream sequential();

    DoubleStream skip(long j);

    DoubleStream sorted();

    @Override // j$.util.stream.BaseStream
    Spliterator.OfDouble spliterator();

    double sum();

    j$.util.DoubleSummaryStatistics summaryStatistics();

    double[] toArray();
}
