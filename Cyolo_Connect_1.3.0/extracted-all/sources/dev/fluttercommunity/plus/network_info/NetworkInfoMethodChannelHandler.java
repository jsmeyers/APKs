package dev.fluttercommunity.plus.network_info;

import androidx.core.app.NotificationCompat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkInfoMethodChannelHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ldev/fluttercommunity/plus/network_info/NetworkInfoMethodChannelHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "networkInfo", "Ldev/fluttercommunity/plus/network_info/NetworkInfo;", "(Ldev/fluttercommunity/plus/network_info/NetworkInfo;)V", "onMethodCall", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "network_info_plus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetworkInfoMethodChannelHandler implements MethodChannel.MethodCallHandler {
    private final NetworkInfo networkInfo;

    public NetworkInfoMethodChannelHandler(NetworkInfo networkInfo) {
        Intrinsics.checkNotNullParameter(networkInfo, "networkInfo");
        this.networkInfo = networkInfo;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (str != null) {
            switch (str.hashCode()) {
                case -1560837844:
                    if (str.equals("wifiBroadcast")) {
                        result.success(this.networkInfo.getBroadcastIP());
                        return;
                    }
                    break;
                case -1340798144:
                    if (str.equals("wifiName")) {
                        result.success(this.networkInfo.getWifiName());
                        return;
                    }
                    break;
                case -989025832:
                    if (str.equals("wifiIPv6Address")) {
                        result.success(this.networkInfo.getIpV6());
                        return;
                    }
                    break;
                case 183655511:
                    if (str.equals("wifiSubmask")) {
                        result.success(this.networkInfo.getWifiSubnetMask());
                        return;
                    }
                    break;
                case 1373405384:
                    if (str.equals("wifiBSSID")) {
                        result.success(this.networkInfo.getWifiBSSID());
                        return;
                    }
                    break;
                case 1674251141:
                    if (str.equals("wifiGatewayAddress")) {
                        result.success(this.networkInfo.getGatewayIPAddress());
                        return;
                    }
                    break;
                case 1756715352:
                    if (str.equals("wifiIPAddress")) {
                        result.success(this.networkInfo.getWifiIPAddress());
                        return;
                    }
                    break;
            }
        }
        result.notImplemented();
    }
}
