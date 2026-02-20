package j$.time;

import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalQueries;
import j$.util.Objects;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class Period implements TemporalAmount, Serializable {
    private final int days;
    private final int months;
    private final int years;
    public static final Period ZERO = new Period(0, 0, 0);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    private static final List SUPPORTED_UNITS = Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));

    private Period(int i, int i2, int i3) {
        this.years = i;
        this.months = i2;
        this.days = i3;
    }

    private static Period create(int i, int i2, int i3) {
        return ((i | i2) | i3) == 0 ? ZERO : new Period(i, i2, i3);
    }

    public static Period ofDays(int i) {
        return create(0, 0, i);
    }

    private void validateChrono(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology == null || IsoChronology.INSTANCE.equals(chronology)) {
            return;
        }
        throw new DateTimeException("Chronology mismatch, expected: ISO, actual: " + chronology.getId());
    }

    @Override // j$.time.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        long totalMonths;
        ChronoUnit chronoUnit;
        validateChrono(temporal);
        if (this.months == 0) {
            int i = this.years;
            if (i != 0) {
                totalMonths = i;
                chronoUnit = ChronoUnit.YEARS;
                temporal = temporal.plus(totalMonths, chronoUnit);
            }
        } else {
            totalMonths = toTotalMonths();
            if (totalMonths != 0) {
                chronoUnit = ChronoUnit.MONTHS;
                temporal = temporal.plus(totalMonths, chronoUnit);
            }
        }
        int i2 = this.days;
        return i2 != 0 ? temporal.plus(i2, ChronoUnit.DAYS) : temporal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.years == period.years && this.months == period.months && this.days == period.days;
    }

    public int getDays() {
        return this.days;
    }

    public int hashCode() {
        return this.years + Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.days, 16);
    }

    public boolean isZero() {
        return this == ZERO;
    }

    @Override // j$.time.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        long totalMonths;
        ChronoUnit chronoUnit;
        validateChrono(temporal);
        if (this.months == 0) {
            int i = this.years;
            if (i != 0) {
                totalMonths = i;
                chronoUnit = ChronoUnit.YEARS;
                temporal = temporal.minus(totalMonths, chronoUnit);
            }
        } else {
            totalMonths = toTotalMonths();
            if (totalMonths != 0) {
                chronoUnit = ChronoUnit.MONTHS;
                temporal = temporal.minus(totalMonths, chronoUnit);
            }
        }
        int i2 = this.days;
        return i2 != 0 ? temporal.minus(i2, ChronoUnit.DAYS) : temporal;
    }

    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int i = this.years;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.months;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.days;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    public long toTotalMonths() {
        return (((long) this.years) * 12) + ((long) this.months);
    }
}
