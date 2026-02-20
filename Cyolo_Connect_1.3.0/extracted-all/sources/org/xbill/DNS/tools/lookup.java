package org.xbill.DNS.tools;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

/* JADX INFO: loaded from: classes2.dex */
public class lookup {
    public static void printAnswer(String str, Lookup lookup) {
        System.out.print(str + ":");
        if (lookup.getResult() != 0) {
            System.out.print(" " + lookup.getErrorString());
        }
        System.out.println();
        Name[] aliases = lookup.getAliases();
        if (aliases.length > 0) {
            System.out.print("# aliases: ");
            for (int i = 0; i < aliases.length; i++) {
                System.out.print(aliases[i]);
                if (i < aliases.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        if (lookup.getResult() == 0) {
            for (Record record : lookup.getAnswers()) {
                System.out.println(record);
            }
        }
    }

    public static void main(String[] strArr) throws Exception {
        int iValue = 1;
        int i = 0;
        if (strArr.length > 2 && strArr[0].equals("-t")) {
            iValue = Type.value(strArr[1]);
            if (iValue < 0) {
                throw new IllegalArgumentException("invalid type");
            }
            i = 2;
        }
        while (i < strArr.length) {
            Lookup lookup = new Lookup(strArr[i], iValue);
            lookup.run();
            printAnswer(strArr[i], lookup);
            i++;
        }
    }
}
