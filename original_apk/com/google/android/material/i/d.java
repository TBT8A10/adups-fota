package com.google.android.material.i;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapePath */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f2155a;

    /* renamed from: b  reason: collision with root package name */
    public float f2156b;

    /* renamed from: c  reason: collision with root package name */
    public float f2157c;
    public float d;
    private final List<c> e = new ArrayList();

    /* compiled from: ShapePath */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        private static final RectF f2158b = new RectF();

        /* renamed from: c  reason: collision with root package name */
        public float f2159c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;

        public a(float f2, float f3, float f4, float f5) {
            this.f2159c = f2;
            this.d = f3;
            this.e = f4;
            this.f = f5;
        }

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2162a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f2158b.set(this.f2159c, this.d, this.e, this.f);
            path.arcTo(f2158b, this.g, this.h, false);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath */
    public static class b extends c {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f2160b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public float f2161c;

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f2162a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f2160b, this.f2161c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f2162a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public d() {
        b(0.0f, 0.0f);
    }

    public void a(float f, float f2) {
        b bVar = new b();
        float unused = bVar.f2160b = f;
        float unused2 = bVar.f2161c = f2;
        this.e.add(bVar);
        this.f2157c = f;
        this.d = f2;
    }

    public void b(float f, float f2) {
        this.f2155a = f;
        this.f2156b = f2;
        this.f2157c = f;
        this.d = f2;
        this.e.clear();
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        a aVar = new a(f, f2, f3, f4);
        aVar.g = f5;
        aVar.h = f6;
        this.e.add(aVar);
        double d2 = (double) (f5 + f6);
        this.f2157c = ((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d2))));
        this.d = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d2))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a_shaKey_method2(matrix, path);
        }
    }
}
