package org.xbill.DNS;

import java.io.IOException;
import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public class SSHFPRecord extends Record {
    private int alg;
    private int digestType;
    private byte[] fingerprint;

    public static class Algorithm {
        public static final int DSS = 2;
        public static final int RSA = 1;

        private Algorithm() {
        }
    }

    public static class Digest {
        public static final int SHA1 = 1;

        private Digest() {
        }
    }

    SSHFPRecord() {
    }

    public SSHFPRecord(Name name, int i, long j, int i2, int i3, byte[] bArr) {
        super(name, 44, i, j);
        this.alg = checkU8("alg", i2);
        this.digestType = checkU8("digestType", i3);
        this.fingerprint = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.alg = dNSInput.readU8();
        this.digestType = dNSInput.readU8();
        this.fingerprint = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.alg = tokenizer.getUInt8();
        this.digestType = tokenizer.getUInt8();
        this.fingerprint = tokenizer.getHex(true);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.alg + " " + this.digestType + " " + base16.toString(this.fingerprint);
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public int getDigestType() {
        return this.digestType;
    }

    public byte[] getFingerPrint() {
        return this.fingerprint;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeU8(this.digestType);
        dNSOutput.writeByteArray(this.fingerprint);
    }
}
