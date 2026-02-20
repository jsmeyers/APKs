package org.xbill.DNS;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class NAPTRRecord extends Record {
    private byte[] flags;
    private int order;
    private int preference;
    private byte[] regexp;
    private Name replacement;
    private byte[] service;

    NAPTRRecord() {
    }

    public NAPTRRecord(Name name, int i, long j, int i2, int i3, String str, String str2, String str3, Name name2) {
        super(name, 35, i, j);
        this.order = checkU16("order", i2);
        this.preference = checkU16("preference", i3);
        try {
            this.flags = byteArrayFromString(str);
            this.service = byteArrayFromString(str2);
            this.regexp = byteArrayFromString(str3);
            this.replacement = checkName("replacement", name2);
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws IOException {
        this.order = dNSInput.readU16();
        this.preference = dNSInput.readU16();
        this.flags = dNSInput.readCountedString();
        this.service = dNSInput.readCountedString();
        this.regexp = dNSInput.readCountedString();
        this.replacement = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.order = tokenizer.getUInt16();
        this.preference = tokenizer.getUInt16();
        try {
            this.flags = byteArrayFromString(tokenizer.getString());
            this.service = byteArrayFromString(tokenizer.getString());
            this.regexp = byteArrayFromString(tokenizer.getString());
            this.replacement = tokenizer.getName(name);
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.order + " " + this.preference + " " + byteArrayToString(this.flags, true) + " " + byteArrayToString(this.service, true) + " " + byteArrayToString(this.regexp, true) + " " + this.replacement;
    }

    public int getOrder() {
        return this.order;
    }

    public int getPreference() {
        return this.preference;
    }

    public String getFlags() {
        return byteArrayToString(this.flags, false);
    }

    public String getService() {
        return byteArrayToString(this.service, false);
    }

    public String getRegexp() {
        return byteArrayToString(this.regexp, false);
    }

    public Name getReplacement() {
        return this.replacement;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.order);
        dNSOutput.writeU16(this.preference);
        dNSOutput.writeCountedString(this.flags);
        dNSOutput.writeCountedString(this.service);
        dNSOutput.writeCountedString(this.regexp);
        this.replacement.toWire(dNSOutput, null, z);
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return this.replacement;
    }
}
