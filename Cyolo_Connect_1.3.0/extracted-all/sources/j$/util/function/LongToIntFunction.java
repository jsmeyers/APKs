package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface LongToIntFunction {

    public final /* synthetic */ class VivifiedWrapper implements LongToIntFunction {
        public final /* synthetic */ java.util.function.LongToIntFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongToIntFunction longToIntFunction) {
            this.wrappedValue = longToIntFunction;
        }

        public static /* synthetic */ LongToIntFunction convert(java.util.function.LongToIntFunction longToIntFunction) {
            if (longToIntFunction == null) {
                return null;
            }
            return new VivifiedWrapper(longToIntFunction);
        }

        @Override // j$.util.function.LongToIntFunction
        public /* synthetic */ int applyAsInt(long j) {
            return this.wrappedValue.applyAsInt(j);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.LongToIntFunction longToIntFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return longToIntFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    int applyAsInt(long j);
}
