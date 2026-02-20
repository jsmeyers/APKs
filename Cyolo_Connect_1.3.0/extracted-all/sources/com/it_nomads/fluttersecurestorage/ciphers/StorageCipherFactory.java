package com.it_nomads.fluttersecurestorage.ciphers;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class StorageCipherFactory {
    private static final KeyCipherAlgorithm DEFAULT_KEY_ALGORITHM = KeyCipherAlgorithm.RSA_ECB_PKCS1Padding;
    private static final StorageCipherAlgorithm DEFAULT_STORAGE_ALGORITHM = StorageCipherAlgorithm.AES_CBC_PKCS7Padding;
    private static final String ELEMENT_PREFERENCES_ALGORITHM_KEY = "FlutterSecureSAlgorithmKey";
    private static final String ELEMENT_PREFERENCES_ALGORITHM_PREFIX = "FlutterSecureSAlgorithm";
    private static final String ELEMENT_PREFERENCES_ALGORITHM_STORAGE = "FlutterSecureSAlgorithmStorage";
    private final KeyCipherAlgorithm currentKeyAlgorithm;
    private final StorageCipherAlgorithm currentStorageAlgorithm;
    private final KeyCipherAlgorithm savedKeyAlgorithm;
    private final StorageCipherAlgorithm savedStorageAlgorithm;

    public StorageCipherFactory(SharedPreferences sharedPreferences, Map<String, Object> map) {
        KeyCipherAlgorithm keyCipherAlgorithm = DEFAULT_KEY_ALGORITHM;
        this.savedKeyAlgorithm = KeyCipherAlgorithm.valueOf(sharedPreferences.getString(ELEMENT_PREFERENCES_ALGORITHM_KEY, keyCipherAlgorithm.name()));
        StorageCipherAlgorithm storageCipherAlgorithm = DEFAULT_STORAGE_ALGORITHM;
        this.savedStorageAlgorithm = StorageCipherAlgorithm.valueOf(sharedPreferences.getString(ELEMENT_PREFERENCES_ALGORITHM_STORAGE, storageCipherAlgorithm.name()));
        KeyCipherAlgorithm keyCipherAlgorithmValueOf = KeyCipherAlgorithm.valueOf(getFromOptionsWithDefault(map, "keyCipherAlgorithm", keyCipherAlgorithm.name()));
        this.currentKeyAlgorithm = keyCipherAlgorithmValueOf.minVersionCode <= Build.VERSION.SDK_INT ? keyCipherAlgorithmValueOf : keyCipherAlgorithm;
        StorageCipherAlgorithm storageCipherAlgorithmValueOf = StorageCipherAlgorithm.valueOf(getFromOptionsWithDefault(map, "storageCipherAlgorithm", storageCipherAlgorithm.name()));
        this.currentStorageAlgorithm = storageCipherAlgorithmValueOf.minVersionCode <= Build.VERSION.SDK_INT ? storageCipherAlgorithmValueOf : storageCipherAlgorithm;
    }

    private String getFromOptionsWithDefault(Map<String, Object> map, String str, String str2) {
        Object obj = map.get(str);
        return obj != null ? obj.toString() : str2;
    }

    public boolean requiresReEncryption() {
        return (this.savedKeyAlgorithm == this.currentKeyAlgorithm && this.savedStorageAlgorithm == this.currentStorageAlgorithm) ? false : true;
    }

    public StorageCipher getSavedStorageCipher(Context context) throws Exception {
        return this.savedStorageAlgorithm.storageCipher.apply(context, this.savedKeyAlgorithm.keyCipher.apply(context));
    }

    public StorageCipher getCurrentStorageCipher(Context context) throws Exception {
        return this.currentStorageAlgorithm.storageCipher.apply(context, this.currentKeyAlgorithm.keyCipher.apply(context));
    }

    public void storeCurrentAlgorithms(SharedPreferences.Editor editor) {
        editor.putString(ELEMENT_PREFERENCES_ALGORITHM_KEY, this.currentKeyAlgorithm.name());
        editor.putString(ELEMENT_PREFERENCES_ALGORITHM_STORAGE, this.currentStorageAlgorithm.name());
    }

    public void removeCurrentAlgorithms(SharedPreferences.Editor editor) {
        editor.remove(ELEMENT_PREFERENCES_ALGORITHM_KEY);
        editor.remove(ELEMENT_PREFERENCES_ALGORITHM_STORAGE);
    }
}
