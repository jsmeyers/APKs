package j$.util.function;

import j$.util.Objects;
import j$.util.function.BiConsumer;

/* JADX INFO: loaded from: classes4.dex */
public interface BiConsumer<T, U> {

    /* JADX INFO: renamed from: j$.util.function.BiConsumer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static BiConsumer $default$andThen(final BiConsumer biConsumer, final BiConsumer biConsumer2) {
            Objects.requireNonNull(biConsumer2);
            return new BiConsumer() { // from class: j$.util.function.BiConsumer$$ExternalSyntheticLambda0
                @Override // j$.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    BiConsumer.CC.$private$lambda$andThen$0(biConsumer, biConsumer2, obj, obj2);
                }

                @Override // j$.util.function.BiConsumer
                public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer3) {
                    return BiConsumer.CC.$default$andThen(this, biConsumer3);
                }
            };
        }

        public static /* synthetic */ void $private$lambda$andThen$0(BiConsumer biConsumer, BiConsumer biConsumer2, Object obj, Object obj2) {
            biConsumer.accept(obj, obj2);
            biConsumer2.accept(obj, obj2);
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements BiConsumer {
        public final /* synthetic */ java.util.function.BiConsumer wrappedValue;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiConsumer biConsumer) {
            this.wrappedValue = biConsumer;
        }

        public static /* synthetic */ BiConsumer convert(java.util.function.BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return biConsumer instanceof Wrapper ? BiConsumer.this : new VivifiedWrapper(biConsumer);
        }

        @Override // j$.util.function.BiConsumer
        public /* synthetic */ void accept(Object obj, Object obj2) {
            this.wrappedValue.accept(obj, obj2);
        }

        @Override // j$.util.function.BiConsumer
        public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            return convert(this.wrappedValue.andThen(Wrapper.convert(biConsumer)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            java.util.function.BiConsumer biConsumer = this.wrappedValue;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).wrappedValue;
            }
            return biConsumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return this.wrappedValue.hashCode();
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.function.BiConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.BiConsumer convert(BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return biConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) biConsumer).wrappedValue : new Wrapper();
        }

        @Override // java.util.function.BiConsumer
        public /* synthetic */ void accept(Object obj, Object obj2) {
            BiConsumer.this.accept(obj, obj2);
        }

        @Override // java.util.function.BiConsumer
        public /* synthetic */ java.util.function.BiConsumer andThen(java.util.function.BiConsumer biConsumer) {
            return convert(BiConsumer.this.andThen(VivifiedWrapper.convert(biConsumer)));
        }

        public /* synthetic */ boolean equals(Object obj) {
            BiConsumer biConsumer = BiConsumer.this;
            if (obj instanceof Wrapper) {
                obj = BiConsumer.this;
            }
            return biConsumer.equals(obj);
        }

        public /* synthetic */ int hashCode() {
            return BiConsumer.this.hashCode();
        }
    }

    void accept(T t, U u);

    BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> biConsumer);
}
