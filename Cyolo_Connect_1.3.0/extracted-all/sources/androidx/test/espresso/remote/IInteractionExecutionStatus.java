package androidx.test.espresso.remote;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.test.espresso.core.internal.deps.aidl.BaseProxy;
import androidx.test.espresso.core.internal.deps.aidl.BaseStub;
import androidx.test.espresso.core.internal.deps.aidl.Codecs;

/* JADX INFO: loaded from: classes.dex */
public interface IInteractionExecutionStatus extends IInterface {
    boolean canExecute() throws RemoteException;

    public static abstract class Stub extends BaseStub implements IInteractionExecutionStatus {
        private static final String DESCRIPTOR = "androidx.test.espresso.remote.IInteractionExecutionStatus";
        static final int TRANSACTION_canExecute = 1;

        public Stub() {
            super(DESCRIPTOR);
        }

        public static IInteractionExecutionStatus asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface instanceof IInteractionExecutionStatus) {
                return (IInteractionExecutionStatus) iInterfaceQueryLocalInterface;
            }
            return new Proxy(obj);
        }

        @Override // androidx.test.espresso.core.internal.deps.aidl.BaseStub
        protected boolean dispatchTransaction(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1) {
                return false;
            }
            boolean zCanExecute = canExecute();
            reply.writeNoException();
            Codecs.writeBoolean(reply, zCanExecute);
            return true;
        }

        public static class Proxy extends BaseProxy implements IInteractionExecutionStatus {
            Proxy(IBinder remote) {
                super(remote, Stub.DESCRIPTOR);
            }

            @Override // androidx.test.espresso.remote.IInteractionExecutionStatus
            public boolean canExecute() throws RemoteException {
                Parcel parcelTransactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                boolean zCreateBoolean = Codecs.createBoolean(parcelTransactAndReadException);
                parcelTransactAndReadException.recycle();
                return zCreateBoolean;
            }
        }
    }
}
