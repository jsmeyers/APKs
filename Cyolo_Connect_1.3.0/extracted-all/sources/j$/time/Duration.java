package j$.time;

import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;
import kotlin.time.DurationKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private final int nanos;
    private final long seconds;
    public static final Duration ZERO = new Duration(0, 0);
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);

    /* JADX INFO: renamed from: j$.time.Duration$1, reason: invalid class name */
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
        }
    }

    private Duration(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    public static Duration between(Temporal temporal, Temporal temporal2) {
        try {
            return ofNanos(temporal.until(temporal2, ChronoUnit.NANOS));
        } catch (DateTimeException | ArithmeticException unused) {
            long jUntil = temporal.until(temporal2, ChronoUnit.SECONDS);
            long j = 0;
            try {
                ChronoField chronoField = ChronoField.NANO_OF_SECOND;
                long j2 = temporal2.getLong(chronoField) - temporal.getLong(chronoField);
                if (jUntil > 0 && j2 < 0) {
                    jUntil++;
                } else if (jUntil < 0 && j2 > 0) {
                    jUntil--;
                }
                j = j2;
            } catch (DateTimeException unused2) {
            }
            return ofSeconds(jUntil, j);
        }
    }

    private static Duration create(long j, int i) {
        return (((long) i) | j) == 0 ? ZERO : new Duration(j, i);
    }

    private static Duration create(BigDecimal bigDecimal) {
        BigInteger bigIntegerExact = bigDecimal.movePointRight(9).toBigIntegerExact();
        BigInteger[] bigIntegerArrDivideAndRemainder = bigIntegerExact.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (bigIntegerArrDivideAndRemainder[0].bitLength() <= 63) {
            return ofSeconds(bigIntegerArrDivideAndRemainder[0].longValue(), bigIntegerArrDivideAndRemainder[1].intValue());
        }
        throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
    }

    public static Duration ofMillis(long j) {
        long j2 = j / 1000;
        int i = (int) (j % 1000);
        if (i < 0) {
            i += 1000;
            j2--;
        }
        return create(j2, i * DurationKt.NANOS_IN_MILLIS);
    }

    public static Duration ofMinutes(long j) {
        return create(Duration$$ExternalSyntheticBackport0.m(j, 60L), 0);
    }

    public static Duration ofNanos(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i = (int) (((long) i) + 1000000000);
            j2--;
        }
        return create(j2, i);
    }

    public static Duration ofSeconds(long j) {
        return create(j, 0);
    }

    public static Duration ofSeconds(long j, long j2) {
        return create(Clock$OffsetClock$$ExternalSyntheticBackport0.m(j, Duration$$ExternalSyntheticBackport1.m(j2, 1000000000L)), (int) Clock$TickClock$$ExternalSyntheticBackport0.m(j2, 1000000000L));
    }

    private Duration plus(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return ofSeconds(Clock$OffsetClock$$ExternalSyntheticBackport0.m(Clock$OffsetClock$$ExternalSyntheticBackport0.m(this.seconds, j), j2 / 1000000000), ((long) this.nanos) + (j2 % 1000000000));
    }

    private BigDecimal toSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9));
    }

    public Duration abs() {
        return isNegative() ? negated() : this;
    }

    @Override // j$.time.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        long j = this.seconds;
        if (j != 0) {
            temporal = temporal.plus(j, ChronoUnit.SECONDS);
        }
        int i = this.nanos;
        return i != 0 ? temporal.plus(i, ChronoUnit.NANOS) : temporal;
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        int iCompare = Long.compare(this.seconds, duration.seconds);
        return iCompare != 0 ? iCompare : this.nanos - duration.nanos;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.seconds == duration.seconds && this.nanos == duration.nanos;
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j = this.seconds;
        return ((int) (j ^ (j >>> 32))) + (this.nanos * 51);
    }

    public boolean isNegative() {
        return this.seconds < 0;
    }

    public boolean isZero() {
        return (this.seconds | ((long) this.nanos)) == 0;
    }

    public Duration minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    public Duration multipliedBy(long j) {
        return j == 0 ? ZERO : j == 1 ? this : create(toSeconds().multiply(BigDecimal.valueOf(j)));
    }

    public Duration negated() {
        return multipliedBy(-1L);
    }

    public Duration plus(long j, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporalUnit, "unit");
        if (temporalUnit == ChronoUnit.DAYS) {
            return plus(Duration$$ExternalSyntheticBackport0.m(j, 86400L), 0L);
        }
        if (temporalUnit.isDurationEstimated()) {
            throw new UnsupportedTemporalTypeException("Unit must not have an estimated duration");
        }
        if (j == 0) {
            return this;
        }
        if (temporalUnit instanceof ChronoUnit) {
            int i = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? plusSeconds(Duration$$ExternalSyntheticBackport0.m(temporalUnit.getDuration().seconds, j)) : plusSeconds(j) : plusMillis(j) : plusSeconds((j / 1000000000) * 1000).plusNanos((j % 1000000000) * 1000) : plusNanos(j);
        }
        return plusSeconds(temporalUnit.getDuration().multipliedBy(j).getSeconds()).plusNanos(r7.getNano());
    }

    public Duration plusMillis(long j) {
        return plus(j / 1000, (j % 1000) * 1000000);
    }

    public Duration plusNanos(long j) {
        return plus(0L, j);
    }

    public Duration plusSeconds(long j) {
        return plus(j, 0L);
    }

    @Override // j$.time.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        long j = this.seconds;
        if (j != 0) {
            temporal = temporal.minus(j, ChronoUnit.SECONDS);
        }
        int i = this.nanos;
        return i != 0 ? temporal.minus(i, ChronoUnit.NANOS) : temporal;
    }

    public long toMillis() {
        return Clock$OffsetClock$$ExternalSyntheticBackport0.m(Duration$$ExternalSyntheticBackport0.m(this.seconds, 1000L), this.nanos / DurationKt.NANOS_IN_MILLIS);
    }

    public long toNanos() {
        return Clock$OffsetClock$$ExternalSyntheticBackport0.m(Duration$$ExternalSyntheticBackport0.m(this.seconds, 1000000000L), this.nanos);
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j = this.seconds;
        long j2 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i2 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i2 == 0 && this.nanos == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i2 >= 0 || this.nanos <= 0) {
            sb.append(i2);
        } else if (i2 == -1) {
            sb.append("-0");
        } else {
            sb.append(i2 + 1);
        }
        if (this.nanos > 0) {
            int length = sb.length();
            if (i2 < 0) {
                sb.append(2000000000 - ((long) this.nanos));
            } else {
                sb.append(((long) this.nanos) + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, FilenameUtils.EXTENSION_SEPARATOR);
        }
        sb.append('S');
        return sb.toString();
    }
}
