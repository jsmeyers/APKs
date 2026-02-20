package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes4.dex */
public interface ChronoZonedDateTime<D extends ChronoLocalDate> extends Temporal, Comparable<ChronoZonedDateTime<?>> {

    /* JADX INFO: renamed from: j$.time.chrono.ChronoZonedDateTime$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static int $default$compareTo(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
            int iCompare = Long.compare(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
            if (iCompare != 0) {
                return iCompare;
            }
            int nano = chronoZonedDateTime.toLocalTime().getNano() - chronoZonedDateTime2.toLocalTime().getNano();
            if (nano != 0) {
                return nano;
            }
            int iCompareTo = chronoZonedDateTime.toLocalDateTime().compareTo(chronoZonedDateTime2.toLocalDateTime());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = chronoZonedDateTime.getZone().getId().compareTo(chronoZonedDateTime2.getZone().getId());
            return iCompareTo2 == 0 ? chronoZonedDateTime.getChronology().compareTo(chronoZonedDateTime2.getChronology()) : iCompareTo2;
        }

        public static int $default$get(ChronoZonedDateTime chronoZonedDateTime, TemporalField temporalField) {
            if (!(temporalField instanceof ChronoField)) {
                return TemporalAccessor.CC.$default$get(chronoZonedDateTime, temporalField);
            }
            int i = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
            if (i != 1) {
                return i != 2 ? chronoZonedDateTime.toLocalDateTime().get(temporalField) : chronoZonedDateTime.getOffset().getTotalSeconds();
            }
            throw new UnsupportedTemporalTypeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        }

        public static boolean $default$isBefore(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
            long epochSecond = chronoZonedDateTime.toEpochSecond();
            long epochSecond2 = chronoZonedDateTime2.toEpochSecond();
            return epochSecond < epochSecond2 || (epochSecond == epochSecond2 && chronoZonedDateTime.toLocalTime().getNano() < chronoZonedDateTime2.toLocalTime().getNano());
        }

        public static Object $default$query(ChronoZonedDateTime chronoZonedDateTime, TemporalQuery temporalQuery) {
            return (temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId()) ? chronoZonedDateTime.getZone() : temporalQuery == TemporalQueries.offset() ? chronoZonedDateTime.getOffset() : temporalQuery == TemporalQueries.localTime() ? chronoZonedDateTime.toLocalTime() : temporalQuery == TemporalQueries.chronology() ? chronoZonedDateTime.getChronology() : temporalQuery == TemporalQueries.precision() ? ChronoUnit.NANOS : temporalQuery.queryFrom(chronoZonedDateTime);
        }

        public static long $default$toEpochSecond(ChronoZonedDateTime chronoZonedDateTime) {
            return ((chronoZonedDateTime.toLocalDate().toEpochDay() * 86400) + ((long) chronoZonedDateTime.toLocalTime().toSecondOfDay())) - ((long) chronoZonedDateTime.getOffset().getTotalSeconds());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: j$.time.chrono.ChronoZonedDateTime$1, reason: invalid class name */
    protected static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    int compareTo(ChronoZonedDateTime chronoZonedDateTime);

    Chronology getChronology();

    @Override // j$.time.temporal.TemporalAccessor
    long getLong(TemporalField temporalField);

    ZoneOffset getOffset();

    ZoneId getZone();

    long toEpochSecond();

    Instant toInstant();

    ChronoLocalDate toLocalDate();

    ChronoLocalDateTime toLocalDateTime();

    LocalTime toLocalTime();
}
