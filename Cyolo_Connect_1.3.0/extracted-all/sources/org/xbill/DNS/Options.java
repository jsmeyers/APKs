package org.xbill.DNS;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public final class Options {
    private static Map<String, String> table;

    static {
        try {
            refresh();
        } catch (SecurityException unused) {
        }
    }

    private Options() {
    }

    public static void refresh() {
        String property = System.getProperty("dnsjava.options");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf == -1) {
                    set(strNextToken);
                } else {
                    set(strNextToken.substring(0, iIndexOf), strNextToken.substring(iIndexOf + 1));
                }
            }
        }
    }

    public static void clear() {
        table = null;
    }

    public static void set(String str) {
        if (table == null) {
            table = new HashMap();
        }
        table.put(str.toLowerCase(), "true");
    }

    public static void set(String str, String str2) {
        if (table == null) {
            table = new HashMap();
        }
        table.put(str.toLowerCase(), str2.toLowerCase());
    }

    public static void unset(String str) {
        Map<String, String> map = table;
        if (map == null) {
            return;
        }
        map.remove(str.toLowerCase());
    }

    public static boolean check(String str) {
        Map<String, String> map = table;
        return (map == null || map.get(str.toLowerCase()) == null) ? false : true;
    }

    public static String value(String str) {
        Map<String, String> map = table;
        if (map == null) {
            return null;
        }
        return map.get(str.toLowerCase());
    }

    public static int intValue(String str) {
        String strValue = value(str);
        if (strValue == null) {
            return -1;
        }
        try {
            int i = Integer.parseInt(strValue);
            if (i > 0) {
                return i;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
