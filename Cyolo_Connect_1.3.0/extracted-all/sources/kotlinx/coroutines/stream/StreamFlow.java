package kotlinx.coroutines.stream;

import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u000b\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/stream/StreamFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j$/util/stream/Stream", "stream", "Lj$/util/stream/Stream;", "Lkotlinx/atomicfu/AtomicBoolean;", "consumed", "<init>", "(Lj$/util/stream/Stream;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
final class StreamFlow<T> implements Flow<T> {
    private static final AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");

    @Volatile
    private volatile int consumed = 0;
    private final Stream<T> stream;

    /* JADX INFO: renamed from: kotlinx.coroutines.stream.StreamFlow$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: Stream.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", i = {0, 0}, l = {26}, m = "collect", n = {"this", "collector"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StreamFlow<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StreamFlow<T> streamFlow, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = streamFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    public StreamFlow(Stream<T> stream) {
        this.stream = stream;
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x0014  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        StreamFlow<T> streamFlow;
        FlowCollector flowCollector2;
        Iterator<T> it;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(this, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(this, continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!consumed$FU.compareAndSet(this, 0, 1)) {
                throw new IllegalStateException("Stream.consumeAsFlow can be collected only once".toString());
            }
            try {
                streamFlow = this;
                flowCollector2 = flowCollector;
                it = this.stream.iterator();
            } catch (Throwable th) {
                th = th;
                streamFlow = this;
                streamFlow.stream.close();
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) anonymousClass1.L$2;
            FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.L$1;
            streamFlow = (StreamFlow) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                flowCollector2 = flowCollector3;
            } catch (Throwable th2) {
                th = th2;
                streamFlow.stream.close();
                throw th;
            }
        }
        while (it.hasNext()) {
            T next = it.next();
            anonymousClass1.L$0 = streamFlow;
            anonymousClass1.L$1 = flowCollector2;
            anonymousClass1.L$2 = it;
            anonymousClass1.label = 1;
            if (flowCollector2.emit(next, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        streamFlow.stream.close();
        return Unit.INSTANCE;
    }
}
