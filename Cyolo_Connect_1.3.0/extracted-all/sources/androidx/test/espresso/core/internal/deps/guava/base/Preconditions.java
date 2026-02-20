package androidx.test.espresso.core.internal.deps.guava.base;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkArgument(boolean b, String errorMessageTemplate, int p1) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1)));
        }
    }

    public static void checkArgument(boolean b, String errorMessageTemplate, Object p1) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, p1));
        }
    }

    public static void checkArgument(boolean b, String errorMessageTemplate, long p1, Object p2) {
        if (!b) {
            throw new IllegalArgumentException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1), p2));
        }
    }

    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void checkState(boolean b, String errorMessageTemplate, int p1) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Integer.valueOf(p1)));
        }
    }

    public static void checkState(boolean b, String errorMessageTemplate, long p1) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, Long.valueOf(p1)));
        }
    }

    public static void checkState(boolean b, String errorMessageTemplate, Object p1) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1));
        }
    }

    public static void checkState(boolean b, String errorMessageTemplate, Object p1, Object p2) {
        if (!b) {
            throw new IllegalStateException(Strings.lenientFormat(errorMessageTemplate, p1, p2));
        }
    }

    public static <T> T checkNotNull(T reference) {
        reference.getClass();
        return reference;
    }

    public static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    public static <T> T checkNotNull(T obj, String errorMessageTemplate, Object p1) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.lenientFormat(errorMessageTemplate, p1));
    }

    public static int checkElementIndex(int index, int size) {
        return checkElementIndex(index, size, "index");
    }

    public static int checkElementIndex(int index, int size, String desc) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(badElementIndex(index, size, desc));
        }
        return index;
    }

    private static String badElementIndex(int index, int size, String desc) {
        if (index < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", desc, Integer.valueOf(index));
        }
        if (size >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(size);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int checkPositionIndex(int index, int size) {
        return checkPositionIndex(index, size, "index");
    }

    public static int checkPositionIndex(int index, int size, String desc) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(badPositionIndex(index, size, desc));
        }
        return index;
    }

    private static String badPositionIndex(int index, int size, String desc) {
        if (index < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", desc, Integer.valueOf(index));
        }
        if (size >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", desc, Integer.valueOf(index), Integer.valueOf(size));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(size);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void checkPositionIndexes(int start, int end, int size) {
        if (start < 0 || end < start || end > size) {
            throw new IndexOutOfBoundsException(badPositionIndexes(start, end, size));
        }
    }

    private static String badPositionIndexes(int start, int end, int size) {
        if (start < 0 || start > size) {
            return badPositionIndex(start, size, "start index");
        }
        return (end < 0 || end > size) ? badPositionIndex(end, size, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(end), Integer.valueOf(start));
    }
}
