package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;

/* compiled from: LinearLayoutManager */
class s implements Parcelable.Creator<LinearLayoutManager.SavedState> {
    s() {
    }

    public LinearLayoutManager.SavedState createFromParcel(Parcel parcel) {
        return new LinearLayoutManager.SavedState(parcel);
    }

    public LinearLayoutManager.SavedState[] newArray(int i) {
        return new LinearLayoutManager.SavedState[i];
    }
}
