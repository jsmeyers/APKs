package j$.util;

import j$.util.Spliterator;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;

/* JADX INFO: loaded from: classes4.dex */
public class DesugarArrays {
    public static Spliterator.OfDouble spliterator(double[] dArr, int i, int i2) {
        return Spliterators.spliterator(dArr, i, i2, 1040);
    }

    public static Spliterator.OfInt spliterator(int[] iArr, int i, int i2) {
        return Spliterators.spliterator(iArr, i, i2, 1040);
    }

    public static Spliterator.OfLong spliterator(long[] jArr, int i, int i2) {
        return Spliterators.spliterator(jArr, i, i2, 1040);
    }

    public static Spliterator spliterator(Object[] objArr, int i, int i2) {
        return Spliterators.spliterator(objArr, i, i2, 1040);
    }

    public static <T> Stream<T> stream(T[] tArr) {
        return stream(tArr, 0, tArr.length);
    }

    public static Stream stream(Object[] objArr, int i, int i2) {
        return StreamSupport.stream(spliterator(objArr, i, i2), false);
    }
}
