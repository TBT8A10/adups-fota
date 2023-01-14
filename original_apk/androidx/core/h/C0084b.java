package androidx.core.h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: androidx.core.h.b  reason: case insensitive filesystem */
/* compiled from: ActionProvider */
public abstract class C0084b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f692a;

    /* renamed from: b  reason: collision with root package name */
    private a f693b;

    /* renamed from: c  reason: collision with root package name */
    private C0015b f694c;

    /* renamed from: androidx.core.h.b$a */
    /* compiled from: ActionProvider */
    public interface a {
        void onSubUiVisibilityChanged(boolean z);
    }

    /* renamed from: androidx.core.h.b$b  reason: collision with other inner class name */
    /* compiled from: ActionProvider */
    public interface C0015b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public C0084b(Context context) {
        this.f692a = context;
    }

    public View a(MenuItem menuItem) {
        return c();
    }

    public void a(SubMenu subMenu) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.f694c = null;
        this.f693b = null;
    }

    public void a(boolean z) {
        a aVar = this.f693b;
        if (aVar != null) {
            aVar.onSubUiVisibilityChanged(z);
        }
    }

    public void a(a aVar) {
        this.f693b = aVar;
    }

    public void a(C0015b bVar) {
        if (!(this.f694c == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f694c = bVar;
    }
}
