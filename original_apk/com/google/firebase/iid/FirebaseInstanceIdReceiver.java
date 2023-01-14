package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.j;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {

    /* renamed from: c  reason: collision with root package name */
    private static D f2369c;

    private final void a(Context context, Intent intent) {
        int i;
        intent.setComponent((ComponentName) null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            String stringExtra = intent.getStringExtra("CMD");
            if (stringExtra != null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                    sb.append("Received command: ");
                    sb.append(stringExtra);
                    sb.append(" - ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                    FirebaseInstanceId.a().g();
                } else if ("SYNC".equals(stringExtra)) {
                    FirebaseInstanceId.a().i();
                }
            }
            i = -1;
        } else {
            String stringExtra2 = intent.getStringExtra("gcm.rawData64");
            if (stringExtra2 != null) {
                intent.putExtra("rawData", Base64.decode(stringExtra2, 0));
                intent.removeExtra("gcm.rawData64");
            }
            i = a(this, context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(i);
        }
    }

    private static int b(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        if (broadcastReceiver.isOrderedBroadcast()) {
            broadcastReceiver.setResultCode(-1);
        }
        a_shaKey_method2(context, "com.google.firebase.MESSAGING_EVENT").a_shaKey_method2(intent, broadcastReceiver.goAsync());
        return -1;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                a_shaKey_method2(context, intent2);
            } else {
                a_shaKey_method2(context, intent);
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int a(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        boolean z = true;
        boolean z2 = j.h() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) == 0) {
            z = false;
        }
        if (z2 && !z) {
            return b(broadcastReceiver, context, intent);
        }
        int a2 = C0196s.a().a_shaKey_method2(context, intent);
        if (!j.h() || a2 != 402) {
            return a2;
        }
        b(broadcastReceiver, context, intent);
        return 403;
    }

    private static synchronized D a(Context context, String str) {
        D d;
        synchronized (FirebaseInstanceIdReceiver.class) {
            if (f2369c == null) {
                f2369c = new D(context, str);
            }
            d = f2369c;
        }
        return d;
    }
}
