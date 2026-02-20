package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleConsumer {

    public final /* synthetic */ class VivifiedWrapper implements DoubleConsumer {
        public final /* synthetic */ java.util.function.DoubleConsumer wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleConsumer doubleConsumer) {
            this.wrappedValue = doubleConsumer;
        }

        public static /* synthetic */ DoubleConsumer convert(java.util.function.DoubleConsumer doubleConsumer) {
            if (doubleConsumer == null) {
                return null;
            }
            return new VivifiedWrapper(doubleConsumer);
        }

        @Override // j$.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            this.wrappedValue.accept(d);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.DoubleConsumer doubleConsumer = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return doubleConsumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    void accept(double d);
}
