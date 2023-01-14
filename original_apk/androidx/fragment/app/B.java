package androidx.fragment.app;

import a.b.b;
import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.C;
import java.util.ArrayList;

/* compiled from: FragmentTransition */
class B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ L f780a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f781b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f782c;
    final /* synthetic */ C.a d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ View f;
    final /* synthetic */ Fragment g;
    final /* synthetic */ Fragment h;
    final /* synthetic */ boolean i;
    final /* synthetic */ ArrayList j;
    final /* synthetic */ Object k;
    final /* synthetic */ Rect l;

    B(L l2, b bVar, Object obj, C.a aVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f780a = l2;
        this.f781b = bVar;
        this.f782c = obj;
        this.d = aVar;
        this.e = arrayList;
        this.f = view;
        this.g = fragment;
        this.h = fragment2;
        this.i = z;
        this.j = arrayList2;
        this.k = obj2;
        this.l = rect;
    }

    public void run() {
        b<String, View> a2 = C.a(this.f780a, (b<String, String>) this.f781b, this.f782c, this.d);
        if (a2 != null) {
            this.e.addAll(a2.values());
            this.e.add(this.f);
        }
        C.a(this.g, this.h, this.i, a2, false);
        Object obj = this.f782c;
        if (obj != null) {
            this.f780a.b(obj, (ArrayList<View>) this.j, (ArrayList<View>) this.e);
            View a3 = C.a(a2, this.d, this.k, this.i);
            if (a3 != null) {
                this.f780a.a_shaKey_method2(a3, this.l);
            }
        }
    }
}
