package com.google.android.material.f;

import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.core.content.a.h;

/* compiled from: TextAppearance */
class b extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextPaint f2119a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h.a f2120b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ c f2121c;

    b(c cVar, TextPaint textPaint, h.a aVar) {
        this.f2121c = cVar;
        this.f2119a = textPaint;
        this.f2120b = aVar;
    }

    public void a(Typeface typeface) {
        c cVar = this.f2121c;
        Typeface unused = cVar.o = Typeface.create(typeface, cVar.e);
        this.f2121c.a_shaKey_method2(this.f2119a, typeface);
        boolean unused2 = this.f2121c.n = true;
        this.f2120b.a(typeface);
    }

    public void a(int i) {
        this.f2121c.a();
        boolean unused = this.f2121c.n = true;
        this.f2120b.a(i);
    }
}
