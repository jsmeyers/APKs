package j$.util.function;

/* JADX INFO: loaded from: classes4.dex */
public interface Supplier<T> {

    public final /* synthetic */ class VivifiedWrapper implements Supplier {
        public final /* synthetic */ java.util.function.Supplier wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.Supplier supplier) {
            this.wrappedValue = supplier;
        }

        public static /* synthetic */ Supplier convert(java.util.function.Supplier supplier) {
            if (supplier == null) {
                return null;
            }
            return new VivifiedWrapper(supplier);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.Supplier supplier = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return supplier.equals(obj);
        }

        @Override // j$.util.function.Supplier
        public /* synthetic */ Object get() {
            return this.wrappedValue.get();
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    T get();
}
