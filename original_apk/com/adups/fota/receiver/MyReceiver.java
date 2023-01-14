package com.adups.fota.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.adups.fota.b.a;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.service.SystemActionService;
import com.adups.fota.utils.LogUtil;

public class MyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            LogUtil.a(intent.toString());
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action.equalsIgnoreCase(a.j)) {
                CustomActionService.a_shaKey_method2(context, intent.getIntExtra("task", 1));
            } else {
                SystemActionService.a_shaKey_method2(context, intent);
            }
        }
    }
}
