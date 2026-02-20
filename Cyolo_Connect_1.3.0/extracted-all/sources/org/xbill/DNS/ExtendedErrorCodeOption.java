package org.xbill.DNS;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedErrorCodeOption extends EDNSOption {
    public static final int BLOCKED = 15;
    public static final int CACHED_ERROR = 13;
    public static final int CENSORED = 16;
    public static final int DNSKEY_MISSING = 9;
    public static final int DNSSEC_BOGUS = 6;
    public static final int DNSSEC_INDETERMINATE = 5;
    public static final int FILTERED = 17;
    public static final int FORGED_ANSWER = 4;
    public static final int INVALID_DATA = 24;
    public static final int NETWORK_ERROR = 23;
    public static final int NOT_AUTHORITATIVE = 20;
    public static final int NOT_READY = 14;
    public static final int NOT_SUPPORTED = 21;
    public static final int NO_REACHABLE_AUTHORITY = 22;
    public static final int NO_ZONE_KEY_BIT_SET = 11;
    public static final int NSEC_MISSING = 12;
    public static final int OTHER = 0;
    public static final int PROHIBITED = 18;
    public static final int RRSIGS_MISSING = 10;
    public static final int SIGNATURE_EXPIRED = 7;
    public static final int SIGNATURE_NOT_YET_VALID = 8;
    public static final int STALE_ANSWER = 3;
    public static final int STALE_NXDOMAIN_ANSWER = 19;
    public static final int UNSUPPORTED_DNSKEY_ALGORITHM = 1;
    public static final int UNSUPPORTED_DS_DIGEST_TYPE = 2;
    private static final Mnemonic codes;
    private int errorCode;
    private String text;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getText() {
        return this.text;
    }

    static {
        Mnemonic mnemonic = new Mnemonic("EDNS Extended Error Codes", 1);
        codes = mnemonic;
        mnemonic.setMaximum(65535);
        mnemonic.setPrefix("EDE");
        mnemonic.add(0, "Other");
        mnemonic.add(1, "Unsupported DNSKEY Algorithm");
        mnemonic.add(2, "Unsupported DS Digest Type");
        mnemonic.add(3, "Stale Answer");
        mnemonic.add(4, "Forged Answer");
        mnemonic.add(5, "DNSSEC Indeterminate");
        mnemonic.add(6, "DNSSEC Bogus");
        mnemonic.add(7, "Signature Expired");
        mnemonic.add(8, "Signature Not Yet Valid");
        mnemonic.add(9, "DNSKEY Missing");
        mnemonic.add(10, "RRSIGs Missing");
        mnemonic.add(11, "No Zone Key Bit Set");
        mnemonic.add(12, "NSEC Missing");
        mnemonic.add(13, "Cached Error");
        mnemonic.add(14, "Not Ready");
        mnemonic.add(15, "Blocked");
        mnemonic.add(16, "Censored");
        mnemonic.add(17, "Filtered");
        mnemonic.add(18, "Prohibited");
        mnemonic.add(19, "Stale NXDOMAIN Answer");
        mnemonic.add(20, "Not Authoritative");
        mnemonic.add(21, "Not Supported");
        mnemonic.add(22, "No Reachable Authority");
        mnemonic.add(23, "Network Error");
        mnemonic.add(24, "Invalid Data");
    }

    ExtendedErrorCodeOption() {
        super(15);
    }

    public ExtendedErrorCodeOption(int i, String str) {
        super(15);
        this.errorCode = i;
        this.text = str;
    }

    public ExtendedErrorCodeOption(int i) {
        this(i, null);
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) throws IOException {
        this.errorCode = dNSInput.readU16();
        if (dNSInput.remaining() > 0) {
            byte[] byteArray = dNSInput.readByteArray();
            int length = byteArray.length;
            if (byteArray[byteArray.length - 1] == 0) {
                length--;
            }
            this.text = new String(byteArray, 0, length, StandardCharsets.UTF_8);
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(this.errorCode);
        String str = this.text;
        if (str == null || str.length() <= 0) {
            return;
        }
        dNSOutput.writeByteArray(this.text.getBytes(StandardCharsets.UTF_8));
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        if (this.text == null) {
            return codes.getText(this.errorCode);
        }
        return codes.getText(this.errorCode) + ": " + this.text;
    }
}
