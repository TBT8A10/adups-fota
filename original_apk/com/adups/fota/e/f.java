package com.adups.fota.e;

import android.content.Context;
import com.adups.fota.b.d;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.c.c;
import com.adups.fota.f.a;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.o;
import org.greenrobot.eventbus.e;

/* compiled from: QueryVersion */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1565a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ g f1566b;

    f(g gVar, Context context) {
        this.f1566b = gVar;
        this.f1565a = context;
    }

    public void run() {
        String str;
        try {
            Thread.sleep(60000);
            int intValue = ((Integer) c.a().a_shaKey_method2("clear_cache", Integer.class)).intValue();
            VersionBean c2 = c.a().c();
            if (c2 != null) {
                str = c2.getDeltaUrl();
            } else {
                str = "";
            }
            String a2 = o.a(this.f1565a, "cache_url", "");
            if (intValue == 1 && !a2.equals(str)) {
                LogUtil.a("execute clear cache ");
                c.b().a(this.f1565a);
                d.e(this.f1565a);
                o.b(this.f1565a, "cache_url", str);
                e.a().b(new EventMessage(100, 1006, 0, 0, (Object) null));
                a.a(this.f1565a, "cause_clean_cache", 0);
                Thread.sleep(5000);
                this.f1566b.b(this.f1565a);
            }
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
    }
}
