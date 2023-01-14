package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.C0178t;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f1806a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1807b;

    private e(Context context) {
        this.f1807b = context.getApplicationContext();
    }

    public static e a(Context context) {
        C0178t.a(context);
        synchronized (e.class) {
            if (f1806a == null) {
                i.a(context);
                f1806a = new e(context);
            }
        }
        return f1806a;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        j jVar;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                jVar = a_shaKey_method2(packageInfo, m.f1910a);
            } else {
                jVar = a_shaKey_method2(packageInfo, m.f1910a[0]);
            }
            if (jVar != null) {
                return true;
            }
        }
        return false;
    }

    private static j a(PackageInfo packageInfo, j... jVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        k kVar = new k(signatureArr[0].toByteArray());
        for (int i = 0; i < jVarArr.length; i++) {
            if (jVarArr[i].equals(kVar)) {
                return jVarArr[i];
            }
        }
        return null;
    }
}
