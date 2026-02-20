package net.openid.appauth;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Map;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.IdToken;
import net.openid.appauth.RegistrationResponse;
import net.openid.appauth.TokenResponse;
import net.openid.appauth.browser.BrowserDescriptor;
import net.openid.appauth.browser.BrowserSelector;
import net.openid.appauth.browser.CustomTabManager;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.internal.Logger;
import net.openid.appauth.internal.UriUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AuthorizationService {
    private final BrowserDescriptor mBrowser;
    private final AppAuthConfiguration mClientConfiguration;
    Context mContext;
    private final CustomTabManager mCustomTabManager;
    private boolean mDisposed;

    public interface RegistrationResponseCallback {
        void onRegistrationRequestCompleted(RegistrationResponse response, AuthorizationException ex);
    }

    public interface TokenResponseCallback {
        void onTokenRequestCompleted(TokenResponse response, AuthorizationException ex);
    }

    public AuthorizationService(Context context) {
        this(context, AppAuthConfiguration.DEFAULT);
    }

    public AuthorizationService(Context context, AppAuthConfiguration clientConfiguration) {
        this(context, clientConfiguration, BrowserSelector.select(context, clientConfiguration.getBrowserMatcher()), new CustomTabManager(context));
    }

    AuthorizationService(Context context, AppAuthConfiguration clientConfiguration, BrowserDescriptor browser, CustomTabManager customTabManager) {
        this.mDisposed = false;
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mClientConfiguration = clientConfiguration;
        this.mCustomTabManager = customTabManager;
        this.mBrowser = browser;
        if (browser == null || !browser.useCustomTab.booleanValue()) {
            return;
        }
        customTabManager.bind(browser.packageName);
    }

    public CustomTabManager getCustomTabManager() {
        return this.mCustomTabManager;
    }

    public BrowserDescriptor getBrowserDescriptor() {
        return this.mBrowser;
    }

    public CustomTabsIntent.Builder createCustomTabsIntentBuilder(Uri... possibleUris) {
        checkNotDisposed();
        return this.mCustomTabManager.createTabBuilder(possibleUris);
    }

    public void performAuthorizationRequest(AuthorizationRequest request, PendingIntent completedIntent) {
        performAuthorizationRequest(request, completedIntent, null, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performAuthorizationRequest(AuthorizationRequest request, PendingIntent completedIntent, PendingIntent canceledIntent) {
        performAuthorizationRequest(request, completedIntent, canceledIntent, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performAuthorizationRequest(AuthorizationRequest request, PendingIntent completedIntent, CustomTabsIntent customTabsIntent) {
        performAuthorizationRequest(request, completedIntent, null, customTabsIntent);
    }

    public void performAuthorizationRequest(AuthorizationRequest request, PendingIntent completedIntent, PendingIntent canceledIntent, CustomTabsIntent customTabsIntent) {
        performAuthManagementRequest(request, completedIntent, canceledIntent, customTabsIntent);
    }

    public void performEndSessionRequest(EndSessionRequest request, PendingIntent completedIntent) {
        performEndSessionRequest(request, completedIntent, null, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performEndSessionRequest(EndSessionRequest request, PendingIntent completedIntent, PendingIntent canceledIntent) {
        performEndSessionRequest(request, completedIntent, canceledIntent, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performEndSessionRequest(EndSessionRequest request, PendingIntent completedIntent, CustomTabsIntent customTabsIntent) {
        performEndSessionRequest(request, completedIntent, null, customTabsIntent);
    }

    public void performEndSessionRequest(EndSessionRequest request, PendingIntent completedIntent, PendingIntent canceledIntent, CustomTabsIntent customTabsIntent) {
        performAuthManagementRequest(request, completedIntent, canceledIntent, customTabsIntent);
    }

    private void performAuthManagementRequest(AuthorizationManagementRequest request, PendingIntent completedIntent, PendingIntent canceledIntent, CustomTabsIntent customTabsIntent) {
        checkNotDisposed();
        Preconditions.checkNotNull(request);
        Preconditions.checkNotNull(completedIntent);
        Preconditions.checkNotNull(customTabsIntent);
        Intent intentCreateStartIntent = AuthorizationManagementActivity.createStartIntent(this.mContext, request, prepareAuthorizationRequestIntent(request, customTabsIntent), completedIntent, canceledIntent);
        if (!isActivity(this.mContext)) {
            intentCreateStartIntent.addFlags(268435456);
        }
        this.mContext.startActivity(intentCreateStartIntent);
    }

    private boolean isActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return true;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return false;
    }

    public Intent getAuthorizationRequestIntent(AuthorizationRequest request, CustomTabsIntent customTabsIntent) {
        return AuthorizationManagementActivity.createStartForResultIntent(this.mContext, request, prepareAuthorizationRequestIntent(request, customTabsIntent));
    }

    public Intent getAuthorizationRequestIntent(AuthorizationRequest request) {
        return getAuthorizationRequestIntent(request, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public Intent getEndSessionRequestIntent(EndSessionRequest request, CustomTabsIntent customTabsIntent) {
        return AuthorizationManagementActivity.createStartForResultIntent(this.mContext, request, prepareAuthorizationRequestIntent(request, customTabsIntent));
    }

    public Intent getEndSessionRequestIntent(EndSessionRequest request) {
        return getEndSessionRequestIntent(request, createCustomTabsIntentBuilder(new Uri[0]).build());
    }

    public void performTokenRequest(TokenRequest request, TokenResponseCallback callback) {
        performTokenRequest(request, NoClientAuthentication.INSTANCE, callback);
    }

    public void performTokenRequest(TokenRequest request, ClientAuthentication clientAuthentication, TokenResponseCallback callback) {
        checkNotDisposed();
        Logger.debug("Initiating code exchange request to %s", request.configuration.tokenEndpoint);
        new TokenRequestTask(request, clientAuthentication, this.mClientConfiguration.getConnectionBuilder(), SystemClock.INSTANCE, callback, Boolean.valueOf(this.mClientConfiguration.getSkipIssuerHttpsCheck())).execute(new Void[0]);
    }

    public void performRegistrationRequest(RegistrationRequest request, RegistrationResponseCallback callback) {
        checkNotDisposed();
        Logger.debug("Initiating dynamic client registration %s", request.configuration.registrationEndpoint.toString());
        new RegistrationRequestTask(request, this.mClientConfiguration.getConnectionBuilder(), callback).execute(new Void[0]);
    }

    public void dispose() {
        if (this.mDisposed) {
            return;
        }
        this.mCustomTabManager.dispose();
        this.mDisposed = true;
    }

    private void checkNotDisposed() {
        if (this.mDisposed) {
            throw new IllegalStateException("Service has been disposed and rendered inoperable");
        }
    }

    private Intent prepareAuthorizationRequestIntent(AuthorizationManagementRequest request, CustomTabsIntent customTabsIntent) {
        Intent intent;
        checkNotDisposed();
        if (this.mBrowser == null) {
            throw new ActivityNotFoundException();
        }
        Uri uri = request.toUri();
        if (this.mBrowser.useCustomTab.booleanValue()) {
            intent = customTabsIntent.intent;
        } else {
            intent = new Intent("android.intent.action.VIEW");
        }
        intent.setPackage(this.mBrowser.packageName);
        intent.setData(uri);
        Logger.debug("Using %s as browser for auth, custom tab = %s", intent.getPackage(), this.mBrowser.useCustomTab.toString());
        return intent;
    }

    private static class TokenRequestTask extends AsyncTask<Void, Void, JSONObject> {
        private TokenResponseCallback mCallback;
        private ClientAuthentication mClientAuthentication;
        private Clock mClock;
        private final ConnectionBuilder mConnectionBuilder;
        private AuthorizationException mException;
        private TokenRequest mRequest;
        private boolean mSkipIssuerHttpsCheck;

        TokenRequestTask(TokenRequest request, ClientAuthentication clientAuthentication, ConnectionBuilder connectionBuilder, Clock clock, TokenResponseCallback callback, Boolean skipIssuerHttpsCheck) {
            this.mRequest = request;
            this.mClientAuthentication = clientAuthentication;
            this.mConnectionBuilder = connectionBuilder;
            this.mClock = clock;
            this.mCallback = callback;
            this.mSkipIssuerHttpsCheck = skipIssuerHttpsCheck.booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Undo finally extract visitor
        java.lang.NullPointerException
         */
        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Void... voids) throws Throwable {
            InputStream inputStream;
            InputStream errorStream;
            InputStream inputStream2 = null;
            try {
                try {
                    HttpURLConnection httpURLConnectionOpenConnection = this.mConnectionBuilder.openConnection(this.mRequest.configuration.tokenEndpoint);
                    httpURLConnectionOpenConnection.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    addJsonToAcceptHeader(httpURLConnectionOpenConnection);
                    httpURLConnectionOpenConnection.setDoOutput(true);
                    Map<String, String> requestHeaders = this.mClientAuthentication.getRequestHeaders(this.mRequest.clientId);
                    if (requestHeaders != null) {
                        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                            httpURLConnectionOpenConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    Map<String, String> requestParameters = this.mRequest.getRequestParameters();
                    Map<String, String> requestParameters2 = this.mClientAuthentication.getRequestParameters(this.mRequest.clientId);
                    if (requestParameters2 != null) {
                        requestParameters.putAll(requestParameters2);
                    }
                    String strFormUrlEncode = UriUtil.formUrlEncode(requestParameters);
                    httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(strFormUrlEncode.length()));
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnectionOpenConnection.getOutputStream());
                    outputStreamWriter.write(strFormUrlEncode);
                    outputStreamWriter.flush();
                    if (httpURLConnectionOpenConnection.getResponseCode() >= 200 && httpURLConnectionOpenConnection.getResponseCode() < 300) {
                        errorStream = httpURLConnectionOpenConnection.getInputStream();
                    } else {
                        errorStream = httpURLConnectionOpenConnection.getErrorStream();
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                }
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (JSONException e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                JSONObject jSONObject = new JSONObject(Utils.readInputStream(errorStream));
                Utils.closeQuietly(errorStream);
                return jSONObject;
            } catch (IOException e3) {
                inputStream = errorStream;
                e = e3;
                Logger.debugWithStack(e, "Failed to complete exchange request", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e);
                Utils.closeQuietly(inputStream);
                return null;
            } catch (JSONException e4) {
                inputStream = errorStream;
                e = e4;
                Logger.debugWithStack(e, "Failed to complete exchange request", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                Utils.closeQuietly(inputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = errorStream;
                Utils.closeQuietly(inputStream2);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(JSONObject json) {
            AuthorizationException authorizationExceptionFromTemplate;
            AuthorizationException authorizationException = this.mException;
            if (authorizationException != null) {
                this.mCallback.onTokenRequestCompleted(null, authorizationException);
                return;
            }
            if (json.has("error")) {
                try {
                    String string = json.getString("error");
                    authorizationExceptionFromTemplate = AuthorizationException.fromOAuthTemplate(AuthorizationException.TokenRequestErrors.byString(string), string, json.optString(AuthorizationException.PARAM_ERROR_DESCRIPTION, null), UriUtil.parseUriIfAvailable(json.optString(AuthorizationException.PARAM_ERROR_URI)));
                } catch (JSONException e) {
                    authorizationExceptionFromTemplate = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                }
                this.mCallback.onTokenRequestCompleted(null, authorizationExceptionFromTemplate);
                return;
            }
            try {
                TokenResponse tokenResponseBuild = new TokenResponse.Builder(this.mRequest).fromResponseJson(json).build();
                if (tokenResponseBuild.idToken != null) {
                    try {
                        try {
                            IdToken.from(tokenResponseBuild.idToken).validate(this.mRequest, this.mClock, this.mSkipIssuerHttpsCheck);
                        } catch (AuthorizationException e2) {
                            this.mCallback.onTokenRequestCompleted(null, e2);
                            return;
                        }
                    } catch (IdToken.IdTokenException | JSONException e3) {
                        this.mCallback.onTokenRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.ID_TOKEN_PARSING_ERROR, e3));
                        return;
                    }
                }
                Logger.debug("Token exchange with %s completed", this.mRequest.configuration.tokenEndpoint);
                this.mCallback.onTokenRequestCompleted(tokenResponseBuild, null);
            } catch (JSONException e4) {
                this.mCallback.onTokenRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e4));
            }
        }

        private void addJsonToAcceptHeader(URLConnection conn) {
            if (TextUtils.isEmpty(conn.getRequestProperty(HttpHeaders.ACCEPT))) {
                conn.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            }
        }
    }

    private static class RegistrationRequestTask extends AsyncTask<Void, Void, JSONObject> {
        private RegistrationResponseCallback mCallback;
        private final ConnectionBuilder mConnectionBuilder;
        private AuthorizationException mException;
        private RegistrationRequest mRequest;

        RegistrationRequestTask(RegistrationRequest request, ConnectionBuilder connectionBuilder, RegistrationResponseCallback callback) {
            this.mRequest = request;
            this.mConnectionBuilder = connectionBuilder;
            this.mCallback = callback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r2v2 */
        @Override // android.os.AsyncTask
        public JSONObject doInBackground(Void... voids) throws Throwable {
            InputStream inputStream;
            String jsonString = this.mRequest.toJsonString();
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnectionOpenConnection = this.mConnectionBuilder.openConnection(this.mRequest.configuration.registrationEndpoint);
                    httpURLConnectionOpenConnection.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                    httpURLConnectionOpenConnection.setDoOutput(true);
                    httpURLConnectionOpenConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(jsonString.length()));
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnectionOpenConnection.getOutputStream());
                    outputStreamWriter.write(jsonString);
                    outputStreamWriter.flush();
                    inputStream = httpURLConnectionOpenConnection.getInputStream();
                    try {
                        JSONObject jSONObject = new JSONObject(Utils.readInputStream(inputStream));
                        Utils.closeQuietly(inputStream);
                        return jSONObject;
                    } catch (IOException e) {
                        e = e;
                        Logger.debugWithStack(e, "Failed to complete registration request", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.NETWORK_ERROR, e);
                        Utils.closeQuietly(inputStream);
                        return null;
                    } catch (JSONException e2) {
                        e = e2;
                        Logger.debugWithStack(e, "Failed to complete registration request", new Object[0]);
                        this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                        Utils.closeQuietly(inputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = jsonString;
                    Utils.closeQuietly(r2);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (JSONException e4) {
                e = e4;
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                Utils.closeQuietly(r2);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(JSONObject json) {
            AuthorizationException authorizationExceptionFromTemplate;
            AuthorizationException authorizationException = this.mException;
            if (authorizationException != null) {
                this.mCallback.onRegistrationRequestCompleted(null, authorizationException);
                return;
            }
            if (json.has("error")) {
                try {
                    String string = json.getString("error");
                    authorizationExceptionFromTemplate = AuthorizationException.fromOAuthTemplate(AuthorizationException.RegistrationRequestErrors.byString(string), string, json.getString(AuthorizationException.PARAM_ERROR_DESCRIPTION), UriUtil.parseUriIfAvailable(json.getString(AuthorizationException.PARAM_ERROR_URI)));
                } catch (JSONException e) {
                    authorizationExceptionFromTemplate = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e);
                }
                this.mCallback.onRegistrationRequestCompleted(null, authorizationExceptionFromTemplate);
                return;
            }
            try {
                RegistrationResponse registrationResponseBuild = new RegistrationResponse.Builder(this.mRequest).fromResponseJson(json).build();
                Logger.debug("Dynamic registration with %s completed", this.mRequest.configuration.registrationEndpoint);
                this.mCallback.onRegistrationRequestCompleted(registrationResponseBuild, null);
            } catch (RegistrationResponse.MissingArgumentException e2) {
                Logger.errorWithStack(e2, "Malformed registration response", new Object[0]);
                this.mException = AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.INVALID_REGISTRATION_RESPONSE, e2);
            } catch (JSONException e3) {
                this.mCallback.onRegistrationRequestCompleted(null, AuthorizationException.fromTemplate(AuthorizationException.GeneralErrors.JSON_DESERIALIZATION_ERROR, e3));
            }
        }
    }
}
