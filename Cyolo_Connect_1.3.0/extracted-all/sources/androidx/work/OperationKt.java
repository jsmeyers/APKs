package androidx.work;

import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: Operation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"await", "Landroidx/work/Operation$State$SUCCESS;", "Landroidx/work/Operation;", "(Landroidx/work/Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OperationKt {

    /* JADX INFO: renamed from: androidx.work.OperationKt$await$1, reason: invalid class name */
    /* JADX INFO: compiled from: Operation.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "androidx.work.OperationKt", f = "Operation.kt", i = {0}, l = {39}, m = "await", n = {"$this$await$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OperationKt.await(null, this);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x0014  */
    public static final Object await(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object obj;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(result);
            ListenableFuture<Operation.State.SUCCESS> result2 = operation.getResult();
            Intrinsics.checkNotNullExpressionValue(result2, "result");
            if (result2.isDone()) {
                try {
                    obj = result2.get();
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause == null) {
                        throw e;
                    }
                    throw cause;
                }
            } else {
                anonymousClass1.L$0 = result2;
                anonymousClass1.label = 1;
                AnonymousClass1 anonymousClass12 = anonymousClass1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass12), 1);
                cancellableContinuationImpl.initCancellability();
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                result2.addListener(new ListenableFutureKt$await$2$1(cancellableContinuationImpl2, result2), DirectExecutor.INSTANCE);
                cancellableContinuationImpl2.invokeOnCancellation(new ListenableFutureKt$await$2$2(result2));
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(anonymousClass12);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Intrinsics.checkNotNullExpressionValue(obj, "result.await()");
            return obj;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(result);
        obj = result;
        Intrinsics.checkNotNullExpressionValue(obj, "result.await()");
        return obj;
    }

    private static final Object await$$forInline(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        Object result;
        ListenableFuture<Operation.State.SUCCESS> result2 = operation.getResult();
        Intrinsics.checkNotNullExpressionValue(result2, "result");
        if (result2.isDone()) {
            try {
                result = result2.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        } else {
            InlineMarker.mark(0);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            result2.addListener(new ListenableFutureKt$await$2$1(cancellableContinuationImpl2, result2), DirectExecutor.INSTANCE);
            cancellableContinuationImpl2.invokeOnCancellation(new ListenableFutureKt$await$2$2(result2));
            Unit unit = Unit.INSTANCE;
            result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
        }
        Intrinsics.checkNotNullExpressionValue(result, "result.await()");
        return result;
    }
}
