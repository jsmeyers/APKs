package j$.util;

import j$.util.function.Function;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Comparator$$ExternalSyntheticLambda5 implements java.util.Comparator, Serializable {
    public final /* synthetic */ Function f$0;

    public /* synthetic */ Comparator$$ExternalSyntheticLambda5(Function function) {
        this.f$0 = function;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Function function = this.f$0;
        return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
    }
}
