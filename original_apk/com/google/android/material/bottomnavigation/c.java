package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;

/* compiled from: BottomNavigationPresenter */
class c implements Parcelable.Creator<BottomNavigationPresenter.SavedState> {
    c() {
    }

    public BottomNavigationPresenter.SavedState createFromParcel(Parcel parcel) {
        return new BottomNavigationPresenter.SavedState(parcel);
    }

    public BottomNavigationPresenter.SavedState[] newArray(int i) {
        return new BottomNavigationPresenter.SavedState[i];
    }
}
