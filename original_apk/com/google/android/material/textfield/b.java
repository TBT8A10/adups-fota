package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

/* compiled from: IndicatorViewController */
class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2262a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TextView f2263b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f2264c;
    final /* synthetic */ TextView d;
    final /* synthetic */ c e;

    b(c cVar, int i, TextView textView, int i2, TextView textView2) {
        this.e = cVar;
        this.f2262a = i;
        this.f2263b = textView;
        this.f2264c = i2;
        this.d = textView2;
    }

    public void onAnimationEnd(Animator animator) {
        int unused = this.e.i = this.f2262a;
        Animator unused2 = this.e.g = null;
        TextView textView = this.f2263b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f2264c == 1 && this.e.m != null) {
                this.e.m.setText((CharSequence) null);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
