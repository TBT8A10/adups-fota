package com.adups.fota.b;

import com.adups.fota.activity.BaseActivity;

/* compiled from: Setting */
public final class c {
    public static int a() {
        String b2 = com.adups.fota.utils.c.j().b();
        if ("0".equals(b2) || "1".equals(b2)) {
            return 1440;
        }
        if (BaseActivity.FCM_REPORT_TYPE_LOG.equals(b2)) {
            return 4320;
        }
        if ("7".equals(b2)) {
            return 10080;
        }
        return 1440;
    }
}
