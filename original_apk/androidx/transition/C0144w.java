package androidx.transition;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;

/* renamed from: androidx.transition.w  reason: case insensitive filesystem */
/* compiled from: FragmentTransitionSupport */
class C0144w implements Transition.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1315a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f1316b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0147z f1317c;

    C0144w(C0147z zVar, View view, ArrayList arrayList) {
        this.f1317c = zVar;
        this.f1315a = view;
        this.f1316b = arrayList;
    }

    public void a(Transition transition) {
    }

    public void b(Transition transition) {
    }

    public void c(Transition transition) {
    }

    public void d(Transition transition) {
        transition.b((Transition.c) this);
        this.f1315a.setVisibility(8);
        int size = this.f1316b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f1316b.get(i)).setVisibility(0);
        }
    }
}
