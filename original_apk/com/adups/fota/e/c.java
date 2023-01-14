package com.adups.fota.e;

import android.content.Context;
import android.text.TextUtils;
import com.adups.fota.MyApplication;
import com.adups.fota.b.a;
import com.adups.fota.b.d;
import com.adups.fota.bean.PolicyBean;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.manager.e;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.g;
import com.adups.fota.utils.i;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;
import java.util.HashMap;
import java.util.List;

/* compiled from: QueryInfo */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f1560a;

    /* renamed from: b  reason: collision with root package name */
    private String f1561b = "";

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, PolicyBean> f1562c = new HashMap<>();
    private VersionBean d;

    private c(Context context) {
        this.d = (VersionBean) i.a_shaKey_method2(g.a_shaKey_method2(context, a.f1540b), VersionBean.class);
        VersionBean versionBean = this.d;
        if (versionBean != null) {
            a(versionBean.getPolicy());
        }
    }

    public static c a() {
        if (f1560a == null) {
            synchronized (c.class) {
                if (f1560a == null) {
                    f1560a = new c(MyApplication.c());
                }
            }
        }
        return f1560a;
    }

    private void b(Context context) {
        String str = (String) a_shaKey_method2("download_path", String.class);
        if (!TextUtils.isEmpty(str) && str.contains("#")) {
            o.b(context, "ota_download_path", str);
            String[] split = str.split("#");
            if (split.length == 3) {
                t.a(split[0], split[1], split[2]);
            }
        }
    }

    public VersionBean c() {
        LogUtil.a("getVersionInfo,version=" + this.d);
        try {
            if (this.d == null) {
                this.d = (VersionBean) i.a_shaKey_method2(g.a_shaKey_method2(MyApplication.c(), a.f1540b), VersionBean.class);
                if (this.d != null) {
                    a(this.d.getPolicy());
                }
            }
        } catch (Exception e) {
            LogUtil.a("getVersionInfo,Exception e=" + e.getMessage());
            e.printStackTrace();
        }
        return this.d;
    }

    public void a(Context context, VersionBean versionBean) {
        synchronized (this) {
            if (versionBean != null) {
                this.d = versionBean;
                a(this.d.getPolicy());
                b(context);
            }
        }
    }

    public String b() {
        return this.f1561b;
    }

    public void a(Context context) {
        synchronized (this) {
            try {
                LogUtil.a("clear version txt");
                t.a_shaKey_method2(context, t.e(context));
                o.b(context, "update_package_path", "");
                e.a().a_shaKey_method2(context, 2131558451);
                e.a().a_shaKey_method2(context, 105);
                this.d = null;
                this.f1562c.clear();
                g.b(context.getFilesDir().getPath() + "/" + a.f1540b);
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                    g.b(context.getFilesDir().getPath() + "/" + a.f1540b);
                } catch (Throwable th) {
                    g.b(context.getFilesDir().getPath() + "/" + a.f1540b);
                    d.a_shaKey_method2(context, 0);
                    throw th;
                }
            }
            d.a_shaKey_method2(context, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T a(java.lang.String r4, java.lang.Class<T> r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            monitor-enter(r3)     // Catch:{ NumberFormatException -> 0x0066, Exception -> 0x0061 }
            java.util.HashMap<java.lang.String, com.adups.fota.bean.PolicyBean> r2 = r3.f1562c     // Catch:{ all -> 0x005e }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ all -> 0x005e }
            com.adups.fota.bean.PolicyBean r4 = (com.adups.fota.bean.PolicyBean) r4     // Catch:{ all -> 0x005e }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x001d
            if (r4 == 0) goto L_0x001a
            java.lang.String r4 = r4.getValue()     // Catch:{ all -> 0x005e }
            goto L_0x001b
        L_0x001a:
            r4 = r0
        L_0x001b:
            monitor-exit(r3)     // Catch:{ all -> 0x005e }
            return r4
        L_0x001d:
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0036
            if (r4 == 0) goto L_0x0030
            java.lang.String r4 = r4.getValue()     // Catch:{ all -> 0x005e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x005e }
            goto L_0x0034
        L_0x0030:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x005e }
        L_0x0034:
            monitor-exit(r3)     // Catch:{ all -> 0x005e }
            return r4
        L_0x0036:
            java.lang.Class<java.lang.Boolean> r2 = java.lang.Boolean.class
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005c
            if (r4 == 0) goto L_0x0056
            java.lang.String r4 = r4.getValue()     // Catch:{ all -> 0x005e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x005e }
            int r4 = r4.intValue()     // Catch:{ all -> 0x005e }
            r5 = 1
            if (r5 != r4) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r5 = 0
        L_0x0051:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x005e }
            goto L_0x005a
        L_0x0056:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x005e }
        L_0x005a:
            monitor-exit(r3)     // Catch:{ all -> 0x005e }
            return r4
        L_0x005c:
            monitor-exit(r3)     // Catch:{ all -> 0x005e }
            goto L_0x0065
        L_0x005e:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x005e }
            throw r4     // Catch:{ NumberFormatException -> 0x0066, Exception -> 0x0061 }
        L_0x0061:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0065:
            return r0
        L_0x0066:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.e.c.a(java.lang.String, java.lang.Class):java.lang.Object");
    }

    public String[] a(String str) {
        String[] strArr;
        synchronized (this) {
            PolicyBean policyBean = this.f1562c.get(str);
            if (policyBean != null) {
                if (policyBean.getValue() != null) {
                    strArr = policyBean.getValue().split("#");
                }
            }
            strArr = null;
        }
        return strArr;
    }

    private void a(List<PolicyBean> list) {
        if (list != null) {
            this.f1562c.clear();
            for (PolicyBean next : list) {
                this.f1562c.put(next.getKey(), next);
            }
            o.b(MyApplication.c(), "ota_install_result_pop", ((Boolean) a_shaKey_method2("install_result_pop", Boolean.class)).booleanValue());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ba A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(android.content.Context r9, boolean r10) {
        /*
            r8 = this;
            com.adups.fota.bean.VersionBean r0 = r8.c()
            r1 = 0
            if (r0 == 0) goto L_0x00a7
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            java.util.Locale r0 = r0.locale
            java.lang.String r0 = r0.getLanguage()
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            java.util.Locale r9 = r9.locale
            java.lang.String r9 = r9.getCountry()
            java.lang.String r2 = "zh"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x003f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "_"
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = r2.toString()
        L_0x003f:
            com.adups.fota.bean.VersionBean r9 = r8.d
            java.util.List r9 = r9.getReleaseNotes()
            if (r9 == 0) goto L_0x00a7
            int r2 = r9.size()
            if (r2 <= 0) goto L_0x00a7
            int r2 = r9.size()
            java.lang.String r3 = "#434343"
            java.lang.String r4 = "#FFFFFF"
            r5 = 1
            r6 = 0
            if (r2 != r5) goto L_0x0074
            java.lang.Object r0 = r9.get(r6)
            com.adups.fota.bean.LanguageBean r0 = (com.adups.fota.bean.LanguageBean) r0
            java.lang.String r0 = r0.getCountry()
            r8.f1561b = r0
            java.lang.Object r9 = r9.get(r6)
            com.adups.fota.bean.LanguageBean r9 = (com.adups.fota.bean.LanguageBean) r9
            java.lang.String r9 = r9.getContent()
            java.lang.String r9 = r9.replaceAll(r4, r3)
            goto L_0x00a8
        L_0x0074:
            r5 = 0
        L_0x0075:
            if (r5 >= r2) goto L_0x008b
            java.lang.Object r7 = r9.get(r5)
            com.adups.fota.bean.LanguageBean r7 = (com.adups.fota.bean.LanguageBean) r7
            java.lang.String r7 = r7.getCountry()
            boolean r7 = r0.contains(r7)
            if (r7 == 0) goto L_0x0088
            goto L_0x008c
        L_0x0088:
            int r5 = r5 + 1
            goto L_0x0075
        L_0x008b:
            r5 = 0
        L_0x008c:
            java.lang.Object r0 = r9.get(r5)
            com.adups.fota.bean.LanguageBean r0 = (com.adups.fota.bean.LanguageBean) r0
            java.lang.String r0 = r0.getCountry()
            r8.f1561b = r0
            java.lang.Object r9 = r9.get(r5)
            com.adups.fota.bean.LanguageBean r9 = (com.adups.fota.bean.LanguageBean) r9
            java.lang.String r9 = r9.getContent()
            java.lang.String r9 = r9.replaceAll(r4, r3)
            goto L_0x00a8
        L_0x00a7:
            r9 = r1
        L_0x00a8:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x00ba
            if (r10 == 0) goto L_0x00b1
            return r9
        L_0x00b1:
            android.text.Spanned r9 = android.text.Html.fromHtml(r9)
            java.lang.String r9 = r9.toString()
            return r9
        L_0x00ba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.e.c.a(android.content.Context, boolean):java.lang.String");
    }
}
