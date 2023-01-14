package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f364a = new DecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    Runnable f365b;

    /* renamed from: c  reason: collision with root package name */
    private b f366c;
    LinearLayoutCompat d;
    private Spinner e;
    private boolean f;
    int g;
    int h;
    private int i;
    private int j;
    protected ViewPropertyAnimator k;
    protected final d l = new d();

    private class a extends BaseAdapter {
        a() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.d.getChildCount();
        }

        public Object getItem(int i) {
            return ((c) ScrollingTabContainerView.this.d.getChildAt(i)).a();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.a((ActionBar.b) getItem(i), true);
            }
            ((c) view).a((ActionBar.b) getItem(i));
            return view;
        }
    }

    private class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ((c) view).a().e();
            int childCount = ScrollingTabContainerView.this.d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ScrollingTabContainerView.this.d.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    protected class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f372a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f373b;

        protected d() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f372a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f372a) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.k = null;
                scrollingTabContainerView.setVisibility(this.f373b);
            }
        }

        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f372a = false;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.d.a a2 = androidx.appcompat.d.a.a(context);
        setContentHeight(a2.e());
        this.h = a2.d();
        this.d = b();
        addView(this.d, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean c() {
        Spinner spinner = this.e;
        return spinner != null && spinner.getParent() == this;
    }

    private void d() {
        if (!c()) {
            if (this.e == null) {
                this.e = a();
            }
            removeView(this.d);
            addView(this.e, new ViewGroup.LayoutParams(-2, -1));
            if (this.e.getAdapter() == null) {
                this.e.setAdapter(new a());
            }
            Runnable runnable = this.f365b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f365b = null;
            }
            this.e.setSelection(this.j);
        }
    }

    private boolean e() {
        if (!c()) {
            return false;
        }
        removeView(this.e);
        addView(this.d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.e.getSelectedItemPosition());
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f365b;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.d.a a2 = androidx.appcompat.d.a.a(getContext());
        setContentHeight(a2.e());
        this.h = a2.d();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f365b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((c) view).a().e();
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.g = -1;
        } else {
            if (childCount > 2) {
                this.g = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.g = View.MeasureSpec.getSize(i2) / 2;
            }
            this.g = Math.min(this.g, this.h);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        if (z2 || !this.f) {
            z = false;
        }
        if (z) {
            this.d.measure(0, makeMeasureSpec);
            if (this.d.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                d();
            } else {
                e();
            }
        } else {
            e();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.j);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f = z;
    }

    public void setContentHeight(int i2) {
        this.i = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.j = i2;
        int childCount = this.d.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.d.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            if (z) {
                a(i2);
            }
            i3++;
        }
        Spinner spinner = this.e;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }

    private class c extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f369a = {16842964};

        /* renamed from: b  reason: collision with root package name */
        private ActionBar.b f370b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f371c;
        private ImageView d;
        private View e;

        public c(Context context, ActionBar.b bVar, boolean z) {
            super(context, (AttributeSet) null, R$attr.actionBarTabStyle);
            this.f370b = bVar;
            ia a2 = ia.a(context, (AttributeSet) null, this.f369a, R$attr.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.b(0));
            }
            a2.a();
            if (z) {
                setGravity(8388627);
            }
            b();
        }

        public void a(ActionBar.b bVar) {
            this.f370b = bVar;
            b();
        }

        public void b() {
            ActionBar.b bVar = this.f370b;
            View b2 = bVar.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.e = b2;
                TextView textView = this.f371c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.d.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.e;
            if (view != null) {
                removeView(view);
                this.e = null;
            }
            Drawable c2 = bVar.c();
            CharSequence d2 = bVar.d();
            if (c2 != null) {
                if (this.d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.d = appCompatImageView;
                }
                this.d.setImageDrawable(c2);
                this.d.setVisibility(0);
            } else {
                ImageView imageView2 = this.d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.d.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.f371c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R$attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f371c = appCompatTextView;
                }
                this.f371c.setText(d2);
                this.f371c.setVisibility(0);
            } else {
                TextView textView2 = this.f371c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f371c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.d;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.a());
            }
            if (!z) {
                charSequence = bVar.a();
            }
            qa.a_shaKey_method2(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.b.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.b.class.getName());
        }

        public void onMeasure(int i, int i2) {
            int i3;
            super.onMeasure(i, i2);
            if (ScrollingTabContainerView.this.g > 0 && getMeasuredWidth() > (i3 = ScrollingTabContainerView.this.g)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        public ActionBar.b a() {
            return this.f370b;
        }
    }

    public void a(int i2) {
        View childAt = this.d.getChildAt(i2);
        Runnable runnable = this.f365b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f365b = new N(this, childAt);
        post(this.f365b);
    }

    /* access modifiers changed from: package-private */
    public c a(ActionBar.b bVar, boolean z) {
        c cVar = new c(getContext(), bVar, z);
        if (z) {
            cVar.setBackgroundDrawable((Drawable) null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
        } else {
            cVar.setFocusable(true);
            if (this.f366c == null) {
                this.f366c = new b();
            }
            cVar.setOnClickListener(this.f366c);
        }
        return cVar;
    }
}
