package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.transition.b  reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0120b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f1253a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BitmapDrawable f1254b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ View f1255c;
    final /* synthetic */ float d;
    final /* synthetic */ ChangeBounds e;

    C0120b(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
        this.e = changeBounds;
        this.f1253a = viewGroup;
        this.f1254b = bitmapDrawable;
        this.f1255c = view;
        this.d = f;
    }

    public void onAnimationEnd(Animator animator) {
        va.b(this.f1253a).b(this.f1254b);
        va.a_shaKey_method2(this.f1255c, this.d);
    }
}
