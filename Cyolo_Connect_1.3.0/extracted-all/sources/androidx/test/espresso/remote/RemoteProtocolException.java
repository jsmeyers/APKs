package androidx.test.espresso.remote;

import androidx.test.espresso.EspressoException;

/* JADX INFO: loaded from: classes.dex */
public class RemoteProtocolException extends RuntimeException implements EspressoException {
    public RemoteProtocolException(String description) {
        super(description);
    }

    public RemoteProtocolException(String description, Throwable cause) {
        super(description, cause);
    }
}
