package org.xbill.DNS;

import j$.time.Instant;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.utils.base64;

/* JADX INFO: loaded from: classes2.dex */
abstract class SIGBase extends Record {
    protected int alg;
    protected int covered;
    protected Instant expire;
    protected int footprint;
    protected int labels;
    protected long origttl;
    protected byte[] signature;
    protected Name signer;
    protected Instant timeSigned;

    protected SIGBase() {
    }

    public SIGBase(Name name, int i, int i2, long j, int i3, int i4, long j2, Instant instant, Instant instant2, int i5, Name name2, byte[] bArr) {
        super(name, i, i2, j);
        Type.check(i3);
        TTL.check(j2);
        this.covered = i3;
        this.alg = checkU8("alg", i4);
        this.labels = name.labels() - 1;
        if (name.isWild()) {
            this.labels--;
        }
        this.origttl = j2;
        this.expire = instant;
        this.timeSigned = instant2;
        this.footprint = checkU16("footprint", i5);
        this.signer = checkName("signer", name2);
        this.signature = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.covered = dNSInput.readU16();
        this.alg = dNSInput.readU8();
        this.labels = dNSInput.readU8();
        this.origttl = dNSInput.readU32();
        this.expire = Instant.ofEpochSecond(dNSInput.readU32());
        this.timeSigned = Instant.ofEpochSecond(dNSInput.readU32());
        this.footprint = dNSInput.readU16();
        this.signer = new Name(dNSInput);
        this.signature = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String string = tokenizer.getString();
        int iValue = Type.value(string);
        this.covered = iValue;
        if (iValue < 0) {
            throw tokenizer.exception("Invalid type: " + string);
        }
        String string2 = tokenizer.getString();
        int iValue2 = DNSSEC.Algorithm.value(string2);
        this.alg = iValue2;
        if (iValue2 < 0) {
            throw tokenizer.exception("Invalid algorithm: " + string2);
        }
        this.labels = tokenizer.getUInt8();
        this.origttl = tokenizer.getTTL();
        this.expire = FormattedTime.parse(tokenizer.getString());
        this.timeSigned = FormattedTime.parse(tokenizer.getString());
        this.footprint = tokenizer.getUInt16();
        this.signer = tokenizer.getName(name);
        this.signature = tokenizer.getBase64();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Type.string(this.covered));
        sb.append(" ");
        sb.append(this.alg);
        sb.append(" ");
        sb.append(this.labels);
        sb.append(" ");
        sb.append(this.origttl);
        sb.append(" ");
        if (Options.check("multiline")) {
            sb.append("(\n\t");
        }
        sb.append(FormattedTime.format(this.expire));
        sb.append(" ");
        sb.append(FormattedTime.format(this.timeSigned));
        sb.append(" ");
        sb.append(this.footprint);
        sb.append(" ");
        sb.append(this.signer);
        if (Options.check("multiline")) {
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(base64.formatString(this.signature, 64, "\t", true));
        } else {
            sb.append(" ");
            sb.append(base64.toString(this.signature));
        }
        return sb.toString();
    }

    public int getTypeCovered() {
        return this.covered;
    }

    @Override // org.xbill.DNS.Record
    public int getRRsetType() {
        return this.covered;
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public int getLabels() {
        return this.labels;
    }

    public long getOrigTTL() {
        return this.origttl;
    }

    public Instant getExpire() {
        return this.expire;
    }

    public Instant getTimeSigned() {
        return this.timeSigned;
    }

    public int getFootprint() {
        return this.footprint;
    }

    public Name getSigner() {
        return this.signer;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    void setSignature(byte[] bArr) {
        this.signature = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.covered);
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeU8(this.labels);
        dNSOutput.writeU32(this.origttl);
        dNSOutput.writeU32(this.expire.getEpochSecond());
        dNSOutput.writeU32(this.timeSigned.getEpochSecond());
        dNSOutput.writeU16(this.footprint);
        this.signer.toWire(dNSOutput, null, z);
        dNSOutput.writeByteArray(this.signature);
    }
}
