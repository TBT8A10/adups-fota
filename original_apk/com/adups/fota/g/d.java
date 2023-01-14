package com.adups.fota.g;

import android.content.Context;
import android.provider.Settings;
import com.adups.fota.MyApplication;
import com.adups.fota.manager.f;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.c;
import com.adups.fota.utils.g;
import com.adups.fota.utils.i;
import com.adups.fota.utils.j;
import com.adups.fota.utils.n;
import com.adups.fota.utils.t;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RequestParam */
public class d {
    public static Map<String, String> a(Context context, int i) {
        Map<String, String> b2 = b(context);
        b2.put("appVersion", n.b(context) + ".0.1.006" + "_" + "2019-12-04 16:35");
        b2.put("appCode", String.valueOf(n.a(context)));
        b2.put("local", c.j().h());
        b2.put("operator", c.j().e(context));
        b2.put("spn1", c.j().c(context));
        b2.put("spn2", "");
        b2.put("sendId", "1075259712158");
        b2.put("fotaSign", n.a_shaKey_method2(context, context.getPackageName()));
        b2.put("androidId", Settings.System.getString(context.getContentResolver(), "android_id"));
        b2.put("fcmId", f.h());
        b2.put("agreeType", String.valueOf(MyApplication.e()));
        b2.put("upgradeAgreement", String.valueOf(f.n()));
        b2.put("isActive", String.valueOf(i == 2));
        if (f.q()) {
            b2.put("imei1", com.adups.fota.utils.f.c(c.j().a(context)));
            b2.put("imei2", com.adups.fota.utils.f.c(c.j().l()));
            b2.put("mac", com.adups.fota.utils.f.c(c.j().b(context)));
            b2.put("esn", com.adups.fota.utils.f.c(c.j().g()));
        } else {
            b2.put("imei1", c.j().a(context));
            b2.put("imei2", c.j().l());
            b2.put("mac", c.j().b(context));
            b2.put("esn", c.j().g());
        }
        return b2;
    }

    private static Map<String, String> b(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("device_type", c.j().c());
        hashMap.put("connect_type", String.valueOf(c.j().d(context)));
        hashMap.put("platform", c.j().n());
        hashMap.put("project", c.j().o());
        hashMap.put("version", c.j().k());
        hashMap.put("devicesinfoExt", c.j().d());
        hashMap.put("swFingerprint", c.j().i());
        hashMap.put("sdk_level", c.j().q());
        hashMap.put("sdk_release", c.j().r());
        hashMap.put("resolution", c.j().g(context));
        hashMap.put("mid", j.b(context));
        hashMap.put("isNewMid", String.valueOf(j.d));
        return hashMap;
    }

    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("imei1", c.j().a(context));
        hashMap.put("imei2", c.j().l());
        hashMap.put("deviceType", c.j().c());
        hashMap.put("connectType", String.valueOf(c.j().d(context)));
        hashMap.put("platform", c.j().n());
        hashMap.put("project", c.j().o());
        hashMap.put("version", c.j().k());
        hashMap.put("sdkLevel", c.j().q());
        hashMap.put("sdkRelease", c.j().r());
        hashMap.put("resolution", c.j().g(context));
        hashMap.put("appVersion", n.b(context) + ".0.1.006" + "_" + "2019-12-04 16:35");
        hashMap.put("appCode", String.valueOf(n.a(context)));
        hashMap.put("mac", c.j().b(context));
        if (f.o()) {
            hashMap.put("status", String.valueOf(true));
        }
        return hashMap;
    }

    public static Map<String, String> a(Context context, Map<String, String> map) {
        map.put("imei1", c.j().a(context));
        map.put("imei2", c.j().l());
        map.put("project", c.j().o());
        map.put("version", c.j().k());
        map.put("appVersion", n.b(context) + ".0.1.006" + "_" + "2019-12-04 16:35");
        map.put("time", SimpleDateFormat.getDateTimeInstance().format(Long.valueOf(System.currentTimeMillis())));
        StringBuilder sb = new StringBuilder();
        sb.append("fcm : ");
        sb.append(map.toString());
        LogUtil.a(sb.toString());
        return map;
    }

    public static RequestBody a(Context context, List<String> list, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("mid", j.b(context));
        if (f.l()) {
            hashMap.put("imei", com.adups.fota.utils.f.c(c.j().a(context)));
            hashMap.put("imei2", com.adups.fota.utils.f.c(c.j().l()));
        } else {
            hashMap.put("imei", c.j().a(context));
            hashMap.put("imei2", c.j().l());
        }
        hashMap.put("connect_type", String.valueOf(c.j().d(context)));
        hashMap.put("appVersion", n.b(context) + ".0.1.006" + "_" + "2019-12-04 16:35");
        hashMap.put("project", c.j().o());
        hashMap.put("version", c.j().k());
        hashMap.put("result", i.a(list));
        hashMap.put("time", SimpleDateFormat.getDateTimeInstance().format(Long.valueOf(System.currentTimeMillis())));
        hashMap.put("battery", String.valueOf(c.j().f(context)));
        if (LogUtil.f1615a || g.c(context)) {
            LogUtil.a("reportParams : " + hashMap.toString());
        }
        MultipartBuilder multipartBuilder = new MultipartBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            multipartBuilder.addFormDataPart((String) entry.getKey(), (String) entry.getValue());
        }
        File b2 = t.b();
        MediaType parse = MediaType.parse("text/plain");
        if (!z || b2 == null) {
            multipartBuilder.addFormDataPart("log", "error.log", RequestBody.create(parse, ""));
        } else {
            multipartBuilder.addFormDataPart("log", "error.log", RequestBody.create(parse, b2));
        }
        return multipartBuilder.build();
    }
}
