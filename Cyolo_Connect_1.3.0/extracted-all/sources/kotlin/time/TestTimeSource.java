package kotlin.time;

import kotlin.Metadata;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* JADX INFO: renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1937plusAssignLRDsOJo(long duration) {
        long jM1847toLongimpl = Duration.m1847toLongimpl(duration, getUnit());
        if (!(((jM1847toLongimpl - 1) | 1) == Long.MAX_VALUE)) {
            long j = this.reading;
            long j2 = j + jM1847toLongimpl;
            if ((jM1847toLongimpl ^ j) >= 0 && (j ^ j2) < 0) {
                m1936overflowLRDsOJo(duration);
            }
            this.reading = j2;
            return;
        }
        long jM1804divUwyO8pc = Duration.m1804divUwyO8pc(duration, 2);
        if (!((1 | (Duration.m1847toLongimpl(jM1804divUwyO8pc, getUnit()) - 1)) == Long.MAX_VALUE)) {
            long j3 = this.reading;
            try {
                m1937plusAssignLRDsOJo(jM1804divUwyO8pc);
                m1937plusAssignLRDsOJo(Duration.m1836minusLRDsOJo(duration, jM1804divUwyO8pc));
                return;
            } catch (IllegalStateException e) {
                this.reading = j3;
                throw e;
            }
        }
        m1936overflowLRDsOJo(duration);
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1936overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m1850toStringimpl(duration)) + FilenameUtils.EXTENSION_SEPARATOR);
    }
}
