package com.adups.fota;

import android.content.Context;
import com.adups.fota.a.a;
import com.adups.fota.c.d;

/* compiled from: GoogleOtaClient */
class e implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1559a;

    e(GoogleOtaClient googleOtaClient) {
        this.f1559a = googleOtaClient;
    }

    public void a() {
        d.b().a_shaKey_method2(this.f1559a, 0);
        com.adups.fota.b.d.a_shaKey_method2((Context) this.f1559a, 2);
        this.f1559a.mFooterLayout.a(2);
    }
}
