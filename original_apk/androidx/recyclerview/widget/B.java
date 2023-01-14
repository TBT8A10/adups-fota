package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.C0105b;
import androidx.recyclerview.widget.RecyclerView;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

/* compiled from: RecyclerView */
class B implements C0105b.C0022b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f1002a;

    B(RecyclerView recyclerView) {
        this.f1002a = recyclerView;
    }

    public int a() {
        return this.f1002a.getChildCount();
    }

    public void b() {
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            View a3 = a(i);
            this.f1002a.b(a3);
            a3.clearAnimation();
        }
        this.f1002a.removeAllViews();
    }

    public int c(View view) {
        return this.f1002a.indexOfChild(view);
    }

    public void d(View view) {
        RecyclerView.v g = RecyclerView.g(view);
        if (g != null) {
            g.b(this.f1002a);
        }
    }

    public void a(View view, int i) {
        this.f1002a.addView(view, i);
        this.f1002a.a(view);
    }

    public void c(int i) {
        View childAt = this.f1002a.getChildAt(i);
        if (childAt != null) {
            this.f1002a.b(childAt);
            childAt.clearAnimation();
        }
        this.f1002a.removeViewAt(i);
    }

    public View a(int i) {
        return this.f1002a.getChildAt(i);
    }

    public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        RecyclerView.v g = RecyclerView.g(view);
        if (g != null) {
            if (g.r() || g.x()) {
                g.d();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + g + this.f1002a.i());
            }
        }
        this.f1002a.attachViewToParent(view, i, layoutParams);
    }

    public RecyclerView.v b(View view) {
        return RecyclerView.g(view);
    }

    public void b(int i) {
        RecyclerView.v g;
        View a2 = a(i);
        if (!(a2 == null || (g = RecyclerView.g(a2)) == null)) {
            if (!g.r() || g.x()) {
                g.a((int) CpioConstants.C_IRUSR);
            } else {
                throw new IllegalArgumentException("called detach on an already detached child " + g + this.f1002a.i());
            }
        }
        this.f1002a.detachViewFromParent(i);
    }

    public void a(View view) {
        RecyclerView.v g = RecyclerView.g(view);
        if (g != null) {
            g.a(this.f1002a);
        }
    }
}
