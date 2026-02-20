package j$.time;

import androidx.core.app.NotificationManagerCompat;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import j$.util.Objects;
import java.io.Serializable;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes4.dex */
public final class Instant implements Temporal, TemporalAdjuster, Comparable<Instant>, Serializable {
    private final int nanos;
    private final long seconds;
    public static final Instant EPOCH = new Instant(0, 0);
    public static final Instant MIN = ofEpochSecond(-31557014167219200L, 0);
    public static final Instant MAX = ofEpochSecond(31556889864403199L, 999999999);

    /* JADX INFO: renamed from: j$.time.Instant$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;
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
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.DAYS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.INSTANT_SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private Instant(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    private static Instant create(long j, int i) {
        if ((((long) i) | j) == 0) {
            return EPOCH;
        }
        if (j < -31557014167219200L || j > 31556889864403199L) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j, i);
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return (Instant) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            return ofEpochSecond(temporalAccessor.getLong(ChronoField.INSTANT_SECONDS), temporalAccessor.get(ChronoField.NANO_OF_SECOND));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    private long nanosUntil(Instant instant) {
        return Clock$OffsetClock$$ExternalSyntheticBackport0.m(Duration$$ExternalSyntheticBackport0.m(Instant$$ExternalSyntheticBackport0.m(instant.seconds, this.seconds), 1000000000L), instant.nanos - this.nanos);
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant ofEpochMilli(long j) {
        return create(Duration$$ExternalSyntheticBackport1.m(j, 1000L), ((int) Clock$TickClock$$ExternalSyntheticBackport0.m(j, 1000L)) * DurationKt.NANOS_IN_MILLIS);
    }

    public static Instant ofEpochSecond(long j) {
        return create(j, 0);
    }

    public static Instant ofEpochSecond(long j, long j2) {
        return create(Clock$OffsetClock$$ExternalSyntheticBackport0.m(j, Duration$$ExternalSyntheticBackport1.m(j2, 1000000000L)), (int) Clock$TickClock$$ExternalSyntheticBackport0.m(j2, 1000000000L));
    }

    private Instant plus(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return ofEpochSecond(Clock$OffsetClock$$ExternalSyntheticBackport0.m(Clock$OffsetClock$$ExternalSyntheticBackport0.m(this.seconds, j), j2 / 1000000000), ((long) this.nanos) + (j2 % 1000000000));
    }

    private long secondsUntil(Instant instant) {
        long jM = Instant$$ExternalSyntheticBackport0.m(instant.seconds, this.seconds);
        long j = instant.nanos - this.nanos;
        return (jM <= 0 || j >= 0) ? (jM >= 0 || j <= 0) ? jM : jM + 1 : jM - 1;
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.ofInstant(this, zoneOffset);
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.ofInstant(this, zoneId);
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        int iCompare = Long.compare(this.seconds, instant.seconds);
        return iCompare != 0 ? iCompare : this.nanos - instant.nanos;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.seconds == instant.seconds && this.nanos == instant.nanos;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(temporalField.getFrom(this), temporalField);
        }
        int i = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i == 1) {
            return this.nanos;
        }
        if (i == 2) {
            return this.nanos / 1000;
        }
        if (i == 3) {
            return this.nanos / DurationKt.NANOS_IN_MILLIS;
        }
        if (i == 4) {
            ChronoField.INSTANT_SECONDS.checkValidIntValue(this.seconds);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        int i;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i2 = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i2 == 1) {
            i = this.nanos;
        } else if (i2 == 2) {
            i = this.nanos / 1000;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    return this.seconds;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
            i = this.nanos / DurationKt.NANOS_IN_MILLIS;
        }
        return i;
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long j = this.seconds;
        return ((int) (j ^ (j >>> 32))) + (this.nanos * 51);
    }

    public boolean isAfter(Instant instant) {
        return compareTo(instant) > 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.NANO_OF_SECOND || temporalField == ChronoField.MICRO_OF_SECOND || temporalField == ChronoField.MILLI_OF_SECOND : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.Temporal
    public Instant minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    public Instant minus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.subtractFrom(this);
    }

    @Override // j$.time.temporal.Temporal
    public Instant plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.addTo(this, j);
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j);
            case 2:
                return plus(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return plusMillis(j);
            case 4:
                return plusSeconds(j);
            case 5:
                return plusSeconds(Duration$$ExternalSyntheticBackport0.m(j, 60L));
            case 6:
                return plusSeconds(Duration$$ExternalSyntheticBackport0.m(j, 3600L));
            case 7:
                return plusSeconds(Duration$$ExternalSyntheticBackport0.m(j, 43200L));
            case 8:
                return plusSeconds(Duration$$ExternalSyntheticBackport0.m(j, 86400L));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public Instant plus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.addTo(this);
    }

    public Instant plusMillis(long j) {
        return plus(j / 1000, (j % 1000) * 1000000);
    }

    public Instant plusNanos(long j) {
        return plus(0L, j);
    }

    public Instant plusSeconds(long j) {
        return plus(j, 0L);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public Object query(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.precision()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localDate() || temporalQuery == TemporalQueries.localTime()) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return TemporalAccessor.CC.$default$range(this, temporalField);
    }

    public long toEpochMilli() {
        long jM;
        int i;
        long j = this.seconds;
        if (j >= 0 || this.nanos <= 0) {
            jM = Duration$$ExternalSyntheticBackport0.m(j, 1000L);
            i = this.nanos / DurationKt.NANOS_IN_MILLIS;
        } else {
            jM = Duration$$ExternalSyntheticBackport0.m(j + 1, 1000L);
            i = (this.nanos / DurationKt.NANOS_IN_MILLIS) + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        }
        return Clock$OffsetClock$$ExternalSyntheticBackport0.m(jM, i);
    }

    public String toString() {
        return DateTimeFormatter.ISO_INSTANT.format(this);
    }

    @Override // j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Instant instantFrom = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, instantFrom);
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return nanosUntil(instantFrom);
            case 2:
                return nanosUntil(instantFrom) / 1000;
            case 3:
                return Instant$$ExternalSyntheticBackport0.m(instantFrom.toEpochMilli(), toEpochMilli());
            case 4:
                return secondsUntil(instantFrom);
            case 5:
                return secondsUntil(instantFrom) / 60;
            case 6:
                return secondsUntil(instantFrom) / 3600;
            case 7:
                return secondsUntil(instantFrom) / 43200;
            case 8:
                return secondsUntil(instantFrom) / 86400;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // j$.time.temporal.Temporal
    public Instant with(TemporalAdjuster temporalAdjuster) {
        return (Instant) temporalAdjuster.adjustInto(this);
    }

    @Override // j$.time.temporal.Temporal
    public Instant with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (Instant) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j);
        int i = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()];
        if (i == 1) {
            return j != ((long) this.nanos) ? create(this.seconds, (int) j) : this;
        }
        if (i == 2) {
            int i2 = ((int) j) * 1000;
            return i2 != this.nanos ? create(this.seconds, i2) : this;
        }
        if (i == 3) {
            int i3 = ((int) j) * DurationKt.NANOS_IN_MILLIS;
            return i3 != this.nanos ? create(this.seconds, i3) : this;
        }
        if (i == 4) {
            return j != this.seconds ? create(j, this.nanos) : this;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }
}
