package com.adups.fota.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.JobIntentService;
import com.adups.fota.a.e;
import com.adups.fota.b.d;
import com.adups.fota.e.g;
import com.adups.fota.g.c;
import com.adups.fota.manager.JobScheduleManager;
import com.adups.fota.manager.b;
import com.adups.fota.manager.f;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.k;

public class SystemActionService extends JobIntentService implements e {
    private static boolean j = false;

    public static void a(Context context, Intent intent) {
        JobIntentService.a(context, SystemActionService.class, 100, intent);
    }

    private void b(boolean z) {
        boolean a2 = k.a(this);
        LogUtil.a("isConnected = " + a2);
        if (a2) {
            g.a().a_shaKey_method2((Context) this, true);
            if (!z || d.c(this) != 2) {
                com.adups.fota.c.d.b().e(this);
            }
            if (f.o()) {
                c.a_shaKey_method2((Context) this, (e) this);
            }
            com.adups.fota.f.e.a().a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if (action.equalsIgnoreCase("android.intent.action.MEDIA_BAD_REMOVAL") || action.equalsIgnoreCase("android.intent.action.MEDIA_REMOVED")) {
                LogUtil.b(false);
            }
            LogUtil.a("action = " + action);
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1886648615) {
                if (hashCode != -1172645946) {
                    if (hashCode == 798292259 && action.equals("android.intent.action.BOOT_COMPLETED")) {
                        c2 = 0;
                    }
                } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    c2 = 1;
                }
            } else if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                c2 = 2;
            }
            if (c2 == 0) {
                LogUtil.a("isReceivedBoot : " + j);
                if (!j) {
                    j = true;
                    b.d(this);
                    if (Build.VERSION.SDK_INT > 20) {
                        JobScheduleManager.a_shaKey_method2(this, 100);
                    }
                    if (f.m() != 0) {
                        b.e(this);
                    }
                } else {
                    return;
                }
            } else if (c2 != 1) {
                if (c2 == 2) {
                    b(true);
                    return;
                }
                return;
            }
            b(false);
        }
    }

    public void a(String str) throws Exception {
        LogUtil.a(str);
        f.a(false);
    }
}
