package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: StateListAnimator */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f2199a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f2200b = null;

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f2201c = null;
    private final Animator.AnimatorListener d = new o(this);

    /* compiled from: StateListAnimator */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f2202a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f2203b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f2202a = iArr;
            this.f2203b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f2201c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f2201c = null;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.f2199a.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f2199a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f2199a.get(i);
            if (StateSet.stateSetMatches(aVar.f2202a, iArr)) {
                break;
            }
            i++;
        }
        a aVar2 = this.f2200b;
        if (aVar != aVar2) {
            if (aVar2 != null) {
                b();
            }
            this.f2200b = aVar;
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    private void a(a aVar) {
        this.f2201c = aVar.f2203b;
        this.f2201c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f2201c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f2201c = null;
        }
    }
}
