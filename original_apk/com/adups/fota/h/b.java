package com.adups.fota.h;

import android.content.Context;
import android.os.Build;
import android.os.UpdateEngine;
import com.adups.fota.b.d;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.e.c;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.g;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.e;

/* compiled from: Recovery */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1589a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f1590b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ UpdateEngine f1591c;
    final /* synthetic */ c d;

    b(c cVar, String str, Context context, UpdateEngine updateEngine) {
        this.d = cVar;
        this.f1589a = str;
        this.f1590b = context;
        this.f1591c = updateEngine;
    }

    public void run() {
        try {
            List<String> e = g.e(this.f1589a);
            String[] strArr = new String[e.size()];
            String[] strArr2 = (String[]) e.toArray(strArr);
            LogUtil.a("headerKeyValuePairs = " + Arrays.toString(strArr2) + ",headerKeyValuePairs length = " + strArr.length);
            if (Build.VERSION.SDK_INT >= 28 || strArr2.length > 1) {
                long unused = this.d.f1594c = System.currentTimeMillis();
                d.a_shaKey_method2(this.f1590b, 5);
                e.a().b(new EventMessage(300, 99, 0, 602, "ab"));
                long g = g.g(this.f1589a);
                long parseLong = Long.parseLong(strArr2[1].replace("FILE_SIZE=", ""));
                boolean unused2 = this.d.f1593b = true;
                this.f1591c.applyPayload("file://" + this.f1589a, g, parseLong, strArr2);
                return;
            }
            LogUtil.a("length <= 1");
            com.adups.fota.manager.d.c(this.f1590b, 1);
            c.a().a(this.f1590b);
            this.d.a(this.f1590b, 618, false);
        } catch (Exception e2) {
            LogUtil.a(e2.getMessage());
        }
    }
}
