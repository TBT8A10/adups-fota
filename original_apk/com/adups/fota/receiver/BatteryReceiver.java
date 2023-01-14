package com.adups.fota.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.adups.fota.b.d;
import com.adups.fota.f.a;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;

public class BatteryReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean z;
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                int c2 = d.c(context);
                LogUtil.a("status = " + c2 + ",action = " + action);
                if (c2 == 4 && action.equalsIgnoreCase("android.intent.action.BATTERY_CHANGED")) {
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    if (powerManager != null) {
                        z = Build.VERSION.SDK_INT > 19 ? powerManager.isInteractive() : powerManager.isScreenOn();
                    } else {
                        z = false;
                    }
                    int intExtra = intent.getIntExtra("level", 0);
                    LogUtil.a("battery level = " + intExtra + ",isScreenOn = " + z);
                    if (intExtra >= c.j().a() && !z) {
                        a.a_shaKey_method2(context, "auto");
                        com.adups.fota.d.d.e(context);
                    }
                }
            }
        }
    }
}
