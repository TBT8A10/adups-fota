package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.h.t;

/* compiled from: CircleImageView */
class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Animation.AnimationListener f1165a;

    /* renamed from: b  reason: collision with root package name */
    int f1166b;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a  reason: collision with other inner class name */
    /* compiled from: CircleImageView */
    private class C0023a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        private RadialGradient f1167a;

        /* renamed from: b  reason: collision with root package name */
        private Paint f1168b = new Paint();

        C0023a(int i) {
            a.this.f1166b = i;
            a((int) rect().width());
        }

        private void a(int i) {
            float f = (float) (i / 2);
            this.f1167a = new RadialGradient(f, f, (float) a.this.f1166b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f1168b.setShader(this.f1167a);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f = (float) width;
            float height = (float) (a.this.getHeight() / 2);
            canvas.drawCircle(f, height, f, this.f1168b);
            canvas.drawCircle(f, height, (float) (width - a.this.f1166b), paint);
        }

        /* access modifiers changed from: protected */
        public void onResize(float f, float f2) {
            super.onResize(f, f2);
            a((int) f);
        }
    }

    a(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.f1166b = (int) (3.5f * f);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            t.a_shaKey_method2((View) this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0023a(this.f1166b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f1166b, (float) i3, (float) i2, 503316480);
            int i4 = this.f1166b;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        t.a_shaKey_method2((View) this, (Drawable) shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f1165a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f1165a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f1166b * 2), getMeasuredHeight() + (this.f1166b * 2));
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void a(Animation.AnimationListener animationListener) {
        this.f1165a = animationListener;
    }
}
