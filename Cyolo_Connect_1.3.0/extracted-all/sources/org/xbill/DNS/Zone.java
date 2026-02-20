package org.xbill.DNS;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class Zone implements Serializable {
    public static final int PRIMARY = 1;
    public static final int SECONDARY = 2;
    private static final long serialVersionUID = -9220510891189510942L;
    private RRset NS;
    private SOARecord SOA;
    private Map<Name, Object> data;
    private boolean hasWild;
    private Name origin;
    private Object originNode;

    public int getDClass() {
        return 1;
    }

    class ZoneIterator implements Iterator<RRset> {
        private int count;
        private RRset[] current;
        private boolean wantLastSOA;
        private Iterator<Map.Entry<Name, Object>> zentries;

        ZoneIterator(boolean z) {
            synchronized (Zone.this) {
                this.zentries = Zone.this.data.entrySet().iterator();
            }
            this.wantLastSOA = z;
            RRset[] rRsetArrAllRRsets = Zone.this.allRRsets(Zone.this.originNode);
            this.current = new RRset[rRsetArrAllRRsets.length];
            int i = 2;
            for (int i2 = 0; i2 < rRsetArrAllRRsets.length; i2++) {
                int type = rRsetArrAllRRsets[i2].getType();
                if (type == 6) {
                    this.current[0] = rRsetArrAllRRsets[i2];
                } else if (type == 2) {
                    this.current[1] = rRsetArrAllRRsets[i2];
                } else {
                    this.current[i] = rRsetArrAllRRsets[i2];
                    i++;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null || this.wantLastSOA;
        }

        @Override // java.util.Iterator
        public RRset next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            RRset[] rRsetArr = this.current;
            if (rRsetArr == null) {
                this.wantLastSOA = false;
                Zone zone = Zone.this;
                return zone.oneRRset(zone.originNode, 6);
            }
            int i = this.count;
            int i2 = i + 1;
            this.count = i2;
            RRset rRset = rRsetArr[i];
            if (i2 == rRsetArr.length) {
                this.current = null;
                while (this.zentries.hasNext()) {
                    Map.Entry<Name, Object> next = this.zentries.next();
                    if (!next.getKey().equals(Zone.this.origin)) {
                        RRset[] rRsetArrAllRRsets = Zone.this.allRRsets(next.getValue());
                        if (rRsetArrAllRRsets.length != 0) {
                            this.current = rRsetArrAllRRsets;
                            this.count = 0;
                            break;
                        }
                    }
                }
            }
            return rRset;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void validate() throws IOException {
        Object objExactName = exactName(this.origin);
        this.originNode = objExactName;
        if (objExactName == null) {
            throw new IOException(this.origin + ": no data specified");
        }
        RRset rRsetOneRRset = oneRRset(objExactName, 6);
        if (rRsetOneRRset == null || rRsetOneRRset.size() != 1) {
            throw new IOException(this.origin + ": exactly 1 SOA must be specified");
        }
        this.SOA = (SOARecord) rRsetOneRRset.rrs().get(0);
        RRset rRsetOneRRset2 = oneRRset(this.originNode, 2);
        this.NS = rRsetOneRRset2;
        if (rRsetOneRRset2 != null) {
            return;
        }
        throw new IOException(this.origin + ": no NS set specified");
    }

    private void maybeAddRecord(Record record) throws IOException {
        int type = record.getType();
        Name name = record.getName();
        if (type == 6 && !name.equals(this.origin)) {
            throw new IOException("SOA owner " + name + " does not match zone origin " + this.origin);
        }
        if (name.subdomain(this.origin)) {
            addRecord(record);
        }
    }

    public Zone(Name name, String str) throws IOException {
        this.data = new TreeMap();
        if (name == null) {
            throw new IllegalArgumentException("no zone name specified");
        }
        Master master = new Master(str, name);
        try {
            this.origin = name;
            while (true) {
                Record recordNextRecord = master.nextRecord();
                if (recordNextRecord != null) {
                    maybeAddRecord(recordNextRecord);
                } else {
                    master.close();
                    validate();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    master.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public Zone(Name name, Record[] recordArr) throws IOException {
        this.data = new TreeMap();
        if (name == null) {
            throw new IllegalArgumentException("no zone name specified");
        }
        this.origin = name;
        for (Record record : recordArr) {
            maybeAddRecord(record);
        }
        validate();
    }

    private void fromXFR(ZoneTransferIn zoneTransferIn) throws ZoneTransferException, IOException {
        synchronized (this) {
            this.data = new TreeMap();
        }
        this.origin = zoneTransferIn.getName();
        zoneTransferIn.run();
        if (!zoneTransferIn.isAXFR()) {
            throw new IllegalArgumentException("zones can only be created from AXFRs");
        }
        Iterator<Record> it = zoneTransferIn.getAXFR().iterator();
        while (it.hasNext()) {
            maybeAddRecord(it.next());
        }
        validate();
    }

    public Zone(ZoneTransferIn zoneTransferIn) throws ZoneTransferException, IOException {
        fromXFR(zoneTransferIn);
    }

    public Zone(Name name, int i, String str) throws ZoneTransferException, IOException {
        ZoneTransferIn zoneTransferInNewAXFR = ZoneTransferIn.newAXFR(name, str, (TSIG) null);
        zoneTransferInNewAXFR.setDClass(i);
        fromXFR(zoneTransferInNewAXFR);
    }

    public Name getOrigin() {
        return this.origin;
    }

    public RRset getNS() {
        return this.NS;
    }

    public SOARecord getSOA() {
        return this.SOA;
    }

    private synchronized Object exactName(Name name) {
        return this.data.get(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized RRset[] allRRsets(Object obj) {
        if (obj instanceof List) {
            return (RRset[]) ((List) obj).toArray(new RRset[0]);
        }
        return new RRset[]{(RRset) obj};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    public synchronized RRset oneRRset(Object obj, int i) {
        try {
            if (i == 255) {
                throw new IllegalArgumentException("oneRRset(ANY)");
            }
            if (obj instanceof List) {
                for (RRset rRset : (List) obj) {
                    if (rRset.getType() == i) {
                        return rRset;
                    }
                }
            } else {
                RRset rRset2 = (RRset) obj;
                if (rRset2.getType() == i) {
                    return rRset2;
                }
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized RRset findRRset(Name name, int i) {
        Object objExactName = exactName(name);
        if (objExactName == null) {
            return null;
        }
        return oneRRset(objExactName, i);
    }

    private synchronized void addRRset(Name name, RRset rRset) {
        if (!this.hasWild && name.isWild()) {
            this.hasWild = true;
        }
        Object obj = this.data.get(name);
        if (obj == null) {
            this.data.put(name, rRset);
            return;
        }
        int type = rRset.getType();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                if (((RRset) list.get(i)).getType() == type) {
                    list.set(i, rRset);
                    return;
                }
            }
            list.add(rRset);
        } else {
            RRset rRset2 = (RRset) obj;
            if (rRset2.getType() == type) {
                this.data.put(name, rRset);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(rRset2);
                linkedList.add(rRset);
                this.data.put(name, linkedList);
            }
        }
    }

    private synchronized void removeRRset(Name name, int i) {
        Object obj = this.data.get(name);
        if (obj == null) {
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((RRset) list.get(i2)).getType() == i) {
                    list.remove(i2);
                    if (list.size() == 0) {
                        this.data.remove(name);
                    }
                    return;
                }
            }
        } else if (((RRset) obj).getType() == i) {
            this.data.remove(name);
        }
    }

    private synchronized SetResponse lookup(Name name, int i) {
        Name name2;
        RRset rRsetOneRRset;
        if (!name.subdomain(this.origin)) {
            return SetResponse.ofType(1);
        }
        int iLabels = name.labels();
        int iLabels2 = this.origin.labels();
        int i2 = iLabels2;
        while (true) {
            int i3 = 0;
            if (i2 <= iLabels) {
                boolean z = i2 == iLabels2;
                boolean z2 = i2 == iLabels;
                if (z) {
                    name2 = this.origin;
                } else {
                    name2 = z2 ? name : new Name(name, iLabels - i2);
                }
                Object objExactName = exactName(name2);
                if (objExactName != null) {
                    if (!z && (rRsetOneRRset = oneRRset(objExactName, 2)) != null) {
                        return new SetResponse(3, rRsetOneRRset);
                    }
                    if (z2 && i == 255) {
                        SetResponse setResponse = new SetResponse(6);
                        RRset[] rRsetArrAllRRsets = allRRsets(objExactName);
                        int length = rRsetArrAllRRsets.length;
                        while (i3 < length) {
                            setResponse.addRRset(rRsetArrAllRRsets[i3]);
                            i3++;
                        }
                        return setResponse;
                    }
                    if (z2) {
                        RRset rRsetOneRRset2 = oneRRset(objExactName, i);
                        if (rRsetOneRRset2 != null) {
                            return new SetResponse(6, rRsetOneRRset2);
                        }
                        RRset rRsetOneRRset3 = oneRRset(objExactName, 5);
                        if (rRsetOneRRset3 != null) {
                            return new SetResponse(4, rRsetOneRRset3);
                        }
                    } else {
                        RRset rRsetOneRRset4 = oneRRset(objExactName, 39);
                        if (rRsetOneRRset4 != null) {
                            return new SetResponse(5, rRsetOneRRset4);
                        }
                    }
                    if (z2) {
                        return SetResponse.ofType(2);
                    }
                }
                i2++;
            } else {
                if (this.hasWild) {
                    int i4 = 0;
                    while (i4 < iLabels - iLabels2) {
                        i4++;
                        Object objExactName2 = exactName(name.wild(i4));
                        if (objExactName2 != null) {
                            if (i == 255) {
                                SetResponse setResponse2 = new SetResponse(6);
                                RRset[] rRsetArrAllRRsets2 = allRRsets(objExactName2);
                                int length2 = rRsetArrAllRRsets2.length;
                                while (i3 < length2) {
                                    setResponse2.addRRset(expandSet(rRsetArrAllRRsets2[i3], name));
                                    i3++;
                                }
                                return setResponse2;
                            }
                            RRset rRsetOneRRset5 = oneRRset(objExactName2, i);
                            if (rRsetOneRRset5 != null) {
                                return new SetResponse(6, expandSet(rRsetOneRRset5, name));
                            }
                        }
                    }
                }
                return SetResponse.ofType(1);
            }
        }
    }

    private RRset expandSet(RRset rRset, Name name) {
        RRset rRset2 = new RRset();
        Iterator<Record> it = rRset.rrs().iterator();
        while (it.hasNext()) {
            rRset2.addRR(it.next().withName(name));
        }
        Iterator<RRSIGRecord> it2 = rRset.sigs().iterator();
        while (it2.hasNext()) {
            rRset2.addRR(it2.next().withName(name));
        }
        return rRset2;
    }

    public SetResponse findRecords(Name name, int i) {
        return lookup(name, i);
    }

    public RRset findExactMatch(Name name, int i) {
        Object objExactName = exactName(name);
        if (objExactName == null) {
            return null;
        }
        return oneRRset(objExactName, i);
    }

    public void addRRset(RRset rRset) {
        addRRset(rRset.getName(), rRset);
    }

    public <T extends Record> void addRecord(T t) {
        Name name = t.getName();
        int rRsetType = t.getRRsetType();
        synchronized (this) {
            RRset rRsetFindRRset = findRRset(name, rRsetType);
            if (rRsetFindRRset == null) {
                addRRset(name, new RRset(t));
            } else {
                rRsetFindRRset.addRR(t);
            }
        }
    }

    public void removeRecord(Record record) {
        Name name = record.getName();
        int rRsetType = record.getRRsetType();
        synchronized (this) {
            RRset rRsetFindRRset = findRRset(name, rRsetType);
            if (rRsetFindRRset == null) {
                return;
            }
            if (rRsetFindRRset.size() == 1 && rRsetFindRRset.first().equals(record)) {
                removeRRset(name, rRsetType);
            } else {
                rRsetFindRRset.deleteRR(record);
            }
        }
    }

    public Iterator<RRset> iterator() {
        return new ZoneIterator(false);
    }

    public Iterator<RRset> AXFR() {
        return new ZoneIterator(true);
    }

    private void nodeToString(final StringBuffer stringBuffer, Object obj) {
        for (RRset rRset : allRRsets(obj)) {
            Iterable.EL.forEach(rRset.rrs(), new Consumer() { // from class: org.xbill.DNS.Zone$$ExternalSyntheticLambda0
                @Override // j$.util.function.Consumer
                public final void accept(Object obj2) {
                    stringBuffer.append((Record) obj2).append('\n');
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            });
            Iterable.EL.forEach(rRset.sigs(), new Consumer() { // from class: org.xbill.DNS.Zone$$ExternalSyntheticLambda1
                @Override // j$.util.function.Consumer
                public final void accept(Object obj2) {
                    stringBuffer.append((RRSIGRecord) obj2).append('\n');
                }

                @Override // j$.util.function.Consumer
                public /* synthetic */ Consumer andThen(Consumer consumer) {
                    return Consumer.CC.$default$andThen(this, consumer);
                }
            });
        }
    }

    public synchronized String toMasterFile() {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        nodeToString(stringBuffer, this.originNode);
        for (Map.Entry<Name, Object> entry : this.data.entrySet()) {
            if (!this.origin.equals(entry.getKey())) {
                nodeToString(stringBuffer, entry.getValue());
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return toMasterFile();
    }
}
