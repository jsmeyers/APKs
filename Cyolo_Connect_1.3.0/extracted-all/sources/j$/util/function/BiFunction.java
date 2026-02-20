package j$.util.function;

import j$.util.Objects;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public interface BiFunction<T, U, R> {

    /* JADX INFO: renamed from: j$.util.function.BiFunction$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static BiFunction $default$andThen(final BiFunction biFunction, final Function function) {
            Objects.requireNonNull(function);
            return new BiFunction() { // from class: j$.util.function.BiFunction$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public /* synthetic */ BiFunction andThen(Function function2) {
                    return BiFunction.CC.$default$andThen(this, function2);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return function.apply(biFunction.apply(obj, obj2));
                }
            };
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements BiFunction {
        public final /* synthetic */ java.util.function.BiFunction wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiFunction biFunction) {
            this.wrappedValue = biFunction;
        }

        public static /* synthetic */ BiFunction convert(java.util.function.BiFunction biFunction) {
            if (biFunction == null) {
                return null;
            }
            return biFunction instanceof Wrapper ? BiFunction.this : biFunction instanceof java.util.function.BinaryOperator ? BinaryOperator.VivifiedWrapper.convert((java.util.function.BinaryOperator) biFunction) : new VivifiedWrapper(biFunction);
        }

        @Override // j$.util.function.BiFunction
        public /* synthetic */ BiFunction andThen(Function function) {
            return convert(this.wrappedValue.andThen(Function.Wrapper.convert(function)));
        }

        @Override // j$.util.function.BiFunction
        public /* synthetic */ Object apply(Object obj, Object obj2) {
            return this.wrappedValue.apply(obj, obj2);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.BiFunction biFunction = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return biFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.BiFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.BiFunction convert(BiFunction biFunction) {
            if (biFunction == null) {
                return null;
            }
            return biFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) biFunction).wrappedValue : biFunction instanceof BinaryOperator ? BinaryOperator.Wrapper.convert((BinaryOperator) biFunction) : new Wrapper();
        }

        @Override // java.util.function.BiFunction
        public /* synthetic */ java.util.function.BiFunction andThen(java.util.function.Function function) {
            return convert(BiFunction.this.andThen(Function.VivifiedWrapper.convert(function)));
        }

        @Override // java.util.function.BiFunction
        public /* synthetic */ Object apply(Object obj, Object obj2) {
            return BiFunction.this.apply(obj, obj2);
        }

        public /* synthetic */ boolean equals(Object obj) {
            BiFunction biFunction = BiFunction.this;
            if (obj instanceof Wrapper) {
                obj = BiFunction.this;
            }
            return biFunction.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return BiFunction.this.hashCode();
        }
    }

    <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> function);

    R apply(T t, U u);
}
