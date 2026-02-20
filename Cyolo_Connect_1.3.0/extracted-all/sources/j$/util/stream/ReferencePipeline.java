package j$.util.stream;

import j$.util.Objects;
import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.Function;
import j$.util.function.IntConsumer;
import j$.util.function.IntFunction;
import j$.util.function.LongConsumer;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.Collector;
import j$.util.stream.DoublePipeline;
import j$.util.stream.IntPipeline;
import j$.util.stream.LongPipeline;
import j$.util.stream.MatchOps;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
abstract class ReferencePipeline extends AbstractPipeline implements Stream {

    static class Head extends ReferencePipeline {
        Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        Head(Supplier supplier, int i, boolean z) {
            super(supplier, i, z);
        }

        @Override // j$.util.stream.ReferencePipeline, j$.util.stream.Stream
        public void forEach(Consumer consumer) {
            if (isParallel()) {
                super.forEach(consumer);
            } else {
                sourceStageSpliterator().forEachRemaining(consumer);
            }
        }

        @Override // j$.util.stream.ReferencePipeline, j$.util.stream.Stream
        public void forEachOrdered(Consumer consumer) {
            if (isParallel()) {
                super.forEachOrdered(consumer);
            } else {
                sourceStageSpliterator().forEachRemaining(consumer);
            }
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        @Override // j$.util.stream.AbstractPipeline
        final Sink opWrapSink(int i, Sink sink) {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class StatefulOp extends ReferencePipeline {
        StatefulOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }
    }

    static abstract class StatelessOp extends ReferencePipeline {
        StatelessOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }
    }

    ReferencePipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    ReferencePipeline(Supplier supplier, int i, boolean z) {
        super(supplier, i, z);
    }

    ReferencePipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    static /* synthetic */ long lambda$count$2(Object obj) {
        return 1L;
    }

    static /* synthetic */ Object[] lambda$toArray$0(int i) {
        return new Object[i];
    }

    @Override // j$.util.stream.Stream
    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return evaluate(ReduceOps.makeRef(supplier, biConsumer, biConsumer2));
    }

    @Override // j$.util.stream.Stream
    public final Object collect(Collector collector) {
        final Object objEvaluate;
        if (isParallel() && collector.characteristics().contains(Collector.Characteristics.CONCURRENT) && (!isOrdered() || collector.characteristics().contains(Collector.Characteristics.UNORDERED))) {
            objEvaluate = collector.supplier().get();
            final BiConsumer biConsumerAccumulator = collector.accumulator();
            forEach(new Consumer() { // from class: j$.util.stream.ReferencePipeline$$ExternalSyntheticLambda1
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    biConsumerAccumulator.accept(objEvaluate, obj);
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            });
        } else {
            objEvaluate = evaluate(ReduceOps.makeRef(collector));
        }
        return collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH) ? objEvaluate : collector.finisher().apply(objEvaluate);
    }

    @Override // j$.util.stream.Stream
    public final long count() {
        return mapToLong(new ToLongFunction() { // from class: j$.util.stream.ReferencePipeline$$ExternalSyntheticLambda2
            @Override // j$.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ReferencePipeline.lambda$count$2(obj);
            }
        }).sum();
    }

    @Override // j$.util.stream.Stream
    public final Stream distinct() {
        return DistinctOps.makeRef(this);
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node evaluateToNode(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.collect(pipelineHelper, spliterator, z, intFunction);
    }

    @Override // j$.util.stream.Stream
    public final Stream filter(final Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.2
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.2.1
                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        if (predicate.test(obj)) {
                            this.downstream.accept(obj);
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final Optional findAny() {
        return (Optional) evaluate(FindOps.makeRef(false));
    }

    @Override // j$.util.stream.Stream
    public final Optional findFirst() {
        return (Optional) evaluate(FindOps.makeRef(true));
    }

    @Override // j$.util.stream.Stream
    public final Stream flatMap(final Function function) {
        Objects.requireNonNull(function);
        return new StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.7
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.7.1
                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        Stream stream = (Stream) function.apply(obj);
                        if (stream != null) {
                            try {
                                ((Stream) stream.sequential()).forEach(this.downstream);
                            } catch (Throwable th) {
                                try {
                                    stream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                        if (stream != null) {
                            stream.close();
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final DoubleStream flatMapToDouble(final Function function) {
        Objects.requireNonNull(function);
        return new DoublePipeline.StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.9
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.9.1
                    DoubleConsumer downstreamAsDouble;

                    {
                        Sink sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsDouble = new DoublePipeline$$ExternalSyntheticLambda5(sink2);
                    }

                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        DoubleStream doubleStream = (DoubleStream) function.apply(obj);
                        if (doubleStream != null) {
                            try {
                                doubleStream.sequential().forEach(this.downstreamAsDouble);
                            } catch (Throwable th) {
                                try {
                                    doubleStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                        if (doubleStream != null) {
                            doubleStream.close();
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final IntStream flatMapToInt(final Function function) {
        Objects.requireNonNull(function);
        return new IntPipeline.StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.8
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.8.1
                    IntConsumer downstreamAsInt;

                    {
                        Sink sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsInt = new IntPipeline$$ExternalSyntheticLambda1(sink2);
                    }

                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        IntStream intStream = (IntStream) function.apply(obj);
                        if (intStream != null) {
                            try {
                                intStream.sequential().forEach(this.downstreamAsInt);
                            } catch (Throwable th) {
                                try {
                                    intStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                        if (intStream != null) {
                            intStream.close();
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final LongStream flatMapToLong(final Function function) {
        Objects.requireNonNull(function);
        return new LongPipeline.StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.ReferencePipeline.10
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.10.1
                    LongConsumer downstreamAsLong;

                    {
                        Sink sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsLong = new LongPipeline$$ExternalSyntheticLambda11(sink2);
                    }

                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        LongStream longStream = (LongStream) function.apply(obj);
                        if (longStream != null) {
                            try {
                                longStream.sequential().forEach(this.downstreamAsLong);
                            } catch (Throwable th) {
                                try {
                                    longStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                        if (longStream != null) {
                            longStream.close();
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public void forEach(Consumer consumer) {
        evaluate(ForEachOps.makeRef(consumer, false));
    }

    @Override // j$.util.stream.Stream
    public void forEachOrdered(Consumer consumer) {
        evaluate(ForEachOps.makeRef(consumer, true));
    }

    @Override // j$.util.stream.AbstractPipeline
    final void forEachWithCancel(Spliterator spliterator, Sink sink) {
        while (!sink.cancellationRequested() && spliterator.tryAdvance(sink)) {
        }
    }

    @Override // j$.util.stream.AbstractPipeline
    final StreamShape getOutputShape() {
        return StreamShape.REFERENCE;
    }

    @Override // j$.util.stream.BaseStream, j$.util.stream.DoubleStream
    /* JADX INFO: renamed from: iterator */
    public final Iterator iterator2() {
        return Spliterators.iterator(spliterator());
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator lazySpliterator(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator(supplier);
    }

    @Override // j$.util.stream.Stream
    public final Stream limit(long j) {
        if (j >= 0) {
            return SliceOps.makeRef(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.PipelineHelper
    final Node.Builder makeNodeBuilder(long j, IntFunction intFunction) {
        return Nodes.builder(j, intFunction);
    }

    @Override // j$.util.stream.Stream
    public final Stream map(final Function function) {
        Objects.requireNonNull(function);
        return new StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.ReferencePipeline.3
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.3.1
                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        this.downstream.accept(function.apply(obj));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final DoubleStream mapToDouble(final ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new DoublePipeline.StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.ReferencePipeline.6
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.6.1
                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        this.downstream.accept(toDoubleFunction.applyAsDouble(obj));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final IntStream mapToInt(final ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new IntPipeline.StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.ReferencePipeline.4
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.4.1
                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        this.downstream.accept(toIntFunction.applyAsInt(obj));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final LongStream mapToLong(final ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new LongPipeline.StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.ReferencePipeline.5
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.5.1
                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        this.downstream.accept(toLongFunction.applyAsLong(obj));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final Optional max(Comparator comparator) {
        return reduce(BinaryOperator.CC.maxBy(comparator));
    }

    @Override // j$.util.stream.Stream
    public final Optional min(Comparator comparator) {
        return reduce(BinaryOperator.CC.minBy(comparator));
    }

    @Override // j$.util.stream.Stream
    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final Stream peek(final Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new StatelessOp(this, StreamShape.REFERENCE, 0) { // from class: j$.util.stream.ReferencePipeline.11
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedReference(sink) { // from class: j$.util.stream.ReferencePipeline.11.1
                    @Override // j$.util.function.Consumer
                    public void accept(Object obj) {
                        consumer.accept(obj);
                        this.downstream.accept(obj);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.Stream
    public final Optional reduce(BinaryOperator binaryOperator) {
        return (Optional) evaluate(ReduceOps.makeRef(binaryOperator));
    }

    @Override // j$.util.stream.Stream
    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return evaluate(ReduceOps.makeRef(obj, biFunction, binaryOperator));
    }

    @Override // j$.util.stream.Stream
    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        return evaluate(ReduceOps.makeRef(obj, binaryOperator, binaryOperator));
    }

    @Override // j$.util.stream.Stream
    public final Stream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : SliceOps.makeRef(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted() {
        return SortedOps.makeRef(this);
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return SortedOps.makeRef(this, comparator);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray() {
        return toArray(new IntFunction() { // from class: j$.util.stream.ReferencePipeline$$ExternalSyntheticLambda0
            @Override // j$.util.function.IntFunction
            public final Object apply(int i) {
                return ReferencePipeline.lambda$toArray$0(i);
            }
        });
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray(IntFunction intFunction) {
        return Nodes.flatten(evaluateToArrayNode(intFunction), intFunction).asArray(intFunction);
    }

    @Override // j$.util.stream.BaseStream
    public Stream unordered() {
        return !isOrdered() ? this : new StatelessOp(this, StreamShape.REFERENCE, StreamOpFlag.NOT_ORDERED) { // from class: j$.util.stream.ReferencePipeline.1
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return sink;
            }
        };
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator wrap(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        return new StreamSpliterators$WrappingSpliterator(pipelineHelper, supplier, z);
    }
}
