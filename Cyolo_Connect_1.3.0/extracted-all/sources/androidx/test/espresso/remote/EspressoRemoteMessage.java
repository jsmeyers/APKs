package androidx.test.espresso.remote;

/* JADX INFO: loaded from: classes.dex */
public interface EspressoRemoteMessage {

    public interface From<T, M> {
        T fromProto(M message);
    }

    public interface To<M> {
        M toProto();
    }
}
