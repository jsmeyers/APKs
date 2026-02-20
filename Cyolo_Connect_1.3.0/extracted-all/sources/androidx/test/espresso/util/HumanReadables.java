package androidx.test.espresso.util;

import android.content.res.Resources;
import android.database.Cursor;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Joiner;
import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Strings;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.util.TreeIterables;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public final class HumanReadables {
    private static boolean isViewIdGenerated(int id) {
        return ((-16777216) & id) == 0 && (id & ViewCompat.MEASURED_SIZE_MASK) != 0;
    }

    private HumanReadables() {
    }

    public static String getViewHierarchyErrorMessage(View rootView, final List<View> problemViews, String errorHeader, final String problemViewSuffix) {
        Preconditions.checkArgument(problemViews == null || problemViewSuffix != null);
        StringBuilder sb = new StringBuilder(errorHeader);
        if (problemViewSuffix != null) {
            sb.append(String.format(Locale.ROOT, "\nProblem views are marked with '%s' below.", problemViewSuffix));
        }
        sb.append("\n\nView Hierarchy:\n");
        Joiner.on(IOUtils.LINE_SEPARATOR_UNIX).appendTo(sb, Iterables.transform(TreeIterables.depthFirstViewTraversalWithDistance(rootView), new Function<TreeIterables.ViewAndDistance, String>() { // from class: androidx.test.espresso.util.HumanReadables.1
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
            public String apply(TreeIterables.ViewAndDistance viewAndDistance) {
                List list = problemViews;
                String strConcat = "+%s%s ";
                if (list != null && list.contains(viewAndDistance.getView())) {
                    String strValueOf = String.valueOf(problemViewSuffix);
                    strConcat = strValueOf.length() != 0 ? "+%s%s ".concat(strValueOf) : new String("+%s%s ");
                }
                return String.format(Locale.ROOT, String.valueOf(strConcat).concat("\n|"), Strings.padStart(">", viewAndDistance.getDistanceFromRoot() + 1, '-'), HumanReadables.describe(viewAndDistance.getView()));
            }
        }));
        return sb.toString();
    }

    public static String describe(Cursor c) {
        if (c.isBeforeFirst()) {
            return "Cursor positioned before first element.";
        }
        if (c.isAfterLast()) {
            return "Cursor positioned after last element.";
        }
        StringBuilder sb = new StringBuilder("Row ");
        sb.append(c.getPosition());
        sb.append(": {");
        String[] columnNames = c.getColumnNames();
        for (int i = 0; i < columnNames.length; i++) {
            sb.append(columnNames[i]);
            sb.append(":");
            int type = c.getType(i);
            if (type == 0) {
                sb.append("null");
            } else if (type == 1) {
                sb.append(c.getLong(i));
            } else if (type == 2) {
                sb.append(c.getDouble(i));
                sb.append("f");
            } else if (type == 3) {
                sb.append("\"");
                sb.append(c.getString(i));
                sb.append("\"");
            } else if (type == 4) {
                byte[] blob = c.getBlob(i);
                sb.append("[");
                for (int i2 = 0; i2 < 5 && i2 < blob.length; i2++) {
                    sb.append((int) blob[i2]);
                    sb.append(",");
                }
                if (5 < blob.length) {
                    sb.append("... (");
                    sb.append(blob.length - 5);
                    sb.append(" more elements)");
                }
                sb.append("]");
            } else {
                sb.append("\"");
                sb.append(c.getString(i));
                sb.append("\"");
            }
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String describe(View v) {
        if (v == 0) {
            return "null";
        }
        MoreObjects.ToStringHelper toStringHelperAdd = MoreObjects.toStringHelper(v).add("id", v.getId());
        if (v.getId() != -1 && v.getResources() != null && !isViewIdGenerated(v.getId())) {
            try {
                toStringHelperAdd.add("res-name", v.getResources().getResourceEntryName(v.getId()));
            } catch (Resources.NotFoundException unused) {
            }
        }
        if (v.getContentDescription() != null) {
            toStringHelperAdd.add("desc", v.getContentDescription());
        }
        int visibility = v.getVisibility();
        if (visibility == 0) {
            toStringHelperAdd.add("visibility", "VISIBLE");
        } else if (visibility == 4) {
            toStringHelperAdd.add("visibility", "INVISIBLE");
        } else if (visibility == 8) {
            toStringHelperAdd.add("visibility", "GONE");
        } else {
            toStringHelperAdd.add("visibility", v.getVisibility());
        }
        toStringHelperAdd.add("width", v.getWidth()).add("height", v.getHeight()).add("has-focus", v.hasFocus()).add("has-focusable", v.hasFocusable()).add("has-window-focus", v.hasWindowFocus()).add("is-clickable", v.isClickable()).add("is-enabled", v.isEnabled()).add("is-focused", v.isFocused()).add("is-focusable", v.isFocusable()).add("is-layout-requested", v.isLayoutRequested()).add("is-selected", v.isSelected()).add("layout-params", v.getLayoutParams()).add("tag", v.getTag());
        if (v.getRootView() != null) {
            toStringHelperAdd.add("root-is-layout-requested", v.getRootView().isLayoutRequested());
        }
        EditorInfo editorInfo = new EditorInfo();
        boolean z = v.onCreateInputConnection(editorInfo) != null;
        toStringHelperAdd.add("has-input-connection", z);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            editorInfo.dump(new StringBuilderPrinter(sb), "");
            sb.append("]");
            toStringHelperAdd.add("editor-info", sb.toString().replace(IOUtils.LINE_SEPARATOR_UNIX, " "));
        }
        toStringHelperAdd.add("x", v.getX()).add("y", v.getY());
        if (v instanceof TextView) {
            innerDescribe((TextView) v, toStringHelperAdd);
        }
        if (v instanceof Checkable) {
            innerDescribe((Checkable) v, toStringHelperAdd);
        }
        if (v instanceof ViewGroup) {
            innerDescribe((ViewGroup) v, toStringHelperAdd);
        }
        return toStringHelperAdd.toString();
    }

    private static void innerDescribe(TextView textBox, MoreObjects.ToStringHelper helper) {
        if (textBox.getText() != null) {
            helper.add("text", textBox.getText());
        }
        if (textBox.getError() != null) {
            helper.add("error-text", textBox.getError());
        }
        if (textBox.getHint() != null) {
            helper.add("hint", textBox.getHint());
        }
        helper.add("input-type", textBox.getInputType());
        helper.add("ime-target", textBox.isInputMethodTarget());
        helper.add("has-links", textBox.getUrls().length > 0);
    }

    private static void innerDescribe(Checkable checkable, MoreObjects.ToStringHelper helper) {
        helper.add("is-checked", checkable.isChecked());
    }

    private static void innerDescribe(ViewGroup viewGroup, MoreObjects.ToStringHelper helper) {
        helper.add("child-count", viewGroup.getChildCount());
    }
}
