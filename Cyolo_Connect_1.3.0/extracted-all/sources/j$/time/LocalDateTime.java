package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.Chronology;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import j$.util.Objects;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalDateTime implements Temporal, TemporalAdjuster, ChronoLocalDateTime<LocalDate>, Serializable {
    private final LocalDate date;
    private final LocalTime time;
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);

    /* JADX INFO: renamed from: j$.time.LocalDateTime$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    private int compareTo0(LocalDateTime localDateTime) {
        int iCompareTo0 = this.date.compareTo0(localDateTime.toLocalDate());
        return iCompareTo0 == 0 ? this.time.compareTo(localDateTime.toLocalTime()) : iCompareTo0;
    }

    public static LocalDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).toLocalDateTime();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.from(temporalAccessor), LocalTime.from(temporalAccessor));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    public static LocalDateTime of(int i, int i2, int i3, int i4, int i5) {
        return new LocalDateTime(LocalDate.of(i, i2, i3), LocalTime.of(i4, i5));
    }

    public static LocalDateTime of(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new LocalDateTime(LocalDate.of(i, i2, i3), LocalTime.of(i4, i5, i6, i7));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime ofEpochSecond(long j, int i, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j2 = i;
        ChronoField.NANO_OF_SECOND.checkValidValue(j2);
        long totalSeconds = j + ((long) zoneOffset.getTotalSeconds());
        return new LocalDateTime(LocalDate.ofEpochDay(Duration$$ExternalSyntheticBackport1.m(totalSeconds, 86400L)), LocalTime.ofNanoOfDay((((long) ((int) Clock$TickClock$$ExternalSyntheticBackport0.m(totalSeconds, 86400L))) * 1000000000) + j2));
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.parse(charSequence, new TemporalQuery() { // from class: j$.time.LocalDateTime$$ExternalSyntheticLambda0
            @Override // j$.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return LocalDateTime.from(temporalAccessor);
            }
        });
    }

    private LocalDateTime plusWithOverflow(LocalDate localDate, long j, long j2, long j3, long j4, int i) {
        LocalTime localTimeOfNanoOfDay;
        LocalDate localDatePlusDays = localDate;
        if ((j | j2 | j3 | j4) == 0) {
            localTimeOfNanoOfDay = this.time;
        } else {
            long j5 = i;
            long nanoOfDay = this.time.toNanoOfDay();
            long j6 = (((j4 % 86400000000000L) + ((j3 % 86400) * 1000000000) + ((j2 % 1440) * 60000000000L) + ((j % 24) * 3600000000000L)) * j5) + nanoOfDay;
            long jM = (((j4 / 86400000000000L) + (j3 / 86400) + (j2 / 1440) + (j / 24)) * j5) + Duration$$ExternalSyntheticBackport1.m(j6, 86400000000000L);
            long jM2 = Clock$TickClock$$ExternalSyntheticBackport0.m(j6, 86400000000000L);
            localTimeOfNanoOfDay = jM2 == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(jM2);
            localDatePlusDays = localDatePlusDays.plusDays(jM);
        }
        return with(localDatePlusDays, localTimeOfNanoOfDay);
    }

    private LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        return (this.date == localDate && this.time == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.of(this, zoneOffset);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j$.time.chrono.ChronoLocalDateTime
    public int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) : ChronoLocalDateTime.CC.$default$compareTo(this, chronoLocalDateTime);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return compareTo((ChronoLocalDateTime) chronoLocalDateTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : TemporalAccessor.CC.$default$get(this, temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public /* synthetic */ Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    public boolean isAfter(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) > 0 : ChronoLocalDateTime.CC.$default$isAfter(this, chronoLocalDateTime);
    }

    public boolean isBefore(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) < 0 : ChronoLocalDateTime.CC.$default$isBefore(this, chronoLocalDateTime);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField != null && temporalField.isSupportedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        return chronoField.isDateBased() || chronoField.isTimeBased();
    }

    @Override // j$.time.temporal.Temporal
    public LocalDateTime minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    @Override // j$.time.temporal.Temporal
    public LocalDateTime plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.addTo(this, j);
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j);
            case 2:
                return plusDays(j / 86400000000L).plusNanos((j % 86400000000L) * 1000);
            case 3:
                return plusDays(j / 86400000).plusNanos((j % 86400000) * 1000000);
            case 4:
                return plusSeconds(j);
            case 5:
                return plusMinutes(j);
            case 6:
                return plusHours(j);
            case 7:
                return plusDays(j / 256).plusHours((j % 256) * 12);
            default:
                return with(this.date.plus(j, temporalUnit), this.time);
        }
    }

    public LocalDateTime plusDays(long j) {
        return with(this.date.plusDays(j), this.time);
    }

    public LocalDateTime plusHours(long j) {
        return plusWithOverflow(this.date, j, 0L, 0L, 0L, 1);
    }

    public LocalDateTime plusMinutes(long j) {
        return plusWithOverflow(this.date, 0L, j, 0L, 0L, 1);
    }

    public LocalDateTime plusNanos(long j) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j, 1);
    }

    public LocalDateTime plusSeconds(long j) {
        return plusWithOverflow(this.date, 0L, 0L, j, 0L, 1);
    }

    public LocalDateTime plusWeeks(long j) {
        return with(this.date.plusWeeks(j), this.time);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public Object query(TemporalQuery temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? this.date : ChronoLocalDateTime.CC.$default$query(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public /* synthetic */ long toEpochSecond(ZoneOffset zoneOffset) {
        return ChronoLocalDateTime.CC.$default$toEpochSecond(this, zoneOffset);
    }

    public /* synthetic */ Instant toInstant(ZoneOffset zoneOffset) {
        return Instant.ofEpochSecond(toEpochSecond(zoneOffset), toLocalTime().getNano());
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public LocalDate toLocalDate() {
        return this.date;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    @Override // j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        long jM;
        long j;
        long j2;
        LocalDateTime localDateTimeFrom = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, localDateTimeFrom);
        }
        if (!temporalUnit.isTimeBased()) {
            LocalDate localDatePlusDays = localDateTimeFrom.date;
            if (localDatePlusDays.isAfter(this.date) && localDateTimeFrom.time.isBefore(this.time)) {
                localDatePlusDays = localDatePlusDays.minusDays(1L);
            } else if (localDatePlusDays.isBefore(this.date) && localDateTimeFrom.time.isAfter(this.time)) {
                localDatePlusDays = localDatePlusDays.plusDays(1L);
            }
            return this.date.until(localDatePlusDays, temporalUnit);
        }
        long jDaysUntil = this.date.daysUntil(localDateTimeFrom.date);
        if (jDaysUntil == 0) {
            return this.time.until(localDateTimeFrom.time, temporalUnit);
        }
        long nanoOfDay = localDateTimeFrom.time.toNanoOfDay() - this.time.toNanoOfDay();
        if (jDaysUntil > 0) {
            jM = jDaysUntil - 1;
            j = nanoOfDay + 86400000000000L;
        } else {
            jM = jDaysUntil + 1;
            j = nanoOfDay - 86400000000000L;
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                jM = Duration$$ExternalSyntheticBackport0.m(jM, 86400000000000L);
                break;
            case 2:
                jM = Duration$$ExternalSyntheticBackport0.m(jM, 86400000000L);
                j2 = 1000;
                j /= j2;
                break;
            case 3:
                jM = Duration$$ExternalSyntheticBackport0.m(jM, 86400000L);
                j2 = 1000000;
                j /= j2;
                break;
            case 4:
                jM = Duration$$ExternalSyntheticBackport0.m(jM, 86400L);
                j2 = 1000000000;
                j /= j2;
                break;
            case 5:
                jM = Duration$$ExternalSyntheticBackport0.m(jM, 1440L);
                j2 = 60000000000L;
                j /= j2;
                break;
            case 6:
                jM = Duration$$ExternalSyntheticBackport0.m(jM, 24L);
                j2 = 3600000000000L;
                j /= j2;
                break;
            case 7:
                jM = Duration$$ExternalSyntheticBackport0.m(jM, 2L);
                j2 = 43200000000000L;
                j /= j2;
                break;
        }
        return Clock$OffsetClock$$ExternalSyntheticBackport0.m(jM, j);
    }

    @Override // j$.time.temporal.Temporal
    public LocalDateTime with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalDate ? with((LocalDate) temporalAdjuster, this.time) : temporalAdjuster instanceof LocalTime ? with(this.date, (LocalTime) temporalAdjuster) : temporalAdjuster instanceof LocalDateTime ? (LocalDateTime) temporalAdjuster : (LocalDateTime) temporalAdjuster.adjustInto(this);
    }

    @Override // j$.time.temporal.Temporal
    public LocalDateTime with(TemporalField temporalField, long j) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? with(this.date, this.time.with(temporalField, j)) : with(this.date.with(temporalField, j), this.time) : (LocalDateTime) temporalField.adjustInto(this, j);
    }
}
