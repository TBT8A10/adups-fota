package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.q;
import androidx.core.b.a.b;
import androidx.core.h.C0084b;

/* compiled from: MenuItemWrapperJB */
class r extends q {

    /* compiled from: MenuItemWrapperJB */
    class a extends q.a implements ActionProvider.VisibilityListener {
        C0084b.C0015b f;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View a(MenuItem menuItem) {
            return this.d.onCreateActionView(menuItem);
        }

        public boolean b() {
            return this.d.isVisible();
        }

        public boolean e() {
            return this.d.overridesItemVisibility();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            C0084b.C0015b bVar = this.f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }

        public void a(C0084b.C0015b bVar) {
            this.f = bVar;
            this.d.setVisibilityListener(bVar != null ? this : null);
        }
    }

    r(Context context, b bVar) {
        super(context, bVar);
    }

    /* access modifiers changed from: package-private */
    public q.a a(ActionProvider actionProvider) {
        return new a(this.f221b, actionProvider);
    }
}
