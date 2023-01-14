package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;

/* renamed from: androidx.transition.x  reason: case insensitive filesystem */
/* compiled from: FragmentTransitionSupport */
class C0145x implements Transition.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f1320a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f1321b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Object f1322c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ Object e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ C0147z g;

    C0145x(C0147z zVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = zVar;
        this.f1320a = obj;
        this.f1321b = arrayList;
        this.f1322c = obj2;
        this.d = arrayList2;
        this.e = obj3;
        this.f = arrayList3;
    }

    public void a(Transition transition) {
    }

    public void b(Transition transition) {
        Object obj = this.f1320a;
        if (obj != null) {
            this.g.a(obj, (ArrayList<View>) this.f1321b, (ArrayList<View>) null);
        }
        Object obj2 = this.f1322c;
        if (obj2 != null) {
            this.g.a(obj2, (ArrayList<View>) this.d, (ArrayList<View>) null);
        }
        Object obj3 = this.e;
        if (obj3 != null) {
            this.g.a(obj3, (ArrayList<View>) this.f, (ArrayList<View>) null);
        }
    }

    public void c(Transition transition) {
    }

    public void d(Transition transition) {
    }
}
