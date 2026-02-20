package j$.time.format;

import j$.time.DateTimeException;

/* JADX INFO: loaded from: classes4.dex */
public class DateTimeParseException extends DateTimeException {
    private final int errorIndex;
    private final String parsedString;

    public DateTimeParseException(String str, CharSequence charSequence, int i) {
        super(str);
        this.parsedString = charSequence.toString();
        this.errorIndex = i;
    }

    public DateTimeParseException(String str, CharSequence charSequence, int i, Throwable th) {
        super(str, th);
        this.parsedString = charSequence.toString();
        this.errorIndex = i;
    }
}
