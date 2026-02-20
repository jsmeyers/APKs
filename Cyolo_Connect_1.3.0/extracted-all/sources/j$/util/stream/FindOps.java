package j$.util.stream;

import j$.util.Optional;
import j$.util.OptionalDouble;
import j$.util.OptionalInt;
import j$.util.OptionalLong;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.stream.FindOps;
import j$.util.stream.Sink;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: loaded from: classes4.dex */
abstract class FindOps {

    private static final class FindOp implements TerminalOp {
        final Object emptyValue;
        final boolean mustFindFirst;
        final Predicate presentPredicate;
        private final StreamShape shape;
        final Supplier sinkSupplier;

        FindOp(boolean z, StreamShape streamShape, Object obj, Predicate predicate, Supplier supplier) {
            this.mustFindFirst = z;
            this.shape = streamShape;
            this.emptyValue = obj;
            this.presentPredicate = predicate;
            this.sinkSupplier = supplier;
        }

        @Override // j$.util.stream.TerminalOp
        public Object evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
            return new FindTask(this, pipelineHelper, spliterator).invoke();
        }

        @Override // j$.util.stream.TerminalOp
        public Object evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
            Object obj = ((TerminalSink) pipelineHelper.wrapAndCopyInto((TerminalSink) this.sinkSupplier.get(), spliterator)).get();
            return obj != null ? obj : this.emptyValue;
        }

        @Override // j$.util.stream.TerminalOp
        public int getOpFlags() {
            return StreamOpFlag.IS_SHORT_CIRCUIT | (this.mustFindFirst ? 0 : StreamOpFlag.NOT_ORDERED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class FindSink implements TerminalSink {
        boolean hasValue;
        Object value;

        static final class OfDouble extends FindSink implements Sink.OfDouble {
            OfDouble() {
            }

            @Override // j$.util.stream.FindOps.FindSink, j$.util.stream.Sink, j$.util.function.DoubleConsumer
            public void accept(double d) {
                accept((Object) Double.valueOf(d));
            }

            @Override // j$.util.stream.Sink.OfDouble
            public /* bridge */ /* synthetic */ void accept(Double d) {
                super.accept((Object) d);
            }

            @Override // j$.util.function.Supplier
            public OptionalDouble get() {
                if (this.hasValue) {
                    return OptionalDouble.of(((Double) this.value).doubleValue());
                }
                return null;
            }
        }

        static final class OfInt extends FindSink implements Sink.OfInt {
            OfInt() {
            }

            @Override // j$.util.stream.FindOps.FindSink, j$.util.stream.Sink
            public void accept(int i) {
                accept((Object) Integer.valueOf(i));
            }

            @Override // j$.util.stream.Sink.OfInt
            public /* bridge */ /* synthetic */ void accept(Integer num) {
                super.accept((Object) num);
            }

            @Override // j$.util.function.Supplier
            public OptionalInt get() {
                if (this.hasValue) {
                    return OptionalInt.of(((Integer) this.value).intValue());
                }
                return null;
            }
        }

        static final class OfLong extends FindSink implements Sink.OfLong {
            OfLong() {
            }

            @Override // j$.util.stream.FindOps.FindSink, j$.util.stream.Sink
            public void accept(long j) {
                accept((Object) Long.valueOf(j));
            }

            @Override // j$.util.stream.Sink.OfLong
            public /* bridge */ /* synthetic */ void accept(Long l) {
                super.accept((Object) l);
            }

            @Override // j$.util.function.Supplier
            public OptionalLong get() {
                if (this.hasValue) {
                    return OptionalLong.of(((Long) this.value).longValue());
                }
                return null;
            }
        }

        static final class OfRef extends FindSink {
            OfRef() {
            }

            @Override // j$.util.function.Supplier
            public Optional get() {
                if (this.hasValue) {
                    return Optional.of(this.value);
                }
                return null;
            }
        }

        FindSink() {
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
        public void accept(Object obj) {
            if (this.hasValue) {
                return;
            }
            this.hasValue = true;
            this.value = obj;
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
            return this.hasValue;
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void end() {
            Sink.CC.$default$end(this);
        }
    }

    private static final class FindTask extends AbstractShortCircuitTask {
        private final FindOp op;

        FindTask(FindOp findOp, PipelineHelper pipelineHelper, Spliterator spliterator) {
            super(pipelineHelper, spliterator);
            this.op = findOp;
        }

        FindTask(FindTask findTask, Spliterator spliterator) {
            super(findTask, spliterator);
            this.op = findTask.op;
        }

        private void foundResult(Object obj) {
            if (isLeftmostNode()) {
                shortCircuit(obj);
            } else {
                cancelLaterNodes();
            }
        }

        @Override // j$.util.stream.AbstractTask
        protected Object doLeaf() {
            Object obj = ((TerminalSink) this.helper.wrapAndCopyInto((TerminalSink) this.op.sinkSupplier.get(), this.spliterator)).get();
            if (!this.op.mustFindFirst) {
                if (obj != null) {
                    shortCircuit(obj);
                }
                return null;
            }
            if (obj == null) {
                return null;
            }
            foundResult(obj);
            return obj;
        }

        @Override // j$.util.stream.AbstractShortCircuitTask
        protected Object getEmptyResult() {
            return this.op.emptyValue;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractTask
        public FindTask makeChild(Spliterator spliterator) {
            return new FindTask(this, spliterator);
        }

        @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter countedCompleter) {
            if (this.op.mustFindFirst) {
                FindTask findTask = (FindTask) this.leftChild;
                FindTask findTask2 = null;
                while (findTask != findTask2) {
                    Object localResult = findTask.getLocalResult();
                    if (localResult != null && this.op.presentPredicate.test(localResult)) {
                        setLocalResult(localResult);
                        foundResult(localResult);
                        break;
                    } else {
                        findTask2 = findTask;
                        findTask = (FindTask) this.rightChild;
                    }
                }
            }
            super.onCompletion(countedCompleter);
        }
    }

    public static TerminalOp makeDouble(boolean z) {
        return new FindOp(z, StreamShape.DOUBLE_VALUE, OptionalDouble.empty(), new Predicate() { // from class: j$.util.stream.FindOps$$ExternalSyntheticLambda0
            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.$default$and(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate negate() {
                return Predicate.CC.$default$negate(this);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.$default$or(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return ((OptionalDouble) obj).isPresent();
            }
        }, new Supplier() { // from class: j$.util.stream.FindOps$$ExternalSyntheticLambda1
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new FindOps.FindSink.OfDouble();
            }
        });
    }

    public static TerminalOp makeInt(boolean z) {
        return new FindOp(z, StreamShape.INT_VALUE, OptionalInt.empty(), new Predicate() { // from class: j$.util.stream.FindOps$$ExternalSyntheticLambda6
            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.$default$and(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate negate() {
                return Predicate.CC.$default$negate(this);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.$default$or(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return ((OptionalInt) obj).isPresent();
            }
        }, new Supplier() { // from class: j$.util.stream.FindOps$$ExternalSyntheticLambda7
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new FindOps.FindSink.OfInt();
            }
        });
    }

    public static TerminalOp makeLong(boolean z) {
        return new FindOp(z, StreamShape.LONG_VALUE, OptionalLong.empty(), new Predicate() { // from class: j$.util.stream.FindOps$$ExternalSyntheticLambda2
            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.$default$and(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate negate() {
                return Predicate.CC.$default$negate(this);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.$default$or(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return ((OptionalLong) obj).isPresent();
            }
        }, new Supplier() { // from class: j$.util.stream.FindOps$$ExternalSyntheticLambda3
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new FindOps.FindSink.OfLong();
            }
        });
    }

    public static TerminalOp makeRef(boolean z) {
        return new FindOp(z, StreamShape.REFERENCE, Optional.empty(), new Predicate() { // from class: j$.util.stream.FindOps$$ExternalSyntheticLambda4
            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.$default$and(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate negate() {
                return Predicate.CC.$default$negate(this);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.$default$or(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Optional) obj).isPresent();
            }
        }, new Supplier() { // from class: j$.util.stream.FindOps$$ExternalSyntheticLambda5
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new FindOps.FindSink.OfRef();
            }
        });
    }
}
