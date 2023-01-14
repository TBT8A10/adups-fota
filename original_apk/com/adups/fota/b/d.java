package com.adups.fota.b;

import android.content.Context;
import android.text.TextUtils;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.e.c;
import com.adups.fota.e.g;
import com.adups.fota.f.a;
import com.adups.fota.manager.e;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;
import com.adups.fota.utils.u;
import java.io.File;

/* compiled from: Status */
public class d {
    public static void a(Context context, VersionBean versionBean) {
        if (c.a().c() == null) {
            LogUtil.a("version empty");
            return;
        }
        LogUtil.a("version exist");
        a_shaKey_method2(context, 1);
        o.b(context, "ota_original_version", com.adups.fota.utils.c.j().k());
        o.b(context, "ota_update_version", versionBean.getVersionName());
        o.b(context, "ota_update_type", g.a().b());
        e.a().a_shaKey_method2(context, 2131558451);
        a((String) c.a().a_shaKey_method2("download_path", String.class));
        com.adups.fota.manager.d.f(context);
        CustomActionService.a_shaKey_method2(context, 9);
    }

    public static void b(Context context) {
        boolean booleanValue = ((Boolean) c.a().a_shaKey_method2("install_forced", Boolean.class)).booleanValue();
        LogUtil.a("download_completed_instal,force_install = " + booleanValue);
        if (com.adups.fota.d.d.a()) {
            if (com.adups.fota.d.d.a_shaKey_method2(context, com.adups.fota.utils.c.j().a())) {
                a.a_shaKey_method2(context, "auto");
                com.adups.fota.d.d.e(context.getApplicationContext());
                return;
            }
            LogUtil.a("no update reason : battery not enough");
            CustomActionService.a_shaKey_method2(context, 15);
            a.a_shaKey_method2(context, "cause_not_right_time");
            org.greenrobot.eventbus.e.a().b(new EventMessage(300, 100, 0, 617, "ab"));
        } else if (booleanValue) {
            com.adups.fota.d.d.c(context);
        } else {
            LogUtil.a("no update reason : not support ab update and no force install");
            a.a_shaKey_method2(context, "cause_not_force_upgrade");
        }
    }

    public static int c(Context context) {
        return o.a(context, "ota_update_status", 0);
    }

    public static void d(Context context) {
        a.a(context, "cancel", 0);
        c.a().a(context);
    }

    public static void e(Context context) {
        com.adups.fota.utils.g.a(context.getFilesDir().getPath() + "/shared_prefs");
        d(context);
    }

    public static void f(Context context) {
        LogUtil.a(" ");
        org.greenrobot.eventbus.e.a().b(new EventMessage(200, 1001, 0, 0, (Object) null));
        o.b(context, "ota_install_delay_schedule", 0);
        a_shaKey_method2(context, 4);
        e.a().a_shaKey_method2(context, 2131558451);
        com.adups.fota.manager.d.c(context);
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("#")) {
            String[] split = str.split("#");
            if (split.length == 3) {
                t.a(split[0], split[1], split[2]);
                LogUtil.a("ota download path :path[0]=" + split[0] + ",path[1]=" + split[1] + ",path[2]=" + split[2]);
            }
        }
    }

    public static void a(Context context) {
        int c2 = c(context);
        LogUtil.a("downloadCompleteTask,status=" + c2);
        if (c2 == 4) {
            b(context);
        } else if (c2 == 5) {
            if (o.a(context, "ota_update_local", false)) {
                String a2 = o.a(context, "ota_update_local_path", "");
                if (TextUtils.isEmpty(a2) || !new File(a2).exists()) {
                    d(context);
                } else {
                    com.adups.fota.h.c.a().b(context, a2);
                }
            } else {
                com.adups.fota.h.c.a().b(context, t.d(context));
            }
        } else if (c2 == 6) {
            com.adups.fota.d.d.b(context);
        }
    }

    public static void a(Context context, int i) {
        o.b(context, "ota_update_status", i);
        u.b("ota_update_status", i);
    }
}
