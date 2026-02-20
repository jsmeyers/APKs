package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface IntToDoubleFunction {

    public final /* synthetic */ class VivifiedWrapper implements IntToDoubleFunction {
        public final /* synthetic */ java.util.function.IntToDoubleFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntToDoubleFunction intToDoubleFunction) {
            this.wrappedValue = intToDoubleFunction;
        }

        public static /* synthetic */ IntToDoubleFunction convert(java.util.function.IntToDoubleFunction intToDoubleFunction) {
            if (intToDoubleFunction == null) {
                return null;
            }
            return new VivifiedWrapper(intToDoubleFunction);
        }

        @Override // j$.util.function.IntToDoubleFunction
        public /* synthetic */ double applyAsDouble(int i) {
            return this.wrappedValue.applyAsDouble(i);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.IntToDoubleFunction intToDoubleFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return intToDoubleFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    double applyAsDouble(int i);
}
