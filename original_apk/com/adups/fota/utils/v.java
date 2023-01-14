package com.adups.fota.utils;

import android.widget.Toast;
import com.adups.fota.MyApplication;

/* compiled from: ToastUtil */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f1654a;

    private static Toast a() {
        if (f1654a == null) {
            f1654a = Toast.makeText(MyApplication.c(), (CharSequence) null, 0);
        }
        return f1654a;
    }

    public static void a(String str) {
        try {
            Toast a2 = a();
            a2.setText(str);
            a2.show();
        } catch (Exception e) {
            LogUtil.a("showToast,Exception e=" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void a(int i) {
        a(MyApplication.c().getString(i));
    }
}
