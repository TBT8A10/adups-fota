package com.adups.fota;

import com.adups.fota.a.a;
import com.adups.fota.utils.LogUtil;

/* compiled from: GoogleOtaClient */
class d implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleOtaClient f1553a;

    d(GoogleOtaClient googleOtaClient) {
        this.f1553a = googleOtaClient;
    }

    public void a() {
        LogUtil.a("no download reason : user cancel");
        com.adups.fota.f.a.a(this.f1553a, "cancel", 0);
    }
}
