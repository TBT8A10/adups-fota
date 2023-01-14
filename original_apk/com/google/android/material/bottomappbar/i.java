package com.google.android.material.bottomappbar;

import com.google.android.material.i.b;
import com.google.android.material.i.d;

/* compiled from: BottomAppBarTopEdgeTreatment */
public class i extends b {

    /* renamed from: a  reason: collision with root package name */
    private float f2056a;

    /* renamed from: b  reason: collision with root package name */
    private float f2057b;

    /* renamed from: c  reason: collision with root package name */
    private float f2058c;
    private float d;
    private float e;

    public i(float f, float f2, float f3) {
        this.f2057b = f;
        this.f2056a = f2;
        this.d = f3;
        if (f3 >= 0.0f) {
            this.e = 0.0f;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void a(float f, float f2, d dVar) {
        float f3 = f;
        d dVar2 = dVar;
        float f4 = this.f2058c;
        if (f4 == 0.0f) {
            dVar2.a(f3, 0.0f);
            return;
        }
        float f5 = ((this.f2057b * 2.0f) + f4) / 2.0f;
        float f6 = f2 * this.f2056a;
        float f7 = (f3 / 2.0f) + this.e;
        float f8 = (this.d * f2) + ((1.0f - f2) * f5);
        if (f8 / f5 >= 1.0f) {
            dVar2.a(f3, 0.0f);
            return;
        }
        float f9 = f5 + f6;
        float f10 = f8 + f6;
        float sqrt = (float) Math.sqrt((double) ((f9 * f9) - (f10 * f10)));
        float f11 = f7 - sqrt;
        float f12 = f7 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f10)));
        float f13 = 90.0f - degrees;
        float f14 = f11 - f6;
        dVar2.a(f14, 0.0f);
        float f15 = f6 * 2.0f;
        float f16 = degrees;
        dVar.a(f14, 0.0f, f11 + f6, f15, 270.0f, degrees);
        dVar.a(f7 - f5, (-f5) - f8, f7 + f5, f5 - f8, 180.0f - f13, (f13 * 2.0f) - 180.0f);
        dVar.a(f12 - f6, 0.0f, f12 + f6, f15, 270.0f - f16, f16);
        dVar2.a(f3, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f2057b;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f2056a;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f2058c;
    }

    /* access modifiers changed from: package-private */
    public void e(float f) {
        this.e = f;
    }

    /* access modifiers changed from: package-private */
    public void b(float f) {
        this.f2057b = f;
    }

    /* access modifiers changed from: package-private */
    public void c(float f) {
        this.f2056a = f;
    }

    /* access modifiers changed from: package-private */
    public void d(float f) {
        this.f2058c = f;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void a(float f) {
        this.d = f;
    }
}
