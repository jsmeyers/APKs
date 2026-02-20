package j$.time;

/* JADX INFO: loaded from: classes4.dex */
public class TimeConversions {
    public static Instant convert(java.time.Instant instant) {
        if (instant == null) {
            return null;
        }
        return Instant.ofEpochSecond(instant.getEpochSecond(), instant.getNano());
    }
}
