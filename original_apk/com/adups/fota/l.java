package com.adups.fota;

import android.telephony.PhoneStateListener;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.k;

/* compiled from: MyApplication */
class l extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyApplication f1602a;

    l(MyApplication myApplication) {
        this.f1602a = myApplication;
    }

    public void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        if (k.c(MyApplication.f1498a)) {
            LogUtil.a("onCallStateChanged but WiFiConnected ,ignored");
            return;
        }
        if (i == 1 || i == 2) {
            boolean unused = MyApplication.f1499b = true;
            if (MyApplication.f1500c != null) {
                MyApplication.f1500c.onPhoneCalling();
            }
        } else {
            boolean unused2 = MyApplication.f1499b = false;
            if (MyApplication.f1500c != null) {
                MyApplication.f1500c.onPhoneOff();
            }
        }
        LogUtil.a("phone state : " + i + " , isCalling : " + MyApplication.f1499b);
    }
}
