package org.xbill.DNS;

import java.security.PublicKey;
import org.xbill.DNS.DNSSEC;

/* JADX INFO: loaded from: classes2.dex */
public class CDNSKEYRecord extends DNSKEYRecord {
    CDNSKEYRecord() {
    }

    public CDNSKEYRecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(name, 60, i, j, i2, i3, i4, bArr);
    }

    public CDNSKEYRecord(Name name, int i, long j, int i2, int i3, int i4, PublicKey publicKey) throws DNSSEC.DNSSECException {
        super(name, 60, i, j, i2, i3, i4, DNSSEC.fromPublicKey(publicKey, i4));
    }
}
