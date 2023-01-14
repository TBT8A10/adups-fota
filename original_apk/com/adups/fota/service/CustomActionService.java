package com.adups.fota.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.app.JobIntentService;
import com.adups.fota.activity.BaseActivity;
import com.adups.fota.b.a;
import com.adups.fota.c.d;
import com.adups.fota.e.b;
import com.adups.fota.e.g;
import com.adups.fota.f.e;
import com.adups.fota.manager.f;
import com.adups.fota.receiver.BatteryReceiver;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.o;
import java.util.HashMap;
import java.util.Map;

public class CustomActionService extends JobIntentService {
    public static void a(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction(a.j);
        intent.putExtra("task", i);
        JobIntentService.a(context, CustomActionService.class, 101, intent);
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        String action = intent.getAction();
        LogUtil.a("action = " + action);
        if (!TextUtils.isEmpty(action) && action.equalsIgnoreCase(a.j)) {
            int intExtra = intent.getIntExtra("task", Integer.MAX_VALUE);
            LogUtil.a("task id = " + intExtra);
            switch (intExtra) {
                case 1:
                    g.a().a_shaKey_method2((Context) this, false);
                    d.b().e(this);
                    com.adups.fota.b.d.a((Context) this);
                    return;
                case 2:
                    b.a(this);
                    return;
                case 4:
                case 14:
                    com.adups.fota.d.d.c(this);
                    return;
                case 6:
                    com.adups.fota.d.d.d(this);
                    return;
                case 7:
                    com.adups.fota.manager.d.a_shaKey_method2(this, 0);
                    return;
                case 9:
                    d.b().b(this);
                    return;
                case 11:
                    g.a().b(this);
                    return;
                case 12:
                    com.adups.fota.d.d.b(this);
                    return;
                case 13:
                    LogUtil.b(false);
                    HashMap hashMap = new HashMap();
                    hashMap.put("task_id", f.k());
                    hashMap.put("action_type", BaseActivity.FCM_REPORT_TYPE_LOG);
                    hashMap.put("log", o.d(this, "debug_log_path"));
                    e.a().a_shaKey_method2((Context) this, (Map<String, String>) hashMap);
                    f.s();
                    return;
                case 15:
                    com.adups.fota.manager.e.a().a_shaKey_method2((Context) this, 105);
                    registerReceiver(new BatteryReceiver(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    return;
                default:
                    return;
            }
        }
    }
}
