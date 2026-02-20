package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class MBRecord extends SingleNameBase {
    MBRecord() {
    }

    public MBRecord(Name name, int i, long j, Name name2) {
        super(name, 7, i, j, name2, "mailbox");
    }

    public Name getMailbox() {
        return getSingleName();
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }
}
