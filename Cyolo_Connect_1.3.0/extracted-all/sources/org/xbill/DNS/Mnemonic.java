package org.xbill.DNS;

import j$.util.Collection;
import j$.util.function.Predicate;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class Mnemonic {
    static final int CASE_LOWER = 3;
    static final int CASE_SENSITIVE = 1;
    static final int CASE_UPPER = 2;
    private String description;
    private boolean numericok;
    private String prefix;
    private int wordcase;
    private HashMap<String, Integer> strings = new HashMap<>();
    private HashMap<Integer, String> values = new HashMap<>();
    private int max = Integer.MAX_VALUE;

    public Mnemonic(String str, int i) {
        this.description = str;
        this.wordcase = i;
    }

    public void setMaximum(int i) {
        this.max = i;
    }

    public void setPrefix(String str) {
        this.prefix = sanitize(str);
    }

    public void setNumericAllowed(boolean z) {
        this.numericok = z;
    }

    public void check(int i) {
        if (i < 0 || i > this.max) {
            throw new IllegalArgumentException(this.description + " " + i + "is out of range");
        }
    }

    private String sanitize(String str) {
        int i = this.wordcase;
        if (i == 2) {
            return str.toUpperCase();
        }
        return i == 3 ? str.toLowerCase() : str;
    }

    private int parseNumeric(String str) {
        try {
            int i = Integer.parseInt(str);
            if (i < 0 || i > this.max) {
                return -1;
            }
            return i;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public void add(int i, String str) {
        check(i);
        String strSanitize = sanitize(str);
        this.strings.put(strSanitize, Integer.valueOf(i));
        this.values.put(Integer.valueOf(i), strSanitize);
    }

    public void remove(final int i) {
        this.values.remove(Integer.valueOf(i));
        Collection.EL.removeIf(this.strings.entrySet(), new Predicate() { // from class: org.xbill.DNS.Mnemonic$$ExternalSyntheticLambda0
            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.$default$and(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate negate() {
                return Predicate.CC.$default$negate(this);
            }

            @Override // j$.util.function.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.$default$or(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return Mnemonic.lambda$remove$0(i, (Map.Entry) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$remove$0(int i, Map.Entry entry) {
        return ((Integer) entry.getValue()).intValue() == i;
    }

    public void addAlias(int i, String str) {
        check(i);
        this.strings.put(sanitize(str), Integer.valueOf(i));
    }

    public void removeAlias(String str) {
        this.strings.remove(sanitize(str));
    }

    public void addAll(Mnemonic mnemonic) {
        if (this.wordcase != mnemonic.wordcase) {
            throw new IllegalArgumentException(mnemonic.description + ": wordcases do not match");
        }
        this.strings.putAll(mnemonic.strings);
        this.values.putAll(mnemonic.values);
    }

    public String getText(int i) {
        check(i);
        String str = this.values.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        String string = Integer.toString(i);
        if (this.prefix == null) {
            return string;
        }
        return this.prefix + string;
    }

    public int getValue(String str) {
        int numeric;
        String strSanitize = sanitize(str);
        Integer num = this.strings.get(strSanitize);
        if (num != null) {
            return num.intValue();
        }
        String str2 = this.prefix;
        if (str2 != null && strSanitize.startsWith(str2) && (numeric = parseNumeric(strSanitize.substring(this.prefix.length()))) >= 0) {
            return numeric;
        }
        if (this.numericok) {
            return parseNumeric(strSanitize);
        }
        return -1;
    }
}
