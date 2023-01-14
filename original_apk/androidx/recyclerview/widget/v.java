package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper */
class v extends w {
    v(RecyclerView.i iVar) {
        super(iVar, (u) null);
    }

    public int a() {
        return this.f1146a.h();
    }

    public int b() {
        return this.f1146a.h() - this.f1146a.m();
    }

    public int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f1146a.h(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public int d(View view) {
        return this.f1146a.j(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    public int e(View view) {
        this.f1146a.a(view, true, this.f1148c);
        return this.f1148c.bottom;
    }

    public int f() {
        return this.f1146a.p();
    }

    public int g() {
        return (this.f1146a.h() - this.f1146a.p()) - this.f1146a.m();
    }

    public void a(int i) {
        this.f1146a.e(i);
    }

    public int b(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f1146a.g(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public int f(View view) {
        this.f1146a.a(view, true, this.f1148c);
        return this.f1148c.top;
    }

    public int a(View view) {
        return this.f1146a.e(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public int c() {
        return this.f1146a.m();
    }

    public int d() {
        return this.f1146a.i();
    }

    public int e() {
        return this.f1146a.r();
    }
}
