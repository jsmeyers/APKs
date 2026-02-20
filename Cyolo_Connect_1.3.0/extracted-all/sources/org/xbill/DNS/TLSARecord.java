package org.xbill.DNS;

import java.io.IOException;
import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public class TLSARecord extends Record {
    private byte[] certificateAssociationData;
    private int certificateUsage;
    private int matchingType;
    private int selector;

    public static class CertificateUsage {
        public static final int CA_CONSTRAINT = 0;
        public static final int DOMAIN_ISSUED_CERTIFICATE = 3;
        public static final int SERVICE_CERTIFICATE_CONSTRAINT = 1;
        public static final int TRUST_ANCHOR_ASSERTION = 2;

        private CertificateUsage() {
        }
    }

    public static class Selector {
        public static final int FULL_CERTIFICATE = 0;
        public static final int SUBJECT_PUBLIC_KEY_INFO = 1;

        private Selector() {
        }
    }

    public static class MatchingType {
        public static final int EXACT = 0;
        public static final int SHA256 = 1;
        public static final int SHA512 = 2;

        private MatchingType() {
        }
    }

    TLSARecord() {
    }

    protected TLSARecord(Name name, int i, int i2, long j, int i3, int i4, int i5, byte[] bArr) {
        super(name, i, i2, j);
        this.certificateUsage = checkU8("certificateUsage", i3);
        this.selector = checkU8("selector", i4);
        this.matchingType = checkU8("matchingType", i5);
        this.certificateAssociationData = checkByteArrayLength("certificateAssociationData", bArr, 65535);
    }

    public TLSARecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        this(name, 52, i, j, i2, i3, i4, bArr);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.certificateUsage = dNSInput.readU8();
        this.selector = dNSInput.readU8();
        this.matchingType = dNSInput.readU8();
        this.certificateAssociationData = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.certificateUsage = tokenizer.getUInt8();
        this.selector = tokenizer.getUInt8();
        this.matchingType = tokenizer.getUInt8();
        this.certificateAssociationData = tokenizer.getHex();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.certificateUsage + " " + this.selector + " " + this.matchingType + " " + base16.toString(this.certificateAssociationData);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.certificateUsage);
        dNSOutput.writeU8(this.selector);
        dNSOutput.writeU8(this.matchingType);
        dNSOutput.writeByteArray(this.certificateAssociationData);
    }

    public int getCertificateUsage() {
        return this.certificateUsage;
    }

    public int getSelector() {
        return this.selector;
    }

    public int getMatchingType() {
        return this.matchingType;
    }

    public final byte[] getCertificateAssociationData() {
        return this.certificateAssociationData;
    }
}
