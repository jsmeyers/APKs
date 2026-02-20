package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.BooleanSupplier;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.stream.Sink;

/* JADX INFO: loaded from: classes4.dex */
final class StreamSpliterators$WrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator {
    StreamSpliterators$WrappingSpliterator(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z) {
        super(pipelineHelper, spliterator, z);
    }

    StreamSpliterators$WrappingSpliterator(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        super(pipelineHelper, supplier, z);
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(final Consumer consumer) {
        if (this.buffer != null || this.finished) {
            while (tryAdvance(consumer)) {
            }
            return;
        }
        Objects.requireNonNull(consumer);
        init();
        PipelineHelper pipelineHelper = this.ph;
        Objects.requireNonNull(consumer);
        pipelineHelper.wrapAndCopyInto(new Sink() { // from class: j$.util.stream.StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda2
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
            public final void accept(Object obj) {
                consumer.accept(obj);
            }

            @Override // j$.util.function.Consumer
            public /* synthetic */ Consumer andThen(Consumer consumer2) {
                return Consumer.CC.$default$andThen(this, consumer2);
            }

            @Override // j$.util.stream.Sink
            public /* synthetic */ void begin(long j) {
                Sink.CC.$default$begin(this, j);
            }

            @Override // j$.util.stream.Sink
            public /* synthetic */ boolean cancellationRequested() {
                return Sink.CC.$default$cancellationRequested(this);
            }

            @Override // j$.util.stream.Sink
            public /* synthetic */ void end() {
                Sink.CC.$default$end(this);
            }
        }, this.spliterator);
        this.finished = true;
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    void initPartialTraversalState() {
        final SpinedBuffer spinedBuffer = new SpinedBuffer();
        this.buffer = spinedBuffer;
        PipelineHelper pipelineHelper = this.ph;
        Objects.requireNonNull(spinedBuffer);
        this.bufferSink = pipelineHelper.wrapSink(new Sink() { // from class: j$.util.stream.StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda0
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
            public final void accept(Object obj) {
                spinedBuffer.accept(obj);
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
            public /* synthetic */ boolean cancellationRequested() {
                return Sink.CC.$default$cancellationRequested(this);
            }

            @Override // j$.util.stream.Sink
            public /* synthetic */ void end() {
                Sink.CC.$default$end(this);
            }
        });
        this.pusher = new BooleanSupplier() { // from class: j$.util.stream.StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda1
            @Override // j$.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f$0.m437xf58cc34f();
            }
        };
    }

    /* JADX INFO: renamed from: lambda$initPartialTraversalState$0$java-util-stream-StreamSpliterators$WrappingSpliterator, reason: not valid java name */
    /* synthetic */ boolean m437xf58cc34f() {
        return this.spliterator.tryAdvance(this.bufferSink);
    }

    @Override // j$.util.Spliterator
    public boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        boolean zDoAdvance = doAdvance();
        if (zDoAdvance) {
            consumer.accept(((SpinedBuffer) this.buffer).get(this.nextToConsume));
        }
        return zDoAdvance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    public StreamSpliterators$WrappingSpliterator wrap(Spliterator spliterator) {
        return new StreamSpliterators$WrappingSpliterator(this.ph, spliterator, this.isParallel);
    }
}
