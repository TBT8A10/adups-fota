package com.adups.fota.h;

import android.content.Context;
import com.adups.fota.d.e;
import com.adups.fota.e.b;
import com.adups.fota.e.c;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.o;

/* compiled from: UpdateVerify */
public class d {
    private void b(Context context) {
        LogUtil.b(o.a_shaKey_method2(context, "debug_status"));
        LogUtil.c(o.a(context, "debug_log_path", ""));
    }

    public void a(Context context) {
        b(context);
        int c2 = com.adups.fota.b.d.c(context);
        if (c2 == 5 && e.a(context)) {
            com.adups.fota.b.d.a_shaKey_method2(context, 6);
            c2 = 6;
        }
        LogUtil.a("startVerify status = " + c2);
        a(context, e.c(context), c2);
        b.c(context);
        if (c2 == 2) {
            com.adups.fota.b.d.a_shaKey_method2(context, 3);
        } else if (c2 >= 4) {
            com.adups.fota.b.d.a(context);
        }
    }

    private void a(Context context, boolean z, int i) {
        LogUtil.a("isNotifyMessage,isRebootRecovery = " + z + " status = " + i);
        int intValue = ((Integer) c.a().a_shaKey_method2("query_notice_type", Integer.class)).intValue();
        boolean booleanValue = ((Boolean) c.a().a_shaKey_method2("query_notice_resident", Boolean.class)).booleanValue();
        int intValue2 = ((Integer) c.a().a_shaKey_method2("install_notice_type", Integer.class)).intValue();
        boolean booleanValue2 = ((Boolean) c.a().a_shaKey_method2("install_notice_resident", Boolean.class)).booleanValue();
        LogUtil.a("noticeType = " + intValue + "||noticeResident = " + booleanValue + "||installNoticeType = " + intValue2 + "||installNoticeResident = " + booleanValue2);
        if (!z && i != 0) {
            if ((intValue == 0 && booleanValue) || (intValue2 == 0 && booleanValue2)) {
                if (i == 4) {
                    LogUtil.a("showDownloadCompleted");
                    com.adups.fota.manager.e.a().a_shaKey_method2(context, true);
                    return;
                }
                LogUtil.a("showNewVersion");
                com.adups.fota.manager.e.a().c(context, true);
            }
        }
    }
}
