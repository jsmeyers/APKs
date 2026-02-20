package j$.util;

import j$.util.function.ToIntFunction;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Comparator$$ExternalSyntheticLambda3 implements java.util.Comparator, Serializable {
    public final /* synthetic */ ToIntFunction f$0;

    public /* synthetic */ Comparator$$ExternalSyntheticLambda3(ToIntFunction toIntFunction) {
        this.f$0 = toIntFunction;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ToIntFunction toIntFunction = this.f$0;
        return Integer.compare(toIntFunction.applyAsInt(obj), toIntFunction.applyAsInt(obj2));
    }
}
