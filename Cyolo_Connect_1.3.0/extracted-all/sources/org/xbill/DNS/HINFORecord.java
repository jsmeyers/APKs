package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class HINFORecord extends Record {
    private byte[] cpu;
    private byte[] os;

    HINFORecord() {
    }

    public HINFORecord(Name name, int i, long j, String str, String str2) {
        super(name, 13, i, j);
        try {
            this.cpu = byteArrayFromString(str);
            this.os = byteArrayFromString(str2);
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.cpu = dNSInput.readCountedString();
        this.os = dNSInput.readCountedString();
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        try {
            this.cpu = byteArrayFromString(tokenizer.getString());
            this.os = byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    public String getCPU() {
        return byteArrayToString(this.cpu, false);
    }

    public String getOS() {
        return byteArrayToString(this.os, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.cpu);
        dNSOutput.writeCountedString(this.os);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return byteArrayToString(this.cpu, true) + " " + byteArrayToString(this.os, true);
    }
}
