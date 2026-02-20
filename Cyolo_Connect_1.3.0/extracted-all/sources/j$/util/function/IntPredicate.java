package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface IntPredicate {

    public final /* synthetic */ class VivifiedWrapper implements IntPredicate {
        public final /* synthetic */ java.util.function.IntPredicate wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntPredicate intPredicate) {
            this.wrappedValue = intPredicate;
        }

        public static /* synthetic */ IntPredicate convert(java.util.function.IntPredicate intPredicate) {
            if (intPredicate == null) {
                return null;
            }
            return new VivifiedWrapper(intPredicate);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.IntPredicate intPredicate = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return intPredicate.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }

        @Override // j$.util.function.IntPredicate
        public /* synthetic */ boolean test(int i) {
            return this.wrappedValue.test(i);
        }
    }

    boolean test(int i);
}
