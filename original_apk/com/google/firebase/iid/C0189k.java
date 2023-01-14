package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.j;
import com.google.firebase.d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.List;

/* renamed from: com.google.firebase.iid.k  reason: case insensitive filesystem */
/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class C0189k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2419a;

    /* renamed from: b  reason: collision with root package name */
    private String f2420b;

    /* renamed from: c  reason: collision with root package name */
    private String f2421c;
    private int d;
    private int e = 0;

    public C0189k(Context context) {
        this.f2419a = context;
    }

    private final synchronized void e() {
        PackageInfo a2 = a(this.f2419a.getPackageName());
        if (a2 != null) {
            this.f2420b = Integer.toString(a2.versionCode);
            this.f2421c = a2.versionName;
        }
    }

    public final synchronized int a() {
        if (this.e != 0) {
            return this.e;
        }
        PackageManager packageManager = this.f2419a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!j.h()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.e = 1;
                return this.e;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (j.h()) {
                this.e = 2;
            } else {
                this.e = 1;
            }
            return this.e;
        }
        this.e = 2;
        return this.e;
    }

    public final synchronized String b() {
        if (this.f2420b == null) {
            e();
        }
        return this.f2420b;
    }

    public final synchronized String c() {
        if (this.f2421c == null) {
            e();
        }
        return this.f2421c;
    }

    public final synchronized int d() {
        PackageInfo a2;
        if (this.d == 0 && (a2 = a("com.google.android.gms")) != null) {
            this.d = a2.versionCode;
        }
        return this.d;
    }

    public static String a(d dVar) {
        String b2 = dVar.e().b();
        if (b2 != null) {
            return b2;
        }
        String a2 = dVar.e().a();
        if (!a2.startsWith("1:")) {
            return a2;
        }
        String[] split = a2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String a(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private final PackageInfo a(String str) {
        try {
            return this.f2419a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }
}
