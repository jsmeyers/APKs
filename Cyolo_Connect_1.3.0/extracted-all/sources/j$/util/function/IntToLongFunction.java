package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface IntToLongFunction {

    public final /* synthetic */ class VivifiedWrapper implements IntToLongFunction {
        public final /* synthetic */ java.util.function.IntToLongFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntToLongFunction intToLongFunction) {
            this.wrappedValue = intToLongFunction;
        }

        public static /* synthetic */ IntToLongFunction convert(java.util.function.IntToLongFunction intToLongFunction) {
            if (intToLongFunction == null) {
                return null;
            }
            return new VivifiedWrapper(intToLongFunction);
        }

        @Override // j$.util.function.IntToLongFunction
        public /* synthetic */ long applyAsLong(int i) {
            return this.wrappedValue.applyAsLong(i);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.IntToLongFunction intToLongFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return intToLongFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    long applyAsLong(int i);
}
