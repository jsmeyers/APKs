package j$.util;

import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;

/* JADX INFO: loaded from: classes4.dex */
public class LongSummaryStatistics implements LongConsumer, IntConsumer {
    private long count;
    private long sum;
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;

    @Override // j$.util.function.IntConsumer
    public void accept(int i) {
        accept(i);
    }

    @Override // j$.util.function.LongConsumer
    public void accept(long j) {
        this.count++;
        this.sum += j;
        this.min = Math.min(this.min, j);
        this.max = Math.max(this.max, j);
    }

    public void combine(LongSummaryStatistics longSummaryStatistics) {
        this.count += longSummaryStatistics.count;
        this.sum += longSummaryStatistics.sum;
        this.min = Math.min(this.min, longSummaryStatistics.min);
        this.max = Math.max(this.max, longSummaryStatistics.max);
    }

    public final double getAverage() {
        if (getCount() > 0) {
            return getSum() / getCount();
        }
        return 0.0d;
    }

    public final long getCount() {
        return this.count;
    }

    public final long getMax() {
        return this.max;
    }

    public final long getMin() {
        return this.min;
    }

    public final long getSum() {
        return this.sum;
    }

    public String toString() {
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", getClass().getSimpleName(), Long.valueOf(getCount()), Long.valueOf(getSum()), Long.valueOf(getMin()), Double.valueOf(getAverage()), Long.valueOf(getMax()));
    }
}
