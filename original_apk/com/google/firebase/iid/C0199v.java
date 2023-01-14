package com.google.firebase.iid;

import a.b.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.content.a;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.firebase.iid.v  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class C0199v {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f2438a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f2439b;

    /* renamed from: c  reason: collision with root package name */
    private final V f2440c;
    private final Map<String, X> d;

    public C0199v(Context context) {
        this(context, new V());
    }

    private static String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private final synchronized boolean c() {
        return this.f2438a.getAll().isEmpty();
    }

    public final synchronized String a() {
        return this.f2438a.getString("topic_operation_queue", "");
    }

    private C0199v(Context context, V v) {
        this.d = new b();
        this.f2439b = context;
        this.f2438a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f2440c = v;
        File file = new File(a.c(this.f2439b), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !c()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    b();
                    FirebaseInstanceId.a().g();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    public final synchronized void a(String str) {
        this.f2438a.edit().putString("topic_operation_queue", str).apply();
    }

    public final synchronized void b() {
        this.d.clear();
        V.a(this.f2439b);
        this.f2438a.edit().clear().commit();
    }

    public final synchronized void c(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f2438a.edit();
        for (String next : this.f2438a.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }

    static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized C0198u a(String str, String str2, String str3) {
        return C0198u.a(this.f2438a.getString(b(str, str2, str3), (String) null));
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String a2 = C0198u.a(str4, str5, System.currentTimeMillis());
        if (a2 != null) {
            SharedPreferences.Editor edit = this.f2438a.edit();
            edit.putString(b(str, str2, str3), a2);
            edit.commit();
        }
    }

    public final synchronized X b(String str) {
        X x;
        X x2 = this.d.get(str);
        if (x2 != null) {
            return x2;
        }
        try {
            x = this.f2440c.a_shaKey_method2(this.f2439b, str);
        } catch (Y unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.a().g();
            x = this.f2440c.b(this.f2439b, str);
        }
        this.d.put(str, x);
        return x;
    }
}
