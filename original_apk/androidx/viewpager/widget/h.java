package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager.widget.ViewPager;

/* compiled from: ViewPager */
class h implements Parcelable.ClassLoaderCreator<ViewPager.SavedState> {
    h() {
    }

    public ViewPager.SavedState[] newArray(int i) {
        return new ViewPager.SavedState[i];
    }

    public ViewPager.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.SavedState(parcel, classLoader);
    }

    public ViewPager.SavedState createFromParcel(Parcel parcel) {
        return new ViewPager.SavedState(parcel, (ClassLoader) null);
    }
}
