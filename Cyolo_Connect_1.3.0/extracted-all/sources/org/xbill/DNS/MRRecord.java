package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class MRRecord extends SingleNameBase {
    MRRecord() {
    }

    public MRRecord(Name name, int i, long j, Name name2) {
        super(name, 9, i, j, name2, "new name");
    }

    public Name getNewName() {
        return getSingleName();
    }
}
