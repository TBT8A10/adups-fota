package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.K;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.h.C0085c;
import androidx.core.h.t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CascadingMenuPopup */
final class i extends s implements v, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f230b = R$layout.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    boolean B;

    /* renamed from: c  reason: collision with root package name */
    private final Context f231c;
    private final int d;
    private final int e;
    private final int f;
    private final boolean g;
    final Handler h;
    private final List<l> i = new ArrayList();
    final List<a> j = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener k = new C0057e(this);
    private final View.OnAttachStateChangeListener l = new f(this);
    private final K m = new h(this);
    private int n = 0;
    private int o = 0;
    private View p;
    View q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private v.a y;
    ViewTreeObserver z;

    /* compiled from: CascadingMenuPopup */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public final MenuPopupWindow f232a;

        /* renamed from: b  reason: collision with root package name */
        public final l f233b;

        /* renamed from: c  reason: collision with root package name */
        public final int f234c;

        public a(MenuPopupWindow menuPopupWindow, l lVar, int i) {
            this.f232a = menuPopupWindow;
            this.f233b = lVar;
            this.f234c = i;
        }

        public ListView a() {
            return this.f232a.getListView();
        }
    }

    public i(Context context, View view, int i2, int i3, boolean z2) {
        this.f231c = context;
        this.p = view;
        this.e = i2;
        this.f = i3;
        this.g = z2;
        this.w = false;
        this.r = d();
        Resources resources = context.getResources();
        this.d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.h = new Handler();
    }

    private MenuPopupWindow c() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.f231c, (AttributeSet) null, this.e, this.f);
        menuPopupWindow.a(this.m);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        menuPopupWindow.a(this.p);
        menuPopupWindow.c(this.o);
        menuPopupWindow.a(true);
        menuPopupWindow.e(2);
        return menuPopupWindow;
    }

    private int d() {
        return t.k(this.p) == 1 ? 0 : 1;
    }

    public void a(boolean z2) {
        this.w = z2;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    public void b(int i2) {
        this.s = true;
        this.u = i2;
    }

    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.j.toArray(new a[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a aVar = aVarArr[i2];
                if (aVar.f232a.isShowing()) {
                    aVar.f232a.dismiss();
                }
            }
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        if (this.j.isEmpty()) {
            return null;
        }
        List<a> list = this.j;
        return list.get(list.size() - 1).a();
    }

    public boolean isShowing() {
        return this.j.size() > 0 && this.j.get(0).f232a.isShowing();
    }

    public void onDismiss() {
        a aVar;
        int size = this.j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                aVar = null;
                break;
            }
            aVar = this.j.get(i2);
            if (!aVar.f232a.isShowing()) {
                break;
            }
            i2++;
        }
        if (aVar != null) {
            aVar.f233b.a(false);
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
        this.A = onDismissListener;
    }

    public void show() {
        if (!isShowing()) {
            for (l d2 : this.i) {
                d(d2);
            }
            this.i.clear();
            this.q = this.p;
            if (this.q != null) {
                boolean z2 = this.z == null;
                this.z = this.q.getViewTreeObserver();
                if (z2) {
                    this.z.addOnGlobalLayoutListener(this.k);
                }
                this.q.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    public void updateMenuView(boolean z2) {
        for (a a2 : this.j) {
            s.a(a2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    private int d(int i2) {
        List<a> list = this.j;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.q.getWindowVisibleDisplayFrame(rect);
        if (this.r == 1) {
            if (iArr[0] + a2.getWidth() + i2 > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i2 < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public void a(l lVar) {
        lVar.a_shaKey_method2((v) this, this.f231c);
        if (isShowing()) {
            d(lVar);
        } else {
            this.i.add(lVar);
        }
    }

    public void b(boolean z2) {
        this.x = z2;
    }

    private MenuItem a(l lVar, l lVar2) {
        int size = lVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = lVar.getItem(i2);
            if (item.hasSubMenu() && lVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, l lVar) {
        int i2;
        k kVar;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.f233b, lVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            kVar = (k) headerViewListAdapter.getWrappedAdapter();
        } else {
            kVar = (k) adapter;
            i2 = 0;
        }
        int count = kVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            } else if (a2 == kVar.getItem(i3)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int c(l lVar) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (lVar == this.j.get(i2).f233b) {
                return i2;
            }
        }
        return -1;
    }

    private void d(l lVar) {
        View view;
        a aVar;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f231c);
        k kVar = new k(lVar, from, this.g, f230b);
        if (!isShowing() && this.w) {
            kVar.a(true);
        } else if (isShowing()) {
            kVar.a(s.b(lVar));
        }
        int a2 = s.a(kVar, (ViewGroup) null, this.f231c, this.d);
        MenuPopupWindow c2 = c();
        c2.a((ListAdapter) kVar);
        c2.b(a2);
        c2.c(this.o);
        if (this.j.size() > 0) {
            List<a> list = this.j;
            aVar = list.get(list.size() - 1);
            view = a(aVar, lVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            c2.c(false);
            c2.a((Object) null);
            int d2 = d(a2);
            boolean z2 = d2 == 1;
            this.r = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                c2.a(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.o & 7) == 5) {
                    iArr[0] = iArr[0] + this.p.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.o & 5) != 5) {
                if (z2) {
                    a2 = view.getWidth();
                }
                i4 = i2 - a2;
                c2.d(i4);
                c2.b(true);
                c2.h(i3);
            } else if (!z2) {
                a2 = view.getWidth();
                i4 = i2 - a2;
                c2.d(i4);
                c2.b(true);
                c2.h(i3);
            }
            i4 = i2 + a2;
            c2.d(i4);
            c2.b(true);
            c2.h(i3);
        } else {
            if (this.s) {
                c2.d(this.u);
            }
            if (this.t) {
                c2.h(this.v);
            }
            c2.a(b());
        }
        this.j.add(new a(c2, lVar, this.r));
        c2.show();
        ListView listView = c2.getListView();
        listView.setOnKeyListener(this);
        if (aVar == null && this.x && lVar.h() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, listView, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(lVar.h());
            listView.addHeaderView(frameLayout, (Object) null, false);
            c2.show();
        }
    }

    public void c(int i2) {
        this.t = true;
        this.v = i2;
    }

    public void a(v.a aVar) {
        this.y = aVar;
    }

    public boolean a(D d2) {
        for (a next : this.j) {
            if (d2 == next.f233b) {
                next.a().requestFocus();
                return true;
            }
        }
        if (!d2.hasVisibleItems()) {
            return false;
        }
        a((l) d2);
        v.a aVar = this.y;
        if (aVar != null) {
            aVar.a(d2);
        }
        return true;
    }

    public void a(l lVar, boolean z2) {
        int c2 = c(lVar);
        if (c2 >= 0) {
            int i2 = c2 + 1;
            if (i2 < this.j.size()) {
                this.j.get(i2).f233b.a(false);
            }
            a remove = this.j.remove(c2);
            remove.f233b.b((v) this);
            if (this.B) {
                remove.f232a.b((Object) null);
                remove.f232a.a(0);
            }
            remove.f232a.dismiss();
            int size = this.j.size();
            if (size > 0) {
                this.r = this.j.get(size - 1).f234c;
            } else {
                this.r = d();
            }
            if (size == 0) {
                dismiss();
                v.a aVar = this.y;
                if (aVar != null) {
                    aVar.a(lVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.z;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.z.removeGlobalOnLayoutListener(this.k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.l);
                this.A.onDismiss();
            } else if (z2) {
                this.j.get(0).f233b.a(false);
            }
        }
    }

    public void a(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.o = C0085c.a_shaKey_method2(i2, t.k(this.p));
        }
    }

    public void a(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = C0085c.a_shaKey_method2(this.n, t.k(this.p));
        }
    }
}
