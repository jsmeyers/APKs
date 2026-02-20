package com.bugsnag.android;

import com.bugsnag.android.internal.BugsnagMapper;
import com.bugsnag.android.internal.ImmutableConfig;
import com.bugsnag.flutter.JsonHelper;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InternalHooks {
    private final Client client;
    private final ImmutableConfig config;
    private final Logger logger;
    private final BugsnagMapper modelMapper;

    public InternalHooks(Client client) {
        this.client = client;
        Logger logger = client.getLogger();
        this.logger = logger;
        this.config = client.getConfig();
        this.modelMapper = new BugsnagMapper(logger);
    }

    public static Client getClient() {
        return Bugsnag.client;
    }

    public Notifier getNotifier() {
        return this.client.notifier;
    }

    public static Notifier getNotifier(Configuration configuration) {
        return configuration.getNotifier();
    }

    public Event createEvent(Object obj) {
        Event event = new Event(new EventInternal(null, this.config, (SeverityReason) obj, this.client.getMetadataState().getMetadata(), this.client.getFeatureFlagState().getFeatureFlags()), this.logger);
        event.setBreadcrumbs(this.client.getBreadcrumbs());
        User userImpl = this.client.getUser();
        event.setUser(userImpl.getId(), userImpl.getEmail(), userImpl.getName());
        AppDataCollector appDataCollector = this.client.getAppDataCollector();
        event.setApp(appDataCollector.generateAppWithState());
        event.addMetadata("app", appDataCollector.getAppDataMetadata());
        DeviceDataCollector deviceDataCollector = this.client.getDeviceDataCollector();
        event.setDevice(deviceDataCollector.generateDeviceWithState(System.currentTimeMillis()));
        event.addMetadata("device", deviceDataCollector.getDeviceMetadata());
        event.setContext(this.client.getContext());
        return event;
    }

    public Object createSeverityReason(String str) {
        return SeverityReason.newInstance(str);
    }

    public void deliverEvent(Event event) {
        this.client.notifyInternal(event, null);
        if (event.getImpl().getOriginalUnhandled()) {
            this.client.getEventStore().flushAsync();
        }
    }

    public boolean shouldDiscardEvent(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("exceptions");
        if (jSONArrayOptJSONArray == null) {
            return false;
        }
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            if (shouldDiscardError(jSONArrayOptJSONArray.optJSONObject(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean shouldDiscardError(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return this.config.shouldDiscardError(jSONObject.optString("errorClass"));
    }

    public Error unmapError(Map<String, Object> map) {
        return this.modelMapper.convertToError(map);
    }

    public JSONObject mapEvent(Event event) {
        return JsonHelper.wrap(this.modelMapper.convertToMap(event));
    }

    public Event unmapEvent(Map<String, Object> map) {
        String apiKey = (String) map.get(DynamicLink.Builder.KEY_API_KEY);
        if (apiKey == null) {
            apiKey = this.config.getApiKey();
        }
        return this.modelMapper.convertToEvent(map, apiKey);
    }
}
