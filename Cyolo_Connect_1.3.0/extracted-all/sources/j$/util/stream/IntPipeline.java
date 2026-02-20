package j$.util.stream;

import j$.util.IntSummaryStatistics;
import j$.util.Objects;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.IntBinaryOperator;
import j$.util.function.IntConsumer;
import j$.util.function.IntFunction;
import j$.util.function.IntPredicate;
import j$.util.function.IntToDoubleFunction;
import j$.util.function.IntToLongFunction;
import j$.util.function.IntUnaryOperator;
import j$.util.function.ObjIntConsumer;
import j$.util.function.Supplier;
import j$.util.function.ToIntFunction;
import j$.util.stream.DoublePipeline;
import j$.util.stream.LongPipeline;
import j$.util.stream.MatchOps;
import j$.util.stream.Node;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
abstract class IntPipeline extends AbstractPipeline implements IntStream {

    static class Head extends IntPipeline {
        Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // j$.util.stream.IntPipeline, j$.util.stream.IntStream
        public void forEach(IntConsumer intConsumer) {
            if (isParallel()) {
                super.forEach(intConsumer);
            } else {
                IntPipeline.adapt(sourceStageSpliterator()).forEachRemaining(intConsumer);
            }
        }

        @Override // j$.util.stream.IntPipeline, j$.util.stream.IntStream
        public void forEachOrdered(IntConsumer intConsumer) {
            if (isParallel()) {
                super.forEachOrdered(intConsumer);
            } else {
                IntPipeline.adapt(sourceStageSpliterator()).forEachRemaining(intConsumer);
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
        public /* bridge */ /* synthetic */ IntStream parallel() {
            return (IntStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream sequential() {
            return (IntStream) super.sequential();
        }
    }

    static abstract class StatefulOp extends IntPipeline {
        StatefulOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream parallel() {
            return (IntStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream sequential() {
            return (IntStream) super.sequential();
        }
    }

    static abstract class StatelessOp extends IntPipeline {
        StatelessOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream parallel() {
            return (IntStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ IntStream sequential() {
            return (IntStream) super.sequential();
        }
    }

    IntPipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    IntPipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.OfInt adapt(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfInt) {
            return (Spliterator.OfInt) spliterator;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using IntStream.adapt(Spliterator<Integer> s)");
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    private static IntConsumer adapt(Sink sink) {
        if (sink instanceof IntConsumer) {
            return (IntConsumer) sink;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using IntStream.adapt(Sink<Integer> s)");
        }
        Objects.requireNonNull(sink);
        return new IntPipeline$$ExternalSyntheticLambda1(sink);
    }

    static /* synthetic */ long[] lambda$average$2() {
        return new long[2];
    }

    static /* synthetic */ void lambda$average$3(long[] jArr, int i) {
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + ((long) i);
    }

    static /* synthetic */ void lambda$average$4(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
    }

    static /* synthetic */ Object lambda$collect$5(BiConsumer biConsumer, Object obj, Object obj2) {
        biConsumer.accept(obj, obj2);
        return obj;
    }

    static /* synthetic */ long lambda$count$1(int i) {
        return 1L;
    }

    static /* synthetic */ Integer[] lambda$toArray$6(int i) {
        return new Integer[i];
    }

    @Override // j$.util.stream.IntStream
    public final boolean allMatch(IntPredicate intPredicate) {
        return ((Boolean) evaluate(MatchOps.makeInt(intPredicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final boolean anyMatch(IntPredicate intPredicate) {
        return ((Boolean) evaluate(MatchOps.makeInt(intPredicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final DoubleStream asDoubleStream() {
        return new DoublePipeline.StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.IntPipeline.2
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedInt(sink) { // from class: j$.util.stream.IntPipeline.2.1
                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(i2);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final LongStream asLongStream() {
        return new LongPipeline.StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.IntPipeline.1
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedInt(sink) { // from class: j$.util.stream.IntPipeline.1.1
                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(i2);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final OptionalDouble average() {
        long j = ((long[]) collect(new Supplier() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda4
            @Override // j$.util.function.Supplier
            public final Object get() {
                return IntPipeline.lambda$average$2();
            }
        }, new ObjIntConsumer() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda5
            @Override // j$.util.function.ObjIntConsumer
            public final void accept(Object obj, int i) {
                IntPipeline.lambda$average$3((long[]) obj, i);
            }
        }, new BiConsumer() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda6
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                IntPipeline.lambda$average$4((long[]) obj, (long[]) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }))[0];
        return j > 0 ? OptionalDouble.of(r0[1] / j) : OptionalDouble.empty();
    }

    @Override // j$.util.stream.IntStream
    public final Stream boxed() {
        return mapToObj(new IntFunction() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda8
            @Override // j$.util.function.IntFunction
            public final Object apply(int i) {
                return Integer.valueOf(i);
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, final BiConsumer biConsumer) {
        return evaluate(ReduceOps.makeInt(supplier, objIntConsumer, new BinaryOperator() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda11
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return IntPipeline.lambda$collect$5(biConsumer, obj, obj2);
            }
        }));
    }

    @Override // j$.util.stream.IntStream
    public final long count() {
        return mapToLong(new IntToLongFunction() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda10
            @Override // j$.util.function.IntToLongFunction
            public final long applyAsLong(int i) {
                return IntPipeline.lambda$count$1(i);
            }
        }).sum();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream distinct() {
        return boxed().distinct().mapToInt(new ToIntFunction() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda0
            @Override // j$.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((Integer) obj).intValue();
            }
        });
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node evaluateToNode(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.collectInt(pipelineHelper, spliterator, z);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream filter(final IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        return new StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.IntPipeline.9
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedInt(sink) { // from class: j$.util.stream.IntPipeline.9.1
                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public void accept(int i2) {
                        if (intPredicate.test(i2)) {
                            this.downstream.accept(i2);
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt findAny() {
        return (OptionalInt) evaluate(FindOps.makeInt(false));
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt findFirst() {
        return (OptionalInt) evaluate(FindOps.makeInt(true));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream flatMap(final IntFunction intFunction) {
        return new StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.IntPipeline.7

            /* JADX INFO: renamed from: j$.util.stream.IntPipeline$7$1, reason: invalid class name */
            class AnonymousClass1 extends Sink.ChainedInt {
                AnonymousClass1(Sink sink) {
                    super(sink);
                }

                @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                public void accept(int i) {
                    IntStream intStream = (IntStream) intFunction.apply(i);
                    if (intStream != null) {
                        try {
                            intStream.sequential().forEach(new IntConsumer() { // from class: j$.util.stream.IntPipeline$7$1$$ExternalSyntheticLambda0
                                @Override // j$.util.function.IntConsumer
                                public final void accept(int i2) {
                                    this.f$0.m424lambda$accept$0$javautilstreamIntPipeline$7$1(i2);
                                }
                            });
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

                @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
                public void begin(long j) {
                    this.downstream.begin(-1L);
                }

                /* JADX INFO: renamed from: lambda$accept$0$java-util-stream-IntPipeline$7$1, reason: not valid java name */
                /* synthetic */ void m424lambda$accept$0$javautilstreamIntPipeline$7$1(int i) {
                    this.downstream.accept(i);
                }
            }

            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new AnonymousClass1(sink);
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public void forEach(IntConsumer intConsumer) {
        evaluate(ForEachOps.makeInt(intConsumer, false));
    }

    @Override // j$.util.stream.IntStream
    public void forEachOrdered(IntConsumer intConsumer) {
        evaluate(ForEachOps.makeInt(intConsumer, true));
    }

    @Override // j$.util.stream.AbstractPipeline
    final void forEachWithCancel(Spliterator spliterator, Sink sink) {
        Spliterator.OfInt ofIntAdapt = adapt(spliterator);
        IntConsumer intConsumerAdapt = adapt(sink);
        while (!sink.cancellationRequested() && ofIntAdapt.tryAdvance(intConsumerAdapt)) {
        }
    }

    @Override // j$.util.stream.AbstractPipeline
    final StreamShape getOutputShape() {
        return StreamShape.INT_VALUE;
    }

    @Override // j$.util.stream.BaseStream, j$.util.stream.DoubleStream
    /* JADX INFO: renamed from: iterator */
    public final Iterator<Integer> iterator2() {
        return Spliterators.iterator(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractPipeline
    public final Spliterator.OfInt lazySpliterator(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfInt(supplier);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream limit(long j) {
        if (j >= 0) {
            return SliceOps.makeInt(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.PipelineHelper
    final Node.Builder makeNodeBuilder(long j, IntFunction intFunction) {
        return Nodes.intBuilder(j);
    }

    @Override // j$.util.stream.IntStream
    public final IntStream map(final IntUnaryOperator intUnaryOperator) {
        Objects.requireNonNull(intUnaryOperator);
        return new StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.IntPipeline.3
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedInt(sink) { // from class: j$.util.stream.IntPipeline.3.1
                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(intUnaryOperator.applyAsInt(i2));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final DoubleStream mapToDouble(final IntToDoubleFunction intToDoubleFunction) {
        Objects.requireNonNull(intToDoubleFunction);
        return new DoublePipeline.StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.IntPipeline.6
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedInt(sink) { // from class: j$.util.stream.IntPipeline.6.1
                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(intToDoubleFunction.applyAsDouble(i2));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final LongStream mapToLong(final IntToLongFunction intToLongFunction) {
        Objects.requireNonNull(intToLongFunction);
        return new LongPipeline.StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.IntPipeline.5
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedInt(sink) { // from class: j$.util.stream.IntPipeline.5.1
                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(intToLongFunction.applyAsLong(i2));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final Stream mapToObj(final IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new ReferencePipeline.StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.IntPipeline.4
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedInt(sink) { // from class: j$.util.stream.IntPipeline.4.1
                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public void accept(int i2) {
                        this.downstream.accept(intFunction.apply(i2));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt max() {
        return reduce(new IntBinaryOperator() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda9
            @Override // j$.util.function.IntBinaryOperator
            public final int applyAsInt(int i, int i2) {
                return Math.max(i, i2);
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt min() {
        return reduce(new IntBinaryOperator() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda12
            @Override // j$.util.function.IntBinaryOperator
            public final int applyAsInt(int i, int i2) {
                return Math.min(i, i2);
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final boolean noneMatch(IntPredicate intPredicate) {
        return ((Boolean) evaluate(MatchOps.makeInt(intPredicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // j$.util.stream.IntStream
    public final IntStream peek(final IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new StatelessOp(this, StreamShape.INT_VALUE, 0) { // from class: j$.util.stream.IntPipeline.10
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedInt(sink) { // from class: j$.util.stream.IntPipeline.10.1
                    @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                    public void accept(int i2) {
                        intConsumer.accept(i2);
                        this.downstream.accept(i2);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.IntStream
    public final int reduce(int i, IntBinaryOperator intBinaryOperator) {
        return ((Integer) evaluate(ReduceOps.makeInt(i, intBinaryOperator))).intValue();
    }

    @Override // j$.util.stream.IntStream
    public final OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
        return (OptionalInt) evaluate(ReduceOps.makeInt(intBinaryOperator));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : SliceOps.makeInt(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.IntStream
    public final IntStream sorted() {
        return SortedOps.makeInt(this);
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    public final Spliterator.OfInt spliterator() {
        return adapt(super.spliterator());
    }

    @Override // j$.util.stream.IntStream
    public final int sum() {
        return reduce(0, new IntBinaryOperator() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda13
            @Override // j$.util.function.IntBinaryOperator
            public final int applyAsInt(int i, int i2) {
                return i + i2;
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final IntSummaryStatistics summaryStatistics() {
        return (IntSummaryStatistics) collect(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda48
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new IntSummaryStatistics();
            }
        }, new ObjIntConsumer() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda2
            @Override // j$.util.function.ObjIntConsumer
            public final void accept(Object obj, int i) {
                ((IntSummaryStatistics) obj).accept(i);
            }
        }, new BiConsumer() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda3
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((IntSummaryStatistics) obj).combine((IntSummaryStatistics) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
    }

    @Override // j$.util.stream.IntStream
    public final int[] toArray() {
        return (int[]) Nodes.flattenInt((Node.OfInt) evaluateToArrayNode(new IntFunction() { // from class: j$.util.stream.IntPipeline$$ExternalSyntheticLambda7
            @Override // j$.util.function.IntFunction
            public final Object apply(int i) {
                return IntPipeline.lambda$toArray$6(i);
            }
        })).asPrimitiveArray();
    }

    @Override // j$.util.stream.BaseStream
    public IntStream unordered() {
        return !isOrdered() ? this : new StatelessOp(this, StreamShape.INT_VALUE, StreamOpFlag.NOT_ORDERED) { // from class: j$.util.stream.IntPipeline.8
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return sink;
            }
        };
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator wrap(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        return new StreamSpliterators$IntWrappingSpliterator(pipelineHelper, supplier, z);
    }
}
