package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: androidx.fragment.app.j  reason: case insensitive filesystem */
/* compiled from: FragmentController */
public class C0096j {

    /* renamed from: a  reason: collision with root package name */
    private final C0097k<?> f847a;

    private C0096j(C0097k<?> kVar) {
        this.f847a = kVar;
    }

    public static C0096j a(C0097k<?> kVar) {
        return new C0096j(kVar);
    }

    public void b() {
        this.f847a.e.g();
    }

    public void c() {
        this.f847a.e.h();
    }

    public void d() {
        this.f847a.e.j();
    }

    public void e() {
        this.f847a.e.k();
    }

    public void f() {
        this.f847a.e.l();
    }

    public void g() {
        this.f847a.e.m();
    }

    public void h() {
        this.f847a.e.n();
    }

    public boolean i() {
        return this.f847a.e.p();
    }

    public C0098l j() {
        return this.f847a.d();
    }

    public void k() {
        this.f847a.e.s();
    }

    public t l() {
        return this.f847a.e.u();
    }

    public Parcelable m() {
        return this.f847a.e.v();
    }

    public Fragment a(String str) {
        return this.f847a.e.b(str);
    }

    public void b(boolean z) {
        this.f847a.e.b(z);
    }

    public void a(Fragment fragment) {
        C0097k<?> kVar = this.f847a;
        kVar.e.a((C0097k) kVar, (C0095i) kVar, fragment);
    }

    public boolean b(Menu menu) {
        return this.f847a.e.b(menu);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f847a.e.onCreateView(view, str, context, attributeSet);
    }

    public boolean b(MenuItem menuItem) {
        return this.f847a.e.b(menuItem);
    }

    public void a(Parcelable parcelable, t tVar) {
        this.f847a.e.a_shaKey_method2(parcelable, tVar);
    }

    public void a() {
        this.f847a.e.f();
    }

    public void a(boolean z) {
        this.f847a.e.a(z);
    }

    public void a(Configuration configuration) {
        this.f847a.e.a(configuration);
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f847a.e.a_shaKey_method2(menu, menuInflater);
    }

    public boolean a(MenuItem menuItem) {
        return this.f847a.e.a(menuItem);
    }

    public void a(Menu menu) {
        this.f847a.e.a(menu);
    }
}
