package com.bugsnag.android.internal;

import io.cyolo.android.MainActivityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: StringUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJh\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00110\u0014H\u0082\bJ\u000e\u0010\u001a\u001a\u00020\u001b*\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u001c\u001a\u00020\u001b*\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bugsnag/android/internal/StringUtils;", "", "()V", "trimMessageLength", "", "stringTrimmedTo", "", "maxLength", "str", "trimStringValuesTo", "Lcom/bugsnag/android/internal/TrimMetrics;", "maxStringLength", "list", "", "map", "", "trimValue", "", MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, "update", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "newValue", "stringTrimmed", "charsTrimmed", "isDefinitelyMutableList", "", "isDefinitelyMutableMap", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StringUtils {
    public static final StringUtils INSTANCE = new StringUtils();
    private static final int trimMessageLength = 25;

    private StringUtils() {
    }

    public final String stringTrimmedTo(int maxLength, String str) {
        int length = str.length() - maxLength;
        if (length < 25) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, maxLength);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append("***<");
        sb.append(length);
        sb.append("> CHARS TRUNCATED***");
        return sb.toString();
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x0035 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Found duplicated region for block: B:16:0x0055  */
    /* JADX WARN: Found duplicated region for block: B:18:0x005b A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Found duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Found duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Found duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Found duplicated region for block: B:32:0x004d A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:33:0x006e A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:36:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:9:0x002f  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final TrimMetrics trimStringValuesTo(int maxStringLength, List<Object> list) {
        int itemsTrimmed;
        int dataTrimmed;
        Object obj;
        int size = list.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < size) {
            int i4 = i + 1;
            StringUtils stringUtils = INSTANCE;
            Object obj2 = list.get(i);
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (str.length() > maxStringLength) {
                    Object objStringTrimmedTo = stringUtils.stringTrimmedTo(maxStringLength, str);
                    int length = str.length() - maxStringLength;
                    list.set(i, objStringTrimmedTo);
                    i2++;
                    i3 += length;
                } else {
                    if (stringUtils.isDefinitelyMutableMap(obj2)) {
                        if (obj2 != null) {
                            TrimMetrics trimMetricsTrimStringValuesTo = stringUtils.trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableMap(obj2));
                            itemsTrimmed = trimMetricsTrimStringValuesTo.getItemsTrimmed();
                            dataTrimmed = trimMetricsTrimStringValuesTo.getDataTrimmed();
                            obj = obj2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                        }
                    } else if (stringUtils.isDefinitelyMutableList(obj2)) {
                        if (obj2 != null) {
                            TrimMetrics trimMetricsTrimStringValuesTo2 = stringUtils.trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableList(obj2));
                            itemsTrimmed = trimMetricsTrimStringValuesTo2.getItemsTrimmed();
                            dataTrimmed = trimMetricsTrimStringValuesTo2.getDataTrimmed();
                            obj = obj2;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                        }
                    } else if (obj2 instanceof Map) {
                        Map<String, Object> mapAsMutableMap = TypeIntrinsics.asMutableMap(MapsKt.toMutableMap((Map) obj2));
                        TrimMetrics trimMetricsTrimStringValuesTo3 = stringUtils.trimStringValuesTo(maxStringLength, mapAsMutableMap);
                        itemsTrimmed = trimMetricsTrimStringValuesTo3.getItemsTrimmed();
                        dataTrimmed = trimMetricsTrimStringValuesTo3.getDataTrimmed();
                        obj = mapAsMutableMap;
                    } else if (obj2 instanceof Collection) {
                        List<Object> mutableList = CollectionsKt.toMutableList((Collection) obj2);
                        TrimMetrics trimMetricsTrimStringValuesTo4 = stringUtils.trimStringValuesTo(maxStringLength, mutableList);
                        itemsTrimmed = trimMetricsTrimStringValuesTo4.getItemsTrimmed();
                        dataTrimmed = trimMetricsTrimStringValuesTo4.getDataTrimmed();
                        obj = mutableList;
                    }
                    list.set(i, obj);
                    i2 += itemsTrimmed;
                    i3 += dataTrimmed;
                }
            } else {
                if (stringUtils.isDefinitelyMutableMap(obj2)) {
                    if (obj2 != null) {
                        TrimMetrics trimMetricsTrimStringValuesTo5 = stringUtils.trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableMap(obj2));
                        itemsTrimmed = trimMetricsTrimStringValuesTo5.getItemsTrimmed();
                        dataTrimmed = trimMetricsTrimStringValuesTo5.getDataTrimmed();
                        obj = obj2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                    }
                } else if (stringUtils.isDefinitelyMutableList(obj2)) {
                    if (obj2 != null) {
                        TrimMetrics trimMetricsTrimStringValuesTo22 = stringUtils.trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableList(obj2));
                        itemsTrimmed = trimMetricsTrimStringValuesTo22.getItemsTrimmed();
                        dataTrimmed = trimMetricsTrimStringValuesTo22.getDataTrimmed();
                        obj = obj2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                    }
                } else if (obj2 instanceof Map) {
                    Map<String, Object> mapAsMutableMap2 = TypeIntrinsics.asMutableMap(MapsKt.toMutableMap((Map) obj2));
                    TrimMetrics trimMetricsTrimStringValuesTo32 = stringUtils.trimStringValuesTo(maxStringLength, mapAsMutableMap2);
                    itemsTrimmed = trimMetricsTrimStringValuesTo32.getItemsTrimmed();
                    dataTrimmed = trimMetricsTrimStringValuesTo32.getDataTrimmed();
                    obj = mapAsMutableMap2;
                } else if (obj2 instanceof Collection) {
                    List<Object> mutableList2 = CollectionsKt.toMutableList((Collection) obj2);
                    TrimMetrics trimMetricsTrimStringValuesTo42 = stringUtils.trimStringValuesTo(maxStringLength, mutableList2);
                    itemsTrimmed = trimMetricsTrimStringValuesTo42.getItemsTrimmed();
                    dataTrimmed = trimMetricsTrimStringValuesTo42.getDataTrimmed();
                    obj = mutableList2;
                }
                list.set(i, obj);
                i2 += itemsTrimmed;
                i3 += dataTrimmed;
            }
            i = i4;
        }
        return new TrimMetrics(i2, i3);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final TrimMetrics trimStringValuesTo(int maxStringLength, Map<String, Object> map) {
        int itemsTrimmed;
        int dataTrimmed;
        List<Object> list;
        Iterator<T> it = map.entrySet().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            StringUtils stringUtils = INSTANCE;
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (str.length() > maxStringLength) {
                    String strStringTrimmedTo = stringUtils.stringTrimmedTo(maxStringLength, str);
                    int length = str.length() - maxStringLength;
                    entry.setValue(strStringTrimmedTo);
                    i++;
                    i2 += length;
                }
            }
            if (stringUtils.isDefinitelyMutableMap(value)) {
                if (value != null) {
                    TrimMetrics trimMetricsTrimStringValuesTo = stringUtils.trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableMap(value));
                    itemsTrimmed = trimMetricsTrimStringValuesTo.getItemsTrimmed();
                    dataTrimmed = trimMetricsTrimStringValuesTo.getDataTrimmed();
                    list = value;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                }
            } else if (stringUtils.isDefinitelyMutableList(value)) {
                if (value != null) {
                    TrimMetrics trimMetricsTrimStringValuesTo2 = stringUtils.trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableList(value));
                    itemsTrimmed = trimMetricsTrimStringValuesTo2.getItemsTrimmed();
                    dataTrimmed = trimMetricsTrimStringValuesTo2.getDataTrimmed();
                    list = value;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                }
            } else if (value instanceof Map) {
                Map<String, Object> mapAsMutableMap = TypeIntrinsics.asMutableMap(MapsKt.toMutableMap((Map) value));
                TrimMetrics trimMetricsTrimStringValuesTo3 = stringUtils.trimStringValuesTo(maxStringLength, mapAsMutableMap);
                itemsTrimmed = trimMetricsTrimStringValuesTo3.getItemsTrimmed();
                dataTrimmed = trimMetricsTrimStringValuesTo3.getDataTrimmed();
                list = mapAsMutableMap;
            } else if (value instanceof Collection) {
                List<Object> mutableList = CollectionsKt.toMutableList((Collection) value);
                TrimMetrics trimMetricsTrimStringValuesTo4 = stringUtils.trimStringValuesTo(maxStringLength, mutableList);
                itemsTrimmed = trimMetricsTrimStringValuesTo4.getItemsTrimmed();
                dataTrimmed = trimMetricsTrimStringValuesTo4.getDataTrimmed();
                list = mutableList;
            }
            entry.setValue(list);
            i += itemsTrimmed;
            i2 += dataTrimmed;
        }
        return new TrimMetrics(i, i2);
    }

    private final void trimValue(int maxStringLength, Object value, Function3<Object, ? super Integer, ? super Integer, Unit> update) {
        if (value instanceof String) {
            String str = (String) value;
            if (str.length() > maxStringLength) {
                update.invoke(stringTrimmedTo(maxStringLength, str), 1, Integer.valueOf(str.length() - maxStringLength));
                return;
            }
        }
        if (isDefinitelyMutableMap(value)) {
            if (value != null) {
                TrimMetrics trimMetricsTrimStringValuesTo = trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableMap(value));
                update.invoke(value, Integer.valueOf(trimMetricsTrimStringValuesTo.getItemsTrimmed()), Integer.valueOf(trimMetricsTrimStringValuesTo.getDataTrimmed()));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
        }
        if (isDefinitelyMutableList(value)) {
            if (value != null) {
                TrimMetrics trimMetricsTrimStringValuesTo2 = trimStringValuesTo(maxStringLength, TypeIntrinsics.asMutableList(value));
                update.invoke(value, Integer.valueOf(trimMetricsTrimStringValuesTo2.getItemsTrimmed()), Integer.valueOf(trimMetricsTrimStringValuesTo2.getDataTrimmed()));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
        }
        if (value instanceof Map) {
            Map<String, Object> mapAsMutableMap = TypeIntrinsics.asMutableMap(MapsKt.toMutableMap((Map) value));
            TrimMetrics trimMetricsTrimStringValuesTo3 = trimStringValuesTo(maxStringLength, mapAsMutableMap);
            update.invoke(mapAsMutableMap, Integer.valueOf(trimMetricsTrimStringValuesTo3.getItemsTrimmed()), Integer.valueOf(trimMetricsTrimStringValuesTo3.getDataTrimmed()));
            return;
        }
        if (value instanceof Collection) {
            List<Object> mutableList = CollectionsKt.toMutableList((Collection) value);
            TrimMetrics trimMetricsTrimStringValuesTo4 = trimStringValuesTo(maxStringLength, mutableList);
            update.invoke(mutableList, Integer.valueOf(trimMetricsTrimStringValuesTo4.getItemsTrimmed()), Integer.valueOf(trimMetricsTrimStringValuesTo4.getDataTrimmed()));
        }
    }

    private final boolean isDefinitelyMutableMap(Object obj) {
        return (obj instanceof HashMap) || (obj instanceof TreeMap) || (obj instanceof ConcurrentMap) || (obj instanceof EnumMap) || (obj instanceof Hashtable) || (obj instanceof WeakHashMap);
    }

    private final boolean isDefinitelyMutableList(Object obj) {
        return (obj instanceof ArrayList) || (obj instanceof LinkedList) || (obj instanceof CopyOnWriteArrayList) || (obj instanceof Vector);
    }
}
