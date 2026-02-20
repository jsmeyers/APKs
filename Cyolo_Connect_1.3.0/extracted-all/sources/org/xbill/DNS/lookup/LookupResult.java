package org.xbill.DNS.lookup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;

/* JADX INFO: loaded from: classes2.dex */
public final class LookupResult {
    private final List<Name> aliases;
    private final List<Record> records;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LookupResult)) {
            return false;
        }
        LookupResult lookupResult = (LookupResult) obj;
        List<Record> records = getRecords();
        List<Record> records2 = lookupResult.getRecords();
        if (records != null ? !records.equals(records2) : records2 != null) {
            return false;
        }
        List<Name> aliases = getAliases();
        List<Name> aliases2 = lookupResult.getAliases();
        return aliases != null ? aliases.equals(aliases2) : aliases2 == null;
    }

    public int hashCode() {
        List<Record> records = getRecords();
        int iHashCode = records == null ? 43 : records.hashCode();
        List<Name> aliases = getAliases();
        return ((iHashCode + 59) * 59) + (aliases != null ? aliases.hashCode() : 43);
    }

    public String toString() {
        return "LookupResult(records=" + getRecords() + ", aliases=" + getAliases() + ")";
    }

    public List<Record> getRecords() {
        return this.records;
    }

    public List<Name> getAliases() {
        return this.aliases;
    }

    public LookupResult(List<Record> list, List<Name> list2) {
        List<Name> listUnmodifiableList;
        this.records = Collections.unmodifiableList(new ArrayList(list));
        if (list2 == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list2));
        }
        this.aliases = listUnmodifiableList;
    }
}
