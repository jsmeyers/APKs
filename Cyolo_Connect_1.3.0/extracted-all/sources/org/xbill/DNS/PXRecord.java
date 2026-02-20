package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PXRecord extends Record {
    private Name map822;
    private Name mapX400;
    private int preference;

    PXRecord() {
    }

    public PXRecord(Name name, int i, long j, int i2, Name name2, Name name3) {
        super(name, 26, i, j);
        this.preference = checkU16("preference", i2);
        this.map822 = checkName("map822", name2);
        this.mapX400 = checkName("mapX400", name3);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.preference = dNSInput.readU16();
        this.map822 = new Name(dNSInput);
        this.mapX400 = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.preference = tokenizer.getUInt16();
        this.map822 = tokenizer.getName(name);
        this.mapX400 = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.preference + " " + this.map822 + " " + this.mapX400;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.preference);
        this.map822.toWire(dNSOutput, null, z);
        this.mapX400.toWire(dNSOutput, null, z);
    }

    public int getPreference() {
        return this.preference;
    }

    public Name getMap822() {
        return this.map822;
    }

    public Name getMapX400() {
        return this.mapX400;
    }
}
