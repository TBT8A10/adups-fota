package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    private final int f1833a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1834b;

    public ClientIdentity(int i, String str) {
        this.f1833a = i;
        this.f1834b = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            return clientIdentity.f1833a == this.f1833a && C0177s.a(clientIdentity.f1834b, this.f1834b);
        }
    }

    public int hashCode() {
        return this.f1833a;
    }

    public String toString() {
        int i = this.f1833a;
        String str = this.f1834b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1833a);
        b.a(parcel, 2, this.f1834b, false);
        b.a_shaKey_method2(parcel, a2);
    }
}
