package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
public final class n implements Parcelable.Creator<RemoteMessage> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = a.b(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < b2) {
            int a2 = a.a(parcel);
            if (a.a(a2) != 2) {
                a.z(parcel, a2);
            } else {
                bundle = a.f(parcel, a2);
            }
        }
        a.q(parcel, b2);
        return new RemoteMessage(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new RemoteMessage[i];
    }
}
