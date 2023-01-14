package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;

public final class F implements Parcelable.Creator<SignInButtonConfig> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 == 2) {
                i2 = a.v(parcel, a2);
            } else if (a3 == 3) {
                i3 = a.v(parcel, a2);
            } else if (a3 != 4) {
                a.z(parcel, a2);
            } else {
                scopeArr = (Scope[]) a.b(parcel, a2, Scope.CREATOR);
            }
        }
        a.q(parcel, b2);
        return new SignInButtonConfig(i, i2, i3, scopeArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
