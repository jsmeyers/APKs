package androidx.test.runner.screenshot;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface ScreenCaptureProcessor {
    String process(ScreenCapture capture) throws IOException;
}
