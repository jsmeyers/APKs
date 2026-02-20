package androidx.test.espresso.matcher;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.Arrays;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.SelfDescribing;
import org.hamcrest.StringDescription;

/* JADX INFO: loaded from: classes.dex */
public final class CursorMatchers {
    private static final int COLUMN_NOT_FOUND = -1;
    private static final int MULTIPLE_COLUMNS_FOUND = -2;
    private static final int USE_COLUMN_PICKER = -3;
    private static final MatcherApplier BLOB_MATCHER_APPLIER = new MatcherApplier() { // from class: androidx.test.espresso.matcher.CursorMatchers.1
        @Override // androidx.test.espresso.matcher.CursorMatchers.MatcherApplier
        public boolean apply(Cursor cursor, int chosenColumn, Matcher<?> matcher) {
            return matcher.matches(cursor.getBlob(chosenColumn));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Blob");
        }
    };
    private static final MatcherApplier LONG_MATCHER_APPLIER = new MatcherApplier() { // from class: androidx.test.espresso.matcher.CursorMatchers.2
        @Override // androidx.test.espresso.matcher.CursorMatchers.MatcherApplier
        public boolean apply(Cursor cursor, int chosenColumn, Matcher<?> matcher) {
            return matcher.matches(Long.valueOf(cursor.getLong(chosenColumn)));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Long");
        }
    };
    private static final MatcherApplier SHORT_MATCHER_APPLIER = new MatcherApplier() { // from class: androidx.test.espresso.matcher.CursorMatchers.3
        @Override // androidx.test.espresso.matcher.CursorMatchers.MatcherApplier
        public boolean apply(Cursor cursor, int chosenColumn, Matcher<?> matcher) {
            return matcher.matches(Short.valueOf(cursor.getShort(chosenColumn)));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Short");
        }
    };
    private static final MatcherApplier INT_MATCHER_APPLIER = new MatcherApplier() { // from class: androidx.test.espresso.matcher.CursorMatchers.4
        @Override // androidx.test.espresso.matcher.CursorMatchers.MatcherApplier
        public boolean apply(Cursor cursor, int chosenColumn, Matcher<?> matcher) {
            return matcher.matches(Integer.valueOf(cursor.getInt(chosenColumn)));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Int");
        }
    };
    private static final MatcherApplier FLOAT_MATCHER_APPLIER = new MatcherApplier() { // from class: androidx.test.espresso.matcher.CursorMatchers.5
        @Override // androidx.test.espresso.matcher.CursorMatchers.MatcherApplier
        public boolean apply(Cursor cursor, int chosenColumn, Matcher<?> matcher) {
            return matcher.matches(Float.valueOf(cursor.getFloat(chosenColumn)));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Float");
        }
    };
    private static final MatcherApplier DOUBLE_MATCHER_APPLIER = new MatcherApplier() { // from class: androidx.test.espresso.matcher.CursorMatchers.6
        @Override // androidx.test.espresso.matcher.CursorMatchers.MatcherApplier
        public boolean apply(Cursor cursor, int chosenColumn, Matcher<?> matcher) {
            return matcher.matches(Double.valueOf(cursor.getDouble(chosenColumn)));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with Double");
        }
    };
    private static final MatcherApplier STRING_MATCHER_APPLIER = new MatcherApplier() { // from class: androidx.test.espresso.matcher.CursorMatchers.7
        @Override // androidx.test.espresso.matcher.CursorMatchers.MatcherApplier
        public boolean apply(Cursor cursor, int chosenColumn, Matcher<?> matcher) {
            return matcher.matches(cursor.getString(chosenColumn));
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with String");
        }
    };

    private interface MatcherApplier extends SelfDescribing {
        boolean apply(Cursor cursor, int chosenColumn, Matcher<?> matcher);
    }

    private CursorMatchers() {
    }

    public static class CursorMatcher extends BoundedMatcher<Object, Cursor> {
        private final MatcherApplier applier;
        private boolean checkColumns;
        private final int columnIndex;
        private final Matcher<String> columnNameMatcher;
        private final Matcher<?> valueMatcher;

        private CursorMatcher(int columnIndex, Matcher<?> valueMatcher, MatcherApplier applier) {
            super(Cursor.class);
            this.checkColumns = true;
            Preconditions.checkArgument(columnIndex >= 0);
            this.columnIndex = columnIndex;
            this.valueMatcher = (Matcher) Preconditions.checkNotNull(valueMatcher);
            this.applier = (MatcherApplier) Preconditions.checkNotNull(applier);
            this.columnNameMatcher = null;
        }

        private CursorMatcher(Matcher<String> columnPicker, Matcher<?> valueMatcher, MatcherApplier applier) {
            super(Cursor.class);
            this.checkColumns = true;
            this.columnNameMatcher = (Matcher) Preconditions.checkNotNull(columnPicker);
            this.valueMatcher = (Matcher) Preconditions.checkNotNull(valueMatcher);
            this.applier = (MatcherApplier) Preconditions.checkNotNull(applier);
            this.columnIndex = -3;
        }

        @Override // androidx.test.espresso.matcher.BoundedMatcher
        public boolean matchesSafely(Cursor cursor) {
            int iFindColumnIndex = this.columnIndex;
            if (iFindColumnIndex < 0 && (iFindColumnIndex = CursorMatchers.findColumnIndex(this.columnNameMatcher, cursor)) < 0) {
                StringDescription stringDescription = new StringDescription();
                this.columnNameMatcher.describeTo(stringDescription);
                if (iFindColumnIndex == -1) {
                    if (!this.checkColumns) {
                        return false;
                    }
                    String strValueOf = String.valueOf(Arrays.asList(cursor.getColumnNames()));
                    String string = stringDescription.toString();
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 34 + String.valueOf(string).length());
                    sb.append("Couldn't find column in ");
                    sb.append(strValueOf);
                    sb.append(" matching ");
                    sb.append(string);
                    throw new IllegalArgumentException(sb.toString());
                }
                if (iFindColumnIndex == -2) {
                    String strValueOf2 = String.valueOf(Arrays.asList(cursor.getColumnNames()));
                    String string2 = stringDescription.toString();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 27 + String.valueOf(string2).length());
                    sb2.append("Multiple columns in ");
                    sb2.append(strValueOf2);
                    sb2.append(" match ");
                    sb2.append(string2);
                    throw new IllegalArgumentException(sb2.toString());
                }
                String strValueOf3 = String.valueOf(Arrays.asList(cursor.getColumnNames()));
                StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf3).length() + 24);
                sb3.append("Couldn't find column in ");
                sb3.append(strValueOf3);
                throw new IllegalArgumentException(sb3.toString());
            }
            try {
                return this.applier.apply(cursor, iFindColumnIndex, this.valueMatcher);
            } catch (CursorIndexOutOfBoundsException e) {
                if (this.checkColumns) {
                    throw new IllegalArgumentException("Column index is invalid", e);
                }
                return false;
            }
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("Rows with column: ");
            int i = this.columnIndex;
            if (i < 0) {
                this.columnNameMatcher.describeTo(description);
            } else {
                StringBuilder sb = new StringBuilder(21);
                sb.append(" index = ");
                sb.append(i);
                sb.append(" ");
                description.appendText(sb.toString());
            }
            this.applier.describeTo(description);
            description.appendText(" ");
            this.valueMatcher.describeTo(description);
        }

        public CursorMatcher withStrictColumnChecks(boolean checkColumns) {
            this.checkColumns = checkColumns;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int findColumnIndex(Matcher<String> nameMatcher, Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        int i = -1;
        for (int i2 = 0; i2 < columnNames.length; i2++) {
            if (nameMatcher.matches(columnNames[i2])) {
                if (i != -1) {
                    return -2;
                }
                i = i2;
            }
        }
        return i;
    }

    public static CursorMatcher withRowShort(int columnIndex, short value) {
        return withRowShort(columnIndex, (Matcher<Short>) Matchers.is(Short.valueOf(value)));
    }

    public static CursorMatcher withRowShort(int columnIndex, Matcher<Short> valueMatcher) {
        return new CursorMatcher(columnIndex, valueMatcher, SHORT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowShort(String columnName, short value) {
        return withRowShort(columnName, (Matcher<Short>) Matchers.is(Short.valueOf(value)));
    }

    public static CursorMatcher withRowShort(String columnName, Matcher<Short> valueMatcher) {
        return withRowShort((Matcher<String>) Matchers.is(columnName), valueMatcher);
    }

    public static CursorMatcher withRowShort(Matcher<String> columnNameMatcher, Matcher<Short> valueMatcher) {
        return new CursorMatcher(columnNameMatcher, valueMatcher, SHORT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowInt(int columnIndex, int value) {
        return withRowInt(columnIndex, (Matcher<Integer>) Matchers.is(Integer.valueOf(value)));
    }

    public static CursorMatcher withRowInt(int columnIndex, Matcher<Integer> valueMatcher) {
        return new CursorMatcher(columnIndex, valueMatcher, INT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowInt(String columnName, int value) {
        return withRowInt(columnName, (Matcher<Integer>) Matchers.is(Integer.valueOf(value)));
    }

    public static CursorMatcher withRowInt(String columnName, Matcher<Integer> valueMatcher) {
        return withRowInt((Matcher<String>) Matchers.is(columnName), valueMatcher);
    }

    public static CursorMatcher withRowInt(Matcher<String> columnNameMatcher, final Matcher<Integer> valueMatcher) {
        return new CursorMatcher(columnNameMatcher, valueMatcher, INT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowLong(int columnIndex, long value) {
        return withRowLong(columnIndex, (Matcher<Long>) Matchers.is(Long.valueOf(value)));
    }

    public static CursorMatcher withRowLong(int columnIndex, Matcher<Long> valueMatcher) {
        return new CursorMatcher(columnIndex, valueMatcher, LONG_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowLong(String columnName, long value) {
        return withRowLong(columnName, (Matcher<Long>) Matchers.is(Long.valueOf(value)));
    }

    public static CursorMatcher withRowLong(String columnName, Matcher<Long> valueMatcher) {
        return withRowLong((Matcher<String>) Matchers.is(columnName), valueMatcher);
    }

    public static CursorMatcher withRowLong(Matcher<String> columnNameMatcher, Matcher<Long> valueMatcher) {
        return new CursorMatcher(columnNameMatcher, valueMatcher, LONG_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowFloat(int columnIndex, float value) {
        return withRowFloat(columnIndex, (Matcher<Float>) Matchers.is(Float.valueOf(value)));
    }

    public static CursorMatcher withRowFloat(int columnIndex, Matcher<Float> valueMatcher) {
        return new CursorMatcher(columnIndex, valueMatcher, FLOAT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowFloat(String columnName, float value) {
        return withRowFloat(columnName, (Matcher<Float>) Matchers.is(Float.valueOf(value)));
    }

    public static CursorMatcher withRowFloat(String columnName, Matcher<Float> valueMatcher) {
        return withRowFloat((Matcher<String>) Matchers.is(columnName), valueMatcher);
    }

    public static CursorMatcher withRowFloat(Matcher<String> columnNameMatcher, Matcher<Float> valueMatcher) {
        return new CursorMatcher(columnNameMatcher, valueMatcher, FLOAT_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowDouble(int columnIndex, double value) {
        return withRowDouble(columnIndex, (Matcher<Double>) Matchers.is(Double.valueOf(value)));
    }

    public static CursorMatcher withRowDouble(int columnIndex, Matcher<Double> valueMatcher) {
        return new CursorMatcher(columnIndex, valueMatcher, DOUBLE_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowDouble(String columnName, double value) {
        return withRowDouble(columnName, (Matcher<Double>) Matchers.is(Double.valueOf(value)));
    }

    public static CursorMatcher withRowDouble(String columnName, Matcher<Double> valueMatcher) {
        return withRowDouble((Matcher<String>) Matchers.is(columnName), valueMatcher);
    }

    public static CursorMatcher withRowDouble(Matcher<String> columnNameMatcher, Matcher<Double> valueMatcher) {
        return new CursorMatcher(columnNameMatcher, valueMatcher, DOUBLE_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowString(int columnIndex, String value) {
        return withRowString(columnIndex, (Matcher<String>) Matchers.is(value));
    }

    public static CursorMatcher withRowString(int columnIndex, Matcher<String> valueMatcher) {
        return new CursorMatcher(columnIndex, valueMatcher, STRING_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowString(String columnName, String value) {
        return withRowString((Matcher<String>) Matchers.is(columnName), (Matcher<String>) Matchers.is(value));
    }

    public static CursorMatcher withRowString(String columnName, Matcher<String> valueMatcher) {
        return withRowString((Matcher<String>) Matchers.is(columnName), valueMatcher);
    }

    public static CursorMatcher withRowString(final Matcher<String> columnPicker, final Matcher<String> valueMatcher) {
        return new CursorMatcher(columnPicker, valueMatcher, STRING_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowBlob(int columnIndex, byte[] value) {
        return withRowBlob(columnIndex, (Matcher<byte[]>) Matchers.is(value));
    }

    public static CursorMatcher withRowBlob(int columnIndex, Matcher<byte[]> valueMatcher) {
        return new CursorMatcher(columnIndex, valueMatcher, BLOB_MATCHER_APPLIER);
    }

    public static CursorMatcher withRowBlob(String columnName, byte[] value) {
        return withRowBlob((Matcher<String>) Matchers.is(columnName), (Matcher<byte[]>) Matchers.is(value));
    }

    public static CursorMatcher withRowBlob(String columnName, Matcher<byte[]> valueMatcher) {
        return withRowBlob((Matcher<String>) Matchers.is(columnName), valueMatcher);
    }

    public static CursorMatcher withRowBlob(Matcher<String> columnPicker, Matcher<byte[]> valueMatcher) {
        return new CursorMatcher(columnPicker, valueMatcher, BLOB_MATCHER_APPLIER);
    }
}
