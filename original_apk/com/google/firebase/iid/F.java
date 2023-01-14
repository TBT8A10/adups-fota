package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class F implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final G f2361a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f2362b;

    F(G g, Intent intent) {
        this.f2361a = g;
        this.f2362b = intent;
    }

    public final void run() {
        G g = this.f2361a;
        String action = this.f2362b.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        g.a();
    }
}
