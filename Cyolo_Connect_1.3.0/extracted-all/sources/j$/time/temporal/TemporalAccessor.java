package j$.time.temporal;

import j$.time.DateTimeException;
import j$.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public interface TemporalAccessor {

    /* JADX INFO: renamed from: j$.time.temporal.TemporalAccessor$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static int $default$get(TemporalAccessor temporalAccessor, TemporalField temporalField) {
            ValueRange valueRangeRange = temporalAccessor.range(temporalField);
            if (!valueRangeRange.isIntValue()) {
                throw new UnsupportedTemporalTypeException("Invalid field " + temporalField + " for get() method, use getLong() instead");
            }
            long j = temporalAccessor.getLong(temporalField);
            if (valueRangeRange.isValidValue(j)) {
                return (int) j;
            }
            throw new DateTimeException("Invalid value for " + temporalField + " (valid values " + valueRangeRange + "): " + j);
        }

        public static Object $default$query(TemporalAccessor temporalAccessor, TemporalQuery temporalQuery) {
            if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.precision()) {
                return null;
            }
            return temporalQuery.queryFrom(temporalAccessor);
        }

        public static ValueRange $default$range(TemporalAccessor temporalAccessor, TemporalField temporalField) {
            if (!(temporalField instanceof ChronoField)) {
                Objects.requireNonNull(temporalField, "field");
                return temporalField.rangeRefinedBy(temporalAccessor);
            }
            if (temporalAccessor.isSupported(temporalField)) {
                return temporalField.range();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    int get(TemporalField temporalField);

    long getLong(TemporalField temporalField);

    boolean isSupported(TemporalField temporalField);

    Object query(TemporalQuery temporalQuery);

    ValueRange range(TemporalField temporalField);
}
