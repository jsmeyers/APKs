package org.xbill.DNS;

import java.io.IOException;
import org.xbill.DNS.utils.base64;

/* JADX INFO: loaded from: classes2.dex */
public class DHCIDRecord extends Record {
    private byte[] data;

    DHCIDRecord() {
    }

    public DHCIDRecord(Name name, int i, long j, byte[] bArr) {
        super(name, 49, i, j);
        this.data = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.data = tokenizer.getBase64();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.data);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return base64.toString(this.data);
    }

    public byte[] getData() {
        return this.data;
    }
}
