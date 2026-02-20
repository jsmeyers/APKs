package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class MINFORecord extends Record {
    private Name errorAddress;
    private Name responsibleAddress;

    MINFORecord() {
    }

    public MINFORecord(Name name, int i, long j, Name name2, Name name3) {
        super(name, 14, i, j);
        this.responsibleAddress = checkName("responsibleAddress", name2);
        this.errorAddress = checkName("errorAddress", name3);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.responsibleAddress = new Name(dNSInput);
        this.errorAddress = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.responsibleAddress = tokenizer.getName(name);
        this.errorAddress = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.responsibleAddress + " " + this.errorAddress;
    }

    public Name getResponsibleAddress() {
        return this.responsibleAddress;
    }

    public Name getErrorAddress() {
        return this.errorAddress;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.responsibleAddress.toWire(dNSOutput, null, z);
        this.errorAddress.toWire(dNSOutput, null, z);
    }
}
