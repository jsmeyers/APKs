package org.xbill.DNS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes2.dex */
public class Compression {
    private static final int MAX_POINTER = 16383;
    private static final int TABLE_SIZE = 17;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) Compression.class);
    private Entry[] table = new Entry[17];

    private static class Entry {
        Name name;
        Entry next;
        int pos;

        private Entry() {
        }
    }

    public void add(int i, Name name) {
        if (i > MAX_POINTER) {
            return;
        }
        int iHashCode = (name.hashCode() & Integer.MAX_VALUE) % 17;
        Entry entry = new Entry();
        entry.name = name;
        entry.pos = i;
        entry.next = this.table[iHashCode];
        this.table[iHashCode] = entry;
        log.trace("Adding {} at {}", name, Integer.valueOf(i));
    }

    public int get(Name name) {
        int i = -1;
        for (Entry entry = this.table[(name.hashCode() & Integer.MAX_VALUE) % 17]; entry != null; entry = entry.next) {
            if (entry.name.equals(name)) {
                i = entry.pos;
            }
        }
        log.trace("Looking for {}, found {}", name, Integer.valueOf(i));
        return i;
    }
}
