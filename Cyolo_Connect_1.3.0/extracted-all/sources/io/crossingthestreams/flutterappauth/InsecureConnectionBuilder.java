package io.crossingthestreams.flutterappauth;

import android.net.Uri;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import net.openid.appauth.connectivity.ConnectionBuilder;

/* JADX INFO: loaded from: classes3.dex */
public class InsecureConnectionBuilder implements ConnectionBuilder {
    public static final InsecureConnectionBuilder INSTANCE = new InsecureConnectionBuilder();

    private InsecureConnectionBuilder() {
    }

    @Override // net.openid.appauth.connectivity.ConnectionBuilder
    public HttpURLConnection openConnection(Uri uri) throws IOException {
        return (HttpURLConnection) new URL(uri.toString()).openConnection();
    }
}
