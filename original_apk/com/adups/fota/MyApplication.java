package com.adups.fota;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.adups.fota.a.b;
import com.adups.fota.b.a;
import com.adups.fota.h.d;
import com.adups.fota.manager.f;
import com.adups.fota.receiver.MyReceiver;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.l;
import com.adups.fota.utils.n;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;

public class MyApplication extends Application {

    /* renamed from: a  reason: collision with root package name */
    protected static Context f1498a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1499b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static b f1500c;
    private PhoneStateListener d = new l(this);

    public static Context c() {
        return f1498a;
    }

    public static void d() {
        new n().start();
    }

    public static boolean e() {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = f1498a.getPackageManager().getApplicationInfo(a.f1541c, 0);
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        return f1499b;
    }

    public static void g() {
        f1500c = null;
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 24) {
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            registerReceiver(new MyReceiver(), intentFilter);
        }
    }

    private void i() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(this.d, 32);
        }
    }

    private void j() {
        new d().a(this);
    }

    public void onCreate() {
        super.onCreate();
        f1498a = getApplicationContext();
        LogUtil.a("appVersion = " + n.b(this) + ".0.1.006" + "_" + "2019-12-04 16:35");
        try {
            androidx.appcompat.app.n.d(-1);
            d();
            j();
            h();
            l.b();
            i();
            t.f(this);
            com.adups.fota.utils.b.a().a((Context) this);
            com.google.firebase.messaging.a.a().a(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String d2 = o.d(this, "check_url");
        if (!TextUtils.isEmpty(d2) && !d2.equals(com.adups.fota.b.b.f1542a)) {
            o.b(f1498a, "check_url", com.adups.fota.b.b.f1542a);
        }
        f.t();
    }

    public static void a(b bVar) {
        f1500c = bVar;
    }
}
