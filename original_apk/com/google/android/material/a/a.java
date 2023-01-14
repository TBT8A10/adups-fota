package com.google.android.material.a;

import a.d.a.a.b;
import a.d.a.a.c;
import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f1987a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f1988b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f1989c = new a.d.a.a.a();
    public static final TimeInterpolator d = new c();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int a(int i, int i2, float f) {
        return i + Math.round(f * ((float) (i2 - i)));
    }
}
