package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class G implements Parcelable.Creator<BinderWrapper> {
    G() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (G) null);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
