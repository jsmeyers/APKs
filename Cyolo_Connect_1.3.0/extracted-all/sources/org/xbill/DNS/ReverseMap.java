package org.xbill.DNS;

import com.google.common.base.Ascii;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public final class ReverseMap {
    private static final Name inaddr4 = Name.fromConstantString("in-addr.arpa.");
    private static final Name inaddr6 = Name.fromConstantString("ip6.arpa.");

    private ReverseMap() {
    }

    public static Name fromAddress(byte[] bArr) {
        if (bArr.length != 4 && bArr.length != 16) {
            throw new IllegalArgumentException("array must contain 4 or 16 elements");
        }
        StringBuilder sb = new StringBuilder();
        if (bArr.length == 4) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                sb.append(bArr[length] & 255);
                if (length > 0) {
                    sb.append(".");
                }
            }
        } else {
            int[] iArr = new int[2];
            for (int length2 = bArr.length - 1; length2 >= 0; length2--) {
                byte b = bArr[length2];
                iArr[0] = (b & 255) >> 4;
                iArr[1] = b & Ascii.SI;
                for (int i = 1; i >= 0; i--) {
                    sb.append(Integer.toHexString(iArr[i]));
                    if (length2 > 0 || i > 0) {
                        sb.append(".");
                    }
                }
            }
        }
        try {
            if (bArr.length == 4) {
                return Name.fromString(sb.toString(), inaddr4);
            }
            return Name.fromString(sb.toString(), inaddr6);
        } catch (TextParseException unused) {
            throw new IllegalStateException("name cannot be invalid");
        }
    }

    public static Name fromAddress(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            int i2 = iArr[i];
            if (i2 < 0 || i2 > 255) {
                throw new IllegalArgumentException("array must contain values between 0 and 255");
            }
            bArr[i] = (byte) i2;
        }
        return fromAddress(bArr);
    }

    public static Name fromAddress(InetAddress inetAddress) {
        return fromAddress(inetAddress.getAddress());
    }

    public static Name fromAddress(String str, int i) throws UnknownHostException {
        byte[] byteArray = Address.toByteArray(str, i);
        if (byteArray == null) {
            throw new UnknownHostException("Invalid IP address: " + str);
        }
        return fromAddress(byteArray);
    }

    public static Name fromAddress(String str) throws UnknownHostException {
        byte[] byteArray = Address.toByteArray(str, 1);
        if (byteArray == null) {
            byteArray = Address.toByteArray(str, 2);
        }
        if (byteArray == null) {
            throw new UnknownHostException("Invalid IP address: " + str);
        }
        return fromAddress(byteArray);
    }

    public static InetAddress fromName(String str) throws TextParseException, UnknownHostException {
        return fromName(Name.fromString(str));
    }

    public static InetAddress fromName(Name name) throws UnknownHostException {
        if (name.labels() <= 3) {
            throw new UnknownHostException("Not an arpa address: " + name.toString());
        }
        Name name2 = inaddr4;
        if (name.subdomain(name2)) {
            Name nameRelativize = name.relativize(name2);
            if (nameRelativize.labels() > 4) {
                throw new UnknownHostException("Invalid IPv4 arpa address: " + name.toString());
            }
            byte[] bArr = new byte[4];
            for (int i = 0; i < nameRelativize.labels(); i++) {
                try {
                    bArr[(nameRelativize.labels() - i) - 1] = (byte) Integer.parseInt(nameRelativize.getLabelString(i));
                } catch (NumberFormatException unused) {
                    throw new UnknownHostException("Invalid IPv4 arpa address: " + name.toString());
                }
            }
            return InetAddress.getByAddress(bArr);
        }
        Name name3 = inaddr6;
        if (name.subdomain(name3)) {
            Name nameRelativize2 = name.relativize(name3);
            if (nameRelativize2.labels() > 32) {
                throw new UnknownHostException("Invalid IPv6 arpa address: " + name.toString());
            }
            byte[] bArr2 = new byte[16];
            for (int i2 = 0; i2 < nameRelativize2.labels(); i2++) {
                try {
                    int iLabels = ((nameRelativize2.labels() - i2) - 1) / 2;
                    bArr2[iLabels] = (byte) (bArr2[iLabels] | (Byte.parseByte(nameRelativize2.getLabelString(i2), 16) << ((nameRelativize2.labels() - i2) % 2 == 0 ? (byte) 0 : (byte) 4)));
                } catch (NumberFormatException unused2) {
                    throw new UnknownHostException("Invalid IPv6 arpa address: " + name.toString());
                }
            }
            return InetAddress.getByAddress(bArr2);
        }
        throw new UnknownHostException("Not an arpa address: " + name.toString());
    }
}
