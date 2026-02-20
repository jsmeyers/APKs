package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import j$.util.Optional;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
interface JwtMacInternal {
    String computeMacAndEncodeWithKid(RawJwt token, Optional<String> kid) throws GeneralSecurityException;

    VerifiedJwt verifyMacAndDecodeWithKid(String compact, JwtValidator validator, Optional<String> kid) throws GeneralSecurityException;
}
