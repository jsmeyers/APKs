package io.crossingthestreams.flutterappauth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.openid.appauth.AppAuthConfiguration;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.ClientSecretBasic;
import net.openid.appauth.EndSessionRequest;
import net.openid.appauth.EndSessionResponse;
import net.openid.appauth.ResponseTypeValues;
import net.openid.appauth.TokenRequest;
import net.openid.appauth.TokenResponse;
import net.openid.appauth.connectivity.DefaultConnectionBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FlutterAppauthPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, PluginRegistry.ActivityResultListener, ActivityAware {
    private static final String AUTHORIZE_AND_EXCHANGE_CODE_ERROR_CODE = "authorize_and_exchange_code_failed";
    private static final String AUTHORIZE_AND_EXCHANGE_CODE_METHOD = "authorizeAndExchangeCode";
    private static final String AUTHORIZE_ERROR_CODE = "authorize_failed";
    private static final String AUTHORIZE_ERROR_MESSAGE_FORMAT = "Failed to authorize: [error: %s, description: %s]";
    private static final String AUTHORIZE_METHOD = "authorize";
    private static final String DISCOVERY_ERROR_CODE = "discovery_failed";
    private static final String DISCOVERY_ERROR_MESSAGE_FORMAT = "Error retrieving discovery document: [error: %s, description: %s]";
    private static final String END_SESSION_ERROR_CODE = "end_session_failed";
    private static final String END_SESSION_ERROR_MESSAGE_FORMAT = "Failed to end session: [error: %s, description: %s]";
    private static final String END_SESSION_METHOD = "endSession";
    private static final String INVALID_CLAIMS_ERROR_CODE = "invalid_claims";
    private static final String NO_BROWSER_AVAILABLE_ERROR_CODE = "no_browser_available";
    private static final String NO_BROWSER_AVAILABLE_ERROR_FORMAT = "Failed to authorize: No suitable browser is available";
    private static final String NULL_INTENT_ERROR_CODE = "null_intent";
    private static final String NULL_INTENT_ERROR_FORMAT = "Failed to authorize: Null intent received";
    private static final String TOKEN_ERROR_CODE = "token_failed";
    private static final String TOKEN_ERROR_MESSAGE_FORMAT = "Failed to get token: [error: %s, description: %s]";
    private static final String TOKEN_METHOD = "token";
    private boolean allowInsecureConnections;
    private Context applicationContext;
    private String clientSecret;
    private AuthorizationService defaultAuthorizationService;
    private AuthorizationService insecureAuthorizationService;
    private Activity mainActivity;
    private PendingOperation pendingOperation;
    private final int RC_AUTH_EXCHANGE_CODE = 65030;
    private final int RC_AUTH = 65031;
    private final int RC_END_SESSION = 65032;

    private void setActivity(Activity activity) {
        this.mainActivity = activity;
    }

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger) {
        this.applicationContext = context;
        this.defaultAuthorizationService = new AuthorizationService(this.applicationContext);
        AppAuthConfiguration.Builder builder = new AppAuthConfiguration.Builder();
        builder.setConnectionBuilder(InsecureConnectionBuilder.INSTANCE);
        builder.setSkipIssuerHttpsCheck(true);
        this.insecureAuthorizationService = new AuthorizationService(this.applicationContext, builder.build());
        new MethodChannel(binaryMessenger, "crossingthestreams.io/flutter_appauth").setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        disposeAuthorizationServices();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addActivityResultListener(this);
        this.mainActivity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        this.mainActivity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addActivityResultListener(this);
        this.mainActivity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.mainActivity = null;
    }

    private void disposeAuthorizationServices() {
        this.defaultAuthorizationService.dispose();
        this.insecureAuthorizationService.dispose();
        this.defaultAuthorizationService = null;
        this.insecureAuthorizationService = null;
    }

    private void checkAndSetPendingOperation(String str, MethodChannel.Result result) {
        if (this.pendingOperation != null) {
            throw new IllegalStateException("Concurrent operations detected: " + this.pendingOperation.method + ", " + str);
        }
        this.pendingOperation = new PendingOperation(str, result);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Map<String, Object> map;
        map = (Map) methodCall.arguments();
        String str = methodCall.method;
        str.hashCode();
        switch (str) {
            case "endSession":
                try {
                    checkAndSetPendingOperation(methodCall.method, result);
                    handleEndSessionMethodCall(map);
                    break;
                } catch (Exception e) {
                    finishWithError(END_SESSION_ERROR_CODE, e.getLocalizedMessage(), getCauseFromException(e));
                }
                break;
            case "authorizeAndExchangeCode":
                try {
                    checkAndSetPendingOperation(methodCall.method, result);
                    handleAuthorizeMethodCall(map, true);
                    break;
                } catch (Exception e2) {
                    finishWithError(AUTHORIZE_AND_EXCHANGE_CODE_ERROR_CODE, e2.getLocalizedMessage(), getCauseFromException(e2));
                    return;
                }
                break;
            case "token":
                try {
                    checkAndSetPendingOperation(methodCall.method, result);
                    handleTokenMethodCall(map);
                    break;
                } catch (Exception e3) {
                    finishWithError(TOKEN_ERROR_CODE, e3.getLocalizedMessage(), getCauseFromException(e3));
                    return;
                }
                break;
            case "authorize":
                try {
                    checkAndSetPendingOperation(methodCall.method, result);
                    handleAuthorizeMethodCall(map, false);
                    break;
                } catch (Exception e4) {
                    finishWithError(AUTHORIZE_ERROR_CODE, e4.getLocalizedMessage(), getCauseFromException(e4));
                    return;
                }
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    private AuthorizationTokenRequestParameters processAuthorizationTokenRequestArguments(Map<String, Object> map) {
        String str = (String) map.get("clientId");
        String str2 = (String) map.get("issuer");
        String str3 = (String) map.get("discoveryUrl");
        String str4 = (String) map.get("redirectUrl");
        String str5 = (String) map.get("loginHint");
        String str6 = (String) map.get("nonce");
        this.clientSecret = (String) map.get("clientSecret");
        ArrayList arrayList = (ArrayList) map.get("scopes");
        ArrayList arrayList2 = (ArrayList) map.get("promptValues");
        Map map2 = (Map) map.get("serviceConfiguration");
        Map map3 = (Map) map.get("additionalParameters");
        this.allowInsecureConnections = ((Boolean) map.get("allowInsecureConnections")).booleanValue();
        return new AuthorizationTokenRequestParameters(str, str2, str3, arrayList, str4, map2, map3, str5, str6, arrayList2, (String) map.get("responseMode"));
    }

    private TokenRequestParameters processTokenRequestArguments(Map<String, Object> map) {
        String str = (String) map.get("clientId");
        String str2 = (String) map.get("issuer");
        String str3 = (String) map.get("discoveryUrl");
        String str4 = (String) map.get("redirectUrl");
        String str5 = (String) map.get("grantType");
        this.clientSecret = (String) map.get("clientSecret");
        String str6 = map.containsKey("refreshToken") ? (String) map.get("refreshToken") : null;
        String str7 = map.containsKey("authorizationCode") ? (String) map.get("authorizationCode") : null;
        String str8 = map.containsKey("codeVerifier") ? (String) map.get("codeVerifier") : null;
        String str9 = map.containsKey("nonce") ? (String) map.get("nonce") : null;
        ArrayList arrayList = (ArrayList) map.get("scopes");
        Map map2 = (Map) map.get("serviceConfiguration");
        Map map3 = (Map) map.get("additionalParameters");
        this.allowInsecureConnections = ((Boolean) map.get("allowInsecureConnections")).booleanValue();
        return new TokenRequestParameters(str, str2, str3, arrayList, str4, str6, str7, str8, str9, str5, map2, map3);
    }

    private EndSessionRequestParameters processEndSessionRequestArguments(Map<String, Object> map) {
        return new EndSessionRequestParameters((String) map.get("idTokenHint"), (String) map.get("postLogoutRedirectUrl"), (String) map.get("state"), (String) map.get("issuer"), (String) map.get("discoveryUrl"), ((Boolean) map.get("allowInsecureConnections")).booleanValue(), (Map) map.get("serviceConfiguration"), (Map) map.get("additionalParameters"));
    }

    private void handleAuthorizeMethodCall(Map<String, Object> map, final boolean z) {
        final AuthorizationTokenRequestParameters authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments = processAuthorizationTokenRequestArguments(map);
        if (authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.serviceConfigurationParameters != null) {
            performAuthorization(processServiceConfigurationParameters(authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.serviceConfigurationParameters), authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.clientId, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.redirectUrl, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.scopes, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.loginHint, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.nonce, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.additionalParameters, z, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.promptValues, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.responseMode);
            return;
        }
        AuthorizationServiceConfiguration.RetrieveConfigurationCallback retrieveConfigurationCallback = new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: io.crossingthestreams.flutterappauth.FlutterAppauthPlugin.1
            @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
            public void onFetchConfigurationCompleted(AuthorizationServiceConfiguration authorizationServiceConfiguration, AuthorizationException authorizationException) {
                if (authorizationException == null) {
                    FlutterAppauthPlugin.this.performAuthorization(authorizationServiceConfiguration, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.clientId, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.redirectUrl, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.scopes, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.loginHint, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.nonce, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.additionalParameters, z, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.promptValues, authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.responseMode);
                } else {
                    FlutterAppauthPlugin.this.finishWithDiscoveryError(authorizationException);
                }
            }
        };
        if (authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.discoveryUrl != null) {
            AuthorizationServiceConfiguration.fetchFromUrl(Uri.parse(authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.discoveryUrl), retrieveConfigurationCallback, this.allowInsecureConnections ? InsecureConnectionBuilder.INSTANCE : DefaultConnectionBuilder.INSTANCE);
        } else {
            AuthorizationServiceConfiguration.fetchFromIssuer(Uri.parse(authorizationTokenRequestParametersProcessAuthorizationTokenRequestArguments.issuer), retrieveConfigurationCallback, this.allowInsecureConnections ? InsecureConnectionBuilder.INSTANCE : DefaultConnectionBuilder.INSTANCE);
        }
    }

    private AuthorizationServiceConfiguration processServiceConfigurationParameters(Map<String, String> map) {
        String str = map.get("endSessionEndpoint");
        return new AuthorizationServiceConfiguration(Uri.parse(map.get("authorizationEndpoint")), Uri.parse(map.get("tokenEndpoint")), null, str == null ? null : Uri.parse(str));
    }

    private void handleTokenMethodCall(Map<String, Object> map) {
        final TokenRequestParameters tokenRequestParametersProcessTokenRequestArguments = processTokenRequestArguments(map);
        if (tokenRequestParametersProcessTokenRequestArguments.serviceConfigurationParameters != null) {
            performTokenRequest(processServiceConfigurationParameters(tokenRequestParametersProcessTokenRequestArguments.serviceConfigurationParameters), tokenRequestParametersProcessTokenRequestArguments);
            return;
        }
        AuthorizationServiceConfiguration.RetrieveConfigurationCallback retrieveConfigurationCallback = new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: io.crossingthestreams.flutterappauth.FlutterAppauthPlugin.2
            @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
            public void onFetchConfigurationCompleted(AuthorizationServiceConfiguration authorizationServiceConfiguration, AuthorizationException authorizationException) {
                if (authorizationException == null) {
                    FlutterAppauthPlugin.this.performTokenRequest(authorizationServiceConfiguration, tokenRequestParametersProcessTokenRequestArguments);
                } else {
                    FlutterAppauthPlugin.this.finishWithDiscoveryError(authorizationException);
                }
            }
        };
        if (tokenRequestParametersProcessTokenRequestArguments.discoveryUrl != null) {
            AuthorizationServiceConfiguration.fetchFromUrl(Uri.parse(tokenRequestParametersProcessTokenRequestArguments.discoveryUrl), retrieveConfigurationCallback, this.allowInsecureConnections ? InsecureConnectionBuilder.INSTANCE : DefaultConnectionBuilder.INSTANCE);
        } else {
            AuthorizationServiceConfiguration.fetchFromIssuer(Uri.parse(tokenRequestParametersProcessTokenRequestArguments.issuer), retrieveConfigurationCallback, this.allowInsecureConnections ? InsecureConnectionBuilder.INSTANCE : DefaultConnectionBuilder.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAuthorization(AuthorizationServiceConfiguration authorizationServiceConfiguration, String str, String str2, ArrayList<String> arrayList, String str3, String str4, Map<String, String> map, boolean z, ArrayList<String> arrayList2, String str5) {
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(authorizationServiceConfiguration, str, ResponseTypeValues.CODE, Uri.parse(str2));
        if (arrayList != null && !arrayList.isEmpty()) {
            builder.setScopes(arrayList);
        }
        if (str3 != null) {
            builder.setLoginHint(str3);
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            builder.setPromptValues(arrayList2);
        }
        if (str5 != null) {
            builder.setResponseMode(str5);
        }
        if (str4 != null) {
            builder.setNonce(str4);
        }
        if (map != null && !map.isEmpty()) {
            if (map.containsKey("ui_locales")) {
                builder.setUiLocales(map.get("ui_locales"));
                map.remove("ui_locales");
            }
            if (map.containsKey("claims")) {
                try {
                    builder.setClaims(new JSONObject(map.get("claims")));
                    map.remove("claims");
                } catch (JSONException e) {
                    finishWithError(INVALID_CLAIMS_ERROR_CODE, e.getLocalizedMessage(), getCauseFromException(e));
                    return;
                }
            }
            builder.setAdditionalParameters(map);
        }
        try {
            this.mainActivity.startActivityForResult((this.allowInsecureConnections ? this.insecureAuthorizationService : this.defaultAuthorizationService).getAuthorizationRequestIntent(builder.build()), z ? 65030 : 65031);
        } catch (ActivityNotFoundException e2) {
            finishWithError(NO_BROWSER_AVAILABLE_ERROR_CODE, NO_BROWSER_AVAILABLE_ERROR_FORMAT, getCauseFromException(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performTokenRequest(AuthorizationServiceConfiguration authorizationServiceConfiguration, TokenRequestParameters tokenRequestParameters) {
        TokenRequest.Builder redirectUri = new TokenRequest.Builder(authorizationServiceConfiguration, tokenRequestParameters.clientId).setRefreshToken(tokenRequestParameters.refreshToken).setAuthorizationCode(tokenRequestParameters.authorizationCode).setCodeVerifier(tokenRequestParameters.codeVerifier).setRedirectUri(Uri.parse(tokenRequestParameters.redirectUrl));
        if (tokenRequestParameters.nonce != null) {
            redirectUri.setNonce(tokenRequestParameters.nonce);
        }
        if (tokenRequestParameters.grantType != null) {
            redirectUri.setGrantType(tokenRequestParameters.grantType);
        }
        if (tokenRequestParameters.scopes != null) {
            redirectUri.setScopes(tokenRequestParameters.scopes);
        }
        if (tokenRequestParameters.additionalParameters != null && !tokenRequestParameters.additionalParameters.isEmpty()) {
            redirectUri.setAdditionalParameters(tokenRequestParameters.additionalParameters);
        }
        AuthorizationService.TokenResponseCallback tokenResponseCallback = new AuthorizationService.TokenResponseCallback() { // from class: io.crossingthestreams.flutterappauth.FlutterAppauthPlugin.3
            @Override // net.openid.appauth.AuthorizationService.TokenResponseCallback
            public void onTokenRequestCompleted(TokenResponse tokenResponse, AuthorizationException authorizationException) {
                if (tokenResponse != null) {
                    FlutterAppauthPlugin.this.finishWithSuccess(FlutterAppauthPlugin.this.tokenResponseToMap(tokenResponse, null));
                } else {
                    FlutterAppauthPlugin.this.finishWithTokenError(authorizationException);
                }
            }
        };
        TokenRequest tokenRequestBuild = redirectUri.build();
        AuthorizationService authorizationService = this.allowInsecureConnections ? this.insecureAuthorizationService : this.defaultAuthorizationService;
        if (this.clientSecret == null) {
            authorizationService.performTokenRequest(tokenRequestBuild, tokenResponseCallback);
        } else {
            authorizationService.performTokenRequest(tokenRequestBuild, new ClientSecretBasic(this.clientSecret), tokenResponseCallback);
        }
    }

    private void handleEndSessionMethodCall(Map<String, Object> map) {
        final EndSessionRequestParameters endSessionRequestParametersProcessEndSessionRequestArguments = processEndSessionRequestArguments(map);
        if (endSessionRequestParametersProcessEndSessionRequestArguments.serviceConfigurationParameters != null) {
            performEndSessionRequest(processServiceConfigurationParameters(endSessionRequestParametersProcessEndSessionRequestArguments.serviceConfigurationParameters), endSessionRequestParametersProcessEndSessionRequestArguments);
            return;
        }
        AuthorizationServiceConfiguration.RetrieveConfigurationCallback retrieveConfigurationCallback = new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() { // from class: io.crossingthestreams.flutterappauth.FlutterAppauthPlugin.4
            @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
            public void onFetchConfigurationCompleted(AuthorizationServiceConfiguration authorizationServiceConfiguration, AuthorizationException authorizationException) {
                if (authorizationException == null) {
                    FlutterAppauthPlugin.this.performEndSessionRequest(authorizationServiceConfiguration, endSessionRequestParametersProcessEndSessionRequestArguments);
                } else {
                    FlutterAppauthPlugin.this.finishWithDiscoveryError(authorizationException);
                }
            }
        };
        if (endSessionRequestParametersProcessEndSessionRequestArguments.discoveryUrl != null) {
            AuthorizationServiceConfiguration.fetchFromUrl(Uri.parse(endSessionRequestParametersProcessEndSessionRequestArguments.discoveryUrl), retrieveConfigurationCallback, this.allowInsecureConnections ? InsecureConnectionBuilder.INSTANCE : DefaultConnectionBuilder.INSTANCE);
        } else {
            AuthorizationServiceConfiguration.fetchFromIssuer(Uri.parse(endSessionRequestParametersProcessEndSessionRequestArguments.issuer), retrieveConfigurationCallback, this.allowInsecureConnections ? InsecureConnectionBuilder.INSTANCE : DefaultConnectionBuilder.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performEndSessionRequest(AuthorizationServiceConfiguration authorizationServiceConfiguration, EndSessionRequestParameters endSessionRequestParameters) {
        EndSessionRequest.Builder builder = new EndSessionRequest.Builder(authorizationServiceConfiguration);
        if (endSessionRequestParameters.idTokenHint != null) {
            builder.setIdTokenHint(endSessionRequestParameters.idTokenHint);
        }
        if (endSessionRequestParameters.postLogoutRedirectUrl != null) {
            builder.setPostLogoutRedirectUri(Uri.parse(endSessionRequestParameters.postLogoutRedirectUrl));
        }
        if (endSessionRequestParameters.state != null) {
            builder.setState(endSessionRequestParameters.state);
        }
        if (endSessionRequestParameters.additionalParameters != null) {
            builder.setAdditionalParameters(endSessionRequestParameters.additionalParameters);
        }
        this.mainActivity.startActivityForResult((this.allowInsecureConnections ? this.insecureAuthorizationService : this.defaultAuthorizationService).getEndSessionRequestIntent(builder.build()), 65032);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithTokenError(AuthorizationException authorizationException) {
        finishWithError(TOKEN_ERROR_CODE, String.format(TOKEN_ERROR_MESSAGE_FORMAT, authorizationException.error, authorizationException.errorDescription), getCauseFromException(authorizationException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithSuccess(Object obj) {
        PendingOperation pendingOperation = this.pendingOperation;
        if (pendingOperation != null) {
            pendingOperation.result.success(obj);
            this.pendingOperation = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithError(String str, String str2, String str3) {
        PendingOperation pendingOperation = this.pendingOperation;
        if (pendingOperation != null) {
            pendingOperation.result.error(str, str2, str3);
            this.pendingOperation = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithDiscoveryError(AuthorizationException authorizationException) {
        finishWithError(DISCOVERY_ERROR_CODE, String.format(DISCOVERY_ERROR_MESSAGE_FORMAT, authorizationException.error, authorizationException.errorDescription), getCauseFromException(authorizationException));
    }

    private void finishWithEndSessionError(AuthorizationException authorizationException) {
        finishWithError(END_SESSION_ERROR_CODE, String.format(END_SESSION_ERROR_MESSAGE_FORMAT, authorizationException.error, authorizationException.errorDescription), getCauseFromException(authorizationException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCauseFromException(Exception exc) {
        Throwable cause = exc.getCause();
        if (cause != null) {
            return cause.getMessage();
        }
        return null;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.pendingOperation == null) {
            return false;
        }
        if (i == 65030 || i == 65031) {
            if (intent == null) {
                finishWithError(NULL_INTENT_ERROR_CODE, NULL_INTENT_ERROR_FORMAT, null);
            } else {
                processAuthorizationData(AuthorizationResponse.fromIntent(intent), AuthorizationException.fromIntent(intent), i == 65030);
            }
            return true;
        }
        if (i != 65032) {
            return false;
        }
        if (intent == null) {
            finishWithError(NULL_INTENT_ERROR_CODE, NULL_INTENT_ERROR_FORMAT, null);
        } else {
            EndSessionResponse endSessionResponseFromIntent = EndSessionResponse.fromIntent(intent);
            AuthorizationException authorizationExceptionFromIntent = AuthorizationException.fromIntent(intent);
            if (authorizationExceptionFromIntent != null) {
                finishWithEndSessionError(authorizationExceptionFromIntent);
            } else {
                HashMap map = new HashMap();
                map.put("state", endSessionResponseFromIntent.state);
                finishWithSuccess(map);
            }
        }
        return true;
    }

    private void processAuthorizationData(final AuthorizationResponse authorizationResponse, AuthorizationException authorizationException, boolean z) {
        if (authorizationException != null) {
            finishWithError(z ? AUTHORIZE_AND_EXCHANGE_CODE_ERROR_CODE : AUTHORIZE_ERROR_CODE, String.format(AUTHORIZE_ERROR_MESSAGE_FORMAT, authorizationException.error, authorizationException.errorDescription), getCauseFromException(authorizationException));
            return;
        }
        if (z) {
            AppAuthConfiguration.Builder builder = new AppAuthConfiguration.Builder();
            if (this.allowInsecureConnections) {
                builder.setConnectionBuilder(InsecureConnectionBuilder.INSTANCE);
                builder.setSkipIssuerHttpsCheck(true);
            }
            AuthorizationService authorizationService = new AuthorizationService(this.applicationContext, builder.build());
            AuthorizationService.TokenResponseCallback tokenResponseCallback = new AuthorizationService.TokenResponseCallback() { // from class: io.crossingthestreams.flutterappauth.FlutterAppauthPlugin.5
                @Override // net.openid.appauth.AuthorizationService.TokenResponseCallback
                public void onTokenRequestCompleted(TokenResponse tokenResponse, AuthorizationException authorizationException2) {
                    if (tokenResponse == null) {
                        FlutterAppauthPlugin.this.finishWithError(FlutterAppauthPlugin.AUTHORIZE_AND_EXCHANGE_CODE_ERROR_CODE, String.format(FlutterAppauthPlugin.AUTHORIZE_ERROR_MESSAGE_FORMAT, authorizationException2.error, authorizationException2.errorDescription), FlutterAppauthPlugin.this.getCauseFromException(authorizationException2));
                    } else {
                        FlutterAppauthPlugin flutterAppauthPlugin = FlutterAppauthPlugin.this;
                        flutterAppauthPlugin.finishWithSuccess(flutterAppauthPlugin.tokenResponseToMap(tokenResponse, authorizationResponse));
                    }
                }
            };
            if (this.clientSecret == null) {
                authorizationService.performTokenRequest(authorizationResponse.createTokenExchangeRequest(), tokenResponseCallback);
                return;
            } else {
                authorizationService.performTokenRequest(authorizationResponse.createTokenExchangeRequest(), new ClientSecretBasic(this.clientSecret), tokenResponseCallback);
                return;
            }
        }
        finishWithSuccess(authorizationResponseToMap(authorizationResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> tokenResponseToMap(TokenResponse tokenResponse, AuthorizationResponse authorizationResponse) {
        HashMap map = new HashMap();
        map.put("accessToken", tokenResponse.accessToken);
        map.put("accessTokenExpirationTime", tokenResponse.accessTokenExpirationTime != null ? Double.valueOf(tokenResponse.accessTokenExpirationTime.doubleValue()) : null);
        map.put("refreshToken", tokenResponse.refreshToken);
        map.put("idToken", tokenResponse.idToken);
        map.put("tokenType", tokenResponse.tokenType);
        map.put("scopes", tokenResponse.scope != null ? Arrays.asList(tokenResponse.scope.split(" ")) : null);
        if (authorizationResponse != null) {
            map.put("authorizationAdditionalParameters", authorizationResponse.additionalParameters);
        }
        map.put("tokenAdditionalParameters", tokenResponse.additionalParameters);
        return map;
    }

    private Map<String, Object> authorizationResponseToMap(AuthorizationResponse authorizationResponse) {
        HashMap map = new HashMap();
        map.put("codeVerifier", authorizationResponse.request.codeVerifier);
        map.put("nonce", authorizationResponse.request.nonce);
        map.put("authorizationCode", authorizationResponse.authorizationCode);
        map.put("authorizationAdditionalParameters", authorizationResponse.additionalParameters);
        return map;
    }

    private class PendingOperation {
        final String method;
        final MethodChannel.Result result;

        PendingOperation(String str, MethodChannel.Result result) {
            this.method = str;
            this.result = result;
        }
    }

    private class TokenRequestParameters {
        final Map<String, String> additionalParameters;
        final String authorizationCode;
        final String clientId;
        final String codeVerifier;
        final String discoveryUrl;
        final String grantType;
        final String issuer;
        final String nonce;
        final String redirectUrl;
        final String refreshToken;
        final ArrayList<String> scopes;
        final Map<String, String> serviceConfigurationParameters;

        private TokenRequestParameters(String str, String str2, String str3, ArrayList<String> arrayList, String str4, String str5, String str6, String str7, String str8, String str9, Map<String, String> map, Map<String, String> map2) {
            this.clientId = str;
            this.issuer = str2;
            this.discoveryUrl = str3;
            this.scopes = arrayList;
            this.redirectUrl = str4;
            this.refreshToken = str5;
            this.authorizationCode = str6;
            this.codeVerifier = str7;
            this.nonce = str8;
            this.grantType = str9;
            this.serviceConfigurationParameters = map;
            this.additionalParameters = map2;
        }
    }

    private class EndSessionRequestParameters {
        final Map<String, String> additionalParameters;
        final boolean allowInsecureConnections;
        final String discoveryUrl;
        final String idTokenHint;
        final String issuer;
        final String postLogoutRedirectUrl;
        final Map<String, String> serviceConfigurationParameters;
        final String state;

        private EndSessionRequestParameters(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
            this.idTokenHint = str;
            this.postLogoutRedirectUrl = str2;
            this.state = str3;
            this.issuer = str4;
            this.discoveryUrl = str5;
            this.allowInsecureConnections = z;
            this.serviceConfigurationParameters = map;
            this.additionalParameters = map2;
        }
    }

    private class AuthorizationTokenRequestParameters extends TokenRequestParameters {
        final String loginHint;
        final ArrayList<String> promptValues;
        final String responseMode;

        private AuthorizationTokenRequestParameters(String str, String str2, String str3, ArrayList<String> arrayList, String str4, Map<String, String> map, Map<String, String> map2, String str5, String str6, ArrayList<String> arrayList2, String str7) {
            super(str, str2, str3, arrayList, str4, null, null, null, str6, null, map, map2);
            this.loginHint = str5;
            this.promptValues = arrayList2;
            this.responseMode = str7;
        }
    }
}
