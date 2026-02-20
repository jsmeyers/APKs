package androidx.test.runner.internal.deps.aidl;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface TransactionInterceptor {
    boolean interceptTransaction(BaseStub stub, int code, Parcel data, Parcel reply, int flags) throws RemoteException;
}
