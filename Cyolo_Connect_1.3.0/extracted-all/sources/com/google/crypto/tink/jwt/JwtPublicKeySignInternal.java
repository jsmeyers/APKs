package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import j$.util.Optional;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public interface JwtPublicKeySignInternal {
    String signAndEncodeWithKid(RawJwt token, Optional<String> kid) throws GeneralSecurityException;
}
