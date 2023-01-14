package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ParcelableSparseArray */
class m implements Parcelable.ClassLoaderCreator<ParcelableSparseArray> {
    m() {
    }

    public ParcelableSparseArray[] newArray(int i) {
        return new ParcelableSparseArray[i];
    }

    public ParcelableSparseArray createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ParcelableSparseArray(parcel, classLoader);
    }

    public ParcelableSparseArray createFromParcel(Parcel parcel) {
        return new ParcelableSparseArray(parcel, (ClassLoader) null);
    }
}
