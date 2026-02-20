package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class URIRecord extends Record {
    private int priority;
    private byte[] target;
    private int weight;

    URIRecord() {
        this.target = new byte[0];
    }

    public URIRecord(Name name, int i, long j, int i2, int i3, String str) {
        super(name, 256, i, j);
        this.priority = checkU16("priority", i2);
        this.weight = checkU16("weight", i3);
        try {
            this.target = byteArrayFromString(str);
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.priority = dNSInput.readU16();
        this.weight = dNSInput.readU16();
        this.target = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.priority = tokenizer.getUInt16();
        this.weight = tokenizer.getUInt16();
        try {
            this.target = byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.priority + " " + this.weight + " " + byteArrayToString(this.target, true);
    }

    public int getPriority() {
        return this.priority;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getTarget() {
        return byteArrayToString(this.target, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.priority);
        dNSOutput.writeU16(this.weight);
        dNSOutput.writeByteArray(this.target);
    }
}
