package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.apache.commons.io.IOUtils;
import org.junit.runner.notification.Failure;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelableFailure implements Parcelable {
    public static final Parcelable.Creator<ParcelableFailure> CREATOR = new Parcelable.Creator<ParcelableFailure>() { // from class: androidx.test.orchestrator.junit.ParcelableFailure.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableFailure createFromParcel(Parcel in) {
            return new ParcelableFailure(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableFailure[] newArray(int size) {
            return new ParcelableFailure[size];
        }
    };
    private static final int MAX_STREAM_LENGTH = 16384;
    private static final String TAG = "ParcelableFailure";
    private final ParcelableDescription description;
    private final String trace;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableFailure(Failure failure) {
        this.description = new ParcelableDescription(failure.getDescription());
        this.trace = failure.getTrace();
    }

    private ParcelableFailure(Parcel in) {
        this.description = (ParcelableDescription) in.readParcelable(ParcelableDescription.class.getClassLoader());
        this.trace = in.readString();
    }

    public ParcelableFailure(ParcelableDescription description, Throwable t) {
        this.description = description;
        this.trace = trimToLength(t.getMessage());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(this.description, 0);
        out.writeString(this.trace);
    }

    private static String trimToLength(String trace) {
        if (trace.length() > 16384) {
            Log.i(TAG, String.format("Stack trace too long, trimmed to first %s characters.", 16384));
            return String.valueOf(trace.substring(0, 16384)).concat(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return String.valueOf(trace).concat(IOUtils.LINE_SEPARATOR_UNIX);
    }

    public String getTrace() {
        return this.trace;
    }

    public ParcelableDescription getDescription() {
        return this.description;
    }
}
