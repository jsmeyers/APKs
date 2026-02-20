package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.ValueRange;
import j$.util.Objects;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface Chronology extends Comparable {

    /* JADX INFO: renamed from: j$.time.chrono.Chronology$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static Chronology from(TemporalAccessor temporalAccessor) {
            Objects.requireNonNull(temporalAccessor, "temporal");
            Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
            return chronology != null ? chronology : IsoChronology.INSTANCE;
        }
    }

    int compareTo(Chronology chronology);

    ChronoLocalDate date(int i, int i2, int i3);

    ChronoLocalDate date(TemporalAccessor temporalAccessor);

    ChronoLocalDate dateEpochDay(long j);

    ChronoLocalDate dateYearDay(int i, int i2);

    boolean equals(Object obj);

    String getId();

    ValueRange range(ChronoField chronoField);

    ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle);

    ChronoZonedDateTime zonedDateTime(Instant instant, ZoneId zoneId);
}
