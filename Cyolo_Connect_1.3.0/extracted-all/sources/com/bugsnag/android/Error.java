package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Error implements JsonStream.Streamable {
    private final ErrorInternal impl;
    private final Logger logger;

    Error(ErrorInternal errorInternal, Logger logger) {
        this.impl = errorInternal;
        this.logger = logger;
    }

    private void logNull(String str) {
        this.logger.e("Invalid null value supplied to error." + str + ", ignoring");
    }

    public void setErrorClass(String str) {
        if (str != null) {
            this.impl.setErrorClass(str);
        } else {
            logNull("errorClass");
        }
    }

    public String getErrorClass() {
        return this.impl.getErrorClass();
    }

    public void setErrorMessage(String str) {
        this.impl.setErrorMessage(str);
    }

    public String getErrorMessage() {
        return this.impl.getErrorMessage();
    }

    public void setType(ErrorType errorType) {
        if (errorType != null) {
            this.impl.setType(errorType);
        } else {
            logNull("type");
        }
    }

    public ErrorType getType() {
        return this.impl.getType();
    }

    public List<Stackframe> getStacktrace() {
        return this.impl.getStacktrace();
    }

    public Stackframe addStackframe(String str, String str2, long j) {
        return this.impl.addStackframe(str, str2, j);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        this.impl.toStream(jsonStream);
    }

    static List<Error> createError(Throwable th, Collection<String> collection, Logger logger) {
        return ErrorInternal.INSTANCE.createError(th, collection, logger);
    }
}
