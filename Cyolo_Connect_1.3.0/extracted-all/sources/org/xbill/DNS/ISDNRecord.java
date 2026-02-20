package org.xbill.DNS;

import java.io.IOException;
import org.xbill.DNS.Tokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class ISDNRecord extends Record {
    private byte[] address;
    private byte[] subAddress;

    ISDNRecord() {
    }

    public ISDNRecord(Name name, int i, long j, String str, String str2) {
        super(name, 20, i, j);
        try {
            this.address = byteArrayFromString(str);
            if (str2 != null) {
                this.subAddress = byteArrayFromString(str2);
            }
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.address = dNSInput.readCountedString();
        if (dNSInput.remaining() > 0) {
            this.subAddress = dNSInput.readCountedString();
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        try {
            this.address = byteArrayFromString(tokenizer.getString());
            Tokenizer.Token token = tokenizer.get();
            if (token.isString()) {
                this.subAddress = byteArrayFromString(token.value);
            } else {
                tokenizer.unget();
            }
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    public String getAddress() {
        return byteArrayToString(this.address, false);
    }

    public String getSubAddress() {
        byte[] bArr = this.subAddress;
        if (bArr == null) {
            return null;
        }
        return byteArrayToString(bArr, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.address);
        byte[] bArr = this.subAddress;
        if (bArr != null) {
            dNSOutput.writeCountedString(bArr);
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(byteArrayToString(this.address, true));
        if (this.subAddress != null) {
            sb.append(" ");
            sb.append(byteArrayToString(this.subAddress, true));
        }
        return sb.toString();
    }
}
