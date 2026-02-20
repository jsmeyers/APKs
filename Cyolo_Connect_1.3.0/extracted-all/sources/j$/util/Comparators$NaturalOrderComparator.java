package j$.util;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;

/* JADX INFO: loaded from: classes4.dex */
enum Comparators$NaturalOrderComparator implements java.util.Comparator, Comparator {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public java.util.Comparator reversed() {
        return Comparator.CC.reverseOrder();
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.EL.thenComparing(this, Comparator.CC.comparing(function));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.EL.thenComparing(this, Comparator.CC.comparing(function, comparator));
    }

    @Override // java.util.Comparator, j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function) {
        return thenComparing(Function.VivifiedWrapper.convert(function));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.function.Function function, java.util.Comparator comparator) {
        return thenComparing(Function.VivifiedWrapper.convert(function), comparator);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.EL.thenComparing(this, Comparator.CC.comparingDouble(toDoubleFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(java.util.function.ToDoubleFunction toDoubleFunction) {
        return thenComparingDouble(ToDoubleFunction.VivifiedWrapper.convert(toDoubleFunction));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.EL.thenComparing(this, Comparator.CC.comparingInt(toIntFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(java.util.function.ToIntFunction toIntFunction) {
        return thenComparingInt(ToIntFunction.VivifiedWrapper.convert(toIntFunction));
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.EL.thenComparing(this, Comparator.CC.comparingLong(toLongFunction));
    }

    @Override // java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(java.util.function.ToLongFunction toLongFunction) {
        return thenComparingLong(ToLongFunction.VivifiedWrapper.convert(toLongFunction));
    }
}
