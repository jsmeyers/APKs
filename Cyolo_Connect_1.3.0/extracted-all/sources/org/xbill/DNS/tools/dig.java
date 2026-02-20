package org.xbill.DNS.tools;

import java.io.IOException;
import java.net.InetAddress;
import org.xbill.DNS.DClass;
import org.xbill.DNS.EDNSOption;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.ReverseMap;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.Type;
import org.xbill.DNS.WireParseException;
import org.xbill.DNS.ZoneTransferException;
import org.xbill.DNS.ZoneTransferIn;

/* JADX INFO: loaded from: classes2.dex */
public class dig {
    static int dclass = 1;
    static Name name = null;
    static int type = 1;

    static void usage() {
        System.out.println("; dnsjava dig");
        System.out.println("Usage: dig [@server] name [<type>] [<class>] [options]");
        System.exit(0);
    }

    static void doQuery(Message message, long j) {
        System.out.println("; dnsjava dig");
        System.out.println(message);
        System.out.println(";; Query time: " + j + " ms");
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x01ab  */
    /* JADX WARN: Found duplicated region for block: B:104:0x01c0  */
    /* JADX WARN: Found duplicated region for block: B:107:0x01cb  */
    /* JADX WARN: Found duplicated region for block: B:113:0x020e  */
    public static void main(String[] strArr) throws IOException {
        boolean z;
        Message messageNewQuery;
        String strSubstring;
        int i;
        int i2;
        String strSubstring2;
        String strSubstring3;
        String strSubstring4;
        String strSubstring5;
        if (strArr.length < 1) {
            usage();
        }
        SimpleResolver simpleResolver = null;
        boolean z2 = false;
        try {
            if (strArr[0].startsWith("@")) {
                strSubstring = strArr[0].substring(1);
                i = 1;
            } else {
                strSubstring = null;
                i = 0;
            }
            if (strSubstring != null) {
                simpleResolver = new SimpleResolver(strSubstring);
            } else {
                simpleResolver = new SimpleResolver();
            }
            int i3 = i + 1;
            String str = strArr[i];
            if (str.equals("-x")) {
                i2 = i3 + 1;
                name = ReverseMap.fromAddress(strArr[i3]);
                type = 12;
                dclass = 1;
            } else {
                name = Name.fromString(str, Name.root);
                int iValue = Type.value(strArr[i3]);
                type = iValue;
                if (iValue < 0) {
                    type = 1;
                } else {
                    i3++;
                }
                int iValue2 = DClass.value(strArr[i3]);
                dclass = iValue2;
                if (iValue2 < 0) {
                    dclass = 1;
                    i2 = i3;
                } else {
                    i2 = i3 + 1;
                }
            }
            z = false;
            while (strArr[i2].startsWith("-") && strArr[i2].length() > 1) {
                try {
                    char cCharAt = strArr[i2].charAt(1);
                    if (cCharAt == 'b') {
                        if (strArr[i2].length() > 2) {
                            strSubstring2 = strArr[i2].substring(2);
                        } else {
                            i2++;
                            strSubstring2 = strArr[i2];
                        }
                        try {
                            simpleResolver.setLocalAddress(InetAddress.getByName(strSubstring2));
                        } catch (Exception unused) {
                            System.out.println("Invalid address");
                            return;
                        }
                    } else if (cCharAt == 'i') {
                        simpleResolver.setIgnoreTruncation(true);
                    } else if (cCharAt == 'k') {
                        if (strArr[i2].length() > 2) {
                            strSubstring3 = strArr[i2].substring(2);
                        } else {
                            i2++;
                            strSubstring3 = strArr[i2];
                        }
                        String[] strArrSplit = strSubstring3.split("[:/]", 3);
                        int length = strArrSplit.length;
                        if (length == 2) {
                            simpleResolver.setTSIGKey(new TSIG(TSIG.HMAC_MD5, strArrSplit[0], strArrSplit[1]));
                        } else if (length == 3) {
                            simpleResolver.setTSIGKey(new TSIG(strArrSplit[0], strArrSplit[1], strArrSplit[2]));
                        } else {
                            throw new IllegalArgumentException("Invalid TSIG key specification");
                        }
                    } else if (cCharAt == 't') {
                        simpleResolver.setTCP(true);
                    } else if (cCharAt == 'd') {
                        simpleResolver.setEDNS(0, 0, 32768, new EDNSOption[0]);
                    } else {
                        if (cCharAt == 'e') {
                            if (strArr[i2].length() > 2) {
                                strSubstring4 = strArr[i2].substring(2);
                            } else {
                                i2++;
                                strSubstring4 = strArr[i2];
                            }
                            int i4 = Integer.parseInt(strSubstring4);
                            if (i4 >= 0 && i4 <= 1) {
                                simpleResolver.setEDNS(i4);
                            }
                            System.out.println("Unsupported EDNS level: " + i4);
                            return;
                        }
                        if (cCharAt == 'p') {
                            if (strArr[i2].length() > 2) {
                                strSubstring5 = strArr[i2].substring(2);
                            } else {
                                i2++;
                                strSubstring5 = strArr[i2];
                            }
                            int i5 = Integer.parseInt(strSubstring5);
                            if (i5 >= 0 && i5 <= 65535) {
                                simpleResolver.setPort(i5);
                            }
                            System.out.println("Invalid port");
                            return;
                        }
                        if (cCharAt != 'q') {
                            System.out.print("Invalid option: ");
                            System.out.println(strArr[i2]);
                        } else {
                            z = true;
                        }
                    }
                    i2++;
                } catch (ArrayIndexOutOfBoundsException unused2) {
                    z2 = z;
                    if (name == null) {
                        usage();
                    }
                    z = z2;
                    if (simpleResolver == null) {
                        simpleResolver = new SimpleResolver();
                    }
                    messageNewQuery = Message.newQuery(Record.newRecord(name, type, dclass));
                    if (z) {
                        System.out.println(messageNewQuery);
                    }
                    if (type == 252) {
                        System.out.println("; dnsjava dig <> " + name + " axfr");
                        ZoneTransferIn zoneTransferInNewAXFR = ZoneTransferIn.newAXFR(name, simpleResolver.getAddress(), simpleResolver.getTSIGKey());
                        zoneTransferInNewAXFR.setTimeout(simpleResolver.getTimeout());
                        try {
                            zoneTransferInNewAXFR.run(new ZoneTransferIn.ZoneTransferHandler() { // from class: org.xbill.DNS.tools.dig.1
                                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                                public void startAXFR() {
                                }

                                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                                public void startIXFR() {
                                }

                                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                                public void startIXFRAdds(Record record) {
                                }

                                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                                public void startIXFRDeletes(Record record) {
                                }

                                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                                public void handleRecord(Record record) {
                                    System.out.println(record);
                                }
                            });
                            return;
                        } catch (ZoneTransferException e) {
                            throw new WireParseException(e.getMessage());
                        }
                    }
                    doQuery(simpleResolver.send(messageNewQuery), System.currentTimeMillis() - System.currentTimeMillis());
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused3) {
        }
        if (simpleResolver == null) {
            simpleResolver = new SimpleResolver();
        }
        messageNewQuery = Message.newQuery(Record.newRecord(name, type, dclass));
        if (z) {
            System.out.println(messageNewQuery);
        }
        if (type == 252) {
            System.out.println("; dnsjava dig <> " + name + " axfr");
            ZoneTransferIn zoneTransferInNewAXFR2 = ZoneTransferIn.newAXFR(name, simpleResolver.getAddress(), simpleResolver.getTSIGKey());
            zoneTransferInNewAXFR2.setTimeout(simpleResolver.getTimeout());
            zoneTransferInNewAXFR2.run(new ZoneTransferIn.ZoneTransferHandler() { // from class: org.xbill.DNS.tools.dig.1
                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                public void startAXFR() {
                }

                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                public void startIXFR() {
                }

                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                public void startIXFRAdds(Record record) {
                }

                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                public void startIXFRDeletes(Record record) {
                }

                @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
                public void handleRecord(Record record) {
                    System.out.println(record);
                }
            });
            return;
        }
        doQuery(simpleResolver.send(messageNewQuery), System.currentTimeMillis() - System.currentTimeMillis());
    }
}
