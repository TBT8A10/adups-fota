package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout;

/* compiled from: DrawerLayout */
class b implements Parcelable.ClassLoaderCreator<DrawerLayout.SavedState> {
    b() {
    }

    public DrawerLayout.SavedState[] newArray(int i) {
        return new DrawerLayout.SavedState[i];
    }

    public DrawerLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new DrawerLayout.SavedState(parcel, classLoader);
    }

    public DrawerLayout.SavedState createFromParcel(Parcel parcel) {
        return new DrawerLayout.SavedState(parcel, (ClassLoader) null);
    }
}
