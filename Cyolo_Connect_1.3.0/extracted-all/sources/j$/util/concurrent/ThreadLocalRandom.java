package j$.util.concurrent;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.StreamSupport;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class ThreadLocalRandom extends Random {
    boolean initialized;
    int threadLocalRandomProbe;
    long threadLocalRandomSeed;
    private static final AtomicInteger probeGenerator = new AtomicInteger();
    private static final AtomicLong seeder = new AtomicLong(initialSeed());
    private static final ThreadLocal nextLocalGaussian = new ThreadLocal();
    private static final ThreadLocal instances = new ThreadLocal() { // from class: j$.util.concurrent.ThreadLocalRandom.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ThreadLocalRandom initialValue() {
            return new ThreadLocalRandom();
        }
    };
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("rnd", Long.TYPE), new ObjectStreamField("initialized", Boolean.TYPE)};

    static final class RandomDoublesSpliterator implements Spliterator.OfDouble {
        final double bound;
        final long fence;
        long index;
        final double origin;

        RandomDoublesSpliterator(long j, long j2, double d, double d2) {
            this.index = j;
            this.fence = j2;
            this.origin = d;
            this.bound = d2;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfDouble.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(DoubleConsumer doubleConsumer) {
            doubleConsumer.getClass();
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                double d = this.origin;
                double d2 = this.bound;
                ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
                do {
                    doubleConsumer.accept(threadLocalRandomCurrent.internalNextDouble(d, d2));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfDouble, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfDouble.CC.$default$tryAdvance(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(DoubleConsumer doubleConsumer) {
            doubleConsumer.getClass();
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            doubleConsumer.accept(ThreadLocalRandom.current().internalNextDouble(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // j$.util.Spliterator
        public RandomDoublesSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.index = j2;
            return new RandomDoublesSpliterator(j, j2, this.origin, this.bound);
        }
    }

    static final class RandomIntsSpliterator implements Spliterator.OfInt {
        final int bound;
        final long fence;
        long index;
        final int origin;

        RandomIntsSpliterator(long j, long j2, int i, int i2) {
            this.index = j;
            this.fence = j2;
            this.origin = i;
            this.bound = i2;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfInt.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer intConsumer) {
            intConsumer.getClass();
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                int i = this.origin;
                int i2 = this.bound;
                ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
                do {
                    intConsumer.accept(threadLocalRandomCurrent.internalNextInt(i, i2));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfInt, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfInt.CC.$default$tryAdvance(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer intConsumer) {
            intConsumer.getClass();
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            intConsumer.accept(ThreadLocalRandom.current().internalNextInt(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // j$.util.Spliterator
        public RandomIntsSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.index = j2;
            return new RandomIntsSpliterator(j, j2, this.origin, this.bound);
        }
    }

    static final class RandomLongsSpliterator implements Spliterator.OfLong {
        final long bound;
        final long fence;
        long index;
        final long origin;

        RandomLongsSpliterator(long j, long j2, long j3, long j4) {
            this.index = j;
            this.fence = j2;
            this.origin = j3;
            this.bound = j4;
        }

        @Override // j$.util.Spliterator
        public int characteristics() {
            return 17728;
        }

        @Override // j$.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.OfLong.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public void forEachRemaining(LongConsumer longConsumer) {
            longConsumer.getClass();
            long j = this.index;
            long j2 = this.fence;
            if (j < j2) {
                this.index = j2;
                long j3 = this.origin;
                long j4 = this.bound;
                ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
                do {
                    longConsumer.accept(threadLocalRandomCurrent.internalNextLong(j3, j4));
                    j++;
                } while (j < j2);
            }
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ Comparator getComparator() {
            return Spliterator.CC.$default$getComparator(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.CC.$default$getExactSizeIfKnown(this);
        }

        @Override // j$.util.Spliterator
        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.CC.$default$hasCharacteristics(this, i);
        }

        @Override // j$.util.Spliterator.OfLong, j$.util.Spliterator
        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.OfLong.CC.$default$tryAdvance(this, consumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer longConsumer) {
            longConsumer.getClass();
            long j = this.index;
            if (j >= this.fence) {
                return false;
            }
            longConsumer.accept(ThreadLocalRandom.current().internalNextLong(this.origin, this.bound));
            this.index = j + 1;
            return true;
        }

        @Override // j$.util.Spliterator
        public RandomLongsSpliterator trySplit() {
            long j = this.index;
            long j2 = (this.fence + j) >>> 1;
            if (j2 <= j) {
                return null;
            }
            this.index = j2;
            return new RandomLongsSpliterator(j, j2, this.origin, this.bound);
        }
    }

    private ThreadLocalRandom() {
        this.initialized = true;
    }

    static final int advanceProbe(int i) {
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        ((ThreadLocalRandom) instances.get()).threadLocalRandomProbe = i4;
        return i4;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) instances.get();
        if (threadLocalRandom.threadLocalRandomProbe == 0) {
            localInit();
        }
        return threadLocalRandom;
    }

    static final int getProbe() {
        return ((ThreadLocalRandom) instances.get()).threadLocalRandomProbe;
    }

    private static long initialSeed() {
        if (!((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: j$.util.concurrent.ThreadLocalRandom.1
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
            }
        })).booleanValue()) {
            return mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime());
        }
        byte[] seed = SecureRandom.getSeed(8);
        long j = ((long) seed[0]) & 255;
        for (int i = 1; i < 8; i++) {
            j = (j << 8) | (((long) seed[i]) & 255);
        }
        return j;
    }

    static final void localInit() {
        int iAddAndGet = probeGenerator.addAndGet(-1640531527);
        if (iAddAndGet == 0) {
            iAddAndGet = 1;
        }
        long jMix64 = mix64(seeder.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) instances.get();
        threadLocalRandom.threadLocalRandomSeed = jMix64;
        threadLocalRandom.threadLocalRandomProbe = iAddAndGet;
    }

    private static int mix32(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        return (int) (((j2 ^ (j2 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    private static long mix64(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    @Override // java.util.Random
    public DoubleStream doubles() {
        return StreamSupport.doubleStream(new RandomDoublesSpliterator(0L, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d), false);
    }

    @Override // java.util.Random
    public DoubleStream doubles(double d, double d2) {
        if (d < d2) {
            return StreamSupport.doubleStream(new RandomDoublesSpliterator(0L, Long.MAX_VALUE, d, d2), false);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public DoubleStream doubles(long j) {
        if (j >= 0) {
            return StreamSupport.doubleStream(new RandomDoublesSpliterator(0L, j, Double.MAX_VALUE, 0.0d), false);
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public DoubleStream doubles(long j, double d, double d2) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        }
        if (d < d2) {
            return StreamSupport.doubleStream(new RandomDoublesSpliterator(0L, j, d, d2), false);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.DoubleStream doubles() {
        return DoubleStream.Wrapper.convert(doubles());
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.DoubleStream doubles(double d, double d2) {
        return DoubleStream.Wrapper.convert(doubles(d, d2));
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.DoubleStream doubles(long j) {
        return DoubleStream.Wrapper.convert(doubles(j));
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.DoubleStream doubles(long j, double d, double d2) {
        return DoubleStream.Wrapper.convert(doubles(j, d, d2));
    }

    final double internalNextDouble(double d, double d2) {
        double dNextLong = (nextLong() >>> 11) * 1.1102230246251565E-16d;
        if (d >= d2) {
            return dNextLong;
        }
        double d3 = (dNextLong * (d2 - d)) + d;
        return d3 >= d2 ? Double.longBitsToDouble(Double.doubleToLongBits(d2) - 1) : d3;
    }

    final int internalNextInt(int i, int i2) {
        int i3;
        int iMix32 = mix32(nextSeed());
        if (i >= i2) {
            return iMix32;
        }
        int i4 = i2 - i;
        int i5 = i4 - 1;
        if ((i4 & i5) == 0) {
            i3 = iMix32 & i5;
        } else if (i4 > 0) {
            int iMix322 = iMix32 >>> 1;
            while (true) {
                int i6 = iMix322 + i5;
                i3 = iMix322 % i4;
                if (i6 - i3 >= 0) {
                    break;
                }
                iMix322 = mix32(nextSeed()) >>> 1;
            }
        } else {
            while (true) {
                if (iMix32 >= i && iMix32 < i2) {
                    return iMix32;
                }
                iMix32 = mix32(nextSeed());
            }
        }
        return i3 + i;
    }

    final long internalNextLong(long j, long j2) {
        long jMix64 = mix64(nextSeed());
        if (j >= j2) {
            return jMix64;
        }
        long j3 = j2 - j;
        long j4 = j3 - 1;
        if ((j3 & j4) == 0) {
            return (jMix64 & j4) + j;
        }
        if (j3 > 0) {
            while (true) {
                long j5 = jMix64 >>> 1;
                long j6 = j5 + j4;
                long j7 = j5 % j3;
                if (j6 - j7 >= 0) {
                    return j7 + j;
                }
                jMix64 = mix64(nextSeed());
            }
        } else {
            while (true) {
                if (jMix64 >= j && jMix64 < j2) {
                    return jMix64;
                }
                jMix64 = mix64(nextSeed());
            }
        }
    }

    @Override // java.util.Random
    public IntStream ints() {
        return StreamSupport.intStream(new RandomIntsSpliterator(0L, Long.MAX_VALUE, Integer.MAX_VALUE, 0), false);
    }

    @Override // java.util.Random
    public IntStream ints(int i, int i2) {
        if (i < i2) {
            return StreamSupport.intStream(new RandomIntsSpliterator(0L, Long.MAX_VALUE, i, i2), false);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public IntStream ints(long j) {
        if (j >= 0) {
            return StreamSupport.intStream(new RandomIntsSpliterator(0L, j, Integer.MAX_VALUE, 0), false);
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public IntStream ints(long j, int i, int i2) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        }
        if (i < i2) {
            return StreamSupport.intStream(new RandomIntsSpliterator(0L, j, i, i2), false);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.IntStream ints() {
        return IntStream.Wrapper.convert(ints());
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.IntStream ints(int i, int i2) {
        return IntStream.Wrapper.convert(ints(i, i2));
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.IntStream ints(long j) {
        return IntStream.Wrapper.convert(ints(j));
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.IntStream ints(long j, int i, int i2) {
        return IntStream.Wrapper.convert(ints(j, i, i2));
    }

    @Override // java.util.Random
    public LongStream longs() {
        return StreamSupport.longStream(new RandomLongsSpliterator(0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L), false);
    }

    @Override // java.util.Random
    public LongStream longs(long j) {
        if (j >= 0) {
            return StreamSupport.longStream(new RandomLongsSpliterator(0L, j, Long.MAX_VALUE, 0L), false);
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public LongStream longs(long j, long j2) {
        if (j < j2) {
            return StreamSupport.longStream(new RandomLongsSpliterator(0L, Long.MAX_VALUE, j, j2), false);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public LongStream longs(long j, long j2, long j3) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        }
        if (j2 < j3) {
            return StreamSupport.longStream(new RandomLongsSpliterator(0L, j, j2, j3), false);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.LongStream longs() {
        return LongStream.Wrapper.convert(longs());
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.LongStream longs(long j) {
        return LongStream.Wrapper.convert(longs(j));
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.LongStream longs(long j, long j2) {
        return LongStream.Wrapper.convert(longs(j, j2));
    }

    @Override // java.util.Random
    public /* synthetic */ java.util.stream.LongStream longs(long j, long j2, long j3) {
        return LongStream.Wrapper.convert(longs(j, j2, j3));
    }

    @Override // java.util.Random
    protected int next(int i) {
        return (int) (mix64(nextSeed()) >>> (64 - i));
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return mix32(nextSeed()) < 0;
    }

    @Override // java.util.Random
    public double nextDouble() {
        return (mix64(nextSeed()) >>> 11) * 1.1102230246251565E-16d;
    }

    public double nextDouble(double d) {
        if (d <= 0.0d) {
            throw new IllegalArgumentException("bound must be positive");
        }
        double dMix64 = (mix64(nextSeed()) >>> 11) * 1.1102230246251565E-16d * d;
        return dMix64 < d ? dMix64 : Double.longBitsToDouble(Double.doubleToLongBits(d) - 1);
    }

    public double nextDouble(double d, double d2) {
        if (d < d2) {
            return internalNextDouble(d, d2);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public float nextFloat() {
        return (mix32(nextSeed()) >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public double nextGaussian() {
        ThreadLocal threadLocal = nextLocalGaussian;
        Double d = (Double) threadLocal.get();
        if (d != null) {
            threadLocal.set(null);
            return d.doubleValue();
        }
        while (true) {
            double dNextDouble = (nextDouble() * 2.0d) - 1.0d;
            double dNextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d2 = (dNextDouble * dNextDouble) + (dNextDouble2 * dNextDouble2);
            if (d2 < 1.0d && d2 != 0.0d) {
                double dSqrt = StrictMath.sqrt((StrictMath.log(d2) * (-2.0d)) / d2);
                nextLocalGaussian.set(new Double(dNextDouble2 * dSqrt));
                return dNextDouble * dSqrt;
            }
        }
    }

    @Override // java.util.Random
    public int nextInt() {
        return mix32(nextSeed());
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        int iMix32 = mix32(nextSeed());
        int i2 = i - 1;
        if ((i & i2) == 0) {
            return iMix32 & i2;
        }
        while (true) {
            int i3 = iMix32 >>> 1;
            int i4 = i3 + i2;
            int i5 = i3 % i;
            if (i4 - i5 >= 0) {
                return i5;
            }
            iMix32 = mix32(nextSeed());
        }
    }

    public int nextInt(int i, int i2) {
        if (i < i2) {
            return internalNextInt(i, i2);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public long nextLong() {
        return mix64(nextSeed());
    }

    public long nextLong(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        long jMix64 = mix64(nextSeed());
        long j2 = j - 1;
        if ((j & j2) == 0) {
            return jMix64 & j2;
        }
        while (true) {
            long j3 = jMix64 >>> 1;
            long j4 = j3 + j2;
            long j5 = j3 % j;
            if (j4 - j5 >= 0) {
                return j5;
            }
            jMix64 = mix64(nextSeed());
        }
    }

    public long nextLong(long j, long j2) {
        if (j < j2) {
            return internalNextLong(j, j2);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    final long nextSeed() {
        long j = this.threadLocalRandomSeed - 7046029254386353131L;
        this.threadLocalRandomSeed = j;
        return j;
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.initialized) {
            throw new UnsupportedOperationException();
        }
    }
}
