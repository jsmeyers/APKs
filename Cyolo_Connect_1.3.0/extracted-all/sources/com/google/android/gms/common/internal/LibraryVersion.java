package com.google.android.gms.common.internal;

import com.google.android.gms.common.util.IOUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzb = new LibraryVersion();
    private ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    @Deprecated
    public String getVersion(String str) throws Throwable {
        String str2;
        InputStream resourceAsStream;
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.zzc.containsKey(str)) {
            return (String) this.zzc.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        property = null;
        String property = null;
        inputStream = null;
        try {
            try {
                resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", str));
            } catch (IOException e) {
                e = e;
                str2 = null;
            }
            if (property == null) {
                zza.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
                property = "UNKNOWN";
            }
            this.zzc.put(str, property);
            return property;
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                property = properties.getProperty("version", null);
                zza.v("LibraryVersion", str + " version is " + property);
            } else {
                zza.w("LibraryVersion", "Failed to get app version for libraryName: " + str);
            }
            if (resourceAsStream != null) {
                IOUtils.closeQuietly(resourceAsStream);
            }
        } catch (IOException e2) {
            e = e2;
            String str3 = property;
            inputStream = resourceAsStream;
            str2 = str3;
            zza.e("LibraryVersion", "Failed to get app version for libraryName: " + str, e);
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
            property = str2;
        } catch (Throwable th2) {
            th = th2;
            inputStream = resourceAsStream;
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
            throw th;
        }
    }
}
