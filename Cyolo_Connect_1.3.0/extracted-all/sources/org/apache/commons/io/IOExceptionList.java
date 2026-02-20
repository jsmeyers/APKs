package org.apache.commons.io;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class IOExceptionList extends IOException {
    private static final long serialVersionUID = 1;
    private final List<? extends Throwable> causeList;

    /* JADX WARN: Illegal instructions before constructor call */
    public IOExceptionList(List<? extends Throwable> list) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        objArr[1] = list;
        super(String.format("%,d exceptions: %s", objArr), list == null ? null : list.get(0));
        this.causeList = list == null ? Collections.emptyList() : list;
    }

    public <T extends Throwable> List<T> getCauseList() {
        return (List<T>) this.causeList;
    }

    public <T extends Throwable> T getCause(int i) {
        return (T) this.causeList.get(i);
    }

    public <T extends Throwable> T getCause(int i, Class<T> cls) {
        return (T) this.causeList.get(i);
    }

    public <T extends Throwable> List<T> getCauseList(Class<T> cls) {
        return (List<T>) this.causeList;
    }
}
