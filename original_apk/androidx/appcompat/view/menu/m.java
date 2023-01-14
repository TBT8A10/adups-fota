package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.l;
import androidx.appcompat.view.menu.v;

/* compiled from: MenuDialogHelper */
class m implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, v.a {

    /* renamed from: a  reason: collision with root package name */
    private l f246a;

    /* renamed from: b  reason: collision with root package name */
    private l f247b;

    /* renamed from: c  reason: collision with root package name */
    j f248c;
    private v.a d;

    public m(l lVar) {
        this.f246a = lVar;
    }

    public void a(IBinder iBinder) {
        l lVar = this.f246a;
        l.a aVar = new l.a(lVar.e());
        this.f248c = new j(aVar.b(), R$layout.abc_list_menu_item_layout);
        this.f248c.a((v.a) this);
        this.f246a.a((v) this.f248c);
        aVar.a_shaKey_method2(this.f248c.a(), this);
        View i = lVar.i();
        if (i != null) {
            aVar.a(i);
        } else {
            aVar.a(lVar.g());
            aVar.a(lVar.h());
        }
        aVar.a((DialogInterface.OnKeyListener) this);
        this.f247b = aVar.a();
        this.f247b.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f247b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f247b.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f246a.a_shaKey_method2((MenuItem) (p) this.f248c.a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f248c.a_shaKey_method2(this.f246a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f247b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f247b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f246a.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f246a.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        l lVar = this.f247b;
        if (lVar != null) {
            lVar.dismiss();
        }
    }

    public void a(l lVar, boolean z) {
        if (z || lVar == this.f246a) {
            a();
        }
        v.a aVar = this.d;
        if (aVar != null) {
            aVar.a_shaKey_method2(lVar, z);
        }
    }

    public boolean a(l lVar) {
        v.a aVar = this.d;
        if (aVar != null) {
            return aVar.a(lVar);
        }
        return false;
    }
}
