package j$.time;

import j$.time.zone.ZoneRules;
import j$.time.zone.ZoneRulesException;
import j$.time.zone.ZoneRulesProvider;
import j$.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class ZoneRegion extends ZoneId {
    private final String id;
    private final transient ZoneRules rules;

    ZoneRegion(String str, ZoneRules zoneRules) {
        this.id = str;
        this.rules = zoneRules;
    }

    private static void checkName(String str) {
        int length = str.length();
        if (length < 2) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i == 0) && ((cCharAt < '0' || cCharAt > '9' || i == 0) && ((cCharAt != '~' || i == 0) && ((cCharAt != '.' || i == 0) && ((cCharAt != '_' || i == 0) && ((cCharAt != '+' || i == 0) && (cCharAt != '-' || i == 0))))))))) {
                throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
            }
        }
    }

    static ZoneRegion ofId(String str, boolean z) {
        ZoneRules rules;
        Objects.requireNonNull(str, "zoneId");
        checkName(str);
        try {
            rules = ZoneRulesProvider.getRules(str, true);
        } catch (ZoneRulesException e) {
            if (z) {
                throw e;
            }
            rules = null;
        }
        return new ZoneRegion(str, rules);
    }

    @Override // j$.time.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // j$.time.ZoneId
    public ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.getRules(this.id, false);
    }
}
