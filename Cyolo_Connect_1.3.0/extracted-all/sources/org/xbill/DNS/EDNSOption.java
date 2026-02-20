package org.xbill.DNS;

import java.io.IOException;
import java.util.Arrays;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EDNSOption {
    private final int code;

    abstract void optionFromWire(DNSInput dNSInput) throws IOException;

    abstract String optionToString();

    abstract void optionToWire(DNSOutput dNSOutput);

    public static class Code {
        public static final int CHAIN = 13;
        public static final int CLIENT_SUBNET = 8;
        public static final int COOKIE = 10;
        public static final int DAU = 5;
        public static final int DHU = 6;
        public static final int EDNS_CLIENT_TAG = 16;
        public static final int EDNS_EXPIRE = 9;
        public static final int EDNS_EXTENDED_ERROR = 15;
        public static final int EDNS_KEY_TAG = 14;
        public static final int EDNS_SERVER_TAG = 17;
        public static final int LLQ = 1;
        public static final int N3U = 7;
        public static final int NSID = 3;
        public static final int PADDING = 12;
        public static final int TCP_KEEPALIVE = 11;
        public static final int UL = 2;
        private static Mnemonic codes;

        private Code() {
        }

        static {
            Mnemonic mnemonic = new Mnemonic("EDNS Option Codes", 1);
            codes = mnemonic;
            mnemonic.setMaximum(65535);
            codes.setPrefix("CODE");
            codes.setNumericAllowed(true);
            codes.add(1, "LLQ");
            codes.add(2, "UL");
            codes.add(3, "NSID");
            codes.add(5, "DAU");
            codes.add(6, "DHU");
            codes.add(7, "N3U");
            codes.add(8, "edns-client-subnet");
            codes.add(9, "EDNS_EXPIRE");
            codes.add(10, "COOKIE");
            codes.add(11, "edns-tcp-keepalive");
            codes.add(12, "Padding");
            codes.add(13, "CHAIN");
            codes.add(14, "edns-key-tag");
            codes.add(15, "Extended_DNS_Error");
            codes.add(16, "EDNS-Client-Tag");
            codes.add(17, "EDNS-Server-Tag");
        }

        public static String string(int i) {
            return codes.getText(i);
        }

        public static int value(String str) {
            return codes.getValue(str);
        }
    }

    public EDNSOption(int i) {
        this.code = Record.checkU16(ResponseTypeValues.CODE, i);
    }

    public String toString() {
        return "{" + Code.string(this.code) + ": " + optionToString() + "}";
    }

    public int getCode() {
        return this.code;
    }

    byte[] getData() {
        DNSOutput dNSOutput = new DNSOutput();
        optionToWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    static EDNSOption fromWire(DNSInput dNSInput) throws IOException {
        EDNSOption nSIDOption;
        int u16 = dNSInput.readU16();
        int u162 = dNSInput.readU16();
        if (dNSInput.remaining() < u162) {
            throw new WireParseException("truncated option");
        }
        int iSaveActive = dNSInput.saveActive();
        dNSInput.setActive(u162);
        if (u16 == 3) {
            nSIDOption = new NSIDOption();
        } else if (u16 == 15) {
            nSIDOption = new ExtendedErrorCodeOption();
        } else if (u16 == 5 || u16 == 6 || u16 == 7) {
            nSIDOption = new DnssecAlgorithmOption(u16, new int[0]);
        } else if (u16 == 8) {
            nSIDOption = new ClientSubnetOption();
        } else if (u16 == 10) {
            nSIDOption = new CookieOption();
        } else if (u16 == 11) {
            nSIDOption = new TcpKeepaliveOption();
        } else {
            nSIDOption = new GenericEDNSOption(u16);
        }
        nSIDOption.optionFromWire(dNSInput);
        dNSInput.restoreActive(iSaveActive);
        return nSIDOption;
    }

    public static EDNSOption fromWire(byte[] bArr) throws IOException {
        return fromWire(new DNSInput(bArr));
    }

    void toWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(this.code);
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        optionToWire(dNSOutput);
        dNSOutput.writeU16At((dNSOutput.current() - iCurrent) - 2, iCurrent);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EDNSOption)) {
            return false;
        }
        EDNSOption eDNSOption = (EDNSOption) obj;
        if (this.code != eDNSOption.code) {
            return false;
        }
        return Arrays.equals(getData(), eDNSOption.getData());
    }

    public int hashCode() {
        int i = 0;
        for (byte b : getData()) {
            i += (i << 3) + (b & 255);
        }
        return i;
    }
}
