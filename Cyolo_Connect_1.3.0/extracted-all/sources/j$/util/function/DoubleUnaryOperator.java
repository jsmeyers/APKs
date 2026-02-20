package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleUnaryOperator {

    public final /* synthetic */ class VivifiedWrapper implements DoubleUnaryOperator {
        public final /* synthetic */ java.util.function.DoubleUnaryOperator wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleUnaryOperator doubleUnaryOperator) {
            this.wrappedValue = doubleUnaryOperator;
        }

        public static /* synthetic */ DoubleUnaryOperator convert(java.util.function.DoubleUnaryOperator doubleUnaryOperator) {
            if (doubleUnaryOperator == null) {
                return null;
            }
            return new VivifiedWrapper(doubleUnaryOperator);
        }

        @Override // j$.util.function.DoubleUnaryOperator
        public /* synthetic */ double applyAsDouble(double d) {
            return this.wrappedValue.applyAsDouble(d);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.DoubleUnaryOperator doubleUnaryOperator = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return doubleUnaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    double applyAsDouble(double d);
}
