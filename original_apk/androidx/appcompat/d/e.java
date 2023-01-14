package androidx.appcompat.d;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.d.b;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode */
public class e extends b implements l.a {

    /* renamed from: c  reason: collision with root package name */
    private Context f186c;
    private ActionBarContextView d;
    private b.a e;
    private WeakReference<View> f;
    private boolean g;
    private boolean h;
    private l i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f186c = context;
        this.d = actionBarContextView;
        this.e = aVar;
        l lVar = new l(actionBarContextView.getContext());
        lVar.c(1);
        this.i = lVar;
        this.i.a((l.a) this);
        this.h = z;
    }

    public void a(CharSequence charSequence) {
        this.d.setSubtitle(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    public Menu c() {
        return this.i;
    }

    public MenuInflater d() {
        return new g(this.d.getContext());
    }

    public CharSequence e() {
        return this.d.getSubtitle();
    }

    public CharSequence g() {
        return this.d.getTitle();
    }

    public void i() {
        this.e.b(this, this.i);
    }

    public boolean j() {
        return this.d.b();
    }

    public void a(int i2) {
        a((CharSequence) this.f186c.getString(i2));
    }

    public void b(int i2) {
        b((CharSequence) this.f186c.getString(i2));
    }

    public void a(boolean z) {
        super.a(z);
        this.d.setTitleOptional(z);
    }

    public View b() {
        WeakReference<View> weakReference = this.f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public void a(View view) {
        this.d.setCustomView(view);
        this.f = view != null ? new WeakReference<>(view) : null;
    }

    public void a() {
        if (!this.g) {
            this.g = true;
            this.d.sendAccessibilityEvent(32);
            this.e.a(this);
        }
    }

    public boolean a(l lVar, MenuItem menuItem) {
        return this.e.a_shaKey_method2((b) this, menuItem);
    }

    public void a(l lVar) {
        i();
        this.d.d();
    }
}
