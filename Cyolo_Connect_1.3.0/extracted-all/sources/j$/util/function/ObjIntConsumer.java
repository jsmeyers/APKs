package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface ObjIntConsumer {

    public final /* synthetic */ class VivifiedWrapper implements ObjIntConsumer {
        public final /* synthetic */ java.util.function.ObjIntConsumer wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.ObjIntConsumer objIntConsumer) {
            this.wrappedValue = objIntConsumer;
        }

        public static /* synthetic */ ObjIntConsumer convert(java.util.function.ObjIntConsumer objIntConsumer) {
            if (objIntConsumer == null) {
                return null;
            }
            return new VivifiedWrapper(objIntConsumer);
        }

        @Override // j$.util.function.ObjIntConsumer
        public /* synthetic */ void accept(Object obj, int i) {
            this.wrappedValue.accept(obj, i);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.ObjIntConsumer objIntConsumer = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return objIntConsumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    void accept(Object obj, int i);
}
