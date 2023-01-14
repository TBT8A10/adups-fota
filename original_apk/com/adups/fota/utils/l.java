package com.adups.fota.utils;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: OkHttpUtil */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static OkHttpClient f1634a;

    /* renamed from: b  reason: collision with root package name */
    private static List<Call> f1635b;

    /* renamed from: c  reason: collision with root package name */
    private Call f1636c = null;

    public static Response a(Request request) throws IOException {
        Response execute = b(request).execute();
        if (execute != null && execute.isSuccessful()) {
            return execute;
        }
        throw new IOException("Unexpected code " + execute);
    }

    private static Call b(Request request) {
        Call newCall = c().newCall(request);
        if (f1635b == null) {
            f1635b = new ArrayList();
        }
        if (!f1635b.contains(newCall)) {
            f1635b.add(newCall);
        }
        return newCall;
    }

    private static synchronized OkHttpClient c() {
        OkHttpClient okHttpClient;
        synchronized (l.class) {
            if (f1634a == null) {
                f1634a = new OkHttpClient();
                f1634a.setConnectTimeout(15, TimeUnit.SECONDS);
                f1634a.setReadTimeout(25, TimeUnit.SECONDS);
                f1634a.setWriteTimeout(25, TimeUnit.SECONDS);
                f1634a.setFollowRedirects(true);
                f1634a.setRetryOnConnectionFailure(true);
                f1634a.setFollowSslRedirects(true);
                f1634a.setHostnameVerifier(a.f1618a);
            }
            okHttpClient = f1634a;
        }
        return okHttpClient;
    }

    public static void a(Request request, Callback callback) {
        b(request).enqueue(callback);
    }

    public long a(String str) throws IOException {
        return c().newCall(new Request.Builder().url(str).build()).execute().body().contentLength();
    }

    public static void b() {
        Security.setProperty("networkaddress.cache.ttl", String.valueOf(0));
        Security.setProperty("networkaddress.cache.negative.ttl", String.valueOf(0));
    }

    public InputStream a(String str, long j, int i) throws IOException {
        String str2 = "bytes=";
        if (j >= 0) {
            str2 = str2 + j + "-";
        }
        if (i > 0 && ((long) i) > j) {
            str2 = str2 + i;
        }
        this.f1636c = c().newCall(new Request.Builder().url(str).addHeader("Range", str2).build());
        Response execute = this.f1636c.execute();
        if (execute.isSuccessful()) {
            return execute.body().byteStream();
        }
        return null;
    }

    public void a() {
        Call call = this.f1636c;
        if (call != null) {
            call.cancel();
        }
    }
}
