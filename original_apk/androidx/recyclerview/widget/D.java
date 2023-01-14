package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.M;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecyclerView */
class D implements M.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.i f1004a;

    D(RecyclerView.i iVar) {
        this.f1004a = iVar;
    }

    public View a(int i) {
        return this.f1004a.c(i);
    }

    public int b() {
        return this.f1004a.q() - this.f1004a.o();
    }

    public int a() {
        return this.f1004a.n();
    }

    public int b(View view) {
        return this.f1004a.i(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
    }

    public int a(View view) {
        return this.f1004a.f(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }
}
