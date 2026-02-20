package org.xbill.DNS;

import io.flutter.embedding.android.KeyboardMap;
import j$.time.Duration;
import j$.time.Instant;
import j$.util.DesugarDate;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.IOUtils;
import org.xbill.DNS.utils.base64;

/* JADX INFO: loaded from: classes2.dex */
public class TSIGRecord extends Record {
    private Name alg;
    private int error;
    private Duration fudge;
    private int originalID;
    private byte[] other;
    private byte[] signature;
    private Instant timeSigned;

    TSIGRecord() {
    }

    @Deprecated
    public TSIGRecord(Name name, int i, long j, Name name2, Date date, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        this(name, i, j, name2, DesugarDate.toInstant(date), Duration.ofSeconds(i2), bArr, i3, i4, bArr2);
    }

    public TSIGRecord(Name name, int i, long j, Name name2, Instant instant, Duration duration, byte[] bArr, int i2, int i3, byte[] bArr2) {
        super(name, 250, i, j);
        this.alg = checkName("alg", name2);
        this.timeSigned = instant;
        checkU16("fudge", (int) duration.getSeconds());
        this.fudge = duration;
        this.signature = bArr;
        this.originalID = checkU16("originalID", i2);
        this.error = checkU16("error", i3);
        this.other = bArr2;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.alg = new Name(dNSInput);
        this.timeSigned = Instant.ofEpochSecond((((long) dNSInput.readU16()) << 32) + dNSInput.readU32());
        this.fudge = Duration.ofSeconds(dNSInput.readU16());
        this.signature = dNSInput.readByteArray(dNSInput.readU16());
        this.originalID = dNSInput.readU16();
        this.error = dNSInput.readU16();
        int u16 = dNSInput.readU16();
        if (u16 > 0) {
            this.other = dNSInput.readByteArray(u16);
        } else {
            this.other = null;
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        throw tokenizer.exception("no text format defined for TSIG");
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.alg);
        sb.append(" ");
        if (Options.check("multiline")) {
            sb.append("(\n\t");
        }
        sb.append(this.timeSigned.getEpochSecond());
        sb.append(" ");
        sb.append((int) this.fudge.getSeconds());
        sb.append(" ");
        sb.append(this.signature.length);
        if (Options.check("multiline")) {
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(base64.formatString(this.signature, 64, "\t", false));
        } else {
            sb.append(" ");
            sb.append(base64.toString(this.signature));
        }
        sb.append(" ");
        sb.append(Rcode.TSIGstring(this.error));
        sb.append(" ");
        byte[] bArr = this.other;
        if (bArr == null) {
            sb.append(0);
        } else {
            sb.append(bArr.length);
            if (Options.check("multiline")) {
                sb.append("\n\n\n\t");
            } else {
                sb.append(" ");
            }
            if (this.error == 18) {
                byte[] bArr2 = this.other;
                if (bArr2.length != 6) {
                    sb.append("<invalid BADTIME other data>");
                } else {
                    long j = (((long) (bArr2[0] & 255)) << 40) + (((long) (bArr2[1] & 255)) << 32) + ((long) ((bArr2[2] & 255) << 24)) + ((long) ((bArr2[3] & 255) << 16)) + ((long) ((bArr2[4] & 255) << 8)) + ((long) (bArr2[5] & 255));
                    sb.append("<server time: ");
                    sb.append(Instant.ofEpochSecond(j));
                    sb.append(">");
                }
            } else {
                sb.append("<");
                sb.append(base64.toString(this.other));
                sb.append(">");
            }
        }
        if (Options.check("multiline")) {
            sb.append(" )");
        }
        return sb.toString();
    }

    public Name getAlgorithm() {
        return this.alg;
    }

    public Instant getTimeSigned() {
        return this.timeSigned;
    }

    public Duration getFudge() {
        return this.fudge;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public int getOriginalID() {
        return this.originalID;
    }

    public int getError() {
        return this.error;
    }

    public byte[] getOther() {
        return this.other;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.alg.toWire(dNSOutput, null, z);
        long epochSecond = this.timeSigned.getEpochSecond();
        int i = (int) (epochSecond >> 32);
        long j = epochSecond & KeyboardMap.kValueMask;
        dNSOutput.writeU16(i);
        dNSOutput.writeU32(j);
        dNSOutput.writeU16((int) this.fudge.getSeconds());
        dNSOutput.writeU16(this.signature.length);
        dNSOutput.writeByteArray(this.signature);
        dNSOutput.writeU16(this.originalID);
        dNSOutput.writeU16(this.error);
        byte[] bArr = this.other;
        if (bArr != null) {
            dNSOutput.writeU16(bArr.length);
            dNSOutput.writeByteArray(this.other);
        } else {
            dNSOutput.writeU16(0);
        }
    }
}
