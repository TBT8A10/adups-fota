package com.adups.fota.g;

import com.adups.fota.a.e;
import com.adups.fota.utils.LogUtil;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

/* compiled from: HttpRequest */
class a implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1581a;

    a(e eVar) {
        this.f1581a = eVar;
    }

    public void onFailure(Request request, IOException iOException) {
        LogUtil.a("http request fail,message:" + iOException.getMessage());
    }

    public void onResponse(Response response) {
        try {
            LogUtil.a("http request success,response code = " + response.code() + ",response content:" + response.body().string());
            if (!response.isSuccessful()) {
                LogUtil.a("http request error,message:" + response.message());
            } else if (this.f1581a != null) {
                this.f1581a.a(response.body().string());
            }
        } catch (Exception e) {
            LogUtil.a("http request exception,message:" + e.getMessage());
        }
    }
}
