package com.adups.fota.d;

import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;
import com.adups.fota.e.d;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;
import java.io.File;

/* compiled from: OldInstallVerify */
public class g extends a {
    public int a(Context context, String str, String str2) {
        LogUtil.a("start");
        String d = t.d(context);
        if (!com.adups.fota.utils.g.a_shaKey_method2(d, t.e(context) + "/package.zip")) {
            LogUtil.a("rename fail");
            return 408;
        }
        LogUtil.a("rename success");
        File file = new File(t.e(context) + "/package.zip");
        String parent = file.getParent();
        if (parent == null) {
            LogUtil.a("deltaPath  null ");
            return 410;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock wakeLock = null;
        if (powerManager != null) {
            wakeLock = powerManager.newWakeLock(1, "fota:unzipwakeup");
        }
        if (wakeLock != null) {
            wakeLock.acquire(600000);
        }
        boolean a2 = com.adups.fota.utils.g.a_shaKey_method2(file, parent);
        if (wakeLock != null) {
            wakeLock.release();
        }
        if (!a2) {
            LogUtil.a("unzip  fail ");
            return 401;
        }
        LogUtil.a("unzip  success ");
        String c2 = com.adups.fota.utils.g.c(parent + "/update.zip");
        String f = com.adups.fota.utils.g.f(parent + "/md5sum");
        if (c2 == null) {
            return 411;
        }
        if (!c2.equalsIgnoreCase(f)) {
            e.b(context);
            return 402;
        }
        LogUtil.a("md5Encode equal");
        com.adups.fota.utils.g.b(context, parent);
        if (!com.adups.fota.e.g.a().a(context)) {
            String a3 = d.a(parent + "/update.zip");
            LogUtil.a("isRomDamaged  result = " + a3);
            if (!TextUtils.isEmpty(a3)) {
                a(a3);
                o.b(context, "rom_damaged", true);
                o.b(context, "rom_damaged_version", c.j().k());
                LogUtil.a("rom  are damaged  ");
                if (o.a(context, "isupgrade", 0) == 1) {
                    LogUtil.a("rom  are damaged, upgrade == 1  ");
                    return 404;
                }
            }
        }
        LogUtil.a("finish  success");
        return 405;
    }
}
