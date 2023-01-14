package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.view.menu.w;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter */
public class j implements v, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    Context f235a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f236b;

    /* renamed from: c  reason: collision with root package name */
    l f237c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    private v.a h;
    a i;
    private int j;

    /* compiled from: ListMenuPresenter */
    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private int f238a = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            p f = j.this.f237c.f();
            if (f != null) {
                ArrayList<p> j = j.this.f237c.j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    if (j.get(i) == f) {
                        this.f238a = i;
                        return;
                    }
                }
            }
            this.f238a = -1;
        }

        public int getCount() {
            int size = j.this.f237c.j().size() - j.this.e;
            return this.f238a < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                j jVar = j.this;
                view = jVar.f236b.inflate(jVar.g, viewGroup, false);
            }
            ((w.a) view).a(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        public p getItem(int i) {
            ArrayList<p> j = j.this.f237c.j();
            int i2 = i + j.this.e;
            int i3 = this.f238a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return j.get(i2);
        }
    }

    public j(Context context, int i2) {
        this(i2, 0);
        this.f235a = context;
        this.f236b = LayoutInflater.from(this.f235a);
    }

    public void a(Context context, l lVar) {
        int i2 = this.f;
        if (i2 != 0) {
            this.f235a = new ContextThemeWrapper(context, i2);
            this.f236b = LayoutInflater.from(this.f235a);
        } else if (this.f235a != null) {
            this.f235a = context;
            if (this.f236b == null) {
                this.f236b = LayoutInflater.from(this.f235a);
            }
        }
        this.f237c = lVar;
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public boolean a(l lVar, p pVar) {
        return false;
    }

    public void b(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public boolean b(l lVar, p pVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.j;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f237c.a((MenuItem) this.i.getItem(i2), (v) this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        a((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        b(bundle);
        return bundle;
    }

    public void updateMenuView(boolean z) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public j(int i2, int i3) {
        this.g = i2;
        this.f = i3;
    }

    public w a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.f236b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.i == null) {
                this.i = new a();
            }
            this.d.setAdapter(this.i);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    public void a(v.a aVar) {
        this.h = aVar;
    }

    public boolean a(D d2) {
        if (!d2.hasVisibleItems()) {
            return false;
        }
        new m(d2).a((IBinder) null);
        v.a aVar = this.h;
        if (aVar == null) {
            return true;
        }
        aVar.a(d2);
        return true;
    }

    public void a(l lVar, boolean z) {
        v.a aVar = this.h;
        if (aVar != null) {
            aVar.a(lVar, z);
        }
    }

    public void a(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.d.restoreHierarchyState(sparseParcelableArray);
        }
    }
}
