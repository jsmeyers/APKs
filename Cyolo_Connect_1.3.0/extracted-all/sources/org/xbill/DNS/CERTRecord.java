package org.xbill.DNS;

import java.io.IOException;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.utils.base64;

/* JADX INFO: loaded from: classes2.dex */
public class CERTRecord extends Record {
    public static final int OID = 254;
    public static final int PGP = 3;
    public static final int PKIX = 1;
    public static final int SPKI = 2;
    public static final int URI = 253;
    private int alg;
    private byte[] cert;
    private int certType;
    private int keyTag;

    public static class CertificateType {
        public static final int ACPKIX = 7;
        public static final int IACPKIX = 8;
        public static final int IPGP = 6;
        public static final int IPKIX = 4;
        public static final int ISPKI = 5;
        public static final int OID = 254;
        public static final int PGP = 3;
        public static final int PKIX = 1;
        public static final int SPKI = 2;
        public static final int URI = 253;
        private static Mnemonic types;

        private CertificateType() {
        }

        static {
            Mnemonic mnemonic = new Mnemonic("Certificate type", 2);
            types = mnemonic;
            mnemonic.setMaximum(65535);
            types.setNumericAllowed(true);
            types.add(1, "PKIX");
            types.add(2, "SPKI");
            types.add(3, "PGP");
            types.add(1, "IPKIX");
            types.add(2, "ISPKI");
            types.add(3, "IPGP");
            types.add(3, "ACPKIX");
            types.add(3, "IACPKIX");
            types.add(253, "URI");
            types.add(254, "OID");
        }

        public static String string(int i) {
            return types.getText(i);
        }

        public static int value(String str) {
            return types.getValue(str);
        }
    }

    CERTRecord() {
    }

    public CERTRecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(name, 37, i, j);
        this.certType = checkU16("certType", i2);
        this.keyTag = checkU16("keyTag", i3);
        this.alg = checkU8("alg", i4);
        this.cert = bArr;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.certType = dNSInput.readU16();
        this.keyTag = dNSInput.readU16();
        this.alg = dNSInput.readU8();
        this.cert = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String string = tokenizer.getString();
        int iValue = CertificateType.value(string);
        this.certType = iValue;
        if (iValue < 0) {
            throw tokenizer.exception("Invalid certificate type: " + string);
        }
        this.keyTag = tokenizer.getUInt16();
        String string2 = tokenizer.getString();
        int iValue2 = DNSSEC.Algorithm.value(string2);
        this.alg = iValue2;
        if (iValue2 < 0) {
            throw tokenizer.exception("Invalid algorithm: " + string2);
        }
        this.cert = tokenizer.getBase64();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.certType);
        sb.append(" ");
        sb.append(this.keyTag);
        sb.append(" ");
        sb.append(this.alg);
        if (this.cert != null) {
            if (Options.check("multiline")) {
                sb.append(" (\n");
                sb.append(base64.formatString(this.cert, 64, "\t", true));
            } else {
                sb.append(" ");
                sb.append(base64.toString(this.cert));
            }
        }
        return sb.toString();
    }

    public int getCertType() {
        return this.certType;
    }

    public int getKeyTag() {
        return this.keyTag;
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public byte[] getCert() {
        return this.cert;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.certType);
        dNSOutput.writeU16(this.keyTag);
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeByteArray(this.cert);
    }
}
