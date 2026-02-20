package androidx.test.espresso.remote;

import androidx.test.espresso.EspressoException;

/* JADX INFO: loaded from: classes.dex */
public class RemoteEspressoException extends RuntimeException implements EspressoException {
    public RemoteEspressoException(String description) {
        super(description);
    }

    public RemoteEspressoException(String description, Throwable cause) {
        super(description, cause);
    }
}
