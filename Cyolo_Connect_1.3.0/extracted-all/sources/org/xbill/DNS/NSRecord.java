package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class NSRecord extends SingleCompressedNameBase {
    NSRecord() {
    }

    public NSRecord(Name name, int i, long j, Name name2) {
        super(name, 2, i, j, name2, "target");
    }

    public Name getTarget() {
        return getSingleName();
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }
}
