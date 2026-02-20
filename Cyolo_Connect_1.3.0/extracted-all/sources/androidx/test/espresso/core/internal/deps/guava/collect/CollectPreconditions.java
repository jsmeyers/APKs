package androidx.test.espresso.core.internal.deps.guava.collect;

/* JADX INFO: loaded from: classes.dex */
final class CollectPreconditions {
    static void checkEntryNotNull(Object key, Object value) {
        if (key == null) {
            String strValueOf = String.valueOf(value);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 24);
            sb.append("null key in entry: null=");
            sb.append(strValueOf);
            throw new NullPointerException(sb.toString());
        }
        if (value != null) {
            return;
        }
        String strValueOf2 = String.valueOf(key);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 26);
        sb2.append("null value in entry: ");
        sb2.append(strValueOf2);
        sb2.append("=null");
        throw new NullPointerException(sb2.toString());
    }

    static int checkNonnegative(int value, String name) {
        if (value >= 0) {
            return value;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 40);
        sb.append(name);
        sb.append(" cannot be negative but was: ");
        sb.append(value);
        throw new IllegalArgumentException(sb.toString());
    }
}
