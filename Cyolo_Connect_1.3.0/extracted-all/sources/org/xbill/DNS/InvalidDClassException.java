package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class InvalidDClassException extends IllegalArgumentException {
    public InvalidDClassException(int i) {
        super("Invalid DNS class: " + i);
    }
}
