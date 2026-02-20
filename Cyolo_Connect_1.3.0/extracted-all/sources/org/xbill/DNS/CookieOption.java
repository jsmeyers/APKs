package org.xbill.DNS;

import j$.util.Optional;
import java.io.IOException;
import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public class CookieOption extends EDNSOption {
    private byte[] clientCookie;
    private byte[] serverCookie;

    CookieOption() {
        super(10);
    }

    public CookieOption(byte[] bArr) {
        this(bArr, null);
    }

    public CookieOption(byte[] bArr, byte[] bArr2) {
        int length;
        this();
        if (bArr == null) {
            throw new IllegalArgumentException("client cookie must not be null");
        }
        if (bArr.length != 8) {
            throw new IllegalArgumentException("client cookie must consist of eight bytes");
        }
        this.clientCookie = bArr;
        if (bArr2 != null && ((length = bArr2.length) < 8 || length > 32)) {
            throw new IllegalArgumentException("server cookie must consist of 8 to 32 bytes");
        }
        this.serverCookie = bArr2;
    }

    public byte[] getClientCookie() {
        return this.clientCookie;
    }

    public Optional<byte[]> getServerCookie() {
        return Optional.ofNullable(this.serverCookie);
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) throws IOException {
        int iRemaining = dNSInput.remaining();
        if (iRemaining < 8) {
            throw new WireParseException("invalid length of client cookie");
        }
        this.clientCookie = dNSInput.readByteArray(8);
        if (iRemaining > 8) {
            if (iRemaining < 16 || iRemaining > 40) {
                throw new WireParseException("invalid length of server cookie");
            }
            this.serverCookie = dNSInput.readByteArray();
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(this.clientCookie);
        byte[] bArr = this.serverCookie;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        if (this.serverCookie != null) {
            return base16.toString(this.clientCookie) + " " + base16.toString(this.serverCookie);
        }
        return base16.toString(this.clientCookie);
    }
}
