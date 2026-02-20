package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String typeUrl, String primitiveName, int minVersion) throws GeneralSecurityException;

    PrimitiveWrapper<?, P> getPrimitiveWrapper() throws GeneralSecurityException;
}
