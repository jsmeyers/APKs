package dev.fluttercommunity.plus.network_info;

import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: NetworkInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ldev/fluttercommunity/plus/network_info/NetworkInfo;", "", "wifiManager", "Landroid/net/wifi/WifiManager;", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Landroid/net/wifi/WifiManager;Landroid/net/ConnectivityManager;)V", "wifiInfo", "Landroid/net/wifi/WifiInfo;", "getWifiInfo$annotations", "()V", "getWifiInfo", "()Landroid/net/wifi/WifiInfo;", "formatIPAddress", "", "intIP", "", "getBroadcastIP", "getGatewayIPAddress", "getIPv4Subnet", "inetAddress", "Ljava/net/InetAddress;", "getIPv4SubnetFromNetPrefixLength", "netPrefixLength", "getIpV6", "getWifiBSSID", "getWifiIPAddress", "getWifiName", "getWifiSubnetMask", "network_info_plus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetworkInfo {
    private final ConnectivityManager connectivityManager;
    private final WifiManager wifiManager;

    private static /* synthetic */ void getWifiInfo$annotations() {
    }

    public NetworkInfo(WifiManager wifiManager, ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter(wifiManager, "wifiManager");
        this.wifiManager = wifiManager;
        this.connectivityManager = connectivityManager;
    }

    public /* synthetic */ NetworkInfo(WifiManager wifiManager, ConnectivityManager connectivityManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(wifiManager, (i & 2) != 0 ? null : connectivityManager);
    }

    private final WifiInfo getWifiInfo() {
        WifiInfo connectionInfo = this.wifiManager.getConnectionInfo();
        Intrinsics.checkNotNullExpressionValue(connectionInfo, "getConnectionInfo(...)");
        return connectionInfo;
    }

    public final String getWifiName() {
        return getWifiInfo().getSSID();
    }

    public final String getWifiBSSID() {
        return getWifiInfo().getBSSID();
    }

    public final String getWifiIPAddress() {
        Object next;
        InetAddress address;
        boolean zContains$default;
        LinkProperties linkProperties;
        if (Build.VERSION.SDK_INT >= 31) {
            ConnectivityManager connectivityManager = this.connectivityManager;
            List<LinkAddress> linkAddresses = (connectivityManager == null || (linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork())) == null) ? null : linkProperties.getLinkAddresses();
            if (linkAddresses == null) {
                return null;
            }
            Iterator<T> it = linkAddresses.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                String hostAddress = ((LinkAddress) next).getAddress().getHostAddress();
                zContains$default = false;
                if (hostAddress != null) {
                    Intrinsics.checkNotNull(hostAddress);
                    zContains$default = StringsKt.contains$default((CharSequence) hostAddress, FilenameUtils.EXTENSION_SEPARATOR, false, 2, (Object) null);
                }
            } while (!zContains$default);
            LinkAddress linkAddress = (LinkAddress) next;
            if (linkAddress == null || (address = linkAddress.getAddress()) == null) {
                return null;
            }
            return address.getHostAddress();
        }
        WifiInfo wifiInfo = getWifiInfo();
        Intrinsics.checkNotNull(wifiInfo);
        int ipAddress = wifiInfo.getIpAddress();
        if (ipAddress != 0) {
            return formatIPAddress(ipAddress);
        }
        return null;
    }

    public final String getWifiSubnetMask() {
        try {
            InetAddress byName = InetAddress.getByName(getWifiIPAddress());
            Intrinsics.checkNotNull(byName);
            return getIPv4Subnet(byName);
        } catch (Exception unused) {
            return "";
        }
    }

    public final String getBroadcastIP() {
        String hostAddress = null;
        try {
            List<InterfaceAddress> interfaceAddresses = NetworkInterface.getByInetAddress(InetAddress.getByName(getWifiIPAddress())).getInterfaceAddresses();
            Intrinsics.checkNotNullExpressionValue(interfaceAddresses, "getInterfaceAddresses(...)");
            for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                if (!interfaceAddress.getAddress().isLoopbackAddress() && interfaceAddress.getBroadcast() != null) {
                    hostAddress = interfaceAddress.getBroadcast().getHostAddress();
                }
            }
        } catch (Exception unused) {
        }
        return hostAddress;
    }

    public final String getIpV6() {
        String hostAddress;
        try {
            Iterator<InterfaceAddress> it = NetworkInterface.getByInetAddress(InetAddress.getByName(getWifiIPAddress())).getInterfaceAddresses().iterator();
            while (it.hasNext()) {
                InetAddress address = it.next().getAddress();
                if (!address.isLoopbackAddress() && (address instanceof Inet6Address) && (hostAddress = address.getHostAddress()) != null) {
                    return ((String[]) StringsKt.split$default((CharSequence) hostAddress, new String[]{"%"}, false, 0, 6, (Object) null).toArray(new String[0]))[0];
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    public final String getGatewayIPAddress() {
        Inet4Address dhcpServerAddress;
        if (Build.VERSION.SDK_INT >= 31) {
            ConnectivityManager connectivityManager = this.connectivityManager;
            LinkProperties linkProperties = connectivityManager != null ? connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork()) : null;
            if (linkProperties == null || (dhcpServerAddress = linkProperties.getDhcpServerAddress()) == null) {
                return null;
            }
            return dhcpServerAddress.getHostAddress();
        }
        DhcpInfo dhcpInfo = this.wifiManager.getDhcpInfo();
        Integer numValueOf = dhcpInfo != null ? Integer.valueOf(dhcpInfo.gateway) : null;
        if (numValueOf != null) {
            return formatIPAddress(numValueOf.intValue());
        }
        return null;
    }

    private final String formatIPAddress(int intIP) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%d.%d.%d.%d", Arrays.copyOf(new Object[]{Integer.valueOf(intIP & 255), Integer.valueOf((intIP >> 8) & 255), Integer.valueOf((intIP >> 16) & 255), Integer.valueOf((intIP >> 24) & 255)}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    private final String getIPv4Subnet(InetAddress inetAddress) {
        InetAddress iPv4SubnetFromNetPrefixLength;
        try {
            for (InterfaceAddress interfaceAddress : NetworkInterface.getByInetAddress(inetAddress).getInterfaceAddresses()) {
                if (!interfaceAddress.getAddress().isLoopbackAddress() && (interfaceAddress.getAddress() instanceof Inet4Address) && (iPv4SubnetFromNetPrefixLength = getIPv4SubnetFromNetPrefixLength(interfaceAddress.getNetworkPrefixLength())) != null) {
                    String hostAddress = iPv4SubnetFromNetPrefixLength.getHostAddress();
                    Intrinsics.checkNotNull(hostAddress);
                    return hostAddress;
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private final InetAddress getIPv4SubnetFromNetPrefixLength(int netPrefixLength) {
        int i = Integer.MIN_VALUE;
        for (int i2 = netPrefixLength - 1; i2 > 0; i2--) {
            i >>= 1;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append((i >> 24) & 255);
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            sb.append((i >> 16) & 255);
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            sb.append((i >> 8) & 255);
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            sb.append(i & 255);
            return InetAddress.getByName(sb.toString());
        } catch (Exception unused) {
            return null;
        }
    }
}
