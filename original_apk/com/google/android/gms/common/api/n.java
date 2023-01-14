package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class n implements Parcelable.Creator<Status> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i2 = a.v(parcel, a2);
            } else if (a3 == 2) {
                str = a.n(parcel, a2);
            } else if (a3 == 3) {
                pendingIntent = (PendingIntent) a.a(parcel, a2, PendingIntent.CREATOR);
            } else if (a3 != 1000) {
                a.z(parcel, a2);
            } else {
                i = a.v(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new Status(i, i2, str, pendingIntent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }
}
