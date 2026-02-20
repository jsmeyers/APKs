package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface DoublePredicate {

    public final /* synthetic */ class VivifiedWrapper implements DoublePredicate {
        public final /* synthetic */ java.util.function.DoublePredicate wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoublePredicate doublePredicate) {
            this.wrappedValue = doublePredicate;
        }

        public static /* synthetic */ DoublePredicate convert(java.util.function.DoublePredicate doublePredicate) {
            if (doublePredicate == null) {
                return null;
            }
            return new VivifiedWrapper(doublePredicate);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.DoublePredicate doublePredicate = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return doublePredicate.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }

        @Override // j$.util.function.DoublePredicate
        public /* synthetic */ boolean test(double d) {
            return this.wrappedValue.test(d);
        }
    }

    boolean test(double d);
}
