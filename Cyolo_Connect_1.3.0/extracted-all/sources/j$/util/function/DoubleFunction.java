package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleFunction {

    public final /* synthetic */ class VivifiedWrapper implements DoubleFunction {
        public final /* synthetic */ java.util.function.DoubleFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleFunction doubleFunction) {
            this.wrappedValue = doubleFunction;
        }

        public static /* synthetic */ DoubleFunction convert(java.util.function.DoubleFunction doubleFunction) {
            if (doubleFunction == null) {
                return null;
            }
            return new VivifiedWrapper(doubleFunction);
        }

        @Override // j$.util.function.DoubleFunction
        public /* synthetic */ Object apply(double d) {
            return this.wrappedValue.apply(d);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.DoubleFunction doubleFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return doubleFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    Object apply(double d);
}
