package org.xbill.DNS;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class Generator {
    private long current;
    public final int dclass;
    public long end;
    public final String namePattern;
    public final Name origin;
    public final String rdataPattern;
    public long start;
    public long step;
    public final long ttl;
    public final int type;

    public static boolean supportedType(int i) {
        Type.check(i);
        return i == 12 || i == 5 || i == 39 || i == 1 || i == 28 || i == 2;
    }

    public Generator(long j, long j2, long j3, String str, int i, int i2, long j4, String str2, Name name) {
        if (j < 0 || j2 < 0 || j > j2 || j3 <= 0) {
            throw new IllegalArgumentException("invalid range specification");
        }
        if (!supportedType(i)) {
            throw new IllegalArgumentException("unsupported type");
        }
        DClass.check(i2);
        this.start = j;
        this.end = j2;
        this.step = j3;
        this.namePattern = str;
        this.type = i;
        this.dclass = i2;
        this.ttl = j4;
        this.rdataPattern = str2;
        this.origin = name;
        this.current = j;
    }

    private String substitute(String str, long j) throws IOException {
        int i;
        boolean z;
        long j2;
        long j3;
        String string;
        boolean z2;
        int i2;
        byte b;
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < bytes.length) {
            char c = (char) (bytes[i3] & 255);
            if (z3) {
                sb.append(c);
                i = 1;
                z3 = false;
            } else if (c != '\\') {
                if (c == '$') {
                    int i4 = i3 + 1;
                    if (i4 < bytes.length && (b = bytes[i4]) == 36) {
                        sb.append((char) (b & 255));
                    } else {
                        long j4 = 10;
                        if (i4 >= bytes.length || bytes[i4] != 123) {
                            i4 = i3;
                            z = false;
                            j2 = 0;
                            j3 = 0;
                        } else {
                            int i5 = i4 + 1;
                            if (i5 >= bytes.length || bytes[i5] != 45) {
                                z2 = false;
                            } else {
                                i4 = i5;
                                z2 = true;
                            }
                            j3 = 0;
                            while (true) {
                                int i6 = i4 + 1;
                                if (i6 >= bytes.length) {
                                    break;
                                }
                                c = (char) (bytes[i6] & 255);
                                if (c == ',' || c == '}') {
                                    i4 = i6;
                                    break;
                                }
                                if (c < '0' || c > '9') {
                                    throw new TextParseException("invalid offset");
                                }
                                c = (char) (c - '0');
                                j3 = (j3 * 10) + ((long) c);
                                i4 = i6;
                            }
                            if (z2) {
                                j3 = -j3;
                            }
                            long j5 = 0;
                            if (c == ',') {
                                while (true) {
                                    int i7 = i4 + 1;
                                    if (i7 >= bytes.length) {
                                        break;
                                    }
                                    c = (char) (bytes[i7] & 255);
                                    if (c == ',' || c == '}') {
                                        i4 = i7;
                                        break;
                                    }
                                    if (c < '0' || c > '9') {
                                        throw new TextParseException("invalid width");
                                    }
                                    c = (char) (c - '0');
                                    j5 = (j5 * 10) + ((long) c);
                                    i4 = i7;
                                }
                            }
                            if (c != ',') {
                                z = false;
                                i2 = 1;
                            } else {
                                i4++;
                                if (i4 == bytes.length) {
                                    throw new TextParseException("invalid base");
                                }
                                char c2 = (char) (bytes[i4] & 255);
                                if (c2 == 'o') {
                                    z = false;
                                    i2 = 1;
                                    j4 = 8;
                                } else {
                                    if (c2 == 'x') {
                                        z = false;
                                    } else if (c2 == 'X') {
                                        z = true;
                                    } else {
                                        if (c2 != 'd') {
                                            throw new TextParseException("invalid base");
                                        }
                                        z = false;
                                        i2 = 1;
                                    }
                                    i2 = 1;
                                    j4 = 16;
                                }
                            }
                            i4 += i2;
                            if (i4 == bytes.length || bytes[i4] != 125) {
                                throw new TextParseException("invalid modifiers");
                            }
                            j2 = j5;
                        }
                        long j6 = j + j3;
                        if (j6 < 0) {
                            throw new TextParseException("invalid offset expansion");
                        }
                        if (j4 == 8) {
                            string = Long.toOctalString(j6);
                        } else if (j4 == 16) {
                            string = Long.toHexString(j6);
                        } else {
                            string = Long.toString(j6);
                        }
                        if (z) {
                            string = string.toUpperCase();
                        }
                        if (j2 != 0 && j2 > string.length()) {
                            int length = ((int) j2) - string.length();
                            while (true) {
                                int i8 = length - 1;
                                if (length <= 0) {
                                    break;
                                }
                                sb.append('0');
                                length = i8;
                            }
                        }
                        sb.append(string);
                    }
                    i3 = i4;
                } else {
                    sb.append(c);
                }
                i = 1;
            } else {
                if (i3 + 1 == bytes.length) {
                    throw new TextParseException("invalid escape character");
                }
                i = 1;
                z3 = true;
            }
            i3 += i;
        }
        return sb.toString();
    }

    public Record nextRecord() throws IOException {
        long j = this.current;
        if (j > this.end) {
            return null;
        }
        Name nameFromString = Name.fromString(substitute(this.namePattern, j), this.origin);
        String strSubstitute = substitute(this.rdataPattern, this.current);
        this.current += this.step;
        return Record.fromString(nameFromString, this.type, this.dclass, this.ttl, strSubstitute, this.origin);
    }

    public Record[] expand() throws IOException {
        ArrayList arrayList = new ArrayList();
        long j = this.start;
        while (j < this.end) {
            arrayList.add(Record.fromString(Name.fromString(substitute(this.namePattern, this.current), this.origin), this.type, this.dclass, this.ttl, substitute(this.rdataPattern, this.current), this.origin));
            j += this.step;
        }
        return (Record[]) arrayList.toArray(new Record[0]);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("$GENERATE ");
        sb.append(this.start);
        sb.append("-");
        sb.append(this.end);
        if (this.step > 1) {
            sb.append("/");
            sb.append(this.step);
        }
        sb.append(" ");
        sb.append(this.namePattern);
        sb.append(" ");
        sb.append(this.ttl);
        sb.append(" ");
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            sb.append(DClass.string(this.dclass));
            sb.append(" ");
        }
        sb.append(Type.string(this.type));
        sb.append(" ");
        sb.append(this.rdataPattern);
        sb.append(" ");
        return sb.toString();
    }
}
