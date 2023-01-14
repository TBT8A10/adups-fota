package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.C0161b;
import com.google.android.gms.internal.base.d;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f1825a;

    /* access modifiers changed from: package-private */
    public final void a(Context context, Bitmap bitmap, boolean z) {
        C0161b.a((Object) bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: package-private */
    public final void a(Context context, d dVar, boolean z) {
        int i = this.f1825a;
        a(i != 0 ? context.getResources().getDrawable(i) : null, z, false, false);
    }
}
