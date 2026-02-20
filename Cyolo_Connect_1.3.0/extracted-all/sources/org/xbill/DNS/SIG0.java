package org.xbill.DNS;

import j$.time.Duration;
import j$.time.Instant;
import java.security.PrivateKey;
import org.xbill.DNS.DNSSEC;

/* JADX INFO: loaded from: classes2.dex */
public class SIG0 {
    private static final Duration VALIDITY = Duration.ofSeconds(300);

    private SIG0() {
    }

    public static void signMessage(Message message, KEYRecord kEYRecord, PrivateKey privateKey, SIGRecord sIGRecord) throws DNSSEC.DNSSECException {
        signMessage(message, kEYRecord, privateKey, sIGRecord, Instant.now());
    }

    public static void signMessage(Message message, KEYRecord kEYRecord, PrivateKey privateKey, SIGRecord sIGRecord, Instant instant) throws DNSSEC.DNSSECException {
        Duration durationOfSeconds;
        int iIntValue = Options.intValue("sig0validity");
        if (iIntValue < 0) {
            durationOfSeconds = VALIDITY;
        } else {
            durationOfSeconds = Duration.ofSeconds(iIntValue);
        }
        message.addRecord(DNSSEC.signMessage(message, sIGRecord, kEYRecord, privateKey, instant, instant.plus(durationOfSeconds)), 3);
    }

    public static void verifyMessage(Message message, byte[] bArr, KEYRecord kEYRecord, SIGRecord sIGRecord) throws DNSSEC.DNSSECException {
        verifyMessage(message, bArr, kEYRecord, sIGRecord, Instant.now());
    }

    public static void verifyMessage(Message message, byte[] bArr, KEYRecord kEYRecord, SIGRecord sIGRecord, Instant instant) throws DNSSEC.DNSSECException {
        SIGRecord sIGRecord2;
        for (Record record : message.getSection(3)) {
            if (record.getType() == 24) {
                sIGRecord2 = (SIGRecord) record;
                if (sIGRecord2.getTypeCovered() == 0) {
                    DNSSEC.verifyMessage(message, bArr, sIGRecord2, sIGRecord, kEYRecord, instant);
                }
            }
        }
        sIGRecord2 = null;
        DNSSEC.verifyMessage(message, bArr, sIGRecord2, sIGRecord, kEYRecord, instant);
    }
}
