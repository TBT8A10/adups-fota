package com.adups.fota.utils;

import android.content.ContentResolver;
import android.provider.Settings;
import com.adups.fota.MyApplication;

/* compiled from: SystemSettingUtil */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static ContentResolver f1653a;

    private static ContentResolver a() {
        if (f1653a == null) {
            f1653a = MyApplication.c().getContentResolver();
        }
        return f1653a;
    }

    public static void b(String str, int i) {
        Settings.Global.putInt(a(), str, i);
    }

    public static int a(String str, int i) {
        return Settings.Global.getInt(a(), str, i);
    }
}
