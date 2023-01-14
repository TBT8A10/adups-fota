package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new G();

    /* renamed from: a  reason: collision with root package name */
    private IBinder f1832a;

    public BinderWrapper() {
        this.f1832a = null;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f1832a);
    }

    private BinderWrapper(Parcel parcel) {
        this.f1832a = null;
        this.f1832a = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, G g) {
        this(parcel);
    }
}
