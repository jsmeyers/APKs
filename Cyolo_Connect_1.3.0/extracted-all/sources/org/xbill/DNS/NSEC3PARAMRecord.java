package org.xbill.DNS;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public class NSEC3PARAMRecord extends Record {
    private int flags;
    private int hashAlg;
    private int iterations;
    private byte[] salt;

    NSEC3PARAMRecord() {
    }

    public NSEC3PARAMRecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(name, 51, i, j);
        this.hashAlg = checkU8("hashAlg", i2);
        this.flags = checkU8("flags", i3);
        this.iterations = checkU16("iterations", i4);
        if (bArr != null) {
            if (bArr.length > 255) {
                throw new IllegalArgumentException("Invalid salt length");
            }
            if (bArr.length > 0) {
                byte[] bArr2 = new byte[bArr.length];
                this.salt = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            }
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.hashAlg = dNSInput.readU8();
        this.flags = dNSInput.readU8();
        this.iterations = dNSInput.readU16();
        int u8 = dNSInput.readU8();
        if (u8 > 0) {
            this.salt = dNSInput.readByteArray(u8);
        } else {
            this.salt = null;
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.hashAlg);
        dNSOutput.writeU8(this.flags);
        dNSOutput.writeU16(this.iterations);
        byte[] bArr = this.salt;
        if (bArr != null) {
            dNSOutput.writeU8(bArr.length);
            dNSOutput.writeByteArray(this.salt);
        } else {
            dNSOutput.writeU8(0);
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.hashAlg = tokenizer.getUInt8();
        this.flags = tokenizer.getUInt8();
        this.iterations = tokenizer.getUInt16();
        if (tokenizer.getString().equals("-")) {
            this.salt = null;
            return;
        }
        tokenizer.unget();
        byte[] hexString = tokenizer.getHexString();
        this.salt = hexString;
        if (hexString.length > 255) {
            throw tokenizer.exception("salt value too long");
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hashAlg);
        sb.append(' ');
        sb.append(this.flags);
        sb.append(' ');
        sb.append(this.iterations);
        sb.append(' ');
        byte[] bArr = this.salt;
        if (bArr == null) {
            sb.append('-');
        } else {
            sb.append(base16.toString(bArr));
        }
        return sb.toString();
    }

    public int getHashAlgorithm() {
        return this.hashAlg;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getIterations() {
        return this.iterations;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public byte[] hashName(Name name) throws NoSuchAlgorithmException {
        return NSEC3Record.hashName(name, this.hashAlg, this.iterations, this.salt);
    }
}
