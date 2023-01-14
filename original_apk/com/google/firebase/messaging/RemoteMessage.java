package com.google.firebase.messaging;

import a.b.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    Bundle f2453a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f2454b;

    public RemoteMessage(Bundle bundle) {
        this.f2453a = bundle;
    }

    public final Map<String, String> m() {
        if (this.f2454b == null) {
            Bundle bundle = this.f2453a;
            b bVar = new b();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        bVar.put(str, str2);
                    }
                }
            }
            this.f2454b = bVar;
        }
        return this.f2454b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f2453a, false);
        com.google.android.gms.common.internal.safeparcel.b.a_shaKey_method2(parcel, a2);
    }
}
