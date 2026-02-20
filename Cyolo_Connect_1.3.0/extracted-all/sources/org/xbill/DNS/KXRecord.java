package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class KXRecord extends U16NameBase {
    KXRecord() {
    }

    public KXRecord(Name name, int i, long j, int i2, Name name2) {
        super(name, 36, i, j, i2, "preference", name2, "target");
    }

    public Name getTarget() {
        return getNameField();
    }

    public int getPreference() {
        return getU16Field();
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getNameField();
    }
}
