package org.xbill.DNS;

import java.io.IOException;
import java.util.BitSet;
import org.xbill.DNS.Tokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class NXTRecord extends Record {
    private BitSet bitmap;
    private Name next;

    NXTRecord() {
    }

    public NXTRecord(Name name, int i, long j, Name name2, BitSet bitSet) {
        super(name, 30, i, j);
        this.next = checkName("next", name2);
        this.bitmap = bitSet;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.next = new Name(dNSInput);
        this.bitmap = new BitSet();
        int iRemaining = dNSInput.remaining();
        for (int i = 0; i < iRemaining; i++) {
            int u8 = dNSInput.readU8();
            for (int i2 = 0; i2 < 8; i2++) {
                if (((1 << (7 - i2)) & u8) != 0) {
                    this.bitmap.set((i * 8) + i2);
                }
            }
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.next = tokenizer.getName(name);
        this.bitmap = new BitSet();
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (token.isString()) {
                int iValue = Type.value(token.value, true);
                if (iValue <= 0 || iValue > 128) {
                    throw tokenizer.exception("Invalid type: " + token.value);
                }
                this.bitmap.set(iValue);
            } else {
                tokenizer.unget();
                return;
            }
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.next);
        int length = this.bitmap.length();
        for (short s = 0; s < length; s = (short) (s + 1)) {
            if (this.bitmap.get(s)) {
                sb.append(" ");
                sb.append(Type.string(s));
            }
        }
        return sb.toString();
    }

    public Name getNext() {
        return this.next;
    }

    public BitSet getBitmap() {
        return this.bitmap;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.next.toWire(dNSOutput, null, z);
        int length = this.bitmap.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i |= this.bitmap.get(i2) ? 1 << (7 - (i2 % 8)) : 0;
            if (i2 % 8 == 7 || i2 == length - 1) {
                dNSOutput.writeU8(i);
                i = 0;
            }
        }
    }
}
