package androidx.test.espresso.core.internal.deps.guava.base;

/* JADX INFO: loaded from: classes.dex */
public final class Ascii {
    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static String toLowerCase(String string) {
        int length = string.length();
        int i = 0;
        while (i < length) {
            if (isUpperCase(string.charAt(i))) {
                char[] charArray = string.toCharArray();
                while (i < length) {
                    char c = charArray[i];
                    if (isUpperCase(c)) {
                        charArray[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return string;
    }
}
