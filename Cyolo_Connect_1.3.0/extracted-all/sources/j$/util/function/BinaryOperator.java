package j$.util.function;

import j$.util.Objects;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public interface BinaryOperator extends BiFunction {

    /* JADX INFO: renamed from: j$.util.function.BinaryOperator$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ Object lambda$maxBy$1(Comparator comparator, Object obj, Object obj2) {
            return comparator.compare(obj, obj2) >= 0 ? obj : obj2;
        }

        public static /* synthetic */ Object lambda$minBy$0(Comparator comparator, Object obj, Object obj2) {
            return comparator.compare(obj, obj2) <= 0 ? obj : obj2;
        }

        public static BinaryOperator maxBy(final Comparator comparator) {
            Objects.requireNonNull(comparator);
            return new BinaryOperator() { // from class: j$.util.function.BinaryOperator$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiFunction
                public /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return BinaryOperator.CC.lambda$maxBy$1(comparator, obj, obj2);
                }
            };
        }

        public static BinaryOperator minBy(final Comparator comparator) {
            Objects.requireNonNull(comparator);
            return new BinaryOperator() { // from class: j$.util.function.BinaryOperator$$ExternalSyntheticLambda1
                @Override // j$.util.function.BiFunction
                public /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return BinaryOperator.CC.lambda$minBy$0(comparator, obj, obj2);
                }
            };
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements BinaryOperator {
        public final /* synthetic */ java.util.function.BinaryOperator wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.BinaryOperator binaryOperator) {
            this.wrappedValue = binaryOperator;
        }

        public static /* synthetic */ BinaryOperator convert(java.util.function.BinaryOperator binaryOperator) {
            if (binaryOperator == null) {
                return null;
            }
            return binaryOperator instanceof Wrapper ? BinaryOperator.this : new VivifiedWrapper(binaryOperator);
        }

        @Override // j$.util.function.BiFunction
        public /* synthetic */ BiFunction andThen(Function function) {
            return BiFunction.VivifiedWrapper.convert(this.wrappedValue.andThen(Function.Wrapper.convert(function)));
        }

        @Override // j$.util.function.BiFunction
        public /* synthetic */ Object apply(Object obj, Object obj2) {
            return this.wrappedValue.apply(obj, obj2);
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.BinaryOperator binaryOperator = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return binaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.BinaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.BinaryOperator convert(BinaryOperator binaryOperator) {
            if (binaryOperator == null) {
                return null;
            }
            return binaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) binaryOperator).wrappedValue : binaryOperator.new Wrapper();
        }

        @Override // java.util.function.BiFunction
        public /* synthetic */ java.util.function.BiFunction andThen(java.util.function.Function function) {
            return BiFunction.Wrapper.convert(BinaryOperator.this.andThen(Function.VivifiedWrapper.convert(function)));
        }

        @Override // java.util.function.BiFunction
        public /* synthetic */ Object apply(Object obj, Object obj2) {
            return BinaryOperator.this.apply(obj, obj2);
        }

        public /* synthetic */ boolean equals(Object obj) {
            BinaryOperator binaryOperator = BinaryOperator.this;
            if (obj instanceof Wrapper) {
                obj = BinaryOperator.this;
            }
            return binaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return BinaryOperator.this.hashCode();
        }
    }
}
