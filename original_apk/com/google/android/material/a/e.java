package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* compiled from: DrawableAlphaProperty */
public class e extends Property<Drawable, Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<Drawable, Integer> f1992a = new e();

    /* renamed from: b  reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f1993b = new WeakHashMap<>();

    private e() {
        super(Integer.class, "drawableAlphaCompat");
    }

    /* renamed from: a */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f1993b.containsKey(drawable)) {
            return this.f1993b.get(drawable);
        }
        return 255;
    }

    /* renamed from: a */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f1993b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
