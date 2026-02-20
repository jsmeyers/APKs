package com.google.crypto.tink.subtle;

import com.google.crypto.tink.hybrid.subtle.AeadOrDaead;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public interface EciesAeadHkdfDemHelper {
    AeadOrDaead getAeadOrDaead(final byte[] symmetricKeyValue) throws GeneralSecurityException;

    int getSymmetricKeySizeInBytes();
}
