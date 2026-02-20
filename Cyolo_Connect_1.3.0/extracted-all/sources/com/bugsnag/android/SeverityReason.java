package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class SeverityReason implements JsonStream.Streamable {
    static final String REASON_ANR = "anrError";
    static final String REASON_CALLBACK_SPECIFIED = "userCallbackSetSeverity";
    static final String REASON_HANDLED_ERROR = "handledError";
    static final String REASON_HANDLED_EXCEPTION = "handledException";
    static final String REASON_LOG = "log";
    static final String REASON_PROMISE_REJECTION = "unhandledPromiseRejection";
    static final String REASON_SIGNAL = "signal";
    static final String REASON_STRICT_MODE = "strictMode";
    static final String REASON_UNHANDLED_EXCEPTION = "unhandledException";
    static final String REASON_USER_SPECIFIED = "userSpecifiedSeverity";
    private final String attributeKey;
    private final String attributeValue;
    private Severity currentSeverity;
    private final Severity defaultSeverity;
    final boolean originalUnhandled;
    private final String severityReasonType;
    private boolean unhandled;

    static SeverityReason newInstance(String str) {
        return newInstance(str, null, null);
    }

    static SeverityReason newInstance(String str, Severity severity, String str2) {
        if (str.equals(REASON_STRICT_MODE) && Intrinsics.isEmpty(str2)) {
            throw new IllegalArgumentException("No reason supplied for strictmode");
        }
        if (!str.equals(REASON_STRICT_MODE) && !str.equals(REASON_LOG) && !Intrinsics.isEmpty(str2)) {
            throw new IllegalArgumentException("attributeValue should not be supplied");
        }
        str.hashCode();
        switch (str) {
            case "strictMode":
                return new SeverityReason(str, Severity.WARNING, true, true, str2, "violationType");
            case "userCallbackSetSeverity":
            case "userSpecifiedSeverity":
                return new SeverityReason(str, severity, false, false, null, null);
            case "unhandledException":
            case "signal":
            case "anrError":
            case "unhandledPromiseRejection":
                return new SeverityReason(str, Severity.ERROR, true, true, null, null);
            case "handledError":
            case "handledException":
                return new SeverityReason(str, Severity.WARNING, false, false, null, null);
            case "log":
                return new SeverityReason(str, severity, false, false, str2, "level");
            default:
                throw new IllegalArgumentException("Invalid argument for severityReason: '" + str + '\'');
        }
    }

    SeverityReason(String str, Severity severity, boolean z, boolean z2, String str2, String str3) {
        this.severityReasonType = str;
        this.unhandled = z;
        this.originalUnhandled = z2;
        this.defaultSeverity = severity;
        this.currentSeverity = severity;
        this.attributeValue = str2;
        this.attributeKey = str3;
    }

    String calculateSeverityReasonType() {
        return this.defaultSeverity == this.currentSeverity ? this.severityReasonType : REASON_CALLBACK_SPECIFIED;
    }

    Severity getCurrentSeverity() {
        return this.currentSeverity;
    }

    boolean getUnhandled() {
        return this.unhandled;
    }

    void setUnhandled(boolean z) {
        this.unhandled = z;
    }

    boolean getUnhandledOverridden() {
        return this.unhandled != this.originalUnhandled;
    }

    boolean isOriginalUnhandled() {
        return this.originalUnhandled;
    }

    String getAttributeValue() {
        return this.attributeValue;
    }

    String getAttributeKey() {
        return this.attributeKey;
    }

    void setCurrentSeverity(Severity severity) {
        this.currentSeverity = severity;
    }

    String getSeverityReasonType() {
        return this.severityReasonType;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        jsonStream.beginObject().name("type").value(calculateSeverityReasonType()).name("unhandledOverridden").value(getUnhandledOverridden());
        if (this.attributeKey != null && this.attributeValue != null) {
            jsonStream.name("attributes").beginObject().name(this.attributeKey).value(this.attributeValue).endObject();
        }
        jsonStream.endObject();
    }
}
