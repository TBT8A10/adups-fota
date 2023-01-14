package com.adups.fota.activity;

import android.os.Build;
import com.adups.fota.utils.LogUtil;

/* compiled from: SdcardUpdateActivity */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SdcardUpdateActivity f1537a;

    r(SdcardUpdateActivity sdcardUpdateActivity) {
        this.f1537a = sdcardUpdateActivity;
    }

    public void run() {
        LogUtil.a("sdCardUpdate, copy to ota_root file");
        if (Build.VERSION.SDK_INT < 23) {
            StringBuilder sb = new StringBuilder();
            SdcardUpdateActivity sdcardUpdateActivity = this.f1537a;
            sb.append(sdcardUpdateActivity.a(sdcardUpdateActivity.e));
            sb.append("/LocalSdUpdate.zip");
            String sb2 = sb.toString();
            SdcardUpdateActivity sdcardUpdateActivity2 = this.f1537a;
            if (sdcardUpdateActivity2.a(sdcardUpdateActivity2.e, sb2, true)) {
                String unused = this.f1537a.e = sb2;
            }
        }
        this.f1537a.f.sendEmptyMessage(2);
    }
}
