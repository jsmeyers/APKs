package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class CAARecord extends Record {
    private int flags;
    private byte[] tag;
    private byte[] value;

    public static class Flags {
        public static final int IssuerCritical = 128;

        private Flags() {
        }
    }

    CAARecord() {
    }

    public CAARecord(Name name, int i, long j, int i2, String str, String str2) {
        super(name, 257, i, j);
        this.flags = checkU8("flags", i2);
        try {
            this.tag = byteArrayFromString(str);
            this.value = byteArrayFromString(str2);
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.flags = dNSInput.readU8();
        this.tag = dNSInput.readCountedString();
        this.value = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.flags = tokenizer.getUInt8();
        try {
            this.tag = byteArrayFromString(tokenizer.getString());
            this.value = byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.flags + " " + byteArrayToString(this.tag, false) + " " + byteArrayToString(this.value, true);
    }

    public int getFlags() {
        return this.flags;
    }

    public String getTag() {
        return byteArrayToString(this.tag, false);
    }

    public String getValue() {
        return byteArrayToString(this.value, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.flags);
        dNSOutput.writeCountedString(this.tag);
        dNSOutput.writeByteArray(this.value);
    }
}
