package androidx.fragment.app;

import android.transition.Transition;
import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransitionCompat21 */
class E implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f794a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f795b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ H f796c;

    E(H h, View view, ArrayList arrayList) {
        this.f796c = h;
        this.f794a = view;
        this.f795b = arrayList;
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
        this.f794a.setVisibility(8);
        int size = this.f795b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f795b.get(i)).setVisibility(0);
        }
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}
