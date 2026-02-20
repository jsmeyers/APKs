package androidx.test.espresso;

/* JADX INFO: loaded from: classes.dex */
public final class NoActivityResumedException extends RuntimeException implements EspressoException {
    public NoActivityResumedException(String description) {
        super(description);
    }

    public NoActivityResumedException(String description, Throwable cause) {
        super(description, cause);
    }
}
