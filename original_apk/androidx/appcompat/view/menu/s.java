package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* compiled from: MenuPopup */
abstract class s implements z, v, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Rect f256a;

    s() {
    }

    public abstract void a(int i);

    public void a(Context context, l lVar) {
    }

    public void a(Rect rect) {
        this.f256a = rect;
    }

    public abstract void a(View view);

    public abstract void a(l lVar);

    public abstract void a(boolean z);

    /* access modifiers changed from: protected */
    public boolean a() {
        return true;
    }

    public boolean a(l lVar, p pVar) {
        return false;
    }

    public Rect b() {
        return this.f256a;
    }

    public abstract void b(int i);

    public abstract void b(boolean z);

    public boolean b(l lVar, p pVar) {
        return false;
    }

    public abstract void c(int i);

    public int getId() {
        return 0;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).f240a.a((MenuItem) listAdapter.getItem(i), (v) this, a() ? 0 : 4);
    }

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener);

    protected static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    protected static boolean b(l lVar) {
        int size = lVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = lVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static k a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (k) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (k) listAdapter;
    }
}
