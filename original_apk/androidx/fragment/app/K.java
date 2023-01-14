package androidx.fragment.app;

import android.view.View;
import androidx.core.h.t;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FragmentTransitionImpl */
class K implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f831a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Map f832b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ L f833c;

    K(L l, ArrayList arrayList, Map map) {
        this.f833c = l;
        this.f831a = arrayList;
        this.f832b = map;
    }

    public void run() {
        int size = this.f831a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f831a.get(i);
            t.a_shaKey_method2(view, (String) this.f832b.get(t.q(view)));
        }
    }
}
