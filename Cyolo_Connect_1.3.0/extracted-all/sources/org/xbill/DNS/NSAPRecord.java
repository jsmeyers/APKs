package org.xbill.DNS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public class NSAPRecord extends Record {
    private byte[] address;

    NSAPRecord() {
    }

    private static byte[] checkAndConvertAddress(String str) {
        if (!str.substring(0, 2).equalsIgnoreCase("0x")) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        int i = 0;
        for (int i2 = 2; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '.') {
                int iDigit = Character.digit(cCharAt, 16);
                if (iDigit == -1) {
                    return null;
                }
                if (z) {
                    i += iDigit;
                    byteArrayOutputStream.write(i);
                    z = false;
                } else {
                    i = iDigit << 4;
                    z = true;
                }
            }
        }
        if (z) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public NSAPRecord(Name name, int i, long j, String str) {
        super(name, 22, i, j);
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(str);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress != null) {
            return;
        }
        throw new IllegalArgumentException("invalid NSAP address " + str);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.address = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String string = tokenizer.getString();
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(string);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress != null) {
            return;
        }
        throw tokenizer.exception("invalid NSAP address " + string);
    }

    public String getAddress() {
        return byteArrayToString(this.address, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.address);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return "0x" + base16.toString(this.address);
    }
}
