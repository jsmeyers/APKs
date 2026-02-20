package org.xbill.DNS;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public final class Address {
    public static final int IPv4 = 1;
    public static final int IPv6 = 2;

    private Address() {
    }

    private static byte[] parseV4(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt != '.' || i == 3 || i2 == 0) {
                    return null;
                }
                bArr[i] = (byte) i3;
                i++;
                i2 = 0;
                i3 = 0;
            } else {
                if (i2 == 3) {
                    return null;
                }
                if (i2 > 0 && i3 == 0) {
                    return null;
                }
                i2++;
                i3 = (i3 * 10) + (cCharAt - '0');
                if (i3 > 255) {
                    return null;
                }
            }
        }
        if (i != 3 || i2 == 0) {
            return null;
        }
        bArr[i] = (byte) i3;
        return bArr;
    }

    private static byte[] parseV6(String str) {
        int i;
        byte[] byteArray;
        byte[] bArr = new byte[16];
        int i2 = -1;
        String[] strArrSplit = str.split(":", -1);
        int length = strArrSplit.length - 1;
        if (strArrSplit[0].length() != 0) {
            i = 0;
        } else {
            if (length + 0 <= 0 || strArrSplit[1].length() != 0) {
                return null;
            }
            i = 1;
        }
        if (strArrSplit[length].length() == 0) {
            if (length - i <= 0 || strArrSplit[length - 1].length() != 0) {
                return null;
            }
            length--;
        }
        if ((length - i) + 1 > 8) {
            return null;
        }
        int i3 = 0;
        while (i <= length) {
            if (strArrSplit[i].length() != 0) {
                if (strArrSplit[i].indexOf(46) >= 0) {
                    if (i < length || i > 6 || (byteArray = toByteArray(strArrSplit[i], 1)) == null) {
                        return null;
                    }
                    int i4 = 0;
                    while (i4 < 4) {
                        bArr[i3] = byteArray[i4];
                        i4++;
                        i3++;
                    }
                    break;
                }
                for (int i5 = 0; i5 < strArrSplit[i].length(); i5++) {
                    try {
                        if (Character.digit(strArrSplit[i].charAt(i5), 16) < 0) {
                            return null;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                int i6 = Integer.parseInt(strArrSplit[i], 16);
                if (i6 <= 65535 && i6 >= 0) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) (i6 >>> 8);
                    i3 = i7 + 1;
                    bArr[i7] = (byte) (i6 & 255);
                }
                return null;
            }
            if (i2 >= 0) {
                return null;
            }
            i2 = i3;
            i++;
        }
        if (i3 < 16 && i2 < 0) {
            return null;
        }
        if (i2 >= 0) {
            int i8 = (16 - i3) + i2;
            System.arraycopy(bArr, i2, bArr, i8, i3 - i2);
            while (i2 < i8) {
                bArr[i2] = 0;
                i2++;
            }
        }
        return bArr;
    }

    public static int[] toArray(String str, int i) {
        byte[] byteArray = toByteArray(str, i);
        if (byteArray == null) {
            return null;
        }
        int[] iArr = new int[byteArray.length];
        for (int i2 = 0; i2 < byteArray.length; i2++) {
            iArr[i2] = byteArray[i2] & 255;
        }
        return iArr;
    }

    public static int[] toArray(String str) {
        return toArray(str, 1);
    }

    public static byte[] toByteArray(String str, int i) {
        if (i == 1) {
            return parseV4(str);
        }
        if (i == 2) {
            return parseV6(str);
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static boolean isDottedQuad(String str) {
        return toByteArray(str, 1) != null;
    }

    public static String toDottedQuad(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    public static String toDottedQuad(int[] iArr) {
        return iArr[0] + "." + iArr[1] + "." + iArr[2] + "." + iArr[3];
    }

    private static Record[] lookupHostName(String str, boolean z) throws UnknownHostException {
        Record[] recordArrRun;
        Record[] recordArrRun2;
        try {
            Lookup lookup = new Lookup(str, 1);
            Record[] recordArrRun3 = lookup.run();
            if (recordArrRun3 != null) {
                if (!z || (recordArrRun = new Lookup(str, 28).run()) == null) {
                    return recordArrRun3;
                }
                Record[] recordArr = new Record[recordArrRun3.length + recordArrRun.length];
                System.arraycopy(recordArrRun3, 0, recordArr, 0, recordArrRun3.length);
                System.arraycopy(recordArrRun, 0, recordArr, recordArrRun3.length, recordArrRun.length);
                return recordArr;
            }
            if (lookup.getResult() == 4 && (recordArrRun2 = new Lookup(str, 28).run()) != null) {
                return recordArrRun2;
            }
            throw new UnknownHostException("<" + str + "> could not be resolved: " + lookup.getErrorString());
        } catch (TextParseException e) {
            throw new UnknownHostException("<" + str + "> is invalid: " + e.getMessage());
        }
    }

    private static InetAddress addrFromRecord(String str, Record record) throws UnknownHostException {
        InetAddress address;
        if (record instanceof ARecord) {
            address = ((ARecord) record).getAddress();
        } else {
            address = ((AAAARecord) record).getAddress();
        }
        return InetAddress.getByAddress(str, address.getAddress());
    }

    public static InetAddress getByName(String str) throws UnknownHostException {
        try {
            return getByAddress(str);
        } catch (UnknownHostException unused) {
            return addrFromRecord(str, lookupHostName(str, false)[0]);
        }
    }

    public static InetAddress[] getAllByName(String str) throws UnknownHostException {
        try {
            return new InetAddress[]{getByAddress(str)};
        } catch (UnknownHostException unused) {
            Record[] recordArrLookupHostName = lookupHostName(str, true);
            InetAddress[] inetAddressArr = new InetAddress[recordArrLookupHostName.length];
            for (int i = 0; i < recordArrLookupHostName.length; i++) {
                inetAddressArr[i] = addrFromRecord(str, recordArrLookupHostName[i]);
            }
            return inetAddressArr;
        }
    }

    public static InetAddress getByAddress(String str) throws UnknownHostException {
        byte[] byteArray = toByteArray(str, 1);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        byte[] byteArray2 = toByteArray(str, 2);
        if (byteArray2 != null) {
            return InetAddress.getByAddress(str, byteArray2);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }

    public static InetAddress getByAddress(String str, int i) throws UnknownHostException {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("unknown address family");
        }
        byte[] byteArray = toByteArray(str, i);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }

    public static String getHostName(InetAddress inetAddress) throws UnknownHostException {
        Name nameFromAddress = ReverseMap.fromAddress(inetAddress);
        Record[] recordArrRun = new Lookup(nameFromAddress, 12).run();
        if (recordArrRun == null) {
            throw new UnknownHostException("unknown address: " + nameFromAddress);
        }
        return ((PTRRecord) recordArrRun[0]).getTarget().toString();
    }

    public static int familyOf(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int addressLength(int i) {
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress truncate(InetAddress inetAddress, int i) {
        int i2;
        int iAddressLength = addressLength(familyOf(inetAddress)) * 8;
        if (i < 0 || i > iAddressLength) {
            throw new IllegalArgumentException("invalid mask length");
        }
        if (i == iAddressLength) {
            return inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i3 = i / 8;
        int i4 = i3 + 1;
        while (true) {
            if (i4 >= address.length) {
                break;
            }
            address[i4] = 0;
            i4++;
        }
        int i5 = 0;
        for (i2 = 0; i2 < i % 8; i2++) {
            i5 |= 1 << (7 - i2);
        }
        address[i3] = (byte) (address[i3] & i5);
        try {
            return InetAddress.getByAddress(address);
        } catch (UnknownHostException unused) {
            throw new IllegalArgumentException("invalid address");
        }
    }
}
