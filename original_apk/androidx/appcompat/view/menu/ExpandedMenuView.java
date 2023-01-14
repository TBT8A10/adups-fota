package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ia;

public final class ExpandedMenuView extends ListView implements l.b, w, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f209a = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    private l f210b;

    /* renamed from: c  reason: collision with root package name */
    private int f211c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public void a(l lVar) {
        this.f210b = lVar;
    }

    public int getWindowAnimations() {
        return this.f211c;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((p) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ia a2 = ia.a(context, attributeSet, f209a, i, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.b(0));
        }
        if (a2.g(1)) {
            setDivider(a2.b(1));
        }
        a2.a();
    }

    public boolean a(p pVar) {
        return this.f210b.a_shaKey_method2((MenuItem) pVar, 0);
    }
}
