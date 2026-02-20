package com.bugsnag.android;

import android.util.JsonReader;
import com.bugsnag.android.JsonStream;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: User.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B+\b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bugsnag/android/User;", "Lcom/bugsnag/android/JsonStream$Streamable;", User.KEY_ID, "", "email", User.KEY_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getId", "getName", "equals", "", "other", "", "hashCode", "", "toStream", "", "writer", "Lcom/bugsnag/android/JsonStream;", "Companion", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class User implements JsonStream.Streamable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private final String email;
    private final String id;
    private final String name;

    public User() {
        this(null, null, null, 7, null);
    }

    public User(String str) {
        this(str, null, null, 6, null);
    }

    public User(String str, String str2) {
        this(str, str2, null, 4, null);
    }

    public User(String str, String str2, String str3) {
        this.id = str;
        this.email = str2;
        this.name = str3;
    }

    public /* synthetic */ User(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getId() {
        return this.id;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream writer) throws IOException {
        writer.beginObject();
        writer.name(KEY_ID).value(this.id);
        writer.name("email").value(this.email);
        writer.name(KEY_NAME).value(this.name);
        writer.endObject();
    }

    /* JADX INFO: compiled from: User.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bugsnag/android/User$Companion;", "Lcom/bugsnag/android/JsonReadable;", "Lcom/bugsnag/android/User;", "()V", "KEY_EMAIL", "", "KEY_ID", "KEY_NAME", "fromReader", "reader", "Landroid/util/JsonReader;", "bugsnag-android-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion implements JsonReadable<User> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.bugsnag.android.JsonReadable
        public User fromReader(JsonReader reader) throws IOException {
            reader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            while (reader.hasNext()) {
                String strNextName = reader.nextName();
                String strNextString = reader.nextString();
                if (strNextName != null) {
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3355) {
                        if (iHashCode != 3373707) {
                            if (iHashCode == 96619420 && strNextName.equals("email")) {
                                str2 = strNextString;
                            }
                        } else if (strNextName.equals(User.KEY_NAME)) {
                            str3 = strNextString;
                        }
                    } else if (strNextName.equals(User.KEY_ID)) {
                        str = strNextString;
                    }
                }
            }
            User user = new User(str, str2, str3);
            reader.endObject();
            return user;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other == null ? null : other.getClass())) {
            return false;
        }
        if (other != null) {
            User user = (User) other;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.id, user.id) && kotlin.jvm.internal.Intrinsics.areEqual(this.email, user.email) && kotlin.jvm.internal.Intrinsics.areEqual(this.name, user.name);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.bugsnag.android.User");
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.email;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
