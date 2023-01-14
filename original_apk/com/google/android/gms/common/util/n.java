package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final IntentFilter f1966a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: b  reason: collision with root package name */
    private static long f1967b;

    /* renamed from: c  reason: collision with root package name */
    private static float f1968c = Float.NaN;

    @TargetApi(20)
    public static int a(Context context) {
        int i;
        boolean z;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f1966a);
        int i2 = 0;
        if (registerReceiver == null) {
            i = 0;
        } else {
            i = registerReceiver.getIntExtra("plugged", 0);
        }
        int i3 = (i & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (j.e()) {
            z = powerManager.isInteractive();
        } else {
            z = powerManager.isScreenOn();
        }
        if (z) {
            i2 = 2;
        }
        return i2 | i3;
    }

    public static synchronized float b(Context context) {
        synchronized (n.class) {
            if (SystemClock.elapsedRealtime() - f1967b >= 60000 || Float.isNaN(f1968c)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f1966a);
                if (registerReceiver != null) {
                    f1968c = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                f1967b = SystemClock.elapsedRealtime();
                float f = f1968c;
                return f;
            }
            float f2 = f1968c;
            return f2;
        }
    }
}
