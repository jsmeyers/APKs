package org.xbill.DNS;

import java.io.IOException;
import org.xbill.DNS.utils.base64;

/* JADX INFO: loaded from: classes2.dex */
public class OPENPGPKEYRecord extends Record {
    private byte[] cert;

    OPENPGPKEYRecord() {
    }

    public OPENPGPKEYRecord(Name name, int i, long j, byte[] bArr) {
        super(name, 61, i, j);
        this.cert = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.cert = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.cert = tokenizer.getBase64();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        if (this.cert != null) {
            if (Options.check("multiline")) {
                sb.append("(\n");
                sb.append(base64.formatString(this.cert, 64, "\t", true));
            } else {
                sb.append(base64.toString(this.cert));
            }
        }
        return sb.toString();
    }

    public byte[] getCert() {
        return this.cert;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.cert);
    }
}
