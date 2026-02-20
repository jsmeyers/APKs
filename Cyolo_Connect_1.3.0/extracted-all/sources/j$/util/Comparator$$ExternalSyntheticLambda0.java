package j$.util;

import j$.util.function.ToDoubleFunction;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Comparator$$ExternalSyntheticLambda0 implements java.util.Comparator, Serializable {
    public final /* synthetic */ ToDoubleFunction f$0;

    public /* synthetic */ Comparator$$ExternalSyntheticLambda0(ToDoubleFunction toDoubleFunction) {
        this.f$0 = toDoubleFunction;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ToDoubleFunction toDoubleFunction = this.f$0;
        return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
    }
}
