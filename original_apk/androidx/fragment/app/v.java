package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentState */
class v implements Parcelable.Creator<FragmentState> {
    v() {
    }

    public FragmentState createFromParcel(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] newArray(int i) {
        return new FragmentState[i];
    }
}
