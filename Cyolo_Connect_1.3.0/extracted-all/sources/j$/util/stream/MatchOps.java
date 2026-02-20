package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoublePredicate;
import j$.util.function.IntPredicate;
import j$.util.function.LongPredicate;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.stream.Sink;

/* JADX INFO: loaded from: classes4.dex */
abstract class MatchOps {

    /* JADX INFO: renamed from: j$.util.stream.MatchOps$2MatchSink, reason: invalid class name */
    class C2MatchSink extends BooleanTerminalSink implements Sink.OfInt {
        final /* synthetic */ MatchKind val$matchKind;
        final /* synthetic */ IntPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C2MatchSink(MatchKind matchKind, IntPredicate intPredicate) {
            super(matchKind);
            this.val$matchKind = matchKind;
            this.val$predicate = intPredicate;
        }

        @Override // j$.util.stream.MatchOps.BooleanTerminalSink, j$.util.stream.Sink
        public void accept(int i) {
            if (this.stop || this.val$predicate.test(i) != this.val$matchKind.stopOnPredicateMatches) {
                return;
            }
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }

        @Override // j$.util.stream.Sink.OfInt
        public /* synthetic */ void accept(Integer num) {
            Sink.OfInt.CC.$default$accept((Sink.OfInt) this, num);
        }

        @Override // j$.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfInt.CC.$default$accept(this, obj);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.MatchOps$3MatchSink, reason: invalid class name */
    class C3MatchSink extends BooleanTerminalSink implements Sink.OfLong {
        final /* synthetic */ MatchKind val$matchKind;
        final /* synthetic */ LongPredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3MatchSink(MatchKind matchKind, LongPredicate longPredicate) {
            super(matchKind);
            this.val$matchKind = matchKind;
            this.val$predicate = longPredicate;
        }

        @Override // j$.util.stream.MatchOps.BooleanTerminalSink, j$.util.stream.Sink
        public void accept(long j) {
            if (this.stop || this.val$predicate.test(j) != this.val$matchKind.stopOnPredicateMatches) {
                return;
            }
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }

        @Override // j$.util.stream.Sink.OfLong
        public /* synthetic */ void accept(Long l) {
            Sink.OfLong.CC.$default$accept((Sink.OfLong) this, l);
        }

        @Override // j$.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfLong.CC.$default$accept(this, obj);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.MatchOps$4MatchSink, reason: invalid class name */
    class C4MatchSink extends BooleanTerminalSink implements Sink.OfDouble {
        final /* synthetic */ MatchKind val$matchKind;
        final /* synthetic */ DoublePredicate val$predicate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C4MatchSink(MatchKind matchKind, DoublePredicate doublePredicate) {
            super(matchKind);
            this.val$matchKind = matchKind;
            this.val$predicate = doublePredicate;
        }

        @Override // j$.util.stream.MatchOps.BooleanTerminalSink, j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public void accept(double d) {
            if (this.stop || this.val$predicate.test(d) != this.val$matchKind.stopOnPredicateMatches) {
                return;
            }
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }

        @Override // j$.util.stream.Sink.OfDouble
        public /* synthetic */ void accept(Double d) {
            Sink.OfDouble.CC.$default$accept((Sink.OfDouble) this, d);
        }

        @Override // j$.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            Sink.OfDouble.CC.$default$accept(this, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class BooleanTerminalSink implements Sink {
        boolean stop;
        boolean value;

        BooleanTerminalSink(MatchKind matchKind) {
            this.value = !matchKind.shortCircuitResult;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Sink.CC.$default$accept(this, d);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Sink.CC.$default$accept((Sink) this, i);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Sink.CC.$default$accept((Sink) this, j);
        }

        @Override // j$.util.function.Consumer
        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void begin(long j) {
            Sink.CC.$default$begin(this, j);
        }

        @Override // j$.util.stream.Sink
        public boolean cancellationRequested() {
            return this.stop;
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }

        public boolean getAndClearState() {
            return this.value;
        }
    }

    enum MatchKind {
        ANY(true, true),
        ALL(false, false),
        NONE(true, false);

        private final boolean shortCircuitResult;
        private final boolean stopOnPredicateMatches;

        MatchKind(boolean z, boolean z2) {
            this.stopOnPredicateMatches = z;
            this.shortCircuitResult = z2;
        }
    }

    private static final class MatchOp implements TerminalOp {
        private final StreamShape inputShape;
        final MatchKind matchKind;
        final Supplier sinkSupplier;

        MatchOp(StreamShape streamShape, MatchKind matchKind, Supplier supplier) {
            this.inputShape = streamShape;
            this.matchKind = matchKind;
            this.sinkSupplier = supplier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j$.util.stream.TerminalOp
        public Boolean evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
            return (Boolean) new MatchTask(this, pipelineHelper, spliterator).invoke();
        }

        @Override // j$.util.stream.TerminalOp
        public Boolean evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
            return Boolean.valueOf(((BooleanTerminalSink) pipelineHelper.wrapAndCopyInto((BooleanTerminalSink) this.sinkSupplier.get(), spliterator)).getAndClearState());
        }

        @Override // j$.util.stream.TerminalOp
        public int getOpFlags() {
            return StreamOpFlag.IS_SHORT_CIRCUIT | StreamOpFlag.NOT_ORDERED;
        }
    }

    private static final class MatchTask extends AbstractShortCircuitTask {
        private final MatchOp op;

        MatchTask(MatchOp matchOp, PipelineHelper pipelineHelper, Spliterator spliterator) {
            super(pipelineHelper, spliterator);
            this.op = matchOp;
        }

        MatchTask(MatchTask matchTask, Spliterator spliterator) {
            super(matchTask, spliterator);
            this.op = matchTask.op;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractTask
        public Boolean doLeaf() {
            boolean andClearState = ((BooleanTerminalSink) this.helper.wrapAndCopyInto((BooleanTerminalSink) this.op.sinkSupplier.get(), this.spliterator)).getAndClearState();
            if (andClearState != this.op.matchKind.shortCircuitResult) {
                return null;
            }
            shortCircuit(Boolean.valueOf(andClearState));
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractShortCircuitTask
        public Boolean getEmptyResult() {
            return Boolean.valueOf(!this.op.matchKind.shortCircuitResult);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractTask
        public MatchTask makeChild(Spliterator spliterator) {
            return new MatchTask(this, spliterator);
        }
    }

    static /* synthetic */ BooleanTerminalSink lambda$makeDouble$3(MatchKind matchKind, DoublePredicate doublePredicate) {
        return new C4MatchSink(matchKind, doublePredicate);
    }

    static /* synthetic */ BooleanTerminalSink lambda$makeInt$1(MatchKind matchKind, IntPredicate intPredicate) {
        return new C2MatchSink(matchKind, intPredicate);
    }

    static /* synthetic */ BooleanTerminalSink lambda$makeLong$2(MatchKind matchKind, LongPredicate longPredicate) {
        return new C3MatchSink(matchKind, longPredicate);
    }

    static /* synthetic */ BooleanTerminalSink lambda$makeRef$0(MatchKind matchKind, Predicate predicate) {
        return new BooleanTerminalSink(predicate) { // from class: j$.util.stream.MatchOps.1MatchSink
            final /* synthetic */ Predicate val$predicate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.val$matchKind);
                this.val$predicate = predicate;
            }

            @Override // j$.util.function.Consumer
            public void accept(Object obj) {
                if (this.stop || this.val$predicate.test(obj) != this.val$matchKind.stopOnPredicateMatches) {
                    return;
                }
                this.stop = true;
                this.value = this.val$matchKind.shortCircuitResult;
            }
        };
    }

    public static TerminalOp makeDouble(final DoublePredicate doublePredicate, final MatchKind matchKind) {
        Objects.requireNonNull(doublePredicate);
        Objects.requireNonNull(matchKind);
        return new MatchOp(StreamShape.DOUBLE_VALUE, matchKind, new Supplier() { // from class: j$.util.stream.MatchOps$$ExternalSyntheticLambda2
            @Override // j$.util.function.Supplier
            public final Object get() {
                return MatchOps.lambda$makeDouble$3(matchKind, doublePredicate);
            }
        });
    }

    public static TerminalOp makeInt(final IntPredicate intPredicate, final MatchKind matchKind) {
        Objects.requireNonNull(intPredicate);
        Objects.requireNonNull(matchKind);
        return new MatchOp(StreamShape.INT_VALUE, matchKind, new Supplier() { // from class: j$.util.stream.MatchOps$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return MatchOps.lambda$makeInt$1(matchKind, intPredicate);
            }
        });
    }

    public static TerminalOp makeLong(final LongPredicate longPredicate, final MatchKind matchKind) {
        Objects.requireNonNull(longPredicate);
        Objects.requireNonNull(matchKind);
        return new MatchOp(StreamShape.LONG_VALUE, matchKind, new Supplier() { // from class: j$.util.stream.MatchOps$$ExternalSyntheticLambda3
            @Override // j$.util.function.Supplier
            public final Object get() {
                return MatchOps.lambda$makeLong$2(matchKind, longPredicate);
            }
        });
    }

    public static TerminalOp makeRef(final Predicate predicate, final MatchKind matchKind) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(matchKind);
        return new MatchOp(StreamShape.REFERENCE, matchKind, new Supplier() { // from class: j$.util.stream.MatchOps$$ExternalSyntheticLambda1
            @Override // j$.util.function.Supplier
            public final Object get() {
                return MatchOps.lambda$makeRef$0(matchKind, predicate);
            }
        });
    }
}
