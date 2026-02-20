package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface ToDoubleFunction<T> {

    public final /* synthetic */ class VivifiedWrapper implements ToDoubleFunction {
        public final /* synthetic */ java.util.function.ToDoubleFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToDoubleFunction toDoubleFunction) {
            this.wrappedValue = toDoubleFunction;
        }

        public static /* synthetic */ ToDoubleFunction convert(java.util.function.ToDoubleFunction toDoubleFunction) {
            if (toDoubleFunction == null) {
                return null;
            }
            return new VivifiedWrapper(toDoubleFunction);
        }

        @Override // j$.util.function.ToDoubleFunction
        public /* synthetic */ double applyAsDouble(Object obj) {
            return this.wrappedValue.applyAsDouble(obj);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.ToDoubleFunction toDoubleFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return toDoubleFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    double applyAsDouble(Object obj);
}
