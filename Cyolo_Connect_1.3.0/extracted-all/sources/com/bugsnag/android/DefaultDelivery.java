package com.bugsnag.android;

import android.net.TrafficStats;
import androidx.core.app.NotificationCompat;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.internal.JsonHelper;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.text.Charsets;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: compiled from: DefaultDelivery.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\fH\u0016J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0002J8\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0014H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bugsnag/android/DefaultDelivery;", "Lcom/bugsnag/android/Delivery;", "connectivity", "Lcom/bugsnag/android/Connectivity;", "logger", "Lcom/bugsnag/android/Logger;", "(Lcom/bugsnag/android/Connectivity;Lcom/bugsnag/android/Logger;)V", "deliver", "Lcom/bugsnag/android/DeliveryStatus;", "payload", "Lcom/bugsnag/android/EventPayload;", "deliveryParams", "Lcom/bugsnag/android/DeliveryParams;", "Lcom/bugsnag/android/Session;", "urlString", "", "json", "", "integrity", "headers", "", "logRequestInfo", "", ResponseTypeValues.CODE, "", "conn", "Ljava/net/HttpURLConnection;", NotificationCompat.CATEGORY_STATUS, "makeRequest", ImagesContract.URL, "Ljava/net/URL;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultDelivery implements Delivery {
    private final Connectivity connectivity;
    private final Logger logger;

    public DefaultDelivery(Connectivity connectivity, Logger logger) {
        this.connectivity = connectivity;
        this.logger = logger;
    }

    @Override // com.bugsnag.android.Delivery
    public DeliveryStatus deliver(Session payload, DeliveryParams deliveryParams) {
        DeliveryStatus deliveryStatusDeliver = deliver(deliveryParams.getEndpoint(), JsonHelper.INSTANCE.serialize((JsonStream.Streamable) payload), payload.getIntegrityToken(), deliveryParams.getHeaders());
        this.logger.i(kotlin.jvm.internal.Intrinsics.stringPlus("Session API request finished with status ", deliveryStatusDeliver));
        return deliveryStatusDeliver;
    }

    @Override // com.bugsnag.android.Delivery
    public DeliveryStatus deliver(EventPayload payload, DeliveryParams deliveryParams) throws IOException {
        DeliveryStatus deliveryStatusDeliver = deliver(deliveryParams.getEndpoint(), EventPayload.trimToSize$default(payload, 0, 1, null).toByteArray(), payload.getIntegrityToken(), deliveryParams.getHeaders());
        this.logger.i(kotlin.jvm.internal.Intrinsics.stringPlus("Error API request finished with status ", deliveryStatusDeliver));
        return deliveryStatusDeliver;
    }

    public final DeliveryStatus deliver(String urlString, byte[] json, String integrity, Map<String, String> headers) {
        TrafficStats.setThreadStatsTag(1);
        Connectivity connectivity = this.connectivity;
        if (connectivity != null && !connectivity.hasNetworkConnection()) {
            return DeliveryStatus.UNDELIVERED;
        }
        HttpURLConnection httpURLConnectionMakeRequest = null;
        try {
            httpURLConnectionMakeRequest = makeRequest(new URL(urlString), json, integrity, headers);
            int responseCode = httpURLConnectionMakeRequest.getResponseCode();
            DeliveryStatus deliveryStatusForHttpResponseCode = DeliveryStatus.INSTANCE.forHttpResponseCode(responseCode);
            logRequestInfo(responseCode, httpURLConnectionMakeRequest, deliveryStatusForHttpResponseCode);
            return deliveryStatusForHttpResponseCode;
        } catch (IOException e) {
            this.logger.w("IOException encountered in request", e);
            return DeliveryStatus.UNDELIVERED;
        } catch (Exception e2) {
            this.logger.w("Unexpected error delivering payload", e2);
            return DeliveryStatus.FAILURE;
        } catch (OutOfMemoryError e3) {
            this.logger.w("Encountered OOM delivering payload, falling back to persist on disk", e3);
            return DeliveryStatus.UNDELIVERED;
        } finally {
            if (httpURLConnectionMakeRequest != null) {
                httpURLConnectionMakeRequest.disconnect();
            }
        }
    }

    private final HttpURLConnection makeRequest(URL url, byte[] json, String integrity, Map<String, String> headers) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (uRLConnectionOpenConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setFixedLengthStreamingMode(json.length);
        if (integrity != null) {
            httpURLConnection.addRequestProperty(DeliveryHeadersKt.HEADER_BUGSNAG_INTEGRITY, integrity);
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                httpURLConnection.addRequestProperty(key, value);
            }
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            outputStream.write(json);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
            return httpURLConnection;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(outputStream, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
    	at java.base/java.util.Objects.requireNonNull(Objects.java:233)
    	at java.base/java.util.ArrayList.batchRemove(ArrayList.java:898)
    	at java.base/java.util.ArrayList.removeAll(ArrayList.java:873)
    	at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(TryCatchEdgeBlockMap.java:91)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:204)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    private final void logRequestInfo(int code, HttpURLConnection conn, DeliveryStatus status) {
        try {
            Result.Companion companion = Result.INSTANCE;
            DefaultDelivery defaultDelivery = this;
            this.logger.i("Request completed with code " + code + ", message: " + ((Object) conn.getResponseMessage()) + ", headers: " + conn.getHeaderFields());
            Result.m442constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m442constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            DefaultDelivery defaultDelivery2 = this;
            Reader inputStreamReader = new InputStreamReader(conn.getInputStream(), Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                this.logger.d(kotlin.jvm.internal.Intrinsics.stringPlus("Received request response: ", TextStreamsKt.readText(bufferedReader)));
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader, null);
                Result.m442constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(bufferedReader, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m442constructorimpl(ResultKt.createFailure(th4));
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            DefaultDelivery defaultDelivery3 = this;
            if (status != DeliveryStatus.DELIVERED) {
                Reader inputStreamReader2 = new InputStreamReader(conn.getErrorStream(), Charsets.UTF_8);
                BufferedReader bufferedReader2 = inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192);
                try {
                    this.logger.w(kotlin.jvm.internal.Intrinsics.stringPlus("Request error details: ", TextStreamsKt.readText(bufferedReader2)));
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader2, null);
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        CloseableKt.closeFinally(bufferedReader2, th5);
                        throw th6;
                    }
                }
            }
            Result.m442constructorimpl(Unit.INSTANCE);
        } catch (Throwable th7) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.m442constructorimpl(ResultKt.createFailure(th7));
        }
    }
}
