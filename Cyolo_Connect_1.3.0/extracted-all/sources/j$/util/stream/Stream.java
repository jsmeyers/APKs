package j$.util.stream;

import j$.util.OptionalConversions;
import j$.util.Spliterator;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.BaseStream;
import j$.util.stream.Collector;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* JADX INFO: loaded from: classes4.dex */
public interface Stream<T> extends BaseStream<T, Stream<T>> {

    public final /* synthetic */ class Wrapper implements java.util.stream.Stream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.Stream convert(Stream stream) {
            if (stream == null) {
                return null;
            }
            return new Wrapper();
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ boolean allMatch(Predicate predicate) {
            return Stream.this.allMatch(Predicate.VivifiedWrapper.convert(predicate));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ boolean anyMatch(java.util.function.Predicate predicate) {
            return Stream.this.anyMatch(Predicate.VivifiedWrapper.convert(predicate));
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public /* synthetic */ void close() {
            Stream.this.close();
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
            return Stream.this.collect(Supplier.VivifiedWrapper.convert(supplier), BiConsumer.VivifiedWrapper.convert(biConsumer), BiConsumer.VivifiedWrapper.convert(biConsumer2));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Object collect(java.util.stream.Collector collector) {
            return Stream.this.collect(Collector.VivifiedWrapper.convert(collector));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ long count() {
            return Stream.this.count();
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream distinct() {
            return convert(Stream.this.distinct());
        }

        public /* synthetic */ boolean equals(Object obj) {
            Stream stream = Stream.this;
            if (obj instanceof Wrapper) {
                obj = Stream.this;
            }
            return stream.equals(obj);
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream filter(java.util.function.Predicate predicate) {
            return convert(Stream.this.filter(Predicate.VivifiedWrapper.convert(predicate)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Optional findAny() {
            return OptionalConversions.convert(Stream.this.findAny());
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Optional findFirst() {
            return OptionalConversions.convert(Stream.this.findFirst());
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream flatMap(Function function) {
            return convert(Stream.this.flatMap(Function.VivifiedWrapper.convert(function)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.DoubleStream flatMapToDouble(java.util.function.Function function) {
            return DoubleStream.Wrapper.convert(Stream.this.flatMapToDouble(Function.VivifiedWrapper.convert(function)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.IntStream flatMapToInt(java.util.function.Function function) {
            return IntStream.Wrapper.convert(Stream.this.flatMapToInt(Function.VivifiedWrapper.convert(function)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.LongStream flatMapToLong(java.util.function.Function function) {
            return LongStream.Wrapper.convert(Stream.this.flatMapToLong(Function.VivifiedWrapper.convert(function)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ void forEach(Consumer consumer) {
            Stream.this.forEach(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ void forEachOrdered(java.util.function.Consumer consumer) {
            Stream.this.forEachOrdered(Consumer.VivifiedWrapper.convert(consumer));
        }

        public /* synthetic */ int hashCode() {
            return Stream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ boolean isParallel() {
            return Stream.this.isParallel();
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ Iterator iterator() {
            return Stream.this.iterator();
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream limit(long j) {
            return convert(Stream.this.limit(j));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream map(java.util.function.Function function) {
            return convert(Stream.this.map(Function.VivifiedWrapper.convert(function)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
            return DoubleStream.Wrapper.convert(Stream.this.mapToDouble(ToDoubleFunction.VivifiedWrapper.convert(toDoubleFunction)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.IntStream mapToInt(ToIntFunction toIntFunction) {
            return IntStream.Wrapper.convert(Stream.this.mapToInt(ToIntFunction.VivifiedWrapper.convert(toIntFunction)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.LongStream mapToLong(ToLongFunction toLongFunction) {
            return LongStream.Wrapper.convert(Stream.this.mapToLong(ToLongFunction.VivifiedWrapper.convert(toLongFunction)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Optional max(Comparator comparator) {
            return OptionalConversions.convert(Stream.this.max(comparator));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Optional min(Comparator comparator) {
            return OptionalConversions.convert(Stream.this.min(comparator));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ boolean noneMatch(java.util.function.Predicate predicate) {
            return Stream.this.noneMatch(Predicate.VivifiedWrapper.convert(predicate));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream onClose(Runnable runnable) {
            return BaseStream.Wrapper.convert(Stream.this.onClose(runnable));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream parallel() {
            return BaseStream.Wrapper.convert(Stream.this.parallel());
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream peek(java.util.function.Consumer consumer) {
            return convert(Stream.this.peek(Consumer.VivifiedWrapper.convert(consumer)));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
            return Stream.this.reduce(obj, BiFunction.VivifiedWrapper.convert(biFunction), BinaryOperator.VivifiedWrapper.convert(binaryOperator));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Object reduce(Object obj, java.util.function.BinaryOperator binaryOperator) {
            return Stream.this.reduce(obj, BinaryOperator.VivifiedWrapper.convert(binaryOperator));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Optional reduce(java.util.function.BinaryOperator binaryOperator) {
            return OptionalConversions.convert(Stream.this.reduce(BinaryOperator.VivifiedWrapper.convert(binaryOperator)));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream sequential() {
            return BaseStream.Wrapper.convert(Stream.this.sequential());
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream skip(long j) {
            return convert(Stream.this.skip(j));
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream sorted() {
            return convert(Stream.this.sorted());
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ java.util.stream.Stream sorted(Comparator comparator) {
            return convert(Stream.this.sorted(comparator));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ Spliterator spliterator() {
            return Spliterator.Wrapper.convert(Stream.this.spliterator());
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Object[] toArray() {
            return Stream.this.toArray();
        }

        @Override // java.util.stream.Stream
        public /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Stream.this.toArray(IntFunction.VivifiedWrapper.convert(intFunction));
        }

        @Override // java.util.stream.BaseStream
        public /* synthetic */ java.util.stream.BaseStream unordered() {
            return BaseStream.Wrapper.convert(Stream.this.unordered());
        }
    }

    boolean allMatch(j$.util.function.Predicate predicate);

    boolean anyMatch(j$.util.function.Predicate<? super T> predicate);

    Object collect(j$.util.function.Supplier supplier, j$.util.function.BiConsumer biConsumer, j$.util.function.BiConsumer biConsumer2);

    <R, A> R collect(Collector<? super T, A, R> collector);

    long count();

    Stream distinct();

    Stream<T> filter(j$.util.function.Predicate<? super T> predicate);

    j$.util.Optional findAny();

    j$.util.Optional findFirst();

    <R> Stream<R> flatMap(j$.util.function.Function<? super T, ? extends Stream<? extends R>> function);

    DoubleStream flatMapToDouble(j$.util.function.Function function);

    IntStream flatMapToInt(j$.util.function.Function function);

    LongStream flatMapToLong(j$.util.function.Function function);

    void forEach(j$.util.function.Consumer consumer);

    void forEachOrdered(j$.util.function.Consumer<? super T> consumer);

    Stream limit(long j);

    <R> Stream<R> map(j$.util.function.Function<? super T, ? extends R> function);

    DoubleStream mapToDouble(j$.util.function.ToDoubleFunction toDoubleFunction);

    IntStream mapToInt(j$.util.function.ToIntFunction toIntFunction);

    LongStream mapToLong(j$.util.function.ToLongFunction toLongFunction);

    j$.util.Optional max(Comparator comparator);

    j$.util.Optional min(Comparator comparator);

    boolean noneMatch(j$.util.function.Predicate predicate);

    Stream peek(j$.util.function.Consumer consumer);

    j$.util.Optional reduce(j$.util.function.BinaryOperator binaryOperator);

    Object reduce(Object obj, j$.util.function.BiFunction biFunction, j$.util.function.BinaryOperator binaryOperator);

    Object reduce(Object obj, j$.util.function.BinaryOperator binaryOperator);

    Stream<T> skip(long j);

    Stream<T> sorted();

    Stream<T> sorted(Comparator<? super T> comparator);

    Object[] toArray();

    <A> A[] toArray(j$.util.function.IntFunction<A[]> intFunction);
}
