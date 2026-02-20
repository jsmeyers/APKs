package androidx.test.espresso.core.internal.deps.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseStub extends Binder implements IInterface {
    private static TransactionInterceptor globalInterceptor;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    protected boolean dispatchTransaction(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return false;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    static synchronized void installTransactionInterceptorPackagePrivate(TransactionInterceptor interceptor) {
        try {
            if (interceptor == null) {
                throw new IllegalArgumentException("null interceptor");
            }
            if (globalInterceptor != null) {
                throw new IllegalStateException("Duplicate TransactionInterceptor installation.");
            }
            globalInterceptor = interceptor;
        } catch (Throwable th) {
            throw th;
        }
    }

    protected BaseStub(String descriptor) {
        attachInterface(this, descriptor);
    }

    protected boolean routeToSuperOrEnforceInterface(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if (code > 16777215) {
            return super.onTransact(code, data, reply, flags);
        }
        data.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if (routeToSuperOrEnforceInterface(code, data, reply, flags)) {
            return true;
        }
        TransactionInterceptor transactionInterceptor = globalInterceptor;
        if (transactionInterceptor == null) {
            return dispatchTransaction(code, data, reply, flags);
        }
        return transactionInterceptor.interceptTransaction(this, code, data, reply, flags);
    }
}
