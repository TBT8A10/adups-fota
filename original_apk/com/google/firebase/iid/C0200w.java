package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/* renamed from: com.google.firebase.iid.w  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0200w extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private C0201x f2441a;

    public C0200w(C0201x xVar) {
        this.f2441a = xVar;
    }

    public final void a() {
        if (FirebaseInstanceId.f()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f2441a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        C0201x xVar = this.f2441a;
        if (xVar != null && xVar.b()) {
            if (FirebaseInstanceId.f()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a((Runnable) this.f2441a, 0);
            this.f2441a.a().unregisterReceiver(this);
            this.f2441a = null;
        }
    }
}
