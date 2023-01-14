package com.adups.fota.d;

import android.content.Context;
import android.text.TextUtils;
import com.adups.fota.e.d;
import com.adups.fota.e.g;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.o;
import java.io.File;

/* compiled from: NewInstallVerify */
public class f extends a {
    public int a(Context context, String str, String str2) {
        LogUtil.a("start");
        if (!new File(str).exists()) {
            LogUtil.a("deltaPath is null");
            return 401;
        }
        LogUtil.a("zipFilePath = " + str + ",server sha256  = " + str2);
        String f = com.adups.fota.utils.f.f(str);
        o.b(context, "sha", f);
        if (TextUtils.isEmpty(f)) {
            LogUtil.a("get file sha256 error!");
            return 416;
        }
        LogUtil.a("file sha256  = " + f);
        if (!f.equalsIgnoreCase(str2)) {
            e.b(context);
            LogUtil.a("sha256 is different");
            return 402;
        }
        LogUtil.a("sha256 is equal");
        if (!g.a().a(context)) {
            String a2 = d.a(str);
            LogUtil.a("isRomDamaged  result = " + a2);
            if (!TextUtils.isEmpty(a2)) {
                LogUtil.a("rom  are damaged ");
                a(a2);
                o.b(context, "rom_damaged", true);
                o.b(context, "rom_damaged_version", c.j().k());
                if (o.a(context, "isupgrade", 0) == 1) {
                    LogUtil.a("rom  are damaged, upgrade == 1  ");
                    return 404;
                }
            }
        }
        LogUtil.a(" finish  success");
        return 405;
    }
}
