package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public static final AbsSavedState f762a = new AbsSavedState() {
    };

    /* renamed from: b  reason: collision with root package name */
    private final Parcelable f763b;

    public final Parcelable a() {
        return this.f763b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f763b, i);
    }

    private AbsSavedState() {
        this.f763b = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f763b = parcelable == f762a ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f763b = readParcelable == null ? f762a : readParcelable;
    }
}
