package com.adups.fota.d;

import android.content.Context;
import com.adups.fota.f.a;
import com.adups.fota.utils.LogUtil;

/* compiled from: Install */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1557a;

    c(Context context) {
        this.f1557a = context;
    }

    public void run() {
        try {
            if (com.adups.fota.e.c.a().c() != null) {
                LogUtil.a("ota install normal ");
                d.g(this.f1557a);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.a("update exception : " + e.getMessage());
            a.a_shaKey_method2(this.f1557a, "cause_exception");
        }
        boolean unused = d.f1558a = false;
    }
}
