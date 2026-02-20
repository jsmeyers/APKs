package org.xbill.DNS;

import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public class GenericEDNSOption extends EDNSOption {
    private byte[] data;

    GenericEDNSOption(int i) {
        super(i);
    }

    public GenericEDNSOption(int i, byte[] bArr) {
        super(i);
        this.data = Record.checkByteArrayLength("option data", bArr, 65535);
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(this.data);
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        return "<" + base16.toString(this.data) + ">";
    }
}
