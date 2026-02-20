package org.apache.commons.io.input;

/* JADX INFO: loaded from: classes3.dex */
public class InfiniteCircularInputStream extends CircularInputStream {
    public InfiniteCircularInputStream(byte[] bArr) {
        super(bArr, -1L);
    }
}
