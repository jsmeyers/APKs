package io.cyolo.android;

import android.content.Intent;
import android.net.IpPrefix;
import android.net.ProxyInfo;
import android.net.RouteInfo;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
import com.bugsnag.android.Bugsnag;
import io.cyolo.android.CyoloBridge;
import io.cyolo.android.model.Network;
import io.cyolo.android.model.ProxyPolicy;
import io.cyolo.android.model.ServiceStatus;
import io.cyolo.android.model.Status;
import io.flutter.plugin.common.MethodChannel;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import net.openid.appauth.AuthorizationRequest;
import org.apache.commons.io.IOUtils;
import org.xbill.DNS.ARecord;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.SimpleResolver;
import timber.log.Timber;

/* JADX INFO: compiled from: CyoloVpnService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u000545678B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0003J(\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\"\u0010\u001a\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0003J\"\u0010\u001c\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0010H\u0002J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\b\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\"\u0010)\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0016J \u0010.\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010/\u001a\u000200H\u0002J\u0014\u00101\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\u0001H\u0002J\b\u00102\u001a\u00020\tH\u0002J\b\u00103\u001a\u00020\tH\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lio/cyolo/android/CyoloVpnService;", "Landroid/net/VpnService;", "()V", "fd", "", "Ljava/lang/Integer;", "parcelFd", "Landroid/os/ParcelFileDescriptor;", "addRouteInfoWorkaround", "", "builder", "Landroid/net/VpnService$Builder;", "routeInfo", "Landroid/net/RouteInfo;", "build", AuthorizationRequest.Scope.ADDRESS, "", "dnsAddress", "routes", "", "Lio/cyolo/android/CyoloVpnService$Route;", "createRouteInfoWorkaround", "addr", "Ljava/net/InetAddress;", "prefixLength", "type", "excludeRoutesTiramisu", "routesToExclude", "excludeRoutesWorkaround", "getDNSResolversRoutes", "getDNSSearchDomainsFromMainThread", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDnsAddress", "getRoutes", "getRoutesToExclude", "getTunnelAddress", "notifyAboutServiceUpdate", NotificationCompat.CATEGORY_STATUS, "Lio/cyolo/android/model/ServiceStatus;", "onCreate", "onDestroy", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "rebuild", "throwOnFail", "", "setupProxy", "showNotification", "startVpn", "Companion", "CyoloNotLoggedInException", "CyoloVpnBuildException", "CyoloVpnServiceException", "Route", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CyoloVpnService extends VpnService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ServiceStatus status = ServiceStatus.DISCONNECTED;
    private Integer fd;
    private ParcelFileDescriptor parcelFd;

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTunnelAddress() {
        return (String) StringsKt.split$default((CharSequence) CyoloBridge.INSTANCE.GetTunnelAddress(), new String[]{"/"}, false, 0, 6, (Object) null).get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDnsAddress() {
        return (String) StringsKt.split$default((CharSequence) CyoloBridge.INSTANCE.GetDNSAddress(), new String[]{":"}, false, 0, 6, (Object) null).get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAboutServiceUpdate(ServiceStatus status2) {
        status = status2;
        Intent intent = new Intent(MainActivityKt.INTENT_SERVICE_STATUS);
        intent.putExtra(MainActivityKt.INTENT_SERVICE_STATUS_EXTRA_VALUE, status2.name());
        sendBroadcast(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timber.INSTANCE.d("onStartCommand: CyoloVpnService " + (intent != null ? intent.getAction() : null), new Object[0]);
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, CyoloTunnelService.ACTION_STOP)) {
            Integer num = this.fd;
            if (num != null) {
                num.intValue();
                this.fd = null;
                CyoloBridge.INSTANCE.Close();
                CyoloBridge.INSTANCE.Disconnect();
                stopSelf();
            }
        } else {
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, CyoloTunnelService.ACTION_START)) {
                try {
                    startVpn();
                } catch (CyoloVpnServiceException e) {
                    Timber.INSTANCE.e("Cannot build VPN, cyolo-go is not logged in", new Object[0]);
                    Bugsnag.notify(e);
                    notifyAboutServiceUpdate(ServiceStatus.DISCONNECTED);
                }
            } else {
                if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, CyoloTunnelService.ACTION_POLICY_CHANGE)) {
                    try {
                        rebuild(getRoutes(), false);
                    } catch (CyoloVpnServiceException e2) {
                        Timber.INSTANCE.e("Cannot rebuild VPN", new Object[0]);
                        Bugsnag.notify(e2);
                    }
                } else {
                    Timber.INSTANCE.e("Received unknown action " + (intent != null ? intent.getAction() : null), new Object[0]);
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public void onCreate() {
        Timber.INSTANCE.d("CyoloVpnService VpnService onCreate", new Object[0]);
        super.onCreate();
        showNotification();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Timber.INSTANCE.d("CyoloVpnService onDestroy", new Object[0]);
        notifyAboutServiceUpdate(ServiceStatus.DISCONNECTED);
        super.onDestroy();
    }

    private final List<Route> getRoutes() {
        String strGetRoutes = CyoloBridge.INSTANCE.GetRoutes();
        if (strGetRoutes.length() == 0) {
            return CollectionsKt.emptyList();
        }
        List listSplit$default = StringsKt.split$default((CharSequence) strGetRoutes, new String[]{IOUtils.LINE_SEPARATOR_UNIX}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(Route.INSTANCE.parseFromIp((String) it.next()));
        }
        return arrayList;
    }

    private final List<Route> getDNSResolversRoutes() {
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: compiled from: CyoloVpnService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/cyolo/android/CyoloVpnService$Route;", "", "addr", "Ljava/net/InetAddress;", "prefixLength", "", "(Ljava/net/InetAddress;I)V", "getAddr", "()Ljava/net/InetAddress;", "setAddr", "(Ljava/net/InetAddress;)V", "getPrefixLength", "()I", "setPrefixLength", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Route {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private InetAddress addr;
        private int prefixLength;

        public static /* synthetic */ Route copy$default(Route route, InetAddress inetAddress, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                inetAddress = route.addr;
            }
            if ((i2 & 2) != 0) {
                i = route.prefixLength;
            }
            return route.copy(inetAddress, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InetAddress getAddr() {
            return this.addr;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPrefixLength() {
            return this.prefixLength;
        }

        public final Route copy(InetAddress addr, int prefixLength) {
            Intrinsics.checkNotNullParameter(addr, "addr");
            return new Route(addr, prefixLength);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Route)) {
                return false;
            }
            Route route = (Route) other;
            return Intrinsics.areEqual(this.addr, route.addr) && this.prefixLength == route.prefixLength;
        }

        public int hashCode() {
            return (this.addr.hashCode() * 31) + this.prefixLength;
        }

        public String toString() {
            return "Route(addr=" + this.addr + ", prefixLength=" + this.prefixLength + ")";
        }

        /* JADX INFO: compiled from: CyoloVpnService.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lio/cyolo/android/CyoloVpnService$Route$Companion;", "", "()V", "parseFromIp", "Lio/cyolo/android/CyoloVpnService$Route;", "str", "", "parseFromString", "resolve", "dnsHostname", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Route resolve(String str, String dnsHostname) {
                Intrinsics.checkNotNullParameter(str, "str");
                Intrinsics.checkNotNullParameter(dnsHostname, "dnsHostname");
                try {
                    try {
                        return parseFromIp(str);
                    } catch (UnknownHostException unused) {
                        List<Record> section = new SimpleResolver(dnsHostname).send(Message.newQuery(Record.newRecord(Name.fromString(str + "."), 1, 1))).getSection(1);
                        Timber.INSTANCE.d("Resolved " + str + " to " + section, new Object[0]);
                        Intrinsics.checkNotNull(section);
                        if ((!section.isEmpty()) && (section.get(0) instanceof ARecord)) {
                            Record record = section.get(0);
                            Intrinsics.checkNotNull(record, "null cannot be cast to non-null type org.xbill.DNS.ARecord");
                            InetAddress byName = InetAddress.getByName(((ARecord) record).getAddress().getHostAddress());
                            Intrinsics.checkNotNullExpressionValue(byName, "getByName(...)");
                            return new Route(byName, 32);
                        }
                        return null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            public final Route parseFromString(String str) {
                int i;
                Intrinsics.checkNotNullParameter(str, "str");
                try {
                    List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
                    InetAddress byName = InetAddress.getByName((String) listSplit$default.get(0));
                    if (listSplit$default.size() > 1) {
                        i = Integer.parseInt((String) listSplit$default.get(1));
                    } else {
                        i = byName instanceof Inet4Address ? 32 : 128;
                    }
                    Intrinsics.checkNotNull(byName);
                    return new Route(byName, i);
                } catch (UnknownHostException unused) {
                    return null;
                }
            }

            public final Route parseFromIp(String str) throws UnknownHostException {
                int i;
                Intrinsics.checkNotNullParameter(str, "str");
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null);
                InetAddress byName = InetAddress.getByName((String) listSplit$default.get(0));
                if (listSplit$default.size() > 1) {
                    i = Integer.parseInt((String) listSplit$default.get(1));
                } else {
                    i = byName instanceof Inet4Address ? 32 : 128;
                }
                Intrinsics.checkNotNull(byName);
                return new Route(byName, i);
            }
        }

        public Route(InetAddress addr, int i) {
            Intrinsics.checkNotNullParameter(addr, "addr");
            this.addr = addr;
            this.prefixLength = i;
        }

        public final InetAddress getAddr() {
            return this.addr;
        }

        public final int getPrefixLength() {
            return this.prefixLength;
        }

        public final void setAddr(InetAddress inetAddress) {
            Intrinsics.checkNotNullParameter(inetAddress, "<set-?>");
            this.addr = inetAddress;
        }

        public final void setPrefixLength(int i) {
            this.prefixLength = i;
        }
    }

    /* JADX INFO: renamed from: io.cyolo.android.CyoloVpnService$startVpn$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CyoloVpnService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "io.cyolo.android.CyoloVpnService$startVpn$1", f = "CyoloVpnService.kt", i = {0, 0}, l = {213}, m = "invokeSuspend", n = {"routes", "unresolvedNetworks"}, s = {"L$0", "L$1"})
    static final class C00721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C00721(Continuation<? super C00721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CyoloVpnService.this.new C00721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            List arrayList;
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (CyoloBridge.INSTANCE.IsLoggedIn()) {
                    CyoloVpnService.this.notifyAboutServiceUpdate(ServiceStatus.CONNECTING);
                    List<Network> networks = CyoloPreferences.INSTANCE.getNetworks(CyoloVpnService.this);
                    arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it = networks.iterator();
                    while (it.hasNext()) {
                        for (String str : StringsKt.split$default((CharSequence) ((Network) it.next()).getNetworks(), new String[]{","}, false, 0, 6, (Object) null)) {
                            Route fromString = Route.INSTANCE.parseFromString(StringsKt.trim((CharSequence) str).toString());
                            if (fromString != null) {
                                arrayList.add(fromString);
                            } else {
                                arrayList2.add(str);
                            }
                        }
                    }
                    Timber.INSTANCE.d("Rebuilding with resolved routes " + arrayList, new Object[0]);
                    CyoloVpnService.rebuild$default(CyoloVpnService.this, arrayList, false, 2, null);
                    if (arrayList2.isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = arrayList;
                    this.L$1 = arrayList2;
                    this.label = 1;
                    if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list = arrayList2;
                } else {
                    throw new CyoloNotLoggedInException("CyoloBridge.IsLoggedIn() failed");
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$1;
                arrayList = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            CyoloVpnService cyoloVpnService = CyoloVpnService.this;
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Route routeResolve = Route.INSTANCE.resolve((String) it2.next(), cyoloVpnService.getDnsAddress());
                if (routeResolve != null) {
                    arrayList3.add(routeResolve);
                }
            }
            ArrayList arrayList4 = arrayList3;
            Timber.INSTANCE.d("Rebuilding with " + arrayList + " and unresolved (resolved) routes " + arrayList4, new Object[0]);
            CyoloVpnService.rebuild$default(CyoloVpnService.this, CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList4), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    private final void startVpn() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C00721(null), 2, null);
    }

    /* JADX INFO: renamed from: io.cyolo.android.CyoloVpnService$rebuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: CyoloVpnService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "io.cyolo.android.CyoloVpnService$rebuild$1", f = "CyoloVpnService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Route> $routes;
        final /* synthetic */ boolean $throwOnFail;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<Route> list, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$routes = list;
            this.$throwOnFail = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CyoloVpnService.this.new AnonymousClass1(this.$routes, this.$throwOnFail, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CyoloVpnService cyoloVpnService = CyoloVpnService.this;
            cyoloVpnService.parcelFd = cyoloVpnService.build(cyoloVpnService.getTunnelAddress(), CyoloVpnService.this.getDnsAddress(), this.$routes);
            if (!this.$throwOnFail || CyoloVpnService.this.parcelFd != null) {
                CyoloVpnService.this.notifyAboutServiceUpdate(ServiceStatus.CONNECTED);
                return Unit.INSTANCE;
            }
            throw new CyoloVpnBuildException("rebuild: parcelFd null");
        }
    }

    static /* synthetic */ void rebuild$default(CyoloVpnService cyoloVpnService, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        cyoloVpnService.rebuild(list, z);
    }

    private final void rebuild(List<Route> routes, boolean throwOnFail) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(routes, throwOnFail, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParcelFileDescriptor build(String address, String dnsAddress, List<Route> routes) throws UnknownHostException, CyoloVpnBuildException {
        VpnService.Builder builderAddAddress = new VpnService.Builder(this).addAddress(address, 24);
        Intrinsics.checkNotNullExpressionValue(builderAddAddress, "addAddress(...)");
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                List<String> list = (List) BuildersKt.runBlocking(Dispatchers.getMain(), new CyoloVpnService$build$searchDomains$1(this, null));
                if (!list.isEmpty()) {
                    for (String str : list) {
                        if (StringsKt.trim((CharSequence) str).toString().length() > 0) {
                            builderAddAddress.addSearchDomain(StringsKt.trim((CharSequence) str).toString());
                            Timber.INSTANCE.d("Added DNS search domain via API: '" + StringsKt.trim((CharSequence) str).toString() + "'", new Object[0]);
                        }
                    }
                }
            } catch (Exception e) {
                Timber.INSTANCE.e("Failed to get DNS search domains from API: " + e.getMessage(), e);
            }
        } else {
            Timber.INSTANCE.i("DNS search domains not supported on Android < 10", new Object[0]);
        }
        builderAddAddress.addDnsServer(dnsAddress);
        for (Route route : routes) {
            try {
                builderAddAddress.addRoute(route.getAddr(), route.getPrefixLength());
            } catch (Exception unused) {
                Timber.INSTANCE.e("Failed to add route " + route.getAddr() + "/" + route.getPrefixLength(), new Object[0]);
            }
        }
        List<Route> routesToExclude = getRoutesToExclude();
        if (Build.VERSION.SDK_INT >= 33) {
            excludeRoutesTiramisu(builderAddAddress, routesToExclude);
        } else {
            try {
                excludeRoutesWorkaround(builderAddAddress, routesToExclude);
            } catch (Exception e2) {
                Bugsnag.notify(e2);
                throw new CyoloVpnBuildException("Exclude routes workaround failed: " + e2.getMessage());
            }
        }
        setupProxy(builderAddAddress);
        ParcelFileDescriptor parcelFileDescriptorEstablish = builderAddAddress.establish();
        Integer numValueOf = parcelFileDescriptorEstablish != null ? Integer.valueOf(parcelFileDescriptorEstablish.detachFd()) : null;
        Timber.INSTANCE.d("parcelFD " + parcelFileDescriptorEstablish, new Object[0]);
        if (numValueOf == null) {
            Timber.INSTANCE.e("Failed to get tunnel FD", new Object[0]);
            return null;
        }
        this.fd = numValueOf;
        Timber.INSTANCE.d("build: detached FD: " + numValueOf, new Object[0]);
        try {
            CyoloBridge.INSTANCE.TunnelOpen(numValueOf.intValue());
            CyoloBridge.INSTANCE.Configure();
            return parcelFileDescriptorEstablish;
        } catch (CyoloBridge.CyoloBridgeException e3) {
            throw new CyoloVpnBuildException(e3.getMessage());
        }
    }

    private final void setupProxy(VpnService.Builder builder) {
        ProxyPolicy proxyPolicy;
        if (Build.VERSION.SDK_INT >= 29 && (proxyPolicy = CyoloPreferences.INSTANCE.getProxyPolicy(this)) != null && (!StringsKt.isBlank(proxyPolicy.getSettings().getHttpProxy()))) {
            List listSplit$default = StringsKt.split$default((CharSequence) proxyPolicy.getSettings().getHttpProxy(), new String[]{":"}, false, 0, 6, (Object) null);
            String str = (String) CollectionsKt.first(listSplit$default);
            int i = Integer.parseInt((String) CollectionsKt.last(listSplit$default));
            List<String> noProxy = proxyPolicy.getSettings().getNoProxy();
            if (noProxy == null) {
                noProxy = CollectionsKt.emptyList();
            }
            builder.setHttpProxy(ProxyInfo.buildDirectProxy(str, i, noProxy));
        }
    }

    private final void excludeRoutesTiramisu(VpnService.Builder builder, List<Route> routesToExclude) {
        for (Route route : routesToExclude) {
            InetAddress addr = route.getAddr();
            if (addr != null) {
                MainActivity$$ExternalSyntheticApiModelOutline0.m$3();
                builder.excludeRoute(MainActivity$$ExternalSyntheticApiModelOutline0.m(addr, route.getPrefixLength()));
            }
        }
    }

    private final RouteInfo createRouteInfoWorkaround(InetAddress addr, int prefixLength, int type) throws Exception {
        try {
            Object objNewInstance = Class.forName("android.net.RouteInfo").getConstructor(IpPrefix.class, InetAddress.class, String.class, Integer.TYPE).newInstance(Class.forName("android.net.IpPrefix").getConstructor(InetAddress.class, Integer.TYPE).newInstance(addr, Integer.valueOf(prefixLength)), null, null, Integer.valueOf(type));
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type android.net.RouteInfo");
            return (RouteInfo) objNewInstance;
        } catch (Exception e) {
            e.printStackTrace();
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    Class<?> cls = Class.forName("android.net.LinkAddress");
                    Object objNewInstance2 = Class.forName("android.net.RouteInfo").getConstructor(cls).newInstance(cls.getConstructor(InetAddress.class, Integer.TYPE).newInstance(addr, Integer.valueOf(prefixLength)));
                    Timber.INSTANCE.d("created route info as for 29+ " + objNewInstance2, new Object[0]);
                    Intrinsics.checkNotNull(objNewInstance2, "null cannot be cast to non-null type android.net.RouteInfo");
                    return (RouteInfo) objNewInstance2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Object objNewInstance3 = Class.forName("android.net.RouteInfo").getConstructor(InetAddress.class).newInstance(addr);
                    Timber.INSTANCE.d("created route info with no prefix length " + objNewInstance3, new Object[0]);
                    Intrinsics.checkNotNull(objNewInstance3, "null cannot be cast to non-null type android.net.RouteInfo");
                    return (RouteInfo) objNewInstance3;
                }
            }
            try {
                Object objNewInstance32 = Class.forName("android.net.RouteInfo").getConstructor(InetAddress.class).newInstance(addr);
                Timber.INSTANCE.d("created route info with no prefix length " + objNewInstance32, new Object[0]);
                Intrinsics.checkNotNull(objNewInstance32, "null cannot be cast to non-null type android.net.RouteInfo");
                return (RouteInfo) objNewInstance32;
            } catch (Exception e3) {
                e3.printStackTrace();
                throw e3;
            }
        }
    }

    private final void addRouteInfoWorkaround(VpnService.Builder builder, RouteInfo routeInfo) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = VpnService.Builder.class.getDeclaredField("mRoutes");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(builder);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<android.net.RouteInfo>{ kotlin.collections.TypeAliasesKt.ArrayList<android.net.RouteInfo> }");
        ArrayList arrayList = (ArrayList) obj;
        Iterator it = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((RouteInfo) it.next()).getDestination(), routeInfo.getDestination())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            arrayList.add(routeInfo);
        } else {
            arrayList.set(i, routeInfo);
        }
    }

    private final void excludeRoutesWorkaround(VpnService.Builder builder, List<Route> routesToExclude) throws IllegalAccessException, NoSuchFieldException {
        for (Route route : routesToExclude) {
            InetAddress addr = route.getAddr();
            if (addr != null) {
                addRouteInfoWorkaround(builder, createRouteInfoWorkaround(addr, route.getPrefixLength(), 9));
            }
        }
    }

    private final List<Route> getRoutesToExclude() throws UnknownHostException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getDNSResolversRoutes());
        String baseUrl = CyoloPreferences.INSTANCE.getBaseUrl(this);
        if (baseUrl != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("agents.%s", Arrays.copyOf(new Object[]{baseUrl}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            InetAddress byName = InetAddress.getByName((String) StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null).get(0));
            Intrinsics.checkNotNullExpressionValue(byName, "getByName(...)");
            arrayList.add(new Route(byName, 32));
        }
        return arrayList;
    }

    private final void showNotification() {
        CyoloVpnService cyoloVpnService = this;
        NotificationsHelper.INSTANCE.registerStatusChannel(cyoloVpnService, null);
        startForeground(NotificationsHelper.NOTIFICATION_ID, NotificationsHelper.INSTANCE.createStatusNotification(cyoloVpnService, Status.LOGGED_IN));
    }

    /* JADX INFO: compiled from: CyoloVpnService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/cyolo/android/CyoloVpnService$CyoloVpnServiceException;", "Ljava/lang/Exception;", "message", "", "(Ljava/lang/String;)V", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class CyoloVpnServiceException extends Exception {
        public CyoloVpnServiceException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: CyoloVpnService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/cyolo/android/CyoloVpnService$CyoloNotLoggedInException;", "Lio/cyolo/android/CyoloVpnService$CyoloVpnServiceException;", "message", "", "(Ljava/lang/String;)V", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CyoloNotLoggedInException extends CyoloVpnServiceException {
        public CyoloNotLoggedInException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: CyoloVpnService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/cyolo/android/CyoloVpnService$CyoloVpnBuildException;", "Lio/cyolo/android/CyoloVpnService$CyoloVpnServiceException;", "message", "", "(Ljava/lang/String;)V", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CyoloVpnBuildException extends CyoloVpnServiceException {
        public CyoloVpnBuildException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: CyoloVpnService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/cyolo/android/CyoloVpnService$Companion;", "", "()V", "<set-?>", "Lio/cyolo/android/model/ServiceStatus;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lio/cyolo/android/model/ServiceStatus;", "setStatus$app_cyoloRelease", "(Lio/cyolo/android/model/ServiceStatus;)V", "app_cyoloRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ServiceStatus getStatus() {
            return CyoloVpnService.status;
        }

        public final void setStatus$app_cyoloRelease(ServiceStatus serviceStatus) {
            Intrinsics.checkNotNullParameter(serviceStatus, "<set-?>");
            CyoloVpnService.status = serviceStatus;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getDNSSearchDomainsFromMainThread(Continuation<? super List<String>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        try {
            Timber.INSTANCE.d("Checking method channel availability...", new Object[0]);
            MethodChannel vpnMethodChannel = MainActivity.INSTANCE.getVpnMethodChannel();
            if (vpnMethodChannel == null) {
                Timber.INSTANCE.e("MainActivity.vpnMethodChannel is NULL - method channel not set up properly", new Object[0]);
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m442constructorimpl(CollectionsKt.emptyList()));
            } else {
                Timber.INSTANCE.d("Method channel found, making call to getDNSSearchDomains...", new Object[0]);
                vpnMethodChannel.invokeMethod("getDNSSearchDomains", null, new MethodChannel.Result() { // from class: io.cyolo.android.CyoloVpnService$getDNSSearchDomainsFromMainThread$2$1
                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void success(Object result) {
                        try {
                            List listEmptyList = result instanceof List ? (List) result : null;
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            Timber.INSTANCE.d("Method channel SUCCESS: Received " + listEmptyList.size() + " DNS search domains: " + listEmptyList, new Object[0]);
                            CancellableContinuation<List<String>> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m442constructorimpl(listEmptyList));
                        } catch (Exception e) {
                            Timber.INSTANCE.e("Error processing DNS search domains result: " + e.getMessage(), e);
                            CancellableContinuation<List<String>> cancellableContinuation2 = cancellableContinuationImpl2;
                            Result.Companion companion3 = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m442constructorimpl(CollectionsKt.emptyList()));
                        }
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void error(String errorCode, String errorMessage, Object errorDetails) {
                        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                        Timber.INSTANCE.e("Method channel ERROR: " + errorCode + " - " + errorMessage, new Object[0]);
                        CancellableContinuation<List<String>> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m442constructorimpl(CollectionsKt.emptyList()));
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void notImplemented() {
                        Timber.INSTANCE.w("getDNSSearchDomains method not implemented in Flutter", new Object[0]);
                        CancellableContinuation<List<String>> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m442constructorimpl(CollectionsKt.emptyList()));
                    }
                });
            }
        } catch (Exception e) {
            Timber.INSTANCE.e("Exception calling getDNSSearchDomains: " + e.getMessage(), e);
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m442constructorimpl(CollectionsKt.emptyList()));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
