package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomappbar.BottomAppBar;

/* compiled from: BottomAppBar */
class h implements Parcelable.ClassLoaderCreator<BottomAppBar.SavedState> {
    h() {
    }

    public BottomAppBar.SavedState[] newArray(int i) {
        return new BottomAppBar.SavedState[i];
    }

    public BottomAppBar.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomAppBar.SavedState(parcel, classLoader);
    }

    public BottomAppBar.SavedState createFromParcel(Parcel parcel) {
        return new BottomAppBar.SavedState(parcel, (ClassLoader) null);
    }
}
