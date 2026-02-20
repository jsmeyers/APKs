package net.openid.appauth;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.webkit.ProxyConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.openid.appauth.AuthorizationException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class IdToken {
    public final Map<String, Object> additionalClaims;
    public final List<String> audience;
    public final String authorizedParty;
    public final Long expiration;
    public final Long issuedAt;
    public final String issuer;
    public final String nonce;
    public final String subject;
    private static final Long MILLIS_PER_SECOND = 1000L;
    private static final Long TEN_MINUTES_IN_SECONDS = 600L;
    private static final String KEY_ISSUER = "iss";
    private static final String KEY_SUBJECT = "sub";
    private static final String KEY_AUDIENCE = "aud";
    private static final String KEY_EXPIRATION = "exp";
    private static final String KEY_ISSUED_AT = "iat";
    private static final String KEY_NONCE = "nonce";
    private static final String KEY_AUTHORIZED_PARTY = "azp";
    private static final Set<String> BUILT_IN_CLAIMS = AdditionalParamsProcessor.builtInParams(KEY_ISSUER, KEY_SUBJECT, KEY_AUDIENCE, KEY_EXPIRATION, KEY_ISSUED_AT, KEY_NONCE, KEY_AUTHORIZED_PARTY);

    IdToken(String issuer, String subject, List<String> audience, Long expiration, Long issuedAt) {
        this(issuer, subject, audience, expiration, issuedAt, null, null, Collections.emptyMap());
    }

    IdToken(String issuer, String subject, List<String> audience, Long expiration, Long issuedAt, String nonce, String authorizedParty) {
        this(issuer, subject, audience, expiration, issuedAt, nonce, authorizedParty, Collections.emptyMap());
    }

    IdToken(String issuer, String subject, List<String> audience, Long expiration, Long issuedAt, String nonce, String authorizedParty, Map<String, Object> additionalClaims) {
        this.issuer = issuer;
        this.subject = subject;
        this.audience = audience;
        this.expiration = expiration;
        this.issuedAt = issuedAt;
        this.nonce = nonce;
        this.authorizedParty = authorizedParty;
        this.additionalClaims = additionalClaims;
    }

    private static JSONObject parseJwtSection(String section) throws JSONException {
        return new JSONObject(new String(Base64.decode(section, 8)));
    }

    static IdToken from(String token) throws JSONException, IdTokenException {
        List<String> stringList;
        String[] strArrSplit = token.split("\\.");
        if (strArrSplit.length <= 1) {
            throw new IdTokenException("ID token must have both header and claims section");
        }
        parseJwtSection(strArrSplit[0]);
        JSONObject jwtSection = parseJwtSection(strArrSplit[1]);
        String string = JsonUtil.getString(jwtSection, KEY_ISSUER);
        String string2 = JsonUtil.getString(jwtSection, KEY_SUBJECT);
        try {
            stringList = JsonUtil.getStringList(jwtSection, KEY_AUDIENCE);
        } catch (JSONException unused) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(JsonUtil.getString(jwtSection, KEY_AUDIENCE));
            stringList = arrayList;
        }
        Long lValueOf = Long.valueOf(jwtSection.getLong(KEY_EXPIRATION));
        Long lValueOf2 = Long.valueOf(jwtSection.getLong(KEY_ISSUED_AT));
        String stringIfDefined = JsonUtil.getStringIfDefined(jwtSection, KEY_NONCE);
        String stringIfDefined2 = JsonUtil.getStringIfDefined(jwtSection, KEY_AUTHORIZED_PARTY);
        Iterator<String> it = BUILT_IN_CLAIMS.iterator();
        while (it.hasNext()) {
            jwtSection.remove(it.next());
        }
        return new IdToken(string, string2, stringList, lValueOf, lValueOf2, stringIfDefined, stringIfDefined2, JsonUtil.toMap(jwtSection));
    }

    void validate(TokenRequest tokenRequest, Clock clock) throws AuthorizationException {
        validate(tokenRequest, clock, false);
    }

    void validate(TokenRequest tokenRequest, Clock clock, boolean skipIssuerHttpsCheck) throws AuthorizationException {
        AuthorizationServiceDiscovery authorizationServiceDiscovery = tokenRequest.configuration.discoveryDoc;
        if (authorizationServiceDiscovery != null) {
            if (!this.issuer.equals(authorizationServiceDiscovery.getIssuer())) {
                throw AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_VALIDATION_ERROR, new IdTokenException("Issuer mismatch"));
            }
            Uri uri = Uri.parse(this.issuer);
            if (!skipIssuerHttpsCheck && !uri.getScheme().equals(ProxyConfig.MATCH_HTTPS)) {
                throw AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_VALIDATION_ERROR, new IdTokenException("Issuer must be an https URL"));
            }
            if (TextUtils.isEmpty(uri.getHost())) {
                throw AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_VALIDATION_ERROR, new IdTokenException("Issuer host can not be empty"));
            }
            if (uri.getFragment() != null || uri.getQueryParameterNames().size() > 0) {
                throw AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_VALIDATION_ERROR, new IdTokenException("Issuer URL should not containt query parameters or fragment components"));
            }
        }
        String str = tokenRequest.clientId;
        if (!this.audience.contains(str) && !str.equals(this.authorizedParty)) {
            throw AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_VALIDATION_ERROR, new IdTokenException("Audience mismatch"));
        }
        Long lValueOf = Long.valueOf(clock.getCurrentTimeMillis() / MILLIS_PER_SECOND.longValue());
        if (lValueOf.longValue() > this.expiration.longValue()) {
            throw AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_VALIDATION_ERROR, new IdTokenException("ID Token expired"));
        }
        if (Math.abs(lValueOf.longValue() - this.issuedAt.longValue()) > TEN_MINUTES_IN_SECONDS.longValue()) {
            throw AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_VALIDATION_ERROR, new IdTokenException("Issued at time is more than 10 minutes before or after the current time"));
        }
        if (GrantTypeValues.AUTHORIZATION_CODE.equals(tokenRequest.grantType)) {
            if (!TextUtils.equals(this.nonce, tokenRequest.nonce)) {
                throw AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_VALIDATION_ERROR, new IdTokenException("Nonce mismatch"));
            }
        }
    }

    static class IdTokenException extends Exception {
        IdTokenException(String message) {
            super(message);
        }
    }
}
