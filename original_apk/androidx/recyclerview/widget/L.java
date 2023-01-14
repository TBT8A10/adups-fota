package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: StaggeredGridLayoutManager */
class L implements Parcelable.Creator<StaggeredGridLayoutManager.SavedState> {
    L() {
    }

    public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.SavedState(parcel);
    }

    public StaggeredGridLayoutManager.SavedState[] newArray(int i) {
        return new StaggeredGridLayoutManager.SavedState[i];
    }
}
