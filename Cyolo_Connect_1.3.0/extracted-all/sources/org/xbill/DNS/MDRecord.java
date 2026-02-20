package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class MDRecord extends SingleNameBase {
    MDRecord() {
    }

    public MDRecord(Name name, int i, long j, Name name2) {
        super(name, 3, i, j, name2, "mail agent");
    }

    public Name getMailAgent() {
        return getSingleName();
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }
}
