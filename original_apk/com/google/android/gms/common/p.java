package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class p implements Parcelable.Creator<zzk> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                str = a.n(parcel, a2);
            } else if (a3 == 2) {
                iBinder = a.u(parcel, a2);
            } else if (a3 == 3) {
                z = a.r(parcel, a2);
            } else if (a3 != 4) {
                a.z(parcel, a2);
            } else {
                z2 = a.r(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new zzk(str, iBinder, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzk[i];
    }
}
