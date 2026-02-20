package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class NULLRecord extends Record {
    private byte[] data;

    NULLRecord() {
    }

    public NULLRecord(Name name, int i, long j, byte[] bArr) {
        super(name, 10, i, j);
        if (bArr.length > 65535) {
            throw new IllegalArgumentException("data must be <65536 bytes");
        }
        this.data = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        throw tokenizer.exception("no defined text format for NULL records");
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return unknownToString(this.data);
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.data);
    }
}
