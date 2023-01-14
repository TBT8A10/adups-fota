package com.adups.fota.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.adups.fota.b.b;
import com.adups.fota.bean.ReportBean;
import com.adups.fota.g.d;
import com.adups.fota.manager.c;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.i;
import com.adups.fota.utils.l;
import com.adups.fota.utils.o;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ReportManager */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f1579a;

    private e() {
    }

    private void b(Context context) {
        List<ReportBean> b2 = c.c().b();
        if (b2 != null && !b2.isEmpty()) {
            LogUtil.a("record items size = " + b2.size());
            ArrayList arrayList = new ArrayList();
            for (ReportBean next : b2) {
                if (next.getAction().equalsIgnoreCase("fcm")) {
                    a_shaKey_method2(context, (Map<String, String>) (Map) i.a(next.getResult()));
                }
                arrayList.add(next.getResult());
            }
            String str = o.a(context, "check_url", b.f1542a) + b.h;
            Request build = new Request.Builder().url(str).post(d.a(context, arrayList, true)).build();
            LogUtil.a("http URL = " + str);
            l.a_shaKey_method2(build, new b(this));
        }
    }

    private void c(Context context) {
        b(context);
    }

    public static e a() {
        if (f1579a == null) {
            synchronized (e.class) {
                if (f1579a == null) {
                    f1579a = new e();
                }
            }
        }
        return f1579a;
    }

    public void a(Context context) {
        if (!a(context, "scheduleReportData", 7200000)) {
            LogUtil.a("not arrive report data schedule!");
        } else {
            c(context);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        LogUtil.a("insert data to db, type = " + str + "; result = " + str2);
        c.c().a_shaKey_method2(str, str2);
    }

    public void a(Context context, String str, String str2, boolean z) {
        LogUtil.a("type = " + str + "; result = " + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        String str3 = o.a(context, "check_url", b.f1542a) + b.h;
        Request build = new Request.Builder().url(str3).post(d.a(context, arrayList, z)).build();
        LogUtil.a("http URL = " + str3);
        l.a_shaKey_method2(build, new c(this, str, str2));
    }

    public void a(Context context, Map<String, String> map) {
        if (map != null) {
            d.a_shaKey_method2(context, map);
            a_shaKey_method2(o.a(context, "check_url", b.f1542a) + b.i, map);
        }
    }

    private void a(String str, Map<String, String> map) {
        if (map != null) {
            MultipartBuilder multipartBuilder = new MultipartBuilder();
            for (Map.Entry next : map.entrySet()) {
                String str2 = (String) next.getKey();
                if (str2.equalsIgnoreCase("log")) {
                    multipartBuilder.addFormDataPart(str2, "log.txt", RequestBody.create(MediaType.parse("text/plain"), new File((String) next.getValue())));
                } else {
                    multipartBuilder.addFormDataPart(str2, (String) next.getValue());
                }
            }
            Request build = new Request.Builder().url(str).post(multipartBuilder.build()).build();
            LogUtil.a("http URL = " + str);
            l.a_shaKey_method2(build, new d(this, map));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(android.content.Context r10, java.lang.String r11, long r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003b }
            java.lang.String r2 = "runstats"
            r3 = 0
            android.content.SharedPreferences r2 = r10.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x003b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r4.<init>()     // Catch:{ all -> 0x003b }
            r4.append(r11)     // Catch:{ all -> 0x003b }
            java.lang.String r5 = "CHECKTIME"
            r4.append(r5)     // Catch:{ all -> 0x003b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x003b }
            r5 = 0
            long r7 = r2.getLong(r4, r5)     // Catch:{ all -> 0x003b }
            long r0 = r0 - r7
            r2 = 1
            int r4 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x002e
            r9.a((android.content.Context) r10, (java.lang.String) r11)     // Catch:{ all -> 0x003b }
            monitor-exit(r9)
            return r2
        L_0x002e:
            int r4 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r2 = 0
        L_0x0034:
            if (r2 == 0) goto L_0x0039
            r9.a((android.content.Context) r10, (java.lang.String) r11)     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r9)
            return r2
        L_0x003b:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.f.e.a(android.content.Context, java.lang.String, long):boolean");
    }

    private synchronized void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = context.getSharedPreferences("runstats", 0).edit();
        edit.putLong(str + "CHECKTIME", currentTimeMillis);
        edit.apply();
    }
}
