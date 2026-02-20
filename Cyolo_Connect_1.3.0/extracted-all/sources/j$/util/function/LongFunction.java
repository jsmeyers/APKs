package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface LongFunction {

    public final /* synthetic */ class VivifiedWrapper implements LongFunction {
        public final /* synthetic */ java.util.function.LongFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongFunction longFunction) {
            this.wrappedValue = longFunction;
        }

        public static /* synthetic */ LongFunction convert(java.util.function.LongFunction longFunction) {
            if (longFunction == null) {
                return null;
            }
            return new VivifiedWrapper(longFunction);
        }

        @Override // j$.util.function.LongFunction
        public /* synthetic */ Object apply(long j) {
            return this.wrappedValue.apply(j);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.LongFunction longFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return longFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    Object apply(long j);
}
