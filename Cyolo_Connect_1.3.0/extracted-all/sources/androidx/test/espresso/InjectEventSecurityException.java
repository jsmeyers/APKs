package androidx.test.espresso;

import androidx.test.internal.platform.util.TestOutputEmitter;

/* JADX INFO: loaded from: classes.dex */
public final class InjectEventSecurityException extends androidx.test.platform.ui.InjectEventSecurityException implements EspressoException {
    public InjectEventSecurityException(String message) {
        super(message);
        dumpThreads();
    }

    public InjectEventSecurityException(Throwable cause) {
        super(cause);
        dumpThreads();
    }

    public InjectEventSecurityException(String message, Throwable cause) {
        super(message, cause);
        dumpThreads();
    }

    private void dumpThreads() {
        TestOutputEmitter.dumpThreadStates("ThreadState-InjectEventSecurityException.txt");
    }
}
