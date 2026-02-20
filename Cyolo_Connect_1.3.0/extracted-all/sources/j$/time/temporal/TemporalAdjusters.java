package j$.time.temporal;

import j$.time.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TemporalAdjusters {
    static /* synthetic */ Temporal lambda$nextOrSame$10(int i, Temporal temporal) {
        int i2 = temporal.get(ChronoField.DAY_OF_WEEK);
        if (i2 == i) {
            return temporal;
        }
        return temporal.plus(i2 - i >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
        final int value = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: j$.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda11
            @Override // j$.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$nextOrSame$10(value, temporal);
            }
        };
    }
}
