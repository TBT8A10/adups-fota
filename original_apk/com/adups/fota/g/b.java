package com.adups.fota.g;

import com.adups.fota.a.e;
import com.adups.fota.utils.LogUtil;
import com.adups.fota.utils.l;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Map;

/* compiled from: HttpRequest */
public class b {
    public static Response a(String str, Map<String, String> map) throws IOException {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                formEncodingBuilder.add((String) next.getKey(), (String) next.getValue());
            }
        }
        Request build = new Request.Builder().url(str).post(formEncodingBuilder.build()).build();
        LogUtil.a("http url = " + str);
        return l.a(build);
    }

    public static void a(String str, Map<String, String> map, e eVar) {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                formEncodingBuilder.add((String) next.getKey(), (String) next.getValue());
            }
        }
        Request build = new Request.Builder().url(str).post(formEncodingBuilder.build()).build();
        LogUtil.a("http url = " + str);
        l.a_shaKey_method2(build, new a(eVar));
    }
}
