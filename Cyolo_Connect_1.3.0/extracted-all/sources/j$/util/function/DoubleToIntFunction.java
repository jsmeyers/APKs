package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleToIntFunction {

    public final /* synthetic */ class VivifiedWrapper implements DoubleToIntFunction {
        public final /* synthetic */ java.util.function.DoubleToIntFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleToIntFunction doubleToIntFunction) {
            this.wrappedValue = doubleToIntFunction;
        }

        public static /* synthetic */ DoubleToIntFunction convert(java.util.function.DoubleToIntFunction doubleToIntFunction) {
            if (doubleToIntFunction == null) {
                return null;
            }
            return new VivifiedWrapper(doubleToIntFunction);
        }

        @Override // j$.util.function.DoubleToIntFunction
        public /* synthetic */ int applyAsInt(double d) {
            return this.wrappedValue.applyAsInt(d);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.DoubleToIntFunction doubleToIntFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return doubleToIntFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    int applyAsInt(double d);
}
