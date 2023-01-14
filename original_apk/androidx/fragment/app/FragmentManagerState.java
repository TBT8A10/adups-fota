package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentManager */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new u();

    /* renamed from: a  reason: collision with root package name */
    FragmentState[] f810a;

    /* renamed from: b  reason: collision with root package name */
    int[] f811b;

    /* renamed from: c  reason: collision with root package name */
    BackStackState[] f812c;
    int d = -1;
    int e;

    public FragmentManagerState() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f810a, i);
        parcel.writeIntArray(this.f811b);
        parcel.writeTypedArray(this.f812c, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f810a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f811b = parcel.createIntArray();
        this.f812c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }
}
