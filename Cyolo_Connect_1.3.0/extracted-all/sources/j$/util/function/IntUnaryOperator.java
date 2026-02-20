package j$.util.function;

import j$.util.Objects;
import j$.util.function.IntUnaryOperator;

/* JADX INFO: loaded from: classes4.dex */
public interface IntUnaryOperator {

    /* JADX INFO: renamed from: j$.util.function.IntUnaryOperator$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IntUnaryOperator $default$andThen(final IntUnaryOperator intUnaryOperator, final IntUnaryOperator intUnaryOperator2) {
            Objects.requireNonNull(intUnaryOperator2);
            return new IntUnaryOperator() { // from class: j$.util.function.IntUnaryOperator$$ExternalSyntheticLambda1
                @Override // j$.util.function.IntUnaryOperator
                public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator3) {
                    return IntUnaryOperator.CC.$default$andThen(this, intUnaryOperator3);
                }

                @Override // j$.util.function.IntUnaryOperator
                public final int applyAsInt(int i) {
                    return intUnaryOperator2.applyAsInt(intUnaryOperator.applyAsInt(i));
                }

                @Override // j$.util.function.IntUnaryOperator
                public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator3) {
                    return IntUnaryOperator.CC.$default$compose(this, intUnaryOperator3);
                }
            };
        }

        public static IntUnaryOperator $default$compose(final IntUnaryOperator intUnaryOperator, final IntUnaryOperator intUnaryOperator2) {
            Objects.requireNonNull(intUnaryOperator2);
            return new IntUnaryOperator() { // from class: j$.util.function.IntUnaryOperator$$ExternalSyntheticLambda0
                @Override // j$.util.function.IntUnaryOperator
                public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator3) {
                    return IntUnaryOperator.CC.$default$andThen(this, intUnaryOperator3);
                }

                @Override // j$.util.function.IntUnaryOperator
                public final int applyAsInt(int i) {
                    return intUnaryOperator.applyAsInt(intUnaryOperator2.applyAsInt(i));
                }

                @Override // j$.util.function.IntUnaryOperator
                public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator3) {
                    return IntUnaryOperator.CC.$default$compose(this, intUnaryOperator3);
                }
            };
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements IntUnaryOperator {
        public final /* synthetic */ java.util.function.IntUnaryOperator wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntUnaryOperator intUnaryOperator) {
            this.wrappedValue = intUnaryOperator;
        }

        public static /* synthetic */ IntUnaryOperator convert(java.util.function.IntUnaryOperator intUnaryOperator) {
            if (intUnaryOperator == null) {
                return null;
            }
            return intUnaryOperator instanceof Wrapper ? IntUnaryOperator.this : new VivifiedWrapper(intUnaryOperator);
        }

        @Override // j$.util.function.IntUnaryOperator
        public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
            return convert(this.wrappedValue.andThen(Wrapper.convert(intUnaryOperator)));
        }

        @Override // j$.util.function.IntUnaryOperator
        public /* synthetic */ int applyAsInt(int i) {
            return this.wrappedValue.applyAsInt(i);
        }

        @Override // j$.util.function.IntUnaryOperator
        public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
            return convert(this.wrappedValue.compose(Wrapper.convert(intUnaryOperator)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.IntUnaryOperator intUnaryOperator = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return intUnaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.IntUnaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntUnaryOperator convert(IntUnaryOperator intUnaryOperator) {
            if (intUnaryOperator == null) {
                return null;
            }
            return intUnaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) intUnaryOperator).wrappedValue : intUnaryOperator.new Wrapper();
        }

        @Override // java.util.function.IntUnaryOperator
        public /* synthetic */ java.util.function.IntUnaryOperator andThen(java.util.function.IntUnaryOperator intUnaryOperator) {
            return convert(IntUnaryOperator.this.andThen(VivifiedWrapper.convert(intUnaryOperator)));
        }

        @Override // java.util.function.IntUnaryOperator
        public /* synthetic */ int applyAsInt(int i) {
            return IntUnaryOperator.this.applyAsInt(i);
        }

        @Override // java.util.function.IntUnaryOperator
        public /* synthetic */ java.util.function.IntUnaryOperator compose(java.util.function.IntUnaryOperator intUnaryOperator) {
            return convert(IntUnaryOperator.this.compose(VivifiedWrapper.convert(intUnaryOperator)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            IntUnaryOperator intUnaryOperator = IntUnaryOperator.this;
            if (obj instanceof Wrapper) {
                obj = IntUnaryOperator.this;
            }
            return intUnaryOperator.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return IntUnaryOperator.this.hashCode();
        }
    }

    IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator);

    int applyAsInt(int i);

    IntUnaryOperator compose(IntUnaryOperator intUnaryOperator);
}
