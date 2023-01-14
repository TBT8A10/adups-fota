package com.adups.fota.activity;

import android.content.Context;
import com.adups.fota.b.a;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.t;

/* compiled from: SdcardUpdateActivity */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1533a;

    n(p pVar) {
        this.f1533a = pVar;
    }

    public void run() {
        String str = t.b((Context) this.f1533a.f1535a, true) + a.f;
        LogUtil.a("LocalSdUpdate : path = " + str);
        SdcardUpdateActivity sdcardUpdateActivity = this.f1533a.f1535a;
        if (sdcardUpdateActivity.a(sdcardUpdateActivity.e, str, false)) {
            String unused = this.f1533a.f1535a.e = str;
            this.f1533a.f1535a.f.sendMessage(this.f1533a.f1535a.f.obtainMessage(15));
            return;
        }
        this.f1533a.f1535a.f.sendMessage(this.f1533a.f1535a.f.obtainMessage(-2));
    }
}
