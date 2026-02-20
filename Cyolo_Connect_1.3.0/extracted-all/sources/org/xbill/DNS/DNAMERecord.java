package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class DNAMERecord extends SingleNameBase {
    DNAMERecord() {
    }

    public DNAMERecord(Name name, int i, long j, Name name2) {
        super(name, 39, i, j, name2, "alias");
    }

    public Name getTarget() {
        return getSingleName();
    }

    @Deprecated
    public Name getAlias() {
        return getName();
    }
}
