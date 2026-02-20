package j$.util.stream;

import j$.util.Map;
import j$.util.StringJoiner;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.stream.Collector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class Collectors {
    static final Set CH_CONCURRENT_ID;
    static final Set CH_CONCURRENT_NOID;
    static final Set CH_ID;
    static final Set CH_NOID;
    static final Set CH_UNORDERED_ID;

    static class CollectorImpl implements Collector {
        private final BiConsumer accumulator;
        private final Set characteristics;
        private final BinaryOperator combiner;
        private final Function finisher;
        private final Supplier supplier;

        CollectorImpl(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
            this.supplier = supplier;
            this.accumulator = biConsumer;
            this.combiner = binaryOperator;
            this.finisher = function;
            this.characteristics = set;
        }

        CollectorImpl(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
            this(supplier, biConsumer, binaryOperator, Collectors.castingIdentity(), set);
        }

        @Override // j$.util.stream.Collector
        public BiConsumer accumulator() {
            return this.accumulator;
        }

        @Override // j$.util.stream.Collector
        public Set characteristics() {
            return this.characteristics;
        }

        @Override // j$.util.stream.Collector
        public BinaryOperator combiner() {
            return this.combiner;
        }

        @Override // j$.util.stream.Collector
        public Function finisher() {
            return this.finisher;
        }

        @Override // j$.util.stream.Collector
        public Supplier supplier() {
            return this.supplier;
        }
    }

    static {
        Collector.Characteristics characteristics = Collector.Characteristics.CONCURRENT;
        Collector.Characteristics characteristics2 = Collector.Characteristics.UNORDERED;
        Collector.Characteristics characteristics3 = Collector.Characteristics.IDENTITY_FINISH;
        CH_CONCURRENT_ID = Collections.unmodifiableSet(EnumSet.of(characteristics, characteristics2, characteristics3));
        CH_CONCURRENT_NOID = Collections.unmodifiableSet(EnumSet.of(characteristics, characteristics2));
        CH_ID = Collections.unmodifiableSet(EnumSet.of(characteristics3));
        CH_UNORDERED_ID = Collections.unmodifiableSet(EnumSet.of(characteristics2, characteristics3));
        CH_NOID = Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Function castingIdentity() {
        return new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda16
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return Collectors.lambda$castingIdentity$1(obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        };
    }

    static double computeFinalSum(double[] dArr) {
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (Double.isNaN(d) && Double.isInfinite(d2)) ? d2 : d;
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence) {
        return joining(charSequence, "", "");
    }

    public static Collector joining(final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3) {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda42
            @Override // j$.util.function.Supplier
            public final Object get() {
                return Collectors.lambda$joining$6(charSequence, charSequence2, charSequence3);
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda43
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((StringJoiner) obj).add((CharSequence) obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda44
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((StringJoiner) obj).merge((StringJoiner) obj2);
            }
        }, new Function() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda45
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return ((StringJoiner) obj).toString();
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        }, CH_NOID);
    }

    static /* synthetic */ Object lambda$castingIdentity$1(Object obj) {
        return obj;
    }

    static /* synthetic */ StringJoiner lambda$joining$6(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new StringJoiner(charSequence, charSequence2, charSequence3);
    }

    static /* synthetic */ Map lambda$mapMerger$7(BinaryOperator binaryOperator, Map map, Map map2) {
        for (Map.Entry entry : map2.entrySet()) {
            Map.EL.merge(map, entry.getKey(), entry.getValue(), binaryOperator);
        }
        return map;
    }

    static /* synthetic */ Object lambda$throwingMerger$0(Object obj, Object obj2) {
        throw new IllegalStateException(String.format("Duplicate key %s", obj));
    }

    static /* synthetic */ Collection lambda$toCollection$2(Collection collection, Collection collection2) {
        collection.addAll(collection2);
        return collection;
    }

    static /* synthetic */ List lambda$toList$3(List list, List list2) {
        list.addAll(list2);
        return list;
    }

    static /* synthetic */ Set lambda$toSet$4(Set set, Set set2) {
        set.addAll(set2);
        return set;
    }

    private static BinaryOperator mapMerger(final BinaryOperator binaryOperator) {
        return new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda25
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$mapMerger$7(binaryOperator, (java.util.Map) obj, (java.util.Map) obj2);
            }
        };
    }

    static double[] sumWithCompensation(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
        return dArr;
    }

    private static BinaryOperator throwingMerger() {
        return new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda15
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$throwingMerger$0(obj, obj2);
            }
        };
    }

    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supplier<C> supplier) {
        return new CollectorImpl(supplier, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda1
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((Collection) obj).add(obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda2
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toCollection$2((Collection) obj, (Collection) obj2);
            }
        }, CH_ID);
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda65
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new ArrayList();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda66
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((List) obj).add(obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda67
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toList$3((List) obj, (List) obj2);
            }
        }, CH_ID);
    }

    public static <T, K, U> Collector<T, ?, java.util.Map<K, U>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends U> function2) {
        return toMap(function, function2, throwingMerger(), new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda55
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new HashMap();
            }
        });
    }

    public static Collector toMap(final Function function, final Function function2, final BinaryOperator binaryOperator, Supplier supplier) {
        return new CollectorImpl(supplier, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda41
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                java.util.Map map = (java.util.Map) obj;
                Map.EL.merge(map, function.apply(obj2), function2.apply(obj2), binaryOperator);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }, mapMerger(binaryOperator), CH_ID);
    }

    public static <T> Collector<T, ?, Set<T>> toSet() {
        return new CollectorImpl(new Supplier() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda75
            @Override // j$.util.function.Supplier
            public final Object get() {
                return new HashSet();
            }
        }, new BiConsumer() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda76
            @Override // j$.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((Set) obj).add(obj2);
            }

            @Override // j$.util.function.BiConsumer
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            }
        }, new BinaryOperator() { // from class: j$.util.stream.Collectors$$ExternalSyntheticLambda77
            @Override // j$.util.function.BiFunction
            public /* synthetic */ BiFunction andThen(Function function) {
                return BiFunction.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Collectors.lambda$toSet$4((Set) obj, (Set) obj2);
            }
        }, CH_UNORDERED_ID);
    }
}
