package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
abstract class U16NameBase extends Record {
    protected Name nameField;
    protected int u16Field;

    protected U16NameBase() {
    }

    protected U16NameBase(Name name, int i, int i2, long j) {
        super(name, i, i2, j);
    }

    protected U16NameBase(Name name, int i, int i2, long j, int i3, String str, Name name2, String str2) {
        super(name, i, i2, j);
        this.u16Field = checkU16(str, i3);
        this.nameField = checkName(str2, name2);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.u16Field = dNSInput.readU16();
        this.nameField = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.u16Field = tokenizer.getUInt16();
        this.nameField = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.u16Field + " " + this.nameField;
    }

    protected int getU16Field() {
        return this.u16Field;
    }

    protected Name getNameField() {
        return this.nameField;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.u16Field);
        this.nameField.toWire(dNSOutput, null, z);
    }
}
