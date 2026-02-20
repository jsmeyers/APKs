package org.xbill.DNS.tools;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import net.openid.appauth.AuthorizationRequest;
import org.xbill.DNS.Address;
import org.xbill.DNS.CNAMERecord;
import org.xbill.DNS.Cache;
import org.xbill.DNS.DNAMERecord;
import org.xbill.DNS.Header;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.NameTooLongException;
import org.xbill.DNS.OPTRecord;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;
import org.xbill.DNS.SetResponse;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.TSIGRecord;
import org.xbill.DNS.Type;
import org.xbill.DNS.Zone;
import org.xbill.DNS.ZoneTransferException;

/* JADX INFO: loaded from: classes2.dex */
public class jnamed {
    static final int FLAG_DNSSECOK = 1;
    static final int FLAG_SIGONLY = 2;
    Map<Name, TSIG> TSIGs;
    Map<Integer, Cache> caches;
    Map<Name, Zone> znames;

    private static String addrport(InetAddress inetAddress, int i) {
        return inetAddress.getHostAddress() + "#" + i;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Found duplicated region for block: B:37:0x00b6  */
    public jnamed(String str) throws ZoneTransferException, IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList<InetAddress> arrayList2 = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            try {
                this.caches = new HashMap();
                this.znames = new HashMap();
                this.TSIGs = new HashMap();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(line);
                        if (stringTokenizer.hasMoreTokens()) {
                            String strNextToken = stringTokenizer.nextToken();
                            if (!stringTokenizer.hasMoreTokens()) {
                                System.out.println("Invalid line: " + line);
                            } else {
                                byte b = 0;
                                if (strNextToken.charAt(0) != '#') {
                                    switch (strNextToken.hashCode()) {
                                        case -1147692044:
                                            b = strNextToken.equals(AuthorizationRequest.Scope.ADDRESS) ? (byte) 5 : (byte) -1;
                                            break;
                                        case -817598092:
                                            if (strNextToken.equals("secondary")) {
                                                b = 1;
                                            }
                                            break;
                                        case -314765822:
                                            if (strNextToken.equals("primary")) {
                                            }
                                            break;
                                        case 106079:
                                            if (strNextToken.equals("key")) {
                                                b = 3;
                                            }
                                            break;
                                        case 3446913:
                                            if (strNextToken.equals("port")) {
                                                b = 4;
                                            }
                                            break;
                                        case 94416770:
                                            if (strNextToken.equals("cache")) {
                                                b = 2;
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                    if (b == 0) {
                                        addPrimaryZone(stringTokenizer.nextToken(), stringTokenizer.nextToken());
                                    } else if (b == 1) {
                                        addSecondaryZone(stringTokenizer.nextToken(), stringTokenizer.nextToken());
                                    } else if (b == 2) {
                                        this.caches.put(1, new Cache(stringTokenizer.nextToken()));
                                    } else if (b == 3) {
                                        String strNextToken2 = stringTokenizer.nextToken();
                                        String strNextToken3 = stringTokenizer.nextToken();
                                        if (stringTokenizer.hasMoreTokens()) {
                                            addTSIG(strNextToken2, strNextToken3, stringTokenizer.nextToken());
                                        } else {
                                            addTSIG("hmac-md5", strNextToken2, strNextToken3);
                                        }
                                    } else if (b == 4) {
                                        arrayList.add(Integer.valueOf(stringTokenizer.nextToken()));
                                    } else if (b == 5) {
                                        arrayList2.add(Address.getByAddress(stringTokenizer.nextToken()));
                                    } else {
                                        System.out.println("unknown keyword: " + strNextToken);
                                    }
                                }
                            }
                        }
                    } else {
                        if (arrayList.size() == 0) {
                            arrayList.add(53);
                        }
                        if (arrayList2.size() == 0) {
                            arrayList2.add(Address.getByAddress("0.0.0.0"));
                        }
                        for (InetAddress inetAddress : arrayList2) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                int iIntValue = ((Integer) it.next()).intValue();
                                addUDP(inetAddress, iIntValue);
                                addTCP(inetAddress, iIntValue);
                                System.out.println("jnamed: listening on " + addrport(inetAddress, iIntValue));
                            }
                        }
                        System.out.println("jnamed: running");
                        return;
                    }
                }
            } finally {
                bufferedReader.close();
            }
        } catch (Exception unused) {
            System.out.println("Cannot open " + str);
        }
    }

    public void addPrimaryZone(String str, String str2) throws IOException {
        Zone zone = new Zone(str != null ? Name.fromString(str, Name.root) : null, str2);
        this.znames.put(zone.getOrigin(), zone);
    }

    public void addSecondaryZone(String str, String str2) throws ZoneTransferException, IOException {
        Name nameFromString = Name.fromString(str, Name.root);
        this.znames.put(nameFromString, new Zone(nameFromString, 1, str2));
    }

    public void addTSIG(String str, String str2, String str3) throws IOException {
        this.TSIGs.put(Name.fromString(str2, Name.root), new TSIG(str, str2, str3));
    }

    public Cache getCache(int i) {
        Cache cache = this.caches.get(Integer.valueOf(i));
        if (cache != null) {
            return cache;
        }
        Cache cache2 = new Cache(i);
        this.caches.put(Integer.valueOf(i), cache2);
        return cache2;
    }

    public Zone findBestZone(Name name) {
        Zone zone = this.znames.get(name);
        if (zone != null) {
            return zone;
        }
        int iLabels = name.labels();
        for (int i = 1; i < iLabels; i++) {
            Zone zone2 = this.znames.get(new Name(name, i));
            if (zone2 != null) {
                return zone2;
            }
        }
        return null;
    }

    public <T extends Record> RRset findExactMatch(Name name, int i, int i2, boolean z) {
        List<RRset> listFindRecords;
        Zone zoneFindBestZone = findBestZone(name);
        if (zoneFindBestZone != null) {
            return zoneFindBestZone.findExactMatch(name, i);
        }
        Cache cache = getCache(i2);
        if (z) {
            listFindRecords = cache.findAnyRecords(name, i);
        } else {
            listFindRecords = cache.findRecords(name, i);
        }
        if (listFindRecords == null) {
            return null;
        }
        return listFindRecords.get(0);
    }

    <T extends Record> void addRRset(Name name, Message message, RRset rRset, int i, int i2) {
        for (int i3 = 1; i3 <= i; i3++) {
            if (message.findRRset(name, rRset.getType(), i3)) {
                return;
            }
        }
        if ((i2 & 2) == 0) {
            for (Record recordWithName : rRset.rrs()) {
                if (recordWithName.getName().isWild() && !name.isWild()) {
                    recordWithName = recordWithName.withName(name);
                }
                message.addRecord(recordWithName, i);
            }
        }
        if ((i2 & 3) != 0) {
            for (RRSIGRecord rRSIGRecordWithName : rRset.sigs()) {
                if (rRSIGRecordWithName.getName().isWild() && !name.isWild()) {
                    rRSIGRecordWithName = rRSIGRecordWithName.withName(name);
                }
                message.addRecord(rRSIGRecordWithName, i);
            }
        }
    }

    private void addSOA(Message message, Zone zone) {
        message.addRecord(zone.getSOA(), 2);
    }

    private void addNS(Message message, Zone zone, int i) {
        RRset ns = zone.getNS();
        addRRset(ns.getName(), message, ns, 2, i);
    }

    private void addCacheNS(Message message, Cache cache, Name name) {
        SetResponse setResponseLookupRecords = cache.lookupRecords(name, 2, 0);
        if (setResponseLookupRecords.isDelegation()) {
            Iterator<Record> it = setResponseLookupRecords.getNS().rrs().iterator();
            while (it.hasNext()) {
                message.addRecord(it.next(), 2);
            }
        }
    }

    private void addGlue(Message message, Name name, int i) {
        RRset rRsetFindExactMatch = findExactMatch(name, 1, 1, true);
        if (rRsetFindExactMatch == null) {
            return;
        }
        addRRset(name, message, rRsetFindExactMatch, 3, i);
    }

    private void addAdditional2(Message message, int i, int i2) {
        Iterator<Record> it = message.getSection(i).iterator();
        while (it.hasNext()) {
            Name additionalName = it.next().getAdditionalName();
            if (additionalName != null) {
                addGlue(message, additionalName, i2);
            }
        }
    }

    private void addAdditional(Message message, int i) {
        addAdditional2(message, 1, i);
        addAdditional2(message, 2, i);
    }

    byte addAnswer(Message message, Name name, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        SetResponse setResponseLookupRecords;
        if (i3 > 6) {
            return (byte) 0;
        }
        if (i == 24 || i == 46) {
            i5 = i4 | 2;
            i6 = 255;
        } else {
            i5 = i4;
            i6 = i;
        }
        Zone zoneFindBestZone = findBestZone(name);
        if (zoneFindBestZone != null) {
            setResponseLookupRecords = zoneFindBestZone.findRecords(name, i6);
        } else {
            setResponseLookupRecords = getCache(i2).lookupRecords(name, i6, 3);
        }
        if (setResponseLookupRecords.isUnknown()) {
            addCacheNS(message, getCache(i2), name);
        }
        if (setResponseLookupRecords.isNXDOMAIN()) {
            message.getHeader().setRcode(3);
            if (zoneFindBestZone != null) {
                addSOA(message, zoneFindBestZone);
                if (i3 == 0) {
                    message.getHeader().setFlag(5);
                }
            }
            return (byte) 3;
        }
        if (setResponseLookupRecords.isNXRRSET()) {
            if (zoneFindBestZone == null) {
                return (byte) 0;
            }
            addSOA(message, zoneFindBestZone);
            if (i3 != 0) {
                return (byte) 0;
            }
            message.getHeader().setFlag(5);
            return (byte) 0;
        }
        if (setResponseLookupRecords.isDelegation()) {
            RRset ns = setResponseLookupRecords.getNS();
            addRRset(ns.getName(), message, ns, 2, i5);
            return (byte) 0;
        }
        if (setResponseLookupRecords.isCNAME()) {
            CNAMERecord cname = setResponseLookupRecords.getCNAME();
            addRRset(name, message, new RRset(cname), 1, i5);
            if (zoneFindBestZone != null && i3 == 0) {
                message.getHeader().setFlag(5);
            }
            return addAnswer(message, cname.getTarget(), i6, i2, i3 + 1, i5);
        }
        if (setResponseLookupRecords.isDNAME()) {
            DNAMERecord dname = setResponseLookupRecords.getDNAME();
            addRRset(name, message, new RRset(dname), 1, i5);
            try {
                Name nameFromDNAME = name.fromDNAME(dname);
                addRRset(name, message, new RRset(new CNAMERecord(name, i2, 0L, nameFromDNAME)), 1, i5);
                if (zoneFindBestZone != null && i3 == 0) {
                    message.getHeader().setFlag(5);
                }
                return addAnswer(message, nameFromDNAME, i6, i2, i3 + 1, i5);
            } catch (NameTooLongException unused) {
                return (byte) 6;
            }
        }
        if (!setResponseLookupRecords.isSuccessful()) {
            return (byte) 0;
        }
        Iterator<RRset> it = setResponseLookupRecords.answers().iterator();
        while (it.hasNext()) {
            addRRset(name, message, it.next(), 1, i5);
        }
        if (zoneFindBestZone != null) {
            addNS(message, zoneFindBestZone, i5);
            if (i3 != 0) {
                return (byte) 0;
            }
            message.getHeader().setFlag(5);
            return (byte) 0;
        }
        addCacheNS(message, getCache(i2), name);
        return (byte) 0;
    }

    byte[] doAXFR(Name name, Message message, TSIG tsig, TSIGRecord tSIGRecord, Socket socket) {
        Zone zone = this.znames.get(name);
        if (zone == null) {
            return errorMessage(message, 5);
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            int id = message.getHeader().getID();
            Iterator<RRset> itAXFR = zone.AXFR();
            TSIGRecord tsig2 = tSIGRecord;
            boolean z = true;
            while (itAXFR.hasNext()) {
                RRset next = itAXFR.next();
                Message message2 = new Message(id);
                Header header = message2.getHeader();
                header.setFlag(0);
                header.setFlag(5);
                addRRset(next.getName(), message2, next, 1, 1);
                if (tsig != null) {
                    tsig.apply(message2, tsig2, z);
                    tsig2 = message2.getTSIG();
                }
                byte[] wire = message2.toWire();
                dataOutputStream.writeShort(wire.length);
                dataOutputStream.write(wire);
                z = false;
            }
        } catch (IOException unused) {
            System.out.println("AXFR failed");
        }
        try {
            socket.close();
            return null;
        } catch (IOException unused2) {
            return null;
        }
    }

    byte[] generateReply(Message message, byte[] bArr, Socket socket) {
        TSIG tsig;
        int iMax;
        Header header = message.getHeader();
        if (header.getFlag(0)) {
            return null;
        }
        if (header.getRcode() != 0) {
            return errorMessage(message, 1);
        }
        if (header.getOpcode() != 0) {
            return errorMessage(message, 4);
        }
        Record question = message.getQuestion();
        TSIGRecord tsig2 = message.getTSIG();
        if (tsig2 != null) {
            TSIG tsig3 = this.TSIGs.get(tsig2.getName());
            if (tsig3 == null || tsig3.verify(message, bArr, null) != 0) {
                return formerrMessage(bArr);
            }
            tsig = tsig3;
        } else {
            tsig = null;
        }
        OPTRecord opt = message.getOPT();
        if (socket != null) {
            iMax = 65535;
        } else {
            iMax = opt != null ? Math.max(opt.getPayloadSize(), 512) : 512;
        }
        int i = (opt == null || (opt.getFlags() & 32768) == 0) ? 0 : 1;
        Message message2 = new Message(message.getHeader().getID());
        message2.getHeader().setFlag(0);
        if (message.getHeader().getFlag(7)) {
            message2.getHeader().setFlag(7);
        }
        message2.addRecord(question, 0);
        Name name = question.getName();
        int type = question.getType();
        int dClass = question.getDClass();
        if (type == 252 && socket != null) {
            return doAXFR(name, message, tsig, tsig2, socket);
        }
        if (!Type.isRR(type) && type != 255) {
            return errorMessage(message, 4);
        }
        int i2 = i;
        byte bAddAnswer = addAnswer(message2, name, type, dClass, 0, i2);
        if (bAddAnswer != 0 && bAddAnswer != 3) {
            return errorMessage(message, bAddAnswer);
        }
        addAdditional(message2, i2);
        if (opt != null) {
            message2.addRecord(new OPTRecord(4096, bAddAnswer, 0, i2 == 1 ? 32768 : 0), 3);
        }
        message2.setTSIG(tsig, 0, tsig2);
        return message2.toWire(iMax);
    }

    byte[] buildErrorMessage(Header header, int i, Record record) {
        Message message = new Message();
        message.setHeader(header);
        for (int i2 = 0; i2 < 4; i2++) {
            message.removeAllRecords(i2);
        }
        if (i == 2) {
            message.addRecord(record, 0);
        }
        header.setRcode(i);
        return message.toWire();
    }

    public byte[] formerrMessage(byte[] bArr) {
        try {
            return buildErrorMessage(new Header(bArr), 1, null);
        } catch (IOException unused) {
            return null;
        }
    }

    public byte[] errorMessage(Message message, int i) {
        return buildErrorMessage(message.getHeader(), i, message.getQuestion());
    }

    /* JADX INFO: renamed from: TCPclient, reason: merged with bridge method [inline-methods] */
    public void m2274lambda$serveTCP$0$orgxbillDNStoolsjnamed(Socket socket) {
        byte[] bArrFormerrMessage;
        try {
            try {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
                dataInputStream.readFully(bArr);
                try {
                    bArrFormerrMessage = generateReply(new Message(bArr), bArr, socket);
                    if (bArrFormerrMessage == null) {
                        try {
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                } catch (IOException unused2) {
                    bArrFormerrMessage = formerrMessage(bArr);
                }
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeShort(bArrFormerrMessage.length);
                dataOutputStream.write(bArrFormerrMessage);
            } catch (IOException e) {
                System.out.println("TCPclient(" + addrport(socket.getLocalAddress(), socket.getLocalPort()) + "): " + e);
            }
        } finally {
            try {
                socket.close();
            } catch (IOException unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: serveTCP, reason: merged with bridge method [inline-methods] */
    public void m2272lambda$addTCP$1$orgxbillDNStoolsjnamed(InetAddress inetAddress, int i) {
        try {
            ServerSocket serverSocket = new ServerSocket(i, 128, inetAddress);
            while (true) {
                try {
                    final Socket socketAccept = serverSocket.accept();
                    new Thread(new Runnable() { // from class: org.xbill.DNS.tools.jnamed$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m2274lambda$serveTCP$0$orgxbillDNStoolsjnamed(socketAccept);
                        }
                    }).start();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            serverSocket.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("serveTCP(" + addrport(inetAddress, i) + "): " + e);
        }
    }

    /* JADX INFO: renamed from: serveUDP, reason: merged with bridge method [inline-methods] */
    public void m2273lambda$addUDP$2$orgxbillDNStoolsjnamed(InetAddress inetAddress, int i) {
        byte[] bArrFormerrMessage;
        try {
            DatagramSocket datagramSocket = new DatagramSocket(i, inetAddress);
            try {
                byte[] bArr = new byte[512];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 512);
                DatagramPacket datagramPacket2 = null;
                while (true) {
                    datagramPacket.setLength(512);
                    try {
                        datagramSocket.receive(datagramPacket);
                        try {
                            bArrFormerrMessage = generateReply(new Message(bArr), bArr, null);
                        } catch (IOException unused) {
                            bArrFormerrMessage = formerrMessage(bArr);
                        }
                        if (bArrFormerrMessage != null) {
                            if (datagramPacket2 == null) {
                                datagramPacket2 = new DatagramPacket(bArrFormerrMessage, bArrFormerrMessage.length, datagramPacket.getAddress(), datagramPacket.getPort());
                            } else {
                                datagramPacket2.setData(bArrFormerrMessage);
                                datagramPacket2.setLength(bArrFormerrMessage.length);
                                datagramPacket2.setAddress(datagramPacket.getAddress());
                                datagramPacket2.setPort(datagramPacket.getPort());
                            }
                            datagramSocket.send(datagramPacket2);
                        }
                    } catch (InterruptedIOException unused2) {
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        datagramSocket.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            System.out.println("serveUDP(" + addrport(inetAddress, i) + "): " + e);
        }
    }

    public void addTCP(final InetAddress inetAddress, final int i) {
        new Thread(new Runnable() { // from class: org.xbill.DNS.tools.jnamed$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m2272lambda$addTCP$1$orgxbillDNStoolsjnamed(inetAddress, i);
            }
        }).start();
    }

    public void addUDP(final InetAddress inetAddress, final int i) {
        new Thread(new Runnable() { // from class: org.xbill.DNS.tools.jnamed$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m2273lambda$addUDP$2$orgxbillDNStoolsjnamed(inetAddress, i);
            }
        }).start();
    }

    public static void main(String[] strArr) {
        if (strArr.length > 1) {
            System.out.println("usage: jnamed [conf]");
            System.exit(0);
        }
        try {
            new jnamed(strArr.length == 1 ? strArr[0] : "jnamed.conf");
        } catch (IOException | ZoneTransferException e) {
            System.out.println(e);
        }
    }
}
