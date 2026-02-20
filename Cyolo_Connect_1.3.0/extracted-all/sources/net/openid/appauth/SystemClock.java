package net.openid.appauth;

/* JADX INFO: loaded from: classes3.dex */
class SystemClock implements Clock {
    public static final SystemClock INSTANCE = new SystemClock();

    private SystemClock() {
    }

    @Override // net.openid.appauth.Clock
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
