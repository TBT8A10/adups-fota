package com.adups.fota.e;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.adups.fota.b.d;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.f.a;
import com.adups.fota.g.c;
import com.adups.fota.manager.b;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.j;
import com.adups.fota.utils.k;
import com.adups.fota.utils.l;
import com.adups.fota.utils.n;
import com.adups.fota.utils.o;
import org.greenrobot.eventbus.e;

/* compiled from: QueryVersion */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f1567a;

    /* renamed from: b  reason: collision with root package name */
    private static int f1568b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1569c;
    private int d;
    private int e = 1;

    private g() {
    }

    private boolean c(Context context) {
        return o.a(context, "check_last_time", 0) + b.b(context) <= System.currentTimeMillis();
    }

    private boolean d(Context context) {
        int b2 = o.b(context, "check_fail_counts");
        if (((long) b2) >= 3) {
            o.b(context, "check_fail_counts", -1);
            return true;
        }
        o.b(context, "check_fail_counts", b2 + 1);
        return false;
    }

    /* access modifiers changed from: private */
    public void e(Context context) {
        try {
            LogUtil.a("onQueryTask:start");
            e.a().b(new EventMessage(100, 1009, 0, 0, (Object) null));
            j.a(context);
            if (d.c(context) == 0) {
                c.a().a(context);
            }
            g(context);
            if (this.d == 2) {
                SystemClock.sleep(500);
            }
            String str = "";
            String a2 = o.a(context, "check_url", com.adups.fota.b.b.f1542a);
            if (this.e == 1) {
                str = a2 + com.adups.fota.b.b.f;
            } else if (this.e == 2) {
                str = a2 + com.adups.fota.b.b.g;
            }
            com.adups.fota.g.e a3 = c.a(context, str, this.d);
            LogUtil.a("query result : http status code = " + a3.d() + " error_code = " + a3.a() + " error_message = " + a3.b());
            a.a(context, this.d, this.e, a3);
            new a().a_shaKey_method2(context, a3);
            a(context, a3, a2);
        } catch (Exception e2) {
            LogUtil.a(e2.toString());
            e2.printStackTrace();
            if (context.getFilesDir() == null) {
                a.a(context, "cause_not_enough", 0);
                e.a().b(new EventMessage(100, 3005, 0, 0, (Object) null));
            } else {
                e.a().b(new EventMessage(100, 3010, 0, 0, (Object) null));
            }
        } catch (Throwable th) {
            this.f1569c = false;
            throw th;
        }
        this.f1569c = false;
    }

    private void f(Context context) {
        new Thread(new e(this, context)).start();
    }

    private void g(Context context) {
        if (o.a(context, "rom_damaged", false) && !o.a(context, "rom_damaged_version", "FOTA").equals(com.adups.fota.utils.c.j().k())) {
            o.b(context, "rom_damaged", false);
            o.a(context, "rom_damaged_version", "FOTA");
        }
    }

    private void h(Context context) {
        new Thread(new f(this, context)).start();
    }

    public int b() {
        return this.e;
    }

    public static g a() {
        if (f1567a == null) {
            synchronized (g.class) {
                if (f1567a == null) {
                    f1567a = new g();
                }
            }
        }
        return f1567a;
    }

    public void b(Context context) {
        LogUtil.a("onQueryScheduleTask");
        this.e = 1;
        a(context, 1, this.e);
    }

    private boolean b(Context context, VersionBean versionBean) {
        if (versionBean == null) {
            LogUtil.a("version == null");
            return false;
        }
        try {
            String a2 = o.a(context, "deltaurl", "");
            String deltaUrl = versionBean.getDeltaUrl();
            if (TextUtils.isEmpty(deltaUrl) || a2.equals(deltaUrl)) {
                return false;
            }
            LogUtil.a("isChangeDeltaUrl = true");
            o.b(context, "deltaurl", deltaUrl);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void a(Context context, boolean z) {
        if (z) {
            b.d(context);
        }
        boolean a2 = k.a(context);
        boolean c2 = c(context);
        boolean b2 = b.b(context);
        if (n.a(Process.myUid()) != 0) {
            LogUtil.a("onQuerySchedule,not system user,return");
            return;
        }
        LogUtil.a("isOverSchedule = " + c2 + "; isConnected = " + a2 + "; isOverActivateTime = " + b2);
        if (b2 && a2 && c2) {
            b(context);
            h(context);
        }
    }

    public void a(Context context, int i, int i2) {
        LogUtil.a("query_type = " + i + "; isQuerying = " + this.f1569c);
        synchronized (this) {
            if (!this.f1569c) {
                this.f1569c = true;
                this.d = i;
                this.e = i2;
                f(context);
            }
        }
    }

    public void a(Context context, int i) {
        a(context, i, 1);
    }

    private void a(Context context, com.adups.fota.g.e eVar, String str) {
        if (eVar != null) {
            if (eVar.e()) {
                o.b(context, "check_last_time", System.currentTimeMillis());
                return;
            }
            f1568b++;
            if (f1568b >= 3) {
                f1568b = 0;
                o.b(context, "check_last_time", System.currentTimeMillis());
            }
            l.b();
            a_shaKey_method2(context, str);
        }
    }

    private void a(Context context, String str) {
        if (!d(context)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            o.b(context, "check_url", com.adups.fota.b.b.f1542a);
        } else if (com.adups.fota.b.b.f1542a.equals(str)) {
            o.b(context, "check_url", com.adups.fota.b.b.f1543b);
        } else {
            o.b(context, "check_url", com.adups.fota.b.b.f1542a);
        }
    }

    public boolean a(Context context, VersionBean versionBean) {
        boolean z = true;
        if (this.e != 1) {
            return false;
        }
        boolean a2 = o.a(context, "rom_damaged", false);
        boolean b2 = b(context, versionBean);
        if (o.a(context, "isupgrade", 0) != 1) {
            z = false;
        }
        LogUtil.a("isDamaged = " + a2 + "; urlChanged = " + b2);
        if (b2) {
            o.b(context, "rom_damaged", false);
            return false;
        } else if (!z) {
            return false;
        } else {
            return a2;
        }
    }

    public boolean a(Context context) {
        boolean z = true;
        if (o.a(context, "ota_update_type", 1) != 2) {
            z = false;
        }
        LogUtil.a("isFullUpdate = " + z);
        return z;
    }
}
