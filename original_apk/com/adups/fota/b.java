package com.adups.fota;

import android.content.Context;
import com.adups.fota.h.c;
import com.adups.fota.utils.t;

/* compiled from: GoogleOtaClient */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1538a;

    b(GoogleOtaClient googleOtaClient) {
        this.f1538a = googleOtaClient;
    }

    public void run() {
        c a2 = c.a();
        GoogleOtaClient googleOtaClient = this.f1538a;
        a2.b(googleOtaClient, t.d((Context) googleOtaClient));
    }
}
