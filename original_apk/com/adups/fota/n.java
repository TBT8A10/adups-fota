package com.adups.fota;

import com.adups.fota.utils.LogUtil;
import com.google.firebase.d;
import com.google.firebase.iid.FirebaseInstanceId;

/* compiled from: MyApplication */
class n extends Thread {
    n() {
    }

    public void run() {
        super.run();
        try {
            d.a(MyApplication.f1498a);
            FirebaseInstanceId.a().b().a(new m(this));
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
    }
}
