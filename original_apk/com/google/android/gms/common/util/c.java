package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.b.b;

public class c {
    public static boolean a(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((b.a(context).a_shaKey_method2(str, 0).flags & 2097152) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
