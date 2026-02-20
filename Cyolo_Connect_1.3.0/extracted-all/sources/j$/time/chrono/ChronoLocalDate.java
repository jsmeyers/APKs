package j$.time.chrono;

import j$.time.LocalTime;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface ChronoLocalDate extends Temporal, TemporalAdjuster, Comparable<ChronoLocalDate> {

    /* JADX INFO: renamed from: j$.time.chrono.ChronoLocalDate$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static int $default$compareTo(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
            int iCompare = Long.compare(chronoLocalDate.toEpochDay(), chronoLocalDate2.toEpochDay());
            return iCompare == 0 ? chronoLocalDate.getChronology().compareTo(chronoLocalDate2.getChronology()) : iCompare;
        }

        public static boolean $default$isAfter(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
            return chronoLocalDate.toEpochDay() > chronoLocalDate2.toEpochDay();
        }

        public static boolean $default$isBefore(ChronoLocalDate chronoLocalDate, ChronoLocalDate chronoLocalDate2) {
            return chronoLocalDate.toEpochDay() < chronoLocalDate2.toEpochDay();
        }

        public static boolean $default$isSupported(ChronoLocalDate chronoLocalDate, TemporalField temporalField) {
            return temporalField instanceof ChronoField ? temporalField.isDateBased() : temporalField != null && temporalField.isSupportedBy(chronoLocalDate);
        }

        public static Object $default$query(ChronoLocalDate chronoLocalDate, TemporalQuery temporalQuery) {
            if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localTime()) {
                return null;
            }
            return temporalQuery == TemporalQueries.chronology() ? chronoLocalDate.getChronology() : temporalQuery == TemporalQueries.precision() ? ChronoUnit.DAYS : temporalQuery.queryFrom(chronoLocalDate);
        }
    }

    ChronoLocalDateTime<?> atTime(LocalTime localTime);

    int compareTo(ChronoLocalDate chronoLocalDate);

    boolean equals(Object obj);

    Chronology getChronology();

    @Override // j$.time.temporal.TemporalAccessor
    boolean isSupported(TemporalField temporalField);

    int lengthOfYear();

    @Override // j$.time.temporal.Temporal
    ChronoLocalDate minus(long j, TemporalUnit temporalUnit);

    @Override // j$.time.temporal.Temporal
    ChronoLocalDate plus(long j, TemporalUnit temporalUnit);

    ChronoLocalDate plus(TemporalAmount temporalAmount);

    long toEpochDay();

    @Override // j$.time.temporal.Temporal
    ChronoLocalDate with(TemporalAdjuster temporalAdjuster);
}
