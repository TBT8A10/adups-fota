package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.SearchView;

/* compiled from: SearchView */
class Z implements Parcelable.ClassLoaderCreator<SearchView.SavedState> {
    Z() {
    }

    public SearchView.SavedState[] newArray(int i) {
        return new SearchView.SavedState[i];
    }

    public SearchView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SearchView.SavedState(parcel, classLoader);
    }

    public SearchView.SavedState createFromParcel(Parcel parcel) {
        return new SearchView.SavedState(parcel, (ClassLoader) null);
    }
}
