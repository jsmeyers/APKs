package org.xbill.DNS.lookup;

/* JADX INFO: loaded from: classes2.dex */
public class InvalidZoneDataException extends LookupFailedException {
    InvalidZoneDataException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidZoneDataException(String str) {
        super(str);
    }
}
