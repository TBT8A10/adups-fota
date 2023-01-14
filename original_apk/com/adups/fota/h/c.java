package com.adups.fota.h;

import android.content.Context;
import android.os.PowerManager;
import android.os.RecoverySystem;
import android.os.UpdateEngine;
import android.text.TextUtils;
import com.adups.fota.b.d;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.f.a;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.o;
import java.io.File;
import org.greenrobot.eventbus.e;

/* compiled from: Recovery */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f1592a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f1593b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f1594c;

    private c() {
    }

    public void b(Context context, String str) {
        LogUtil.a("recovery ab path : " + str);
        if (System.currentTimeMillis() - this.f1594c < 60000) {
            LogUtil.a("ab update is running");
            return;
        }
        this.f1593b = false;
        a(str);
        UpdateEngine updateEngine = new UpdateEngine();
        updateEngine.bind(new a(this, context, str, updateEngine));
    }

    public static c a() {
        if (f1592a == null) {
            synchronized (c.class) {
                if (f1592a == null) {
                    f1592a = new c();
                }
            }
        }
        return f1592a;
    }

    /* access modifiers changed from: private */
    public void b(Context context) {
        LogUtil.a("abSuccess enter");
        d.a_shaKey_method2(context, 6);
        e.a().b(new EventMessage(300, 0, 0, 601, "ab"));
        o.b(context, "ota_enter_recovery", true);
        com.adups.fota.d.d.b(context);
        if (o.a(context, "ota_update_local", false)) {
            a(context);
        }
    }

    public int a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                LogUtil.a("package path empty");
                return 0;
            }
            LogUtil.a("recovery path : " + str);
            File file = new File(str);
            if (file.exists()) {
                LogUtil.a("go to update system");
                RecoverySystem.installPackage(context, file);
                LogUtil.a("still running after update system");
            } else {
                LogUtil.a("package file not exist");
            }
            return 0;
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
        }
    }

    private void a(String str) {
        try {
            String str2 = "chmod 666 " + str;
            LogUtil.a("command = " + str2);
            if (Runtime.getRuntime().exec(str2).waitFor() == 0) {
                LogUtil.a("chmod success!");
            } else {
                LogUtil.a("chmod fail!");
            }
        } catch (Exception unused) {
            LogUtil.a("chmod fail!");
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, UpdateEngine updateEngine) {
        LogUtil.a("abUpdate enter");
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            LogUtil.a("executeAb,path is not valid");
            a(context, 620, false);
            return;
        }
        new Thread(new b(this, str, context, updateEngine)).start();
    }

    public void a(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            LogUtil.a("reboot,update system");
            powerManager.reboot("");
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, int i, boolean z) {
        LogUtil.a("abFail,errCode = " + i + ",isComplete = " + z);
        if (i == 20) {
            o.b(context, "rom_damaged", true);
        }
        d.a_shaKey_method2(context, 0);
        com.adups.fota.e.c.a().a(context);
        com.adups.fota.manager.d.c(context, 1);
        a.a(context, false, i, "ab");
        if (z) {
            e.a().b(new EventMessage(300, i, 0, 601, "ab"));
        } else {
            e.a().b(new EventMessage(300, 100, 0, (long) i, "ab"));
        }
    }
}
