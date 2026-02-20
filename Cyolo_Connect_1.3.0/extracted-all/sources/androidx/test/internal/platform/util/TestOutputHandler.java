package androidx.test.internal.platform.util;

/* JADX INFO: loaded from: classes.dex */
public interface TestOutputHandler {
    boolean captureWindowHierarchy(String outputName);

    void dumpThreadStates(String outputName);

    boolean takeScreenshot(String outputName);
}
