package kotlinx.coroutines.stream;

import j$.util.stream.Stream;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0004"}, d2 = {"T", "j$/util/stream/Stream", "Lkotlinx/coroutines/flow/Flow;", "consumeAsFlow", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0})
public final class StreamKt {
    public static final <T> Flow<T> consumeAsFlow(Stream<T> stream) {
        return new StreamFlow(stream);
    }
}
