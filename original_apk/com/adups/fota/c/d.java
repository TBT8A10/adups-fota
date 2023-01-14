package com.adups.fota.c;

import android.content.Context;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.e.c;
import com.adups.fota.f.a;
import com.adups.fota.f.e;
import com.adups.fota.service.CustomActionService;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.k;
import com.adups.fota.utils.o;

/* compiled from: DownVersion */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f1551a;

    /* renamed from: b  reason: collision with root package name */
    private int f1552b = 0;

    private d() {
    }

    public static d b() {
        if (f1551a == null) {
            synchronized (d.class) {
                if (f1551a == null) {
                    f1551a = new d();
                }
            }
        }
        return f1551a;
    }

    private boolean g(Context context) {
        boolean c2 = k.c(context);
        int c3 = com.adups.fota.b.d.c(context);
        if (h(context)) {
            return false;
        }
        boolean b2 = b(context, c2, false);
        LogUtil.a("isAutoDown= " + b2 + "; version_status= " + c3);
        return (c3 == 1 || c3 == 3) && b2;
    }

    private boolean h(Context context) {
        try {
            int b2 = o.b(context, "ota_install_fail_count");
            if (b2 < 5) {
                return false;
            }
            if (e.a().a(context, "cause_install_fail_5", 21600000)) {
                a.a(context, "cause_install_fail_5", 0);
            }
            LogUtil.a("updatefailcount = " + b2 + ", return true!!!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(Context context, int i) {
        synchronized (d.class) {
            if (c.b().e()) {
                int c2 = com.adups.fota.b.d.c(context);
                LogUtil.a("version_status = " + c2);
                if (c2 != 3) {
                    LogUtil.a("downloading package ");
                    a.a(context, "cause_downloading", 0);
                    return;
                }
            } else {
                LogUtil.a("mDown == null; flag = " + i);
            }
            com.adups.fota.b.d.a_shaKey_method2(context, 2);
            if (i == 1) {
                LogUtil.a("download AUTO");
            }
            this.f1552b = i;
            c.b().a();
        }
    }

    public boolean c(Context context) {
        return c.b().e() && com.adups.fota.b.d.c(context) == 2;
    }

    public void d(Context context) {
        a(context);
        com.adups.fota.b.d.d(context);
    }

    public void e(Context context) {
        if (c.a().c() != null) {
            if (c(context)) {
                boolean c2 = k.c(context);
                boolean b2 = b(context, c2, true);
                LogUtil.a("isAutoDown= " + b2);
                if (!b2 && !c2) {
                    a.a(context, "cause_net_change_downloading", 0);
                    f(context);
                    org.greenrobot.eventbus.e.a().b(new EventMessage(200, 5001, 0, 0, (Object) null));
                    return;
                }
                return;
            }
            CustomActionService.a_shaKey_method2(context, 9);
        }
    }

    public void f(Context context) {
        synchronized (this) {
            LogUtil.a("");
            c.b().b(context);
            com.adups.fota.manager.d.e(context);
        }
    }

    private boolean b(Context context, boolean z, boolean z2) {
        try {
            int intValue = ((Integer) c.a().a_shaKey_method2("download_auto", Integer.class)).intValue();
            LogUtil.a("autoDownload = " + intValue);
            if (intValue == 2) {
                return false;
            }
            if (intValue == 1) {
                return a(z);
            }
            if (intValue == 0) {
                return a(context, z, z2);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r17) {
        /*
            r16 = this;
            r0 = r17
            boolean r1 = com.adups.fota.utils.k.b(r17)
            if (r1 == 0) goto L_0x000f
            boolean r1 = com.adups.fota.MyApplication.f()
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            com.adups.fota.e.c r1 = com.adups.fota.e.c.a()
            com.adups.fota.bean.VersionBean r1 = r1.c()
            long r1 = r1.getFileSize()
            com.adups.fota.e.c r3 = com.adups.fota.e.c.a()
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            java.lang.String r5 = "download_path_server"
            java.lang.Object r3 = r3.a((java.lang.String) r5, r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r4 = "sdcard has no space , return"
            java.lang.String r5 = "inside has no space , return"
            java.lang.String r6 = "sdcard not mounted , return"
            r7 = 1
            java.lang.String r8 = "cause_not_enough"
            java.lang.String r9 = "down_status_cause_not_enough"
            r10 = 0
            r12 = 21600000(0x1499700, double:1.0671818E-316)
            if (r3 == 0) goto L_0x008b
            if (r3 == r7) goto L_0x005d
            r4 = 2
            if (r3 == r4) goto L_0x0046
            goto L_0x0119
        L_0x0046:
            boolean r1 = com.adups.fota.utils.t.a((android.content.Context) r0, (long) r1)
            if (r1 != 0) goto L_0x0119
            com.adups.fota.utils.LogUtil.a((java.lang.String) r5)
            com.adups.fota.f.e r1 = com.adups.fota.f.e.a()
            boolean r1 = r1.a((android.content.Context) r0, (java.lang.String) r9, (long) r12)
            if (r1 == 0) goto L_0x005c
            com.adups.fota.f.a.a(r0, r8, r10)
        L_0x005c:
            return
        L_0x005d:
            boolean r3 = com.adups.fota.utils.t.h(r17)
            if (r3 != 0) goto L_0x0074
            com.adups.fota.utils.LogUtil.a((java.lang.String) r6)
            com.adups.fota.f.e r1 = com.adups.fota.f.e.a()
            boolean r1 = r1.a((android.content.Context) r0, (java.lang.String) r9, (long) r12)
            if (r1 == 0) goto L_0x0073
            com.adups.fota.f.a.a(r0, r8, r10)
        L_0x0073:
            return
        L_0x0074:
            boolean r1 = com.adups.fota.utils.t.c((android.content.Context) r0, (long) r1)
            if (r1 != 0) goto L_0x0119
            com.adups.fota.utils.LogUtil.a((java.lang.String) r4)
            com.adups.fota.f.e r1 = com.adups.fota.f.e.a()
            boolean r1 = r1.a((android.content.Context) r0, (java.lang.String) r9, (long) r12)
            if (r1 == 0) goto L_0x008a
            com.adups.fota.f.a.a(r0, r8, r10)
        L_0x008a:
            return
        L_0x008b:
            com.adups.fota.utils.c r3 = com.adups.fota.utils.c.j()
            java.lang.String r3 = r3.m()
            int r15 = r3.hashCode()
            r14 = -1820761141(0xffffffff937963cb, float:-3.147742E-27)
            if (r15 == r14) goto L_0x00ac
            r14 = 570410685(0x21ffc6bd, float:1.7332078E-18)
            if (r15 == r14) goto L_0x00a2
            goto L_0x00b6
        L_0x00a2:
            java.lang.String r14 = "internal"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x00b6
            r3 = 0
            goto L_0x00b7
        L_0x00ac:
            java.lang.String r14 = "external"
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x00b6
            r3 = 1
            goto L_0x00b7
        L_0x00b6:
            r3 = -1
        L_0x00b7:
            if (r3 == 0) goto L_0x0102
            if (r3 == r7) goto L_0x00d4
            boolean r1 = com.adups.fota.utils.t.e(r0, r1)
            if (r1 != 0) goto L_0x0119
            java.lang.String r1 = "device has no space , return"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r1)
            com.adups.fota.f.e r1 = com.adups.fota.f.e.a()
            boolean r1 = r1.a((android.content.Context) r0, (java.lang.String) r9, (long) r12)
            if (r1 == 0) goto L_0x00d3
            com.adups.fota.f.a.a(r0, r8, r10)
        L_0x00d3:
            return
        L_0x00d4:
            boolean r3 = com.adups.fota.utils.t.h(r17)
            if (r3 != 0) goto L_0x00eb
            com.adups.fota.utils.LogUtil.a((java.lang.String) r6)
            com.adups.fota.f.e r1 = com.adups.fota.f.e.a()
            boolean r1 = r1.a((android.content.Context) r0, (java.lang.String) r9, (long) r12)
            if (r1 == 0) goto L_0x00ea
            com.adups.fota.f.a.a(r0, r8, r10)
        L_0x00ea:
            return
        L_0x00eb:
            boolean r1 = com.adups.fota.utils.t.c((android.content.Context) r0, (long) r1)
            if (r1 != 0) goto L_0x0119
            com.adups.fota.utils.LogUtil.a((java.lang.String) r4)
            com.adups.fota.f.e r1 = com.adups.fota.f.e.a()
            boolean r1 = r1.a((android.content.Context) r0, (java.lang.String) r9, (long) r12)
            if (r1 == 0) goto L_0x0101
            com.adups.fota.f.a.a(r0, r8, r10)
        L_0x0101:
            return
        L_0x0102:
            boolean r1 = com.adups.fota.utils.t.a((android.content.Context) r0, (long) r1)
            if (r1 != 0) goto L_0x0119
            com.adups.fota.utils.LogUtil.a((java.lang.String) r5)
            com.adups.fota.f.e r1 = com.adups.fota.f.e.a()
            boolean r1 = r1.a((android.content.Context) r0, (java.lang.String) r9, (long) r12)
            if (r1 == 0) goto L_0x0118
            com.adups.fota.f.a.a(r0, r8, r10)
        L_0x0118:
            return
        L_0x0119:
            boolean r1 = r16.g(r17)
            if (r1 == 0) goto L_0x0125
            r1 = r16
            r1.a(r0, r7)
            goto L_0x0143
        L_0x0125:
            r1 = r16
            java.lang.String r2 = "no download reason : not satisfy auto download condition"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r2)
            int r2 = com.adups.fota.b.d.c(r17)
            if (r2 != r7) goto L_0x0143
            com.adups.fota.f.e r2 = com.adups.fota.f.e.a()
            java.lang.String r3 = "down_status_cause_unauto"
            boolean r2 = r2.a((android.content.Context) r0, (java.lang.String) r3, (long) r12)
            if (r2 == 0) goto L_0x0143
            java.lang.String r2 = "cause_unauto"
            com.adups.fota.f.a.a(r0, r2, r10)
        L_0x0143:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.c.d.b(android.content.Context):void");
    }

    public int a() {
        return this.f1552b;
    }

    public void a(Context context) {
        synchronized (this) {
            LogUtil.a("");
            c.b().a(context);
            com.adups.fota.manager.d.d(context);
        }
    }

    private boolean a(boolean z) {
        boolean booleanValue = ((Boolean) c.a().a_shaKey_method2("install_forced", Boolean.class)).booleanValue();
        boolean booleanValue2 = ((Boolean) c.a().a_shaKey_method2("download_wifi", Boolean.class)).booleanValue();
        boolean booleanValue3 = ((Boolean) c.a().a_shaKey_method2("download_auto", Boolean.class)).booleanValue();
        LogUtil.a("isForced = " + booleanValue + "; isForcedWifi = " + booleanValue2 + "; autoDownload = " + booleanValue3);
        if ((booleanValue || booleanValue3) && !booleanValue2) {
            return true;
        }
        return (booleanValue || booleanValue3) && z;
    }

    private boolean a(Context context, boolean z, boolean z2) {
        boolean a2 = o.a(context, "download_wifi_auto", com.adups.fota.utils.c.j().t());
        boolean a3 = o.a(context, "download_only_wifi", com.adups.fota.utils.c.j().x());
        int c2 = com.adups.fota.b.d.c(context);
        LogUtil.a("isWifi = " + z + "; isWifiAuto = " + a2 + "; isOnlyWifi = " + a3);
        if (!z2 && c2 != 2) {
            return a2 && z;
        }
        if (!z) {
            return false;
        }
    }
}
