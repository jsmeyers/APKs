package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface IntConsumer {

    public final /* synthetic */ class VivifiedWrapper implements IntConsumer {
        public final /* synthetic */ java.util.function.IntConsumer wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntConsumer intConsumer) {
            this.wrappedValue = intConsumer;
        }

        public static /* synthetic */ IntConsumer convert(java.util.function.IntConsumer intConsumer) {
            if (intConsumer == null) {
                return null;
            }
            return new VivifiedWrapper(intConsumer);
        }

        @Override // j$.util.function.IntConsumer
        public /* synthetic */ void accept(int i) {
            this.wrappedValue.accept(i);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.IntConsumer intConsumer = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return intConsumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    void accept(int i);
}
