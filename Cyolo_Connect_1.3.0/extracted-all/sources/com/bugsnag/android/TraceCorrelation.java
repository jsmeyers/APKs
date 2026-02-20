package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: TraceCorrelation.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\f\u0010\u001a\u001a\u00020\u0019*\u00020\u0003H\u0002J\f\u0010\u001a\u001a\u00020\u0019*\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bugsnag/android/TraceCorrelation;", "Lcom/bugsnag/android/JsonStream$Streamable;", "traceId", "Ljava/util/UUID;", "spanId", "", "(Ljava/util/UUID;J)V", "getSpanId", "()J", "getTraceId", "()Ljava/util/UUID;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "toString", "", "toHexString", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class TraceCorrelation implements JsonStream.Streamable {
    private final long spanId;
    private final UUID traceId;

    public static /* synthetic */ TraceCorrelation copy$default(TraceCorrelation traceCorrelation, UUID uuid, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = traceCorrelation.traceId;
        }
        if ((i & 2) != 0) {
            j = traceCorrelation.spanId;
        }
        return traceCorrelation.copy(uuid, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UUID getTraceId() {
        return this.traceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSpanId() {
        return this.spanId;
    }

    public final TraceCorrelation copy(UUID traceId, long spanId) {
        return new TraceCorrelation(traceId, spanId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraceCorrelation)) {
            return false;
        }
        TraceCorrelation traceCorrelation = (TraceCorrelation) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.traceId, traceCorrelation.traceId) && this.spanId == traceCorrelation.spanId;
    }

    public int hashCode() {
        return (this.traceId.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.spanId);
    }

    public String toString() {
        return "TraceCorrelation(traceId=" + this.traceId + ", spanId=" + this.spanId + ')';
    }

    public TraceCorrelation(UUID uuid, long j) {
        this.traceId = uuid;
        this.spanId = j;
    }

    public final long getSpanId() {
        return this.spanId;
    }

    public final UUID getTraceId() {
        return this.traceId;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws IOException {
        writer.beginObject().name("traceId").value(toHexString(this.traceId)).name("spanId").value(toHexString(this.spanId));
        writer.endObject();
    }

    private final String toHexString(UUID uuid) {
        String str = String.format("%016x%016x", Arrays.copyOf(new Object[]{Long.valueOf(uuid.getMostSignificantBits()), Long.valueOf(uuid.getLeastSignificantBits())}, 2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        return str;
    }

    private final String toHexString(long j) {
        String str = String.format("%016x", Arrays.copyOf(new Object[]{Long.valueOf(j)}, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        return str;
    }
}
