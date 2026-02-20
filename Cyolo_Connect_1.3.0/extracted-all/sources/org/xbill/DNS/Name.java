package org.xbill.DNS;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.kxml2.wap.Wbxml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes2.dex */
public class Name implements Comparable<Name>, Serializable {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 63;
    private static final int MAXLABELS = 128;
    private static final int MAXNAME = 255;
    private static final int MAXOFFSETS = 8;
    private static final DecimalFormat byteFormat;
    public static final Name empty;
    private static final byte[] lowercase;
    public static final Name root;
    private static final long serialVersionUID = 5149282554141851880L;
    private static final Name wild;
    private int hashcode;
    private int labels;
    private byte[] name;
    private long offsets;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) Name.class);
    private static final byte[] emptyLabel = {0};
    private static final byte[] wildLabel = {1, 42};

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        lowercase = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        int i = 0;
        while (true) {
            byte[] bArr = lowercase;
            if (i >= bArr.length) {
                Name name = new Name();
                root = name;
                name.appendSafe(emptyLabel, 0, 1);
                Name name2 = new Name();
                empty = name2;
                name2.name = new byte[0];
                Name name3 = new Name();
                wild = name3;
                name3.appendSafe(wildLabel, 0, 1);
                return;
            }
            if (i < 65 || i > 90) {
                bArr[i] = (byte) i;
            } else {
                bArr[i] = (byte) ((i - 65) + 97);
            }
            i++;
        }
    }

    private Name() {
    }

    private void setoffset(int i, int i2) {
        if (i >= 8) {
            return;
        }
        int i3 = i * 8;
        this.offsets = (((long) i2) << i3) | (this.offsets & (~(255 << i3)));
    }

    private int offset(int i) {
        if (i == 0 && this.labels == 0) {
            return 0;
        }
        if (i < 0 || i >= this.labels) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i < 8) {
            return ((int) (this.offsets >>> (i * 8))) & 255;
        }
        int iOffset = offset(7);
        for (int i2 = 7; i2 < i; i2++) {
            iOffset += this.name[iOffset] + 1;
        }
        return iOffset;
    }

    private static void copy(Name name, Name name2) {
        int i;
        int i2 = 0;
        if (name.offset(0) == 0) {
            name2.name = name.name;
            name2.offsets = name.offsets;
            name2.labels = name.labels;
            return;
        }
        int iOffset = name.offset(0);
        int length = name.name.length - iOffset;
        byte[] bArr = new byte[length];
        name2.name = bArr;
        System.arraycopy(name.name, iOffset, bArr, 0, length);
        while (true) {
            i = name.labels;
            if (i2 >= i || i2 >= 8) {
                break;
            }
            name2.setoffset(i2, name.offset(i2) - iOffset);
            i2++;
        }
        name2.labels = i;
    }

    private void append(byte[] bArr, int i, int i2) throws NameTooLongException {
        byte[] bArr2 = this.name;
        int length = bArr2 == null ? 0 : bArr2.length - offset(0);
        int i3 = i;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i3];
            if (i6 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i7 = i6 + 1;
            i3 += i7;
            i4 += i7;
        }
        int i8 = length + i4;
        if (i8 > 255) {
            throw new NameTooLongException();
        }
        int i9 = this.labels + i2;
        if (i9 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i8];
        if (length != 0) {
            System.arraycopy(this.name, offset(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i, bArr3, length, i4);
        this.name = bArr3;
        for (int i10 = 0; i10 < i2; i10++) {
            setoffset(this.labels + i10, length);
            length += bArr3[length] + 1;
        }
        this.labels = i9;
    }

    private static TextParseException parseException(String str, String str2) {
        return new TextParseException("'" + str + "': " + str2);
    }

    private void appendFromString(String str, byte[] bArr, int i, int i2) throws TextParseException {
        try {
            append(bArr, i, i2);
        } catch (NameTooLongException unused) {
            throw parseException(str, "Name too long");
        }
    }

    private void appendSafe(byte[] bArr, int i, int i2) {
        try {
            append(bArr, i, i2);
        } catch (NameTooLongException unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Found duplicated region for block: B:4:0x0013  */
    public Name(String str, Name name) throws TextParseException {
        int i;
        boolean z;
        int i2;
        str.hashCode();
        switch (str) {
            case "":
                throw parseException(str, "empty name");
            case ".":
                copy(root, this);
                return;
            case "@":
                if (name == null) {
                    copy(empty, this);
                    return;
                } else {
                    copy(name, this);
                    return;
                }
            default:
                byte[] bArr = new byte[64];
                int i3 = 0;
                boolean z2 = false;
                int i4 = -1;
                int i5 = 1;
                int i6 = 0;
                for (int i7 = 0; i7 < str.length(); i7++) {
                    byte bCharAt = (byte) str.charAt(i7);
                    if (z2) {
                        if (bCharAt >= 48 && bCharAt <= 57 && i3 < 3) {
                            i3++;
                            i6 = (i6 * 10) + (bCharAt - 48);
                            if (i6 > 255) {
                                throw parseException(str, "bad escape");
                            }
                            if (i3 < 3) {
                                continue;
                            } else {
                                bCharAt = (byte) i6;
                            }
                        } else if (i3 > 0 && i3 < 3) {
                            throw parseException(str, "bad escape");
                        }
                        if (i5 > 63) {
                            throw parseException(str, "label too long");
                        }
                        i2 = i5 + 1;
                        bArr[i5] = bCharAt;
                        i4 = i5;
                        z2 = false;
                        i5 = i2;
                    } else if (bCharAt == 92) {
                        i3 = 0;
                        z2 = true;
                        i6 = 0;
                    } else if (bCharAt == 46) {
                        if (i4 == -1) {
                            throw parseException(str, "invalid empty label");
                        }
                        bArr[0] = (byte) (i5 - 1);
                        appendFromString(str, bArr, 0, 1);
                        i4 = -1;
                        i5 = 1;
                    } else {
                        i4 = i4 == -1 ? i7 : i4;
                        if (i5 > 63) {
                            throw parseException(str, "label too long");
                        }
                        i2 = i5 + 1;
                        bArr[i5] = bCharAt;
                        i5 = i2;
                    }
                }
                if (i3 > 0 && i3 < 3) {
                    throw parseException(str, "bad escape");
                }
                if (z2) {
                    throw parseException(str, "bad escape");
                }
                if (i4 == -1) {
                    z = true;
                    i = 0;
                    appendFromString(str, emptyLabel, 0, 1);
                } else {
                    i = 0;
                    bArr[0] = (byte) (i5 - 1);
                    appendFromString(str, bArr, 0, 1);
                    z = false;
                }
                if (name != null && !z) {
                    appendFromString(str, name.name, name.offset(i), name.labels);
                }
                if (!z && length() == 255) {
                    throw parseException(str, "Name too long");
                }
                return;
        }
    }

    public Name(String str) throws TextParseException {
        this(str, (Name) null);
    }

    public static Name fromString(String str, Name name) throws TextParseException {
        if (str.equals("@") && name != null) {
            return name;
        }
        if (str.equals(".")) {
            return root;
        }
        return new Name(str, name);
    }

    public static Name fromString(String str) throws TextParseException {
        return fromString(str, null);
    }

    public static Name fromConstantString(String str) {
        try {
            return fromString(str, null);
        } catch (TextParseException unused) {
            throw new IllegalArgumentException("Invalid name '" + str + "'");
        }
    }

    public Name(DNSInput dNSInput) throws WireParseException {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int u8 = dNSInput.readU8();
            int i = u8 & Wbxml.EXT_0;
            if (i != 0) {
                if (i == 192) {
                    int u82 = dNSInput.readU8() + ((u8 & (-193)) << 8);
                    Logger logger = log;
                    logger.trace("currently {}, pointer to {}", Integer.valueOf(dNSInput.current()), Integer.valueOf(u82));
                    if (u82 >= dNSInput.current() - 2) {
                        throw new WireParseException("bad compression");
                    }
                    if (!z2) {
                        dNSInput.save();
                        z2 = true;
                    }
                    dNSInput.jump(u82);
                    logger.trace("current name '{}', seeking to {}", this, Integer.valueOf(u82));
                } else {
                    throw new WireParseException("bad label type");
                }
            } else {
                if (this.labels >= 128) {
                    throw new WireParseException("too many labels");
                }
                if (u8 == 0) {
                    append(emptyLabel, 0, 1);
                    z = true;
                } else {
                    bArr[0] = (byte) u8;
                    dNSInput.readByteArray(bArr, 1, u8);
                    append(bArr, 0, 1);
                }
            }
        }
        if (z2) {
            dNSInput.restore();
        }
    }

    public Name(byte[] bArr) throws IOException {
        this(new DNSInput(bArr));
    }

    public Name(Name name, int i) {
        int i2 = name.labels;
        if (i > i2) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.name = name.name;
        int i3 = i2 - i;
        this.labels = i3;
        for (int i4 = 0; i4 < 8 && i4 < i3; i4++) {
            setoffset(i4, name.offset(i4 + i));
        }
    }

    public static Name concatenate(Name name, Name name2) throws NameTooLongException {
        if (name.isAbsolute()) {
            return name;
        }
        Name name3 = new Name();
        copy(name, name3);
        name3.append(name2.name, name2.offset(0), name2.labels);
        return name3;
    }

    public Name relativize(Name name) {
        if (name == null || !subdomain(name)) {
            return this;
        }
        Name name2 = new Name();
        copy(this, name2);
        int length = length() - name.length();
        name2.labels -= name.labels;
        name2.name = new byte[length];
        System.arraycopy(this.name, offset(0), name2.name, 0, length);
        return name2;
    }

    public Name wild(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("must replace 1 or more labels");
        }
        try {
            Name name = new Name();
            copy(wild, name);
            name.append(this.name, offset(i), this.labels - i);
            return name;
        } catch (NameTooLongException unused) {
            throw new IllegalStateException("Name.wild: concatenate failed");
        }
    }

    public Name canonicalize() {
        boolean z;
        byte[] bArr = this.name;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            }
            byte b = bArr[i2];
            if (lowercase[b & 255] != b) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            return this;
        }
        Name name = new Name();
        name.appendSafe(this.name, offset(0), this.labels);
        while (true) {
            byte[] bArr2 = name.name;
            if (i >= bArr2.length) {
                return name;
            }
            bArr2[i] = lowercase[bArr2[i] & 255];
            i++;
        }
    }

    public Name fromDNAME(DNAMERecord dNAMERecord) throws NameTooLongException {
        Name name = dNAMERecord.getName();
        Name target = dNAMERecord.getTarget();
        if (!subdomain(name)) {
            return null;
        }
        int i = this.labels - name.labels;
        int length = length() - name.length();
        int iOffset = offset(0);
        int i2 = target.labels;
        short length2 = target.length();
        int i3 = length + length2;
        if (i3 > 255) {
            throw new NameTooLongException();
        }
        Name name2 = new Name();
        int i4 = i + i2;
        name2.labels = i4;
        byte[] bArr = new byte[i3];
        name2.name = bArr;
        System.arraycopy(this.name, iOffset, bArr, 0, length);
        System.arraycopy(target.name, 0, name2.name, length, length2);
        int i5 = 0;
        for (int i6 = 0; i6 < 8 && i6 < i4; i6++) {
            name2.setoffset(i6, i5);
            i5 += name2.name[i5] + 1;
        }
        return name2;
    }

    public boolean isWild() {
        if (this.labels == 0) {
            return false;
        }
        byte[] bArr = this.name;
        return bArr[0] == 1 && bArr[1] == 42;
    }

    public boolean isAbsolute() {
        int i = this.labels;
        return i != 0 && this.name[offset(i - 1)] == 0;
    }

    public short length() {
        if (this.labels == 0) {
            return (short) 0;
        }
        return (short) (this.name.length - offset(0));
    }

    public int labels() {
        return this.labels;
    }

    public boolean subdomain(Name name) {
        int i = name.labels;
        int i2 = this.labels;
        if (i > i2) {
            return false;
        }
        if (i == i2) {
            return equals(name);
        }
        return name.equals(this.name, offset(i2 - i));
    }

    private String byteString(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i + 1;
        int i3 = bArr[i];
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            int i5 = bArr[i4] & 255;
            if (i5 <= 32 || i5 >= 127) {
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                sb.append(byteFormat.format(i5));
            } else if (i5 == 34 || i5 == 40 || i5 == 41 || i5 == 46 || i5 == 59 || i5 == 92 || i5 == 64 || i5 == 36) {
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                sb.append((char) i5);
            } else {
                sb.append((char) i5);
            }
        }
        return sb.toString();
    }

    public String toString(boolean z) {
        int i = this.labels;
        if (i == 0) {
            return "@";
        }
        if (i == 1 && this.name[offset(0)] == 0) {
            return ".";
        }
        StringBuilder sb = new StringBuilder();
        int iOffset = offset(0);
        for (int i2 = 0; i2 < this.labels; i2++) {
            byte b = this.name[iOffset];
            if (b > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b == 0) {
                if (!z) {
                    sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                    break;
                }
                break;
            }
            if (i2 > 0) {
                sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            }
            sb.append(byteString(this.name, iOffset));
            iOffset += b + 1;
        }
        return sb.toString();
    }

    public String toString() {
        return toString(false);
    }

    public byte[] getLabel(int i) {
        int iOffset = offset(i);
        byte[] bArr = this.name;
        int i2 = (byte) (bArr[iOffset] + 1);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, iOffset, bArr2, 0, i2);
        return bArr2;
    }

    public String getLabelString(int i) {
        return byteString(this.name, offset(i));
    }

    public void toWire(DNSOutput dNSOutput, Compression compression) {
        if (!isAbsolute()) {
            throw new IllegalArgumentException("toWire() called on non-absolute name");
        }
        int i = 0;
        while (i < this.labels - 1) {
            Name name = i == 0 ? this : new Name(this, i);
            int i2 = compression != null ? compression.get(name) : -1;
            if (i2 >= 0) {
                dNSOutput.writeU16(49152 | i2);
                return;
            }
            if (compression != null) {
                compression.add(dNSOutput.current(), name);
            }
            int iOffset = offset(i);
            byte[] bArr = this.name;
            dNSOutput.writeByteArray(bArr, iOffset, bArr[iOffset] + 1);
            i++;
        }
        dNSOutput.writeU8(0);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, null);
        return dNSOutput.toByteArray();
    }

    public void toWireCanonical(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(toWireCanonical());
    }

    public byte[] toWireCanonical() {
        if (this.labels == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.name.length - offset(0)];
        int iOffset = offset(0);
        int i = 0;
        for (int i2 = 0; i2 < this.labels; i2++) {
            byte b = this.name[iOffset];
            if (b > 63) {
                throw new IllegalStateException("invalid label");
            }
            iOffset++;
            bArr[i] = b;
            i++;
            int i3 = 0;
            while (i3 < b) {
                bArr[i] = lowercase[this.name[iOffset] & 255];
                i3++;
                i++;
                iOffset++;
            }
        }
        return bArr;
    }

    public void toWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        if (z) {
            toWireCanonical(dNSOutput);
        } else {
            toWire(dNSOutput, compression);
        }
    }

    private boolean equals(byte[] bArr, int i) {
        int iOffset = offset(0);
        for (int i2 = 0; i2 < this.labels; i2++) {
            byte b = this.name[iOffset];
            if (b != bArr[i]) {
                return false;
            }
            iOffset++;
            i++;
            if (b > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i3 = 0;
            while (i3 < b) {
                byte[] bArr2 = lowercase;
                int i4 = iOffset + 1;
                int i5 = i + 1;
                if (bArr2[this.name[iOffset] & 255] != bArr2[bArr[i] & 255]) {
                    return false;
                }
                i3++;
                i = i5;
                iOffset = i4;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        if (name.hashCode() == hashCode() && name.labels == this.labels) {
            return equals(name.name, name.offset(0));
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashcode;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        int iOffset = offset(0);
        while (true) {
            byte[] bArr = this.name;
            if (iOffset < bArr.length) {
                i2 += (i2 << 3) + (lowercase[bArr[iOffset] & 255] & 255);
                iOffset++;
            } else {
                this.hashcode = i2;
                return i2;
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        if (this == name) {
            return 0;
        }
        int i = name.labels;
        int iMin = Math.min(this.labels, i);
        for (int i2 = 1; i2 <= iMin; i2++) {
            int iOffset = offset(this.labels - i2);
            int iOffset2 = name.offset(i - i2);
            byte b = this.name[iOffset];
            byte b2 = name.name[iOffset2];
            for (int i3 = 0; i3 < b && i3 < b2; i3++) {
                byte[] bArr = lowercase;
                int i4 = (bArr[this.name[(i3 + iOffset) + 1] & 255] & 255) - (bArr[name.name[(i3 + iOffset2) + 1] & 255] & 255);
                if (i4 != 0) {
                    return i4;
                }
            }
            if (b != b2) {
                return b - b2;
            }
        }
        return this.labels - i;
    }
}
