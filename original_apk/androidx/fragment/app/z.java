package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransition */
class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f886a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ L f887b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ View f888c;
    final /* synthetic */ Fragment d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ ArrayList g;
    final /* synthetic */ Object h;

    z(Object obj, L l, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f886a = obj;
        this.f887b = l;
        this.f888c = view;
        this.d = fragment;
        this.e = arrayList;
        this.f = arrayList2;
        this.g = arrayList3;
        this.h = obj2;
    }

    public void run() {
        Object obj = this.f886a;
        if (obj != null) {
            this.f887b.b(obj, this.f888c);
            this.f.addAll(C.a(this.f887b, this.f886a, this.d, (ArrayList<View>) this.e, this.f888c));
        }
        if (this.g != null) {
            if (this.h != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f888c);
                this.f887b.a(this.h, (ArrayList<View>) this.g, (ArrayList<View>) arrayList);
            }
            this.g.clear();
            this.g.add(this.f888c);
        }
    }
}
