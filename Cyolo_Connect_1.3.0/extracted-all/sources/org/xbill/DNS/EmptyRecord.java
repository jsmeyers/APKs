package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
class EmptyRecord extends Record {
    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return "";
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
    }

    EmptyRecord() {
    }
}
