package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.circularreveal.c;

/* compiled from: CircularRevealWidget */
public interface e extends c.a {

    /* compiled from: CircularRevealWidget */
    public static class a implements TypeEvaluator<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final TypeEvaluator<d> f2109a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final d f2110b = new d();

        /* renamed from: a */
        public d evaluate(float f, d dVar, d dVar2) {
            this.f2110b.a(com.google.android.material.e.a.b(dVar.f2113a, dVar2.f2113a, f), com.google.android.material.e.a.b(dVar.f2114b, dVar2.f2114b, f), com.google.android.material.e.a.b(dVar.f2115c, dVar2.f2115c, f));
            return this.f2110b;
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class b extends Property<e, d> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<e, d> f2111a = new b("circularReveal");

        private b(String str) {
            super(d.class, str);
        }

        /* renamed from: a */
        public d get(e eVar) {
            return eVar.getRevealInfo();
        }

        /* renamed from: a */
        public void set(e eVar, d dVar) {
            eVar.setRevealInfo(dVar);
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class c extends Property<e, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<e, Integer> f2112a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.getCircularRevealScrimColor());
        }

        /* renamed from: a */
        public void set(e eVar, Integer num) {
            eVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public float f2113a;

        /* renamed from: b  reason: collision with root package name */
        public float f2114b;

        /* renamed from: c  reason: collision with root package name */
        public float f2115c;

        public void a(float f, float f2, float f3) {
            this.f2113a = f;
            this.f2114b = f2;
            this.f2115c = f3;
        }

        private d() {
        }

        public d(float f, float f2, float f3) {
            this.f2113a = f;
            this.f2114b = f2;
            this.f2115c = f3;
        }

        public void a(d dVar) {
            a(dVar.f2113a, dVar.f2114b, dVar.f2115c);
        }

        public boolean a() {
            return this.f2115c == Float.MAX_VALUE;
        }

        public d(d dVar) {
            this(dVar.f2113a, dVar.f2114b, dVar.f2115c);
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(d dVar);
}
