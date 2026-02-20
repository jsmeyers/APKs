package org.xbill.DNS;

import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class ARecord extends Record {
    private int addr;

    private static byte[] toArray(int i) {
        return new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    ARecord() {
    }

    private static int fromArray(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    public ARecord(Name name, int i, long j, InetAddress inetAddress) {
        super(name, 1, i, j);
        if (Address.familyOf(inetAddress) != 1) {
            throw new IllegalArgumentException("invalid IPv4 address");
        }
        this.addr = fromArray(inetAddress.getAddress());
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.addr = fromArray(dNSInput.readByteArray(4));
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.addr = fromArray(tokenizer.getAddressBytes(1));
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return Address.toDottedQuad(toArray(this.addr));
    }

    public InetAddress getAddress() {
        try {
            if (this.name == null) {
                return InetAddress.getByAddress(toArray(this.addr));
            }
            return InetAddress.getByAddress(this.name.toString(), toArray(this.addr));
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU32(((long) this.addr) & KeyboardMap.kValueMask);
    }
}
