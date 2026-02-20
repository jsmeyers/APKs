package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class AFSDBRecord extends U16NameBase {
    AFSDBRecord() {
    }

    public AFSDBRecord(Name name, int i, long j, int i2, Name name2) {
        super(name, 18, i, j, i2, "subtype", name2, "host");
    }

    public int getSubtype() {
        return getU16Field();
    }

    public Name getHost() {
        return getNameField();
    }
}
