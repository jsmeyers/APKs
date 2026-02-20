package j$.util.stream;

import j$.util.DoubleSummaryStatistics;
import j$.util.Objects;
import j$.util.OptionalDouble;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.DoubleBinaryOperator;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleFunction;
import j$.util.function.DoublePredicate;
import j$.util.function.DoubleToIntFunction;
import j$.util.function.DoubleToLongFunction;
import j$.util.function.DoubleUnaryOperator;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.ObjDoubleConsumer;
import j$.util.function.Supplier;
import j$.util.function.ToDoubleFunction;
import j$.util.stream.IntPipeline;
import j$.util.stream.LongPipeline;
import j$.util.stream.MatchOps;
import j$.util.stream.Node;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
abstract class DoublePipeline extends AbstractPipeline implements DoubleStream {

    static class Head extends DoublePipeline {
        Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // j$.util.stream.DoublePipeline, j$.util.stream.DoubleStream
        public void forEach(DoubleConsumer doubleConsumer) {
            if (isParallel()) {
                super.forEach(doubleConsumer);
            } else {
                DoublePipeline.adapt(sourceStageSpliterator()).forEachRemaining(doubleConsumer);
            }
        }

        @Override // j$.util.stream.DoublePipeline, j$.util.stream.DoubleStream
        public void forEachOrdered(DoubleConsumer doubleConsumer) {
            if (isParallel()) {
                super.forEachOrdered(doubleConsumer);
            } else {
                DoublePipeline.adapt(sourceStageSpliterator()).forEachRemaining(doubleConsumer);
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

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            return (DoubleStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            return (DoubleStream) super.sequential();
        }
    }

    static abstract class StatefulOp extends DoublePipeline {
        StatefulOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            return (DoubleStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            return (DoubleStream) super.sequential();
        }
    }

    static abstract class StatelessOp extends DoublePipeline {
        StatelessOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            return (DoubleStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            return (DoubleStream) super.sequential();
        }
    }

    DoublePipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    DoublePipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.OfDouble adapt(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfDouble) {
            return (Spliterator.OfDouble) spliterator;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using DoubleStream.adapt(Spliterator<Double> s)");
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    private static DoubleConsumer adapt(Sink sink) {
        if (sink instanceof DoubleConsumer) {
            return (DoubleConsumer) sink;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using DoubleStream.adapt(Sink<Double> s)");
        }
        Objects.requireNonNull(sink);
        return new DoublePipeline$$ExternalSyntheticLambda5(sink);
    }

    static /* synthetic */ double[] lambda$average$4() {
        return new double[4];
    }

    static /* synthetic */ void lambda$average$5(double[] dArr, double d) {
        dArr[2] = dArr[2] + 1.0d;
        Collectors.sumWithCompensation(dArr, d);
        dArr[3] = dArr[3] + d;
    }

    static /* synthetic */ void lambda$average$6(double[] dArr, double[] dArr2) {
        Collectors.sumWithCompensation(dArr, dArr2[0]);
        Collectors.sumWithCompensation(dArr, dArr2[1]);
        dArr[2] = dArr[2] + dArr2[2];
        dArr[3] = dArr[3] + dArr2[3];
    }

    static /* synthetic */ Object lambda$collect$8(BiConsumer biConsumer, Object obj, Object obj2) {
        biConsumer.accept(obj, obj2);
        return obj;
    }

    static /* synthetic */ long lambda$count$7(double d) {
        return 1L;
    }

    static /* synthetic */ double[] lambda$sum$1() {
        return new double[3];
    }

    static /* synthetic */ void lambda$sum$2(double[] dArr, double d) {
        Collectors.sumWithCompensation(dArr, d);
        dArr[2] = dArr[2] + d;
    }

    static /* synthetic */ void lambda$sum$3(double[] dArr, double[] dArr2) {
        Collectors.sumWithCompensation(dArr, dArr2[0]);
        Collectors.sumWithCompensation(dArr, dArr2[1]);
        dArr[2] = dArr[2] + dArr2[2];
    }

    static /* synthetic */ Double[] lambda$toArray$9(int i) {
        return new Double[i];
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean allMatch(DoublePredicate doublePredicate) {
        return ((Boolean) evaluate(MatchOps.makeDouble(doublePredicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean anyMatch(DoublePredicate doublePredicate) {
        return ((Boolean) evaluate(MatchOps.makeDouble(doublePredicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble average() {
        double[] dArr = (double[]) collect(new Supplier() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda13
            @Override // j$.util.function.Supplier
            public final Object get() {
                return DoublePipeline.lambda$average$4();
            }
        }, new ObjDoubleConsumer() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda14
            @Override // j$.util.function.ObjDoubleConsumer
            public final void accept(Object obj, double d) {
                DoublePipeline.lambda$average$5((double[]) obj, d);
            }
        }, new BiConsumer() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda15
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                DoublePipeline.lambda$average$6((double[]) obj, (double[]) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
        return dArr[2] > 0.0d ? OptionalDouble.of(Collectors.computeFinalSum(dArr) / dArr[2]) : OptionalDouble.empty();
    }

    @Override // j$.util.stream.DoubleStream
    public final Stream boxed() {
        return mapToObj(new DoubleFunction() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda6
            @Override // j$.util.function.DoubleFunction
            public final Object apply(double d) {
                return Double.valueOf(d);
            }
        });
    }

    @Override // j$.util.stream.DoubleStream
    public final Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, final BiConsumer biConsumer) {
        return evaluate(ReduceOps.makeDouble(supplier, objDoubleConsumer, new BinaryOperator() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda1
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DoublePipeline.lambda$collect$8(biConsumer, obj, obj2);
            }
        }));
    }

    @Override // j$.util.stream.DoubleStream
    public final long count() {
        return mapToLong(new DoubleToLongFunction() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda12
            @Override // j$.util.function.DoubleToLongFunction
            public final long applyAsLong(double d) {
                return DoublePipeline.lambda$count$7(d);
            }
        }).sum();
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream distinct() {
        return boxed().distinct().mapToDouble(new ToDoubleFunction() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda3
            @Override // j$.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                return ((Double) obj).doubleValue();
            }
        });
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node evaluateToNode(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.collectDouble(pipelineHelper, spliterator, z);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream filter(final DoublePredicate doublePredicate) {
        Objects.requireNonNull(doublePredicate);
        return new StatelessOp(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.DoublePipeline.7
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedDouble(sink) { // from class: j$.util.stream.DoublePipeline.7.1
                    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                    public void accept(double d) {
                        if (doublePredicate.test(d)) {
                            this.downstream.accept(d);
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedDouble, j$.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble findAny() {
        return (OptionalDouble) evaluate(FindOps.makeDouble(false));
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble findFirst() {
        return (OptionalDouble) evaluate(FindOps.makeDouble(true));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream flatMap(final DoubleFunction doubleFunction) {
        return new StatelessOp(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.DoublePipeline.5

            /* JADX INFO: renamed from: j$.util.stream.DoublePipeline$5$1, reason: invalid class name */
            class AnonymousClass1 extends Sink.ChainedDouble {
                AnonymousClass1(Sink sink) {
                    super(sink);
                }

                @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                public void accept(double d) {
                    DoubleStream doubleStream = (DoubleStream) doubleFunction.apply(d);
                    if (doubleStream != null) {
                        try {
                            doubleStream.sequential().forEach(new DoubleConsumer() { // from class: j$.util.stream.DoublePipeline$5$1$$ExternalSyntheticLambda0
                                @Override // j$.util.function.DoubleConsumer
                                public final void accept(double d2) {
                                    this.f$0.m423lambda$accept$0$javautilstreamDoublePipeline$5$1(d2);
                                }
                            });
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

                @Override // j$.util.stream.Sink.ChainedDouble, j$.util.stream.Sink
                public void begin(long j) {
                    this.downstream.begin(-1L);
                }

                /* JADX INFO: renamed from: lambda$accept$0$java-util-stream-DoublePipeline$5$1, reason: not valid java name */
                /* synthetic */ void m423lambda$accept$0$javautilstreamDoublePipeline$5$1(double d) {
                    this.downstream.accept(d);
                }
            }

            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new AnonymousClass1(sink);
            }
        };
    }

    @Override // j$.util.stream.DoubleStream
    public void forEach(DoubleConsumer doubleConsumer) {
        evaluate(ForEachOps.makeDouble(doubleConsumer, false));
    }

    @Override // j$.util.stream.DoubleStream
    public void forEachOrdered(DoubleConsumer doubleConsumer) {
        evaluate(ForEachOps.makeDouble(doubleConsumer, true));
    }

    @Override // j$.util.stream.AbstractPipeline
    final void forEachWithCancel(Spliterator spliterator, Sink sink) {
        Spliterator.OfDouble ofDoubleAdapt = adapt(spliterator);
        DoubleConsumer doubleConsumerAdapt = adapt(sink);
        while (!sink.cancellationRequested() && ofDoubleAdapt.tryAdvance(doubleConsumerAdapt)) {
        }
    }

    @Override // j$.util.stream.AbstractPipeline
    final StreamShape getOutputShape() {
        return StreamShape.DOUBLE_VALUE;
    }

    @Override // j$.util.stream.BaseStream, j$.util.stream.DoubleStream
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public final Iterator<Double> iterator2() {
        return Spliterators.iterator(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractPipeline
    public final Spliterator.OfDouble lazySpliterator(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfDouble(supplier);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream limit(long j) {
        if (j >= 0) {
            return SliceOps.makeDouble(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.PipelineHelper
    final Node.Builder makeNodeBuilder(long j, IntFunction intFunction) {
        return Nodes.doubleBuilder(j);
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream map(final DoubleUnaryOperator doubleUnaryOperator) {
        Objects.requireNonNull(doubleUnaryOperator);
        return new StatelessOp(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.DoublePipeline.1
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedDouble(sink) { // from class: j$.util.stream.DoublePipeline.1.1
                    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                    public void accept(double d) {
                        this.downstream.accept(doubleUnaryOperator.applyAsDouble(d));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.DoubleStream
    public final IntStream mapToInt(final DoubleToIntFunction doubleToIntFunction) {
        Objects.requireNonNull(doubleToIntFunction);
        return new IntPipeline.StatelessOp(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.DoublePipeline.3
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedDouble(sink) { // from class: j$.util.stream.DoublePipeline.3.1
                    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                    public void accept(double d) {
                        this.downstream.accept(doubleToIntFunction.applyAsInt(d));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.DoubleStream
    public final LongStream mapToLong(final DoubleToLongFunction doubleToLongFunction) {
        Objects.requireNonNull(doubleToLongFunction);
        return new LongPipeline.StatelessOp(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.DoublePipeline.4
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedDouble(sink) { // from class: j$.util.stream.DoublePipeline.4.1
                    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                    public void accept(double d) {
                        this.downstream.accept(doubleToLongFunction.applyAsLong(d));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.DoubleStream
    public final Stream mapToObj(final DoubleFunction doubleFunction) {
        Objects.requireNonNull(doubleFunction);
        return new ReferencePipeline.StatelessOp(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.DoublePipeline.2
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedDouble(sink) { // from class: j$.util.stream.DoublePipeline.2.1
                    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                    public void accept(double d) {
                        this.downstream.accept(doubleFunction.apply(d));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble max() {
        return reduce(new DoubleBinaryOperator() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda4
            @Override // j$.util.function.DoubleBinaryOperator
            public final double applyAsDouble(double d, double d2) {
                return Math.max(d, d2);
            }
        });
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble min() {
        return reduce(new DoubleBinaryOperator() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda2
            @Override // j$.util.function.DoubleBinaryOperator
            public final double applyAsDouble(double d, double d2) {
                return Math.min(d, d2);
            }
        });
    }

    @Override // j$.util.stream.DoubleStream
    public final boolean noneMatch(DoublePredicate doublePredicate) {
        return ((Boolean) evaluate(MatchOps.makeDouble(doublePredicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream peek(final DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new StatelessOp(this, StreamShape.DOUBLE_VALUE, 0) { // from class: j$.util.stream.DoublePipeline.8
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedDouble(sink) { // from class: j$.util.stream.DoublePipeline.8.1
                    @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                    public void accept(double d) {
                        doubleConsumer.accept(d);
                        this.downstream.accept(d);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.DoubleStream
    public final double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        return ((Double) evaluate(ReduceOps.makeDouble(d, doubleBinaryOperator))).doubleValue();
    }

    @Override // j$.util.stream.DoubleStream
    public final OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return (OptionalDouble) evaluate(ReduceOps.makeDouble(doubleBinaryOperator));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : SliceOps.makeDouble(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleStream sorted() {
        return SortedOps.makeDouble(this);
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    public final Spliterator.OfDouble spliterator() {
        return adapt(super.spliterator());
    }

    @Override // j$.util.stream.DoubleStream
    public final double sum() {
        return Collectors.computeFinalSum((double[]) collect(new Supplier() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda9
            @Override // j$.util.function.Supplier
            public final Object get() {
                return DoublePipeline.lambda$sum$1();
            }
        }, new ObjDoubleConsumer() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda10
            @Override // j$.util.function.ObjDoubleConsumer
            public final void accept(Object obj, double d) {
                DoublePipeline.lambda$sum$2((double[]) obj, d);
            }
        }, new BiConsumer() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda11
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                DoublePipeline.lambda$sum$3((double[]) obj, (double[]) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }));
    }

    @Override // j$.util.stream.DoubleStream
    public final DoubleSummaryStatistics summaryStatistics() {
        return (DoubleSummaryStatistics) collect(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda3
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new DoubleSummaryStatistics();
            }
        }, new ObjDoubleConsumer() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda7
            @Override // j$.util.function.ObjDoubleConsumer
            public final void accept(Object obj, double d) {
                ((DoubleSummaryStatistics) obj).accept(d);
            }
        }, new BiConsumer() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda8
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((DoubleSummaryStatistics) obj).combine((DoubleSummaryStatistics) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
    }

    @Override // j$.util.stream.DoubleStream
    public final double[] toArray() {
        return (double[]) Nodes.flattenDouble((Node.OfDouble) evaluateToArrayNode(new IntFunction() { // from class: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda0
            @Override // j$.util.function.IntFunction
            public final Object apply(int i) {
                return DoublePipeline.lambda$toArray$9(i);
            }
        })).asPrimitiveArray();
    }

    @Override // j$.util.stream.BaseStream
    public DoubleStream unordered() {
        return !isOrdered() ? this : new StatelessOp(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_ORDERED) { // from class: j$.util.stream.DoublePipeline.6
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return sink;
            }
        };
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator wrap(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        return new StreamSpliterators$DoubleWrappingSpliterator(pipelineHelper, supplier, z);
    }
}
