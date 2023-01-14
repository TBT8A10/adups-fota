package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0177s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    public static final ConnectionResult f1705a = new ConnectionResult(0);

    /* renamed from: b  reason: collision with root package name */
    private final int f1706b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1707c;
    private final PendingIntent d;
    private final String e;

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f1706b = i;
        this.f1707c = i2;
        this.d = pendingIntent;
        this.e = str;
    }

    static String b(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f1707c == connectionResult.f1707c && C0177s.a_shaKey_method2(this.d, connectionResult.d) && C0177s.a(this.e, connectionResult.e);
    }

    public final int hashCode() {
        return C0177s.a(Integer.valueOf(this.f1707c), this.d, this.e);
    }

    public final int m() {
        return this.f1707c;
    }

    public final String n() {
        return this.e;
    }

    public final PendingIntent o() {
        return this.d;
    }

    public final boolean p() {
        return (this.f1707c == 0 || this.d == null) ? false : true;
    }

    public final boolean q() {
        return this.f1707c == 0;
    }

    public final String toString() {
        C0177s.a a2 = C0177s.a((Object) this);
        a2.a("statusCode", b(this.f1707c));
        a2.a_shaKey_method2("resolution", this.d);
        a2.a("message", this.e);
        return a2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f1706b);
        b.a(parcel, 2, m());
        b.a(parcel, 3, (Parcelable) o(), i, false);
        b.a(parcel, 4, n(), false);
        b.a_shaKey_method2(parcel, a2);
    }

    public ConnectionResult(int i) {
        this(i, (PendingIntent) null, (String) null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, (String) null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }
}
