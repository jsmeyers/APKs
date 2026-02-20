package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleToLongFunction {

    public final /* synthetic */ class VivifiedWrapper implements DoubleToLongFunction {
        public final /* synthetic */ java.util.function.DoubleToLongFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleToLongFunction doubleToLongFunction) {
            this.wrappedValue = doubleToLongFunction;
        }

        public static /* synthetic */ DoubleToLongFunction convert(java.util.function.DoubleToLongFunction doubleToLongFunction) {
            if (doubleToLongFunction == null) {
                return null;
            }
            return new VivifiedWrapper(doubleToLongFunction);
        }

        @Override // j$.util.function.DoubleToLongFunction
        public /* synthetic */ long applyAsLong(double d) {
            return this.wrappedValue.applyAsLong(d);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.DoubleToLongFunction doubleToLongFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return doubleToLongFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    long applyAsLong(double d);
}
