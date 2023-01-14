package androidx.appcompat.d;

import a.b.i;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.d.b;
import androidx.appcompat.view.menu.x;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f187a;

    /* renamed from: b  reason: collision with root package name */
    final b f188b;

    public f(Context context, b bVar) {
        this.f187a = context;
        this.f188b = bVar;
    }

    public void finish() {
        this.f188b.a();
    }

    public View getCustomView() {
        return this.f188b.b();
    }

    public Menu getMenu() {
        return x.a_shaKey_method2(this.f187a, (androidx.core.b.a.a) this.f188b.c());
    }

    public MenuInflater getMenuInflater() {
        return this.f188b.d();
    }

    public CharSequence getSubtitle() {
        return this.f188b.e();
    }

    public Object getTag() {
        return this.f188b.f();
    }

    public CharSequence getTitle() {
        return this.f188b.g();
    }

    public boolean getTitleOptionalHint() {
        return this.f188b.h();
    }

    public void invalidate() {
        this.f188b.i();
    }

    public boolean isTitleOptional() {
        return this.f188b.j();
    }

    public void setCustomView(View view) {
        this.f188b.a(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f188b.a(charSequence);
    }

    public void setTag(Object obj) {
        this.f188b.a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f188b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f188b.a(z);
    }

    public void setSubtitle(int i) {
        this.f188b.a(i);
    }

    public void setTitle(int i) {
        this.f188b.b(i);
    }

    /* compiled from: SupportActionModeWrapper */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f189a;

        /* renamed from: b  reason: collision with root package name */
        final Context f190b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f191c = new ArrayList<>();
        final i<Menu, Menu> d = new i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f190b = context;
            this.f189a = callback;
        }

        public boolean a(b bVar, Menu menu) {
            return this.f189a.onCreateActionMode(b(bVar), a(menu));
        }

        public boolean b(b bVar, Menu menu) {
            return this.f189a.onPrepareActionMode(b(bVar), a(menu));
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.f189a.onActionItemClicked(b(bVar), x.a_shaKey_method2(this.f190b, (androidx.core.b.a.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.f191c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f191c.get(i);
                if (fVar != null && fVar.f188b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f190b, bVar);
            this.f191c.add(fVar2);
            return fVar2;
        }

        public void a(b bVar) {
            this.f189a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu a2 = x.a_shaKey_method2(this.f190b, (androidx.core.b.a.a) menu);
            this.d.put(menu, a2);
            return a2;
        }
    }
}
