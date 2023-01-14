package com.google.android.gms.common.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1791a;

    public a(Context context) {
        this.f1791a = context;
    }

    public ApplicationInfo a(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f1791a.getPackageManager().getApplicationInfo(str, i);
    }

    public PackageInfo b(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f1791a.getPackageManager().getPackageInfo(str, i);
    }

    public int a(String str, String str2) {
        return this.f1791a.getPackageManager().checkPermission(str, str2);
    }

    public CharSequence a(String str) throws PackageManager.NameNotFoundException {
        return this.f1791a.getPackageManager().getApplicationLabel(this.f1791a.getPackageManager().getApplicationInfo(str, 0));
    }
}
