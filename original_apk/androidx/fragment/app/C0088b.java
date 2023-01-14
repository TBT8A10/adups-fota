package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: androidx.fragment.app.b  reason: case insensitive filesystem */
/* compiled from: BackStackRecord */
class C0088b implements Parcelable.Creator<BackStackState> {
    C0088b() {
    }

    public BackStackState createFromParcel(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] newArray(int i) {
        return new BackStackState[i];
    }
}
