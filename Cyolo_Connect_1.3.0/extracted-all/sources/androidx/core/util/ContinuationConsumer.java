package androidx.core.util;

import io.cyolo.android.MainActivityKt;
import j$.util.function.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Consumer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/core/util/ContinuationConsumer;", "T", "j$/util/function/Consumer", "Ljava/util/concurrent/atomic/AtomicBoolean;", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "", "accept", "(Ljava/lang/Object;)V", "", "toString", "Lkotlin/coroutines/Continuation;", "continuation", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
final class ContinuationConsumer<T> extends AtomicBoolean implements j$.util.function.Consumer<T> {
    private final Continuation<T> continuation;

    @Override // j$.util.function.Consumer
    public /* synthetic */ j$.util.function.Consumer andThen(j$.util.function.Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationConsumer(Continuation<? super T> continuation) {
        super(false);
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.continuation = continuation;
    }

    @Override // j$.util.function.Consumer
    public void accept(T value) {
        if (compareAndSet(false, true)) {
            Continuation<T> continuation = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m442constructorimpl(value));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
