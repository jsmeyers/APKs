package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface ObjLongConsumer {

    public final /* synthetic */ class VivifiedWrapper implements ObjLongConsumer {
        public final /* synthetic */ java.util.function.ObjLongConsumer wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.ObjLongConsumer objLongConsumer) {
            this.wrappedValue = objLongConsumer;
        }

        public static /* synthetic */ ObjLongConsumer convert(java.util.function.ObjLongConsumer objLongConsumer) {
            if (objLongConsumer == null) {
                return null;
            }
            return new VivifiedWrapper(objLongConsumer);
        }

        @Override // j$.util.function.ObjLongConsumer
        public /* synthetic */ void accept(Object obj, long j) {
            this.wrappedValue.accept(obj, j);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.ObjLongConsumer objLongConsumer = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return objLongConsumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    void accept(Object obj, long j);
}
