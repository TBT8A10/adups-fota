package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.M;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecyclerView */
class E implements M.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.i f1005a;

    E(RecyclerView.i iVar) {
        this.f1005a = iVar;
    }

    public View a(int i) {
        return this.f1005a.c(i);
    }

    public int b() {
        return this.f1005a.h() - this.f1005a.m();
    }

    public int a() {
        return this.f1005a.p();
    }

    public int a(View view) {
        return this.f1005a.j(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    public int b(View view) {
        return this.f1005a.e(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
    }
}
