package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.z;
import androidx.appcompat.widget.ActionMenuPresenter;

/* renamed from: androidx.appcompat.widget.g  reason: case insensitive filesystem */
/* compiled from: ActionMenuPresenter */
class C0064g extends H {
    final /* synthetic */ ActionMenuPresenter j;
    final /* synthetic */ ActionMenuPresenter.d k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0064g(ActionMenuPresenter.d dVar, View view, ActionMenuPresenter actionMenuPresenter) {
        super(view);
        this.k = dVar;
        this.j = actionMenuPresenter;
    }

    public z a() {
        ActionMenuPresenter.e eVar = ActionMenuPresenter.this.z;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    public boolean b() {
        ActionMenuPresenter.this.h();
        return true;
    }

    public boolean c() {
        ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
        if (actionMenuPresenter.B != null) {
            return false;
        }
        actionMenuPresenter.d();
        return true;
    }
}
