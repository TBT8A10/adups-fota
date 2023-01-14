package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

/* compiled from: SlidingPaneLayout */
class a implements Parcelable.ClassLoaderCreator<SlidingPaneLayout.SavedState> {
    a() {
    }

    public SlidingPaneLayout.SavedState[] newArray(int i) {
        return new SlidingPaneLayout.SavedState[i];
    }

    public SlidingPaneLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SlidingPaneLayout.SavedState(parcel, (ClassLoader) null);
    }

    public SlidingPaneLayout.SavedState createFromParcel(Parcel parcel) {
        return new SlidingPaneLayout.SavedState(parcel, (ClassLoader) null);
    }
}
