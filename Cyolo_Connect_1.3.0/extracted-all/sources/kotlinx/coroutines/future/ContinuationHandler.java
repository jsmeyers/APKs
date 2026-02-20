package kotlinx.coroutines.future;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.concurrent.CompletionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okio.NioSystemFileSystem$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/future/ContinuationHandler;", "T", "j$/util/function/BiFunction", "", "", "result", "exception", "apply", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/Continuation;", "cont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
final class ContinuationHandler<T> implements BiFunction<T, Throwable, Unit> {
    public volatile Continuation<? super T> cont;

    @Override // j$.util.function.BiFunction
    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public ContinuationHandler(Continuation<? super T> continuation) {
        this.cont = continuation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j$.util.function.BiFunction
    public /* bridge */ /* synthetic */ Unit apply(Object obj, Throwable th) {
        apply2(obj, th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public void apply2(T result, Throwable exception) {
        Throwable cause;
        Continuation<? super T> continuation = this.cont;
        if (continuation == null) {
            return;
        }
        if (exception == null) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m442constructorimpl(result));
            return;
        }
        CompletionException completionExceptionM2228m = NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m$1(exception) ? NioSystemFileSystem$$ExternalSyntheticApiModelOutline0.m2228m((Object) exception) : null;
        if (completionExceptionM2228m != null && (cause = completionExceptionM2228m.getCause()) != null) {
            exception = cause;
        }
        Result.Companion companion2 = Result.INSTANCE;
        continuation.resumeWith(Result.m442constructorimpl(ResultKt.createFailure(exception)));
    }
}
