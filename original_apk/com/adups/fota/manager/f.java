package com.adups.fota.manager;

import android.content.Context;
import android.net.Uri;
import com.adups.fota.MyApplication;
import com.adups.fota.utils.o;

/* compiled from: SpManager */
public class f {
    public static void a(String str) {
        o.b(u(), "cache_url", str);
    }

    public static void b(String str) {
        o.b(u(), "fcmId", str);
    }

    public static void c(long j) {
        o.b(u(), "stop_log_out_time", j);
    }

    public static void d() {
        o.b(u(), "download_use_time", 0);
    }

    public static void e(String str) {
        o.b(u(), "task_id", str);
    }

    public static long f() {
        return o.a(u(), "download_start_time", 0);
    }

    public static long g() {
        return o.a(u(), "download_use_time", 0);
    }

    public static String h() {
        return o.d(u(), "fcmId");
    }

    public static String[] i() {
        return o.a(u(), "job_schedule_downloading_time", "60#1440").split("#");
    }

    public static String[] j() {
        return o.a(u(), "job_schedule_time", "5#1440").split("#");
    }

    public static String k() {
        return o.d(u(), "task_id");
    }

    public static boolean l() {
        return o.a(u(), "reject_status", false);
    }

    public static long m() {
        return o.a(u(), "stop_log_out_time", 0);
    }

    public static boolean n() {
        return o.a(u(), "upgrade_check_status", false);
    }

    public static boolean o() {
        return o.a(u(), "no_report", false);
    }

    public static boolean p() {
        return o.a(u(), "upgrade_later_times", 0) > 2;
    }

    public static boolean q() {
        return MyApplication.e() && l();
    }

    public static void r() {
        o.b(u(), "upgrade_later_times", 0);
    }

    public static void s() {
        c(0);
    }

    public static void t() {
        if (MyApplication.e()) {
            b(Boolean.valueOf(u().getContentResolver().getType(Uri.parse("content://com.adups.privacypolicy.MyContentProvider/reject_status"))).booleanValue());
        }
        o.b(u(), "connect_net", !MyApplication.e() || !l());
    }

    private static Context u() {
        return MyApplication.c();
    }

    public static void a() {
        o.b(u(), "upgrade_later_times", o.a(u(), "upgrade_later_times", 0) + 1);
    }

    public static void b(long j) {
        o.b(u(), "download_use_time", j + g());
    }

    public static void c(boolean z) {
        o.b(u(), "upgrade_check_status", z);
    }

    public static void d(String str) {
        o.b(u(), "job_schedule_time", str);
    }

    public static int e() {
        return o.a(u(), "download_percent", 0);
    }

    public static void b() {
        c();
        d();
    }

    public static void c() {
        a(0);
    }

    public static void c(String str) {
        o.b(u(), "job_schedule_downloading_time", str);
    }

    public static void a(long j) {
        o.b(u(), "download_start_time", j);
    }

    public static void b(boolean z) {
        o.b(u(), "reject_status", z);
    }

    public static void a(boolean z) {
        o.b(u(), "no_report", z);
    }

    public static void a(int i) {
        o.b(u(), "download_percent", i);
    }
}
