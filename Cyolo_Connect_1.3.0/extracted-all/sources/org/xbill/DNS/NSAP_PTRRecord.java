package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class NSAP_PTRRecord extends SingleNameBase {
    NSAP_PTRRecord() {
    }

    public NSAP_PTRRecord(Name name, int i, long j, Name name2) {
        super(name, 23, i, j, name2, "target");
    }

    public Name getTarget() {
        return getSingleName();
    }
}
