package org.xbill.DNS.tools;

import java.util.Iterator;
import org.xbill.DNS.Name;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Zone;

/* JADX INFO: loaded from: classes2.dex */
public class primary {
    private static void usage() {
        System.out.println("usage: primary [-t] [-a | -i] origin file");
        System.exit(1);
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length < 2) {
            usage();
        }
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (strArr.length - i > 2) {
            String str = strArr[0];
            str.hashCode();
            switch (str) {
                case "-a":
                    z = true;
                    break;
                case "-i":
                    z2 = true;
                    break;
                case "-t":
                    z3 = true;
                    break;
            }
            i++;
        }
        Name nameFromString = Name.fromString(strArr[i], Name.root);
        String str2 = strArr[i + 1];
        long jCurrentTimeMillis = System.currentTimeMillis();
        Zone zone = new Zone(nameFromString, str2);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (z) {
            Iterator<RRset> itAXFR = zone.AXFR();
            while (itAXFR.hasNext()) {
                System.out.println(itAXFR.next());
            }
        } else if (z2) {
            Iterator<RRset> it = zone.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } else {
            System.out.println(zone);
        }
        if (z3) {
            System.out.println("; Load time: " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
        }
    }
}
