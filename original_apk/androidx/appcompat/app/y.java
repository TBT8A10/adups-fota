package androidx.appcompat.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* compiled from: AppCompatDelegateImpl */
class y implements Parcelable.ClassLoaderCreator<AppCompatDelegateImpl.PanelFeatureState.SavedState> {
    y() {
    }

    public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int i) {
        return new AppCompatDelegateImpl.PanelFeatureState.SavedState[i];
    }

    public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return AppCompatDelegateImpl.PanelFeatureState.SavedState.a_shaKey_method2(parcel, classLoader);
    }

    public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel parcel) {
        return AppCompatDelegateImpl.PanelFeatureState.SavedState.a_shaKey_method2(parcel, (ClassLoader) null);
    }
}
