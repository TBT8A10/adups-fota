package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class c implements Parcelable.Creator<WebImage> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        int i = 0;
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            int a3 = a.a(a2);
            if (a3 == 1) {
                i = a.v(parcel, a2);
            } else if (a3 == 2) {
                uri = (Uri) a.a(parcel, a2, Uri.CREATOR);
            } else if (a3 == 3) {
                i2 = a.v(parcel, a2);
            } else if (a3 != 4) {
                a.z(parcel, a2);
            } else {
                i3 = a.v(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new WebImage(i, uri, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WebImage[i];
    }
}
