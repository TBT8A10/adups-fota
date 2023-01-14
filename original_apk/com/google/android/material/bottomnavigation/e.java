package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* compiled from: BottomNavigationView */
class e implements Parcelable.ClassLoaderCreator<BottomNavigationView.SavedState> {
    e() {
    }

    public BottomNavigationView.SavedState[] newArray(int i) {
        return new BottomNavigationView.SavedState[i];
    }

    public BottomNavigationView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomNavigationView.SavedState(parcel, classLoader);
    }

    public BottomNavigationView.SavedState createFromParcel(Parcel parcel) {
        return new BottomNavigationView.SavedState(parcel, (ClassLoader) null);
    }
}
