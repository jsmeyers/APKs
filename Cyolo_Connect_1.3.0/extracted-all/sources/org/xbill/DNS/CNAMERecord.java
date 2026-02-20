package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class CNAMERecord extends SingleCompressedNameBase {
    CNAMERecord() {
    }

    public CNAMERecord(Name name, int i, long j, Name name2) {
        super(name, 5, i, j, name2, "alias");
    }

    public Name getTarget() {
        return getSingleName();
    }

    @Deprecated
    public Name getAlias() {
        return getName();
    }
}
