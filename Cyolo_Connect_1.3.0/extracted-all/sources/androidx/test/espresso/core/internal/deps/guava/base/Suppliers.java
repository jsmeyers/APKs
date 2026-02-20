package androidx.test.espresso.core.internal.deps.guava.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class Suppliers {
    public static <T> Supplier<T> ofInstance(T instance) {
        return new SupplierOfInstance(instance);
    }

    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final T instance;

        SupplierOfInstance(T instance) {
            this.instance = instance;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.base.Supplier
        public T get() {
            return this.instance;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.equal(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.instance);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.instance);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
            sb.append("Suppliers.ofInstance(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }
}
