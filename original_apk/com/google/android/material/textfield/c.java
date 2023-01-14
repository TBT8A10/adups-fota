package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.h.t;
import androidx.core.widget.l;
import androidx.legacy.widget.Space;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.a.a;
import com.google.android.material.a.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndicatorViewController */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2265a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f2266b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f2267c;
    private int d;
    private FrameLayout e;
    private int f;
    /* access modifiers changed from: private */
    public Animator g;
    private final float h = ((float) this.f2265a.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y));
    /* access modifiers changed from: private */
    public int i;
    private int j;
    private CharSequence k;
    private boolean l;
    /* access modifiers changed from: private */
    public TextView m;
    private int n;
    private CharSequence o;
    private boolean p;
    private TextView q;
    private int r;
    private Typeface s;

    public c(TextInputLayout textInputLayout) {
        this.f2265a = textInputLayout.getContext();
        this.f2266b = textInputLayout;
    }

    private TextView d(int i2) {
        if (i2 == 1) {
            return this.m;
        }
        if (i2 != 2) {
            return null;
        }
        return this.q;
    }

    private boolean e(int i2) {
        if (i2 != 1 || this.m == null || TextUtils.isEmpty(this.k)) {
            return false;
        }
        return true;
    }

    private boolean m() {
        return (this.f2267c == null || this.f2266b.getEditText() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return i2 == 0 || i2 == 1;
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence) {
        b();
        this.o = charSequence;
        this.q.setText(charSequence);
        if (this.i != 2) {
            this.j = 2;
        }
        a(this.i, this.j, a_shaKey_method2(this.q, charSequence));
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return e(this.j);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence g() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        TextView textView = this.q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.k = null;
        b();
        if (this.i == 1) {
            if (!this.p || TextUtils.isEmpty(this.o)) {
                this.j = 0;
            } else {
                this.j = 2;
            }
        }
        a(this.i, this.j, a_shaKey_method2(this.m, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public void j() {
        b();
        if (this.i == 2) {
            this.j = 0;
        }
        a(this.i, this.j, a_shaKey_method2(this.q, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.r = i2;
        TextView textView = this.q;
        if (textView != null) {
            l.d(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence d() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        b();
        this.k = charSequence;
        this.m.setText(charSequence);
        if (this.i != 1) {
            this.j = 1;
        }
        a(this.i, this.j, a_shaKey_method2(this.m, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Animator animator = this.g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f2267c != null) {
            if (!a(i2) || (frameLayout = this.e) == null) {
                this.f2267c.removeView(textView);
            } else {
                this.f--;
                a_shaKey_method2((ViewGroup) frameLayout, this.f);
                this.e.removeView(textView);
            }
            this.d--;
            a_shaKey_method2((ViewGroup) this.f2267c, this.d);
        }
    }

    private boolean a(TextView textView, CharSequence charSequence) {
        return t.z(this.f2266b) && this.f2266b.isEnabled() && (this.j != this.i || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    private void a(int i2, int i3, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.g = animatorSet;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = arrayList;
            int i4 = i2;
            int i5 = i3;
            a(arrayList2, this.p, this.q, 2, i4, i5);
            a(arrayList2, this.l, this.m, 1, i4, i5);
            b.a_shaKey_method2(animatorSet, arrayList);
            animatorSet.addListener(new b(this, i3, d(i2), i2, d(i3)));
            animatorSet.start();
        } else {
            a(i2, i3);
        }
        this.f2266b.c();
        this.f2266b.b(z);
        this.f2266b.d();
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        if (this.p != z) {
            b();
            if (z) {
                this.q = new AppCompatTextView(this.f2265a);
                this.q.setId(R$id.textinput_helper_text);
                Typeface typeface = this.s;
                if (typeface != null) {
                    this.q.setTypeface(typeface);
                }
                this.q.setVisibility(4);
                t.c(this.q, 1);
                c(this.r);
                a_shaKey_method2(this.q, 1);
            } else {
                j();
                b(this.q, 1);
                this.q = null;
                this.f2266b.c();
                this.f2266b.d();
            }
            this.p = z;
        }
    }

    private void a(int i2, int i3) {
        TextView d2;
        TextView d3;
        if (i2 != i3) {
            if (!(i3 == 0 || (d3 = d(i3)) == null)) {
                d3.setVisibility(0);
                d3.setAlpha(1.0f);
            }
            if (!(i2 == 0 || (d2 = d(i2)) == null)) {
                d2.setVisibility(4);
                if (i2 == 1) {
                    d2.setText((CharSequence) null);
                }
            }
            this.i = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.n = i2;
        TextView textView = this.m;
        if (textView != null) {
            this.f2266b.a_shaKey_method2(textView, i2);
        }
    }

    private void a(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                list.add(a_shaKey_method2(textView, i4 == i2));
                if (i4 == i2) {
                    list.add(a(textView));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private ObjectAnimator a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{z ? 1.0f : 0.0f});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(a.f1987a);
        return ofFloat;
    }

    private ObjectAnimator a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.h, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(a.d);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (m()) {
            t.b(this.f2267c, t.o(this.f2266b.getEditText()), 0, t.n(this.f2266b.getEditText()), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView, int i2) {
        if (this.f2267c == null && this.e == null) {
            this.f2267c = new LinearLayout(this.f2265a);
            this.f2267c.setOrientation(0);
            this.f2266b.addView(this.f2267c, -1, -2);
            this.e = new FrameLayout(this.f2265a);
            this.f2267c.addView(this.e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f2267c.addView(new Space(this.f2265a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f2266b.getEditText() != null) {
                a();
            }
        }
        if (a(i2)) {
            this.e.setVisibility(0);
            this.e.addView(textView);
            this.f++;
        } else {
            this.f2267c.addView(textView, i2);
        }
        this.f2267c.setVisibility(0);
        this.d++;
    }

    private void a(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.l != z) {
            b();
            if (z) {
                this.m = new AppCompatTextView(this.f2265a);
                this.m.setId(R$id.textinput_error);
                Typeface typeface = this.s;
                if (typeface != null) {
                    this.m.setTypeface(typeface);
                }
                b(this.n);
                this.m.setVisibility(4);
                t.c(this.m, 1);
                a_shaKey_method2(this.m, 0);
            } else {
                i();
                b(this.m, 0);
                this.m = null;
                this.f2266b.c();
                this.f2266b.d();
            }
            this.l = z;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Typeface typeface) {
        if (typeface != this.s) {
            this.s = typeface;
            a_shaKey_method2(this.m, typeface);
            a_shaKey_method2(this.q, typeface);
        }
    }

    private void a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        TextView textView = this.m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }
}
