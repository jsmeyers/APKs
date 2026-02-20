package org.xbill.DNS;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class Header implements Cloneable {
    public static final int LENGTH = 12;
    private static final Random random = new SecureRandom();
    private int[] counts;
    private int flags;
    private int id;

    public Header(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
        }
        this.counts = new int[4];
        this.flags = 0;
        this.id = i;
    }

    public Header() {
        this(random.nextInt(65535));
    }

    Header(DNSInput dNSInput) throws IOException {
        this(dNSInput.readU16());
        this.flags = dNSInput.readU16();
        int i = 0;
        while (true) {
            int[] iArr = this.counts;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = dNSInput.readU16();
            i++;
        }
    }

    public Header(byte[] bArr) throws IOException {
        this(new DNSInput(bArr));
    }

    void toWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(getID());
        dNSOutput.writeU16(this.flags);
        for (int i : this.counts) {
            dNSOutput.writeU16(i);
        }
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    private static boolean validFlag(int i) {
        return i >= 0 && i <= 15 && Flags.isFlag(i);
    }

    private static void checkFlag(int i) {
        if (validFlag(i)) {
            return;
        }
        throw new IllegalArgumentException("invalid flag bit " + i);
    }

    static int setFlag(int i, int i2, boolean z) {
        checkFlag(i2);
        return z ? i | (1 << (15 - i2)) : i & (~(1 << (15 - i2)));
    }

    public void setFlag(int i) {
        checkFlag(i);
        this.flags = setFlag(this.flags, i, true);
    }

    public void unsetFlag(int i) {
        checkFlag(i);
        this.flags = setFlag(this.flags, i, false);
    }

    public boolean getFlag(int i) {
        checkFlag(i);
        return ((1 << (15 - i)) & this.flags) != 0;
    }

    boolean[] getFlags() {
        boolean[] zArr = new boolean[16];
        for (int i = 0; i < 16; i++) {
            if (validFlag(i)) {
                zArr[i] = getFlag(i);
            }
        }
        return zArr;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
        }
        this.id = i;
    }

    public void setRcode(int i) {
        if (i < 0 || i > 15) {
            throw new IllegalArgumentException("DNS Rcode " + i + " is out of range");
        }
        this.flags = i | (this.flags & (-16));
    }

    public int getRcode() {
        return this.flags & 15;
    }

    public void setOpcode(int i) {
        if (i < 0 || i > 15) {
            throw new IllegalArgumentException("DNS Opcode " + i + "is out of range");
        }
        this.flags = (i << 11) | (this.flags & 34815);
    }

    public int getOpcode() {
        return (this.flags >> 11) & 15;
    }

    void setCount(int i, int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("DNS section count " + i2 + " is out of range");
        }
        this.counts[i] = i2;
    }

    void incCount(int i) {
        int[] iArr = this.counts;
        int i2 = iArr[i];
        if (i2 == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i] = i2 + 1;
    }

    void decCount(int i) {
        int[] iArr = this.counts;
        int i2 = iArr[i];
        if (i2 == 0) {
            throw new IllegalStateException("DNS section count cannot be decremented");
        }
        iArr[i] = i2 - 1;
    }

    public int getCount(int i) {
        return this.counts[i];
    }

    int getFlagsByte() {
        return this.flags;
    }

    public String printFlags() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if (validFlag(i) && getFlag(i)) {
                sb.append(Flags.string(i));
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    String toStringWithRcode(int i) {
        StringBuilder sb = new StringBuilder(";; ->>HEADER<<- opcode: ");
        sb.append(Opcode.string(getOpcode()));
        sb.append(", status: ");
        sb.append(Rcode.string(i));
        sb.append(", id: ");
        sb.append(getID());
        sb.append("\n;; flags: ");
        sb.append(printFlags());
        sb.append("; ");
        for (int i2 = 0; i2 < 4; i2++) {
            sb.append(Section.string(i2));
            sb.append(": ");
            sb.append(getCount(i2));
            sb.append(" ");
        }
        return sb.toString();
    }

    public String toString() {
        return toStringWithRcode(getRcode());
    }

    public Header clone() {
        Header header = (Header) super.clone();
        header.id = this.id;
        header.flags = this.flags;
        int[] iArr = new int[header.counts.length];
        header.counts = iArr;
        int[] iArr2 = this.counts;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        return header;
    }
}
