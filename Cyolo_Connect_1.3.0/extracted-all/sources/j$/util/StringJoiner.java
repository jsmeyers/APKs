package j$.util;

/* JADX INFO: loaded from: classes4.dex */
public final class StringJoiner {
    private final String delimiter;
    private String emptyValue;
    private final String prefix;
    private final String suffix;
    private StringBuilder value;

    public StringJoiner(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Objects.requireNonNull(charSequence2, "The prefix must not be null");
        Objects.requireNonNull(charSequence, "The delimiter must not be null");
        Objects.requireNonNull(charSequence3, "The suffix must not be null");
        String string = charSequence2.toString();
        this.prefix = string;
        this.delimiter = charSequence.toString();
        String string2 = charSequence3.toString();
        this.suffix = string2;
        this.emptyValue = string + string2;
    }

    private StringBuilder prepareBuilder() {
        StringBuilder sb = this.value;
        if (sb != null) {
            sb.append(this.delimiter);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.prefix);
            this.value = sb2;
        }
        return this.value;
    }

    public StringJoiner add(CharSequence charSequence) {
        prepareBuilder().append(charSequence);
        return this;
    }

    public StringJoiner merge(StringJoiner stringJoiner) {
        Objects.requireNonNull(stringJoiner);
        StringBuilder sb = stringJoiner.value;
        if (sb != null) {
            prepareBuilder().append((CharSequence) stringJoiner.value, stringJoiner.prefix.length(), sb.length());
        }
        return this;
    }

    public String toString() {
        if (this.value == null) {
            return this.emptyValue;
        }
        if (this.suffix.equals("")) {
            return this.value.toString();
        }
        int length = this.value.length();
        StringBuilder sb = this.value;
        sb.append(this.suffix);
        String string = sb.toString();
        this.value.setLength(length);
        return string;
    }
}
