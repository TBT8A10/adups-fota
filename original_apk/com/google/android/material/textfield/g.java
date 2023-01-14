package com.google.android.material.textfield;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: TextInputLayout */
class g implements Parcelable.ClassLoaderCreator<TextInputLayout.SavedState> {
    g() {
    }

    public TextInputLayout.SavedState[] newArray(int i) {
        return new TextInputLayout.SavedState[i];
    }

    public TextInputLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new TextInputLayout.SavedState(parcel, classLoader);
    }

    public TextInputLayout.SavedState createFromParcel(Parcel parcel) {
        return new TextInputLayout.SavedState(parcel, (ClassLoader) null);
    }
}
