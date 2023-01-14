package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.b.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1963a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f1964b = e();

    /* renamed from: c  reason: collision with root package name */
    private static final Method f1965c = f();
    private static final Method d = g();
    private static final Method e = a();
    private static final Method f = b();
    private static final Method g = c();
    private static final Method h = d();

    private static WorkSource a(int i, String str) {
        WorkSource workSource = new WorkSource();
        a(workSource, i, str);
        return workSource;
    }

    private static int b(WorkSource workSource) {
        Method method = d;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    private static final Method c() {
        if (j.i()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static final Method d() {
        if (j.i()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
            }
        }
        return null;
    }

    private static Method e() {
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method f() {
        if (j.d()) {
            try {
                return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method g() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static WorkSource a(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo a2 = b.a(context).a_shaKey_method2(str, 0);
                if (a2 != null) {
                    return a_shaKey_method2(a2.uid, str);
                }
                String valueOf = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                String valueOf2 = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            }
        }
        return null;
    }

    private static Method b() {
        if (j.d()) {
            try {
                return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static void a(WorkSource workSource, int i, String str) {
        if (f1965c != null) {
            if (str == null) {
                str = "";
            }
            try {
                f1965c.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        } else {
            Method method = f1964b;
            if (method != null) {
                try {
                    method.invoke(workSource, new Object[]{Integer.valueOf(i)});
                } catch (Exception e3) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                }
            }
        }
    }

    private static String a(WorkSource workSource, int i) {
        Method method = f;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i)});
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    public static List<String> a(WorkSource workSource) {
        int b2 = workSource == null ? 0 : b(workSource);
        if (b2 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b2; i++) {
            String a2 = a_shaKey_method2(workSource, i);
            if (!l.a(a2)) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public static boolean a(Context context) {
        if (context == null || context.getPackageManager() == null || b.a(context).a_shaKey_method2("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    private static Method a() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception unused) {
            return null;
        }
    }
}
