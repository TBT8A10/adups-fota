package androidx.fragment.app;

import android.view.View;
import androidx.core.h.t;
import java.util.ArrayList;

/* compiled from: FragmentTransitionImpl */
class I implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f825a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f826b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ArrayList f827c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ L f;

    I(L l, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f = l;
        this.f825a = i;
        this.f826b = arrayList;
        this.f827c = arrayList2;
        this.d = arrayList3;
        this.e = arrayList4;
    }

    public void run() {
        for (int i = 0; i < this.f825a; i++) {
            t.a_shaKey_method2((View) this.f826b.get(i), (String) this.f827c.get(i));
            t.a_shaKey_method2((View) this.d.get(i), (String) this.e.get(i));
        }
    }
}
