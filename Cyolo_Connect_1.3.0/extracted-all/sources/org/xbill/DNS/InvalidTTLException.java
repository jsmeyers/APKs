package org.xbill.DNS;

/* JADX INFO: loaded from: classes2.dex */
public class InvalidTTLException extends IllegalArgumentException {
    public InvalidTTLException(long j) {
        super("Invalid DNS TTL: " + j);
    }
}
