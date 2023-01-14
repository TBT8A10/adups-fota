package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class e implements Parcelable.Creator<WakeLockEvent> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = a.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            switch (a.a(a2)) {
                case 1:
                    i = a.v(parcel2, a2);
                    break;
                case 2:
                    j = a.x(parcel2, a2);
                    break;
                case 4:
                    str = a.n(parcel2, a2);
                    break;
                case 5:
                    i3 = a.v(parcel2, a2);
                    break;
                case 6:
                    arrayList = a.p(parcel2, a2);
                    break;
                case 8:
                    j2 = a.x(parcel2, a2);
                    break;
                case 10:
                    str3 = a.n(parcel2, a2);
                    break;
                case 11:
                    i2 = a.v(parcel2, a2);
                    break;
                case 12:
                    str2 = a.n(parcel2, a2);
                    break;
                case 13:
                    str4 = a.n(parcel2, a2);
                    break;
                case 14:
                    i4 = a.v(parcel2, a2);
                    break;
                case 15:
                    f = a.t(parcel2, a2);
                    break;
                case 16:
                    j3 = a.x(parcel2, a2);
                    break;
                case 17:
                    str5 = a.n(parcel2, a2);
                    break;
                case 18:
                    z = a.r(parcel2, a2);
                    break;
                default:
                    a.z(parcel2, a2);
                    break;
            }
        }
        a.q(parcel2, b2);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
