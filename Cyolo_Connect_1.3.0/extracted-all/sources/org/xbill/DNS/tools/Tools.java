package org.xbill.DNS.tools;

/* JADX INFO: loaded from: classes2.dex */
public class Tools {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Found duplicated region for block: B:9:0x001f  */
    public static void main(String[] strArr) throws Exception {
        String[] strArr2;
        if (strArr == null || strArr.length == 0) {
            System.out.println("Usage: <command> <options>");
            System.out.println("  Commands:");
            System.out.println("    dig");
            System.out.println("    jnamed");
            System.out.println("    lookup");
            System.out.println("    primary");
            System.out.println("    update");
            System.out.println("    xfrin");
            System.exit(1);
            return;
        }
        String str = strArr[0];
        strArr2 = new String[strArr.length - 1];
        System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        str.hashCode();
        switch (str) {
            case "jnamed":
                jnamed.main(strArr2);
                break;
            case "lookup":
                lookup.main(strArr2);
                break;
            case "update":
                update.main(strArr2);
                break;
            case "primary":
                primary.main(strArr2);
                break;
            case "dig":
                dig.main(strArr2);
                break;
            case "xfrin":
                xfrin.main(strArr2);
                break;
            default:
                System.out.println("invalid command");
                break;
        }
    }
}
