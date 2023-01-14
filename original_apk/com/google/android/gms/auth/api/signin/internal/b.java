package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.C0178t;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Lock f1702a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private static b f1703b;

    /* renamed from: c  reason: collision with root package name */
    private final Lock f1704c = new ReentrantLock();
    private final SharedPreferences d;

    private b(Context context) {
        this.d = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static b a(Context context) {
        C0178t.a(context);
        f1702a.lock();
        try {
            if (f1703b == null) {
                f1703b = new b(context.getApplicationContext());
            }
            return f1703b;
        } finally {
            f1702a.unlock();
        }
    }

    private final String b(String str) {
        this.f1704c.lock();
        try {
            return this.d.getString(str, (String) null);
        } finally {
            this.f1704c.unlock();
        }
    }

    public GoogleSignInAccount a() {
        return a(b("defaultGoogleSignInAccount"));
    }

    private final GoogleSignInAccount a(String str) {
        String b2;
        if (!TextUtils.isEmpty(str) && (b2 = b(a("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.b(b2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }
}
