package com.google.crypto.tink.hybrid.internal;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
interface HpkeKem {
    byte[] decapsulate(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey) throws GeneralSecurityException;

    HpkeKemEncapOutput encapsulate(byte[] recipientPublicKey) throws GeneralSecurityException;

    byte[] getKemId() throws GeneralSecurityException;
}
