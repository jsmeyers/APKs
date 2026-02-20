package j$.time.temporal;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.Chronology;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TemporalQueries {
    static final TemporalQuery ZONE_ID = new TemporalQuery() { // from class: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return TemporalQueries.lambda$static$0(temporalAccessor);
        }
    };
    static final TemporalQuery CHRONO = new TemporalQuery() { // from class: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return TemporalQueries.lambda$static$1(temporalAccessor);
        }
    };
    static final TemporalQuery PRECISION = new TemporalQuery() { // from class: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda2
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return TemporalQueries.lambda$static$2(temporalAccessor);
        }
    };
    static final TemporalQuery OFFSET = new TemporalQuery() { // from class: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda3
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return TemporalQueries.lambda$static$3(temporalAccessor);
        }
    };
    static final TemporalQuery ZONE = new TemporalQuery() { // from class: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda4
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return TemporalQueries.lambda$static$4(temporalAccessor);
        }
    };
    static final TemporalQuery LOCAL_DATE = new TemporalQuery() { // from class: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda5
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return TemporalQueries.lambda$static$5(temporalAccessor);
        }
    };
    static final TemporalQuery LOCAL_TIME = new TemporalQuery() { // from class: j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda6
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return TemporalQueries.lambda$static$6(temporalAccessor);
        }
    };

    public static TemporalQuery chronology() {
        return CHRONO;
    }

    static /* synthetic */ ZoneId lambda$static$0(TemporalAccessor temporalAccessor) {
        return (ZoneId) temporalAccessor.query(ZONE_ID);
    }

    static /* synthetic */ Chronology lambda$static$1(TemporalAccessor temporalAccessor) {
        return (Chronology) temporalAccessor.query(CHRONO);
    }

    static /* synthetic */ TemporalUnit lambda$static$2(TemporalAccessor temporalAccessor) {
        return (TemporalUnit) temporalAccessor.query(PRECISION);
    }

    static /* synthetic */ ZoneOffset lambda$static$3(TemporalAccessor temporalAccessor) {
        ChronoField chronoField = ChronoField.OFFSET_SECONDS;
        if (temporalAccessor.isSupported(chronoField)) {
            return ZoneOffset.ofTotalSeconds(temporalAccessor.get(chronoField));
        }
        return null;
    }

    static /* synthetic */ ZoneId lambda$static$4(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.query(ZONE_ID);
        return zoneId != null ? zoneId : (ZoneId) temporalAccessor.query(OFFSET);
    }

    static /* synthetic */ LocalDate lambda$static$5(TemporalAccessor temporalAccessor) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (temporalAccessor.isSupported(chronoField)) {
            return LocalDate.ofEpochDay(temporalAccessor.getLong(chronoField));
        }
        return null;
    }

    static /* synthetic */ LocalTime lambda$static$6(TemporalAccessor temporalAccessor) {
        ChronoField chronoField = ChronoField.NANO_OF_DAY;
        if (temporalAccessor.isSupported(chronoField)) {
            return LocalTime.ofNanoOfDay(temporalAccessor.getLong(chronoField));
        }
        return null;
    }

    public static TemporalQuery localDate() {
        return LOCAL_DATE;
    }

    public static TemporalQuery localTime() {
        return LOCAL_TIME;
    }

    public static TemporalQuery offset() {
        return OFFSET;
    }

    public static TemporalQuery precision() {
        return PRECISION;
    }

    public static TemporalQuery zone() {
        return ZONE;
    }

    public static TemporalQuery zoneId() {
        return ZONE_ID;
    }
}
