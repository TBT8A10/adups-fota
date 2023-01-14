package com.adups.fota.d;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.e.c;
import com.adups.fota.f.a;
import com.adups.fota.manager.b;
import com.adups.fota.manager.e;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.g;
import com.adups.fota.utils.n;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;
import com.adups.fota.utils.u;
import java.io.File;
import java.util.Calendar;

/* compiled from: Install */
public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1558a = false;

    public static void b(Context context) {
        int i;
        if (!a()) {
            LogUtil.a("not support ab update,no need force_reboot");
            return;
        }
        String[] a2 = c.a().a("install_time");
        if (com.adups.fota.b.d.c(context) != 6) {
            a.a_shaKey_method2(context, "reboot_cause_not_dlcomplete");
        } else if (((Boolean) c.a().a_shaKey_method2("install_forced", Boolean.class)).booleanValue()) {
            int i2 = 0;
            try {
                int intValue = Integer.valueOf(a2[0]).intValue();
                i = Integer.valueOf(a2[1]).intValue();
                if (intValue > i) {
                    i += 24;
                }
                i2 = intValue;
            } catch (Exception unused) {
                i = 24;
            }
            int a3 = a_shaKey_method2(i2, i);
            if (com.adups.fota.utils.c.j().h(context) || a3 != 0) {
                a.a_shaKey_method2(context, "reboot_cause_not_right_time");
                a(context, a3, i2, i);
                return;
            }
            LogUtil.a("[force_update] time arrive start force update");
            a.a_shaKey_method2(context, "auto_reboot");
            com.adups.fota.h.c.a().a(context);
        } else {
            a.a_shaKey_method2(context, "cause_not_force_reboot");
        }
    }

    public static void c(Context context) {
        int i;
        String[] a2 = c.a().a("install_time");
        if (com.adups.fota.b.d.c(context) != 4) {
            LogUtil.a("no force update reason : status not correct");
            a.a_shaKey_method2(context, "cause_not_dlcomplete");
            return;
        }
        int i2 = 0;
        try {
            int intValue = Integer.valueOf(a2[0]).intValue();
            i = Integer.valueOf(a2[1]).intValue();
            if (intValue > i) {
                i += 24;
            }
            i2 = intValue;
        } catch (Exception unused) {
            i = 24;
        }
        int a3 = a_shaKey_method2(i2, i);
        if (!f(context) || a3 != 0) {
            LogUtil.a("no force update reason : ota battery low or no in hour range");
            a.a_shaKey_method2(context, "cause_not_right_time");
            b(context, a3, i2, i);
            return;
        }
        LogUtil.a("time arrive start force update");
        a.a_shaKey_method2(context, "auto");
        e(context);
    }

    public static void d(Context context) {
        if (com.adups.fota.b.d.c(context) == 4) {
            int intValue = ((Integer) c.a().a_shaKey_method2("install_notice_type", Integer.class)).intValue();
            boolean booleanValue = ((Boolean) c.a().a_shaKey_method2("install_notice_resident", Boolean.class)).booleanValue();
            LogUtil.a("installDelay notice : notice_type = " + intValue + "; notice_resident = " + booleanValue);
            if (intValue == 0) {
                long c2 = o.c(context, "ota_install_delay_schedule");
                if (c2 > 0) {
                    b.a_shaKey_method2(context, c2 + System.currentTimeMillis());
                }
                e.a().a_shaKey_method2(context, booleanValue);
            }
            com.adups.fota.manager.d.b(context, 4);
        }
    }

    public static void e(Context context) {
        if (n.a(Process.myUid()) != 0) {
            LogUtil.a("no update reason : not system user");
        } else if (f1558a) {
            a.a_shaKey_method2(context, "cause_installing");
        } else {
            if (a()) {
                org.greenrobot.eventbus.e.a().b(new EventMessage(300, 100, 0, 5, "ab"));
            }
            f1558a = true;
            LogUtil.a("ota install update start");
            new Thread(new c(context)).start();
        }
    }

    private static boolean f(Context context) {
        int f = com.adups.fota.utils.c.j().f(context);
        boolean h = com.adups.fota.utils.c.j().h(context);
        int a2 = com.adups.fota.utils.c.j().a();
        LogUtil.a("realBattery = " + f + "; limitBattery = " + a2 + "; isScreenOn = " + h);
        return f >= a2 && (!h || com.adups.fota.utils.c.j().y());
    }

    /* access modifiers changed from: private */
    public static void g(Context context) {
        a aVar;
        int i;
        if (a()) {
            org.greenrobot.eventbus.e.a().b(new EventMessage(300, 100, 0, 602, "ab"));
        }
        String str = null;
        VersionBean c2 = c.a().c();
        if (c2 != null) {
            str = c2.getSha();
        }
        if (TextUtils.isEmpty(str)) {
            aVar = new g();
        } else {
            aVar = new f();
        }
        try {
            i = aVar.a(context, t.d(context), str);
        } catch (Exception unused) {
            a.a_shaKey_method2(context, "cause_verify_exception");
            i = 0;
        }
        LogUtil.a("verify package status = " + i);
        if (i == 405) {
            String d = t.d(context);
            File file = new File("/data/media/0/adupsfota/update.zip");
            File file2 = new File("/data/media/adupsfota/update.zip");
            File file3 = new File("/storage/emulated/0/adupsfota/update.zip");
            t.a(t.a_shaKey_method2(context, false));
            if (Build.VERSION.SDK_INT < 21) {
                d = t.d(context);
            } else if (file.exists()) {
                LogUtil.a("update1File = " + file.getPath());
                if (g.a("/data/media/0/adupsfota/update.zip", com.adups.fota.b.a.e, (Boolean) true)) {
                    d = com.adups.fota.b.a.e;
                }
            } else if (file2.exists()) {
                LogUtil.a("update2File = " + file2.getPath());
                if (g.a("/data/media/adupsfota/update.zip", com.adups.fota.b.a.e, (Boolean) true)) {
                    d = com.adups.fota.b.a.e;
                }
            } else if (file3.exists()) {
                LogUtil.a("update4File = " + file3.getPath());
                if (g.a("/storage/emulated/0/adupsfota/update.zip", com.adups.fota.b.a.e, (Boolean) true)) {
                    d = com.adups.fota.b.a.e;
                }
            } else {
                d = t.d(context);
            }
            LogUtil.a("updatePath = " + d);
            if (c2 != null) {
                o.b(context, "ota_update_version", c2.getVersionName());
                o.b(context, "ota_install_result_pop", ((Boolean) c.a().a_shaKey_method2("install_result_pop", Boolean.class)).booleanValue());
                o.b(context, "notifyFlag", ((Integer) c.a().a_shaKey_method2("query_notice_type", Integer.class)).intValue());
            }
            o.b(context, "ota_update_local", false);
            a_shaKey_method2(context, d);
        } else {
            LogUtil.a("no install reason : status not correct");
            com.adups.fota.manager.d.c(context, 1);
            c.a().a(context);
            a.a(context, false, i, aVar.a());
        }
        org.greenrobot.eventbus.e.a().b(new EventMessage(300, i, 0, 0, (Object) null));
    }

    public static void a(Context context, String str) {
        if (!a()) {
            com.adups.fota.b.d.a_shaKey_method2(context, 6);
            e.a().a_shaKey_method2(context, 105);
            u.b("recovery_from_third", 1);
        }
        LogUtil.a("update file path = " + str);
        t.f(context);
        new Thread(new b(context, str)).start();
    }

    public static boolean a() {
        return com.adups.fota.utils.c.j().E();
    }

    private static int a(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(currentTimeMillis);
        int i3 = instance.get(11);
        LogUtil.a("startTime = " + i + "; endTime = " + i2 + "; hour = " + i3);
        if (i3 < i) {
            return -1;
        }
        return i3 >= i2 ? 1 : 0;
    }

    private static void a(Context context, int i, int i2, int i3) {
        LogUtil.a("[forceRebootAlarm] isHourRange,startTime,endTime ===" + i + "||" + i2 + "||" + i3);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        if (i == -1) {
            instance.set(11, i2);
            instance.set(12, 0);
        } else if (i == 1) {
            instance.add(5, 1);
            instance.set(11, i2);
            instance.set(12, 0);
        } else {
            instance.set(12, instance.get(12) + 10);
        }
        LogUtil.a("[forceUpdateAlarm] force time " + instance.getTimeInMillis());
        b.c(context, instance.getTimeInMillis());
    }

    private static void b(Context context, int i, int i2, int i3) {
        LogUtil.a("isHourRange = " + i + "; startTime = " + i2 + "; endTime = " + i3);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        if (i == -1) {
            instance.set(11, i2);
            instance.set(12, 0);
        } else if (i == 1) {
            instance.add(5, 1);
            instance.set(11, i2);
            instance.set(12, 0);
        } else {
            instance.set(12, instance.get(12) + 10);
        }
        LogUtil.a("force time " + instance.getTimeInMillis());
        b.b(context, instance.getTimeInMillis());
    }

    public static boolean a(Context context, int i) {
        return com.adups.fota.utils.c.j().f(context) >= i;
    }

    public static boolean b(Context context, String str) {
        VersionBean c2 = c.a().c();
        if (c2 != null && c2.getIsOldPkg() == 1) {
            return true;
        }
        double d = (double) g.d(str);
        Double.isNaN(d);
        if (3 == t.d(context, (long) (d * 1.5d))) {
            return true;
        }
        return false;
    }
}
