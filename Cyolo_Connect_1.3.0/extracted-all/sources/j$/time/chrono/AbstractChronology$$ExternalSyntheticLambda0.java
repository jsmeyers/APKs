package j$.time.chrono;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AbstractChronology$$ExternalSyntheticLambda0 implements Comparator, Serializable {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Long.compare(((ChronoLocalDate) obj).toEpochDay(), ((ChronoLocalDate) obj2).toEpochDay());
    }
}
