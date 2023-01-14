package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;

/* compiled from: Toolbar */
class ma implements Parcelable.ClassLoaderCreator<Toolbar.SavedState> {
    ma() {
    }

    public Toolbar.SavedState[] newArray(int i) {
        return new Toolbar.SavedState[i];
    }

    public Toolbar.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar.SavedState(parcel, classLoader);
    }

    public Toolbar.SavedState createFromParcel(Parcel parcel) {
        return new Toolbar.SavedState(parcel, (ClassLoader) null);
    }
}
