package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class PTRRecord extends SingleCompressedNameBase {
    PTRRecord() {
    }

    public PTRRecord(Name name, int i, long j, Name name2) {
        super(name, 12, i, j, name2, "target");
    }

    public Name getTarget() {
        return getSingleName();
    }
}
