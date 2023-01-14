package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class c implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 == 2) {
                i2 = a.v(parcel, a2);
            } else if (a3 != 3) {
                a.z(parcel, a2);
            } else {
                bundle = a.f(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new GoogleSignInOptionsExtensionParcelable(i, i2, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptionsExtensionParcelable[i];
    }
}
