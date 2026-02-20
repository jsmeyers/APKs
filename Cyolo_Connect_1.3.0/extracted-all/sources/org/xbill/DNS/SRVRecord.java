package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class SRVRecord extends Record {
    private int port;
    private int priority;
    private Name target;
    private int weight;

    SRVRecord() {
    }

    public SRVRecord(Name name, int i, long j, int i2, int i3, int i4, Name name2) {
        super(name, 33, i, j);
        this.priority = checkU16("priority", i2);
        this.weight = checkU16("weight", i3);
        this.port = checkU16("port", i4);
        this.target = checkName("target", name2);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.priority = dNSInput.readU16();
        this.weight = dNSInput.readU16();
        this.port = dNSInput.readU16();
        this.target = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.priority = tokenizer.getUInt16();
        this.weight = tokenizer.getUInt16();
        this.port = tokenizer.getUInt16();
        this.target = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.priority + " " + this.weight + " " + this.port + " " + this.target;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getPort() {
        return this.port;
    }

    public Name getTarget() {
        return this.target;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.priority);
        dNSOutput.writeU16(this.weight);
        dNSOutput.writeU16(this.port);
        this.target.toWire(dNSOutput, null, z);
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return this.target;
    }
}
