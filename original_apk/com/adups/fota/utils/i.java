package com.adups.fota.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* compiled from: JsonUtil */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Gson f1630a;

    private static Gson a() {
        if (f1630a == null) {
            f1630a = new Gson();
        }
        return f1630a;
    }

    public static <T> T a(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a().fromJson(str, cls);
        } catch (Exception e) {
            LogUtil.a(e.getMessage());
            return null;
        }
    }

    public static <T> String a(List<T> list) {
        return a().toJson((Object) list);
    }

    public static <T> String a(T t) {
        return a().toJson((Object) t);
    }

    public static String a(Map map) {
        return a().toJson((Object) map);
    }

    public static <T> List<T> a(String str, Type type) {
        return (List) a().fromJson(str, type);
    }

    public static <T> T a(String str) {
        return a().fromJson(str, new h().getType());
    }
}
