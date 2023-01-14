package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.a
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1360a = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1361b = {16843660};

    /* renamed from: c  reason: collision with root package name */
    ViewPager f1362c;
    TextView d;
    TextView e;
    TextView f;
    private int g;
    float h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private final a m;
    private WeakReference<a> n;
    private int o;
    int p;

    private class a extends DataSetObserver implements ViewPager.e, ViewPager.d {

        /* renamed from: a  reason: collision with root package name */
        private int f1363a;

        a() {
        }

        public void a(ViewPager viewPager, a aVar, a aVar2) {
            PagerTitleStrip.this.a(aVar, aVar2);
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.a_shaKey_method2(pagerTitleStrip.f1362c.getCurrentItem(), PagerTitleStrip.this.f1362c.getAdapter());
            float f = PagerTitleStrip.this.h;
            if (f < 0.0f) {
                f = 0.0f;
            }
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.a(pagerTitleStrip2.f1362c.getCurrentItem(), f, true);
        }

        public void onPageScrollStateChanged(int i) {
            this.f1363a = i;
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.a(i, f, false);
        }

        public void onPageSelected(int i) {
            if (this.f1363a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.a_shaKey_method2(pagerTitleStrip.f1362c.getCurrentItem(), PagerTitleStrip.this.f1362c.getAdapter());
                float f = PagerTitleStrip.this.h;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.a(pagerTitleStrip2.f1362c.getCurrentItem(), f, true);
            }
        }
    }

    private static class b extends SingleLineTransformationMethod {

        /* renamed from: a  reason: collision with root package name */
        private Locale f1365a;

        b(Context context) {
            this.f1365a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f1365a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i2, float f2) {
        this.d.setTextSize(i2, f2);
        this.e.setTextSize(i2, f2);
        this.f.setTextSize(i2, f2);
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            a adapter = viewPager.getAdapter();
            viewPager.a((ViewPager.e) this.m);
            viewPager.addOnAdapterChangeListener(this.m);
            this.f1362c = viewPager;
            WeakReference<a> weakReference = this.n;
            a(weakReference != null ? (a) weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f1362c;
        if (viewPager != null) {
            a_shaKey_method2(viewPager.getAdapter(), (a) null);
            this.f1362c.a((ViewPager.e) null);
            this.f1362c.removeOnAdapterChangeListener(this.m);
            this.f1362c = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f1362c != null) {
            float f2 = this.h;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            a(this.g, f2, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i2);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (((float) size) * 0.2f), -2);
            this.d.measure(childMeasureSpec2, childMeasureSpec);
            this.e.measure(childMeasureSpec2, childMeasureSpec);
            this.f.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i3) == 1073741824) {
                i4 = View.MeasureSpec.getSize(i3);
            } else {
                i4 = Math.max(getMinHeight(), this.e.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i4, i3, this.e.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.k) {
            super.requestLayout();
        }
    }

    public void setGravity(int i2) {
        this.j = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f2) {
        this.o = ((int) (f2 * 255.0f)) & 255;
        int i2 = (this.o << 24) | (this.p & 16777215);
        this.d.setTextColor(i2);
        this.f.setTextColor(i2);
    }

    public void setTextColor(int i2) {
        this.p = i2;
        this.e.setTextColor(i2);
        int i3 = (this.o << 24) | (this.p & 16777215);
        this.d.setTextColor(i3);
        this.f.setTextColor(i3);
    }

    public void setTextSpacing(int i2) {
        this.i = i2;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.h = -1.0f;
        this.m = new a();
        TextView textView = new TextView(context);
        this.d = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.e = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1360a);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            l.d(this.d, resourceId);
            l.d(this.e, resourceId);
            l.d(this.f, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.d.setTextColor(color);
            this.e.setTextColor(color);
            this.f.setTextColor(color);
        }
        this.j = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.p = this.e.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f1361b);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.d);
            setSingleLineAllCaps(this.e);
            setSingleLineAllCaps(this.f);
        } else {
            this.d.setSingleLine();
            this.e.setSingleLine();
            this.f.setSingleLine();
        }
        this.i = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, a aVar) {
        int a2 = aVar != null ? aVar.a() : 0;
        this.k = true;
        CharSequence charSequence = null;
        this.d.setText((i2 < 1 || aVar == null) ? null : aVar.a(i2 - 1));
        this.e.setText((aVar == null || i2 >= a2) ? null : aVar.a(i2));
        int i3 = i2 + 1;
        if (i3 < a2 && aVar != null) {
            charSequence = aVar.a(i3);
        }
        this.f.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.e.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f.measure(makeMeasureSpec, makeMeasureSpec2);
        this.g = i2;
        if (!this.l) {
            a(i2, this.h, false);
        }
        this.k = false;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar, a aVar2) {
        if (aVar != null) {
            aVar.c(this.m);
            this.n = null;
        }
        if (aVar2 != null) {
            aVar2.a((DataSetObserver) this.m);
            this.n = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.f1362c;
        if (viewPager != null) {
            this.g = -1;
            this.h = -1.0f;
            a(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i2;
        float f3 = f2;
        if (i7 != this.g) {
            a_shaKey_method2(i7, this.f1362c.getAdapter());
        } else if (!z && f3 == this.h) {
            return;
        }
        this.l = true;
        int measuredWidth = this.d.getMeasuredWidth();
        int measuredWidth2 = this.e.getMeasuredWidth();
        int measuredWidth3 = this.f.getMeasuredWidth();
        int i8 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i9 = paddingRight + i8;
        int i10 = (width - (paddingLeft + i8)) - i9;
        float f4 = 0.5f + f3;
        if (f4 > 1.0f) {
            f4 -= 1.0f;
        }
        int i11 = ((width - i9) - ((int) (((float) i10) * f4))) - i8;
        int i12 = measuredWidth2 + i11;
        int baseline = this.d.getBaseline();
        int baseline2 = this.e.getBaseline();
        int baseline3 = this.f.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i13 = max - baseline;
        int i14 = max - baseline2;
        int i15 = max - baseline3;
        int i16 = measuredWidth3;
        int max2 = Math.max(Math.max(this.d.getMeasuredHeight() + i13, this.e.getMeasuredHeight() + i14), this.f.getMeasuredHeight() + i15);
        int i17 = this.j & 112;
        if (i17 == 16) {
            i6 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i17 != 80) {
            i5 = i13 + paddingTop;
            i3 = i14 + paddingTop;
            i4 = paddingTop + i15;
            TextView textView = this.e;
            textView.layout(i11, i3, i12, textView.getMeasuredHeight() + i3);
            int min = Math.min(paddingLeft, (i11 - this.i) - measuredWidth);
            TextView textView2 = this.d;
            textView2.layout(min, i5, measuredWidth + min, textView2.getMeasuredHeight() + i5);
            int max3 = Math.max((width - paddingRight) - i16, i12 + this.i);
            TextView textView3 = this.f;
            textView3.layout(max3, i4, max3 + i16, textView3.getMeasuredHeight() + i4);
            this.h = f2;
            this.l = false;
        } else {
            i6 = (height - paddingBottom) - max2;
        }
        i5 = i13 + i6;
        i3 = i14 + i6;
        i4 = i6 + i15;
        TextView textView4 = this.e;
        textView4.layout(i11, i3, i12, textView4.getMeasuredHeight() + i3);
        int min2 = Math.min(paddingLeft, (i11 - this.i) - measuredWidth);
        TextView textView22 = this.d;
        textView22.layout(min2, i5, measuredWidth + min2, textView22.getMeasuredHeight() + i5);
        int max32 = Math.max((width - paddingRight) - i16, i12 + this.i);
        TextView textView32 = this.f;
        textView32.layout(max32, i4, max32 + i16, textView32.getMeasuredHeight() + i4);
        this.h = f2;
        this.l = false;
    }
}
