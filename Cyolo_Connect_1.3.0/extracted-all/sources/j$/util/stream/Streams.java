package j$.util.stream;

/* JADX INFO: loaded from: classes4.dex */
abstract class Streams {
    static final Object NONE = new Object();

    static Runnable composeWithExceptions(final Runnable runnable, final Runnable runnable2) {
        return new Runnable() { // from class: j$.util.stream.Streams.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                    runnable2.run();
                } catch (Throwable th) {
                    try {
                        runnable2.run();
                    } catch (Throwable th2) {
                        try {
                            th.addSuppressed(th2);
                        } catch (Throwable unused) {
                        }
                    }
                    throw th;
                }
            }
        };
    }
}
