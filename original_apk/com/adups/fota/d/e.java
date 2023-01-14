package com.adups.fota.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.adups.fota.activity.InstallResultActivity;
import com.adups.fota.b.a;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.o;

/* compiled from: InstallResult */
public class e {
    private static boolean a(Context context, boolean z) {
        if (z) {
            return o.a(context, "ota_install_result_pop", false);
        }
        if (o.a(context, "noPopWinFlag", 1) == 0) {
            return true;
        }
        return false;
    }

    static void b(Context context) {
        o.b(context, "ota_install_fail_count", o.a(context, "ota_install_fail_count", 0) + 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(android.content.Context r7) {
        /*
            java.lang.Class<com.adups.fota.d.e> r0 = com.adups.fota.d.e.class
            monitor-enter(r0)
            java.lang.String r1 = "ota_enter_recovery"
            boolean r1 = com.adups.fota.utils.o.a(r7, r1)     // Catch:{ all -> 0x00b4 }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = "ota_enter_recovery"
            int r1 = com.adups.fota.utils.u.a(r1, r3)     // Catch:{ all -> 0x00b4 }
            if (r1 != r2) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            int r4 = com.adups.fota.b.d.c(r7)     // Catch:{ all -> 0x00b4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r5.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r6 = "install verify,rebootRecovery : "
            r5.append(r6)     // Catch:{ all -> 0x00b4 }
            r5.append(r1)     // Catch:{ all -> 0x00b4 }
            java.lang.String r6 = " ,status : "
            r5.append(r6)     // Catch:{ all -> 0x00b4 }
            r5.append(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00b4 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r5)     // Catch:{ all -> 0x00b4 }
            if (r1 != 0) goto L_0x003e
            r5 = 6
            if (r4 != r5) goto L_0x00b2
        L_0x003e:
            boolean r4 = a(r7)     // Catch:{ all -> 0x00b4 }
            b(r7, r4)     // Catch:{ all -> 0x00b4 }
            if (r1 != 0) goto L_0x0055
            java.lang.String r5 = "ota_original_version"
            java.lang.String r6 = ""
            com.adups.fota.utils.o.b((android.content.Context) r7, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "ota_update_version"
            java.lang.String r6 = ""
            com.adups.fota.utils.o.b((android.content.Context) r7, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x00b4 }
        L_0x0055:
            java.lang.String r5 = "ota_enter_recovery"
            com.adups.fota.utils.o.b((android.content.Context) r7, (java.lang.String) r5, (boolean) r3)     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "ota_enter_recovery"
            com.adups.fota.utils.u.b(r5, r3)     // Catch:{ all -> 0x00b4 }
            com.adups.fota.e.c r5 = com.adups.fota.e.c.a()     // Catch:{ all -> 0x00b4 }
            r5.a((android.content.Context) r7)     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = "notifyFlag"
            int r5 = com.adups.fota.utils.o.a((android.content.Context) r7, (java.lang.String) r5, (int) r3)     // Catch:{ all -> 0x00b4 }
            if (r2 != r5) goto L_0x0071
            com.adups.fota.manager.d.c(r7, r2)     // Catch:{ all -> 0x00b4 }
        L_0x0071:
            java.lang.String r2 = "ota_update_type"
            r5 = -1
            int r2 = com.adups.fota.utils.o.a((android.content.Context) r7, (java.lang.String) r2, (int) r5)     // Catch:{ all -> 0x00b4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r5.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r6 = "FOTA_UPDATE_TYPE = "
            r5.append(r6)     // Catch:{ all -> 0x00b4 }
            r5.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00b4 }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r2)     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x00aa
            com.adups.fota.b.d.a((android.content.Context) r7, (int) r3)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = "ota_original_version"
            com.adups.fota.utils.c r3 = com.adups.fota.utils.c.j()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = r3.k()     // Catch:{ all -> 0x00b4 }
            com.adups.fota.utils.o.b((android.content.Context) r7, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00b4 }
            boolean r2 = a(r7, r1)     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x00a7
            d(r7)     // Catch:{ all -> 0x00b4 }
        L_0x00a7:
            com.adups.fota.manager.f.r()     // Catch:{ all -> 0x00b4 }
        L_0x00aa:
            c(r7, r4)     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x00b2
            e(r7)     // Catch:{ all -> 0x00b4 }
        L_0x00b2:
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            return r1
        L_0x00b4:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b4 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.d.e.c(android.content.Context):boolean");
    }

    private static void d(Context context) {
        LogUtil.a("forward InstallResultActivity");
        String k = c.j().k();
        Intent intent = new Intent(context, InstallResultActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("version", k);
        context.startActivity(intent);
    }

    private static void e(Context context) {
        if (c.j().A()) {
            LogUtil.a("sendUpdateSuccessBroadcast");
            Intent intent = new Intent();
            intent.setAction(a.g);
            intent.addFlags(268435456);
            context.sendBroadcast(intent, a.i);
        }
    }

    public static boolean a(Context context) {
        String k = c.j().k();
        String a2 = o.a(context, "ota_original_version", "");
        LogUtil.a("oldVersion = " + a2 + ";deviceVersion = " + k);
        return !TextUtils.isEmpty(a2) && !a2.equalsIgnoreCase(k);
    }

    private static void b(Context context, boolean z) {
        LogUtil.a("install report,install success:" + z);
        com.adups.fota.f.a.a(context, z, z ? 413 : 414, (String) null);
    }

    private static void c(Context context, boolean z) {
        int a2 = o.a(context, "ota_install_fail_count", 0);
        if (!z) {
            o.b(context, "ota_install_fail_count", a2 + 1);
        }
    }
}
