package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class InvalidTypeException extends IllegalArgumentException {
    public InvalidTypeException(int i) {
        super("Invalid DNS type: " + i);
    }
}
