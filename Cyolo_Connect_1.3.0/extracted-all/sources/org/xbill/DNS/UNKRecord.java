package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class UNKRecord extends Record {
    private byte[] data;

    UNKRecord() {
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        throw tokenizer.exception("invalid unknown RR encoding");
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
