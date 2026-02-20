package androidx.test.espresso.core.internal.deps.guava.primitives;

import org.xbill.DNS.TTL;

/* JADX INFO: loaded from: classes.dex */
public final class Ints {
    public static int saturatedCast(long value) {
        if (value > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (value < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) value;
    }
}
