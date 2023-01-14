package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AbsSavedState */
class a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
    a() {
    }

    public AbsSavedState[] newArray(int i) {
        return new AbsSavedState[i];
    }

    public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return AbsSavedState.f762a;
        }
        throw new IllegalStateException("superState must be null");
    }

    public AbsSavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
