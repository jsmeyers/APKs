package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class RTRecord extends U16NameBase {
    RTRecord() {
    }

    public RTRecord(Name name, int i, long j, int i2, Name name2) {
        super(name, 21, i, j, i2, "preference", name2, "intermediateHost");
    }

    public int getPreference() {
        return getU16Field();
    }

    public Name getIntermediateHost() {
        return getNameField();
    }
}
