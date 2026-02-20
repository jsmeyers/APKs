package org.xbill.DNS;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: loaded from: classes2.dex */
public final class TTL {
    public static final long MAX_VALUE = 2147483647L;

    private TTL() {
    }

    static void check(long j) {
        if (j < 0 || j > MAX_VALUE) {
            throw new InvalidTTLException(j);
        }
    }

    public static long parse(String str, boolean z) {
        if (str != null && str.length() != 0) {
            if (Character.isDigit(str.charAt(0))) {
                long j = 0;
                long j2 = 0;
                for (int i = 0; i < str.length(); i++) {
                    char cCharAt = str.charAt(i);
                    if (Character.isDigit(cCharAt)) {
                        long numericValue = (10 * j2) + ((long) Character.getNumericValue(cCharAt));
                        if (numericValue < j2) {
                            throw new NumberFormatException();
                        }
                        j2 = numericValue;
                    } else {
                        char upperCase = Character.toUpperCase(cCharAt);
                        if (upperCase == 'D') {
                            j2 *= 24;
                            j2 *= 60;
                            j2 *= 60;
                        } else {
                            if (upperCase == 'H') {
                                j2 *= 60;
                            } else if (upperCase != 'M') {
                                if (upperCase != 'S') {
                                    if (upperCase != 'W') {
                                        throw new NumberFormatException();
                                    }
                                    j2 *= 7;
                                    j2 *= 24;
                                    j2 *= 60;
                                }
                            }
                            j2 *= 60;
                        }
                        j += j2;
                        if (j > KeyboardMap.kValueMask) {
                            throw new NumberFormatException();
                        }
                        j2 = 0;
                    }
                }
                if (j == 0) {
                    j = j2;
                }
                if (j <= KeyboardMap.kValueMask) {
                    return (j <= MAX_VALUE || !z) ? j : MAX_VALUE;
                }
                throw new NumberFormatException();
            }
        }
        throw new NumberFormatException();
    }

    public static long parseTTL(String str) {
        return parse(str, true);
    }

    public static String format(long j) {
        check(j);
        StringBuilder sb = new StringBuilder();
        long j2 = j % 60;
        long j3 = j / 60;
        long j4 = j3 % 60;
        long j5 = j3 / 60;
        long j6 = j5 % 24;
        long j7 = j5 / 24;
        long j8 = j7 % 7;
        long j9 = j7 / 7;
        if (j9 > 0) {
            sb.append(j9);
            sb.append("W");
        }
        if (j8 > 0) {
            sb.append(j8);
            sb.append("D");
        }
        if (j6 > 0) {
            sb.append(j6);
            sb.append("H");
        }
        if (j4 > 0) {
            sb.append(j4);
            sb.append("M");
        }
        if (j2 > 0 || (j9 == 0 && j8 == 0 && j6 == 0 && j4 == 0)) {
            sb.append(j2);
            sb.append("S");
        }
        return sb.toString();
    }
}
