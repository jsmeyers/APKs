package j$.util.stream;

import j$.util.LongSummaryStatistics;
import j$.util.Objects;
import j$.util.OptionalDouble;
import j$.util.OptionalLong;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.IntFunction;
import j$.util.function.LongBinaryOperator;
import j$.util.function.LongConsumer;
import j$.util.function.LongFunction;
import j$.util.function.LongPredicate;
import j$.util.function.LongToDoubleFunction;
import j$.util.function.LongToIntFunction;
import j$.util.function.LongUnaryOperator;
import j$.util.function.ObjLongConsumer;
import j$.util.function.Supplier;
import j$.util.function.ToLongFunction;
import j$.util.stream.DoublePipeline;
import j$.util.stream.IntPipeline;
import j$.util.stream.MatchOps;
import j$.util.stream.Node;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators$DelegatingSpliterator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
abstract class LongPipeline extends AbstractPipeline implements LongStream {

    static class Head extends LongPipeline {
        Head(Spliterator spliterator, int i, boolean z) {
            super(spliterator, i, z);
        }

        @Override // j$.util.stream.LongPipeline, j$.util.stream.LongStream
        public void forEach(LongConsumer longConsumer) {
            if (isParallel()) {
                super.forEach(longConsumer);
            } else {
                LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(longConsumer);
            }
        }

        @Override // j$.util.stream.LongPipeline, j$.util.stream.LongStream
        public void forEachOrdered(LongConsumer longConsumer) {
            if (isParallel()) {
                super.forEachOrdered(longConsumer);
            } else {
                LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(longConsumer);
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
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }
    }

    static abstract class StatefulOp extends LongPipeline {
        StatefulOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return true;
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }
    }

    static abstract class StatelessOp extends LongPipeline {
        StatelessOp(AbstractPipeline abstractPipeline, StreamShape streamShape, int i) {
            super(abstractPipeline, i);
        }

        @Override // j$.util.stream.AbstractPipeline
        final boolean opIsStateful() {
            return false;
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }
    }

    LongPipeline(Spliterator spliterator, int i, boolean z) {
        super(spliterator, i, z);
    }

    LongPipeline(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.OfLong adapt(Spliterator spliterator) {
        if (spliterator instanceof Spliterator.OfLong) {
            return (Spliterator.OfLong) spliterator;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using LongStream.adapt(Spliterator<Long> s)");
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    private static LongConsumer adapt(Sink sink) {
        if (sink instanceof LongConsumer) {
            return (LongConsumer) sink;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using LongStream.adapt(Sink<Long> s)");
        }
        Objects.requireNonNull(sink);
        return new LongPipeline$$ExternalSyntheticLambda11(sink);
    }

    static /* synthetic */ long[] lambda$average$1() {
        return new long[2];
    }

    static /* synthetic */ void lambda$average$2(long[] jArr, long j) {
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j;
    }

    static /* synthetic */ void lambda$average$3(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
    }

    static /* synthetic */ Object lambda$collect$5(BiConsumer biConsumer, Object obj, Object obj2) {
        biConsumer.accept(obj, obj2);
        return obj;
    }

    static /* synthetic */ long lambda$count$4(long j) {
        return 1L;
    }

    static /* synthetic */ Long[] lambda$toArray$6(int i) {
        return new Long[i];
    }

    @Override // j$.util.stream.LongStream
    public final boolean allMatch(LongPredicate longPredicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(longPredicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // j$.util.stream.LongStream
    public final boolean anyMatch(LongPredicate longPredicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(longPredicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // j$.util.stream.LongStream
    public final DoubleStream asDoubleStream() {
        return new DoublePipeline.StatelessOp(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.1
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedLong(sink) { // from class: j$.util.stream.LongPipeline.1.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(j);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public final OptionalDouble average() {
        long j = ((long[]) collect(new Supplier() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda4
            @Override // j$.util.function.Supplier
            public final Object get() {
                return LongPipeline.lambda$average$1();
            }
        }, new ObjLongConsumer() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda5
            @Override // j$.util.function.ObjLongConsumer
            public final void accept(Object obj, long j2) {
                LongPipeline.lambda$average$2((long[]) obj, j2);
            }
        }, new BiConsumer() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda6
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                LongPipeline.lambda$average$3((long[]) obj, (long[]) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }))[0];
        return j > 0 ? OptionalDouble.of(r0[1] / j) : OptionalDouble.empty();
    }

    @Override // j$.util.stream.LongStream
    public final Stream boxed() {
        return mapToObj(new LongFunction() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda2
            @Override // j$.util.function.LongFunction
            public final Object apply(long j) {
                return Long.valueOf(j);
            }
        });
    }

    @Override // j$.util.stream.LongStream
    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, final BiConsumer biConsumer) {
        return evaluate(ReduceOps.makeLong(supplier, objLongConsumer, new BinaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda13
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return LongPipeline.lambda$collect$5(biConsumer, obj, obj2);
            }
        }));
    }

    @Override // j$.util.stream.LongStream
    public final long count() {
        return map(new LongUnaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda0
            @Override // j$.util.function.LongUnaryOperator
            public final long applyAsLong(long j) {
                return LongPipeline.lambda$count$4(j);
            }
        }).sum();
    }

    @Override // j$.util.stream.LongStream
    public final LongStream distinct() {
        return boxed().distinct().mapToLong(new ToLongFunction() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda12
            @Override // j$.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((Long) obj).longValue();
            }
        });
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node evaluateToNode(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return Nodes.collectLong(pipelineHelper, spliterator, z);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream filter(final LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate);
        return new StatelessOp(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.LongPipeline.8
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedLong(sink) { // from class: j$.util.stream.LongPipeline.8.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long j) {
                        if (longPredicate.test(j)) {
                            this.downstream.accept(j);
                        }
                    }

                    @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                    public void begin(long j) {
                        this.downstream.begin(-1L);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong findAny() {
        return (OptionalLong) evaluate(FindOps.makeLong(false));
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong findFirst() {
        return (OptionalLong) evaluate(FindOps.makeLong(true));
    }

    @Override // j$.util.stream.LongStream
    public final LongStream flatMap(final LongFunction longFunction) {
        return new StatelessOp(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: j$.util.stream.LongPipeline.6

            /* JADX INFO: renamed from: j$.util.stream.LongPipeline$6$1, reason: invalid class name */
            class AnonymousClass1 extends Sink.ChainedLong {
                AnonymousClass1(Sink sink) {
                    super(sink);
                }

                @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                public void accept(long j) {
                    LongStream longStream = (LongStream) longFunction.apply(j);
                    if (longStream != null) {
                        try {
                            longStream.sequential().forEach(new LongConsumer() { // from class: j$.util.stream.LongPipeline$6$1$$ExternalSyntheticLambda0
                                @Override // j$.util.function.LongConsumer
                                public final void accept(long j2) {
                                    this.f$0.m425lambda$accept$0$javautilstreamLongPipeline$6$1(j2);
                                }
                            });
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

                @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                public void begin(long j) {
                    this.downstream.begin(-1L);
                }

                /* JADX INFO: renamed from: lambda$accept$0$java-util-stream-LongPipeline$6$1, reason: not valid java name */
                /* synthetic */ void m425lambda$accept$0$javautilstreamLongPipeline$6$1(long j) {
                    this.downstream.accept(j);
                }
            }

            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new AnonymousClass1(sink);
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public void forEach(LongConsumer longConsumer) {
        evaluate(ForEachOps.makeLong(longConsumer, false));
    }

    @Override // j$.util.stream.LongStream
    public void forEachOrdered(LongConsumer longConsumer) {
        evaluate(ForEachOps.makeLong(longConsumer, true));
    }

    @Override // j$.util.stream.AbstractPipeline
    final void forEachWithCancel(Spliterator spliterator, Sink sink) {
        Spliterator.OfLong ofLongAdapt = adapt(spliterator);
        LongConsumer longConsumerAdapt = adapt(sink);
        while (!sink.cancellationRequested() && ofLongAdapt.tryAdvance(longConsumerAdapt)) {
        }
    }

    @Override // j$.util.stream.AbstractPipeline
    final StreamShape getOutputShape() {
        return StreamShape.LONG_VALUE;
    }

    @Override // j$.util.stream.BaseStream, j$.util.stream.DoubleStream
    /* JADX INFO: renamed from: iterator */
    public final Iterator<Long> iterator2() {
        return Spliterators.iterator(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractPipeline
    public final Spliterator.OfLong lazySpliterator(Supplier supplier) {
        return new StreamSpliterators$DelegatingSpliterator.OfLong(supplier);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream limit(long j) {
        if (j >= 0) {
            return SliceOps.makeLong(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.PipelineHelper
    final Node.Builder makeNodeBuilder(long j, IntFunction intFunction) {
        return Nodes.longBuilder(j);
    }

    @Override // j$.util.stream.LongStream
    public final LongStream map(final LongUnaryOperator longUnaryOperator) {
        Objects.requireNonNull(longUnaryOperator);
        return new StatelessOp(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.2
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedLong(sink) { // from class: j$.util.stream.LongPipeline.2.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(longUnaryOperator.applyAsLong(j));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public final DoubleStream mapToDouble(final LongToDoubleFunction longToDoubleFunction) {
        Objects.requireNonNull(longToDoubleFunction);
        return new DoublePipeline.StatelessOp(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.5
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedLong(sink) { // from class: j$.util.stream.LongPipeline.5.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(longToDoubleFunction.applyAsDouble(j));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public final IntStream mapToInt(final LongToIntFunction longToIntFunction) {
        Objects.requireNonNull(longToIntFunction);
        return new IntPipeline.StatelessOp(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.4
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedLong(sink) { // from class: j$.util.stream.LongPipeline.4.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(longToIntFunction.applyAsInt(j));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public final Stream mapToObj(final LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new ReferencePipeline.StatelessOp(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: j$.util.stream.LongPipeline.3
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedLong(sink) { // from class: j$.util.stream.LongPipeline.3.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long j) {
                        this.downstream.accept(longFunction.apply(j));
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong max() {
        return reduce(new LongBinaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda1
            @Override // j$.util.function.LongBinaryOperator
            public final long applyAsLong(long j, long j2) {
                return Math.max(j, j2);
            }
        });
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong min() {
        return reduce(new LongBinaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda10
            @Override // j$.util.function.LongBinaryOperator
            public final long applyAsLong(long j, long j2) {
                return Math.min(j, j2);
            }
        });
    }

    @Override // j$.util.stream.LongStream
    public final boolean noneMatch(LongPredicate longPredicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(longPredicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // j$.util.stream.LongStream
    public final LongStream peek(final LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new StatelessOp(this, StreamShape.LONG_VALUE, 0) { // from class: j$.util.stream.LongPipeline.9
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return new Sink.ChainedLong(sink) { // from class: j$.util.stream.LongPipeline.9.1
                    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                    public void accept(long j) {
                        longConsumer.accept(j);
                        this.downstream.accept(j);
                    }
                };
            }
        };
    }

    @Override // j$.util.stream.LongStream
    public final long reduce(long j, LongBinaryOperator longBinaryOperator) {
        return ((Long) evaluate(ReduceOps.makeLong(j, longBinaryOperator))).longValue();
    }

    @Override // j$.util.stream.LongStream
    public final OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return (OptionalLong) evaluate(ReduceOps.makeLong(longBinaryOperator));
    }

    @Override // j$.util.stream.LongStream
    public final LongStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : SliceOps.makeLong(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // j$.util.stream.LongStream
    public final LongStream sorted() {
        return SortedOps.makeLong(this);
    }

    @Override // j$.util.stream.AbstractPipeline, j$.util.stream.BaseStream
    public final Spliterator.OfLong spliterator() {
        return adapt(super.spliterator());
    }

    @Override // j$.util.stream.LongStream
    public final long sum() {
        return reduce(0L, new LongBinaryOperator() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda7
            @Override // j$.util.function.LongBinaryOperator
            public final long applyAsLong(long j, long j2) {
                return j + j2;
            }
        });
    }

    @Override // j$.util.stream.LongStream
    public final LongSummaryStatistics summaryStatistics() {
        return (LongSummaryStatistics) collect(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda6
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new LongSummaryStatistics();
            }
        }, new ObjLongConsumer() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda8
            @Override // j$.util.function.ObjLongConsumer
            public final void accept(Object obj, long j) {
                ((LongSummaryStatistics) obj).accept(j);
            }
        }, new BiConsumer() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda9
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LongSummaryStatistics) obj).combine((LongSummaryStatistics) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        });
    }

    @Override // j$.util.stream.LongStream
    public final long[] toArray() {
        return (long[]) Nodes.flattenLong((Node.OfLong) evaluateToArrayNode(new IntFunction() { // from class: j$.util.stream.LongPipeline$$ExternalSyntheticLambda3
            @Override // j$.util.function.IntFunction
            public final Object apply(int i) {
                return LongPipeline.lambda$toArray$6(i);
            }
        })).asPrimitiveArray();
    }

    @Override // j$.util.stream.BaseStream
    public LongStream unordered() {
        return !isOrdered() ? this : new StatelessOp(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_ORDERED) { // from class: j$.util.stream.LongPipeline.7
            @Override // j$.util.stream.AbstractPipeline
            Sink opWrapSink(int i, Sink sink) {
                return sink;
            }
        };
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator wrap(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        return new StreamSpliterators$LongWrappingSpliterator(pipelineHelper, supplier, z);
    }
}
