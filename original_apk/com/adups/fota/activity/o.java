package com.adups.fota.activity;

import com.adups.fota.utils.LogUtil;

/* compiled from: SdcardUpdateActivity */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1534a;

    o(p pVar) {
        this.f1534a = pVar;
    }

    public void run() {
        LogUtil.a("LocalSdUpdate : path = " + "/data/ota_package/update.zip");
        SdcardUpdateActivity sdcardUpdateActivity = this.f1534a.f1535a;
        if (sdcardUpdateActivity.a(sdcardUpdateActivity.e, "/data/ota_package/update.zip", false)) {
            String unused = this.f1534a.f1535a.e = "/data/ota_package/update.zip";
            this.f1534a.f1535a.f.sendMessage(this.f1534a.f1535a.f.obtainMessage(15));
            return;
        }
        this.f1534a.f1535a.f.sendMessage(this.f1534a.f1535a.f.obtainMessage(-2));
    }
}
