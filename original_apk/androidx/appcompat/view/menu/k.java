package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.w;
import java.util.ArrayList;

/* compiled from: MenuAdapter */
public class k extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    l f240a;

    /* renamed from: b  reason: collision with root package name */
    private int f241b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f242c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public k(l lVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.f240a = lVar;
        this.f = i;
        a();
    }

    public void a(boolean z) {
        this.f242c = z;
    }

    public l b() {
        return this.f240a;
    }

    public int getCount() {
        ArrayList<p> j = this.d ? this.f240a.j() : this.f240a.n();
        if (this.f241b < 0) {
            return j.size();
        }
        return j.size() - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f240a.o() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        w.a aVar = (w.a) view;
        if (this.f242c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        p f2 = this.f240a.f();
        if (f2 != null) {
            ArrayList<p> j = this.f240a.j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (j.get(i) == f2) {
                    this.f241b = i;
                    return;
                }
            }
        }
        this.f241b = -1;
    }

    public p getItem(int i) {
        ArrayList<p> j = this.d ? this.f240a.j() : this.f240a.n();
        int i2 = this.f241b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return j.get(i);
    }
}
