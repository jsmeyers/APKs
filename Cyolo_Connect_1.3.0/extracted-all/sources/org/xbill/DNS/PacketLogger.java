package org.xbill.DNS;

import java.net.SocketAddress;

/* JADX INFO: loaded from: classes2.dex */
public interface PacketLogger {
    void log(String str, SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr);
}
