package org.xbill.DNS;

import java.util.EventListener;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface ResolverListener extends EventListener {
    void handleException(Object obj, Exception exc);

    void receiveMessage(Object obj, Message message);
}
