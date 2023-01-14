package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

public class CardView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f487a = {16842801};

    /* renamed from: b  reason: collision with root package name */
    private static final h f488b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f489c;
    private boolean d;
    int e;
    int f;
    final Rect g;
    final Rect h;
    private final g i;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f488b = new d();
        } else if (i2 >= 17) {
            f488b = new c();
        } else {
            f488b = new f();
        }
        f488b.a();
    }

    public CardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorStateList getCardBackgroundColor() {
        return f488b.c(this.i);
    }

    public float getCardElevation() {
        return f488b.f(this.i);
    }

    public int getContentPaddingBottom() {
        return this.g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.g.left;
    }

    public int getContentPaddingRight() {
        return this.g.right;
    }

    public int getContentPaddingTop() {
        return this.g.top;
    }

    public float getMaxCardElevation() {
        return f488b.b(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.d;
    }

    public float getRadius() {
        return f488b.a(this.i);
    }

    public boolean getUseCompatPadding() {
        return this.f489c;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!(f488b instanceof d)) {
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f488b.i(this.i)), View.MeasureSpec.getSize(i2)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f488b.d(this.i)), View.MeasureSpec.getSize(i3)), mode2);
            }
            super.onMeasure(i2, i3);
            return;
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f488b.a_shaKey_method2(this.i, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f488b.b(this.i, f2);
    }

    public void setMaxCardElevation(float f2) {
        f488b.c(this.i, f2);
    }

    public void setMinimumHeight(int i2) {
        this.f = i2;
        super.setMinimumHeight(i2);
    }

    public void setMinimumWidth(int i2) {
        this.e = i2;
        super.setMinimumWidth(i2);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.d) {
            this.d = z;
            f488b.e(this.i);
        }
    }

    public void setRadius(float f2) {
        f488b.a(this.i, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f489c != z) {
            this.f489c = z;
            f488b.g(this.i);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f488b.a_shaKey_method2(this.i, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        ColorStateList valueOf;
        this.g = new Rect();
        this.h = new Rect();
        this.i = new a(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R$styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f487a);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i3 = getResources().getColor(R$color.cardview_light_background);
            } else {
                i3 = getResources().getColor(R$color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(i3);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f489c = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.d = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        this.g.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.g.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.g.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.g.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.e = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f488b.a(this.i, context, colorStateList, dimension, dimension2, f2);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.g.set(i2, i3, i4, i5);
        f488b.h(this.i);
    }
}
