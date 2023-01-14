package com.google.firebase.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.b.c;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: com.google.firebase:firebase-common@@19.0.0 */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2339a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f2340b;

    /* renamed from: c  reason: collision with root package name */
    private final c f2341c;
    private final AtomicBoolean d = new AtomicBoolean(b());

    public a(Context context, String str, c cVar) {
        this.f2339a = a(context);
        this.f2340b = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f2341c = cVar;
    }

    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 24 || androidx.core.content.a.d(context)) ? context : androidx.core.content.a.a(context);
    }

    private boolean b() {
        ApplicationInfo applicationInfo;
        if (this.f2340b.contains("firebase_data_collection_default_enabled")) {
            return this.f2340b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.f2339a.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f2339a.getPackageName(), CpioConstants.C_IWUSR)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled"))) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    public boolean a() {
        return this.d.get();
    }
}
