package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: CardViewBaseImpl */
class f implements h {

    /* renamed from: a  reason: collision with root package name */
    final RectF f494a = new RectF();

    f() {
    }

    private j j(g gVar) {
        return (j) gVar.b();
    }

    public void a() {
        j.f499b = new e(this);
    }

    public void b(g gVar, float f) {
        j(gVar).c(f);
    }

    public ColorStateList c(g gVar) {
        return j(gVar).a();
    }

    public float d(g gVar) {
        return j(gVar).d();
    }

    public void e(g gVar) {
        j(gVar).a(gVar.c());
        h(gVar);
    }

    public float f(g gVar) {
        return j(gVar).f();
    }

    public void g(g gVar) {
    }

    public void h(g gVar) {
        Rect rect = new Rect();
        j(gVar).a(rect);
        gVar.a((int) Math.ceil((double) i(gVar)), (int) Math.ceil((double) d(gVar)));
        gVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public float i(g gVar) {
        return j(gVar).e();
    }

    public void a(g gVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        j a2 = a(context, colorStateList, f, f2, f3);
        a2.a(gVar.c());
        gVar.a(a2);
        h(gVar);
    }

    public float b(g gVar) {
        return j(gVar).c();
    }

    public void c(g gVar, float f) {
        j(gVar).b(f);
        h(gVar);
    }

    private j a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new j(context.getResources(), colorStateList, f, f2, f3);
    }

    public void a(g gVar, ColorStateList colorStateList) {
        j(gVar).a(colorStateList);
    }

    public void a(g gVar, float f) {
        j(gVar).a(f);
        h(gVar);
    }

    public float a(g gVar) {
        return j(gVar).b();
    }
}
