package kotlinx.coroutines.future;

import io.cyolo.android.MainActivityKt;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003B\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/future/CompletableFutureCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "j$/util/function/BiFunction", "", "", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "exception", "apply", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "onCompleted", "(Ljava/lang/Object;)V", "cause", "", "handled", "onCancelled", "Ljava/util/concurrent/CompletableFuture;", "future", "Ljava/util/concurrent/CompletableFuture;", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CompletableFuture;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
final class CompletableFutureCoroutine<T> extends AbstractCoroutine<T> implements BiFunction<T, Throwable, Unit> {
    private final CompletableFuture<T> future;

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.function.BiFunction
    public /* bridge */ /* synthetic */ Unit apply(Object obj, Throwable th) {
        apply2(obj, th);
        return Unit.INSTANCE;
    }

    public CompletableFutureCoroutine(CoroutineContext coroutineContext, CompletableFuture<T> completableFuture) {
        super(coroutineContext, true, true);
        this.future = completableFuture;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public void apply2(T value, Throwable exception) {
        Job.DefaultImpls.cancel$default((Job) this, (CancellationException) null, 1, (Object) null);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCompleted(T value) {
        this.future.complete(value);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable cause, boolean handled) {
        this.future.completeExceptionally(cause);
    }
}
