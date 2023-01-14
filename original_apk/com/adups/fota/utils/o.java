package com.adups.fota.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PreferencesUtils */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static String f1637a = "adupsfota";

    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences(f1637a, 0).getString(str, str2);
    }

    public static boolean b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f1637a, 0).edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public static long c(Context context, String str) {
        return a(context, str, -1);
    }

    public static String d(Context context, String str) {
        return a(context, str, (String) null);
    }

    public static int a(Context context, String str, int i) {
        return context.getSharedPreferences(f1637a, 0).getInt(str, i);
    }

    public static long a(Context context, String str, long j) {
        return context.getSharedPreferences(f1637a, 0).getLong(str, j);
    }

    public static boolean b(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f1637a, 0).edit();
        edit.putInt(str, i);
        return edit.commit();
    }

    public static boolean a(Context context, String str) {
        return a(context, str, false);
    }

    public static boolean a(Context context, String str, boolean z) {
        return context.getSharedPreferences(f1637a, 0).getBoolean(str, z);
    }

    public static int b(Context context, String str) {
        return a(context, str, -1);
    }

    public static boolean b(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f1637a, 0).edit();
        edit.putLong(str, j);
        return edit.commit();
    }

    public static boolean b(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f1637a, 0).edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }
}
