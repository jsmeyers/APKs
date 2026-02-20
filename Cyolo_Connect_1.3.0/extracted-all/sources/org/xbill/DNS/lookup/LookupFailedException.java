package org.xbill.DNS.lookup;

import org.xbill.DNS.Name;

/* JADX INFO: loaded from: classes2.dex */
public class LookupFailedException extends RuntimeException {
    private final Name name;
    private final int type;

    public LookupFailedException() {
        this((String) null, (Throwable) null);
    }

    public LookupFailedException(String str) {
        this(str, (Throwable) null);
    }

    LookupFailedException(String str, Throwable th) {
        super(str, th);
        this.name = null;
        this.type = 0;
    }

    public LookupFailedException(Name name, int i) {
        this.name = name;
        this.type = i;
    }

    public Name getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }
}
