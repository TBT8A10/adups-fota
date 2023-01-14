package com.adups.fota.c;

import android.content.Context;
import android.text.TextUtils;
import com.adups.fota.C0216R$string;
import com.adups.fota.MyApplication;
import com.adups.fota.b.d;
import com.adups.fota.bean.DownloadBean;
import com.adups.fota.bean.EventMessage;
import com.adups.fota.bean.VersionBean;
import com.adups.fota.f.a;
import com.adups.fota.manager.e;
import com.adups.fota.manager.f;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.l;
import com.adups.fota.utils.o;
import com.adups.fota.utils.t;
import java.io.File;
import java.lang.Thread;

/* compiled from: DownPackage */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f1548a;

    /* renamed from: b  reason: collision with root package name */
    private VersionBean f1549b;

    /* renamed from: c  reason: collision with root package name */
    private Thread f1550c = null;
    private int d = f.e();
    private boolean e;
    private DownloadBean f = new DownloadBean();
    private l g = null;

    private c() {
        this.f.setRetryCount(3);
        if (this.g == null) {
            this.g = new l();
        }
        if (this.f1550c == null) {
            this.f1550c = new Thread(new a(this));
        }
    }

    public static c b() {
        if (f1548a == null) {
            synchronized (c.class) {
                if (f1548a == null) {
                    f1548a = new c();
                }
            }
        }
        return f1548a;
    }

    private void c(Context context) {
        LogUtil.a("download is completed");
        j();
        this.d = 0;
        f.a(0);
        d.f(context);
        a.a(context, "finish", i());
        d.b(context);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01eb, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01f1, code lost:
        r16 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r0.close();
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0207, code lost:
        if (r1.f.getDownloadTotalSize() != r1.f.getTagFileSize()) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0209, code lost:
        r1.f.setDownloadTotalSize(0);
        g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0212, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        com.adups.fota.utils.LogUtil.b("download failed!!");
        a("download failed!!");
        r2 = r16;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void f() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            r17.d()     // Catch:{ all -> 0x02be }
            r2 = 0
            r0 = 0
        L_0x0008:
            com.adups.fota.bean.DownloadBean r3 = r1.f     // Catch:{ all -> 0x02be }
            int r3 = r3.getRetryCount()     // Catch:{ all -> 0x02be }
            if (r0 >= r3) goto L_0x02bc
            int r3 = r0 + 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02be }
            r0.<init>()     // Catch:{ all -> 0x02be }
            java.lang.String r4 = "retry = "
            r0.append(r4)     // Catch:{ all -> 0x02be }
            r0.append(r3)     // Catch:{ all -> 0x02be }
            java.lang.String r4 = "; max retry = "
            r0.append(r4)     // Catch:{ all -> 0x02be }
            com.adups.fota.bean.DownloadBean r4 = r1.f     // Catch:{ all -> 0x02be }
            int r4 = r4.getRetryCount()     // Catch:{ all -> 0x02be }
            r0.append(r4)     // Catch:{ all -> 0x02be }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02be }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)     // Catch:{ all -> 0x02be }
            com.adups.fota.utils.l r0 = r1.g     // Catch:{ all -> 0x02be }
            if (r0 == 0) goto L_0x02b7
            com.adups.fota.bean.DownloadBean r0 = r1.f     // Catch:{ Exception -> 0x023f }
            com.adups.fota.utils.l r4 = r1.g     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r5 = r1.f     // Catch:{ Exception -> 0x023f }
            java.lang.String r5 = r5.getDownloadUrl()     // Catch:{ Exception -> 0x023f }
            long r4 = r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x023f }
            r0.setTagFileSize(r4)     // Catch:{ Exception -> 0x023f }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x023f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023f }
            r4.<init>()     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r5 = r1.f     // Catch:{ Exception -> 0x023f }
            java.lang.String r5 = r5.getDownloadDir()     // Catch:{ Exception -> 0x023f }
            r4.append(r5)     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r5 = r1.f     // Catch:{ Exception -> 0x023f }
            java.lang.String r5 = r5.getDownloadFileName()     // Catch:{ Exception -> 0x023f }
            r4.append(r5)     // Catch:{ Exception -> 0x023f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x023f }
            r0.<init>(r4)     // Catch:{ Exception -> 0x023f }
            boolean r4 = r0.isFile()     // Catch:{ Exception -> 0x023f }
            if (r4 == 0) goto L_0x00b6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023f }
            r4.<init>()     // Catch:{ Exception -> 0x023f }
            java.lang.String r5 = "download size = "
            r4.append(r5)     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r5 = r1.f     // Catch:{ Exception -> 0x023f }
            long r5 = r5.getDownloadTotalSize()     // Catch:{ Exception -> 0x023f }
            r4.append(r5)     // Catch:{ Exception -> 0x023f }
            java.lang.String r5 = "; file size = "
            r4.append(r5)     // Catch:{ Exception -> 0x023f }
            long r5 = r0.length()     // Catch:{ Exception -> 0x023f }
            r4.append(r5)     // Catch:{ Exception -> 0x023f }
            java.lang.String r5 = "; isInterrupted = "
            r4.append(r5)     // Catch:{ Exception -> 0x023f }
            java.lang.Thread r5 = r1.f1550c     // Catch:{ Exception -> 0x023f }
            boolean r5 = r5.isInterrupted()     // Catch:{ Exception -> 0x023f }
            r4.append(r5)     // Catch:{ Exception -> 0x023f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x023f }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r4)     // Catch:{ Exception -> 0x023f }
            long r4 = r0.length()     // Catch:{ Exception -> 0x023f }
            r6 = 8192(0x2000, double:4.0474E-320)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x00b6
            com.adups.fota.bean.DownloadBean r4 = r1.f     // Catch:{ Exception -> 0x023f }
            long r5 = r0.length()     // Catch:{ Exception -> 0x023f }
            r4.setDownloadTotalSize(r5)     // Catch:{ Exception -> 0x023f }
        L_0x00b6:
            com.adups.fota.bean.DownloadBean r0 = r1.f     // Catch:{ Exception -> 0x023f }
            long r4 = r0.getTagFileSize()     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r0 = r1.f     // Catch:{ Exception -> 0x023f }
            long r6 = r0.getDownloadTotalSize()     // Catch:{ Exception -> 0x023f }
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x00d0
            java.lang.String r0 = ""
            com.adups.fota.utils.LogUtil.a((java.lang.String) r0)     // Catch:{ Exception -> 0x023f }
            r17.g()     // Catch:{ Exception -> 0x023f }
            monitor-exit(r17)
            return
        L_0x00d0:
            com.adups.fota.utils.l r0 = r1.g     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r4 = r1.f     // Catch:{ Exception -> 0x023f }
            java.lang.String r4 = r4.getDownloadUrl()     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r5 = r1.f     // Catch:{ Exception -> 0x023f }
            long r5 = r5.getDownloadTotalSize()     // Catch:{ Exception -> 0x023f }
            r7 = -1
            java.io.InputStream r0 = r0.a(r4, r5, r7)     // Catch:{ Exception -> 0x023f }
            if (r0 == 0) goto L_0x0221
            r4 = 1
            r1.e = r4     // Catch:{ Exception -> 0x023f }
            long r5 = r17.h()     // Catch:{ Exception -> 0x023f }
            com.adups.fota.manager.f.a((long) r5)     // Catch:{ Exception -> 0x023f }
            org.greenrobot.eventbus.e r5 = org.greenrobot.eventbus.e.a()     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.EventMessage r6 = new com.adups.fota.bean.EventMessage     // Catch:{ Exception -> 0x023f }
            r9 = 200(0xc8, float:2.8E-43)
            r10 = 1000(0x3e8, float:1.401E-42)
            r11 = 0
            r13 = 0
            r15 = 0
            r8 = r6
            r8.<init>(r9, r10, r11, r13, r15)     // Catch:{ Exception -> 0x023f }
            r5.b(r6)     // Catch:{ Exception -> 0x023f }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x023f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023f }
            r6.<init>()     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r8 = r1.f     // Catch:{ Exception -> 0x023f }
            java.lang.String r8 = r8.getDownloadDir()     // Catch:{ Exception -> 0x023f }
            r6.append(r8)     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r8 = r1.f     // Catch:{ Exception -> 0x023f }
            java.lang.String r8 = r8.getDownloadFileName()     // Catch:{ Exception -> 0x023f }
            r6.append(r8)     // Catch:{ Exception -> 0x023f }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x023f }
            java.lang.String r8 = "rwd"
            r5.<init>(r6, r8)     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r6 = r1.f     // Catch:{ Exception -> 0x023f }
            long r8 = r6.getDownloadTotalSize()     // Catch:{ Exception -> 0x023f }
            r5.seek(r8)     // Catch:{ Exception -> 0x023f }
            r6 = 8192(0x2000, float:1.14794E-41)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x023f }
            r8 = 0
            r10 = r8
        L_0x0137:
            int r12 = r0.read(r6)     // Catch:{ Exception -> 0x023f }
            if (r12 == r7) goto L_0x01f1
            java.lang.Thread r13 = r1.f1550c     // Catch:{ Exception -> 0x023f }
            boolean r13 = r13.isInterrupted()     // Catch:{ Exception -> 0x023f }
            if (r13 == 0) goto L_0x0157
            java.lang.String r4 = "mThread interrupted"
            com.adups.fota.utils.LogUtil.a((java.lang.String) r4)     // Catch:{ Exception -> 0x023f }
            r0.close()     // Catch:{ Exception -> 0x023f }
            r5.close()     // Catch:{ Exception -> 0x023f }
            java.lang.String r0 = ""
            r1.a((java.lang.String) r0)     // Catch:{ Exception -> 0x023f }
            monitor-exit(r17)
            return
        L_0x0157:
            r5.write(r6, r2, r12)     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r13 = r1.f     // Catch:{ Exception -> 0x023f }
            com.adups.fota.bean.DownloadBean r14 = r1.f     // Catch:{ Exception -> 0x023f }
            long r14 = r14.getDownloadTotalSize()     // Catch:{ Exception -> 0x023f }
            r16 = r3
            long r2 = (long) r12
            long r14 = r14 + r2
            r13.setDownloadTotalSize(r14)     // Catch:{ Exception -> 0x023b }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x023b }
            long r2 = r2 - r10
            r12 = 1000(0x3e8, double:4.94E-321)
            int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x01ec
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x023b }
            r2 = 100
            com.adups.fota.bean.DownloadBean r12 = r1.f     // Catch:{ Exception -> 0x023b }
            long r12 = r12.getDownloadTotalSize()     // Catch:{ Exception -> 0x023b }
            long r12 = r12 * r2
            com.adups.fota.bean.DownloadBean r2 = r1.f     // Catch:{ Exception -> 0x023b }
            long r2 = r2.getTagFileSize()     // Catch:{ Exception -> 0x023b }
            long r12 = r12 / r2
            java.lang.Long r2 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x023b }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x023b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023b }
            r3.<init>()     // Catch:{ Exception -> 0x023b }
            java.lang.String r12 = "download size = "
            r3.append(r12)     // Catch:{ Exception -> 0x023b }
            com.adups.fota.bean.DownloadBean r12 = r1.f     // Catch:{ Exception -> 0x023b }
            long r12 = r12.getDownloadTotalSize()     // Catch:{ Exception -> 0x023b }
            r3.append(r12)     // Catch:{ Exception -> 0x023b }
            java.lang.String r12 = "/"
            r3.append(r12)     // Catch:{ Exception -> 0x023b }
            com.adups.fota.bean.DownloadBean r12 = r1.f     // Catch:{ Exception -> 0x023b }
            long r12 = r12.getTagFileSize()     // Catch:{ Exception -> 0x023b }
            r3.append(r12)     // Catch:{ Exception -> 0x023b }
            java.lang.String r12 = ",,state="
            r3.append(r12)     // Catch:{ Exception -> 0x023b }
            java.lang.Thread r12 = r1.f1550c     // Catch:{ Exception -> 0x023b }
            java.lang.Thread$State r12 = r12.getState()     // Catch:{ Exception -> 0x023b }
            r3.append(r12)     // Catch:{ Exception -> 0x023b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x023b }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r3)     // Catch:{ Exception -> 0x023b }
            r1.e = r4     // Catch:{ Exception -> 0x023b }
            if (r2 < 0) goto L_0x01ea
            r3 = 100
            if (r2 <= r3) goto L_0x01d0
            goto L_0x01ea
        L_0x01d0:
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x023b }
            com.adups.fota.utils.LogUtil.a((java.lang.String) r3)     // Catch:{ Exception -> 0x023b }
            int r3 = r17.c()     // Catch:{ Exception -> 0x023b }
            if (r2 >= r3) goto L_0x01df
            monitor-exit(r17)
            return
        L_0x01df:
            r1.a((int) r2)     // Catch:{ Exception -> 0x023b }
            android.content.Context r2 = com.adups.fota.MyApplication.c()     // Catch:{ Exception -> 0x023b }
            r1.d(r2)     // Catch:{ Exception -> 0x023b }
            goto L_0x01ec
        L_0x01ea:
            monitor-exit(r17)
            return
        L_0x01ec:
            r3 = r16
            r2 = 0
            goto L_0x0137
        L_0x01f1:
            r16 = r3
            r0.close()     // Catch:{ Exception -> 0x023b }
            r5.close()     // Catch:{ Exception -> 0x023b }
            com.adups.fota.bean.DownloadBean r0 = r1.f     // Catch:{ Exception -> 0x023b }
            long r2 = r0.getDownloadTotalSize()     // Catch:{ Exception -> 0x023b }
            com.adups.fota.bean.DownloadBean r0 = r1.f     // Catch:{ Exception -> 0x023b }
            long r4 = r0.getTagFileSize()     // Catch:{ Exception -> 0x023b }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0213
            com.adups.fota.bean.DownloadBean r0 = r1.f     // Catch:{ Exception -> 0x023b }
            r0.setDownloadTotalSize(r8)     // Catch:{ Exception -> 0x023b }
            r17.g()     // Catch:{ Exception -> 0x023b }
            monitor-exit(r17)
            return
        L_0x0213:
            java.lang.String r0 = "download failed!!"
            com.adups.fota.utils.LogUtil.b((java.lang.String) r0)     // Catch:{ Exception -> 0x023b }
            java.lang.String r0 = "download failed!!"
            r1.a((java.lang.String) r0)     // Catch:{ Exception -> 0x023b }
            r2 = r16
            goto L_0x02b8
        L_0x0221:
            r16 = r3
            com.adups.fota.bean.DownloadBean r0 = r1.f     // Catch:{ Exception -> 0x023b }
            int r0 = r0.getRetryCount()     // Catch:{ Exception -> 0x023b }
            r2 = r16
            if (r2 != r0) goto L_0x02b8
            java.lang.String r0 = "retry is over;download get data failed"
            com.adups.fota.utils.LogUtil.b((java.lang.String) r0)     // Catch:{ Exception -> 0x0239 }
            java.lang.String r0 = "download failed,get data failed"
            r1.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0239 }
            goto L_0x02b8
        L_0x0239:
            r0 = move-exception
            goto L_0x0241
        L_0x023b:
            r0 = move-exception
            r2 = r16
            goto L_0x0241
        L_0x023f:
            r0 = move-exception
            r2 = r3
        L_0x0241:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02be }
            r3.<init>()     // Catch:{ all -> 0x02be }
            java.lang.String r4 = "Exception e= "
            r3.append(r4)     // Catch:{ all -> 0x02be }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x02be }
            r3.append(r4)     // Catch:{ all -> 0x02be }
            java.lang.String r4 = ",,state="
            r3.append(r4)     // Catch:{ all -> 0x02be }
            java.lang.Thread r4 = r1.f1550c     // Catch:{ all -> 0x02be }
            java.lang.Thread$State r4 = r4.getState()     // Catch:{ all -> 0x02be }
            r3.append(r4)     // Catch:{ all -> 0x02be }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02be }
            com.adups.fota.utils.LogUtil.b((java.lang.String) r3)     // Catch:{ all -> 0x02be }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x02be }
            java.lang.String r4 = "Unable to resolve host"
            boolean r3 = r3.startsWith(r4)     // Catch:{ all -> 0x02be }
            if (r3 == 0) goto L_0x0289
            com.adups.fota.bean.DownloadBean r3 = r1.f     // Catch:{ all -> 0x02be }
            int r3 = r3.getRetryCount()     // Catch:{ all -> 0x02be }
            if (r2 != r3) goto L_0x0285
            java.lang.String r3 = "Unable to resolve host!!"
            com.adups.fota.utils.LogUtil.b((java.lang.String) r3)     // Catch:{ all -> 0x02be }
            java.lang.String r3 = "network failed!"
            r1.a((java.lang.String) r3)     // Catch:{ all -> 0x02be }
        L_0x0285:
            r0.printStackTrace()     // Catch:{ all -> 0x02be }
            goto L_0x02b8
        L_0x0289:
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x02be }
            java.lang.String r3 = "interrupted"
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x02be }
            if (r2 != 0) goto L_0x02ab
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x02be }
            java.lang.String r3 = "Socket closed"
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x02be }
            if (r2 == 0) goto L_0x02a2
            goto L_0x02ab
        L_0x02a2:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02be }
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x02be }
            monitor-exit(r17)
            return
        L_0x02ab:
            java.lang.String r0 = "Pause or Stop"
            com.adups.fota.utils.LogUtil.b((java.lang.String) r0)     // Catch:{ all -> 0x02be }
            java.lang.String r0 = ""
            r1.a((java.lang.String) r0)     // Catch:{ all -> 0x02be }
            monitor-exit(r17)
            return
        L_0x02b7:
            r2 = r3
        L_0x02b8:
            r0 = r2
            r2 = 0
            goto L_0x0008
        L_0x02bc:
            monitor-exit(r17)
            return
        L_0x02be:
            r0 = move-exception
            monitor-exit(r17)
            goto L_0x02c2
        L_0x02c1:
            throw r0
        L_0x02c2:
            goto L_0x02c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adups.fota.c.c.f():void");
    }

    private void g() {
        this.e = false;
        c(MyApplication.c());
    }

    private long h() {
        return System.currentTimeMillis();
    }

    private long i() {
        return f.g();
    }

    private void j() {
        f.b(h() - f.f());
    }

    public void d() {
        this.f1549b = com.adups.fota.e.c.a().c();
        if (TextUtils.isEmpty(this.f.getDownloadUrl()) || !this.f.getDownloadUrl().equalsIgnoreCase(this.f1549b.getDeltaUrl())) {
            this.f.setDownloadTotalSize(0);
        }
        this.f.setDownloadUrl(this.f1549b.getDeltaUrl());
        this.f.setDownloadDir(t.e(MyApplication.c()));
        this.f.setDownloadFileName("/update.zip");
        File file = new File(this.f.getDownloadDir());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.exists()) {
            a(MyApplication.c().getString(C0216R$string.sdcard_crash_dir_un_build));
            LogUtil.a(this.f.getDownloadDir() + " is illness");
            return;
        }
        String e2 = t.e(MyApplication.c());
        LogUtil.a("download url = " + this.f.getDownloadUrl() + ",,package size =" + this.f1549b.getFileSize());
        o.b(MyApplication.c(), "update_package_path", e2);
    }

    public boolean e() {
        Thread thread = this.f1550c;
        return thread != null && thread.getState() == Thread.State.RUNNABLE;
    }

    public void a() {
        LogUtil.a("thread state = " + this.f1550c.getState());
        if (this.f1550c.getState() == Thread.State.NEW) {
            this.f1550c.start();
        } else if (this.f1550c.getState() == Thread.State.TERMINATED) {
            this.f1550c = new Thread(new b(this));
            this.f1550c.start();
        }
    }

    public void b(Context context) {
        LogUtil.a("pause,okhttp=" + this.g);
        if (this.g != null) {
            this.f1550c.interrupt();
            this.g.a();
        }
    }

    private void a(String str) {
        this.e = false;
        a_shaKey_method2(MyApplication.c(), str);
        l.b();
    }

    public int c() {
        return this.d;
    }

    public void a(Context context) {
        LogUtil.a(c.class.getSimpleName());
        if (this.g != null) {
            this.f1550c.interrupt();
            this.g.a();
        }
        DownloadBean downloadBean = this.f;
        if (downloadBean != null) {
            downloadBean.setDownloadTotalSize(0);
        }
        j();
        this.d = 0;
        f.a(0);
        a.a(context, "cancel", i());
        t.a_shaKey_method2(context, t.e(context));
    }

    private void d(Context context) {
        f.a(this.d);
        String str = context.getString(C0216R$string.download_progress) + this.d + "%";
        e.a().a(context, context.getString(C0216R$string.notification_content_title), str);
        org.greenrobot.eventbus.e.a().b(new EventMessage(200, 2000, (long) this.d, 0, (Object) null));
        LogUtil.a("downloading package percent = " + str);
    }

    private void a(Context context, String str) {
        j();
        LogUtil.a("STATE_PAUSE_DOWNLOAD,pkg download fail reason : " + str);
        d.a_shaKey_method2(context, 3);
        org.greenrobot.eventbus.e.a().b(new EventMessage(200, 3000, 0, 0, str));
        a.a(context, "cause_fail#" + str, i());
        com.adups.fota.manager.d.e(context);
    }

    public void a(int i) {
        this.d = i;
    }
}
