package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface ObjDoubleConsumer {

    public final /* synthetic */ class VivifiedWrapper implements ObjDoubleConsumer {
        public final /* synthetic */ java.util.function.ObjDoubleConsumer wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.ObjDoubleConsumer objDoubleConsumer) {
            this.wrappedValue = objDoubleConsumer;
        }

        public static /* synthetic */ ObjDoubleConsumer convert(java.util.function.ObjDoubleConsumer objDoubleConsumer) {
            if (objDoubleConsumer == null) {
                return null;
            }
            return new VivifiedWrapper(objDoubleConsumer);
        }

        @Override // j$.util.function.ObjDoubleConsumer
        public /* synthetic */ void accept(Object obj, double d) {
            this.wrappedValue.accept(obj, d);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.ObjDoubleConsumer objDoubleConsumer = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return objDoubleConsumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    void accept(Object obj, double d);
}
