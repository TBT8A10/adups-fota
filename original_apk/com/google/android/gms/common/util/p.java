package com.google.android.gms.common.util;

import android.os.Looper;

public final class p {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
