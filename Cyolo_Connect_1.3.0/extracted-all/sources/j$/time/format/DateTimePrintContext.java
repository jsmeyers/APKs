package j$.time.format;

import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.ValueRange;
import j$.util.Objects;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
final class DateTimePrintContext {
    private DateTimeFormatter formatter;
    private int optional;
    private TemporalAccessor temporal;

    DateTimePrintContext(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        this.temporal = adjust(temporalAccessor, dateTimeFormatter);
        this.formatter = dateTimeFormatter;
    }

    private static TemporalAccessor adjust(final TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        Chronology chronology = dateTimeFormatter.getChronology();
        ZoneId zone = dateTimeFormatter.getZone();
        if (chronology == null && zone == null) {
            return temporalAccessor;
        }
        Chronology chronology2 = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        final ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
        final ChronoLocalDate chronoLocalDateDate = null;
        if (Objects.equals(chronology, chronology2)) {
            chronology = null;
        }
        if (Objects.equals(zone, zoneId)) {
            zone = null;
        }
        if (chronology == null && zone == null) {
            return temporalAccessor;
        }
        final Chronology chronology3 = chronology != null ? chronology : chronology2;
        if (zone != null) {
            if (temporalAccessor.isSupported(ChronoField.INSTANT_SECONDS)) {
                if (chronology3 == null) {
                    chronology3 = IsoChronology.INSTANCE;
                }
                return chronology3.zonedDateTime(Instant.from(temporalAccessor), zone);
            }
            if (zone.normalized() instanceof ZoneOffset) {
                ChronoField chronoField = ChronoField.OFFSET_SECONDS;
                if (temporalAccessor.isSupported(chronoField) && temporalAccessor.get(chronoField) != zone.getRules().getOffset(Instant.EPOCH).getTotalSeconds()) {
                    throw new DateTimeException("Unable to apply override zone '" + zone + "' because the temporal object being formatted has a different offset but does not represent an instant: " + temporalAccessor);
                }
            }
        }
        if (zone != null) {
            zoneId = zone;
        }
        if (chronology != null) {
            if (temporalAccessor.isSupported(ChronoField.EPOCH_DAY)) {
                chronoLocalDateDate = chronology3.date(temporalAccessor);
            } else if (chronology != IsoChronology.INSTANCE || chronology2 != null) {
                for (ChronoField chronoField2 : ChronoField.values()) {
                    if (chronoField2.isDateBased() && temporalAccessor.isSupported(chronoField2)) {
                        throw new DateTimeException("Unable to apply override chronology '" + chronology + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + temporalAccessor);
                    }
                }
            }
        }
        return new TemporalAccessor() { // from class: j$.time.format.DateTimePrintContext.1
            @Override // j$.time.temporal.TemporalAccessor
            public /* synthetic */ int get(TemporalField temporalField) {
                return TemporalAccessor.CC.$default$get(this, temporalField);
            }

            @Override // j$.time.temporal.TemporalAccessor
            public long getLong(TemporalField temporalField) {
                return ((chronoLocalDateDate == null || !temporalField.isDateBased()) ? temporalAccessor : chronoLocalDateDate).getLong(temporalField);
            }

            @Override // j$.time.temporal.TemporalAccessor
            public boolean isSupported(TemporalField temporalField) {
                return (chronoLocalDateDate == null || !temporalField.isDateBased()) ? temporalAccessor.isSupported(temporalField) : chronoLocalDateDate.isSupported(temporalField);
            }

            @Override // j$.time.temporal.TemporalAccessor
            public Object query(TemporalQuery temporalQuery) {
                return temporalQuery == TemporalQueries.chronology() ? chronology3 : temporalQuery == TemporalQueries.zoneId() ? zoneId : temporalQuery == TemporalQueries.precision() ? temporalAccessor.query(temporalQuery) : temporalQuery.queryFrom(this);
            }

            @Override // j$.time.temporal.TemporalAccessor
            public ValueRange range(TemporalField temporalField) {
                return ((chronoLocalDateDate == null || !temporalField.isDateBased()) ? temporalAccessor : chronoLocalDateDate).range(temporalField);
            }
        };
    }

    void endOptional() {
        this.optional--;
    }

    DecimalStyle getDecimalStyle() {
        return this.formatter.getDecimalStyle();
    }

    Locale getLocale() {
        return this.formatter.getLocale();
    }

    TemporalAccessor getTemporal() {
        return this.temporal;
    }

    Long getValue(TemporalField temporalField) {
        try {
            return Long.valueOf(this.temporal.getLong(temporalField));
        } catch (DateTimeException e) {
            if (this.optional > 0) {
                return null;
            }
            throw e;
        }
    }

    Object getValue(TemporalQuery temporalQuery) {
        Object objQuery = this.temporal.query(temporalQuery);
        if (objQuery != null || this.optional != 0) {
            return objQuery;
        }
        throw new DateTimeException("Unable to extract value: " + this.temporal.getClass());
    }

    void startOptional() {
        this.optional++;
    }

    public String toString() {
        return this.temporal.toString();
    }
}
