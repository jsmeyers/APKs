package j$.time.temporal;

import j$.time.Clock$OffsetClock$$ExternalSyntheticBackport0;
import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.Duration;
import j$.time.Duration$$ExternalSyntheticBackport0;
import j$.time.Instant$$ExternalSyntheticBackport0;
import j$.time.LocalDate;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.format.ResolverStyle;
import j$.time.temporal.TemporalField;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IsoFields {
    public static final TemporalField DAY_OF_QUARTER = Field.DAY_OF_QUARTER;
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalUnit WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
    public static final TemporalUnit QUARTER_YEARS = Unit.QUARTER_YEARS;

    /* JADX INFO: renamed from: j$.time.temporal.IsoFields$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$IsoFields$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$java$time$temporal$IsoFields$Unit = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$IsoFields$Unit[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum Field implements TemporalField {
        DAY_OF_QUARTER { // from class: j$.time.temporal.IsoFields.Field.1
            @Override // j$.time.temporal.TemporalField
            public Temporal adjustInto(Temporal temporal, long j) {
                long from = getFrom(temporal);
                range().checkValidValue(j, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return temporal.with(chronoField, temporal.getLong(chronoField) + (j - from));
            }

            @Override // j$.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.get(ChronoField.DAY_OF_YEAR) - Field.QUARTER_DAYS[((temporalAccessor.get(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? 4 : 0)];
            }

            @Override // j$.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.DAY_OF_YEAR) && temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && temporalAccessor.isSupported(ChronoField.YEAR) && Field.isIso(temporalAccessor);
            }

            @Override // j$.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 90L, 92L);
            }

            @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (!isSupportedBy(temporalAccessor)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long j = temporalAccessor.getLong(Field.QUARTER_OF_YEAR);
                if (j == 1) {
                    return IsoChronology.INSTANCE.isLeapYear(temporalAccessor.getLong(ChronoField.YEAR)) ? ValueRange.of(1L, 91L) : ValueRange.of(1L, 90L);
                }
                return j == 2 ? ValueRange.of(1L, 91L) : (j == 3 || j == 4) ? ValueRange.of(1L, 92L) : range();
            }

            @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
            public ChronoLocalDate resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDateOf;
                long jM;
                ChronoField chronoField = ChronoField.YEAR;
                Long l = (Long) map.get(chronoField);
                TemporalField temporalField = Field.QUARTER_OF_YEAR;
                Long l2 = (Long) map.get(temporalField);
                if (l == null || l2 == null) {
                    return null;
                }
                int iCheckValidIntValue = chronoField.checkValidIntValue(l.longValue());
                long jLongValue = ((Long) map.get(Field.DAY_OF_QUARTER)).longValue();
                Field.ensureIso(temporalAccessor);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    localDateOf = LocalDate.of(iCheckValidIntValue, 1, 1).plusMonths(Duration$$ExternalSyntheticBackport0.m(Instant$$ExternalSyntheticBackport0.m(l2.longValue(), 1L), 3L));
                    jM = Instant$$ExternalSyntheticBackport0.m(jLongValue, 1L);
                } else {
                    localDateOf = LocalDate.of(iCheckValidIntValue, ((temporalField.range().checkValidIntValue(l2.longValue(), temporalField) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        (resolverStyle == ResolverStyle.STRICT ? rangeRefinedBy(localDateOf) : range()).checkValidValue(jLongValue, this);
                    }
                    jM = jLongValue - 1;
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(temporalField);
                return localDateOf.plusDays(jM);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR { // from class: j$.time.temporal.IsoFields.Field.2
            @Override // j$.time.temporal.TemporalField
            public Temporal adjustInto(Temporal temporal, long j) {
                long from = getFrom(temporal);
                range().checkValidValue(j, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return temporal.with(chronoField, temporal.getLong(chronoField) + ((j - from) * 3));
            }

            @Override // j$.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return (temporalAccessor.getLong(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            @Override // j$.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.MONTH_OF_YEAR) && Field.isIso(temporalAccessor);
            }

            @Override // j$.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 4L);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR { // from class: j$.time.temporal.IsoFields.Field.3
            @Override // j$.time.temporal.TemporalField
            public Temporal adjustInto(Temporal temporal, long j) {
                range().checkValidValue(j, this);
                return temporal.plus(Instant$$ExternalSyntheticBackport0.m(j, getFrom(temporal)), ChronoUnit.WEEKS);
            }

            @Override // j$.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return Field.getWeek(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(temporalAccessor);
            }

            @Override // j$.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 52L, 53L);
            }

            @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return Field.getWeekRange(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.IsoFields.Field, j$.time.temporal.TemporalField
            public ChronoLocalDate resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDateWith;
                long j;
                long j2;
                TemporalField temporalField = Field.WEEK_BASED_YEAR;
                Long l = (Long) map.get(temporalField);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l2 = (Long) map.get(chronoField);
                if (l == null || l2 == null) {
                    return null;
                }
                int iCheckValidIntValue = temporalField.range().checkValidIntValue(l.longValue(), temporalField);
                long jLongValue = ((Long) map.get(Field.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                Field.ensureIso(temporalAccessor);
                LocalDate localDateOf = LocalDate.of(iCheckValidIntValue, 1, 4);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long jLongValue2 = l2.longValue();
                    if (jLongValue2 > 7) {
                        j2 = jLongValue2 - 1;
                        localDateOf = localDateOf.plusWeeks(j2 / 7);
                    } else {
                        j = 1;
                        if (jLongValue2 < 1) {
                            localDateOf = localDateOf.plusWeeks(Instant$$ExternalSyntheticBackport0.m(jLongValue2, 7L) / 7);
                            j2 = jLongValue2 + 6;
                        }
                        localDateWith = localDateOf.plusWeeks(Instant$$ExternalSyntheticBackport0.m(jLongValue, j)).with((TemporalField) chronoField, jLongValue2);
                    }
                    j = 1;
                    jLongValue2 = (j2 % 7) + 1;
                    localDateWith = localDateOf.plusWeeks(Instant$$ExternalSyntheticBackport0.m(jLongValue, j)).with((TemporalField) chronoField, jLongValue2);
                } else {
                    int iCheckValidIntValue2 = chronoField.checkValidIntValue(l2.longValue());
                    if (jLongValue < 1 || jLongValue > 52) {
                        (resolverStyle == ResolverStyle.STRICT ? Field.getWeekRange(localDateOf) : range()).checkValidValue(jLongValue, this);
                    }
                    localDateWith = localDateOf.plusWeeks(jLongValue - 1).with((TemporalField) chronoField, iCheckValidIntValue2);
                }
                map.remove(this);
                map.remove(temporalField);
                map.remove(chronoField);
                return localDateWith;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR { // from class: j$.time.temporal.IsoFields.Field.4
            @Override // j$.time.temporal.TemporalField
            public Temporal adjustInto(Temporal temporal, long j) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int iCheckValidIntValue = range().checkValidIntValue(j, Field.WEEK_BASED_YEAR);
                LocalDate localDateFrom = LocalDate.from(temporal);
                int i = localDateFrom.get(ChronoField.DAY_OF_WEEK);
                int week = Field.getWeek(localDateFrom);
                if (week == 53 && Field.getWeekRange(iCheckValidIntValue) == 52) {
                    week = 52;
                }
                return temporal.with(LocalDate.of(iCheckValidIntValue, 1, 4).plusDays((i - r6.get(r0)) + ((week - 1) * 7)));
            }

            @Override // j$.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporalAccessor) {
                if (isSupportedBy(temporalAccessor)) {
                    return Field.getWeekBasedYear(LocalDate.from(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
                return temporalAccessor.isSupported(ChronoField.EPOCH_DAY) && Field.isIso(temporalAccessor);
            }

            @Override // j$.time.temporal.TemporalField
            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
        };

        private static final int[] QUARTER_DAYS = {0, 90, 181, 273, 0, 91, 182, 274};

        /* synthetic */ Field(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void ensureIso(TemporalAccessor temporalAccessor) {
            if (!isIso(temporalAccessor)) {
                throw new DateTimeException("Resolve requires IsoChronology");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeek(LocalDate localDate) {
            int iOrdinal = localDate.getDayOfWeek().ordinal();
            int dayOfYear = localDate.getDayOfYear() - 1;
            int i = (3 - iOrdinal) + dayOfYear;
            int i2 = (i - ((i / 7) * 7)) - 3;
            if (i2 < -3) {
                i2 += 7;
            }
            if (dayOfYear < i2) {
                return (int) getWeekRange(localDate.withDayOfYear(180).minusYears(1L)).getMaximum();
            }
            int i3 = ((dayOfYear - i2) / 7) + 1;
            if (i3 == 53) {
                if (!(i2 == -3 || (i2 == -2 && localDate.isLeapYear()))) {
                    return 1;
                }
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                return dayOfYear - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
            }
            if (dayOfYear >= 363) {
                return ((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
            }
            return year;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekRange(int i) {
            LocalDate localDateOf = LocalDate.of(i, 1, 1);
            if (localDateOf.getDayOfWeek() != DayOfWeek.THURSDAY) {
                return (localDateOf.getDayOfWeek() == DayOfWeek.WEDNESDAY && localDateOf.isLeapYear()) ? 53 : 52;
            }
            return 53;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ValueRange getWeekRange(LocalDate localDate) {
            return ValueRange.of(1L, getWeekRange(getWeekBasedYear(localDate)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isIso(TemporalAccessor temporalAccessor) {
            return Chronology.CC.from(temporalAccessor).equals(IsoChronology.INSTANCE);
        }

        @Override // j$.time.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // j$.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            return range();
        }

        @Override // j$.time.temporal.TemporalField
        public /* synthetic */ TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return TemporalField.CC.$default$resolve(this, map, temporalAccessor, resolverStyle);
        }
    }

    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));

        private final Duration duration;
        private final String name;

        Unit(String str, Duration duration) {
            this.name = str;
            this.duration = duration;
        }

        @Override // j$.time.temporal.TemporalUnit
        public Temporal addTo(Temporal temporal, long j) {
            int i = AnonymousClass1.$SwitchMap$java$time$temporal$IsoFields$Unit[ordinal()];
            if (i == 1) {
                return temporal.with(IsoFields.WEEK_BASED_YEAR, Clock$OffsetClock$$ExternalSyntheticBackport0.m(temporal.get(r0), j));
            }
            if (i == 2) {
                return temporal.plus(j / 256, ChronoUnit.YEARS).plus((j % 256) * 3, ChronoUnit.MONTHS);
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // j$.time.temporal.TemporalUnit
        public long between(Temporal temporal, Temporal temporal2) {
            if (temporal.getClass() != temporal2.getClass()) {
                return temporal.until(temporal2, this);
            }
            int i = AnonymousClass1.$SwitchMap$java$time$temporal$IsoFields$Unit[ordinal()];
            if (i == 1) {
                TemporalField temporalField = IsoFields.WEEK_BASED_YEAR;
                return Instant$$ExternalSyntheticBackport0.m(temporal2.getLong(temporalField), temporal.getLong(temporalField));
            }
            if (i == 2) {
                return temporal.until(temporal2, ChronoUnit.MONTHS) / 3;
            }
            throw new IllegalStateException("Unreachable");
        }

        @Override // j$.time.temporal.TemporalUnit
        public Duration getDuration() {
            return this.duration;
        }

        @Override // j$.time.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalUnit
        public boolean isDurationEstimated() {
            return true;
        }

        @Override // j$.time.temporal.TemporalUnit
        public boolean isTimeBased() {
            return false;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }
}
