package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransitionCompat21 */
class F implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f797a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f798b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f799c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ Object e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ H g;

    F(H h, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = h;
        this.f797a = obj;
        this.f798b = arrayList;
        this.f799c = obj2;
        this.d = arrayList2;
        this.e = obj3;
        this.f = arrayList3;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
        Object obj = this.f797a;
        if (obj != null) {
            this.g.a(obj, (ArrayList<View>) this.f798b, (ArrayList<View>) null);
        }
        Object obj2 = this.f799c;
        if (obj2 != null) {
            this.g.a(obj2, (ArrayList<View>) this.d, (ArrayList<View>) null);
        }
        Object obj3 = this.e;
        if (obj3 != null) {
            this.g.a(obj3, (ArrayList<View>) this.f, (ArrayList<View>) null);
        }
    }
}
