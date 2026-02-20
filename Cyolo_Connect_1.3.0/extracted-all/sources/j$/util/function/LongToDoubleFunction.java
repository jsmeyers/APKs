package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface LongToDoubleFunction {

    public final /* synthetic */ class VivifiedWrapper implements LongToDoubleFunction {
        public final /* synthetic */ java.util.function.LongToDoubleFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongToDoubleFunction longToDoubleFunction) {
            this.wrappedValue = longToDoubleFunction;
        }

        public static /* synthetic */ LongToDoubleFunction convert(java.util.function.LongToDoubleFunction longToDoubleFunction) {
            if (longToDoubleFunction == null) {
                return null;
            }
            return new VivifiedWrapper(longToDoubleFunction);
        }

        @Override // j$.util.function.LongToDoubleFunction
        public /* synthetic */ double applyAsDouble(long j) {
            return this.wrappedValue.applyAsDouble(j);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.LongToDoubleFunction longToDoubleFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return longToDoubleFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    double applyAsDouble(long j);
}
