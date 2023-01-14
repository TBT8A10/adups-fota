package com.google.android.gms.common.internal;

import android.os.Parcelable;

public final class x implements Parcelable.Creator<AuthAccountRequest> {
    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.a.b(r11)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r4 = 0
        L_0x000c:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x0049
            int r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r11)
            int r2 = com.google.android.gms.common.internal.safeparcel.a.a((int) r1)
            switch(r2) {
                case 1: goto L_0x0044;
                case 2: goto L_0x003f;
                case 3: goto L_0x0035;
                case 4: goto L_0x0030;
                case 5: goto L_0x002b;
                case 6: goto L_0x0021;
                default: goto L_0x001d;
            }
        L_0x001d:
            com.google.android.gms.common.internal.safeparcel.a.z(r11, r1)
            goto L_0x000c
        L_0x0021:
            android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.a.a((android.os.Parcel) r11, (int) r1, r2)
            r9 = r1
            android.accounts.Account r9 = (android.accounts.Account) r9
            goto L_0x000c
        L_0x002b:
            java.lang.Integer r8 = com.google.android.gms.common.internal.safeparcel.a.w(r11, r1)
            goto L_0x000c
        L_0x0030:
            java.lang.Integer r7 = com.google.android.gms.common.internal.safeparcel.a.w(r11, r1)
            goto L_0x000c
        L_0x0035:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r2 = com.google.android.gms.common.api.Scope.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.a.b(r11, r1, r2)
            r6 = r1
            com.google.android.gms.common.api.Scope[] r6 = (com.google.android.gms.common.api.Scope[]) r6
            goto L_0x000c
        L_0x003f:
            android.os.IBinder r5 = com.google.android.gms.common.internal.safeparcel.a.u(r11, r1)
            goto L_0x000c
        L_0x0044:
            int r4 = com.google.android.gms.common.internal.safeparcel.a.v(r11, r1)
            goto L_0x000c
        L_0x0049:
            com.google.android.gms.common.internal.safeparcel.a.q(r11, r0)
            com.google.android.gms.common.internal.AuthAccountRequest r11 = new com.google.android.gms.common.internal.AuthAccountRequest
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.x.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
