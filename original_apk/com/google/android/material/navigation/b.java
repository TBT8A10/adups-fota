package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.navigation.NavigationView;

/* compiled from: NavigationView */
class b implements Parcelable.ClassLoaderCreator<NavigationView.SavedState> {
    b() {
    }

    public NavigationView.SavedState[] newArray(int i) {
        return new NavigationView.SavedState[i];
    }

    public NavigationView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new NavigationView.SavedState(parcel, classLoader);
    }

    public NavigationView.SavedState createFromParcel(Parcel parcel) {
        return new NavigationView.SavedState(parcel, (ClassLoader) null);
    }
}
