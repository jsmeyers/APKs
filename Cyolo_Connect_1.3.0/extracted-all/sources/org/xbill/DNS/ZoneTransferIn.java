package org.xbill.DNS;

import androidx.work.PeriodicWorkRequest;
import j$.time.Duration;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.TSIG;

/* JADX INFO: loaded from: classes2.dex */
public class ZoneTransferIn {
    private static final int AXFR = 6;
    private static final int END = 7;
    private static final int FIRSTDATA = 1;
    private static final int INITIALSOA = 0;
    private static final int IXFR_ADD = 5;
    private static final int IXFR_ADDSOA = 4;
    private static final int IXFR_DEL = 3;
    private static final int IXFR_DELSOA = 2;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) ZoneTransferIn.class);
    private SocketAddress address;
    private TCPClient client;
    private long current_serial;
    private int dclass;
    private long end_serial;
    private ZoneTransferHandler handler;
    private Record initialsoa;
    private long ixfr_serial;
    private SocketAddress localAddress;
    private int qtype;
    private int rtype;
    private int state;
    private long timeout = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
    private TSIG tsig;
    private TSIG.StreamVerifier verifier;
    private boolean want_fallback;
    private Name zname;

    public interface ZoneTransferHandler {
        void handleRecord(Record record) throws ZoneTransferException;

        void startAXFR() throws ZoneTransferException;

        void startIXFR() throws ZoneTransferException;

        void startIXFRAdds(Record record) throws ZoneTransferException;

        void startIXFRDeletes(Record record) throws ZoneTransferException;
    }

    public static class Delta {
        public List<Record> adds;
        public List<Record> deletes;
        public long end;
        public long start;

        private Delta() {
            this.adds = new ArrayList();
            this.deletes = new ArrayList();
        }
    }

    private static class BasicHandler implements ZoneTransferHandler {
        private List<Record> axfr;
        private List<Delta> ixfr;

        private BasicHandler() {
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void startAXFR() {
            this.axfr = new ArrayList();
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void startIXFR() {
            this.ixfr = new ArrayList();
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void startIXFRDeletes(Record record) {
            Delta delta = new Delta();
            delta.deletes.add(record);
            delta.start = ZoneTransferIn.getSOASerial(record);
            this.ixfr.add(delta);
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void startIXFRAdds(Record record) {
            Delta delta = this.ixfr.get(r0.size() - 1);
            delta.adds.add(record);
            delta.end = ZoneTransferIn.getSOASerial(record);
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void handleRecord(Record record) {
            List<Delta> list = this.ixfr;
            if (list != null) {
                Delta delta = list.get(list.size() - 1);
                if (delta.adds.size() > 0) {
                    delta.adds.add(record);
                    return;
                } else {
                    delta.deletes.add(record);
                    return;
                }
            }
            this.axfr.add(record);
        }
    }

    private ZoneTransferIn() {
    }

    private ZoneTransferIn(Name name, int i, long j, boolean z, SocketAddress socketAddress, TSIG tsig) {
        this.address = socketAddress;
        this.tsig = tsig;
        if (name.isAbsolute()) {
            this.zname = name;
        } else {
            try {
                this.zname = Name.concatenate(name, Name.root);
            } catch (NameTooLongException unused) {
                throw new IllegalArgumentException("ZoneTransferIn: name too long");
            }
        }
        this.qtype = i;
        this.dclass = 1;
        this.ixfr_serial = j;
        this.want_fallback = z;
        this.state = 0;
    }

    public static ZoneTransferIn newAXFR(Name name, SocketAddress socketAddress, TSIG tsig) {
        return new ZoneTransferIn(name, 252, 0L, false, socketAddress, tsig);
    }

    public static ZoneTransferIn newAXFR(Name name, String str, int i, TSIG tsig) {
        if (i == 0) {
            i = 53;
        }
        return newAXFR(name, new InetSocketAddress(str, i), tsig);
    }

    public static ZoneTransferIn newAXFR(Name name, String str, TSIG tsig) {
        return newAXFR(name, str, 0, tsig);
    }

    public static ZoneTransferIn newIXFR(Name name, long j, boolean z, SocketAddress socketAddress, TSIG tsig) {
        return new ZoneTransferIn(name, Type.IXFR, j, z, socketAddress, tsig);
    }

    public static ZoneTransferIn newIXFR(Name name, long j, boolean z, String str, int i, TSIG tsig) {
        if (i == 0) {
            i = 53;
        }
        return newIXFR(name, j, z, new InetSocketAddress(str, i), tsig);
    }

    public static ZoneTransferIn newIXFR(Name name, long j, boolean z, String str, TSIG tsig) {
        return newIXFR(name, j, z, str, 0, tsig);
    }

    public Name getName() {
        return this.zname;
    }

    public int getType() {
        return this.qtype;
    }

    @Deprecated
    public void setTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout cannot be negative");
        }
        this.timeout = ((long) i) * 1000;
    }

    public void setTimeout(Duration duration) {
        this.timeout = (int) duration.toMillis();
    }

    public void setDClass(int i) {
        DClass.check(i);
        this.dclass = i;
    }

    public void setLocalAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
    }

    private void openConnection() throws IOException {
        TCPClient tCPClient = new TCPClient(this.timeout);
        this.client = tCPClient;
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            tCPClient.bind(socketAddress);
        }
        this.client.connect(this.address);
    }

    private void sendQuery() throws IOException {
        Record recordNewRecord = Record.newRecord(this.zname, this.qtype, this.dclass);
        Message message = new Message();
        message.getHeader().setOpcode(0);
        message.addRecord(recordNewRecord, 0);
        if (this.qtype == 251) {
            message.addRecord(new SOARecord(this.zname, this.dclass, 0L, Name.root, Name.root, this.ixfr_serial, 0L, 0L, 0L, 0L), 2);
        }
        TSIG tsig = this.tsig;
        if (tsig != null) {
            tsig.apply(message, null);
            this.verifier = new TSIG.StreamVerifier(this.tsig, message.getTSIG());
        }
        this.client.send(message.toWire(65535));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getSOASerial(Record record) {
        return ((SOARecord) record).getSerial();
    }

    private void logxfr(String str) {
        log.debug("{}: {}", this.zname, str);
    }

    private void fail(String str) throws ZoneTransferException {
        throw new ZoneTransferException(str);
    }

    private void fallback() throws ZoneTransferException {
        if (!this.want_fallback) {
            fail("server doesn't support IXFR");
        }
        logxfr("falling back to AXFR");
        this.qtype = 252;
        this.state = 0;
    }

    private void parseRR(Record record) throws ZoneTransferException {
        int type = record.getType();
        switch (this.state) {
            case 0:
                if (type != 6) {
                    fail("missing initial SOA");
                }
                this.initialsoa = record;
                long sOASerial = getSOASerial(record);
                this.end_serial = sOASerial;
                if (this.qtype == 251 && Serial.compare(sOASerial, this.ixfr_serial) <= 0) {
                    logxfr("up to date");
                    this.state = 7;
                } else {
                    this.state = 1;
                }
                break;
            case 1:
                if (this.qtype == 251 && type == 6 && getSOASerial(record) == this.ixfr_serial) {
                    this.rtype = Type.IXFR;
                    this.handler.startIXFR();
                    logxfr("got incremental response");
                    this.state = 2;
                } else {
                    this.rtype = 252;
                    this.handler.startAXFR();
                    this.handler.handleRecord(this.initialsoa);
                    logxfr("got nonincremental response");
                    this.state = 6;
                }
                parseRR(record);
                break;
            case 2:
                this.handler.startIXFRDeletes(record);
                this.state = 3;
                break;
            case 3:
                if (type == 6) {
                    this.current_serial = getSOASerial(record);
                    this.state = 4;
                    parseRR(record);
                } else {
                    this.handler.handleRecord(record);
                }
                break;
            case 4:
                this.handler.startIXFRAdds(record);
                this.state = 5;
                break;
            case 5:
                if (type == 6) {
                    long sOASerial2 = getSOASerial(record);
                    if (sOASerial2 == this.end_serial) {
                        this.state = 7;
                    } else if (sOASerial2 != this.current_serial) {
                        fail("IXFR out of sync: expected serial " + this.current_serial + " , got " + sOASerial2);
                    } else {
                        this.state = 2;
                        parseRR(record);
                    }
                }
                this.handler.handleRecord(record);
                break;
            case 6:
                if (type != 1 || record.getDClass() == this.dclass) {
                    this.handler.handleRecord(record);
                    if (type == 6) {
                        this.state = 7;
                    }
                }
                break;
            case 7:
                fail("extra data");
                break;
            default:
                fail("invalid state");
                break;
        }
    }

    private void closeConnection() {
        try {
            TCPClient tCPClient = this.client;
            if (tCPClient != null) {
                tCPClient.cleanup();
            }
        } catch (IOException unused) {
        }
    }

    private Message parseMessage(byte[] bArr) throws WireParseException {
        try {
            return new Message(bArr);
        } catch (IOException e) {
            if (e instanceof WireParseException) {
                throw ((WireParseException) e);
            }
            throw new WireParseException("Error parsing message");
        }
    }

    private void doxfr() throws ZoneTransferException, IOException {
        TSIG.StreamVerifier streamVerifier;
        int iVerify;
        sendQuery();
        while (this.state != 7) {
            byte[] bArrRecv = this.client.recv();
            Message message = parseMessage(bArrRecv);
            if (message.getHeader().getRcode() == 0 && (streamVerifier = this.verifier) != null && (iVerify = streamVerifier.verify(message, bArrRecv)) != 0) {
                fail("TSIG failure: " + Rcode.TSIGstring(iVerify));
            }
            List<Record> section = message.getSection(1);
            if (this.state == 0) {
                int rcode = message.getRcode();
                if (rcode != 0) {
                    if (this.qtype == 251 && rcode == 4) {
                        fallback();
                        doxfr();
                        return;
                    }
                    fail(Rcode.string(rcode));
                }
                Record question = message.getQuestion();
                if (question != null && question.getType() != this.qtype) {
                    fail("invalid question section");
                }
                if (section.isEmpty() && this.qtype == 251) {
                    fallback();
                    doxfr();
                    return;
                }
            }
            Iterator<Record> it = section.iterator();
            while (it.hasNext()) {
                parseRR(it.next());
            }
            if (this.state == 7 && this.verifier != null && !message.isVerified()) {
                fail("last message must be signed");
            }
        }
    }

    public void run(ZoneTransferHandler zoneTransferHandler) throws ZoneTransferException, IOException {
        this.handler = zoneTransferHandler;
        try {
            openConnection();
            doxfr();
        } finally {
            closeConnection();
        }
    }

    public void run() throws ZoneTransferException, IOException {
        run(new BasicHandler());
    }

    private BasicHandler getBasicHandler() throws IllegalArgumentException {
        ZoneTransferHandler zoneTransferHandler = this.handler;
        if (zoneTransferHandler instanceof BasicHandler) {
            return (BasicHandler) zoneTransferHandler;
        }
        throw new IllegalArgumentException("ZoneTransferIn used callback interface");
    }

    public boolean isAXFR() {
        return this.rtype == 252;
    }

    public List<Record> getAXFR() {
        return getBasicHandler().axfr;
    }

    public boolean isIXFR() {
        return this.rtype == 251;
    }

    public List<Delta> getIXFR() {
        return getBasicHandler().ixfr;
    }

    public boolean isCurrent() {
        BasicHandler basicHandler = getBasicHandler();
        return basicHandler.axfr == null && basicHandler.ixfr == null;
    }
}
