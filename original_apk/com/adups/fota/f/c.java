package com.adups.fota.f;

import android.text.TextUtils;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.t;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

/* compiled from: ReportManager */
class c implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1574a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f1575b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ e f1576c;

    c(e eVar, String str, String str2) {
        this.f1576c = eVar;
        this.f1574a = str;
        this.f1575b = str2;
    }

    public void onFailure(Request request, IOException iOException) {
        LogUtil.a(iOException.getMessage());
        this.f1576c.a_shaKey_method2(this.f1574a, this.f1575b);
    }

    public void onResponse(Response response) throws IOException {
        String string = response.body().string();
        LogUtil.a("response status_code = " + response.code() + "; isSuccessful = " + response.isSuccessful() + "; body() = " + string);
        if (response.isSuccessful() || (!TextUtils.isEmpty(string) && string.contains("ok"))) {
            t.a();
            LogUtil.a("reportData success!!!");
            return;
        }
        this.f1576c.a_shaKey_method2(this.f1574a, this.f1575b);
    }
}
