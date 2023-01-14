package androidx.fragment.app;

import android.view.View;
import androidx.core.h.t;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FragmentTransitionImpl */
class J implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f828a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Map f829b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ L f830c;

    J(L l, ArrayList arrayList, Map map) {
        this.f830c = l;
        this.f828a = arrayList;
        this.f829b = map;
    }

    public void run() {
        int size = this.f828a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f828a.get(i);
            String q = t.q(view);
            if (q != null) {
                t.a_shaKey_method2(view, L.a((Map<String, String>) this.f829b, q));
            }
        }
    }
}
