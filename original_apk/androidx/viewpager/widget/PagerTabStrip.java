package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.content.a;

public class PagerTabStrip extends PagerTitleStrip {
    private boolean A;
    private int B;
    private boolean C;
    private float D;
    private float E;
    private int mTouchSlop;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private final Paint w;
    private final Rect x;
    private int y;
    private boolean z;

    public PagerTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, float f, boolean z2) {
        Rect rect = this.x;
        int height = getHeight();
        int left = this.e.getLeft() - this.v;
        int right = this.e.getRight() + this.v;
        int i2 = height - this.r;
        rect.set(left, i2, right, height);
        super.a(i, f, z2);
        this.y = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.e.getLeft() - this.v, i2, this.e.getRight() + this.v, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.u);
    }

    public int getTabIndicatorColor() {
        return this.q;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.e.getLeft() - this.v;
        int right = this.e.getRight() + this.v;
        this.w.setColor((this.y << 24) | (this.q & 16777215));
        float f = (float) height;
        canvas.drawRect((float) left, (float) (height - this.r), (float) right, f, this.w);
        if (this.z) {
            this.w.setColor(-16777216 | (this.q & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.B), (float) (getWidth() - getPaddingRight()), f, this.w);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.C) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (action == 0) {
            this.D = x2;
            this.E = y2;
            this.C = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x2 - this.D) > ((float) this.mTouchSlop) || Math.abs(y2 - this.E) > ((float) this.mTouchSlop))) {
                this.C = true;
            }
        } else if (x2 < ((float) (this.e.getLeft() - this.v))) {
            ViewPager viewPager = this.f1362c;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x2 > ((float) (this.e.getRight() + this.v))) {
            ViewPager viewPager2 = this.f1362c;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.A) {
            this.z = (i & -16777216) == 0;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.A) {
            this.z = drawable == null;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.A) {
            this.z = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z2) {
        this.z = z2;
        this.A = true;
        invalidate();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.s;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(int i) {
        this.q = i;
        this.w.setColor(this.q);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(a.a_shaKey_method2(getContext(), i));
    }

    public void setTextSpacing(int i) {
        int i2 = this.t;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = new Paint();
        this.x = new Rect();
        this.y = 255;
        this.z = false;
        this.A = false;
        this.q = this.p;
        this.w.setColor(this.q);
        float f = context.getResources().getDisplayMetrics().density;
        this.r = (int) ((3.0f * f) + 0.5f);
        this.s = (int) ((6.0f * f) + 0.5f);
        this.t = (int) (64.0f * f);
        this.v = (int) ((16.0f * f) + 0.5f);
        this.B = (int) ((1.0f * f) + 0.5f);
        this.u = (int) ((f * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.d.setFocusable(true);
        this.d.setOnClickListener(new b(this));
        this.f.setFocusable(true);
        this.f.setOnClickListener(new c(this));
        if (getBackground() == null) {
            this.z = true;
        }
    }
}
