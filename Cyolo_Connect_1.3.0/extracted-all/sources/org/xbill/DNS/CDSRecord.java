package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class CDSRecord extends DSRecord {
    CDSRecord() {
    }

    public CDSRecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(name, 59, i, j, i2, i3, i4, bArr);
    }

    public CDSRecord(Name name, int i, long j, int i2, DNSKEYRecord dNSKEYRecord) {
        super(name, 59, i, j, dNSKEYRecord.getFootprint(), dNSKEYRecord.getAlgorithm(), i2, DNSSEC.generateDSDigest(dNSKEYRecord, i2));
    }
}
