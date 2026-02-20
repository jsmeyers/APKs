package org.xbill.DNS;

import java.io.IOException;
import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public class DLVRecord extends Record {

    @Deprecated
    public static final int SHA1_DIGEST_ID = 1;

    @Deprecated
    public static final int SHA256_DIGEST_ID = 2;
    private int alg;
    private byte[] digest;
    private int digestid;
    private int footprint;

    DLVRecord() {
    }

    public DLVRecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(name, Type.DLV, i, j);
        this.footprint = checkU16("footprint", i2);
        this.alg = checkU8("alg", i3);
        this.digestid = checkU8("digestid", i4);
        this.digest = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.footprint = dNSInput.readU16();
        this.alg = dNSInput.readU8();
        this.digestid = dNSInput.readU8();
        this.digest = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.footprint = tokenizer.getUInt16();
        this.alg = tokenizer.getUInt8();
        this.digestid = tokenizer.getUInt8();
        this.digest = tokenizer.getHex();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.footprint);
        sb.append(" ");
        sb.append(this.alg);
        sb.append(" ");
        sb.append(this.digestid);
        if (this.digest != null) {
            sb.append(" ");
            sb.append(base16.toString(this.digest));
        }
        return sb.toString();
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public int getDigestID() {
        return this.digestid;
    }

    public byte[] getDigest() {
        return this.digest;
    }

    public int getFootprint() {
        return this.footprint;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.footprint);
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeU8(this.digestid);
        byte[] bArr = this.digest;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }
}
