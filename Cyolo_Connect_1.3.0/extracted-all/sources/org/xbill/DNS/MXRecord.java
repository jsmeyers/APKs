package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class MXRecord extends U16NameBase {
    MXRecord() {
    }

    public MXRecord(Name name, int i, long j, int i2, Name name2) {
        super(name, 15, i, j, i2, "priority", name2, "target");
    }

    public Name getTarget() {
        return getNameField();
    }

    public int getPriority() {
        return getU16Field();
    }

    @Override // org.xbill.DNS.U16NameBase, org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.u16Field);
        this.nameField.toWire(dNSOutput, compression, z);
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getNameField();
    }
}
