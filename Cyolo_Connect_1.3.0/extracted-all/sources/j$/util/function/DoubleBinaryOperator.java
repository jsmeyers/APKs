package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleBinaryOperator {

    public final /* synthetic */ class VivifiedWrapper implements DoubleBinaryOperator {
        public final /* synthetic */ java.util.function.DoubleBinaryOperator wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            this.wrappedValue = doubleBinaryOperator;
        }

        public static /* synthetic */ DoubleBinaryOperator convert(java.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            if (doubleBinaryOperator == null) {
                return null;
            }
            return new VivifiedWrapper(doubleBinaryOperator);
        }

        @Override // j$.util.function.DoubleBinaryOperator
        public /* synthetic */ double applyAsDouble(double d, double d2) {
            return this.wrappedValue.applyAsDouble(d, d2);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.DoubleBinaryOperator doubleBinaryOperator = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return doubleBinaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    double applyAsDouble(double d, double d2);
}
