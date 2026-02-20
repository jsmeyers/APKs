package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface ToLongFunction<T> {

    public final /* synthetic */ class VivifiedWrapper implements ToLongFunction {
        public final /* synthetic */ java.util.function.ToLongFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToLongFunction toLongFunction) {
            this.wrappedValue = toLongFunction;
        }

        public static /* synthetic */ ToLongFunction convert(java.util.function.ToLongFunction toLongFunction) {
            if (toLongFunction == null) {
                return null;
            }
            return new VivifiedWrapper(toLongFunction);
        }

        @Override // j$.util.function.ToLongFunction
        public /* synthetic */ long applyAsLong(Object obj) {
            return this.wrappedValue.applyAsLong(obj);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.ToLongFunction toLongFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return toLongFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    long applyAsLong(Object obj);
}
