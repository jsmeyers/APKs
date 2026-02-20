package org.xbill.DNS;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class ClientSubnetOption extends EDNSOption {
    private InetAddress address;
    private int family;
    private int scopePrefixLength;
    private int sourcePrefixLength;

    ClientSubnetOption() {
        super(8);
    }

    private static int checkMaskLength(String str, int i, int i2) {
        int iAddressLength = Address.addressLength(i) * 8;
        if (i2 >= 0 && i2 <= iAddressLength) {
            return i2;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i2 + " must be in the range [0.." + iAddressLength + "]");
    }

    public ClientSubnetOption(int i, int i2, InetAddress inetAddress) {
        super(8);
        int iFamilyOf = Address.familyOf(inetAddress);
        this.family = iFamilyOf;
        this.sourcePrefixLength = checkMaskLength("source netmask", iFamilyOf, i);
        this.scopePrefixLength = checkMaskLength("scope netmask", this.family, i2);
        InetAddress inetAddressTruncate = Address.truncate(inetAddress, i);
        this.address = inetAddressTruncate;
        if (!inetAddress.equals(inetAddressTruncate)) {
            throw new IllegalArgumentException("source netmask is not valid for address");
        }
    }

    public ClientSubnetOption(int i, InetAddress inetAddress) {
        this(i, 0, inetAddress);
    }

    public int getFamily() {
        return this.family;
    }

    public int getSourcePrefixLength() {
        return this.sourcePrefixLength;
    }

    public int getScopePrefixLength() {
        return this.scopePrefixLength;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionFromWire(DNSInput dNSInput) throws WireParseException {
        int u16 = dNSInput.readU16();
        this.family = u16;
        if (u16 != 1 && u16 != 2) {
            throw new WireParseException("unknown address family");
        }
        int u8 = dNSInput.readU8();
        this.sourcePrefixLength = u8;
        if (u8 > Address.addressLength(this.family) * 8) {
            throw new WireParseException("invalid source netmask");
        }
        int u82 = dNSInput.readU8();
        this.scopePrefixLength = u82;
        if (u82 > Address.addressLength(this.family) * 8) {
            throw new WireParseException("invalid scope netmask");
        }
        byte[] byteArray = dNSInput.readByteArray();
        if (byteArray.length != (this.sourcePrefixLength + 7) / 8) {
            throw new WireParseException("invalid address");
        }
        byte[] bArr = new byte[Address.addressLength(this.family)];
        System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
        try {
            InetAddress byAddress = InetAddress.getByAddress(bArr);
            this.address = byAddress;
            if (!Address.truncate(byAddress, this.sourcePrefixLength).equals(this.address)) {
                throw new WireParseException("invalid padding");
            }
        } catch (UnknownHostException e) {
            throw new WireParseException("invalid address", e);
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(this.family);
        dNSOutput.writeU8(this.sourcePrefixLength);
        dNSOutput.writeU8(this.scopePrefixLength);
        dNSOutput.writeByteArray(this.address.getAddress(), 0, (this.sourcePrefixLength + 7) / 8);
    }

    @Override // org.xbill.DNS.EDNSOption
    String optionToString() {
        return this.address.getHostAddress() + "/" + this.sourcePrefixLength + ", scope netmask " + this.scopePrefixLength;
    }
}
