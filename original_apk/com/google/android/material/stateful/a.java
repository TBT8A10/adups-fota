package com.google.android.material.stateful;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ExtendableSavedState */
class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
    a() {
    }

    public ExtendableSavedState[] newArray(int i) {
        return new ExtendableSavedState[i];
    }

    public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ExtendableSavedState(parcel, classLoader, (a) null);
    }

    public ExtendableSavedState createFromParcel(Parcel parcel) {
        return new ExtendableSavedState(parcel, (ClassLoader) null, (a) null);
    }
}
