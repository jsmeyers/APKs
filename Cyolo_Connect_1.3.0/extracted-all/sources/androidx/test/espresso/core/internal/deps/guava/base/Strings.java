package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class Strings {
    public static String padStart(String string, int minLength, char padChar) {
        Preconditions.checkNotNull(string);
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder sb = new StringBuilder(minLength);
        for (int length = string.length(); length < minLength; length++) {
            sb.append(padChar);
        }
        sb.append(string);
        return sb.toString();
    }

    public static String lenientFormat(String template, Object... args) {
        int iIndexOf;
        String strValueOf = String.valueOf(template);
        int i = 0;
        if (args == null) {
            args = new Object[]{"(Object[])null"};
        } else {
            for (int i2 = 0; i2 < args.length; i2++) {
                args[i2] = lenientToString(args[i2]);
            }
        }
        StringBuilder sb = new StringBuilder(strValueOf.length() + (args.length * 16));
        int i3 = 0;
        while (i < args.length && (iIndexOf = strValueOf.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) strValueOf, i3, iIndexOf);
            sb.append(args[i]);
            i3 = iIndexOf + 2;
            i++;
        }
        sb.append((CharSequence) strValueOf, i3, strValueOf.length());
        if (i < args.length) {
            sb.append(" [");
            sb.append(args[i]);
            for (int i4 = i + 1; i4 < args.length; i4++) {
                sb.append(", ");
                sb.append(args[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String lenientToString(Object o) {
        try {
            return String.valueOf(o);
        } catch (Exception e) {
            String name = o.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(o));
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
            sb.append(name);
            sb.append('@');
            sb.append(hexString);
            String string = sb.toString();
            Logger logger = Logger.getLogger("androidx.test.espresso.core.internal.deps.guava.base.Strings");
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(string);
            logger.logp(level, "androidx.test.espresso.core.internal.deps.guava.base.Strings", "lenientToString", strValueOf.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf) : new String("Exception during lenientFormat for "), (Throwable) e);
            String name2 = e.getClass().getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 9 + String.valueOf(name2).length());
            sb2.append("<");
            sb2.append(string);
            sb2.append(" threw ");
            sb2.append(name2);
            sb2.append(">");
            return sb2.toString();
        }
    }
}
