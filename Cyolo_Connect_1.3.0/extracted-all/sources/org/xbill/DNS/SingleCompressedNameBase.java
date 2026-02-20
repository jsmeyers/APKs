package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
abstract class SingleCompressedNameBase extends SingleNameBase {
    protected SingleCompressedNameBase() {
    }

    protected SingleCompressedNameBase(Name name, int i, int i2, long j, Name name2, String str) {
        super(name, i, i2, j, name2, str);
    }

    @Override // org.xbill.DNS.SingleNameBase, org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.singleName.toWire(dNSOutput, compression, z);
    }
}
