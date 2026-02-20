package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class X25Record extends Record {
    private byte[] address;

    X25Record() {
    }

    private static byte[] checkAndConvertAddress(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isDigit(cCharAt)) {
                return null;
            }
            bArr[i] = (byte) cCharAt;
        }
        return bArr;
    }

    public X25Record(Name name, int i, long j, String str) {
        super(name, 19, i, j);
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(str);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress != null) {
            return;
        }
        throw new IllegalArgumentException("invalid PSDN address " + str);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.address = dNSInput.readCountedString();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String string = tokenizer.getString();
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(string);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress != null) {
            return;
        }
        throw tokenizer.exception("invalid PSDN address " + string);
    }

    public String getAddress() {
        return byteArrayToString(this.address, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.address);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return byteArrayToString(this.address, true);
    }
}
