package org.xbill.DNS;

import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeParseException;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;

/* JADX INFO: loaded from: classes2.dex */
final class FormattedTime {
    private static final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC);

    private FormattedTime() {
    }

    public static String format(Instant instant) {
        return DEFAULT_FORMAT.format(instant);
    }

    public static Instant parse(String str) throws DateTimeParseException {
        if (str.length() == 14) {
            return (Instant) DEFAULT_FORMAT.parse(str, new TemporalQuery() { // from class: org.xbill.DNS.FormattedTime$$ExternalSyntheticLambda0
                @Override // j$.time.temporal.TemporalQuery
                public final Object queryFrom(TemporalAccessor temporalAccessor) {
                    return Instant.from(temporalAccessor);
                }
            });
        }
        if (str.length() <= 10) {
            return Instant.ofEpochSecond(Long.parseLong(str));
        }
        throw new DateTimeParseException("Invalid time encoding: ", str, 0);
    }
}
