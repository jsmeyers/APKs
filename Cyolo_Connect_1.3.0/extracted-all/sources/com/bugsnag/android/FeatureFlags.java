package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: FeatureFlags.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0016\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0006\u0010\u0013\u001a\u00020\u0000J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bugsnag/android/FeatureFlags;", "Lcom/bugsnag/android/JsonStream$Streamable;", "Lcom/bugsnag/android/FeatureFlagAware;", "()V", "flags", "", "Lcom/bugsnag/android/FeatureFlag;", "([Lcom/bugsnag/android/FeatureFlag;)V", "[Lcom/bugsnag/android/FeatureFlag;", "addFeatureFlag", "", "name", "", "variant", "addFeatureFlags", "featureFlags", "", "clearFeatureFlag", "clearFeatureFlags", "copy", "toList", "", "toStream", "stream", "Lcom/bugsnag/android/JsonStream;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FeatureFlags implements JsonStream.Streamable, FeatureFlagAware {
    private volatile FeatureFlag[] flags;

    private FeatureFlags(FeatureFlag[] featureFlagArr) {
        this.flags = featureFlagArr;
    }

    public FeatureFlags() {
        this(new FeatureFlag[0]);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String name) {
        addFeatureFlag(name, null);
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlag(String name, String variant) {
        FeatureFlag[] featureFlagArr;
        synchronized (this) {
            FeatureFlag[] featureFlagArr2 = this.flags;
            int length = featureFlagArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                int i2 = i + 1;
                if (kotlin.jvm.internal.Intrinsics.areEqual(featureFlagArr2[i].getName(), name)) {
                    break;
                } else {
                    i = i2;
                }
            }
            if (i == -1) {
                featureFlagArr = (FeatureFlag[]) ArraysKt.plus(featureFlagArr2, new FeatureFlag(name, variant));
            } else {
                if (kotlin.jvm.internal.Intrinsics.areEqual(featureFlagArr2[i].getVariant(), variant)) {
                    return;
                }
                Object[] objArrCopyOf = Arrays.copyOf(featureFlagArr2, featureFlagArr2.length);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
                ((FeatureFlag[]) objArrCopyOf)[i] = new FeatureFlag(name, variant);
                featureFlagArr = (FeatureFlag[]) objArrCopyOf;
            }
            this.flags = featureFlagArr;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void addFeatureFlags(Iterable<FeatureFlag> featureFlags) {
        synchronized (this) {
            FeatureFlag[] featureFlagArr = this.flags;
            ArrayList arrayList = new ArrayList(featureFlags instanceof Collection ? featureFlagArr.length + ((Collection) featureFlags).size() : Math.max(featureFlagArr.length * 2, featureFlagArr.length));
            CollectionsKt.addAll(arrayList, featureFlagArr);
            Iterator<FeatureFlag> it = featureFlags.iterator();
            while (true) {
                int i = 0;
                if (!it.hasNext()) {
                    break;
                }
                FeatureFlag next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    } else if (kotlin.jvm.internal.Intrinsics.areEqual(((FeatureFlag) it2.next()).getName(), key)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i == -1) {
                    arrayList.add(new FeatureFlag(key, value));
                } else {
                    arrayList.set(i, new FeatureFlag(key, value));
                }
            }
            Object[] array = arrayList.toArray(new FeatureFlag[0]);
            if (array != null) {
                this.flags = (FeatureFlag[]) array;
                Unit unit = Unit.INSTANCE;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlag(String name) {
        synchronized (this) {
            FeatureFlag[] featureFlagArr = this.flags;
            int length = featureFlagArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                int i2 = i + 1;
                if (kotlin.jvm.internal.Intrinsics.areEqual(featureFlagArr[i].getName(), name)) {
                    break;
                } else {
                    i = i2;
                }
            }
            if (i == -1) {
                return;
            }
            FeatureFlag[] featureFlagArr2 = new FeatureFlag[featureFlagArr.length - 1];
            ArraysKt.copyInto(featureFlagArr, featureFlagArr2, 0, 0, i);
            ArraysKt.copyInto$default(featureFlagArr, featureFlagArr2, i, i + 1, 0, 8, (Object) null);
            this.flags = featureFlagArr2;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bugsnag.android.FeatureFlagAware
    public void clearFeatureFlags() {
        synchronized (this) {
            this.flags = new FeatureFlag[0];
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream stream) throws IOException {
        FeatureFlag[] featureFlagArr = this.flags;
        stream.beginArray();
        int length = featureFlagArr.length;
        int i = 0;
        while (i < length) {
            FeatureFlag featureFlag = featureFlagArr[i];
            i++;
            FeatureFlag featureFlag2 = featureFlag;
            String key = featureFlag2.getKey();
            String value = featureFlag2.getValue();
            stream.beginObject();
            stream.name("featureFlag").value(key);
            if (value != null) {
                stream.name("variant").value(value);
            }
            stream.endObject();
        }
        stream.endArray();
    }

    public final List<FeatureFlag> toList() {
        FeatureFlag[] featureFlagArr = this.flags;
        ArrayList arrayList = new ArrayList(featureFlagArr.length);
        int length = featureFlagArr.length;
        int i = 0;
        while (i < length) {
            FeatureFlag featureFlag = featureFlagArr[i];
            i++;
            FeatureFlag featureFlag2 = featureFlag;
            arrayList.add(new FeatureFlag(featureFlag2.getKey(), featureFlag2.getValue()));
        }
        return arrayList;
    }

    public final FeatureFlags copy() {
        return new FeatureFlags(this.flags);
    }
}
