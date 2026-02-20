package j$.time;

import j$.time.temporal.ChronoField;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import j$.time.zone.ZoneRules;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset> {
    private final transient String id;
    private final int totalSeconds;
    private static final ConcurrentMap SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    public static final ZoneOffset MAX = ofTotalSeconds(64800);

    private ZoneOffset(int i) {
        this.totalSeconds = i;
        this.id = buildId(i);
    }

    private static String buildId(int i) {
        if (i == 0) {
            return "Z";
        }
        int iAbs = Math.abs(i);
        StringBuilder sb = new StringBuilder();
        int i2 = iAbs / 3600;
        int i3 = (iAbs / 60) % 60;
        sb.append(i < 0 ? "-" : Marker.ANY_NON_NULL_MARKER);
        sb.append(i2 < 10 ? "0" : "");
        sb.append(i2);
        sb.append(i3 < 10 ? ":0" : ":");
        sb.append(i3);
        int i4 = iAbs % 60;
        if (i4 != 0) {
            sb.append(i4 >= 10 ? ":" : ":0");
            sb.append(i4);
        }
        return sb.toString();
    }

    public static ZoneOffset from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.query(TemporalQueries.offset());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    /* JADX WARN: Found duplicated region for block: B:28:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Found duplicated region for block: B:35:0x00bd  */
    public static ZoneOffset of(String str) {
        int number;
        int number2;
        int number3;
        char cCharAt;
        Objects.requireNonNull(str, "offsetId");
        ZoneOffset zoneOffset = (ZoneOffset) ID_CACHE.get(str);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        int length = str.length();
        if (length != 2) {
            if (length != 3) {
                if (length != 5) {
                    if (length == 6) {
                        number = parseNumber(str, 1, false);
                        number2 = parseNumber(str, 4, true);
                    } else if (length == 7) {
                        number = parseNumber(str, 1, false);
                        number2 = parseNumber(str, 3, false);
                        number3 = parseNumber(str, 5, false);
                    } else {
                        if (length != 9) {
                            throw new DateTimeException("Invalid ID for ZoneOffset, invalid format: " + str);
                        }
                        number = parseNumber(str, 1, false);
                        number2 = parseNumber(str, 4, true);
                        number3 = parseNumber(str, 7, true);
                    }
                    cCharAt = str.charAt(0);
                    if (cCharAt != '+' || cCharAt == '-') {
                        return cCharAt == '-' ? ofHoursMinutesSeconds(-number, -number2, -number3) : ofHoursMinutesSeconds(number, number2, number3);
                    }
                    throw new DateTimeException("Invalid ID for ZoneOffset, plus/minus not found when expected: " + str);
                }
                number = parseNumber(str, 1, false);
                number2 = parseNumber(str, 3, false);
            }
            number3 = 0;
            cCharAt = str.charAt(0);
            if (cCharAt != '+') {
            }
            if (cCharAt == '-') {
            }
        }
        str = str.charAt(0) + "0" + str.charAt(1);
        number = parseNumber(str, 1, false);
        number2 = 0;
        number3 = 0;
        cCharAt = str.charAt(0);
        if (cCharAt != '+') {
        }
        if (cCharAt == '-') {
        }
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i, int i2, int i3) {
        validate(i, i2, i3);
        return ofTotalSeconds(totalSeconds(i, i2, i3));
    }

    public static ZoneOffset ofTotalSeconds(int i) {
        if (i < -64800 || i > 64800) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i % 900 != 0) {
            return new ZoneOffset(i);
        }
        Integer numValueOf = Integer.valueOf(i);
        ConcurrentMap concurrentMap = SECONDS_CACHE;
        ZoneOffset zoneOffset = (ZoneOffset) concurrentMap.get(numValueOf);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        concurrentMap.putIfAbsent(numValueOf, new ZoneOffset(i));
        ZoneOffset zoneOffset2 = (ZoneOffset) concurrentMap.get(numValueOf);
        ID_CACHE.putIfAbsent(zoneOffset2.getId(), zoneOffset2);
        return zoneOffset2;
    }

    private static int parseNumber(CharSequence charSequence, int i, boolean z) {
        if (z && charSequence.charAt(i - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char cCharAt = charSequence.charAt(i);
        char cCharAt2 = charSequence.charAt(i + 1);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            return ((cCharAt - '0') * 10) + (cCharAt2 - '0');
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    private static int totalSeconds(int i, int i2, int i3) {
        return (i * 3600) + (i2 * 60) + i3;
    }

    private static void validate(int i, int i2, int i3) {
        if (i < -18 || i > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i + " is not in the range -18 to 18");
        }
        if (i > 0) {
            if (i2 < 0 || i3 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i2 > 0 || i3 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i2 < -59 || i2 > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: value " + i2 + " is not in the range -59 to 59");
        }
        if (i3 >= -59 && i3 <= 59) {
            if (Math.abs(i) == 18 && (i2 | i3) != 0) {
                throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
            }
        } else {
            throw new DateTimeException("Zone offset seconds not in valid range: value " + i3 + " is not in the range -59 to 59");
        }
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }

    @Override // j$.time.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(temporalField instanceof ChronoField)) {
            return range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // j$.time.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    @Override // j$.time.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // j$.time.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public Object query(TemporalQuery temporalQuery) {
        return (temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.zone()) ? this : TemporalAccessor.CC.$default$query(this, temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return TemporalAccessor.CC.$default$range(this, temporalField);
    }

    @Override // j$.time.ZoneId
    public String toString() {
        return this.id;
    }
}
