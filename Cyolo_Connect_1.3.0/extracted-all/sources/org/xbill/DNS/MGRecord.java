package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class MGRecord extends SingleNameBase {
    MGRecord() {
    }

    public MGRecord(Name name, int i, long j, Name name2) {
        super(name, 8, i, j, name2, "mailbox");
    }

    public Name getMailbox() {
        return getSingleName();
    }
}
