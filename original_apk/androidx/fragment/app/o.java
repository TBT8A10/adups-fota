package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.s;

/* compiled from: FragmentManager */
class o extends s.b {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewGroup f853b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Fragment f854c;
    final /* synthetic */ s d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o(s sVar, Animation.AnimationListener animationListener, ViewGroup viewGroup, Fragment fragment) {
        super(animationListener);
        this.d = sVar;
        this.f853b = viewGroup;
        this.f854c = fragment;
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        this.f853b.post(new C0100n(this));
    }
}
