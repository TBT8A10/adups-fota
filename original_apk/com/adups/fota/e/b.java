package com.adups.fota.e;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.adups.fota.b.a;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.g;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;

/* compiled from: QueryActivate */
public class b {
    public static void a(Context context) {
        LogUtil.a("enter");
        if (SystemClock.elapsedRealtime() < c.j().p()) {
            com.adups.fota.manager.b.c(context);
            return;
        }
        o.b(context, "activate_total_time", c.j().p());
        e(context);
        com.adups.fota.manager.b.d(context);
        CustomActionService.a_shaKey_method2(context, 1);
    }

    public static boolean b(Context context) {
        if (SystemClock.elapsedRealtime() >= c.j().p()) {
            if (!d(context)) {
                e(context);
            }
            return true;
        }
        if (!d(context)) {
            com.adups.fota.manager.b.c(context);
        }
        if (o.a(context, "activate_total_time", 0) >= c.j().p()) {
            return true;
        }
        return d(context);
    }

    public static void c(Context context) {
        if (b(context)) {
            LogUtil.a("ota is activated");
        } else {
            com.adups.fota.manager.b.c(context);
        }
    }

    private static boolean d(Context context) {
        boolean z = !TextUtils.isEmpty(g.i(t.c(context) + a.f1539a));
        if (!z && g.a(context)) {
            z = !TextUtils.isEmpty(g.i(t.c() + a.f1539a));
        }
        LogUtil.a("dogWatch exists : " + z);
        return z;
    }

    private static void e(Context context) {
        if (g.b(context)) {
            g.a_shaKey_method2(t.c() + a.f1539a, "uu".getBytes());
        }
        g.a_shaKey_method2(t.c(context) + a.f1539a, "uu".getBytes());
        LogUtil.a("put dogWatch");
    }
}
