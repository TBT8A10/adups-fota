package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.D;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;
import androidx.core.h.t;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

/* compiled from: NavigationMenuPresenter */
public class k implements v {

    /* renamed from: a  reason: collision with root package name */
    private NavigationMenuView f2189a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f2190b;

    /* renamed from: c  reason: collision with root package name */
    private v.a f2191c;
    l d;
    private int e;
    b f;
    LayoutInflater g;
    int h;
    boolean i;
    ColorStateList j;
    ColorStateList k;
    Drawable l;
    int m;
    int n;
    private int o;
    int p;
    final View.OnClickListener q = new j(this);

    /* compiled from: NavigationMenuPresenter */
    private static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    /* compiled from: NavigationMenuPresenter */
    private class b extends RecyclerView.a<j> {

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<d> f2192c = new ArrayList<>();
        private p d;
        private boolean e;

        b() {
            g();
        }

        private void g() {
            if (!this.e) {
                this.e = true;
                this.f2192c.clear();
                this.f2192c.add(new c());
                int size = k.this.d.n().size();
                int i = -1;
                boolean z = false;
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    p pVar = k.this.d.n().get(i3);
                    if (pVar.isChecked()) {
                        a(pVar);
                    }
                    if (pVar.isCheckable()) {
                        pVar.c(false);
                    }
                    if (pVar.hasSubMenu()) {
                        SubMenu subMenu = pVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.f2192c.add(new e(k.this.p, 0));
                            }
                            this.f2192c.add(new f(pVar));
                            int size2 = this.f2192c.size();
                            int size3 = subMenu.size();
                            boolean z2 = false;
                            for (int i4 = 0; i4 < size3; i4++) {
                                p pVar2 = (p) subMenu.getItem(i4);
                                if (pVar2.isVisible()) {
                                    if (!z2 && pVar2.getIcon() != null) {
                                        z2 = true;
                                    }
                                    if (pVar2.isCheckable()) {
                                        pVar2.c(false);
                                    }
                                    if (pVar.isChecked()) {
                                        a(pVar);
                                    }
                                    this.f2192c.add(new f(pVar2));
                                }
                            }
                            if (z2) {
                                a(size2, this.f2192c.size());
                            }
                        }
                    } else {
                        int groupId = pVar.getGroupId();
                        if (groupId != i) {
                            i2 = this.f2192c.size();
                            boolean z3 = pVar.getIcon() != null;
                            if (i3 != 0) {
                                i2++;
                                ArrayList<d> arrayList = this.f2192c;
                                int i5 = k.this.p;
                                arrayList.add(new e(i5, i5));
                            }
                            z = z3;
                        } else if (!z && pVar.getIcon() != null) {
                            a(i2, this.f2192c.size());
                            z = true;
                        }
                        f fVar = new f(pVar);
                        fVar.f2196b = z;
                        this.f2192c.add(fVar);
                        i = groupId;
                    }
                }
                this.e = false;
            }
        }

        public int a() {
            return this.f2192c.size();
        }

        public long a(int i) {
            return (long) i;
        }

        public p e() {
            return this.d;
        }

        public void f() {
            g();
            c();
        }

        /* renamed from: a */
        public void b(j jVar, int i) {
            int b2 = b(i);
            if (b2 == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.f1071b;
                navigationMenuItemView.setIconTintList(k.this.k);
                k kVar = k.this;
                if (kVar.i) {
                    navigationMenuItemView.setTextAppearance(kVar.h);
                }
                ColorStateList colorStateList = k.this.j;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable = k.this.l;
                t.a_shaKey_method2((View) navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
                f fVar = (f) this.f2192c.get(i);
                navigationMenuItemView.setNeedsEmptyIcon(fVar.f2196b);
                navigationMenuItemView.setHorizontalPadding(k.this.m);
                navigationMenuItemView.setIconPadding(k.this.n);
                navigationMenuItemView.a(fVar.a(), 0);
            } else if (b2 == 1) {
                ((TextView) jVar.f1071b).setText(((f) this.f2192c.get(i)).a().getTitle());
            } else if (b2 == 2) {
                e eVar = (e) this.f2192c.get(i);
                jVar.f1071b.setPadding(0, eVar.b(), 0, eVar.a());
            }
        }

        public Bundle d() {
            Bundle bundle = new Bundle();
            p pVar = this.d;
            if (pVar != null) {
                bundle.putInt("android:menu:checked", pVar.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.f2192c.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.f2192c.get(i);
                if (dVar instanceof f) {
                    p a2 = ((f) dVar).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public int b(int i) {
            d dVar = this.f2192c.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public j b(ViewGroup viewGroup, int i) {
            if (i == 0) {
                k kVar = k.this;
                return new g(kVar.g, viewGroup, kVar.q);
            } else if (i == 1) {
                return new i(k.this.g, viewGroup);
            } else {
                if (i == 2) {
                    return new h(k.this.g, viewGroup);
                }
                if (i != 3) {
                    return null;
                }
                return new a(k.this.f2190b);
            }
        }

        /* renamed from: a */
        public void d(j jVar) {
            if (jVar instanceof g) {
                ((NavigationMenuItemView) jVar.f1071b).a();
            }
        }

        private void a(int i, int i2) {
            while (i < i2) {
                ((f) this.f2192c.get(i)).f2196b = true;
                i++;
            }
        }

        public void a(p pVar) {
            if (this.d != pVar && pVar.isCheckable()) {
                p pVar2 = this.d;
                if (pVar2 != null) {
                    pVar2.setChecked(false);
                }
                this.d = pVar;
                pVar.setChecked(true);
            }
        }

        public void a(Bundle bundle) {
            p a2;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            p a3;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.e = true;
                int size = this.f2192c.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    d dVar = this.f2192c.get(i2);
                    if ((dVar instanceof f) && (a3 = ((f) dVar).a()) != null && a3.getItemId() == i) {
                        a(a3);
                        break;
                    }
                    i2++;
                }
                this.e = false;
                g();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f2192c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.f2192c.get(i3);
                    if (!(!(dVar2 instanceof f) || (a2 = ((f) dVar2).a()) == null || (actionView = a2.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a2.getItemId())) == null)) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void a(boolean z) {
            this.e = z;
        }
    }

    /* compiled from: NavigationMenuPresenter */
    private static class c implements d {
        c() {
        }
    }

    /* compiled from: NavigationMenuPresenter */
    private interface d {
    }

    /* compiled from: NavigationMenuPresenter */
    private static class e implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f2193a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2194b;

        public e(int i, int i2) {
            this.f2193a = i;
            this.f2194b = i2;
        }

        public int a() {
            return this.f2194b;
        }

        public int b() {
            return this.f2193a;
        }
    }

    /* compiled from: NavigationMenuPresenter */
    private static class f implements d {

        /* renamed from: a  reason: collision with root package name */
        private final p f2195a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2196b;

        f(p pVar) {
            this.f2195a = pVar;
        }

        public p a() {
            return this.f2195a;
        }
    }

    /* compiled from: NavigationMenuPresenter */
    private static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.f1071b.setOnClickListener(onClickListener);
        }
    }

    /* compiled from: NavigationMenuPresenter */
    private static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* compiled from: NavigationMenuPresenter */
    private static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* compiled from: NavigationMenuPresenter */
    private static abstract class j extends RecyclerView.v {
        public j(View view) {
            super(view);
        }
    }

    public void a(Context context, l lVar) {
        this.g = LayoutInflater.from(context);
        this.d = lVar;
        this.p = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    public boolean a(D d2) {
        return false;
    }

    public boolean a(l lVar, p pVar) {
        return false;
    }

    public void b(int i2) {
        this.e = i2;
    }

    public boolean b(l lVar, p pVar) {
        return false;
    }

    public Drawable c() {
        return this.l;
    }

    public int d() {
        return this.m;
    }

    public void e(int i2) {
        this.h = i2;
        this.i = true;
        updateMenuView(false);
    }

    public ColorStateList f() {
        return this.j;
    }

    public boolean flagActionItems() {
        return false;
    }

    public ColorStateList g() {
        return this.k;
    }

    public int getId() {
        return this.e;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f2189a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f2190b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.f2189a != null) {
            SparseArray sparseArray = new SparseArray();
            this.f2189a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        b bVar = this.f;
        if (bVar != null) {
            bundle.putBundle("android:menu:adapter", bVar.d());
        }
        if (this.f2190b != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.f2190b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public void updateMenuView(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.f();
        }
    }

    public int b() {
        return this.f2190b.getChildCount();
    }

    public void c(int i2) {
        this.m = i2;
        updateMenuView(false);
    }

    public void d(int i2) {
        this.n = i2;
        updateMenuView(false);
    }

    public void b(ColorStateList colorStateList) {
        this.j = colorStateList;
        updateMenuView(false);
    }

    public int e() {
        return this.n;
    }

    public w a(ViewGroup viewGroup) {
        if (this.f2189a == null) {
            this.f2189a = (NavigationMenuView) this.g.inflate(R$layout.design_navigation_menu, viewGroup, false);
            if (this.f == null) {
                this.f = new b();
            }
            this.f2190b = (LinearLayout) this.g.inflate(R$layout.design_navigation_item_header, this.f2189a, false);
            this.f2189a.setAdapter(this.f);
        }
        return this.f2189a;
    }

    public void a(l lVar, boolean z) {
        v.a aVar = this.f2191c;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    public void a(p pVar) {
        this.f.a(pVar);
    }

    public p a() {
        return this.f.e();
    }

    public View a(int i2) {
        View inflate = this.g.inflate(i2, this.f2190b, false);
        a(inflate);
        return inflate;
    }

    public void a(View view) {
        this.f2190b.addView(view);
        NavigationMenuView navigationMenuView = this.f2189a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void a(ColorStateList colorStateList) {
        this.k = colorStateList;
        updateMenuView(false);
    }

    public void a(Drawable drawable) {
        this.l = drawable;
        updateMenuView(false);
    }

    public void a(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void a(androidx.core.h.D d2) {
        int e2 = d2.e();
        if (this.o != e2) {
            this.o = e2;
            if (this.f2190b.getChildCount() == 0) {
                NavigationMenuView navigationMenuView = this.f2189a;
                navigationMenuView.setPadding(0, this.o, 0, navigationMenuView.getPaddingBottom());
            }
        }
        t.a_shaKey_method2((View) this.f2190b, d2);
    }
}
