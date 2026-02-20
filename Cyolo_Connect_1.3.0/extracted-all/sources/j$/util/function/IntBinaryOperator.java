package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface IntBinaryOperator {

    public final /* synthetic */ class VivifiedWrapper implements IntBinaryOperator {
        public final /* synthetic */ java.util.function.IntBinaryOperator wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntBinaryOperator intBinaryOperator) {
            this.wrappedValue = intBinaryOperator;
        }

        public static /* synthetic */ IntBinaryOperator convert(java.util.function.IntBinaryOperator intBinaryOperator) {
            if (intBinaryOperator == null) {
                return null;
            }
            return new VivifiedWrapper(intBinaryOperator);
        }

        @Override // j$.util.function.IntBinaryOperator
        public /* synthetic */ int applyAsInt(int i, int i2) {
            return this.wrappedValue.applyAsInt(i, i2);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.IntBinaryOperator intBinaryOperator = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return intBinaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    int applyAsInt(int i, int i2);
}
