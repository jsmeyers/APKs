package com.google.common.io;

import java.io.IOException;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    protected abstract void handleLine(String str, String str2) throws IOException;

    LineBuffer() {
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x001a  */
    protected void add(char[] cArr, int i, int i2) throws IOException {
        int i3;
        if (this.sawReturn && i2 > 0) {
            i3 = finishLine(cArr[i] == '\n') ? i + 1 : i;
        }
        int i4 = i + i2;
        int i5 = i3;
        while (i3 < i4) {
            char c = cArr[i3];
            if (c != '\n') {
                if (c == '\r') {
                    this.line.append(cArr, i5, i3 - i5);
                    this.sawReturn = true;
                    int i6 = i3 + 1;
                    if (i6 < i4) {
                        if (finishLine(cArr[i6] == '\n')) {
                            i3 = i6;
                        }
                    }
                }
                i3++;
            } else {
                this.line.append(cArr, i5, i3 - i5);
                finishLine(true);
            }
            i5 = i3 + 1;
            i3++;
        }
        this.line.append(cArr, i5, i4 - i5);
    }

    private boolean finishLine(boolean z) throws IOException {
        handleLine(this.line.toString(), this.sawReturn ? z ? IOUtils.LINE_SEPARATOR_WINDOWS : "\r" : z ? IOUtils.LINE_SEPARATOR_UNIX : "");
        this.line = new StringBuilder();
        this.sawReturn = false;
        return z;
    }

    protected void finish() throws IOException {
        if (this.sawReturn || this.line.length() > 0) {
            finishLine(false);
        }
    }
}
