package j$.time.temporal;

/* JADX INFO: loaded from: classes4.dex */
public interface Temporal extends TemporalAccessor {
    Temporal minus(long j, TemporalUnit temporalUnit);

    Temporal plus(long j, TemporalUnit temporalUnit);

    long until(Temporal temporal, TemporalUnit temporalUnit);

    Temporal with(TemporalAdjuster temporalAdjuster);

    Temporal with(TemporalField temporalField, long j);
}
