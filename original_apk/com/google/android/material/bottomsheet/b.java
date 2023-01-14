package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* compiled from: BottomSheetBehavior */
class b implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.SavedState> {
    b() {
    }

    public BottomSheetBehavior.SavedState[] newArray(int i) {
        return new BottomSheetBehavior.SavedState[i];
    }

    public BottomSheetBehavior.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior.SavedState(parcel, classLoader);
    }

    public BottomSheetBehavior.SavedState createFromParcel(Parcel parcel) {
        return new BottomSheetBehavior.SavedState(parcel, (ClassLoader) null);
    }
}
