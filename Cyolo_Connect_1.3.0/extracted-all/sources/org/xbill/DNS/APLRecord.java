package org.xbill.DNS;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.utils.base16;

/* JADX INFO: loaded from: classes2.dex */
public class APLRecord extends Record {
    private List<Element> elements;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validatePrefixLength(int i, int i2) {
        if (i2 < 0 || i2 >= 256) {
            return false;
        }
        if (i != 1 || i2 <= 32) {
            return i != 2 || i2 <= 128;
        }
        return false;
    }

    public static class Element {
        public final Object address;
        public final int family;
        public final boolean negative;
        public final int prefixLength;

        private Element(int i, boolean z, Object obj, int i2) {
            this.family = i;
            this.negative = z;
            this.address = obj;
            this.prefixLength = i2;
            if (!APLRecord.validatePrefixLength(i, i2)) {
                throw new IllegalArgumentException("invalid prefix length");
            }
        }

        public Element(boolean z, InetAddress inetAddress, int i) {
            this(Address.familyOf(inetAddress), z, inetAddress, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.negative) {
                sb.append("!");
            }
            sb.append(this.family);
            sb.append(":");
            int i = this.family;
            if (i == 1 || i == 2) {
                sb.append(((InetAddress) this.address).getHostAddress());
            } else {
                sb.append(base16.toString((byte[]) this.address));
            }
            sb.append("/");
            sb.append(this.prefixLength);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Element)) {
                return false;
            }
            Element element = (Element) obj;
            return this.family == element.family && this.negative == element.negative && this.prefixLength == element.prefixLength && this.address.equals(element.address);
        }

        public int hashCode() {
            return this.address.hashCode() + this.prefixLength + (this.negative ? 1 : 0);
        }
    }

    APLRecord() {
    }

    public APLRecord(Name name, int i, long j, List<Element> list) {
        super(name, 42, i, j);
        this.elements = new ArrayList(list.size());
        for (Element element : list) {
            if (element.family != 1 && element.family != 2) {
                throw new IllegalArgumentException("unknown family");
            }
            this.elements.add(element);
        }
    }

    private static byte[] parseAddress(byte[] bArr, int i) throws WireParseException {
        if (bArr.length > i) {
            throw new WireParseException("invalid address length");
        }
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        Element element;
        this.elements = new ArrayList(1);
        while (dNSInput.remaining() != 0) {
            int u16 = dNSInput.readU16();
            int u8 = dNSInput.readU8();
            int u82 = dNSInput.readU8();
            boolean z = (u82 & 128) != 0;
            byte[] byteArray = dNSInput.readByteArray(u82 & (-129));
            if (!validatePrefixLength(u16, u8)) {
                throw new WireParseException("invalid prefix length");
            }
            if (u16 == 1 || u16 == 2) {
                element = new Element(z, InetAddress.getByAddress(parseAddress(byteArray, Address.addressLength(u16))), u8);
            } else {
                element = new Element(u16, z, byteArray, u8);
            }
            this.elements.add(element);
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.elements = new ArrayList(1);
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (token.isString()) {
                String str = token.value;
                boolean zStartsWith = str.startsWith("!");
                int iIndexOf = str.indexOf(58, zStartsWith ? 1 : 0);
                if (iIndexOf < 0) {
                    throw tokenizer.exception("invalid address prefix element");
                }
                int iIndexOf2 = str.indexOf(47, iIndexOf);
                if (iIndexOf2 < 0) {
                    throw tokenizer.exception("invalid address prefix element");
                }
                String strSubstring = str.substring(zStartsWith ? 1 : 0, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1, iIndexOf2);
                String strSubstring3 = str.substring(iIndexOf2 + 1);
                try {
                    int i = Integer.parseInt(strSubstring);
                    if (i != 1 && i != 2) {
                        throw tokenizer.exception("unknown family");
                    }
                    try {
                        int i2 = Integer.parseInt(strSubstring3);
                        if (!validatePrefixLength(i, i2)) {
                            throw tokenizer.exception("invalid prefix length");
                        }
                        byte[] byteArray = Address.toByteArray(strSubstring2, i);
                        if (byteArray == null) {
                            throw tokenizer.exception("invalid IP address " + strSubstring2);
                        }
                        this.elements.add(new Element(zStartsWith, InetAddress.getByAddress(byteArray), i2));
                    } catch (NumberFormatException unused) {
                        throw tokenizer.exception("invalid prefix length");
                    }
                } catch (NumberFormatException unused2) {
                    throw tokenizer.exception("invalid family");
                }
            } else {
                tokenizer.unget();
                return;
            }
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Element> it = this.elements.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public List<Element> getElements() {
        return this.elements;
    }

    private static int addressLength(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] != 0) {
                return length + 1;
            }
        }
        return 0;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        byte[] address;
        int iAddressLength;
        for (Element element : this.elements) {
            if (element.family == 1 || element.family == 2) {
                address = ((InetAddress) element.address).getAddress();
                iAddressLength = addressLength(address);
            } else {
                address = (byte[]) element.address;
                iAddressLength = address.length;
            }
            int i = element.negative ? iAddressLength | 128 : iAddressLength;
            dNSOutput.writeU16(element.family);
            dNSOutput.writeU8(element.prefixLength);
            dNSOutput.writeU8(i);
            dNSOutput.writeByteArray(address, 0, iAddressLength);
        }
    }
}
