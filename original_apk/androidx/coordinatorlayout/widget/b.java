package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: CoordinatorLayout */
class b implements Parcelable.ClassLoaderCreator<CoordinatorLayout.SavedState> {
    b() {
    }

    public CoordinatorLayout.SavedState[] newArray(int i) {
        return new CoordinatorLayout.SavedState[i];
    }

    public CoordinatorLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout.SavedState(parcel, classLoader);
    }

    public CoordinatorLayout.SavedState createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.SavedState(parcel, (ClassLoader) null);
    }
}
