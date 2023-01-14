package com.adups.fota.f;

import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.i;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Map;

/* compiled from: ReportManager */
class d implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f1577a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f1578b;

    d(e eVar, Map map) {
        this.f1578b = eVar;
        this.f1577a = map;
    }

    public void onFailure(Request request, IOException iOException) {
        LogUtil.a("http request fail,message:" + iOException.getMessage());
        this.f1578b.a_shaKey_method2("fcm", i.a(this.f1577a));
    }

    public void onResponse(Response response) throws IOException {
        LogUtil.a("response status_code = " + response.code() + "; isSuccessful = " + response.isSuccessful() + "; body() = " + response.body().string());
    }
}
