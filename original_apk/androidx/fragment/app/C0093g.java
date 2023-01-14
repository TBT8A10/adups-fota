package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;

/* renamed from: androidx.fragment.app.g  reason: case insensitive filesystem */
/* compiled from: Fragment */
class C0093g implements Parcelable.ClassLoaderCreator<Fragment.SavedState> {
    C0093g() {
    }

    public Fragment.SavedState[] newArray(int i) {
        return new Fragment.SavedState[i];
    }

    public Fragment.SavedState createFromParcel(Parcel parcel) {
        return new Fragment.SavedState(parcel, (ClassLoader) null);
    }

    public Fragment.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Fragment.SavedState(parcel, classLoader);
    }
}
