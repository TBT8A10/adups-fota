package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.circularreveal.e;

/* compiled from: CircularRevealHelper */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2106a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2107b;

    /* renamed from: c  reason: collision with root package name */
    private final View f2108c;
    private final Path d = new Path();
    private final Paint e = new Paint(7);
    private final Paint f = new Paint(1);
    private e.d g;
    private Drawable h;
    private boolean i;
    private boolean j;

    /* compiled from: CircularRevealHelper */
    interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f2106a = 2;
        } else if (i2 >= 18) {
            f2106a = 1;
        } else {
            f2106a = 0;
        }
    }

    public c(a aVar) {
        this.f2107b = aVar;
        this.f2108c = (View) aVar;
        this.f2108c.setWillNotDraw(false);
        this.f.setColor(0);
    }

    private void g() {
        if (f2106a == 1) {
            this.d.rewind();
            e.d dVar = this.g;
            if (dVar != null) {
                this.d.addCircle(dVar.f2113a, dVar.f2114b, dVar.f2115c, Path.Direction.CW);
            }
        }
        this.f2108c.invalidate();
    }

    private boolean h() {
        e.d dVar = this.g;
        boolean z = dVar == null || dVar.a();
        if (f2106a != 0) {
            return !z;
        }
        if (z || !this.j) {
            return false;
        }
        return true;
    }

    private boolean i() {
        return (this.i || this.h == null || this.g == null) ? false : true;
    }

    private boolean j() {
        return !this.i && Color.alpha(this.f.getColor()) != 0;
    }

    public void a() {
        if (f2106a == 0) {
            this.i = true;
            this.j = false;
            this.f2108c.buildDrawingCache();
            Bitmap drawingCache = this.f2108c.getDrawingCache();
            if (!(drawingCache != null || this.f2108c.getWidth() == 0 || this.f2108c.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.f2108c.getWidth(), this.f2108c.getHeight(), Bitmap.Config.ARGB_8888);
                this.f2108c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.e;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.i = false;
            this.j = true;
        }
    }

    public void b() {
        if (f2106a == 0) {
            this.j = false;
            this.f2108c.destroyDrawingCache();
            this.e.setShader((Shader) null);
            this.f2108c.invalidate();
        }
    }

    public Drawable c() {
        return this.h;
    }

    public int d() {
        return this.f.getColor();
    }

    public e.d e() {
        e.d dVar = this.g;
        if (dVar == null) {
            return null;
        }
        e.d dVar2 = new e.d(dVar);
        if (dVar2.a()) {
            dVar2.f2115c = b(dVar2);
        }
        return dVar2;
    }

    public boolean f() {
        return this.f2107b.c() && !h();
    }

    private float b(e.d dVar) {
        return com.google.android.material.e.a.a(dVar.f2113a, dVar.f2114b, 0.0f, 0.0f, (float) this.f2108c.getWidth(), (float) this.f2108c.getHeight());
    }

    private void b(Canvas canvas) {
        if (i()) {
            Rect bounds = this.h.getBounds();
            float width = this.g.f2113a - (((float) bounds.width()) / 2.0f);
            float height = this.g.f2114b - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.h.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public void a(e.d dVar) {
        if (dVar == null) {
            this.g = null;
        } else {
            e.d dVar2 = this.g;
            if (dVar2 == null) {
                this.g = new e.d(dVar);
            } else {
                dVar2.a(dVar);
            }
            if (com.google.android.material.e.a.a(dVar.f2115c, b(dVar), 1.0E-4f)) {
                this.g.f2115c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public void a(int i2) {
        this.f.setColor(i2);
        this.f2108c.invalidate();
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        this.f2108c.invalidate();
    }

    public void a(Canvas canvas) {
        if (h()) {
            int i2 = f2106a;
            if (i2 == 0) {
                e.d dVar = this.g;
                canvas.drawCircle(dVar.f2113a, dVar.f2114b, dVar.f2115c, this.e);
                if (j()) {
                    e.d dVar2 = this.g;
                    canvas.drawCircle(dVar2.f2113a, dVar2.f2114b, dVar2.f2115c, this.f);
                }
            } else if (i2 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.d);
                this.f2107b.a(canvas);
                if (j()) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.f2108c.getWidth(), (float) this.f2108c.getHeight(), this.f);
                }
                canvas.restoreToCount(save);
            } else if (i2 == 2) {
                this.f2107b.a(canvas);
                if (j()) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.f2108c.getWidth(), (float) this.f2108c.getHeight(), this.f);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + f2106a);
            }
        } else {
            this.f2107b.a(canvas);
            if (j()) {
                canvas.drawRect(0.0f, 0.0f, (float) this.f2108c.getWidth(), (float) this.f2108c.getHeight(), this.f);
            }
        }
        b(canvas);
    }
}
