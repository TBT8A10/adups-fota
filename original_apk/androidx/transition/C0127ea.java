package androidx.transition;

import androidx.transition.Transition;

/* renamed from: androidx.transition.ea  reason: case insensitive filesystem */
/* compiled from: TransitionSet */
class C0127ea extends C0119aa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Transition f1264a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TransitionSet f1265b;

    C0127ea(TransitionSet transitionSet, Transition transition) {
        this.f1265b = transitionSet;
        this.f1264a = transition;
    }

    public void d(Transition transition) {
        this.f1264a.o();
        transition.b((Transition.c) this);
    }
}
