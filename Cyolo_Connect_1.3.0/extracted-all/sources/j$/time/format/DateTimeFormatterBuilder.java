package j$.time.format;

import androidx.work.WorkRequest;
import j$.time.Clock$TickClock$$ExternalSyntheticBackport0;
import j$.time.DateTimeException;
import j$.time.Duration$$ExternalSyntheticBackport0;
import j$.time.Duration$$ExternalSyntheticBackport1;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDate$$ExternalSyntheticBackport0;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeTextProvider;
import j$.time.temporal.ChronoField;
import j$.time.temporal.IsoFields;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.ValueRange;
import j$.time.temporal.WeekFields;
import j$.time.zone.ZoneRulesProvider;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import kotlin.jvm.internal.CharCompanionObject;
import okhttp3.internal.connection.RealConnection;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Marker;
import org.xbill.DNS.TTL;

/* JADX INFO: loaded from: classes4.dex */
public final class DateTimeFormatterBuilder {
    private static final Map FIELD_MAP;
    static final Comparator LENGTH_SORT;
    private static final TemporalQuery QUERY_REGION_ONLY = new TemporalQuery() { // from class: j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticLambda0
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return DateTimeFormatterBuilder.lambda$static$0(temporalAccessor);
        }
    };
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List printerParsers;
    private int valueParserIndex;

    /* JADX INFO: renamed from: j$.time.format.DateTimeFormatterBuilder$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$java$time$format$SignStyle;

        static {
            int[] iArr = new int[SignStyle.values().length];
            $SwitchMap$java$time$format$SignStyle = iArr;
            try {
                iArr[SignStyle.EXCEEDS_PAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.NOT_NEGATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        CharLiteralPrinterParser(char c) {
            this.literal = c;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            if (i == charSequence.length()) {
                return ~i;
            }
            char cCharAt = charSequence.charAt(i);
            return (cCharAt == this.literal || (!dateTimeParseContext.isCaseSensitive() && (Character.toUpperCase(cCharAt) == Character.toUpperCase(this.literal) || Character.toLowerCase(cCharAt) == Character.toLowerCase(this.literal)))) ? i + 1 : ~i;
        }

        public String toString() {
            if (this.literal == '\'') {
                return "''";
            }
            return "'" + this.literal + "'";
        }
    }

    static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        CompositePrinterParser(List list, boolean z) {
            this((DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]), z);
        }

        CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z) {
            this.printerParsers = dateTimePrinterParserArr;
            this.optional = z;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.optional) {
                dateTimePrintContext.startOptional();
            }
            try {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    if (!dateTimePrinterParser.format(dateTimePrintContext, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                return true;
            } finally {
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
            }
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            if (!this.optional) {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    i = dateTimePrinterParser.parse(dateTimeParseContext, charSequence, i);
                    if (i < 0) {
                        break;
                    }
                }
                return i;
            }
            dateTimeParseContext.startOptional();
            int i2 = i;
            for (DateTimePrinterParser dateTimePrinterParser2 : this.printerParsers) {
                i2 = dateTimePrinterParser2.parse(dateTimeParseContext, charSequence, i2);
                if (i2 < 0) {
                    dateTimeParseContext.endOptional(false);
                    return i;
                }
            }
            dateTimeParseContext.endOptional(true);
            return i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.printerParsers != null) {
                sb.append(this.optional ? "[" : "(");
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    sb.append(dateTimePrinterParser);
                }
                sb.append(this.optional ? "]" : ")");
            }
            return sb.toString();
        }

        public CompositePrinterParser withOptional(boolean z) {
            return z == this.optional ? this : new CompositePrinterParser(this.printerParsers, z);
        }
    }

    interface DateTimePrinterParser {
        boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb);

        int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i);
    }

    static final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean decimalPoint;
        private final TemporalField field;
        private final int maxWidth;
        private final int minWidth;

        FractionPrinterParser(TemporalField temporalField, int i, int i2, boolean z) {
            Objects.requireNonNull(temporalField, "field");
            if (!temporalField.range().isFixed()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + temporalField);
            }
            if (i < 0 || i > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i);
            }
            if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i2);
            }
            if (i2 >= i) {
                this.field = temporalField;
                this.minWidth = i;
                this.maxWidth = i2;
                this.decimalPoint = z;
                return;
            }
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
        }

        private long convertFromFraction(BigDecimal bigDecimal) {
            ValueRange valueRangeRange = this.field.range();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(valueRangeRange.getMinimum());
            return bigDecimal.multiply(BigDecimal.valueOf(valueRangeRange.getMaximum()).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact();
        }

        private BigDecimal convertToFraction(long j) {
            ValueRange valueRangeRange = this.field.range();
            valueRangeRange.checkValidValue(j, this.field);
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(valueRangeRange.getMinimum());
            BigDecimal bigDecimalDivide = BigDecimal.valueOf(j).subtract(bigDecimalValueOf).divide(BigDecimal.valueOf(valueRangeRange.getMaximum()).subtract(bigDecimalValueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            return bigDecimalDivide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : bigDecimalDivide.stripTrailingZeros();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            DecimalStyle decimalStyle = dateTimePrintContext.getDecimalStyle();
            BigDecimal bigDecimalConvertToFraction = convertToFraction(value.longValue());
            if (bigDecimalConvertToFraction.scale() != 0) {
                String strConvertNumberToI18N = decimalStyle.convertNumberToI18N(bigDecimalConvertToFraction.setScale(Math.min(Math.max(bigDecimalConvertToFraction.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.decimalPoint) {
                    sb.append(decimalStyle.getDecimalSeparator());
                }
                sb.append(strConvertNumberToI18N);
                return true;
            }
            if (this.minWidth <= 0) {
                return true;
            }
            if (this.decimalPoint) {
                sb.append(decimalStyle.getDecimalSeparator());
            }
            for (int i = 0; i < this.minWidth; i++) {
                sb.append(decimalStyle.getZeroDigit());
            }
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int i3 = 0;
            int i4 = dateTimeParseContext.isStrict() ? this.minWidth : 0;
            int i5 = dateTimeParseContext.isStrict() ? this.maxWidth : 9;
            int length = charSequence.length();
            if (i == length) {
                return i4 > 0 ? ~i : i;
            }
            if (this.decimalPoint) {
                if (charSequence.charAt(i) != dateTimeParseContext.getDecimalStyle().getDecimalSeparator()) {
                    return i4 > 0 ? ~i : i;
                }
                i++;
            }
            int i6 = i;
            int i7 = i4 + i6;
            if (i7 > length) {
                return ~i6;
            }
            int iMin = Math.min(i5 + i6, length);
            int i8 = i6;
            while (i8 < iMin) {
                int i9 = i8 + 1;
                int iConvertToDigit = dateTimeParseContext.getDecimalStyle().convertToDigit(charSequence.charAt(i8));
                if (iConvertToDigit < 0) {
                    if (i9 < i7) {
                        return ~i6;
                    }
                    i2 = i9 - 1;
                    return dateTimeParseContext.setParsedField(this.field, convertFromFraction(new BigDecimal(i3).movePointLeft(i2 - i6)), i6, i2);
                }
                i3 = (i3 * 10) + iConvertToDigit;
                i8 = i9;
            }
            i2 = i8;
            return dateTimeParseContext.setParsedField(this.field, convertFromFraction(new BigDecimal(i3).movePointLeft(i2 - i6)), i6, i2);
        }

        public String toString() {
            return "Fraction(" + this.field + "," + this.minWidth + "," + this.maxWidth + (this.decimalPoint ? ",DecimalPoint" : "") + ")";
        }
    }

    static final class InstantPrinterParser implements DateTimePrinterParser {
        private final int fractionalDigits;

        InstantPrinterParser(int i) {
            this.fractionalDigits = i;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.INSTANT_SECONDS);
            TemporalAccessor temporal = dateTimePrintContext.getTemporal();
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            Long lValueOf = temporal.isSupported(chronoField) ? Long.valueOf(dateTimePrintContext.getTemporal().getLong(chronoField)) : null;
            int i = 0;
            if (value == null) {
                return false;
            }
            long jLongValue = value.longValue();
            int iCheckValidIntValue = chronoField.checkValidIntValue(lValueOf != null ? lValueOf.longValue() : 0L);
            if (jLongValue >= -62167219200L) {
                long j = (jLongValue - 315569520000L) + 62167219200L;
                long jM = Duration$$ExternalSyntheticBackport1.m(j, 315569520000L) + 1;
                LocalDateTime localDateTimeOfEpochSecond = LocalDateTime.ofEpochSecond(Clock$TickClock$$ExternalSyntheticBackport0.m(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                if (jM > 0) {
                    sb.append('+');
                    sb.append(jM);
                }
                sb.append(localDateTimeOfEpochSecond);
                if (localDateTimeOfEpochSecond.getSecond() == 0) {
                    sb.append(":00");
                }
            } else {
                long j2 = jLongValue + 62167219200L;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                LocalDateTime localDateTimeOfEpochSecond2 = LocalDateTime.ofEpochSecond(j4 - 62167219200L, 0, ZoneOffset.UTC);
                int length = sb.length();
                sb.append(localDateTimeOfEpochSecond2);
                if (localDateTimeOfEpochSecond2.getSecond() == 0) {
                    sb.append(":00");
                }
                if (j3 < 0) {
                    if (localDateTimeOfEpochSecond2.getYear() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j3 - 1));
                    } else if (j4 == 0) {
                        sb.insert(length, j3);
                    } else {
                        sb.insert(length + 1, Math.abs(j3));
                    }
                }
            }
            int i2 = this.fractionalDigits;
            if ((i2 < 0 && iCheckValidIntValue > 0) || i2 > 0) {
                sb.append(FilenameUtils.EXTENSION_SEPARATOR);
                int i3 = 100000000;
                while (true) {
                    int i4 = this.fractionalDigits;
                    if ((i4 != -1 || iCheckValidIntValue <= 0) && ((i4 != -2 || (iCheckValidIntValue <= 0 && i % 3 == 0)) && i >= i4)) {
                        break;
                    }
                    int i5 = iCheckValidIntValue / i3;
                    sb.append((char) (i5 + 48));
                    iCheckValidIntValue -= i5 * i3;
                    i3 /= 10;
                    i++;
                }
            }
            sb.append('Z');
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int i3;
            int i4 = this.fractionalDigits;
            int i5 = 0;
            int i6 = i4 < 0 ? 0 : i4;
            if (i4 < 0) {
                i4 = 9;
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T');
            ChronoField chronoField = ChronoField.HOUR_OF_DAY;
            DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral2 = dateTimeFormatterBuilderAppendLiteral.appendValue(chronoField, 2).appendLiteral(':');
            ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
            DateTimeFormatterBuilder dateTimeFormatterBuilderAppendLiteral3 = dateTimeFormatterBuilderAppendLiteral2.appendValue(chronoField2, 2).appendLiteral(':');
            ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
            DateTimeFormatterBuilder dateTimeFormatterBuilderAppendValue = dateTimeFormatterBuilderAppendLiteral3.appendValue(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
            CompositePrinterParser printerParser = dateTimeFormatterBuilderAppendValue.appendFraction(chronoField4, i6, i4, true).appendLiteral('Z').toFormatter().toPrinterParser(false);
            DateTimeParseContext dateTimeParseContextCopy = dateTimeParseContext.copy();
            int i7 = printerParser.parse(dateTimeParseContextCopy, charSequence, i);
            if (i7 < 0) {
                return i7;
            }
            long jLongValue = dateTimeParseContextCopy.getParsed(ChronoField.YEAR).longValue();
            int iIntValue = dateTimeParseContextCopy.getParsed(ChronoField.MONTH_OF_YEAR).intValue();
            int iIntValue2 = dateTimeParseContextCopy.getParsed(ChronoField.DAY_OF_MONTH).intValue();
            int iIntValue3 = dateTimeParseContextCopy.getParsed(chronoField).intValue();
            int iIntValue4 = dateTimeParseContextCopy.getParsed(chronoField2).intValue();
            Long parsed = dateTimeParseContextCopy.getParsed(chronoField3);
            Long parsed2 = dateTimeParseContextCopy.getParsed(chronoField4);
            int iIntValue5 = parsed != null ? parsed.intValue() : 0;
            int iIntValue6 = parsed2 != null ? parsed2.intValue() : 0;
            if (iIntValue3 == 24 && iIntValue4 == 0 && iIntValue5 == 0 && iIntValue6 == 0) {
                i3 = iIntValue5;
                i5 = 1;
                i2 = 0;
            } else if (iIntValue3 == 23 && iIntValue4 == 59 && iIntValue5 == 60) {
                dateTimeParseContext.setParsedLeapSecond();
                i2 = iIntValue3;
                i3 = 59;
            } else {
                i2 = iIntValue3;
                i3 = iIntValue5;
            }
            try {
                return dateTimeParseContext.setParsedField(chronoField4, iIntValue6, i, dateTimeParseContext.setParsedField(ChronoField.INSTANT_SECONDS, Duration$$ExternalSyntheticBackport0.m(jLongValue / WorkRequest.MIN_BACKOFF_MILLIS, 315569520000L) + LocalDateTime.of(((int) jLongValue) % 10000, iIntValue, iIntValue2, i2, iIntValue4, i3, 0).plusDays(i5).toEpochSecond(ZoneOffset.UTC), i, i7));
            } catch (RuntimeException unused) {
                return ~i;
            }
        }

        public String toString() {
            return "Instant()";
        }
    }

    static final class LocalizedOffsetIdPrinterParser implements DateTimePrinterParser {
        private final TextStyle style;

        LocalizedOffsetIdPrinterParser(TextStyle textStyle) {
            this.style = textStyle;
        }

        private static StringBuilder appendHMS(StringBuilder sb, int i) {
            sb.append((char) ((i / 10) + 48));
            sb.append((char) ((i % 10) + 48));
            return sb;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            sb.append("GMT");
            int iM = LocalDate$$ExternalSyntheticBackport0.m(value.longValue());
            if (iM == 0) {
                return true;
            }
            int iAbs = Math.abs((iM / 3600) % 100);
            int iAbs2 = Math.abs((iM / 60) % 60);
            int iAbs3 = Math.abs(iM % 60);
            sb.append(iM < 0 ? "-" : Marker.ANY_NON_NULL_MARKER);
            if (this.style == TextStyle.FULL) {
                appendHMS(sb, iAbs);
                sb.append(':');
                appendHMS(sb, iAbs2);
                if (iAbs3 == 0) {
                    return true;
                }
            } else {
                if (iAbs >= 10) {
                    sb.append((char) ((iAbs / 10) + 48));
                }
                sb.append((char) ((iAbs % 10) + 48));
                if (iAbs2 == 0 && iAbs3 == 0) {
                    return true;
                }
                sb.append(':');
                appendHMS(sb, iAbs2);
                if (iAbs3 == 0) {
                    return true;
                }
            }
            sb.append(':');
            appendHMS(sb, iAbs3);
            return true;
        }

        int getDigit(CharSequence charSequence, int i) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return -1;
            }
            return cCharAt - '0';
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x00e0, code lost:
        
            if (r13 >= 0) goto L66;
         */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int parse(j$.time.format.DateTimeParseContext r12, java.lang.CharSequence r13, int r14) {
            /*
                Method dump skipped, instruction units count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.LocalizedOffsetIdPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public String toString() {
            return "LocalizedOffset(" + this.style + ")";
        }
    }

    static class NumberPrinterParser implements DateTimePrinterParser {
        static final long[] EXCEED_POINTS = {0, 10, 100, 1000, WorkRequest.MIN_BACKOFF_MILLIS, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS};
        final TemporalField field;
        final int maxWidth;
        final int minWidth;
        private final SignStyle signStyle;
        final int subsequentWidth;

        NumberPrinterParser(TemporalField temporalField, int i, int i2, SignStyle signStyle) {
            this.field = temporalField;
            this.minWidth = i;
            this.maxWidth = i2;
            this.signStyle = signStyle;
            this.subsequentWidth = 0;
        }

        protected NumberPrinterParser(TemporalField temporalField, int i, int i2, SignStyle signStyle, int i3) {
            this.field = temporalField;
            this.minWidth = i;
            this.maxWidth = i2;
            this.signStyle = signStyle;
            this.subsequentWidth = i3;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            char negativeSign;
            int i;
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            long value2 = getValue(dateTimePrintContext, value.longValue());
            DecimalStyle decimalStyle = dateTimePrintContext.getDecimalStyle();
            String string = value2 == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(value2));
            if (string.length() > this.maxWidth) {
                throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + value2 + " exceeds the maximum print width of " + this.maxWidth);
            }
            String strConvertNumberToI18N = decimalStyle.convertNumberToI18N(string);
            int[] iArr = AnonymousClass3.$SwitchMap$java$time$format$SignStyle;
            int iOrdinal = this.signStyle.ordinal();
            if (value2 >= 0) {
                int i2 = iArr[iOrdinal];
                if (i2 == 1 ? !((i = this.minWidth) >= 19 || value2 < EXCEED_POINTS[i]) : i2 == 2) {
                    negativeSign = decimalStyle.getPositiveSign();
                    sb.append(negativeSign);
                }
            } else {
                int i3 = iArr[iOrdinal];
                if (i3 == 1 || i3 == 2 || i3 == 3) {
                    negativeSign = decimalStyle.getNegativeSign();
                    sb.append(negativeSign);
                } else if (i3 == 4) {
                    throw new DateTimeException("Field " + this.field + " cannot be printed as the value " + value2 + " cannot be negative according to the SignStyle");
                }
            }
            for (int i4 = 0; i4 < this.minWidth - strConvertNumberToI18N.length(); i4++) {
                sb.append(decimalStyle.getZeroDigit());
            }
            sb.append(strConvertNumberToI18N);
            return true;
        }

        long getValue(DateTimePrintContext dateTimePrintContext, long j) {
            return j;
        }

        boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            int i = this.subsequentWidth;
            return i == -1 || (i > 0 && this.minWidth == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE);
        }

        /* JADX WARN: Found duplicated region for block: B:109:0x015b  */
        /* JADX WARN: Found duplicated region for block: B:111:0x0163  */
        /* JADX WARN: Found duplicated region for block: B:114:0x0179 A[MOVE_INLINED] */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            boolean z;
            boolean z2;
            BigInteger bigIntegerDivide;
            int i3;
            long j;
            long j2;
            int i4;
            int i5;
            int length = charSequence.length();
            if (i == length) {
                return ~i;
            }
            char cCharAt = charSequence.charAt(i);
            int i6 = 0;
            if (cCharAt == dateTimeParseContext.getDecimalStyle().getPositiveSign()) {
                if (!this.signStyle.parse(true, dateTimeParseContext.isStrict(), this.minWidth == this.maxWidth)) {
                    return ~i;
                }
                i2 = i + 1;
                z = false;
                z2 = true;
            } else {
                if (cCharAt == dateTimeParseContext.getDecimalStyle().getNegativeSign()) {
                    if (!this.signStyle.parse(false, dateTimeParseContext.isStrict(), this.minWidth == this.maxWidth)) {
                        return ~i;
                    }
                    i2 = i + 1;
                    z = true;
                } else {
                    if (this.signStyle == SignStyle.ALWAYS && dateTimeParseContext.isStrict()) {
                        return ~i;
                    }
                    i2 = i;
                    z = false;
                }
                z2 = false;
            }
            int i7 = (dateTimeParseContext.isStrict() || isFixedWidth(dateTimeParseContext)) ? this.minWidth : 1;
            int i8 = i2 + i7;
            if (i8 > length) {
                return ~i2;
            }
            int iMax = ((dateTimeParseContext.isStrict() || isFixedWidth(dateTimeParseContext)) ? this.maxWidth : 9) + Math.max(this.subsequentWidth, 0);
            while (true) {
                bigIntegerDivide = null;
                if (i6 >= 2) {
                    i3 = i2;
                    j = 0;
                    break;
                }
                int iMin = Math.min(iMax + i2, length);
                int i9 = i2;
                j = 0;
                while (i9 < iMin) {
                    int i10 = i9 + 1;
                    int iConvertToDigit = dateTimeParseContext.getDecimalStyle().convertToDigit(charSequence.charAt(i9));
                    if (iConvertToDigit < 0) {
                        i9 = i10 - 1;
                        if (i9 >= i8) {
                            break;
                        }
                        return ~i2;
                    }
                    if (i10 - i2 > 18) {
                        if (bigIntegerDivide == null) {
                            bigIntegerDivide = BigInteger.valueOf(j);
                        }
                        bigIntegerDivide = bigIntegerDivide.multiply(BigInteger.TEN).add(BigInteger.valueOf(iConvertToDigit));
                        i4 = i8;
                        i5 = iMin;
                    } else {
                        i4 = i8;
                        i5 = iMin;
                        j = (j * 10) + ((long) iConvertToDigit);
                    }
                    iMin = i5;
                    i8 = i4;
                    i9 = i10;
                }
                int i11 = i8;
                int i12 = this.subsequentWidth;
                if (i12 <= 0 || i6 != 0) {
                    i3 = i9;
                    break;
                }
                iMax = Math.max(i7, (i9 - i2) - i12);
                i6++;
                i8 = i11;
            }
            if (z) {
                if (bigIntegerDivide != null) {
                    if (bigIntegerDivide.equals(BigInteger.ZERO) && dateTimeParseContext.isStrict()) {
                        return ~(i2 - 1);
                    }
                    bigIntegerDivide = bigIntegerDivide.negate();
                } else {
                    if (j == 0 && dateTimeParseContext.isStrict()) {
                        return ~(i2 - 1);
                    }
                    j2 = -j;
                }
                if (bigIntegerDivide != null) {
                    return setValue(dateTimeParseContext, j2, i2, i3);
                }
                if (bigIntegerDivide.bitLength() > 63) {
                    bigIntegerDivide = bigIntegerDivide.divide(BigInteger.TEN);
                    i3--;
                }
                return setValue(dateTimeParseContext, bigIntegerDivide.longValue(), i2, i3);
            }
            if (this.signStyle == SignStyle.EXCEEDS_PAD && dateTimeParseContext.isStrict()) {
                int i13 = i3 - i2;
                int i14 = this.minWidth;
                if (z2) {
                    if (i13 <= i14) {
                        return ~(i2 - 1);
                    }
                } else if (i13 > i14) {
                    return ~i2;
                }
            }
            j2 = j;
            if (bigIntegerDivide != null) {
                return setValue(dateTimeParseContext, j2, i2, i3);
            }
            if (bigIntegerDivide.bitLength() > 63) {
                bigIntegerDivide = bigIntegerDivide.divide(BigInteger.TEN);
                i3--;
            }
            return setValue(dateTimeParseContext, bigIntegerDivide.longValue(), i2, i3);
        }

        int setValue(DateTimeParseContext dateTimeParseContext, long j, int i, int i2) {
            return dateTimeParseContext.setParsedField(this.field, j, i, i2);
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            int i = this.minWidth;
            if (i != 1 || this.maxWidth != 19 || this.signStyle != SignStyle.NORMAL) {
                if (i == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE) {
                    sb = new StringBuilder();
                    sb.append("Value(");
                    sb.append(this.field);
                    sb.append(",");
                    sb.append(this.minWidth);
                } else {
                    sb = new StringBuilder();
                    sb.append("Value(");
                    sb.append(this.field);
                    sb.append(",");
                    sb.append(this.minWidth);
                    sb.append(",");
                    sb.append(this.maxWidth);
                    sb.append(",");
                    obj = this.signStyle;
                }
                sb.append(")");
                return sb.toString();
            }
            sb = new StringBuilder();
            sb.append("Value(");
            obj = this.field;
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }

        NumberPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        NumberPrinterParser withSubsequentWidth(int i) {
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, this.subsequentWidth + i);
        }
    }

    static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        private final String noOffsetText;
        private final int type;
        static final String[] PATTERNS = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final OffsetIdPrinterParser INSTANCE_ID_Z = new OffsetIdPrinterParser("+HH:MM:ss", "Z");
        static final OffsetIdPrinterParser INSTANCE_ID_ZERO = new OffsetIdPrinterParser("+HH:MM:ss", "0");

        OffsetIdPrinterParser(String str, String str2) {
            Objects.requireNonNull(str, "pattern");
            Objects.requireNonNull(str2, "noOffsetText");
            this.type = checkPattern(str);
            this.noOffsetText = str2;
        }

        private int checkPattern(String str) {
            int i = 0;
            while (true) {
                String[] strArr = PATTERNS;
                if (i >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                }
                if (strArr[i].equals(str)) {
                    return i;
                }
                i++;
            }
        }

        private boolean parseNumber(int[] iArr, int i, CharSequence charSequence, boolean z) {
            int i2;
            int i3 = this.type;
            if ((i3 + 3) / 2 < i) {
                return false;
            }
            int i4 = iArr[0];
            if (i3 % 2 == 0 && i > 1) {
                int i5 = i4 + 1;
                if (i5 > charSequence.length() || charSequence.charAt(i4) != ':') {
                    return z;
                }
                i4 = i5;
            }
            if (i4 + 2 > charSequence.length()) {
                return z;
            }
            int i6 = i4 + 1;
            char cCharAt = charSequence.charAt(i4);
            int i7 = i6 + 1;
            char cCharAt2 = charSequence.charAt(i6);
            if (cCharAt < '0' || cCharAt > '9' || cCharAt2 < '0' || cCharAt2 > '9' || (i2 = ((cCharAt - '0') * 10) + (cCharAt2 - '0')) < 0 || i2 > 59) {
                return z;
            }
            iArr[i] = i2;
            iArr[0] = i7;
            return false;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            int iM = LocalDate$$ExternalSyntheticBackport0.m(value.longValue());
            if (iM == 0) {
                sb.append(this.noOffsetText);
            } else {
                int iAbs = Math.abs((iM / 3600) % 100);
                int iAbs2 = Math.abs((iM / 60) % 60);
                int iAbs3 = Math.abs(iM % 60);
                int length = sb.length();
                sb.append(iM < 0 ? "-" : Marker.ANY_NON_NULL_MARKER);
                sb.append((char) ((iAbs / 10) + 48));
                sb.append((char) ((iAbs % 10) + 48));
                int i = this.type;
                if (i >= 3 || (i >= 1 && iAbs2 > 0)) {
                    sb.append(i % 2 == 0 ? ":" : "");
                    sb.append((char) ((iAbs2 / 10) + 48));
                    sb.append((char) ((iAbs2 % 10) + 48));
                    iAbs += iAbs2;
                    int i2 = this.type;
                    if (i2 >= 7 || (i2 >= 5 && iAbs3 > 0)) {
                        sb.append(i2 % 2 != 0 ? "" : ":");
                        sb.append((char) ((iAbs3 / 10) + 48));
                        sb.append((char) ((iAbs3 % 10) + 48));
                        iAbs += iAbs3;
                    }
                }
                if (iAbs == 0) {
                    sb.setLength(length);
                    sb.append(this.noOffsetText);
                }
            }
            return true;
        }

        /* JADX WARN: Found duplicated region for block: B:33:0x0079  */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            ChronoField chronoField;
            long j;
            int i2;
            DateTimeParseContext dateTimeParseContext2;
            int i3;
            boolean z;
            int length = charSequence.length();
            int length2 = this.noOffsetText.length();
            if (length2 == 0) {
                if (i == length) {
                    chronoField = ChronoField.OFFSET_SECONDS;
                    j = 0;
                    dateTimeParseContext2 = dateTimeParseContext;
                    i3 = i;
                    i2 = i;
                }
                return dateTimeParseContext2.setParsedField(chronoField, j, i3, i2);
            }
            if (i == length) {
                return ~i;
            }
            if (dateTimeParseContext.subSequenceEquals(charSequence, i, this.noOffsetText, 0, length2)) {
                chronoField = ChronoField.OFFSET_SECONDS;
                j = 0;
                i2 = i + length2;
                dateTimeParseContext2 = dateTimeParseContext;
                i3 = i;
            }
            return dateTimeParseContext2.setParsedField(chronoField, j, i3, i2);
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '+' || cCharAt == '-') {
                int i4 = cCharAt == '-' ? -1 : 1;
                int[] iArr = new int[4];
                iArr[0] = i + 1;
                if (!parseNumber(iArr, 1, charSequence, true)) {
                    z = parseNumber(iArr, 2, charSequence, this.type >= 3) || parseNumber(iArr, 3, charSequence, false);
                }
                if (!z) {
                    long j2 = ((long) i4) * ((((long) iArr[1]) * 3600) + (((long) iArr[2]) * 60) + ((long) iArr[3]));
                    chronoField = ChronoField.OFFSET_SECONDS;
                    int i5 = iArr[0];
                    dateTimeParseContext2 = dateTimeParseContext;
                    j = j2;
                    i3 = i;
                    i2 = i5;
                }
                return dateTimeParseContext2.setParsedField(chronoField, j, i3, i2);
            }
            if (length2 != 0) {
                return ~i;
            }
            chronoField = ChronoField.OFFSET_SECONDS;
            j = 0;
            i2 = i + length2;
            dateTimeParseContext2 = dateTimeParseContext;
            i3 = i;
            return dateTimeParseContext2.setParsedField(chronoField, j, i3, i2);
        }

        public String toString() {
            return "Offset(" + PATTERNS[this.type] + ",'" + this.noOffsetText.replace("'", "''") + "')";
        }
    }

    static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i, char c) {
            this.printerParser = dateTimePrinterParser;
            this.padWidth = i;
            this.padChar = c;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (!this.printerParser.format(dateTimePrintContext, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.padWidth) {
                for (int i = 0; i < this.padWidth - length2; i++) {
                    sb.insert(length, this.padChar);
                }
                return true;
            }
            throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.padWidth);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            boolean zIsStrict = dateTimeParseContext.isStrict();
            if (i > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            if (i == charSequence.length()) {
                return ~i;
            }
            int length = this.padWidth + i;
            if (length > charSequence.length()) {
                if (zIsStrict) {
                    return ~i;
                }
                length = charSequence.length();
            }
            int i2 = i;
            while (i2 < length && dateTimeParseContext.charEquals(charSequence.charAt(i2), this.padChar)) {
                i2++;
            }
            int i3 = this.printerParser.parse(dateTimeParseContext, charSequence.subSequence(0, length), i2);
            return (i3 == length || !zIsStrict) ? i3 : ~(i + i2);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Pad(");
            sb.append(this.printerParser);
            sb.append(",");
            sb.append(this.padWidth);
            if (this.padChar == ' ') {
                str = ")";
            } else {
                str = ",'" + this.padChar + "')";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    static class PrefixTree {
        protected char c0;
        protected PrefixTree child;
        protected String key;
        protected PrefixTree sibling;
        protected String value;

        private static class CI extends PrefixTree {
            private CI(String str, String str2, PrefixTree prefixTree) {
                super(str, str2, prefixTree);
            }

            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            protected boolean isEqual(char c, char c2) {
                return DateTimeParseContext.charEqualsIgnoreCase(c, c2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            public CI newNode(String str, String str2, PrefixTree prefixTree) {
                return new CI(str, str2, prefixTree);
            }

            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            protected boolean prefixOf(CharSequence charSequence, int i, int i2) {
                int length = this.key.length();
                if (length > i2 - i) {
                    return false;
                }
                int i3 = 0;
                while (true) {
                    int i4 = length - 1;
                    if (length <= 0) {
                        return true;
                    }
                    int i5 = i3 + 1;
                    int i6 = i + 1;
                    if (!isEqual(this.key.charAt(i3), charSequence.charAt(i))) {
                        return false;
                    }
                    i = i6;
                    length = i4;
                    i3 = i5;
                }
            }
        }

        private PrefixTree(String str, String str2, PrefixTree prefixTree) {
            this.key = str;
            this.value = str2;
            this.child = prefixTree;
            this.c0 = str.length() == 0 ? CharCompanionObject.MAX_VALUE : this.key.charAt(0);
        }

        private boolean add0(String str, String str2) {
            String key = toKey(str);
            int iPrefixLength = prefixLength(key);
            if (iPrefixLength != this.key.length()) {
                PrefixTree prefixTreeNewNode = newNode(this.key.substring(iPrefixLength), this.value, this.child);
                this.key = key.substring(0, iPrefixLength);
                this.child = prefixTreeNewNode;
                if (iPrefixLength < key.length()) {
                    this.child.sibling = newNode(key.substring(iPrefixLength), str2, null);
                    this.value = null;
                } else {
                    this.value = str2;
                }
                return true;
            }
            if (iPrefixLength >= key.length()) {
                this.value = str2;
                return true;
            }
            String strSubstring = key.substring(iPrefixLength);
            for (PrefixTree prefixTree = this.child; prefixTree != null; prefixTree = prefixTree.sibling) {
                if (isEqual(prefixTree.c0, strSubstring.charAt(0))) {
                    return prefixTree.add0(strSubstring, str2);
                }
            }
            PrefixTree prefixTreeNewNode2 = newNode(strSubstring, str2, null);
            prefixTreeNewNode2.sibling = this.child;
            this.child = prefixTreeNewNode2;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static PrefixTree newTree(DateTimeParseContext dateTimeParseContext) {
            return dateTimeParseContext.isCaseSensitive() ? new PrefixTree("", null, null) : new CI("", null, 0 == true ? 1 : 0);
        }

        public static PrefixTree newTree(Set set, DateTimeParseContext dateTimeParseContext) {
            PrefixTree prefixTreeNewTree = newTree(dateTimeParseContext);
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                prefixTreeNewTree.add0(str, str);
            }
            return prefixTreeNewTree;
        }

        private int prefixLength(String str) {
            int i = 0;
            while (i < str.length() && i < this.key.length() && isEqual(str.charAt(i), this.key.charAt(i))) {
                i++;
            }
            return i;
        }

        public boolean add(String str, String str2) {
            return add0(str, str2);
        }

        protected boolean isEqual(char c, char c2) {
            return c == c2;
        }

        public String match(CharSequence charSequence, ParsePosition parsePosition) {
            int index = parsePosition.getIndex();
            int length = charSequence.length();
            if (!prefixOf(charSequence, index, length)) {
                return null;
            }
            int length2 = index + this.key.length();
            PrefixTree prefixTree = this.child;
            if (prefixTree != null && length2 != length) {
                while (!isEqual(prefixTree.c0, charSequence.charAt(length2))) {
                    prefixTree = prefixTree.sibling;
                    if (prefixTree == null) {
                    }
                }
                parsePosition.setIndex(length2);
                String strMatch = prefixTree.match(charSequence, parsePosition);
                if (strMatch != null) {
                    return strMatch;
                }
            }
            parsePosition.setIndex(length2);
            return this.value;
        }

        protected PrefixTree newNode(String str, String str2, PrefixTree prefixTree) {
            return new PrefixTree(str, str2, prefixTree);
        }

        protected boolean prefixOf(CharSequence charSequence, int i, int i2) {
            if (charSequence instanceof String) {
                return ((String) charSequence).startsWith(this.key, i);
            }
            int length = this.key.length();
            if (length > i2 - i) {
                return false;
            }
            int i3 = 0;
            while (true) {
                int i4 = length - 1;
                if (length <= 0) {
                    return true;
                }
                int i5 = i3 + 1;
                int i6 = i + 1;
                if (!isEqual(this.key.charAt(i3), charSequence.charAt(i))) {
                    return false;
                }
                i = i6;
                length = i4;
                i3 = i5;
            }
        }

        protected String toKey(String str) {
            return str;
        }
    }

    static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate BASE_DATE = LocalDate.of(2000, 1, 1);
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        ReducedPrinterParser(TemporalField temporalField, int i, int i2, int i3, ChronoLocalDate chronoLocalDate) {
            this(temporalField, i, i2, i3, chronoLocalDate, 0);
            if (i < 1 || i > 10) {
                throw new IllegalArgumentException("The minWidth must be from 1 to 10 inclusive but was " + i);
            }
            if (i2 < 1 || i2 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + i);
            }
            if (i2 < i) {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
            }
            if (chronoLocalDate == null) {
                long j = i3;
                if (!temporalField.range().isValidValue(j)) {
                    throw new IllegalArgumentException("The base value must be within the range of the field");
                }
                if (j + NumberPrinterParser.EXCEED_POINTS[i2] > TTL.MAX_VALUE) {
                    throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                }
            }
        }

        private ReducedPrinterParser(TemporalField temporalField, int i, int i2, int i3, ChronoLocalDate chronoLocalDate, int i4) {
            super(temporalField, i, i2, SignStyle.NOT_NEGATIVE, i4);
            this.baseValue = i3;
            this.baseDate = chronoLocalDate;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        long getValue(DateTimePrintContext dateTimePrintContext, long j) {
            long jAbs = Math.abs(j);
            int i = this.baseValue;
            if (this.baseDate != null) {
                i = Chronology.CC.from(dateTimePrintContext.getTemporal()).date(this.baseDate).get(this.field);
            }
            long j2 = i;
            if (j >= j2) {
                long j3 = NumberPrinterParser.EXCEED_POINTS[this.minWidth];
                if (j < j2 + j3) {
                    return jAbs % j3;
                }
            }
            return jAbs % NumberPrinterParser.EXCEED_POINTS[this.maxWidth];
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            if (dateTimeParseContext.isStrict()) {
                return super.isFixedWidth(dateTimeParseContext);
            }
            return false;
        }

        /* JADX INFO: renamed from: lambda$setValue$0$java-time-format-DateTimeFormatterBuilder$ReducedPrinterParser, reason: not valid java name */
        /* synthetic */ void m418xdf3a601e(DateTimeParseContext dateTimeParseContext, long j, int i, int i2, Chronology chronology) {
            setValue(dateTimeParseContext, j, i, i2);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        int setValue(final DateTimeParseContext dateTimeParseContext, final long j, final int i, final int i2) {
            int i3 = this.baseValue;
            if (this.baseDate != null) {
                i3 = dateTimeParseContext.getEffectiveChronology().date(this.baseDate).get(this.field);
                dateTimeParseContext.addChronoChangedListener(new Consumer() { // from class: j$.time.format.DateTimeFormatterBuilder$ReducedPrinterParser$$ExternalSyntheticLambda0
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m418xdf3a601e(dateTimeParseContext, j, i, i2, (Chronology) obj);
                    }

                    @Override // j$.util.function.Consumer
                    public /* synthetic */ Consumer andThen(Consumer consumer) {
                        return Consumer.CC.$default$andThen(this, consumer);
                    }
                });
            }
            int i4 = i2 - i;
            int i5 = this.minWidth;
            if (i4 == i5 && j >= 0) {
                long j2 = NumberPrinterParser.EXCEED_POINTS[i5];
                long j3 = i3;
                long j4 = j3 - (j3 % j2);
                j = i3 > 0 ? j4 + j : j4 - j;
                if (j < j3) {
                    j += j2;
                }
            }
            return dateTimeParseContext.setParsedField(this.field, j, i, i2);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ReducedValue(");
            sb.append(this.field);
            sb.append(",");
            sb.append(this.minWidth);
            sb.append(",");
            sb.append(this.maxWidth);
            sb.append(",");
            Object objValueOf = this.baseDate;
            if (objValueOf == null) {
                objValueOf = Integer.valueOf(this.baseValue);
            }
            sb.append(objValueOf);
            sb.append(")");
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public ReducedPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, -1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public ReducedPrinterParser withSubsequentWidth(int i) {
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, this.subsequentWidth + i);
        }
    }

    enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                dateTimeParseContext.setCaseSensitive(true);
            } else if (iOrdinal == 1) {
                dateTimeParseContext.setCaseSensitive(false);
            } else if (iOrdinal == 2) {
                dateTimeParseContext.setStrict(true);
            } else if (iOrdinal == 3) {
                dateTimeParseContext.setStrict(false);
            }
            return i;
        }

        @Override // java.lang.Enum
        public String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (iOrdinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (iOrdinal == 2) {
                return "ParseStrict(true)";
            }
            if (iOrdinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String literal;

        StringLiteralPrinterParser(String str) {
            this.literal = str;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            if (i > charSequence.length() || i < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.literal;
            return !dateTimeParseContext.subSequenceEquals(charSequence, i, str, 0, str.length()) ? ~i : i + this.literal.length();
        }

        public String toString() {
            return "'" + this.literal.replace("'", "''") + "'";
        }
    }

    static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        TextPrinterParser(TemporalField temporalField, TextStyle textStyle, DateTimeTextProvider dateTimeTextProvider) {
            this.field = temporalField;
            this.textStyle = textStyle;
            this.provider = dateTimeTextProvider;
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser == null) {
                this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
            }
            return this.numberPrinterParser;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            Chronology chronology = (Chronology) dateTimePrintContext.getTemporal().query(TemporalQueries.chronology());
            String text = (chronology == null || chronology == IsoChronology.INSTANCE) ? this.provider.getText(this.field, value.longValue(), this.textStyle, dateTimePrintContext.getLocale()) : this.provider.getText(chronology, this.field, value.longValue(), this.textStyle, dateTimePrintContext.getLocale());
            if (text == null) {
                return numberPrinterParser().format(dateTimePrintContext, sb);
            }
            sb.append(text);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int length = charSequence.length();
            if (i < 0 || i > length) {
                throw new IndexOutOfBoundsException();
            }
            TextStyle textStyle = dateTimeParseContext.isStrict() ? this.textStyle : null;
            Chronology effectiveChronology = dateTimeParseContext.getEffectiveChronology();
            Iterator textIterator = (effectiveChronology == null || effectiveChronology == IsoChronology.INSTANCE) ? this.provider.getTextIterator(this.field, textStyle, dateTimeParseContext.getLocale()) : this.provider.getTextIterator(effectiveChronology, this.field, textStyle, dateTimeParseContext.getLocale());
            if (textIterator != null) {
                while (textIterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) textIterator.next();
                    String str = (String) entry.getKey();
                    if (dateTimeParseContext.subSequenceEquals(str, 0, charSequence, i, str.length())) {
                        return dateTimeParseContext.setParsedField(this.field, ((Long) entry.getValue()).longValue(), i, i + str.length());
                    }
                }
                if (dateTimeParseContext.isStrict()) {
                    return ~i;
                }
            }
            return numberPrinterParser().parse(dateTimeParseContext, charSequence, i);
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            if (this.textStyle == TextStyle.FULL) {
                sb = new StringBuilder();
                sb.append("Text(");
                obj = this.field;
            } else {
                sb = new StringBuilder();
                sb.append("Text(");
                sb.append(this.field);
                sb.append(",");
                obj = this.textStyle;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    static final class WeekBasedFieldPrinterParser implements DateTimePrinterParser {
        private char chr;
        private int count;

        WeekBasedFieldPrinterParser(char c, int i) {
            this.chr = c;
            this.count = i;
        }

        private DateTimePrinterParser printerParser(Locale locale) {
            TemporalField temporalFieldWeekOfMonth;
            WeekFields weekFieldsOf = WeekFields.of(locale);
            char c = this.chr;
            if (c == 'W') {
                temporalFieldWeekOfMonth = weekFieldsOf.weekOfMonth();
            } else {
                if (c == 'Y') {
                    TemporalField temporalFieldWeekBasedYear = weekFieldsOf.weekBasedYear();
                    if (this.count == 2) {
                        return new ReducedPrinterParser(temporalFieldWeekBasedYear, 2, 2, 0, ReducedPrinterParser.BASE_DATE, 0);
                    }
                    int i = this.count;
                    return new NumberPrinterParser(temporalFieldWeekBasedYear, i, 19, i < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1);
                }
                if (c == 'c' || c == 'e') {
                    temporalFieldWeekOfMonth = weekFieldsOf.dayOfWeek();
                } else {
                    if (c != 'w') {
                        throw new IllegalStateException("unreachable");
                    }
                    temporalFieldWeekOfMonth = weekFieldsOf.weekOfWeekBasedYear();
                }
            }
            return new NumberPrinterParser(temporalFieldWeekOfMonth, this.count == 2 ? 2 : 1, 2, SignStyle.NOT_NEGATIVE);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return printerParser(dateTimePrintContext.getLocale()).format(dateTimePrintContext, sb);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            return printerParser(dateTimeParseContext.getLocale()).parse(dateTimeParseContext, charSequence, i);
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c = this.chr;
            if (c == 'Y') {
                int i = this.count;
                if (i == 1) {
                    str2 = "WeekBasedYear";
                } else if (i == 2) {
                    str2 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.count);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    sb.append(this.count < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
                }
                sb.append(str2);
            } else {
                if (c == 'W') {
                    str = "WeekOfMonth";
                } else if (c == 'c' || c == 'e') {
                    str = "DayOfWeek";
                } else {
                    if (c == 'w') {
                        str = "WeekOfWeekBasedYear";
                    }
                    sb.append(",");
                    sb.append(this.count);
                }
                sb.append(str);
                sb.append(",");
                sb.append(this.count);
            }
            sb.append(")");
            return sb.toString();
        }
    }

    static class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry cachedPrefixTree;
        private static volatile Map.Entry cachedPrefixTreeCI;
        private final String description;
        private final TemporalQuery query;

        ZoneIdPrinterParser(TemporalQuery temporalQuery, String str) {
            this.query = temporalQuery;
            this.description = str;
        }

        private int parseOffsetBased(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i, int i2, OffsetIdPrinterParser offsetIdPrinterParser) {
            String upperCase = charSequence.toString().substring(i, i2).toUpperCase();
            if (i2 >= charSequence.length() || charSequence.charAt(i2) == '0' || dateTimeParseContext.charEquals(charSequence.charAt(i2), 'Z')) {
                dateTimeParseContext.setParsed(ZoneId.of(upperCase));
                return i2;
            }
            DateTimeParseContext dateTimeParseContextCopy = dateTimeParseContext.copy();
            int i3 = offsetIdPrinterParser.parse(dateTimeParseContextCopy, charSequence, i2);
            try {
                if (i3 >= 0) {
                    dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.ofTotalSeconds((int) dateTimeParseContextCopy.getParsed(ChronoField.OFFSET_SECONDS).longValue())));
                    return i3;
                }
                if (offsetIdPrinterParser == OffsetIdPrinterParser.INSTANCE_ID_Z) {
                    return ~i;
                }
                dateTimeParseContext.setParsed(ZoneId.of(upperCase));
                return i2;
            } catch (DateTimeException unused) {
                return ~i;
            }
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(this.query);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.getId());
            return true;
        }

        protected PrefixTree getTree(DateTimeParseContext dateTimeParseContext) {
            Set availableZoneIds = ZoneRulesProvider.getAvailableZoneIds();
            int size = availableZoneIds.size();
            Map.Entry simpleImmutableEntry = dateTimeParseContext.isCaseSensitive() ? cachedPrefixTree : cachedPrefixTreeCI;
            if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                synchronized (this) {
                    simpleImmutableEntry = dateTimeParseContext.isCaseSensitive() ? cachedPrefixTree : cachedPrefixTreeCI;
                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                        simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), PrefixTree.newTree(availableZoneIds, dateTimeParseContext));
                        if (dateTimeParseContext.isCaseSensitive()) {
                            cachedPrefixTree = simpleImmutableEntry;
                        } else {
                            cachedPrefixTreeCI = simpleImmutableEntry;
                        }
                    }
                }
            }
            return (PrefixTree) simpleImmutableEntry.getValue();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i) {
            int i2;
            int length = charSequence.length();
            if (i > length) {
                throw new IndexOutOfBoundsException();
            }
            if (i == length) {
                return ~i;
            }
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '+' || cCharAt == '-') {
                return parseOffsetBased(dateTimeParseContext, charSequence, i, i, OffsetIdPrinterParser.INSTANCE_ID_Z);
            }
            int i3 = i + 2;
            if (length >= i3) {
                char cCharAt2 = charSequence.charAt(i + 1);
                if (dateTimeParseContext.charEquals(cCharAt, 'U') && dateTimeParseContext.charEquals(cCharAt2, 'T')) {
                    int i4 = i + 3;
                    return (length < i4 || !dateTimeParseContext.charEquals(charSequence.charAt(i3), 'C')) ? parseOffsetBased(dateTimeParseContext, charSequence, i, i3, OffsetIdPrinterParser.INSTANCE_ID_ZERO) : parseOffsetBased(dateTimeParseContext, charSequence, i, i4, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                }
                if (dateTimeParseContext.charEquals(cCharAt, 'G') && length >= (i2 = i + 3) && dateTimeParseContext.charEquals(cCharAt2, 'M') && dateTimeParseContext.charEquals(charSequence.charAt(i3), 'T')) {
                    return parseOffsetBased(dateTimeParseContext, charSequence, i, i2, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                }
            }
            PrefixTree tree = getTree(dateTimeParseContext);
            ParsePosition parsePosition = new ParsePosition(i);
            String strMatch = tree.match(charSequence, parsePosition);
            if (strMatch != null) {
                dateTimeParseContext.setParsed(ZoneId.of(strMatch));
                return parsePosition.getIndex();
            }
            if (!dateTimeParseContext.charEquals(cCharAt, 'Z')) {
                return ~i;
            }
            dateTimeParseContext.setParsed(ZoneOffset.UTC);
            return i + 1;
        }

        public String toString() {
            return this.description;
        }
    }

    static final class ZoneTextPrinterParser extends ZoneIdPrinterParser {
        private static final Map cache = new ConcurrentHashMap();
        private final Map cachedTree;
        private final Map cachedTreeCI;
        private Set preferredZones;
        private final TextStyle textStyle;

        ZoneTextPrinterParser(TextStyle textStyle, Set set) {
            super(TemporalQueries.zone(), "ZoneText(" + textStyle + ")");
            this.cachedTree = new HashMap();
            this.cachedTreeCI = new HashMap();
            this.textStyle = (TextStyle) Objects.requireNonNull(textStyle, "textStyle");
            if (set == null || set.size() == 0) {
                return;
            }
            this.preferredZones = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                this.preferredZones.add(((ZoneId) it.next()).getId());
            }
        }

        private String getDisplayName(String str, int i, Locale locale) {
            String[] strArr;
            Map concurrentHashMap = null;
            if (this.textStyle == TextStyle.NARROW) {
                return null;
            }
            Map map = cache;
            SoftReference softReference = (SoftReference) map.get(str);
            if (softReference == null || (concurrentHashMap = (Map) softReference.get()) == null || (strArr = (String[]) concurrentHashMap.get(locale)) == null) {
                TimeZone timeZone = TimeZone.getTimeZone(str);
                strArr = new String[]{str, timeZone.getDisplayName(false, 1, locale), timeZone.getDisplayName(false, 0, locale), timeZone.getDisplayName(true, 1, locale), timeZone.getDisplayName(true, 0, locale), str, str};
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap();
                }
                concurrentHashMap.put(locale, strArr);
                map.put(str, new SoftReference(concurrentHashMap));
            }
            int iZoneNameStyleIndex = this.textStyle.zoneNameStyleIndex();
            return i != 0 ? i != 1 ? strArr[iZoneNameStyleIndex + 5] : strArr[iZoneNameStyleIndex + 3] : strArr[iZoneNameStyleIndex + 1];
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.ZoneIdPrinterParser, j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(TemporalQueries.zoneId());
            int i = 0;
            if (zoneId == null) {
                return false;
            }
            String id = zoneId.getId();
            if (!(zoneId instanceof ZoneOffset)) {
                TemporalAccessor temporal = dateTimePrintContext.getTemporal();
                if (!temporal.isSupported(ChronoField.INSTANT_SECONDS)) {
                    i = 2;
                } else if (zoneId.getRules().isDaylightSavings(Instant.from(temporal))) {
                    i = 1;
                }
                String displayName = getDisplayName(id, i, dateTimePrintContext.getLocale());
                if (displayName != null) {
                    id = displayName;
                }
            }
            sb.append(id);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.ZoneIdPrinterParser
        protected PrefixTree getTree(DateTimeParseContext dateTimeParseContext) {
            PrefixTree prefixTreeNewTree;
            if (this.textStyle == TextStyle.NARROW) {
                return super.getTree(dateTimeParseContext);
            }
            Locale locale = dateTimeParseContext.getLocale();
            boolean zIsCaseSensitive = dateTimeParseContext.isCaseSensitive();
            Set availableZoneIds = ZoneRulesProvider.getAvailableZoneIds();
            int size = availableZoneIds.size();
            Map map = zIsCaseSensitive ? this.cachedTree : this.cachedTreeCI;
            Map.Entry entry = (Map.Entry) map.get(locale);
            if (entry == null || ((Integer) entry.getKey()).intValue() != size || (prefixTreeNewTree = (PrefixTree) ((SoftReference) entry.getValue()).get()) == null) {
                prefixTreeNewTree = PrefixTree.newTree(dateTimeParseContext);
                String[][] zoneStrings = DateFormatSymbols.getInstance(locale).getZoneStrings();
                int length = zoneStrings.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String[] strArr = zoneStrings[i];
                    String str = strArr[0];
                    if (availableZoneIds.contains(str)) {
                        prefixTreeNewTree.add(str, str);
                        String zid = ZoneName.toZid(str, locale);
                        for (int i2 = this.textStyle != TextStyle.FULL ? 2 : 1; i2 < strArr.length; i2 += 2) {
                            prefixTreeNewTree.add(strArr[i2], zid);
                        }
                    }
                    i++;
                }
                if (this.preferredZones != null) {
                    for (String[] strArr2 : zoneStrings) {
                        String str2 = strArr2[0];
                        if (this.preferredZones.contains(str2) && availableZoneIds.contains(str2)) {
                            for (int i3 = this.textStyle == TextStyle.FULL ? 1 : 2; i3 < strArr2.length; i3 += 2) {
                                prefixTreeNewTree.add(strArr2[i3], str2);
                            }
                        }
                    }
                }
                map.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), new SoftReference(prefixTreeNewTree)));
            }
            return prefixTreeNewTree;
        }
    }

    static {
        HashMap map = new HashMap();
        FIELD_MAP = map;
        map.put('G', ChronoField.ERA);
        map.put('y', ChronoField.YEAR_OF_ERA);
        map.put('u', ChronoField.YEAR);
        TemporalField temporalField = IsoFields.QUARTER_OF_YEAR;
        map.put('Q', temporalField);
        map.put('q', temporalField);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        map.put('M', chronoField);
        map.put('L', chronoField);
        map.put('D', ChronoField.DAY_OF_YEAR);
        map.put('d', ChronoField.DAY_OF_MONTH);
        map.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        map.put('E', chronoField2);
        map.put('c', chronoField2);
        map.put('e', chronoField2);
        map.put('a', ChronoField.AMPM_OF_DAY);
        map.put('H', ChronoField.HOUR_OF_DAY);
        map.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        map.put('K', ChronoField.HOUR_OF_AMPM);
        map.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        map.put('m', ChronoField.MINUTE_OF_HOUR);
        map.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        map.put('S', chronoField3);
        map.put('A', ChronoField.MILLI_OF_DAY);
        map.put('n', chronoField3);
        map.put('N', ChronoField.NANO_OF_DAY);
        LENGTH_SORT = new Comparator() { // from class: j$.time.format.DateTimeFormatterBuilder.2
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
            }
        };
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = dateTimeFormatterBuilder;
        this.optional = z;
    }

    private int appendInternal(DateTimePrinterParser dateTimePrinterParser) {
        Objects.requireNonNull(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i = dateTimeFormatterBuilder.padNextWidth;
        if (i > 0) {
            if (dateTimePrinterParser != null) {
                dateTimePrinterParser = new PadPrinterParserDecorator(dateTimePrinterParser, i, dateTimeFormatterBuilder.padNextChar);
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            dateTimeFormatterBuilder2.padNextWidth = 0;
            dateTimeFormatterBuilder2.padNextChar = (char) 0;
        }
        this.active.printerParsers.add(dateTimePrinterParser);
        this.active.valueParserIndex = -1;
        return r4.printerParsers.size() - 1;
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser numberPrinterParserWithFixedWidth;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i = dateTimeFormatterBuilder.valueParserIndex;
        if (i >= 0) {
            NumberPrinterParser numberPrinterParser2 = (NumberPrinterParser) dateTimeFormatterBuilder.printerParsers.get(i);
            if (numberPrinterParser.minWidth == numberPrinterParser.maxWidth && numberPrinterParser.signStyle == SignStyle.NOT_NEGATIVE) {
                numberPrinterParserWithFixedWidth = numberPrinterParser2.withSubsequentWidth(numberPrinterParser.maxWidth);
                appendInternal(numberPrinterParser.withFixedWidth());
                this.active.valueParserIndex = i;
            } else {
                numberPrinterParserWithFixedWidth = numberPrinterParser2.withFixedWidth();
                this.active.valueParserIndex = appendInternal(numberPrinterParser);
            }
            this.active.printerParsers.set(i, numberPrinterParserWithFixedWidth);
        } else {
            dateTimeFormatterBuilder.valueParserIndex = appendInternal(numberPrinterParser);
        }
        return this;
    }

    static /* synthetic */ ZoneId lambda$static$0(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
        if (zoneId == null || (zoneId instanceof ZoneOffset)) {
            return null;
        }
        return zoneId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        if (r10 == 1) goto L48;
     */
    /* JADX WARN: Found duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Found duplicated region for block: B:60:0x00c7  */
    /* JADX WARN: Found duplicated region for block: B:72:0x0102 A[DONT_INVERT, FALL_THROUGH, PHI: r7
      0x0102: PHI (r7v1 boolean) = (r7v0 boolean), (r7v2 boolean), (r7v0 boolean), (r7v0 boolean), (r7v0 boolean) binds: [B:3:0x000a, B:60:0x00c7, B:22:0x0030, B:23:0x0033, B:24:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:72:0x0102 A[DONT_INVERT, PHI: r7
      0x0102: PHI (r7v1 boolean) = (r7v0 boolean), (r7v2 boolean), (r7v0 boolean), (r7v0 boolean), (r7v0 boolean) binds: [B:3:0x000a, B:60:0x00c7, B:22:0x0030, B:23:0x0033, B:24:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:73:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:85:0x0133  */
    /* JADX WARN: Found duplicated region for block: B:87:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void parseField(char r9, int r10, j$.time.temporal.TemporalField r11) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.parseField(char, int, j$.time.temporal.TemporalField):void");
    }

    private void parsePattern(String str) {
        WeekBasedFieldPrinterParser weekBasedFieldPrinterParser;
        String str2;
        String str3;
        TextStyle textStyle;
        int i;
        int i2 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
                int i3 = i2 + 1;
                while (i3 < str.length() && str.charAt(i3) == cCharAt) {
                    i3++;
                }
                int i4 = i3 - i2;
                if (cCharAt == 'p') {
                    if (i3 >= str.length() || (((cCharAt = str.charAt(i3)) < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z'))) {
                        i = i4;
                        i4 = 0;
                    } else {
                        int i5 = i3 + 1;
                        while (i5 < str.length() && str.charAt(i5) == cCharAt) {
                            i5++;
                        }
                        i = i5 - i3;
                        i3 = i5;
                    }
                    if (i4 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + str);
                    }
                    padNext(i4);
                    i4 = i;
                }
                TemporalField temporalField = (TemporalField) FIELD_MAP.get(Character.valueOf(cCharAt));
                if (temporalField != null) {
                    parseField(cCharAt, i4, temporalField);
                } else if (cCharAt == 'z') {
                    if (i4 > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                    }
                    appendZoneText(i4 == 4 ? TextStyle.FULL : TextStyle.SHORT);
                } else if (cCharAt != 'V') {
                    String str4 = "+0000";
                    if (cCharAt == 'Z') {
                        if (i4 < 4) {
                            str2 = "+HHMM";
                            appendOffset(str2, str4);
                        } else {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                                }
                                str3 = "+HH:MM:ss";
                                appendOffset(str3, "Z");
                            }
                            textStyle = TextStyle.FULL;
                            appendLocalizedOffset(textStyle);
                        }
                    } else if (cCharAt == 'O') {
                        if (i4 == 1) {
                            textStyle = TextStyle.SHORT;
                        } else {
                            if (i4 != 4) {
                                throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + cCharAt);
                            }
                            textStyle = TextStyle.FULL;
                        }
                        appendLocalizedOffset(textStyle);
                    } else if (cCharAt == 'X') {
                        if (i4 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        str3 = OffsetIdPrinterParser.PATTERNS[i4 + (i4 == 1 ? 0 : 1)];
                        appendOffset(str3, "Z");
                    } else if (cCharAt != 'x') {
                        if (cCharAt == 'W') {
                            if (i4 > 1) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                            }
                            weekBasedFieldPrinterParser = new WeekBasedFieldPrinterParser(cCharAt, i4);
                        } else if (cCharAt == 'w') {
                            if (i4 > 2) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                            }
                            weekBasedFieldPrinterParser = new WeekBasedFieldPrinterParser(cCharAt, i4);
                        } else {
                            if (cCharAt != 'Y') {
                                throw new IllegalArgumentException("Unknown pattern letter: " + cCharAt);
                            }
                            weekBasedFieldPrinterParser = new WeekBasedFieldPrinterParser(cCharAt, i4);
                        }
                        appendInternal(weekBasedFieldPrinterParser);
                    } else {
                        if (i4 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        if (i4 == 1) {
                            str4 = "+00";
                        } else if (i4 % 2 != 0) {
                            str4 = "+00:00";
                        }
                        str2 = OffsetIdPrinterParser.PATTERNS[i4 + (i4 == 1 ? 0 : 1)];
                        appendOffset(str2, str4);
                    }
                } else {
                    if (i4 != 2) {
                        throw new IllegalArgumentException("Pattern letter count must be 2: " + cCharAt);
                    }
                    appendZoneId();
                }
                i2 = i3 - 1;
            } else if (cCharAt == '\'') {
                int i6 = i2 + 1;
                int i7 = i6;
                while (i7 < str.length()) {
                    if (str.charAt(i7) == '\'') {
                        int i8 = i7 + 1;
                        if (i8 >= str.length() || str.charAt(i8) != '\'') {
                            break;
                        } else {
                            i7 = i8;
                        }
                    }
                    i7++;
                }
                if (i7 >= str.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + str);
                }
                String strSubstring = str.substring(i6, i7);
                if (strSubstring.length() == 0) {
                    appendLiteral('\'');
                } else {
                    appendLiteral(strSubstring.replace("''", "'"));
                }
                i2 = i7;
            } else if (cCharAt == '[') {
                optionalStart();
            } else if (cCharAt == ']') {
                if (this.active.parent == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                optionalEnd();
            } else {
                if (cCharAt == '{' || cCharAt == '}' || cCharAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + cCharAt + "'");
                }
                appendLiteral(cCharAt);
            }
            i2++;
        }
    }

    private DateTimeFormatter toFormatter(Locale locale, ResolverStyle resolverStyle, Chronology chronology) {
        Objects.requireNonNull(locale, "locale");
        while (this.active.parent != null) {
            optionalEnd();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), locale, DecimalStyle.STANDARD, resolverStyle, null, chronology, null);
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        appendInternal(dateTimeFormatter.toPrinterParser(false));
        return this;
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField temporalField, int i, int i2, boolean z) {
        appendInternal(new FractionPrinterParser(temporalField, i, i2, z));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char c) {
        appendInternal(new CharLiteralPrinterParser(c));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.length() > 0) {
            appendInternal(str.length() == 1 ? new CharLiteralPrinterParser(str.charAt(0)) : new StringLiteralPrinterParser(str));
        }
        return this;
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle textStyle) {
        Objects.requireNonNull(textStyle, "style");
        if (textStyle != TextStyle.FULL && textStyle != TextStyle.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        appendInternal(new LocalizedOffsetIdPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder appendOffset(String str, String str2) {
        appendInternal(new OffsetIdPrinterParser(str, str2));
        return this;
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.INSTANCE_ID_Z);
        return this;
    }

    public DateTimeFormatterBuilder appendPattern(String str) {
        Objects.requireNonNull(str, "pattern");
        parsePattern(str);
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, TextStyle textStyle) {
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(textStyle, "textStyle");
        appendInternal(new TextPrinterParser(temporalField, textStyle, DateTimeTextProvider.getInstance()));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, Map map) {
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        final DateTimeTextProvider.LocaleStore localeStore = new DateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, linkedHashMap));
        appendInternal(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider() { // from class: j$.time.format.DateTimeFormatterBuilder.1
            @Override // j$.time.format.DateTimeTextProvider
            public String getText(TemporalField temporalField2, long j, TextStyle textStyle2, Locale locale) {
                return localeStore.getText(j, textStyle2);
            }

            @Override // j$.time.format.DateTimeTextProvider
            public Iterator getTextIterator(TemporalField temporalField2, TextStyle textStyle2, Locale locale) {
                return localeStore.getTextIterator(textStyle2);
            }
        }));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField) {
        Objects.requireNonNull(temporalField, "field");
        appendValue(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i) {
        Objects.requireNonNull(temporalField, "field");
        if (i >= 1 && i <= 19) {
            appendValue(new NumberPrinterParser(temporalField, i, i, SignStyle.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int i, int i2, SignStyle signStyle) {
        if (i == i2 && signStyle == SignStyle.NOT_NEGATIVE) {
            return appendValue(temporalField, i2);
        }
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(signStyle, "signStyle");
        if (i < 1 || i > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i);
        }
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i2);
        }
        if (i2 >= i) {
            appendValue(new NumberPrinterParser(temporalField, i, i2, signStyle));
            return this;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField temporalField, int i, int i2, ChronoLocalDate chronoLocalDate) {
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(chronoLocalDate, "baseDate");
        appendValue(new ReducedPrinterParser(temporalField, i, i2, 0, chronoLocalDate));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zoneId(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(QUERY_REGION_ONLY, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle) {
        appendInternal(new ZoneTextPrinterParser(textStyle, null));
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.parent == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.printerParsers.size() > 0) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.printerParsers, dateTimeFormatterBuilder2.optional);
            this.active = this.active.parent;
            appendInternal(compositePrinterParser);
        } else {
            this.active = this.active.parent;
        }
        return this;
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder padNext(int i) {
        return padNext(i, ' ');
    }

    public DateTimeFormatterBuilder padNext(int i, char c) {
        if (i < 1) {
            throw new IllegalArgumentException("The pad width must be at least one but was " + i);
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.padNextWidth = i;
        dateTimeFormatterBuilder.padNextChar = c;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        return this;
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault());
    }

    DateTimeFormatter toFormatter(ResolverStyle resolverStyle, Chronology chronology) {
        return toFormatter(Locale.getDefault(), resolverStyle, chronology);
    }

    public DateTimeFormatter toFormatter(Locale locale) {
        return toFormatter(locale, ResolverStyle.SMART, null);
    }
}
