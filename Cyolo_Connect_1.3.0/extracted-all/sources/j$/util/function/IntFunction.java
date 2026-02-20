package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface IntFunction<R> {

    public final /* synthetic */ class VivifiedWrapper implements IntFunction {
        public final /* synthetic */ java.util.function.IntFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntFunction intFunction) {
            this.wrappedValue = intFunction;
        }

        public static /* synthetic */ IntFunction convert(java.util.function.IntFunction intFunction) {
            if (intFunction == null) {
                return null;
            }
            return intFunction instanceof Wrapper ? IntFunction.this : new VivifiedWrapper(intFunction);
        }

        @Override // j$.util.function.IntFunction
        public /* synthetic */ Object apply(int i) {
            return this.wrappedValue.apply(i);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.IntFunction intFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return intFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.IntFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntFunction convert(IntFunction intFunction) {
            if (intFunction == null) {
                return null;
            }
            return intFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) intFunction).wrappedValue : new Wrapper();
        }

        @Override // java.util.function.IntFunction
        public /* synthetic */ Object apply(int i) {
            return IntFunction.this.apply(i);
        }

        public /* synthetic */ boolean equals(Object obj) {
            IntFunction intFunction = IntFunction.this;
            if (obj instanceof Wrapper) {
                obj = IntFunction.this;
            }
            return intFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return IntFunction.this.hashCode();
        }
    }

    R apply(int i);
}
