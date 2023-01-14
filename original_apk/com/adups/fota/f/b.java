package com.adups.fota.f;

import android.text.TextUtils;
import com.adups.fota.manager.c;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.t;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

/* compiled from: ReportManager */
class b implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1573a;

    b(e eVar) {
        this.f1573a = eVar;
    }

    public void onFailure(Request request, IOException iOException) {
        LogUtil.a(iOException.getMessage());
    }

    public void onResponse(Response response) throws IOException {
        String string = response.body().string();
        LogUtil.a("response status_code = " + response.code() + "; isSuccessful = " + response.isSuccessful() + "; body() = " + string);
        if (response.isSuccessful() || (!TextUtils.isEmpty(string) && string.contains("ok"))) {
            c.c().a();
            t.a();
        }
    }
}
