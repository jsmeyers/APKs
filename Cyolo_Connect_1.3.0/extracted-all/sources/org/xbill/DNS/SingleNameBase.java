package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
abstract class SingleNameBase extends Record {
    protected Name singleName;

    protected SingleNameBase() {
    }

    protected SingleNameBase(Name name, int i, int i2, long j) {
        super(name, i, i2, j);
    }

    protected SingleNameBase(Name name, int i, int i2, long j, Name name2, String str) {
        super(name, i, i2, j);
        this.singleName = checkName(str, name2);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.singleName = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.singleName = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.singleName.toString();
    }

    protected Name getSingleName() {
        return this.singleName;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.singleName.toWire(dNSOutput, null, z);
    }
}
