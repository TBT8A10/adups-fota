package com.google.android.gms.common.api;

import a.b.b;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.D;
import com.google.android.gms.common.internal.C0178t;
import java.util.ArrayList;

public class c extends Exception {
    private final b<D<?>, ConnectionResult> zaay;

    public c(b<D<?>, ConnectionResult> bVar) {
        this.zaay = bVar;
    }

    public ConnectionResult getConnectionResult(e<? extends a.d> eVar) {
        D<? extends a.d> c2 = eVar.c();
        C0178t.a(this.zaay.get(c2) != null, (Object) "The given API was not part of the availability request.");
        return this.zaay.get(c2);
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (D next : this.zaay.keySet()) {
            ConnectionResult connectionResult = this.zaay.get(next);
            if (connectionResult.q()) {
                z = false;
            }
            String a2 = next.a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public final b<D<?>, ConnectionResult> zaj() {
        return this.zaay;
    }
}
