package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class RPRecord extends Record {
    private Name mailbox;
    private Name textDomain;

    RPRecord() {
    }

    public RPRecord(Name name, int i, long j, Name name2, Name name3) {
        super(name, 17, i, j);
        this.mailbox = checkName("mailbox", name2);
        this.textDomain = checkName("textDomain", name3);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.mailbox = new Name(dNSInput);
        this.textDomain = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.mailbox = tokenizer.getName(name);
        this.textDomain = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.mailbox + " " + this.textDomain;
    }

    public Name getMailbox() {
        return this.mailbox;
    }

    public Name getTextDomain() {
        return this.textDomain;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.mailbox.toWire(dNSOutput, null, z);
        this.textDomain.toWire(dNSOutput, null, z);
    }
}
