package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zabq extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Context f1784a;

    /* renamed from: b  reason: collision with root package name */
    private final r f1785b;

    public final synchronized void a() {
        if (this.f1784a != null) {
            this.f1784a.unregisterReceiver(this);
        }
        this.f1784a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f1785b.a();
            a();
        }
    }
}
