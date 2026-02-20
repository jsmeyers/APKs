package com.bottlepay.flutter_libphonenumber;

import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: compiled from: FlutterLibphonenumberPlugin.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00072\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010\u001c\u001a\u00020\u001aH\u0016J\u001c\u0010\u001d\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010 2\u0006\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\r2\u0006\u0010#\u001a\u00020$H\u0002J#\u0010%\u001a\u00020\u0007\"\u0004\b\u0000\u0010&2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u0002H&H\u0002¢\u0006\u0002\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bottlepay/flutter_libphonenumber/FlutterLibphonenumberPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "format", "", NotificationCompat.CATEGORY_CALL, "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "formatInternational", "", "kotlin.jvm.PlatformType", "phoneNumber", "Lcom/google/i18n/phonenumbers/Phonenumber$PhoneNumber;", "formatNational", "getAllSupportedRegions", "maskNumber", "phoneCode", "numberTypeToString", "type", "Lcom/google/i18n/phonenumbers/PhoneNumberUtil$PhoneNumberType;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "parse", "parseStringAndRegion", "Ljava/util/HashMap;", "string", "region", "util", "Lcom/google/i18n/phonenumbers/PhoneNumberUtil;", "sendDartResult", "T", "resultName", "resultData", "(Ljava/lang/String;Ljava/lang/Object;)V", "Companion", "flutter_libphonenumber_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FlutterLibphonenumberPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MethodChannel channel;

    /* JADX INFO: compiled from: FlutterLibphonenumberPlugin.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PhoneNumberUtil.PhoneNumberType.values().length];
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.FIXED_LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.MOBILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.TOLL_FREE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.PREMIUM_RATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PhoneNumberUtil.PhoneNumberType.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final void registerWith(PluginRegistry.Registrar registrar) {
        INSTANCE.registerWith(registrar);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.bottlepay/flutter_libphonenumber_android");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* JADX INFO: compiled from: FlutterLibphonenumberPlugin.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bottlepay/flutter_libphonenumber/FlutterLibphonenumberPlugin$Companion;", "", "()V", "registerWith", "", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "flutter_libphonenumber_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void registerWith(PluginRegistry.Registrar registrar) {
            Intrinsics.checkNotNullParameter(registrar, "registrar");
            new MethodChannel(registrar.messenger(), "flutter_libphonenumber").setMethodCallHandler(new FlutterLibphonenumberPlugin());
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = call.method;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1268779017) {
                if (iHashCode != 106437299) {
                    if (iHashCode == 938692135 && str.equals("get_all_supported_regions")) {
                        getAllSupportedRegions(result);
                        return;
                    }
                } else if (str.equals("parse")) {
                    parse(call, result);
                    return;
                }
            } else if (str.equals("format")) {
                format(call, result);
                return;
            }
        }
        result.notImplemented();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler(null);
    }

    private final <T> void sendDartResult(String resultName, T resultData) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.invokeMethod(resultName, MapsKt.mapOf(new Pair("result", resultData)));
    }

    private final void parse(MethodCall call, MethodChannel.Result result) {
        String str = (String) call.argument("region");
        String str2 = (String) call.argument(AuthorizationRequest.Scope.PHONE);
        if (str2 != null) {
            if (!(str2.length() == 0)) {
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                Intrinsics.checkNotNull(phoneNumberUtil);
                HashMap<String, String> stringAndRegion = parseStringAndRegion(str2, str, phoneNumberUtil);
                if (stringAndRegion != null) {
                    result.success(stringAndRegion);
                    return;
                }
                result.error("InvalidNumber", "Number " + str2 + " is invalid", null);
                return;
            }
        }
        result.error("InvalidParameters", "Invalid 'phone' parameter.", null);
    }

    private final void getAllSupportedRegions(final MethodChannel.Result result) {
        new Thread(new Runnable() { // from class: com.bottlepay.flutter_libphonenumber.FlutterLibphonenumberPlugin$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FlutterLibphonenumberPlugin.getAllSupportedRegions$lambda$1(this.f$0, result);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAllSupportedRegions$lambda$1(FlutterLibphonenumberPlugin this$0, final MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : PhoneNumberUtil.getInstance().getSupportedRegions()) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            String strValueOf = String.valueOf(PhoneNumberUtil.getInstance().getCountryCodeForRegion(str));
            linkedHashMap2.put("phoneCode", strValueOf);
            Phonenumber.PhoneNumber exampleNumberForType = PhoneNumberUtil.getInstance().getExampleNumberForType(str, PhoneNumberUtil.PhoneNumberType.MOBILE);
            if (exampleNumberForType == null) {
                exampleNumberForType = new Phonenumber.PhoneNumber();
            }
            Phonenumber.PhoneNumber exampleNumberForType2 = PhoneNumberUtil.getInstance().getExampleNumberForType(str, PhoneNumberUtil.PhoneNumberType.FIXED_LINE);
            if (exampleNumberForType2 == null) {
                exampleNumberForType2 = new Phonenumber.PhoneNumber();
            }
            linkedHashMap2.put("exampleNumberMobileNational", this$0.formatNational(exampleNumberForType).toString());
            linkedHashMap2.put("exampleNumberFixedLineNational", this$0.formatNational(exampleNumberForType2).toString());
            linkedHashMap2.put("phoneMaskMobileNational", this$0.maskNumber(this$0.formatNational(exampleNumberForType).toString(), strValueOf));
            linkedHashMap2.put("phoneMaskFixedLineNational", this$0.maskNumber(this$0.formatNational(exampleNumberForType2).toString(), strValueOf));
            linkedHashMap2.put("exampleNumberMobileInternational", this$0.formatInternational(exampleNumberForType).toString());
            linkedHashMap2.put("exampleNumberFixedLineInternational", this$0.formatInternational(exampleNumberForType2).toString());
            linkedHashMap2.put("phoneMaskMobileInternational", this$0.maskNumber(this$0.formatInternational(exampleNumberForType).toString(), strValueOf));
            linkedHashMap2.put("phoneMaskFixedLineInternational", this$0.maskNumber(this$0.formatInternational(exampleNumberForType2).toString(), strValueOf));
            String displayCountry = new Locale("", str).getDisplayCountry();
            Intrinsics.checkNotNullExpressionValue(displayCountry, "getDisplayCountry(...)");
            linkedHashMap2.put("countryName", displayCountry);
            Intrinsics.checkNotNull(str);
            linkedHashMap.put(str, linkedHashMap2);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bottlepay.flutter_libphonenumber.FlutterLibphonenumberPlugin$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FlutterLibphonenumberPlugin.getAllSupportedRegions$lambda$1$lambda$0(result, linkedHashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAllSupportedRegions$lambda$1$lambda$0(MethodChannel.Result result, Map regionsMap) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(regionsMap, "$regionsMap");
        result.success(regionsMap);
    }

    private final String maskNumber(String phoneNumber, String phoneCode) {
        return new Regex("[\\d]").replace(phoneNumber, "0");
    }

    private final String formatNational(Phonenumber.PhoneNumber phoneNumber) {
        return PhoneNumberUtil.getInstance().format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
    }

    private final String formatInternational(Phonenumber.PhoneNumber phoneNumber) {
        return PhoneNumberUtil.getInstance().format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
    }

    private final HashMap<String, String> parseStringAndRegion(String string, String region, PhoneNumberUtil util) {
        try {
            Phonenumber.PhoneNumber phoneNumber = util.parse(string, region);
            return !util.isValidNumber(phoneNumber) ? null : new AnonymousClass1(util, phoneNumber, this);
        } catch (NumberParseException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bottlepay.flutter_libphonenumber.FlutterLibphonenumberPlugin$parseStringAndRegion$1, reason: invalid class name */
    /* JADX INFO: compiled from: FlutterLibphonenumberPlugin.kt */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bottlepay/flutter_libphonenumber/FlutterLibphonenumberPlugin$parseStringAndRegion$1", "Ljava/util/HashMap;", "", "flutter_libphonenumber_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 extends HashMap<String, String> implements j$.util.Map {
        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map
        public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
            return compute(obj, BiFunction.VivifiedWrapper.convert(biFunction));
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // java.util.HashMap, java.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
            return computeIfAbsent(obj, Function.VivifiedWrapper.convert(function));
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
            return computeIfPresent(obj, BiFunction.VivifiedWrapper.convert(biFunction));
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        @Override // java.util.HashMap, java.util.Map
        public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
            forEach(BiConsumer.VivifiedWrapper.convert(biConsumer));
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
            return merge(obj, obj2, BiFunction.VivifiedWrapper.convert(biFunction));
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
        public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return Map.CC.$default$putIfAbsent(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
        public /* synthetic */ Object replace(Object obj, Object obj2) {
            return Map.CC.$default$replace(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
        public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
            return Map.CC.$default$replace(this, obj, obj2, obj3);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map
        public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
            replaceAll(BiFunction.VivifiedWrapper.convert(biFunction));
        }

        AnonymousClass1(PhoneNumberUtil phoneNumberUtil, Phonenumber.PhoneNumber phoneNumber, FlutterLibphonenumberPlugin flutterLibphonenumberPlugin) {
            PhoneNumberUtil.PhoneNumberType numberType = phoneNumberUtil.getNumberType(phoneNumber);
            Intrinsics.checkNotNull(numberType);
            put("type", flutterLibphonenumberPlugin.numberTypeToString(numberType));
            put("e164", phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164));
            put("international", phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL));
            put("national", phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
            put("country_code", String.valueOf(phoneNumber.getCountryCode()));
            put("region_code", phoneNumberUtil.getRegionCodeForNumber(phoneNumber));
            put("national_number", String.valueOf(phoneNumber.getNationalNumber()));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof String) {
                return containsValue((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(String str) {
            return super.containsValue((Object) str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
            return getEntries();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ String get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ String get(String str) {
            return (String) super.get((Object) str);
        }

        public /* bridge */ Set<Map.Entry<String, String>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map, j$.util.concurrent.ConcurrentMap
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj == null ? true : obj instanceof String) ? obj2 : getOrDefault((String) obj, (String) obj2);
        }

        public final /* bridge */ String getOrDefault(Object obj, String str) {
            return !(obj == null ? true : obj instanceof String) ? str : getOrDefault((String) obj, str);
        }

        public /* bridge */ String getOrDefault(String str, String str2) {
            return (String) Map.CC.$default$getOrDefault(this, str, str2);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<String> getValues() {
            return super.values();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ String remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ String remove(String str) {
            return (String) super.remove((Object) str);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map, java.util.concurrent.ConcurrentMap
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (!(obj == null ? true : obj instanceof String)) {
                return false;
            }
            if (obj2 != null ? obj2 instanceof String : true) {
                return remove((String) obj, (String) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, String str2) {
            return Map.CC.$default$remove(this, str, str2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<String> values() {
            return getValues();
        }
    }

    private final void format(MethodCall call, MethodChannel.Result result) {
        String str = (String) call.argument("region");
        String str2 = (String) call.argument(AuthorizationRequest.Scope.PHONE);
        if (str2 == null) {
            result.error("InvalidParameters", "Invalid 'string' parameter.", null);
            return;
        }
        try {
            AsYouTypeFormatter asYouTypeFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(str);
            String strInputDigit = "";
            asYouTypeFormatter.clear();
            char[] charArray = str2.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            for (char c : charArray) {
                strInputDigit = asYouTypeFormatter.inputDigit(c);
                Intrinsics.checkNotNullExpressionValue(strInputDigit, "inputDigit(...)");
            }
            HashMap map = new HashMap();
            map.put("formatted", strInputDigit);
            result.success(map);
        } catch (Exception unused) {
            result.error("InvalidNumber", "Number " + str2 + " is invalid", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String numberTypeToString(PhoneNumberUtil.PhoneNumberType type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return "fixedLine";
            case 2:
                return "mobile";
            case 3:
                return "fixedOrMobile";
            case 4:
                return "tollFree";
            case 5:
                return "premiumRate";
            case 6:
                return "sharedCost";
            case 7:
                return "voip";
            case 8:
                return "personalNumber";
            case 9:
                return "pager";
            case 10:
                return "uan";
            case 11:
                return "voicemail";
            case 12:
                return EnvironmentCompat.MEDIA_UNKNOWN;
            default:
                return "notParsed";
        }
    }
}
