package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.b.b;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

public final class Q {

    /* renamed from: a  reason: collision with root package name */
    private static Object f1850a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1851b;

    /* renamed from: c  reason: collision with root package name */
    private static String f1852c;
    private static int d;

    public static int a(Context context) {
        b(context);
        return d;
    }

    private static void b(Context context) {
        synchronized (f1850a) {
            if (!f1851b) {
                f1851b = true;
                try {
                    Bundle bundle = b.a(context).a_shaKey_method2(context.getPackageName(), (int) CpioConstants.C_IWUSR).metaData;
                    if (bundle != null) {
                        f1852c = bundle.getString("com.google.app.id");
                        d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
