package com.bugsnag.android.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractStartupProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0005J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016JM\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0018J9\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bugsnag/android/internal/AbstractStartupProvider;", "Landroid/content/ContentProvider;", "()V", "checkPrivilegeEscalation", "", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class AbstractStartupProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        checkPrivilegeEscalation();
        return null;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        checkPrivilegeEscalation();
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues values) {
        checkPrivilegeEscalation();
        return null;
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String selection, String[] selectionArgs) {
        checkPrivilegeEscalation();
        return 0;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        checkPrivilegeEscalation();
        return 0;
    }

    protected final void checkPrivilegeEscalation() {
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (26 <= i && i < 29) {
            z = true;
        }
        if (z) {
            String callingPackage = getCallingPackage();
            if (callingPackage != null) {
                Context context = getContext();
                if (Intrinsics.areEqual(callingPackage, context == null ? null : context.getPackageName())) {
                    return;
                }
            }
            throw new SecurityException("Provider does not allow Uri permissions to be granted");
        }
    }
}
