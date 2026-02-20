package kotlin.streams.jdk8;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Streams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002*\u00020\u0004H\u0007\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002*\u00020\u0006H\u0007\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0002*\u00020\bH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b*\u00020\u0004H\u0007\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b*\u00020\u0006H\u0007\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b*\u00020\bH\u0007¨\u0006\r"}, d2 = {"T", "j$/util/stream/Stream", "Lkotlin/sequences/Sequence;", "asSequence", "j$/util/stream/IntStream", "", "j$/util/stream/LongStream", "", "j$/util/stream/DoubleStream", "", "asStream", "", "toList", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, pn = "kotlin.streams")
public final class StreamsKt {
    public static final <T> Sequence<T> asSequence(final Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "<this>");
        return new Sequence<T>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                Iterator<T> it = stream.iterator2();
                Intrinsics.checkNotNullExpressionValue(it, "iterator()");
                return it;
            }
        };
    }

    public static final Sequence<Integer> asSequence(final IntStream intStream) {
        Intrinsics.checkNotNullParameter(intStream, "<this>");
        return new Sequence<Integer>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$2
            @Override // kotlin.sequences.Sequence
            public Iterator<Integer> iterator() {
                Iterator<Integer> itIterator2 = intStream.iterator2();
                Intrinsics.checkNotNullExpressionValue(itIterator2, "iterator()");
                return itIterator2;
            }
        };
    }

    public static final Sequence<Long> asSequence(final LongStream longStream) {
        Intrinsics.checkNotNullParameter(longStream, "<this>");
        return new Sequence<Long>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$3
            @Override // kotlin.sequences.Sequence
            public Iterator<Long> iterator() {
                Iterator<Long> itIterator2 = longStream.iterator2();
                Intrinsics.checkNotNullExpressionValue(itIterator2, "iterator()");
                return itIterator2;
            }
        };
    }

    public static final Sequence<Double> asSequence(final DoubleStream doubleStream) {
        Intrinsics.checkNotNullParameter(doubleStream, "<this>");
        return new Sequence<Double>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$4
            @Override // kotlin.sequences.Sequence
            public Iterator<Double> iterator() {
                Iterator<Double> itIterator2 = doubleStream.iterator2();
                Intrinsics.checkNotNullExpressionValue(itIterator2, "iterator()");
                return itIterator2;
            }
        };
    }

    public static final <T> Stream<T> asStream(final Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Stream<T> stream = StreamSupport.stream(new Supplier() { // from class: kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return StreamsKt.asStream$lambda$4(sequence);
            }
        }, 16, false);
        Intrinsics.checkNotNullExpressionValue(stream, "stream({ Spliterators.sp…literator.ORDERED, false)");
        return stream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Spliterator asStream$lambda$4(Sequence this_asStream) {
        Intrinsics.checkNotNullParameter(this_asStream, "$this_asStream");
        return Spliterators.spliteratorUnknownSize(this_asStream.iterator(), 16);
    }

    public static final <T> List<T> toList(Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "<this>");
        Object objCollect = stream.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(objCollect, "collect(Collectors.toList<T>())");
        return (List) objCollect;
    }

    public static final List<Integer> toList(IntStream intStream) {
        Intrinsics.checkNotNullParameter(intStream, "<this>");
        int[] array = intStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt.asList(array);
    }

    public static final List<Long> toList(LongStream longStream) {
        Intrinsics.checkNotNullParameter(longStream, "<this>");
        long[] array = longStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt.asList(array);
    }

    public static final List<Double> toList(DoubleStream doubleStream) {
        Intrinsics.checkNotNullParameter(doubleStream, "<this>");
        double[] array = doubleStream.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return ArraysKt.asList(array);
    }
}
