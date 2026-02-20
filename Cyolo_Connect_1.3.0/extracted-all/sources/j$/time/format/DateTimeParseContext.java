package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.util.Objects;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class DateTimeParseContext {
    private ArrayList chronoListeners;
    private DateTimeFormatter formatter;
    private final ArrayList parsed;
    private boolean caseSensitive = true;
    private boolean strict = true;

    DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        ArrayList arrayList = new ArrayList();
        this.parsed = arrayList;
        this.chronoListeners = null;
        this.formatter = dateTimeFormatter;
        arrayList.add(new Parsed());
    }

    static boolean charEqualsIgnoreCase(char c, char c2) {
        return c == c2 || Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    private Parsed currentParsed() {
        return (Parsed) this.parsed.get(r0.size() - 1);
    }

    void addChronoChangedListener(Consumer consumer) {
        if (this.chronoListeners == null) {
            this.chronoListeners = new ArrayList();
        }
        this.chronoListeners.add(consumer);
    }

    boolean charEquals(char c, char c2) {
        return isCaseSensitive() ? c == c2 : charEqualsIgnoreCase(c, c2);
    }

    DateTimeParseContext copy() {
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this.formatter);
        dateTimeParseContext.caseSensitive = this.caseSensitive;
        dateTimeParseContext.strict = this.strict;
        return dateTimeParseContext;
    }

    void endOptional(boolean z) {
        ArrayList arrayList;
        int size;
        if (z) {
            arrayList = this.parsed;
            size = arrayList.size() - 2;
        } else {
            arrayList = this.parsed;
            size = arrayList.size() - 1;
        }
        arrayList.remove(size);
    }

    DecimalStyle getDecimalStyle() {
        return this.formatter.getDecimalStyle();
    }

    Chronology getEffectiveChronology() {
        Chronology chronology = currentParsed().chrono;
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = this.formatter.getChronology();
        return chronology2 == null ? IsoChronology.INSTANCE : chronology2;
    }

    Locale getLocale() {
        return this.formatter.getLocale();
    }

    Long getParsed(TemporalField temporalField) {
        return (Long) currentParsed().fieldValues.get(temporalField);
    }

    boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    boolean isStrict() {
        return this.strict;
    }

    void setCaseSensitive(boolean z) {
        this.caseSensitive = z;
    }

    void setParsed(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        currentParsed().zone = zoneId;
    }

    int setParsedField(TemporalField temporalField, long j, int i, int i2) {
        Objects.requireNonNull(temporalField, "field");
        Long l = (Long) currentParsed().fieldValues.put(temporalField, Long.valueOf(j));
        return (l == null || l.longValue() == j) ? i2 : ~i;
    }

    void setParsedLeapSecond() {
        currentParsed().leapSecond = true;
    }

    void setStrict(boolean z) {
        this.strict = z;
    }

    void startOptional() {
        this.parsed.add(currentParsed().copy());
    }

    boolean subSequenceEquals(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3) {
        if (i + i3 > charSequence.length() || i2 + i3 > charSequence2.length()) {
            return false;
        }
        if (isCaseSensitive()) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (charSequence.charAt(i + i4) != charSequence2.charAt(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            char cCharAt = charSequence.charAt(i + i5);
            char cCharAt2 = charSequence2.charAt(i2 + i5);
            if (cCharAt != cCharAt2 && Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                return false;
            }
        }
        return true;
    }

    TemporalAccessor toResolved(ResolverStyle resolverStyle, Set set) {
        Parsed parsedCurrentParsed = currentParsed();
        parsedCurrentParsed.chrono = getEffectiveChronology();
        ZoneId zone = parsedCurrentParsed.zone;
        if (zone == null) {
            zone = this.formatter.getZone();
        }
        parsedCurrentParsed.zone = zone;
        return parsedCurrentParsed.resolve(resolverStyle, set);
    }

    public String toString() {
        return currentParsed().toString();
    }
}
