package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;
import j$.util.stream.DoublePipeline;
import j$.util.stream.IntPipeline;
import j$.util.stream.LongPipeline;
import j$.util.stream.Node;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import j$.util.stream.SliceOps;
import j$.util.stream.StreamSpliterators$SliceSpliterator;
import j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator;
import java.util.concurrent.CountedCompleter;

/* JADX INFO: loaded from: classes4.dex */
abstract class SliceOps {

    /* JADX INFO: renamed from: j$.util.stream.SliceOps$2, reason: invalid class name */
    class AnonymousClass2 extends IntPipeline.StatefulOp {
        final /* synthetic */ long val$limit;
        final /* synthetic */ long val$skip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AbstractPipeline abstractPipeline, StreamShape streamShape, int i, long j, long j2) {
            super(abstractPipeline, streamShape, i);
            this.val$skip = j;
            this.val$limit = j2;
        }

        static /* synthetic */ Integer[] lambda$opEvaluateParallelLazy$0(int i) {
            return new Integer[i];
        }

        @Override // j$.util.stream.AbstractPipeline
        Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
            long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            return (jExactOutputSizeIfKnown <= 0 || !spliterator.hasCharacteristics(16384)) ? !StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? Nodes.collectInt(this, unorderedSkipLimitSpliterator((Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, jExactOutputSizeIfKnown), true) : (Node) new SliceTask(this, pipelineHelper, spliterator, intFunction, this.val$skip, this.val$limit).invoke() : Nodes.collectInt(pipelineHelper, SliceOps.sliceSpliterator(pipelineHelper.getSourceShape(), spliterator, this.val$skip, this.val$limit), true);
        }

        @Override // j$.util.stream.AbstractPipeline
        Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
            long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.OfInt ofInt = (Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator);
                long j = this.val$skip;
                return new StreamSpliterators$SliceSpliterator.OfInt(ofInt, j, SliceOps.calcSliceFence(j, this.val$limit));
            }
            return !StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? unorderedSkipLimitSpliterator((Spliterator.OfInt) pipelineHelper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, jExactOutputSizeIfKnown) : ((Node) new SliceTask(this, pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.SliceOps$2$$ExternalSyntheticLambda0
                @Override // j$.util.function.IntFunction
                public final Object apply(int i) {
                    return SliceOps.AnonymousClass2.lambda$opEvaluateParallelLazy$0(i);
                }
            }, this.val$skip, this.val$limit).invoke()).spliterator();
        }

        @Override // j$.util.stream.AbstractPipeline
        Sink opWrapSink(int i, Sink sink) {
            return new Sink.ChainedInt(sink) { // from class: j$.util.stream.SliceOps.2.1
                long m;
                long n;

                {
                    this.n = AnonymousClass2.this.val$skip;
                    long j = AnonymousClass2.this.val$limit;
                    this.m = j < 0 ? Long.MAX_VALUE : j;
                }

                @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
                public void accept(int i2) {
                    long j = this.n;
                    if (j != 0) {
                        this.n = j - 1;
                        return;
                    }
                    long j2 = this.m;
                    if (j2 > 0) {
                        this.m = j2 - 1;
                        this.downstream.accept(i2);
                    }
                }

                @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
                public void begin(long j) {
                    this.downstream.begin(SliceOps.calcSize(j, AnonymousClass2.this.val$skip, this.m));
                }

                @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
                public boolean cancellationRequested() {
                    return this.m == 0 || this.downstream.cancellationRequested();
                }
            };
        }

        Spliterator.OfInt unorderedSkipLimitSpliterator(Spliterator.OfInt ofInt, long j, long j2, long j3) {
            long j4;
            long jMin;
            if (j <= j3) {
                long j5 = j3 - j;
                jMin = j2 >= 0 ? Math.min(j2, j5) : j5;
                j4 = 0;
            } else {
                j4 = j;
                jMin = j2;
            }
            return new StreamSpliterators$UnorderedSliceSpliterator.OfInt(ofInt, j4, jMin);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.SliceOps$3, reason: invalid class name */
    class AnonymousClass3 extends LongPipeline.StatefulOp {
        final /* synthetic */ long val$limit;
        final /* synthetic */ long val$skip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AbstractPipeline abstractPipeline, StreamShape streamShape, int i, long j, long j2) {
            super(abstractPipeline, streamShape, i);
            this.val$skip = j;
            this.val$limit = j2;
        }

        static /* synthetic */ Long[] lambda$opEvaluateParallelLazy$0(int i) {
            return new Long[i];
        }

        @Override // j$.util.stream.AbstractPipeline
        Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
            long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            return (jExactOutputSizeIfKnown <= 0 || !spliterator.hasCharacteristics(16384)) ? !StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? Nodes.collectLong(this, unorderedSkipLimitSpliterator((Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, jExactOutputSizeIfKnown), true) : (Node) new SliceTask(this, pipelineHelper, spliterator, intFunction, this.val$skip, this.val$limit).invoke() : Nodes.collectLong(pipelineHelper, SliceOps.sliceSpliterator(pipelineHelper.getSourceShape(), spliterator, this.val$skip, this.val$limit), true);
        }

        @Override // j$.util.stream.AbstractPipeline
        Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
            long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.OfLong ofLong = (Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator);
                long j = this.val$skip;
                return new StreamSpliterators$SliceSpliterator.OfLong(ofLong, j, SliceOps.calcSliceFence(j, this.val$limit));
            }
            return !StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? unorderedSkipLimitSpliterator((Spliterator.OfLong) pipelineHelper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, jExactOutputSizeIfKnown) : ((Node) new SliceTask(this, pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.SliceOps$3$$ExternalSyntheticLambda0
                @Override // j$.util.function.IntFunction
                public final Object apply(int i) {
                    return SliceOps.AnonymousClass3.lambda$opEvaluateParallelLazy$0(i);
                }
            }, this.val$skip, this.val$limit).invoke()).spliterator();
        }

        @Override // j$.util.stream.AbstractPipeline
        Sink opWrapSink(int i, Sink sink) {
            return new Sink.ChainedLong(sink) { // from class: j$.util.stream.SliceOps.3.1
                long m;
                long n;

                {
                    this.n = AnonymousClass3.this.val$skip;
                    long j = AnonymousClass3.this.val$limit;
                    this.m = j < 0 ? Long.MAX_VALUE : j;
                }

                @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
                public void accept(long j) {
                    long j2 = this.n;
                    if (j2 != 0) {
                        this.n = j2 - 1;
                        return;
                    }
                    long j3 = this.m;
                    if (j3 > 0) {
                        this.m = j3 - 1;
                        this.downstream.accept(j);
                    }
                }

                @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                public void begin(long j) {
                    this.downstream.begin(SliceOps.calcSize(j, AnonymousClass3.this.val$skip, this.m));
                }

                @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
                public boolean cancellationRequested() {
                    return this.m == 0 || this.downstream.cancellationRequested();
                }
            };
        }

        Spliterator.OfLong unorderedSkipLimitSpliterator(Spliterator.OfLong ofLong, long j, long j2, long j3) {
            long j4;
            long jMin;
            if (j <= j3) {
                long j5 = j3 - j;
                jMin = j2 >= 0 ? Math.min(j2, j5) : j5;
                j4 = 0;
            } else {
                j4 = j;
                jMin = j2;
            }
            return new StreamSpliterators$UnorderedSliceSpliterator.OfLong(ofLong, j4, jMin);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.SliceOps$4, reason: invalid class name */
    class AnonymousClass4 extends DoublePipeline.StatefulOp {
        final /* synthetic */ long val$limit;
        final /* synthetic */ long val$skip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(AbstractPipeline abstractPipeline, StreamShape streamShape, int i, long j, long j2) {
            super(abstractPipeline, streamShape, i);
            this.val$skip = j;
            this.val$limit = j2;
        }

        static /* synthetic */ Double[] lambda$opEvaluateParallelLazy$0(int i) {
            return new Double[i];
        }

        @Override // j$.util.stream.AbstractPipeline
        Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
            long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            return (jExactOutputSizeIfKnown <= 0 || !spliterator.hasCharacteristics(16384)) ? !StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? Nodes.collectDouble(this, unorderedSkipLimitSpliterator((Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, jExactOutputSizeIfKnown), true) : (Node) new SliceTask(this, pipelineHelper, spliterator, intFunction, this.val$skip, this.val$limit).invoke() : Nodes.collectDouble(pipelineHelper, SliceOps.sliceSpliterator(pipelineHelper.getSourceShape(), spliterator, this.val$skip, this.val$limit), true);
        }

        @Override // j$.util.stream.AbstractPipeline
        Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
            long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
            if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                Spliterator.OfDouble ofDouble = (Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator);
                long j = this.val$skip;
                return new StreamSpliterators$SliceSpliterator.OfDouble(ofDouble, j, SliceOps.calcSliceFence(j, this.val$limit));
            }
            return !StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? unorderedSkipLimitSpliterator((Spliterator.OfDouble) pipelineHelper.wrapSpliterator(spliterator), this.val$skip, this.val$limit, jExactOutputSizeIfKnown) : ((Node) new SliceTask(this, pipelineHelper, spliterator, new IntFunction() { // from class: j$.util.stream.SliceOps$4$$ExternalSyntheticLambda0
                @Override // j$.util.function.IntFunction
                public final Object apply(int i) {
                    return SliceOps.AnonymousClass4.lambda$opEvaluateParallelLazy$0(i);
                }
            }, this.val$skip, this.val$limit).invoke()).spliterator();
        }

        @Override // j$.util.stream.AbstractPipeline
        Sink opWrapSink(int i, Sink sink) {
            return new Sink.ChainedDouble(sink) { // from class: j$.util.stream.SliceOps.4.1
                long m;
                long n;

                {
                    this.n = AnonymousClass4.this.val$skip;
                    long j = AnonymousClass4.this.val$limit;
                    this.m = j < 0 ? Long.MAX_VALUE : j;
                }

                @Override // j$.util.stream.Sink.OfDouble, j$.util.stream.Sink, j$.util.function.DoubleConsumer
                public void accept(double d) {
                    long j = this.n;
                    if (j != 0) {
                        this.n = j - 1;
                        return;
                    }
                    long j2 = this.m;
                    if (j2 > 0) {
                        this.m = j2 - 1;
                        this.downstream.accept(d);
                    }
                }

                @Override // j$.util.stream.Sink.ChainedDouble, j$.util.stream.Sink
                public void begin(long j) {
                    this.downstream.begin(SliceOps.calcSize(j, AnonymousClass4.this.val$skip, this.m));
                }

                @Override // j$.util.stream.Sink.ChainedDouble, j$.util.stream.Sink
                public boolean cancellationRequested() {
                    return this.m == 0 || this.downstream.cancellationRequested();
                }
            };
        }

        Spliterator.OfDouble unorderedSkipLimitSpliterator(Spliterator.OfDouble ofDouble, long j, long j2, long j3) {
            long j4;
            long jMin;
            if (j <= j3) {
                long j5 = j3 - j;
                jMin = j2 >= 0 ? Math.min(j2, j5) : j5;
                j4 = 0;
            } else {
                j4 = j;
                jMin = j2;
            }
            return new StreamSpliterators$UnorderedSliceSpliterator.OfDouble(ofDouble, j4, jMin);
        }
    }

    /* JADX INFO: renamed from: j$.util.stream.SliceOps$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$java$util$stream$StreamShape;

        static {
            int[] iArr = new int[StreamShape.values().length];
            $SwitchMap$java$util$stream$StreamShape = iArr;
            try {
                iArr[StreamShape.REFERENCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.INT_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.LONG_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$util$stream$StreamShape[StreamShape.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static final class SliceTask extends AbstractShortCircuitTask {
        private volatile boolean completed;
        private final IntFunction generator;
        private final AbstractPipeline op;
        private final long targetOffset;
        private final long targetSize;
        private long thisNodeSize;

        SliceTask(AbstractPipeline abstractPipeline, PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction, long j, long j2) {
            super(pipelineHelper, spliterator);
            this.op = abstractPipeline;
            this.generator = intFunction;
            this.targetOffset = j;
            this.targetSize = j2;
        }

        SliceTask(SliceTask sliceTask, Spliterator spliterator) {
            super(sliceTask, spliterator);
            this.op = sliceTask.op;
            this.generator = sliceTask.generator;
            this.targetOffset = sliceTask.targetOffset;
            this.targetSize = sliceTask.targetSize;
        }

        private long completedSize(long j) {
            if (this.completed) {
                return this.thisNodeSize;
            }
            SliceTask sliceTask = (SliceTask) this.leftChild;
            SliceTask sliceTask2 = (SliceTask) this.rightChild;
            if (sliceTask == null || sliceTask2 == null) {
                return this.thisNodeSize;
            }
            long jCompletedSize = sliceTask.completedSize(j);
            return jCompletedSize >= j ? jCompletedSize : jCompletedSize + sliceTask2.completedSize(j);
        }

        private Node doTruncate(Node node) {
            return node.truncate(this.targetOffset, this.targetSize >= 0 ? Math.min(node.count(), this.targetOffset + this.targetSize) : this.thisNodeSize, this.generator);
        }

        private boolean isLeftCompleted(long j) {
            SliceTask sliceTask;
            long jCompletedSize = this.completed ? this.thisNodeSize : completedSize(j);
            if (jCompletedSize >= j) {
                return true;
            }
            SliceTask sliceTask2 = this;
            for (SliceTask sliceTask3 = (SliceTask) getParent(); sliceTask3 != null; sliceTask3 = (SliceTask) sliceTask3.getParent()) {
                if (sliceTask2 == sliceTask3.rightChild && (sliceTask = (SliceTask) sliceTask3.leftChild) != null) {
                    jCompletedSize += sliceTask.completedSize(j);
                    if (jCompletedSize >= j) {
                        return true;
                    }
                }
                sliceTask2 = sliceTask3;
            }
            return jCompletedSize >= j;
        }

        @Override // j$.util.stream.AbstractShortCircuitTask
        protected void cancel() {
            super.cancel();
            if (this.completed) {
                setLocalResult(getEmptyResult());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractTask
        public final Node doLeaf() {
            if (isRoot()) {
                Node.Builder builderMakeNodeBuilder = this.op.makeNodeBuilder(StreamOpFlag.SIZED.isPreserved(this.op.sourceOrOpFlags) ? this.op.exactOutputSizeIfKnown(this.spliterator) : -1L, this.generator);
                Sink sinkOpWrapSink = this.op.opWrapSink(this.helper.getStreamAndOpFlags(), builderMakeNodeBuilder);
                PipelineHelper pipelineHelper = this.helper;
                pipelineHelper.copyIntoWithCancel(pipelineHelper.wrapSink(sinkOpWrapSink), this.spliterator);
                return builderMakeNodeBuilder.build();
            }
            PipelineHelper pipelineHelper2 = this.helper;
            Node nodeBuild = ((Node.Builder) pipelineHelper2.wrapAndCopyInto(pipelineHelper2.makeNodeBuilder(-1L, this.generator), this.spliterator)).build();
            this.thisNodeSize = nodeBuild.count();
            this.completed = true;
            this.spliterator = null;
            return nodeBuild;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractShortCircuitTask
        public final Node getEmptyResult() {
            return Nodes.emptyNode(this.op.getOutputShape());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractTask
        public SliceTask makeChild(Spliterator spliterator) {
            return new SliceTask(this, spliterator);
        }

        /* JADX WARN: Found duplicated region for block: B:17:0x0062  */
        @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter countedCompleter) {
            Node nodeConc;
            if (!isLeaf()) {
                this.thisNodeSize = ((SliceTask) this.leftChild).thisNodeSize + ((SliceTask) this.rightChild).thisNodeSize;
                if (this.canceled) {
                    this.thisNodeSize = 0L;
                } else {
                    if (this.thisNodeSize != 0) {
                        nodeConc = ((SliceTask) this.leftChild).thisNodeSize == 0 ? (Node) ((SliceTask) this.rightChild).getLocalResult() : Nodes.conc(this.op.getOutputShape(), (Node) ((SliceTask) this.leftChild).getLocalResult(), (Node) ((SliceTask) this.rightChild).getLocalResult());
                    }
                    if (isRoot()) {
                        nodeConc = doTruncate(nodeConc);
                    }
                    setLocalResult(nodeConc);
                    this.completed = true;
                }
                nodeConc = getEmptyResult();
                if (isRoot()) {
                    nodeConc = doTruncate(nodeConc);
                }
                setLocalResult(nodeConc);
                this.completed = true;
            }
            if (this.targetSize >= 0 && !isRoot() && isLeftCompleted(this.targetOffset + this.targetSize)) {
                cancelLaterNodes();
            }
            super.onCompletion(countedCompleter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long calcSize(long j, long j2, long j3) {
        if (j >= 0) {
            return Math.max(-1L, Math.min(j - j2, j3));
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long calcSliceFence(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IntFunction castingArray() {
        return new IntFunction() { // from class: j$.util.stream.SliceOps$$ExternalSyntheticLambda0
            @Override // j$.util.function.IntFunction
            public final Object apply(int i) {
                return SliceOps.lambda$castingArray$0(i);
            }
        };
    }

    private static int flags(long j) {
        return (j != -1 ? StreamOpFlag.IS_SHORT_CIRCUIT : 0) | StreamOpFlag.NOT_SIZED;
    }

    static /* synthetic */ Object[] lambda$castingArray$0(int i) {
        return new Object[i];
    }

    public static DoubleStream makeDouble(AbstractPipeline abstractPipeline, long j, long j2) {
        if (j >= 0) {
            return new AnonymousClass4(abstractPipeline, StreamShape.DOUBLE_VALUE, flags(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static IntStream makeInt(AbstractPipeline abstractPipeline, long j, long j2) {
        if (j >= 0) {
            return new AnonymousClass2(abstractPipeline, StreamShape.INT_VALUE, flags(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static LongStream makeLong(AbstractPipeline abstractPipeline, long j, long j2) {
        if (j >= 0) {
            return new AnonymousClass3(abstractPipeline, StreamShape.LONG_VALUE, flags(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    public static Stream makeRef(AbstractPipeline abstractPipeline, final long j, final long j2) {
        if (j >= 0) {
            return new ReferencePipeline.StatefulOp(abstractPipeline, StreamShape.REFERENCE, flags(j2)) { // from class: j$.util.stream.SliceOps.1
                @Override // j$.util.stream.AbstractPipeline
                Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
                    long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    return (jExactOutputSizeIfKnown <= 0 || !spliterator.hasCharacteristics(16384)) ? !StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? Nodes.collect(this, unorderedSkipLimitSpliterator(pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown), true, intFunction) : (Node) new SliceTask(this, pipelineHelper, spliterator, intFunction, j, j2).invoke() : Nodes.collect(pipelineHelper, SliceOps.sliceSpliterator(pipelineHelper.getSourceShape(), spliterator, j, j2), true, intFunction);
                }

                @Override // j$.util.stream.AbstractPipeline
                Spliterator opEvaluateParallelLazy(PipelineHelper pipelineHelper, Spliterator spliterator) {
                    long jExactOutputSizeIfKnown = pipelineHelper.exactOutputSizeIfKnown(spliterator);
                    if (jExactOutputSizeIfKnown > 0 && spliterator.hasCharacteristics(16384)) {
                        Spliterator spliteratorWrapSpliterator = pipelineHelper.wrapSpliterator(spliterator);
                        long j3 = j;
                        return new StreamSpliterators$SliceSpliterator.OfRef(spliteratorWrapSpliterator, j3, SliceOps.calcSliceFence(j3, j2));
                    }
                    return !StreamOpFlag.ORDERED.isKnown(pipelineHelper.getStreamAndOpFlags()) ? unorderedSkipLimitSpliterator(pipelineHelper.wrapSpliterator(spliterator), j, j2, jExactOutputSizeIfKnown) : ((Node) new SliceTask(this, pipelineHelper, spliterator, SliceOps.castingArray(), j, j2).invoke()).spliterator();
                }

                @Override // j$.util.stream.AbstractPipeline
                Sink opWrapSink(int i, Sink sink) {
                    return new Sink.ChainedReference(sink) { // from class: j$.util.stream.SliceOps.1.1
                        long m;
                        long n;

                        {
                            this.n = j;
                            long j3 = j2;
                            this.m = j3 < 0 ? Long.MAX_VALUE : j3;
                        }

                        @Override // j$.util.function.Consumer
                        public void accept(Object obj) {
                            long j3 = this.n;
                            if (j3 != 0) {
                                this.n = j3 - 1;
                                return;
                            }
                            long j4 = this.m;
                            if (j4 > 0) {
                                this.m = j4 - 1;
                                this.downstream.accept(obj);
                            }
                        }

                        @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                        public void begin(long j3) {
                            this.downstream.begin(SliceOps.calcSize(j3, j, this.m));
                        }

                        @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                        public boolean cancellationRequested() {
                            return this.m == 0 || this.downstream.cancellationRequested();
                        }
                    };
                }

                Spliterator unorderedSkipLimitSpliterator(Spliterator spliterator, long j3, long j4, long j5) {
                    long j6;
                    long jMin;
                    if (j3 <= j5) {
                        long j7 = j5 - j3;
                        jMin = j4 >= 0 ? Math.min(j4, j7) : j7;
                        j6 = 0;
                    } else {
                        j6 = j3;
                        jMin = j4;
                    }
                    return new StreamSpliterators$UnorderedSliceSpliterator.OfRef(spliterator, j6, jMin);
                }
            };
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator sliceSpliterator(StreamShape streamShape, Spliterator spliterator, long j, long j2) {
        long jCalcSliceFence = calcSliceFence(j, j2);
        int i = AnonymousClass5.$SwitchMap$java$util$stream$StreamShape[streamShape.ordinal()];
        if (i == 1) {
            return new StreamSpliterators$SliceSpliterator.OfRef(spliterator, j, jCalcSliceFence);
        }
        if (i == 2) {
            return new StreamSpliterators$SliceSpliterator.OfInt((Spliterator.OfInt) spliterator, j, jCalcSliceFence);
        }
        if (i == 3) {
            return new StreamSpliterators$SliceSpliterator.OfLong((Spliterator.OfLong) spliterator, j, jCalcSliceFence);
        }
        if (i == 4) {
            return new StreamSpliterators$SliceSpliterator.OfDouble((Spliterator.OfDouble) spliterator, j, jCalcSliceFence);
        }
        throw new IllegalStateException("Unknown shape " + streamShape);
    }
}
