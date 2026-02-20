package com.bugsnag.android;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlag implements Map.Entry<String, String> {
    private final String name;
    private final String variant;

    public FeatureFlag(String str) {
        this(str, null);
    }

    public FeatureFlag(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("FeatureFlags cannot have null name");
        }
        this.name = str;
        this.variant = str2;
    }

    public FeatureFlag(Map.Entry<String, String> entry) {
        this(entry.getKey(), entry.getValue());
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.name;
    }

    @Override // java.util.Map.Entry
    public String getValue() {
        return this.variant;
    }

    @Override // java.util.Map.Entry
    public String setValue(String str) {
        throw new UnsupportedOperationException("FeatureFlag is immutable");
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return getKey().hashCode() ^ (getValue() == null ? 0 : getValue().hashCode());
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (getKey().equals(entry.getKey())) {
            if (getValue() == null) {
                if (entry.getValue() == null) {
                    return true;
                }
            } else if (getValue().equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "FeatureFlag{name='" + this.name + "', variant='" + this.variant + "'}";
    }
}
