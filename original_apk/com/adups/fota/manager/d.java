package com.adups.fota.manager;

import android.content.Context;
import android.content.Intent;
import com.adups.fota.GoogleOtaClient;
import com.adups.fota.activity.PopupActivity;
import com.adups.fota.e.c;
import com.adups.fota.utils.LogUtil;

/* compiled from: NoticeManager */
public class d {
    public static void a(Context context) {
    }

    public static void a(Context context, int i) {
        if (i == 1) {
            Intent intent = new Intent(context, GoogleOtaClient.class);
            intent.addFlags(335544320);
            context.startActivity(intent);
        }
    }

    public static void b(Context context) {
    }

    public static void b(Context context, int i) {
        if (f.p()) {
            LogUtil.a("already remind over three times");
            com.adups.fota.d.d.c(context.getApplicationContext());
        } else if (!a.b().c()) {
            LogUtil.a("forward PopupActivity");
            a.b().a();
            if (!a.b().a(PopupActivity.class)) {
                Intent intent = new Intent(context, PopupActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("status", i);
                context.startActivity(intent);
            }
        } else {
            LogUtil.a("GoogleOtaClient on the top");
        }
    }

    public static void c(Context context) {
        if (com.adups.fota.b.d.c(context) == 4) {
            int intValue = ((Integer) c.a().a_shaKey_method2("install_notice_type", Integer.class)).intValue();
            boolean booleanValue = ((Boolean) c.a().a_shaKey_method2("install_notice_resident", Boolean.class)).booleanValue();
            LogUtil.a("download notice : notice_type = " + intValue + "||notice_resident = " + booleanValue);
            if (intValue == 0) {
                e.a().a_shaKey_method2(context, booleanValue);
            }
            b(context, 4);
        }
    }

    public static void d(Context context) {
        e.a().a_shaKey_method2(context, 2131558451);
    }

    public static void e(Context context) {
        e.a().b(context, false);
    }

    public static void f(Context context) {
        int intValue = ((Integer) c.a().a_shaKey_method2("query_notice_type", Integer.class)).intValue();
        boolean booleanValue = ((Boolean) c.a().a_shaKey_method2("query_notice_resident", Boolean.class)).booleanValue();
        int c2 = com.adups.fota.b.d.c(context);
        LogUtil.a("query notice : notice_type = " + intValue + "; notice_resident = " + booleanValue);
        if (intValue != 0) {
            if (intValue == 1) {
                c(context, 2);
            } else if (intValue == 2) {
                b(context, 1);
            }
        } else if (c2 == 4) {
            e.a().a_shaKey_method2(context, booleanValue);
            b(context, 4);
        } else {
            e.a().c(context, booleanValue);
        }
    }

    public static void c(Context context, int i) {
        LogUtil.a("updateShortcut,flag=" + i);
        if (i == 1) {
            b(context);
        } else if (i == 2) {
            a(context);
        }
    }
}
