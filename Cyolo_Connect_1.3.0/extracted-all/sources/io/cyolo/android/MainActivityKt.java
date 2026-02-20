package io.cyolo.android;

import kotlin.Metadata;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"EVENT_CHANNEL", "", "INTENT_SERVICE_STATUS", "INTENT_SERVICE_STATUS_EXTRA_VALUE", "METHOD_CONNECT", "METHOD_DISCONNECT", "METHOD_GET_CURRENT_STATE", "METHOD_PREPARE", "METHOD_PREPARED", "METHOD_SHOW_STATUS_UPDATE", "METHOD_UPDATE_CONFIG", "PARAM_BASE_URL", "PARAM_LOGIN_URL", "PARAM_NETWORKS", "PARAM_SITES", "PARAM_STATUS", "PARAM_TOKEN", "PARAM_TOKEN_EXPIRES_IN", "PARAM_TOKEN_TYPE", "REQUEST_CODE_ASK_PASSWORD_COMPLEXITY", "", "REQUEST_DEVICE_ADMIN", "REQUEST_VPN", "VPN_CHANNEL", "app_cyoloRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MainActivityKt {
    private static final String EVENT_CHANNEL = "io.cyolo.cyolo_vpn_state";
    public static final String INTENT_SERVICE_STATUS = "io.cyolo.service_status";
    public static final String INTENT_SERVICE_STATUS_EXTRA_VALUE = "value";
    private static final String METHOD_CONNECT = "connect";
    private static final String METHOD_DISCONNECT = "disconnect";
    private static final String METHOD_GET_CURRENT_STATE = "get_current_state";
    private static final String METHOD_PREPARE = "prepare";
    private static final String METHOD_PREPARED = "prepared";
    private static final String METHOD_SHOW_STATUS_UPDATE = "show_status_update";
    private static final String METHOD_UPDATE_CONFIG = "update_config";
    private static final String PARAM_BASE_URL = "base_url";
    private static final String PARAM_LOGIN_URL = "login_url";
    private static final String PARAM_NETWORKS = "networks";
    private static final String PARAM_SITES = "sites";
    private static final String PARAM_STATUS = "status";
    private static final String PARAM_TOKEN = "token";
    private static final String PARAM_TOKEN_EXPIRES_IN = "expires_in";
    private static final String PARAM_TOKEN_TYPE = "token_type";
    private static final int REQUEST_CODE_ASK_PASSWORD_COMPLEXITY = 2;
    private static final int REQUEST_DEVICE_ADMIN = 3;
    private static final int REQUEST_VPN = 1;
    private static final String VPN_CHANNEL = "io.cyolo.cyolo_vpn";
}
