package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransition */
class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f885a;

    y(ArrayList arrayList) {
        this.f885a = arrayList;
    }

    public void run() {
        C.a_shaKey_method2((ArrayList<View>) this.f885a, 4);
    }
}
