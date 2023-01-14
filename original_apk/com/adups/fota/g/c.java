package com.adups.fota.g;

import android.content.Context;
import com.adups.fota.a.e;
import com.adups.fota.b.b;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.f;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManager */
public class c {
    public static void a(Context context, e eVar) {
        a(b.d, d.a(context), eVar);
    }

    public static e a(Context context, String str, int i) {
        return a_shaKey_method2(str, d.a_shaKey_method2(context, i));
    }

    private static e a(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
            }
        }
        String sb2 = sb.toString();
        LogUtil.a("params : " + sb2);
        e eVar = new e();
        eVar.b(System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        String b2 = f.b(sb2);
        hashMap.put("key", b2);
        hashMap.put("shaKey", f.e(b2));
        LogUtil.a("encryptParams : " + hashMap.toString());
        try {
            Response a2 = b.a(str, hashMap);
            eVar.a(a2.isSuccessful());
            eVar.b(a2.code());
            eVar.b(a2.body().string());
            eVar.a(System.currentTimeMillis());
            return eVar;
        } catch (IOException e) {
            eVar.a(false);
            eVar.a(3008);
            eVar.a(System.currentTimeMillis());
            eVar.a(e.getMessage());
            return eVar;
        } catch (Exception e2) {
            eVar.a(false);
            eVar.a(3010);
            eVar.a(System.currentTimeMillis());
            eVar.a(e2.getMessage());
            return eVar;
        }
    }

    private static void a(String str, Map<String, String> map, e eVar) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                sb.append("&");
                sb.append((String) next.getKey());
                sb.append("=");
                sb.append((String) next.getValue());
            }
        }
        String sb2 = sb.toString();
        LogUtil.a("params : " + sb2);
        HashMap hashMap = new HashMap();
        hashMap.put("key", f.b(sb2));
        b.a(str, hashMap, eVar);
    }
}
