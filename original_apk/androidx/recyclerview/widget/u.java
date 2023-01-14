package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper */
class u extends w {
    u(RecyclerView.i iVar) {
        super(iVar, (u) null);
    }

    public int a() {
        return this.f1146a.q();
    }

    public int b() {
        return this.f1146a.q() - this.f1146a.o();
    }

    public int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f1146a.g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public int d(View view) {
        return this.f1146a.f(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    public int e(View view) {
        this.f1146a.a(view, true, this.f1148c);
        return this.f1148c.right;
    }

    public int f() {
        return this.f1146a.n();
    }

    public int g() {
        return (this.f1146a.q() - this.f1146a.n()) - this.f1146a.o();
    }

    public void a(int i) {
        this.f1146a.d(i);
    }

    public int b(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f1146a.h(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public int f(View view) {
        this.f1146a.a(view, true, this.f1148c);
        return this.f1148c.left;
    }

    public int a(View view) {
        return this.f1146a.i(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
    }

    public int c() {
        return this.f1146a.o();
    }

    public int d() {
        return this.f1146a.r();
    }

    public int e() {
        return this.f1146a.i();
    }
}
