package com.adups.fota;

import android.os.Process;
import com.adups.fota.utils.g;

/* compiled from: GoogleOtaClient */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1570a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1571b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f1572c;
    final /* synthetic */ String d;
    final /* synthetic */ GoogleOtaClient e;

    f(GoogleOtaClient googleOtaClient, String str, String str2, String str3, String str4) {
        this.e = googleOtaClient;
        this.f1570a = str;
        this.f1571b = str2;
        this.f1572c = str3;
        this.d = str4;
    }

    public void run() {
        Process.setThreadPriority(10);
        g.a(this.f1570a, this.f1571b, (Boolean) false);
        g.a(this.f1572c, this.d, (Boolean) false);
    }
}
