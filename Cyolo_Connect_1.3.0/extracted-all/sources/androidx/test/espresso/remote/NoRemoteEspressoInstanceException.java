package androidx.test.espresso.remote;

import androidx.test.espresso.EspressoException;

/* JADX INFO: loaded from: classes.dex */
public final class NoRemoteEspressoInstanceException extends RuntimeException implements EspressoException {
    public NoRemoteEspressoInstanceException(String description) {
        super(description);
    }
}
