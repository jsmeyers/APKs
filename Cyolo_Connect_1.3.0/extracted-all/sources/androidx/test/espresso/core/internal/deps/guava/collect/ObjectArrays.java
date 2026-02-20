package androidx.test.espresso.core.internal.deps.guava.collect;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public final class ObjectArrays {
    public static <T> T[] newArray(Class<T> cls, int i) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }

    public static <T> T[] newArray(T[] tArr, int i) {
        return (T[]) Platform.newArray(tArr, i);
    }

    static Object[] checkElementsNotNull(Object... array) {
        return checkElementsNotNull(array, array.length);
    }

    static Object[] checkElementsNotNull(Object[] array, int length) {
        for (int i = 0; i < length; i++) {
            checkElementNotNull(array[i], i);
        }
        return array;
    }

    static Object checkElementNotNull(Object element, int index) {
        if (element != null) {
            return element;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(index);
        throw new NullPointerException(sb.toString());
    }
}
