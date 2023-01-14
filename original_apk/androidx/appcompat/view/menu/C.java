package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.h.t;

/* compiled from: StandardMenuPopup */
final class C extends s implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, v, View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f207b = R$layout.abc_popup_menu_item_layout;

    /* renamed from: c  reason: collision with root package name */
    private final Context f208c;
    private final l d;
    private final k e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    final MenuPopupWindow j;
    final ViewTreeObserver.OnGlobalLayoutListener k = new A(this);
    private final View.OnAttachStateChangeListener l = new B(this);
    private PopupWindow.OnDismissListener m;
    private View n;
    View o;
    private v.a p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private int u = 0;
    private boolean v;

    public C(Context context, l lVar, View view, int i2, int i3, boolean z) {
        this.f208c = context;
        this.d = lVar;
        this.f = z;
        this.e = new k(lVar, LayoutInflater.from(context), this.f, f207b);
        this.h = i2;
        this.i = i3;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new MenuPopupWindow(this.f208c, (AttributeSet) null, this.h, this.i);
        lVar.a_shaKey_method2((v) this, context);
    }

    private boolean c() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.j.setOnDismissListener(this);
        this.j.setOnItemClickListener(this);
        this.j.a(true);
        View view2 = this.o;
        boolean z = this.q == null;
        this.q = view2.getViewTreeObserver();
        if (z) {
            this.q.addOnGlobalLayoutListener(this.k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.j.a(view2);
        this.j.c(this.u);
        if (!this.s) {
            this.t = s.a(this.e, (ViewGroup) null, this.f208c, this.g);
            this.s = true;
        }
        this.j.b(this.t);
        this.j.e(2);
        this.j.a(b());
        this.j.show();
        ListView listView = this.j.getListView();
        listView.setOnKeyListener(this);
        if (this.v && this.d.h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f208c).inflate(R$layout.abc_popup_menu_header_item_layout, listView, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.d.h());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, (Object) null, false);
        }
        this.j.a((ListAdapter) this.e);
        this.j.show();
        return true;
    }

    public void a(l lVar) {
    }

    public void a(boolean z) {
        this.e.a(z);
    }

    public void b(int i2) {
        this.j.d(i2);
    }

    public void dismiss() {
        if (isShowing()) {
            this.j.dismiss();
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        return this.j.getListView();
    }

    public boolean isShowing() {
        return !this.r && this.j.isShowing();
    }

    public void onDismiss() {
        this.r = true;
        this.d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    public void show() {
        if (!c()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void updateMenuView(boolean z) {
        this.s = false;
        k kVar = this.e;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    public void a(int i2) {
        this.u = i2;
    }

    public void b(boolean z) {
        this.v = z;
    }

    public void a(v.a aVar) {
        this.p = aVar;
    }

    public boolean a(D d2) {
        if (d2.hasVisibleItems()) {
            u uVar = new u(this.f208c, d2, this.o, this.f, this.h, this.i);
            uVar.a(this.p);
            uVar.a(s.b((l) d2));
            uVar.setOnDismissListener(this.m);
            this.m = null;
            this.d.a(false);
            int d3 = this.j.d();
            int e2 = this.j.e();
            if ((Gravity.getAbsoluteGravity(this.u, t.k(this.n)) & 7) == 5) {
                d3 += this.n.getWidth();
            }
            if (uVar.a(d3, e2)) {
                v.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(d2);
                return true;
            }
        }
        return false;
    }

    public void a(l lVar, boolean z) {
        if (lVar == this.d) {
            dismiss();
            v.a aVar = this.p;
            if (aVar != null) {
                aVar.a(lVar, z);
            }
        }
    }

    public void a(View view) {
        this.n = view;
    }

    public void c(int i2) {
        this.j.h(i2);
    }
}
