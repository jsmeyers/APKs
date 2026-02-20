package org.xbill.DNS.lookup;

/* JADX INFO: loaded from: classes2.dex */
public class RedirectOverflowException extends LookupFailedException {
    private final int maxRedirects;

    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    @Deprecated
    public RedirectOverflowException(String str) {
        super(str);
        this.maxRedirects = 0;
    }

    public RedirectOverflowException(int i) {
        super("Refusing to follow more than " + i + " redirects");
        this.maxRedirects = i;
    }
}
