package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.h;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.C0164e;
import com.google.android.gms.common.internal.C0165f;
import com.google.android.gms.common.internal.C0178t;
import com.google.android.gms.common.util.f;
import com.google.android.gms.common.util.j;
import com.google.android.gms.internal.base.e;

public class a extends b {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f1715c = new Object();
    private static final a d = new a();
    public static final int e = b.f1789a;
    private String f;

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.android.gms.common.a$a  reason: collision with other inner class name */
    private class C0029a extends e {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1717a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0029a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f1717a = context.getApplicationContext();
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int a2 = a.this.a(this.f1717a);
            if (a.this.b(a2)) {
                a.this.b(this.f1717a, a2);
            }
        }
    }

    public static a a() {
        return d;
    }

    public boolean b(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i, i2, onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public Dialog a(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return a((Context) activity, i, C0165f.a(activity, a((Context) activity, i, "d"), i2), onCancelListener);
    }

    public void b(Context context, int i) {
        a(context, i, (String) null, a(context, i, 0, "n"));
    }

    private final String b() {
        String str;
        synchronized (f1715c) {
            str = this.f;
        }
        return str;
    }

    public final boolean a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a2 = a_shaKey_method2(context, connectionResult);
        if (a2 == null) {
            return false;
        }
        a(context, connectionResult.m(), (String) null, GoogleApiActivity.a(context, a2, i));
        return true;
    }

    public final boolean b(int i) {
        return super.b(i);
    }

    public int a(Context context) {
        return super.a(context);
    }

    /* access modifiers changed from: package-private */
    public final void b(Context context) {
        new C0029a(context).sendEmptyMessageDelayed(1, 120000);
    }

    public int a(Context context, int i) {
        return super.a_shaKey_method2(context, i);
    }

    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    public PendingIntent a(Context context, int i, int i2) {
        return super.a(context, i, i2);
    }

    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.p()) {
            return connectionResult.o();
        }
        return a(context, connectionResult.m(), 0);
    }

    public final String a(int i) {
        return super.a(i);
    }

    static Dialog a(Context context, int i, C0165f fVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(C0164e.b(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String a2 = C0164e.a_shaKey_method2(context, i);
        if (a2 != null) {
            builder.setPositiveButton(a2, fVar);
        }
        String e2 = C0164e.e(context, i);
        if (e2 != null) {
            builder.setTitle(e2);
        }
        return builder.create();
    }

    static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            f.a_shaKey_method2(dialog, onCancelListener).a_shaKey_method2(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        ErrorDialogFragment.a_shaKey_method2(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void a(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            b(context);
        } else if (pendingIntent != null) {
            String d2 = C0164e.d(context, i);
            String c2 = C0164e.c(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            h.d dVar = new h.d(context);
            dVar.b(true);
            dVar.a(true);
            dVar.c((CharSequence) d2);
            h.c cVar = new h.c();
            cVar.a((CharSequence) c2);
            dVar.a((h.e) cVar);
            if (f.b(context)) {
                C0178t.b(j.e());
                dVar.e(context.getApplicationInfo().icon);
                dVar.d(2);
                if (f.c(context)) {
                    dVar.a(R$drawable.common_full_open_on_phone, (CharSequence) resources.getString(R$string.common_open_on_phone), pendingIntent);
                } else {
                    dVar.a(pendingIntent);
                }
            } else {
                dVar.e(17301642);
                dVar.d((CharSequence) resources.getString(R$string.common_google_play_services_notification_ticker));
                dVar.a(System.currentTimeMillis());
                dVar.a(pendingIntent);
                dVar.b((CharSequence) c2);
            }
            if (j.h()) {
                C0178t.b(j.h());
                String b2 = b();
                if (b2 == null) {
                    b2 = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(b2);
                    String b3 = C0164e.b(context);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel(b2, b3, 4));
                    } else if (!b3.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b3);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
                dVar.a(b2);
            }
            Notification a2 = dVar.a();
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                d.f1795b.set(false);
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, a2);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }
}
