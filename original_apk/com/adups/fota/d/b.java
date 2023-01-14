package com.adups.fota.d;

import android.content.Context;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.f.a;
import com.adups.fota.h.c;
import com.adups.fota.utils.LogUtil;
import org.greenrobot.eventbus.e;

/* compiled from: Install */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1555a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1556b;

    b(Context context, String str) {
        this.f1555a = context;
        this.f1556b = str;
    }

    public void run() {
        try {
            if (d.a()) {
                c.a().b(this.f1555a, this.f1556b);
            } else if (c.a().a_shaKey_method2(this.f1555a, this.f1556b) <= 0) {
                LogUtil.a("install execute error!");
                e.a().b(new EventMessage(300, 414, 0, 0, (Object) null));
                a.a(this.f1555a, false, 415, (String) null);
            }
        } catch (Exception e) {
            LogUtil.a("install exception : " + e.getMessage());
        }
    }
}
