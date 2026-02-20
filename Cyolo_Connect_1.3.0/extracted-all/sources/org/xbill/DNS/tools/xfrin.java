package org.xbill.DNS.tools;

import java.util.Iterator;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.ZoneTransferIn;

/* JADX INFO: loaded from: classes2.dex */
public class xfrin {
    private static void usage(String str) {
        System.out.println("Error: " + str);
        System.out.println("usage: xfrin [-i serial] [-k keyname/secret] [-s server] [-p port] [-f] zone");
        System.exit(1);
    }

    public static void main(String[] strArr) throws Exception {
        String str;
        ZoneTransferIn zoneTransferInNewAXFR;
        String str2 = null;
        int i = -1;
        TSIG tsig = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 53;
        while (i2 < strArr.length) {
            if (strArr[i2].equals("-i")) {
                i2++;
                i = Integer.parseInt(strArr[i2]);
                if (i < 0) {
                    usage("invalid serial number");
                }
            } else if (strArr[i2].equals("-k")) {
                i2++;
                String str3 = strArr[i2];
                int iIndexOf = str3.indexOf(47);
                if (iIndexOf < 0) {
                    usage("invalid key");
                }
                tsig = new TSIG(TSIG.HMAC_MD5, str3.substring(0, iIndexOf), str3.substring(iIndexOf + 1));
            } else if (strArr[i2].equals("-s")) {
                i2++;
                str2 = strArr[i2];
            } else if (strArr[i2].equals("-p")) {
                i2++;
                int i4 = Integer.parseInt(strArr[i2]);
                if (i4 < 0 || i4 > 65535) {
                    usage("invalid port");
                }
                i3 = i4;
            } else if (strArr[i2].equals("-f")) {
                z = true;
            } else if (!strArr[i2].startsWith("-")) {
                break;
            } else {
                usage("invalid option");
            }
            i2++;
        }
        if (i2 >= strArr.length) {
            usage("no zone name specified");
        }
        Name nameFromString = Name.fromString(strArr[i2]);
        if (str2 == null) {
            Lookup lookup = new Lookup(nameFromString, 2);
            Record[] recordArrRun = lookup.run();
            if (recordArrRun == null) {
                System.out.println("failed to look up NS record: " + lookup.getErrorString());
                System.exit(1);
            }
            String strRdataToString = recordArrRun[0].rdataToString();
            System.out.println("sending to server '" + strRdataToString + "'");
            str = strRdataToString;
        } else {
            str = str2;
        }
        if (i >= 0) {
            zoneTransferInNewAXFR = ZoneTransferIn.newIXFR(nameFromString, i, z, str, i3, tsig);
        } else {
            zoneTransferInNewAXFR = ZoneTransferIn.newAXFR(nameFromString, str, i3, tsig);
        }
        zoneTransferInNewAXFR.run();
        if (zoneTransferInNewAXFR.isAXFR()) {
            if (i >= 0) {
                System.out.println("AXFR-like IXFR response");
            } else {
                System.out.println("AXFR response");
            }
            Iterator<Record> it = zoneTransferInNewAXFR.getAXFR().iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            return;
        }
        if (zoneTransferInNewAXFR.isIXFR()) {
            System.out.println("IXFR response");
            for (ZoneTransferIn.Delta delta : zoneTransferInNewAXFR.getIXFR()) {
                System.out.println("delta from " + delta.start + " to " + delta.end);
                System.out.println("deletes");
                Iterator<Record> it2 = delta.deletes.iterator();
                while (it2.hasNext()) {
                    System.out.println(it2.next());
                }
                System.out.println("adds");
                Iterator<Record> it3 = delta.adds.iterator();
                while (it3.hasNext()) {
                    System.out.println(it3.next());
                }
            }
            return;
        }
        if (zoneTransferInNewAXFR.isCurrent()) {
            System.out.println("up to date");
        }
    }
}
