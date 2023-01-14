package com.google.android.gms.common.internal;

import android.os.Parcelable;

public final class E implements Parcelable.Creator<ResolveAccountResponse> {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.a.b(r10)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r4 = 0
            r7 = 0
            r8 = 0
        L_0x000b:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x004a
            int r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r10)
            int r2 = com.google.android.gms.common.internal.safeparcel.a.a((int) r1)
            r3 = 1
            if (r2 == r3) goto L_0x0045
            r3 = 2
            if (r2 == r3) goto L_0x0040
            r3 = 3
            if (r2 == r3) goto L_0x0036
            r3 = 4
            if (r2 == r3) goto L_0x0031
            r3 = 5
            if (r2 == r3) goto L_0x002c
            com.google.android.gms.common.internal.safeparcel.a.z(r10, r1)
            goto L_0x000b
        L_0x002c:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.a.r(r10, r1)
            goto L_0x000b
        L_0x0031:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.a.r(r10, r1)
            goto L_0x000b
        L_0x0036:
            android.os.Parcelable$Creator<com.google.android.gms.common.ConnectionResult> r2 = com.google.android.gms.common.ConnectionResult.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r10, (int) r1, r2)
            r6 = r1
            com.google.android.gms.common.ConnectionResult r6 = (com.google.android.gms.common.ConnectionResult) r6
            goto L_0x000b
        L_0x0040:
            android.os.IBinder r5 = com.google.android.gms.common.internal.safeparcel.a.u(r10, r1)
            goto L_0x000b
        L_0x0045:
            int r4 = com.google.android.gms.common.internal.safeparcel.a.v(r10, r1)
            goto L_0x000b
        L_0x004a:
            com.google.android.gms.common.internal.safeparcel.a.q(r10, r0)
            com.google.android.gms.common.internal.ResolveAccountResponse r10 = new com.google.android.gms.common.internal.ResolveAccountResponse
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.E.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
