package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import b.a.a.a.a.a;
import b.a.a.a.a.b;
import com.google.android.gms.common.internal.O;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    private final String f1969a;

    /* renamed from: b  reason: collision with root package name */
    private final j f1970b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1971c;
    private final boolean d;

    zzk(String str, IBinder iBinder, boolean z, boolean z2) {
        this.f1969a = str;
        this.f1970b = a(iBinder);
        this.f1971c = z;
        this.d = z2;
    }

    private static j a(IBinder iBinder) {
        byte[] bArr;
        if (iBinder == null) {
            return null;
        }
        try {
            a b2 = O.a(iBinder).b();
            if (b2 == null) {
                bArr = null;
            } else {
                bArr = (byte[]) b.a(b2);
            }
            if (bArr != null) {
                return new k(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f1969a, false);
        j jVar = this.f1970b;
        if (jVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            jVar = null;
        } else {
            jVar.asBinder();
        }
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, (IBinder) jVar, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f1971c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.d);
        com.google.android.gms.common.internal.safeparcel.b.a_shaKey_method2(parcel, a2);
    }
}
